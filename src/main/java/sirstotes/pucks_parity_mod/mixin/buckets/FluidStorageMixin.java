package sirstotes.pucks_parity_mod.mixin.buckets;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage.CombinedItemApiProvider;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.FullItemFluidStorage;
import net.fabricmc.fabric.impl.transfer.fluid.CombinedProvidersImpl;
import net.fabricmc.fabric.impl.transfer.fluid.EmptyBucketStorage;
import net.fabricmc.fabric.mixin.transfer.BucketItemAccessor;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sirstotes.pucks_parity_mod.PucksParityModItems;

@Mixin(FluidStorage.class)
public abstract class FluidStorageMixin {
    @Shadow(remap = false)
    public static final Event<CombinedItemApiProvider> GENERAL_COMBINED_PROVIDER = null;
    @Inject(method = "<clinit>", at = @At("HEAD"))
	private static void staticInjection(CallbackInfo ci) {
        combinedItemApiProvider(PucksParityModItems.COPPER_BUCKET).register(EmptyBucketStorage::new);
		// Register full bucket storage
		GENERAL_COMBINED_PROVIDER.register(context -> {
			if (context.getItemVariant().getItem() instanceof BucketItem bucketItem) {
				Fluid bucketFluid = ((BucketItemAccessor) bucketItem).fabric_getFluid();

				// Make sure the mapping is bidirectional.
				if (bucketFluid != null && bucketFluid.getBucketItem() == bucketItem) {
					return new FullItemFluidStorage(context, PucksParityModItems.COPPER_BUCKET, FluidVariant.of(bucketFluid), FluidConstants.BUCKET);
				}
			}

			return null;
		});

		combinedItemApiProvider(PucksParityModItems.GOLD_BUCKET).register(EmptyBucketStorage::new);
		// Register full bucket storage
		GENERAL_COMBINED_PROVIDER.register(context -> {
			if (context.getItemVariant().getItem() instanceof BucketItem bucketItem) {
				Fluid bucketFluid = ((BucketItemAccessor) bucketItem).fabric_getFluid();

				// Make sure the mapping is bidirectional.
				if (bucketFluid != null && bucketFluid.getBucketItem() == bucketItem) {
					return new FullItemFluidStorage(context, PucksParityModItems.GOLD_BUCKET, FluidVariant.of(bucketFluid), FluidConstants.BUCKET);
				}
			}

			return null;
		});
    }
    @Shadow
    public static Event<CombinedItemApiProvider> combinedItemApiProvider(Item item) {   
		return CombinedProvidersImpl.getOrCreateItemEvent(item);
	}
}
