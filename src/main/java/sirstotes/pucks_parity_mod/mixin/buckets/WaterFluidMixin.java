package sirstotes.pucks_parity_mod.mixin.buckets;

import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import sirstotes.pucks_parity_mod.accessors.BucketItemMixinAccessor;
import sirstotes.pucks_parity_mod.accessors.FluidMixinAccessor;

public abstract class WaterFluidMixin implements FluidMixinAccessor {
    public Item pucks_Parity_Mod$getBucketItem(BucketItem empty) {
        return ((BucketItemMixinAccessor) empty).pucks_Parity_Mod$getFilled(Fluids.WATER);
    }
}
