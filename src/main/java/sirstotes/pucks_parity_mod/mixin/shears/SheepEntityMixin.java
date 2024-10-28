package sirstotes.pucks_parity_mod.mixin.shears;

import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;
import sirstotes.pucks_parity_mod.PucksParityModItems;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;

@Mixin(SheepEntity.class)
public abstract class SheepEntityMixin {
    @ModifyExpressionValue(
        method = "interactMob",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z")
    )
    public boolean includeNewShears(boolean original, PlayerEntity player, Hand hand) {
        return original || player.getStackInHand(hand).isIn(PucksParityModItems.SHEARS);
    }
}
// public abstract class SheepEntityMixin extends AnimalEntity implements Shearable {
// 	protected SheepEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
// 		super(entityType, world);
// 		//TODO Auto-generated constructor stub
// 	}

// 	//interactMob(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/util/Hand;)Lnew/minecraft/util/ActionResult;
// 	@Inject(at = @At("HEAD"), method = "interactMob", cancellable = true)
// 	private void interactMobMixin(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> info) {
// 		ItemStack itemStack = player.getStackInHand(hand);
// 		if (itemStack.isOf(ModItems.COPPER_SHEARS)) {
// 			if (!this.getWorld().isClient && this.isShearable()) {
// 				this.sheared(SoundCategory.PLAYERS);
// 				this.emitGameEvent(GameEvent.SHEAR, player);
// 				itemStack.damage(1, player, this.getSlotForHand(hand));
// 				info.setReturnValue(ActionResult.SUCCESS);
// 			}
// 		}
// 	}

// 	@Shadow
// 	public abstract void sheared(SoundCategory shearedSoundCategory);

//     @Shadow
// 	public abstract boolean isShearable();

//     @Shadow
// 	public abstract boolean isBreedingItem(ItemStack stack);

//     @Shadow
// 	public abstract PassiveEntity createChild(ServerWorld world, PassiveEntity entity);
// }