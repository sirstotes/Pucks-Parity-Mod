package sirstotes.pucks_parity_mod;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.Degradable;
import net.minecraft.block.HopperBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class OxidizableHopperBlock extends HopperBlock implements Oxidizable {
    public static int TRANSFER_COOLDOWN = 8;
    public static final int INVENTORY_SIZE = 3;
//    public static final MapCodec<OxidizableHopperBlock> CODEC = RecordCodecBuilder.mapCodec(
//            instance -> instance.group(Oxidizable.OxidationLevel.CODEC.fieldOf("weathering_state").forGetter(Degradable::getDegradationLevel), createSettingsCodec())
//                    .apply(instance, OxidizableHopperBlock::new)
//    );
    private final Oxidizable.OxidationLevel oxidationLevel;

    public OxidizableHopperBlock(Oxidizable.OxidationLevel oxidationLevel, int transferCooldown, Settings settings) {
        super(settings);
        TRANSFER_COOLDOWN = transferCooldown;
        this.oxidationLevel = oxidationLevel;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new OxidizableHopperBlockEntity(pos, state);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.tickDegradation(state, world, pos, random);
    }

    @Override
    protected boolean hasRandomTicks(BlockState state) {
        return Oxidizable.getIncreasedOxidationBlock(state.getBlock()).isPresent();
    }

    public Oxidizable.OxidationLevel getDegradationLevel() {
        return this.oxidationLevel;
    }
}
