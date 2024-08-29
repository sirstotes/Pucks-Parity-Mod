package sirstotes.pucks_parity_mod;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;

public class CopperMilkBucketItem extends MilkBucketItem {

    public CopperMilkBucketItem(Settings settings) {
        super(settings);
        //TODO Auto-generated constructor stub
    }
    
    
	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		if (user instanceof ServerPlayerEntity serverPlayerEntity) {
			Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
			serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
		}

		if (!world.isClient) {
			user.clearStatusEffects();
		}

		if (user instanceof PlayerEntity playerEntity) {
			return ItemUsage.exchangeStack(stack, playerEntity, new ItemStack(PucksParityModItems.COPPER_BUCKET), false);
		} else {
			stack.decrementUnlessCreative(1, user);
			return stack;
		}
	}
}
