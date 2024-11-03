package sirstotes.pucks_parity_mod;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;

public class GoldMilkBucketItem extends MilkBucketItem implements PucksParityModBucket {
    private final Item emptiedItem;
    private final int fluidLevel;

    public GoldMilkBucketItem(Item emptiesTo, int _level, Settings settings) {
        super(settings);
        emptiedItem = emptiesTo;
        fluidLevel = _level;
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
            return ItemUsage.exchangeStack(stack, playerEntity, new ItemStack(emptiedItem), false);
        } else {
            stack.decrementUnlessCreative(1, user);
            return stack;
        }
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
        return null;
    }

    @Override
    public Item pucks_Parity_Mod$getMilk() {
        if (fluidLevel == 1) {
            return PucksParityModItems.GOLD_MILK_BUCKET_2;
        } else {
            return PucksParityModItems.GOLD_MILK_BUCKET_3;
        }
    }
}
