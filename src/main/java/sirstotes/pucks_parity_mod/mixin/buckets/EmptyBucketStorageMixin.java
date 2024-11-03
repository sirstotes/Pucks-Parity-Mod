package sirstotes.pucks_parity_mod.mixin.buckets;

import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.transaction.TransactionContext;
import net.minecraft.item.BucketItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Shadow;

import net.fabricmc.fabric.api.transfer.v1.context.ContainerItemContext;
import net.fabricmc.fabric.impl.transfer.fluid.EmptyBucketStorage;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sirstotes.pucks_parity_mod.PucksParityModItems;

@Mixin(EmptyBucketStorage.class)
public abstract class EmptyBucketStorageMixin {
    @Final
    @Shadow(remap = false)
    private ContainerItemContext context;
    @Inject(method="insert(Lnet/fabricmc/fabric/api/transfer/v1/fluid/FluidVariant;JLnet/fabricmc/fabric/api/transfer/v1/transaction/TransactionContext;)J",
            at= @At(value = "INVOKE",
                    target = "Lnet/fabricmc/fabric/api/transfer/v1/storage/StoragePreconditions;notBlankNotNegative(Lnet/fabricmc/fabric/api/transfer/v1/storage/TransferVariant;J)V",
                    shift = At.Shift.AFTER),
            cancellable = true,
            remap = false)
    public void includeAllBuckets(FluidVariant resource, long maxAmount, TransactionContext transaction, CallbackInfoReturnable<Long> cir) {
        if (!(this.context.getItemVariant() instanceof BucketItem)) {
            cir.setReturnValue(0L);
        }
    }
}
