package sirstotes.pucks_parity_mod;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class OxidizablePlayerOnlyPressurePlateBlock extends PlayerOnlyPressurePlateBlock implements Oxidizable {
    //?if >1.20.1 {
    /*public static final MapCodec<OxidizablePlayerOnlyPressurePlateBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(createSettingsCodec(),
                            BlockSetType.CODEC.fieldOf("block_set_type").forGetter(block -> block.blockSetType),
                            Codec.intRange(0, 1024).fieldOf("delay").forGetter(block -> block.delay),
                            Oxidizable.OxidationLevel.CODEC.fieldOf("weathering_state").forGetter(Degradable::getDegradationLevel))
                    .apply(instance, OxidizablePlayerOnlyPressurePlateBlock::new)
    );
    *///?}
    private final Oxidizable.OxidationLevel oxidationLevel;
    public static final IntProperty POWER = Properties.POWER;
    private final int delay;

    protected OxidizablePlayerOnlyPressurePlateBlock(Settings settings, BlockSetType blockSetType, int pressDelay, OxidationLevel level) {
        super(settings, blockSetType, pressDelay);
        delay = pressDelay;
        oxidationLevel = level;
    }

    @Override
    /*?if <1.21.2 {*/public/*?} else {*//*protected*//*?}*/ void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickDegradation(state, world, pos, random);
    }

    @Override
    /*?if <1.21.2 {*/public/*?} else {*//*protected*//*?}*/ boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    @Override
    public OxidationLevel getDegradationLevel() {
        return oxidationLevel;
    }
}
