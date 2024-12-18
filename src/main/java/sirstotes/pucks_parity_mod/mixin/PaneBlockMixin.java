package sirstotes.pucks_parity_mod.mixin;
//?if >1.20.1 {
/*import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sirstotes.pucks_parity_mod.SlidingPaneDoorBlock;

@Mixin(PaneBlock.class)
public class PaneBlockMixin {
    @ModifyReturnValue(method = "connectsTo", at = @At("RETURN"))
    public boolean includePaneDoors (boolean original, BlockState state, boolean sideSolidFullSquare) {//TODO: Only connect to side of the door.
        return original || state.getBlock() instanceof SlidingPaneDoorBlock;
    }
}//TODO: backport
*///?}