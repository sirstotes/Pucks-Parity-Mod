package sirstotes.pucks_parity_mod.mixin.buckets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Waterloggable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BucketItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sirstotes.pucks_parity_mod.accessors.BucketItemMixinAccessor;
import sirstotes.pucks_parity_mod.accessors.FluidMixinAccessor;

@Mixin(Waterloggable.class)
public interface WaterloggableMixin {
    default ItemStack pucks_Parity_Mod$tryDrainFluid(Item item, WorldAccess world, BlockPos pos, BlockState state) {
        if ((Boolean)state.get(Properties.WATERLOGGED)) {
            world.setBlockState(pos, state.with(Properties.WATERLOGGED, Boolean.valueOf(false)), Block.NOTIFY_ALL);
            if (!state.canPlaceAt(world, pos)) {
                world.breakBlock(pos, true);
            }

            if (item instanceof BucketItem) {
                return new ItemStack(((BucketItemMixinAccessor) item).pucks_Parity_Mod$getFilled(Fluids.WATER));
            }
            return new ItemStack(Items.WATER_BUCKET);
        } else {
            return ItemStack.EMPTY;
        }
    }
}
