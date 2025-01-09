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

		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.COPPER_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_COPPER_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.EXPOSED_COPPER_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_EXPOSED_COPPER_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WEATHERED_COPPER_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_WEATHERED_COPPER_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.OXIDIZED_COPPER_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_OXIDIZED_COPPER_LANTERN, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.COPPER_SOUL_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_COPPER_SOUL_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.EXPOSED_COPPER_SOUL_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_EXPOSED_COPPER_SOUL_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WEATHERED_COPPER_SOUL_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_WEATHERED_COPPER_SOUL_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.OXIDIZED_COPPER_SOUL_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_OXIDIZED_COPPER_SOUL_LANTERN, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.COPPER_REDSTONE_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_COPPER_REDSTONE_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.EXPOSED_COPPER_REDSTONE_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_EXPOSED_COPPER_REDSTONE_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WEATHERED_COPPER_REDSTONE_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_WEATHERED_COPPER_REDSTONE_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.OXIDIZED_COPPER_REDSTONE_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_OXIDIZED_COPPER_REDSTONE_LANTERN, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.COPPER_GATE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_COPPER_GATE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.EXPOSED_COPPER_GATE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_EXPOSED_COPPER_GATE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WEATHERED_COPPER_GATE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_WEATHERED_COPPER_GATE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.OXIDIZED_COPPER_GATE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WAXED_OXIDIZED_COPPER_GATE, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.GOLD_GATE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.GOLD_CHAIN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.GOLD_BARS, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.GOLD_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.GOLD_SOUL_LANTERN, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.GOLD_REDSTONE_LANTERN, RenderLayer.getCutout());
		
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.IRON_GATE, RenderLayer.getCutout());
		//? if >1.20.1 {
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.GOLD_GRATE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.IRON_GRATE, RenderLayer.getCutout());
		//?}
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.IRON_REDSTONE_LANTERN, RenderLayer.getCutout());

		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.SLIDING_GLASS_PANE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.RED_SLIDING_GLASS_PANE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.ORANGE_SLIDING_GLASS_PANE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.YELLOW_SLIDING_GLASS_PANE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.LIME_SLIDING_GLASS_PANE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.GREEN_SLIDING_GLASS_PANE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.CYAN_SLIDING_GLASS_PANE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.LIGHT_BLUE_SLIDING_GLASS_PANE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.BLUE_SLIDING_GLASS_PANE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.PURPLE_SLIDING_GLASS_PANE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.MAGENTA_SLIDING_GLASS_PANE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.PINK_SLIDING_GLASS_PANE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.BROWN_SLIDING_GLASS_PANE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.WHITE_SLIDING_GLASS_PANE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.LIGHT_GRAY_SLIDING_GLASS_PANE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.GRAY_SLIDING_GLASS_PANE, RenderLayer.getTranslucent());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.BLACK_SLIDING_GLASS_PANE, RenderLayer.getTranslucent());

	}
}