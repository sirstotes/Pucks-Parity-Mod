package sirstotes.pucks_parity_mod.mixin.shears;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

import net.minecraft.block.BeehiveBlock;
import net.minecraft.item.ItemStack;
import sirstotes.pucks_parity_mod.PucksParityModItems;

@Mixin(BeehiveBlock.class)
public abstract class BeehiveBlockMixin {
    @ModifyExpressionValue(
        method = "onUseWithItem",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z")
    )
    public boolean includeNewShears(boolean original, ItemStack stack) {
        return original || stack.isIn(PucksParityModItems.SHEARS);
    }
}
