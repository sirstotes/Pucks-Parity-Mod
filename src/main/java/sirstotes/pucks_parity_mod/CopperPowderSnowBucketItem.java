package sirstotes.pucks_parity_mod;

import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.PowderSnowBucketItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;

public class CopperPowderSnowBucketItem extends PowderSnowBucketItem {

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
}
