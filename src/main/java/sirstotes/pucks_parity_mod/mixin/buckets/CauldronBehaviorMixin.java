package sirstotes.pucks_parity_mod.mixin.buckets;

import java.util.Map;
import java.util.function.Predicate;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import org.spongepowered.asm.mixin.injection.At;

import net.minecraft.block.BlockState;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sirstotes.pucks_parity_mod.PucksParityModBucket;
import sirstotes.pucks_parity_mod.PucksParityModItems;

@Mixin(CauldronBehavior.class)
public abstract interface CauldronBehaviorMixin {
	@Shadow
	private static ActionResult fillCauldron(World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack, BlockState state, SoundEvent soundEvent) {
		if (!world.isClient) {
			Item item = stack.getItem();
			player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.BUCKET)));
			player.incrementStat(Stats.FILL_CAULDRON);
			player.incrementStat(Stats.USED.getOrCreateStat(item));
			world.setBlockState(pos, state);
			world.playSound((PlayerEntity)null, pos, soundEvent, SoundCategory.BLOCKS, 1.0F, 1.0F);
			world.emitGameEvent((Entity)null, GameEvent.FLUID_PLACE, pos);
		}

		return ActionResult.SUCCESS;
	}

    @Inject(method="registerBucketBehavior", at=@At("TAIL"))
    private static void registerNewBucketBehaviors(Map<Item, CauldronBehavior> behavior, CallbackInfo ci) {
        behavior.put(PucksParityModItems.COPPER_LAVA_BUCKET, (state, world, pos, player, hand, stack) -> fillCauldron(
				world, pos, player, hand, stack, Blocks.LAVA_CAULDRON.getDefaultState(), SoundEvents.ENTITY_GENERIC_BURN
		));
		behavior.put(PucksParityModItems.COPPER_WATER_BUCKET, CauldronBehaviorMixin::tryFillWithWater);
		behavior.put(PucksParityModItems.COPPER_POWDER_SNOW_BUCKET, CauldronBehaviorMixin::tryFillWithPowderSnow);
		behavior.put(PucksParityModItems.GOLD_WATER_BUCKET_1, CauldronBehaviorMixin::tryFillWithWater);
		behavior.put(PucksParityModItems.GOLD_WATER_BUCKET_2, CauldronBehaviorMixin::tryFillWithWater);
		behavior.put(PucksParityModItems.GOLD_WATER_BUCKET_3, CauldronBehaviorMixin::tryFillWithWater);
		behavior.put(PucksParityModItems.GOLD_LAVA_BUCKET_1, CauldronBehaviorMixin::tryFillWithLava);
		behavior.put(PucksParityModItems.GOLD_LAVA_BUCKET_2, CauldronBehaviorMixin::tryFillWithLava);
		behavior.put(PucksParityModItems.GOLD_LAVA_BUCKET_3, CauldronBehaviorMixin::tryFillWithLava);
		behavior.put(PucksParityModItems.GOLD_POWDER_SNOW_BUCKET_1, CauldronBehaviorMixin::tryFillWithPowderSnow);
		behavior.put(PucksParityModItems.GOLD_POWDER_SNOW_BUCKET_2, CauldronBehaviorMixin::tryFillWithPowderSnow);
		behavior.put(PucksParityModItems.GOLD_POWDER_SNOW_BUCKET_3, CauldronBehaviorMixin::tryFillWithPowderSnow);
    }

    @Inject(method = "registerBehavior", at = @At("TAIL"))
    private static void registerBehaviorBuckets(CallbackInfo ci, @Local(ordinal = 1) Map<Item, CauldronBehavior> map2, @Local(ordinal = 2) Map<Item, CauldronBehavior> map3, @Local(ordinal = 3) Map<Item, CauldronBehavior> map4) {
        map2.put(
			PucksParityModItems.COPPER_BUCKET,
			(CauldronBehavior)(state, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(PucksParityModItems.COPPER_WATER_BUCKET), statex -> (Integer)statex.get(LeveledCauldronBlock.LEVEL) == 3, SoundEvents.ITEM_BUCKET_FILL)
		);
		map2.put(
				PucksParityModItems.GOLD_BUCKET,
				(CauldronBehavior)(state, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(PucksParityModItems.GOLD_WATER_BUCKET_1), statex -> (Integer)statex.get(LeveledCauldronBlock.LEVEL) == 3, SoundEvents.ITEM_BUCKET_FILL)
		);
		map2.put(
				PucksParityModItems.GOLD_WATER_BUCKET_1,
				(CauldronBehavior)(state, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(PucksParityModItems.GOLD_WATER_BUCKET_2), statex -> (Integer)statex.get(LeveledCauldronBlock.LEVEL) == 3, SoundEvents.ITEM_BUCKET_FILL)
		);
		map2.put(
				PucksParityModItems.GOLD_WATER_BUCKET_2,
				(CauldronBehavior)(state, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(PucksParityModItems.GOLD_WATER_BUCKET_3), statex -> (Integer)statex.get(LeveledCauldronBlock.LEVEL) == 3, SoundEvents.ITEM_BUCKET_FILL)
		);
        map3.put(
				PucksParityModItems.COPPER_BUCKET,
				(CauldronBehavior)(state, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(PucksParityModItems.COPPER_LAVA_BUCKET), statex -> true, SoundEvents.ITEM_BUCKET_FILL_LAVA)
		);
		map3.put(
				PucksParityModItems.GOLD_BUCKET,
				(CauldronBehavior)(state, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(PucksParityModItems.GOLD_LAVA_BUCKET_1), statex -> true, SoundEvents.ITEM_BUCKET_FILL_LAVA)
		);
		map3.put(
				PucksParityModItems.GOLD_LAVA_BUCKET_1,
				(CauldronBehavior)(state, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(PucksParityModItems.GOLD_LAVA_BUCKET_2), statex -> true, SoundEvents.ITEM_BUCKET_FILL_LAVA)
		);
		map3.put(
				PucksParityModItems.GOLD_LAVA_BUCKET_2,
				(CauldronBehavior)(state, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(PucksParityModItems.GOLD_LAVA_BUCKET_3), statex -> true, SoundEvents.ITEM_BUCKET_FILL_LAVA)
		);
        map4.put(
			PucksParityModItems.COPPER_BUCKET,
			(CauldronBehavior)(state, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(PucksParityModItems.COPPER_POWDER_SNOW_BUCKET), statex -> (Integer)statex.get(LeveledCauldronBlock.LEVEL) == 3, SoundEvents.ITEM_BUCKET_FILL_POWDER_SNOW)
		);
		map4.put(
				PucksParityModItems.GOLD_BUCKET,
				(CauldronBehavior)(state, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(PucksParityModItems.GOLD_POWDER_SNOW_BUCKET_1), statex -> (Integer)statex.get(LeveledCauldronBlock.LEVEL) == 3, SoundEvents.ITEM_BUCKET_FILL_POWDER_SNOW)
		);
		map4.put(
				PucksParityModItems.GOLD_POWDER_SNOW_BUCKET_1,
				(CauldronBehavior)(state, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(PucksParityModItems.GOLD_POWDER_SNOW_BUCKET_2), statex -> (Integer)statex.get(LeveledCauldronBlock.LEVEL) == 3, SoundEvents.ITEM_BUCKET_FILL_POWDER_SNOW)
		);
		map4.put(
				PucksParityModItems.GOLD_POWDER_SNOW_BUCKET_2,
				(CauldronBehavior)(state, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(PucksParityModItems.GOLD_POWDER_SNOW_BUCKET_3), statex -> (Integer)statex.get(LeveledCauldronBlock.LEVEL) == 3, SoundEvents.ITEM_BUCKET_FILL_POWDER_SNOW)
		);
    }
    @ModifyArg(method = "fillCauldron", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;<init>(Lnet/minecraft/item/ItemConvertible;)V"))
    private static ItemConvertible bucketItem(ItemConvertible original, @Local(argsOnly = true) ItemStack stack) {
        if(stack.getItem() instanceof PucksParityModBucket item) {
            return item.pucks_Parity_Mod$getEmptied();
        }
        return original;
    }

	@Shadow
	private static ActionResult tryFillWithWater(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack) {
		return null;
	}

	@Shadow
	private static ActionResult tryFillWithLava(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack) {
		return null;
	}

	@Shadow
	private static ActionResult tryFillWithPowderSnow(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack) {
		return null;
	}
}
