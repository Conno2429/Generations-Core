package generations.gg.generations.core.generationscore.common.event

import com.cobblemon.mod.common.Cobblemon
import com.cobblemon.mod.common.api.Priority
import com.cobblemon.mod.common.api.battles.model.actor.ActorType
import com.cobblemon.mod.common.api.events.CobblemonEvents
import com.cobblemon.mod.common.api.events.drops.LootDroppedEvent
import com.cobblemon.mod.common.api.text.text
import com.cobblemon.mod.common.api.types.tera.TeraTypes
import com.cobblemon.mod.common.battles.actor.PlayerBattleActor
import com.cobblemon.mod.common.client.gui.interact.wheel.InteractWheelOption
import com.cobblemon.mod.common.client.gui.interact.wheel.Orientation
import com.cobblemon.mod.common.util.asTranslated
import com.cobblemon.mod.common.util.cobblemonResource
import com.cobblemon.mod.common.util.giveOrDropItemStack
import generations.gg.generations.core.generationscore.common.GenerationsCore
import generations.gg.generations.core.generationscore.common.api.player.Caught
import generations.gg.generations.core.generationscore.common.battle.BattleConditionsProcessor
import generations.gg.generations.core.generationscore.common.battle.BattleConditionsProcessor.getTypeName
import generations.gg.generations.core.generationscore.common.battle.BattleConditionsProcessor.sendToPlayersAndSpectators
import generations.gg.generations.core.generationscore.common.battle.BattleSideData
import generations.gg.generations.core.generationscore.common.battle.ConditionsData
import generations.gg.generations.core.generationscore.common.battle.GenerationsInstructionProcessor
import generations.gg.generations.core.generationscore.common.client.render.rarecandy.instanceOrNull
import generations.gg.generations.core.generationscore.common.config.LegendKeys
import generations.gg.generations.core.generationscore.common.config.SpeciesKey
import generations.gg.generations.core.generationscore.common.network.packets.HeadPatPacket
import generations.gg.generations.core.generationscore.common.tags.GenerationsItemTags
import generations.gg.generations.core.generationscore.common.util.DataKeys
import generations.gg.generations.core.generationscore.common.util.fixIVS
import generations.gg.generations.core.generationscore.common.world.item.FormChanging
import generations.gg.generations.core.generationscore.common.world.item.GenerationsItems
import generations.gg.generations.core.generationscore.common.world.item.PostBattleUpdatingItem
import net.minecraft.client.Minecraft
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.ItemStack
import org.joml.Vector3f

class GenerationsCobblemonEvents {

    companion object {
        val gimmackItems: Set<ResourceLocation> = setOf(
            cobblemonResource("key_stone"),
            cobblemonResource("dynamax_band"),
            cobblemonResource("tera_orb"),
            cobblemonResource("z_ring")
        )


        fun init() {
//            FORME_CHANGE.subscribe(Priority.NORMAL, {(a, b, c) -> GenerationsInstructionProcessor.processDetailsChange(a, b, c) })

            CobblemonEvents.TERASTALLIZATION.subscribe(Priority.NORMAL, GenerationsInstructionProcessor::processTerastallization)
            CobblemonEvents.BATTLE_STARTED_PRE.subscribe(Priority.NORMAL, GenerationsInstructionProcessor::preBattleChanges)

//            FORME_CHANGE.subscribe(Priority.NORMAL, {(a, b, c) -> GenerationsInstructionProcessor.processDetailsChange(a, b, c) })
//            CobblemonEvents.MEGA_EVOLUTION.subscribe(Priority.NORMAL, GenerationsInstructionProcessor::processMegaEvolution)
//            CobblemonEvents.POKEMON_ENTITY_SPAWN.subscribe(Priority.HIGHEST) { it ->
//
//            }

            CobblemonEvents.BATTLE_VICTORY.subscribe(Priority.HIGH) { event ->
                val data = mutableListOf<PostBattleUpdatingItem.BattleData>()

                event.losers.forEach { actor1 ->
                    val isNpc = actor1.type == ActorType.NPC
                    actor1.pokemonList.stream()
                        .map { PostBattleUpdatingItem.BattleData(isNpc, it.effectedPokemon, "") }.forEach(data::add)
                }

                event.winners.stream()
                    .filter { battleActor -> battleActor is PlayerBattleActor }
                    .map { battleActor -> battleActor as PlayerBattleActor }
                    .forEach { actor ->
                        actor.entity?.inventory?.items?.asSequence()
                            ?.filter { a -> a.item is PostBattleUpdatingItem }
                            ?.forEach { a -> (a.item as PostBattleUpdatingItem).afterBattle(actor, a, data) }

                        actor.pokemonList.asSequence().map { it.originalPokemon }.forEach { originalPokemon ->
                            val it: ItemStack = originalPokemon.heldItem()
                            if (!it.isEmpty)
                                if (it.item is PostBattleUpdatingItem) {
                                    (it.item as PostBattleUpdatingItem).afterBattle(
                                        actor,
                                        it,
                                        true,
                                        data
                                    )
                                    originalPokemon.swapHeldItem(it, false)
                                }
                        }
                    }
            }

            CobblemonEvents.POKEMON_CAPTURED.subscribe(Priority.HIGH) { event ->
                val speciesKey = SpeciesKey.Companion.fromPokemon(event.pokemon)
                Caught.get(event.player).accumulate(speciesKey)

                val pokemon = event.pokemon
                pokemon.fixIVS()

                if (pokemon.species.name == "Terapagos" || pokemon.teraType != TeraTypes.STELLAR) {
                    pokemon.teraType = TeraTypes.STELLAR
                }

                //Loot

                var table = event.pokemon.form.drops
                var drops = table.getDrops().toMutableList()
                var player = event.player

                CobblemonEvents.LOOT_DROPPED.postThen(
                    event = LootDroppedEvent(table, player, null, drops),
                    ifSucceeded = { it.drops.forEach { it.drop(null, player.serverLevel(), player.position(), player) } }
                )
            }

            CobblemonEvents.BATTLE_STARTED_PRE.subscribe(Priority.HIGHEST)  {
                it.battle.actors.filterIsInstance<PlayerBattleActor>()
                    .mapNotNull { it.entity }.forEach {
                    val keyItems = Cobblemon.playerDataManager.getGenericData(it).keyItems

                    keyItems.removeAll(gimmackItems)

                    if(it.inventory.contains(GenerationsItemTags.KEY_STONES)) keyItems.add(cobblemonResource("key_stone"))
                    if(it.inventory.contains(GenerationsItemTags.DYNAMAX_BANDS)) keyItems.add(cobblemonResource("dynamax_band"))
                    if(it.inventory.contains(GenerationsItemTags.TERA_ORBS)) keyItems.add(cobblemonResource("tera_orb"))
                    if(it.inventory.contains(GenerationsItemTags.Z_RINGS)) keyItems.add(cobblemonResource("z_ring"))
                }
            }

            CobblemonEvents.BATTLE_STARTED_POST.subscribe(Priority.NORMAL) {
                val conditionsData = ConditionsData()
                for (actor in it.battle.actors) {
                    if (actor in it.battle.side1.actors) {
                        conditionsData.sideList.add(BattleSideData("1", actor.getTypeName(), "legend"))
                        println("Actor Side 1: ${actor.getTypeName()}")
                    }
                    if (actor in it.battle.side2.actors) {
                        conditionsData.sideList.add(BattleSideData("2", actor.getTypeName(), "legend"))
                        println("Actor Side 2: ${actor.getTypeName()}")
                    }
                }

                BattleConditionsProcessor.conditionsDataMap[it.battle.battleId] = conditionsData
                it.battle.sendToPlayersAndSpectators()
            }

            CobblemonEvents.FRIENDSHIP_UPDATED.subscribe {
                var player = it.pokemon.getOwnerPlayer() ?: return@subscribe

                if(it.newFriendship >= Cobblemon.config.maxPokemonFriendship && it.pokemon.species.resourceIdentifier == LegendKeys.MANAPHY.species) {

                    if(it.pokemon.persistentData.getBoolean(DataKeys.GAVE_EGG)) return@subscribe

                    player.sendSystemMessage("Due to ${it.pokemon.getDisplayName().string} happiness reaching max, it gave you an egg.".text())

                    player.giveOrDropItemStack(GenerationsItems.PHIONE_EGG.value().defaultInstance, true)
                    it.pokemon.persistentData.putBoolean(DataKeys.GAVE_EGG, true)
                }
            }

            CobblemonEvents.POKEMON_INTERACTION_GUI_CREATION.subscribe {

                it.addOption(
                    Orientation.BOTTOM_LEFT, InteractWheelOption(
                        iconResource = GenerationsCore.id("textures/ui/interact/head_pat.png"),
                        tooltipText = "generations_core.ui.interact.head_pat",
                        colour = { Vector3f(1F, 0F, 0F) },
                        onPress = {
                            HeadPatPacket(it.pokemonID).sendToServer()
                            Minecraft.getInstance().screen = null
                        })
                )

            }

            CobblemonEvents.HELD_ITEM_POST.subscribe {

                it.returned.item.instanceOrNull<FormChanging>()?.let { formChanging ->
                    if(formChanging.process(it.pokemon, true)) {
                        it.pokemon.getOwnerPlayer()?.sendSystemMessage("generations_core.ability.formchange".asTranslated(it.pokemon.getDisplayName().string))
                    }
                }

                it.received.item.instanceOrNull<FormChanging>()?.let { formChanging ->
                    if(formChanging.process(it.pokemon, false)) {
                        it.pokemon.getOwnerPlayer()?.sendSystemMessage("generations_core.ability.formchange".asTranslated(it.pokemon.getDisplayName().string))
                    }
                }

                HeldItemFormeChange.ogerMaskChange(it)
                HeldItemFormeChange.removeBehemoth(it)
            }



//            CobblemonEvents.POKEMON_ENTITY_SPAWN.subscribe { it.entity.taskBuilder().infiniteIterations().identifier("castform") }

            CobblemonEvents.LOOT_DROPPED.subscribe(Priority.HIGHEST) {

            }
        }
    }
}