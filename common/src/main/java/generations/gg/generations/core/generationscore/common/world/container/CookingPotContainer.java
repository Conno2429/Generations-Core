package generations.gg.generations.core.generationscore.common.world.container;

import com.cobblemon.mod.common.item.BerryItem;
import generations.gg.generations.core.generationscore.common.world.item.GenerationsItems;
import generations.gg.generations.core.generationscore.common.world.item.curry.CurryIngredient;
import generations.gg.generations.core.generationscore.common.world.level.block.entities.CookingPotBlockEntity;
import generations.gg.generations.core.generationscore.common.world.container.slots.CurryResultSlot;
import generations.gg.generations.core.generationscore.common.world.container.slots.PredicateSlotItemHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class CookingPotContainer extends AbstractContainerMenu {
    public final CookingPotBlockEntity cookingPot;

    public CookingPotContainer(GenerationsContainers.CreationContext<CookingPotBlockEntity> ctx) {
        super(GenerationsContainers.COOKING_POT.get(), ctx.id());
        this.cookingPot = ctx.blockEntity();

        var handler = ctx.blockEntity().getContainer();
        addSlot(new PredicateSlotItemHandler(handler, 0, 26, 8 + 11, CookingPotContainer::isBerryOrMaxMushrooms));
        addSlot(new PredicateSlotItemHandler(handler, 1, 44, 8 + 11, CookingPotContainer::isBerryOrMaxMushrooms));
        addSlot(new PredicateSlotItemHandler(handler, 2, 62, 8 + 11, CookingPotContainer::isBerryOrMaxMushrooms));
        addSlot(new PredicateSlotItemHandler(handler, 3, 80, 26 + 11, CookingPotContainer::isBerryOrMaxMushrooms));
        addSlot(new PredicateSlotItemHandler(handler, 4, 80, 44 + 11, CookingPotContainer::isBerryOrMaxMushrooms));
        addSlot(new PredicateSlotItemHandler(handler, 5, 62, 62 + 11, CookingPotContainer::isBerryOrMaxMushrooms));
        addSlot(new PredicateSlotItemHandler(handler, 6, 44, 62 + 11, CookingPotContainer::isBerryOrMaxMushrooms));
        addSlot(new PredicateSlotItemHandler(handler, 7, 26, 62 + 11, CookingPotContainer::isBerryOrMaxMushrooms));
        addSlot(new PredicateSlotItemHandler(handler, 8, 8, 44 + 11, CookingPotContainer::isBerryOrMaxMushrooms));
        addSlot(new PredicateSlotItemHandler(handler, 9, 8, 26 + 11, CookingPotContainer::isBerryOrMaxMushrooms));
        addSlot(new PredicateSlotItemHandler(handler, 10, 35, 35 + 11, CookingPotContainer::isBowl));
        addSlot(new PredicateSlotItemHandler(handler, 11, 53, 35 + 11, CookingPotContainer::isCurryIngredientOrMaxHoney));
        addSlot(new PredicateSlotItemHandler(handler, 12, 108, 57 + 11, CookingPotContainer::isLog));
        addSlot(new CurryResultSlot(ctx.playerInv().player, handler, 13, 142, 35 + 11));

        bindPlayerInventory(ctx.playerInv());
        sendAllDataToRemote();
    }

    private void bindPlayerInventory(Inventory player) {
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 9; x++) {
                addSlot(new Slot(player, x + y * 9 + 9, 8 + x * 18, 84 + y * 18 + 11 + 9));
            }
        }

        for (int x = 0; x < 9; x++) {
            addSlot(new Slot(player, x, 8 + x * 18, 142 + 11 + 9));
        }

    }

    private static boolean isBowl(ItemStack itemStack) {
        return itemStack.getItem() == Items.BOWL;
    }

    @Override
    public boolean stillValid(@NotNull Player playerIn) {
        return true; //TODO: WOrry about this later...
    }


    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player playerIn, int index) {
        Slot slot = this.slots.get(index);
        if (!slot.hasItem()) return ItemStack.EMPTY;

        ItemStack slotStack = slot.getItem();
        ItemStack originalStack = slotStack.copy(); // Copy to retain original data

        // Store NBT for debugging before we move it
        CompoundTag originalNBT = slotStack.hasTag() ? slotStack.getTag().copy() : null;


        boolean moved = false;

        // If the slot is the crafting output (slot 13), ensure crafting logic is applied before moving
        if (index == 13) {
//            System.out.println("  - Crafting Slot Detected! Running `onTake()` before moving.");
            slot.onTake(playerIn, slotStack);
        }

        if (index < 14) {
            this.moveItemStackTo(slotStack, 14, 49, false);
        } else if (index < 50) {
            if (isBerryOrMaxMushrooms(originalStack)) {
                this.moveItemStackTo(slotStack, 0, 10, false);
            } else if (isBowl(originalStack)) {
                this.moveItemStackTo(slotStack, 10, 11, false);
            } else if (isCurryIngredientOrMaxHoney(originalStack)) {
                this.moveItemStackTo(slotStack, 11, 12, false);
            } else if (isLog(originalStack)) {
                this.moveItemStackTo(slotStack, 12, 13, false);
            }
        }

        if (!ItemStack.matches(slotStack, originalStack)) {
            slotStack.setTag(originalNBT);
        }

        if (slotStack.getCount() == 0) {
            slot.safeInsert(ItemStack.EMPTY);
        } else {
            slot.setChanged();
        }

        if (slotStack.getCount() == originalStack.getCount()) {
            return ItemStack.EMPTY;
        }

        if (index == 13) {
            slot.onTake(playerIn, originalStack);
        }

        return originalStack;
    }

    public static boolean isLog(ItemStack stack) {
        return stack.is(ItemTags.LOGS_THAT_BURN);
    }

    public static boolean isBerryOrMaxMushrooms(ItemStack stack) {
        return stack.getItem() instanceof BerryItem || stack.getItem() == GenerationsItems.MAX_MUSHROOMS.get();
    }

    public static boolean isCurryIngredientOrMaxHoney(ItemStack stack) {
        return stack.getItem() instanceof CurryIngredient || stack.getItem() == GenerationsItems.MAX_HONEY.get();
    }

}
