package sirstotes.pucks_parity_mod;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class PlayerOnlyPressurePlateBlock extends AbstractPressurePlateBlock {
    //?if >1.20.1 {
    /*public static final MapCodec< PlayerOnlyPressurePlateBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                            createSettingsCodec(),
                            BlockSetType.CODEC.fieldOf("block_set_type").forGetter(block -> block.blockSetType),
                            Codec.intRange(0, 1024).fieldOf("delay").forGetter(block -> block.delay)
                    )
                    .apply(instance,  PlayerOnlyPressurePlateBlock::new)
    );
    @Override
    public MapCodec< PlayerOnlyPressurePlateBlock> getCodec() {
        return CODEC;
    }
    *///?}

    public static final BooleanProperty POWERED = Properties.POWERED;
    private final int delay;

    protected PlayerOnlyPressurePlateBlock(Settings settings, BlockSetType blockSetType, int pressDelay) {
        super(settings, blockSetType);
        this.setDefaultState(this.stateManager.getDefaultState().with(POWERED, Boolean.valueOf(false)));
        delay = pressDelay;
    }

    @Override
    protected int getRedstoneOutput(World world, BlockPos pos) {
        return getEntityCount(world, BOX.offset(pos), PlayerEntity.class) > 0 ? 15 : 0;
    }

    @Override
    protected int getRedstoneOutput(BlockState state) {
        return state.get(POWERED) ? 15 : 0;
    }

    @Override
    protected BlockState setRedstoneOutput(BlockState state, int rsOut) {
        return state.with(POWERED, Boolean.valueOf(rsOut > 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    @Override
    protected int getTickRate() {
        return delay;
    }
}
