package sirstotes.pucks_parity_mod;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidDrainable;
import net.minecraft.block.FluidFillable;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.ActionResult;

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

public class CopperBucketItem extends BucketItem implements PucksParityModBucket {

    private Fluid fluid;
    public CopperBucketItem(Fluid _fluid, Settings settings) {
        super(_fluid, settings);
        fluid = _fluid;
    }
    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult blockHitResult = raycast(
                world, user, this.fluid == Fluids.EMPTY ? net.minecraft.world.RaycastContext.FluidHandling.SOURCE_ONLY : RaycastContext.FluidHandling.NONE
        );
        if (blockHitResult.getType() == HitResult.Type.MISS) {
            return ActionResult.PASS;
        } else if (blockHitResult.getType() != HitResult.Type.BLOCK) {
            return ActionResult.PASS;
        } else {
            BlockPos blockPos = blockHitResult.getBlockPos();
            Direction direction = blockHitResult.getSide();
            BlockPos blockPos2 = blockPos.offset(direction);
            if (world.canPlayerModifyAt(user, blockPos) && user.canPlaceOn(blockPos2, direction, itemStack)) {
                BlockState blockState = world.getBlockState(blockPos);
                ItemStack itemStack2;
                if (this.fluid == Fluids.EMPTY) {
                    blockState = world.getBlockState(blockPos);
                    Block var14 = blockState.getBlock();
                    if (var14 instanceof FluidDrainable) {
                        FluidDrainable fluidDrainable = (FluidDrainable)var14;
                        itemStack2 = ((FluidDrainableMixinAccessor) fluidDrainable).pucks_Parity_Mod$tryDrainFluid(this, world, blockPos, blockState);
                        if (!itemStack2.isEmpty()) {
                            user.incrementStat(Stats.USED.getOrCreateStat(this));
                            fluidDrainable.getBucketFillSound().ifPresent((sound) -> {
                                user.playSound(sound, 1.0F, 1.0F);
                            });
                            world.emitGameEvent(user, GameEvent.FLUID_PICKUP, blockPos);
                            ItemStack itemStack3 = ItemUsage.exchangeStack(itemStack, user, itemStack2);
                            if (!world.isClient) {
                                Criteria.FILLED_BUCKET.trigger((ServerPlayerEntity)user, itemStack2);
                            }

                            return ActionResult.SUCCESS.withNewHandStack(itemStack3);
                        }
                    }

                    return ActionResult.FAIL;
                } else {
                    blockState = world.getBlockState(blockPos);
                    BlockPos blockPos3 = blockState.getBlock() instanceof FluidFillable && this.fluid == Fluids.WATER ? blockPos : blockPos2;
                    if (this.placeFluid(user, world, blockPos3, blockHitResult)) {
                        this.onEmptied(user, world, itemStack, blockPos3);
                        if (user instanceof ServerPlayerEntity) {
                            Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity)user, blockPos3, itemStack);
                        }

                        user.incrementStat(Stats.USED.getOrCreateStat(this));
                        itemStack2 = ItemUsage.exchangeStack(itemStack, user, pucks_Parity_Mod$getEmptiedStack(itemStack, user));
                        return ActionResult.SUCCESS.withNewHandStack(itemStack2);
                    } else {
                        return ActionResult.FAIL;
                    }
                }
            } else {
                return ActionResult.FAIL;
            }
        }
    }

    public static ItemStack pucks_Parity_Mod$getEmptiedStack(ItemStack stack, PlayerEntity player) {
        if (stack.getItem() instanceof CopperBucketItem bucket && bucket.fluid == Fluids.LAVA) {
            player.playSound(SoundEvents.ENTITY_GENERIC_BURN, 0.4F, 2.0F + player.getRandom().nextFloat() * 0.4F);
            return !player.isInCreativeMode() ? ItemStack.EMPTY : stack;
        }
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
