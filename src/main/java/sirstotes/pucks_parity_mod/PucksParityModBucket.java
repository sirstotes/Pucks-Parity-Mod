package sirstotes.pucks_parity_mod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public interface PucksParityModBucket {
    Fluid fluid = null;

    Fluid pucks_Parity_Mod$getFluid();
    Item pucks_Parity_Mod$getFilled(Fluid fluid);
    Item pucks_Parity_Mod$getEmptied();
    Item pucks_Parity_Mod$getPowderedSnow();
    Item pucks_Parity_Mod$getMilk();
}
