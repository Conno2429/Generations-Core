package generations.gg.generations.core.generationscore.common.world.level.block;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import generations.gg.generations.core.generationscore.common.GenerationsCore;
import generations.gg.generations.core.generationscore.common.util.GenerationsItemUtils;
import generations.gg.generations.core.generationscore.common.util.GenerationsUtils;
import generations.gg.generations.core.generationscore.common.world.item.GenerationsItems;
import generations.gg.generations.core.generationscore.common.world.level.block.de.WorkDeskBlock;
import generations.gg.generations.core.generationscore.common.world.level.block.deco.ShelfBlock;
import generations.gg.generations.core.generationscore.common.world.level.block.decorations.*;
import generations.gg.generations.core.generationscore.common.world.level.block.entities.*;
import generations.gg.generations.core.generationscore.common.world.level.block.entities.generic.GenericDyedVariantBlockEntity;
import generations.gg.generations.core.generationscore.common.world.level.block.utilityblocks.DyeableBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class GenerationsDecorationBlocks {
    public static final DeferredRegister<Block> DECORATIONS = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.BLOCK);
    public static final DeferredRegister<Block> DECORATION_ITEMS = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.BLOCK);

    public static final List<RegistrySupplier<BallDisplayBlock>> BALL_DISPLAY_BLOCKS = new ArrayList<>();

    /**
     * Decoration Blocks
     */
    public static final RegistrySupplier<Block> HOUSE_LAMP = registerDecorationItem("house_lamp", () -> new HouseLampBlock(BlockBehaviour.Properties.of().destroyTime(1.0f).sound(SoundType.METAL).lightLevel((lightLevel) -> 15)));
    public static final RegistrySupplier<Block> SWITCH = registerDecorationItem("switch", () -> new SwitchBlock(BlockBehaviour.Properties.of().destroyTime(1.0f).sound(SoundType.METAL)));
    public static final RegistrySupplier<Block> LITWICK_CANDLE = registerDecorationItem("litwick_candle", () -> new LitwickCandleBlock(BlockBehaviour.Properties.copy(Blocks.CANDLE).lightLevel(state -> 11).destroyTime(0.7f)));
    public static final RegistrySupplier<Block> LITWICK_CANDLES = registerDecorationItem("litwick_candles", () -> new LitwickCandlesBlock(BlockBehaviour.Properties.copy(Blocks.CANDLE).lightLevel(state -> 15).destroyTime(0.5f)));

    public static final DyedGroup<VendingMachineBlock, VendingMachineBlockEntity> VENDING_MACHINE = registerDyed("vending_machine", (color, function) -> () -> new VendingMachineBlock(color, function, BlockBehaviour.Properties.of().destroyTime(1.0f).sound(SoundType.METAL).requiresCorrectToolForDrops()));

    public static final DyedGroup<StreetLampBlock, StreetLampBlockEntity> STREET_LAMP = registerDyed("street_lamp", (color, function) -> () -> new StreetLampBlock(color, function, BlockBehaviour.Properties.of().destroyTime(1.0f).sound(SoundType.METAL).lightLevel(value -> {
        if(((StreetLampBlock) value.getBlock()).getHeightValue(value) == 1) return 15;
        return 0;
    }).requiresCorrectToolForDrops()));
    public static final RegistrySupplier<DoubleStreetLampBlock> DOUBLE_STREET_LAMP = registerDecorationItem("double_street_lamp", () -> new DoubleStreetLampBlock(BlockBehaviour.Properties.of()));

    private static DyedGroup<VariantCouchBlock, CouchBlockEntity> registerCouch(VariantCouchBlock.Variant variant) {
        return registerDyed("couch_" + variant.name().toLowerCase(), (color, function) -> () -> new VariantCouchBlock(color, function, BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL), variant));
    }


    public static final DyedGroup<VariantCouchBlock, CouchBlockEntity> COUCH_ARM_LEFT = registerCouch(VariantCouchBlock.Variant.ARM_LEFT);
    public static final DyedGroup<VariantCouchBlock, CouchBlockEntity> COUCH_ARM_RIGHT = registerCouch(VariantCouchBlock.Variant.ARM_RIGHT);
    public static final DyedGroup<VariantCouchBlock, CouchBlockEntity> COUCH_CORNER_LEFT = registerCouch(VariantCouchBlock.Variant.CORNER_LEFT);
    public static final DyedGroup<VariantCouchBlock, CouchBlockEntity> COUCH_CORNER_RIGHT = registerCouch(VariantCouchBlock.Variant.CORNER_RIGHT);
    public static final DyedGroup<VariantCouchBlock, CouchBlockEntity> COUCH_MIDDLE = registerCouch(VariantCouchBlock.Variant.MIDDLE);
    public static final DyedGroup<VariantCouchBlock, CouchBlockEntity> COUCH_OTTOMAN = registerCouch(VariantCouchBlock.Variant.OTTOMAN);

    public static final RegistrySupplier<Block> SNORLAX_BEAN_BAG = registerDecorationItem("snorlax_bean_bag", () -> new BeanBagBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(.5f).ignitedByLava()));
    public static final DyedGroup<PastelBeanBagBlock, GenericDyedVariantBlockEntity> PASTEL_BEAN_BAG = registerDyed("pastel_bean_bag", (color, function) -> () -> new PastelBeanBagBlock(color, function, BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(.5f).ignitedByLava()));
    public static final DyedGroup<SwivelChairBlock, GenericDyedVariantBlockEntity> SWIVEL_CHAIR = registerDyed("swivel_chair", (color, function) -> () -> new SwivelChairBlock(color, function, BlockBehaviour.Properties.of().sound(SoundType.WOOL).strength(.5f).ignitedByLava()));
    public static final RegistrySupplier<Block> BENCH = registerDecorationItem("bench", () -> new BenchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOL).strength(1.0f).sound(SoundType.WOOD)));
    public static final RegistrySupplier<Block> COUCH = registerDecorationItem("couch", () -> new CouchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.WOOL).strength(1.0f).sound(SoundType.WOOD)));
    public static final RegistrySupplier<Block> BUSH = registerDecorationItem("bush", () -> new BushBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).sound(SoundType.GRASS).strength(1.0f)));

    public static final RegistrySupplier<Block> DESK = registerDecorationItem("desk", () -> new DeskBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(1.0f).sound(SoundType.WOOD)));

    public static final RegistrySupplier<Block> FRIDGE = registerDecorationItem("fridge", () -> new FridgeBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(.5f)));

    public static final RegistrySupplier<Block> WORK_DESK = registerDecorationItem("work_desk", () -> new WorkDeskBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(1.0f)));
    public static final RegistrySupplier<Block> SHELF = registerDecorationItem("shelf", () -> new ShelfBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(1.0f)));

    public static final RegistrySupplier<Block> BOOK_SHELF = registerDecorationItem("book_shelf", () -> new BookShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(1.0f).requiresCorrectToolForDrops()));


    public static final RegistrySupplier<Block> POKEBALL_PILLAR = registerDecorationItem("pokeball_pillar", () -> new PokeballPillarBlock(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE).strength(1.0f)));

    public static final RegistrySupplier<Block> HDTV = registerDecorationItem("hdtv", () -> new HdTvBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(.5f)));

    public static final RegistrySupplier<Block> SHOP_DISPLAY_CASE_1 = registerDecorationItem("shop_display_case_1", () -> new ShopDisplayBlock(BlockBehaviour.Properties.of(), 1, 0, 0, "case_1"));
    public static final RegistrySupplier<Block> SHOP_DISPLAY_CASE_2 = registerDecorationItem("shop_display_case_2", () -> new ShopDisplayBlock(BlockBehaviour.Properties.of(), 1, 0, 0, "case_2"));
    public static final RegistrySupplier<Block> SHOP_DISPLAY_SMALL_1 = registerDecorationItem("shop_display_small_1", () -> new ShopDisplayBlock(BlockBehaviour.Properties.of(), 1, 1, 0, "round_1"));
    public static final RegistrySupplier<Block> SHOP_DISPLAY_SMALL_2 = registerDecorationItem("shop_display_small_2", () -> new ShopDisplayBlock(BlockBehaviour.Properties.of(), 1, 1, 0, "round_2"));
    public static final RegistrySupplier<Block> SHOP_DISPLAY_LARGE_SHELF_1 = registerDecorationItem("shop_display_large_shelf_1", () -> new ShopDisplayBlock(BlockBehaviour.Properties.of(), 1, 2, 0, "shelf_1"));
    public static final RegistrySupplier<Block> SHOP_DISPLAY_LARGE_SHELF_2 = registerDecorationItem("shop_display_large_shelf_2", () -> new ShopDisplayBlock(BlockBehaviour.Properties.of(), 1, 2, 0, "shelf_2"));

    //Cushion

    public static final RegistrySupplier<Block> FOONGUS_CUSHION = registerDecorationItem("foongus_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL), "foongus"));
    public static final RegistrySupplier<Block> GREATBALL_CUSHION = registerDecorationItem("greatball_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL), "greatball"));
    public static final RegistrySupplier<Block> POKEBALL_CUSHION = registerDecorationItem("pokeball_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL), "pokeball"));
    public static final RegistrySupplier<Block> MASTERBALL_CUSHION = registerDecorationItem("masterball_cushion", () -> new CushionBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL), "masterball"));

    public static <T extends DyedVariantBlockEntity<?>, V extends DyeableBlock<T, V>> DyedGroup<V,T> registerDyed(String name, BiFunction<DyeColor, Map<DyeColor, RegistrySupplier<V>>, Supplier<V>> blockSupplier) {

        var dyeMap = new HashMap<DyeColor, RegistrySupplier<V>>();

        Arrays.stream(DyeColor.values()).forEach(dyeColor -> {
            var properName = dyeColor.getSerializedName() + "_" + name;
            RegistrySupplier<V> block = registerBlock(properName, blockSupplier.apply(dyeColor, dyeMap));

            register(properName, properties -> new BlockItem(block.get(), properties));
            dyeMap.put(dyeColor, block);
        });

        return new DyedGroup<>(dyeMap);
    }


    /**
     * Decoration Blocks (Vending Machine)
     */
    //Ball Displays
    public static final RegistrySupplier<BallDisplayBlock> EMPTY_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.EMPTY);
    public static final RegistrySupplier<BallDisplayBlock> POKE_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.POKE);
    public static final RegistrySupplier<BallDisplayBlock> GREAT_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.GREAT);
    public static final RegistrySupplier<BallDisplayBlock> ULTRA_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.ULTRA);
    public static final RegistrySupplier<BallDisplayBlock> MASTER_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.MASTER);
    public static final RegistrySupplier<BallDisplayBlock> CHERISH_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.CHERISH);
    public static final RegistrySupplier<BallDisplayBlock> DIVE_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.DIVE);
    public static final RegistrySupplier<BallDisplayBlock> DUSK_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.DUSK);
    public static final RegistrySupplier<BallDisplayBlock> FAST_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.FAST);
    public static final RegistrySupplier<BallDisplayBlock> FRIEND_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.FRIEND);
    //public static final RegistrySupplier<BallDisplayBlock> GS_BALL_DISPLAY = registerBallDisplay(DisplayState.GS);
    public static final RegistrySupplier<BallDisplayBlock> HEAL_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.HEAL);
    public static final RegistrySupplier<BallDisplayBlock> HEAVY_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.HEAVY);
    public static final RegistrySupplier<BallDisplayBlock> LEVEL_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.LEVEL);
    public static final RegistrySupplier<BallDisplayBlock> LOVE_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.LOVE);
    public static final RegistrySupplier<BallDisplayBlock> LURE_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.LURE);
    public static final RegistrySupplier<BallDisplayBlock> LUXURY_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.LUXURY);
    public static final RegistrySupplier<BallDisplayBlock> MOON_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.MOON);
    public static final RegistrySupplier<BallDisplayBlock> NEST_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.NEST);
    public static final RegistrySupplier<BallDisplayBlock> NET_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.NET);
    public static final RegistrySupplier<BallDisplayBlock> PARK_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.PARK);
    public static final RegistrySupplier<BallDisplayBlock> PREMIER_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.PREMIER);
    public static final RegistrySupplier<BallDisplayBlock> QUICK_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.QUICK);
    public static final RegistrySupplier<BallDisplayBlock> REPEAT_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.REPEAT);
    public static final RegistrySupplier<BallDisplayBlock> SAFARI_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.SAFARI);
    public static final RegistrySupplier<BallDisplayBlock> SPORT_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.SPORT);
    public static final RegistrySupplier<BallDisplayBlock> TIMER_BALL_DISPLAY = registerBallDisplay(BallDisplayBlock.DisplayState.TIMER);

    private static RegistrySupplier<BallDisplayBlock> registerBallDisplay(BallDisplayBlock.DisplayState state) {
        var block = registerDecorationItem(state.name().toLowerCase() + "_ball_display", () -> new BallDisplayBlock(state));
        BALL_DISPLAY_BLOCKS.add(block);
        return block;
    }

    private static <T extends Block> RegistrySupplier<T> registerDecorationItem(String name, Supplier<T> blockSupplier) {
        RegistrySupplier<T> block = registerBlock(name, blockSupplier);
        register(name, properties -> GenerationsItemUtils.generateBlockItem(block.get(), properties));
        return block;
    }

    private static <T extends Block> RegistrySupplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
        return GenerationsUtils.registerBlock(DECORATIONS, name, blockSupplier);
    }

    private static <T extends BlockItem> RegistrySupplier<T> register(String name, Function<Item.Properties, T> itemSupplier) {
        return GenerationsItems.ITEMS.register(name, () -> itemSupplier.apply(new Item.Properties()));
    }

    public static void init() {
        GenerationsCore.LOGGER.info("Registering Generations Decorations");
        DECORATIONS.register();
    }
}
