package sirstotes.pucks_parity_mod.mixin.brush;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.entity.BrushableBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BrushItem;
import net.minecraft.util.Hand;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sirstotes.pucks_parity_mod.accessors.BrushItemMixinAccessor;

@Mixin(BrushableBlockEntity.class)
public class BrushableBlockEntityMixin {
    @ModifyConstant(method = "brush", constant = @Constant(intValue = 10))
    public int variableBrushTime(int constant, @Local(argsOnly = true) PlayerEntity player) {
        if(player.getStackInHand(Hand.MAIN_HAND).getItem() instanceof BrushItem brush) {
            return ((BrushItemMixinAccessor) brush).getBrushes();
        } else if(player.getStackInHand(Hand.OFF_HAND).getItem() instanceof BrushItem brush) {
            return ((BrushItemMixinAccessor) brush).getBrushes();
        }
        return constant;
    }
}
