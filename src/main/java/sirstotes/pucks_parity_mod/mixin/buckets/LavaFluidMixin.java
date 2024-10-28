package sirstotes.pucks_parity_mod.mixin.buckets;

import net.minecraft.fluid.Fluids;
import net.minecraft.fluid.LavaFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import sirstotes.pucks_parity_mod.PucksParityModBucket;
import sirstotes.pucks_parity_mod.accessors.FluidMixinAccessor;

@Mixin (LavaFluid.class)
public class LavaFluidMixin implements FluidMixinAccessor {
    public Item pucks_Parity_Mod$getBucketItem(BucketItem empty) {
        return ((PucksParityModBucket) empty).pucks_Parity_Mod$getFilled(Fluids.LAVA);
    }
}
