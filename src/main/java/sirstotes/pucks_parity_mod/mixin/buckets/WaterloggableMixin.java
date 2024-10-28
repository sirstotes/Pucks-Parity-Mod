package sirstotes.pucks_parity_mod.mixin.buckets;

import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sirstotes.pucks_parity_mod.PucksParityModBucket;
import sirstotes.pucks_parity_mod.accessors.WaterloggableMixinAccessor;

@Mixin(Waterloggable.class)
public interface WaterloggableMixin extends WaterloggableMixinAccessor {
}
