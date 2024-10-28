package sirstotes.pucks_parity_mod.mixin.buckets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import sirstotes.pucks_parity_mod.accessors.FluidDrainableMixinAccessor;
import sirstotes.pucks_parity_mod.accessors.FluidMixinAccessor;

import static net.minecraft.block.FluidBlock.LEVEL;

@Mixin(FluidBlock.class)
public class FluidBlockMixin implements FluidDrainableMixinAccessor {
    @Final
    @Shadow
    protected FlowableFluid fluid;
    @Unique
    public ItemStack pucks_Parity_Mod$tryDrainFluid(Item item, WorldAccess world, BlockPos pos, BlockState state) {
        if ((Integer)state.get(LEVEL) == 0) {
            world.setBlockState(pos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL_AND_REDRAW);
            if (item instanceof BucketItem) {
                return new ItemStack(((FluidMixinAccessor) this.fluid).pucks_Parity_Mod$getBucketItem((BucketItem) item));
            }
            return new ItemStack(this.fluid.getBucketItem());
        }
        return ItemStack.EMPTY;
    } //Can only do it this way if I make every single other FluidDrainable class also have a mixin for this.. Then other mod compatibility is out the window.

    @Override
    public boolean pucks_Parity_Mod$fluidEquals(Fluid _fluid) {
        return fluid == _fluid;
    }
}
