package generations.gg.generations.core.generationscore.world.item;

import generations.gg.generations.core.generationscore.world.entity.TieredFishingHookEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class RubyRodItem extends TieredFishingRodItem implements LangTooltip {
    public RubyRodItem(Properties properties, TieredFishingHookEntity.Teir tier) {
        super(properties, tier);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltipComponents, TooltipFlag isAdvanced) {
        LangTooltip.super.appendHoverText(stack, level, tooltipComponents, isAdvanced);
    }
}
