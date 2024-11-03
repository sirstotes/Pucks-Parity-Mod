package sirstotes.pucks_parity_mod.mixin.buckets;

import net.minecraft.block.*;
import org.spongepowered.asm.mixin.Mixin;
import sirstotes.pucks_parity_mod.accessors.WaterloggableMixinAccessor;

@Mixin(Waterloggable.class)
public interface WaterloggableMixin extends WaterloggableMixinAccessor {
    //Literally just mixing in the Accessor. Its methods are all defaulted.
}
