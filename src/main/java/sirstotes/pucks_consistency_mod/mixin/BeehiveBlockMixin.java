package sirstotes.pucks_consistency_mod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import sirstotes.pucks_consistency_mod.ModItems;

@Mixin(BeehiveBlock.class)
public abstract class BeehiveBlockMixin {// extends BlockWithEntity {
    // @Shadow
    // public static final IntProperty HONEY_LEVEL = null;

    // protected BeehiveBlockMixin(Settings settings) {
    //     super(settings);
    // }
    
    // @Inject(at = @At("HEAD"), method = "onUseWithItem", cancellable = true)
	// private void onUseWithItemMixin(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit, CallbackInfoReturnable<ActionResult> info) {
	// 	int i = (Integer)state.get(HONEY_LEVEL);
	// 	boolean bl = false;
	// 	if (i >= 5) {
	// 		Item item = stack.getItem();
	// 		if (stack.isOf(ModItems.COPPER_SHEARS)) {
	// 			world.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.BLOCK_BEEHIVE_SHEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);
	// 			((BeehiveBlockInvoker) this).dropHoneycombInvoker(world, pos);
	// 			stack.damage(1, player, LivingEntity.getSlotForHand(hand));
	// 			bl = true;
	// 			world.emitGameEvent(player, GameEvent.SHEAR, pos);
	// 		}
	// 	}
	// }

    @ModifyExpressionValue(
        method = "onUseWithItem",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z")
    )
    public boolean includeNewShears(boolean original, ItemStack stack) {
        return original || stack.isOf(ModItems.COPPER_SHEARS);
    }
}
