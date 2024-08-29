package sirstotes.pucks_parity_mod.mixin.buckets;

import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sirstotes.pucks_parity_mod.accessors.BucketItemMixinAccessor;
import sirstotes.pucks_parity_mod.accessors.FluidDrainableMixinAccessor;
import sirstotes.pucks_parity_mod.accessors.FluidMixinAccessor;

@Mixin(WaterFluid.Still.class)
public class WaterFluid$StillMixin implements FluidMixinAccessor {
    public Item pucks_Parity_Mod$getBucketItem(BucketItem empty) {
        return ((BucketItemMixinAccessor) empty).pucks_Parity_Mod$getFilled(Fluids.WATER);
    }
}
