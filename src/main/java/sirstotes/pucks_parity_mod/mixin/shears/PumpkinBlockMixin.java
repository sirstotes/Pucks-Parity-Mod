package sirstotes.pucks_parity_mod.mixin.shears;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.block.PumpkinBlock;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sirstotes.pucks_parity_mod.PucksParityModItems;

@Mixin(PumpkinBlock.class)
public abstract class PumpkinBlockMixin {
    @ModifyExpressionValue(
        method = "onUseWithItem",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z")
    )
    public boolean includeNewShears(boolean original, ItemStack stack) {//TODO: This will break compatibility with other mods but I'm not sure what else to do.
        return !stack.isIn(PucksParityModItems.SHEARS);
    }
}
