package generations.gg.generations.core.generationscore.common.world.item;

import com.cobblemon.mod.common.api.types.ElementalType
import com.cobblemon.mod.common.api.types.ElementalTypes
import com.cobblemon.mod.common.item.PokeBallItem
import com.cobblemon.mod.common.pokemon.helditem.CobblemonHeldItemManager
import dev.architectury.core.item.ArchitecturyRecordItem
import dev.architectury.registry.registries.DeferredRegister
import dev.architectury.registry.registries.RegistrySupplier
import generations.gg.generations.core.generationscore.common.GenerationsCore
import generations.gg.generations.core.generationscore.common.config.LegendKeys
import generations.gg.generations.core.generationscore.common.world.GenerationsPokeBalls
import generations.gg.generations.core.generationscore.common.world.entity.GenerationsBoatEntity
import generations.gg.generations.core.generationscore.common.world.entity.TieredFishingHookEntity
import generations.gg.generations.core.generationscore.common.world.item.curry.CurryIngredient
import generations.gg.generations.core.generationscore.common.world.item.curry.CurryType
import generations.gg.generations.core.generationscore.common.world.item.curry.ItemCurry
import generations.gg.generations.core.generationscore.common.world.item.legends.*
import generations.gg.generations.core.generationscore.common.world.level.block.GenerationsWood
import generations.gg.generations.core.generationscore.common.world.sound.GenerationsSounds
import net.minecraft.core.registries.Registries
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.item.HangingSignItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.SignItem
import java.util.function.Function

/**
 * Generations Items
 * @see net.minecraft.world.item.Item
 * @author Joseph T. McQuigg
 * @author WaterPicker
 */
@SuppressWarnings("unused")
object GenerationsItems {

    /** Generations Items Deferred Register */
    @JvmField val ITEMS = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.ITEM)

    /** Generations Ribbons Deferred Register */
    @JvmField val RIBBONS = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.ITEM)

    /** Generations Badges Deferred Register */
    @JvmField val BADGES = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.ITEM)

    /** Generations Unimplemented Deferred Register */
    @JvmField val UNIMPLEMENTED = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.ITEM)

    /** Generations Cusine Deferred Register */
    @JvmField val CUISINE = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.ITEM)

    /** Generations Natural Deferred Register */
    @JvmField val NATURAL = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.ITEM)

    /** Generations Restoration Deferred Register */
    @JvmField val RESTORATION = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.ITEM)

    /** Generations Player Items Deferred Register */
    @JvmField val PLAYER_ITEMS = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.ITEM)

    /** Generations HeldItems Deferred Register */
    @JvmField val HELD_ITEMS = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.ITEM)

    /** Generations Pokemail Deferred Register */
    @JvmField val POKEMAIL = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.ITEM)

    /** Generations Legendary Items Deferred Register */
    @JvmField val LEGENDARY_ITEMS = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.ITEM)

    /** Generations Utility Deferred Register */
    @JvmField val UTILITY = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.ITEM)

    /** Generations Valuables Deferred Register */
    @JvmField val VALUABLES = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.ITEM)

    /** Generations Form Items Deferred Register */
    @JvmField val FORM_ITEMS = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.ITEM)

    /** Generations Building Blocks Deferred Register */
    @JvmField val BUILDING_BLOCKS = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.ITEM)


    /**
     * Restoration Items
     */
    @JvmField val PURPLE_JUICE = register("purple_juice", ::Item, RESTORATION)
    @JvmField val RED_JUICE = register("red_juice", ::Item, RESTORATION)
    @JvmField val YELLOW_JUICE = register("yellow_juice", ::Item, RESTORATION)
    @JvmField val BLUE_JUICE = register("blue_juice", ::Item, RESTORATION)
    @JvmField val GREEN_JUICE = register("green_juice", ::Item, RESTORATION)
    @JvmField val PINK_JUICE = register("pink_juice", ::Item, RESTORATION)
    @JvmField val COLORFUL_SHAKE = register("colorful_shake", ::Item, RESTORATION)
    @JvmField val PERILOUS_SOUP = register("perilous_soup", ::Item, RESTORATION)
    @JvmField val RARE_SODA = register("rare_soda", ::Item, RESTORATION)
    @JvmField val ULTRA_RARE_SODA = register("ultra_rare_soda", ::Item, RESTORATION)
    @JvmField val FRESH_WATER = register("fresh_water", ::Item, RESTORATION)
    @JvmField val SODA_POP = register("soda_pop", ::Item, RESTORATION)
    @JvmField val LEMONADE = register("lemonade", ::Item, RESTORATION)
    @JvmField val MOOMOO_MILK = register("moomoo_milk", ::Item, RESTORATION)
    @JvmField val LUMIOSE_GALETTE = register("lumiose_galette", ::Item, RESTORATION)
    @JvmField val SHALOUR_SABLE = register("shalour_sable", ::Item, RESTORATION)
    @JvmField val CASTELIACONE = register("casteliacone", ::Item, RESTORATION)
    @JvmField val OLD_GATEAU = register("old_gateau", ::Item, RESTORATION)
    @JvmField val BIG_MALASADA = register("big_malasada", ::Item, RESTORATION)
    @JvmField val LAVA_COOKIE = register("lava_cookie", ::Item, RESTORATION)
    @JvmField val RAGE_CANDY_BAR = register("rage_candy_bar", ::Item, RESTORATION)
    @JvmField val BLUE_FLUTE = register("blue_flute", ::Item, RESTORATION)
    @JvmField val RED_FLUTE = register("red_flute", ::Item, RESTORATION)
    @JvmField val YELLOW_FLUTE = register("yellow_flute", ::Item, RESTORATION)
    @JvmField val ENERGY_POWDER = register("energy_powder", ::Item, RESTORATION)
    @JvmField val SWEET_HEART = register("sweet_heart", ::Item, RESTORATION)
    @JvmField val BASIC_SWEET_POKE_PUFF = register("basic_sweet_poke_puff", ::Item, RESTORATION)
    @JvmField val BASIC_CITRUS_POKE_PUFF = register("basic_citrus_poke_puff", ::Item, RESTORATION)
    @JvmField val BASIC_MINT_POKE_PUFF = register("basic_mint_poke_puff", ::Item, RESTORATION)
    @JvmField val BASIC_MOCHA_POKE_PUFF = register("basic_mocha_poke_puff", ::Item, RESTORATION)
    @JvmField val BASIC_SPICE_POKE_PUFF = register("basic_spice_poke_puff", ::Item, RESTORATION)

    /**
     * Consumable Items
     */
    @JvmField val DYNAMAX_CANDY = register("dynamax_candy", ::Item, RESTORATION);
    @JvmField val MAX_HONEY = register("max_honey", ::Item, RESTORATION);
    @JvmField val MAX_MUSHROOMS = register("max_mushrooms", ::Item, RESTORATION);
    @JvmField val MAX_POWDER = register("max_powder", ::Item, RESTORATION);
    @JvmField val MAX_SOUP = register("max_soup", ::Item, RESTORATION);

    /**
     * TM ITEMS
     */
    @JvmField val CUSTOM_TM = registerTm("tm", ::CustomTechnicalMachineItem);


    @JvmField val TM_1 = registerTm("tm_1", { TechnicalMachineItem("takedown", it) }, PLAYER_ITEMS)
    @JvmField val TM_2 = registerTm("tm_2", { TechnicalMachineItem("charm", it) }, PLAYER_ITEMS)
    @JvmField val TM_3 = registerTm("tm_3", { TechnicalMachineItem("faketears", it) }, PLAYER_ITEMS)
    @JvmField val TM_4 = registerTm("tm_4", { TechnicalMachineItem("agility", it) }, PLAYER_ITEMS)
    @JvmField val TM_5 = registerTm("tm_5", { TechnicalMachineItem("mudslap", it) }, PLAYER_ITEMS)
    @JvmField val TM_6 = registerTm("tm_6", { TechnicalMachineItem("scaryface", it) }, PLAYER_ITEMS)
    @JvmField val TM_7 = registerTm("tm_7", { TechnicalMachineItem("protect", it) }, PLAYER_ITEMS)
    @JvmField val TM_8 = registerTm("tm_8", { TechnicalMachineItem("firefang", it) }, PLAYER_ITEMS)
    @JvmField val TM_9 = registerTm("tm_9", { TechnicalMachineItem("thunderfang", it) }, PLAYER_ITEMS)
    @JvmField val TM_10 = registerTm("tm_10", { TechnicalMachineItem("icefang", it) }, PLAYER_ITEMS)
    @JvmField val TM_11 = registerTm("tm_11", { TechnicalMachineItem("waterpulse", it) }, PLAYER_ITEMS)
    @JvmField val TM_12 = registerTm("tm_12", { TechnicalMachineItem("lowkick", it) }, PLAYER_ITEMS)
    @JvmField val TM_13 = registerTm("tm_13", { TechnicalMachineItem("acidspray", it) }, PLAYER_ITEMS)
    @JvmField val TM_14 = registerTm("tm_14", { TechnicalMachineItem("acrobatics", it) }, PLAYER_ITEMS)
    @JvmField val TM_15 = registerTm("tm_15", { TechnicalMachineItem("strugglebug", it) }, PLAYER_ITEMS)
    @JvmField val TM_16 = registerTm("tm_16", { TechnicalMachineItem("psybeam", it) }, PLAYER_ITEMS)
    @JvmField val TM_17 = registerTm("tm_17", { TechnicalMachineItem("confuseray", it) }, PLAYER_ITEMS)
    @JvmField val TM_18 = registerTm("tm_18", { TechnicalMachineItem("thief", it) }, PLAYER_ITEMS)
    @JvmField val TM_19 = registerTm("tm_19", { TechnicalMachineItem("disarmingvoice", it) }, PLAYER_ITEMS)
    @JvmField val TM_20 = registerTm("tm_20", { TechnicalMachineItem("trailblaze", it) }, PLAYER_ITEMS)
    @JvmField val TM_21 = registerTm("tm_21", { TechnicalMachineItem("pounce", it) }, PLAYER_ITEMS)
    @JvmField val TM_22 = registerTm("tm_22", { TechnicalMachineItem("chillingwater", it) }, PLAYER_ITEMS)
    @JvmField val TM_23 = registerTm("tm_23", { TechnicalMachineItem("chargebeam", it) }, PLAYER_ITEMS)
    @JvmField val TM_24 = registerTm("tm_24", { TechnicalMachineItem("firespin", it) }, PLAYER_ITEMS)
    @JvmField val TM_25 = registerTm("tm_25", { TechnicalMachineItem("facade", it) }, PLAYER_ITEMS)
    @JvmField val TM_26 = registerTm("tm_26", { TechnicalMachineItem("poisontail", it) }, PLAYER_ITEMS)
    @JvmField val TM_27 = registerTm("tm_27", { TechnicalMachineItem("aerialace", it) }, PLAYER_ITEMS)
    @JvmField val TM_28 = registerTm("tm_28", { TechnicalMachineItem("bulldoze", it) }, PLAYER_ITEMS)
    @JvmField val TM_29 = registerTm("tm_29", { TechnicalMachineItem("hex", it) }, PLAYER_ITEMS)
    @JvmField val TM_30 = registerTm("tm_30", { TechnicalMachineItem("snarl", it) }, PLAYER_ITEMS)
    @JvmField val TM_31 = registerTm("tm_31", { TechnicalMachineItem("metalclaw", it) }, PLAYER_ITEMS)
    @JvmField val TM_32 = registerTm("tm_32", { TechnicalMachineItem("switft", it) }, PLAYER_ITEMS)
    @JvmField val TM_33 = registerTm("tm_33", { TechnicalMachineItem("magicalleaf", it) }, PLAYER_ITEMS)
    @JvmField val TM_34 = registerTm("tm_34", { TechnicalMachineItem("icywind", it) }, PLAYER_ITEMS)
    @JvmField val TM_35 = registerTm("tm_35", { TechnicalMachineItem("mudshot", it) }, PLAYER_ITEMS)
    @JvmField val TM_36 = registerTm("tm_36", { TechnicalMachineItem("rocktomb", it) }, PLAYER_ITEMS)
    @JvmField val TM_37 = registerTm("tm_37", { TechnicalMachineItem("drainingkiss", it) }, PLAYER_ITEMS)
    @JvmField val TM_38 = registerTm("tm_38", { TechnicalMachineItem("flamecharge", it) }, PLAYER_ITEMS)
    @JvmField val TM_39 = registerTm("tm_39", { TechnicalMachineItem("lowsweep", it) }, PLAYER_ITEMS)
    @JvmField val TM_40 = registerTm("tm_40", { TechnicalMachineItem("aircutter", it) }, PLAYER_ITEMS)
    @JvmField val TM_41 = registerTm("tm_41", { TechnicalMachineItem("storedpower", it) }, PLAYER_ITEMS)
    @JvmField val TM_42 = registerTm("tm_42", { TechnicalMachineItem("nightshade", it) }, PLAYER_ITEMS)
    @JvmField val TM_43 = registerTm("tm_43", { TechnicalMachineItem("fling", it) }, PLAYER_ITEMS)
    @JvmField val TM_44 = registerTm("tm_44", { TechnicalMachineItem("dragontail", it) }, PLAYER_ITEMS)
    @JvmField val TM_45 = registerTm("tm_45", { TechnicalMachineItem("venoshock", it) }, PLAYER_ITEMS)
    @JvmField val TM_46 = registerTm("tm_46", { TechnicalMachineItem("avalanche", it) }, PLAYER_ITEMS)
    @JvmField val TM_47 = registerTm("tm_47", { TechnicalMachineItem("endure", it) }, PLAYER_ITEMS)
    @JvmField val TM_48 = registerTm("tm_48", { TechnicalMachineItem("voltswitch", it) }, PLAYER_ITEMS)
    @JvmField val TM_49 = registerTm("tm_49", { TechnicalMachineItem("sunnyday", it) }, PLAYER_ITEMS)
    @JvmField val TM_50 = registerTm("tm_50", { TechnicalMachineItem("raindance", it) }, PLAYER_ITEMS)
    @JvmField val TM_51 = registerTm("tm_51", { TechnicalMachineItem("sandstorm", it) }, PLAYER_ITEMS)
    @JvmField val TM_52 = registerTm("tm_52", { TechnicalMachineItem("snowscape", it) }, PLAYER_ITEMS)
    @JvmField val TM_53 = registerTm("tm_53", { TechnicalMachineItem("smartstrike", it) }, PLAYER_ITEMS)
    @JvmField val TM_54 = registerTm("tm_54", { TechnicalMachineItem("psyshock", it) }, PLAYER_ITEMS)
    @JvmField val TM_55 = registerTm("tm_55", { TechnicalMachineItem("dig", it) }, PLAYER_ITEMS)
    @JvmField val TM_56 = registerTm("tm_56", { TechnicalMachineItem("bulletseed", it) }, PLAYER_ITEMS)
    @JvmField val TM_57 = registerTm("tm_57", { TechnicalMachineItem("falseswipe", it) }, PLAYER_ITEMS)
    @JvmField val TM_58 = registerTm("tm_58", { TechnicalMachineItem("brickbreak", it) }, PLAYER_ITEMS)
    @JvmField val TM_59 = registerTm("tm_59", { TechnicalMachineItem("zenheadbutt", it) }, PLAYER_ITEMS)
    @JvmField val TM_60 = registerTm("tm_60", { TechnicalMachineItem("uturn", it) }, PLAYER_ITEMS)
    @JvmField val TM_61 = registerTm("tm_61", { TechnicalMachineItem("shadowclaw", it) }, PLAYER_ITEMS)
    @JvmField val TM_62 = registerTm("tm_62", { TechnicalMachineItem("foulplay", it) }, PLAYER_ITEMS)
    @JvmField val TM_63 = registerTm("tm_63", { TechnicalMachineItem("psychicfangs", it) }, PLAYER_ITEMS)
    @JvmField val TM_64 = registerTm("tm_64", { TechnicalMachineItem("bulkup", it) }, PLAYER_ITEMS)
    @JvmField val TM_65 = registerTm("tm_65", { TechnicalMachineItem("airslash", it) }, PLAYER_ITEMS)
    @JvmField val TM_66 = registerTm("tm_66", { TechnicalMachineItem("bodyslam", it) }, PLAYER_ITEMS)
    @JvmField val TM_67 = registerTm("tm_67", { TechnicalMachineItem("firepunch", it) }, PLAYER_ITEMS)
    @JvmField val TM_68 = registerTm("tm_68", { TechnicalMachineItem("thunderpunch", it) }, PLAYER_ITEMS)
    @JvmField val TM_69 = registerTm("tm_69", { TechnicalMachineItem("icepunch", it) }, PLAYER_ITEMS)
    @JvmField val TM_70 = registerTm("tm_70", { TechnicalMachineItem("sleeptalk", it) }, PLAYER_ITEMS)
    @JvmField val TM_71 = registerTm("tm_71", { TechnicalMachineItem("seedbomb", it) }, PLAYER_ITEMS)
    @JvmField val TM_72 = registerTm("tm_72", { TechnicalMachineItem("electroball", it) }, PLAYER_ITEMS)
    @JvmField val TM_73 = registerTm("tm_73", { TechnicalMachineItem("drainpunch", it) }, PLAYER_ITEMS)
    @JvmField val TM_74 = registerTm("tm_74", { TechnicalMachineItem("reflect", it) }, PLAYER_ITEMS)
    @JvmField val TM_75 = registerTm("tm_75", { TechnicalMachineItem("lightscreen", it) }, PLAYER_ITEMS)
    @JvmField val TM_76 = registerTm("tm_76", { TechnicalMachineItem("rockblast", it) }, PLAYER_ITEMS)
    @JvmField val TM_77 = registerTm("tm_77", { TechnicalMachineItem("waterfall", it) }, PLAYER_ITEMS)
    @JvmField val TM_78 = registerTm("tm_78", { TechnicalMachineItem("dragonclaw", it) }, PLAYER_ITEMS)
    @JvmField val TM_79 = registerTm("tm_79", { TechnicalMachineItem("dazzlinggleam", it) }, PLAYER_ITEMS)
    @JvmField val TM_80 = registerTm("tm_80", { TechnicalMachineItem("metronome", it) }, PLAYER_ITEMS)
    @JvmField val TM_81 = registerTm("tm_81", { TechnicalMachineItem("grassknot", it) }, PLAYER_ITEMS)
    @JvmField val TM_82 = registerTm("tm_82", { TechnicalMachineItem("thunderwave", it) }, PLAYER_ITEMS)
    @JvmField val TM_83 = registerTm("tm_83", { TechnicalMachineItem("poisonjab", it) }, PLAYER_ITEMS)
    @JvmField val TM_84 = registerTm("tm_84", { TechnicalMachineItem("stompingtantrum", it) }, PLAYER_ITEMS)
    @JvmField val TM_85 = registerTm("tm_85", { TechnicalMachineItem("rest", it) }, PLAYER_ITEMS)
    @JvmField val TM_86 = registerTm("tm_86", { TechnicalMachineItem("rockslide", it) }, PLAYER_ITEMS)
    @JvmField val TM_87 = registerTm("tm_87", { TechnicalMachineItem("taunt", it) }, PLAYER_ITEMS)
    @JvmField val TM_88 = registerTm("tm_88", { TechnicalMachineItem("swordsdance", it) }, PLAYER_ITEMS)
    @JvmField val TM_89 = registerTm("tm_89", { TechnicalMachineItem("bodypress", it) }, PLAYER_ITEMS)
    @JvmField val TM_90 = registerTm("tm_90", { TechnicalMachineItem("spikes", it) }, PLAYER_ITEMS)
    @JvmField val TM_91 = registerTm("tm_91", { TechnicalMachineItem("toxicspikes", it) }, PLAYER_ITEMS)
    @JvmField val TM_92 = registerTm("tm_92", { TechnicalMachineItem("imprison", it) }, PLAYER_ITEMS)
    @JvmField val TM_93 = registerTm("tm_93", { TechnicalMachineItem("flashcannon", it) }, PLAYER_ITEMS)
    @JvmField val TM_94 = registerTm("tm_94", { TechnicalMachineItem("darkpulse", it) }, PLAYER_ITEMS)
    @JvmField val TM_95 = registerTm("tm_95", { TechnicalMachineItem("leechlife", it) }, PLAYER_ITEMS)
    @JvmField val TM_96 = registerTm("tm_96", { TechnicalMachineItem("eerieimpulse", it) }, PLAYER_ITEMS)
    @JvmField val TM_97 = registerTm("tm_97", { TechnicalMachineItem("fly", it) }, PLAYER_ITEMS)
    @JvmField val TM_98 = registerTm("tm_98", { TechnicalMachineItem("skillswap", it) }, PLAYER_ITEMS)
    @JvmField val TM_99 = registerTm("tm_99", { TechnicalMachineItem("ironhead", it) }, PLAYER_ITEMS)
    @JvmField val TM_100 = registerTm("tm_100", { TechnicalMachineItem("dragondance", it) }, PLAYER_ITEMS)
    @JvmField val TM_101 = registerTm("tm_101", { TechnicalMachineItem("powergem", it) }, PLAYER_ITEMS)
    @JvmField val TM_102 = registerTm("tm_102", { TechnicalMachineItem("gunkshot", it) }, PLAYER_ITEMS)
    @JvmField val TM_103 = registerTm("tm_103", { TechnicalMachineItem("substitue", it) }, PLAYER_ITEMS)
    @JvmField val TM_104 = registerTm("tm_104", { TechnicalMachineItem("irondefense", it) }, PLAYER_ITEMS)
    @JvmField val TM_105 = registerTm("tm_105", { TechnicalMachineItem("xscissor", it) }, PLAYER_ITEMS)
    @JvmField val TM_106 = registerTm("tm_106", { TechnicalMachineItem("drillrun", it) }, PLAYER_ITEMS)
    @JvmField val TM_107 = registerTm("tm_107", { TechnicalMachineItem("willowisp", it) }, PLAYER_ITEMS)
    @JvmField val TM_108 = registerTm("tm_108", { TechnicalMachineItem("crunch", it) }, PLAYER_ITEMS)
    @JvmField val TM_109 = registerTm("tm_109", { TechnicalMachineItem("trick", it) }, PLAYER_ITEMS)
    @JvmField val TM_110 = registerTm("tm_110", { TechnicalMachineItem("liquidation", it) }, PLAYER_ITEMS)
    @JvmField val TM_111 = registerTm("tm_111", { TechnicalMachineItem("gigadrain", it) }, PLAYER_ITEMS)
    @JvmField val TM_112 = registerTm("tm_112", { TechnicalMachineItem("aurasphere", it) }, PLAYER_ITEMS)
    @JvmField val TM_113 = registerTm("tm_113", { TechnicalMachineItem("tailwind", it) }, PLAYER_ITEMS)
    @JvmField val TM_114 = registerTm("tm_114", { TechnicalMachineItem("shadowball", it) }, PLAYER_ITEMS)
    @JvmField val TM_115 = registerTm("tm_115", { TechnicalMachineItem("dragonpulse", it) }, PLAYER_ITEMS)
    @JvmField val TM_116 = registerTm("tm_116", { TechnicalMachineItem("stealthrock", it) }, PLAYER_ITEMS)
    @JvmField val TM_117 = registerTm("tm_117", { TechnicalMachineItem("hypervoice", it) }, PLAYER_ITEMS)
    @JvmField val TM_118 = registerTm("tm_118", { TechnicalMachineItem("heatwave", it) }, PLAYER_ITEMS)
    @JvmField val TM_119 = registerTm("tm_119", { TechnicalMachineItem("energyball", it) }, PLAYER_ITEMS)
    @JvmField val TM_120 = registerTm("tm_120", { TechnicalMachineItem("psychic", it) }, PLAYER_ITEMS)
    @JvmField val TM_121 = registerTm("tm_121", { TechnicalMachineItem("heavyslam", it) }, PLAYER_ITEMS)
    @JvmField val TM_122 = registerTm("tm_122", { TechnicalMachineItem("encore", it) }, PLAYER_ITEMS)
    @JvmField val TM_123 = registerTm("tm_123", { TechnicalMachineItem("surf", it) }, PLAYER_ITEMS)
    @JvmField val TM_124 = registerTm("tm_124", { TechnicalMachineItem("icespinner", it) }, PLAYER_ITEMS)
    @JvmField val TM_125 = registerTm("tm_125", { TechnicalMachineItem("flamethrower", it) }, PLAYER_ITEMS)
    @JvmField val TM_126 = registerTm("tm_126", { TechnicalMachineItem("thunderbolt", it) }, PLAYER_ITEMS)
    @JvmField val TM_127 = registerTm("tm_127", { TechnicalMachineItem("playrough", it) }, PLAYER_ITEMS)
    @JvmField val TM_128 = registerTm("tm_128", { TechnicalMachineItem("amnesia", it) }, PLAYER_ITEMS)
    @JvmField val TM_129 = registerTm("tm_129", { TechnicalMachineItem("calmmind", it) }, PLAYER_ITEMS)
    @JvmField val TM_130 = registerTm("tm_130", { TechnicalMachineItem("helpinghand", it) }, PLAYER_ITEMS)
    @JvmField val TM_131 = registerTm("tm_131", { TechnicalMachineItem("pollenpuff", it) }, PLAYER_ITEMS)
    @JvmField val TM_132 = registerTm("tm_132", { TechnicalMachineItem("batonpass", it) }, PLAYER_ITEMS)
    @JvmField val TM_133 = registerTm("tm_133", { TechnicalMachineItem("earthpower", it) }, PLAYER_ITEMS)
    @JvmField val TM_134 = registerTm("tm_134", { TechnicalMachineItem("reversal", it) }, PLAYER_ITEMS)
    @JvmField val TM_135 = registerTm("tm_135", { TechnicalMachineItem("icebeam", it) }, PLAYER_ITEMS)
    @JvmField val TM_136 = registerTm("tm_136", { TechnicalMachineItem("electricterrain", it) }, PLAYER_ITEMS)
    @JvmField val TM_137 = registerTm("tm_137", { TechnicalMachineItem("grassterrain", it) }, PLAYER_ITEMS)
    @JvmField val TM_138 = registerTm("tm_138", { TechnicalMachineItem("psychicterrain", it) }, PLAYER_ITEMS)
    @JvmField val TM_139 = registerTm("tm_139", { TechnicalMachineItem("mistyterrain", it) }, PLAYER_ITEMS)
    @JvmField val TM_140 = registerTm("tm_140", { TechnicalMachineItem("nastyplot", it) }, PLAYER_ITEMS)
    @JvmField val TM_141 = registerTm("tm_141", { TechnicalMachineItem("fireblast", it) }, PLAYER_ITEMS)
    @JvmField val TM_142 = registerTm("tm_142", { TechnicalMachineItem("hydropump", it) }, PLAYER_ITEMS)
    @JvmField val TM_143 = registerTm("tm_143", { TechnicalMachineItem("blizzard", it) }, PLAYER_ITEMS)
    @JvmField val TM_144 = registerTm("tm_144", { TechnicalMachineItem("firepledge", it) }, PLAYER_ITEMS)
    @JvmField val TM_145 = registerTm("tm_145", { TechnicalMachineItem("waterpledge", it) }, PLAYER_ITEMS)
    @JvmField val TM_146 = registerTm("tm_146", { TechnicalMachineItem("grasspledge", it) }, PLAYER_ITEMS)
    @JvmField val TM_147 = registerTm("tm_147", { TechnicalMachineItem("wildcharge", it) }, PLAYER_ITEMS)
    @JvmField val TM_148 = registerTm("tm_148", { TechnicalMachineItem("sludgebomb", it) }, PLAYER_ITEMS)
    @JvmField val TM_149 = registerTm("tm_149", { TechnicalMachineItem("earthquake", it) }, PLAYER_ITEMS)
    @JvmField val TM_150 = registerTm("tm_150", { TechnicalMachineItem("stoneedge", it) }, PLAYER_ITEMS)
    @JvmField val TM_151 = registerTm("tm_151", { TechnicalMachineItem("phantomforce", it) }, PLAYER_ITEMS)
    @JvmField val TM_152 = registerTm("tm_152", { TechnicalMachineItem("gigaimpact", it) }, PLAYER_ITEMS)
    @JvmField val TM_153 = registerTm("tm_153", { TechnicalMachineItem("blastburn", it) }, PLAYER_ITEMS)
    @JvmField val TM_154 = registerTm("tm_154", { TechnicalMachineItem("hydrocannon", it) }, PLAYER_ITEMS)
    @JvmField val TM_155 = registerTm("tm_155", { TechnicalMachineItem("frenzyplant", it) }, PLAYER_ITEMS)
    @JvmField val TM_156 = registerTm("tm_156", { TechnicalMachineItem("outrage", it) }, PLAYER_ITEMS)
    @JvmField val TM_157 = registerTm("tm_157", { TechnicalMachineItem("overheat", it) }, PLAYER_ITEMS)
    @JvmField val TM_158 = registerTm("tm_158", { TechnicalMachineItem("focusblast", it) }, PLAYER_ITEMS)
    @JvmField val TM_159 = registerTm("tm_159", { TechnicalMachineItem("leafstorm", it) }, PLAYER_ITEMS)
    @JvmField val TM_160 = registerTm("tm_160", { TechnicalMachineItem("hurricane", it) }, PLAYER_ITEMS)
    @JvmField val TM_161 = registerTm("tm_161", { TechnicalMachineItem("trickroom", it) }, PLAYER_ITEMS)
    @JvmField val TM_162 = registerTm("tm_162", { TechnicalMachineItem("bugbuzz", it) }, PLAYER_ITEMS)
    @JvmField val TM_163 = registerTm("tm_163", { TechnicalMachineItem("hyperbeam", it) }, PLAYER_ITEMS)
    @JvmField val TM_164 = registerTm("tm_164", { TechnicalMachineItem("bravebird", it) }, PLAYER_ITEMS)
    @JvmField val TM_165 = registerTm("tm_165", { TechnicalMachineItem("flareblitz", it) }, PLAYER_ITEMS)
    @JvmField val TM_166 = registerTm("tm_166", { TechnicalMachineItem("thunder", it) }, PLAYER_ITEMS)
    @JvmField val TM_167 = registerTm("tm_167", { TechnicalMachineItem("closecombat", it) }, PLAYER_ITEMS)
    @JvmField val TM_168 = registerTm("tm_168", { TechnicalMachineItem("solarbeam", it) }, PLAYER_ITEMS)
    @JvmField val TM_169 = registerTm("tm_169", { TechnicalMachineItem("dracometeor", it) }, PLAYER_ITEMS)
    @JvmField val TM_170 = registerTm("tm_170", { TechnicalMachineItem("steelbeam", it) }, PLAYER_ITEMS)
    @JvmField val TM_171 = registerTm("tm_171", { TechnicalMachineItem("terablast", it) }, PLAYER_ITEMS)
    @JvmField val TM_172 = registerTm("tm_172", { TechnicalMachineItem("roar", it) }, PLAYER_ITEMS)
    @JvmField val TM_173 = registerTm("tm_173", { TechnicalMachineItem("charge", it) }, PLAYER_ITEMS)
    @JvmField val TM_174 = registerTm("tm_174", { TechnicalMachineItem("haze", it) }, PLAYER_ITEMS)
    @JvmField val TM_175 = registerTm("tm_175", { TechnicalMachineItem("toxic", it) }, PLAYER_ITEMS)
    @JvmField val TM_176 = registerTm("tm_176", { TechnicalMachineItem("sandtomb", it) }, PLAYER_ITEMS)
    @JvmField val TM_177 = registerTm("tm_177", { TechnicalMachineItem("spite", it) }, PLAYER_ITEMS)
    @JvmField val TM_178 = registerTm("tm_178", { TechnicalMachineItem("gravity", it) }, PLAYER_ITEMS)
    @JvmField val TM_179 = registerTm("tm_179", { TechnicalMachineItem("smackdown", it) }, PLAYER_ITEMS)
    @JvmField val TM_180 = registerTm("tm_180", { TechnicalMachineItem("gyroball", it) }, PLAYER_ITEMS)
    @JvmField val TM_181 = registerTm("tm_181", { TechnicalMachineItem("knockoff", it) }, PLAYER_ITEMS)
    @JvmField val TM_182 = registerTm("tm_182", { TechnicalMachineItem("bugbite", it) }, PLAYER_ITEMS)
    @JvmField val TM_183 = registerTm("tm_183", { TechnicalMachineItem("superfang", it) }, PLAYER_ITEMS)
    @JvmField val TM_184 = registerTm("tm_184", { TechnicalMachineItem("vacuumwave", it) }, PLAYER_ITEMS)
    @JvmField val TM_185 = registerTm("tm_185", { TechnicalMachineItem("lunge", it) }, PLAYER_ITEMS)
    @JvmField val TM_186 = registerTm("tm_186", { TechnicalMachineItem("highhorsepower", it) }, PLAYER_ITEMS)
    @JvmField val TM_187 = registerTm("tm_187", { TechnicalMachineItem("iciclespear", it) }, PLAYER_ITEMS)
    @JvmField val TM_188 = registerTm("tm_188", { TechnicalMachineItem("scald", it) }, PLAYER_ITEMS)
    @JvmField val TM_189 = registerTm("tm_189", { TechnicalMachineItem("heatcrash", it) }, PLAYER_ITEMS)
    @JvmField val TM_190 = registerTm("tm_190", { TechnicalMachineItem("solarblade", it) }, PLAYER_ITEMS)
    @JvmField val TM_191 = registerTm("tm_191", { TechnicalMachineItem("uproar", it) }, PLAYER_ITEMS)
    @JvmField val TM_192 = registerTm("tm_192", { TechnicalMachineItem("focuspunch", it) }, PLAYER_ITEMS)
    @JvmField val TM_193 = registerTm("tm_193", { TechnicalMachineItem("weatherball", it) }, PLAYER_ITEMS)
    @JvmField val TM_194 = registerTm("tm_194", { TechnicalMachineItem("grassyglide", it) }, PLAYER_ITEMS)
    @JvmField val TM_195 = registerTm("tm_195", { TechnicalMachineItem("burningjealousy", it) }, PLAYER_ITEMS)
    @JvmField val TM_196 = registerTm("tm_196", { TechnicalMachineItem("flipturn", it) }, PLAYER_ITEMS)
    @JvmField val TM_197 = registerTm("tm_197", { TechnicalMachineItem("dualwingbeat", it) }, PLAYER_ITEMS)
    @JvmField val TM_198 = registerTm("tm_198", { TechnicalMachineItem("poltergeist", it) }, PLAYER_ITEMS)
    @JvmField val TM_199 = registerTm("tm_199", { TechnicalMachineItem("lashout", it) }, PLAYER_ITEMS)
    @JvmField val TM_200 = registerTm("tm_200", { TechnicalMachineItem("scaleshot", it) }, PLAYER_ITEMS)
    @JvmField val TM_201 = registerTm("tm_201", { TechnicalMachineItem("mistyexplosion", it) }, PLAYER_ITEMS)
    @JvmField val TM_202 = registerTm("tm_202", { TechnicalMachineItem("painsplit", it) }, PLAYER_ITEMS)
    @JvmField val TM_203 = registerTm("tm_203", { TechnicalMachineItem("psychup", it) }, PLAYER_ITEMS)
    @JvmField val TM_204 = registerTm("tm_204", { TechnicalMachineItem("doubleedge", it) }, PLAYER_ITEMS)
    @JvmField val TM_205 = registerTm("tm_205", { TechnicalMachineItem("endeavor", it) }, PLAYER_ITEMS)
    @JvmField val TM_206 = registerTm("tm_206", { TechnicalMachineItem("petalblizzard", it) }, PLAYER_ITEMS)
    @JvmField val TM_207 = registerTm("tm_207", { TechnicalMachineItem("temperflare", it) }, PLAYER_ITEMS)
    @JvmField val TM_208 = registerTm("tm_208", { TechnicalMachineItem("whirlpool", it) }, PLAYER_ITEMS)
    @JvmField val TM_209 = registerTm("tm_209", { TechnicalMachineItem("muddywater", it) }, PLAYER_ITEMS)
    @JvmField val TM_210 = registerTm("tm_210", { TechnicalMachineItem("supercell", it) }, PLAYER_ITEMS)
    @JvmField val TM_211 = registerTm("tm_211", { TechnicalMachineItem("electroweb", it) }, PLAYER_ITEMS)
    @JvmField val TM_212 = registerTm("tm_212", { TechnicalMachineItem("tripleaxel", it) }, PLAYER_ITEMS)
    @JvmField val TM_213 = registerTm("tm_213", { TechnicalMachineItem("coaching", it) }, PLAYER_ITEMS)
    @JvmField val TM_214 = registerTm("tm_214", { TechnicalMachineItem("sludgewave", it) }, PLAYER_ITEMS)
    @JvmField val TM_215 = registerTm("tm_215", { TechnicalMachineItem("scorchingsands", it) }, PLAYER_ITEMS)
    @JvmField val TM_216 = registerTm("tm_216", { TechnicalMachineItem("featherdance", it) }, PLAYER_ITEMS)
    @JvmField val TM_217 = registerTm("tm_217", { TechnicalMachineItem("futuresight", it) }, PLAYER_ITEMS)
    @JvmField val TM_218 = registerTm("tm_218", { TechnicalMachineItem("expandingforce", it) }, PLAYER_ITEMS)
    @JvmField val TM_219 = registerTm("tm_219", { TechnicalMachineItem("skittersmack", it) }, PLAYER_ITEMS)
    @JvmField val TM_220 = registerTm("tm_220", { TechnicalMachineItem("meteorbeam", it) }, PLAYER_ITEMS)
    @JvmField val TM_221 = registerTm("tm_221", { TechnicalMachineItem("throatchop", it) }, PLAYER_ITEMS)
    @JvmField val TM_222 = registerTm("tm_222", { TechnicalMachineItem("breakingswipe", it) }, PLAYER_ITEMS)
    @JvmField val TM_223 = registerTm("tm_223", { TechnicalMachineItem("metalsound", it) }, PLAYER_ITEMS)
    @JvmField val TM_224 = registerTm("tm_224", { TechnicalMachineItem("curse", it) }, PLAYER_ITEMS)
    @JvmField val TM_225 = registerTm("tm_225", { TechnicalMachineItem("hardpress", it) }, PLAYER_ITEMS)
    @JvmField val TM_226 = registerTm("tm_226", { TechnicalMachineItem("dragoncheer", it) }, PLAYER_ITEMS)
    @JvmField val TM_227 = registerTm("tm_227", { TechnicalMachineItem("alluringvoice", it) }, PLAYER_ITEMS)
    @JvmField val TM_228 = registerTm("tm_228", { TechnicalMachineItem("psychicnoise", it) }, PLAYER_ITEMS)
    @JvmField val TM_229 = registerTm("tm_229", { TechnicalMachineItem("upperhand", it) }, PLAYER_ITEMS)



    /**
     * Badges
     */
    @JvmField val BALANCE_BADGE = createBadge("balance")
    @JvmField val BEACON_BADGE = createBadge("beacon")
    @JvmField val BOULDER_BADGE = createBadge("boulder")
    @JvmField val CASCADE_BADGE = createBadge("cascade")
    @JvmField val COAL_BADGE = createBadge("coal")
    @JvmField val COBBLE_BADGE = createBadge("cobble")
    @JvmField val DYNAMO_BADGE = createBadge("dynamo")
    @JvmField val EARTH_BADGE = createBadge("earth")
    @JvmField val FEATHER_BADGE = createBadge("feather")
    @JvmField val FEN_BADGE = createBadge("fen")
    @JvmField val FOG_BADGE = createBadge("fog")
    @JvmField val FOREST_BADGE = createBadge("forest")
    @JvmField val GLACIER_BADGE = createBadge("glacier")
    @JvmField val HEAT_BADGE = createBadge("heat")
    @JvmField val HIVE_BADGE = createBadge("hive")
    @JvmField val ICICLE_BADGE = createBadge("icicle")
    @JvmField val KNUCKLE_BADGE = createBadge("knuckle")
    @JvmField val MARSH_BADGE = createBadge("marsh")
    @JvmField val MIND_BADGE = createBadge("mind")
    @JvmField val MINE_BADGE = createBadge("mine")
    @JvmField val MINERAL_BADGE = createBadge("mineral")
    @JvmField val PLAIN_BADGE = createBadge("plain")
    @JvmField val RAINBOW_BADGE = createBadge("rainbow")
    @JvmField val RAIN_BADGE = createBadge("rain")
    @JvmField val RELIC_BADGE = createBadge("relic")
    @JvmField val RISING_BADGE = createBadge("rising")
    @JvmField val SOUL_BADGE = createBadge("soul")
    @JvmField val STONE_BADGE = createBadge("stone")
    @JvmField val STORM_BADGE = createBadge("storm")
    @JvmField val THUNDER_BADGE = createBadge("thunder")
    @JvmField val VOLCANO_BADGE = createBadge("volcano")
    @JvmField val ZEPHYR_BADGE = createBadge("zephyr")
    @JvmField val BASIC_BADGE = createBadge("basic")
    @JvmField val BOLT_BADGE = createBadge("bolt")
    @JvmField val FREEZE_BADGE = createBadge("freeze")
    @JvmField val INSECT_BADGE = createBadge("insect")
    @JvmField val JET_BADGE = createBadge("jet")
    @JvmField val LEGEND_BADGE = createBadge("legend")
    @JvmField val QUAKE_BADGE = createBadge("quake")
    @JvmField val TOXIC_BADGE = createBadge("toxic")
    @JvmField val TRIO_BADGE = createBadge("trio")
    @JvmField val WAVE_BADGE = createBadge("wave")
    @JvmField val BUG_BADGE = createBadge("bug")
    @JvmField val CLIFF_BADGE = createBadge("cliff")
    @JvmField val RUMBLE_BADGE = createBadge("rumble")
    @JvmField val PLANT_BADGE = createBadge("plant")
    @JvmField val VOLTAGE_BADGE = createBadge("voltage")
    @JvmField val FAIRY_BADGE = createBadge("fairy")
    @JvmField val PSYCHIC_BADGE = createBadge("psychic")
    @JvmField val ICEBERG_BADGE = createBadge("iceberg")
    @JvmField val SPIKESHELL_BADGE = createBadge("spikeshell")
    @JvmField val SEARUBY_BADGE = createBadge("searuby")
    @JvmField val JADESTAR_BADGE = createBadge("jadestar")
    @JvmField val CORALEYE_BADGE = createBadge("coraleye")
    @JvmField val FREEDOM_BADGE = createBadge("freedom")
    @JvmField val HARMONY_BADGE = createBadge("harmony")
    @JvmField val PATIENCE_BADGE = createBadge("patience")
    @JvmField val PRIDE_BADGE = createBadge("pride")
    @JvmField val TRANQUILITY_BADGE = createBadge("tranquility")
    @JvmField val DARK_BADGE = createBadge("dark")
    @JvmField val DRAGON_BADGE = createBadge("dragon")
    @JvmField val FAIRY_2_BADGE = createBadge("fairy_2")
    @JvmField val FIRE_BADGE = createBadge("fire")
    @JvmField val GRASS_BADGE = createBadge("grass")
    @JvmField val ICE_BADGE = createBadge("ice")
    @JvmField val ROCK_BADGE = createBadge("rock")
    @JvmField val WATER_BADGE = createBadge("water")
    @JvmField val FIGHTING_BADGE = createBadge("fighting")
    @JvmField val GHOST_BADGE = createBadge("ghost")
    @JvmField val SURGE_BADGE = createBadge("surge")
    @JvmField val COMPLETE_SHIELD_BADGE = createBadge("complete_shield")
    @JvmField val COMPLETE_SWORD_BADGE = createBadge("complete_sword")

    /**
     * Ribbons
     */
    @JvmField val PALDEA_CHAMPION_RIBBON = createRibbon("paldea_champion_ribbon")
    @JvmField val ABILITY_RIBBON = createRibbon("ability_ribbon")
    @JvmField val ALERT_RIBBON = createRibbon("alert_ribbon")
    @JvmField val ALOLA_CHAMPION_RIBBON = createRibbon("alola_champion_ribbon")
    @JvmField val ARTIST_RIBBON = createRibbon("artist_ribbon")
    @JvmField val BEAUTY_MASTER_RIBBON = createRibbon("beauty_master_ribbon")
    @JvmField val BEAUTY_RIBBON_GREAT = createRibbon("beauty_ribbon_great")
    @JvmField val BEAUTY_RIBBON_HOENN = createRibbon("beauty_ribbon_hoenn")
    @JvmField val BEAUTY_RIBBON_HYPER = createRibbon("beauty_ribbon_hyper")
    @JvmField val BEAUTY_RIBBON_MASTER_HOENN = createRibbon("beauty_ribbon_master_hoenn")
    @JvmField val BEAUTY_RIBBON_MASTER_SINNOH = createRibbon("beauty_ribbon_master_sinnoh")
    @JvmField val BEAUTY_RIBBON_SINNOH = createRibbon("beauty_ribbon_sinnoh")
    @JvmField val BEAUTY_RIBBON_SUPER = createRibbon("beauty_ribbon_super")
    @JvmField val BEAUTY_RIBBON_ULTRA = createRibbon("beauty_ribbon_ultra")
    @JvmField val CARELESS_RIBBON = createRibbon("careless_ribbon")
    @JvmField val CHAMPION_RIBBON = createRibbon("champion_ribbon")
    @JvmField val CLEVERNESS_MASTER_RIBBON = createRibbon("cleverness_master_ribbon")
    @JvmField val CONTEST_STAR_RIBBON = createRibbon("contest_star_ribbon")
    @JvmField val COOL_RIBBON_GREAT = createRibbon("cool_ribbon_great")
    @JvmField val COOL_RIBBON_HOENN = createRibbon("cool_ribbon_hoenn")
    @JvmField val COOL_RIBBON_HYPER = createRibbon("cool_ribbon_hyper")
    @JvmField val COOL_RIBBON_MASTER_HOENN = createRibbon("cool_ribbon_master_hoenn")
    @JvmField val COOL_RIBBON_MASTER_SINNOH = createRibbon("cool_ribbon_master_sinnoh")
    @JvmField val COOL_RIBBON_SINNOH = createRibbon("cool_ribbon_sinnoh")
    @JvmField val COOL_RIBBON_SUPER = createRibbon("cool_ribbon_super")
    @JvmField val COOL_RIBBON_ULTRA = createRibbon("cool_ribbon_ultra")
    @JvmField val COOLNESS_MASTER_RIBBON = createRibbon("coolness_master_ribbon")
    @JvmField val CUTE_RIBBON_GREAT = createRibbon("cute_ribbon_great")
    @JvmField val CUTE_RIBBON_HOENN = createRibbon("cute_ribbon_hoenn")
    @JvmField val CUTE_RIBBON_HYPER = createRibbon("cute_ribbon_hyper")
    @JvmField val CUTE_RIBBON_MASTER_HOENN = createRibbon("cute_ribbon_master_hoenn")
    @JvmField val CUTE_RIBBON_MASTER_SINNOH = createRibbon("cute_ribbon_master_sinnoh")
    @JvmField val CUTE_RIBBON_SINNOH = createRibbon("cute_ribbon_sinnoh")
    @JvmField val CUTE_RIBBON_SUPER = createRibbon("cute_ribbon_super")
    @JvmField val CUTE_RIBBON_ULTRA = createRibbon("cute_ribbon_ultra")
    @JvmField val CUTENESS_MASTER_RIBBON = createRibbon("cuteness_master_ribbon")
    @JvmField val DOUBLE_ABILITY_RIBBON = createRibbon("double_ability_ribbon")
    @JvmField val DOWNCAST_RIBBON = createRibbon("downcast_ribbon")
    @JvmField val EARTH_RIBBON = createRibbon("earth_ribbon")
    @JvmField val EFFORT_RIBBON = createRibbon("effort_ribbon")
    @JvmField val EXPERT_BATTLER_RIBBON = createRibbon("expert_battler_ribbon")
    @JvmField val BATTLE_TREE_GREAT_RIBBON = createRibbon("battle_tree_great_ribbon")
    @JvmField val BATTLE_TREE_MASTER_RIBBON = createRibbon("battle_tree_master_ribbon")
    @JvmField val TOWER_MASTER_RIBBON = createRibbon("tower_master_ribbon")
    @JvmField val FOOTPRINT_RIBBON = createRibbon("footprint_ribbon")
    @JvmField val RECORD_RIBBON = createRibbon("record_ribbon")
    @JvmField val BEST_FRIENDS_RIBBON = createRibbon("best_friends_ribbon")
    @JvmField val TRAINING_RIBBON = createRibbon("training_ribbon")
    @JvmField val BATTLE_ROYALE_MASTER_RIBBON = createRibbon("battle_royale_master_ribbon")
    @JvmField val MASTER_RANK_RIBBON = createRibbon("master_rank_ribbon")
    @JvmField val PIONEER_RIBBON = createRibbon("pioneer_ribbon")
    @JvmField val COUNTRY_RIBBON = createRibbon("country_ribbon")
    @JvmField val WORLD_RIBBON = createRibbon("world_ribbon")
    @JvmField val CLASSIC_RIBBON = createRibbon("classic_ribbon")
    @JvmField val PREMIER_RIBBON = createRibbon("premier_ribbon")
    @JvmField val EVENT_RIBBON = createRibbon("event_ribbon")
    @JvmField val BIRTHDAY_RIBBON = createRibbon("birthday_ribbon")
    @JvmField val SPECIAL_RIBBON = createRibbon("special_ribbon")
    @JvmField val SOUVENIR_RIBBON = createRibbon("souvenir_ribbon")
    @JvmField val WISHING_RIBBON = createRibbon("wishing_ribbon")
    @JvmField val BATTLE_CHAMPION_RIBBON = createRibbon("battle_champion_ribbon")
    @JvmField val REGIONAL_CHAMPION_RIBBON = createRibbon("regional_champion_ribbon")
    @JvmField val NATIONAL_CHAMPION_RIBBON = createRibbon("national_champion_ribbon")
    @JvmField val WORLD_CHAMPION_RIBBON = createRibbon("world_champion_ribbon")
    @JvmField val GORGEOUS_RIBBON = createRibbon("gorgeous_ribbon")
    @JvmField val GORGEOUS_ROYAL_RIBBON = createRibbon("gorgeous_royal_ribbon")
    @JvmField val GREAT_ABILITY_RIBBON = createRibbon("great_ability_ribbon")
    @JvmField val HOENN_CHAMPION_RIBBON = createRibbon("hoenn_champion_ribbon")
    @JvmField val KALOS_CHAMPION_RIBBON = createRibbon("kalos_champion_ribbon")
    @JvmField val LEGEND_RIBBON = createRibbon("legend_ribbon")
    @JvmField val MULTI_ABILITY_RIBBON = createRibbon("multi_ability_ribbon")
    @JvmField val NATIONAL_RIBBON = createRibbon("national_ribbon")
    @JvmField val PAIR_ABILITY_RIBBON = createRibbon("pair_ability_ribbon")
    @JvmField val RELAX_RIBBON = createRibbon("relax_ribbon")
    @JvmField val ROYAL_RIBBON = createRibbon("royal_ribbon")
    @JvmField val SHOCK_RIBBON = createRibbon("shock_ribbon")
    @JvmField val SINNOH_CHAMPION_RIBBON = createRibbon("sinnoh_champion_ribbon")
    @JvmField val SKILLFUL_BATTLER_RIBBON = createRibbon("skillful_battler_ribbon")
    @JvmField val SMART_RIBBON_GREAT = createRibbon("smart_ribbon_great")
    @JvmField val SMART_RIBBON_HOENN = createRibbon("smart_ribbon_hoenn")
    @JvmField val SMART_RIBBON_HYPER = createRibbon("smart_ribbon_hyper")
    @JvmField val SMART_RIBBON_MASTER_HOENN = createRibbon("smart_ribbon_master_hoenn")
    @JvmField val SMART_RIBBON_MASTER_SINNOH = createRibbon("smart_ribbon_master_sinnoh")
    @JvmField val SMART_RIBBON_SINNOH = createRibbon("smart_ribbon_sinnoh")
    @JvmField val SMART_RIBBON_SUPER = createRibbon("smart_ribbon_super")
    @JvmField val SMART_RIBBON_ULTRA = createRibbon("smart_ribbon_ultra")
    @JvmField val SMILE_RIBBON = createRibbon("smile_ribbon")
    @JvmField val SNOOZE_RIBBON = createRibbon("snooze_ribbon")
    @JvmField val TOUGH_RIBBON_GREAT = createRibbon("tough_ribbon_great")
    @JvmField val TOUGH_RIBBON_HOENN = createRibbon("tough_ribbon_hoenn")
    @JvmField val TOUGH_RIBBON_HYPER = createRibbon("tough_ribbon_hyper")
    @JvmField val TOUGH_RIBBON_MASTER_HOENN = createRibbon("tough_ribbon_master_hoenn")
    @JvmField val TOUGH_RIBBON_MASTER_SINNOH = createRibbon("tough_ribbon_master_sinnoh")
    @JvmField val TOUGH_RIBBON_SINNOH = createRibbon("tough_ribbon_sinnoh")
    @JvmField val TOUGH_RIBBON_SUPER = createRibbon("tough_ribbon_super")
    @JvmField val TOUGH_RIBBON_ULTRA = createRibbon("tough_ribbon_ultra")
    @JvmField val TOUGHNESS_MASTER_RIBBON = createRibbon("toughness_master_ribbon")
    @JvmField val VICTORY_RIBBON = createRibbon("victory_ribbon")
    @JvmField val WINNING_RIBBON = createRibbon("winning_ribbon")
    @JvmField val WORLD_ABILITY_RIBBON = createRibbon("world_ability_ribbon")
    @JvmField val ONCE_IN_A_LIFETIME_RIBBON = createRibbon("once_in_a_lifetime_ribbon")
    @JvmField val GALAR_CHAMP_RIBBON = createRibbon("galar_champ_ribbon")
    @JvmField val ABILITY_SYMBOL = createRibbon("ability_symbol")
    @JvmField val ABILITY_SYMBOL_SILVER = createRibbon("ability_symbol_silver")
    @JvmField val BRAVE_SYMBOL = createRibbon("brave_symbol")
    @JvmField val BRAVE_SYMBOL_SILVER = createRibbon("brave_symbol_silver")
    @JvmField val GUTS_SYMBOL = createRibbon("guts_symbol")
    @JvmField val GUTS_SYMBOL_SILVER = createRibbon("guts_symbol_silver")
    @JvmField val KNOWLEDGE_SYMBOL = createRibbon("knowledge_symbol")
    @JvmField val KNOWLEDGE_SYMBOL_SILVER = createRibbon("knowledge_symbol_silver")
    @JvmField val LUCK_SYMBOL = createRibbon("luck_symbol")
    @JvmField val LUCK_SYMBOL_SILVER = createRibbon("luck_symbol_silver")
    @JvmField val SPIRITS_SYMBOL = createRibbon("spirits_symbol")
    @JvmField val SPIRITS_SYMBOL_SILVER = createRibbon("spirits_symbol_silver")
    @JvmField val TACTICS_SYMBOL = createRibbon("tactics_symbol")
    @JvmField val TACTICS_SYMBOL_SILVER = createRibbon("tactics_symbol_silver")

    /**
     * Held Items
     */
    @JvmField val ADRENALINE_ORB = registerHeldItem("adrenaline_orb")
    @JvmField val AMULET_COIN = registerHeldItem("amulet_coin")
    @JvmField val BLACK_FLUTE = registerHeldItem("black_flute")
    @JvmField val EXP_ALL = registerHeldItem("exp_all")
    @JvmField val FLUFFY_TAIL = registerHeldItem("fluffy_tail")
    @JvmField val GRIP_CLAW = registerHeldItem("grip_claw")
    @JvmField val LAGGING_TAIL = registerHeldItem("lagging_tail")
    @JvmField val LEEK = registerHeldItem("leek")
    @JvmField val LUCKY_PUNCH = registerHeldItem("lucky_punch")
    @JvmField val LUMINOUS_MOSS = registerHeldItem("luminous_moss")
    @JvmField val MACHO_BRACE = registerHeldItem("macho_brace")
    @JvmField val METRONOME = registerHeldItem("metronome")
    @JvmField val POKE_DOLL = registerHeldItem("poke_doll")
    @JvmField val POKE_TOY = registerHeldItem("poke_toy")
    @JvmField val PROTECTIVE_PADS = registerHeldItem("protective_pads")
    @JvmField val ROOM_SERVICE = registerHeldItem("room_service")
    @JvmField val SCOPE_LENS = registerHeldItem("scope_lens")
    @JvmField val SHED_SHELL = registerHeldItem("shed_shell")
    @JvmField val SNOWBALL = registerHeldItem("snowball")
    @JvmField val SOUL_DEW = registerHeldItem("soul_dew")
    @JvmField val TERRAIN_EXTENDER = registerHeldItem("terrain_extender")
    @JvmField val THICK_CLUB = registerHeldItem("thick_club")
    @JvmField val THROAT_SPRAY = registerHeldItem("throat_spray")
    @JvmField val UP_GRADE = registerHeldItem("up_grade")
    @JvmField val UTILITY_UMBRELLA = registerHeldItem("utility_umbrella")
    @JvmField val WHITE_FLUTE = registerHeldItem("white_flute")
    @JvmField val WIDE_LENS = registerHeldItem("wide_lens")
    @JvmField val ZOOM_LENS = registerHeldItem("zoom_lens")
    @JvmField val BURN_DRIVE = registerHeldItem("burn_drive")
    @JvmField val CHILL_DRIVE = registerHeldItem("chill_drive")
    @JvmField val DOUSE_DRIVE = registerHeldItem("douse_drive")
    @JvmField val SHOCK_DRIVE = registerHeldItem("shock_drive")

    //Incense
    @JvmField val FULL_INCENSE = registerHeldItem("full_incense")
    @JvmField val LAX_INCENSE = registerHeldItem("lax_incense")
    @JvmField val LUCK_INCENSE = registerHeldItem("luck_incense")
    @JvmField val ODD_INCENSE = registerHeldItem("odd_incense")
    @JvmField val PURE_INCENSE = registerHeldItem("pure_incense")
    @JvmField val ROCK_INCENSE = registerHeldItem("rock_incense")
    @JvmField val ROSE_INCENSE = registerHeldItem("rose_incense")
    @JvmField val SEA_INCENSE = registerHeldItem("sea_incense")
    @JvmField val WAVE_INCENSE = registerHeldItem("wave_incense")

    @JvmField val ABOMASITE = registerHeldItem("abomasite")
    @JvmField val ABSOLITE = registerHeldItem("absolite")
    @JvmField val AERODACTYLITE = registerHeldItem("aerodactylite")
    @JvmField val AGGRONITE = registerHeldItem("aggronite")
    @JvmField val ALAKAZITE = registerHeldItem("alakazite")
    @JvmField val ALTARIANITE = registerHeldItem("altarianite")
    @JvmField val AMPHAROSITE = registerHeldItem("ampharosite")
    @JvmField val AUDINITE = registerHeldItem("audinite")
    @JvmField val BANETTITE = registerHeldItem("banettite")
    @JvmField val BEEDRILLITE = registerHeldItem("beedrillite")
    @JvmField val BLASTOISINITE = registerHeldItem("blastoisinite")
    @JvmField val BLAZIKENITE = registerHeldItem("blazikenite")
    @JvmField val CAMERUPTITE = registerHeldItem("cameruptite")
    @JvmField val CHARIZARDITE_X = registerHeldItem("charizardite_x")
    @JvmField val CHARIZARDITE_Y = registerHeldItem("charizardite_y")
    @JvmField val DIANCITE = registerHeldItem("diancite")
    @JvmField val GALLADITE = registerHeldItem("galladite")
    @JvmField val GARCHOMPITE = registerHeldItem("garchompite")
    @JvmField val GARDEVOIRITE = registerHeldItem("gardevoirite")
    @JvmField val GENGARITE = registerHeldItem("gengarite")
    @JvmField val GLALITITE = registerHeldItem("glalitite")
    @JvmField val GYARADOSITE = registerHeldItem("gyaradosite")
    @JvmField val HERACRONITE = registerHeldItem("heracronite")
    @JvmField val HOUNDOOMINITE = registerHeldItem("houndoominite")
    @JvmField val KANGASKHANITE = registerHeldItem("kangaskhanite")
    @JvmField val LATIASITE = registerHeldItem("latiasite")
    @JvmField val LATIOSITE = registerHeldItem("latiosite")
    @JvmField val LOPUNNNITE = registerHeldItem("lopunnite")
    @JvmField val LUCARIONITE = registerHeldItem("lucarionite")
    @JvmField val MANECTITE = registerHeldItem("manectite")
    @JvmField val MAWILITE = registerHeldItem("mawilite")
    @JvmField val MEDICHAMITE = registerHeldItem("medichamite")
    @JvmField val METAGROSSITE = registerHeldItem("metagrossite")
    @JvmField val MEWTWONITE_X = registerHeldItem("mewtwonite_x")
    @JvmField val MEWTWONITE_Y = registerHeldItem("mewtwonite_y")
    @JvmField val PIDGEOTITE = registerHeldItem("pidgeotite")
    @JvmField val PINSIRITE = registerHeldItem("pinsirite")
    @JvmField val SABLENITE = registerHeldItem("sablenite")
    @JvmField val SALAMENCITE = registerHeldItem("salamencite")
    @JvmField val SCEPTILITE = registerHeldItem("sceptilite")
    @JvmField val SCIZORITE = registerHeldItem("scizorite")
    @JvmField val SHARPEDONITE = registerHeldItem("sharpedonite")
    @JvmField val SLOWBRONITE = registerHeldItem("slowbronite")
    @JvmField val STEELIXITE = registerHeldItem("steelixite")
    @JvmField val SWAMPERTITE = registerHeldItem("swampertite")
    @JvmField val TYRANITARITE = registerHeldItem("tyranitarite")
    @JvmField val VENUSAURITE = registerHeldItem("venusaurite")

    @JvmField val BUG_MEMORY_DRIVE = registerHeldItem("bug_memory_drive")
    @JvmField val DARK_MEMORY_DRIVE = registerHeldItem("dark_memory_drive")
    @JvmField val DRAGON_MEMORY_DRIVE = registerHeldItem("dragon_memory_drive")
    @JvmField val ELECTRIC_MEMORY_DRIVE = registerHeldItem("electric_memory_drive")
    @JvmField val FAIRY_MEMORY_DRIVE = registerHeldItem("fairy_memory_drive")
    @JvmField val FIGHTING_MEMORY_DRIVE = registerHeldItem("fighting_memory_drive")
    @JvmField val FIRE_MEMORY_DRIVE = registerHeldItem("fire_memory_drive")
    @JvmField val FLYING_MEMORY_DRIVE = registerHeldItem("flying_memory_drive")
    @JvmField val GHOST_MEMORY_DRIVE = registerHeldItem("ghost_memory_drive")
    @JvmField val GRASS_MEMORY_DRIVE = registerHeldItem("grass_memory_drive")
    @JvmField val GROUND_MEMORY_DRIVE = registerHeldItem("ground_memory_drive")
    @JvmField val ICE_MEMORY_DRIVE = registerHeldItem("ice_memory_drive")
    @JvmField val POISON_MEMORY_DRIVE = registerHeldItem("poison_memory_drive")
    @JvmField val PSYCHIC_MEMORY_DRIVE = registerHeldItem("psychic_memory_drive")
    @JvmField val ROCK_MEMORY_DRIVE = registerHeldItem("rock_memory_drive")
    @JvmField val STEEL_MEMORY_DRIVE = registerHeldItem("steel_memory_drive")
    @JvmField val WATER_MEMORY_DRIVE = registerHeldItem("water_memory_drive")

    @JvmField val DRACO_PLATE = registerPlate("draco_plate", ElementalTypes.DRAGON)
    @JvmField val DREAD_PLATE = registerPlate("dread_plate", ElementalTypes.DARK)
    @JvmField val EARTH_PLATE = registerPlate("earth_plate", ElementalTypes.GROUND)
    @JvmField val FIST_PLATE = registerPlate("fist_plate", ElementalTypes.FIGHTING)
    @JvmField val FLAME_PLATE = registerPlate("flame_plate", ElementalTypes.FIRE)
    @JvmField val ICICLE_PLATE = registerPlate("icicle_plate", ElementalTypes.ICE)
    @JvmField val INSECT_PLATE = registerPlate("insect_plate", ElementalTypes.BUG)
    @JvmField val IRON_PLATE = registerPlate("iron_plate", ElementalTypes.STEEL)
    @JvmField val MEADOW_PLATE = registerPlate("meadow_plate", ElementalTypes.GRASS)
    @JvmField val MIND_PLATE = registerPlate("mind_plate", ElementalTypes.PSYCHIC)
    @JvmField val PIXIE_PLATE = registerPlate("pixie_plate", ElementalTypes.FAIRY)
    @JvmField val SKY_PLATE = registerPlate("sky_plate", ElementalTypes.FLYING)
    @JvmField val SPLASH_PLATE = registerPlate("splash_plate", ElementalTypes.WATER)
    @JvmField val SPOOKY_PLATE = registerPlate("spooky_plate", ElementalTypes.GHOST)
    @JvmField val STONE_PLATE = registerPlate("stone_plate", ElementalTypes.ROCK)
    @JvmField val TOXIC_PLATE = registerPlate("toxic_plate", ElementalTypes.POISON)
    @JvmField val ZAP_PLATE = registerPlate("zap_plate", ElementalTypes.ELECTRIC)

    @JvmField val BUGINIUM_Z = registerHeldItem("buginium_z")
    @JvmField val DARKINIUM_Z = registerHeldItem("darkinium_z")
    @JvmField val DRAGONIUM_Z = registerHeldItem("dragonium_z")
    @JvmField val ELECTRIUM_Z = registerHeldItem("electrium_z")
    @JvmField val FAIRIUM_Z = registerHeldItem("fairium_z")
    @JvmField val FIGHTINIUM_Z = registerHeldItem("fightinium_z")
    @JvmField val FIRIUM_Z = registerHeldItem("firium_z")
    @JvmField val FLYINIUM_Z = registerHeldItem("flyinium_z")
    @JvmField val GHOSTIUM_Z = registerHeldItem("ghostium_z")
    @JvmField val GRASSIUM_Z = registerHeldItem("grassium_z")
    @JvmField val GROUNDIUM_Z = registerHeldItem("groundium_z")
    @JvmField val ICIUM_Z = registerHeldItem("icium_z")
    @JvmField val NORMALIUM_Z = registerHeldItem("normalium_z")
    @JvmField val POISONIUM_Z = registerHeldItem("poisonium_z")
    @JvmField val PSYCHIUM_Z = registerHeldItem("psychium_z")
    @JvmField val ROCKIUM_Z = registerHeldItem("rockium_z")
    @JvmField val STEELIUM_Z = registerHeldItem("steelium_z")
    @JvmField val WATERIUM_Z = registerHeldItem("waterium_z")

    @JvmField val ALORAICHIUM_Z = registerHeldItem("aloraichium_z")
    @JvmField val DECIDIUM_Z = registerHeldItem("decidium_z")
    @JvmField val EEVIUM_Z = registerHeldItem("eevium_z")
    @JvmField val INCINIUM_Z = registerHeldItem("incinium_z")
    @JvmField val KOMMONIUM_Z = registerHeldItem("kommonium_z")
    @JvmField val LUNALIUM_Z = registerHeldItem("lunalium_z")
    @JvmField val LYCANIUM_Z = registerHeldItem("lycanium_z")
    @JvmField val MARSHADIUM_Z = registerHeldItem("marshadium_z")
    @JvmField val MEWNIUM_Z = registerHeldItem("mewnium_z")
    @JvmField val MIMIKIUM_Z = registerHeldItem("mimikium_z")
    @JvmField val PIKANIUM_Z = registerHeldItem("pikanium_z")
    @JvmField val PIKASHUNIUM_Z = registerHeldItem("pikashunium_z")
    @JvmField val PRIMARIUM_Z = registerHeldItem("primarium_z")
    @JvmField val SNORLIUM_Z = registerHeldItem("snorlium_z")
    @JvmField val SOLGANIUM_Z = registerHeldItem("solganium_z")
    @JvmField val TAPUNIUM_Z = registerHeldItem("tapunium_z")
    @JvmField val ULTRANECROZIUM_Z = registerHeldItem("ultranecrozium_z")

    @JvmField val ELECTRIC_SEED = registerHeldItem("electric_seed")
    @JvmField val MISTY_SEED = registerHeldItem("misty_seed")
    @JvmField val GRASSY_SEED = registerHeldItem("grassy_seed")
    @JvmField val PSYCHIC_SEED = registerHeldItem("psychic_seed")
    @JvmField val RED_SCARF = registerHeldItem("red_scarf")
    @JvmField val LEGEND_PLATE = registerHeldItem("legend_plate")
    @JvmField val LUSTROUS_GLOBE = registerHeldItem("lustrous_globe")
    @JvmField val ADAMANT_CRYSTAL = registerHeldItem("adamant_crystal")
    @JvmField val GRISEOUS_CORE = registerHeldItem("griseous_core")
    @JvmField val PUNCHING_GLOVE = registerHeldItem("punching_glove")
    @JvmField val CLEAR_AMULET = registerHeldItem("clear_amulet")
    @JvmField val BOOSTER_ENERGY = registerHeldItem("booster_energy")
    @JvmField val FAIRY_FEATHER = registerHeldItem("fairy_feather")

    /**
     * Vanilla Like Materials
     */
    @JvmField val Z_INGOT = register("z_ingot", ::Item, PLAYER_ITEMS)
    @JvmField val DYNITE_ORE = register("dynite_ore", ::Item, PLAYER_ITEMS)
    @JvmField val MEGASTONE_SHARD = register("mega_stone_shard", { Item(it.stacksTo(1)) }, PLAYER_ITEMS)
    @JvmField val KEY_STONE = register("key_stone", ::Item, PLAYER_ITEMS)



    @JvmField val COPPER_PLATE = register("copper_plate", ::Item, PLAYER_ITEMS);

    /**
     * Player Items
     */
    @JvmField val MARK_CHARM = register("mark_charm", ::Item, PLAYER_ITEMS)
    @JvmField val CATCHING_CHARM = register("catching_charm", ::Item, PLAYER_ITEMS)
    @JvmField val EXP_CHARM = register("exp_charm", ::Item, PLAYER_ITEMS)
    /*, TieredFishingHookEntity.Teir.OLD*/
    @JvmField val OLD_ROD = register("old_rod", { TieredFishingRodItem(it, TieredFishingHookEntity.Teir.OLD) }, PLAYER_ITEMS)
    @JvmField val GOOD_ROD = register("good_rod", { TieredFishingRodItem(it, TieredFishingHookEntity.Teir.GOOD) }, PLAYER_ITEMS)
    /*, TieredFishingHookEntity.Teir.SUPER*/
    @JvmField val SUPER_ROD = register("super_rod", { TieredFishingRodItem(it, TieredFishingHookEntity.Teir.SUPER) }, PLAYER_ITEMS)
    /*, TieredFishingHookEntity.Teir.RUBY*/
    @JvmField val RUBY_ROD = register("ruby_rod", { RubyRodItem(it, TieredFishingHookEntity.Teir.RUBY) }, PLAYER_ITEMS)
    @JvmField val CAMERA = register("camera", ::CameraItem, PLAYER_ITEMS)
    @JvmField val SNAP_CAMERA = register("snap_camera", ::CameraItem, PLAYER_ITEMS)
    @JvmField val FILM = register("film", ::Item, PLAYER_ITEMS)
    @JvmField val REPEL = register("repel", ::Item, PLAYER_ITEMS)
    @JvmField val SUPER_REPEL = register("super_repel", ::Item, PLAYER_ITEMS)
    @JvmField val MAX_REPEL = register("max_repel", ::Item, PLAYER_ITEMS)
    @JvmField val WAILMER_PAIL = register("wailmer_pail", ::Item, PLAYER_ITEMS)
    @JvmField val SPRINK_LOTAD = register("sprink_lotad", ::Item, PLAYER_ITEMS)
    @JvmField val SPRAYDUCK = register("sprayduck", { Item(it.stacksTo(1)) }, PLAYER_ITEMS)
    @JvmField val SQUIRT_BOTTLE = register("squirt_bottle", { Item(it.stacksTo(1)) }, PLAYER_ITEMS)
    @JvmField val MEGA_BRACELET = register("mega_bracelet", { Item(it.stacksTo(1)) }, PLAYER_ITEMS)
    @JvmField val MEGA_CHARM = register("mega_charm", { Item(it.stacksTo(1)) }, PLAYER_ITEMS)
    @JvmField val MEGA_CUFF = register("mega_cuff", { Item(it.stacksTo(1)) }, PLAYER_ITEMS)
    @JvmField val MEGA_RING = register("mega_ring", { Item(it.stacksTo(1)) }, PLAYER_ITEMS)
    @JvmField val Z_POWER_RING = register("z_power_ring", { Item(it.stacksTo(1)) }, PLAYER_ITEMS)
    @JvmField val Z_RING = register("z_ring", { Item(it.stacksTo(1)) }, PLAYER_ITEMS)
    /*
    public static final RegistrySupplier<Item> RED_BIKE = register("red_bike", Item::new, PLAYER_ITEMS);
    public static final RegistrySupplier<Item> ORANGE_BIKE = register("orange_bike", Item::new, PLAYER_ITEMS);
    public static final RegistrySupplier<Item> YELLOW_BIKE = register("yellow_bike", Item::new, PLAYER_ITEMS);
    public static final RegistrySupplier<Item> GREEN_BIKE = register("green_bike", Item::new, PLAYER_ITEMS);
    public static final RegistrySupplier<Item> BLUE_BIKE = register("blue_bike", Item::new, PLAYER_ITEMS);
    public static final RegistrySupplier<Item> PURPLE_BIKE = register("purple_bike", Item::new, PLAYER_ITEMS);
    */
    @JvmField val ROTOM_CATALOG = register("rotom_catalog", ::Item, PLAYER_ITEMS)
    @JvmField val POKEDEX = register("pokedex", ::Item, PLAYER_ITEMS)
    @JvmField val LURE_MODULE = register("lure_module", ::Item, PLAYER_ITEMS)
    @JvmField val BOTTLE_CAP = register("bottle_cap", ::Item, PLAYER_ITEMS)
    @JvmField val GOLD_BOTTLE_CAP = register("gold_bottle_cap", ::Item, PLAYER_ITEMS)
    @JvmField val WISHING_STAR = register("wishing_star", ::Item, PLAYER_ITEMS)
    @JvmField val DYNAMAX_BAND = register("dynamax_band", { Item(it.stacksTo(1)) }, PLAYER_ITEMS)
    @JvmField val TIME_CAPSULE = register("time_capsule", { TimeCapsule(it.fireResistant().stacksTo(1)) }, PLAYER_ITEMS)
    @JvmField val STRANGE_BALL = register("strange_ball", { PokeBallItem(GenerationsPokeBalls.STRANGE_BALL) })


//    private static RegistrySupplier<PokeBallItem> registerBallItem(PokeBall pokeBall) {
//        return register(pokeBall.getName().getPath(), () -> {
//            var item = new PokeBallItem(pokeBall);
//            pokeBall.item = item;
//        })
//
//        val item = create(pokeBall.name.path, PokeBallItem(pokeBall))
//        pokeBall.item = item
//        pokeBalls.add(item)
//        return item
//    }


    /**
     * Legendary Items
     */
    @JvmField val ORB = register("orb", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val ADAMANT_ORB = register("adamant_orb", { CreationTrioItem(it.stacksTo(1), LegendKeys.DIALGA, GenerationsCore.id("models/block/shrines/creation_trio/adamant_orb.pk")) }, LEGENDARY_ITEMS);
    @JvmField val GRISEOUS_ORB = register("griseous_orb", { CreationTrioItem(it.stacksTo(1), LegendKeys.GIRATINA, GenerationsCore.id("models/block/shrines/creation_trio/griseous_orb.pk")) }, LEGENDARY_ITEMS);
    @JvmField val LUSTROUS_ORB = register("lustrous_orb", { CreationTrioItem(it.stacksTo(1), LegendKeys.PALKIA, GenerationsCore.id("models/block/shrines/creation_trio/lustrous_orb.pk")) }, LEGENDARY_ITEMS);
    @JvmField val SHATTERED_ICE_KEY_1 = register("shattered_ice_key_1", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val SHATTERED_ICE_KEY_2 = register("shattered_ice_key_2", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val SHATTERED_ICE_KEY_3 = register("shattered_ice_key_3", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val SHATTERED_ICE_KEY_4 = register("shattered_ice_key_4", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val ICEBERG_KEY = register("iceberg_key", { RegiKeyItem(it, LegendKeys.REGICE) }, LEGENDARY_ITEMS);
    @JvmField val CRUMBLED_ROCK_KEY_1 = register("crumbled_rock_key_1", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val CRUMBLED_ROCK_KEY_2 = register("crumbled_rock_key_2", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val CRUMBLED_ROCK_KEY_3 = register("crumbled_rock_key_3", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val CRUMBLED_ROCK_KEY_4 = register("crumbled_rock_key_4", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val ROCK_PEAK_KEY = register("rock_peak_key", { RegiKeyItem(it, LegendKeys.REGIROCK) }, LEGENDARY_ITEMS);
    @JvmField val RUSTY_IRON_KEY_1 = register("rusty_iron_key_1", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val RUSTY_IRON_KEY_2 = register("rusty_iron_key_2", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val RUSTY_IRON_KEY_3 = register("rusty_iron_key_3", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val RUSTY_IRON_KEY_4 = register("rusty_iron_key_4", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val IRON_KEY = register("iron_key", { RegiKeyItem(it, LegendKeys.REGISTEEL) }, LEGENDARY_ITEMS);
    @JvmField val FRAGMENTED_DRAGO_KEY_1 = register("fragmented_drago_key_1", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val FRAGMENTED_DRAGO_KEY_2 = register("fragmented_drago_key_2", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val FRAGMENTED_DRAGO_KEY_3 = register("fragmented_drago_key_3", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val FRAGMENTED_DRAGO_KEY_4 = register("fragmented_drago_key_4", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val DRAGO_KEY = register("drago_key", { RegiKeyItem(it, LegendKeys.REGIDRAGO) }, LEGENDARY_ITEMS);
    @JvmField val DISCHARGED_ELEKI_KEY_1 = register("discharged_eleki_key_1", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val DISCHARGED_ELEKI_KEY_2 = register("discharged_eleki_key_2", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val DISCHARGED_ELEKI_KEY_3 = register("discharged_eleki_key_3", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val DISCHARGED_ELEKI_KEY_4 = register("discharged_eleki_key_4", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val ELEKI_KEY = register("eleki_key", { RegiKeyItem(it, LegendKeys.REGIELEKI) } , LEGENDARY_ITEMS);
    @JvmField val SHATTERED_RELIC_SONG_1 = register("shattered_relic_song_1", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val SHATTERED_RELIC_SONG_2 = register("shattered_relic_song_2", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val SHATTERED_RELIC_SONG_3 = register("shattered_relic_song_3", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val SHATTERED_RELIC_SONG_4 = register("shattered_relic_song_4", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val RELIC_SONG = createRelicSong(false)
    @JvmField val INERT_RELIC_SONG = createRelicSong(true)
    @JvmField val RED_CHAIN = register("red_chain", { RedChainItem(it.stacksTo(1)) }, LEGENDARY_ITEMS)
    @JvmField val DNA_SPLICERS = register("dna_splicers", { DnaSplicer(it) }, LEGENDARY_ITEMS)
    @JvmField val REINS_OF_UNITY = register("reins_of_unity", ::Item, LEGENDARY_ITEMS)
    @JvmField val N_SOLARIZER = register("n_solarizer", { NecroizerItemItem(it, "solgaleo", "sunsteelstrike", "duskmane")}, LEGENDARY_ITEMS)
    @JvmField val N_LUNARIZER = register("n_lunarizer", { NecroizerItemItem(it, "lunala", "moongeistbeam", "dawnwings") }, LEGENDARY_ITEMS)
    @JvmField val LEGEND_FINDER = register("legend_finder", ::Item, LEGENDARY_ITEMS)
    @JvmField val HOOPA_RING = register("hoopa_ring", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val RED_ORB = register("red_orb", ::Item, LEGENDARY_ITEMS)
    @JvmField val FADED_RED_ORB = register("faded_red_orb", { ElementalPostBattleUpdateItemImpl(it.stacksTo(1).durability(300), ElementalTypes.FIRE) }, LEGENDARY_ITEMS)
    @JvmField val FADED_BLUE_ORB = register("faded_blue_orb", { ElementalPostBattleUpdateItemImpl(it.stacksTo(1).durability(300), ElementalTypes.WATER) }, LEGENDARY_ITEMS)
    @JvmField val FADED_JADE_ORB = register("faded_jade_orb", { ElementalPostBattleUpdateItemImplImpl(it.stacksTo(1).durability(300), LegendKeys.RAYQUAZA, ElementalTypes.FLYING) }, LEGENDARY_ITEMS)
    @JvmField val BLUE_ORB = register("blue_orb", ::Item, LEGENDARY_ITEMS)
    @JvmField val JADE_ORB = register("jade_orb", { JadeOrb(it.stacksTo(1)) }, LEGENDARY_ITEMS)
    @JvmField val LIGHT_STONE = register("light_stone", { TaoTrioStoneItem(it.stacksTo(1).durability(100), LegendKeys.RESHIRAM) }, LEGENDARY_ITEMS)
    @JvmField val DARK_STONE = register("dark_stone", { TaoTrioStoneItem(it.stacksTo(1).durability(100), LegendKeys.ZEKROM) }, LEGENDARY_ITEMS)
    @JvmField val DRAGON_STONE = register("dragon_stone", { TaoTrioStoneItem(it.stacksTo(1).durability(100), LegendKeys.KYUREM) }, LEGENDARY_ITEMS)
    @JvmField val RAINBOW_WING = register("rainbow_wing", { WingItem(it, "rainbow", ElementalTypes.FLYING, LegendKeys.HO_OH) }, LEGENDARY_ITEMS)
    @JvmField val SILVER_WING = register("silver_wing", { WingItem(it.stacksTo(1), "silver", ElementalTypes.FLYING, LegendKeys.LUGIA) }, LEGENDARY_ITEMS)
    @JvmField val DARK_SOUL = register("dark_soul", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val DRAGON_SOUL = register("dragon_soul", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val MELODY_FLUTE = register("melody_flute", ::MelodyFluteItem, LEGENDARY_ITEMS);
    @JvmField val SPARKLING_SHARD = register("sparkling_shard", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val SPARKLING_STONE = register("sparkling_stone", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val RUSTY_FRAGMENT = register("rusty_fragment", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val RUSTY_SWORD = register("rusty_sword", { ElementalPostBattleUpdateItemImplImpl(it.stacksTo(1).durability(100), LegendKeys.ZACIAN, ElementalTypes.STEEL) }, LEGENDARY_ITEMS);
    @JvmField val CROWNED_SWORD = register("crowned_sword", ::Item, LEGENDARY_ITEMS);
    @JvmField val RUSTY_SHIELD = register("rusty_shield", { ElementalPostBattleUpdateItemImplImpl(it.stacksTo(1).durability(100), LegendKeys.ZAMAZENTA, ElementalTypes.STEEL) }, LEGENDARY_ITEMS);
    @JvmField val CROWNED_SHIELD = register("crowned_shield", ::Item, LEGENDARY_ITEMS);
    @JvmField val SCROLL_PAGE = register("scroll_page", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val SECRET_ARMOR_SCROLL = register("secret_armor_scroll", ::SecretArmorScroll, LEGENDARY_ITEMS);
    @JvmField val ZYGARDE_CUBE = register("zygarde_cube", { ZygardeCubeItem(it.stacksTo(1).durability(ZygardeCubeItem.FULL)) }, LEGENDARY_ITEMS);
    @JvmField val MELTAN_BOX = register("meltan_box", { MeltanBox(it.stacksTo(1).durability(200)) }, LEGENDARY_ITEMS);
    @JvmField val MELTAN_BOX_CHARGED = register("meltan_box_charged", ::MeltanBox, LEGENDARY_ITEMS);
    @JvmField val TIME_GLASS = register("time_glass", { TimeGlassItem(it.stacksTo(1).durability(100)) }, LEGENDARY_ITEMS);
    @JvmField val MOON_FLUTE = register("moon_flute", ::Item, LEGENDARY_ITEMS);
    @JvmField val SUN_FLUTE = register("sun_flute", ::Item, LEGENDARY_ITEMS);
    @JvmField val LAVA_CRYSTAL = register("lava_crystal", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val JEWEL_OF_LIFE = register("jewel_of_life", ::Item, LEGENDARY_ITEMS);
    @JvmField val MIRROR = register("mirror", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val UNENCHANTED_ICEROOT_CARROT = register("unenchanted_iceroot_carrot", ::Item, LEGENDARY_ITEMS)
    @JvmField val ICEROOT_CARROT = register("iceroot_carrot", { CalyrexSteedItem("iceroot", it.stacksTo(1).food(FoodProperties.Builder().alwaysEat().build()), LegendKeys.GLASTRIER, UNENCHANTED_ICEROOT_CARROT) }, LEGENDARY_ITEMS)
    @JvmField val UNENCHANTED_SHADEROOT_CARROT = register("unenchanted_shaderoot_carrot", ::Item, LEGENDARY_ITEMS)
    @JvmField val SHADEROOT_CARROT = register("shaderoot_carrot", { CalyrexSteedItem("shaderoot", it.stacksTo(1).food(FoodProperties.Builder().alwaysEat().build()), LegendKeys.SPECTRIER, UNENCHANTED_SHADEROOT_CARROT) }, LEGENDARY_ITEMS)
    @JvmField val ENIGMA_STONE = register("enigma_stone", { EnigmaStoneItem(it.stacksTo(1).durability(100)) }, LEGENDARY_ITEMS)
    @JvmField val ENIGMA_SHARD = register("enigma_shard", { ItemWithLangTooltipImpl(it.stacksTo(64)) }, LEGENDARY_ITEMS)
    @JvmField val ENIGMA_FRAGMENT = register("enigma_fragment", { ItemWithLangTooltipImpl(it.stacksTo(64).fireResistant() /* just incase it falls into lava while in nether*/) }, LEGENDARY_ITEMS);
    @JvmField val SACRED_ASH = register("sacred_ash", { ItemWithLangTooltipImpl(it.stacksTo(1).durability(1)) }, LEGENDARY_ITEMS);
    @JvmField val SHARD_OF_WILLPOWER = register("shard_of_willpower", { ItemWithLangTooltipImpl(it.stacksTo(9)) }, LEGENDARY_ITEMS)
    @JvmField val SHARD_OF_EMOTION = register("shard_of_emotion", { ItemWithLangTooltipImpl(it.stacksTo(9)) }, LEGENDARY_ITEMS)
    @JvmField val SHARD_OF_KNOWLEDGE = register("shard_of_knowledge", { ItemWithLangTooltipImpl(it.stacksTo(9)) }, LEGENDARY_ITEMS)
    @JvmField val CRYSTAL_OF_WILLPOWER = register("crystal_of_willpower", { LakeCrystalItem(it.durability(100), LegendKeys.AZELF) }, LEGENDARY_ITEMS);
    @JvmField val CRYSTAL_OF_EMOTION = register("crystal_of_emotion", { LakeCrystalItem(it.durability(100), LegendKeys.MESPRIT) }, LEGENDARY_ITEMS);
    @JvmField val CRYSTAL_OF_KNOWLEDGE = register("crystal_of_knowledge", { LakeCrystalItem(it.durability(100), LegendKeys.UXIE) }, LEGENDARY_ITEMS);
    @JvmField val REGICE_ORB = register("regice_orb", { RegiOrbItem(it, "regice") }, LEGENDARY_ITEMS);
    @JvmField val REGIROCK_ORB = register("regirock_orb", { RegiOrbItem(it, "regirock") }, LEGENDARY_ITEMS);
    @JvmField val REGISTEEL_ORB = register("registeel_orb", { RegiOrbItem(it,"registeel") }, LEGENDARY_ITEMS);
    @JvmField val REGIDRAGO_ORB = register("regidrago_orb", { RegiOrbItem(it, "regidrago") }, LEGENDARY_ITEMS);
    @JvmField val REGIELEKI_ORB = register("regieleki_orb", { RegiOrbItem(it, "regieleki") }, LEGENDARY_ITEMS);
    @JvmField val MAGMA_CRYSTAL = register("magma_crystal", { MagmaCrystal(it.stacksTo(1)) }, LEGENDARY_ITEMS);
    @JvmField val ICY_WING = register("icy_wing", { WingItem(it.stacksTo(1), "icy", ElementalTypes.ICE, LegendKeys.ARTICUNO) }, LEGENDARY_ITEMS)
    @JvmField val ELEGANT_WING = register("elegant_wing", { WingItem(it.stacksTo(1), "elegant", ElementalTypes.PSYCHIC, LegendKeys.GALARIAN_ARTICUNO) }, LEGENDARY_ITEMS)
    @JvmField val STATIC_WING = register("static_wing", { WingItem(it.stacksTo(1), "static", ElementalTypes.ELECTRIC, LegendKeys.ZAPDOS) }, LEGENDARY_ITEMS)
    @JvmField val BELLIGERENT_WING = register("belligerent_wing", { WingItem(it.stacksTo(1), "belligerent", ElementalTypes.FIGHTING, LegendKeys.GALARIAN_ZAPDOS) }, LEGENDARY_ITEMS)
    @JvmField val FIERY_WING = register("fiery_wing", { WingItem(it.stacksTo(1).fireResistant(), "fiery", ElementalTypes.FIRE, LegendKeys.MOLTRES) }, LEGENDARY_ITEMS)
    @JvmField val SINISTER_WING = register("sinister_wing", { WingItem(it.stacksTo(1), "sinister", ElementalTypes.DARK, LegendKeys.GALARIAN_MOLTRES) }, LEGENDARY_ITEMS)
    @JvmField val MEW_DNA_FIBER = register("mew_dna_fiber", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val MEW_FOSSIL = register("mew_fossil", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)
    @JvmField val LIGHT_SOUL = register("light_soul", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS)

    //TODO: Turn back to 10,000 before release
    @JvmField val WONDER_EGG = register("wonder_egg", { LegendaryEggItem(it.stacksTo(1), LegendKeys.MANAPHY, 100.0) }, LEGENDARY_ITEMS);

    //TODO: Turn back to 10,000 before release
    @JvmField val PHIONE_EGG = register("phione_egg", { LegendaryEggItem(it.stacksTo(1), LegendKeys.PHIONE, 100.0) }, LEGENDARY_ITEMS)
    @JvmField val SOUL_HEART = register("soul_heart", { SingleElmentPostUpdatingItem(it.stacksTo(1).durability(100), ElementalTypes.FAIRY) }, LEGENDARY_ITEMS)
    @JvmField val BLUE_PETAL = register("blue_petal", ::Item, LEGENDARY_ITEMS);
    @JvmField val GREEN_PETAL = register("green_petal", ::Item, LEGENDARY_ITEMS);
    @JvmField val ORANGE_PETAL = register("orange_petal", ::Item, LEGENDARY_ITEMS);
    @JvmField val PINK_PETAL = register("pink_petal", ::Item, LEGENDARY_ITEMS);
    @JvmField val PURPLE_PETAL = register("purple_petal", ::Item, LEGENDARY_ITEMS);
    @JvmField val RADIANT_PETAL = register("radiant_petal", ::Item, LEGENDARY_ITEMS);
    @JvmField val RED_PETAL = register("red_petal", ::Item, LEGENDARY_ITEMS);
    @JvmField val YELLOW_PETAL = register("yellow_petal", ::Item, LEGENDARY_ITEMS);
    @JvmField val METEORITE_SHARD = register("meteorite_shard", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val BLACK_MANE_HAIR = register("black_mane_hair", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);
    @JvmField val WHITE_MANE_HAIR = register("white_mane_hair", ::ItemWithLangTooltipImpl, LEGENDARY_ITEMS);

    /**
     * Naturals
     */
    @JvmField val CRYSTAL = register("crystal", ::Item, PLAYER_ITEMS)
    @JvmField val RUBY = register("ruby", ::Item, PLAYER_ITEMS)
    @JvmField val SAPPHIRE = register("sapphire", ::Item, PLAYER_ITEMS)
    @JvmField val SILICON = register("silicon", ::Item, PLAYER_ITEMS)

    /**
     * Utility Items
     */
    @JvmField val POKEMON_WAND = register("pokemon_wand", ::Item, UTILITY)
    @JvmField val CHISEL = register("chisel", ::StatueSpawnerItem, UTILITY)
    @JvmField val SUICUNE_STATUE = register("suicune_statue", { StatueSpawnerItem(it, LegendKeys.SUICUNE) }, LEGENDARY_ITEMS)
    @JvmField val RAIKOU_STATUE = register("raikou_statue", { StatueSpawnerItem(it, LegendKeys.RAIKOU) }, LEGENDARY_ITEMS)
    @JvmField val ENTEI_STATUE = register("entei_statue", { StatueSpawnerItem(it, LegendKeys.ENTEI) }, LEGENDARY_ITEMS)

    @JvmField val GIFT_BOX = register("gift_box", ::Item, UTILITY);
    @JvmField val NPC_WAND = register("npc_wand", ::NpcWandItem, UTILITY);
    @JvmField val NPC_PATH_TOOL = register("npc_path_tool", ::NpcPathTool, UTILITY);
    @JvmField val ZONE_WAND = register("zone_wand", ::Item, UTILITY);
    @JvmField val BIKE_FRAME = register("bike_frame", ::Item, UTILITY);
    @JvmField val BIKE_HANDLEBARS = register("bike_handlebars", ::Item, UTILITY);
    @JvmField val BIKE_SEAT = register("bike_seat", ::Item, UTILITY);
    @JvmField val BIKE_WHEEL = register("bike_wheel", ::Item, UTILITY);
    @JvmField val HIDDEN_IRON_DOOR = register("hidden_iron_door", ::Item, UTILITY);
    @JvmField val HIDDEN_WOODEN_DOOR = register("hidden_wooden_door", ::Item, UTILITY);
    @JvmField val HIDDEN_LEVER = register("hidden_lever", ::Item, UTILITY);
    @JvmField val HIDDEN_PRESSURE_PLATE = register("hidden_pressure_plate", ::Item, UTILITY);
    @JvmField val HIDDEN_CUBE = register("hidden_cube", ::Item, UTILITY);
    @JvmField val HIDDEN_BUTTON = register("hidden_button", ::Item, UTILITY);

    /**
     * Form Items
     */
    @JvmField val METEORITE = register("meteorite", ::MeteoriteItem, FORM_ITEMS)
    @JvmField val GRACIDEA = register("gracidea", ::GracideaItem, FORM_ITEMS)
    @JvmField val REVEAL_GLASS = register("reveal_glass", ::ItemWithLangTooltipImpl, FORM_ITEMS)
    @JvmField val ROCKSTAR_COSTUME = register("rockstar_costume", ::Item, FORM_ITEMS)
    @JvmField val BELLE_COSTUME = register("belle_costume", ::Item, FORM_ITEMS)
    @JvmField val POPSTAR_COSTUME = register("popstar_costume", ::Item, FORM_ITEMS)
    @JvmField val PHD_COSTUME = register("phd_costume", ::Item, FORM_ITEMS)
    @JvmField val LIBRE_COSTUME = register("libre_costume", ::Item, FORM_ITEMS)
    @JvmField val MEWTWO_ARMOR = register("mewtwo_armor", ::Item, FORM_ITEMS)
    @JvmField val PINK_NECTAR = register("pink_nectar", { NectarItem(it, "pa'u") }, FORM_ITEMS)
    @JvmField val PURPLE_NECTAR = register("purple_nectar", { NectarItem(it, "sensu") }, FORM_ITEMS)
    @JvmField val RED_NECTAR = register("red_nectar", { NectarItem(it, "") }, FORM_ITEMS)
    @JvmField val YELLOW_NECTAR = register("yellow_nectar", { NectarItem(it, "pom-pom") }, FORM_ITEMS)

    /**
     * Mail
     */
    @JvmField val POKEMAIL_AIR = registerMail("pokemail_air", MailTypes.AIR)
    @JvmField val POKEMAIL_AIR_CLOSED = registerClosedMail("pokemail_air_closed", MailTypes.AIR)
    @JvmField val POKEMAIL_BLOOM = registerMail("pokemail_bloom", MailTypes.BLOOM)
    @JvmField val POKEMAIL_BLOOM_CLOSED = registerClosedMail("pokemail_bloom_closed", MailTypes.BLOOM)
    @JvmField val POKEMAIL_BRICK = registerMail("pokemail_brick", MailTypes.BRICK)
    @JvmField val POKEMAIL_BRICK_CLOSED = registerClosedMail("pokemail_brick_closed", MailTypes.BRICK)
    @JvmField val POKEMAIL_BRIDGE_D = registerMail("pokemail_bridge_d", MailTypes.BRIDGE_D)
    @JvmField val POKEMAIL_BRIDGE_D_CLOSED = registerClosedMail("pokemail_bridge_d_closed", MailTypes.BRIDGE_D)
    @JvmField val POKEMAIL_BRIDGE_M = registerMail("pokemail_bridge_m", MailTypes.BRIDGE_M)
    @JvmField val POKEMAIL_BRIDGE_M_CLOSED = registerClosedMail("pokemail_bridge_m_closed", MailTypes.BRIDGE_M)
    @JvmField val POKEMAIL_BRIDGE_S = registerMail("pokemail_bridge_s", MailTypes.BRIDGE_S)
    @JvmField val POKEMAIL_BRIDGE_S_CLOSED = registerClosedMail("pokemail_bridge_s_closed", MailTypes.BRIDGE_S)
    @JvmField val POKEMAIL_BRIDGE_T = registerMail("pokemail_bridge_t", MailTypes.BRIDGE_T)
    @JvmField val POKEMAIL_BRIDGE_T_CLOSED = registerClosedMail("pokemail_bridge_t_closed", MailTypes.BRIDGE_T)
    @JvmField val POKEMAIL_BRIDGE_V = registerMail("pokemail_bridge_v", MailTypes.BRIDGE_V)
    @JvmField val POKEMAIL_BRIDGE_V_CLOSED = registerClosedMail("pokemail_bridge_v_closed", MailTypes.BRIDGE_V)
    @JvmField val POKEMAIL_BUBBLE = registerMail("pokemail_bubble", MailTypes.BUBBLE)
    @JvmField val POKEMAIL_BUBBLE_CLOSED = registerClosedMail("pokemail_bubble_closed", MailTypes.BUBBLE)
    @JvmField val POKEMAIL_DREAM = registerMail("pokemail_dream", MailTypes.DREAM)
    @JvmField val POKEMAIL_DREAM_CLOSED = registerClosedMail("pokemail_dream_closed", MailTypes.DREAM)
    @JvmField val POKEMAIL_FAB = registerMail("pokemail_fab", MailTypes.FAB)
    @JvmField val POKEMAIL_FAB_CLOSED = registerClosedMail("pokemail_fab_closed", MailTypes.FAB)
    @JvmField val POKEMAIL_FAVORED = registerMail("pokemail_favored", MailTypes.FAVORED)
    @JvmField val POKEMAIL_FAVORED_CLOSED = registerClosedMail("pokemail_favored_closed", MailTypes.FAVORED)
    @JvmField val POKEMAIL_FLAME = registerMail("pokemail_flame", MailTypes.FLAME)
    @JvmField val POKEMAIL_FLAME_CLOSED = registerClosedMail("pokemail_flame_closed", MailTypes.FLAME)
    @JvmField val POKEMAIL_GLITTER = registerMail("pokemail_glitter", MailTypes.GLITTER)
    @JvmField val POKEMAIL_GLITTER_CLOSED = registerClosedMail("pokemail_glitter_closed", MailTypes.GLITTER)
    @JvmField val POKEMAIL_GRASS = registerMail("pokemail_grass", MailTypes.GRASS)
    @JvmField val POKEMAIL_GRASS_CLOSED = registerClosedMail("pokemail_grass_closed", MailTypes.GRASS)
    @JvmField val POKEMAIL_GREET = registerMail("pokemail_greet", MailTypes.GREET)
    @JvmField val POKEMAIL_GREET_CLOSED = registerClosedMail("pokemail_greet_closed", MailTypes.GREET)
    @JvmField val POKEMAIL_HARBOR = registerMail("pokemail_harbor", MailTypes.HARBOR)
    @JvmField val POKEMAIL_HARBOR_CLOSED = registerClosedMail("pokemail_harbor_closed", MailTypes.HARBOR)
    @JvmField val POKEMAIL_HEART = registerMail("pokemail_heart", MailTypes.HEART)
    @JvmField val POKEMAIL_HEART_CLOSED = registerClosedMail("pokemail_heart_closed", MailTypes.HEART)
    @JvmField val POKEMAIL_INQUIRY = registerMail("pokemail_inquiry", MailTypes.INQUIRY)
    @JvmField val POKEMAIL_INQUIRY_CLOSED = registerClosedMail("pokemail_inquiry_closed", MailTypes.INQUIRY)
    @JvmField val POKEMAIL_LIKE = registerMail("pokemail_like", MailTypes.LIKE)
    @JvmField val POKEMAIL_LIKE_CLOSED = registerClosedMail("pokemail_like_closed", MailTypes.LIKE)
    @JvmField val POKEMAIL_MECH = registerMail("pokemail_mech", MailTypes.MECH)
    @JvmField val POKEMAIL_MECH_CLOSED = registerClosedMail("pokemail_mech_closed", MailTypes.MECH)
    @JvmField val POKEMAIL_MOSAIC = registerMail("pokemail_mosaic", MailTypes.MOSAIC)
    @JvmField val POKEMAIL_MOSAIC_CLOSED = registerClosedMail("pokemail_mosaic_closed", MailTypes.MOSAIC)
    @JvmField val POKEMAIL_ORANGE = registerMail("pokemail_orange", MailTypes.ORANGE)
    @JvmField val POKEMAIL_ORANGE_CLOSED = registerClosedMail("pokemail_orange_closed", MailTypes.ORANGE)
    @JvmField val POKEMAIL_REPLY = registerMail("pokemail_reply", MailTypes.REPLY)
    @JvmField val POKEMAIL_REPLY_CLOSED = registerClosedMail("pokemail_reply_closed", MailTypes.REPLY)
    @JvmField val POKEMAIL_RETRO = registerMail("pokemail_retro", MailTypes.RETRO)
    @JvmField val POKEMAIL_RETRO_CLOSED = registerClosedMail("pokemail_retro_closed", MailTypes.RETRO)
    @JvmField val POKEMAIL_RSVP = registerMail("pokemail_rsvp", MailTypes.RSVP)
    @JvmField val POKEMAIL_RSVP_CLOSED = registerClosedMail("pokemail_rsvp_closed", MailTypes.RSVP)
    @JvmField val POKEMAIL_SHADOW = registerMail("pokemail_shadow", MailTypes.SHADOW)
    @JvmField val POKEMAIL_SHADOW_CLOSED = registerClosedMail("pokemail_shadow_closed", MailTypes.SHADOW)
    @JvmField val POKEMAIL_SNOW = registerMail("pokemail_snow", MailTypes.SNOW)
    @JvmField val POKEMAIL_SNOW_CLOSED = registerClosedMail("pokemail_snow_closed", MailTypes.SNOW)
    @JvmField val POKEMAIL_SPACE = registerMail("pokemail_space", MailTypes.SPACE)
    @JvmField val POKEMAIL_SPACE_CLOSED = registerClosedMail("pokemail_space_closed", MailTypes.SPACE)
    @JvmField val POKEMAIL_STEEL = registerMail("pokemail_steel", MailTypes.STEEL)
    @JvmField val POKEMAIL_STEEL_CLOSED = registerClosedMail("pokemail_steel_closed", MailTypes.STEEL)
    @JvmField val POKEMAIL_THANKS = registerMail("pokemail_thanks", MailTypes.THANKS)
    @JvmField val POKEMAIL_THANKS_CLOSED = registerClosedMail("pokemail_thanks_closed", MailTypes.THANKS)
    @JvmField val POKEMAIL_TROPIC = registerMail("pokemail_tropic", MailTypes.TROPIC)
    @JvmField val POKEMAIL_TROPIC_CLOSED = registerClosedMail("pokemail_tropic_closed", MailTypes.TROPIC)
    @JvmField val POKEMAIL_TUNNEL = registerMail("pokemail_tunnel", MailTypes.TUNNEL)
    @JvmField val POKEMAIL_TUNNEL_CLOSED = registerClosedMail("pokemail_tunnel_closed", MailTypes.TUNNEL)
    @JvmField val POKEMAIL_WAVE = registerMail("pokemail_wave", MailTypes.WAVE)
    @JvmField val POKEMAIL_WAVE_CLOSED = registerClosedMail("pokemail_wave_closed", MailTypes.WAVE)
    @JvmField val POKEMAIL_WOOD = registerMail("pokemail_wood", MailTypes.WOOD)
    @JvmField val POKEMAIL_WOOD_CLOSED = registerClosedMail("pokemail_wood_closed", MailTypes.WOOD)

    /**
     * Valuable Items
     */
    @JvmField val RELIC_GOLD = register("relic_gold", ::Item, VALUABLES)
    @JvmField val RELIC_COPPER = register("relic_copper", ::Item, VALUABLES)
    @JvmField val RELIC_BAND = register("relic_band", ::Item, VALUABLES)
    @JvmField val RELIC_SILVER = register("relic_silver", ::Item, VALUABLES)
    @JvmField val RELIC_STATUE = register("relic_statue", ::Item, VALUABLES)
    @JvmField val RELIC_VASE = register("relic_vase", ::Item, VALUABLES)
    @JvmField val RELIC_CROWN = register("relic_crown", ::Item, VALUABLES)
    @JvmField val HEART_SCALE = register("heart_scale", ::Item, VALUABLES)
    @JvmField val SHOAL_SHELL = register("shoal_shell", ::Item, VALUABLES)
    @JvmField val SHOAL_SALT = register("shoal_salt", ::Item, VALUABLES)
    @JvmField val STARDUST = register("stardust", ::Item, VALUABLES)
    @JvmField val RARE_BONE = register("rare_bone", ::Item, VALUABLES)
    @JvmField val SILVER_LEAF = register("silver_leaf", ::Item, VALUABLES)
    @JvmField val STRANGE_SOUVENIR = register("strange_souvenir", ::Item, VALUABLES)
    @JvmField val SLOWPOKE_TAIL = register("slowpoke_tail", ::Item, VALUABLES)
    @JvmField val ODD_KEYSTONE = register("odd_keystone", ::Item, VALUABLES)
    @JvmField val ESCAPE_ROPE = register("escape_rope", ::Item, VALUABLES)
    @JvmField val BEACH_GLASS = register("beach_glass", ::Item, VALUABLES)
    @JvmField val CHALKY_STONE = register("chalky_stone", ::Item, VALUABLES)
    @JvmField val LONE_EARRING = register("lone_earring", ::Item, VALUABLES)
    @JvmField val PRETTY_FEATHER = register("pretty_feather", ::Item, VALUABLES)
    @JvmField val MARBLE = register("marble", ::Item, VALUABLES)
    @JvmField val POLISHED_MUD_BALL = register("polished_mud_ball", ::Item, VALUABLES)
    @JvmField val STRETCHY_SPRING = register("stretchy_spring", ::Item, VALUABLES)
    @JvmField val TROPICAL_SHELL = register("tropical_shell", ::Item, VALUABLES)
    @JvmField val BALM_MUSHROOM = register("balm_mushroom", ::Item, VALUABLES)
    @JvmField val BIG_MUSHROOM = register("big_mushroom", ::Item, VALUABLES)
    @JvmField val BIG_NUGGET = register("big_nugget", ::Item, VALUABLES)
    @JvmField val BIG_PEARL = register("big_pearl", ::Item, VALUABLES)
    @JvmField val GOLD_LEAF = register("gold_leaf", ::Item, VALUABLES)
    @JvmField val SMALL_BOUQUET = register("small_bouquet", ::Item, VALUABLES)
    @JvmField val BLUE_SHARD = register("blue_shard", ::Item, VALUABLES)
    @JvmField val COMET_SHARD = register("comet_shard", ::Item, VALUABLES)
    @JvmField val GREEN_SHARD = register("green_shard", ::Item, VALUABLES)
    @JvmField val NUGGET = register("nugget", ::Item, VALUABLES)
    @JvmField val PEARL = register("pearl", ::Item, VALUABLES)
    @JvmField val PEARL_STRING = register("pearl_string", ::Item, VALUABLES)
    @JvmField val RED_SHARD = register("red_shard", ::Item, VALUABLES)
    @JvmField val STAR_PIECE = register("star_piece", ::Item, VALUABLES)
    @JvmField val TINY_MUSHROOM = register("tiny_mushroom", ::Item, VALUABLES)
    @JvmField val YELLOW_SHARD = register("yellow_shard", ::Item, VALUABLES)
    @JvmField val HONEY = register("honey", ::Item, VALUABLES)

    @JvmField val BUG_CANDY = register("bug_candy", ::Item, VALUABLES)
    @JvmField val DARK_CANDY = register("dark_candy", ::Item, VALUABLES)
    @JvmField val DRAGON_CANDY = register("dragon_candy", ::Item, VALUABLES)
    @JvmField val ELECTRIC_CANDY = register("electric_candy", ::Item, VALUABLES)
    @JvmField val FAIRY_CANDY = register("fairy_candy", ::Item, VALUABLES)
    @JvmField val FIGHTING_CANDY = register("fighting_candy", ::Item, VALUABLES)
    @JvmField val FIRE_CANDY = register("fire_candy", ::Item, VALUABLES)
    @JvmField val FLYING_CANDY = register("flying_candy", ::Item, VALUABLES)
    @JvmField val GHOST_CANDY = register("ghost_candy", ::Item, VALUABLES)
    @JvmField val GRASS_CANDY = register("grass_candy", ::Item, VALUABLES)
    @JvmField val GROUND_CANDY = register("ground_candy", ::Item, VALUABLES)
    @JvmField val ICE_CANDY = register("ice_candy", ::Item, VALUABLES)
    @JvmField val NORMAL_CANDY = register("normal_candy", ::Item, VALUABLES)
    @JvmField val POISON_CANDY = register("poison_candy", ::Item, VALUABLES)
    @JvmField val PSYCHIC_CANDY = register("psychic_candy", ::Item, VALUABLES)
    @JvmField val ROCK_CANDY = register("rock_candy", ::Item, VALUABLES)
    @JvmField val STEEL_CANDY = register("steel_candy", ::Item, VALUABLES)
    @JvmField val WATER_CANDY = register("water_candy", ::Item, VALUABLES)
    @JvmField val NULL_CANDY = register("null_candy", ::Item, VALUABLES)

    /**
     * Curry Ingredients
     */
    @JvmField val BACHS_FOOD_TIN = register("bachs_food_tin", { CurryIngredient(CurryType.Rich, it) }, CUISINE)
    @JvmField val BOBS_FOOD_TIN = register("bobs_food_tin", { CurryIngredient(CurryType.Juicy, it) }, CUISINE)
    @JvmField val BOILED_EGG = register("boiled_egg", { CurryIngredient(CurryType.BoiledEgg, it) }, CUISINE)
    @JvmField val BREAD = register("bread", { CurryIngredient(CurryType.Toast, it) }, CUISINE)
    @JvmField val BRITTLE_BONES = register("brittle_bones", { CurryIngredient(CurryType.Bone, it) }, CUISINE)
    @JvmField val COCONUT_MILK = register("coconut_milk", { CurryIngredient(CurryType.Coconut, it) }, CUISINE)
    @JvmField val FANCY_APPLE = register("fancy_apple", { CurryIngredient(CurryType.Apple, it) }, CUISINE)
    @JvmField val FRESH_CREAM = register("fresh_cream", { CurryIngredient(CurryType.WhippedCream, it) }, CUISINE)
    @JvmField val FRIED_FOOD = register("fried_food", { CurryIngredient(CurryType.FriedFood, it) }, CUISINE)
    @JvmField val FRUIT_BUNCH = register("fruit_bunch", { CurryIngredient(CurryType.Tropical, it) }, CUISINE)
    @JvmField val INSTANT_NOODLES = register("instant_noodles", { CurryIngredient(CurryType.InstantNoodle, it) }, CUISINE)
    @JvmField val LARGE_LEEK = register("large_leek", { CurryIngredient(CurryType.Leek, it) }, CUISINE)
    @JvmField val MIXED_MUSHROOMS = register("mixed_mushrooms", { CurryIngredient(CurryType.MushroomMedley, it) }, CUISINE)
    @JvmField val MOOMOO_CHEESE = register("moomoo_cheese", { CurryIngredient(CurryType.CheeseCovered, it) }, CUISINE)
    @JvmField val PACK_OF_POTATOES = register("pack_of_potatoes", { CurryIngredient(CurryType.PlentyOfPotato, it) }, CUISINE)
    @JvmField val PACKAGED_CURRY = register("packaged_curry", { CurryIngredient(CurryType.Decorative, it) }, CUISINE)
    @JvmField val PASTA = register("pasta", { CurryIngredient(CurryType.Pasta, it) }, CUISINE)
    @JvmField val PRECOOKED_BURGER = register("precooked_burger", { CurryIngredient(CurryType.BurgerSteak, it) }, CUISINE)
    @JvmField val PUNGENT_ROOT = register("pungent_root", { CurryIngredient(CurryType.HerbMedley, it) }, CUISINE)
    @JvmField val SALAD_MIX = register("salad_mix", { CurryIngredient(CurryType.Salad, it) }, CUISINE)
    @JvmField val SAUSAGES = register("sausages", { CurryIngredient(CurryType.Sausage, it) }, CUISINE)
    @JvmField val SMOKED_POKE_TAIL = register("smoked_poke_tail", { CurryIngredient(CurryType.SmokedTail, it) }, CUISINE)
    @JvmField val SPICE_MIX = register("spice_mix", { CurryIngredient(CurryType.Seasoned, it) }, CUISINE)
    @JvmField val TIN_OF_BEANS = register("tin_of_beans", { CurryIngredient(CurryType.BeanMedley, it) }, CUISINE)
    @JvmField val GIGANTAMIX = register("gigantamix", { CurryIngredient(CurryType.Gigantamax, it) }, CUISINE)

    /**
     * Player Consumables
     */
    @JvmField val KOMALA_COFFEE = register("komala_coffee", { Item(it.food(FoodProperties.Builder().nutrition(8).saturationMod(0.8f).alwaysEat().build())) }, CUISINE);
    @JvmField val OMELETTE = register("omelette", { Item(it.food(FoodProperties.Builder().nutrition(8).saturationMod(0.8f).alwaysEat().build())) }, CUISINE);
    @JvmField val PINAP_JUICE = register("pinap_juice", { Item(it.food(FoodProperties.Builder().nutrition(8).saturationMod(0.8f).alwaysEat().build())) }, CUISINE);
    @JvmField val ROSERADE_TEA = register("roserade_tea", { Item(it.food(FoodProperties.Builder().nutrition(8).saturationMod(0.8f).alwaysEat().build())) }, CUISINE);
    @JvmField val TAPU_COCOA = register("tapu_cocoa", { Item(it.food(FoodProperties.Builder().nutrition(8).saturationMod(0.8f).alwaysEat().build())) }, CUISINE);

    //Walkmons

    @JvmField val POKE_WALKMON = register("poke_walkmon", { WalkmonItem(it, 1, "poke_walkmon") }, PLAYER_ITEMS)
    @JvmField val GREAT_WALKMON = register("great_walkmon", { WalkmonItem(it, 2, "great_walkmon") }, PLAYER_ITEMS)
    @JvmField val ULTRA_WALKMON = register("ultra_walkmon", { WalkmonItem(it, 3, "ultra_walkmon") }, PLAYER_ITEMS)
    @JvmField val MASTER_WALKMON = register("master_walkmon", { WalkmonItem(it, 4, "master_walkmon") }, PLAYER_ITEMS)
    @JvmField val HI_TECH_EARBUDS = register("hi_tech_earbuds", { WalkmonItem(it, 4, "hi_tech_earbuds") }, PLAYER_ITEMS)
    @JvmField val GB_SOUNDS = register("gb_sounds", { WalkmonItem(it, 4, "hi_tech_earbuds") })

    //Discs

    @JvmField val AZALEA_TOWN_DISC = createMusicDisc("azalea_town_disc", GenerationsSounds.AZALEA_TOWN, 200)
    @JvmField val CASCARRAFA_CITY_DISC = createMusicDisc("cascarrafa_city_disc", GenerationsSounds.CASCARRAFA_CITY, 169)
    @JvmField val CERULEAN_CITY_DISC = createMusicDisc("cerulean_city_disc", GenerationsSounds.CERULEAN_CITY, 184)
    @JvmField val ETERNA_CITY_DISC = createMusicDisc("eterna_city_disc", GenerationsSounds.ETERNA_CITY, 136)
    @JvmField val GOLDENROD_CITY_DISC = createMusicDisc("goldenrod_city_disc", GenerationsSounds.GOLDENROD_CITY, 182)
    @JvmField val ICIRRUS_CITY_DISC = createMusicDisc("icirrus_city_disc", GenerationsSounds.ICIRRUS_CITY, 148)
    @JvmField val JUBILIFE_VILLAGE_DISC = createMusicDisc("jubilife_village_disc", GenerationsSounds.JUBILIFE_VILLAGE, 202)
    @JvmField val LAKE_OF_RAGE_DISC = createMusicDisc("lake_of_rage_disc", GenerationsSounds.LAKE_OF_RAGE, 139)
    @JvmField val LAVERRE_CITY_DISC = createMusicDisc("laverre_city_disc", GenerationsSounds.LAVERRE_CITY, 281)
    @JvmField val LILLIE_DISC = createMusicDisc("lillie_disc", GenerationsSounds.LILLIE, 312)
    @JvmField val POKEMON_CENTER_DISC = createMusicDisc("pokemon_center_disc", GenerationsSounds.POKEMON_CENTER, 240)
    @JvmField val ROUTE_228_DISC = createMusicDisc("route_228_disc", GenerationsSounds.ROUTE_228, 418)
    @JvmField val SLUMBERING_WEALD_DISC = createMusicDisc("slumbering_weald_disc", GenerationsSounds.SLUMBERING_WEALD, 262)
    @JvmField val SURF_DISC = createMusicDisc("surf_disc", GenerationsSounds.SURF, 261)
    @JvmField val VERMILION_CITY_DISC = createMusicDisc("vermilion_city_disc", GenerationsSounds.VERMILION_CITY, 216)
    @JvmField val CYNTHIA_DISC = createMusicDisc("cynthia_disc", GenerationsSounds.CYNTHIA, 385)
    @JvmField val DEOXYS_DISC = createMusicDisc("deoxys_disc", GenerationsSounds.DEOXYS, 414)
    @JvmField val IRIS_DISC = createMusicDisc("iris_disc", GenerationsSounds.IRIS, 291)
    @JvmField val KANTO_DISC = createMusicDisc("kanto_disc", GenerationsSounds.KANTO, 337)
    @JvmField val LUSAMINE_DISC = createMusicDisc("lusamine_disc", GenerationsSounds.LUSAMINE, 337)
    @JvmField val NEMONA_DISC = createMusicDisc("nemona_disc", GenerationsSounds.NEMONA, 158)
    @JvmField val NESSA_DISC = createMusicDisc("nessa_disc", GenerationsSounds.NESSA, 263)
    @JvmField val PENNY_DISC = createMusicDisc("penny_disc", GenerationsSounds.PENNY, 267)
    @JvmField val RIVAL_DISC = createMusicDisc("rival_disc", GenerationsSounds.RIVAL, 221)
    @JvmField val SADA_AND_TURO_DISC = createMusicDisc("sada_and_turo_disc", GenerationsSounds.SADA_AND_TURO, 349)
    @JvmField val SOUTH_PROVINCE_DISC = createMusicDisc("south_province_disc", GenerationsSounds.SOUTH_PROVINCE, 214)
    @JvmField val TEAM_ROCKET_DISC = createMusicDisc("team_rocket_disc", GenerationsSounds.TEAM_ROCKET, 186)
    @JvmField val ULTRA_NECROZMA_DISC = createMusicDisc("ultra_necrozma_disc", GenerationsSounds.ULTRA_NECROZMA, 296)
    @JvmField val XY_LEGENDARY_DISC = createMusicDisc("xy_legendary_disc", GenerationsSounds.XY_LEGENDARY, 261)
    @JvmField val ZINNIA_DISC = createMusicDisc("zinnia_disc", GenerationsSounds.ZINNIA, 320)
    @JvmField val LAVENDER_TOWN_DISC = createMusicDisc("lavender_town_disc", GenerationsSounds.LAVENDER_TOWN, 369)
    @JvmField val LUGIA_DISC = createMusicDisc("lugia_disc", GenerationsSounds.LUGIA, 341)
    @JvmField val MT_PYRE_DISC = createMusicDisc("mt_pyre_disc", GenerationsSounds.MT_PYRE, 219)

    /**
     * Un-Implemented Items : Items currently have no in-game function
     */
    @JvmField val ABILITY_URGE = register("ability_urge", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ADVENTURE_GUIDE = register("adventure_guide", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val APRICORN_BOX = register("apricorn_box", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val AQUA_SUIT = register("aqua_suit", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ARMOR_PASS = register("armor_pass", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ARMORITE_ORE = register("armorite_ore", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val AURORA_TICKET = register("aurora_ticket", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val AUTOGRAPH = register("autograph", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val AZURE_FLUTE = register("azure_flute", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val BAND_AUTOGRAPH = register("band_autograph", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val BASEMENT_KEY_1 = register("basement_key_1", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val BASEMENT_KEY_2 = register("basement_key_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val BERRY_PLANTER = register("berry_planter", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val BERRY_POUCH = register("berry_pouch", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val BIKE_VOUCHER = register("bike_voucher", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val BLUE_CARD = register("blue_card", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val BLUE_SCARF = register("blue_scarf", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val BLUE_SPHERE = register("blue_sphere", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val CAMPING_GEAR = register("camping_gear", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val CARD_KEY_1 = register("card_key_1", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val CARD_KEY_2 = register("card_key_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val CARROT_SEEDS = register("carrot_seeds", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val CLEAR_BELL = register("clear_bell", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val COIN = register("coin", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val COIN_CASE = register("coin_case", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val COLRESS_MACHINE = register("colress_machine", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val COMMON_STONE = register("common_stone", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val CONTEST_COSTUME_1 = register("contest_costume_1", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val CONTEST_COSTUME_2 = register("contest_costume_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val CONTEST_PASS = register("contest_pass", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val COUPON_1 = register("coupon_1", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val COUPON_2 = register("coupon_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val COUPON_3 = register("coupon_3", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val COURAGE_CANDY = register("courage_candy", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val COURAGE_CANDY_L = register("courage_candy_l", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val COURAGE_CANDY_XL = register("courage_candy_xl", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val CROWN_PASS = register("crown_pass", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val DATA_CARDS = register("data_cards", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val DEVON_PARTS = register("devon_parts", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val DEVON_SCOPE = register("devon_scope", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val DEVON_SCUBA_GEAR = register("devon_scuba_gear", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val DIRE_HIT_2 = register("dire_hit_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val DIRE_HIT_3 = register("dire_hit_3", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val DISCOUNT_COUPON = register("discount_coupon", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val DOWSING_MACHINE_1 = register("dowsing_machine_1", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val DOWSING_MACHINE_2 = register("dowsing_machine_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val DOWSING_MCHN = register("dowsing_mchn", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val DRAGON_SKULL = register("dragon_skull", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val DROPPED_ITEM_RED = register("dropped_item_red", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val DROPPED_ITEM_YELLOW = register("dropped_item_yellow", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ELEVATOR_KEY = register("elevator_key", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ENDORSEMENT = register("endorsement", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val EON_FLUTE = register("eon_flute", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val EON_TICKET = register("eon_ticket", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val EXPLORER_KIT = register("explorer_kit", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val FAME_CHECKER = register("fame_checker", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val FASHION_CASE = register("fashion_case", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val FESTIVAL_TICKET = register("festival_ticket", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val FORAGE_BAG = register("forage_bag", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val GALACTIC_KEY = register("galactic_key", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val GO_GOGGLES = register("go_goggles", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val GOLD_TEETH = register("gold_teeth", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val GOLDEN_NANAB_BERRY = register("golden_nanab_berry", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val GOLDEN_PINAP_BERRY = register("golden_pinap_berry", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val GOLDEN_RAZZ_BERRY = register("golden_razz_berry", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val GRAM = register("gram", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)

    @JvmField val GREEN_SCARF = register("green_scarf", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val GREEN_SPHERE = register("green_sphere", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val GREEN_TEA = register("green_tea", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val GRUBBY_HANKY = register("grubby_hanky", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val HEALTH_CANDY = register("health_candy", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val HEALTH_CANDY_L = register("health_candy_l", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val HEALTH_CANDY_XL = register("health_candy_xl", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val HOLO_CASTER_1 = register("holo_caster_1", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val HOLO_CASTER_2 = register("holo_caster_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val HONOR_OF_KALOS = register("honor_of_kalos", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val INTRIGUING_STONE = register("intriguing_stone", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ITEM_DROP = register("item_drop", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ITEM_URGE = register("item_urge", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val JOURNAL = register("journal", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val KEY_STONE_2 = register("key_stone_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val KEY_TO_ROOM_1 = register("key_to_room_1", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val KEY_TO_ROOM_2 = register("key_to_room_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val KEY_TO_ROOM_4 = register("key_to_room_4", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val KEY_TO_ROOM_6 = register("key_to_room_6", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val LEAF_LETTER = register("leaf_letter", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val LEGENDARY_CLUE = register("legendary_clue", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val LENS_CASE = register("lens_case", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val LETTER = register("letter", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val LIBERTY_PASS = register("liberty_pass", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val LIFT_KEY = register("lift_key", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val LOCK_CAPSULE_1 = register("lock_capsule_1", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val LOCK_CAPSULE_2 = register("lock_capsule_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val LOOKER_TICKET = register("looker_ticket", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val LOOT_SACK = register("loot_sack", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val LOST_ITEM_1 = register("lost_item_1", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val LOST_ITEM_2 = register("lost_item_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val LUNAR_FEATHER = register("lunar_feather", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val LURE = register("lure", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val MACHINE_PART = register("machine_part", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val MAGMA_EMBLEM = register("magma_emblem", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val MAGMA_SUIT = register("magma_suit", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val MAKEUP_BAG = register("makeup_bag", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val MAX_LURE = register("max_lure", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val MEDAL_BOX = register("medal_box", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val MEMBER_CARD = register("member_card", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val MIGHTY_CANDY = register("mighty_candy", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val MIGHTY_CANDY_L = register("mighty_candy_l", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val MIGHTY_CANDY_XL = register("mighty_candy_xl", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val MYSTIC_TICKET = register("mystic_ticket", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val OAKS_LETTER = register("oaks_letter", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val OAKS_PARCEL = register("oaks_parcel", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val OLD_CHARM = register("old_charm", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val OLD_LETTER = register("old_letter", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val OLD_SEA_MAP = register("old_sea_map", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val PAIR_OF_TICKETS = register("pair_of_tickets", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val PAL_PAD = register("pal_pad", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val PALE_SPHERE = register("pale_sphere", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val PASS = register("pass", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val PASS_ORB = register("pass_orb", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val PERMIT = register("permit", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val PEWTER_CRUNCHIES = register("pewter_crunchies", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val PINK_SCARF = register("pink_scarf", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val PLASMA_CARD = register("plasma_card", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val POFFIN = register("poffin", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val POFFIN_CASE = register("poffin_case", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val POINT_CARD = register("point_card", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val POKE_FLUTE = register("poke_flute", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val POKE_RADAR = register("poke_radar", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val POKEBLOCK_CASE = register("pokeblock_case", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val POKEBLOCK_KIT = register("pokeblock_kit", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val POKETCH_BLUE = register("poketch_blue", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val POKETCH_RED = register("poketch_red", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val POWDER_JAR = register("powder_jar", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val POWER_PLANT_PASS = register("power_plant_pass", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val PRISM_SPHERE = register("prism_sphere", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val PROFESSORS_MASK = register("professors_mask", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val PROFS_LETTER = register("profs_letter", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val PROP_CASE = register("prop_case", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val QUICK_CANDY = register("quick_candy", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val QUICK_CANDY_L = register("quick_candy_l", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val QUICK_CANDY_XL = register("quick_candy_xl", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)

    @JvmField val RAINBOW_FLOWER = register("rainbow_flower", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val RAINBOW_PASS = register("rainbow_pass", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)

    @JvmField val RED_SCALE = register("red_scale", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val RED_SPHERE = register("red_sphere", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val RESET_URGE = register("reset_urge", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val RIDE_PAGER = register("ride_pager", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ROLLER_SKATES = register("roller_skates", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ROTO_BARGAIN = register("roto_bargain", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ROTO_BOOST = register("roto_boost", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ROTO_CATCH = register("roto_catch", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ROTO_ENCOUNTER = register("roto_encounter", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ROTO_EXP_POINTS = register("roto_exp_points", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ROTO_FRIENDSHIP = register("roto_friendship", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ROTO_HATCH = register("roto_hatch", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ROTO_HP_RESTORE = register("roto_hp_restore", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ROTO_PP_RESTORE = register("roto_pp_restore", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ROTO_PRIZE_MONEY = register("roto_prize_money", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val ROTO_STEALTH = register("roto_stealth", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val RULE_BOOK = register("rule_book", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SCANNER = register("scanner", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SEAL_BAG = register("seal_bag", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SEAL_CASE = register("seal_case", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SECRET_KEY_1 = register("secret_key_1", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SECRET_KEY_2 = register("secret_key_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SECRET_MEDICINE = register("secret_medicine", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SILPH_SCOPE = register("silph_scope", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SILVER_NANAB_BERRY = register("silver_nanab_berry", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SILVER_PINAP_BERRY = register("silver_pinap_berry", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SILVER_RAZZ_BERRY = register("silver_razz_berry", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SINNOH_STONE = register("sinnoh_stone", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SMART_CANDY = register("smart_candy", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SMART_CANDY_L = register("smart_candy_l", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SMART_CANDY_XL = register("smart_candy_xl", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SONIAS_BOOK = register("sonias_book", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SOOT_SACK = register("soot_sack", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SS_TICKET = register("ss_ticket", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val STORAGE_KEY_1 = register("storage_key_1", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val STORAGE_KEY_2 = register("storage_key_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val STYLE_CARD = register("style_card", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SUITE_KEY = register("suite_key", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val SUPER_LURE = register("super_lure", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val TEACHY_TV = register("teachy_tv", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val TIDAL_BELL = register("tidal_bell", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val TM_CASE = register("tm_case", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val TM_MATERIAL = register("tm_material", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val TMV_PASS = register("tmv_pass", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val TOTEM_STICKER = register("totem_sticker", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val TOUGH_CANDY = register("tough_candy", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val TOUGH_CANDY_L = register("tough_candy_l", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val TOUGH_CANDY_XL = register("tough_candy_xl", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val TOWN_MAP_1 = register("town_map_1", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val TOWN_MAP_2 = register("town_map_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val TOWN_MAP_3 = register("town_map_3", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val TRAVEL_TRUNK_1 = register("travel_trunk_1", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val TRAVEL_TRUNK_2 = register("travel_trunk_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val TRI_PASS = register("tri_pass", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val UNOVA_STONE = register("unova_stone", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val UNOWN_REPORT = register("unown_report", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val VS_RECORDER = register("vs_recorder", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val VS_SEEKER = register("vs_seeker", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val WISHING_CHIP = register("wishing_chip", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val WISHING_PIECE = register("wishing_piece", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val WOODEN_CROWN = register("wooden_crown", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val WORKS_KEY = register("works_key", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_ACCURACY_2 = register("x_accuracy_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_ACCURACY_3 = register("x_accuracy_3", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_ACCURACY_6 = register("x_accuracy_6", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_ATTACK_2 = register("x_attack_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_ATTACK_3 = register("x_attack_3", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_ATTACK_6 = register("x_attack_6", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_DEFENSE_2 = register("x_defense_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_DEFENSE_3 = register("x_defense_3", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_DEFENSE_6 = register("x_defense_6", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_SPECIAL_ATTACK_2 = register("x_special_attack_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_SPECIAL_ATTACK_3 = register("x_special_attack_3", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_SPECIAL_ATTACK_6 = register("x_special_attack_6", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_SPECIAL_DEFENSE_2 = register("x_special_defense_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_SPECIAL_DEFENSE_3 = register("x_special_defense_3", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_SPECIAL_DEFENSE_6 = register("x_special_defense_6", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_SPEED_2 = register("x_speed_2", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_SPEED_3 = register("x_speed_3", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_SPEED_6 = register("x_speed_6", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_TRANSCEIVER_BLUE = register("x_transceiver_blue", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_TRANSCEIVER_RED = register("x_transceiver_red", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val X_TRANSCEIVER_YELLOW = register("x_transceiver_yellow", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val YELLOW_SCARF = register("yellow_scarf", { Item(it.stacksTo(1)) }, UNIMPLEMENTED)
    @JvmField val GALARICA_TWIG = register("galarica_twig", ::Item, UNIMPLEMENTED);

    /**
     * Items to be included in Minecraft Default Section.
     */

    @JvmField val CURRY = register("curry", ::ItemCurry, CUISINE);

    @JvmField val ULTRA_DARK_SIGN = registerSign("ultra_dark_sign") { SignItem(it.stacksTo(16), GenerationsWood.ULTRA_DARK_SIGN.get(), GenerationsWood.ULTRA_DARK_WALL_SIGN.get()) }
    @JvmField val ULTRA_DARK_HANGING_SIGN = registerSign("ultra_dark_hanging_sign") { HangingSignItem(GenerationsWood.ULTRA_DARK_HANGING_SIGN.get(), GenerationsWood.ULTRA_DARK_WALL_HANGING_SIGN.get(), it.stacksTo(16)) }
    @JvmField val ULTRA_JUNGLE_SIGN = registerSign("ultra_jungle_sign") { SignItem(it.stacksTo(16), GenerationsWood.ULTRA_JUNGLE_SIGN.get(), GenerationsWood.ULTRA_JUNGLE_WALL_SIGN.get()) }
    @JvmField val ULTRA_JUNGLE_HANGING_SIGN = registerSign("ultra_jungle_hanging_sign") { HangingSignItem(GenerationsWood.ULTRA_JUNGLE_HANGING_SIGN.get(), GenerationsWood.ULTRA_JUNGLE_WALL_HANGING_SIGN.get(), it.stacksTo(16)) }
    @JvmField val GHOST_SIGN = registerSign("ghost_sign") { SignItem(it.stacksTo(16), GenerationsWood.GHOST_SIGN.get(), GenerationsWood.GHOST_WALL_SIGN.get()) }
    @JvmField val GHOST_HANGING_SIGN = registerSign("ghost_hanging_sign") { HangingSignItem(GenerationsWood.GHOST_HANGING_SIGN.get(), GenerationsWood.GHOST_WALL_HANGING_SIGN.get(), it.stacksTo(16)) }

    @JvmField val GHOST_BOAT_ITEM = register("ghost_boat", { GenerationsBoatItem(it, GenerationsBoatEntity.Type.GHOST) }, BUILDING_BLOCKS);
    @JvmField val GHOST_CHEST_BOAT_ITEM = register("ghost_boat_with_chest", { GenerationsChestBoatItem(it, GenerationsBoatEntity.Type.GHOST) }, BUILDING_BLOCKS);
    @JvmField val ULTRA_DARK_BOAT_ITEM = register("ultra_dark_boat", { GenerationsBoatItem(it, GenerationsBoatEntity.Type.ULTRA_DARK) }, BUILDING_BLOCKS);
    @JvmField val ULTRA_DARK_CHEST_BOAT_ITEM = register("ultra_dark_boat_with_chest", { GenerationsChestBoatItem(it, GenerationsBoatEntity.Type.ULTRA_DARK) }, BUILDING_BLOCKS);
    @JvmField val ULTRA_JUNGLE_BOAT_ITEM = register("ultra_jungle_boat", { GenerationsBoatItem(it, GenerationsBoatEntity.Type.ULTRA_JUNGLE) }, BUILDING_BLOCKS);
    @JvmField val ULTRA_JUNGLE_CHEST_BOAT_ITEM = register("ultra_jungle_boat_with_chest", { GenerationsChestBoatItem(it, GenerationsBoatEntity.Type.ULTRA_JUNGLE) }, BUILDING_BLOCKS);

    private fun createRelicSong(inert: Boolean): RegistrySupplier<RelicSongItem> = register((if(inert) "inert_" else "") + "relic_song", { RelicSongItem(it.stacksTo(1), inert) }, LEGENDARY_ITEMS)

    private fun registerHeldItem(name: String): RegistrySupplier<Item> = register(name, { Item(it).also { CobblemonHeldItemManager.registerRemap(it, name.replace("_", "")) } }, HELD_ITEMS)

    fun of() : Item.Properties = Item.Properties()

    fun <T: Item> register(name: String, itemSupplier: Function<Item.Properties, T>, register: DeferredRegister<Item> = ITEMS): RegistrySupplier<T> = register.register(name) { itemSupplier.apply(of()) }

    fun <T: MoveTeachingItem> registerTm(name: String, itemSupplier: Function<Item.Properties, T>, register: DeferredRegister<Item> = ITEMS): RegistrySupplier<T> = register.register(name) { itemSupplier.apply(of()) }

    private fun registerSign(name: String, itemSupplier: Function<Item.Properties, Item>): RegistrySupplier<Item> = register(name, itemSupplier)

    private fun createBadge(id: String): RegistrySupplier<Item> = register(id + "_badge", ::BadgeItem, BADGES)

    private fun createRibbon(id: String): RegistrySupplier<Item> = register(id, ::RibbonItem, RIBBONS)

    private fun createMusicDisc(name: String, sound: RegistrySupplier<SoundEvent>, ticks: Int): RegistrySupplier<Item> = register(name, { ArchitecturyRecordItem(0, sound, it.`arch$tab`(CreativeModeTabs.TOOLS_AND_UTILITIES).stacksTo(1), ticks) }, PLAYER_ITEMS)

    private fun registerClosedMail(name: String, type: MailType): RegistrySupplier<ClosedMailItem> = register(name, type::createClosedMailItem, POKEMAIL)

    private fun registerMail(name: String, type: MailType): RegistrySupplier<MailItem> = register(name, type::createMailItem, POKEMAIL)

    private fun registerPlate(name: String, type: ElementalType): RegistrySupplier<FormChangingItem> = register(name, { FormChangingItem(it, "type", type.name) })


    @JvmStatic fun init() {
        GenerationsCore.LOGGER.info("Registering Generations Items");
        ITEMS.register();
        RIBBONS.register();
        BADGES.register();
        UNIMPLEMENTED.register();
        CUISINE.register();
        NATURAL.register();
        RESTORATION.register();
        PLAYER_ITEMS.register();
        HELD_ITEMS.register();
        POKEMAIL.register();
        LEGENDARY_ITEMS.register();
        UTILITY.register();
        VALUABLES.register();
        FORM_ITEMS.register();
        BUILDING_BLOCKS.register();
    }
}
