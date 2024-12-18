package sirstotes.pucks_parity_mod.accessors;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;

public interface FluidDrainableMixinAccessor {
    ItemStack pucks_Parity_Mod$tryDrainFluid(Item item, WorldAccess world, BlockPos pos, BlockState state);
    boolean pucks_Parity_Mod$fluidEquals(Fluid fluid, BlockState state);
    default boolean pucks_Parity_Mod$isPowderSnow() {
        return false;
    }
}
