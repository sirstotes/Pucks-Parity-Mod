package sirstotes.pucks_parity_mod;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidDrainable;
import net.minecraft.block.FluidFillable;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import sirstotes.pucks_parity_mod.accessors.FluidDrainableMixinAccessor;
import sirstotes.pucks_parity_mod.mixin.buckets.WaterloggableMixin;

public class CopperBucketItem extends BucketItem implements PucksParityModBucket {

    private Fluid fluid;
    public CopperBucketItem(Fluid _fluid, Settings settings) {
        super(_fluid, settings);
        fluid = _fluid;
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult blockHitResult = raycast(
                world, user, this.fluid == Fluids.EMPTY ? net.minecraft.world.RaycastContext.FluidHandling.SOURCE_ONLY : RaycastContext.FluidHandling.NONE
        );
        if (blockHitResult.getType() == HitResult.Type.MISS) {
            return TypedActionResult.pass(itemStack);
        } else if (blockHitResult.getType() != HitResult.Type.BLOCK) {
            return TypedActionResult.pass(itemStack);
        } else {
            BlockPos blockPos = blockHitResult.getBlockPos();
            Direction direction = blockHitResult.getSide();
            BlockPos blockPos2 = blockPos.offset(direction);
            if (!world.canPlayerModifyAt(user, blockPos) || !user.canPlaceOn(blockPos2, direction, itemStack)) {
                return TypedActionResult.fail(itemStack);
            } else if (this.fluid == Fluids.EMPTY) {
                BlockState blockState = world.getBlockState(blockPos);
                if (blockState.getBlock() instanceof FluidDrainable fluidDrainable) {
                    ItemStack itemStack2 = ((FluidDrainableMixinAccessor) fluidDrainable).pucks_Parity_Mod$tryDrainFluid(this, world, blockPos, blockState);
                    if (!itemStack2.isEmpty()) {
                        user.incrementStat(Stats.USED.getOrCreateStat(this));
                        fluidDrainable.getBucketFillSound().ifPresent(sound -> user.playSound(sound, 1.0F, 1.0F));
                        world.emitGameEvent(user, GameEvent.FLUID_PICKUP, blockPos);
                        ItemStack itemStack3 = ItemUsage.exchangeStack(itemStack, user, itemStack2);
                        if (!world.isClient) {
                            Criteria.FILLED_BUCKET.trigger((ServerPlayerEntity)user, itemStack2);
                        }

                        return TypedActionResult.success(itemStack3, world.isClient());
                    }
                }

                return TypedActionResult.fail(itemStack);
            } else {
                BlockState blockState = world.getBlockState(blockPos);
                BlockPos blockPos3 = blockState.getBlock() instanceof FluidFillable && this.fluid == Fluids.WATER ? blockPos : blockPos2;
                if (this.placeFluid(user, world, blockPos3, blockHitResult)) {
                    this.onEmptied(user, world, itemStack, blockPos3);
                    if (user instanceof ServerPlayerEntity) {
                        Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity)user, blockPos3, itemStack);
                    }

                    user.incrementStat(Stats.USED.getOrCreateStat(this));
                    ItemStack itemStack2 = ItemUsage.exchangeStack(itemStack, user, getEmptiedStack(itemStack, user));
                    return TypedActionResult.success(itemStack2, world.isClient());
                } else {
                    return TypedActionResult.fail(itemStack);
                }
            }
        }
    }

    public ItemStack pucks_Parity_Mod$getEmptiedStack(ItemStack stack, PlayerEntity player) {
        return !player.isInCreativeMode() ? new ItemStack(PucksParityModItems.COPPER_BUCKET) : stack;
    }
    public static ItemStack getEmptiedStack(ItemStack stack, PlayerEntity player) {
        return !player.isInCreativeMode() ? new ItemStack(PucksParityModItems.COPPER_BUCKET) : stack;
    }

    @Override
    public Fluid pucks_Parity_Mod$getFluid() {
        return fluid;
    }

    public Item pucks_Parity_Mod$getFilled(Fluid fluid) {
        if(fluid == Fluids.WATER || fluid == Fluids.FLOWING_WATER) {
            return PucksParityModItems.COPPER_WATER_BUCKET;
        } else if(fluid == Fluids.LAVA || fluid == Fluids.FLOWING_LAVA) {
            return PucksParityModItems.COPPER_LAVA_BUCKET;
        }
        return PucksParityModItems.COPPER_BUCKET;
    }

    public Item pucks_Parity_Mod$getPowderedSnow() {
        return PucksParityModItems.COPPER_POWDER_SNOW_BUCKET;
    }

    public Item pucks_Parity_Mod$getMilk() {
        return PucksParityModItems.COPPER_MILK_BUCKET;
    }

    public boolean pucks_Parity_Mod$isFull() {
        return fluid != Fluids.EMPTY;
    }

    public Item pucks_Parity_Mod$getEmptied() {
        return PucksParityModItems.COPPER_BUCKET;
    }
}
