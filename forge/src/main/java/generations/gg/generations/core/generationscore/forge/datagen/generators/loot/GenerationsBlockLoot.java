package generations.gg.generations.core.generationscore.forge.datagen.generators.loot;

import com.cobblemon.mod.common.CobblemonItems;
import dev.architectury.registry.registries.RegistrySupplier;
import generations.gg.generations.core.generationscore.common.config.LegendKeys;
import generations.gg.generations.core.generationscore.common.world.item.GenerationsItems;
import generations.gg.generations.core.generationscore.common.world.level.block.*;
import generations.gg.generations.core.generationscore.common.world.level.block.generic.GenericRotatableModelBlock;
import generations.gg.generations.core.generationscore.common.world.level.block.set.GenerationsBlockSet;
import generations.gg.generations.core.generationscore.common.world.level.block.set.GenerationsFullBlockSet;
import generations.gg.generations.core.generationscore.common.world.level.block.set.GenerationsOreSet;
import generations.gg.generations.core.generationscore.common.world.level.block.set.GenerationsUltraBlockSet;
import generations.gg.generations.core.generationscore.common.world.level.block.shrines.PrisonBottleStemBlock;
import generations.gg.generations.core.generationscore.common.world.loot.SpeciesKeyCondition;
import generations.gg.generations.core.generationscore.forge.datagen.generators.blocks.BlockDatagen;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.AlternativesEntry;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

class GenerationsBlockLoot extends BlockLootSubProvider {

    private final List<Block> knownBlocks = new ArrayList<>();

    protected GenerationsBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        GenerationsBlocks.STONE.forEach(block -> dropSelfStoneCobble(block.get()));
        GenerationsWood.WOOD_BLOCKS.forEach(block -> dropSelfUpdated(block.get()));

        GenerationsBlocks.ULTRA_BLOCKS.forEach(block -> dropSelfUpdated(block.get()));
        //createDoubleDyedBlock(GenerationsUtilityBlocks.PC.get(), PCBlock.HALF, DoubleBlockHalf.LOWER);
        //createDyedBlock(GenerationsUtilityBlocks.CLOCK.get());
        //createDyedBlock(GenerationsDecorationBlocks.UMBRELLA.get());
        //createDyedBlock(GenerationsDecorationBlocks.PASTEL_BEAN_BAG.get());
        //createDyedBlock(GenerationsDecorationBlocks.VENDING_MACHINE.get());
        //GenerationsDecorationBlocks.VENDING_MACHINE_BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> add(block, createSinglePropConditionTable(block, DoubleDyeableBlock.HALF, DoubleBlockHalf.LOWER)));
        GenerationsPokeDolls.POKEDOLLS.forEach(block -> dropSelf(block.get()));
        BlockDatagen.dropSelfList.stream().map(block -> (Block) block).forEach(this::dropSelf);
        dropSelf(GenerationsShrines.DARK_CRYSTAL);
        dropSelf(GenerationsShrines.LIGHT_CRYSTAL);
        BlockDatagen.MUSHROOM_BLOCKS.forEach(block -> add(block, createMushroomBlockDrop(block, block.asItem())));
        GenerationsFullBlockSet.getFullBlockSets().forEach(generationsFullBlockSet -> generationsFullBlockSet.getAllBlocks().forEach(this::dropSelfUpdated));
        GenerationsBlockSet.getBlockSets().forEach(generationsBlockSet -> generationsBlockSet.getAllBlocks().forEach(this::dropSelfUpdated));
        GenerationsUltraBlockSet.ultraBlockSets.forEach(generationsBlockSet -> generationsBlockSet.getAllBlocks().forEach(this::dropSelfUpdated));

        add(GenerationsBlocks.CHARGE_STONE_SET.getBaseBlock(), createSingleItemTable(GenerationsBlocks.CHARGE_COBBLESTONE_SET.getBaseBlock()));

        dropSelf(GenerationsBlocks.VOLCANIC_FIRESTONE.get());

        dropSelf(GenerationsBlocks.GOLDEN_TEMPLE_SAND.get());

        //Ores
        addOreSet(GenerationsOres.CRYSTAL_ORE_SET);
        addOreSet(GenerationsOres.RUBY_ORE_SET);
        addOreSet(GenerationsOres.SAPPHIRE_ORE_SET);
        addOreSet(GenerationsOres.SILICON_ORE_SET);

        dropSelf(GenerationsOres.Z_CRYSTAL_ORE_SET.getOre());
        dropSelf(GenerationsOres.Z_CRYSTAL_ORE_SET.getDeepslateOre());
        //dropSelf(GenerationsOres.CHARGE_STONE_Z_CRYSTAL_ORE.get());

        addAll(GenerationsBlocks.RUBY_BLOCK.get(), GenerationsBlocks.RUBY_SLAB.get(), GenerationsBlocks.RUBY_STAIRS.get(), GenerationsBlocks.RUBY_WALL.get());

        addAll(GenerationsBlocks.SAPPHIRE_BLOCK.get(), GenerationsBlocks.SAPPHIRE_SLAB.get(), GenerationsBlocks.SAPPHIRE_STAIRS.get(), GenerationsBlocks.SAPPHIRE_WALL.get());

        addAll(GenerationsBlocks.CRYSTAL_BLOCK.get(), GenerationsBlocks.CRYSTAL_SLAB.get(), GenerationsBlocks.CRYSTAL_STAIRS.get(), GenerationsBlocks.CRYSTAL_WALL.get());

        dropSelf(GenerationsBlocks.SILICON_BLOCK.get());
        dropSelf(GenerationsBlocks.Z_BLOCK.get());

        //Ultra Space
        dropSelf(GenerationsBlocks.ULTRA_SAND.get());
        dropWhenSilkTouch(GenerationsBlocks.GHOST_LANTERN.get());
        add(GenerationsBlocks.MACHINE_BLOCK.get(), createSingleItemTable(GenerationsBlocks.MACHINE_BLOCK.get()));
        dropSelf(GenerationsBlocks.RUINS_SAND.get());
        dropSelf(GenerationsBlocks.RICH_SOIL_1.get());
        dropSelf(GenerationsBlocks.RICH_SOIL_2.get());
        dropSelf(GenerationsBlocks.RICH_SOIL_3.get());
        dropSelf(GenerationsBlocks.RICH_SOIL_4.get());

        add(GenerationsBlocks.POKEBALL_CHEST.get(), createNameableBlockEntityTable(GenerationsBlocks.POKEBALL_CHEST.get()));
        add(GenerationsBlocks.GREATBALL_CHEST.get(), createNameableBlockEntityTable(GenerationsBlocks.GREATBALL_CHEST.get()));
        add(GenerationsBlocks.ULTRABALL_CHEST.get(), createNameableBlockEntityTable(GenerationsBlocks.ULTRABALL_CHEST.get()));
        add(GenerationsBlocks.MASTERBALL_CHEST.get(), createNameableBlockEntityTable(GenerationsBlocks.MASTERBALL_CHEST.get()));


        addOreSetWithRandomAmountDrops(GenerationsOres.MEGASTONE_ORE_SET, GenerationsItems.MEGASTONE_SHARD.get());
        addOreSetWithRandomAmountDrops(GenerationsOres.METEORITE_ORE_SET, GenerationsItems.METEORITE_SHARD.get());

        //Pumpkins
        dropSelf(GenerationsBlocks.CURSED_PUMPKIN.get());
        dropSelf(GenerationsBlocks.CURSED_CARVED_PUMPKIN.get());
        dropSelf(GenerationsBlocks.CURSED_JACK_O_LANTERN.get());

        //Furnaces
        add(GenerationsUtilityBlocks.CHARGE_STONE_FURNACE.get(), createNameableBlockEntityTable(GenerationsUtilityBlocks.CHARGE_STONE_FURNACE.get()));
        add(GenerationsUtilityBlocks.CHARGE_STONE_BLAST_FURNACE.get(), createNameableBlockEntityTable(GenerationsUtilityBlocks.CHARGE_STONE_BLAST_FURNACE.get()));
        add(GenerationsUtilityBlocks.CHARGE_STONE_SMOKER.get(), createNameableBlockEntityTable(GenerationsUtilityBlocks.CHARGE_STONE_SMOKER.get()));
        add(GenerationsUtilityBlocks.VOLCANIC_STONE_FURNACE.get(), createNameableBlockEntityTable(GenerationsUtilityBlocks.VOLCANIC_STONE_FURNACE.get()));
        add(GenerationsUtilityBlocks.VOLCANIC_STONE_BLAST_FURNACE.get(), createNameableBlockEntityTable(GenerationsUtilityBlocks.VOLCANIC_STONE_BLAST_FURNACE.get()));
        add(GenerationsUtilityBlocks.VOLCANIC_STONE_SMOKER.get(), createNameableBlockEntityTable(GenerationsUtilityBlocks.VOLCANIC_STONE_SMOKER.get()));



        dropSelf(GenerationsBlocks.POKEMART_SIGN.get());
        dropSelf(GenerationsBlocks.POKECENTER_SIGN.get());

        dropSelf(GenerationsDecorationBlocks.EMPTY_BALL_DISPLAY.get());

        dropDisplayStandWithBall(GenerationsDecorationBlocks.POKE_BALL_DISPLAY.get(), CobblemonItems.POKE_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.GREAT_BALL_DISPLAY.get(), CobblemonItems.GREAT_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.ULTRA_BALL_DISPLAY.get(), CobblemonItems.ULTRA_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.MASTER_BALL_DISPLAY.get(), CobblemonItems.MASTER_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.CHERISH_BALL_DISPLAY.get(), CobblemonItems.CHERISH_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.DIVE_BALL_DISPLAY.get(), CobblemonItems.DIVE_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.DUSK_BALL_DISPLAY.get(), CobblemonItems.DUSK_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.FAST_BALL_DISPLAY.get(), CobblemonItems.FAST_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.FRIEND_BALL_DISPLAY.get(), CobblemonItems.FRIEND_BALL.asItem());
        //dropDisplayStandWithBall(GenerationsDecorationBlocks.GS_BALL_DISPLAY.get(), null);
        dropDisplayStandWithBall(GenerationsDecorationBlocks.HEAL_BALL_DISPLAY.get(), CobblemonItems.HEAL_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.HEAVY_BALL_DISPLAY.get(), CobblemonItems.HEAVY_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.LEVEL_BALL_DISPLAY.get(), CobblemonItems.LEVEL_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.LOVE_BALL_DISPLAY.get(), CobblemonItems.LOVE_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.LURE_BALL_DISPLAY.get(), CobblemonItems.LURE_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.LUXURY_BALL_DISPLAY.get(), CobblemonItems.LUXURY_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.MOON_BALL_DISPLAY.get(), CobblemonItems.MOON_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.NEST_BALL_DISPLAY.get(), CobblemonItems.NEST_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.NET_BALL_DISPLAY.get(), CobblemonItems.NET_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.PARK_BALL_DISPLAY.get(), CobblemonItems.PARK_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.PREMIER_BALL_DISPLAY.get(), CobblemonItems.PREMIER_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.QUICK_BALL_DISPLAY.get(), CobblemonItems.QUICK_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.REPEAT_BALL_DISPLAY.get(), CobblemonItems.REPEAT_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.SAFARI_BALL_DISPLAY.get(), CobblemonItems.SAFARI_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.SPORT_BALL_DISPLAY.get(), CobblemonItems.SPORT_BALL.asItem());
        dropDisplayStandWithBall(GenerationsDecorationBlocks.TIMER_BALL_DISPLAY.get(), CobblemonItems.TIMER_BALL.asItem());

        createGenericRotationModelBlockTable(GenerationsUtilityBlocks.RKS_MACHINE.get());
        createGenericRotationModelBlockTable(GenerationsDecorationBlocks.DOUBLE_STREET_LAMP.get());
        createGenericRotationModelBlockTable(GenerationsShrines.PRISON_BOTTLE.get());
        prisonBottleStem();

        dropSelf(GenerationsBlocks.CASTLE_PILLAR);
        dropSelf(GenerationsBlocks.BROKEN_CASTLE_PILLAR);
        dropSelf(GenerationsBlocks.PRISMARINE_PILLAR);
        dropSelf(GenerationsBlocks.BROKEN_PRISMARINE_PILLAR);
        dropSelf(GenerationsBlocks.DARK_PRISMARINE_PILLAR);
        dropSelf(GenerationsBlocks.BROKEN_DARK_PRISMARINE_PILLAR);
        dropSelf(GenerationsBlocks.GHOST_PILLAR);
        dropSelf(GenerationsBlocks.HAUNTED_PILLAR);
        dropSelf(GenerationsBlocks.BROKEN_HAUNTED_PILLAR);
        dropSelf(GenerationsBlocks.DAWN_STONE_BLOCK);
        dropSelf(GenerationsBlocks.DUSK_STONE_BLOCK);
        dropSelf(GenerationsBlocks.FIRE_STONE_BLOCK);
        dropSelf(GenerationsBlocks.ICE_STONE_BLOCK);
        dropSelf(GenerationsBlocks.LEAF_STONE_BLOCK);
        dropSelf(GenerationsBlocks.MOON_STONE_BLOCK);
        dropSelf(GenerationsBlocks.SHINY_STONE_BLOCK);
        dropSelf(GenerationsBlocks.SUN_STONE_BLOCK);
        dropSelf(GenerationsBlocks.THUNDER_STONE_BLOCK);
        dropSelf(GenerationsBlocks.WATER_STONE_BLOCK);
        dropSelf(GenerationsBlocks.CRATE);

        dropSelf(GenerationsBlocks.WARNING_BLOCK);

        dropSelf(GenerationsBlocks.POKECENTER_DOOR);

        createSignDrops(GenerationsItems.ULTRA_DARK_SIGN.get(), GenerationsWood.ULTRA_DARK_SIGN.get(), GenerationsWood.ULTRA_DARK_WALL_SIGN.get());
        createSignDrops(GenerationsItems.ULTRA_DARK_HANGING_SIGN.get(), GenerationsWood.ULTRA_DARK_HANGING_SIGN.get(), GenerationsWood.ULTRA_DARK_WALL_HANGING_SIGN.get());
        createSignDrops(GenerationsItems.ULTRA_JUNGLE_SIGN.get(), GenerationsWood.ULTRA_JUNGLE_SIGN.get(), GenerationsWood.ULTRA_JUNGLE_WALL_SIGN.get());
        createSignDrops(GenerationsItems.ULTRA_JUNGLE_HANGING_SIGN.get(), GenerationsWood.ULTRA_JUNGLE_HANGING_SIGN.get(), GenerationsWood.ULTRA_JUNGLE_WALL_HANGING_SIGN.get());
        createSignDrops(GenerationsItems.GHOST_SIGN.get(), GenerationsWood.GHOST_SIGN.get(), GenerationsWood.GHOST_WALL_SIGN.get());
        createSignDrops(GenerationsItems.GHOST_HANGING_SIGN.get(), GenerationsWood.GHOST_HANGING_SIGN.get(), GenerationsWood.GHOST_WALL_HANGING_SIGN.get());
    }

    private void createSignDrops(Item item, Block standingSignBlock, Block wallSignBlock) {
        createItemDropTable(item, standingSignBlock);
        createItemDropTable(item, wallSignBlock);
    }

    protected <T extends Block> void dropSelf(RegistrySupplier<T> block) {
        super.dropSelf(block.get());
    }

    private void dropDisplayStandWithBall(Block block, Item item) {
        add(block, LootTable
                .lootTable()
                .withPool(applyExplosionCondition(GenerationsDecorationBlocks.EMPTY_BALL_DISPLAY.get(),
                        LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(GenerationsDecorationBlocks.EMPTY_BALL_DISPLAY.get()))))
                .withPool(applyExplosionCondition(GenerationsDecorationBlocks.EMPTY_BALL_DISPLAY.get(),
                        LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F)).add(LootItem.lootTableItem(item)))));
    }


    private void addOreSetWithRandomAmountDrops(GenerationsOreSet oreSet, Item drop) {
        add(
                oreSet.getOre(),
                createSilkTouchDispatchTable(
                        oreSet.getOre(),
                        applyExplosionDecay(
                                oreSet.getOre(),
                                LootItem.lootTableItem(drop)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between((float) 1, (float) 3)))
                                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                        )
                )
        );
        add(
                oreSet.getDeepslateOre(),
                createSilkTouchDispatchTable(
                        oreSet.getDeepslateOre(),
                        applyExplosionDecay(
                                oreSet.getDeepslateOre(),
                                LootItem.lootTableItem(drop)
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between((float) 1, (float) 3)))
                                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))
                        )
                )
        );
    }

    private void addOreSet(GenerationsOreSet oreSet) {
        if (oreSet.getDrop() == null) return;
        add(oreSet.getOre(), createOreDrop(oreSet.getOre(), oreSet.getDrop()));
        add(oreSet.getDeepslateOre(), createOreDrop(oreSet.getDeepslateOre(), oreSet.getDrop()));
    }

    private void addOreSet(Block ore, Item drop) {
        add(ore, createOreDrop(ore, drop));
    }

    private void addAll(Block block, Block slab, Block stair, Block wall) {
        if (block != null) dropSelf(block);
        if (slab != null) add(slab, createSlabItemTable(slab));
        if (stair != null) dropSelf(stair);
        if (wall != null) dropSelf(wall);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return knownBlocks;
    }

    private void dropSelfUpdated(@NotNull Block block) {
        if (block instanceof SlabBlock) add(block, createSlabItemTable(block));
        else if (block instanceof DoorBlock) add(block, createDoorTable(block));
        else if (block instanceof InfestedBlock) this.otherWhenSilkTouch(block, ((InfestedBlock) block).getHostBlock());
        else dropSelf(block);
    }

    private void dropSelfStoneCobble(@NotNull Block block) {
        if (block == GenerationsBlocks.VOLCANIC_STONE.get())
            add(block, createSingleItemTable(GenerationsBlocks.VOLCANIC_COBBLESTONE_SET.getBaseBlock()));
        else dropSelfUpdated(block);
    }

    @Override
    protected void add(@NotNull Block block, LootTable.@NotNull Builder lootTableBuilder) {
        knownBlocks.add(block);
        super.add(block, lootTableBuilder);
    }

    /*
    protected void createDyedBlock(Block block) {
        add(block, LootTable.lootTable().withPool(
                this.applyExplosionCondition(block,
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(block)
                                        .apply(DyedBlockLootFunction.DUMMY)))));
    }

    protected <T extends Comparable<T> & StringRepresentable> void createDoubleDyedBlock(Block block, Property<T> property, T value) {
        add(block, LootTable.lootTable().withPool(
                this.applyExplosionCondition(block,
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0f))
                                .add(LootItem.lootTableItem(block)
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(dyeMap)
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(property, value)))
                                        .apply(DyedBlockLootFunction.DUMMY)))));
    }

     */

    public void generate(@NotNull BiConsumer<ResourceLocation, LootTable.Builder> biConsumer) {
        this.generate();
        Set<ResourceLocation> set = new HashSet<>();

        for (Block block : this.getKnownBlocks()) {
            if (block.isEnabled(this.enabledFeatures)) {
                ResourceLocation resourcelocation = block.getLootTable();
                if (resourcelocation != BuiltInLootTables.EMPTY && set.add(resourcelocation)) {
                    LootTable.Builder loottable$builder = this.map.remove(resourcelocation);
                    if (loottable$builder == null) {
                        throw new IllegalStateException(String.format(Locale.ROOT, "Missing loottable '%s' for '%s'", resourcelocation, ForgeRegistries.BLOCKS.getKey(block)));
                    }

                    biConsumer.accept(resourcelocation, loottable$builder);
                }
            }
        }

        if (!this.map.isEmpty() && this.map.size() != 1 && this.map.containsKey(new ResourceLocation("empty"))) {
            throw new IllegalStateException("Created block loot tables for non-blocks: " + this.map.keySet());
        }
    }

    protected final <T extends Block> void createItemDropTable(Item item, T block) {
        add(block, LootTable.lootTable().withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add(LootItem.lootTableItem(item)))));
    }

    protected <T extends GenericRotatableModelBlock<?>> void createGenericRotationModelBlockTable(T block) {
        var statePropertiesPredicate = StatePropertiesPredicate.Builder.properties();

        if (block.getWidthProperty() != null) {
            statePropertiesPredicate.hasProperty(block.getWidthProperty(), block.getBaseX());
        }
        if (block.getHeightProperty() != null) {
            statePropertiesPredicate.hasProperty(block.getHeightProperty(), 0);
        }
        if (block.getLengthProperty() != null) {
            statePropertiesPredicate.hasProperty(block.getLengthProperty(), block.getBaseZ());
        }

        add(block, LootTable.lootTable().withPool(this.applyExplosionCondition(block, LootPool.lootPool().setRolls(ConstantValue.exactly(1.0f)).add(LootItem.lootTableItem(block).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(statePropertiesPredicate))))));
    }

    protected <T extends GenericRotatableModelBlock<?>> void prisonBottleStem() {
        var block = GenerationsShrines.PRISON_BOTTLE_STEM.get();
        var statePropertiesPredicate = StatePropertiesPredicate.Builder.properties();

        if (block.getWidthProperty() != null) {
            statePropertiesPredicate.hasProperty(block.getWidthProperty(), block.getBaseX());
        }
        if (block.getHeightProperty() != null) {
            statePropertiesPredicate.hasProperty(block.getHeightProperty(), 0);
        }
        if (block.getLengthProperty() != null) {
            statePropertiesPredicate.hasProperty(block.getLengthProperty(), block.getBaseZ());
        }

        var lootTable = this.applyExplosionCondition(block, LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0f))
                .add(LootItem.lootTableItem(block)
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(block).setProperties(statePropertiesPredicate))));

        add(block, LootTable.lootTable()
                .withPool(lootTable)
                .withPool(ringLoot(PrisonBottleStemBlock.PrisonBottleState.RING_1, 1, statePropertiesPredicate))
                .withPool(ringLoot(PrisonBottleStemBlock.PrisonBottleState.RING_2, 2, statePropertiesPredicate))
                .withPool(ringLoot(PrisonBottleStemBlock.PrisonBottleState.RING_3, 3, statePropertiesPredicate))
                .withPool(ringLoot(PrisonBottleStemBlock.PrisonBottleState.RING_4, 4, statePropertiesPredicate))
                .withPool(ringLoot(PrisonBottleStemBlock.PrisonBottleState.RING_5, 5, statePropertiesPredicate))
        );
    }

    public LootPool.Builder ringLoot(PrisonBottleStemBlock.PrisonBottleState state, int ring, StatePropertiesPredicate.Builder builder) {
        return this.applyExplosionCondition(GenerationsItems.HOOPA_RING.get(), LootPool.lootPool()
                .setRolls(ConstantValue.exactly(ring))
                .add(LootItem.lootTableItem(GenerationsItems.HOOPA_RING.get())
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(GenerationsShrines.PRISON_BOTTLE_STEM.get()).setProperties(builder.hasProperty(PrisonBottleStemBlock.STATE, state)))));
    }
}