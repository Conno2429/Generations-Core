package generations.gg.generations.core.generationscore.forge.datagen.generators.items;

import generations.gg.generations.core.generationscore.common.GenerationsCore;
import generations.gg.generations.core.generationscore.common.world.GenerationsPokeBalls;
import generations.gg.generations.core.generationscore.common.world.item.GenerationsArmor;
import generations.gg.generations.core.generationscore.common.world.item.GenerationsItems;
import generations.gg.generations.core.generationscore.common.world.item.GenerationsTools;
import generations.gg.generations.core.generationscore.common.world.item.curry.CurryType;
import generations.gg.generations.core.generationscore.common.world.level.block.*;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.BiConsumer;

public class ItemDatagen extends ItemModelProvider {

    public ItemDatagen(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, GenerationsCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
//        createItem(GenerationsItems.HP_UP.get(), "restoration/");
//        createItem(GenerationsItems.PROTEIN.get(), "restoration/");
//        createItem(GenerationsItems.IRON.get(), "restoration/");
//        createItem(GenerationsItems.CALCIUM.get(), "restoration/");
//        createItem(GenerationsItems.ZINC.get(), "restoration/");
//        createItem(GenerationsItems.CARBOS.get(), "restoration/");
        createItem(GenerationsItems.PURPLE_JUICE.get(), "restoration/");
        createItem(GenerationsItems.RED_JUICE.get(), "restoration/");
        createItem(GenerationsItems.YELLOW_JUICE.get(), "restoration/");
        createItem(GenerationsItems.BLUE_JUICE.get(), "restoration/");
        createItem(GenerationsItems.GREEN_JUICE.get(), "restoration/");
        createItem(GenerationsItems.PINK_JUICE.get(), "restoration/");
        createItem(GenerationsItems.COLORFUL_SHAKE.get(), "restoration/");
        createItem(GenerationsItems.PERILOUS_SOUP.get(), "restoration/");
        createItem(GenerationsItems.RARE_SODA.get(), "restoration/");
        createItem(GenerationsItems.ULTRA_RARE_SODA.get(), "restoration/");
        createItem(GenerationsItems.FRESH_WATER.get(), "restoration/");
        createItem(GenerationsItems.SODA_POP.get(), "restoration/");
        createItem(GenerationsItems.LEMONADE.get(), "restoration/");
        createItem(GenerationsItems.MOOMOO_MILK.get(), "restoration/");
        createItem(GenerationsItems.LUMIOSE_GALETTE.get(), "restoration/");
        createItem(GenerationsItems.SHALOUR_SABLE.get(), "restoration/");
        createItem(GenerationsItems.CASTELIACONE.get(), "restoration/");
        createItem(GenerationsItems.OLD_GATEAU.get(), "restoration/");
        createItem(GenerationsItems.BIG_MALASADA.get(), "restoration/");
        createItem(GenerationsItems.LAVA_COOKIE.get(), "restoration/");
        createItem(GenerationsItems.RAGE_CANDY_BAR.get(), "restoration/");
        createItem(GenerationsItems.BLUE_FLUTE.get(), "restoration/");
        createItem(GenerationsItems.RED_FLUTE.get(), "restoration/");
        createItem(GenerationsItems.YELLOW_FLUTE.get(), "restoration/");
        createItem(GenerationsItems.ENERGY_POWDER.get(), "restoration/");
        createItem(GenerationsItems.SWEET_HEART.get(), "restoration/");
        createItem(GenerationsItems.BASIC_SWEET_POKE_PUFF.get(), "restoration/");
        createItem(GenerationsItems.BASIC_CITRUS_POKE_PUFF.get(), "restoration/");
        createItem(GenerationsItems.BASIC_MINT_POKE_PUFF.get(), "restoration/");
        createItem(GenerationsItems.BASIC_MOCHA_POKE_PUFF.get(), "restoration/");
        createItem(GenerationsItems.BASIC_SPICE_POKE_PUFF.get(), "restoration/");

        createItem(GenerationsItems.DYNAMAX_CANDY.get(), "restoration/");
        createItem(GenerationsItems.MAX_HONEY.get(), "restoration/");
        createItem(GenerationsItems.MAX_MUSHROOMS.get(), "restoration/");
        createItem(GenerationsItems.MAX_POWDER.get(), "restoration/");
        createItem(GenerationsItems.MAX_SOUP.get(), "restoration/");

        createItem(GenerationsItems.Z_INGOT.get(), "ingots/");
        createItem(GenerationsItems.DYNITE_ORE.get(), "ingots/");
        createItem(GenerationsItems.MEGASTONE_SHARD.get(), "ingots/");
        createItem(GenerationsItems.COPPER_PLATE.get(), "materials/");

        createItem(GenerationsItems.KOMALA_COFFEE.get(), "consumable/");
        createItem(GenerationsItems.OMELETTE.get(), "consumable/");
        createItem(GenerationsItems.PINAP_JUICE.get(), "consumable/");
        createItem(GenerationsItems.ROSERADE_TEA.get(), "consumable/");
        createItem(GenerationsItems.TAPU_COCOA.get(), "consumable/");

        createHeldItem(GenerationsItems.ADRENALINE_ORB.get());
        createHeldItem(GenerationsItems.AMULET_COIN.get());
        createHeldItem(GenerationsItems.BLACK_FLUTE.get());
        createHeldItem(GenerationsItems.EXP_ALL.get());
        createHeldItem(GenerationsItems.FLUFFY_TAIL.get());
        createHeldItem(GenerationsItems.GRIP_CLAW.get());
        createHeldItem(GenerationsItems.LAGGING_TAIL.get());
        createHeldItem(GenerationsItems.LEEK.get());
        createHeldItem(GenerationsItems.LUCKY_PUNCH.get());
        createHeldItem(GenerationsItems.LUMINOUS_MOSS.get());
        createHeldItem(GenerationsItems.MACHO_BRACE.get());
        createHeldItem(GenerationsItems.METRONOME.get());
        createHeldItem(GenerationsItems.POKE_DOLL.get());
        createHeldItem(GenerationsItems.POKE_TOY.get());
        createHeldItem(GenerationsItems.PROTECTIVE_PADS.get());
        createHeldItem(GenerationsItems.ROOM_SERVICE.get());
        createHeldItem(GenerationsItems.SCOPE_LENS.get());
        createHeldItem(GenerationsItems.SHED_SHELL.get());
        createHeldItem(GenerationsItems.SNOWBALL.get());
        createHeldItem(GenerationsItems.SOUL_DEW.get());
        createHeldItem(GenerationsItems.TERRAIN_EXTENDER.get());
        createHeldItem(GenerationsItems.THICK_CLUB.get());
        createHeldItem(GenerationsItems.THROAT_SPRAY.get());
        createHeldItem(GenerationsItems.UP_GRADE.get());
        createHeldItem(GenerationsItems.UTILITY_UMBRELLA.get());
        createHeldItem(GenerationsItems.WHITE_FLUTE.get());
        createHeldItem(GenerationsItems.WIDE_LENS.get());
        createHeldItem(GenerationsItems.ZOOM_LENS.get());

        createHeldItem(GenerationsItems.BURN_DRIVE.get(), "drives/");
        createHeldItem(GenerationsItems.CHILL_DRIVE.get(), "drives/");
        createHeldItem(GenerationsItems.DOUSE_DRIVE.get(), "drives/");
        createHeldItem(GenerationsItems.SHOCK_DRIVE.get(), "drives/");

        createHeldItem(GenerationsItems.FULL_INCENSE.get(), "incense/");
        createHeldItem(GenerationsItems.LAX_INCENSE.get(), "incense/");
        createHeldItem(GenerationsItems.LUCK_INCENSE.get(), "incense/");
        createHeldItem(GenerationsItems.ODD_INCENSE.get(), "incense/");
        createHeldItem(GenerationsItems.PURE_INCENSE.get(), "incense/");
        createHeldItem(GenerationsItems.ROCK_INCENSE.get(), "incense/");
        createHeldItem(GenerationsItems.ROSE_INCENSE.get(), "incense/");
        createHeldItem(GenerationsItems.SEA_INCENSE.get(), "incense/");
        createHeldItem(GenerationsItems.WAVE_INCENSE.get(), "incense/");

        createHeldItem(GenerationsItems.ABOMASITE.get(), "megastones/");
        createHeldItem(GenerationsItems.ABSOLITE.get(), "megastones/");
        createHeldItem(GenerationsItems.AERODACTYLITE.get(), "megastones/");
        createHeldItem(GenerationsItems.AGGRONITE.get(), "megastones/");
        createHeldItem(GenerationsItems.ALAKAZITE.get(), "megastones/");
        createHeldItem(GenerationsItems.ALTARIANITE.get(), "megastones/");
        createHeldItem(GenerationsItems.AMPHAROSITE.get(), "megastones/");
        createHeldItem(GenerationsItems.AUDINITE.get(), "megastones/");
        createHeldItem(GenerationsItems.BANETTITE.get(), "megastones/");
        createHeldItem(GenerationsItems.BEEDRILLITE.get(), "megastones/");
        createHeldItem(GenerationsItems.BLASTOISINITE.get(), "megastones/");
        createHeldItem(GenerationsItems.BLAZIKENITE.get(), "megastones/");
        createHeldItem(GenerationsItems.CAMERUPTITE.get(), "megastones/");
        createHeldItem(GenerationsItems.CHARIZARDITE_X.get(), "megastones/");
        createHeldItem(GenerationsItems.CHARIZARDITE_Y.get(), "megastones/");
        createHeldItem(GenerationsItems.DIANCITE.get(), "megastones/");
        createHeldItem(GenerationsItems.GALLADITE.get(), "megastones/");
        createHeldItem(GenerationsItems.GARCHOMPITE.get(), "megastones/");
        createHeldItem(GenerationsItems.GARDEVOIRITE.get(), "megastones/");
        createHeldItem(GenerationsItems.GENGARITE.get(), "megastones/");
        createHeldItem(GenerationsItems.GLALITITE.get(), "megastones/");
        createHeldItem(GenerationsItems.GYARADOSITE.get(), "megastones/");
        createHeldItem(GenerationsItems.HERACRONITE.get(), "megastones/");
        createHeldItem(GenerationsItems.HOUNDOOMINITE.get(), "megastones/");
        createHeldItem(GenerationsItems.KANGASKHANITE.get(), "megastones/");
        createHeldItem(GenerationsItems.LATIASITE.get(), "megastones/");
        createHeldItem(GenerationsItems.LATIOSITE.get(), "megastones/");
        createHeldItem(GenerationsItems.LOPUNNNITE.get(), "megastones/");
        createHeldItem(GenerationsItems.LUCARIONITE.get(), "megastones/");
        createHeldItem(GenerationsItems.MANECTITE.get(), "megastones/");
        createHeldItem(GenerationsItems.MAWILITE.get(), "megastones/");
        createHeldItem(GenerationsItems.MEDICHAMITE.get(), "megastones/");
        createHeldItem(GenerationsItems.METAGROSSITE.get(), "megastones/");
        createHeldItem(GenerationsItems.MEWTWONITE_X.get(), "megastones/");
        createHeldItem(GenerationsItems.MEWTWONITE_Y.get(), "megastones/");
        createHeldItem(GenerationsItems.PIDGEOTITE.get(), "megastones/");
        createHeldItem(GenerationsItems.PINSIRITE.get(), "megastones/");
        createHeldItem(GenerationsItems.SABLENITE.get(), "megastones/");
        createHeldItem(GenerationsItems.SALAMENCITE.get(), "megastones/");
        createHeldItem(GenerationsItems.SCEPTILITE.get(), "megastones/");
        createHeldItem(GenerationsItems.SCIZORITE.get(), "megastones/");
        createHeldItem(GenerationsItems.SHARPEDONITE.get(), "megastones/");
        createHeldItem(GenerationsItems.SLOWBRONITE.get(), "megastones/");
        createHeldItem(GenerationsItems.STEELIXITE.get(), "megastones/");
        createHeldItem(GenerationsItems.SWAMPERTITE.get(), "megastones/");
        createHeldItem(GenerationsItems.TYRANITARITE.get(), "megastones/");
        createHeldItem(GenerationsItems.VENUSAURITE.get(), "megastones/");

        createHeldItem(GenerationsItems.BUG_MEMORY_DRIVE.get(), "memory/");
        createHeldItem(GenerationsItems.DARK_MEMORY_DRIVE.get(), "memory/");
        createHeldItem(GenerationsItems.DRAGON_MEMORY_DRIVE.get(), "memory/");
        createHeldItem(GenerationsItems.ELECTRIC_MEMORY_DRIVE.get(), "memory/");
        createHeldItem(GenerationsItems.FAIRY_MEMORY_DRIVE.get(), "memory/");
        createHeldItem(GenerationsItems.FIGHTING_MEMORY_DRIVE.get(), "memory/");
        createHeldItem(GenerationsItems.FIRE_MEMORY_DRIVE.get(), "memory/");
        createHeldItem(GenerationsItems.FLYING_MEMORY_DRIVE.get(), "memory/");
        createHeldItem(GenerationsItems.GHOST_MEMORY_DRIVE.get(), "memory/");
        createHeldItem(GenerationsItems.GRASS_MEMORY_DRIVE.get(), "memory/");
        createHeldItem(GenerationsItems.GROUND_MEMORY_DRIVE.get(), "memory/");
        createHeldItem(GenerationsItems.ICE_MEMORY_DRIVE.get(), "memory/");
        createHeldItem(GenerationsItems.POISON_MEMORY_DRIVE.get(), "memory/");
        createHeldItem(GenerationsItems.PSYCHIC_MEMORY_DRIVE.get(), "memory/");
        createHeldItem(GenerationsItems.ROCK_MEMORY_DRIVE.get(), "memory/");
        createHeldItem(GenerationsItems.STEEL_MEMORY_DRIVE.get(), "memory/");
        createHeldItem(GenerationsItems.WATER_MEMORY_DRIVE.get(), "memory/");

        createHeldItem(GenerationsItems.DRACO_PLATE.get(), "plates/");
        createHeldItem(GenerationsItems.DREAD_PLATE.get(), "plates/");
        createHeldItem(GenerationsItems.EARTH_PLATE.get(), "plates/");
        createHeldItem(GenerationsItems.FIST_PLATE.get(), "plates/");
        createHeldItem(GenerationsItems.FLAME_PLATE.get(), "plates/");
        createHeldItem(GenerationsItems.ICICLE_PLATE.get(), "plates/");
        createHeldItem(GenerationsItems.INSECT_PLATE.get(), "plates/");
        createHeldItem(GenerationsItems.IRON_PLATE.get(), "plates/");
        createHeldItem(GenerationsItems.MEADOW_PLATE.get(), "plates/");
        createHeldItem(GenerationsItems.MIND_PLATE.get(), "plates/");
        createHeldItem(GenerationsItems.PIXIE_PLATE.get(), "plates/");
        createHeldItem(GenerationsItems.SKY_PLATE.get(), "plates/");
        createHeldItem(GenerationsItems.SPLASH_PLATE.get(), "plates/");
        createHeldItem(GenerationsItems.SPOOKY_PLATE.get(), "plates/");
        createHeldItem(GenerationsItems.STONE_PLATE.get(), "plates/");
        createHeldItem(GenerationsItems.TOXIC_PLATE.get(), "plates/");
        createHeldItem(GenerationsItems.ZAP_PLATE.get(), "plates/");

        createHeldItem(GenerationsItems.BUGINIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.DARKINIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.DRAGONIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.ELECTRIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.FAIRIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.FIGHTINIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.FIRIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.FLYINIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.GHOSTIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.GRASSIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.GROUNDIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.ICIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.NORMALIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.POISONIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.PSYCHIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.ROCKIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.STEELIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.WATERIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.ALORAICHIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.DECIDIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.EEVIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.INCINIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.KOMMONIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.LUNALIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.LYCANIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.MARSHADIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.MEWNIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.MIMIKIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.PIKANIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.PIKASHUNIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.PRIMARIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.SNORLIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.SOLGANIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.TAPUNIUM_Z.get(), "zcrystals/");
        createHeldItem(GenerationsItems.ULTRANECROZIUM_Z.get(), "zcrystals/");

        createHeldItem(GenerationsItems.ELECTRIC_SEED.get());
        createHeldItem(GenerationsItems.MISTY_SEED.get());
        createHeldItem(GenerationsItems.GRASSY_SEED.get());
        createHeldItem(GenerationsItems.PSYCHIC_SEED.get());
        createHeldItem(GenerationsItems.RED_SCARF.get());

        createHeldItem(GenerationsItems.PUNCHING_GLOVE.get());
        createHeldItem(GenerationsItems.CLEAR_AMULET.get());
        createHeldItem(GenerationsItems.BOOSTER_ENERGY.get());
        createHeldItem(GenerationsItems.FAIRY_FEATHER.get());

        GenerationsPokeDolls.POKEDOLLS.forEach(ball -> createPokedoll(ball.get()));

        createItem(GenerationsItems.RELIC_GOLD.get(), "valuables/");
        createItem(GenerationsItems.RELIC_COPPER.get(), "valuables/");
        createItem(GenerationsItems.RELIC_BAND.get(), "valuables/");
        createItem(GenerationsItems.RELIC_SILVER.get(), "valuables/");
        createItem(GenerationsItems.RELIC_STATUE.get(), "valuables/");
        createItem(GenerationsItems.RELIC_VASE.get(), "valuables/");
        createItem(GenerationsItems.RELIC_CROWN.get(), "valuables/");
        createItem(GenerationsItems.HEART_SCALE.get(), "valuables/");
        createItem(GenerationsItems.SHOAL_SHELL.get(), "valuables/");
        createItem(GenerationsItems.SHOAL_SALT.get(), "valuables/");
        createItem(GenerationsItems.STARDUST.get(), "valuables/");
        createItem(GenerationsItems.RARE_BONE.get(), "valuables/");
        createItem(GenerationsItems.SILVER_LEAF.get(), "valuables/");
        createItem(GenerationsItems.STRANGE_SOUVENIR.get(), "valuables/");
        createItem(GenerationsItems.SLOWPOKE_TAIL.get(), "valuables/");
        createItem(GenerationsItems.ODD_KEYSTONE.get(), "valuables/");
        createItem(GenerationsItems.ESCAPE_ROPE.get(), "valuables/");
        createItem(GenerationsItems.BEACH_GLASS.get(), "valuables/");
        createItem(GenerationsItems.CHALKY_STONE.get(), "valuables/");
        createItem(GenerationsItems.LONE_EARRING.get(), "valuables/");
        createItem(GenerationsItems.PRETTY_FEATHER.get(), "valuables/");
        createItem(GenerationsItems.MARBLE.get(), "valuables/");
        createItem(GenerationsItems.POLISHED_MUD_BALL.get(), "valuables/");
        createItem(GenerationsItems.STRETCHY_SPRING.get(), "valuables/");
        createItem(GenerationsItems.TROPICAL_SHELL.get(), "valuables/");
        createItem(GenerationsItems.BALM_MUSHROOM.get(), "valuables/");
        createItem(GenerationsItems.BIG_MUSHROOM.get(), "valuables/");
        createItem(GenerationsItems.BIG_NUGGET.get(), "valuables/");
        createItem(GenerationsItems.BIG_PEARL.get(), "valuables/");
        createItem(GenerationsItems.GOLD_LEAF.get(), "valuables/");
        createItem(GenerationsItems.SMALL_BOUQUET.get(), "valuables/");
        createItem(GenerationsItems.BLUE_SHARD.get(), "valuables/");
        createItem(GenerationsItems.COMET_SHARD.get(), "valuables/");
        createItem(GenerationsItems.GREEN_SHARD.get(), "valuables/");
        createItem(GenerationsItems.NUGGET.get(), "valuables/");
        createItem(GenerationsItems.PEARL.get(), "valuables/");
        createItem(GenerationsItems.PEARL_STRING.get(), "valuables/");
        createItem(GenerationsItems.RED_SHARD.get(), "valuables/");
        createItem(GenerationsItems.STAR_PIECE.get(), "valuables/");
        createItem(GenerationsItems.TINY_MUSHROOM.get(), "valuables/");
        createItem(GenerationsItems.YELLOW_SHARD.get(), "valuables/");
        createItem(GenerationsItems.HONEY.get(), "valuables/");
        createItem(GenerationsItems.BUG_CANDY.get(), "valuables/");
        createItem(GenerationsItems.DARK_CANDY.get(), "valuables/");
        createItem(GenerationsItems.DRAGON_CANDY.get(), "valuables/");
        createItem(GenerationsItems.ELECTRIC_CANDY.get(), "valuables/");
        createItem(GenerationsItems.FAIRY_CANDY.get(), "valuables/");
        createItem(GenerationsItems.FIGHTING_CANDY.get(), "valuables/");
        createItem(GenerationsItems.FIRE_CANDY.get(), "valuables/");
        createItem(GenerationsItems.FLYING_CANDY.get(), "valuables/");
        createItem(GenerationsItems.GHOST_CANDY.get(), "valuables/");
        createItem(GenerationsItems.GRASS_CANDY.get(), "valuables/");
        createItem(GenerationsItems.GROUND_CANDY.get(), "valuables/");
        createItem(GenerationsItems.ICE_CANDY.get(), "valuables/");
        createItem(GenerationsItems.NORMAL_CANDY.get(), "valuables/");
        createItem(GenerationsItems.POISON_CANDY.get(), "valuables/");
        createItem(GenerationsItems.PSYCHIC_CANDY.get(), "valuables/");
        createItem(GenerationsItems.ROCK_CANDY.get(), "valuables/");
        createItem(GenerationsItems.STEEL_CANDY.get(), "valuables/");
        createItem(GenerationsItems.WATER_CANDY.get(), "valuables/");
        createItem(GenerationsItems.NULL_CANDY.get(), "valuables/");

        GenerationsItems.BADGES.forEach(badge -> createItem(badge.get(), "badges/"));
        GenerationsItems.RIBBONS.forEach(ribbon -> createItem(ribbon.get(), "ribbons/"));

        createItem(GenerationsItems.CRYSTAL.get(), "natural/");
        createItem(GenerationsItems.RUBY.get(), "natural/");
        createItem(GenerationsItems.SAPPHIRE.get(), "natural/");
        createItem(GenerationsItems.SILICON.get(), "natural/");

        GenerationsArmor.ARMOR.forEach(armor -> createItem(armor.get(), "armor/"));
        GenerationsTools.TOOLS.forEach(tool -> handheldItem(tool.get()));

        createItem(GenerationsItems.MARK_CHARM.get(), "player_items/");
        createItem(GenerationsItems.CATCHING_CHARM.get(), "player_items/");
        createItem(GenerationsItems.EXP_CHARM.get(), "player_items/");
        createItem(GenerationsItems.OLD_ROD.get(), "player_items/");
        createItem(GenerationsItems.GOOD_ROD.get(), "player_items/");
        createItem(GenerationsItems.SUPER_ROD.get(), "player_items/");
        createItem(GenerationsItems.RUBY_ROD.get(), "player_items/");
        createItem(GenerationsItems.CAMERA.get(), "player_items/");
        createItem(GenerationsItems.SNAP_CAMERA.get(), "player_items/");
        createItem(GenerationsItems.FILM.get(), "player_items/");
        createItem(GenerationsItems.REPEL.get(), "player_items/");
        createItem(GenerationsItems.SUPER_REPEL.get(), "player_items/");
        createItem(GenerationsItems.MAX_REPEL.get(), "player_items/");
        createItem(GenerationsItems.WAILMER_PAIL.get(), "player_items/");
        createItem(GenerationsItems.SPRINK_LOTAD.get(), "player_items/");
        createItem(GenerationsItems.SPRAYDUCK.get(), "player_items/");
        createItem(GenerationsItems.SQUIRT_BOTTLE.get(), "player_items/");
        createItem(GenerationsItems.MEGA_BRACELET.get(), "player_items/");
        createItem(GenerationsItems.MEGA_CHARM.get(), "player_items/");
        createItem(GenerationsItems.MEGA_CUFF.get(), "player_items/");
        createItem(GenerationsItems.MEGA_RING.get(), "player_items/");
        createItem(GenerationsItems.KEY_STONE.get(), "player_items/");
        createItem(GenerationsItems.Z_POWER_RING.get(), "player_items/");
        createItem(GenerationsItems.Z_RING.get(), "player_items/");

        /*
        createItem(GenerationsItems.RED_BIKE.get(), "player_items/");
        createItem(GenerationsItems.ORANGE_BIKE.get(), "player_items/");
        createItem(GenerationsItems.YELLOW_BIKE.get(), "player_items/");
        createItem(GenerationsItems.GREEN_BIKE.get(), "player_items/");
        createItem(GenerationsItems.BLUE_BIKE.get(), "player_items/");
        createItem(GenerationsItems.PURPLE_BIKE.get(), "player_items/");

         */
        createItem(GenerationsItems.ROTOM_CATALOG.get(), "player_items/");
        createItem(GenerationsItems.POKEDEX.get(), "player_items/");
        createItem(GenerationsItems.LURE_MODULE.get(), "player_items/");
        createItem(GenerationsItems.BOTTLE_CAP.get(), "player_items/");
        createItem(GenerationsItems.GOLD_BOTTLE_CAP.get(), "player_items/");
        createItem(GenerationsItems.WISHING_STAR.get(), "player_items/");
        createItem(GenerationsItems.DYNAMAX_BAND.get(), "player_items/");


        createItem(GenerationsItems.ORB.get(), "legend_items/");
        createItem(GenerationsItems.ADAMANT_ORB.get(), "legend_items/");
        createItem(GenerationsItems.GRISEOUS_ORB.get(), "legend_items/");
        createItem(GenerationsItems.LUSTROUS_ORB.get(), "legend_items/");
        createItem(GenerationsItems.SHATTERED_ICE_KEY_1.get(), "legend_items/");
        createItem(GenerationsItems.SHATTERED_ICE_KEY_2.get(), "legend_items/");
        createItem(GenerationsItems.SHATTERED_ICE_KEY_3.get(), "legend_items/");
        createItem(GenerationsItems.SHATTERED_ICE_KEY_4.get(), "legend_items/");
        createItem(GenerationsItems.ICEBERG_KEY.get(), "legend_items/");
        createItem(GenerationsItems.CRUMBLED_ROCK_KEY_1.get(), "legend_items/");
        createItem(GenerationsItems.CRUMBLED_ROCK_KEY_2.get(), "legend_items/");
        createItem(GenerationsItems.CRUMBLED_ROCK_KEY_3.get(), "legend_items/");
        createItem(GenerationsItems.CRUMBLED_ROCK_KEY_4.get(), "legend_items/");
        createItem(GenerationsItems.ROCK_PEAK_KEY.get(), "legend_items/");
        createItem(GenerationsItems.RUSTY_IRON_KEY_1.get(), "legend_items/");
        createItem(GenerationsItems.RUSTY_IRON_KEY_2.get(), "legend_items/");
        createItem(GenerationsItems.RUSTY_IRON_KEY_3.get(), "legend_items/");
        createItem(GenerationsItems.RUSTY_IRON_KEY_4.get(), "legend_items/");
        createItem(GenerationsItems.IRON_KEY.get(), "legend_items/");
        createItem(GenerationsItems.FRAGMENTED_DRAGO_KEY_1.get(), "legend_items/");
        createItem(GenerationsItems.FRAGMENTED_DRAGO_KEY_2.get(), "legend_items/");
        createItem(GenerationsItems.FRAGMENTED_DRAGO_KEY_3.get(), "legend_items/");
        createItem(GenerationsItems.FRAGMENTED_DRAGO_KEY_4.get(), "legend_items/");
        createItem(GenerationsItems.DRAGO_KEY.get(), "legend_items/");
        createItem(GenerationsItems.DISCHARGED_ELEKI_KEY_1.get(), "legend_items/");
        createItem(GenerationsItems.DISCHARGED_ELEKI_KEY_2.get(), "legend_items/");
        createItem(GenerationsItems.DISCHARGED_ELEKI_KEY_3.get(), "legend_items/");
        createItem(GenerationsItems.DISCHARGED_ELEKI_KEY_4.get(), "legend_items/");
        createItem(GenerationsItems.ELEKI_KEY.get(), "legend_items/");
        createItem(GenerationsItems.SHATTERED_RELIC_SONG_1.get(), "legend_items/");
        createItem(GenerationsItems.SHATTERED_RELIC_SONG_2.get(), "legend_items/");
        createItem(GenerationsItems.SHATTERED_RELIC_SONG_3.get(), "legend_items/");
        createItem(GenerationsItems.SHATTERED_RELIC_SONG_4.get(), "legend_items/");
        createItem(GenerationsItems.RELIC_SONG.get(), "legend_items/");
        createItem(GenerationsItems.RED_CHAIN.get(), "legend_items/");
        createItem(GenerationsItems.DNA_SPLICERS.get(), "legend_items/");
        createItem(GenerationsItems.REINS_OF_UNITY.get(), "legend_items/");
        createItem(GenerationsItems.N_SOLARIZER.get(), "legend_items/");
        createItem(GenerationsItems.N_LUNARIZER.get(), "legend_items/");
        createItem(GenerationsItems.LEGEND_FINDER.get(), "legend_items/");
        createItem(GenerationsItems.HOOPA_RING.get(), "legend_items/");
        createItem(GenerationsItems.FADED_RED_ORB.get(), "legend_items/");
        createItem(GenerationsItems.RED_ORB.get(), "legend_items/");
        createItem(GenerationsItems.FADED_BLUE_ORB.get(), "legend_items/");
        createItem(GenerationsItems.BLUE_ORB.get(), "legend_items/");
        createItem(GenerationsItems.JADE_ORB.get(), "legend_items/");
        createItem(GenerationsItems.LIGHT_STONE.get(), "legend_items/");
        createItem(GenerationsItems.DARK_STONE.get(), "legend_items/");
        createItem(GenerationsItems.DRAGON_STONE.get(), "legend_items/");
        createItem(GenerationsItems.DARK_SOUL.get(), "legend_items/");
        createItem(GenerationsItems.DRAGON_SOUL.get(), "legend_items/");
//        createItem(GenerationsItems.MELODY_FLUTE.get(), "legend_items/");
        createItem(GenerationsItems.SPARKLING_SHARD.get(), "legend_items/");
        createItem(GenerationsItems.SPARKLING_STONE.get(), "legend_items/");
        createItem(GenerationsItems.RUSTY_FRAGMENT.get(), "legend_items/");
        createItem(GenerationsItems.RUSTY_SWORD.get(), "legend_items/");
        createItem(GenerationsItems.CROWNED_SWORD.get(), "legend_items/");
        createItem(GenerationsItems.RUSTY_SHIELD.get(), "legend_items/");
        createItem(GenerationsItems.CROWNED_SHIELD.get(), "legend_items/");
        createItem(GenerationsItems.SCROLL_PAGE.get(), "legend_items/");
        createItem(GenerationsItems.SECRET_ARMOR_SCROLL.get(), "legend_items/");
        createItem(GenerationsItems.ZYGARDE_CUBE.get(), "legend_items/");
        createItem(GenerationsItems.MELTAN_BOX.get(), "legend_items/");
        createItem(GenerationsItems.TIME_GLASS.get(), "legend_items/");
        createItem(GenerationsItems.MOON_FLUTE.get(), "legend_items/");
        createItem(GenerationsItems.SUN_FLUTE.get(), "legend_items/");
        createItem(GenerationsItems.LAVA_CRYSTAL.get(), "legend_items/");
        createItem(GenerationsItems.MAGMA_CRYSTAL.get(), "legend_items/");
        createItem(GenerationsItems.JEWEL_OF_LIFE.get(), "legend_items/");
//        createItemBlockDir(GenerationsShrines.PRISON_BOTTLE_STEM.get().asItem(), "legend_items");
//        createItem(GenerationsItems.PRISON_BOTTLE.get(), "legend_items/");
        createItem(GenerationsItems.MIRROR.get(), "legend_items/");
        createItem(GenerationsShrines.DARK_CRYSTAL.get().asItem(), "legend_items/");
        createItem(GenerationsItems.ICEROOT_CARROT.get(), "legend_items/");
        createItem(GenerationsItems.SHADEROOT_CARROT.get(), "legend_items/");
        createItem(GenerationsItems.ICY_WING.get(), "legend_items/");
        createItem(GenerationsItems.ELEGANT_WING.get(), "legend_items/");
        createItem(GenerationsItems.STATIC_WING.get(), "legend_items/");
        createItem(GenerationsItems.BELLIGERENT_WING.get(), "legend_items/");
        createItem(GenerationsItems.FIERY_WING.get(), "legend_items/");
        createItem(GenerationsItems.SINISTER_WING.get(), "legend_items/");
        createItem(GenerationsItems.REGIELEKI_ORB.get(), "legend_items/");
        createItem(GenerationsItems.REGIDRAGO_ORB.get(), "legend_items/");
        createItem(GenerationsItems.REGIROCK_ORB.get(), "legend_items/");
        createItem(GenerationsItems.REGISTEEL_ORB.get(), "legend_items/");
        createItem(GenerationsItems.REGICE_ORB.get(), "legend_items/");
        createItem(GenerationsItems.SHARD_OF_WILLPOWER.get(), "legend_items/");
        createItem(GenerationsItems.SHARD_OF_EMOTION.get(), "legend_items/");
        createItem(GenerationsItems.SHARD_OF_KNOWLEDGE.get(), "legend_items/");
        createItem(GenerationsItems.CRYSTAL_OF_WILLPOWER.get(), "legend_items/");
        createItem(GenerationsItems.CRYSTAL_OF_EMOTION.get(), "legend_items/");
        createItem(GenerationsItems.CRYSTAL_OF_KNOWLEDGE.get(), "legend_items/");
        createItem(GenerationsItems.LEGEND_PLATE.get(), "legend_items/");
        createItem(GenerationsItems.LUSTROUS_GLOBE.get(), "legend_items/");
        createItem(GenerationsItems.ADAMANT_CRYSTAL.get(), "legend_items/");
        createItem(GenerationsItems.GRISEOUS_CORE.get(), "legend_items/");
        createItem(GenerationsItems.FADED_JADE_ORB.get(), "legend_items/");
        createItem(GenerationsItems.MELTAN_BOX_CHARGED.get(), "legend_items/", "meltan_box");
        createItem(GenerationsItems.UNENCHANTED_ICEROOT_CARROT.get(), "legend_items/", "iceroot_carrot");
        createItem(GenerationsItems.UNENCHANTED_SHADEROOT_CARROT.get(), "legend_items/", "shaderoot_carrot");
        createItem(GenerationsItems.MEW_DNA_FIBER.get(), "legend_items/");
        createItem(GenerationsItems.MEW_FOSSIL.get(), "legend_items/");
        createItem(GenerationsItems.LIGHT_SOUL.get(), "legend_items/");
        createItem(GenerationsShrines.LIGHT_CRYSTAL.get().asItem(), "legend_items/");
        createItem(GenerationsItems.SOUL_HEART.get(), "legend_items/");
        createItem(GenerationsItems.WONDER_EGG.get(), "legend_items/");
        createItem(GenerationsItems.PHIONE_EGG.get(), "legend_items/");
        createItem(GenerationsItems.BLACK_MANE_HAIR.get(), "legend_items/");
        createItem(GenerationsItems.WHITE_MANE_HAIR.get(), "legend_items/");
        createItem(GenerationsItems.ENIGMA_FRAGMENT.get(), "legend_items/");
        createItem(GenerationsItems.ENIGMA_SHARD.get(), "legend_items/");
        createItem(GenerationsItems.ENIGMA_STONE.get(), "legend_items/");
        createItem(GenerationsItems.METEORITE_SHARD.get(), "legend_items/");
        createItem(GenerationsItems.SACRED_ASH.get(), "legend_items/");
        createItem(GenerationsItems.RAINBOW_WING.get(), "legend_items/");
        createItem(GenerationsItems.SILVER_WING.get(), "legend_items/");
        createItem(GenerationsItems.BLUE_PETAL.get(), "legend_items/");
        createItem(GenerationsItems.GREEN_PETAL.get(), "legend_items/");
        createItem(GenerationsItems.ORANGE_PETAL.get(), "legend_items/");
        createItem(GenerationsItems.PINK_PETAL.get(), "legend_items/");
        createItem(GenerationsItems.PURPLE_PETAL.get(), "legend_items/");
        createItem(GenerationsItems.RADIANT_PETAL.get(), "legend_items/");
        createItem(GenerationsItems.RED_PETAL.get(), "legend_items/");
        createItem(GenerationsItems.YELLOW_PETAL.get(), "legend_items/");

        createItem(GenerationsItems.BIKE_FRAME.get(), "utility_items/");
        createItem(GenerationsItems.BIKE_HANDLEBARS.get(), "utility_items/");
        createItem(GenerationsItems.BIKE_SEAT.get(), "utility_items/");
        createItem(GenerationsItems.BIKE_WHEEL.get(), "utility_items/");
        createItem(GenerationsItems.HIDDEN_IRON_DOOR.get(), "utility_items/");
        createItem(GenerationsItems.HIDDEN_WOODEN_DOOR.get(), "utility_items/");
        createItem(GenerationsItems.HIDDEN_LEVER.get(), "utility_items/");
        createItem(GenerationsItems.HIDDEN_PRESSURE_PLATE.get(), "utility_items/");
        createItem(GenerationsItems.HIDDEN_CUBE.get(), "utility_items/");
        createItem(GenerationsItems.HIDDEN_BUTTON.get(), "utility_items/");
        createItem(GenerationsItems.CHISEL.get(), "utility_items/");
        createItem(GenerationsItems.GIFT_BOX.get(), "utility_items/");
        createItem(GenerationsItems.POKEMON_WAND.get(), "utility_items/");
        createItem(GenerationsItems.ZONE_WAND.get(), "utility_items/");
        createItem(GenerationsItems.NPC_PATH_TOOL.get(), "utility_items/");
        createItem(GenerationsItems.NPC_WAND.get(), "utility_items/");

        createItem(GenerationsItems.METEORITE.get(), "form_items/");
        createItem(GenerationsItems.GRACIDEA.get(), "form_items/");
        createItem(GenerationsItems.REVEAL_GLASS.get(), "form_items/");
        createItem(GenerationsItems.ROCKSTAR_COSTUME.get(), "form_items/");
        createItem(GenerationsItems.BELLE_COSTUME.get(), "form_items/");
        createItem(GenerationsItems.POPSTAR_COSTUME.get(), "form_items/");
        createItem(GenerationsItems.PHD_COSTUME.get(), "form_items/");
        createItem(GenerationsItems.LIBRE_COSTUME.get(), "form_items/");
        createItem(GenerationsItems.MEWTWO_ARMOR.get(), "form_items/");
        createItem(GenerationsItems.PINK_NECTAR.get(), "form_items/");
        createItem(GenerationsItems.PURPLE_NECTAR.get(), "form_items/");
        createItem(GenerationsItems.RED_NECTAR.get(), "form_items/");
        createItem(GenerationsItems.YELLOW_NECTAR.get(), "form_items/");

        createItem(GenerationsItems.WORLD_CAP.get(), "caps/");
        createItem(GenerationsItems.KANTO_CAP.get(), "caps/");
        createItem(GenerationsItems.HOENN_CAP.get(), "caps/");
        createItem(GenerationsItems.SINNOH_CAP.get(), "caps/");
        createItem(GenerationsItems.UNOVA_CAP.get(), "caps/");
        createItem(GenerationsItems.KALOS_CAP.get(), "caps/");
        createItem(GenerationsItems.ALOLA_CAP.get(), "caps/");
        createItem(GenerationsItems.PARTNER_CAP.get(), "caps/");

        createItem(GenerationsItems.BACHS_FOOD_TIN.get(), "curry/ingredients/");
        createItem(GenerationsItems.BOBS_FOOD_TIN.get(), "curry/ingredients/");
        createItem(GenerationsItems.BOILED_EGG.get(), "curry/ingredients/");
        createItem(GenerationsItems.BREAD.get(), "curry/ingredients/");
        createItem(GenerationsItems.BRITTLE_BONES.get(), "curry/ingredients/");
        createItem(GenerationsItems.COCONUT_MILK.get(), "curry/ingredients/");
        createItem(GenerationsItems.FANCY_APPLE.get(), "curry/ingredients/");
        createItem(GenerationsItems.FRESH_CREAM.get(), "curry/ingredients/");
        createItem(GenerationsItems.FRIED_FOOD.get(), "curry/ingredients/");
        createItem(GenerationsItems.FRUIT_BUNCH.get(), "curry/ingredients/");
        createItem(GenerationsItems.INSTANT_NOODLES.get(), "curry/ingredients/");
        createItem(GenerationsItems.LARGE_LEEK.get(), "curry/ingredients/");
        createItem(GenerationsItems.MIXED_MUSHROOMS.get(), "curry/ingredients/");
        createItem(GenerationsItems.MOOMOO_CHEESE.get(), "curry/ingredients/");
        createItem(GenerationsItems.PACK_OF_POTATOES.get(), "curry/ingredients/");
        createItem(GenerationsItems.PACKAGED_CURRY.get(), "curry/ingredients/");
        createItem(GenerationsItems.PASTA.get(), "curry/ingredients/");
        createItem(GenerationsItems.PRECOOKED_BURGER.get(), "curry/ingredients/");
        createItem(GenerationsItems.PUNGENT_ROOT.get(), "curry/ingredients/");
        createItem(GenerationsItems.SALAD_MIX.get(), "curry/ingredients/");
        createItem(GenerationsItems.SAUSAGES.get(), "curry/ingredients/");
        createItem(GenerationsItems.SMOKED_POKE_TAIL.get(), "curry/ingredients/");
        createItem(GenerationsItems.SPICE_MIX.get(), "curry/ingredients/");
        createItem(GenerationsItems.TIN_OF_BEANS.get(), "curry/ingredients/");
        createItem(GenerationsItems.GIGANTAMIX.get(), "curry/ingredients/");


        createItem(GenerationsItems.POKEMAIL_AIR.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_AIR_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_BLOOM.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_BLOOM_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_BRICK.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_BRICK_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_BRIDGE_D.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_BRIDGE_D_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_BRIDGE_M.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_BRIDGE_M_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_BRIDGE_S.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_BRIDGE_S_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_BRIDGE_T.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_BRIDGE_T_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_BRIDGE_V.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_BRIDGE_V_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_BUBBLE.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_BUBBLE_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_DREAM.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_DREAM_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_FAB.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_FAB_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_FAVORED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_FAVORED_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_FLAME.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_FLAME_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_GLITTER.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_GLITTER_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_GRASS.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_GRASS_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_GREET.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_GREET_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_HARBOR.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_HARBOR_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_HEART.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_HEART_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_INQUIRY.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_INQUIRY_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_LIKE.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_LIKE_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_MECH.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_MECH_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_MOSAIC.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_MOSAIC_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_ORANGE.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_ORANGE_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_REPLY.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_REPLY_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_RETRO.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_RETRO_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_RSVP.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_RSVP_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_SHADOW.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_SHADOW_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_SNOW.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_SNOW_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_SPACE.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_SPACE_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_STEEL.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_STEEL_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_THANKS.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_THANKS_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_TROPIC.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_TROPIC_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_TUNNEL.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_TUNNEL_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_WAVE.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_WAVE_CLOSED.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_WOOD.get(), "mail/");
        createItem(GenerationsItems.POKEMAIL_WOOD_CLOSED.get(), "mail/");

        createItem(GenerationsItems.ABILITY_URGE.get(), "unimplemented/");
        createItem(GenerationsItems.ADVENTURE_GUIDE.get(), "unimplemented/");
        createItem(GenerationsItems.APRICORN_BOX.get(), "unimplemented/");
        createItem(GenerationsItems.AQUA_SUIT.get(), "unimplemented/");
        createItem(GenerationsItems.ARMOR_PASS.get(), "unimplemented/");
        createItem(GenerationsItems.ARMORITE_ORE.get(), "unimplemented/");
        createItem(GenerationsItems.AURORA_TICKET.get(), "unimplemented/");
        createItem(GenerationsItems.AUTOGRAPH.get(), "unimplemented/");
        createItem(GenerationsItems.AZURE_FLUTE.get(), "unimplemented/");
        createItem(GenerationsItems.BAND_AUTOGRAPH.get(), "unimplemented/");
        createItem(GenerationsItems.BASEMENT_KEY_1.get(), "unimplemented/");
        createItem(GenerationsItems.BASEMENT_KEY_2.get(), "unimplemented/");
        createItem(GenerationsItems.BERRY_PLANTER.get(), "unimplemented/");
        createItem(GenerationsItems.BERRY_POUCH.get(), "unimplemented/");
        createItem(GenerationsItems.BIKE_VOUCHER.get(), "unimplemented/");
        createItem(GenerationsItems.BLUE_CARD.get(), "unimplemented/");
        createItem(GenerationsItems.BLUE_SCARF.get(), "unimplemented/");
        createItem(GenerationsItems.BLUE_SPHERE.get(), "unimplemented/");
        createItem(GenerationsItems.CAMPING_GEAR.get(), "unimplemented/");
        createItem(GenerationsItems.CARD_KEY_1.get(), "unimplemented/");
        createItem(GenerationsItems.CARD_KEY_2.get(), "unimplemented/");
        createItem(GenerationsItems.CARROT_SEEDS.get(), "unimplemented/");
        createItem(GenerationsItems.CLEAR_BELL.get(), "unimplemented/");
        createItem(GenerationsItems.COIN.get(), "unimplemented/");
        createItem(GenerationsItems.COIN_CASE.get(), "unimplemented/");
        createItem(GenerationsItems.COLRESS_MACHINE.get(), "unimplemented/");
        createItem(GenerationsItems.COMMON_STONE.get(), "unimplemented/");
        createItem(GenerationsItems.CONTEST_COSTUME_1.get(), "unimplemented/");
        createItem(GenerationsItems.CONTEST_COSTUME_2.get(), "unimplemented/");
        createItem(GenerationsItems.CONTEST_PASS.get(), "unimplemented/");
        createItem(GenerationsItems.COURAGE_CANDY.get(), "unimplemented/");
        createItem(GenerationsItems.COURAGE_CANDY_L.get(), "unimplemented/");
        createItem(GenerationsItems.COURAGE_CANDY_XL.get(), "unimplemented/");
        createItem(GenerationsItems.COUPON_1.get(), "unimplemented/");
        createItem(GenerationsItems.COUPON_2.get(), "unimplemented/");
        createItem(GenerationsItems.COUPON_3.get(), "unimplemented/");
        createItem(GenerationsItems.CROWN_PASS.get(), "unimplemented/");
        createItem(GenerationsItems.DATA_CARDS.get(), "unimplemented/");
        createItem(GenerationsItems.DEVON_PARTS.get(), "unimplemented/");
        createItem(GenerationsItems.DEVON_SCOPE.get(), "unimplemented/");
        createItem(GenerationsItems.DEVON_SCUBA_GEAR.get(), "unimplemented/");
        createItem(GenerationsItems.DIRE_HIT_2.get(), "unimplemented/");
        createItem(GenerationsItems.DIRE_HIT_3.get(), "unimplemented/");
        createItem(GenerationsItems.DISCOUNT_COUPON.get(), "unimplemented/");
        createItem(GenerationsItems.DOWSING_MACHINE_1.get(), "unimplemented/");
        createItem(GenerationsItems.DOWSING_MACHINE_2.get(), "unimplemented/");
        createItem(GenerationsItems.DOWSING_MCHN.get(), "unimplemented/");
        createItem(GenerationsItems.DRAGON_SKULL.get(), "unimplemented/");
        createItem(GenerationsItems.DROPPED_ITEM_RED.get(), "unimplemented/");
        createItem(GenerationsItems.DROPPED_ITEM_YELLOW.get(), "unimplemented/");
        createItem(GenerationsItems.ELEVATOR_KEY.get(), "unimplemented/");
        createItem(GenerationsItems.ENDORSEMENT.get(), "unimplemented/");
        createItem(GenerationsItems.EON_FLUTE.get(), "unimplemented/");
        createItem(GenerationsItems.EON_TICKET.get(), "unimplemented/");
        createItem(GenerationsItems.EXPLORER_KIT.get(), "unimplemented/");
        createItem(GenerationsItems.FAME_CHECKER.get(), "unimplemented/");
        createItem(GenerationsItems.FASHION_CASE.get(), "unimplemented/");
        createItem(GenerationsItems.FESTIVAL_TICKET.get(), "unimplemented/");
        createItem(GenerationsItems.FORAGE_BAG.get(), "unimplemented/");
        createItem(GenerationsItems.GALACTIC_KEY.get(), "unimplemented/");
        createItem(GenerationsItems.GALARICA_TWIG.get(), "unimplemented/");
        createItem(GenerationsItems.GO_GOGGLES.get(), "unimplemented/");
        createItem(GenerationsItems.GOLD_TEETH.get(), "unimplemented/");
        createItem(GenerationsItems.GOLDEN_NANAB_BERRY.get(), "unimplemented/");
        createItem(GenerationsItems.GOLDEN_PINAP_BERRY.get(), "unimplemented/");
        createItem(GenerationsItems.GOLDEN_RAZZ_BERRY.get(), "unimplemented/");
        createItem(GenerationsItems.GRAM.get(), "unimplemented/");
        createItem(GenerationsItems.GREEN_SCARF.get(), "unimplemented/");
        createItem(GenerationsItems.GREEN_SPHERE.get(), "unimplemented/");
        createItem(GenerationsItems.GREEN_TEA.get(), "unimplemented/");
        createItem(GenerationsItems.GRUBBY_HANKY.get(), "unimplemented/");
        createItem(GenerationsItems.HEALTH_CANDY.get(), "unimplemented/");
        createItem(GenerationsItems.HEALTH_CANDY_L.get(), "unimplemented/");
        createItem(GenerationsItems.HEALTH_CANDY_XL.get(), "unimplemented/");
        createItem(GenerationsItems.HOLO_CASTER_1.get(), "unimplemented/");
        createItem(GenerationsItems.HOLO_CASTER_2.get(), "unimplemented/");
        createItem(GenerationsItems.HONOR_OF_KALOS.get(), "unimplemented/");
        createItem(GenerationsItems.INTRIGUING_STONE.get(), "unimplemented/");
        createItem(GenerationsItems.ITEM_DROP.get(), "unimplemented/");
        createItem(GenerationsItems.ITEM_URGE.get(), "unimplemented/");
        createItem(GenerationsItems.JOURNAL.get(), "unimplemented/");
        createItem(GenerationsItems.KEY_STONE_2.get(), "unimplemented/");
        createItem(GenerationsItems.KEY_TO_ROOM_1.get(), "unimplemented/");
        createItem(GenerationsItems.KEY_TO_ROOM_2.get(), "unimplemented/");
        createItem(GenerationsItems.KEY_TO_ROOM_4.get(), "unimplemented/");
        createItem(GenerationsItems.KEY_TO_ROOM_6.get(), "unimplemented/");
        createItem(GenerationsItems.LEAF_LETTER.get(), "unimplemented/");
        createItem(GenerationsItems.LEGENDARY_CLUE.get(), "unimplemented/");
        createItem(GenerationsItems.LENS_CASE.get(), "unimplemented/");
        createItem(GenerationsItems.LETTER.get(), "unimplemented/");
        createItem(GenerationsItems.LIBERTY_PASS.get(), "unimplemented/");
        createItem(GenerationsItems.LIFT_KEY.get(), "unimplemented/");
        createItem(GenerationsItems.LOCK_CAPSULE_1.get(), "unimplemented/");
        createItem(GenerationsItems.LOCK_CAPSULE_2.get(), "unimplemented/");
        createItem(GenerationsItems.LOOKER_TICKET.get(), "unimplemented/");
        createItem(GenerationsItems.LOOT_SACK.get(), "unimplemented/");
        createItem(GenerationsItems.LOST_ITEM_1.get(), "unimplemented/");
        createItem(GenerationsItems.LOST_ITEM_2.get(), "unimplemented/");
        createItem(GenerationsItems.LUNAR_FEATHER.get(), "unimplemented/");
        createItem(GenerationsItems.LURE.get(), "unimplemented/");
        createItem(GenerationsItems.MACHINE_PART.get(), "unimplemented/");
        createItem(GenerationsItems.MAGMA_EMBLEM.get(), "unimplemented/");
        createItem(GenerationsItems.MAGMA_SUIT.get(), "unimplemented/");
        createItem(GenerationsItems.MAKEUP_BAG.get(), "unimplemented/");
        createItem(GenerationsItems.MAX_LURE.get(), "unimplemented/");
        createItem(GenerationsItems.MEDAL_BOX.get(), "unimplemented/");
        createItem(GenerationsItems.MEMBER_CARD.get(), "unimplemented/");
        createItem(GenerationsItems.MIGHTY_CANDY.get(), "unimplemented/");
        createItem(GenerationsItems.MIGHTY_CANDY_L.get(), "unimplemented/");
        createItem(GenerationsItems.MIGHTY_CANDY_XL.get(), "unimplemented/");
        createItem(GenerationsItems.MYSTIC_TICKET.get(), "unimplemented/");
        createItem(GenerationsItems.OAKS_LETTER.get(), "unimplemented/");
        createItem(GenerationsItems.OAKS_PARCEL.get(), "unimplemented/");
        createItem(GenerationsItems.OLD_CHARM.get(), "unimplemented/");
        createItem(GenerationsItems.OLD_LETTER.get(), "unimplemented/");
        createItem(GenerationsItems.OLD_SEA_MAP.get(), "unimplemented/");
        createItem(GenerationsItems.PAIR_OF_TICKETS.get(), "unimplemented/");
        createItem(GenerationsItems.PAL_PAD.get(), "unimplemented/");
        createItem(GenerationsItems.PALE_SPHERE.get(), "unimplemented/");
        createItem(GenerationsItems.PASS.get(), "unimplemented/");
        createItem(GenerationsItems.PASS_ORB.get(), "unimplemented/");
        createItem(GenerationsItems.PERMIT.get(), "unimplemented/");
        createItem(GenerationsItems.PEWTER_CRUNCHIES.get(), "unimplemented/");
        createItem(GenerationsItems.PINK_SCARF.get(), "unimplemented/");
        createItem(GenerationsItems.PLASMA_CARD.get(), "unimplemented/");
        createItem(GenerationsItems.POFFIN.get(), "unimplemented/");
        createItem(GenerationsItems.POFFIN_CASE.get(), "unimplemented/");
        createItem(GenerationsItems.POINT_CARD.get(), "unimplemented/");
        createItem(GenerationsItems.POKE_FLUTE.get(), "unimplemented/");
        createItem(GenerationsItems.POKE_RADAR.get(), "unimplemented/");
        createItem(GenerationsItems.POKEBLOCK_CASE.get(), "unimplemented/");
        createItem(GenerationsItems.POKEBLOCK_KIT.get(), "unimplemented/");
        createItem(GenerationsItems.POKETCH_BLUE.get(), "unimplemented/");
        createItem(GenerationsItems.POKETCH_RED.get(), "unimplemented/");
        createItem(GenerationsItems.POWDER_JAR.get(), "unimplemented/");
        createItem(GenerationsItems.POWER_PLANT_PASS.get(), "unimplemented/");
        createItem(GenerationsItems.PRISM_SPHERE.get(), "unimplemented/");
        createItem(GenerationsItems.PROFESSORS_MASK.get(), "unimplemented/");
        createItem(GenerationsItems.PROFS_LETTER.get(), "unimplemented/");
        createItem(GenerationsItems.PROP_CASE.get(), "unimplemented/");
        createItem(GenerationsItems.QUICK_CANDY.get(), "unimplemented/");
        createItem(GenerationsItems.QUICK_CANDY_L.get(), "unimplemented/");
        createItem(GenerationsItems.QUICK_CANDY_XL.get(), "unimplemented/");
        createItem(GenerationsItems.RAINBOW_FLOWER.get(), "unimplemented/");
        createItem(GenerationsItems.RAINBOW_PASS.get(), "unimplemented/");
        createItem(GenerationsItems.RED_SCALE.get(), "unimplemented/");
        createItem(GenerationsItems.RED_SPHERE.get(), "unimplemented/");
        createItem(GenerationsItems.RESET_URGE.get(), "unimplemented/");
        createItem(GenerationsItems.RIDE_PAGER.get(), "unimplemented/");
        createItem(GenerationsItems.ROLLER_SKATES.get(), "unimplemented/");
        createItem(GenerationsItems.ROTO_BARGAIN.get(), "unimplemented/");
        createItem(GenerationsItems.ROTO_BOOST.get(), "unimplemented/");
        createItem(GenerationsItems.ROTO_CATCH.get(), "unimplemented/");
        createItem(GenerationsItems.ROTO_ENCOUNTER.get(), "unimplemented/");
        createItem(GenerationsItems.ROTO_EXP_POINTS.get(), "unimplemented/");
        createItem(GenerationsItems.ROTO_FRIENDSHIP.get(), "unimplemented/");
        createItem(GenerationsItems.ROTO_HATCH.get(), "unimplemented/");
        createItem(GenerationsItems.ROTO_HP_RESTORE.get(), "unimplemented/");
        createItem(GenerationsItems.ROTO_PP_RESTORE.get(), "unimplemented/");
        createItem(GenerationsItems.ROTO_PRIZE_MONEY.get(), "unimplemented/");
        createItem(GenerationsItems.ROTO_STEALTH.get(), "unimplemented/");
        createItem(GenerationsItems.RULE_BOOK.get(), "unimplemented/");
        createItem(GenerationsItems.SCANNER.get(), "unimplemented/");
        createItem(GenerationsItems.SEAL_BAG.get(), "unimplemented/");
        createItem(GenerationsItems.SEAL_CASE.get(), "unimplemented/");
        createItem(GenerationsItems.SECRET_KEY_1.get(), "unimplemented/");
        createItem(GenerationsItems.SECRET_KEY_2.get(), "unimplemented/");
        createItem(GenerationsItems.SECRET_MEDICINE.get(), "unimplemented/");
        createItem(GenerationsItems.SILPH_SCOPE.get(), "unimplemented/");
        createItem(GenerationsItems.SILVER_NANAB_BERRY.get(), "unimplemented/");
        createItem(GenerationsItems.SILVER_PINAP_BERRY.get(), "unimplemented/");
        createItem(GenerationsItems.SILVER_RAZZ_BERRY.get(), "unimplemented/");
        createItem(GenerationsItems.SINNOH_STONE.get(), "unimplemented/");
        createItem(GenerationsItems.SMART_CANDY.get(), "unimplemented/");
        createItem(GenerationsItems.SMART_CANDY_L.get(), "unimplemented/");
        createItem(GenerationsItems.SMART_CANDY_XL.get(), "unimplemented/");
        createItem(GenerationsItems.SONIAS_BOOK.get(), "unimplemented/");
        createItem(GenerationsItems.SOOT_SACK.get(), "unimplemented/");
        createItem(GenerationsItems.SS_TICKET.get(), "unimplemented/");
        createItem(GenerationsItems.STORAGE_KEY_1.get(), "unimplemented/");
        createItem(GenerationsItems.STORAGE_KEY_2.get(), "unimplemented/");
        createItem(GenerationsItems.STYLE_CARD.get(), "unimplemented/");
        createItem(GenerationsItems.SUITE_KEY.get(), "unimplemented/");
        createItem(GenerationsItems.SUPER_LURE.get(), "unimplemented/");
        createItem(GenerationsItems.TEACHY_TV.get(), "unimplemented/");
        createItem(GenerationsItems.TIDAL_BELL.get(), "unimplemented/");
        createItem(GenerationsItems.TM_CASE.get(), "unimplemented/");
        createItem(GenerationsItems.TM_MATERIAL.get(), "unimplemented/");
        createItem(GenerationsItems.TMV_PASS.get(), "unimplemented/");
        createItem(GenerationsItems.TOTEM_STICKER.get(), "unimplemented/");
        createItem(GenerationsItems.TOUGH_CANDY.get(), "unimplemented/");
        createItem(GenerationsItems.TOUGH_CANDY_L.get(), "unimplemented/");
        createItem(GenerationsItems.TOUGH_CANDY_XL.get(), "unimplemented/");
        createItem(GenerationsItems.TOWN_MAP_1.get(), "unimplemented/");
        createItem(GenerationsItems.TOWN_MAP_2.get(), "unimplemented/");
        createItem(GenerationsItems.TOWN_MAP_3.get(), "unimplemented/");
        createItem(GenerationsItems.TRAVEL_TRUNK_1.get(), "unimplemented/");
        createItem(GenerationsItems.TRAVEL_TRUNK_2.get(), "unimplemented/");
        createItem(GenerationsItems.TRI_PASS.get(), "unimplemented/");
        createItem(GenerationsItems.UNOVA_STONE.get(), "unimplemented/");
        createItem(GenerationsItems.UNOWN_REPORT.get(), "unimplemented/");
        createItem(GenerationsItems.VS_RECORDER.get(), "unimplemented/");
        createItem(GenerationsItems.VS_SEEKER.get(), "unimplemented/");
        createItem(GenerationsItems.WISHING_CHIP.get(), "unimplemented/");
        createItem(GenerationsItems.WISHING_PIECE.get(), "unimplemented/");
        createItem(GenerationsItems.WOODEN_CROWN.get(), "unimplemented/");
        createItem(GenerationsItems.WORKS_KEY.get(), "unimplemented/");
        createItem(GenerationsItems.X_ACCURACY_2.get(), "unimplemented/");
        createItem(GenerationsItems.X_ACCURACY_3.get(), "unimplemented/");
        createItem(GenerationsItems.X_ACCURACY_6.get(), "unimplemented/");
        createItem(GenerationsItems.X_ATTACK_2.get(), "unimplemented/");
        createItem(GenerationsItems.X_ATTACK_3.get(), "unimplemented/");
        createItem(GenerationsItems.X_ATTACK_6.get(), "unimplemented/");
        createItem(GenerationsItems.X_DEFENSE_2.get(), "unimplemented/");
        createItem(GenerationsItems.X_DEFENSE_3.get(), "unimplemented/");
        createItem(GenerationsItems.X_DEFENSE_6.get(), "unimplemented/");
        createItem(GenerationsItems.X_SPECIAL_ATTACK_2.get(), "unimplemented/");
        createItem(GenerationsItems.X_SPECIAL_ATTACK_3.get(), "unimplemented/");
        createItem(GenerationsItems.X_SPECIAL_ATTACK_6.get(), "unimplemented/");
        createItem(GenerationsItems.X_SPECIAL_DEFENSE_2.get(), "unimplemented/");
        createItem(GenerationsItems.X_SPECIAL_DEFENSE_3.get(), "unimplemented/");
        createItem(GenerationsItems.X_SPECIAL_DEFENSE_6.get(), "unimplemented/");
        createItem(GenerationsItems.X_SPEED_2.get(), "unimplemented/");
        createItem(GenerationsItems.X_SPEED_3.get(), "unimplemented/");
        createItem(GenerationsItems.X_SPEED_6.get(), "unimplemented/");
        createItem(GenerationsItems.X_TRANSCEIVER_BLUE.get(), "unimplemented/");
        createItem(GenerationsItems.X_TRANSCEIVER_RED.get(), "unimplemented/");
        createItem(GenerationsItems.X_TRANSCEIVER_YELLOW.get(), "unimplemented/");
        createItem(GenerationsItems.YELLOW_SCARF.get(), "unimplemented/");
        createItem(GenerationsItems.STRANGE_BALL.get(), "unimplemented/");

        createItem(GenerationsItems.GHOST_BOAT_ITEM.get(), "boat/");
        createItem(GenerationsItems.GHOST_CHEST_BOAT_ITEM.get(), "chest_boat/");
        createItem(GenerationsItems.ULTRA_DARK_BOAT_ITEM.get(), "boat/");
        createItem(GenerationsItems.ULTRA_DARK_CHEST_BOAT_ITEM.get(), "chest_boat/");
        createItem(GenerationsItems.ULTRA_JUNGLE_BOAT_ITEM.get(), "boat/");
        createItem(GenerationsItems.ULTRA_JUNGLE_CHEST_BOAT_ITEM.get(), "chest_boat/");

        createItem(GenerationsItems.POKE_WALKMON.get(), "walkmon/");
        createItem(GenerationsItems.GREAT_WALKMON.get(), "walkmon/");
        createItem(GenerationsItems.ULTRA_WALKMON.get(), "walkmon/");
        createItem(GenerationsItems.MASTER_WALKMON.get(), "walkmon/");
        createItem(GenerationsItems.HI_TECH_EARBUDS.get(), "walkmon/");
        createItem(GenerationsItems.GB_SOUNDS.get(), "walkmon/");

        registerDisc(GenerationsItems.AZALEA_TOWN_DISC.getId());
        registerDisc(GenerationsItems.CASCARRAFA_CITY_DISC.getId());
        registerDisc(GenerationsItems.CERULEAN_CITY_DISC.getId());
        registerDisc(GenerationsItems.ETERNA_CITY_DISC.getId());
        registerDisc(GenerationsItems.GOLDENROD_CITY_DISC.getId());
        registerDisc(GenerationsItems.ICIRRUS_CITY_DISC.getId());
        registerDisc(GenerationsItems.JUBILIFE_VILLAGE_DISC.getId());
        registerDisc(GenerationsItems.LAKE_OF_RAGE_DISC.getId());
        registerDisc(GenerationsItems.LAVERRE_CITY_DISC.getId());
        registerDisc(GenerationsItems.LILLIE_DISC.getId());
        registerDisc(GenerationsItems.POKEMON_CENTER_DISC.getId());
        registerDisc(GenerationsItems.ROUTE_228_DISC.getId());
        registerDisc(GenerationsItems.SLUMBERING_WEALD_DISC.getId());
        registerDisc(GenerationsItems.SURF_DISC.getId());
        registerDisc(GenerationsItems.VERMILION_CITY_DISC.getId());
        registerDisc(GenerationsItems.CYNTHIA_DISC.getId());
        registerDisc(GenerationsItems.DEOXYS_DISC.getId());
        registerDisc(GenerationsItems.IRIS_DISC.getId());
        registerDisc(GenerationsItems.KANTO_DISC.getId());
        registerDisc(GenerationsItems.LUSAMINE_DISC.getId());
        registerDisc(GenerationsItems.NEMONA_DISC.getId());
        registerDisc(GenerationsItems.NESSA_DISC.getId());
        registerDisc(GenerationsItems.PENNY_DISC.getId());
        registerDisc(GenerationsItems.RIVAL_DISC.getId());
        registerDisc(GenerationsItems.SADA_AND_TURO_DISC.getId());
        registerDisc(GenerationsItems.SOUTH_PROVINCE_DISC.getId());
        registerDisc(GenerationsItems.TEAM_ROCKET_DISC.getId());
        registerDisc(GenerationsItems.ULTRA_NECROZMA_DISC.getId());
        registerDisc(GenerationsItems.XY_LEGENDARY_DISC.getId());
        registerDisc(GenerationsItems.ZINNIA_DISC.getId());
        registerDisc(GenerationsItems.LAVENDER_TOWN_DISC.getId());
        registerDisc(GenerationsItems.LUGIA_DISC.getId());
        registerDisc(GenerationsItems.MT_PYRE_DISC.getId());

        createCurry();
        createImbuedFlute();
        createCelestialAltar();
        createTimeCapsule();
        createLunarShrine();
        createTm(GenerationsItems.CUSTOM_TM.get());
        createTm(GenerationsItems.TM_1.get());
        createTm(GenerationsItems.TM_2.get());
        createTm(GenerationsItems.TM_3.get());
        createTm(GenerationsItems.TM_4.get());
        createTm(GenerationsItems.TM_5.get());
        createTm(GenerationsItems.TM_6.get());
        createTm(GenerationsItems.TM_7.get());
        createTm(GenerationsItems.TM_8.get());
        createTm(GenerationsItems.TM_9.get());
        createTm(GenerationsItems.TM_10.get());
        createTm(GenerationsItems.TM_11.get());
        createTm(GenerationsItems.TM_12.get());
        createTm(GenerationsItems.TM_13.get());
        createTm(GenerationsItems.TM_14.get());
        createTm(GenerationsItems.TM_15.get());
        createTm(GenerationsItems.TM_16.get());
        createTm(GenerationsItems.TM_17.get());
        createTm(GenerationsItems.TM_18.get());
        createTm(GenerationsItems.TM_19.get());
        createTm(GenerationsItems.TM_20.get());
        createTm(GenerationsItems.TM_21.get());
        createTm(GenerationsItems.TM_22.get());
        createTm(GenerationsItems.TM_23.get());
        createTm(GenerationsItems.TM_24.get());
        createTm(GenerationsItems.TM_25.get());
        createTm(GenerationsItems.TM_26.get());
        createTm(GenerationsItems.TM_27.get());
        createTm(GenerationsItems.TM_28.get());
        createTm(GenerationsItems.TM_29.get());
        createTm(GenerationsItems.TM_30.get());
        createTm(GenerationsItems.TM_31.get());
        createTm(GenerationsItems.TM_32.get());
        createTm(GenerationsItems.TM_33.get());
        createTm(GenerationsItems.TM_34.get());
        createTm(GenerationsItems.TM_35.get());
        createTm(GenerationsItems.TM_36.get());
        createTm(GenerationsItems.TM_37.get());
        createTm(GenerationsItems.TM_38.get());
        createTm(GenerationsItems.TM_39.get());
        createTm(GenerationsItems.TM_40.get());
        createTm(GenerationsItems.TM_41.get());
        createTm(GenerationsItems.TM_42.get());
        createTm(GenerationsItems.TM_43.get());
        createTm(GenerationsItems.TM_44.get());
        createTm(GenerationsItems.TM_45.get());
        createTm(GenerationsItems.TM_46.get());
        createTm(GenerationsItems.TM_47.get());
        createTm(GenerationsItems.TM_48.get());
        createTm(GenerationsItems.TM_49.get());
        createTm(GenerationsItems.TM_50.get());
        createTm(GenerationsItems.TM_51.get());
        createTm(GenerationsItems.TM_52.get());
        createTm(GenerationsItems.TM_53.get());
        createTm(GenerationsItems.TM_54.get());
        createTm(GenerationsItems.TM_55.get());
        createTm(GenerationsItems.TM_56.get());
        createTm(GenerationsItems.TM_57.get());
        createTm(GenerationsItems.TM_58.get());
        createTm(GenerationsItems.TM_59.get());
        createTm(GenerationsItems.TM_60.get());
        createTm(GenerationsItems.TM_61.get());
        createTm(GenerationsItems.TM_62.get());
        createTm(GenerationsItems.TM_63.get());
        createTm(GenerationsItems.TM_64.get());
        createTm(GenerationsItems.TM_65.get());
        createTm(GenerationsItems.TM_66.get());
        createTm(GenerationsItems.TM_67.get());
        createTm(GenerationsItems.TM_68.get());
        createTm(GenerationsItems.TM_69.get());
        createTm(GenerationsItems.TM_70.get());
        createTm(GenerationsItems.TM_71.get());
        createTm(GenerationsItems.TM_72.get());
        createTm(GenerationsItems.TM_73.get());
        createTm(GenerationsItems.TM_74.get());
        createTm(GenerationsItems.TM_75.get());
        createTm(GenerationsItems.TM_76.get());
        createTm(GenerationsItems.TM_77.get());
        createTm(GenerationsItems.TM_78.get());
        createTm(GenerationsItems.TM_79.get());
        createTm(GenerationsItems.TM_80.get());
        createTm(GenerationsItems.TM_81.get());
        createTm(GenerationsItems.TM_82.get());
        createTm(GenerationsItems.TM_83.get());
        createTm(GenerationsItems.TM_84.get());
        createTm(GenerationsItems.TM_85.get());
        createTm(GenerationsItems.TM_86.get());
        createTm(GenerationsItems.TM_87.get());
        createTm(GenerationsItems.TM_88.get());
        createTm(GenerationsItems.TM_89.get());
        createTm(GenerationsItems.TM_90.get());
        createTm(GenerationsItems.TM_91.get());
        createTm(GenerationsItems.TM_92.get());
        createTm(GenerationsItems.TM_93.get());
        createTm(GenerationsItems.TM_94.get());
        createTm(GenerationsItems.TM_95.get());
        createTm(GenerationsItems.TM_96.get());
        createTm(GenerationsItems.TM_97.get());
        createTm(GenerationsItems.TM_98.get());
        createTm(GenerationsItems.TM_99.get());
        createTm(GenerationsItems.TM_100.get());
        createTm(GenerationsItems.TM_101.get());
        createTm(GenerationsItems.TM_102.get());
        createTm(GenerationsItems.TM_103.get());
        createTm(GenerationsItems.TM_104.get());
        createTm(GenerationsItems.TM_105.get());
        createTm(GenerationsItems.TM_106.get());
        createTm(GenerationsItems.TM_107.get());
        createTm(GenerationsItems.TM_108.get());
        createTm(GenerationsItems.TM_109.get());
        createTm(GenerationsItems.TM_110.get());
        createTm(GenerationsItems.TM_111.get());
        createTm(GenerationsItems.TM_112.get());
        createTm(GenerationsItems.TM_113.get());
        createTm(GenerationsItems.TM_114.get());
        createTm(GenerationsItems.TM_115.get());
        createTm(GenerationsItems.TM_116.get());
        createTm(GenerationsItems.TM_117.get());
        createTm(GenerationsItems.TM_118.get());
        createTm(GenerationsItems.TM_119.get());
        createTm(GenerationsItems.TM_120.get());
        createTm(GenerationsItems.TM_121.get());
        createTm(GenerationsItems.TM_122.get());
        createTm(GenerationsItems.TM_123.get());
        createTm(GenerationsItems.TM_124.get());
        createTm(GenerationsItems.TM_125.get());
        createTm(GenerationsItems.TM_126.get());
        createTm(GenerationsItems.TM_127.get());
        createTm(GenerationsItems.TM_128.get());
        createTm(GenerationsItems.TM_129.get());
        createTm(GenerationsItems.TM_130.get());
        createTm(GenerationsItems.TM_131.get());
        createTm(GenerationsItems.TM_132.get());
        createTm(GenerationsItems.TM_133.get());
        createTm(GenerationsItems.TM_134.get());
        createTm(GenerationsItems.TM_135.get());
        createTm(GenerationsItems.TM_136.get());
        createTm(GenerationsItems.TM_137.get());
        createTm(GenerationsItems.TM_138.get());
        createTm(GenerationsItems.TM_139.get());
        createTm(GenerationsItems.TM_140.get());
        createTm(GenerationsItems.TM_141.get());
        createTm(GenerationsItems.TM_142.get());
        createTm(GenerationsItems.TM_143.get());
        createTm(GenerationsItems.TM_144.get());
        createTm(GenerationsItems.TM_145.get());
        createTm(GenerationsItems.TM_146.get());
        createTm(GenerationsItems.TM_147.get());
        createTm(GenerationsItems.TM_148.get());
        createTm(GenerationsItems.TM_149.get());
        createTm(GenerationsItems.TM_150.get());
        createTm(GenerationsItems.TM_151.get());
        createTm(GenerationsItems.TM_152.get());
        createTm(GenerationsItems.TM_153.get());
        createTm(GenerationsItems.TM_154.get());
        createTm(GenerationsItems.TM_155.get());
        createTm(GenerationsItems.TM_156.get());
        createTm(GenerationsItems.TM_157.get());
        createTm(GenerationsItems.TM_158.get());
        createTm(GenerationsItems.TM_159.get());
        createTm(GenerationsItems.TM_160.get());
        createTm(GenerationsItems.TM_161.get());
        createTm(GenerationsItems.TM_162.get());
        createTm(GenerationsItems.TM_163.get());
        createTm(GenerationsItems.TM_164.get());
        createTm(GenerationsItems.TM_165.get());
        createTm(GenerationsItems.TM_166.get());
        createTm(GenerationsItems.TM_167.get());
        createTm(GenerationsItems.TM_168.get());
        createTm(GenerationsItems.TM_169.get());
        createTm(GenerationsItems.TM_170.get());
        createTm(GenerationsItems.TM_171.get());
        createTm(GenerationsItems.TM_172.get());
        createTm(GenerationsItems.TM_173.get());
        createTm(GenerationsItems.TM_174.get());
        createTm(GenerationsItems.TM_175.get());
        createTm(GenerationsItems.TM_176.get());
        createTm(GenerationsItems.TM_177.get());
        createTm(GenerationsItems.TM_178.get());
        createTm(GenerationsItems.TM_179.get());
        createTm(GenerationsItems.TM_180.get());
        createTm(GenerationsItems.TM_181.get());
        createTm(GenerationsItems.TM_182.get());
        createTm(GenerationsItems.TM_183.get());
        createTm(GenerationsItems.TM_184.get());
        createTm(GenerationsItems.TM_185.get());
        createTm(GenerationsItems.TM_186.get());
        createTm(GenerationsItems.TM_187.get());
        createTm(GenerationsItems.TM_188.get());
        createTm(GenerationsItems.TM_189.get());
        createTm(GenerationsItems.TM_190.get());
        createTm(GenerationsItems.TM_191.get());
        createTm(GenerationsItems.TM_192.get());
        createTm(GenerationsItems.TM_193.get());
        createTm(GenerationsItems.TM_194.get());
        createTm(GenerationsItems.TM_195.get());
        createTm(GenerationsItems.TM_196.get());
        createTm(GenerationsItems.TM_197.get());
        createTm(GenerationsItems.TM_198.get());
        createTm(GenerationsItems.TM_199.get());
        createTm(GenerationsItems.TM_200.get());
        createTm(GenerationsItems.TM_201.get());
        createTm(GenerationsItems.TM_202.get());
        createTm(GenerationsItems.TM_203.get());
        createTm(GenerationsItems.TM_204.get());
        createTm(GenerationsItems.TM_205.get());
        createTm(GenerationsItems.TM_206.get());
        createTm(GenerationsItems.TM_207.get());
        createTm(GenerationsItems.TM_208.get());
        createTm(GenerationsItems.TM_209.get());
        createTm(GenerationsItems.TM_210.get());
        createTm(GenerationsItems.TM_211.get());
        createTm(GenerationsItems.TM_212.get());
        createTm(GenerationsItems.TM_213.get());
        createTm(GenerationsItems.TM_214.get());
        createTm(GenerationsItems.TM_215.get());
        createTm(GenerationsItems.TM_216.get());
        createTm(GenerationsItems.TM_217.get());
        createTm(GenerationsItems.TM_218.get());
        createTm(GenerationsItems.TM_219.get());
        createTm(GenerationsItems.TM_220.get());
        createTm(GenerationsItems.TM_221.get());
        createTm(GenerationsItems.TM_222.get());
        createTm(GenerationsItems.TM_223.get());
        createTm(GenerationsItems.TM_224.get());
        createTm(GenerationsItems.TM_225.get());
        createTm(GenerationsItems.TM_226.get());
        createTm(GenerationsItems.TM_227.get());
        createTm(GenerationsItems.TM_228.get());
        createTm(GenerationsItems.TM_229.get());

        createItemBlock(GenerationsBlocks.BALLONLEA_BLUE_MUSHROOM.get(), "block/");
        createItemBlock(GenerationsBlocks.BALLONLEA_GREEN_MUSHROOM.get(), "block/");
        createItemBlock(GenerationsBlocks.BALLONLEA_PINK_MUSHROOM.get(), "block/");
        createItemBlock(GenerationsBlocks.BALLONLEA_YELLOW_MUSHROOM.get(), "block/");
        createItemBlock(GenerationsBlocks.GROUP_BALLONLEA_BLUE_MUSHROOM.get(), "block/");
        createItemBlock(GenerationsBlocks.GROUP_BALLONLEA_GREEN_MUSHROOM.get(), "block/");
        createItemBlock(GenerationsBlocks.GROUP_BALLONLEA_PINK_MUSHROOM.get(), "block/");
        createItemBlock(GenerationsBlocks.GROUP_BALLONLEA_YELLOW_MUSHROOM.get(), "block/");
        createItemBlock(GenerationsBlocks.TALL_BALLONLEA_BLUE_MUSHROOM.get(), "block/");
        createItemBlock(GenerationsBlocks.TALL_BALLONLEA_GREEN_MUSHROOM.get(), "block/");
        createItemBlock(GenerationsBlocks.TALL_BALLONLEA_PINK_MUSHROOM.get(), "block/");
        createItemBlock(GenerationsBlocks.TALL_BALLONLEA_YELLOW_MUSHROOM.get(), "block/");
        createItemBlock(GenerationsBlocks.DOUBLE_BALLONLEA_BLUE_MUSHROOM.get(), "block/");
        createItemBlock(GenerationsBlocks.DOUBLE_BALLONLEA_GREEN_MUSHROOM.get(), "block/");
        createItemBlock(GenerationsBlocks.DOUBLE_BALLONLEA_PINK_MUSHROOM.get(), "block/");
        createItemBlock(GenerationsBlocks.DOUBLE_BALLONLEA_YELLOW_MUSHROOM.get(), "block/");

        createItemBlock(GenerationsBlocks.FLABEBE_FLOWER_AZ.get(), "block/flowers/");
        createItemBlock(GenerationsBlocks.FLABEBE_FLOWER_BLUE.get(), "block/flowers/");
        createItemBlock(GenerationsBlocks.FLABEBE_FLOWER_ORANGE.get(), "block/flowers/");
        createItemBlock(GenerationsBlocks.FLABEBE_FLOWER_RED.get(), "block/flowers/");
        createItemBlock(GenerationsBlocks.FLABEBE_FLOWER_WHITE.get(), "block/flowers/");
        createItemBlock(GenerationsBlocks.FLABEBE_FLOWER_YELLOW.get(), "block/flowers/");

//        createItemBlock(GenerationsDecorationBlocks.SNORLAX_BEAN_BAG.get(), "item/blocks/bean_bags/");
//        createItemBlock(GenerationsDecorationBlocks.HOUSE_LAMP.get(), "item/blocks/decorations/");
//        createItemBlock(GenerationsDecorationBlocks.SWITCH.get(), "item/blocks/decorations/");
//        createItemBlock(GenerationsDecorationBlocks.LITWICK_CANDLE.get(), "item/blocks/decorations/");
//        createItemBlock(GenerationsDecorationBlocks.LITWICK_CANDLES.get(), "item/blocks/decorations/");
//        createDyedGroupItem(GenerationsDecorationBlocks.PASTEL_BEAN_BAG, "bean_bags");
//        createDyedGroupItem(GenerationsDecorationBlocks.VENDING_MACHINE, "vending_machines");
//        createDyedGroupItem(GenerationsDecorationBlocks.SWIVEL_CHAIR, "swivel_chairs");
//        createDyedGroupItem(GenerationsDecorationBlocks.STREET_LAMP, "street_lamp");
//        createDyedGroupItem(GenerationsDecorationBlocks.COUCH_CORNER_LEFT, "couch");
//        createDyedGroupItem(GenerationsDecorationBlocks.COUCH_CORNER_RIGHT, "couch");
//        createDyedGroupItem(GenerationsDecorationBlocks.COUCH_ARM_LEFT, "couch");
//        createDyedGroupItem(GenerationsDecorationBlocks.COUCH_ARM_RIGHT, "couch");
//        createDyedGroupItem(GenerationsDecorationBlocks.COUCH_OTTOMAN, "couch");
//        createDyedGroupItem(GenerationsDecorationBlocks.COUCH_MIDDLE, "couch");

        createItemBlock(GenerationsUtilityBlocks.COOKING_POT.get(), "item/blocks/utility_blocks/");
//        GenerationsUtilityBlocks.HEALER.block().values().forEach(block -> createItemBlockDir(block.get(), "utility_blocks/healer"));
        createItemBlock(GenerationsUtilityBlocks.TABLE_PC.get(), "item/blocks/utility_blocks/");
        createItemBlock(GenerationsUtilityBlocks.ROTOM_PC.get(), "item/blocks/utility_blocks/");
//        GenerationsUtilityBlocks.CLOCK.block().values().forEach(block -> createItemBlockDir(block.get(), "clocks"));
//        GenerationsUtilityBlocks.BALL_LOOTS.forEach(block -> createItemBlock(block.get(), "item/blocks/ball_loots/"));
//        createItemBlock(GenerationsUtilityBlocks.TRASH_CAN.get(), "item/blocks/utility_blocks/");

        createItemBlock(GenerationsBlocks.POKECENTER_SCARLET_SIGN.get(), "item/blocks/sign/");

        createPointedDripstoneItem(GenerationsBlocks.POINTED_CHARGE_DRIPSTONE.get(), "item/blocks/dripstone/");

//        GenerationsShrines.SHRINES.forEach(shrine -> createItemBlock(shrine.get(), "item/blocks/shrines/"));

        createItemBlock(GenerationsBlocks.POKECENTER_DOOR.get(), "item/blocks/doors/");
        createItemBlock(GenerationsWood.ULTRA_JUNGLE_DOOR.get(), "item/blocks/doors/");
        createItemBlock(GenerationsWood.ULTRA_DARK_DOOR.get(), "item/blocks/doors/");
        createItemBlock(GenerationsWood.GHOST_DOOR.get(), "item/blocks/doors/");
        createItem(GenerationsItems.ULTRA_DARK_SIGN.get(), "blocks/sign/");
        createItem(GenerationsItems.ULTRA_DARK_HANGING_SIGN.get(), "blocks/sign/");
        createItem(GenerationsItems.ULTRA_JUNGLE_SIGN.get(), "blocks/sign/");
        createItem(GenerationsItems.ULTRA_JUNGLE_HANGING_SIGN.get(), "blocks/sign/");
        createItem(GenerationsItems.GHOST_SIGN.get(), "blocks/sign/");
        createItem(GenerationsItems.GHOST_HANGING_SIGN.get(), "blocks/sign/");

        createItem(GenerationsItems.RELIC_SONG.get(), "legend_items/");
        createItem(GenerationsItems.INERT_RELIC_SONG.get(), "legend_items/");

//        createItemBlock(GenerationsDecorationBlocks.EMPTY_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.POKE_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.GREAT_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.ULTRA_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.MASTER_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.CHERISH_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.DIVE_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.DUSK_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.FAST_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.FRIEND_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.GS_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.HEAL_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.HEAVY_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.LEVEL_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.LOVE_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.LURE_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.LUXURY_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.MOON_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.NEST_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.NET_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.PARK_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.PREMIER_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.QUICK_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.REPEAT_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.SAFARI_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.SPORT_BALL_DISPLAY.get(), "item/blocks/ball_displays/");
//        createItemBlock(GenerationsDecorationBlocks.TIMER_BALL_DISPLAY.get(), "item/blocks/ball_displays/");

        createEntityModelItem(GenerationsItems.SUICUNE_STATUE.get());
        createEntityModelItem(GenerationsItems.RAIKOU_STATUE.get());
        createEntityModelItem(GenerationsItems.ENTEI_STATUE.get());
    }

    private void createTimeCapsule() {
        var model = createItem(GenerationsItems.TIME_CAPSULE.get(), "player_items/");
        ItemModelBuilder typeModel = this.getBuilder("item/time_capsule_with_pokemon").parent(new ModelFile.UncheckedModelFile("minecraft:builtin/entity"));
        model.override().model(typeModel).predicate(GenerationsCore.id("has_pokemon"), 1f).end();
    }

//    private void createDyedGroupItem(DyedGroup<?, ?> group, String name) {
//        group.block().values().forEach(block -> createItemBlockDir(block.get().asItem(), name));
//    }

    private void registerDisc(ResourceLocation id) {
        this.singleTexture(id.getPath(), new ResourceLocation("item/generated"), "layer0", GenerationsCore.id("item/discs/" + id.getPath()));
    }

    private void createCurry() {
        ItemModelBuilder model = generated(GenerationsItems.CURRY.getId().getPath(), CurryType.None.getResourceLocation());
        CurryType[] values = CurryType.values();
        for (int i = 0; i < values.length; i++) {
            CurryType type = values[i];
            model.override().model(generated(type.getResourceLocation().getPath(), type.getResourceLocation())).predicate(GenerationsCore.id("curry_type"), i).end();
        }
    }

    private void createTm(Item tm) {
        ItemModelBuilder model = generated(tm.builtInRegistryHolder().key().location().getPath(), GenerationsCore.id("item/tms/tm_normal"));

        BiConsumer<String, Float> consumer = (name, i) -> {
            ItemModelBuilder typeModel = generated("item/tms/tm_" + name, GenerationsCore.id("item/tms/tm_" + name));
            model.override().model(typeModel).predicate(GenerationsCore.id("type"), i).end();
        };

        consumer.accept("normal", 0.00f);
        consumer.accept("fire", 0.01f);
        consumer.accept("water", 0.02f);
        consumer.accept("grass", 0.03f);
        consumer.accept("electric", 0.04f);
        consumer.accept("ice", 0.05f);
        consumer.accept("fighting", 0.06f);
        consumer.accept("poison", 0.07f);
        consumer.accept("ground", 0.08f);
        consumer.accept("flying", 0.09f);
        consumer.accept("psychic", 0.10f);
        consumer.accept("bug", 0.1f);
        consumer.accept("rock", 0.12f);
        consumer.accept("ghost", 0.13f);
        consumer.accept("dragon", 0.14f);
        consumer.accept("dark", 0.15f);
        consumer.accept("steel", 0.16f);
        consumer.accept("fairy", 0.17f);
    }

    private void createImbuedFlute() {
        ItemModelBuilder model = createItem(GenerationsItems.MELODY_FLUTE.get(), "legend_items/");

        BiConsumer<String, Float> consumer = (name, i) -> {
            ItemModelBuilder typeModel = generated("item/flute/" + name + "_flute", GenerationsCore.id("item/flute/" + name + "_flute"));
            model.override().model(typeModel).predicate(GenerationsCore.id("flute_type"), i/8f).end();
        };

        consumer.accept("basic", 0f);
        consumer.accept("icy", 1f);
        consumer.accept("elegant", 2f);
        consumer.accept("static", 3f);
        consumer.accept("belligerent", 4f);
        consumer.accept("fiery", 5f);
        consumer.accept("sinister", 6f);
        consumer.accept("rainbow", 7f);
        consumer.accept("silver", 8f);
    }

    private void createCelestialAltar() {
        ItemModelBuilder model = createItemBlockDir(GenerationsShrines.CELESTIAL_ALTAR.get().asItem(), "shrines");

        BiConsumer<String, Float> consumer = (name, i) -> {
            if(!name.isEmpty()) name = "_" + name;
            ItemModelBuilder typeModel = generated("item/blocks/shrines/celestial_altar" + name, GenerationsCore.id("item/blocks/shrines/celestial_altar" + name));
            model.override().model(typeModel).predicate(GenerationsCore.id("time"), i).end();
        };

//        consumer.accept("", 0f);
        consumer.accept("sun", 0.1f);
        consumer.accept("moon", 0.2f);
    }

    private void createLunarShrine() {
        ItemModelBuilder model = createItemBlockDir(GenerationsShrines.LUNAR_SHRINE.get().asItem(), "shrines");

        BiConsumer<String, Float> consumer = (name, i) -> {
            ItemModelBuilder typeModel = generated("item/blocks/shrines/" + name, GenerationsCore.id("item/blocks/shrines/" + name));
            model.override().model(typeModel).predicate(GenerationsCore.id("light_level"), i).end();
        };

        consumer.accept("darkrai_shrine", 0.0f);
        consumer.accept("cresselia_shrine", 0.1f);
    }

    private ResourceLocation getKey(Item item) {
        return ForgeRegistries.ITEMS.getKey(item);
    }

    private void createTmMaterial(Item material) {
        generated(getKey(material).getPath(), GenerationsCore.id("item/tms/tm_material"));
    }

    private void createHeldItem(Item held) {
        createHeldItem(held, "");
    }

    private void createHeldItem(Item held, String directory) {
        createItem(held, "held_items/" + directory);
    }

    public void createPokedoll(Block block) {
        ResourceLocation key = Objects.requireNonNull(getKey(block.asItem()), "Tried to create json model for unregistered Item.");
        ResourceLocation texPath = GenerationsCore.id("item/dolls/" + key.getPath());
        if(key.getPath().startsWith("shiny_"))
            texPath = GenerationsCore.id("item/dolls/shiny/" + key.getPath().replace("shiny_", ""));

        generated(key.getPath(), texPath);
    }

    public ItemModelBuilder createItemBlock(Block block, String directory) {
        ResourceLocation key = Objects.requireNonNull(getKey(block.asItem()), "Tried to create json model for unregistered Item.");
        return generated(key.getPath(), GenerationsCore.id(directory + key.getPath()));
    }

    public void createPointedDripstoneItem(Block block, String directory) {
        ResourceLocation key = Objects.requireNonNull(getKey(block.asItem()), "Tried to create json model for unregistered Item.");
        singleTexture(key.getPath(), mcLoc("item/pointed_dripstone"), "layer0", GenerationsCore.id(directory.concat(key.getPath())));
    }

    public ItemModelBuilder createItemBlockDir(Item block, String directory) {
        ResourceLocation key = Objects.requireNonNull(getKey(block), "Tried to create json model for unregistered Item.");
        return generated(key.getPath(), GenerationsCore.id("item/blocks/" + directory + "/" + key.getPath()));
    }

    public ItemModelBuilder createCurryType(CurryType type) {
        return generated("item/curry/" + type.getSerializedName(), type.getResourceLocation());
    }

    public ItemModelBuilder createItem(Item item, String directory) {
        return createItem(item, directory, "");
    }

    public ItemModelBuilder createItem(Item item, String directory, String override) {
        try {
            ResourceLocation key = Objects.requireNonNull(getKey(item), "Tried to create json model for unregistered Item.");
            return generated(key.getPath(), GenerationsCore.id("item/" + directory + (override.isEmpty() ? key.getPath() : override)));
        } catch (Exception e) {
            LOGGER.error(item.getDescriptionId() + " -> " + directory);
            return null;
        }
    }

    public ItemModelBuilder createEntityModelItem(Item item) {
        ResourceLocation key = Objects.requireNonNull(getKey(item), "Tried to create json model for unregistered Item.");
        return getBuilder(key.getPath()).parent(new ModelFile.UncheckedModelFile(new ResourceLocation("minecraft:builtin/entity")));
    }


    public ItemModelBuilder generated(String name, ResourceLocation model) {
        try {
            return this.singleTexture(name, new ResourceLocation("item/generated"), "layer0", model);
        } catch (Exception e) {
            LOGGER.error("Item: " + name + " -> " + model);
            return this.singleTexture(name, new ResourceLocation("item/generated"), "layer0", GenerationsCore.id("item/placeholder"));
        }
    }

    private void handheldItem(Item item) {
        withExistingParent(getKey(item).getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(GenerationsCore.MOD_ID, "item/tools/" + getKey(item).getPath()));
    }
}
