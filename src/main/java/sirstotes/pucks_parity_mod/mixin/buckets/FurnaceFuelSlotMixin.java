package sirstotes.pucks_parity_mod.mixin.buckets;
//?if >1.20.1 {
/*import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.FurnaceFuelSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sirstotes.pucks_parity_mod.PucksParityModItems;

@Mixin(FurnaceFuelSlot.class)
public class FurnaceFuelSlotMixin {
    @ModifyReturnValue(method = "isBucket", at = @At("RETURN"))
    private static boolean allowOtherBuckets(boolean original, @Local ItemStack stack) {
        return original || stack.isIn(ConventionalItemTags.BUCKETS);
    }
}//TODO:backport
*///?}