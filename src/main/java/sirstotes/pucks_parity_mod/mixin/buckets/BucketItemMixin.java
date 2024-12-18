package sirstotes.pucks_parity_mod.mixin.buckets;

import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sirstotes.pucks_parity_mod.PucksParityModBucket;

@Mixin(BucketItem.class)
public abstract class BucketItemMixin implements PucksParityModBucket {
    @Unique
    public Fluid pucks_Parity_Mod$getFluid() {
        return fluid;
    }
//    @Unique
//    public ItemStack pucks_Parity_Mod$getEmptiedStack(ItemStack stack, PlayerEntity player) {
//        return !player.isInCreativeMode() ? new ItemStack(Items.BUCKET) : stack;
//    }
    @Unique
    public Item pucks_Parity_Mod$getFilled(Fluid fluid) {
        if(fluid == Fluids.WATER || fluid == Fluids.FLOWING_WATER) {
            return Items.WATER_BUCKET;
        } else if(fluid == Fluids.LAVA || fluid == Fluids.FLOWING_LAVA) {
            return Items.LAVA_BUCKET;
        }
        return Items.BUCKET;
    }
    @Unique
    public Item pucks_Parity_Mod$getPowderedSnow() {
        return Items.POWDER_SNOW_BUCKET;
    }
    @Unique
    public Item pucks_Parity_Mod$getMilk() {
        return Items.MILK_BUCKET;
    }
}
