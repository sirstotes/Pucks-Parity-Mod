package sirstotes.pucks_parity_mod.accessors;

import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;

public interface BucketItemMixinAccessor {
    Item pucks_Parity_Mod$getFilled(Fluid fluid);
    Item pucks_Parity_Mod$getPowderedSnow();
    Item pucks_Parity_Mod$getMilk();
}
