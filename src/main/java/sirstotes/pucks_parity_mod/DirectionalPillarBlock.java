package sirstotes.pucks_parity_mod;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.BlockRotation;

public class DirectionalPillarBlock extends FacingBlock {
    //? if >1.21.1
    public static final MapCodec<DirectionalPillarBlock> CODEC = createCodec(DirectionalPillarBlock::new);
    protected DirectionalPillarBlock(Settings settings) {
        super(settings);
    }

    //? if >1.21.1 {
    @Override
    protected MapCodec<? extends FacingBlock> getCodec() {
        return CODEC;
    }
    //?}

    @Override
    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getSide().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
