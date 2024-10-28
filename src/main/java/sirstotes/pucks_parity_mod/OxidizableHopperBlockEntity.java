package sirstotes.pucks_parity_mod;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.HopperScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public class OxidizableHopperBlockEntity extends HopperBlockEntity {
    public OxidizableHopperBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state);
    }


    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return new HopperScreenHandler(syncId, playerInventory, this);
    }
}
