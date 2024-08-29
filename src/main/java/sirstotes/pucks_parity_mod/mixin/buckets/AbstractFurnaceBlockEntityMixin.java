package sirstotes.pucks_parity_mod.mixin.buckets;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sirstotes.pucks_parity_mod.PucksParityModItems;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin {
    @Inject(method = "craftRecipe", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;decrement(I)V"))
    private static void wetSpongeRecipeForNewBuckets(DynamicRegistryManager registryManager, @Nullable RecipeEntry<?> recipe, DefaultedList<ItemStack> slots, int count, CallbackInfoReturnable<Boolean> cir) {
        if (slots.get(0).isOf(Blocks.WET_SPONGE.asItem()) && !slots.get(1).isEmpty() && slots.get(1).isOf(PucksParityModItems.COPPER_BUCKET)) {
            slots.set(1, new ItemStack(PucksParityModItems.COPPER_WATER_BUCKET));
        }
    }
    @ModifyReturnValue(method = "canExtract", at = @At("RETURN"))
    public boolean canExtractNewBuckets(boolean original, int slot, ItemStack stack, Direction dir) {
        if (!original) {
            return dir == Direction.DOWN && slot == 1 ? stack.isOf(PucksParityModItems.COPPER_WATER_BUCKET) || stack.isOf(PucksParityModItems.COPPER_BUCKET) : true;
        }//TODO: Make this generic and not hard-coded
        return false;
    }
    @ModifyExpressionValue(method = "isValid", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z", ordinal = 0))
    public boolean checkOtherBuckets1(boolean original, @Local(ordinal = 0) ItemStack stack) {
        return original || stack.isOf(PucksParityModItems.COPPER_BUCKET);
    }
    @ModifyExpressionValue(method = "isValid", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z", ordinal = 1))
    public boolean checkOtherBuckets2(boolean original, @Local(ordinal = 1) ItemStack stack) {
        return original || stack.isOf(PucksParityModItems.COPPER_BUCKET);
    }
}
