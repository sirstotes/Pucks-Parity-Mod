package sirstotes.pucks_parity_mod;

import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

public class CopperBucketItem extends BucketItem {

    public CopperBucketItem(Fluid fluid, Settings settings) {
        super(fluid, settings);
        //TODO Auto-generated constructor stub
    }
    @Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        boolean lavaBefore = user.getStackInHand(hand).isOf(PucksParityModItems.COPPER_LAVA_BUCKET);
        TypedActionResult<ItemStack> t = super.use(world, user, hand);
        //return TypedActionResult.success(itemStack2, world.isClient());
        if (t.getResult().isAccepted() && lavaBefore) {
            world.playSound(user, user.getBlockPos(), SoundEvents.ENTITY_GENERIC_BURN, SoundCategory.BLOCKS, 0.75F, 1.0F);
            return TypedActionResult.success(ItemStack.EMPTY, world.isClient());
        }
        return t;
    }

    public ItemStack pucks_Parity_Mod$getEmptiedStack(ItemStack stack, PlayerEntity player) {
        return !player.isInCreativeMode() ? new ItemStack(PucksParityModItems.COPPER_BUCKET) : stack;
    }
    public static ItemStack getEmptiedStack(ItemStack stack, PlayerEntity player) {
        return !player.isInCreativeMode() ? new ItemStack(PucksParityModItems.COPPER_BUCKET) : stack;
    }

    public Item pucks_Parity_Mod$getFilled(Fluid fluid) {
        if(fluid == Fluids.WATER || fluid == Fluids.FLOWING_WATER) {
            return PucksParityModItems.COPPER_WATER_BUCKET;
        } else if(fluid == Fluids.LAVA || fluid == Fluids.FLOWING_LAVA) {
            return PucksParityModItems.COPPER_LAVA_BUCKET;
        }
        return PucksParityModItems.COPPER_BUCKET;
    }

    public Item pucks_Parity_Mod$getPowderedSnow() {
        return PucksParityModItems.COPPER_POWDER_SNOW_BUCKET;
    }

    public Item pucks_Parity_Mod$getMilk() {
        return PucksParityModItems.COPPER_MILK_BUCKET;
    }
}
