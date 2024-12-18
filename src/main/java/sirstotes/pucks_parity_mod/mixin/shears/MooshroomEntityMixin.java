package sirstotes.pucks_parity_mod.mixin.shears;
//?if >1.20.1 {
/*import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MooshroomEntity.class)
public abstract class MooshroomEntityMixin {
    @ModifyExpressionValue(
        method = "interactMob",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z", ordinal = 1)
    )
    public boolean includeNewShears(boolean original, PlayerEntity player, Hand hand) {
        return original || player.getStackInHand(hand).isIn(ConventionalItemTags.SHEAR_TOOLS);
    }
}//TODO: Backport
*///?}