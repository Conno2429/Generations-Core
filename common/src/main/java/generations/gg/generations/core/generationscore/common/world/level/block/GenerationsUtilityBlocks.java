package generations.gg.generations.core.generationscore.common.world.level.block;

import com.cobblemon.mod.common.api.pokeball.PokeBalls;
import com.cobblemon.mod.common.pokeball.PokeBall;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import generations.gg.generations.core.generationscore.common.GenerationsCore;
import generations.gg.generations.core.generationscore.common.util.GenerationsItemUtils;
import generations.gg.generations.core.generationscore.common.util.GenerationsUtils;
import generations.gg.generations.core.generationscore.common.world.item.GenerationsItems;
import generations.gg.generations.core.generationscore.common.world.level.block.entities.DyedPcBlockEntity;
import generations.gg.generations.core.generationscore.common.world.level.block.entities.GenerationsBlockEntityModels;
import generations.gg.generations.core.generationscore.common.world.level.block.entities.ModelProvidingBlockEntity;
import generations.gg.generations.core.generationscore.common.world.level.block.generic.GenericBlastFurnaceBlock;
import generations.gg.generations.core.generationscore.common.world.level.block.generic.GenericFurnaceBlock;
import generations.gg.generations.core.generationscore.common.world.level.block.generic.GenericSmokerBlock;
import generations.gg.generations.core.generationscore.common.world.level.block.utilityblocks.*;
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

public class GenerationsUtilityBlocks {
	public static final DeferredRegister<Block> UTILITY_BLOCKS = DeferredRegister.create(GenerationsCore.MOD_ID, Registries.BLOCK);

	public static final List<RegistrySupplier<BallLootBlock>> BALL_LOOTS = new ArrayList<>();

	/**
	 * Utility Blocks
	 */
	public static final RegistrySupplier<Block> COOKING_POT = registerBlockItem("cooking_pot", () -> new CookingPotBlock(BlockBehaviour.Properties.of().strength(2.5f).randomTicks().noOcclusion()));

	//PC Blocks
	public static final RegistrySupplier<TablePc> TABLE_PC = registerBlockItem("table_pc", () -> new TablePc(BlockBehaviour.Properties.of().noOcclusion().requiresCorrectToolForDrops().strength(2f).lightLevel(PcBlock.Companion::lumiance), GenerationsBlockEntityModels.TABLE_PC, 0, 0, 0));
	public static final RegistrySupplier<RotomPc> ROTOM_PC = registerBlockItem("rotom_pc", () -> new RotomPc(BlockBehaviour.Properties.of().noOcclusion().requiresCorrectToolForDrops().strength(2f).lightLevel(PcBlock.Companion::lumiance)));

	public static final RegistrySupplier<Block> TRASH_CAN = registerBlockItem("trash_can", () -> new TrashCanBlock(BlockBehaviour.Properties.of().destroyTime(1.0f).sound(SoundType.METAL)));

	public static final RegistrySupplier<Block> BOX = registerBlockItem("box", () -> new BoxBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));

	public static final RegistrySupplier<RksMachineBlock> RKS_MACHINE = registerBlockItem("rks_machine", () -> new RksMachineBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

	public static final RegistrySupplier<Block> SCARECROW = registerBlockItem("scarecrow", () -> new ScarecrowBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).dynamicShape().noOcclusion()));

	public static final DyedGroup<DyedPcBlock, DyedPcBlockEntity> PC = registerDyed("pc", (color, dyeColorRegistrySupplierMap) -> () -> new DyedPcBlock(color, dyeColorRegistrySupplierMap, BlockBehaviour.Properties.of().noOcclusion().requiresCorrectToolForDrops().strength(2f).lightLevel(PcBlock.Companion::lumiance)));

	public static final RegistrySupplier<Block> WHITE_ELEVATOR = registerBlockItem("white_elevator", ElevatorBlock::new);
	public static final RegistrySupplier<Block> LIGHT_GRAY_ELEVATOR = registerBlockItem("light_gray_elevator", ElevatorBlock::new);
	public static final RegistrySupplier<Block> GRAY_ELEVATOR = registerBlockItem("gray_elevator", ElevatorBlock::new);
	public static final RegistrySupplier<Block> BLACK_ELEVATOR = registerBlockItem("black_elevator", ElevatorBlock::new);
	public static final RegistrySupplier<Block> BROWN_ELEVATOR = registerBlockItem("brown_elevator", ElevatorBlock::new);
	public static final RegistrySupplier<Block> RED_ELEVATOR = registerBlockItem("red_elevator", ElevatorBlock::new);
	public static final RegistrySupplier<Block> ORANGE_ELEVATOR = registerBlockItem("orange_elevator", ElevatorBlock::new);
	public static final RegistrySupplier<Block> YELLOW_ELEVATOR = registerBlockItem("yellow_elevator", ElevatorBlock::new);
	public static final RegistrySupplier<Block> LIME_ELEVATOR = registerBlockItem("lime_elevator", ElevatorBlock::new);
	public static final RegistrySupplier<Block> GREEN_ELEVATOR = registerBlockItem("green_elevator", ElevatorBlock::new);
	public static final RegistrySupplier<Block> CYAN_ELEVATOR = registerBlockItem("cyan_elevator", ElevatorBlock::new);
	public static final RegistrySupplier<Block> LIGHT_BLUE_ELEVATOR = registerBlockItem("light_blue_elevator", ElevatorBlock::new);
	public static final RegistrySupplier<Block> BLUE_ELEVATOR = registerBlockItem("blue_elevator", ElevatorBlock::new);
	public static final RegistrySupplier<Block> PURPLE_ELEVATOR = registerBlockItem("purple_elevator", ElevatorBlock::new);
	public static final RegistrySupplier<Block> MAGENTA_ELEVATOR = registerBlockItem("magenta_elevator", ElevatorBlock::new);
	public static final RegistrySupplier<Block> PINK_ELEVATOR = registerBlockItem("pink_elevator", ElevatorBlock::new);

	public static RegistrySupplier<BallLootBlock> BEAST_BALL_LOOT = registerLoot("beast", PokeBalls.INSTANCE.getBEAST_BALL());
	public static RegistrySupplier<BallLootBlock> CHERISH_BALL_LOOT = registerLoot("cherish", PokeBalls.INSTANCE.getCHERISH_BALL());
	public static RegistrySupplier<BallLootBlock> DIVE_BALL_LOOT = registerLoot("dive", PokeBalls.INSTANCE.getDIVE_BALL());
	public static RegistrySupplier<BallLootBlock> DREAM_BALL_LOOT = registerLoot("dream", PokeBalls.INSTANCE.getDREAM_BALL());
	public static RegistrySupplier<BallLootBlock> DUSK_BALL_LOOT = registerLoot("dusk", PokeBalls.INSTANCE.getDUSK_BALL());
	public static RegistrySupplier<BallLootBlock> FAST_BALL_LOOT = registerLoot("fast", PokeBalls.INSTANCE.getFAST_BALL());
	public static RegistrySupplier<BallLootBlock> FRIEND_BALL_LOOT = registerLoot("friend", PokeBalls.INSTANCE.getFRIEND_BALL());
	public static RegistrySupplier<BallLootBlock> GIGATON_BALL_LOOT = registerLoot("gigaton", PokeBalls.INSTANCE.getANCIENT_GIGATON_BALL());
	public static RegistrySupplier<BallLootBlock> GREAT_BALL_LOOT = registerLoot("great", PokeBalls.INSTANCE.getGREAT_BALL());
	public static RegistrySupplier<BallLootBlock> HEAL_BALL_LOOT = registerLoot("heal", PokeBalls.INSTANCE.getHEAL_BALL());
	public static RegistrySupplier<BallLootBlock> HEAVY_BALL_LOOT = registerLoot("heavy", PokeBalls.INSTANCE.getHEAVY_BALL());
	public static RegistrySupplier<BallLootBlock> JET_BALL_LOOT = registerLoot("jet", PokeBalls.INSTANCE.getANCIENT_JET_BALL());
	public static RegistrySupplier<BallLootBlock> LEADEN_BALL_LOOT = registerLoot("leaden", PokeBalls.INSTANCE.getANCIENT_LEADEN_BALL());
	public static RegistrySupplier<BallLootBlock> LEVEL_BALL_LOOT = registerLoot("level", PokeBalls.INSTANCE.getLEVEL_BALL());
	public static RegistrySupplier<BallLootBlock> LOVE_BALL_LOOT = registerLoot("love", PokeBalls.INSTANCE.getLOVE_BALL());
	public static RegistrySupplier<BallLootBlock> LURE_BALL_LOOT = registerLoot("lure", PokeBalls.INSTANCE.getLURE_BALL());
	public static RegistrySupplier<BallLootBlock> LUXURY_BALL_LOOT = registerLoot("luxury", PokeBalls.INSTANCE.getLUXURY_BALL());
	public static RegistrySupplier<BallLootBlock> MASTER_BALL_LOOT = registerLoot("master", PokeBalls.INSTANCE.getMASTER_BALL());
	public static RegistrySupplier<BallLootBlock> MOON_BALL_LOOT = registerLoot("moon", PokeBalls.INSTANCE.getMOON_BALL());
	public static RegistrySupplier<BallLootBlock> NEST_BALL_LOOT = registerLoot("nest", PokeBalls.INSTANCE.getNEST_BALL());
	public static RegistrySupplier<BallLootBlock> NET_BALL_LOOT = registerLoot("net", PokeBalls.INSTANCE.getNET_BALL());
	public static RegistrySupplier<BallLootBlock> ORIGIN_BALL_LOOT = registerLoot("origin", PokeBalls.INSTANCE.getANCIENT_ORIGIN_BALL());
	public static RegistrySupplier<BallLootBlock> PARK_BALL_LOOT = registerLoot("park", PokeBalls.INSTANCE.getPARK_BALL());
	public static RegistrySupplier<BallLootBlock> POKE_BALL_LOOT = registerLoot("poke", PokeBalls.INSTANCE.getPOKE_BALL());
	public static RegistrySupplier<BallLootBlock> PREMIER_BALL_LOOT = registerLoot("premier", PokeBalls.INSTANCE.getPREMIER_BALL());
	public static RegistrySupplier<BallLootBlock> QUICK_BALL_LOOT = registerLoot("quick", PokeBalls.INSTANCE.getQUICK_BALL());
	public static RegistrySupplier<BallLootBlock> REPEAT_BALL_LOOT = registerLoot("repeat", PokeBalls.INSTANCE.getREPEAT_BALL());
	public static RegistrySupplier<BallLootBlock> SAFARI_BALL_LOOT = registerLoot("safari", PokeBalls.INSTANCE.getSAFARI_BALL());
	public static RegistrySupplier<BallLootBlock> SPORT_BALL_LOOT = registerLoot("sport", PokeBalls.INSTANCE.getSPORT_BALL());
	public static RegistrySupplier<BallLootBlock> STRANGE_BALL_LOOT = registerLoot("strange", PokeBalls.INSTANCE.getPOKE_BALL());
	public static RegistrySupplier<BallLootBlock> TIMER_BALL_LOOT = registerLoot("timer", PokeBalls.INSTANCE.getTIMER_BALL());
	public static RegistrySupplier<BallLootBlock> ULTRA_BALL_LOOT = registerLoot("ultra", PokeBalls.INSTANCE.getULTRA_BALL());
	public static RegistrySupplier<BallLootBlock> WING_BALL_LOOT = registerLoot("wing", PokeBalls.INSTANCE.getANCIENT_WING_BALL());

	private static RegistrySupplier<BallLootBlock> registerLoot(String name, PokeBall ball) {
		var block = registerBlockItem(name + "_ball_loot", () -> new BallLootBlock(name, ball));
		BALL_LOOTS.add(block);
		return block;
	}

//	public static final RegistrySupplier<BreederBlock> BREEDER = registerBlock("breeder", () -> new BreederBlock(BlockBehaviour.Properties.of().destroyTime(1.0f).sound(SoundType.WOOD).ignitedByLava()));
	public static final RegistrySupplier<GenericFurnaceBlock> CHARGE_STONE_FURNACE = registerBlockItem("charge_stone_furnace", GenericFurnaceBlock::new);
	public static final RegistrySupplier<GenericBlastFurnaceBlock> CHARGE_STONE_BLAST_FURNACE = registerBlockItem("charge_stone_blast_furnace", GenericBlastFurnaceBlock::new);
	public static final RegistrySupplier<GenericSmokerBlock> CHARGE_STONE_SMOKER = registerBlockItem("charge_stone_smoker", GenericSmokerBlock::new);
	public static final RegistrySupplier<GenericFurnaceBlock> VOLCANIC_STONE_FURNACE = registerBlockItem("volcanic_stone_furnace", GenericFurnaceBlock::new);
	public static final RegistrySupplier<GenericBlastFurnaceBlock> VOLCANIC_STONE_BLAST_FURNACE = registerBlockItem("volcanic_stone_blast_furnace", GenericBlastFurnaceBlock::new);
	public static final RegistrySupplier<GenericSmokerBlock> VOLCANIC_STONE_SMOKER = registerBlockItem("volcanic_stone_smoker", GenericSmokerBlock::new);

	private static <T extends BlockItem> RegistrySupplier<T> register(String name, Function<Item.Properties, T> itemSupplier) {
		return GenerationsItems.ITEMS.register(name, () -> itemSupplier.apply(new Item.Properties()));
	}

    private static <T extends Block> RegistrySupplier<T> registerBlockItem(String name, Supplier<T> blockSupplier) {
		RegistrySupplier<T> block = registerBlock(name, blockSupplier);
		register(name, properties -> GenerationsItemUtils.generateBlockItem(block.get(), properties));
		return block;
	}

	private static <T extends Block> RegistrySupplier<T> registerBlock(String name, Supplier<T> blockSupplier) {
		return GenerationsUtils.registerBlock(UTILITY_BLOCKS, name, blockSupplier);
	}

	public static <T extends ModelProvidingBlockEntity, V extends DyeableBlock<T, V>> DyedGroup<V,T> registerDyed(String name, BiFunction<DyeColor, Map<DyeColor, RegistrySupplier<V>>, Supplier<V>> blockSupplier) {

		var dyeMap = new HashMap<DyeColor, RegistrySupplier<V>>();

		Arrays.stream(DyeColor.values()).forEach(dyeColor -> {
			var properName = dyeColor.getSerializedName() + "_" + name;
			RegistrySupplier<V> block = registerBlock(properName, blockSupplier.apply(dyeColor, dyeMap));

			register(properName, properties -> new BlockItem(block.get(), properties));
			dyeMap.put(dyeColor, block);
		});

		return new DyedGroup<>(dyeMap);
	}


	public static void init() {
		GenerationsCore.LOGGER.info("Registering Generations Utility Blocks");
		UTILITY_BLOCKS.register();
	}
}
