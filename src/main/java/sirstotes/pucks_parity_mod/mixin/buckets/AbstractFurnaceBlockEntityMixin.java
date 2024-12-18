package sirstotes.pucks_parity_mod.mixin.buckets;
//?if >1.20.1 {
/*import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.input.SingleStackRecipeInput;
*///?}
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.AbstractCookingRecipe;
import net.minecraft.recipe.Recipe;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sirstotes.pucks_parity_mod.PucksParityModBucket;
import sirstotes.pucks_parity_mod.PucksParityModItems;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin {
    @Inject(method = "craftRecipe", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;decrement(I)V"))
    //?if <1.21.4 {
    private static void wetSpongeRecipeForNewBuckets(DynamicRegistryManager registryManager, Recipe<?> recipe, DefaultedList<ItemStack> slots, int count, CallbackInfoReturnable<Boolean> cir) {
    //?} else
    /*private static void wetSpongeRecipeForNewBuckets(DynamicRegistryManager dynamicRegistryManager, RecipeEntry<? extends AbstractCookingRecipe> recipe, SingleStackRecipeInput input, DefaultedList<ItemStack> inventory, int maxCount, CallbackInfoReturnable<Boolean> cir) {*/
        if (slots.get(0).isOf(Blocks.WET_SPONGE.asItem()) && !slots.get(1).isEmpty() && slots.get(1).isOf(PucksParityModItems.COPPER_BUCKET)) {
            slots.set(1, new ItemStack(PucksParityModItems.COPPER_WATER_BUCKET));
        } else if (slots.get(0).isOf(Blocks.WET_SPONGE.asItem()) && !slots.get(1).isEmpty() && slots.get(1).isOf(PucksParityModItems.GOLD_BUCKET)) {
            slots.set(1, new ItemStack(PucksParityModItems.GOLD_WATER_BUCKET_1));
        } else if (slots.get(0).isOf(Blocks.WET_SPONGE.asItem()) && !slots.get(1).isEmpty() && slots.get(1).isOf(PucksParityModItems.GOLD_WATER_BUCKET_1)) {
            slots.set(1, new ItemStack(PucksParityModItems.GOLD_WATER_BUCKET_2));
        } else if (slots.get(0).isOf(Blocks.WET_SPONGE.asItem()) && !slots.get(1).isEmpty() && slots.get(1).isOf(PucksParityModItems.GOLD_WATER_BUCKET_2)) {
            slots.set(1, new ItemStack(PucksParityModItems.GOLD_WATER_BUCKET_3));
        }
    }
    //?if >1.20.1 {
    /*@ModifyReturnValue(method = "canExtract", at = @At("RETURN"))
    public boolean canExtractNewBuckets(boolean original, int slot, ItemStack stack, Direction dir) {
        if (!original) {
            return dir != Direction.DOWN || slot != 1 || stack.isIn(ConventionalItemTags.BUCKETS) && (((PucksParityModBucket) stack.getItem()).pucks_Parity_Mod$getFluid() == Fluids.WATER || ((PucksParityModBucket) stack.getItem()).pucks_Parity_Mod$getFluid() == Fluids.EMPTY);
        }
        return false;
    }
    @ModifyExpressionValue(method = "isValid", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z", ordinal = 0))
    public boolean checkOtherBuckets1(boolean original, @Local(ordinal = 0, argsOnly = true) ItemStack stack) {
        return original || stack.isIn(ConventionalItemTags.BUCKETS);
    }
    @ModifyExpressionValue(method = "isValid", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z", ordinal = 1))
    public boolean checkOtherBuckets2(boolean original, @Local(ordinal = 1) ItemStack stack) {
        return original || stack.isIn(ConventionalItemTags.BUCKETS);
    }
    *///?}//TODO: Backport this.
}
