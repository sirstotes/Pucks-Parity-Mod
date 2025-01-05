package sirstotes.pucks_parity_mod;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DirectionalBulbBlock extends FacingBlock {
    //?if >1.21.1
    /*public static final MapCodec<DirectionalBulbBlock> CODEC = createCodec(DirectionalBulbBlock::new);*/
    public static final BooleanProperty POWERED = Properties.POWERED;
    public static final BooleanProperty LIT = Properties.LIT;

    //?if >1.21.1 {
    /*@Override
    protected MapCodec<? extends DirectionalBulbBlock> getCodec() {
        return CODEC;
    }
    *///?}

    public DirectionalBulbBlock(AbstractBlock.Settings settings) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(LIT, Boolean.valueOf(false)).with(POWERED, Boolean.valueOf(false)));
    }

    @Override
    /*?if <1.21.2 {*/public/*?} else {*//*protected*//*?}*/ void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (oldState.getBlock() != state.getBlock() && world instanceof ServerWorld serverWorld) {
            this.update(state, serverWorld, pos);
        }
    }

    public void update(BlockState state, ServerWorld world, BlockPos pos) {
        boolean bl = world.isReceivingRedstonePower(pos);
        if (bl != (Boolean)state.get(POWERED)) {
            BlockState blockState = state;
            if (!(Boolean)state.get(POWERED)) {
                blockState = state.cycle(LIT);
                //? if >1.20.1
                /*world.playSound(null, pos, blockState.get(LIT) ? SoundEvents.BLOCK_COPPER_BULB_TURN_ON : SoundEvents.BLOCK_COPPER_BULB_TURN_OFF, SoundCategory.BLOCKS);*/
            }

            world.setBlockState(pos, blockState.with(POWERED, Boolean.valueOf(bl)), Block.NOTIFY_ALL);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT, POWERED, FACING);
    }

    @Override
    /*?if <1.21.2 {*/public/*?} else {*//*protected*//*?}*/ boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    /*?if <1.21.2 {*/public/*?} else {*//*protected*//*?}*/ int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return world.getBlockState(pos).get(LIT) ? 15 : 0;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }
}
