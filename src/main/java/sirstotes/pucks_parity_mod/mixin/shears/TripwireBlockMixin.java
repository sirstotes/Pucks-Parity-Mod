package sirstotes.pucks_parity_mod.mixin.shears;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.TripwireBlock;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(TripwireBlock.class)
public abstract class TripwireBlockMixin {
    @ModifyExpressionValue(
        method = "onBreak",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z")
    )
    public boolean includeNewShears(boolean original, @Local PlayerEntity player) {
        return original || player.getMainHandStack().isIn(ConventionalItemTags.SHEAR_TOOLS);
    }
}
