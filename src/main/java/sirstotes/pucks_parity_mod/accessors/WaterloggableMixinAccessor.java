package sirstotes.pucks_parity_mod.accessors;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidFillable;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Unique;
import sirstotes.pucks_parity_mod.PucksParityModBucket;

public interface WaterloggableMixinAccessor extends FluidDrainableMixinAccessor, FluidFillable {
    default ItemStack pucks_Parity_Mod$tryDrainFluid(Item item, WorldAccess world, BlockPos pos, BlockState state) {
        if ((Boolean) state.get(Properties.WATERLOGGED)) {
            world.setBlockState(pos, state.with(Properties.WATERLOGGED, false), Block.NOTIFY_ALL);
            if (!state.canPlaceAt(world, pos)) {
                world.breakBlock(pos, true);
            }

            return new ItemStack(((PucksParityModBucket) item).pucks_Parity_Mod$getFilled(Fluids.WATER));
        } else {
            return ItemStack.EMPTY;
        }
    }
    default boolean pucks_Parity_Mod$fluidEquals(Fluid fluid) {
        return fluid == Fluids.WATER || fluid == Fluids.FLOWING_WATER;
    }
}