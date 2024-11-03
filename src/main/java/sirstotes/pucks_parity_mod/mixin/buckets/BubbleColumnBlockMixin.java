package sirstotes.pucks_parity_mod.mixin.buckets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BubbleColumnBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sirstotes.pucks_parity_mod.PucksParityModBucket;
import sirstotes.pucks_parity_mod.accessors.FluidDrainableMixinAccessor;

@Mixin(BubbleColumnBlock.class)
public class BubbleColumnBlockMixin implements FluidDrainableMixinAccessor {
    @Unique
    public ItemStack pucks_Parity_Mod$tryDrainFluid(Item item, WorldAccess world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);

        if (item instanceof BucketItem) {
            return new ItemStack(((PucksParityModBucket) item).pucks_Parity_Mod$getFilled(Fluids.WATER));
        }
        return new ItemStack(Items.WATER_BUCKET);
    }

    @Override
    public boolean pucks_Parity_Mod$fluidEquals(Fluid fluid, BlockState state) {
        return (fluid == Fluids.WATER || fluid == Fluids.FLOWING_WATER);
    }
}
