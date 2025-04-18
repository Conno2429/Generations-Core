package generations.gg.generations.core.generationscore.forge.datagen.generators.tags;

import com.google.common.collect.Streams;
import generations.gg.generations.core.generationscore.common.GenerationsCore;
import generations.gg.generations.core.generationscore.common.tags.GenerationsBlockTags;
import generations.gg.generations.core.generationscore.common.tags.GenerationsItemTags;
import generations.gg.generations.core.generationscore.common.world.item.GenerationsArmor;
import generations.gg.generations.core.generationscore.common.world.item.GenerationsItems;
import generations.gg.generations.core.generationscore.common.world.item.GenerationsTools;
import generations.gg.generations.core.generationscore.common.world.item.tools.GenerationsHammerItem;
import generations.gg.generations.core.generationscore.common.world.level.block.*;
import generations.gg.generations.core.generationscore.common.world.level.block.entities.BallDisplayBlock;
import generations.gg.generations.core.generationscore.common.world.level.block.set.GenerationsFullBlockSet;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.PaintingVariantTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import static generations.gg.generations.core.generationscore.common.world.item.GenerationsItems.*;

public class TagsDatagen {
    public static void init(DataGenerator generator, PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper helper) {
        GenerationsBlockTagsProvider blockProvider = new GenerationsBlockTagsProvider(output, lookupProvider, helper);
        generator.addProvider(true, blockProvider);
        generator.addProvider(true, new GenerationsItemTagsProvider(output, lookupProvider, blockProvider, helper));
        generator.addProvider(true, new GenerationsPaintingTagProvider(output, lookupProvider, helper));
    }

    private static class GenerationsBlockTagsProvider extends BlockTagsProvider {

        public GenerationsBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, lookupProvider, GenerationsCore.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider arg) {

            GenerationsBlocks.BLOCKS.forEach(object -> {
                Block block = object.get();
                EasyBlockTags(block);
                if (object instanceof FenceBlock) tag(BlockTags.FENCES).add(block);
                else if (object instanceof FenceGateBlock) tag(BlockTags.FENCE_GATES).add(block);
                else if (object instanceof DoorBlock) tag(BlockTags.DOORS).add(block);
                else if (object instanceof SandBlock) {
                    tag(BlockTags.SAND).add(block);
                    tag(BlockTags.MINEABLE_WITH_SHOVEL).add(block);
                }
            });

            GenerationsBlocks.ULTRA_BLOCKS.forEach(block -> {
                tag(GenerationsBlockTags.ULTRA).add(block.get());
                EasyBlockTags(block.get());
            });

            GenerationsFullBlockSet.getFullBlockSets().forEach(blockSet -> blockSet.getAllBlocks().forEach(block -> {
                if (blockSet.getName().contains("poke_brick"))
                    tag(GenerationsBlockTags.POKEBRICKS).add(blockSet.getBaseBlock());
                else if (blockSet.getName().contains("marble"))
                    tag(GenerationsBlockTags.MARBLE).add(blockSet.getBaseBlock());
            }));

            GenerationsPokeDolls.POKEDOLLS.forEach(pokedoll -> tag(GenerationsBlockTags.POKEDOLLS).add(pokedoll.get()));

            var mine_with_pickaxe = tag(BlockTags.MINEABLE_WITH_PICKAXE).addTag(GenerationsBlockTags.ULTRA).addTag(GenerationsBlockTags.MARBLE)
                    .addTag(GenerationsBlockTags.POKEBRICKS).addTag(GenerationsBlockTags.GENERATIONSORES).addTag(GenerationsBlockTags.POKEBALL_CHESTS)
                    .addTag(GenerationsBlockTags.BALL_DISPLAY_BLOCKS).add(GenerationsBlocks.Z_BLOCK.get()).add(GenerationsBlocks.LIGHTNING_LANTERN.get());

            GenerationsBlocks.STONE.forEach(block -> {
                mine_with_pickaxe.add(block.get());
                EasyBlockTags(block.get());
                if (block.get() instanceof PressurePlateBlock) tag(BlockTags.STONE_PRESSURE_PLATES).add(block.get());
            });

            mine_with_pickaxe.add(
                            GenerationsUtilityBlocks.CHARGE_STONE_FURNACE.get(),
                    GenerationsUtilityBlocks.CHARGE_STONE_BLAST_FURNACE.get(),
                    GenerationsUtilityBlocks.CHARGE_STONE_SMOKER.get(),
                    GenerationsUtilityBlocks.VOLCANIC_STONE_FURNACE.get(),
                    GenerationsUtilityBlocks.VOLCANIC_STONE_BLAST_FURNACE.get(),
                    GenerationsUtilityBlocks.VOLCANIC_STONE_SMOKER.get(),
                    GenerationsShrines.PRISON_BOTTLE.get(),
                    GenerationsShrines.PRISON_BOTTLE_STEM.get(),
                    GenerationsUtilityBlocks.RKS_MACHINE.get(),
                    GenerationsUtilityBlocks.COOKING_POT.get(),
                    GenerationsUtilityBlocks.TABLE_PC.get(),
                    GenerationsUtilityBlocks.ROTOM_PC.get(),
                    GenerationsUtilityBlocks.TRASH_CAN.get(),
                    GenerationsUtilityBlocks.WHITE_ELEVATOR.get(),
                    GenerationsUtilityBlocks.LIGHT_GRAY_ELEVATOR.get(),
                    GenerationsUtilityBlocks.GRAY_ELEVATOR.get(),
                    GenerationsUtilityBlocks.BLACK_ELEVATOR.get(),
                    GenerationsUtilityBlocks.BROWN_ELEVATOR.get(),
                    GenerationsUtilityBlocks.RED_ELEVATOR.get(),
                    GenerationsUtilityBlocks.ORANGE_ELEVATOR.get(),
                    GenerationsUtilityBlocks.YELLOW_ELEVATOR.get(),
                    GenerationsUtilityBlocks.LIME_ELEVATOR.get(),
                    GenerationsUtilityBlocks.GREEN_ELEVATOR.get(),
                    GenerationsUtilityBlocks.CYAN_ELEVATOR.get(),
                    GenerationsUtilityBlocks.LIGHT_BLUE_ELEVATOR.get(),
                    GenerationsUtilityBlocks.BLUE_ELEVATOR.get(),
                    GenerationsUtilityBlocks.PURPLE_ELEVATOR.get(),
                    GenerationsUtilityBlocks.MAGENTA_ELEVATOR.get(),
                    GenerationsUtilityBlocks.PINK_ELEVATOR.get(),
                    GenerationsDecorationBlocks.DESK.get(),
                    GenerationsDecorationBlocks.FRIDGE.get()
            ).add(GenerationsDecorationBlocks.STREET_LAMP.toArray())
                    .add(GenerationsUtilityBlocks.PC.toArray())
                    .add(GenerationsDecorationBlocks.BALL_DISPLAY_BLOCKS.stream().map(Supplier::get).toArray(BallDisplayBlock[]::new));



            tag(BlockTags.DIRT).add(
                    GenerationsBlocks.ULTRA_SAND.get(),
                    GenerationsBlocks.RICH_SOIL_1.get(),
                    GenerationsBlocks.RICH_SOIL_2.get(),
                    GenerationsBlocks.RICH_SOIL_3.get(),
                    GenerationsBlocks.RICH_SOIL_4.get()
            );

            tag(BlockTags.MINEABLE_WITH_SHOVEL).add(
                    GenerationsBlocks.RUINS_SAND.get(),
                    GenerationsBlocks.RICH_SOIL_1.get(),
                    GenerationsBlocks.RICH_SOIL_2.get(),
                    GenerationsBlocks.RICH_SOIL_3.get(),
                    GenerationsBlocks.RICH_SOIL_4.get()
            );

            GenerationsBlocks.ENCHANTED_OBSIDIAN_SET.getAllBlocks()
                    .forEach(block -> tag(BlockTags.NEEDS_DIAMOND_TOOL).add(block));


            tag(GenerationsBlockTags.POKEBALL_CHESTS)
                    .add(
                            GenerationsBlocks.POKEBALL_CHEST.get(),
                            GenerationsBlocks.GREATBALL_CHEST.get(),
                            GenerationsBlocks.ULTRABALL_CHEST.get(),
                            GenerationsBlocks.MASTERBALL_CHEST.get());
            tag(Tags.Blocks.CHESTS).addTag(GenerationsBlockTags.POKEBALL_CHESTS);

            GenerationsShrines.SHRINES.forEach(block -> tag(GenerationsBlockTags.SHRINES).add(block.get()));

            tag(BlockTags.GUARDED_BY_PIGLINS).addTag(GenerationsBlockTags.POKEBALL_CHESTS);
            tag(BlockTags.FEATURES_CANNOT_REPLACE).addTag(GenerationsBlockTags.POKEBALL_CHESTS);

            GenerationsDecorationBlocks.BALL_DISPLAY_BLOCKS.forEach(block -> tag(GenerationsBlockTags.BALL_DISPLAY_BLOCKS).add(block.get()));
            GenerationsUtilityBlocks.BALL_LOOTS.forEach(block -> tag(GenerationsBlockTags.BALL_LOOTS).add(block.get()));

            tag(GenerationsBlockTags.REGI_STANDS).add(GenerationsBlocks.CASTLE_PILLAR.get(), GenerationsBlocks.GHOST_PILLAR.get(), GenerationsBlocks.PRISMARINE_PILLAR.get(), GenerationsBlocks.ICE_PILLAR.get(), GenerationsBlocks.DARK_PRISMARINE_PILLAR.get());


            //Ore Specific tags
            tag(GenerationsBlockTags.SAPPHIRE_ORES).add(GenerationsOres.SAPPHIRE_ORE_SET.getOre(), GenerationsOres.SAPPHIRE_ORE_SET.getDeepslateOre());
            tag(GenerationsBlockTags.RUBY_ORES).add(GenerationsOres.RUBY_ORE_SET.getOre(), GenerationsOres.RUBY_ORE_SET.getDeepslateOre());
            tag(GenerationsBlockTags.CRYSTAL_ORES).add(GenerationsOres.CRYSTAL_ORE_SET.getOre(), GenerationsOres.CRYSTAL_ORE_SET.getDeepslateOre());
            tag(GenerationsBlockTags.SILICON_ORES).add(GenerationsOres.SILICON_ORE_SET.getOre(), GenerationsOres.SILICON_ORE_SET.getDeepslateOre());
            tag(GenerationsBlockTags.Z_CRYSTAL_ORES).add(GenerationsOres.Z_CRYSTAL_ORE_SET.getOre(), GenerationsOres.Z_CRYSTAL_ORE_SET.getDeepslateOre());
            tag(GenerationsBlockTags.MEGASTONE_ORES).add(GenerationsOres.MEGASTONE_ORE_SET.getOre(), GenerationsOres.MEGASTONE_ORE_SET.getDeepslateOre());
            tag(GenerationsBlockTags.METEORITE_ORES).add(GenerationsOres.METEORITE_ORE_SET.getOre(), GenerationsOres.METEORITE_ORE_SET.getDeepslateOre());
            //Vanilla Ores
            /*
            tag(BlockTags.COAL_ORES).add(GenerationsOres.CHARGE_STONE_COAL_ORE_SET.getOre());
            tag(Tags.Blocks.ORES_COAL).add(GenerationsOres.CHARGE_STONE_COAL_ORE_SET.getOre());
            tag(BlockTags.REDSTONE_ORES).add(GenerationsOres.CHARGE_STONE_REDSTONE_ORE_SET.getOre());
            tag(Tags.Blocks.ORES_REDSTONE).add(GenerationsOres.CHARGE_STONE_REDSTONE_ORE_SET.getOre());
            tag(BlockTags.IRON_ORES).add(GenerationsOres.CHARGE_STONE_IRON_ORE_SET.getOre());
            tag(Tags.Blocks.ORES_IRON).add(GenerationsOres.CHARGE_STONE_IRON_ORE_SET.getOre());
            tag(BlockTags.GOLD_ORES).add(GenerationsOres.CHARGE_STONE_GOLD_ORE_SET.getOre());
            tag(Tags.Blocks.ORES_GOLD).add(GenerationsOres.CHARGE_STONE_GOLD_ORE_SET.getOre());
            tag(BlockTags.COPPER_ORES).add(GenerationsOres.CHARGE_STONE_COPPER_ORE_SET.getOre());
            tag(Tags.Blocks.ORES_COPPER).add(GenerationsOres.CHARGE_STONE_COPPER_ORE_SET.getOre());
            tag(BlockTags.LAPIS_ORES).add(GenerationsOres.CHARGE_STONE_LAPIS_LAZULI_ORE_SET.getOre());
            tag(Tags.Blocks.ORES_LAPIS).add(GenerationsOres.CHARGE_STONE_LAPIS_LAZULI_ORE_SET.getOre());
            tag(BlockTags.DIAMOND_ORES).add(GenerationsOres.CHARGE_STONE_DIAMOND_ORE_SET.getOre());
            tag(Tags.Blocks.ORES_DIAMOND).add(GenerationsOres.CHARGE_STONE_DIAMOND_ORE_SET.getOre());
            tag(BlockTags.EMERALD_ORES).add(GenerationsOres.CHARGE_STONE_EMERALD_ORE_SET.getOre());
            tag(Tags.Blocks.ORES_EMERALD).add(GenerationsOres.CHARGE_STONE_EMERALD_ORE_SET.getOre());

             */

            tag(GenerationsBlockTags.GENERATIONSORES)
                    .addTag(GenerationsBlockTags.SAPPHIRE_ORES)
                    .addTag(GenerationsBlockTags.RUBY_ORES)
                    .addTag(GenerationsBlockTags.CRYSTAL_ORES)
                    .addTag(GenerationsBlockTags.SILICON_ORES)
                    .addTag(GenerationsBlockTags.Z_CRYSTAL_ORES)
                    .addTag(GenerationsBlockTags.MEGASTONE_ORES)
                    .addTag(GenerationsBlockTags.METEORITE_ORES);
                    /*
                    .add(GenerationsOres.CHARGE_STONE_COAL_ORE_SET.getOre())
                    .add(GenerationsOres.CHARGE_STONE_REDSTONE_ORE_SET.getOre())
                    .add(GenerationsOres.CHARGE_STONE_IRON_ORE_SET.getOre())
                    .add(GenerationsOres.CHARGE_STONE_GOLD_ORE_SET.getOre())
                    .add(GenerationsOres.CHARGE_STONE_COPPER_ORE_SET.getOre())
                    .add(GenerationsOres.CHARGE_STONE_LAPIS_LAZULI_ORE_SET.getOre())
                    .add(GenerationsOres.CHARGE_STONE_DIAMOND_ORE_SET.getOre())
                    .add(GenerationsOres.CHARGE_STONE_EMERALD_ORE_SET.getOre());
                     */



            GenerationsWood.WOOD_BLOCKS.forEach(block -> {
                Block woodBlock = block.get();
                tag(BlockTags.MINEABLE_WITH_AXE).add(woodBlock);
                if (woodBlock.getName().getString().contains("planks")) tag(BlockTags.PLANKS).add(woodBlock);
                else if (woodBlock instanceof TrapDoorBlock) tag(BlockTags.WOODEN_TRAPDOORS).add(woodBlock);
                else if (woodBlock instanceof DoorBlock) tag(BlockTags.WOODEN_DOORS).add(woodBlock);
                else if (woodBlock instanceof StandingSignBlock) tag(BlockTags.STANDING_SIGNS).add(woodBlock);
                else if (woodBlock instanceof SlabBlock) tag(BlockTags.WOODEN_SLABS).add(woodBlock);
                else if (woodBlock instanceof StairBlock) tag(BlockTags.WOODEN_STAIRS).add(woodBlock);
                else if (woodBlock instanceof FenceBlock) tag(BlockTags.WOODEN_FENCES).add(woodBlock);
                else if (woodBlock instanceof FenceGateBlock) {
                    tag(BlockTags.FENCE_GATES).add(woodBlock);
                    tag(Tags.Blocks.FENCE_GATES_WOODEN).add(woodBlock);
                }
                else if (woodBlock instanceof PressurePlateBlock)
                    tag(BlockTags.WOODEN_PRESSURE_PLATES).add(woodBlock);
                else if (woodBlock instanceof ButtonBlock) tag(BlockTags.WOODEN_BUTTONS).add(woodBlock);
                else if (woodBlock instanceof CeilingHangingSignBlock)
                    tag(BlockTags.CEILING_HANGING_SIGNS).add(woodBlock);
                else if (woodBlock instanceof WallHangingSignBlock)
                    tag(BlockTags.WALL_HANGING_SIGNS).add(woodBlock);
                else if (woodBlock.getName().getString().contains("book")) {
                    tag(Tags.Blocks.BOOKSHELVES).add(woodBlock);
                    tag(BlockTags.ENCHANTMENT_POWER_PROVIDER).add(woodBlock);
                }
            });

            tag(GenerationsBlockTags.GHOST_LOGS).add(GenerationsWood.GHOST_LOG.get(), GenerationsWood.STRIPPED_GHOST_LOG.get());

            tag(GenerationsBlockTags.ULTRA_DARK_LOGS).add(GenerationsWood.ULTRA_DARK_LOG.get(), GenerationsWood.STRIPPED_ULTRA_DARK_LOG.get());

            tag(GenerationsBlockTags.ULTRA_JUNGLE_LOGS).add(GenerationsWood.ULTRA_JUNGLE_LOG.get(), GenerationsWood.STRIPPED_ULTRA_JUNGLE_LOG.get());

            tag(BlockTags.LOGS).addTag(GenerationsBlockTags.GHOST_LOGS).addTag(GenerationsBlockTags.ULTRA_DARK_LOGS).addTag(GenerationsBlockTags.ULTRA_JUNGLE_LOGS);
            tag(BlockTags.LOGS_THAT_BURN).addTag(GenerationsBlockTags.GHOST_LOGS).addTag(GenerationsBlockTags.ULTRA_DARK_LOGS).addTag(GenerationsBlockTags.ULTRA_JUNGLE_LOGS);

            GenerationsWood.WOOD_SIGN.forEach(sign -> {
                if (sign.get() instanceof WallSignBlock) tag(BlockTags.WALL_SIGNS).add(sign.get());
                else if (sign.get() instanceof WallHangingSignBlock) tag(BlockTags.WALL_HANGING_SIGNS).add(sign.get());
            });

            //Charge and Volcanic Stone Brick Tags like Vanilla
            tag(GenerationsBlockTags.CHARGE_STONE_BRICKS)
                    .add(GenerationsBlocks.CHARGE_STONE_BRICKS.get(), GenerationsBlocks.MOSSY_CHARGE_STONE_BRICKS_SET.getBaseBlock(), GenerationsBlocks.CRACKED_CHARGE_STONE_BRICKS.get(), GenerationsBlocks.CHISELED_CHARGE_STONE_BRICKS.get());

            tag(GenerationsBlockTags.VOLCANIC_STONE_BRICKS)
                    .add(GenerationsBlocks.VOLCANIC_STONE_BRICKS.get(), GenerationsBlocks.MOSSY_VOLCANIC_STONE_BRICKS_SET.getBaseBlock(), GenerationsBlocks.CRACKED_VOLCANIC_STONE_BRICKS.get(), GenerationsBlocks.CHISELED_VOLCANIC_STONE_BRICKS.get());

            tag(BlockTags.MINEABLE_WITH_AXE).add(GenerationsBlocks.CURSED_PUMPKIN.get(), GenerationsBlocks.CURSED_JACK_O_LANTERN.get(), GenerationsBlocks.CURSED_CARVED_PUMPKIN.get(), GenerationsUtilityBlocks.SCARECROW.get(), GenerationsUtilityBlocks.BOX.get())
                    .add(GenerationsDecorationBlocks.COUCH_ARM_LEFT.toArray())
                    .add(GenerationsDecorationBlocks.COUCH_ARM_RIGHT.toArray())
                    .add(GenerationsDecorationBlocks.COUCH_CORNER_LEFT.toArray())
                    .add(GenerationsDecorationBlocks.COUCH_CORNER_RIGHT.toArray())
                    .add(GenerationsDecorationBlocks.COUCH_MIDDLE.toArray())
                    .add(GenerationsDecorationBlocks.COUCH_OTTOMAN.toArray());
            tag(BlockTags.ENDERMAN_HOLDABLE).add(GenerationsBlocks.CURSED_PUMPKIN.get(), GenerationsBlocks.CURSED_CARVED_PUMPKIN.get());
            tag(BlockTags.SWORD_EFFICIENT).add(GenerationsBlocks.CURSED_PUMPKIN.get(), GenerationsBlocks.CURSED_JACK_O_LANTERN.get(), GenerationsBlocks.CURSED_CARVED_PUMPKIN.get());

            tag(BlockTags.NEEDS_IRON_TOOL).addTag(GenerationsBlockTags.GENERATIONSORES);
            tag(Tags.Blocks.ORES).addTag(GenerationsBlockTags.GENERATIONSORES);
            tag(BlockTags.NEEDS_STONE_TOOL).add(
                    GenerationsBlocks.SAPPHIRE_BLOCK.get(),
                    GenerationsBlocks.SAPPHIRE_SLAB.get(),
                    GenerationsBlocks.SAPPHIRE_STAIRS.get(),
                    GenerationsBlocks.SAPPHIRE_WALL.get(),
                    GenerationsBlocks.RUBY_BLOCK.get(),
                    GenerationsBlocks.RUBY_SLAB.get(),
                    GenerationsBlocks.RUBY_STAIRS.get(),
                    GenerationsBlocks.RUBY_WALL.get(),
                    GenerationsBlocks.CRYSTAL_BLOCK.get(),
                    GenerationsBlocks.CRYSTAL_SLAB.get(),
                    GenerationsBlocks.CRYSTAL_STAIRS.get(),
                    GenerationsBlocks.CRYSTAL_WALL.get(),
                    GenerationsBlocks.SILICON_BLOCK.get())
                    .addTag(GenerationsBlockTags.BALL_DISPLAY_BLOCKS);

            tag(BlockTags.SNOW_LAYER_CANNOT_SURVIVE_ON).add(GenerationsBlocks.POKECENTER_SCARLET_SIGN.get()).addTag(GenerationsBlockTags.SHRINES).addTag(GenerationsBlockTags.BALL_DISPLAY_BLOCKS).addTag(GenerationsBlockTags.BALL_LOOTS).addTag(GenerationsBlockTags.POKEDOLLS);

            tag(GenerationsBlockTags.TAPU_SUMMONING).add(GenerationsShrines.TAPU_SHRINE.get());
        }

        private void EasyBlockTags(Block object) {
            if (object instanceof SlabBlock) tag(BlockTags.SLABS).add(object);
            else if (object instanceof StairBlock) tag(BlockTags.STAIRS).add(object);
            else if (object instanceof WallBlock) tag(BlockTags.WALLS).add(object);
            else if (object instanceof ButtonBlock) tag(BlockTags.BUTTONS).add(object);
            else if (object instanceof PressurePlateBlock) tag(BlockTags.PRESSURE_PLATES).add(object);

            SoundType type = object.defaultBlockState().getSoundType();
            if (type == SoundType.STONE || type == SoundType.DEEPSLATE)
                tag(BlockTags.MINEABLE_WITH_PICKAXE).add(object);
        }

    }

    private static class GenerationsItemTagsProvider extends ItemTagsProvider {

        public GenerationsItemTagsProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
            super(arg, completableFuture, blockTagsProvider.contentsGetter(), GenerationsCore.MOD_ID, existingFileHelper);
        }


        @Override
        protected void addTags(HolderLookup.@NotNull Provider arg) {
            //Copy Block tags to item version
            copy(BlockTags.PLANKS, ItemTags.PLANKS);
            copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
            copy(BlockTags.BUTTONS, ItemTags.BUTTONS);
            copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
            copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
            copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
            copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
            copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
            copy(Tags.Blocks.FENCE_GATES_WOODEN, Tags.Items.FENCE_GATES_WOODEN);
            copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
            //copy(BlockTags.DOORS, ItemTags.DOORS);
            //copy(BlockTags.SAND, ItemTags.SAND);
            copy(BlockTags.SLABS, ItemTags.SLABS);
            copy(BlockTags.WALLS, ItemTags.WALLS);
            copy(BlockTags.STAIRS, ItemTags.STAIRS);
            copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
            //copy(BlockTags.FENCES, ItemTags.FENCES);
            copy(BlockTags.DIRT, ItemTags.DIRT);
            copy(BlockTags.STANDING_SIGNS, ItemTags.SIGNS);
            tag(ItemTags.LOGS).addTag(GenerationsItemTags.ULTRA_DARK_LOGS).addTag(GenerationsItemTags.ULTRA_JUNGLE_LOGS).addTag(GenerationsItemTags.GHOST_LOGS);
            tag(ItemTags.LOGS_THAT_BURN).addTag(GenerationsItemTags.ULTRA_DARK_LOGS).addTag(GenerationsItemTags.ULTRA_JUNGLE_LOGS).addTag(GenerationsItemTags.GHOST_LOGS);
            copy(GenerationsBlockTags.ULTRA_DARK_LOGS, GenerationsItemTags.ULTRA_DARK_LOGS);
            copy(GenerationsBlockTags.ULTRA_JUNGLE_LOGS, GenerationsItemTags.ULTRA_JUNGLE_LOGS);
            copy(GenerationsBlockTags.GHOST_LOGS, GenerationsItemTags.GHOST_LOGS);
            copy(Tags.Blocks.BOOKSHELVES, Tags.Items.BOOKSHELVES);

            //PokeBricks
            copy(GenerationsBlockTags.POKEBRICKS, GenerationsItemTags.POKEBRICKS);
            //Marble
            copy(GenerationsBlockTags.MARBLE, GenerationsItemTags.MARBLE);
            //Ultra
            copy(GenerationsBlockTags.ULTRA, GenerationsItemTags.ULTRA);
            //PokeDolls
            copy(GenerationsBlockTags.POKEDOLLS, GenerationsItemTags.POKEDOLLS);

            //Ore Specific tags like Vanilla
            copy(GenerationsBlockTags.GENERATIONSORES, GenerationsItemTags.GENERATIONSORES);
            copy(Tags.Blocks.ORES, Tags.Items.ORES);
            copy(GenerationsBlockTags.SAPPHIRE_ORES, GenerationsItemTags.SAPPHIRE_ORES);
            copy(GenerationsBlockTags.RUBY_ORES, GenerationsItemTags.RUBY_ORES);
            copy(GenerationsBlockTags.CRYSTAL_ORES, GenerationsItemTags.CRYSTAL_ORES);
            copy(GenerationsBlockTags.SILICON_ORES, GenerationsItemTags.SILICON_ORES);
            copy(GenerationsBlockTags.Z_CRYSTAL_ORES, GenerationsItemTags.Z_CRYSTAL_ORES);
            copy(GenerationsBlockTags.MEGASTONE_ORES, GenerationsItemTags.MEGASTONE_ORES);
            copy(GenerationsBlockTags.METEORITE_ORES, GenerationsItemTags.METEORITE_ORES);
            /*
            tag(ItemTags.COAL_ORES).add(GenerationsOres.CHARGE_STONE_COAL_ORE_SET.getOre().asItem());
            tag(ItemTags.IRON_ORES).add(GenerationsOres.CHARGE_STONE_IRON_ORE_SET.getOre().asItem());
            tag(ItemTags.GOLD_ORES).add(GenerationsOres.CHARGE_STONE_GOLD_ORE_SET.getOre().asItem());
            tag(ItemTags.COPPER_ORES).add(GenerationsOres.CHARGE_STONE_COPPER_ORE_SET.getOre().asItem());
            tag(ItemTags.DIAMOND_ORES).add(GenerationsOres.CHARGE_STONE_DIAMOND_ORE_SET.getOre().asItem());
            tag(ItemTags.EMERALD_ORES).add(GenerationsOres.CHARGE_STONE_EMERALD_ORE_SET.getOre().asItem());
            tag(ItemTags.LAPIS_ORES).add(GenerationsOres.CHARGE_STONE_LAPIS_LAZULI_ORE_SET.getOre().asItem());
            tag(ItemTags.REDSTONE_ORES).add(GenerationsOres.CHARGE_STONE_REDSTONE_ORE_SET.getOre().asItem());

             */

            /*
            copy(Tags.Blocks.ORES_COAL, Tags.Items.ORES_COAL);
            copy(Tags.Blocks.ORES_IRON, Tags.Items.ORES_IRON);
            copy(Tags.Blocks.ORES_GOLD, Tags.Items.ORES_GOLD);
            copy(Tags.Blocks.ORES_COPPER, Tags.Items.ORES_COPPER);
            copy(Tags.Blocks.ORES_DIAMOND, Tags.Items.ORES_DIAMOND);
            copy(Tags.Blocks.ORES_EMERALD, Tags.Items.ORES_EMERALD);
            copy(Tags.Blocks.ORES_LAPIS, Tags.Items.ORES_LAPIS);
            copy(Tags.Blocks.ORES_REDSTONE, Tags.Items.ORES_REDSTONE);
             */
            //Charge and Volcanic Stone Brick Tags like Vanilla
            copy(GenerationsBlockTags.CHARGE_STONE_BRICKS, GenerationsItemTags.CHARGE_STONE_BRICKS);
            copy(GenerationsBlockTags.VOLCANIC_STONE_BRICKS, GenerationsItemTags.VOLCANIC_STONE_BRICKS);
            copy(GenerationsBlockTags.POKEBALL_CHESTS, GenerationsItemTags.POKEBALL_CHESTS);
            tag(Tags.Items.CHESTS).addTag(GenerationsItemTags.POKEBALL_CHESTS);

            //Discs
            tag(ItemTags.MUSIC_DISCS).add(
                    RELIC_SONG.get(),
                    INERT_RELIC_SONG.get(),
                    AZALEA_TOWN_DISC.get(),
                    CASCARRAFA_CITY_DISC.get(),
                    CERULEAN_CITY_DISC.get(),
                    ETERNA_CITY_DISC.get(),
                    GOLDENROD_CITY_DISC.get(),
                    ICIRRUS_CITY_DISC.get(),
                    JUBILIFE_VILLAGE_DISC.get(),
                    LAKE_OF_RAGE_DISC.get(),
                    LAVERRE_CITY_DISC.get(),
                    LILLIE_DISC.get(),
                    POKEMON_CENTER_DISC.get(),
                    ROUTE_228_DISC.get(),
                    SLUMBERING_WEALD_DISC.get(),
                    SURF_DISC.get(),
                    VERMILION_CITY_DISC.get(),
                    CYNTHIA_DISC.get(),
                    DEOXYS_DISC.get(),
                    IRIS_DISC.get(),
                    KANTO_DISC.get(),
                    LUSAMINE_DISC.get(),
                    NEMONA_DISC.get(),
                    NESSA_DISC.get(),
                    PENNY_DISC.get(),
                    RIVAL_DISC.get(),
                    SADA_AND_TURO_DISC.get(),
                    SOUTH_PROVINCE_DISC.get(),
                    TEAM_ROCKET_DISC.get(),
                    ULTRA_NECROZMA_DISC.get(),
                    XY_LEGENDARY_DISC.get(),
                    ZINNIA_DISC.get(),
                    LAVENDER_TOWN_DISC.get(),
                    LUGIA_DISC.get(),
                    MT_PYRE_DISC.get()
            );

            tag(ItemTags.BOATS).add(GHOST_BOAT_ITEM.get()).add(ULTRA_DARK_BOAT_ITEM.get()).add(ULTRA_JUNGLE_BOAT_ITEM.get());
            tag(ItemTags.CHEST_BOATS).add(GHOST_CHEST_BOAT_ITEM.get()).add(ULTRA_DARK_CHEST_BOAT_ITEM.get()).add(ULTRA_JUNGLE_CHEST_BOAT_ITEM.get());

            tag(ItemTags.STONE_TOOL_MATERIALS).add(GenerationsBlocks.CHARGE_COBBLESTONE_SET.getBaseBlock().asItem()).add(GenerationsBlocks.VOLCANIC_COBBLESTONE_SET.getBaseBlock().asItem());
            GenerationsTools.TOOLS.forEach(tool -> {
                Item item = tool.get();
                if (item instanceof PickaxeItem) tag(ItemTags.PICKAXES).add(item);
                else if (item instanceof AxeItem) tag(ItemTags.AXES).add(item);
                else if (item instanceof ShovelItem) tag(ItemTags.SHOVELS).add(item);
                else if (item instanceof HoeItem) tag(ItemTags.HOES).add(item);
                else if (item instanceof SwordItem) tag(ItemTags.SWORDS).add(item);
                else if (item instanceof GenerationsHammerItem) tag(GenerationsItemTags.HAMMERS).add(item);
            });

            tag(ItemTags.TOOLS).addTag(GenerationsItemTags.HAMMERS);
            tag(Tags.Items.TOOLS).addTag(GenerationsItemTags.HAMMERS);

            tag(GenerationsItemTags.RIBBONS).add(Streams.stream(RIBBONS.iterator()).map(a -> a.get()).toArray(Item[]::new));
            tag(GenerationsItemTags.BADGES).add(Streams.stream(BADGES.iterator()).map(a -> a.get()).toArray(Item[]::new));

            tag(GenerationsItemTags.UNIMPLEMENTED).add(Streams.stream(UNIMPLEMENTED.iterator()).map(a -> a.get()).toArray(Item[]::new));
            tag(GenerationsItemTags.CUISINE).add(Streams.stream(CUISINE.iterator()).map(a -> a.get()).toArray(Item[]::new));
	        tag(GenerationsItemTags.NATURAL).add(Streams.stream(NATURAL.iterator()).map(a -> a.get()).toArray(Item[]::new));
	        tag(GenerationsItemTags.RESTORATION).add(Streams.stream(RESTORATION.iterator()).map(a -> a.get()).toArray(Item[]::new));
	        tag(GenerationsItemTags.PLAYER_ITEMS).add(Streams.stream(PLAYER_ITEMS.iterator()).map(a -> a.get()).toArray(Item[]::new));
	        tag(GenerationsItemTags.HELD_ITEMS).add(Streams.stream(HELD_ITEMS.iterator()).map(a -> a.get()).toArray(Item[]::new));
	        tag(GenerationsItemTags.LEGENDARY_ITEMS).add(Streams.stream(LEGENDARY_ITEMS.iterator()).map(a -> a.get()).toArray(Item[]::new));
	        tag(GenerationsItemTags.UTILITY).add(Streams.stream(UTILITY.iterator()).map(a -> a.get()).toArray(Item[]::new));
	        tag(GenerationsItemTags.VALUABLES).add(Streams.stream(VALUABLES.iterator()).map(a -> a.get()).toArray(Item[]::new));
	        tag(GenerationsItemTags.FORM_ITEMS).add(Streams.stream(FORM_ITEMS.iterator()).map(a -> a.get()).toArray(Item[]::new));
	        tag(GenerationsItemTags.BUILDING_BLOCKS).add(Streams.stream(BUILDING_BLOCKS.iterator()).map(a -> a.get()).toArray(Item[]::new));

	        var generationsItemsTag = tag(GenerationsItemTags.GENERATIONSITEMS)
                    .addTag(GenerationsItemTags.RIBBONS)
                    .addTag(GenerationsItemTags.BADGES)
                    .addTag(GenerationsItemTags.UNIMPLEMENTED)
                    .addTag(GenerationsItemTags.CUISINE)
                    .addTag(GenerationsItemTags.NATURAL)
                    .addTag(GenerationsItemTags.RESTORATION)
                    .addTag(GenerationsItemTags.PLAYER_ITEMS)
                    .addTag(GenerationsItemTags.HELD_ITEMS)
                    .addTag(GenerationsItemTags.LEGENDARY_ITEMS)
                    .addTag(GenerationsItemTags.UTILITY)
                    .addTag(GenerationsItemTags.VALUABLES)
                    .addTag(GenerationsItemTags.FORM_ITEMS)
                    .addTag(GenerationsItemTags.BUILDING_BLOCKS)
                    .addTag(GenerationsItemTags.POKEMAIL)
                    .addTag(GenerationsItemTags.CLOSED_POKEMAIL);

            ITEMS.forEach(item -> generationsItemsTag.add(item.getKey()));

            tag(GenerationsItemTags.POKEMAIL).add(
                    POKEMAIL_AIR.get(),
                    POKEMAIL_BLOOM.get(),
                    POKEMAIL_BRICK.get(),
                    POKEMAIL_BRIDGE_D.get(),
                    POKEMAIL_BRIDGE_M.get(),
                    POKEMAIL_BRIDGE_S.get(),
                    POKEMAIL_BRIDGE_T.get(),
                    POKEMAIL_BRIDGE_V.get(),
                    POKEMAIL_BUBBLE.get(),
                    POKEMAIL_DREAM.get(),
                    POKEMAIL_FAB.get(),
                    POKEMAIL_FAVORED.get(),
                    POKEMAIL_FLAME.get(),
                    POKEMAIL_GLITTER.get(),
                    POKEMAIL_GRASS.get(),
                    POKEMAIL_GREET.get(),
                    POKEMAIL_HARBOR.get(),
                    POKEMAIL_HEART.get(),
                    POKEMAIL_INQUIRY.get(),
                    POKEMAIL_LIKE.get(),
                    POKEMAIL_MECH.get(),
                    POKEMAIL_MOSAIC.get(),
                    POKEMAIL_ORANGE.get(),
                    POKEMAIL_REPLY.get(),
                    POKEMAIL_RETRO.get(),
                    POKEMAIL_RSVP.get(),
                    POKEMAIL_SHADOW.get(),
                    POKEMAIL_SNOW.get(),
                    POKEMAIL_SPACE.get(),
                    POKEMAIL_STEEL.get(),
                    POKEMAIL_THANKS.get(),
                    POKEMAIL_TROPIC.get(),
                    POKEMAIL_TUNNEL.get(),
                    POKEMAIL_WAVE.get(),
                    POKEMAIL_WOOD.get());

            tag(GenerationsItemTags.CLOSED_POKEMAIL).add(
                    POKEMAIL_AIR_CLOSED.get(),
                    POKEMAIL_BLOOM_CLOSED.get(),
                    POKEMAIL_BRICK_CLOSED.get(),
                    POKEMAIL_BRIDGE_D_CLOSED.get(),
                    POKEMAIL_BRIDGE_M_CLOSED.get(),
                    POKEMAIL_BRIDGE_T_CLOSED.get(),
                    POKEMAIL_BRIDGE_S_CLOSED.get(),
                    POKEMAIL_BRIDGE_V_CLOSED.get(),
                    POKEMAIL_BUBBLE_CLOSED.get(),
                    POKEMAIL_DREAM_CLOSED.get(),
                    POKEMAIL_FAB_CLOSED.get(),
                    POKEMAIL_FAVORED_CLOSED.get(),
                    POKEMAIL_FLAME_CLOSED.get(),
                    POKEMAIL_GLITTER_CLOSED.get(),
                    POKEMAIL_GRASS_CLOSED.get(),
                    POKEMAIL_GREET_CLOSED.get(),
                    POKEMAIL_HARBOR_CLOSED.get(),
                    POKEMAIL_HEART_CLOSED.get(),
                    POKEMAIL_INQUIRY_CLOSED.get(),
                    POKEMAIL_LIKE_CLOSED.get(),
                    POKEMAIL_MECH_CLOSED.get(),
                    POKEMAIL_MOSAIC_CLOSED.get(),
                    POKEMAIL_ORANGE_CLOSED.get(),
                    POKEMAIL_REPLY_CLOSED.get(),
                    POKEMAIL_RETRO_CLOSED.get(),
                    POKEMAIL_RSVP_CLOSED.get(),
                    POKEMAIL_SHADOW_CLOSED.get(),
                    POKEMAIL_SNOW_CLOSED.get(),
                    POKEMAIL_SPACE_CLOSED.get(),
                    POKEMAIL_STEEL_CLOSED.get(),
                    POKEMAIL_THANKS_CLOSED.get(),
                    POKEMAIL_TROPIC_CLOSED.get(),
                    POKEMAIL_TUNNEL_CLOSED.get(),
                    POKEMAIL_WAVE_CLOSED.get(),
                    POKEMAIL_WOOD_CLOSED.get());

            tag(GenerationsItemTags.SHEARS).add(Items.SHEARS).addOptionalTag(Tags.Items.SHEARS).addOptionalTag(Objects.requireNonNull(ResourceLocation.tryParse("c:shears")));

            //Forge Armor Tags
            GenerationsArmor.ARMOR.forEach(armor -> {
                switch (((ArmorItem) armor.get()).getType()){
                    case HELMET -> tag(Tags.Items.ARMORS_HELMETS).add(armor.get());
                    case CHESTPLATE -> tag(Tags.Items.ARMORS_CHESTPLATES).add(armor.get());
                    case LEGGINGS -> tag(Tags.Items.ARMORS_LEGGINGS).add(armor.get());
                    case BOOTS -> tag(Tags.Items.ARMORS_BOOTS).add(armor.get());
                }
            });

            tag(GenerationsItemTags.KEY_STONES)
                    .add(KEY_STONE.getKey())
                    .add(KEY_STONE_2.getKey())
                    .add(MEGA_RING.getKey())
                    .add(MEGA_BRACELET.getKey())
                    .add(MEGA_CHARM.getKey())
                    .add(MEGA_CUFF.getKey());
            tag(GenerationsItemTags.DYNAMAX_BANDS).add(DYNAMAX_BAND.getKey());
            tag(GenerationsItemTags.Z_RINGS).add(Z_RING.getKey()).add(Z_POWER_RING.getKey());
            tag(GenerationsItemTags.MEMORY_DRIVES).add(
                    BUG_MEMORY_DRIVE.get(),
                    DARK_MEMORY_DRIVE.get(),
                    DRAGON_MEMORY_DRIVE.get(),
                    ELECTRIC_MEMORY_DRIVE.get(),
                    FAIRY_MEMORY_DRIVE.get(),
                    FIGHTING_MEMORY_DRIVE.get(),
                    FIRE_MEMORY_DRIVE.get(),
                    FLYING_MEMORY_DRIVE.get(),
                    GHOST_MEMORY_DRIVE.get(),
                    GRASS_MEMORY_DRIVE.get(),
                    GROUND_MEMORY_DRIVE.get(),
                    ICE_MEMORY_DRIVE.get(),
                    POISON_MEMORY_DRIVE.get(),
                    PSYCHIC_MEMORY_DRIVE.get(),
                    ROCK_MEMORY_DRIVE.get(),
                    STEEL_MEMORY_DRIVE.get(),
                    WATER_MEMORY_DRIVE.get()
            );

            tag(ItemTags.TRIMMABLE_ARMOR).add(Streams.stream(GenerationsArmor.ARMOR.iterator()).map(Supplier::get).toArray(Item[]::new));
        }
    }

    private static class GenerationsPaintingTagProvider extends PaintingVariantTagsProvider {

        public GenerationsPaintingTagProvider(PackOutput arg, CompletableFuture<HolderLookup.Provider> completableFuture, @Nullable ExistingFileHelper existingFileHelper) {
            super(arg, completableFuture, GenerationsCore.MOD_ID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.@NotNull Provider arg) {
            GenerationsPaintings.PAINTINGS.forEach(painting -> tag(PaintingVariantTags.PLACEABLE).add(TagEntry.element(Objects.requireNonNull(ForgeRegistries.PAINTING_VARIANTS.getKey(painting.get())))));
        }
    }
}
