package sirstotes.pucks_parity_mod.mixin.shears;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

import net.minecraft.block.BeehiveBlock;
import net.minecraft.item.ItemStack;

@Mixin(BeehiveBlock.class)
public abstract class BeehiveBlockMixin {
    @ModifyExpressionValue(
        method = "onUseWithItem",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z")
    )
    public boolean includeNewShears(boolean original, ItemStack stack) {
        return original || stack.isIn(ConventionalItemTags.SHEAR_TOOLS);
    }
}
