package sirstotes.pucks_parity_mod.mixin.buckets;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.passive.GoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sirstotes.pucks_parity_mod.PucksParityModItems;

@Mixin(GoatEntity.class)
public class GoatEntityMixin {
    @ModifyExpressionValue(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    public boolean allowAllBucketsOninteractMob(boolean original, PlayerEntity player, Hand hand) {
        return original || player.getStackInHand(hand).isOf(PucksParityModItems.COPPER_BUCKET);//TODO: Make this generic and not hardcoded
    }
    @ModifyExpressionValue(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item;getDefaultStack()Lnet/minecraft/item/ItemStack;"))
    public ItemStack giveOtherMilkBuckets(ItemStack original, PlayerEntity player, Hand hand) {
        if (player.getStackInHand(hand).isOf(PucksParityModItems.COPPER_BUCKET)) {
            return PucksParityModItems.COPPER_MILK_BUCKET.getDefaultStack();//TODO: Make this generic and not hardcoded
        }
        return original;
    }
}
