package generations.gg.generations.core.generationscore.common.world.level.block.entities;

import com.cobblemon.mod.common.pokemon.Pokemon;
import com.google.common.collect.Lists;
import dev.architectury.registry.menu.ExtendedMenuProvider;
import dev.architectury.registry.menu.MenuRegistry;
import generations.gg.generations.core.generationscore.common.world.container.GenerationsContainers;
import generations.gg.generations.core.generationscore.common.world.container.RksMachineContainer;
import generations.gg.generations.core.generationscore.common.world.recipe.GenerationsCoreRecipeTypes;
import generations.gg.generations.core.generationscore.common.world.recipe.RksRecipe;
import generations.gg.generations.core.generationscore.common.world.sound.GenerationsSounds;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.ExperienceOrb;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RksMachineBlockEntity extends ModelProvidingBlockEntity implements MenuRegistry.ExtendedMenuTypeFactory<RksMachineContainer>, ExtendedMenuProvider, Container, RecipeHolder, StackedContentsCompatible, Toggleable {

    private static final int[] OUTPUT_SLOTS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static final int[] INPUT_SLOTS = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    private static final int DEFAULT_PROCESSING_TIME = 200;
    private static final String INVENTORY_TAG = "Inventory";
    private static final String PROCESSING_TIME_TAG = "ProcessingTime";
    private static final String PROCESSING_TIME_TOTAL_TAG = "ProcessingTimeTotal";
    private static final String IS_PROCESSING_TAG = "IsProcessing";

    public int processingTime;
    public int processTimeTotal;
    public Optional<Pokemon> pokemon;

    private boolean isProcessing = false;

    public NonNullList<ItemStack> inventory;
    public ItemStack output = ItemStack.EMPTY;
    private Recipe<?> lastRecipe;
    private final List<RksMachineContainer> openContainers = new ArrayList<>();

    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed = new Object2IntOpenHashMap<>();


    public RksMachineBlockEntity(BlockPos pos, BlockState state) {
        super(GenerationsBlockEntities.RKS_MACHINE.get(), pos, state);
        this.inventory = NonNullList.withSize(9, ItemStack.EMPTY);
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag nbt) {
        super.saveAdditional(nbt);
        CompoundTag inventoryTag = new CompoundTag();
        ContainerHelper.saveAllItems(inventoryTag, inventory);
        inventoryTag.put("Output", output.save(new CompoundTag()));
        nbt.put(INVENTORY_TAG, inventoryTag);
        nbt.putInt(PROCESSING_TIME_TAG, this.processingTime);
        nbt.putInt(PROCESSING_TIME_TOTAL_TAG, this.processTimeTotal);
        nbt.putBoolean(IS_PROCESSING_TAG, this.isProcessing);
    }

    public void load(@NotNull CompoundTag nbt) {
        super.load(nbt);
        CompoundTag inventoryTag = nbt.getCompound(INVENTORY_TAG);
        ContainerHelper.loadAllItems(inventoryTag, this.inventory);
        this.output = ItemStack.of(inventoryTag.getCompound("Output"));
        this.processingTime = nbt.getInt(PROCESSING_TIME_TAG);
        this.processTimeTotal = nbt.getInt(PROCESSING_TIME_TOTAL_TAG);
        this.isProcessing = nbt.getBoolean(IS_PROCESSING_TAG);
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable(getBlockState().getBlock().getDescriptionId());
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int syncId, @NotNull Inventory inv, @NotNull Player player) {
        return new RksMachineContainer(new GenerationsContainers.CreationContext<>(syncId, inv, this));
    }

//    @Override
//    public int[] getSlotsForFace(Direction dir) {
//        return (dir == Direction.DOWN && (!output.isEmpty() || getCurrentRecipe().isPresent())) ? OUTPUT_SLOTS : INPUT_SLOTS;
//    }
//
//    @Override
//    public boolean canPlaceItemThroughFace(int slot, ItemStack stack, Direction dir) {
//        return slot > 0 && getItem(slot).isEmpty();
//    }
//
//    @Override
//    public boolean canTakeItemThroughFace(int slot, ItemStack stack, Direction dir) {
//        return slot != 0 || !output.isEmpty() || getCurrentRecipe().isPresent();
//    }

    @Override
    public boolean canPlaceItem(int slot, @NotNull ItemStack stack) {
        return slot != 0 && slot <= getContainerSize();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : this.inventory) {
            if (!stack.isEmpty()) return false;
        }
        return output.isEmpty();
    }

    @Override
    public int getContainerSize() {
        return 10;
    }

    public boolean isInputEmpty() {
        for (ItemStack stack : this.inventory) {
            if (!stack.isEmpty()) return false;
        }
        return true;
    }


    @Override
    public @NotNull ItemStack getItem(int slot) {
        if (slot > 0) return this.inventory.get(slot - 1);
        if (!output.isEmpty()) return output;
        return ItemStack.EMPTY;
    }

    @Override
    public @NotNull ItemStack removeItem(int slot, int amount) {
        if (slot == 0) {
            return output.split(amount);
        }
        return ContainerHelper.removeItem(this.inventory, slot - 1, amount);
    }

    @Override
    public @NotNull ItemStack removeItemNoUpdate(int slot) {
        if (slot == 0) {
            ItemStack output = this.output;
            this.output = ItemStack.EMPTY;
            return output;
        }
        return ContainerHelper.takeItem(this.inventory, slot - 1);
    }

    @Override
    public void setItem(int slot, @NotNull ItemStack stack) {
        if (slot == 0) {
            output = stack;
            return;
        }
        inventory.set(slot - 1, stack);
        setChanged();
    }

    @Override
    public void setChanged() {
        super.setChanged();
        for (RksMachineContainer c : openContainers) c.slotsChanged(this);
    }

    @Override
    public boolean stillValid(Player player) {
        return player.getOnPos().distSqr(this.worldPosition) <= 64.0D;
    }

    @Override
    public void fillStackedContents(@NotNull StackedContents finder) {
        for (ItemStack stack : this.inventory) finder.accountStack(stack);
    }

    @Override
    public void setRecipeUsed(Recipe<?> recipe) {
        lastRecipe = recipe;
    }

    @Override
    public Recipe<?> getRecipeUsed() {
        return lastRecipe;
    }

    @Override
    public void clearContent() {
        this.inventory.clear();
    }

    private Optional<? extends RksRecipe<?>> getCurrentRecipe() {
        // No need to find recipes if the inventory is empty. Cannot craft anything.
        if (this.level == null || this.isEmpty()) return Optional.empty();

        RksRecipe<?> lastRecipe = (RksRecipe<?>) getRecipeUsed();
        RecipeManager manager = this.level.getRecipeManager();

        if (lastRecipe != null) {
            RksRecipe<?> mapRecipe = getMappedRecipe(manager, lastRecipe.getId());
            if (mapRecipe != null && mapRecipe.matches(this, level)) {
                return Optional.of(lastRecipe);
            }
        }
        return getMappedRecipe(manager);
    }

    private Optional<? extends RksRecipe<?>> getMappedRecipe(RecipeManager manager) {
        var recipe = manager.getRecipeFor(GenerationsCoreRecipeTypes.RKS_ITEM.get(), this, level);

        if(recipe.isEmpty()) return manager.getRecipeFor(GenerationsCoreRecipeTypes.RKS_POKEMON.get(), this, level);
        else return recipe;
    }

    private RksRecipe<?> getMappedRecipe(RecipeManager manager, ResourceLocation id) {
        var recipe = manager.byType(GenerationsCoreRecipeTypes.RKS_ITEM.get()).get(id);

        if(recipe == null) manager.byType(GenerationsCoreRecipeTypes.RKS_POKEMON.get()).get(id);

        return recipe;
    }

    private Optional<ItemStack> getResult() {
        Optional<ItemStack> maybe_result = getCurrentRecipe().map(recipe -> recipe.assemble(this, null));

        return Optional.of(maybe_result.orElse(ItemStack.EMPTY));
    }

    protected boolean canSmelt(ItemStack result, RksRecipe recipe) {
        if (recipe.matches(this, null)) {
            ItemStack outstack = output;
            if (outstack.isEmpty()) {
                return true;
            } else if (!ItemStack.isSameItem(outstack, result)) {
                return false;
            } else {
                return (outstack.getCount() + result.getCount() <= (recipe.isPokemonResult() ? 1 :outstack.getMaxStackSize()));
            }
        } else {
            return false;
        }
    }

    private int getProcessingTime() {
        return getCurrentRecipe().map(RksRecipe::processingTime).orElse(DEFAULT_PROCESSING_TIME);
    }

    protected void smelt(ItemStack result, RksRecipe recipe) {
        if(recipe.isIncomplete()) return;

        if (!result.isEmpty() && this.canSmelt(result, recipe)) {
            ItemStack outstack = output.copy();

            if (outstack.isEmpty()) {
                output = result.copy();
            } else if (outstack.getItem() == result.getItem()) {
                output.grow(result.getCount());
            }

            if (!this.level.isClientSide()) {
                this.setRecipeUsed(recipe);
            }

            NonNullList<ItemStack> remaining = recipe.getRemainingItems(this);
            NonNullList<ItemStack> drops = NonNullList.create();

            for (int i = 0; i < 9; i++) {
                ItemStack current = inventory.get(i);
                ItemStack remainingStack = remaining.get(i);
                if (!current.isEmpty()) current.shrink(1);
                if (!remainingStack.isEmpty()) {
                    if (current.isEmpty()) {
                        inventory.set(i, remainingStack);
                    } else if (ItemStack.matches(current, remainingStack)) {
                        current.grow(remainingStack.getCount());
                    } else {
                        drops.add(remainingStack);
                    }
                }
            }

            Containers.dropContents(level, worldPosition, drops);
        }
    }

    public static void serverTick(Level level, BlockPos blockpos, BlockState blockstate, RksMachineBlockEntity tile) {
        boolean flag1 = false;

        if (tile.isToggled()) {
            ItemStack result = tile.getResult().orElse(ItemStack.EMPTY);

            Optional<? extends RksRecipe<?>> recipe = tile.getCurrentRecipe();

            if (recipe.isPresent() && (!tile.isInputEmpty())) {
                if (tile.canSmelt(result, recipe.get())) {
                    if (tile.processingTime <= 0) {
                        tile.processTimeTotal = tile.getProcessingTime();
                        tile.processingTime = 0;
                    }
                }
                ++tile.processingTime;

                if(tile.processingTime % 60 == 0) {
                    level.playSound(null, blockpos, GenerationsSounds.RKS_MACHINE.get(), SoundSource.BLOCKS, 1.0f, 1.0f);
                }

                if (tile.processingTime >= tile.processTimeTotal) {
                    tile.smelt(result, recipe.get());
                    tile.processingTime = 0;

                    tile.processTimeTotal = !tile.isInputEmpty() ? tile.getProcessingTime() : 0;

                    tile.setToggled(false);
                }
            }
            else {
                tile.processingTime = 0;
                tile.setToggled(false);
            }
        }/* else if (tile.processingTime > 0) {
            tile.processingTime = Mth.clamp(tile.processingTime - 2, 0, tile.processTimeTotal);
        }*/

        tile.sync();
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NotNull CompoundTag getUpdateTag() {
        return this.saveWithFullMetadata();
    }

    public void awardUsedRecipesAndPopExperience(ServerPlayer player) {
        List<Recipe<?>> list = this.getRecipesToAwardAndPopExperience(player.serverLevel(), player.position());
        player.awardRecipes(list);
        this.recipesUsed.clear();
    }

    public List<Recipe<?>> getRecipesToAwardAndPopExperience(ServerLevel level, Vec3 popVec) {
        ArrayList<Recipe<?>> list = Lists.newArrayList();
        for (Object2IntMap.Entry<?> entry : this.recipesUsed.object2IntEntrySet()) {
            level.getRecipeManager().byKey((ResourceLocation)entry.getKey()).ifPresent(recipe -> {
                list.add(recipe);
                createExperience(level, popVec, entry.getIntValue(), ((RksRecipe)recipe).experience());
            });
        }
        return list;
    }

    private static void createExperience(ServerLevel level, Vec3 popVec, int recipeIndex, float experience) {
        int i = Mth.floor((float)recipeIndex * experience);
        float f = Mth.frac((float)recipeIndex * experience);
        if (f != 0.0f && Math.random() < (double)f) {
            ++i;
        }
        ExperienceOrb.award(level, popVec, i);
    }

    @Override
    public void setToggled(boolean toggle) {
        isProcessing = toggle;
    }

    @Override
    public boolean isToggled() {
        return isProcessing;
    }

    @Override
    public void saveExtraData(FriendlyByteBuf buf) {
        buf.writeBlockPos(getBlockPos());
    }

    @Override
    public RksMachineContainer create(int id, Inventory inventory, FriendlyByteBuf buf) {
        if (inventory.player.level().getBlockEntity(buf.readBlockPos()) instanceof RksMachineBlockEntity cookingPot) {
            return new RksMachineContainer(new GenerationsContainers.CreationContext<>(id, inventory, cookingPot));
        } else {
            return null;
        }
    }
}
