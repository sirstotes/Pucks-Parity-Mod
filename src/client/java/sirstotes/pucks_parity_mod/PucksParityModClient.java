package sirstotes.pucks_parity_mod;

import com.github.crimsondawn45.fabricshieldlib.lib.event.ShieldSetModelCallback;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.model.ShieldEntityModel;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.client.util.SpriteIdentifier;

import static com.github.crimsondawn45.fabricshieldlib.initializers.FabricShieldLibClient.renderBanner;
import static net.minecraft.resource.ResourceType.CLIENT_RESOURCES;

public class PucksParityModClient implements ClientModInitializer {
	public static final EntityModelLayer GOLD_SHIELD_MODEL_LAYER = new EntityModelLayer(Identifier.of("pucks_parity_mod", "gold_shield"),"main");

	public static ShieldEntityModel modelGoldShield;

	public static final SpriteIdentifier GOLD_SHIELD_BASE = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, Identifier.of("pucks_parity_mod", "entity/gold_shield"));
	public static final SpriteIdentifier GOLD_SHIELD_BASE_NO_PATTERN = new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, Identifier.of("pucks_parity_mod", "entity/gold_shield_nopattern"));

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
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.GOLD_GRATE, RenderLayer.getCutout());
		
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.IRON_GATE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(PucksParityModBlocks.IRON_GRATE, RenderLayer.getCutout());
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

		EntityModelLayerRegistry.registerModelLayer(GOLD_SHIELD_MODEL_LAYER, ShieldEntityModel::getTexturedModelData);

		ShieldSetModelCallback.EVENT.register((loader) -> {
			modelGoldShield = new ShieldEntityModel(loader.getModelPart(GOLD_SHIELD_MODEL_LAYER));
			return ActionResult.PASS;
		});

//		BuiltinItemRendererRegistry.INSTANCE.register(PucksParityModItems.GOLD_SHIELD, (stack, mode, matrices, vertexConsumers, light, overlay) -> {
//			renderBanner(stack, matrices, vertexConsumers, light, overlay, modelGoldShield, GOLD_SHIELD_BASE, GOLD_SHIELD_BASE_NO_PATTERN);
//		});
	}

	static {
//		ModelPredicateProviderRegistry.register(
//				PucksParityModItems.COPPER_SHIELD,
//				Identifier.ofVanilla("blocking"),
//				(stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack ? 1.0F : 0.0F
//		);
	}
}