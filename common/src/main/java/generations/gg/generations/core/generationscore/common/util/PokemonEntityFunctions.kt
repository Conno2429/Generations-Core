package generations.gg.generations.core.generationscore.common.util

import com.cobblemon.mod.common.entity.pokemon.PokemonEntity
import generations.gg.generations.core.generationscore.common.world.item.MEGA_STONES
import net.minecraft.core.registries.BuiltInRegistries

fun PokemonEntity.canChangeForm(): Pair<Boolean, String> {
    val pokemon = this.pokemon
    var canFormChange = false
    var aspect = ""
    if (MEGA_STONES.contains(pokemon.heldItem().item.builtInRegistryHolder())) {
        val itemStack = pokemon.heldItem()
        val item = itemStack.item
        val key = BuiltInRegistries.ITEM.getKey(item)
        val itemName = key.path
        val pokeName = pokemon.species.name.lowercase()

        println(itemName)
        println(pokeName)
        if (itemName.take(5) == pokeName.take(5)) {
            canFormChange = true
            if (pokeName == "charizard" || pokeName == "mewtwo") {
                if (itemName.endsWith("x")) {
                    aspect = "mega_x"
                } else {
                    aspect = "mega_y"
                }
            } else {
                aspect = "mega"
            }
        }
    }
    return Pair(canFormChange, aspect)
}