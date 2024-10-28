package sirstotes.pucks_parity_mod.mixin.buckets;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidDrainable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import sirstotes.pucks_parity_mod.PucksParityModBucket;
import sirstotes.pucks_parity_mod.accessors.FluidDrainableMixinAccessor;

@Mixin(BucketItem.class)
public abstract class BucketItemMixin implements PucksParityModBucket {
    @Unique
    public Fluid pucks_Parity_Mod$getFluid() {
        return fluid;
    }
//    @Unique
//    public ItemStack pucks_Parity_Mod$getEmptiedStack(ItemStack stack, PlayerEntity player) {
//        return !player.isInCreativeMode() ? new ItemStack(Items.BUCKET) : stack;
//    }
    @Unique
    public Item pucks_Parity_Mod$getFilled(Fluid fluid) {
        if(fluid == Fluids.WATER || fluid == Fluids.FLOWING_WATER) {
            return Items.WATER_BUCKET;
        } else if(fluid == Fluids.LAVA || fluid == Fluids.FLOWING_LAVA) {
            return Items.LAVA_BUCKET;
        }
        return Items.BUCKET;
    }
    @Unique
    public Item pucks_Parity_Mod$getPowderedSnow() {
        return Items.POWDER_SNOW_BUCKET;
    }
    @Unique
    public Item pucks_Parity_Mod$getMilk() {
        return Items.MILK_BUCKET;
    }
//    @ModifyExpressionValue(method = "use", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/FluidDrainable;tryDrainFluid(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/world/WorldAccess;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;)Lnet/minecraft/item/ItemStack;"))
//    private ItemStack drainFluidWithBucketType(ItemStack original, World world, PlayerEntity user, Hand hand, @Local FluidDrainable fluidDrainable, @Local(ordinal = 0) BlockPos blockPos, @Local BlockState blockState) {
//        //return ((FluidDrainableMixinAccessor) fluidDrainable).pucks_Parity_Mod$tryDrainFluid(user.getStackInHand(hand).getItem(), world, blockPos, blockState);
//
//        if (FluidDrainableMixinAccessor.class.isAssignableFrom(fluidDrainable.getClass())) {
//            System.out.println("Assignable");
//            return ((FluidDrainableMixinAccessor) fluidDrainable).pucks_Parity_Mod$tryDrainFluid(user.getStackInHand(hand).getItem(), world, blockPos, blockState);
//        }
//        System.out.println("NOT Assignable");
//        return original;
//    }
//    @ModifyArg(method = "use", at= @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemUsage;exchangeStack(Lnet/minecraft/item/ItemStack;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/item/ItemStack;)Lnet/minecraft/item/ItemStack;", ordinal = 1), index = 2)
//    private ItemStack emptyBucketWithBucketType(ItemStack original, @Local(ordinal = 0) ItemStack stack, @Local PlayerEntity player) {
//        return pucks_Parity_Mod$getEmptiedStack(stack, player);
//    }
////    @ModifyExpressionValue(method = "use", at= @At(value = "INVOKE", target = "Lnet/minecraft/item/BucketItem;fluid:Lnet/minecraft/fluid/Fluid;"))
////    private boolean fillIfEmpty() {
////        return pucks_Parity_Mod$isFull();
////    }
//    @Unique
//    public boolean pucks_Parity_Mod$isFull() {
//        return ((BucketItemMixinAccessor) this).fluid != Fluids.EMPTY;
//    }
}
