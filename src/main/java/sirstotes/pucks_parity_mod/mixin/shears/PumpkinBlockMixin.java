package sirstotes.pucks_parity_mod.mixin.shears;
//?if >1.20.1 {
/*import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.block.PumpkinBlock;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(PumpkinBlock.class)
public abstract class PumpkinBlockMixin {
    @ModifyExpressionValue(method = "onUseWithItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    public boolean includeNewShears(boolean original, ItemStack stack) {
        return original || stack.isIn(ConventionalItemTags.SHEAR_TOOLS);
    }
}
*///?}