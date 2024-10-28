package sirstotes.pucks_parity_mod.mixin.shears;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.TagKey;
import sirstotes.pucks_parity_mod.PucksParityModItems;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @ModifyReturnValue(method = "isOf", at = @At("RETURN"))//TODO: This is a bad way of doing this. Ideally I should implement the shears tag everywhere.
    public boolean isOfShears(boolean original, Item item) {
        if (item == Items.SHEARS) {
            return original || new ItemStack(item).isIn(PucksParityModItems.SHEARS);
        }
        return original;
    }
    @Shadow
    public abstract boolean isIn(TagKey<Item> tag);
    @Shadow
	public abstract Item getItem();
}
