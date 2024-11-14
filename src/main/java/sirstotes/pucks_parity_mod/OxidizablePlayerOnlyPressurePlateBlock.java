package sirstotes.pucks_parity_mod;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;

public class OxidizablePlayerOnlyPressurePlateBlock extends PlayerOnlyPressurePlateBlock implements Oxidizable {
    public static final MapCodec<OxidizablePlayerOnlyPressurePlateBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(createSettingsCodec(),
                            BlockSetType.CODEC.fieldOf("block_set_type").forGetter(block -> block.blockSetType),
                            Codec.intRange(0, 1024).fieldOf("delay").forGetter(block -> block.delay),
                            Oxidizable.OxidationLevel.CODEC.fieldOf("weathering_state").forGetter(Degradable::getDegradationLevel))
                    .apply(instance, OxidizablePlayerOnlyPressurePlateBlock::new)
    );
    private final Oxidizable.OxidationLevel oxidationLevel;
    public static final IntProperty POWER = Properties.POWER;
    private final int delay;

    protected OxidizablePlayerOnlyPressurePlateBlock(Settings settings, BlockSetType blockSetType, int pressDelay, OxidationLevel level) {
        super(settings, blockSetType, pressDelay);
        delay = pressDelay;
        oxidationLevel = level;
    }

    @Override
    public OxidationLevel getDegradationLevel() {
        return oxidationLevel;
    }
}
