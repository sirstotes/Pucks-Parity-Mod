package sirstotes.pucks_parity_mod;

import net.minecraft.block.BlockState;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;

public class RedstoneCarvedPumpkinBlock extends CarvedPumpkinBlock {

    public RedstoneCarvedPumpkinBlock(Settings settings) {
        super(settings);
    }

    @Override
    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @Override
    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return 15;
    }
}
