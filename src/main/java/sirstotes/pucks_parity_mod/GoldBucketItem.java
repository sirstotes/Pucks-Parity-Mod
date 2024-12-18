package sirstotes.pucks_parity_mod;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidDrainable;
import net.minecraft.block.FluidFillable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import sirstotes.pucks_parity_mod.accessors.FluidDrainableMixinAccessor;

public class GoldBucketItem extends BucketItem implements PucksParityModBucket {
    private final Item emptiedItem;
    private final int fluidLevel;
    private final Fluid fluid;

    public GoldBucketItem(Fluid _fluid, Item emptiesTo, int _level, Settings settings) {
        super(_fluid, settings);
        fluid = _fluid;
        emptiedItem = emptiesTo;
        fluidLevel = _level;
    }
    @Override
    //? if >1.21.1 {
    /*public ActionResult use(World world, PlayerEntity user, Hand hand) {
     *///?} else {
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        //?}
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult blockHitResult = raycast(
                world, user, !pucks_Parity_Mod$isFull() ? net.minecraft.world.RaycastContext.FluidHandling.SOURCE_ONLY : RaycastContext.FluidHandling.NONE
        );
        if (blockHitResult.getType() == HitResult.Type.MISS) {
            //? if >1.21.1 {
            /*return ActionResult.PASS;
             *///? else
            return TypedActionResult.pass(itemStack);
        } else if (blockHitResult.getType() != HitResult.Type.BLOCK) {
            //? if >1.21.1 {
            /*return ActionResult.PASS;
             *///? else
            return TypedActionResult.pass(itemStack);
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
                    if (var14 instanceof FluidDrainable fluidDrainable && (fluidLevel == 0 || ((FluidDrainableMixinAccessor) fluidDrainable).pucks_Parity_Mod$fluidEquals(this.fluid, blockState))) {
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

                            //? if >1.21.1 {
                            /*return ActionResult.SUCCESS.withNewHandStack(itemStack3);
                             *///?} else
                            return TypedActionResult.success(itemStack3);
                        }
                    }

                    //? if >1.21.1 {
                    /*return ActionResult.FAIL;
                     *///? else {
                    return TypedActionResult.fail(itemStack);
                    //?}
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
                        //? if >1.21.1 {
                        /*return ActionResult.SUCCESS.withNewHandStack(itemStack2);
                         *///?} else {
                        return TypedActionResult.success(itemStack2);
                        //?}
                    } else {
                        //? if >1.21.1 {
                        /*return ActionResult.FAIL;
                         *///? else {
                        return TypedActionResult.fail(itemStack);
                        //?}
                    }
                }
            } else {
                //? if >1.21.1 {
                /*return ActionResult.FAIL;
                 *///? else {
                return TypedActionResult.fail(itemStack);
                //?}
            }
        }
    }

    public ItemStack pucks_Parity_Mod$getEmptiedStack(ItemStack stack, PlayerEntity player) {
        return !/*? if <1.21.1 {*/player.getAbilities().creativeMode/*?} else {*//*player.isInCreativeMode()*//*?}*/ ? new ItemStack(emptiedItem) : stack;
    }

    @Override
    public Fluid pucks_Parity_Mod$getFluid() {
        return fluid;
    }

    public Item pucks_Parity_Mod$getFilled(Fluid _fluid) {
        if (fluid == _fluid || fluid == Fluids.EMPTY) {
            if(_fluid == Fluids.WATER || _fluid == Fluids.FLOWING_WATER) {
                if (fluidLevel == 0) {
                    return PucksParityModItems.GOLD_WATER_BUCKET_1;
                } else if (fluidLevel == 1) {
                    return PucksParityModItems.GOLD_WATER_BUCKET_2;
                } else if (fluidLevel > 1) {
                    return PucksParityModItems.GOLD_WATER_BUCKET_3;
                }
            } else if(_fluid == Fluids.LAVA || _fluid == Fluids.FLOWING_LAVA) {
                if (fluidLevel == 0) {
                    return PucksParityModItems.GOLD_LAVA_BUCKET_1;
                } else if (fluidLevel == 1) {
                    return PucksParityModItems.GOLD_LAVA_BUCKET_2;
                } else if (fluidLevel > 1) {
                    return PucksParityModItems.GOLD_LAVA_BUCKET_3;
                }
            }
        }
        return PucksParityModItems.GOLD_BUCKET;
    }

    @Override
    public Item pucks_Parity_Mod$getEmptied() {
        return emptiedItem;
    }

    public Item pucks_Parity_Mod$getPowderedSnow() {
        return PucksParityModItems.GOLD_POWDER_SNOW_BUCKET_1;
    }

    public Item pucks_Parity_Mod$getMilk() {
        return PucksParityModItems.GOLD_MILK_BUCKET_1;
    }

    public boolean pucks_Parity_Mod$isFull() {
        return fluidLevel >= 3;
    }
}
