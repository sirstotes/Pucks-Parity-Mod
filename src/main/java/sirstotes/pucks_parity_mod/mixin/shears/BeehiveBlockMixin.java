package sirstotes.pucks_parity_mod.mixin.shears;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

import net.minecraft.block.BeehiveBlock;
import net.minecraft.item.ItemStack;
import sirstotes.pucks_parity_mod.PucksParityModItems;

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
        return original || stack.isIn(PucksParityModItems.SHEARS);
    }
}
