package sirstotes.pucks_parity_mod.mixin.brush;

//?if >1.20.1
/*import com.llamalad7.mixinextras.sugar.Local;*/
import net.minecraft.block.entity.BrushableBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BrushItem;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import sirstotes.pucks_parity_mod.accessors.BrushItemMixinAccessor;

@Mixin(BrushableBlockEntity.class)
public class BrushableBlockEntityMixin {

    //?if < 1.21.1 {
    @Inject(method = "brush", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/entity/BrushableBlockEntity;getDustedLevel()I", shift = At.Shift.AFTER), cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    public void endBrushingEarlyIfSpecial(long worldTime, PlayerEntity player, Direction hitDirection, CallbackInfoReturnable<Boolean> cir) {
        brushesCount ++;
        if (brushesCount >= 10) {
            finishBrushing(player);
            cir.setReturnValue(true);
        } else {
            brushesCount -= 1;
        }
    }
    @Shadow
    private int brushesCount;
    @Shadow
    private void finishBrushing(PlayerEntity player) {}
    //?} else {
    /*@ModifyConstant(method = "brush", constant = @Constant(intValue = 10))
    public int variableBrushTime(int constant, @Local(argsOnly = true) PlayerEntity player) {
        if(player.getStackInHand(Hand.MAIN_HAND).getItem() instanceof BrushItem brush) {
            return ((BrushItemMixinAccessor) brush).getBrushes();
        } else if(player.getStackInHand(Hand.OFF_HAND).getItem() instanceof BrushItem brush) {
            return ((BrushItemMixinAccessor) brush).getBrushes();
        }
        return constant;
    }
    *///?}
}
