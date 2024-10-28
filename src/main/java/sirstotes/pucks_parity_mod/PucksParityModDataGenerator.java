package sirstotes.pucks_parity_mod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

import static sirstotes.pucks_parity_mod.PucksParityModBlocks.*;

public class PucksParityModDataGenerator implements DataGeneratorEntrypoint {
	private static class BlockLootTableProvider extends FabricBlockLootTableProvider {

		protected BlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
			super(dataOutput, registryLookup);
		}

		@Override
		public void generate() {
			addDrop(COPPER_CHAIN, drops(COPPER_CHAIN.asItem()));
			addDrop(EXPOSED_COPPER_CHAIN, drops(EXPOSED_COPPER_CHAIN.asItem()));
			addDrop(WEATHERED_COPPER_CHAIN, drops(WEATHERED_COPPER_CHAIN.asItem()));
			addDrop(OXIDIZED_COPPER_CHAIN, drops(OXIDIZED_COPPER_CHAIN.asItem()));
			addDrop(WAXED_COPPER_CHAIN, drops(WAXED_COPPER_CHAIN.asItem()));
			addDrop(WAXED_EXPOSED_COPPER_CHAIN, drops(WAXED_EXPOSED_COPPER_CHAIN.asItem()));
			addDrop(WAXED_WEATHERED_COPPER_CHAIN, drops(WAXED_WEATHERED_COPPER_CHAIN.asItem()));
			addDrop(WAXED_OXIDIZED_COPPER_CHAIN, drops(WAXED_OXIDIZED_COPPER_CHAIN.asItem()));

			addDrop(COPPER_BARS, drops(COPPER_BARS.asItem()));
			addDrop(EXPOSED_COPPER_BARS, drops(EXPOSED_COPPER_BARS.asItem()));
			addDrop(WEATHERED_COPPER_BARS, drops(WEATHERED_COPPER_BARS.asItem()));
			addDrop(OXIDIZED_COPPER_BARS, drops(OXIDIZED_COPPER_BARS.asItem()));
			addDrop(WAXED_COPPER_BARS, drops(WAXED_COPPER_BARS.asItem()));
			addDrop(WAXED_EXPOSED_COPPER_BARS, drops(WAXED_EXPOSED_COPPER_BARS.asItem()));
			addDrop(WAXED_WEATHERED_COPPER_BARS, drops(WAXED_WEATHERED_COPPER_BARS.asItem()));
			addDrop(WAXED_OXIDIZED_COPPER_BARS, drops(WAXED_OXIDIZED_COPPER_BARS.asItem()));
		}
	}

	private static class ModelGenerator extends FabricModelProvider {
		private ModelGenerator(FabricDataOutput generator) {
			super(generator);
		}

		@Override
		public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
			registerBars(blockStateModelGenerator, COPPER_BARS, "copper_bars");
			registerBars(blockStateModelGenerator, EXPOSED_COPPER_BARS, "exposed_copper_bars");
			registerBars(blockStateModelGenerator, WEATHERED_COPPER_BARS, "weathered_copper_bars");
			registerBars(blockStateModelGenerator, OXIDIZED_COPPER_BARS, "oxidized_copper_bars");
			registerBars(blockStateModelGenerator, WAXED_COPPER_BARS, "copper_bars");
			registerBars(blockStateModelGenerator, WAXED_EXPOSED_COPPER_BARS, "exposed_copper_bars");
			registerBars(blockStateModelGenerator, WAXED_WEATHERED_COPPER_BARS, "weathered_copper_bars");
			registerBars(blockStateModelGenerator, WAXED_OXIDIZED_COPPER_BARS, "oxidized_copper_bars");
			registerBars(blockStateModelGenerator, GOLD_BARS, "gold_bars");
		}

		@Override
		public void generateItemModels(ItemModelGenerator itemModelGenerator) {
			itemModelGenerator.register(PucksParityModItems.COPPER_BUCKET, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.COPPER_LAVA_BUCKET, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.COPPER_MILK_BUCKET, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.COPPER_WATER_BUCKET, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.COPPER_POWDER_SNOW_BUCKET, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.COPPER_NUGGET, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.COPPER_SHEARS, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.GOLD_BUCKET, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.GOLD_LAVA_BUCKET_1, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.GOLD_LAVA_BUCKET_2, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.GOLD_LAVA_BUCKET_3, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.GOLD_WATER_BUCKET_1, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.GOLD_WATER_BUCKET_2, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.GOLD_WATER_BUCKET_3, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.GOLD_MILK_BUCKET_1, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.GOLD_MILK_BUCKET_2, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.GOLD_MILK_BUCKET_3, Models.GENERATED);
			itemModelGenerator.register(PucksParityModItems.GOLD_SHEARS, Models.GENERATED);

			itemModelGenerator.register(COPPER_CHAIN.asItem(), Models.GENERATED);
			itemModelGenerator.register(EXPOSED_COPPER_CHAIN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WEATHERED_COPPER_CHAIN.asItem(), Models.GENERATED);
			itemModelGenerator.register(OXIDIZED_COPPER_CHAIN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_COPPER_CHAIN.asItem(), COPPER_CHAIN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_EXPOSED_COPPER_CHAIN.asItem(), EXPOSED_COPPER_CHAIN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_WEATHERED_COPPER_CHAIN.asItem(), WEATHERED_COPPER_CHAIN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_OXIDIZED_COPPER_CHAIN.asItem(), OXIDIZED_COPPER_CHAIN.asItem(), Models.GENERATED);
			itemModelGenerator.register(GOLD_CHAIN.asItem(), Models.GENERATED);

			itemModelGenerator.register(COPPER_BARS.asItem(), Models.GENERATED);
			itemModelGenerator.register(EXPOSED_COPPER_BARS.asItem(), Models.GENERATED);
			itemModelGenerator.register(WEATHERED_COPPER_BARS.asItem(), Models.GENERATED);
			itemModelGenerator.register(OXIDIZED_COPPER_BARS.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_COPPER_BARS.asItem(), COPPER_BARS.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_EXPOSED_COPPER_BARS.asItem(), EXPOSED_COPPER_BARS.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_WEATHERED_COPPER_BARS.asItem(), WEATHERED_COPPER_BARS.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_OXIDIZED_COPPER_BARS.asItem(), OXIDIZED_COPPER_BARS.asItem(), Models.GENERATED);
			itemModelGenerator.register(GOLD_BARS.asItem(), Models.GENERATED);
		}

		private void registerBars(BlockStateModelGenerator blockStateModelGenerator, Block block, String texture) {
			Identifier identifier = ModelIds.getBlockSubModelId(block, "_post_ends");
			Identifier identifier2 = ModelIds.getBlockSubModelId(block, "_post");
			Identifier identifier3 = ModelIds.getBlockSubModelId(block, "_cap");
			Identifier identifier4 = ModelIds.getBlockSubModelId(block, "_cap_alt");
			Identifier identifier5 = ModelIds.getBlockSubModelId(block, "_side");
			Identifier identifier6 = ModelIds.getBlockSubModelId(block, "_side_alt");
			blockStateModelGenerator.blockStateCollector
					.accept(
							MultipartBlockStateSupplier.create(block)
									.with(BlockStateVariant.create().put(VariantSettings.MODEL, identifier))
									.with(
											When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, false),
											BlockStateVariant.create().put(VariantSettings.MODEL, identifier2)
									)
									.with(
											When.create().set(Properties.NORTH, true).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, false),
											BlockStateVariant.create().put(VariantSettings.MODEL, identifier3)
									)
									.with(
											When.create().set(Properties.NORTH, false).set(Properties.EAST, true).set(Properties.SOUTH, false).set(Properties.WEST, false),
											BlockStateVariant.create().put(VariantSettings.MODEL, identifier3).put(VariantSettings.Y, VariantSettings.Rotation.R90)
									)
									.with(
											When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, true).set(Properties.WEST, false),
											BlockStateVariant.create().put(VariantSettings.MODEL, identifier4)
									)
									.with(
											When.create().set(Properties.NORTH, false).set(Properties.EAST, false).set(Properties.SOUTH, false).set(Properties.WEST, true),
											BlockStateVariant.create().put(VariantSettings.MODEL, identifier4).put(VariantSettings.Y, VariantSettings.Rotation.R90)
									)
									.with(When.create().set(Properties.NORTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier5))
									.with(
											When.create().set(Properties.EAST, true),
											BlockStateVariant.create().put(VariantSettings.MODEL, identifier5).put(VariantSettings.Y, VariantSettings.Rotation.R90)
									)
									.with(When.create().set(Properties.SOUTH, true), BlockStateVariant.create().put(VariantSettings.MODEL, identifier6))
									.with(
											When.create().set(Properties.WEST, true),
											BlockStateVariant.create().put(VariantSettings.MODEL, identifier6).put(VariantSettings.Y, VariantSettings.Rotation.R90)
									)
					);
			TextureMap textureMap = new TextureMap()
					.put(TextureKey.PARTICLE, Identifier.of("pucks_parity_mod", "block/" + texture))
					.put(TextureKey.TEXTURE, Identifier.of("pucks_parity_mod", "block/" + texture));

			new Model(Optional.of(Identifier.of("pucks_parity_mod", "block/template_bars_post_ends")), Optional.of(texture + "_post_ends"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(identifier, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of("pucks_parity_mod", "block/template_bars_post")), Optional.of(texture + "_post"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(identifier2, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of("pucks_parity_mod", "block/template_bars_cap")), Optional.of(texture + "_cap"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(identifier3, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of("pucks_parity_mod", "block/template_bars_cap_alt")), Optional.of(texture + "_cap_alt"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(identifier4, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of("pucks_parity_mod", "block/template_bars_side")), Optional.of(texture + "_side"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(identifier5, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of("pucks_parity_mod", "block/template_bars_side_alt")), Optional.of(texture + "_side_alt"), TextureKey.PARTICLE, TextureKey.TEXTURE)
					.upload(identifier6, textureMap, blockStateModelGenerator.modelCollector);
		}
	}

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(BlockLootTableProvider::new);
		pack.addProvider(ModelGenerator::new);
	}

}
