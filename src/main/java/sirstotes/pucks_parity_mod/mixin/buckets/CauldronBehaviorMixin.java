package sirstotes.pucks_parity_mod.mixin.buckets;

import java.util.Map;
import java.util.function.Predicate;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
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
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import sirstotes.pucks_parity_mod.PucksParityModItems;

@Mixin(CauldronBehavior.class)
public abstract interface CauldronBehaviorMixin {
	@Unique
	private static ItemActionResult fillCauldronConsume(World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack, BlockState state, SoundEvent soundEvent) {
		if (!world.isClient) {
			Item item = stack.getItem();
			player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, ItemStack.EMPTY));
			player.incrementStat(Stats.FILL_CAULDRON);
			player.incrementStat(Stats.USED.getOrCreateStat(item));
			world.setBlockState(pos, state);
			world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, 1.0F, 1.0F);
			world.emitGameEvent(null, GameEvent.FLUID_PLACE, pos);
		}

		return ItemActionResult.success(world.isClient);
	}

    @Shadow
    static ItemActionResult emptyCauldron(
		BlockState state,
		World world,
		BlockPos pos,
		PlayerEntity player,
		Hand hand,
		ItemStack stack,
		ItemStack output,
		Predicate<BlockState> fullPredicate,
		SoundEvent soundEvent
	) {
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Inject(method="registerBucketBehavior", at=@At("TAIL"))
    private static void registerNewBucketBehaviors(Map<Item, CauldronBehavior> behavior, CallbackInfo ci) {
        behavior.put(PucksParityModItems.COPPER_LAVA_BUCKET, (state, world, pos, player, hand, stack) -> fillCauldronConsume(
				world, pos, player, hand, stack, Blocks.LAVA_CAULDRON.getDefaultState(), SoundEvents.ENTITY_GENERIC_BURN
		));
		behavior.put(PucksParityModItems.COPPER_WATER_BUCKET, CauldronBehavior.FILL_WITH_WATER);
		behavior.put(PucksParityModItems.COPPER_POWDER_SNOW_BUCKET, CauldronBehavior.FILL_WITH_POWDER_SNOW);
    }

    @Inject(method = "registerBehavior", at = @At("TAIL"))
    private static void registerBehaviorBuckets(CallbackInfo ci, @Local(ordinal = 1) Map<Item, CauldronBehavior> map2, @Local(ordinal = 2) Map<Item, CauldronBehavior> map3, @Local(ordinal = 3) Map<Item, CauldronBehavior> map4) {
        map2.put(
			PucksParityModItems.COPPER_BUCKET,
			(CauldronBehavior)(state, world, pos, player, hand, stack) -> emptyCauldron(
					state,
					world,
					pos,
					player,
					hand,
					stack,
					new ItemStack(PucksParityModItems.COPPER_WATER_BUCKET),
					statex -> (Integer)statex.get(LeveledCauldronBlock.LEVEL) == 3,
					SoundEvents.ITEM_BUCKET_FILL
				)
		);
        map3.put(
			PucksParityModItems.COPPER_BUCKET,
			(CauldronBehavior)(state, world, pos, player, hand, stack) -> emptyCauldron(
					state, world, pos, player, hand, stack, new ItemStack(PucksParityModItems.COPPER_LAVA_BUCKET), statex -> true, SoundEvents.ITEM_BUCKET_FILL_LAVA
				)
		);
        map4.put(
			PucksParityModItems.COPPER_BUCKET,
			(CauldronBehavior)(state, world, pos, player, hand, stack) -> emptyCauldron(
					state,
					world,
					pos,
					player,
					hand,
					stack,
					new ItemStack(PucksParityModItems.COPPER_POWDER_SNOW_BUCKET),
					statex -> (Integer)statex.get(LeveledCauldronBlock.LEVEL) == 3,
					SoundEvents.ITEM_BUCKET_FILL_POWDER_SNOW
				)
		);
    }
    @ModifyArg(method = "fillCauldron", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;<init>(Lnet/minecraft/item/ItemConvertible;)V"))
    private static ItemConvertible bucketItem(ItemConvertible original, @Local(argsOnly = true) ItemStack stack) {
        if(stack.isOf(PucksParityModItems.COPPER_LAVA_BUCKET) || stack.isOf(PucksParityModItems.COPPER_WATER_BUCKET) || stack.isOf(PucksParityModItems.COPPER_POWDER_SNOW_BUCKET)) {
            return PucksParityModItems.COPPER_BUCKET;
        }
        return original;
    }
}
