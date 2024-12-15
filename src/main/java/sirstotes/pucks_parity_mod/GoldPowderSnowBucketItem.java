package sirstotes.pucks_parity_mod;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidDrainable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import sirstotes.pucks_parity_mod.accessors.FluidDrainableMixinAccessor;

public class GoldPowderSnowBucketItem extends PowderSnowBucketItem implements PucksParityModBucket {
    private final Item emptiedItem;
    private final int fluidLevel;

    public GoldPowderSnowBucketItem(Item emptiesTo, int _level, Block block, SoundEvent placeSound, Settings settings) {
        super(block, placeSound, settings);
        emptiedItem = emptiesTo;
        fluidLevel = _level;
    }
    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult blockHitResult = raycast(world, user, RaycastContext.FluidHandling.NONE);
        if (blockHitResult.getType() == HitResult.Type.MISS) {
            return ActionResult.PASS;
        } else if (blockHitResult.getType() != HitResult.Type.BLOCK) {
            return ActionResult.PASS;
        }
        BlockPos blockPos = blockHitResult.getBlockPos();
        Direction direction = blockHitResult.getSide();
        BlockPos blockPos2 = blockPos.offset(direction);
        if (world.canPlayerModifyAt(user, blockPos) && user.canPlaceOn(blockPos2, direction, itemStack)) {
            BlockState blockState = world.getBlockState(blockPos);
            if (blockState.getBlock() instanceof FluidDrainable fluidDrainable && ((FluidDrainableMixinAccessor) fluidDrainable).pucks_Parity_Mod$isPowderSnow()) {
                ItemStack itemStack2 = ((FluidDrainableMixinAccessor) fluidDrainable).pucks_Parity_Mod$tryDrainFluid(this, world, blockPos, blockState);
                if (!itemStack2.isEmpty()) {
                    System.out.println(itemStack2.toString());
                    user.incrementStat(Stats.USED.getOrCreateStat(this));
                    fluidDrainable.getBucketFillSound().ifPresent(sound -> user.playSound(sound, 1.0F, 1.0F));
                    world.emitGameEvent(user, GameEvent.FLUID_PICKUP, blockPos);
                    ItemStack itemStack3 = ItemUsage.exchangeStack(itemStack, user, itemStack2);
                    if (!world.isClient) {
                        Criteria.FILLED_BUCKET.trigger((ServerPlayerEntity)user, itemStack2);
                    }
                    return ActionResult.SUCCESS.withNewHandStack(itemStack3);
                }
            }
        }
        return ActionResult.PASS;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().isClient) {
            return ActionResult.SUCCESS;
        }
        if (context.shouldCancelInteraction()) {
            ActionResult actionResult = this.place(new ItemPlacementContext(context));

            PlayerEntity playerEntity = context.getPlayer();
            if (actionResult.isAccepted() && playerEntity != null) {
                playerEntity.setStackInHand(context.getHand(), pucks_Parity_Mod$getEmptiedStack(context.getStack(), playerEntity));
            }
            return actionResult;
        }
        ActionResult actionResult = use(context.getWorld(), context.getPlayer(), context.getHand());
        if (actionResult == ActionResult.PASS) {
            ActionResult actionResult1 = this.place(new ItemPlacementContext(context));

            PlayerEntity playerEntity = context.getPlayer();
            if (actionResult1.isAccepted() && playerEntity != null) {
                playerEntity.setStackInHand(context.getHand(), pucks_Parity_Mod$getEmptiedStack(context.getStack(), playerEntity));
            }
            return actionResult1;
        }
        if (actionResult instanceof ActionResult.Success success) {
            context.getPlayer().setStackInHand(context.getHand(), success.itemContext().newHandStack());
        }
        return actionResult;
    }

    public ItemStack pucks_Parity_Mod$getEmptiedStack(ItemStack stack, PlayerEntity player) {
        return !player.isInCreativeMode() ? new ItemStack(emptiedItem) : stack;
    }

    @Override
    public Fluid pucks_Parity_Mod$getFluid() {
        return null;
    }

    @Override
    public Item pucks_Parity_Mod$getFilled(Fluid fluid) {
        return null;
    }

    @Override
    public Item pucks_Parity_Mod$getEmptied() {
        return emptiedItem;
    }

    @Override
    public Item pucks_Parity_Mod$getPowderedSnow() {
        if (fluidLevel == 1) {
            return PucksParityModItems.GOLD_POWDER_SNOW_BUCKET_2;
        } else {
            return PucksParityModItems.GOLD_POWDER_SNOW_BUCKET_3;
        }
    }

    @Override
    public Item pucks_Parity_Mod$getMilk() {
        return null;
    }
}
