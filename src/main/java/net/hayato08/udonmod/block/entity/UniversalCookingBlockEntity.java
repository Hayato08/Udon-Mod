package net.hayato08.udonmod.block.entity;


import net.hayato08.udonmod.client.gui.UniversalCookingBlockMenu;
import net.hayato08.udonmod.recipe.UdonRecipes;
import net.hayato08.udonmod.recipe.UniversalCookingBlockRecipe;
import net.hayato08.udonmod.recipe.UniversalCookingBlockRecipeInput;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;


public class UniversalCookingBlockEntity extends BlockEntity implements MenuProvider {

    public static final int SLOT_COUNT = 2;
    private static final int INPUT_SLOT_0 = 0;
    private static final int OUTPUT_SLOT_1 = INPUT_SLOT_0 + 1;

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;



    public final ItemStackHandler itemHandler = new ItemStackHandler(SLOT_COUNT)
    {
        @Override
        protected void onContentsChanged (int slot)
        {
            setChanged();
            if (!level.isClientSide) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };


    public UniversalCookingBlockEntity(BlockPos pos, BlockState blockState) {
        super(UdonBlockEntities.UNIVERSAL_COOKING_BLOCK_ENTITY.get(), pos, blockState);
        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i)
                {
                    case 0 -> UniversalCookingBlockEntity.this.progress;
                    case 1 -> UniversalCookingBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i){
                    case 0: UniversalCookingBlockEntity.this.progress = value;
                    case 1: UniversalCookingBlockEntity.this.maxProgress = value;

                }

            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.udonmod.universal_cooking_block");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new UniversalCookingBlockMenu(i, inventory, this, this.data);
    }

    public void drops()
    {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0 ; i < itemHandler.getSlots() ; i ++)
        {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("inventory", itemHandler.serializeNBT(registries));
        tag.putInt("universal_cooking_block.progress", progress);
        tag.putInt("universal_cooking_block.max_progress", maxProgress);

        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);

        itemHandler.deserializeNBT(registries, tag.getCompound("inventory"));
        progress = tag.getInt("universal_cooking_block.progress");
        maxProgress = tag.getInt("universal_cooking_block.max_progress");
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        if(hasResipe())
        {
            intcreaseCraftingProgress();
            setChanged(level, blockPos, blockState);

            if(hasCraftingFinished())
            {
                craftItem();
                resetProgress();
            }
        }
        else
        {
            resetProgress();
        }
    }

    private void resetProgress() {
        progress = 0;
        maxProgress = 72;
    }

    private void craftItem() {
        Optional<RecipeHolder<UniversalCookingBlockRecipe>> recipe = getCurentRecipe();
        ItemStack output = recipe.get().value().output();

        itemHandler.extractItem(INPUT_SLOT_0, 1, false);
        itemHandler.setStackInSlot(OUTPUT_SLOT_1, new ItemStack(output.getItem(),
                itemHandler.getStackInSlot(OUTPUT_SLOT_1).getCount() + output.getCount()));
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void intcreaseCraftingProgress() {
        progress ++;
    }


    // 指定したスロットに特定のアイテムがあるかどうか
    private boolean hasResipe() {
        Optional<RecipeHolder<UniversalCookingBlockRecipe>> recipe = getCurentRecipe();
        if(recipe.isEmpty())
        {
            return false;
        }
        ItemStack output = recipe.get().value().output();

        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private Optional<RecipeHolder<UniversalCookingBlockRecipe>> getCurentRecipe() {
        return this.level.getRecipeManager()
                .getRecipeFor(UdonRecipes.UNIVERSAL_COOKING_BLOCK_TYPE.get(), new UniversalCookingBlockRecipeInput(itemHandler.getStackInSlot(INPUT_SLOT_0)), level);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return itemHandler.getStackInSlot(OUTPUT_SLOT_1).isEmpty() ||
                itemHandler.getStackInSlot(OUTPUT_SLOT_1).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = itemHandler.getStackInSlot(OUTPUT_SLOT_1).isEmpty() ? 64 : itemHandler.getStackInSlot(OUTPUT_SLOT_1).getMaxStackSize();
        int currentCount = itemHandler.getStackInSlot(OUTPUT_SLOT_1).getCount();

        return maxCount >= currentCount + count;
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return super.getUpdateTag(registries);
    }

    @Override
    public @Nullable Packet<ClientGamePacketListener> getUpdatePacket() {
        return super.getUpdatePacket();
    }

}
