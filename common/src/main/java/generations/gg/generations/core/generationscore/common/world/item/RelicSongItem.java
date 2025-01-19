package generations.gg.generations.core.generationscore.common.world.item;

import dev.architectury.core.item.ArchitecturyRecordItem;
import generations.gg.generations.core.generationscore.common.world.sound.GenerationsSounds;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RelicSongItem extends ArchitecturyRecordItem implements LangTooltip {
    private final boolean notInert;

    public RelicSongItem(Item.Properties properties, boolean notInert) {
        super(0, GenerationsSounds.MELOETTAS_RELIC_SONG, properties, 30);
        this.notInert = notInert;
    }

    @Override
    public boolean isFoil(@NotNull ItemStack stack) {
        return !notInert;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        LangTooltip.super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }
}
