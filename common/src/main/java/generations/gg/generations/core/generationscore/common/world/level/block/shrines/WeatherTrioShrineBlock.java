package generations.gg.generations.core.generationscore.common.world.level.block.shrines;

import dev.architectury.registry.registries.RegistrySupplier;
import generations.gg.generations.core.generationscore.common.config.LegendKeys;
import generations.gg.generations.core.generationscore.common.config.SpeciesKey;
import generations.gg.generations.core.generationscore.common.world.level.block.GenerationsVoxelShapes;
import generations.gg.generations.core.generationscore.common.world.entity.block.PokemonUtil;
import generations.gg.generations.core.generationscore.common.world.level.block.entities.GenerationsBlockEntities;
import generations.gg.generations.core.generationscore.common.world.level.block.entities.shrines.WeatherTrioShrineBlockEntity;
import generations.gg.generations.core.generationscore.common.world.level.schedule.ScheduledTask;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import static net.minecraft.world.phys.shapes.BooleanOp.OR;

public class WeatherTrioShrineBlock extends InteractShrineBlock<WeatherTrioShrineBlockEntity> {
    private static final GenerationsVoxelShapes.DirectionalShapes KYOGRE = GenerationsVoxelShapes.generateDirectionVoxelShape(
            Shapes.join(Shapes.box(0.0625, 0, 0.375, 0.9375, 0.125, 0.75),
                    Shapes.box(0.125, 0.125, 0.4375, 0.875, 0.5625, 0.625), OR));

    private static final GenerationsVoxelShapes.DirectionalShapes GROUDON = GenerationsVoxelShapes.generateDirectionVoxelShape(
            Shapes.join(Shapes.box(0, 0, 0.3125, 1, 0.125, 0.6875),
                    Shapes.box(0.125, 0.125, 0.4375, 0.875, 0.5625, 0.5625), OR));

    private final SpeciesKey speiceskey;
    private final RegistrySupplier<? extends Item> requiredItem;

    public WeatherTrioShrineBlock(BlockBehaviour.Properties properties, ResourceLocation model, SpeciesKey speiceskey, RegistrySupplier<? extends Item> requiredItem) {
        super(properties, GenerationsBlockEntities.WEATHER_TRIO, model);
        this.speiceskey = speiceskey;
        this.requiredItem = requiredItem;
    }

    @Override
    public boolean isStackValid(ItemStack stack) {
        return stack.is(requiredItem.get())  && stack.getDamageValue() >= stack.getMaxDamage();
    }

    public SpeciesKey getSpecies() {
        return speiceskey;
    }

    @Override
    protected boolean activate(Level level, BlockPos pos, BlockState state, ServerPlayer player, InteractionHand hand, ActivationState activationState) {
        player.getMainHandItem().shrink(1);

        toggleActive(level, pos);
        ScheduledTask.schedule(() -> {
            PokemonUtil.spawn(getSpecies().createPokemon(70), level, pos, getAngle(state));
            toggleActive(level, pos);
        }, 150);

        return true;
    }

    @Override
    public boolean isActivatable() {
        return true;
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        if(speiceskey == LegendKeys.KYOGRE) return KYOGRE.getShape(state);
        else if(speiceskey == LegendKeys.GROUDON) return GROUDON.getShape(state);
        else return Shapes.block();
    }
}
