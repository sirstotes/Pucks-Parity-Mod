package sirstotes.pucks_parity_mod;

import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
//? if >1.20.1
import net.minecraft.world.block.WireOrientation;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class GoldDoorBlock extends DoorBlock {
    //? if >1.20.1 {
    private final BlockSetType blockSetType;
    public GoldDoorBlock(BlockSetType type, Settings settings) {super(type, settings);blockSetType = type;}
    //?} elif >1.19.2 {
    /*private final BlockSetType blockSetType;
    public GoldDoorBlock(BlockSetType type, Settings settings) {super(settings, type);blockSetType = type;}
    *///?} else {
    /*public GoldDoorBlock(Settings settings) {super(settings);}
    *///?}

    @Override
    //? if <1.21.1 {
    /*public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
    *///?} else {
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
    //?}
        if ((world.isReceivingRedstonePower(pos) || (state.get(HALF) == DoubleBlockHalf.LOWER && world.isReceivingRedstonePower(pos.up())) || (state.get(HALF) == DoubleBlockHalf.UPPER && world.isReceivingRedstonePower(pos.down())))) {
            return ActionResult.FAIL;
        } else {
            state = state.cycle(OPEN);
            world.setBlockState(pos, state, Block.NOTIFY_LISTENERS | Block.REDRAW_ON_MAIN_THREAD);
            this.playOpenCloseSound(player, world, pos, (Boolean)state.get(OPEN));
            world.emitGameEvent(player, this.isOpen(state) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            //? if <1.21.2 {
            /*return ActionResult.success(world.isClient);
            *///?} else
            return ActionResult.SUCCESS;
        }
    }

    //? if >1.19.2 {
    private void playOpenCloseSound(@Nullable Entity entity, World world, BlockPos pos, boolean open) {
        world.playSound(entity, pos, open ? this.blockSetType.doorOpen() : this.blockSetType.doorClose(), SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
    }
    //?} else {
    /*private void playOpenCloseSound(@Nullable Entity entity, World world, BlockPos pos, boolean open) {
        world.syncWorldEvent(null, open ? 1005 : 1011, pos, 0);
    }
    *///?}

    //Causes gold doors to not switch when receiving redstone power.
    //? if <1.21.1 {
    /*@Override public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {}
    *///?} else if <1.21.2 {
    /*@Override protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {}
    *///?} else {
    @Override protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {}
    //?}
}
