package sirstotes.pucks_parity_mod.mixin.brush;

import net.minecraft.item.BrushItem;
import org.spongepowered.asm.mixin.Mixin;
import sirstotes.pucks_parity_mod.accessors.BrushItemMixinAccessor;

@Mixin(BrushItem.class)
public class BrushItemMixin implements BrushItemMixinAccessor {
}
