package sirstotes.pucks_parity_mod;

import com.google.common.collect.Lists;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarvedPumpkinBlock;
import net.minecraft.particle.DustParticleEffect;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
//?if >1.21.3 {
import net.minecraft.world.block.WireOrientation;
import org.jetbrains.annotations.Nullable;
//?}

import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class RedstoneCarvedPumpkinBlock extends CarvedPumpkinBlock {
    public static final BooleanProperty LIT = Properties.LIT;
    protected final ParticleEffect particle;
    private static final Map<BlockView, List<RedstoneCarvedPumpkinBlock.BurnoutEntry>> BURNOUT_MAP;

    public RedstoneCarvedPumpkinBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(LIT, true));
        this.particle = DustParticleEffect.DEFAULT;
    }

    @Override
    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ boolean emitsRedstonePower(BlockState state) {
        return true;
    }

    @Override
    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ int getWeakRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return state.get(LIT)? 15 : 0;
    }

    @Override
    public int getStrongRedstonePower(BlockState state, BlockView world, BlockPos pos, Direction direction) {
        return 0;
    }

    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        Direction[] var6 = Direction.values();

        for (Direction direction : var6) {
            world.updateNeighborsAlways(pos.offset(direction), this);
        }

    }

    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (!moved) {
            Direction[] var6 = Direction.values();

            for (Direction direction : var6) {
                world.updateNeighborsAlways(pos.offset(direction), this);
            }

        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT, FACING);
    }

    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (state.get(LIT)) {
            double d = (double)pos.getX() + 0.5 + state.get(FACING).getVector().getX() + (random.nextDouble() - 0.5) * 0.8;
            double e = (double)pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.8;
            double f = (double)pos.getX() + 0.5 + state.get(FACING).getVector().getZ() + (random.nextDouble() - 0.5) * 0.8;
            world.addParticle(this.particle, d, e, f, 0.0, 0.0, 0.0);
        }
    }

    protected boolean shouldUnpower(World world, BlockPos pos, BlockState state) {
        return world.isEmittingRedstonePower(pos.down(), Direction.DOWN);
    }

    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        boolean bl = this.shouldUnpower(world, pos, state);
        List<RedstoneCarvedPumpkinBlock.BurnoutEntry> list = BURNOUT_MAP.get(world);

        while(list != null && !list.isEmpty() && world.getTime() - list.getFirst().time > 60L) {
            list.removeFirst();
        }

        if (state.get(LIT)) {
            if (bl) {
                world.setBlockState(pos, state.with(LIT, false), 3);
                if (isBurnedOut(world, pos, true)) {
                    world.syncWorldEvent(1502, pos, 0);
                    /*? if >1.19.2 {*/world.scheduleBlockTick/*?} else {*//*world.createAndScheduleBlockTick*//*?}*/(pos, world.getBlockState(pos).getBlock(), 160);
                }
            }
        } else if (!bl && !isBurnedOut(world, pos, false)) {
            world.setBlockState(pos, state.with(LIT, true), 3);
        }
    }

    //? if <1.21.2 {
    /*public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
    *///?} else {
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
    //?}
        if (state.get(LIT) == this.shouldUnpower(world, pos, state) && !world.getBlockTickScheduler().isTicking(pos, this)) {
            /*? if >1.19.2 {*/world.scheduleBlockTick/*?} else {*//*world.createAndScheduleBlockTick*//*?}*/(pos, this, 2);
        }
    }



    private static boolean isBurnedOut(World world, BlockPos pos, boolean addNew) {
        List<RedstoneCarvedPumpkinBlock.BurnoutEntry> list = BURNOUT_MAP.computeIfAbsent(world, (worldx) -> Lists.newArrayList());
        if (addNew) {
            list.add(new RedstoneCarvedPumpkinBlock.BurnoutEntry(pos.toImmutable(), world.getTime()));
        }

        int i = 0;

        for (BurnoutEntry burnoutEntry : list) {
            if (burnoutEntry.pos.equals(pos)) {
                ++i;
                if (i >= 8) {
                    return true;
                }
            }
        }

        return false;
    }

    static {
        BURNOUT_MAP = new WeakHashMap<>();
    }

    public static class BurnoutEntry {
        final BlockPos pos;
        final long time;

        public BurnoutEntry(BlockPos pos, long time) {
            this.pos = pos;
            this.time = time;
        }
    }
}
