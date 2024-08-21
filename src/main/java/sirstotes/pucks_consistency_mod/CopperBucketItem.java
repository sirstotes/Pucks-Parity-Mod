package sirstotes.pucks_consistency_mod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CopperBucketItem extends BucketItem {

    public CopperBucketItem(Fluid fluid, Settings settings) {
        super(fluid, settings);
        //TODO Auto-generated constructor stub
    }
    @Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        TypedActionResult<ItemStack> t = super.use(world, user, hand);
        if (t.getValue().isOf(Items.WATER_BUCKET)) {
            return TypedActionResult.success(ItemUsage.exchangeStack(user.getStackInHand(hand), user, new ItemStack(ModItems.COPPER_WATER_BUCKET)), world.isClient());
        }
        return TypedActionResult.fail(user.getStackInHand(hand));
    }
    
	public static ItemStack getEmptiedStack(ItemStack stack, PlayerEntity player) {
		return !player.isInCreativeMode() ? new ItemStack(ModItems.COPPER_BUCKET) : stack;
	}
}
