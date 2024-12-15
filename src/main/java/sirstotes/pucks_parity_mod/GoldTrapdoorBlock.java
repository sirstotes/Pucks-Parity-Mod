package sirstotes.pucks_parity_mod;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.BlockState;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.block.WireOrientation;
import org.jetbrains.annotations.Nullable;

public class GoldTrapdoorBlock extends TrapdoorBlock {
    private final BlockSetType blockSetType;

    public GoldTrapdoorBlock(BlockSetType type, Settings settings) {
        super(type, settings);
        blockSetType = type;
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!blockSetType.canOpenByHand() && world.isReceivingRedstonePower(pos)) {
            return ActionResult.PASS;
        } else {
            flip(state, world, pos, player);
            return ActionResult.SUCCESS;
        }
    }

    private void flip(BlockState state, World world, BlockPos pos, @Nullable PlayerEntity player) {
        BlockState blockState = state.cycle(OPEN);
        world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
        if ((Boolean)blockState.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        this.playToggleSound(player, world, pos, (Boolean)blockState.get(OPEN));
    }
    //Causes gold trapdoors to not switch when receiving redstone power.
    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {

    }
}
