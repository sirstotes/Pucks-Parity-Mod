package sirstotes.pucks_parity_mod;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
//? if >1.20.1
import net.minecraft.world.block.WireOrientation;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class GoldTrapdoorBlock extends TrapdoorBlock {
    //? if >1.20.1 {
    private final BlockSetType blockSetType;
    public GoldTrapdoorBlock(BlockSetType type, Settings settings) {super(type, settings);blockSetType = type;}
    //?} elif >1.19.2 {
    /*private final BlockSetType blockSetType;
    public GoldTrapdoorBlock(BlockSetType type, Settings settings) {super(settings, type);blockSetType = type;}
    *///?} else {
    /*public GoldTrapdoorBlock(Settings settings) {super(settings);}
     *///?}

    @Override
    //? if <1.21.1 {
    /*public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        *///?} else {
        protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        //?}
        if (world.isReceivingRedstonePower(pos)) {
            return ActionResult.FAIL;
        } else {
            state = state.cycle(OPEN);
            //? if <1.21.2 {
            /*world.setBlockState(pos, state, 2);
            if (state.get(WATERLOGGED)) {
                //? if <1.20.1 {
                /^world.createAndScheduleFluidTick
                ^///?} else {
                world.scheduleFluidTick
                //?}
                (pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
            }

            this.playToggleSound(player, world, pos, state.get(OPEN));
            return ActionResult.success(world.isClient);
            *///?} else {
            world.setBlockState(pos, state, Block.NOTIFY_LISTENERS | Block.REDRAW_ON_MAIN_THREAD);
            this.playToggleSound(player, world, pos, state.get(OPEN));
            world.emitGameEvent(player, state.get(OPEN) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            return ActionResult.SUCCESS;
            //?}
        }
    }

    private void flip(BlockState state, World world, BlockPos pos, @Nullable PlayerEntity player) {
        BlockState blockState = state.cycle(OPEN);
        world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
        if (blockState.get(WATERLOGGED)) {
            //? if <1.20.1 {
            /*world.createAndScheduleFluidTick
            *///?} else {
            world.scheduleFluidTick
            //?}
            (pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        this.playToggleSound(player, world, pos, (Boolean)blockState.get(OPEN));
    }
    //Causes gold trapdoors to not switch when receiving redstone power.
    //? if <1.21.1 {
    /*@Override public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {}
    *///?} else if <1.21.2 {
    /*@Override protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {}
     *///?} else {
    @Override protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {}
    //?}
}
