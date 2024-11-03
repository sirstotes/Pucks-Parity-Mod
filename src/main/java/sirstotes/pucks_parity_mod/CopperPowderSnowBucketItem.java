package sirstotes.pucks_parity_mod;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PowderSnowBucketItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;

public class CopperPowderSnowBucketItem extends PowderSnowBucketItem implements PucksParityModBucket {

    public CopperPowderSnowBucketItem(Block block, SoundEvent placeSound, Settings settings) {
        super(block, placeSound, settings);
        //TODO Auto-generated constructor stub
    }
    
	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		ActionResult actionResult = super.useOnBlock(context);
		PlayerEntity playerEntity = context.getPlayer();
		if (actionResult.isAccepted() && playerEntity != null) {
			playerEntity.setStackInHand(context.getHand(), CopperBucketItem.getEmptiedStack(context.getStack(), playerEntity));
		}

		return actionResult;
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
		return PucksParityModItems.COPPER_BUCKET;
	}

	@Override
	public Item pucks_Parity_Mod$getPowderedSnow() {
		return null;
	}

	@Override
	public Item pucks_Parity_Mod$getMilk() {
		return null;
	}
}
