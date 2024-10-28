package sirstotes.pucks_parity_mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class PucksParityModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.COPPER_CHAIN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.EXPOSED_COPPER_CHAIN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WEATHERED_COPPER_CHAIN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.OXIDIZED_COPPER_CHAIN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_COPPER_CHAIN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_EXPOSED_COPPER_CHAIN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_WEATHERED_COPPER_CHAIN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_OXIDIZED_COPPER_CHAIN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.COPPER_BARS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.EXPOSED_COPPER_BARS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WEATHERED_COPPER_BARS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.OXIDIZED_COPPER_BARS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_COPPER_BARS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_EXPOSED_COPPER_BARS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_WEATHERED_COPPER_BARS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_OXIDIZED_COPPER_BARS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.GOLD_CHAIN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.GOLD_BARS, RenderLayer.getCutout());
	}
}