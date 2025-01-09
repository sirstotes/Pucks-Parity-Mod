package sirstotes.pucks_parity_mod;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
//? if >1.20.1
import net.minecraft.world.block.WireOrientation;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.explosion.Explosion;
import org.jetbrains.annotations.Nullable;
import java.util.function.BiConsumer;

public class SlidingPaneDoorBlock extends Block {
    //? if >1.20.1 {
    public static final MapCodec<DoorBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(BlockSetType.CODEC.fieldOf("block_set_type").forGetter(DoorBlock::getBlockSetType), createSettingsCodec())
                    .apply(instance, DoorBlock::new)
    );
    @Override
    public MapCodec<? extends DoorBlock> getCodec() {
        return CODEC;
    }
    //?}
    public static final EnumProperty<Direction> FACING = HorizontalFacingBlock.FACING;
    public static final BooleanProperty OPEN = Properties.OPEN;
    public static final EnumProperty<DoorHinge> HINGE = Properties.DOOR_HINGE;
    public static final BooleanProperty POWERED = Properties.POWERED;
    protected static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0, 0, 7, 16, 16, 9);
    protected static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0, 0, 7, 16, 16, 9);
    protected static final VoxelShape EAST_SHAPE = Block.createCuboidShape(7, 0, 0, 9, 16, 16);
    protected static final VoxelShape WEST_SHAPE = Block.createCuboidShape(7, 0, 0, 9, 16, 16);
    //protected static final VoxelShape OPEN_SHAPE = Block.createCuboidShape(7, 0, 7, 9, 16, 9);
    private final BlockSetType blockSetType;


    public SlidingPaneDoorBlock(BlockSetType type, AbstractBlock.Settings settings) {
        super(settings.sounds(type.soundType()));
        this.blockSetType = type;
        this.setDefaultState(
                this.stateManager
                        .getDefaultState()
                        .with(FACING, Direction.NORTH)
                        .with(OPEN, false)
                        .with(HINGE, DoorHinge.LEFT)
                        .with(POWERED, false)
        );
    }

    public BlockSetType getBlockSetType() {
        return this.blockSetType;
    }

    @Override
    /*? if <1.21.2 {*/ /*public*//*?} else {*/protected/*?}*/ VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);

        return switch (direction) {
            case SOUTH ->
                    state.get(OPEN) ? SOUTH_SHAPE.offset(state.get(HINGE) == DoorHinge.LEFT ? 0.875 : -0.875, 0, -0.125) : SOUTH_SHAPE;
            case WEST ->
                    state.get(OPEN) ? WEST_SHAPE.offset(0.125, 0, state.get(HINGE) == DoorHinge.LEFT ? 0.875 : -0.875) : WEST_SHAPE;
            case NORTH ->
                    state.get(OPEN) ? NORTH_SHAPE.offset(state.get(HINGE) == DoorHinge.LEFT ? -0.875 : 0.875, 0, 0.125) : NORTH_SHAPE;
            default ->
                    state.get(OPEN) ? EAST_SHAPE.offset(-0.125, 0, state.get(HINGE) == DoorHinge.LEFT ? -0.875 : 0.875) : EAST_SHAPE;
        };
    }

    @Override
    //? if <1.21.1 {
    /*public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        switch (type) {
            case LAND -> {
                return (Boolean)state.get(OPEN);
            }
            case WATER -> {
                return false;
            }
            case AIR -> {
                return (Boolean)state.get(OPEN);
            }
            default -> {
                return false;
            }
        }
    }
    *///?} else {
    protected boolean canPathfindThrough(BlockState state, NavigationType type) {
        return switch (type) {
            case LAND, AIR -> state.get(OPEN);
            case WATER -> false;
        };
    }//?}

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        World world = ctx.getWorld();
        boolean bl = world.isReceivingRedstonePower(blockPos) || world.isReceivingRedstonePower(blockPos.up());
        return this.getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing())
                .with(HINGE, this.getHinge(ctx))
                .with(POWERED, bl)
                .with(OPEN, bl);
    }

    private DoorHinge getHinge(ItemPlacementContext ctx) {
        BlockView blockView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();
        Direction direction = ctx.getHorizontalPlayerFacing();
        BlockPos blockPos2 = blockPos.up();
        Direction direction2 = direction.rotateYCounterclockwise();
        BlockPos blockPos3 = blockPos.offset(direction2);
        BlockState blockState = blockView.getBlockState(blockPos3);
        BlockPos blockPos4 = blockPos2.offset(direction2);
        BlockState blockState2 = blockView.getBlockState(blockPos4);
        Direction direction3 = direction.rotateYClockwise();
        BlockPos blockPos5 = blockPos.offset(direction3);
        BlockState blockState3 = blockView.getBlockState(blockPos5);
        BlockPos blockPos6 = blockPos2.offset(direction3);
        BlockState blockState4 = blockView.getBlockState(blockPos6);
        int i = (blockState.isFullCube(blockView, blockPos3) ? -1 : 0)
                + (blockState2.isFullCube(blockView, blockPos4) ? -1 : 0)
                + (blockState3.isFullCube(blockView, blockPos5) ? 1 : 0)
                + (blockState4.isFullCube(blockView, blockPos6) ? 1 : 0);
        boolean bl = blockState.getBlock() instanceof DoorBlock;
        boolean bl2 = blockState3.getBlock() instanceof DoorBlock;
        if ((!bl || bl2) && i <= 0) {
            if ((!bl2 || bl) && i >= 0) {
                int j = direction.getOffsetX();
                int k = direction.getOffsetZ();
                Vec3d vec3d = ctx.getHitPos();
                double d = vec3d.x - (double) blockPos.getX();
                double e = vec3d.z - (double) blockPos.getZ();
                return (j >= 0 || !(e < 0.5)) && (j <= 0 || !(e > 0.5)) && (k >= 0 || !(d > 0.5)) && (k <= 0 || !(d < 0.5)) ? DoorHinge.LEFT : DoorHinge.RIGHT;
            } else {
                return DoorHinge.LEFT;
            }
        } else {
            return DoorHinge.RIGHT;
        }
    }

    @Override
    //? if <1.21.1 {
    /*public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        *///?} else {
        protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        //?}
        if (!this.blockSetType.canOpenByHand()) {
            return ActionResult.PASS;
        } else {
            state = state.cycle(OPEN);
            world.setBlockState(pos, state, Block.NOTIFY_LISTENERS | Block.REDRAW_ON_MAIN_THREAD);
            this.playOpenCloseSound(player, world, pos, state.get(OPEN));
            world.emitGameEvent(player, this.isOpen(state) ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            return ActionResult.SUCCESS;
        }
    }

    public boolean isOpen(BlockState state) {
        return state.get(OPEN);
    }

    public void setOpen(@Nullable Entity entity, World world, BlockState state, BlockPos pos, boolean open) {
        if (state.isOf(this) && state.get(OPEN) != open) {
            world.setBlockState(pos, state.with(OPEN, open), Block.NOTIFY_LISTENERS | Block.REDRAW_ON_MAIN_THREAD);
            this.playOpenCloseSound(entity, world, pos, open);
            world.emitGameEvent(entity, open ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
        }
    }


    //? if <1.21.1 {
    /*public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        boolean bl = world.isReceivingRedstonePower(pos) || world.isReceivingRedstonePower(pos);
        if (!this.getDefaultState().isOf(sourceBlock) && bl != state.get(POWERED)) {
            if (bl != state.get(OPEN)) {
                this.playOpenCloseSound(null, world, pos, bl);
                world.emitGameEvent(null, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            }

            world.setBlockState(pos, state.with(POWERED, bl).with(OPEN, bl), 2);
        }

    }
    *///?} else {
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, @Nullable WireOrientation wireOrientation, boolean notify) {
        boolean bl = world.isReceivingRedstonePower(pos);
        if (!this.getDefaultState().isOf(sourceBlock) && bl != state.get(POWERED)) {
            if (bl != state.get(OPEN)) {
                this.playOpenCloseSound(null, world, pos, bl);
                world.emitGameEvent(null, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            }

            world.setBlockState(pos, state.with(POWERED, bl).with(OPEN, bl), 2);
        }

    }
    //?}


//    @Override
//    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
//        BlockPos blockPos = pos.down();
//        BlockState blockState = world.getBlockState(blockPos);
//        return blockState.isSideSolidFullSquare(world, blockPos, Direction.UP);
//    }

    private void playOpenCloseSound(@Nullable Entity entity, World world, BlockPos pos, boolean open) {
        world.playSound(
                entity, pos, open ? this.blockSetType.doorOpen() : this.blockSetType.doorClose(), SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F
        );
    }

    @Override
    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ BlockState mirror(BlockState state, BlockMirror mirror) {
        return mirror == BlockMirror.NONE ? state : state.rotate(mirror.getRotation(state.get(FACING))).cycle(HINGE);
    }

    @Override
    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ long getRenderingSeed(BlockState state, BlockPos pos) {
        return MathHelper.idealHash(pos.getX() + pos.getY() + pos.getZ());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN, HINGE, POWERED);
    }

    public static boolean canOpenByHand(World world, BlockPos pos) {
        return canOpenByHand(world.getBlockState(pos));
    }

    public static boolean canOpenByHand(BlockState state) {
        return state.getBlock() instanceof DoorBlock doorBlock && doorBlock.getBlockSetType().canOpenByHand();
    }

    @Override
    /*? if <1.21.2 {*//*public*//*?} else {*/protected/*?}*/ boolean hasSidedTransparency(BlockState state) {
        return true;
    }
}
