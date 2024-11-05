package generations.gg.generations.core.generationscore.common.world.level.block.entities.shrines;

import generations.gg.generations.core.generationscore.common.world.level.block.entities.GenerationsBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class WeatherTrioShrineBlockEntity extends InteractShrineBlockEntity {
    public WeatherTrioShrineBlockEntity(BlockPos arg2, BlockState arg3) {
        super(GenerationsBlockEntities.WEATHER_TRIO.get(), arg2, arg3);
    }
}
