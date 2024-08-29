package sirstotes.pucks_parity_mod.mixin.buckets;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import sirstotes.pucks_parity_mod.accessors.FluidMixinAccessor;

@Mixin (Fluid.class)
public abstract class FluidMixin implements FluidMixinAccessor {
    public abstract Item getBucketItem(BucketItem empty);
}
