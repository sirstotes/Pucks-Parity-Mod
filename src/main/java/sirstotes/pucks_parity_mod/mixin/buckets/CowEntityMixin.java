package sirstotes.pucks_parity_mod.mixin.buckets;

import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import sirstotes.pucks_parity_mod.PucksParityModBucket;
import sirstotes.pucks_parity_mod.PucksParityModItems;

@Mixin(CowEntity.class)
public abstract class CowEntityMixin {
    @ModifyExpressionValue(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    public boolean allowAllBucketsOninteractMob(boolean original, PlayerEntity player, Hand hand) {
        return original || player.getStackInHand(hand).isIn(ConventionalItemTags.BUCKETS) || player.getStackInHand(hand).isOf(PucksParityModItems.GOLD_MILK_BUCKET_1) || player.getStackInHand(hand).isOf(PucksParityModItems.GOLD_MILK_BUCKET_2);
	}
    @ModifyExpressionValue(method = "interactMob", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/Item;getDefaultStack()Lnet/minecraft/item/ItemStack;"))
    public ItemStack giveOtherMilkBuckets(ItemStack original, PlayerEntity player, Hand hand) {
        if (player.getStackInHand(hand).isIn(ConventionalItemTags.BUCKETS) || player.getStackInHand(hand).isOf(PucksParityModItems.GOLD_MILK_BUCKET_1) || player.getStackInHand(hand).isOf(PucksParityModItems.GOLD_MILK_BUCKET_2)) {
            return new ItemStack(((PucksParityModBucket) player.getStackInHand(hand).getItem()).pucks_Parity_Mod$getMilk());
        }
        return original;
    }
}
