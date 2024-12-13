package sirstotes.pucks_parity_mod;

import com.google.common.collect.ImmutableMap;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

import static sirstotes.pucks_parity_mod.PucksParityModBlocks.*;
import static sirstotes.pucks_parity_mod.PucksParityModBlocks.POLISHED_PURPUR;
import static sirstotes.pucks_parity_mod.PucksParityModItems.*;

public class PucksParityModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(BlockLootTableProvider::new);
		pack.addProvider(ModelGenerator::new);
		pack.addProvider(RecipeGenerator::new);
		pack.addProvider(ItemTagGenerator::new);
		pack.addProvider(BlockTagGenerator::new);
	}

	private static class ItemTagGenerator extends FabricTagProvider<Item> {
		public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
			super(output, RegistryKeys.ITEM, registriesFuture);
		}
		@Override
		protected void configure(RegistryWrapper.WrapperLookup lookup) {
			getOrCreateTagBuilder(ItemTags.STONE_CRAFTING_MATERIALS)
					.add(COBBLED_TUFF.asItem())
					.add(COBBLED_GRANITE.asItem())
					.add(COBBLED_ANDESITE.asItem())
					.add(COBBLED_DIORITE.asItem())
					.add(COBBLED_BASALT.asItem())
					.add(COBBLED_CALCITE.asItem())
					.add(COBBLED_DRIPSTONE.asItem());
			getOrCreateTagBuilder(ItemTags.STONE_TOOL_MATERIALS)
					.add(COBBLED_TUFF.asItem())
					.add(COBBLED_GRANITE.asItem())
					.add(COBBLED_ANDESITE.asItem())
					.add(COBBLED_DIORITE.asItem())
					.add(COBBLED_BASALT.asItem())
					.add(COBBLED_CALCITE.asItem())
					.add(COBBLED_DRIPSTONE.asItem());
		}
	}

	private static class BlockTagGenerator extends FabricTagProvider<Block> {
		public BlockTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
			super(output, RegistryKeys.BLOCK, registriesFuture);
		}

		@Override
		protected void configure(RegistryWrapper.WrapperLookup lookup) {
			getOrCreateTagBuilder(BlockTags.INFINIBURN_OVERWORLD).add(NETHERRACK_SLAB, NETHERRACK_STAIRS, CRIMSON_NETHERRACK, CRIMSON_NETHERRACK_SLAB, CRIMSON_NETHERRACK_STAIRS, WARPED_NETHERRACK, WARPED_NETHERRACK_SLAB, WARPED_NETHERRACK_STAIRS);
			getOrCreateTagBuilder(BlockTags.PRESSURE_PLATES).add(PLAYER_PRESSURE_PLATE, WAXED_PLAYER_PRESSURE_PLATE, EXPOSED_PLAYER_PRESSURE_PLATE, WAXED_EXPOSED_PLAYER_PRESSURE_PLATE, WEATHERED_PLAYER_PRESSURE_PLATE, WAXED_WEATHERED_PLAYER_PRESSURE_PLATE, OXIDIZED_PLAYER_PRESSURE_PLATE, WAXED_OXIDIZED_PLAYER_PRESSURE_PLATE);
			getOrCreateTagBuilder(BlockTags.WALLS)
					.add(STONE_WALL)
					.add(POLISHED_STONE_WALL)
					.add(STONE_TILE_WALL)
					.add(COBBLED_TUFF_WALL)
					.add(MOSSY_COBBLED_TUFF_WALL)
					.add(MOSSY_TUFF_BRICK_WALL)
					.add(TUFF_TILE_WALL)
					.add(MOSSY_COBBLED_DEEPSLATE_WALL)
					.add(SCULKY_COBBLED_DEEPSLATE_WALL)
					.add(DEEPSLATE_WALL)
					.add(MOSSY_DEEPSLATE_BRICK_WALL)
					.add(SCULKY_DEEPSLATE_BRICK_WALL)
					.add(COBBLED_GRANITE_WALL)
					.add(MOSSY_COBBLED_GRANITE_WALL)
					.add(GRANITE_BRICK_WALL)
					.add(MOSSY_GRANITE_BRICK_WALL)
					.add(POLISHED_GRANITE_WALL)
					.add(GRANITE_TILE_WALL)
					.add(COBBLED_ANDESITE_WALL)
					.add(MOSSY_COBBLED_ANDESITE_WALL)
					.add(ANDESITE_BRICK_WALL)
					.add(MOSSY_ANDESITE_BRICK_WALL)
					.add(POLISHED_ANDESITE_WALL)
					.add(ANDESITE_TILE_WALL)
					.add(COBBLED_DIORITE_WALL)
					.add(MOSSY_COBBLED_DIORITE_WALL)
					.add(DIORITE_BRICK_WALL)
					.add(MOSSY_DIORITE_BRICK_WALL)
					.add(POLISHED_DIORITE_WALL)
					.add(DIORITE_TILE_WALL)
					.add(COBBLED_BLACKSTONE_WALL)
					.add(CRIMSON_COBBLED_BLACKSTONE_WALL)
					.add(CRIMSON_BLACKSTONE_BRICK_WALL)
					.add(WARPED_COBBLED_BLACKSTONE_WALL)
					.add(WARPED_BLACKSTONE_BRICK_WALL)
					.add(BLACKSTONE_TILE_WALL)
					.add(COBBLED_END_STONE_WALL)
					.add(END_STONE_WALL)
					.add(MOLDY_COBBLED_END_STONE_WALL)
					.add(MOLDY_END_STONE_BRICK_WALL)
					.add(MOLDY_PURPUR_BRICK_WALL)
					.add(POLISHED_END_STONE_WALL)
					.add(END_STONE_TILE_WALL)
					.add(PURPUR_WALL)
					.add(PURPUR_TILE_WALL)
					.add(PURPUR_BRICK_WALL)
					.add(POLISHED_PURPUR_WALL)
					.add(MOSSY_SANDSTONE_WALL)
					.add(SMOOTH_SANDSTONE_WALL)
					.add(SANDSTONE_BRICK_WALL)
					.add(MOSSY_SANDSTONE_BRICK_WALL)
					.add(CUT_SANDSTONE_WALL)
					.add(SANDSTONE_TILE_WALL)
					.add(MOSSY_RED_SANDSTONE_WALL)
					.add(SMOOTH_RED_SANDSTONE_WALL)
					.add(RED_SANDSTONE_BRICK_WALL)
					.add(MOSSY_RED_SANDSTONE_BRICK_WALL)
					.add(CUT_RED_SANDSTONE_WALL)
					.add(RED_SANDSTONE_TILE_WALL)
					.add(BARNACLED_PRISMARINE_WALL)
					.add(SMOOTH_PRISMARINE_WALL)
					.add(PRISMARINE_BRICK_WALL)
					.add(BARNACLED_PRISMARINE_BRICK_WALL)
					.add(POLISHED_PRISMARINE_WALL)
					.add(PRISMARINE_TILE_WALL)
					.add(DARK_PRISMARINE_WALL)
					.add(BARNACLED_DARK_PRISMARINE_WALL)
					.add(SMOOTH_DARK_PRISMARINE_WALL)
					.add(DARK_PRISMARINE_BRICK_WALL)
					.add(BARNACLED_DARK_PRISMARINE_BRICK_WALL)
					.add(POLISHED_DARK_PRISMARINE_WALL)
					.add(DARK_PRISMARINE_TILE_WALL)
					.add(NETHERRACK_WALL)
					.add(CRIMSON_NETHERRACK_WALL)
					.add(WARPED_NETHERRACK_WALL)
					.add(HARDENED_NETHERRACK_WALL)
					.add(NETHER_BRICK_WALL)
					.add(CRIMSON_NETHER_BRICK_WALL)
					.add(WARPED_NETHER_BRICK_WALL)
					.add(POLISHED_HARDENED_NETHERRACK_WALL)
					.add(NETHER_TILE_WALL)
					.add(COBBLED_BASALT_WALL)
					.add(CRIMSON_COBBLED_BASALT_WALL)
					.add(WARPED_COBBLED_BASALT_WALL)
					.add(SMOOTH_BASALT_WALL)
					.add(BASALT_BRICK_WALL)
					.add(CRIMSON_BASALT_BRICK_WALL)
					.add(WARPED_BASALT_BRICK_WALL)
					.add(POLISHED_BASALT_WALL)
					.add(BASALT_TILE_WALL)
					.add(COBBLED_CALCITE_WALL)
					.add(MOSSY_COBBLED_CALCITE_WALL)
					.add(CALCITE_WALL)
					.add(CALCITE_BRICK_WALL)
					.add(MOSSY_CALCITE_BRICK_WALL)
					.add(POLISHED_CALCITE_WALL)
					.add(CALCITE_TILE_WALL)
					.add(COBBLED_DRIPSTONE_WALL)
					.add(MOSSY_COBBLED_DRIPSTONE_WALL)
					.add(DRIPSTONE_WALL)
					.add(DRIPSTONE_BRICK_WALL)
					.add(MOSSY_DRIPSTONE_BRICK_WALL)
					.add(POLISHED_DRIPSTONE_WALL)
					.add(DRIPSTONE_TILE_WALL)
					.add(SMOOTH_STONE_WALL)
					.add(SMOOTH_STONE_BRICK_WALL)
					.add(MOSSY_SMOOTH_STONE_BRICK_WALL)
					.add(POLISHED_SMOOTH_STONE_WALL)
					.add(SMOOTH_STONE_TILE_WALL)
					.add(RED_HARDENED_NETHERRACK_WALL)
					.add(CRIMSON_RED_NETHER_BRICK_WALL)
					.add(WARPED_RED_NETHER_BRICK_WALL)
					.add(POLISHED_RED_HARDENED_NETHERRACK_WALL)
					.add(RED_NETHER_TILE_WALL)
					.add(QUARTZ_WALL)
					.add(QUARTZ_BRICK_WALL)
					.add(CRIMSON_QUARTZ_BRICK_WALL)
					.add(WARPED_QUARTZ_BRICK_WALL)
					.add(WARPED_QUARTZ_BRICK_WALL)
					.add(POLISHED_QUARTZ_WALL)
					.add(QUARTZ_TILE_WALL)
					.add(PACKED_MUD_WALL)
					.add(MOSSY_MUD_BRICK_WALL)
					.add(POLISHED_PACKED_MUD_WALL)
					.add(MUD_TILE_WALL)
					.add(TERRACOTTA_WALL)
					.add(MOSSY_BRICK_WALL)
					.add(POLISHED_TERRACOTTA_WALL)
					.add(TERRACOTTA_TILE_WALL)
					.add(RED_TERRACOTTA_WALL)
					.add(RED_TERRACOTTA_BRICK_WALL)
					.add(MOSSY_RED_TERRACOTTA_BRICK_WALL)
					.add(POLISHED_RED_TERRACOTTA_WALL)
					.add(RED_TERRACOTTA_TILE_WALL)
					.add(ORANGE_TERRACOTTA_WALL)
					.add(ORANGE_TERRACOTTA_BRICK_WALL)
					.add(MOSSY_ORANGE_TERRACOTTA_BRICK_WALL)
					.add(POLISHED_ORANGE_TERRACOTTA_WALL)
					.add(ORANGE_TERRACOTTA_TILE_WALL)
					.add(YELLOW_TERRACOTTA_WALL)
					.add(YELLOW_TERRACOTTA_BRICK_WALL)
					.add(MOSSY_YELLOW_TERRACOTTA_BRICK_WALL)
					.add(POLISHED_YELLOW_TERRACOTTA_WALL)
					.add(YELLOW_TERRACOTTA_TILE_WALL)
					.add(LIME_TERRACOTTA_WALL)
					.add(LIME_TERRACOTTA_BRICK_WALL)
					.add(MOSSY_LIME_TERRACOTTA_BRICK_WALL)
					.add(POLISHED_LIME_TERRACOTTA_WALL)
					.add(LIME_TERRACOTTA_TILE_WALL)
					.add(GREEN_TERRACOTTA_WALL)
					.add(GREEN_TERRACOTTA_BRICK_WALL)
					.add(MOSSY_GREEN_TERRACOTTA_BRICK_WALL)
					.add(POLISHED_GREEN_TERRACOTTA_WALL)
					.add(GREEN_TERRACOTTA_TILE_WALL)
					.add(CYAN_TERRACOTTA_WALL)
					.add(CYAN_TERRACOTTA_BRICK_WALL)
					.add(MOSSY_CYAN_TERRACOTTA_BRICK_WALL)
					.add(POLISHED_CYAN_TERRACOTTA_WALL)
					.add(CYAN_TERRACOTTA_TILE_WALL)
					.add(LIGHT_BLUE_TERRACOTTA_WALL)
					.add(LIGHT_BLUE_TERRACOTTA_BRICK_WALL)
					.add(MOSSY_LIGHT_BLUE_TERRACOTTA_BRICK_WALL)
					.add(POLISHED_LIGHT_BLUE_TERRACOTTA_WALL)
					.add(LIGHT_BLUE_TERRACOTTA_TILE_WALL)
					.add(BLUE_TERRACOTTA_WALL)
					.add(BLUE_TERRACOTTA_BRICK_WALL)
					.add(MOSSY_BLUE_TERRACOTTA_BRICK_WALL)
					.add(POLISHED_BLUE_TERRACOTTA_WALL)
					.add(BLUE_TERRACOTTA_TILE_WALL)
					.add(PURPLE_TERRACOTTA_WALL)
					.add(PURPLE_TERRACOTTA_BRICK_WALL)
					.add(MOSSY_PURPLE_TERRACOTTA_BRICK_WALL)
					.add(POLISHED_PURPLE_TERRACOTTA_WALL)
					.add(PURPLE_TERRACOTTA_TILE_WALL)
					.add(MAGENTA_TERRACOTTA_WALL)
					.add(MAGENTA_TERRACOTTA_BRICK_WALL)
					.add(MOSSY_MAGENTA_TERRACOTTA_BRICK_WALL)
					.add(POLISHED_MAGENTA_TERRACOTTA_WALL)
					.add(MAGENTA_TERRACOTTA_TILE_WALL)
					.add(PINK_TERRACOTTA_WALL)
					.add(PINK_TERRACOTTA_BRICK_WALL)
					.add(MOSSY_PINK_TERRACOTTA_BRICK_WALL)
					.add(POLISHED_PINK_TERRACOTTA_WALL)
					.add(PINK_TERRACOTTA_TILE_WALL)
					.add(BROWN_TERRACOTTA_WALL)
					.add(BROWN_TERRACOTTA_BRICK_WALL)
					.add(MOSSY_BROWN_TERRACOTTA_BRICK_WALL)
					.add(POLISHED_BROWN_TERRACOTTA_WALL)
					.add(BROWN_TERRACOTTA_TILE_WALL)
					.add(WHITE_TERRACOTTA_WALL)
					.add(WHITE_TERRACOTTA_BRICK_WALL)
					.add(MOSSY_WHITE_TERRACOTTA_BRICK_WALL)
					.add(POLISHED_WHITE_TERRACOTTA_WALL)
					.add(WHITE_TERRACOTTA_TILE_WALL)
					.add(LIGHT_GRAY_TERRACOTTA_WALL)
					.add(LIGHT_GRAY_TERRACOTTA_BRICK_WALL)
					.add(MOSSY_LIGHT_GRAY_TERRACOTTA_BRICK_WALL)
					.add(POLISHED_LIGHT_GRAY_TERRACOTTA_WALL)
					.add(LIGHT_GRAY_TERRACOTTA_TILE_WALL)
					.add(GRAY_TERRACOTTA_WALL)
					.add(GRAY_TERRACOTTA_BRICK_WALL)
					.add(MOSSY_GRAY_TERRACOTTA_BRICK_WALL)
					.add(POLISHED_GRAY_TERRACOTTA_WALL)
					.add(GRAY_TERRACOTTA_TILE_WALL)
					.add(BLACK_TERRACOTTA_WALL)
					.add(BLACK_TERRACOTTA_BRICK_WALL)
					.add(MOSSY_BLACK_TERRACOTTA_BRICK_WALL)
					.add(POLISHED_BLACK_TERRACOTTA_WALL)
					.add(BLACK_TERRACOTTA_TILE_WALL);
		}
	}

	private static class RecipeGenerator extends FabricRecipeProvider {
		private RecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
			super(output, registriesFuture);
		}

		@Override
		public void generate(RecipeExporter exporter) {
			offerReversibleCompactingRecipesWithCompactingRecipeGroup(exporter, RecipeCategory.MISC, COPPER_NUGGET, RecipeCategory.MISC, Items.COPPER_INGOT, "copper_ingot_from_nuggets", "copper_ingot");
			offerReversibleCompactingRecipesWithCompactingRecipeGroup(exporter, RecipeCategory.MISC, Items.POPPED_CHORUS_FRUIT, RecipeCategory.MISC, PURPUR, "purpur_from_chorus_fruit", "purpur");
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, COPPER_BUCKET)
					.input('#', Items.COPPER_INGOT)
					.pattern("# #")
					.pattern(" # ")
					.criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
					.offerTo(exporter);
			ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, COPPER_FIRE_STARTER)
					.input(Items.COPPER_INGOT)
					.input(Items.FLINT)
					.criterion("has_flint", conditionsFromItem(Items.FLINT))
					.criterion("has_obsidian", conditionsFromItem(Blocks.OBSIDIAN))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, COPPER_SHEARS)
					.input('#', Items.COPPER_INGOT)
					.pattern(" #")
					.pattern("# ")
					.criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
					.offerTo(exporter);
			CookingRecipeJsonBuilder.createSmelting(
							Ingredient.ofItems(COPPER_HORSE_ARMOR),
							RecipeCategory.MISC,
							COPPER_NUGGET,
							0.1F,
							200
					)
					.criterion("has_copper_horse_armor", conditionsFromItem(COPPER_HORSE_ARMOR))
					.offerTo(exporter, getSmeltingItemPath(COPPER_NUGGET));
			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, COPPER_HORSE_ARMOR)
					.input('X', Items.COPPER_INGOT)
					.pattern("X X")
					.pattern("XXX")
					.pattern("X X")
					.criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, COPPER_SHIELD)
					.input('W', ItemTags.PLANKS)
					.input('o', Items.COPPER_INGOT)
					.pattern("WoW")
					.pattern("WWW")
					.pattern(" W ")
					.criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
					.offerTo(exporter);
			offerPressurePlateRecipe(exporter, PLAYER_PRESSURE_PLATE, Items.COPPER_INGOT);
			ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, COPPER_BARS, 8)
					.input('#', Items.COPPER_INGOT)
					.input('X', COPPER_NUGGET)
					.pattern("#X#")
					.pattern("#X#")
					.criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
					.criterion("has_copper_nugget", conditionsFromItem(COPPER_NUGGET))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, COPPER_GATE, 3)
					.input('#', Items.COPPER_INGOT)
					.input('X', COPPER_NUGGET)
					.pattern("X#X")
					.pattern("X#X")
					.criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
					.criterion("has_copper_nugget", conditionsFromItem(COPPER_NUGGET))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, COPPER_CHAIN)
					.input('I', Items.COPPER_INGOT)
					.input('N', COPPER_NUGGET)
					.pattern("N")
					.pattern("I")
					.pattern("N")
					.criterion("has_copper_nugget", conditionsFromItem(COPPER_NUGGET))
					.criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, COPPER_LANTERN)
					.input('#', Items.TORCH)
					.input('X', COPPER_NUGGET)
					.pattern("XXX")
					.pattern("X#X")
					.pattern("XXX")
					.criterion("has_copper_nugget", conditionsFromItem(COPPER_NUGGET))
					.criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, COPPER_SOUL_LANTERN)
					.input('#', Items.SOUL_TORCH)
					.input('X', COPPER_NUGGET)
					.pattern("XXX")
					.pattern("X#X")
					.pattern("XXX")
					.criterion("has_copper_nugget", conditionsFromItem(COPPER_NUGGET))
					.criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, COPPER_REDSTONE_LANTERN)
					.input('#', Items.REDSTONE_TORCH)
					.input('X', COPPER_NUGGET)
					.pattern("XXX")
					.pattern("X#X")
					.pattern("XXX")
					.criterion("has_copper_nugget", conditionsFromItem(COPPER_NUGGET))
					.criterion("has_copper_ingot", conditionsFromItem(Items.COPPER_INGOT))
					.offerTo(exporter);

			ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, GOLD_BUCKET)
					.input('#', Items.GOLD_INGOT)
					.pattern("# #")
					.pattern(" # ")
					.criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
					.offerTo(exporter);
			ShapelessRecipeJsonBuilder.create(RecipeCategory.TOOLS, GOLD_FIRE_STARTER)
					.input(Items.GOLD_INGOT)
					.input(Items.FLINT)
					.criterion("has_flint", conditionsFromItem(Items.FLINT))
					.criterion("has_obsidian", conditionsFromItem(Blocks.OBSIDIAN))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, GOLD_SHEARS)
					.input('#', Items.GOLD_INGOT)
					.pattern(" #")
					.pattern("# ")
					.criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, GOLD_BRUSH)
					.input('X', Items.FEATHER)
					.input('#', Items.GOLD_INGOT)
					.input('I', Items.STICK)
					.pattern("X")
					.pattern("#")
					.pattern("I")
					.criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, GOLD_SHIELD)
					.input('W', ItemTags.PLANKS)
					.input('o', Items.GOLD_INGOT)
					.pattern("WoW")
					.pattern("WWW")
					.pattern(" W ")
					.criterion("has_copper_ingot", conditionsFromItem(Items.GOLD_INGOT))
					.offerTo(exporter);
			createDoorRecipe(GOLD_DOOR, Ingredient.ofItems(Items.GOLD_INGOT))
					.criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
					.offerTo(exporter);
			createTrapdoorRecipe(GOLD_TRAPDOOR, Ingredient.ofItems(Items.GOLD_INGOT))
					.criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
					.offerTo(exporter);
			offerGrateRecipe(exporter, GOLD_GRATE, Blocks.GOLD_BLOCK);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CUT_GOLD_SLAB, CUT_GOLD, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CUT_GOLD_STAIRS, CUT_GOLD);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CUT_GOLD, Blocks.GOLD_BLOCK, 4);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CUT_GOLD_STAIRS, Blocks.GOLD_BLOCK, 4);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CUT_GOLD_SLAB, Blocks.GOLD_BLOCK, 8);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GOLD, Blocks.GOLD_BLOCK, 4);
			offerBulbRecipe(exporter, GOLD_BULB, Blocks.GOLD_BLOCK);
			ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, GOLD_BARS, 8)
					.input('#', Items.GOLD_INGOT)
					.input('X', Items.GOLD_NUGGET)
					.pattern("#X#")
					.pattern("#X#")
					.criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
					.criterion("has_gold_nugget", conditionsFromItem(Items.GOLD_NUGGET))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, GOLD_GATE, 3)
					.input('#', Items.GOLD_INGOT)
					.input('X', Items.GOLD_NUGGET)
					.pattern("X#X")
					.pattern("X#X")
					.criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
					.criterion("has_gold_nugget", conditionsFromItem(Items.GOLD_NUGGET))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, GOLD_CHAIN)
					.input('I', Items.GOLD_INGOT)
					.input('N', Items.GOLD_NUGGET)
					.pattern("N")
					.pattern("I")
					.pattern("N")
					.criterion("has_iron_nugget", conditionsFromItem(Items.GOLD_NUGGET))
					.criterion("has_iron_ingot", conditionsFromItem(Items.GOLD_INGOT))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, GOLD_LANTERN)
					.input('#', Items.TORCH)
					.input('X', Items.GOLD_NUGGET)
					.pattern("XXX")
					.pattern("X#X")
					.pattern("XXX")
					.criterion("has_gold_nugget", conditionsFromItem(Items.GOLD_NUGGET))
					.criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, GOLD_SOUL_LANTERN)
					.input('#', Items.SOUL_TORCH)
					.input('X', Items.GOLD_NUGGET)
					.pattern("XXX")
					.pattern("X#X")
					.pattern("XXX")
					.criterion("has_gold_nugget", conditionsFromItem(Items.GOLD_NUGGET))
					.criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, GOLD_REDSTONE_LANTERN)
					.input('#', Items.REDSTONE_TORCH)
					.input('X', Items.GOLD_NUGGET)
					.pattern("XXX")
					.pattern("X#X")
					.pattern("XXX")
					.criterion("has_gold_nugget", conditionsFromItem(Items.GOLD_NUGGET))
					.criterion("has_gold_ingot", conditionsFromItem(Items.GOLD_INGOT))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CUT_GOLD, 4)
					.input('X', Blocks.GOLD_BLOCK)
					.pattern("XX")
					.pattern("XX")
					.criterion("has_gold_block", conditionsFromItem(Blocks.GOLD_BLOCK))
					.offerTo(exporter);
			createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, CUT_GOLD_SLAB, Ingredient.ofItems(CUT_GOLD))
					.criterion("has_cut_gold_block", conditionsFromItem(CUT_GOLD))
					.offerTo(exporter);
			createStairsRecipe(CUT_GOLD_STAIRS, Ingredient.ofItems(CUT_GOLD))
					.criterion("has_cut_gold_block", conditionsFromItem(CUT_GOLD))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CHISELED_GOLD, 1)
					.input('X', CUT_GOLD_SLAB)
					.pattern("X")
					.pattern("X")
					.criterion("has_cut_gold_block", conditionsFromItem(CUT_GOLD))
					.offerTo(exporter);

			ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, IRON_BRUSH)
					.input('X', Items.FEATHER)
					.input('#', Items.IRON_INGOT)
					.input('I', Items.STICK)
					.pattern("X")
					.pattern("#")
					.pattern("I")
					.criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
					.offerTo(exporter);
			createTrapdoorRecipe(Blocks.IRON_TRAPDOOR, Ingredient.ofItems(Items.IRON_INGOT))
					.criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
					.offerTo(exporter);
			offerGrateRecipe(exporter, IRON_GRATE, Blocks.IRON_BLOCK);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CUT_IRON_SLAB, CUT_IRON, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CUT_IRON_STAIRS, CUT_IRON);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CUT_IRON, Blocks.IRON_BLOCK, 4);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CUT_IRON_STAIRS, Blocks.IRON_BLOCK, 4);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CUT_IRON_SLAB, Blocks.IRON_BLOCK, 8);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_IRON, Blocks.IRON_BLOCK, 4);
			offerBulbRecipe(exporter, IRON_BULB, Blocks.IRON_BLOCK);
			ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.IRON_BARS, 8)
					.input('#', Items.IRON_INGOT)
					.input('X', Items.IRON_NUGGET)
					.pattern("#X#")
					.pattern("#X#")
					.criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
					.criterion("has_iron_nugget", conditionsFromItem(Items.IRON_NUGGET))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, IRON_GATE, 3)
					.input('#', Items.IRON_INGOT)
					.input('X', Items.IRON_NUGGET)
					.pattern("X#X")
					.pattern("X#X")
					.criterion("has_iron_ingot", conditionsFromItem(Items.IRON_INGOT))
					.criterion("has_iron_nugget", conditionsFromItem(Items.IRON_NUGGET))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, IRON_REDSTONE_LANTERN)
					.input('#', Items.REDSTONE_TORCH)
					.input('X', Items.IRON_NUGGET)
					.pattern("XXX")
					.pattern("X#X")
					.pattern("XXX")
					.criterion("has_gold_nugget", conditionsFromItem(Items.IRON_NUGGET))
					.criterion("has_gold_ingot", conditionsFromItem(Items.IRON_INGOT))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CUT_IRON, 4)
					.input('X', Blocks.IRON_BLOCK)
					.pattern("XX")
					.pattern("XX")
					.criterion("has_gold_block", conditionsFromItem(Blocks.IRON_BLOCK))
					.offerTo(exporter);
			createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, CUT_IRON_SLAB, Ingredient.ofItems(CUT_IRON))
					.criterion("has_cut_gold_block", conditionsFromItem(CUT_IRON))
					.offerTo(exporter);
			createStairsRecipe(CUT_IRON_STAIRS, Ingredient.ofItems(CUT_IRON))
					.criterion("has_cut_gold_block", conditionsFromItem(CUT_IRON))
					.offerTo(exporter);
			ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CHISELED_IRON, 1)
					.input('X', CUT_IRON_SLAB)
					.pattern("X")
					.pattern("X")
					.criterion("has_cut_gold_block", conditionsFromItem(CUT_IRON))
					.offerTo(exporter);

			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, STONE_WALL, Blocks.STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, STONE_TILES, Blocks.STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, STONE_TILE_SLAB, Blocks.STONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, STONE_TILE_STAIRS, Blocks.STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, STONE_TILE_WALL, Blocks.STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_STONE_TILES, Blocks.STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, STONE_TILE_SLAB, STONE_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, STONE_TILE_STAIRS, STONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, STONE_TILE_WALL, STONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_STONE_TILES, STONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_STONE, Blocks.STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_STONE_SLAB, Blocks.STONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_STONE_STAIRS, Blocks.STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_STONE_WALL, Blocks.STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_STONE_SLAB, POLISHED_STONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_STONE_STAIRS, POLISHED_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_STONE_WALL, POLISHED_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, STONE_PILLAR, Blocks.STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_STONE_PILLAR, Blocks.STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, STONE_PILLAR, Blocks.STONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_STONE_PILLAR, Blocks.STONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_STONE_BRICKS, STONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, STONE_PILLAR, STONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_STONE_PILLAR, STONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_STONE_BRICKS, POLISHED_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, STONE_PILLAR, POLISHED_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_STONE_PILLAR, POLISHED_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_TUFF_BRICKS, Blocks.TUFF, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_TUFF_BRICKS, Blocks.TUFF_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TUFF_TILES, Blocks.TUFF, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TUFF_TILE_SLAB, Blocks.TUFF, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TUFF_TILE_STAIRS, Blocks.TUFF, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TUFF_TILE_WALL, Blocks.TUFF, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_TUFF_TILES, Blocks.TUFF, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TUFF_TILE_SLAB, TUFF_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TUFF_TILE_STAIRS, TUFF_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TUFF_TILE_WALL, TUFF_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_TUFF_TILES, TUFF_TILES, 1);;
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TUFF_PILLAR, Blocks.TUFF, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_TUFF_BRICKS, Blocks.TUFF_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TUFF_PILLAR, Blocks.TUFF_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_TUFF, Blocks.TUFF_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_TUFF_BRICKS, TUFF_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TUFF_PILLAR, TUFF_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_TUFF, TUFF_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_TUFF_BRICKS, Blocks.POLISHED_TUFF, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TUFF_PILLAR, Blocks.POLISHED_TUFF, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_TUFF, Blocks.POLISHED_TUFF, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DEEPSLATE_SLAB, Blocks.DEEPSLATE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DEEPSLATE_STAIRS, Blocks.DEEPSLATE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DEEPSLATE_WALL, Blocks.DEEPSLATE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DEEPSLATE_PILLAR, Blocks.DEEPSLATE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DEEPSLATE_PILLAR, Blocks.DEEPSLATE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DEEPSLATE_PILLAR, Blocks.DEEPSLATE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DEEPSLATE_PILLAR, Blocks.DEEPSLATE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DEEPSLATE_PILLAR, Blocks.DEEPSLATE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DEEPSLATE_PILLAR, Blocks.DEEPSLATE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DEEPSLATE_PILLAR, Blocks.POLISHED_DEEPSLATE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DEEPSLATE_PILLAR, Blocks.POLISHED_DEEPSLATE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_BRICKS, Blocks.GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_BRICK_SLAB, Blocks.GRANITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_BRICK_STAIRS, Blocks.GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_BRICK_WALL, Blocks.GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_GRANITE_BRICKS, Blocks.GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_BRICK_SLAB, GRANITE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_BRICK_STAIRS, GRANITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_BRICK_WALL, GRANITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_GRANITE_BRICKS, GRANITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_TILES, Blocks.GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_TILE_SLAB, Blocks.GRANITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_TILE_STAIRS, Blocks.GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_TILE_WALL, Blocks.GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_GRANITE_TILES, Blocks.GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_TILE_SLAB, GRANITE_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_TILE_STAIRS, GRANITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_TILE_WALL, GRANITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_GRANITE_TILES, GRANITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_GRANITE_WALL, Blocks.GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_GRANITE_WALL, Blocks.POLISHED_GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GRANITE, Blocks.GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_PILLAR, Blocks.GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GRANITE_PILLAR, Blocks.GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GRANITE, GRANITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_PILLAR, GRANITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GRANITE_PILLAR, GRANITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GRANITE, GRANITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_PILLAR, GRANITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GRANITE_PILLAR, GRANITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GRANITE, Blocks.POLISHED_GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRANITE_PILLAR, Blocks.POLISHED_GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GRANITE_PILLAR, Blocks.POLISHED_GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_BRICKS, Blocks.ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_BRICK_SLAB, Blocks.ANDESITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_BRICK_STAIRS, Blocks.ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_BRICK_WALL, Blocks.ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_ANDESITE_BRICKS, Blocks.ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_BRICK_SLAB, ANDESITE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_BRICK_STAIRS, ANDESITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_BRICK_WALL, ANDESITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_ANDESITE_BRICKS, ANDESITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_TILES, Blocks.ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_TILE_SLAB, Blocks.ANDESITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_TILE_STAIRS, Blocks.ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_TILE_WALL, Blocks.ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_ANDESITE_TILES, Blocks.ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_TILE_SLAB, ANDESITE_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_TILE_STAIRS, ANDESITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_TILE_WALL, ANDESITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_ANDESITE_TILES, ANDESITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_ANDESITE_WALL, Blocks.ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_ANDESITE_WALL, Blocks.POLISHED_ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_ANDESITE, Blocks.ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_PILLAR, Blocks.ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_ANDESITE_PILLAR, Blocks.ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_ANDESITE, ANDESITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_PILLAR, ANDESITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_ANDESITE_PILLAR, ANDESITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_ANDESITE, ANDESITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_PILLAR, ANDESITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_ANDESITE_PILLAR, ANDESITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_ANDESITE, Blocks.POLISHED_ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ANDESITE_PILLAR, Blocks.POLISHED_ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_ANDESITE_PILLAR, Blocks.POLISHED_ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_BRICKS, Blocks.DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_BRICK_SLAB, Blocks.DIORITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_BRICK_STAIRS, Blocks.DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_BRICK_WALL, Blocks.DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_DIORITE_BRICKS, Blocks.DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_BRICK_SLAB, DIORITE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_BRICK_STAIRS, DIORITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_BRICK_WALL, DIORITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_DIORITE_BRICKS, DIORITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_TILES, Blocks.DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_TILE_SLAB, Blocks.DIORITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_TILE_STAIRS, Blocks.DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_TILE_WALL, Blocks.DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_DIORITE_TILES, Blocks.DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_TILE_SLAB, DIORITE_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_TILE_STAIRS, DIORITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_TILE_WALL, DIORITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_DIORITE_TILES, DIORITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_DIORITE_WALL, Blocks.DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_DIORITE_WALL, Blocks.POLISHED_DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DIORITE, Blocks.DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_PILLAR, Blocks.DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DIORITE_PILLAR, Blocks.DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DIORITE, DIORITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_PILLAR, DIORITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DIORITE_PILLAR, DIORITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DIORITE, DIORITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_PILLAR, DIORITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DIORITE_PILLAR, DIORITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DIORITE, Blocks.POLISHED_DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DIORITE_PILLAR, Blocks.POLISHED_DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DIORITE_PILLAR, Blocks.POLISHED_DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.BLACKSTONE_SLAB, Blocks.BLACKSTONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACKSTONE_TILES, Blocks.BLACKSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACKSTONE_TILE_SLAB, Blocks.BLACKSTONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACKSTONE_TILE_STAIRS, Blocks.BLACKSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACKSTONE_TILE_WALL, Blocks.BLACKSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BLACKSTONE_TILES, Blocks.BLACKSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACKSTONE_TILE_SLAB, BLACKSTONE_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACKSTONE_TILE_STAIRS, BLACKSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACKSTONE_TILE_WALL, BLACKSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BLACKSTONE_TILES, BLACKSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACKSTONE_PILLAR, Blocks.BLACKSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLACKSTONE_PILLAR, Blocks.BLACKSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACKSTONE_PILLAR, Blocks.POLISHED_BLACKSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLACKSTONE_PILLAR, Blocks.POLISHED_BLACKSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACKSTONE_PILLAR, BLACKSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLACKSTONE_PILLAR, BLACKSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACKSTONE_PILLAR, Blocks.POLISHED_BLACKSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLACKSTONE_PILLAR, Blocks.POLISHED_BLACKSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, END_STONE_SLAB, Blocks.END_STONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, END_STONE_STAIRS, Blocks.END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, END_STONE_WALL, Blocks.END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_END_STONE_BRICKS, Blocks.END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_END_STONE_BRICKS, Blocks.END_STONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, END_STONE_TILES, Blocks.END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, END_STONE_TILE_SLAB, Blocks.END_STONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, END_STONE_TILE_STAIRS, Blocks.END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, END_STONE_TILE_WALL, Blocks.END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_END_STONE_TILES, Blocks.END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, END_STONE_TILE_SLAB, END_STONE_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, END_STONE_TILE_STAIRS, END_STONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, END_STONE_TILE_WALL, END_STONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_END_STONE_TILES, END_STONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_END_STONE, Blocks.END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_END_STONE_SLAB, Blocks.END_STONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_END_STONE_STAIRS, Blocks.END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_END_STONE_WALL, Blocks.END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_END_STONE_SLAB, POLISHED_END_STONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_END_STONE_STAIRS, POLISHED_END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_END_STONE_WALL, POLISHED_END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_END_STONE, Blocks.END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, END_STONE_PILLAR, Blocks.END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_END_STONE_PILLAR, Blocks.END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_END_STONE, Blocks.END_STONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, END_STONE_PILLAR, Blocks.END_STONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_END_STONE_PILLAR, Blocks.END_STONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_END_STONE, END_STONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, END_STONE_PILLAR, END_STONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_END_STONE_PILLAR, END_STONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_END_STONE, POLISHED_END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, END_STONE_PILLAR, POLISHED_END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_END_STONE_PILLAR, POLISHED_END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPUR_SLAB, PURPUR, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPUR_STAIRS, PURPUR, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPUR_WALL, PURPUR, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_PURPUR_BRICKS, PURPUR, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_PURPUR_BRICKS, PURPUR_BRICKS, 1);
			StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(PURPUR), RecipeCategory.BUILDING_BLOCKS, PURPUR_TILES, 1)
					.criterion(hasItem(PURPUR), conditionsFromItem(PURPUR))
					.offerTo(exporter, "purpur_tiles_from_purpur_stonecutting");
			StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(PURPUR), RecipeCategory.BUILDING_BLOCKS, PURPUR_TILE_SLAB, 2)
					.criterion(hasItem(PURPUR), conditionsFromItem(PURPUR))
					.offerTo(exporter, "purpur_tile_slab_from_purpur_stonecutting");
			StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(PURPUR), RecipeCategory.BUILDING_BLOCKS, PURPUR_TILE_STAIRS, 1)
					.criterion(hasItem(PURPUR), conditionsFromItem(PURPUR))
					.offerTo(exporter, "purpur_tile_stairs_from_purpur_stonecutting");
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPUR_TILE_WALL, PURPUR, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_PURPUR_TILES, PURPUR, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPUR_TILE_WALL, PURPUR_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_PURPUR_TILES, PURPUR_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PURPUR, PURPUR, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PURPUR_SLAB, PURPUR, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PURPUR_STAIRS, PURPUR, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PURPUR_WALL, PURPUR, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PURPUR_SLAB, POLISHED_PURPUR, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PURPUR_STAIRS, POLISHED_PURPUR, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PURPUR_WALL, POLISHED_PURPUR, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PURPUR, PURPUR, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPUR_PILLAR, PURPUR, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PURPUR_PILLAR, PURPUR, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PURPUR, PURPUR_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPUR_PILLAR, PURPUR_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PURPUR_PILLAR, PURPUR_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PURPUR, PURPUR_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PURPUR_PILLAR, PURPUR_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PURPUR, POLISHED_PURPUR, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPUR_PILLAR, POLISHED_PURPUR, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PURPUR_PILLAR, POLISHED_PURPUR, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_BRICKS, Blocks.SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_BRICK_SLAB, Blocks.SANDSTONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_BRICK_STAIRS, Blocks.SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_BRICK_WALL, Blocks.SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_SANDSTONE_BRICKS, Blocks.SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_BRICK_SLAB, SANDSTONE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_BRICK_STAIRS, SANDSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_BRICK_WALL, SANDSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_SANDSTONE_BRICKS, SANDSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_TILES, Blocks.SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_TILE_SLAB, Blocks.SANDSTONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_TILE_STAIRS, Blocks.SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_TILE_WALL, Blocks.SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_SANDSTONE_TILES, Blocks.SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_TILE_SLAB, SANDSTONE_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_TILE_STAIRS, SANDSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_TILE_WALL, SANDSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_SANDSTONE_TILES, SANDSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_PILLAR, Blocks.SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_SANDSTONE_PILLAR, Blocks.SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_SANDSTONE, SANDSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_PILLAR, SANDSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_SANDSTONE_PILLAR, SANDSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_SANDSTONE, SANDSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_PILLAR, SANDSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_SANDSTONE_PILLAR, SANDSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SANDSTONE_PILLAR, Blocks.CUT_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_SANDSTONE_PILLAR, Blocks.CUT_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_BRICKS, Blocks.RED_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_BRICK_SLAB, Blocks.RED_SANDSTONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_BRICK_STAIRS, Blocks.RED_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_BRICK_WALL, Blocks.RED_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_RED_SANDSTONE_BRICKS, Blocks.RED_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_BRICK_SLAB, RED_SANDSTONE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_BRICK_STAIRS, RED_SANDSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_BRICK_WALL, RED_SANDSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_RED_SANDSTONE_BRICKS, RED_SANDSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_TILES, Blocks.RED_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_TILE_SLAB, Blocks.RED_SANDSTONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_TILE_STAIRS, Blocks.RED_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_TILE_WALL, Blocks.RED_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_RED_SANDSTONE_TILES, Blocks.RED_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_TILE_SLAB, RED_SANDSTONE_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_TILE_STAIRS, RED_SANDSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_TILE_WALL, RED_SANDSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_RED_SANDSTONE_TILES, RED_SANDSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_RED_SANDSTONE, Blocks.RED_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_PILLAR, Blocks.RED_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_RED_SANDSTONE_PILLAR, Blocks.RED_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_RED_SANDSTONE, RED_SANDSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_PILLAR, RED_SANDSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_RED_SANDSTONE_PILLAR, RED_SANDSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_RED_SANDSTONE, RED_SANDSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_PILLAR, RED_SANDSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_RED_SANDSTONE_PILLAR, RED_SANDSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_SANDSTONE_PILLAR, Blocks.CUT_RED_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_RED_SANDSTONE_PILLAR, Blocks.CUT_RED_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PRISMARINE_BRICK_WALL, Blocks.PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_PRISMARINE_BRICKS, Blocks.PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PRISMARINE_BRICK_WALL, Blocks.PRISMARINE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_PRISMARINE_BRICKS, Blocks.PRISMARINE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PRISMARINE_TILES, Blocks.PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PRISMARINE_TILE_SLAB, Blocks.PRISMARINE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PRISMARINE_TILE_STAIRS, Blocks.PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PRISMARINE_TILE_WALL, Blocks.PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_PRISMARINE_TILES, Blocks.PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PRISMARINE_TILE_SLAB, PRISMARINE_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PRISMARINE_TILE_STAIRS, PRISMARINE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PRISMARINE_TILE_WALL, PRISMARINE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_PRISMARINE_TILES, PRISMARINE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PRISMARINE, Blocks.PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PRISMARINE_SLAB, Blocks.PRISMARINE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PRISMARINE_STAIRS, Blocks.PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PRISMARINE_WALL, Blocks.PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PRISMARINE_SLAB, POLISHED_PRISMARINE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PRISMARINE_STAIRS, POLISHED_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PRISMARINE_WALL, POLISHED_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PRISMARINE, Blocks.PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PRISMARINE_PILLAR, Blocks.PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PRISMARINE_PILLAR, Blocks.PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PRISMARINE, Blocks.PRISMARINE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PRISMARINE_PILLAR, Blocks.PRISMARINE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PRISMARINE_PILLAR, Blocks.PRISMARINE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PRISMARINE, PRISMARINE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PRISMARINE_PILLAR, PRISMARINE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PRISMARINE_PILLAR, PRISMARINE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PRISMARINE, POLISHED_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PRISMARINE_PILLAR, POLISHED_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PRISMARINE_PILLAR, POLISHED_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SMOOTH_DARK_PRISMARINE_SLAB, SMOOTH_DARK_PRISMARINE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SMOOTH_DARK_PRISMARINE_STAIRS, SMOOTH_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SMOOTH_DARK_PRISMARINE_WALL, SMOOTH_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DARK_PRISMARINE_BRICKS, SMOOTH_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DARK_PRISMARINE_BRICK_SLAB, SMOOTH_DARK_PRISMARINE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DARK_PRISMARINE_BRICK_STAIRS, SMOOTH_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DARK_PRISMARINE_BRICK_WALL, SMOOTH_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_DARK_PRISMARINE_BRICKS, SMOOTH_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DARK_PRISMARINE_BRICK_SLAB, DARK_PRISMARINE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DARK_PRISMARINE_BRICK_STAIRS, DARK_PRISMARINE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DARK_PRISMARINE_BRICK_WALL, DARK_PRISMARINE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_DARK_PRISMARINE_BRICKS, DARK_PRISMARINE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.DARK_PRISMARINE, SMOOTH_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.DARK_PRISMARINE_SLAB, SMOOTH_DARK_PRISMARINE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.DARK_PRISMARINE_STAIRS, SMOOTH_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DARK_PRISMARINE_TILE_WALL, SMOOTH_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_DARK_PRISMARINE_TILES, SMOOTH_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_DARK_PRISMARINE, SMOOTH_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_DARK_PRISMARINE_SLAB, SMOOTH_DARK_PRISMARINE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_DARK_PRISMARINE_STAIRS, SMOOTH_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_DARK_PRISMARINE_WALL, SMOOTH_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_DARK_PRISMARINE_SLAB, POLISHED_DARK_PRISMARINE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_DARK_PRISMARINE_STAIRS, POLISHED_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_DARK_PRISMARINE_WALL, POLISHED_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DARK_PRISMARINE, SMOOTH_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DARK_PRISMARINE_PILLAR, SMOOTH_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DARK_PRISMARINE_PILLAR, SMOOTH_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DARK_PRISMARINE, DARK_PRISMARINE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DARK_PRISMARINE_PILLAR, DARK_PRISMARINE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DARK_PRISMARINE_PILLAR, DARK_PRISMARINE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DARK_PRISMARINE, POLISHED_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DARK_PRISMARINE_PILLAR, POLISHED_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DARK_PRISMARINE_PILLAR, POLISHED_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DARK_PRISMARINE, Blocks.DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DARK_PRISMARINE_PILLAR, Blocks.DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DARK_PRISMARINE_PILLAR, Blocks.DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, HARDENED_NETHERRACK_SLAB, HARDENED_NETHERRACK, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, HARDENED_NETHERRACK_STAIRS, HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, HARDENED_NETHERRACK_WALL, HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.NETHER_BRICKS, HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.NETHER_BRICK_SLAB, HARDENED_NETHERRACK, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.NETHER_BRICK_STAIRS, HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHER_BRICK_WALL, HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CRACKED_NETHER_BRICKS, HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHER_BRICK_WALL, Blocks.NETHER_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHER_TILES, HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHER_TILE_SLAB, HARDENED_NETHERRACK, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHER_TILE_STAIRS, HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHER_TILE_WALL, HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_NETHER_TILES, HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHER_TILE_SLAB, NETHER_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHER_TILE_STAIRS, NETHER_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHER_TILE_WALL, NETHER_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_NETHER_TILES, NETHER_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_HARDENED_NETHERRACK, HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_HARDENED_NETHERRACK_SLAB, HARDENED_NETHERRACK, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_HARDENED_NETHERRACK_STAIRS, HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_HARDENED_NETHERRACK_WALL, HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_HARDENED_NETHERRACK_SLAB, POLISHED_HARDENED_NETHERRACK, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_HARDENED_NETHERRACK_STAIRS, POLISHED_HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_HARDENED_NETHERRACK_WALL, POLISHED_HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_NETHER_BRICKS, HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHER_PILLAR, HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_NETHER_PILLAR, HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_NETHER_BRICKS, Blocks.NETHER_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHER_PILLAR, Blocks.NETHER_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_NETHER_PILLAR, Blocks.NETHER_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_NETHER_BRICKS, NETHER_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHER_PILLAR, NETHER_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_NETHER_PILLAR, NETHER_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.CHISELED_NETHER_BRICKS, POLISHED_HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHER_PILLAR, POLISHED_HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_NETHER_PILLAR, POLISHED_HARDENED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SMOOTH_BASALT_SLAB, Blocks.SMOOTH_BASALT, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SMOOTH_BASALT_STAIRS, Blocks.SMOOTH_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SMOOTH_BASALT_WALL, Blocks.SMOOTH_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_BRICKS, Blocks.SMOOTH_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_BRICK_SLAB, Blocks.SMOOTH_BASALT, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_BRICK_STAIRS, Blocks.SMOOTH_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_BRICK_WALL, Blocks.SMOOTH_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BASALT_BRICKS, Blocks.SMOOTH_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_BRICK_SLAB, BASALT_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_BRICK_STAIRS, BASALT_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_BRICK_WALL, BASALT_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BASALT_BRICKS, BASALT_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_TILES, Blocks.SMOOTH_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_TILE_SLAB, Blocks.SMOOTH_BASALT, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_TILE_STAIRS, Blocks.SMOOTH_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_TILE_WALL, Blocks.SMOOTH_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BASALT_TILES, Blocks.SMOOTH_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_TILE_SLAB, BASALT_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_TILE_STAIRS, BASALT_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_TILE_WALL, BASALT_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BASALT_TILES, BASALT_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BASALT, Blocks.SMOOTH_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BASALT_SLAB, Blocks.SMOOTH_BASALT, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BASALT_STAIRS, Blocks.SMOOTH_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BASALT_WALL, Blocks.SMOOTH_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BASALT_SLAB, POLISHED_BASALT, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BASALT_STAIRS, POLISHED_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BASALT_WALL, POLISHED_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BASALT, Blocks.SMOOTH_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BASALT_PILLAR, Blocks.SMOOTH_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BASALT, BASALT_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_BASALT, BASALT_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BASALT_PILLAR, BASALT_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BASALT, BASALT_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_BASALT, BASALT_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BASALT_PILLAR, BASALT_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BASALT, POLISHED_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.POLISHED_BASALT, POLISHED_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BASALT_PILLAR, POLISHED_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_SLAB, Blocks.CALCITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_STAIRS, Blocks.CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_WALL, Blocks.CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_BRICKS, Blocks.CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_BRICK_SLAB, Blocks.CALCITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_BRICK_STAIRS, Blocks.CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_BRICK_WALL, Blocks.CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_CALCITE_BRICKS, Blocks.CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_BRICK_SLAB, CALCITE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_BRICK_STAIRS, CALCITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_BRICK_WALL, CALCITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_CALCITE_BRICKS, CALCITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_TILES, Blocks.CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_TILE_SLAB, Blocks.CALCITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_TILE_STAIRS, Blocks.CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_TILE_WALL, Blocks.CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_CALCITE_TILES, Blocks.CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_TILE_SLAB, CALCITE_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_TILE_STAIRS, CALCITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_TILE_WALL, CALCITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_CALCITE_TILES, CALCITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_CALCITE, Blocks.CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_CALCITE_SLAB, Blocks.CALCITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_CALCITE_STAIRS, Blocks.CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_CALCITE_WALL, Blocks.CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_CALCITE_SLAB, POLISHED_CALCITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_CALCITE_STAIRS, POLISHED_CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_CALCITE_WALL, POLISHED_CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_CALCITE, Blocks.CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_PILLAR, Blocks.CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_CALCITE_PILLAR, Blocks.CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_CALCITE, CALCITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_PILLAR, CALCITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_CALCITE_PILLAR, CALCITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_CALCITE, CALCITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_PILLAR, CALCITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_CALCITE_PILLAR, CALCITE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_CALCITE, POLISHED_CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CALCITE_PILLAR, POLISHED_CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_CALCITE_PILLAR, POLISHED_CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_SLAB, Blocks.DRIPSTONE_BLOCK, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_STAIRS, Blocks.DRIPSTONE_BLOCK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_WALL, Blocks.DRIPSTONE_BLOCK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_BRICKS, Blocks.DRIPSTONE_BLOCK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_BRICK_SLAB, Blocks.DRIPSTONE_BLOCK, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_BRICK_STAIRS, Blocks.DRIPSTONE_BLOCK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_BRICK_WALL, Blocks.DRIPSTONE_BLOCK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_DRIPSTONE_BRICKS, Blocks.DRIPSTONE_BLOCK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_BRICK_SLAB, DRIPSTONE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_BRICK_STAIRS, DRIPSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_BRICK_WALL, DRIPSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_DRIPSTONE_BRICKS, DRIPSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_TILES, Blocks.DRIPSTONE_BLOCK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_TILE_SLAB, Blocks.DRIPSTONE_BLOCK, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_TILE_STAIRS, Blocks.DRIPSTONE_BLOCK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_TILE_WALL, Blocks.DRIPSTONE_BLOCK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_DRIPSTONE_TILES, Blocks.DRIPSTONE_BLOCK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_TILE_SLAB, DRIPSTONE_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_TILE_STAIRS, DRIPSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_TILE_WALL, DRIPSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_DRIPSTONE_TILES, DRIPSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_DRIPSTONE_SLAB, Blocks.DRIPSTONE_BLOCK, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_DRIPSTONE_STAIRS, Blocks.DRIPSTONE_BLOCK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_DRIPSTONE_WALL, Blocks.DRIPSTONE_BLOCK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_DRIPSTONE_SLAB, POLISHED_DRIPSTONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_DRIPSTONE_STAIRS, POLISHED_DRIPSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_DRIPSTONE_WALL, POLISHED_DRIPSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DRIPSTONE, Blocks.DRIPSTONE_BLOCK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_PILLAR, Blocks.DRIPSTONE_BLOCK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DRIPSTONE_PILLAR, Blocks.DRIPSTONE_BLOCK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DRIPSTONE, DRIPSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_PILLAR, DRIPSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DRIPSTONE_PILLAR, DRIPSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DRIPSTONE, DRIPSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_PILLAR, DRIPSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DRIPSTONE_PILLAR, DRIPSTONE_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DRIPSTONE, POLISHED_DRIPSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DRIPSTONE_PILLAR, POLISHED_DRIPSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_DRIPSTONE_PILLAR, POLISHED_DRIPSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PACKED_MUD_SLAB, Blocks.PACKED_MUD, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PACKED_MUD_STAIRS, Blocks.PACKED_MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PACKED_MUD_WALL, Blocks.PACKED_MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_MUD_BRICKS, Blocks.PACKED_MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_MUD_BRICKS, Blocks.MUD_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MUD_TILES, Blocks.MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MUD_TILE_SLAB, Blocks.MUD, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MUD_TILE_STAIRS, Blocks.MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MUD_TILE_WALL, Blocks.MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_MUD_TILES, Blocks.MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MUD_TILE_SLAB, MUD_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MUD_TILE_STAIRS, MUD_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MUD_TILE_WALL, MUD_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_MUD_TILES, MUD_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PACKED_MUD, Blocks.MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PACKED_MUD_SLAB, Blocks.MUD, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PACKED_MUD_STAIRS, Blocks.MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PACKED_MUD_WALL, Blocks.MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PACKED_MUD_SLAB, POLISHED_PACKED_MUD, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PACKED_MUD_STAIRS, POLISHED_PACKED_MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PACKED_MUD_WALL, POLISHED_PACKED_MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PACKED_MUD, Blocks.MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PACKED_MUD_PILLAR, Blocks.MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_MUD_PILLAR, Blocks.MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PACKED_MUD, Blocks.MUD_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PACKED_MUD_PILLAR, Blocks.MUD_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_MUD_PILLAR, Blocks.MUD_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PACKED_MUD, MUD_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PACKED_MUD_PILLAR, MUD_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_MUD_PILLAR, MUD_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PACKED_MUD, POLISHED_PACKED_MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PACKED_MUD_PILLAR, POLISHED_PACKED_MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_MUD_PILLAR, POLISHED_PACKED_MUD, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_SLAB, Blocks.TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_STAIRS, Blocks.TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_WALL, Blocks.TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.BRICKS, Blocks.TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.BRICK_SLAB, Blocks.TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.BRICK_STAIRS, Blocks.TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, Blocks.BRICK_WALL, Blocks.TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BRICKS, Blocks.TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BRICKS, Blocks.BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_TILES, Blocks.TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_TILE_SLAB, Blocks.TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_TILE_STAIRS, Blocks.TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_TILE_WALL, Blocks.TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_TERRACOTTA_TILES, Blocks.TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_TILE_SLAB, TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_TILE_STAIRS, TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_TILE_WALL, TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_TERRACOTTA_TILES, TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_TERRACOTTA, Blocks.TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_TERRACOTTA_SLAB, Blocks.TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_TERRACOTTA_STAIRS, Blocks.TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_TERRACOTTA_WALL, Blocks.TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_TERRACOTTA_SLAB, POLISHED_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_TERRACOTTA_STAIRS, POLISHED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_TERRACOTTA_WALL, POLISHED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_TERRACOTTA, Blocks.TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_PILLAR, Blocks.TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_TERRACOTTA_PILLAR, Blocks.TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_TERRACOTTA, Blocks.BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_PILLAR, Blocks.BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_TERRACOTTA_PILLAR, Blocks.BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_TERRACOTTA, TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_PILLAR, TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_TERRACOTTA_PILLAR, TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_TERRACOTTA, POLISHED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, TERRACOTTA_PILLAR, POLISHED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_TERRACOTTA_PILLAR, POLISHED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_SLAB, Blocks.RED_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_STAIRS, Blocks.RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_WALL, Blocks.RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_BRICKS, Blocks.RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_BRICK_SLAB, Blocks.RED_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_BRICK_STAIRS, Blocks.RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_BRICK_WALL, Blocks.RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_RED_TERRACOTTA_BRICKS, Blocks.RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_BRICK_SLAB, RED_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_BRICK_STAIRS, RED_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_BRICK_WALL, RED_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_RED_TERRACOTTA_BRICKS, RED_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_TILES, Blocks.RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_TILE_SLAB, Blocks.RED_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_TILE_STAIRS, Blocks.RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_TILE_WALL, Blocks.RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_RED_TERRACOTTA_TILES, Blocks.RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_TILE_SLAB, RED_TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_TILE_STAIRS, RED_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_TILE_WALL, RED_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_RED_TERRACOTTA_TILES, RED_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_RED_TERRACOTTA, Blocks.RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_RED_TERRACOTTA_SLAB, Blocks.RED_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_RED_TERRACOTTA_STAIRS, Blocks.RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_RED_TERRACOTTA_WALL, Blocks.RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_RED_TERRACOTTA_SLAB, POLISHED_RED_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_RED_TERRACOTTA_STAIRS, POLISHED_RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_RED_TERRACOTTA_WALL, POLISHED_RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_RED_TERRACOTTA, Blocks.RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_PILLAR, Blocks.RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_RED_TERRACOTTA_PILLAR, Blocks.RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_RED_TERRACOTTA, RED_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_PILLAR, RED_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_RED_TERRACOTTA_PILLAR, RED_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_RED_TERRACOTTA, RED_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_PILLAR, RED_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_RED_TERRACOTTA_PILLAR, RED_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_RED_TERRACOTTA, POLISHED_RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, RED_TERRACOTTA_PILLAR, POLISHED_RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_RED_TERRACOTTA_PILLAR, POLISHED_RED_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_SLAB, Blocks.ORANGE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_STAIRS, Blocks.ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_WALL, Blocks.ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_BRICKS, Blocks.ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_BRICK_SLAB, Blocks.ORANGE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_BRICK_STAIRS, Blocks.ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_BRICK_WALL, Blocks.ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_ORANGE_TERRACOTTA_BRICKS, Blocks.ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_BRICK_SLAB, ORANGE_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_BRICK_STAIRS, ORANGE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_BRICK_WALL, ORANGE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_ORANGE_TERRACOTTA_BRICKS, ORANGE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_TILES, Blocks.ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_TILE_SLAB, Blocks.ORANGE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_TILE_STAIRS, Blocks.ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_TILE_WALL, Blocks.ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_ORANGE_TERRACOTTA_TILES, Blocks.ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_TILE_SLAB, ORANGE_TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_TILE_STAIRS, ORANGE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_TILE_WALL, ORANGE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_ORANGE_TERRACOTTA_TILES, ORANGE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_ORANGE_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_ORANGE_TERRACOTTA_SLAB, Blocks.ORANGE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_ORANGE_TERRACOTTA_STAIRS, Blocks.ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_ORANGE_TERRACOTTA_WALL, Blocks.ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_ORANGE_TERRACOTTA_SLAB, POLISHED_ORANGE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_ORANGE_TERRACOTTA_STAIRS, POLISHED_ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_ORANGE_TERRACOTTA_WALL, POLISHED_ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_ORANGE_TERRACOTTA, Blocks.ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_PILLAR, Blocks.ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_ORANGE_TERRACOTTA_PILLAR, Blocks.ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_ORANGE_TERRACOTTA, ORANGE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_PILLAR, ORANGE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_ORANGE_TERRACOTTA_PILLAR, ORANGE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_ORANGE_TERRACOTTA, ORANGE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_PILLAR, ORANGE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_ORANGE_TERRACOTTA_PILLAR, ORANGE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_ORANGE_TERRACOTTA, POLISHED_ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ORANGE_TERRACOTTA_PILLAR, POLISHED_ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_ORANGE_TERRACOTTA_PILLAR, POLISHED_ORANGE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_SLAB, Blocks.YELLOW_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_STAIRS, Blocks.YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_WALL, Blocks.YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_BRICKS, Blocks.YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_BRICK_SLAB, Blocks.YELLOW_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_BRICK_STAIRS, Blocks.YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_BRICK_WALL, Blocks.YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_YELLOW_TERRACOTTA_BRICKS, Blocks.YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_BRICK_SLAB, YELLOW_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_BRICK_STAIRS, YELLOW_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_BRICK_WALL, YELLOW_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_YELLOW_TERRACOTTA_BRICKS, YELLOW_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_TILES, Blocks.YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_TILE_SLAB, Blocks.YELLOW_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_TILE_STAIRS, Blocks.YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_TILE_WALL, Blocks.YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_YELLOW_TERRACOTTA_TILES, Blocks.YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_TILE_SLAB, YELLOW_TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_TILE_STAIRS, YELLOW_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_TILE_WALL, YELLOW_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_YELLOW_TERRACOTTA_TILES, YELLOW_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_YELLOW_TERRACOTTA, Blocks.YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_YELLOW_TERRACOTTA_SLAB, Blocks.YELLOW_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_YELLOW_TERRACOTTA_STAIRS, Blocks.YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_YELLOW_TERRACOTTA_WALL, Blocks.YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_YELLOW_TERRACOTTA_SLAB, POLISHED_YELLOW_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_YELLOW_TERRACOTTA_STAIRS, POLISHED_YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_YELLOW_TERRACOTTA_WALL, POLISHED_YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_YELLOW_TERRACOTTA, Blocks.YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_PILLAR, Blocks.YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_YELLOW_TERRACOTTA_PILLAR, Blocks.YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_YELLOW_TERRACOTTA, YELLOW_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_PILLAR, YELLOW_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_YELLOW_TERRACOTTA_PILLAR, YELLOW_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_YELLOW_TERRACOTTA, YELLOW_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_PILLAR, YELLOW_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_YELLOW_TERRACOTTA_PILLAR, YELLOW_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_YELLOW_TERRACOTTA, POLISHED_YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, YELLOW_TERRACOTTA_PILLAR, POLISHED_YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_YELLOW_TERRACOTTA_PILLAR, POLISHED_YELLOW_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_SLAB, Blocks.LIME_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_STAIRS, Blocks.LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_WALL, Blocks.LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_BRICKS, Blocks.LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_BRICK_SLAB, Blocks.LIME_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_BRICK_STAIRS, Blocks.LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_BRICK_WALL, Blocks.LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_LIME_TERRACOTTA_BRICKS, Blocks.LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_BRICK_SLAB, LIME_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_BRICK_STAIRS, LIME_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_BRICK_WALL, LIME_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_LIME_TERRACOTTA_BRICKS, LIME_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_TILES, Blocks.LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_TILE_SLAB, Blocks.LIME_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_TILE_STAIRS, Blocks.LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_TILE_WALL, Blocks.LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_LIME_TERRACOTTA_TILES, Blocks.LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_TILE_SLAB, LIME_TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_TILE_STAIRS, LIME_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_TILE_WALL, LIME_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_LIME_TERRACOTTA_TILES, LIME_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIME_TERRACOTTA, Blocks.LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIME_TERRACOTTA_SLAB, Blocks.LIME_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIME_TERRACOTTA_STAIRS, Blocks.LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIME_TERRACOTTA_WALL, Blocks.LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIME_TERRACOTTA_SLAB, POLISHED_LIME_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIME_TERRACOTTA_STAIRS, POLISHED_LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIME_TERRACOTTA_WALL, POLISHED_LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIME_TERRACOTTA, Blocks.LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_PILLAR, Blocks.LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIME_TERRACOTTA_PILLAR, Blocks.LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIME_TERRACOTTA, LIME_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_PILLAR, LIME_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIME_TERRACOTTA_PILLAR, LIME_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIME_TERRACOTTA, LIME_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_PILLAR, LIME_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIME_TERRACOTTA_PILLAR, LIME_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIME_TERRACOTTA, POLISHED_LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIME_TERRACOTTA_PILLAR, POLISHED_LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIME_TERRACOTTA_PILLAR, POLISHED_LIME_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_SLAB, Blocks.GREEN_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_STAIRS, Blocks.GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_WALL, Blocks.GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_BRICKS, Blocks.GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_BRICK_SLAB, Blocks.GREEN_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_BRICK_STAIRS, Blocks.GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_BRICK_WALL, Blocks.GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_GREEN_TERRACOTTA_BRICKS, Blocks.GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_BRICK_SLAB, GREEN_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_BRICK_STAIRS, GREEN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_BRICK_WALL, GREEN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_GREEN_TERRACOTTA_BRICKS, GREEN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_TILES, Blocks.GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_TILE_SLAB, Blocks.GREEN_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_TILE_STAIRS, Blocks.GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_TILE_WALL, Blocks.GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_GREEN_TERRACOTTA_TILES, Blocks.GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_TILE_SLAB, GREEN_TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_TILE_STAIRS, GREEN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_TILE_WALL, GREEN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_GREEN_TERRACOTTA_TILES, GREEN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_GREEN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_GREEN_TERRACOTTA_SLAB, Blocks.GREEN_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_GREEN_TERRACOTTA_STAIRS, Blocks.GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_GREEN_TERRACOTTA_WALL, Blocks.GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_GREEN_TERRACOTTA_SLAB, POLISHED_GREEN_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_GREEN_TERRACOTTA_STAIRS, POLISHED_GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_GREEN_TERRACOTTA_WALL, POLISHED_GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GREEN_TERRACOTTA, Blocks.GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_PILLAR, Blocks.GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GREEN_TERRACOTTA_PILLAR, Blocks.GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GREEN_TERRACOTTA, GREEN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_PILLAR, GREEN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GREEN_TERRACOTTA_PILLAR, GREEN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GREEN_TERRACOTTA, GREEN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_PILLAR, GREEN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GREEN_TERRACOTTA_PILLAR, GREEN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GREEN_TERRACOTTA, POLISHED_GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GREEN_TERRACOTTA_PILLAR, POLISHED_GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GREEN_TERRACOTTA_PILLAR, POLISHED_GREEN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_SLAB, Blocks.CYAN_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_STAIRS, Blocks.CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_WALL, Blocks.CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_BRICKS, Blocks.CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_BRICK_SLAB, Blocks.CYAN_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_BRICK_STAIRS, Blocks.CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_BRICK_WALL, Blocks.CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_CYAN_TERRACOTTA_BRICKS, Blocks.CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_BRICK_SLAB, CYAN_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_BRICK_STAIRS, CYAN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_BRICK_WALL, CYAN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_CYAN_TERRACOTTA_BRICKS, CYAN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_TILES, Blocks.CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_TILE_SLAB, Blocks.CYAN_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_TILE_STAIRS, Blocks.CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_TILE_WALL, Blocks.CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_CYAN_TERRACOTTA_TILES, Blocks.CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_TILE_SLAB, CYAN_TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_TILE_STAIRS, CYAN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_TILE_WALL, CYAN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_CYAN_TERRACOTTA_TILES, CYAN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_CYAN_TERRACOTTA, Blocks.CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_CYAN_TERRACOTTA_SLAB, Blocks.CYAN_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_CYAN_TERRACOTTA_STAIRS, Blocks.CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_CYAN_TERRACOTTA_WALL, Blocks.CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_CYAN_TERRACOTTA_SLAB, POLISHED_CYAN_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_CYAN_TERRACOTTA_STAIRS, POLISHED_CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_CYAN_TERRACOTTA_WALL, POLISHED_CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_CYAN_TERRACOTTA, Blocks.CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_PILLAR, Blocks.CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_CYAN_TERRACOTTA_PILLAR, Blocks.CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_CYAN_TERRACOTTA, CYAN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_PILLAR, CYAN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_CYAN_TERRACOTTA_PILLAR, CYAN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_CYAN_TERRACOTTA, CYAN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_PILLAR, CYAN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_CYAN_TERRACOTTA_PILLAR, CYAN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_CYAN_TERRACOTTA, POLISHED_CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CYAN_TERRACOTTA_PILLAR, POLISHED_CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_CYAN_TERRACOTTA_PILLAR, POLISHED_CYAN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_SLAB, Blocks.LIGHT_BLUE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_STAIRS, Blocks.LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_WALL, Blocks.LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_BRICKS, Blocks.LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_BRICK_SLAB, Blocks.LIGHT_BLUE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS, Blocks.LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_BRICK_WALL, Blocks.LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_LIGHT_BLUE_TERRACOTTA_BRICKS, Blocks.LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_BRICK_SLAB, LIGHT_BLUE_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS, LIGHT_BLUE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_BRICK_WALL, LIGHT_BLUE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_LIGHT_BLUE_TERRACOTTA_BRICKS, LIGHT_BLUE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_TILES, Blocks.LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_TILE_SLAB, Blocks.LIGHT_BLUE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_TILE_STAIRS, Blocks.LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_TILE_WALL, Blocks.LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_LIGHT_BLUE_TERRACOTTA_TILES, Blocks.LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_TILE_SLAB, LIGHT_BLUE_TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_TILE_STAIRS, LIGHT_BLUE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_TILE_WALL, LIGHT_BLUE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_LIGHT_BLUE_TERRACOTTA_TILES, LIGHT_BLUE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIGHT_BLUE_TERRACOTTA_SLAB, Blocks.LIGHT_BLUE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIGHT_BLUE_TERRACOTTA_STAIRS, Blocks.LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIGHT_BLUE_TERRACOTTA_WALL, Blocks.LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIGHT_BLUE_TERRACOTTA_SLAB, POLISHED_LIGHT_BLUE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIGHT_BLUE_TERRACOTTA_STAIRS, POLISHED_LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIGHT_BLUE_TERRACOTTA_WALL, POLISHED_LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIGHT_BLUE_TERRACOTTA, Blocks.LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_PILLAR, Blocks.LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIGHT_BLUE_TERRACOTTA_PILLAR, Blocks.LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIGHT_BLUE_TERRACOTTA, LIGHT_BLUE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_PILLAR, LIGHT_BLUE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIGHT_BLUE_TERRACOTTA_PILLAR, LIGHT_BLUE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIGHT_BLUE_TERRACOTTA, LIGHT_BLUE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_PILLAR, LIGHT_BLUE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIGHT_BLUE_TERRACOTTA_PILLAR, LIGHT_BLUE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIGHT_BLUE_TERRACOTTA, POLISHED_LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_BLUE_TERRACOTTA_PILLAR, POLISHED_LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIGHT_BLUE_TERRACOTTA_PILLAR, POLISHED_LIGHT_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_SLAB, Blocks.BLUE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_STAIRS, Blocks.BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_WALL, Blocks.BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_BRICKS, Blocks.BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_BRICK_SLAB, Blocks.BLUE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_BRICK_STAIRS, Blocks.BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_BRICK_WALL, Blocks.BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BLUE_TERRACOTTA_BRICKS, Blocks.BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_BRICK_SLAB, BLUE_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_BRICK_STAIRS, BLUE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_BRICK_WALL, BLUE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BLUE_TERRACOTTA_BRICKS, BLUE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_TILES, Blocks.BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_TILE_SLAB, Blocks.BLUE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_TILE_STAIRS, Blocks.BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_TILE_WALL, Blocks.BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BLUE_TERRACOTTA_TILES, Blocks.BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_TILE_SLAB, BLUE_TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_TILE_STAIRS, BLUE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_TILE_WALL, BLUE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BLUE_TERRACOTTA_TILES, BLUE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BLUE_TERRACOTTA, Blocks.BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BLUE_TERRACOTTA_SLAB, Blocks.BLUE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BLUE_TERRACOTTA_STAIRS, Blocks.BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BLUE_TERRACOTTA_WALL, Blocks.BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BLUE_TERRACOTTA_SLAB, POLISHED_BLUE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BLUE_TERRACOTTA_STAIRS, POLISHED_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BLUE_TERRACOTTA_WALL, POLISHED_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLUE_TERRACOTTA, Blocks.BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_PILLAR, Blocks.BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLUE_TERRACOTTA_PILLAR, Blocks.BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLUE_TERRACOTTA, BLUE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_PILLAR, BLUE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLUE_TERRACOTTA_PILLAR, BLUE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLUE_TERRACOTTA, BLUE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_PILLAR, BLUE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLUE_TERRACOTTA_PILLAR, BLUE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLUE_TERRACOTTA, POLISHED_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLUE_TERRACOTTA_PILLAR, POLISHED_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLUE_TERRACOTTA_PILLAR, POLISHED_BLUE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_SLAB, Blocks.PURPLE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_STAIRS, Blocks.PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_WALL, Blocks.PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_BRICKS, Blocks.PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_BRICK_SLAB, Blocks.PURPLE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_BRICK_STAIRS, Blocks.PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_BRICK_WALL, Blocks.PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_PURPLE_TERRACOTTA_BRICKS, Blocks.PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_BRICK_SLAB, PURPLE_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_BRICK_STAIRS, PURPLE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_BRICK_WALL, PURPLE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_PURPLE_TERRACOTTA_BRICKS, PURPLE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_TILES, Blocks.PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_TILE_SLAB, Blocks.PURPLE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_TILE_STAIRS, Blocks.PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_TILE_WALL, Blocks.PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_PURPLE_TERRACOTTA_TILES, Blocks.PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_TILE_SLAB, PURPLE_TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_TILE_STAIRS, PURPLE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_TILE_WALL, PURPLE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_PURPLE_TERRACOTTA_TILES, PURPLE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PURPLE_TERRACOTTA, Blocks.PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PURPLE_TERRACOTTA_SLAB, Blocks.PURPLE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PURPLE_TERRACOTTA_STAIRS, Blocks.PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PURPLE_TERRACOTTA_WALL, Blocks.PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PURPLE_TERRACOTTA_SLAB, POLISHED_PURPLE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PURPLE_TERRACOTTA_STAIRS, POLISHED_PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PURPLE_TERRACOTTA_WALL, POLISHED_PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PURPLE_TERRACOTTA, Blocks.PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_PILLAR, Blocks.PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PURPLE_TERRACOTTA_PILLAR, Blocks.PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PURPLE_TERRACOTTA, PURPLE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_PILLAR, PURPLE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PURPLE_TERRACOTTA_PILLAR, PURPLE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PURPLE_TERRACOTTA, PURPLE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_PILLAR, PURPLE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PURPLE_TERRACOTTA_PILLAR, PURPLE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PURPLE_TERRACOTTA, POLISHED_PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PURPLE_TERRACOTTA_PILLAR, POLISHED_PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PURPLE_TERRACOTTA_PILLAR, POLISHED_PURPLE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_SLAB, Blocks.MAGENTA_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_STAIRS, Blocks.MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_WALL, Blocks.MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_BRICKS, Blocks.MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_BRICK_SLAB, Blocks.MAGENTA_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_BRICK_STAIRS, Blocks.MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_BRICK_WALL, Blocks.MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_MAGENTA_TERRACOTTA_BRICKS, Blocks.MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_BRICK_SLAB, MAGENTA_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_BRICK_STAIRS, MAGENTA_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_BRICK_WALL, MAGENTA_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_MAGENTA_TERRACOTTA_BRICKS, MAGENTA_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_TILES, Blocks.MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_TILE_SLAB, Blocks.MAGENTA_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_TILE_STAIRS, Blocks.MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_TILE_WALL, Blocks.MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_MAGENTA_TERRACOTTA_TILES, Blocks.MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_TILE_SLAB, MAGENTA_TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_TILE_STAIRS, MAGENTA_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_TILE_WALL, MAGENTA_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_MAGENTA_TERRACOTTA_TILES, MAGENTA_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_MAGENTA_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_MAGENTA_TERRACOTTA_SLAB, Blocks.MAGENTA_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_MAGENTA_TERRACOTTA_STAIRS, Blocks.MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_MAGENTA_TERRACOTTA_WALL, Blocks.MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_MAGENTA_TERRACOTTA_SLAB, POLISHED_MAGENTA_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_MAGENTA_TERRACOTTA_STAIRS, POLISHED_MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_MAGENTA_TERRACOTTA_WALL, POLISHED_MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_MAGENTA_TERRACOTTA, Blocks.MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_PILLAR, Blocks.MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_MAGENTA_TERRACOTTA_PILLAR, Blocks.MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_MAGENTA_TERRACOTTA, MAGENTA_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_PILLAR, MAGENTA_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_MAGENTA_TERRACOTTA_PILLAR, MAGENTA_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_MAGENTA_TERRACOTTA, MAGENTA_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_PILLAR, MAGENTA_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_MAGENTA_TERRACOTTA_PILLAR, MAGENTA_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_MAGENTA_TERRACOTTA, POLISHED_MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MAGENTA_TERRACOTTA_PILLAR, POLISHED_MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_MAGENTA_TERRACOTTA_PILLAR, POLISHED_MAGENTA_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_SLAB, Blocks.PINK_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_STAIRS, Blocks.PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_WALL, Blocks.PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_BRICKS, Blocks.PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_BRICK_SLAB, Blocks.PINK_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_BRICK_STAIRS, Blocks.PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_BRICK_WALL, Blocks.PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_PINK_TERRACOTTA_BRICKS, Blocks.PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_BRICK_SLAB, PINK_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_BRICK_STAIRS, PINK_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_BRICK_WALL, PINK_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_PINK_TERRACOTTA_BRICKS, PINK_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_TILES, Blocks.PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_TILE_SLAB, Blocks.PINK_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_TILE_STAIRS, Blocks.PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_TILE_WALL, Blocks.PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_PINK_TERRACOTTA_TILES, Blocks.PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_TILE_SLAB, PINK_TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_TILE_STAIRS, PINK_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_TILE_WALL, PINK_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_PINK_TERRACOTTA_TILES, PINK_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PINK_TERRACOTTA, Blocks.PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PINK_TERRACOTTA_SLAB, Blocks.PINK_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PINK_TERRACOTTA_STAIRS, Blocks.PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PINK_TERRACOTTA_WALL, Blocks.PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PINK_TERRACOTTA_SLAB, POLISHED_PINK_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PINK_TERRACOTTA_STAIRS, POLISHED_PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_PINK_TERRACOTTA_WALL, POLISHED_PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PINK_TERRACOTTA, Blocks.PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_PILLAR, Blocks.PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PINK_TERRACOTTA_PILLAR, Blocks.PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PINK_TERRACOTTA, PINK_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_PILLAR, PINK_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PINK_TERRACOTTA_PILLAR, PINK_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PINK_TERRACOTTA, PINK_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_PILLAR, PINK_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PINK_TERRACOTTA_PILLAR, PINK_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PINK_TERRACOTTA, POLISHED_PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PINK_TERRACOTTA_PILLAR, POLISHED_PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_PINK_TERRACOTTA_PILLAR, POLISHED_PINK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_SLAB, Blocks.BROWN_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_STAIRS, Blocks.BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_WALL, Blocks.BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_BRICKS, Blocks.BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_BRICK_SLAB, Blocks.BROWN_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_BRICK_STAIRS, Blocks.BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_BRICK_WALL, Blocks.BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BROWN_TERRACOTTA_BRICKS, Blocks.BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_BRICK_SLAB, BROWN_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_BRICK_STAIRS, BROWN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_BRICK_WALL, BROWN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BROWN_TERRACOTTA_BRICKS, BROWN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_TILES, Blocks.BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_TILE_SLAB, Blocks.BROWN_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_TILE_STAIRS, Blocks.BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_TILE_WALL, Blocks.BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BROWN_TERRACOTTA_TILES, Blocks.BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_TILE_SLAB, BROWN_TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_TILE_STAIRS, BROWN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_TILE_WALL, BROWN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BROWN_TERRACOTTA_TILES, BROWN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BROWN_TERRACOTTA, Blocks.BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BROWN_TERRACOTTA_SLAB, Blocks.BROWN_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BROWN_TERRACOTTA_STAIRS, Blocks.BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BROWN_TERRACOTTA_WALL, Blocks.BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BROWN_TERRACOTTA_SLAB, POLISHED_BROWN_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BROWN_TERRACOTTA_STAIRS, POLISHED_BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BROWN_TERRACOTTA_WALL, POLISHED_BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BROWN_TERRACOTTA, Blocks.BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_PILLAR, Blocks.BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BROWN_TERRACOTTA_PILLAR, Blocks.BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BROWN_TERRACOTTA, BROWN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_PILLAR, BROWN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BROWN_TERRACOTTA_PILLAR, BROWN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BROWN_TERRACOTTA, BROWN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_PILLAR, BROWN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BROWN_TERRACOTTA_PILLAR, BROWN_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BROWN_TERRACOTTA, POLISHED_BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BROWN_TERRACOTTA_PILLAR, POLISHED_BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BROWN_TERRACOTTA_PILLAR, POLISHED_BROWN_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_SLAB, Blocks.WHITE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_STAIRS, Blocks.WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_WALL, Blocks.WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_BRICKS, Blocks.WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_BRICK_SLAB, Blocks.WHITE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_BRICK_STAIRS, Blocks.WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_BRICK_WALL, Blocks.WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_WHITE_TERRACOTTA_BRICKS, Blocks.WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_BRICK_SLAB, WHITE_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_BRICK_STAIRS, WHITE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_BRICK_WALL, WHITE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_WHITE_TERRACOTTA_BRICKS, WHITE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_TILES, Blocks.WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_TILE_SLAB, Blocks.WHITE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_TILE_STAIRS, Blocks.WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_TILE_WALL, Blocks.WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_WHITE_TERRACOTTA_TILES, Blocks.WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_TILE_SLAB, WHITE_TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_TILE_STAIRS, WHITE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_TILE_WALL, WHITE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_WHITE_TERRACOTTA_TILES, WHITE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_WHITE_TERRACOTTA, Blocks.WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_WHITE_TERRACOTTA_SLAB, Blocks.WHITE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_WHITE_TERRACOTTA_STAIRS, Blocks.WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_WHITE_TERRACOTTA_WALL, Blocks.WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_WHITE_TERRACOTTA_SLAB, POLISHED_WHITE_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_WHITE_TERRACOTTA_STAIRS, POLISHED_WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_WHITE_TERRACOTTA_WALL, POLISHED_WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_WHITE_TERRACOTTA, Blocks.WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_PILLAR, Blocks.WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_WHITE_TERRACOTTA_PILLAR, Blocks.WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_WHITE_TERRACOTTA, WHITE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_PILLAR, WHITE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_WHITE_TERRACOTTA_PILLAR, WHITE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_WHITE_TERRACOTTA, WHITE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_PILLAR, WHITE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_WHITE_TERRACOTTA_PILLAR, WHITE_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_WHITE_TERRACOTTA, POLISHED_WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WHITE_TERRACOTTA_PILLAR, POLISHED_WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_WHITE_TERRACOTTA_PILLAR, POLISHED_WHITE_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_SLAB, Blocks.LIGHT_GRAY_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_STAIRS, Blocks.LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_WALL, Blocks.LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_BRICKS, Blocks.LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_BRICK_SLAB, Blocks.LIGHT_GRAY_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS, Blocks.LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_BRICK_WALL, Blocks.LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_LIGHT_GRAY_TERRACOTTA_BRICKS, Blocks.LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_BRICK_SLAB, LIGHT_GRAY_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS, LIGHT_GRAY_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_BRICK_WALL, LIGHT_GRAY_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_LIGHT_GRAY_TERRACOTTA_BRICKS, LIGHT_GRAY_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_TILES, Blocks.LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_TILE_SLAB, Blocks.LIGHT_GRAY_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_TILE_STAIRS, Blocks.LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_TILE_WALL, Blocks.LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_LIGHT_GRAY_TERRACOTTA_TILES, Blocks.LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_TILE_SLAB, LIGHT_GRAY_TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_TILE_STAIRS, LIGHT_GRAY_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_TILE_WALL, LIGHT_GRAY_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_LIGHT_GRAY_TERRACOTTA_TILES, LIGHT_GRAY_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIGHT_GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIGHT_GRAY_TERRACOTTA_SLAB, Blocks.LIGHT_GRAY_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIGHT_GRAY_TERRACOTTA_STAIRS, Blocks.LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIGHT_GRAY_TERRACOTTA_WALL, Blocks.LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIGHT_GRAY_TERRACOTTA_SLAB, POLISHED_LIGHT_GRAY_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIGHT_GRAY_TERRACOTTA_STAIRS, POLISHED_LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_LIGHT_GRAY_TERRACOTTA_WALL, POLISHED_LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIGHT_GRAY_TERRACOTTA, Blocks.LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_PILLAR, Blocks.LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIGHT_GRAY_TERRACOTTA_PILLAR, Blocks.LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIGHT_GRAY_TERRACOTTA, LIGHT_GRAY_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_PILLAR, LIGHT_GRAY_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIGHT_GRAY_TERRACOTTA_PILLAR, LIGHT_GRAY_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIGHT_GRAY_TERRACOTTA, LIGHT_GRAY_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_PILLAR, LIGHT_GRAY_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIGHT_GRAY_TERRACOTTA_PILLAR, LIGHT_GRAY_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIGHT_GRAY_TERRACOTTA, POLISHED_LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, LIGHT_GRAY_TERRACOTTA_PILLAR, POLISHED_LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_LIGHT_GRAY_TERRACOTTA_PILLAR, POLISHED_LIGHT_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_SLAB, Blocks.GRAY_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_STAIRS, Blocks.GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_WALL, Blocks.GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_BRICKS, Blocks.GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_BRICK_SLAB, Blocks.GRAY_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_BRICK_STAIRS, Blocks.GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_BRICK_WALL, Blocks.GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_GRAY_TERRACOTTA_BRICKS, Blocks.GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_BRICK_SLAB, GRAY_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_BRICK_STAIRS, GRAY_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_BRICK_WALL, GRAY_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_GRAY_TERRACOTTA_BRICKS, GRAY_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_TILES, Blocks.GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_TILE_SLAB, Blocks.GRAY_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_TILE_STAIRS, Blocks.GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_TILE_WALL, Blocks.GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_GRAY_TERRACOTTA_TILES, Blocks.GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_TILE_SLAB, GRAY_TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_TILE_STAIRS, GRAY_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_TILE_WALL, GRAY_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_GRAY_TERRACOTTA_TILES, GRAY_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_GRAY_TERRACOTTA, Blocks.GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_GRAY_TERRACOTTA_SLAB, Blocks.GRAY_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_GRAY_TERRACOTTA_STAIRS, Blocks.GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_GRAY_TERRACOTTA_WALL, Blocks.GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_GRAY_TERRACOTTA_SLAB, POLISHED_GRAY_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_GRAY_TERRACOTTA_STAIRS, POLISHED_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_GRAY_TERRACOTTA_WALL, POLISHED_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GRAY_TERRACOTTA, Blocks.GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_PILLAR, Blocks.GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GRAY_TERRACOTTA_PILLAR, Blocks.GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GRAY_TERRACOTTA, GRAY_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_PILLAR, GRAY_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GRAY_TERRACOTTA_PILLAR, GRAY_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GRAY_TERRACOTTA, GRAY_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_PILLAR, GRAY_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GRAY_TERRACOTTA_PILLAR, GRAY_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GRAY_TERRACOTTA, POLISHED_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, GRAY_TERRACOTTA_PILLAR, POLISHED_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_GRAY_TERRACOTTA_PILLAR, POLISHED_GRAY_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_SLAB, Blocks.BLACK_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_STAIRS, Blocks.BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_WALL, Blocks.BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_BRICKS, Blocks.BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_BRICK_SLAB, Blocks.BLACK_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_BRICK_STAIRS, Blocks.BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_BRICK_WALL, Blocks.BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BLACK_TERRACOTTA_BRICKS, Blocks.BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_BRICK_SLAB, BLACK_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_BRICK_STAIRS, BLACK_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_BRICK_WALL, BLACK_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BLACK_TERRACOTTA_BRICKS, BLACK_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_TILES, Blocks.BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_TILE_SLAB, Blocks.BLACK_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_TILE_STAIRS, Blocks.BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_TILE_WALL, Blocks.BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BLACK_TERRACOTTA_TILES, Blocks.BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_TILE_SLAB, BLACK_TERRACOTTA_TILES, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_TILE_STAIRS, BLACK_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_TILE_WALL, BLACK_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRACKED_BLACK_TERRACOTTA_TILES, BLACK_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BLACK_TERRACOTTA, Blocks.BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BLACK_TERRACOTTA_SLAB, Blocks.BLACK_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BLACK_TERRACOTTA_STAIRS, Blocks.BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BLACK_TERRACOTTA_WALL, Blocks.BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BLACK_TERRACOTTA_SLAB, POLISHED_BLACK_TERRACOTTA, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BLACK_TERRACOTTA_STAIRS, POLISHED_BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, POLISHED_BLACK_TERRACOTTA_WALL, POLISHED_BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLACK_TERRACOTTA, Blocks.BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_PILLAR, Blocks.BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLACK_TERRACOTTA_PILLAR, Blocks.BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLACK_TERRACOTTA, BLACK_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_PILLAR, BLACK_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLACK_TERRACOTTA_PILLAR, BLACK_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLACK_TERRACOTTA, BLACK_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_PILLAR, BLACK_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLACK_TERRACOTTA_PILLAR, BLACK_TERRACOTTA_TILES, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLACK_TERRACOTTA, POLISHED_BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BLACK_TERRACOTTA_PILLAR, POLISHED_BLACK_TERRACOTTA, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CHISELED_BLACK_TERRACOTTA_PILLAR, POLISHED_BLACK_TERRACOTTA, 1);

			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_TUFF_SLAB, COBBLED_TUFF, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_TUFF_STAIRS, COBBLED_TUFF, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_TUFF_WALL, COBBLED_TUFF, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_TUFF_SLAB, MOSSY_COBBLED_TUFF, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_TUFF_STAIRS, MOSSY_COBBLED_TUFF, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_TUFF_WALL, MOSSY_COBBLED_TUFF, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_DEEPSLATE_SLAB, MOSSY_COBBLED_DEEPSLATE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_DEEPSLATE_STAIRS, MOSSY_COBBLED_DEEPSLATE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_DEEPSLATE_WALL, MOSSY_COBBLED_DEEPSLATE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SCULKY_COBBLED_DEEPSLATE_SLAB, SCULKY_COBBLED_DEEPSLATE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SCULKY_COBBLED_DEEPSLATE_STAIRS, SCULKY_COBBLED_DEEPSLATE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SCULKY_COBBLED_DEEPSLATE_WALL, SCULKY_COBBLED_DEEPSLATE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_GRANITE_SLAB, COBBLED_GRANITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_GRANITE_STAIRS, COBBLED_GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_GRANITE_WALL, COBBLED_GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_GRANITE_SLAB, MOSSY_COBBLED_GRANITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_GRANITE_STAIRS, MOSSY_COBBLED_GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_GRANITE_WALL, MOSSY_COBBLED_GRANITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_ANDESITE_SLAB, COBBLED_ANDESITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_ANDESITE_STAIRS, COBBLED_ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_ANDESITE_WALL, COBBLED_ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_ANDESITE_SLAB, MOSSY_COBBLED_ANDESITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_ANDESITE_STAIRS, MOSSY_COBBLED_ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_ANDESITE_WALL, MOSSY_COBBLED_ANDESITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_DIORITE_SLAB, COBBLED_DIORITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_DIORITE_STAIRS, COBBLED_DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_DIORITE_WALL, COBBLED_DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_DIORITE_SLAB, MOSSY_COBBLED_DIORITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_DIORITE_STAIRS, MOSSY_COBBLED_DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_DIORITE_WALL, MOSSY_COBBLED_DIORITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_BLACKSTONE_SLAB, COBBLED_BLACKSTONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_BLACKSTONE_STAIRS, COBBLED_BLACKSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_BLACKSTONE_WALL, COBBLED_BLACKSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_COBBLED_BLACKSTONE_SLAB, CRIMSON_COBBLED_BLACKSTONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_COBBLED_BLACKSTONE_STAIRS, CRIMSON_COBBLED_BLACKSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_COBBLED_BLACKSTONE_WALL, CRIMSON_COBBLED_BLACKSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_COBBLED_BLACKSTONE_SLAB, WARPED_COBBLED_BLACKSTONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_COBBLED_BLACKSTONE_STAIRS, WARPED_COBBLED_BLACKSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_COBBLED_BLACKSTONE_WALL, WARPED_COBBLED_BLACKSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_END_STONE_SLAB, COBBLED_END_STONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_END_STONE_STAIRS, COBBLED_END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_END_STONE_WALL, COBBLED_END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOLDY_COBBLED_END_STONE_SLAB, MOLDY_COBBLED_END_STONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOLDY_COBBLED_END_STONE_STAIRS, MOLDY_COBBLED_END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOLDY_COBBLED_END_STONE_WALL, MOLDY_COBBLED_END_STONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_SANDSTONE_SLAB, MOSSY_SANDSTONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_SANDSTONE_STAIRS, MOSSY_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_SANDSTONE_WALL, MOSSY_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_RED_SANDSTONE_SLAB, MOSSY_RED_SANDSTONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_RED_SANDSTONE_STAIRS, MOSSY_RED_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_RED_SANDSTONE_WALL, MOSSY_RED_SANDSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BARNACLED_PRISMARINE_SLAB, BARNACLED_PRISMARINE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BARNACLED_PRISMARINE_STAIRS, BARNACLED_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BARNACLED_PRISMARINE_WALL, BARNACLED_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DARK_PRISMARINE_SLAB, DARK_PRISMARINE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DARK_PRISMARINE_STAIRS, DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, DARK_PRISMARINE_WALL, DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BARNACLED_DARK_PRISMARINE_SLAB, BARNACLED_DARK_PRISMARINE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BARNACLED_DARK_PRISMARINE_STAIRS, BARNACLED_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BARNACLED_DARK_PRISMARINE_WALL, BARNACLED_DARK_PRISMARINE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHERRACK_SLAB, Blocks.NETHERRACK, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHERRACK_STAIRS, Blocks.NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, NETHERRACK_WALL, Blocks.NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_NETHERRACK_SLAB, CRIMSON_NETHERRACK, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_NETHERRACK_STAIRS, CRIMSON_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_NETHERRACK_WALL, CRIMSON_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_NETHERRACK_SLAB, WARPED_NETHERRACK, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_NETHERRACK_STAIRS, WARPED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_NETHERRACK_WALL, WARPED_NETHERRACK, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_BASALT_SLAB, COBBLED_BASALT, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_BASALT_STAIRS, COBBLED_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_BASALT_WALL, COBBLED_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_COBBLED_BASALT_SLAB, CRIMSON_COBBLED_BASALT, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_COBBLED_BASALT_STAIRS, CRIMSON_COBBLED_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_COBBLED_BASALT_WALL, CRIMSON_COBBLED_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_COBBLED_BASALT_SLAB, WARPED_COBBLED_BASALT, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_COBBLED_BASALT_STAIRS, WARPED_COBBLED_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_COBBLED_BASALT_WALL, WARPED_COBBLED_BASALT, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_CALCITE_SLAB, COBBLED_CALCITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_CALCITE_STAIRS, COBBLED_CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_CALCITE_WALL, COBBLED_CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_CALCITE_SLAB, MOSSY_COBBLED_CALCITE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_CALCITE_STAIRS, MOSSY_COBBLED_CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_CALCITE_WALL, MOSSY_COBBLED_CALCITE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_DRIPSTONE_SLAB, COBBLED_DRIPSTONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_DRIPSTONE_STAIRS, COBBLED_DRIPSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, COBBLED_DRIPSTONE_WALL, COBBLED_DRIPSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_DRIPSTONE_SLAB, MOSSY_COBBLED_DRIPSTONE, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_DRIPSTONE_STAIRS, MOSSY_COBBLED_DRIPSTONE, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_DRIPSTONE_WALL, MOSSY_COBBLED_DRIPSTONE, 1);

			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_TUFF_BRICK_SLAB, MOSSY_TUFF_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_TUFF_BRICK_STAIRS, MOSSY_TUFF_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_TUFF_BRICK_WALL, MOSSY_TUFF_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_DEEPSLATE_BRICK_SLAB, MOSSY_DEEPSLATE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_DEEPSLATE_BRICK_STAIRS, MOSSY_DEEPSLATE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_DEEPSLATE_BRICK_WALL, MOSSY_DEEPSLATE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SCULKY_DEEPSLATE_BRICK_SLAB, SCULKY_DEEPSLATE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SCULKY_DEEPSLATE_BRICK_STAIRS, SCULKY_DEEPSLATE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, SCULKY_DEEPSLATE_BRICK_WALL, SCULKY_DEEPSLATE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_GRANITE_BRICK_SLAB, MOSSY_GRANITE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_GRANITE_BRICK_STAIRS, MOSSY_GRANITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_GRANITE_BRICK_WALL, MOSSY_GRANITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_ANDESITE_BRICK_SLAB, MOSSY_ANDESITE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_ANDESITE_BRICK_STAIRS, MOSSY_ANDESITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_ANDESITE_BRICK_WALL, MOSSY_ANDESITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_DIORITE_BRICK_SLAB, MOSSY_DIORITE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_DIORITE_BRICK_STAIRS, MOSSY_DIORITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_DIORITE_BRICK_WALL, MOSSY_DIORITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_BLACKSTONE_BRICK_SLAB, CRIMSON_BLACKSTONE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_BLACKSTONE_BRICK_STAIRS, CRIMSON_BLACKSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_BLACKSTONE_BRICK_WALL, CRIMSON_BLACKSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_BLACKSTONE_BRICK_SLAB, WARPED_BLACKSTONE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_BLACKSTONE_BRICK_STAIRS, WARPED_BLACKSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_BLACKSTONE_BRICK_WALL, WARPED_BLACKSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOLDY_END_STONE_BRICK_SLAB, MOLDY_END_STONE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOLDY_END_STONE_BRICK_STAIRS, MOLDY_END_STONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOLDY_END_STONE_BRICK_WALL, MOLDY_END_STONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOLDY_PURPUR_BRICK_SLAB, MOLDY_PURPUR_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOLDY_PURPUR_BRICK_STAIRS, MOLDY_PURPUR_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOLDY_PURPUR_BRICK_WALL, MOLDY_PURPUR_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_SANDSTONE_BRICK_SLAB, MOSSY_SANDSTONE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_SANDSTONE_BRICK_STAIRS, MOSSY_SANDSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_SANDSTONE_BRICK_WALL, MOSSY_SANDSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_RED_SANDSTONE_BRICK_SLAB, MOSSY_RED_SANDSTONE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_RED_SANDSTONE_BRICK_STAIRS, MOSSY_RED_SANDSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_RED_SANDSTONE_BRICK_WALL, MOSSY_RED_SANDSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BARNACLED_PRISMARINE_BRICK_SLAB, BARNACLED_PRISMARINE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BARNACLED_PRISMARINE_BRICK_STAIRS, BARNACLED_PRISMARINE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BARNACLED_PRISMARINE_BRICK_WALL, BARNACLED_PRISMARINE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BARNACLED_DARK_PRISMARINE_BRICK_SLAB, BARNACLED_DARK_PRISMARINE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BARNACLED_DARK_PRISMARINE_BRICK_STAIRS, BARNACLED_DARK_PRISMARINE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BARNACLED_DARK_PRISMARINE_BRICK_WALL, BARNACLED_DARK_PRISMARINE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_NETHER_BRICK_SLAB, CRIMSON_NETHER_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_NETHER_BRICK_STAIRS, CRIMSON_NETHER_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_NETHER_BRICK_WALL, CRIMSON_NETHER_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_BASALT_BRICK_SLAB, CRIMSON_BASALT_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_BASALT_BRICK_STAIRS, CRIMSON_BASALT_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, CRIMSON_BASALT_BRICK_WALL, CRIMSON_BASALT_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_NETHER_BRICK_SLAB, WARPED_NETHER_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_NETHER_BRICK_STAIRS, WARPED_NETHER_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_NETHER_BRICK_WALL, WARPED_NETHER_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_BASALT_BRICK_SLAB, WARPED_BASALT_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_BASALT_BRICK_STAIRS, WARPED_BASALT_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, WARPED_BASALT_BRICK_WALL, WARPED_BASALT_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_CALCITE_BRICK_SLAB, MOSSY_CALCITE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_CALCITE_BRICK_STAIRS, MOSSY_CALCITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_CALCITE_BRICK_WALL, MOSSY_CALCITE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_DRIPSTONE_BRICK_SLAB, MOSSY_DRIPSTONE_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_DRIPSTONE_BRICK_STAIRS, MOSSY_DRIPSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_DRIPSTONE_BRICK_WALL, MOSSY_DRIPSTONE_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_MUD_BRICK_SLAB, MOSSY_MUD_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_MUD_BRICK_STAIRS, MOSSY_MUD_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_MUD_BRICK_WALL, MOSSY_MUD_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_BRICK_SLAB, MOSSY_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_BRICK_STAIRS, MOSSY_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_BRICK_WALL, MOSSY_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_RED_TERRACOTTA_BRICK_SLAB, MOSSY_RED_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_RED_TERRACOTTA_BRICK_STAIRS, MOSSY_RED_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_RED_TERRACOTTA_BRICK_WALL, MOSSY_RED_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_ORANGE_TERRACOTTA_BRICK_SLAB, MOSSY_ORANGE_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_ORANGE_TERRACOTTA_BRICK_STAIRS, MOSSY_ORANGE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_ORANGE_TERRACOTTA_BRICK_WALL, MOSSY_ORANGE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_YELLOW_TERRACOTTA_BRICK_SLAB, MOSSY_YELLOW_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_YELLOW_TERRACOTTA_BRICK_STAIRS, MOSSY_YELLOW_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_YELLOW_TERRACOTTA_BRICK_WALL, MOSSY_YELLOW_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_LIME_TERRACOTTA_BRICK_SLAB, MOSSY_LIME_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_LIME_TERRACOTTA_BRICK_STAIRS, MOSSY_LIME_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_LIME_TERRACOTTA_BRICK_WALL, MOSSY_LIME_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_GREEN_TERRACOTTA_BRICK_SLAB, MOSSY_GREEN_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_GREEN_TERRACOTTA_BRICK_STAIRS, MOSSY_GREEN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_GREEN_TERRACOTTA_BRICK_WALL, MOSSY_GREEN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_CYAN_TERRACOTTA_BRICK_SLAB, MOSSY_CYAN_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_CYAN_TERRACOTTA_BRICK_STAIRS, MOSSY_CYAN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_CYAN_TERRACOTTA_BRICK_WALL, MOSSY_CYAN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_LIGHT_BLUE_TERRACOTTA_BRICK_SLAB, MOSSY_LIGHT_BLUE_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS, MOSSY_LIGHT_BLUE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_LIGHT_BLUE_TERRACOTTA_BRICK_WALL, MOSSY_LIGHT_BLUE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_BLUE_TERRACOTTA_BRICK_SLAB, MOSSY_BLUE_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_BLUE_TERRACOTTA_BRICK_STAIRS, MOSSY_BLUE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_BLUE_TERRACOTTA_BRICK_WALL, MOSSY_BLUE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_PURPLE_TERRACOTTA_BRICK_SLAB, MOSSY_PURPLE_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_PURPLE_TERRACOTTA_BRICK_STAIRS, MOSSY_PURPLE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_PURPLE_TERRACOTTA_BRICK_WALL, MOSSY_PURPLE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_MAGENTA_TERRACOTTA_BRICK_SLAB, MOSSY_MAGENTA_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_MAGENTA_TERRACOTTA_BRICK_STAIRS, MOSSY_MAGENTA_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_MAGENTA_TERRACOTTA_BRICK_WALL, MOSSY_MAGENTA_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_PINK_TERRACOTTA_BRICK_SLAB, MOSSY_PINK_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_PINK_TERRACOTTA_BRICK_STAIRS, MOSSY_PINK_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_PINK_TERRACOTTA_BRICK_WALL, MOSSY_PINK_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_BROWN_TERRACOTTA_BRICK_SLAB, MOSSY_BROWN_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_BROWN_TERRACOTTA_BRICK_STAIRS, MOSSY_BROWN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_BROWN_TERRACOTTA_BRICK_WALL, MOSSY_BROWN_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_WHITE_TERRACOTTA_BRICK_SLAB, MOSSY_WHITE_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_WHITE_TERRACOTTA_BRICK_STAIRS, MOSSY_WHITE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_WHITE_TERRACOTTA_BRICK_WALL, MOSSY_WHITE_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_LIGHT_GRAY_TERRACOTTA_BRICK_SLAB, MOSSY_LIGHT_GRAY_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS, MOSSY_LIGHT_GRAY_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_LIGHT_GRAY_TERRACOTTA_BRICK_WALL, MOSSY_LIGHT_GRAY_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_GRAY_TERRACOTTA_BRICK_SLAB, MOSSY_GRAY_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_GRAY_TERRACOTTA_BRICK_STAIRS, MOSSY_GRAY_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_GRAY_TERRACOTTA_BRICK_WALL, MOSSY_GRAY_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_BLACK_TERRACOTTA_BRICK_SLAB, MOSSY_BLACK_TERRACOTTA_BRICKS, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_BLACK_TERRACOTTA_BRICK_STAIRS, MOSSY_BLACK_TERRACOTTA_BRICKS, 1);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, MOSSY_BLACK_TERRACOTTA_BRICK_WALL, MOSSY_BLACK_TERRACOTTA_BRICKS, 1);

			CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(COBBLED_TUFF), RecipeCategory.BUILDING_BLOCKS, Blocks.TUFF.asItem(), 0.0F, 200).criterion("has_cobblestone", conditionsFromItem(COBBLED_TUFF)).offerTo(exporter);
			CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(COBBLED_GRANITE), RecipeCategory.BUILDING_BLOCKS, Blocks.GRANITE.asItem(), 0.0F, 200).criterion("has_cobblestone", conditionsFromItem(COBBLED_GRANITE)).offerTo(exporter);
			CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(COBBLED_ANDESITE), RecipeCategory.BUILDING_BLOCKS, Blocks.ANDESITE.asItem(), 0.0F, 200).criterion("has_cobblestone", conditionsFromItem(COBBLED_ANDESITE)).offerTo(exporter);
			CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(COBBLED_DIORITE), RecipeCategory.BUILDING_BLOCKS, Blocks.DIORITE.asItem(), 0.0F, 200).criterion("has_cobblestone", conditionsFromItem(COBBLED_DIORITE)).offerTo(exporter);
			CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(COBBLED_BLACKSTONE), RecipeCategory.BUILDING_BLOCKS, Blocks.BLACKSTONE.asItem(), 0.0F, 200).criterion("has_cobblestone", conditionsFromItem(COBBLED_BLACKSTONE)).offerTo(exporter);
			CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(COBBLED_END_STONE), RecipeCategory.BUILDING_BLOCKS, Blocks.END_STONE.asItem(), 0.0F, 200).criterion("has_end_stone", conditionsFromItem(Blocks.END_STONE)).offerTo(exporter);
			CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(Blocks.PRISMARINE), RecipeCategory.BUILDING_BLOCKS, SMOOTH_PRISMARINE.asItem(), 0.0F, 200).criterion("has_prismarine", conditionsFromItem(Blocks.PRISMARINE)).offerTo(exporter);
			CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(DARK_PRISMARINE), RecipeCategory.BUILDING_BLOCKS, SMOOTH_DARK_PRISMARINE.asItem(), 0.0F, 200).criterion("has_dark_prismarine", conditionsFromItem(DARK_PRISMARINE)).offerTo(exporter);
			CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(COBBLED_BASALT), RecipeCategory.BUILDING_BLOCKS, Blocks.SMOOTH_BASALT.asItem(), 0.0F, 200).criterion("has_cobblestone", conditionsFromItem(COBBLED_BASALT)).offerTo(exporter);
			CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(COBBLED_CALCITE), RecipeCategory.BUILDING_BLOCKS, Blocks.CALCITE.asItem(), 0.0F, 200).criterion("has_cobblestone", conditionsFromItem(COBBLED_CALCITE)).offerTo(exporter);
			CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(COBBLED_DRIPSTONE), RecipeCategory.BUILDING_BLOCKS, Blocks.DRIPSTONE_BLOCK.asItem(), 0.0F, 200).criterion("has_cobblestone", conditionsFromItem(COBBLED_DRIPSTONE)).offerTo(exporter);

			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_TUFF)
					.input(COBBLED_TUFF)
					.input(Blocks.VINE)
					.group("mossy_cobbled_tuff")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_COBBLED_TUFF, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_TUFF_BRICKS)
					.input(Blocks.TUFF_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_tuff_bricks")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_TUFF_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_TUFF)
					.input(COBBLED_TUFF)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_cobbled_tuff")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_COBBLED_TUFF, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_TUFF_BRICKS)
					.input(Blocks.TUFF_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_tuff_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_TUFF_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_DEEPSLATE)
					.input(Blocks.COBBLED_DEEPSLATE)
					.input(Blocks.VINE)
					.group("mossy_cobbled_deepslate")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_COBBLED_DEEPSLATE, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_DEEPSLATE_BRICKS)
					.input(Blocks.DEEPSLATE_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_deepslate_bricks")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_DEEPSLATE_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_DEEPSLATE)
					.input(Blocks.COBBLED_DEEPSLATE)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_cobbled_deepslate")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_COBBLED_DEEPSLATE, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_DEEPSLATE_BRICKS)
					.input(Blocks.DEEPSLATE_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_deepslate_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_DEEPSLATE_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, SCULKY_COBBLED_DEEPSLATE)
					.input(Blocks.COBBLED_DEEPSLATE)
					.input(Blocks.SCULK)
					.group("sculky_cobbled_deepslate")
					.criterion("has_moss_block", conditionsFromItem(Blocks.SCULK))
					.offerTo(exporter, convertBetween(SCULKY_COBBLED_DEEPSLATE, Blocks.SCULK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, SCULKY_DEEPSLATE_BRICKS)
					.input(Blocks.DEEPSLATE_BRICKS)
					.input(Blocks.SCULK)
					.group("sculky_deepslate_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.SCULK))
					.offerTo(exporter, convertBetween(SCULKY_DEEPSLATE_BRICKS, Blocks.SCULK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_ANDESITE)
					.input(COBBLED_ANDESITE)
					.input(Blocks.VINE)
					.group("mossy_cobbled_andesite")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_COBBLED_ANDESITE, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_ANDESITE_BRICKS)
					.input(ANDESITE_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_andesite_bricks")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_ANDESITE_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_ANDESITE)
					.input(COBBLED_ANDESITE)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_cobbled_andesite")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_COBBLED_ANDESITE, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_ANDESITE_BRICKS)
					.input(ANDESITE_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_andesite_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_ANDESITE_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_DIORITE)
					.input(COBBLED_DIORITE)
					.input(Blocks.VINE)
					.group("mossy_cobbled_diorite")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_COBBLED_DIORITE, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_DIORITE_BRICKS)
					.input(DIORITE_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_diorite_bricks")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_DIORITE_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_DIORITE)
					.input(COBBLED_DIORITE)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_cobbled_diorite")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_COBBLED_DIORITE, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_DIORITE_BRICKS)
					.input(DIORITE_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_diorite_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_DIORITE_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_GRANITE)
					.input(COBBLED_GRANITE)
					.input(Blocks.VINE)
					.group("mossy_cobbled_granite")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_COBBLED_GRANITE, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_GRANITE_BRICKS)
					.input(GRANITE_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_granite_bricks")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_GRANITE_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_GRANITE)
					.input(COBBLED_GRANITE)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_cobbled_granite")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_COBBLED_GRANITE, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_GRANITE_BRICKS)
					.input(GRANITE_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_granite_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_GRANITE_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_SANDSTONE)
					.input(Blocks.SANDSTONE)
					.input(Blocks.VINE)
					.group("mossy__sandstone")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_SANDSTONE, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_SANDSTONE_BRICKS)
					.input(SANDSTONE_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_sandstone_bricks")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_SANDSTONE_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_SANDSTONE)
					.input(Blocks.SANDSTONE)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy__sandstone")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_SANDSTONE, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_SANDSTONE_BRICKS)
					.input(SANDSTONE_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_sandstone_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_SANDSTONE_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_RED_SANDSTONE)
					.input(Blocks.RED_SANDSTONE)
					.input(Blocks.VINE)
					.group("mossy_red_sandstone")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_RED_SANDSTONE, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_RED_SANDSTONE_BRICKS)
					.input(SANDSTONE_BRICKS)
					.input(Blocks.VINE)
					.group("mossyred_sandstone_bricks")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_RED_SANDSTONE_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_RED_SANDSTONE)
					.input(Blocks.RED_SANDSTONE)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_red_sandstone")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_RED_SANDSTONE, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_RED_SANDSTONE_BRICKS)
					.input(SANDSTONE_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossyred_sandstone_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_RED_SANDSTONE_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_CALCITE)
					.input(COBBLED_CALCITE)
					.input(Blocks.VINE)
					.group("mossy_cobbled_calcite")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_COBBLED_CALCITE, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_CALCITE_BRICKS)
					.input(CALCITE_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_calcite_bricks")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_CALCITE_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_CALCITE)
					.input(COBBLED_CALCITE)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_cobbled_calcite")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_COBBLED_CALCITE, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_CALCITE_BRICKS)
					.input(CALCITE_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_calcite_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_CALCITE_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_DRIPSTONE)
					.input(COBBLED_DRIPSTONE)
					.input(Blocks.VINE)
					.group("mossy_cobbled_dripstone")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_COBBLED_DRIPSTONE, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_DRIPSTONE_BRICKS)
					.input(DRIPSTONE_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_dripstone_bricks")
					.criterion("has_vine", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_DRIPSTONE_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_COBBLED_DRIPSTONE)
					.input(COBBLED_DRIPSTONE)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_cobbled_dripstone")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_COBBLED_DRIPSTONE, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_DRIPSTONE_BRICKS)
					.input(DRIPSTONE_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_dripstone_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_DRIPSTONE_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CRIMSON_COBBLED_BLACKSTONE)
					.input(COBBLED_BLACKSTONE)
					.input(Blocks.CRIMSON_ROOTS)
					.group("crimson_cobbled_blackstone")
					.criterion("has_crimson_roots", conditionsFromItem(Blocks.CRIMSON_ROOTS))
					.offerTo(exporter, convertBetween(CRIMSON_COBBLED_BLACKSTONE, Blocks.CRIMSON_ROOTS));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CRIMSON_BLACKSTONE_BRICKS)
					.input(Blocks.POLISHED_BLACKSTONE_BRICKS)
					.input(Blocks.CRIMSON_ROOTS)
					.group("crimson_blackstone_bricks")
					.criterion("has_crimson_roots", conditionsFromItem(Blocks.CRIMSON_ROOTS))
					.offerTo(exporter, convertBetween(CRIMSON_BLACKSTONE_BRICKS, Blocks.CRIMSON_ROOTS));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WARPED_COBBLED_BLACKSTONE)
					.input(COBBLED_BLACKSTONE)
					.input(Blocks.WARPED_ROOTS)
					.group("warped_cobbled_blackstone")
					.criterion("has_warped_roots", conditionsFromItem(Blocks.WARPED_ROOTS))
					.offerTo(exporter, convertBetween(WARPED_COBBLED_BLACKSTONE, Blocks.CRIMSON_ROOTS));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WARPED_BLACKSTONE_BRICKS)
					.input(Blocks.POLISHED_BLACKSTONE_BRICKS)
					.input(Blocks.WARPED_ROOTS)
					.group("warped_blackstone_bricks")
					.criterion("has_warped_roots", conditionsFromItem(Blocks.WARPED_ROOTS))
					.offerTo(exporter, convertBetween(WARPED_BLACKSTONE_BRICKS, Blocks.WARPED_ROOTS));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CRIMSON_COBBLED_BASALT)
					.input(COBBLED_BASALT)
					.input(Blocks.CRIMSON_ROOTS)
					.group("crimson_cobbled_basalt")
					.criterion("has_crimson_roots", conditionsFromItem(Blocks.CRIMSON_ROOTS))
					.offerTo(exporter, convertBetween(CRIMSON_COBBLED_BASALT, Blocks.CRIMSON_ROOTS));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CRIMSON_BASALT_BRICKS)
					.input(BASALT_BRICKS)
					.input(Blocks.CRIMSON_ROOTS)
					.group("crimson_basalt_bricks")
					.criterion("has_crimson_roots", conditionsFromItem(Blocks.CRIMSON_ROOTS))
					.offerTo(exporter, convertBetween(CRIMSON_BASALT_BRICKS, Blocks.CRIMSON_ROOTS));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WARPED_COBBLED_BASALT)
					.input(COBBLED_BASALT)
					.input(Blocks.WARPED_ROOTS)
					.group("warped_cobbled_basalt")
					.criterion("has_warped_roots", conditionsFromItem(Blocks.WARPED_ROOTS))
					.offerTo(exporter, convertBetween(WARPED_COBBLED_BASALT, Blocks.WARPED_ROOTS));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WARPED_BASALT_BRICKS)
					.input(BASALT_BRICKS)
					.input(Blocks.WARPED_ROOTS)
					.group("warped_basalt_bricks")
					.criterion("has_warped_roots", conditionsFromItem(Blocks.WARPED_ROOTS))
					.offerTo(exporter, convertBetween(WARPED_BASALT_BRICKS, Blocks.WARPED_ROOTS));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CRIMSON_NETHERRACK)
					.input(Blocks.NETHERRACK)
					.input(Blocks.CRIMSON_ROOTS)
					.group("crimson_netherrack")
					.criterion("has_crimson_roots", conditionsFromItem(Blocks.CRIMSON_ROOTS))
					.offerTo(exporter, convertBetween(CRIMSON_NETHERRACK, Blocks.CRIMSON_ROOTS));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WARPED_NETHERRACK)
					.input(Blocks.NETHERRACK)
					.input(Blocks.WARPED_ROOTS)
					.group("warped_netherrack")
					.criterion("has_warped_roots", conditionsFromItem(Blocks.WARPED_ROOTS))
					.offerTo(exporter, convertBetween(WARPED_NETHERRACK, Blocks.WARPED_ROOTS));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CRIMSON_NETHER_BRICKS)
					.input(Blocks.NETHER_BRICKS)
					.input(Blocks.CRIMSON_ROOTS)
					.group("crimson_nether_bricks")
					.criterion("has_crimson_roots", conditionsFromItem(Blocks.CRIMSON_ROOTS))
					.offerTo(exporter, convertBetween(CRIMSON_NETHER_BRICKS, Blocks.CRIMSON_ROOTS));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WARPED_NETHER_BRICKS)
					.input(Blocks.NETHER_BRICKS)
					.input(Blocks.WARPED_ROOTS)
					.group("warped_nether_bricks")
					.criterion("has_warped_roots", conditionsFromItem(Blocks.WARPED_ROOTS))
					.offerTo(exporter, convertBetween(WARPED_NETHER_BRICKS, Blocks.WARPED_ROOTS));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CRIMSON_RED_NETHER_BRICKS)
					.input(Blocks.RED_NETHER_BRICKS)
					.input(Blocks.CRIMSON_ROOTS)
					.group("crimson_red_nether_bricks")
					.criterion("has_crimson_roots", conditionsFromItem(Blocks.CRIMSON_ROOTS))
					.offerTo(exporter, convertBetween(CRIMSON_RED_NETHER_BRICKS, Blocks.CRIMSON_ROOTS));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WARPED_RED_NETHER_BRICKS)
					.input(Blocks.RED_NETHER_BRICKS)
					.input(Blocks.WARPED_ROOTS)
					.group("warped_red_nether_bricks")
					.criterion("has_warped_roots", conditionsFromItem(Blocks.WARPED_ROOTS))
					.offerTo(exporter, convertBetween(WARPED_RED_NETHER_BRICKS, Blocks.WARPED_ROOTS));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, CRIMSON_QUARTZ_BRICKS)
					.input(Blocks.QUARTZ_BRICKS)
					.input(Blocks.CRIMSON_ROOTS)
					.group("crimson_quartz_bricks")
					.criterion("has_crimson_roots", conditionsFromItem(Blocks.CRIMSON_ROOTS))
					.offerTo(exporter, convertBetween(CRIMSON_QUARTZ_BRICKS, Blocks.CRIMSON_ROOTS));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, WARPED_QUARTZ_BRICKS)
					.input(Blocks.QUARTZ_BRICKS)
					.input(Blocks.WARPED_ROOTS)
					.group("warped_quartz_bricks")
					.criterion("has_warped_roots", conditionsFromItem(Blocks.WARPED_ROOTS))
					.offerTo(exporter, convertBetween(WARPED_QUARTZ_BRICKS, Blocks.WARPED_ROOTS));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_SMOOTH_STONE_BRICKS)
					.input(SMOOTH_STONE_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_smooth_stone_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_SMOOTH_STONE_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_SMOOTH_STONE_BRICKS)
					.input(SMOOTH_STONE_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_smooth_stone_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_SMOOTH_STONE_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOLDY_COBBLED_END_STONE)
					.input(COBBLED_END_STONE)
					.input(Items.CHORUS_FRUIT)
					.group("moldy_cobbled_end_stone")
					.criterion("has_chorus_fruit", conditionsFromItem(Items.CHORUS_FRUIT))
					.offerTo(exporter, convertBetween(MOLDY_COBBLED_END_STONE, Items.CHORUS_FRUIT));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOLDY_END_STONE_BRICKS)
					.input(Blocks.END_STONE_BRICKS)
					.input(Items.CHORUS_FRUIT)
					.group("moldy_end_stone_bricks")
					.criterion("has_chorus_fruit", conditionsFromItem(Items.CHORUS_FRUIT))
					.offerTo(exporter, convertBetween(MOLDY_END_STONE_BRICKS, Items.CHORUS_FRUIT));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOLDY_PURPUR_BRICKS)
					.input(PURPUR_BRICKS)
					.input(Items.CHORUS_FRUIT)
					.group("moldy_purpur_bricks")
					.criterion("has_chorus_fruit", conditionsFromItem(Items.CHORUS_FRUIT))
					.offerTo(exporter, convertBetween(MOLDY_PURPUR_BRICKS, Items.CHORUS_FRUIT));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_BRICKS)
					.input(Blocks.BRICKS)
					.input(Blocks.VINE)
					.group("mossy_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_BRICKS)
					.input(Blocks.BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_RED_TERRACOTTA_BRICKS)
					.input(RED_TERRACOTTA_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_red_terracotta_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_RED_TERRACOTTA_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_RED_TERRACOTTA_BRICKS)
					.input(RED_TERRACOTTA_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_red_terracotta_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_RED_TERRACOTTA_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_ORANGE_TERRACOTTA_BRICKS)
					.input(ORANGE_TERRACOTTA_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_orange_terracotta_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_ORANGE_TERRACOTTA_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_ORANGE_TERRACOTTA_BRICKS)
					.input(ORANGE_TERRACOTTA_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_orange_terracotta_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_ORANGE_TERRACOTTA_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_YELLOW_TERRACOTTA_BRICKS)
					.input(YELLOW_TERRACOTTA_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_yellow_terracotta_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_YELLOW_TERRACOTTA_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_YELLOW_TERRACOTTA_BRICKS)
					.input(YELLOW_TERRACOTTA_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_yellow_terracotta_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_YELLOW_TERRACOTTA_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_GREEN_TERRACOTTA_BRICKS)
					.input(GREEN_TERRACOTTA_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_green_terracotta_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_GREEN_TERRACOTTA_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_GREEN_TERRACOTTA_BRICKS)
					.input(GREEN_TERRACOTTA_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_green_terracotta_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_GREEN_TERRACOTTA_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_CYAN_TERRACOTTA_BRICKS)
					.input(CYAN_TERRACOTTA_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_cyan_terracotta_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_CYAN_TERRACOTTA_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_CYAN_TERRACOTTA_BRICKS)
					.input(CYAN_TERRACOTTA_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_cyan_terracotta_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_CYAN_TERRACOTTA_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_LIGHT_BLUE_TERRACOTTA_BRICKS)
					.input(LIGHT_BLUE_TERRACOTTA_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_light_blue_terracotta_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_LIGHT_BLUE_TERRACOTTA_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_LIGHT_BLUE_TERRACOTTA_BRICKS)
					.input(LIGHT_BLUE_TERRACOTTA_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_light_blue_terracotta_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_LIGHT_BLUE_TERRACOTTA_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_BLUE_TERRACOTTA_BRICKS)
					.input(BLUE_TERRACOTTA_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_blue_terracotta_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_BLUE_TERRACOTTA_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_BLUE_TERRACOTTA_BRICKS)
					.input(BLUE_TERRACOTTA_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_blue_terracotta_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_BLUE_TERRACOTTA_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_PURPLE_TERRACOTTA_BRICKS)
					.input(PURPLE_TERRACOTTA_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_purple_terracotta_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_PURPLE_TERRACOTTA_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_PURPLE_TERRACOTTA_BRICKS)
					.input(PURPLE_TERRACOTTA_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_purple_terracotta_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_PURPLE_TERRACOTTA_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_MAGENTA_TERRACOTTA_BRICKS)
					.input(MAGENTA_TERRACOTTA_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_magenta_terracotta_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_MAGENTA_TERRACOTTA_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_MAGENTA_TERRACOTTA_BRICKS)
					.input(MAGENTA_TERRACOTTA_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_magenta_terracotta_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_MAGENTA_TERRACOTTA_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_PINK_TERRACOTTA_BRICKS)
					.input(PINK_TERRACOTTA_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_pink_terracotta_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_PINK_TERRACOTTA_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_PINK_TERRACOTTA_BRICKS)
					.input(PINK_TERRACOTTA_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_pink_terracotta_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_PINK_TERRACOTTA_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_BROWN_TERRACOTTA_BRICKS)
					.input(BROWN_TERRACOTTA_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_brown_terracotta_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_BROWN_TERRACOTTA_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_BROWN_TERRACOTTA_BRICKS)
					.input(BROWN_TERRACOTTA_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_brown_terracotta_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_BROWN_TERRACOTTA_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_WHITE_TERRACOTTA_BRICKS)
					.input(WHITE_TERRACOTTA_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_white_terracotta_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_WHITE_TERRACOTTA_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_WHITE_TERRACOTTA_BRICKS)
					.input(WHITE_TERRACOTTA_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_white_terracotta_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_WHITE_TERRACOTTA_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_LIGHT_GRAY_TERRACOTTA_BRICKS)
					.input(LIGHT_GRAY_TERRACOTTA_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_light_gray_terracotta_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_LIGHT_GRAY_TERRACOTTA_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_LIGHT_GRAY_TERRACOTTA_BRICKS)
					.input(LIGHT_GRAY_TERRACOTTA_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_light_gray_terracotta_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_LIGHT_GRAY_TERRACOTTA_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_GRAY_TERRACOTTA_BRICKS)
					.input(GRAY_TERRACOTTA_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_gray_terracotta_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_GRAY_TERRACOTTA_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_GRAY_TERRACOTTA_BRICKS)
					.input(GRAY_TERRACOTTA_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_gray_terracotta_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_GRAY_TERRACOTTA_BRICKS, Blocks.MOSS_BLOCK));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_BLACK_TERRACOTTA_BRICKS)
					.input(BLACK_TERRACOTTA_BRICKS)
					.input(Blocks.VINE)
					.group("mossy_black_terracotta_bricks")
					.criterion("has_vine_block", conditionsFromItem(Blocks.VINE))
					.offerTo(exporter, convertBetween(MOSSY_BLACK_TERRACOTTA_BRICKS, Blocks.VINE));
			ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, MOSSY_BLACK_TERRACOTTA_BRICKS)
					.input(BLACK_TERRACOTTA_BRICKS)
					.input(Blocks.MOSS_BLOCK)
					.group("mossy_black_terracotta_bricks")
					.criterion("has_moss_block", conditionsFromItem(Blocks.MOSS_BLOCK))
					.offerTo(exporter, convertBetween(MOSSY_BLACK_TERRACOTTA_BRICKS, Blocks.MOSS_BLOCK));
		}
	}

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

			addDrop(COPPER_LANTERN, drops(COPPER_LANTERN.asItem()));
			addDrop(EXPOSED_COPPER_LANTERN, drops(EXPOSED_COPPER_LANTERN.asItem()));
			addDrop(WEATHERED_COPPER_LANTERN, drops(WEATHERED_COPPER_LANTERN.asItem()));
			addDrop(OXIDIZED_COPPER_LANTERN, drops(OXIDIZED_COPPER_LANTERN.asItem()));
			addDrop(WAXED_COPPER_LANTERN, drops(WAXED_COPPER_LANTERN.asItem()));
			addDrop(WAXED_EXPOSED_COPPER_LANTERN, drops(WAXED_EXPOSED_COPPER_LANTERN.asItem()));
			addDrop(WAXED_WEATHERED_COPPER_LANTERN, drops(WAXED_WEATHERED_COPPER_LANTERN.asItem()));
			addDrop(WAXED_OXIDIZED_COPPER_LANTERN, drops(WAXED_OXIDIZED_COPPER_LANTERN.asItem()));

			addDrop(COPPER_LANTERN, drops(COPPER_LANTERN.asItem()));
			addDrop(EXPOSED_COPPER_LANTERN, drops(EXPOSED_COPPER_LANTERN.asItem()));
			addDrop(WEATHERED_COPPER_LANTERN, drops(WEATHERED_COPPER_LANTERN.asItem()));
			addDrop(OXIDIZED_COPPER_LANTERN, drops(OXIDIZED_COPPER_LANTERN.asItem()));
			addDrop(WAXED_COPPER_LANTERN, drops(WAXED_COPPER_LANTERN.asItem()));
			addDrop(WAXED_EXPOSED_COPPER_LANTERN, drops(WAXED_EXPOSED_COPPER_LANTERN.asItem()));
			addDrop(WAXED_WEATHERED_COPPER_LANTERN, drops(WAXED_WEATHERED_COPPER_LANTERN.asItem()));
			addDrop(WAXED_OXIDIZED_COPPER_LANTERN, drops(WAXED_OXIDIZED_COPPER_LANTERN.asItem()));

			addDrop(COPPER_SOUL_LANTERN, drops(COPPER_SOUL_LANTERN.asItem()));
			addDrop(EXPOSED_COPPER_SOUL_LANTERN, drops(EXPOSED_COPPER_SOUL_LANTERN.asItem()));
			addDrop(WEATHERED_COPPER_SOUL_LANTERN, drops(WEATHERED_COPPER_SOUL_LANTERN.asItem()));
			addDrop(OXIDIZED_COPPER_SOUL_LANTERN, drops(OXIDIZED_COPPER_SOUL_LANTERN.asItem()));
			addDrop(WAXED_COPPER_SOUL_LANTERN, drops(WAXED_COPPER_SOUL_LANTERN.asItem()));
			addDrop(WAXED_EXPOSED_COPPER_SOUL_LANTERN, drops(WAXED_EXPOSED_COPPER_SOUL_LANTERN.asItem()));
			addDrop(WAXED_WEATHERED_COPPER_SOUL_LANTERN, drops(WAXED_WEATHERED_COPPER_SOUL_LANTERN.asItem()));
			addDrop(WAXED_OXIDIZED_COPPER_SOUL_LANTERN, drops(WAXED_OXIDIZED_COPPER_SOUL_LANTERN.asItem()));

			addDrop(COPPER_REDSTONE_LANTERN, drops(COPPER_REDSTONE_LANTERN.asItem()));
			addDrop(EXPOSED_COPPER_REDSTONE_LANTERN, drops(EXPOSED_COPPER_REDSTONE_LANTERN.asItem()));
			addDrop(WEATHERED_COPPER_REDSTONE_LANTERN, drops(WEATHERED_COPPER_REDSTONE_LANTERN.asItem()));
			addDrop(OXIDIZED_COPPER_REDSTONE_LANTERN, drops(OXIDIZED_COPPER_REDSTONE_LANTERN.asItem()));
			addDrop(WAXED_COPPER_REDSTONE_LANTERN, drops(WAXED_COPPER_REDSTONE_LANTERN.asItem()));
			addDrop(WAXED_EXPOSED_COPPER_REDSTONE_LANTERN, drops(WAXED_EXPOSED_COPPER_REDSTONE_LANTERN.asItem()));
			addDrop(WAXED_WEATHERED_COPPER_REDSTONE_LANTERN, drops(WAXED_WEATHERED_COPPER_REDSTONE_LANTERN.asItem()));
			addDrop(WAXED_OXIDIZED_COPPER_REDSTONE_LANTERN, drops(WAXED_OXIDIZED_COPPER_REDSTONE_LANTERN.asItem()));

			addDrop(COPPER_GATE, drops(COPPER_GATE.asItem()));
			addDrop(EXPOSED_COPPER_GATE, drops(EXPOSED_COPPER_GATE.asItem()));
			addDrop(WEATHERED_COPPER_GATE, drops(WEATHERED_COPPER_GATE.asItem()));
			addDrop(OXIDIZED_COPPER_GATE, drops(OXIDIZED_COPPER_GATE.asItem()));
			addDrop(WAXED_COPPER_GATE, drops(WAXED_COPPER_GATE.asItem()));
			addDrop(WAXED_EXPOSED_COPPER_GATE, drops(WAXED_EXPOSED_COPPER_GATE.asItem()));
			addDrop(WAXED_WEATHERED_COPPER_GATE, drops(WAXED_WEATHERED_COPPER_GATE.asItem()));
			addDrop(WAXED_OXIDIZED_COPPER_GATE, drops(WAXED_OXIDIZED_COPPER_GATE.asItem()));

			addDrop(GOLD_TRAPDOOR, drops(GOLD_TRAPDOOR.asItem()));
			addDrop(GOLD_DOOR, drops(GOLD_DOOR.asItem()));
			addDrop(GOLD_BULB, drops(GOLD_BULB.asItem()));
			addDrop(CUT_GOLD, drops(CUT_GOLD.asItem()));
			addDrop(CHISELED_GOLD, drops(CHISELED_GOLD.asItem()));
			addDrop(GOLD_GRATE, drops(GOLD_GRATE.asItem()));
			addDrop(GOLD_LANTERN, drops(GOLD_LANTERN.asItem()));
			addDrop(GOLD_SOUL_LANTERN, drops(GOLD_SOUL_LANTERN.asItem()));
			addDrop(GOLD_REDSTONE_LANTERN, drops(GOLD_REDSTONE_LANTERN.asItem()));
			addDrop(GOLD_BARS, drops(GOLD_BARS.asItem()));
			addDrop(GOLD_GATE, drops(GOLD_GATE.asItem()));
			addDrop(GOLD_CHAIN, drops(GOLD_CHAIN.asItem()));

			addDrop(IRON_BULB, drops(IRON_BULB.asItem()));
			addDrop(CUT_IRON, drops(CUT_IRON.asItem()));
			addDrop(CHISELED_IRON, drops(CHISELED_IRON.asItem()));
			addDrop(IRON_GRATE, drops(IRON_GRATE.asItem()));
			addDrop(IRON_GATE, drops(IRON_GATE.asItem()));
			addDrop(IRON_REDSTONE_LANTERN, drops(IRON_REDSTONE_LANTERN.asItem()));

			addDrop(STONE_WALL, drops(STONE_WALL.asItem()));
			addDrop(POLISHED_STONE, drops(POLISHED_STONE.asItem()));
			addDrop(POLISHED_STONE_SLAB, drops(POLISHED_STONE_SLAB.asItem()));
			addDrop(POLISHED_STONE_STAIRS, drops(POLISHED_STONE_STAIRS.asItem()));
			addDrop(POLISHED_STONE_WALL, drops(POLISHED_STONE_WALL.asItem()));
			addDrop(STONE_TILES, drops(STONE_TILES.asItem()));
			addDrop(STONE_TILE_SLAB, drops(STONE_TILE_SLAB.asItem()));
			addDrop(STONE_TILE_STAIRS, drops(STONE_TILE_STAIRS.asItem()));
			addDrop(STONE_TILE_WALL, drops(STONE_TILE_WALL.asItem()));
			addDrop(CRACKED_STONE_TILES, drops(CRACKED_STONE_TILES.asItem()));
			addDrop(STONE_PILLAR, drops(STONE_PILLAR.asItem()));
			addDrop(CHISELED_STONE_PILLAR, drops(CHISELED_STONE_PILLAR.asItem()));
			addDrop(COBBLED_TUFF, drops(COBBLED_TUFF.asItem()));
			addDrop(COBBLED_TUFF_SLAB, drops(COBBLED_TUFF_SLAB.asItem()));
			addDrop(COBBLED_TUFF_STAIRS, drops(COBBLED_TUFF_STAIRS.asItem()));
			addDrop(COBBLED_TUFF_WALL, drops(COBBLED_TUFF_WALL.asItem()));
			addDrop(MOSSY_COBBLED_TUFF, drops(MOSSY_COBBLED_TUFF.asItem()));
			addDrop(MOSSY_COBBLED_TUFF_SLAB, drops(MOSSY_COBBLED_TUFF_SLAB.asItem()));
			addDrop(MOSSY_COBBLED_TUFF_STAIRS, drops(MOSSY_COBBLED_TUFF_STAIRS.asItem()));
			addDrop(MOSSY_COBBLED_TUFF_WALL, drops(MOSSY_COBBLED_TUFF_WALL.asItem()));
			addDrop(CRACKED_TUFF_BRICKS, drops(CRACKED_TUFF_BRICKS.asItem()));
			addDrop(MOSSY_TUFF_BRICKS, drops(MOSSY_TUFF_BRICKS.asItem()));
			addDrop(MOSSY_TUFF_BRICK_SLAB, drops(MOSSY_TUFF_BRICK_SLAB.asItem()));
			addDrop(MOSSY_TUFF_BRICK_STAIRS, drops(MOSSY_TUFF_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_TUFF_BRICK_WALL, drops(MOSSY_TUFF_BRICK_WALL.asItem()));
			addDrop(TUFF_TILES, drops(TUFF_TILES.asItem()));
			addDrop(TUFF_TILE_SLAB, drops(TUFF_TILE_SLAB.asItem()));
			addDrop(TUFF_TILE_STAIRS, drops(TUFF_TILE_STAIRS.asItem()));
			addDrop(TUFF_TILE_WALL, drops(TUFF_TILE_WALL.asItem()));
			addDrop(CRACKED_TUFF_TILES, drops(CRACKED_TUFF_TILES.asItem()));
			addDrop(TUFF_PILLAR, drops(TUFF_PILLAR.asItem()));
			addDrop(MOSSY_COBBLED_DEEPSLATE, drops(MOSSY_COBBLED_DEEPSLATE.asItem()));
			addDrop(MOSSY_COBBLED_DEEPSLATE_SLAB, drops(MOSSY_COBBLED_DEEPSLATE_SLAB.asItem()));
			addDrop(MOSSY_COBBLED_DEEPSLATE_STAIRS, drops(MOSSY_COBBLED_DEEPSLATE_STAIRS.asItem()));
			addDrop(MOSSY_COBBLED_DEEPSLATE_WALL, drops(MOSSY_COBBLED_DEEPSLATE_WALL.asItem()));
			addDrop(SCULKY_COBBLED_DEEPSLATE, drops(SCULKY_COBBLED_DEEPSLATE.asItem()));
			addDrop(SCULKY_COBBLED_DEEPSLATE_SLAB, drops(SCULKY_COBBLED_DEEPSLATE_SLAB.asItem()));
			addDrop(SCULKY_COBBLED_DEEPSLATE_STAIRS, drops(SCULKY_COBBLED_DEEPSLATE_STAIRS.asItem()));
			addDrop(SCULKY_COBBLED_DEEPSLATE_WALL, drops(SCULKY_COBBLED_DEEPSLATE_WALL.asItem()));
			addDrop(DEEPSLATE_SLAB, drops(DEEPSLATE_SLAB.asItem()));
			addDrop(DEEPSLATE_STAIRS, drops(DEEPSLATE_STAIRS.asItem()));
			addDrop(DEEPSLATE_WALL, drops(DEEPSLATE_WALL.asItem()));
			addDrop(MOSSY_DEEPSLATE_BRICKS, drops(MOSSY_DEEPSLATE_BRICKS.asItem()));
			addDrop(MOSSY_DEEPSLATE_BRICK_SLAB, drops(MOSSY_DEEPSLATE_BRICK_SLAB.asItem()));
			addDrop(MOSSY_DEEPSLATE_BRICK_STAIRS, drops(MOSSY_DEEPSLATE_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_DEEPSLATE_BRICK_WALL, drops(MOSSY_DEEPSLATE_BRICK_WALL.asItem()));
			addDrop(SCULKY_DEEPSLATE_BRICKS, drops(SCULKY_DEEPSLATE_BRICKS.asItem()));
			addDrop(SCULKY_DEEPSLATE_BRICK_SLAB, drops(SCULKY_DEEPSLATE_BRICK_SLAB.asItem()));
			addDrop(SCULKY_DEEPSLATE_BRICK_STAIRS, drops(SCULKY_DEEPSLATE_BRICK_STAIRS.asItem()));
			addDrop(SCULKY_DEEPSLATE_BRICK_WALL, drops(SCULKY_DEEPSLATE_BRICK_WALL.asItem()));
			addDrop(DEEPSLATE_PILLAR, drops(DEEPSLATE_PILLAR.asItem()));
			addDrop(CHISELED_DEEPSLATE_PILLAR, drops(CHISELED_DEEPSLATE_PILLAR.asItem()));
			addDrop(COBBLED_GRANITE, drops(COBBLED_GRANITE.asItem()));
			addDrop(COBBLED_GRANITE_SLAB, drops(COBBLED_GRANITE_SLAB.asItem()));
			addDrop(COBBLED_GRANITE_STAIRS, drops(COBBLED_GRANITE_STAIRS.asItem()));
			addDrop(COBBLED_GRANITE_WALL, drops(COBBLED_GRANITE_WALL.asItem()));
			addDrop(MOSSY_COBBLED_GRANITE, drops(MOSSY_COBBLED_GRANITE.asItem()));
			addDrop(MOSSY_COBBLED_GRANITE_SLAB, drops(MOSSY_COBBLED_GRANITE_SLAB.asItem()));
			addDrop(MOSSY_COBBLED_GRANITE_STAIRS, drops(MOSSY_COBBLED_GRANITE_STAIRS.asItem()));
			addDrop(MOSSY_COBBLED_GRANITE_WALL, drops(MOSSY_COBBLED_GRANITE_WALL.asItem()));
			addDrop(CRACKED_GRANITE_BRICKS, drops(CRACKED_GRANITE_BRICKS.asItem()));
			addDrop(GRANITE_BRICKS, drops(GRANITE_BRICKS.asItem()));
			addDrop(GRANITE_BRICK_SLAB, drops(GRANITE_BRICK_SLAB.asItem()));
			addDrop(GRANITE_BRICK_STAIRS, drops(GRANITE_BRICK_STAIRS.asItem()));
			addDrop(GRANITE_BRICK_WALL, drops(GRANITE_BRICK_WALL.asItem()));
			addDrop(MOSSY_GRANITE_BRICKS, drops(MOSSY_GRANITE_BRICKS.asItem()));
			addDrop(MOSSY_GRANITE_BRICK_SLAB, drops(MOSSY_GRANITE_BRICK_SLAB.asItem()));
			addDrop(MOSSY_GRANITE_BRICK_STAIRS, drops(MOSSY_GRANITE_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_GRANITE_BRICK_WALL, drops(MOSSY_GRANITE_BRICK_WALL.asItem()));
			addDrop(CHISELED_GRANITE, drops(CHISELED_GRANITE.asItem()));
			addDrop(POLISHED_GRANITE_WALL, drops(POLISHED_GRANITE_WALL.asItem()));
			addDrop(GRANITE_TILES, drops(GRANITE_TILES.asItem()));
			addDrop(GRANITE_TILE_SLAB, drops(GRANITE_TILE_SLAB.asItem()));
			addDrop(GRANITE_TILE_STAIRS, drops(GRANITE_TILE_STAIRS.asItem()));
			addDrop(GRANITE_TILE_WALL, drops(GRANITE_TILE_WALL.asItem()));
			addDrop(CRACKED_GRANITE_TILES, drops(CRACKED_GRANITE_TILES.asItem()));
			addDrop(GRANITE_PILLAR, drops(GRANITE_PILLAR.asItem()));
			addDrop(CHISELED_GRANITE_PILLAR, drops(CHISELED_GRANITE_PILLAR.asItem()));
			addDrop(COBBLED_ANDESITE, drops(COBBLED_ANDESITE.asItem()));
			addDrop(COBBLED_ANDESITE_SLAB, drops(COBBLED_ANDESITE_SLAB.asItem()));
			addDrop(COBBLED_ANDESITE_STAIRS, drops(COBBLED_ANDESITE_STAIRS.asItem()));
			addDrop(COBBLED_ANDESITE_WALL, drops(COBBLED_ANDESITE_WALL.asItem()));
			addDrop(MOSSY_COBBLED_ANDESITE, drops(MOSSY_COBBLED_ANDESITE.asItem()));
			addDrop(MOSSY_COBBLED_ANDESITE_SLAB, drops(MOSSY_COBBLED_ANDESITE_SLAB.asItem()));
			addDrop(MOSSY_COBBLED_ANDESITE_STAIRS, drops(MOSSY_COBBLED_ANDESITE_STAIRS.asItem()));
			addDrop(MOSSY_COBBLED_ANDESITE_WALL, drops(MOSSY_COBBLED_ANDESITE_WALL.asItem()));
			addDrop(CRACKED_ANDESITE_BRICKS, drops(CRACKED_ANDESITE_BRICKS.asItem()));
			addDrop(ANDESITE_BRICKS, drops(ANDESITE_BRICKS.asItem()));
			addDrop(ANDESITE_BRICK_SLAB, drops(ANDESITE_BRICK_SLAB.asItem()));
			addDrop(ANDESITE_BRICK_STAIRS, drops(ANDESITE_BRICK_STAIRS.asItem()));
			addDrop(ANDESITE_BRICK_WALL, drops(ANDESITE_BRICK_WALL.asItem()));
			addDrop(MOSSY_ANDESITE_BRICKS, drops(MOSSY_ANDESITE_BRICKS.asItem()));
			addDrop(MOSSY_ANDESITE_BRICK_SLAB, drops(MOSSY_ANDESITE_BRICK_SLAB.asItem()));
			addDrop(MOSSY_ANDESITE_BRICK_STAIRS, drops(MOSSY_ANDESITE_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_ANDESITE_BRICK_WALL, drops(MOSSY_ANDESITE_BRICK_WALL.asItem()));
			addDrop(CHISELED_ANDESITE, drops(CHISELED_ANDESITE.asItem()));
			addDrop(POLISHED_ANDESITE_WALL, drops(POLISHED_ANDESITE_WALL.asItem()));
			addDrop(ANDESITE_TILES, drops(ANDESITE_TILES.asItem()));
			addDrop(ANDESITE_TILE_SLAB, drops(ANDESITE_TILE_SLAB.asItem()));
			addDrop(ANDESITE_TILE_STAIRS, drops(ANDESITE_TILE_STAIRS.asItem()));
			addDrop(ANDESITE_TILE_WALL, drops(ANDESITE_TILE_WALL.asItem()));
			addDrop(CRACKED_ANDESITE_TILES, drops(CRACKED_ANDESITE_TILES.asItem()));
			addDrop(ANDESITE_PILLAR, drops(ANDESITE_PILLAR.asItem()));
			addDrop(CHISELED_ANDESITE_PILLAR, drops(CHISELED_ANDESITE_PILLAR.asItem()));
			addDrop(COBBLED_DIORITE, drops(COBBLED_DIORITE.asItem()));
			addDrop(COBBLED_DIORITE_SLAB, drops(COBBLED_DIORITE_SLAB.asItem()));
			addDrop(COBBLED_DIORITE_STAIRS, drops(COBBLED_DIORITE_STAIRS.asItem()));
			addDrop(COBBLED_DIORITE_WALL, drops(COBBLED_DIORITE_WALL.asItem()));
			addDrop(MOSSY_COBBLED_DIORITE, drops(MOSSY_COBBLED_DIORITE.asItem()));
			addDrop(MOSSY_COBBLED_DIORITE_SLAB, drops(MOSSY_COBBLED_DIORITE_SLAB.asItem()));
			addDrop(MOSSY_COBBLED_DIORITE_STAIRS, drops(MOSSY_COBBLED_DIORITE_STAIRS.asItem()));
			addDrop(MOSSY_COBBLED_DIORITE_WALL, drops(MOSSY_COBBLED_DIORITE_WALL.asItem()));
			addDrop(CRACKED_DIORITE_BRICKS, drops(CRACKED_DIORITE_BRICKS.asItem()));
			addDrop(DIORITE_BRICKS, drops(DIORITE_BRICKS.asItem()));
			addDrop(DIORITE_BRICK_SLAB, drops(DIORITE_BRICK_SLAB.asItem()));
			addDrop(DIORITE_BRICK_STAIRS, drops(DIORITE_BRICK_STAIRS.asItem()));
			addDrop(DIORITE_BRICK_WALL, drops(DIORITE_BRICK_WALL.asItem()));
			addDrop(MOSSY_DIORITE_BRICKS, drops(MOSSY_DIORITE_BRICKS.asItem()));
			addDrop(MOSSY_DIORITE_BRICK_SLAB, drops(MOSSY_DIORITE_BRICK_SLAB.asItem()));
			addDrop(MOSSY_DIORITE_BRICK_STAIRS, drops(MOSSY_DIORITE_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_DIORITE_BRICK_WALL, drops(MOSSY_DIORITE_BRICK_WALL.asItem()));
			addDrop(CHISELED_DIORITE, drops(CHISELED_DIORITE.asItem()));
			addDrop(POLISHED_DIORITE_WALL, drops(POLISHED_DIORITE_WALL.asItem()));
			addDrop(DIORITE_TILES, drops(DIORITE_TILES.asItem()));
			addDrop(DIORITE_TILE_SLAB, drops(DIORITE_TILE_SLAB.asItem()));
			addDrop(DIORITE_TILE_STAIRS, drops(DIORITE_TILE_STAIRS.asItem()));
			addDrop(DIORITE_TILE_WALL, drops(DIORITE_TILE_WALL.asItem()));
			addDrop(CRACKED_DIORITE_TILES, drops(CRACKED_DIORITE_TILES.asItem()));
			addDrop(DIORITE_PILLAR, drops(DIORITE_PILLAR.asItem()));
			addDrop(CHISELED_DIORITE_PILLAR, drops(CHISELED_DIORITE_PILLAR.asItem()));
			addDrop(COBBLED_BLACKSTONE, drops(COBBLED_BLACKSTONE.asItem()));
			addDrop(COBBLED_BLACKSTONE_SLAB, drops(COBBLED_BLACKSTONE_SLAB.asItem()));
			addDrop(COBBLED_BLACKSTONE_STAIRS, drops(COBBLED_BLACKSTONE_STAIRS.asItem()));
			addDrop(COBBLED_BLACKSTONE_WALL, drops(COBBLED_BLACKSTONE_WALL.asItem()));
			addDrop(CRIMSON_COBBLED_BLACKSTONE, drops(CRIMSON_COBBLED_BLACKSTONE.asItem()));
			addDrop(CRIMSON_COBBLED_BLACKSTONE_SLAB, drops(CRIMSON_COBBLED_BLACKSTONE_SLAB.asItem()));
			addDrop(CRIMSON_COBBLED_BLACKSTONE_STAIRS, drops(CRIMSON_COBBLED_BLACKSTONE_STAIRS.asItem()));
			addDrop(CRIMSON_COBBLED_BLACKSTONE_WALL, drops(CRIMSON_COBBLED_BLACKSTONE_WALL.asItem()));
			addDrop(CRIMSON_BLACKSTONE_BRICKS, drops(CRIMSON_BLACKSTONE_BRICKS.asItem()));
			addDrop(CRIMSON_BLACKSTONE_BRICK_SLAB, drops(CRIMSON_BLACKSTONE_BRICK_SLAB.asItem()));
			addDrop(CRIMSON_BLACKSTONE_BRICK_STAIRS, drops(CRIMSON_BLACKSTONE_BRICK_STAIRS.asItem()));
			addDrop(CRIMSON_BLACKSTONE_BRICK_WALL, drops(CRIMSON_BLACKSTONE_BRICK_WALL.asItem()));
			addDrop(WARPED_COBBLED_BLACKSTONE, drops(WARPED_COBBLED_BLACKSTONE.asItem()));
			addDrop(WARPED_COBBLED_BLACKSTONE_SLAB, drops(WARPED_COBBLED_BLACKSTONE_SLAB.asItem()));
			addDrop(WARPED_COBBLED_BLACKSTONE_STAIRS, drops(WARPED_COBBLED_BLACKSTONE_STAIRS.asItem()));
			addDrop(WARPED_COBBLED_BLACKSTONE_WALL, drops(WARPED_COBBLED_BLACKSTONE_WALL.asItem()));
			addDrop(WARPED_BLACKSTONE_BRICKS, drops(WARPED_BLACKSTONE_BRICKS.asItem()));
			addDrop(WARPED_BLACKSTONE_BRICK_SLAB, drops(WARPED_BLACKSTONE_BRICK_SLAB.asItem()));
			addDrop(WARPED_BLACKSTONE_BRICK_STAIRS, drops(WARPED_BLACKSTONE_BRICK_STAIRS.asItem()));
			addDrop(WARPED_BLACKSTONE_BRICK_WALL, drops(WARPED_BLACKSTONE_BRICK_WALL.asItem()));
			addDrop(BLACKSTONE_TILES, drops(BLACKSTONE_TILES.asItem()));
			addDrop(BLACKSTONE_TILE_SLAB, drops(BLACKSTONE_TILE_SLAB.asItem()));
			addDrop(BLACKSTONE_TILE_STAIRS, drops(BLACKSTONE_TILE_STAIRS.asItem()));
			addDrop(BLACKSTONE_TILE_WALL, drops(BLACKSTONE_TILE_WALL.asItem()));
			addDrop(CRACKED_BLACKSTONE_TILES, drops(CRACKED_BLACKSTONE_TILES.asItem()));
			addDrop(BLACKSTONE_PILLAR, drops(BLACKSTONE_PILLAR.asItem()));
			addDrop(CHISELED_BLACKSTONE_PILLAR, drops(CHISELED_BLACKSTONE_PILLAR.asItem()));
			addDrop(COBBLED_END_STONE, drops(COBBLED_END_STONE.asItem()));
			addDrop(COBBLED_END_STONE_SLAB, drops(COBBLED_END_STONE_SLAB.asItem()));
			addDrop(COBBLED_END_STONE_STAIRS, drops(COBBLED_END_STONE_STAIRS.asItem()));
			addDrop(COBBLED_END_STONE_WALL, drops(COBBLED_END_STONE_WALL.asItem()));
			addDrop(END_STONE_SLAB, drops(END_STONE_SLAB.asItem()));
			addDrop(END_STONE_STAIRS, drops(END_STONE_STAIRS.asItem()));
			addDrop(END_STONE_WALL, drops(END_STONE_WALL.asItem()));
			addDrop(PURPUR, drops(PURPUR.asItem()));
			addDrop(PURPUR_SLAB, drops(PURPUR_SLAB.asItem()));
			addDrop(PURPUR_STAIRS, drops(PURPUR_STAIRS.asItem()));
			addDrop(PURPUR_WALL, drops(PURPUR_WALL.asItem()));
			addDrop(MOLDY_COBBLED_END_STONE, drops(MOLDY_COBBLED_END_STONE.asItem()));
			addDrop(MOLDY_COBBLED_END_STONE_SLAB, drops(MOLDY_COBBLED_END_STONE_SLAB.asItem()));
			addDrop(MOLDY_COBBLED_END_STONE_STAIRS, drops(MOLDY_COBBLED_END_STONE_STAIRS.asItem()));
			addDrop(MOLDY_COBBLED_END_STONE_WALL, drops(MOLDY_COBBLED_END_STONE_WALL.asItem()));
			addDrop(CRACKED_END_STONE_BRICKS, drops(CRACKED_END_STONE_BRICKS.asItem()));
			addDrop(CRACKED_PURPUR_BRICKS, drops(CRACKED_PURPUR_BRICKS.asItem()));
			addDrop(MOLDY_END_STONE_BRICKS, drops(MOLDY_END_STONE_BRICKS.asItem()));
			addDrop(MOLDY_END_STONE_BRICK_SLAB, drops(MOLDY_END_STONE_BRICK_SLAB.asItem()));
			addDrop(MOLDY_END_STONE_BRICK_STAIRS, drops(MOLDY_END_STONE_BRICK_STAIRS.asItem()));
			addDrop(MOLDY_END_STONE_BRICK_WALL, drops(MOLDY_END_STONE_BRICK_WALL.asItem()));
			addDrop(MOLDY_PURPUR_BRICKS, drops(MOLDY_PURPUR_BRICKS.asItem()));
			addDrop(MOLDY_PURPUR_BRICK_SLAB, drops(MOLDY_PURPUR_BRICK_SLAB.asItem()));
			addDrop(MOLDY_PURPUR_BRICK_STAIRS, drops(MOLDY_PURPUR_BRICK_STAIRS.asItem()));
			addDrop(MOLDY_PURPUR_BRICK_WALL, drops(MOLDY_PURPUR_BRICK_WALL.asItem()));
			addDrop(CHISELED_END_STONE, drops(CHISELED_END_STONE.asItem()));
			addDrop(POLISHED_END_STONE, drops(POLISHED_END_STONE.asItem()));
			addDrop(POLISHED_END_STONE_SLAB, drops(POLISHED_END_STONE_SLAB.asItem()));
			addDrop(POLISHED_END_STONE_STAIRS, drops(POLISHED_END_STONE_STAIRS.asItem()));
			addDrop(POLISHED_END_STONE_WALL, drops(POLISHED_END_STONE_WALL.asItem()));
			addDrop(END_STONE_TILES, drops(END_STONE_TILES.asItem()));
			addDrop(END_STONE_TILE_SLAB, drops(END_STONE_TILE_SLAB.asItem()));
			addDrop(END_STONE_TILE_STAIRS, drops(END_STONE_TILE_STAIRS.asItem()));
			addDrop(END_STONE_TILE_WALL, drops(END_STONE_TILE_WALL.asItem()));
			addDrop(CRACKED_END_STONE_TILES, drops(CRACKED_END_STONE_TILES.asItem()));
			addDrop(END_STONE_PILLAR, drops(END_STONE_PILLAR.asItem()));
			addDrop(CHISELED_END_STONE_PILLAR, drops(CHISELED_END_STONE_PILLAR.asItem()));
			addDrop(CHISELED_PURPUR, drops(CHISELED_PURPUR.asItem()));
			addDrop(POLISHED_PURPUR, drops(POLISHED_PURPUR.asItem()));
			addDrop(POLISHED_PURPUR_SLAB, drops(POLISHED_PURPUR_SLAB.asItem()));
			addDrop(POLISHED_PURPUR_STAIRS, drops(POLISHED_PURPUR_STAIRS.asItem()));
			addDrop(POLISHED_PURPUR_WALL, drops(POLISHED_PURPUR_WALL.asItem()));
			addDrop(PURPUR_TILE_WALL, drops(PURPUR_TILE_WALL.asItem()));
			addDrop(CRACKED_PURPUR_TILES, drops(CRACKED_PURPUR_TILES.asItem()));
			addDrop(CHISELED_PURPUR_PILLAR, drops(CHISELED_PURPUR_PILLAR.asItem()));
			addDrop(MOSSY_SANDSTONE, drops(MOSSY_SANDSTONE.asItem()));
			addDrop(MOSSY_SANDSTONE_SLAB, drops(MOSSY_SANDSTONE_SLAB.asItem()));
			addDrop(MOSSY_SANDSTONE_STAIRS, drops(MOSSY_SANDSTONE_STAIRS.asItem()));
			addDrop(MOSSY_SANDSTONE_WALL, drops(MOSSY_SANDSTONE_WALL.asItem()));
			addDrop(CRACKED_SANDSTONE_BRICKS, drops(CRACKED_SANDSTONE_BRICKS.asItem()));
			addDrop(SMOOTH_SANDSTONE_WALL, drops(SMOOTH_SANDSTONE_WALL.asItem()));
			addDrop(SANDSTONE_BRICKS, drops(SANDSTONE_BRICKS.asItem()));
			addDrop(SANDSTONE_BRICK_SLAB, drops(SANDSTONE_BRICK_SLAB.asItem()));
			addDrop(SANDSTONE_BRICK_STAIRS, drops(SANDSTONE_BRICK_STAIRS.asItem()));
			addDrop(SANDSTONE_BRICK_WALL, drops(SANDSTONE_BRICK_WALL.asItem()));
			addDrop(MOSSY_SANDSTONE_BRICKS, drops(MOSSY_SANDSTONE_BRICKS.asItem()));
			addDrop(MOSSY_SANDSTONE_BRICK_SLAB, drops(MOSSY_SANDSTONE_BRICK_SLAB.asItem()));
			addDrop(MOSSY_SANDSTONE_BRICK_STAIRS, drops(MOSSY_SANDSTONE_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_SANDSTONE_BRICK_WALL, drops(MOSSY_SANDSTONE_BRICK_WALL.asItem()));
			addDrop(CUT_SANDSTONE_STAIRS, drops(CUT_SANDSTONE_STAIRS.asItem()));
//			addDrop(CUT_SANDSTONE_WALL, drops(CUT_SANDSTONE_WALL.asItem()));
			addDrop(SANDSTONE_TILES, drops(SANDSTONE_TILES.asItem()));
			addDrop(SANDSTONE_TILE_SLAB, drops(SANDSTONE_TILE_SLAB.asItem()));
			addDrop(SANDSTONE_TILE_STAIRS, drops(SANDSTONE_TILE_STAIRS.asItem()));
			addDrop(SANDSTONE_TILE_WALL, drops(SANDSTONE_TILE_WALL.asItem()));
			addDrop(CRACKED_SANDSTONE_TILES, drops(CRACKED_SANDSTONE_TILES.asItem()));
			addDrop(SANDSTONE_PILLAR, drops(SANDSTONE_PILLAR.asItem()));
			addDrop(CHISELED_SANDSTONE_PILLAR, drops(CHISELED_SANDSTONE_PILLAR.asItem()));
			addDrop(MOSSY_RED_SANDSTONE, drops(MOSSY_RED_SANDSTONE.asItem()));
			addDrop(MOSSY_RED_SANDSTONE_SLAB, drops(MOSSY_RED_SANDSTONE_SLAB.asItem()));
			addDrop(MOSSY_RED_SANDSTONE_STAIRS, drops(MOSSY_RED_SANDSTONE_STAIRS.asItem()));
			addDrop(MOSSY_RED_SANDSTONE_WALL, drops(MOSSY_RED_SANDSTONE_WALL.asItem()));
			addDrop(CRACKED_RED_SANDSTONE_BRICKS, drops(CRACKED_RED_SANDSTONE_BRICKS.asItem()));
			addDrop(SMOOTH_RED_SANDSTONE_WALL, drops(SMOOTH_RED_SANDSTONE_WALL.asItem()));
			addDrop(RED_SANDSTONE_BRICKS, drops(RED_SANDSTONE_BRICKS.asItem()));
			addDrop(RED_SANDSTONE_BRICK_SLAB, drops(RED_SANDSTONE_BRICK_SLAB.asItem()));
			addDrop(RED_SANDSTONE_BRICK_STAIRS, drops(RED_SANDSTONE_BRICK_STAIRS.asItem()));
			addDrop(RED_SANDSTONE_BRICK_WALL, drops(RED_SANDSTONE_BRICK_WALL.asItem()));
			addDrop(MOSSY_RED_SANDSTONE_BRICKS, drops(MOSSY_RED_SANDSTONE_BRICKS.asItem()));
			addDrop(MOSSY_RED_SANDSTONE_BRICK_SLAB, drops(MOSSY_RED_SANDSTONE_BRICK_SLAB.asItem()));
			addDrop(MOSSY_RED_SANDSTONE_BRICK_STAIRS, drops(MOSSY_RED_SANDSTONE_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_RED_SANDSTONE_BRICK_WALL, drops(MOSSY_RED_SANDSTONE_BRICK_WALL.asItem()));
			addDrop(CUT_RED_SANDSTONE_STAIRS, drops(CUT_RED_SANDSTONE_STAIRS.asItem()));
			addDrop(CUT_RED_SANDSTONE_WALL, drops(CUT_RED_SANDSTONE_WALL.asItem()));
			addDrop(RED_SANDSTONE_TILES, drops(RED_SANDSTONE_TILES.asItem()));
			addDrop(RED_SANDSTONE_TILE_SLAB, drops(RED_SANDSTONE_TILE_SLAB.asItem()));
			addDrop(RED_SANDSTONE_TILE_STAIRS, drops(RED_SANDSTONE_TILE_STAIRS.asItem()));
			addDrop(RED_SANDSTONE_TILE_WALL, drops(RED_SANDSTONE_TILE_WALL.asItem()));
			addDrop(CRACKED_RED_SANDSTONE_TILES, drops(CRACKED_RED_SANDSTONE_TILES.asItem()));
			addDrop(RED_SANDSTONE_PILLAR, drops(RED_SANDSTONE_PILLAR.asItem()));
			addDrop(CHISELED_RED_SANDSTONE_PILLAR, drops(CHISELED_RED_SANDSTONE_PILLAR.asItem()));
			addDrop(BARNACLED_PRISMARINE, drops(BARNACLED_PRISMARINE.asItem()));
			addDrop(BARNACLED_PRISMARINE_SLAB, drops(BARNACLED_PRISMARINE_SLAB.asItem()));
			addDrop(BARNACLED_PRISMARINE_STAIRS, drops(BARNACLED_PRISMARINE_STAIRS.asItem()));
			addDrop(BARNACLED_PRISMARINE_WALL, drops(BARNACLED_PRISMARINE_WALL.asItem()));
			addDrop(SMOOTH_PRISMARINE, drops(Blocks.PRISMARINE.asItem()));
			addDropWithSilkTouch(SMOOTH_PRISMARINE);
			addDrop(SMOOTH_PRISMARINE_SLAB, drops(SMOOTH_PRISMARINE_SLAB.asItem()));
			addDrop(SMOOTH_PRISMARINE_STAIRS, drops(SMOOTH_PRISMARINE_STAIRS.asItem()));
			addDrop(SMOOTH_PRISMARINE_WALL, drops(SMOOTH_PRISMARINE_WALL.asItem()));
			addDrop(CRACKED_PRISMARINE_BRICKS, drops(CRACKED_PRISMARINE_BRICKS.asItem()));
			addDrop(PRISMARINE_BRICK_WALL, drops(PRISMARINE_BRICK_WALL.asItem()));
			addDrop(BARNACLED_PRISMARINE_BRICKS, drops(BARNACLED_PRISMARINE_BRICKS.asItem()));
			addDrop(BARNACLED_PRISMARINE_BRICK_SLAB, drops(BARNACLED_PRISMARINE_BRICK_SLAB.asItem()));
			addDrop(BARNACLED_PRISMARINE_BRICK_STAIRS, drops(BARNACLED_PRISMARINE_BRICK_STAIRS.asItem()));
			addDrop(BARNACLED_PRISMARINE_BRICK_WALL, drops(BARNACLED_PRISMARINE_BRICK_WALL.asItem()));
			addDrop(CHISELED_PRISMARINE, drops(CHISELED_PRISMARINE.asItem()));
			addDrop(POLISHED_PRISMARINE, drops(POLISHED_PRISMARINE.asItem()));
			addDrop(POLISHED_PRISMARINE_SLAB, drops(POLISHED_PRISMARINE_SLAB.asItem()));
			addDrop(POLISHED_PRISMARINE_STAIRS, drops(POLISHED_PRISMARINE_STAIRS.asItem()));
			addDrop(POLISHED_PRISMARINE_WALL, drops(POLISHED_PRISMARINE_WALL.asItem()));
			addDrop(PRISMARINE_TILES, drops(PRISMARINE_TILES.asItem()));
			addDrop(PRISMARINE_TILE_SLAB, drops(PRISMARINE_TILE_SLAB.asItem()));
			addDrop(PRISMARINE_TILE_STAIRS, drops(PRISMARINE_TILE_STAIRS.asItem()));
			addDrop(PRISMARINE_TILE_WALL, drops(PRISMARINE_TILE_WALL.asItem()));
			addDrop(CRACKED_PRISMARINE_TILES, drops(CRACKED_PRISMARINE_TILES.asItem()));
			addDrop(PRISMARINE_PILLAR, drops(PRISMARINE_PILLAR.asItem()));
			addDrop(CHISELED_PRISMARINE_PILLAR, drops(CHISELED_PRISMARINE_PILLAR.asItem()));
			addDrop(DARK_PRISMARINE, drops(DARK_PRISMARINE.asItem()));
			addDrop(DARK_PRISMARINE_SLAB, drops(DARK_PRISMARINE_SLAB.asItem()));
			addDrop(DARK_PRISMARINE_STAIRS, drops(DARK_PRISMARINE_STAIRS.asItem()));
			addDrop(DARK_PRISMARINE_WALL, drops(DARK_PRISMARINE_WALL.asItem()));
			addDrop(BARNACLED_DARK_PRISMARINE, drops(BARNACLED_DARK_PRISMARINE.asItem()));
			addDrop(BARNACLED_DARK_PRISMARINE_SLAB, drops(BARNACLED_DARK_PRISMARINE_SLAB.asItem()));
			addDrop(BARNACLED_DARK_PRISMARINE_STAIRS, drops(BARNACLED_DARK_PRISMARINE_STAIRS.asItem()));
			addDrop(BARNACLED_DARK_PRISMARINE_WALL, drops(BARNACLED_DARK_PRISMARINE_WALL.asItem()));
			addDrop(SMOOTH_DARK_PRISMARINE, drops(DARK_PRISMARINE.asItem()));
			addDropWithSilkTouch(SMOOTH_DARK_PRISMARINE);
			addDrop(SMOOTH_DARK_PRISMARINE_SLAB, drops(SMOOTH_DARK_PRISMARINE_SLAB.asItem()));
			addDrop(SMOOTH_DARK_PRISMARINE_STAIRS, drops(SMOOTH_DARK_PRISMARINE_STAIRS.asItem()));
			addDrop(SMOOTH_DARK_PRISMARINE_WALL, drops(SMOOTH_DARK_PRISMARINE_WALL.asItem()));
			addDrop(CRACKED_DARK_PRISMARINE_BRICKS, drops(CRACKED_DARK_PRISMARINE_BRICKS.asItem()));
			addDrop(DARK_PRISMARINE_BRICKS, drops(DARK_PRISMARINE_BRICKS.asItem()));
			addDrop(DARK_PRISMARINE_BRICK_SLAB, drops(DARK_PRISMARINE_BRICK_SLAB.asItem()));
			addDrop(DARK_PRISMARINE_BRICK_STAIRS, drops(DARK_PRISMARINE_BRICK_STAIRS.asItem()));
			addDrop(DARK_PRISMARINE_BRICK_WALL, drops(DARK_PRISMARINE_BRICK_WALL.asItem()));
			addDrop(BARNACLED_DARK_PRISMARINE_BRICKS, drops(BARNACLED_DARK_PRISMARINE_BRICKS.asItem()));
			addDrop(BARNACLED_DARK_PRISMARINE_BRICK_SLAB, drops(BARNACLED_DARK_PRISMARINE_BRICK_SLAB.asItem()));
			addDrop(BARNACLED_DARK_PRISMARINE_BRICK_STAIRS, drops(BARNACLED_DARK_PRISMARINE_BRICK_STAIRS.asItem()));
			addDrop(BARNACLED_DARK_PRISMARINE_BRICK_WALL, drops(BARNACLED_DARK_PRISMARINE_BRICK_WALL.asItem()));
			addDrop(CHISELED_DARK_PRISMARINE, drops(CHISELED_DARK_PRISMARINE.asItem()));
			addDrop(POLISHED_DARK_PRISMARINE, drops(POLISHED_DARK_PRISMARINE.asItem()));
			addDrop(POLISHED_DARK_PRISMARINE_SLAB, drops(POLISHED_DARK_PRISMARINE_SLAB.asItem()));
			addDrop(POLISHED_DARK_PRISMARINE_STAIRS, drops(POLISHED_DARK_PRISMARINE_STAIRS.asItem()));
			addDrop(POLISHED_DARK_PRISMARINE_WALL, drops(POLISHED_DARK_PRISMARINE_WALL.asItem()));
			addDrop(DARK_PRISMARINE_TILE_WALL, drops(DARK_PRISMARINE_TILE_WALL.asItem()));
			addDrop(CRACKED_DARK_PRISMARINE_TILES, drops(CRACKED_DARK_PRISMARINE_TILES.asItem()));
			addDrop(DARK_PRISMARINE_PILLAR, drops(DARK_PRISMARINE_PILLAR.asItem()));
			addDrop(CHISELED_DARK_PRISMARINE_PILLAR, drops(CHISELED_DARK_PRISMARINE_PILLAR.asItem()));
			addDrop(NETHERRACK_SLAB, drops(NETHERRACK_SLAB.asItem()));
			addDrop(NETHERRACK_STAIRS, drops(NETHERRACK_STAIRS.asItem()));
			addDrop(NETHERRACK_WALL, drops(NETHERRACK_WALL.asItem()));
			addDrop(CRIMSON_NETHERRACK, drops(CRIMSON_NETHERRACK.asItem()));
			addDrop(CRIMSON_NETHERRACK_SLAB, drops(CRIMSON_NETHERRACK_SLAB.asItem()));
			addDrop(CRIMSON_NETHERRACK_STAIRS, drops(CRIMSON_NETHERRACK_STAIRS.asItem()));
			addDrop(CRIMSON_NETHERRACK_WALL, drops(CRIMSON_NETHERRACK_WALL.asItem()));
			addDrop(WARPED_NETHERRACK, drops(WARPED_NETHERRACK.asItem()));
			addDrop(WARPED_NETHERRACK_SLAB, drops(WARPED_NETHERRACK_SLAB.asItem()));
			addDrop(WARPED_NETHERRACK_STAIRS, drops(WARPED_NETHERRACK_STAIRS.asItem()));
			addDrop(WARPED_NETHERRACK_WALL, drops(WARPED_NETHERRACK_WALL.asItem()));
			addDrop(HARDENED_NETHERRACK, drops(HARDENED_NETHERRACK.asItem()));
			addDrop(HARDENED_NETHERRACK_SLAB, drops(HARDENED_NETHERRACK_SLAB.asItem()));
			addDrop(HARDENED_NETHERRACK_STAIRS, drops(HARDENED_NETHERRACK_STAIRS.asItem()));
			addDrop(HARDENED_NETHERRACK_WALL, drops(HARDENED_NETHERRACK_WALL.asItem()));
			addDrop(NETHER_BRICK_WALL, drops(NETHER_BRICK_WALL.asItem()));
			addDrop(CRIMSON_NETHER_BRICKS, drops(CRIMSON_NETHER_BRICKS.asItem()));
			addDrop(CRIMSON_NETHER_BRICK_SLAB, drops(CRIMSON_NETHER_BRICK_SLAB.asItem()));
			addDrop(CRIMSON_NETHER_BRICK_STAIRS, drops(CRIMSON_NETHER_BRICK_STAIRS.asItem()));
			addDrop(CRIMSON_NETHER_BRICK_WALL, drops(CRIMSON_NETHER_BRICK_WALL.asItem()));
			addDrop(WARPED_NETHER_BRICKS, drops(WARPED_NETHER_BRICKS.asItem()));
			addDrop(WARPED_NETHER_BRICK_SLAB, drops(WARPED_NETHER_BRICK_SLAB.asItem()));
			addDrop(WARPED_NETHER_BRICK_STAIRS, drops(WARPED_NETHER_BRICK_STAIRS.asItem()));
			addDrop(WARPED_NETHER_BRICK_WALL, drops(WARPED_NETHER_BRICK_WALL.asItem()));
			addDrop(POLISHED_HARDENED_NETHERRACK, drops(POLISHED_HARDENED_NETHERRACK.asItem()));
			addDrop(POLISHED_HARDENED_NETHERRACK_SLAB, drops(POLISHED_HARDENED_NETHERRACK_SLAB.asItem()));
			addDrop(POLISHED_HARDENED_NETHERRACK_STAIRS, drops(POLISHED_HARDENED_NETHERRACK_STAIRS.asItem()));
			addDrop(POLISHED_HARDENED_NETHERRACK_WALL, drops(POLISHED_HARDENED_NETHERRACK_WALL.asItem()));
			addDrop(NETHER_TILES, drops(NETHER_TILES.asItem()));
			addDrop(NETHER_TILE_SLAB, drops(NETHER_TILE_SLAB.asItem()));
			addDrop(NETHER_TILE_STAIRS, drops(NETHER_TILE_STAIRS.asItem()));
			addDrop(NETHER_TILE_WALL, drops(NETHER_TILE_WALL.asItem()));
			addDrop(CRACKED_NETHER_TILES, drops(CRACKED_NETHER_TILES.asItem()));
			addDrop(NETHER_PILLAR, drops(NETHER_PILLAR.asItem()));
			addDrop(CHISELED_NETHER_PILLAR, drops(CHISELED_NETHER_PILLAR.asItem()));
			addDrop(COBBLED_BASALT, drops(COBBLED_BASALT.asItem()));
			addDrop(COBBLED_BASALT_SLAB, drops(COBBLED_BASALT_SLAB.asItem()));
			addDrop(COBBLED_BASALT_STAIRS, drops(COBBLED_BASALT_STAIRS.asItem()));
			addDrop(COBBLED_BASALT_WALL, drops(COBBLED_BASALT_WALL.asItem()));
			addDrop(CRIMSON_COBBLED_BASALT, drops(CRIMSON_COBBLED_BASALT.asItem()));
			addDrop(CRIMSON_COBBLED_BASALT_SLAB, drops(CRIMSON_COBBLED_BASALT_SLAB.asItem()));
			addDrop(CRIMSON_COBBLED_BASALT_STAIRS, drops(CRIMSON_COBBLED_BASALT_STAIRS.asItem()));
			addDrop(CRIMSON_COBBLED_BASALT_WALL, drops(CRIMSON_COBBLED_BASALT_WALL.asItem()));
			addDrop(WARPED_COBBLED_BASALT, drops(WARPED_COBBLED_BASALT.asItem()));
			addDrop(WARPED_COBBLED_BASALT_SLAB, drops(WARPED_COBBLED_BASALT_SLAB.asItem()));
			addDrop(WARPED_COBBLED_BASALT_STAIRS, drops(WARPED_COBBLED_BASALT_STAIRS.asItem()));
			addDrop(WARPED_COBBLED_BASALT_WALL, drops(WARPED_COBBLED_BASALT_WALL.asItem()));
			addDrop(SMOOTH_BASALT_SLAB, drops(SMOOTH_BASALT_SLAB.asItem()));
			addDrop(SMOOTH_BASALT_STAIRS, drops(SMOOTH_BASALT_STAIRS.asItem()));
			addDrop(SMOOTH_BASALT_WALL, drops(SMOOTH_BASALT_WALL.asItem()));
			addDrop(BASALT_BRICKS, drops(BASALT_BRICKS.asItem()));
			addDrop(BASALT_BRICK_SLAB, drops(BASALT_BRICK_SLAB.asItem()));
			addDrop(BASALT_BRICK_STAIRS, drops(BASALT_BRICK_STAIRS.asItem()));
			addDrop(BASALT_BRICK_WALL, drops(BASALT_BRICK_WALL.asItem()));
			addDrop(CRACKED_BASALT_BRICKS, drops(CRACKED_BASALT_BRICKS.asItem()));
			addDrop(CRIMSON_BASALT_BRICKS, drops(CRIMSON_BASALT_BRICKS.asItem()));
			addDrop(CRIMSON_BASALT_BRICK_SLAB, drops(CRIMSON_BASALT_BRICK_SLAB.asItem()));
			addDrop(CRIMSON_BASALT_BRICK_STAIRS, drops(CRIMSON_BASALT_BRICK_STAIRS.asItem()));
			addDrop(CRIMSON_BASALT_BRICK_WALL, drops(CRIMSON_BASALT_BRICK_WALL.asItem()));
			addDrop(WARPED_BASALT_BRICKS, drops(WARPED_BASALT_BRICKS.asItem()));
			addDrop(WARPED_BASALT_BRICK_SLAB, drops(WARPED_BASALT_BRICK_SLAB.asItem()));
			addDrop(WARPED_BASALT_BRICK_STAIRS, drops(WARPED_BASALT_BRICK_STAIRS.asItem()));
			addDrop(WARPED_BASALT_BRICK_WALL, drops(WARPED_BASALT_BRICK_WALL.asItem()));
			addDrop(CHISELED_BASALT, drops(CHISELED_BASALT.asItem()));
			addDrop(POLISHED_BASALT, drops(POLISHED_BASALT.asItem()));
			addDrop(POLISHED_BASALT_SLAB, drops(POLISHED_BASALT_SLAB.asItem()));
			addDrop(POLISHED_BASALT_STAIRS, drops(POLISHED_BASALT_STAIRS.asItem()));
			addDrop(POLISHED_BASALT_WALL, drops(POLISHED_BASALT_WALL.asItem()));
			addDrop(BASALT_TILES, drops(BASALT_TILES.asItem()));
			addDrop(BASALT_TILE_SLAB, drops(BASALT_TILE_SLAB.asItem()));
			addDrop(BASALT_TILE_STAIRS, drops(BASALT_TILE_STAIRS.asItem()));
			addDrop(BASALT_TILE_WALL, drops(BASALT_TILE_WALL.asItem()));
			addDrop(CRACKED_BASALT_TILES, drops(CRACKED_BASALT_TILES.asItem()));
			addDrop(CHISELED_BASALT_PILLAR, drops(CHISELED_BASALT_PILLAR.asItem()));
			addDrop(COBBLED_CALCITE, drops(COBBLED_CALCITE.asItem()));
			addDrop(COBBLED_CALCITE_SLAB, drops(COBBLED_CALCITE_SLAB.asItem()));
			addDrop(COBBLED_CALCITE_STAIRS, drops(COBBLED_CALCITE_STAIRS.asItem()));
			addDrop(COBBLED_CALCITE_WALL, drops(COBBLED_CALCITE_WALL.asItem()));
			addDrop(MOSSY_COBBLED_CALCITE, drops(MOSSY_COBBLED_CALCITE.asItem()));
			addDrop(MOSSY_COBBLED_CALCITE_SLAB, drops(MOSSY_COBBLED_CALCITE_SLAB.asItem()));
			addDrop(MOSSY_COBBLED_CALCITE_STAIRS, drops(MOSSY_COBBLED_CALCITE_STAIRS.asItem()));
			addDrop(MOSSY_COBBLED_CALCITE_WALL, drops(MOSSY_COBBLED_CALCITE_WALL.asItem()));
			addDrop(CALCITE_SLAB, drops(CALCITE_SLAB.asItem()));
			addDrop(CALCITE_STAIRS, drops(CALCITE_STAIRS.asItem()));
			addDrop(CALCITE_WALL, drops(CALCITE_WALL.asItem()));
			addDrop(CALCITE_BRICKS, drops(CALCITE_BRICKS.asItem()));
			addDrop(CALCITE_BRICK_SLAB, drops(CALCITE_BRICK_SLAB.asItem()));
			addDrop(CALCITE_BRICK_STAIRS, drops(CALCITE_BRICK_STAIRS.asItem()));
			addDrop(CALCITE_BRICK_WALL, drops(CALCITE_BRICK_WALL.asItem()));
			addDrop(CRACKED_CALCITE_BRICKS, drops(CRACKED_CALCITE_BRICKS.asItem()));
			addDrop(MOSSY_CALCITE_BRICKS, drops(MOSSY_CALCITE_BRICKS.asItem()));
			addDrop(MOSSY_CALCITE_BRICK_SLAB, drops(MOSSY_CALCITE_BRICK_SLAB.asItem()));
			addDrop(MOSSY_CALCITE_BRICK_STAIRS, drops(MOSSY_CALCITE_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_CALCITE_BRICK_WALL, drops(MOSSY_CALCITE_BRICK_WALL.asItem()));
			addDrop(CHISELED_CALCITE, drops(CHISELED_CALCITE.asItem()));
			addDrop(POLISHED_CALCITE, drops(POLISHED_CALCITE.asItem()));
			addDrop(POLISHED_CALCITE_SLAB, drops(POLISHED_CALCITE_SLAB.asItem()));
			addDrop(POLISHED_CALCITE_STAIRS, drops(POLISHED_CALCITE_STAIRS.asItem()));
			addDrop(POLISHED_CALCITE_WALL, drops(POLISHED_CALCITE_WALL.asItem()));
			addDrop(CALCITE_TILES, drops(CALCITE_TILES.asItem()));
			addDrop(CALCITE_TILE_SLAB, drops(CALCITE_TILE_SLAB.asItem()));
			addDrop(CALCITE_TILE_STAIRS, drops(CALCITE_TILE_STAIRS.asItem()));
			addDrop(CALCITE_TILE_WALL, drops(CALCITE_TILE_WALL.asItem()));
			addDrop(CRACKED_CALCITE_TILES, drops(CRACKED_CALCITE_TILES.asItem()));
			addDrop(CALCITE_PILLAR, drops(CALCITE_PILLAR.asItem()));
			addDrop(CHISELED_CALCITE_PILLAR, drops(CHISELED_CALCITE_PILLAR.asItem()));
			addDrop(COBBLED_DRIPSTONE, drops(COBBLED_DRIPSTONE.asItem()));
			addDrop(COBBLED_DRIPSTONE_SLAB, drops(COBBLED_DRIPSTONE_SLAB.asItem()));
			addDrop(COBBLED_DRIPSTONE_STAIRS, drops(COBBLED_DRIPSTONE_STAIRS.asItem()));
			addDrop(COBBLED_DRIPSTONE_WALL, drops(COBBLED_DRIPSTONE_WALL.asItem()));
			addDrop(MOSSY_COBBLED_DRIPSTONE, drops(MOSSY_COBBLED_DRIPSTONE.asItem()));
			addDrop(MOSSY_COBBLED_DRIPSTONE_SLAB, drops(MOSSY_COBBLED_DRIPSTONE_SLAB.asItem()));
			addDrop(MOSSY_COBBLED_DRIPSTONE_STAIRS, drops(MOSSY_COBBLED_DRIPSTONE_STAIRS.asItem()));
			addDrop(MOSSY_COBBLED_DRIPSTONE_WALL, drops(MOSSY_COBBLED_DRIPSTONE_WALL.asItem()));
			addDrop(DRIPSTONE_SLAB, drops(DRIPSTONE_SLAB.asItem()));
			addDrop(DRIPSTONE_STAIRS, drops(DRIPSTONE_STAIRS.asItem()));
			addDrop(DRIPSTONE_WALL, drops(DRIPSTONE_WALL.asItem()));
			addDrop(DRIPSTONE_BRICKS, drops(DRIPSTONE_BRICKS.asItem()));
			addDrop(DRIPSTONE_BRICK_SLAB, drops(DRIPSTONE_BRICK_SLAB.asItem()));
			addDrop(DRIPSTONE_BRICK_STAIRS, drops(DRIPSTONE_BRICK_STAIRS.asItem()));
			addDrop(DRIPSTONE_BRICK_WALL, drops(DRIPSTONE_BRICK_WALL.asItem()));
			addDrop(CRACKED_DRIPSTONE_BRICKS, drops(CRACKED_DRIPSTONE_BRICKS.asItem()));
			addDrop(MOSSY_DRIPSTONE_BRICKS, drops(MOSSY_DRIPSTONE_BRICKS.asItem()));
			addDrop(MOSSY_DRIPSTONE_BRICK_SLAB, drops(MOSSY_DRIPSTONE_BRICK_SLAB.asItem()));
			addDrop(MOSSY_DRIPSTONE_BRICK_STAIRS, drops(MOSSY_DRIPSTONE_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_DRIPSTONE_BRICK_WALL, drops(MOSSY_DRIPSTONE_BRICK_WALL.asItem()));
			addDrop(CHISELED_DRIPSTONE, drops(CHISELED_DRIPSTONE.asItem()));
			addDrop(POLISHED_DRIPSTONE, drops(POLISHED_DRIPSTONE.asItem()));
			addDrop(POLISHED_DRIPSTONE_SLAB, drops(POLISHED_DRIPSTONE_SLAB.asItem()));
			addDrop(POLISHED_DRIPSTONE_STAIRS, drops(POLISHED_DRIPSTONE_STAIRS.asItem()));
			addDrop(POLISHED_DRIPSTONE_WALL, drops(POLISHED_DRIPSTONE_WALL.asItem()));
			addDrop(DRIPSTONE_TILES, drops(DRIPSTONE_TILES.asItem()));
			addDrop(DRIPSTONE_TILE_SLAB, drops(DRIPSTONE_TILE_SLAB.asItem()));
			addDrop(DRIPSTONE_TILE_STAIRS, drops(DRIPSTONE_TILE_STAIRS.asItem()));
			addDrop(DRIPSTONE_TILE_WALL, drops(DRIPSTONE_TILE_WALL.asItem()));
			addDrop(CRACKED_DRIPSTONE_TILES, drops(CRACKED_DRIPSTONE_TILES.asItem()));
			addDrop(DRIPSTONE_PILLAR, drops(DRIPSTONE_PILLAR.asItem()));
			addDrop(CHISELED_DRIPSTONE_PILLAR, drops(CHISELED_DRIPSTONE_PILLAR.asItem()));
			addDrop(SMOOTH_STONE, drops(SMOOTH_STONE.asItem()));
			addDrop(SMOOTH_STONE_SLAB, drops(SMOOTH_STONE_SLAB.asItem()));
			addDrop(SMOOTH_STONE_STAIRS, drops(SMOOTH_STONE_STAIRS.asItem()));
			addDrop(SMOOTH_STONE_WALL, drops(SMOOTH_STONE_WALL.asItem()));
			addDrop(SMOOTH_STONE_BRICKS, drops(SMOOTH_STONE_BRICKS.asItem()));
			addDrop(SMOOTH_STONE_BRICK_SLAB, drops(SMOOTH_STONE_BRICK_SLAB.asItem()));
			addDrop(SMOOTH_STONE_BRICK_STAIRS, drops(SMOOTH_STONE_BRICK_STAIRS.asItem()));
			addDrop(SMOOTH_STONE_BRICK_WALL, drops(SMOOTH_STONE_BRICK_WALL.asItem()));
			addDrop(CRACKED_SMOOTH_STONE_BRICKS, drops(CRACKED_SMOOTH_STONE_BRICKS.asItem()));
			addDrop(MOSSY_SMOOTH_STONE_BRICKS, drops(MOSSY_SMOOTH_STONE_BRICKS.asItem()));
			addDrop(MOSSY_SMOOTH_STONE_BRICK_SLAB, drops(MOSSY_SMOOTH_STONE_BRICK_SLAB.asItem()));
			addDrop(MOSSY_SMOOTH_STONE_BRICK_STAIRS, drops(MOSSY_SMOOTH_STONE_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_SMOOTH_STONE_BRICK_WALL, drops(MOSSY_SMOOTH_STONE_BRICK_WALL.asItem()));
			addDrop(CHISELED_SMOOTH_STONE, drops(CHISELED_SMOOTH_STONE.asItem()));
			addDrop(POLISHED_SMOOTH_STONE_STAIRS, drops(POLISHED_SMOOTH_STONE_STAIRS.asItem()));
			addDrop(POLISHED_SMOOTH_STONE_WALL, drops(POLISHED_SMOOTH_STONE_WALL.asItem()));
			addDrop(SMOOTH_STONE_TILES, drops(SMOOTH_STONE_TILES.asItem()));
			addDrop(SMOOTH_STONE_TILE_SLAB, drops(SMOOTH_STONE_TILE_SLAB.asItem()));
			addDrop(SMOOTH_STONE_TILE_STAIRS, drops(SMOOTH_STONE_TILE_STAIRS.asItem()));
			addDrop(SMOOTH_STONE_TILE_WALL, drops(SMOOTH_STONE_TILE_WALL.asItem()));
			addDrop(CRACKED_SMOOTH_STONE_TILES, drops(CRACKED_SMOOTH_STONE_TILES.asItem()));
			addDrop(SMOOTH_STONE_PILLAR, drops(SMOOTH_STONE_PILLAR.asItem()));
			addDrop(CHISELED_SMOOTH_STONE_PILLAR, drops(CHISELED_SMOOTH_STONE_PILLAR.asItem()));
			addDrop(RED_HARDENED_NETHERRACK, drops(RED_HARDENED_NETHERRACK.asItem()));
			addDrop(RED_HARDENED_NETHERRACK_SLAB, drops(RED_HARDENED_NETHERRACK_SLAB.asItem()));
			addDrop(RED_HARDENED_NETHERRACK_STAIRS, drops(RED_HARDENED_NETHERRACK_STAIRS.asItem()));
			addDrop(RED_HARDENED_NETHERRACK_WALL, drops(RED_HARDENED_NETHERRACK_WALL.asItem()));
			addDrop(CRIMSON_RED_NETHER_BRICKS, drops(CRIMSON_RED_NETHER_BRICKS.asItem()));
			addDrop(CRIMSON_RED_NETHER_BRICK_SLAB, drops(CRIMSON_RED_NETHER_BRICK_SLAB.asItem()));
			addDrop(CRIMSON_RED_NETHER_BRICK_STAIRS, drops(CRIMSON_RED_NETHER_BRICK_STAIRS.asItem()));
			addDrop(CRIMSON_RED_NETHER_BRICK_WALL, drops(CRIMSON_RED_NETHER_BRICK_WALL.asItem()));
			addDrop(WARPED_RED_NETHER_BRICKS, drops(WARPED_RED_NETHER_BRICKS.asItem()));
			addDrop(WARPED_RED_NETHER_BRICK_SLAB, drops(WARPED_RED_NETHER_BRICK_SLAB.asItem()));
			addDrop(WARPED_RED_NETHER_BRICK_STAIRS, drops(WARPED_RED_NETHER_BRICK_STAIRS.asItem()));
			addDrop(WARPED_RED_NETHER_BRICK_WALL, drops(WARPED_RED_NETHER_BRICK_WALL.asItem()));
			addDrop(CRACKED_RED_NETHER_BRICKS, drops(CRACKED_RED_NETHER_BRICKS.asItem()));
			addDrop(CHISELED_RED_HARDENED_NETHERRACK, drops(CHISELED_RED_HARDENED_NETHERRACK.asItem()));
			addDrop(POLISHED_RED_HARDENED_NETHERRACK, drops(POLISHED_RED_HARDENED_NETHERRACK.asItem()));
			addDrop(POLISHED_RED_HARDENED_NETHERRACK_SLAB, drops(POLISHED_RED_HARDENED_NETHERRACK_SLAB.asItem()));
			addDrop(POLISHED_RED_HARDENED_NETHERRACK_STAIRS, drops(POLISHED_RED_HARDENED_NETHERRACK_STAIRS.asItem()));
			addDrop(POLISHED_RED_HARDENED_NETHERRACK_WALL, drops(POLISHED_RED_HARDENED_NETHERRACK_WALL.asItem()));
			addDrop(RED_NETHER_TILES, drops(RED_NETHER_TILES.asItem()));
			addDrop(RED_NETHER_TILE_SLAB, drops(RED_NETHER_TILE_SLAB.asItem()));
			addDrop(RED_NETHER_TILE_STAIRS, drops(RED_NETHER_TILE_STAIRS.asItem()));
			addDrop(RED_NETHER_TILE_WALL, drops(RED_NETHER_TILE_WALL.asItem()));
			addDrop(CRACKED_RED_NETHER_TILES, drops(CRACKED_RED_NETHER_TILES.asItem()));
			addDrop(RED_NETHER_PILLAR, drops(RED_NETHER_PILLAR.asItem()));
			addDrop(CHISELED_RED_NETHER_PILLAR, drops(CHISELED_RED_NETHER_PILLAR.asItem()));
			addDrop(QUARTZ_WALL, drops(QUARTZ_WALL.asItem()));
			addDrop(CRACKED_QUARTZ_BRICKS, drops(CRACKED_QUARTZ_BRICKS.asItem()));
			addDrop(QUARTZ_BRICK_SLAB, drops(QUARTZ_BRICK_SLAB.asItem()));
			addDrop(QUARTZ_BRICK_STAIRS, drops(QUARTZ_BRICK_STAIRS.asItem()));
			addDrop(QUARTZ_BRICK_WALL, drops(QUARTZ_BRICK_WALL.asItem()));
			addDrop(CRIMSON_QUARTZ_BRICKS, drops(CRIMSON_QUARTZ_BRICKS.asItem()));
			addDrop(CRIMSON_QUARTZ_BRICK_SLAB, drops(CRIMSON_QUARTZ_BRICK_SLAB.asItem()));
			addDrop(CRIMSON_QUARTZ_BRICK_STAIRS, drops(CRIMSON_QUARTZ_BRICK_STAIRS.asItem()));
			addDrop(CRIMSON_QUARTZ_BRICK_WALL, drops(CRIMSON_QUARTZ_BRICK_WALL.asItem()));
			addDrop(WARPED_QUARTZ_BRICKS, drops(WARPED_QUARTZ_BRICKS.asItem()));
			addDrop(WARPED_QUARTZ_BRICK_SLAB, drops(WARPED_QUARTZ_BRICK_SLAB.asItem()));
			addDrop(WARPED_QUARTZ_BRICK_STAIRS, drops(WARPED_QUARTZ_BRICK_STAIRS.asItem()));
			addDrop(WARPED_QUARTZ_BRICK_WALL, drops(WARPED_QUARTZ_BRICK_WALL.asItem()));
			addDrop(POLISHED_QUARTZ_WALL, drops(POLISHED_QUARTZ_WALL.asItem()));
			addDrop(QUARTZ_TILES, drops(QUARTZ_TILES.asItem()));
			addDrop(QUARTZ_TILE_SLAB, drops(QUARTZ_TILE_SLAB.asItem()));
			addDrop(QUARTZ_TILE_STAIRS, drops(QUARTZ_TILE_STAIRS.asItem()));
			addDrop(QUARTZ_TILE_WALL, drops(QUARTZ_TILE_WALL.asItem()));
			addDrop(CRACKED_QUARTZ_TILES, drops(CRACKED_QUARTZ_TILES.asItem()));
			addDrop(CHISELED_QUARTZ_PILLAR, drops(CHISELED_QUARTZ_PILLAR.asItem()));
			addDrop(PACKED_MUD_SLAB, drops(PACKED_MUD_SLAB.asItem()));
			addDrop(PACKED_MUD_STAIRS, drops(PACKED_MUD_STAIRS.asItem()));
			addDrop(PACKED_MUD_WALL, drops(PACKED_MUD_WALL.asItem()));
			addDrop(CRACKED_MUD_BRICKS, drops(CRACKED_MUD_BRICKS.asItem()));
			addDrop(MOSSY_MUD_BRICKS, drops(MOSSY_MUD_BRICKS.asItem()));
			addDrop(MOSSY_MUD_BRICK_SLAB, drops(MOSSY_MUD_BRICK_SLAB.asItem()));
			addDrop(MOSSY_MUD_BRICK_STAIRS, drops(MOSSY_MUD_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_MUD_BRICK_WALL, drops(MOSSY_MUD_BRICK_WALL.asItem()));
			addDrop(CHISELED_PACKED_MUD, drops(CHISELED_PACKED_MUD.asItem()));
			addDrop(POLISHED_PACKED_MUD, drops(POLISHED_PACKED_MUD.asItem()));
			addDrop(POLISHED_PACKED_MUD_SLAB, drops(POLISHED_PACKED_MUD_SLAB.asItem()));
			addDrop(POLISHED_PACKED_MUD_STAIRS, drops(POLISHED_PACKED_MUD_STAIRS.asItem()));
			addDrop(POLISHED_PACKED_MUD_WALL, drops(POLISHED_PACKED_MUD_WALL.asItem()));
			addDrop(MUD_TILES, drops(MUD_TILES.asItem()));
			addDrop(MUD_TILE_SLAB, drops(MUD_TILE_SLAB.asItem()));
			addDrop(MUD_TILE_STAIRS, drops(MUD_TILE_STAIRS.asItem()));
			addDrop(MUD_TILE_WALL, drops(MUD_TILE_WALL.asItem()));
			addDrop(CRACKED_MUD_TILES, drops(CRACKED_MUD_TILES.asItem()));
			addDrop(PACKED_MUD_PILLAR, drops(PACKED_MUD_PILLAR.asItem()));
			addDrop(CHISELED_MUD_PILLAR, drops(CHISELED_MUD_PILLAR.asItem()));
			addDrop(TERRACOTTA_SLAB, drops(TERRACOTTA_SLAB.asItem()));
			addDrop(TERRACOTTA_STAIRS, drops(TERRACOTTA_STAIRS.asItem()));
			addDrop(TERRACOTTA_WALL, drops(TERRACOTTA_WALL.asItem()));
			addDrop(CRACKED_BRICKS, drops(CRACKED_BRICKS.asItem()));
			addDrop(MOSSY_BRICKS, drops(MOSSY_BRICKS.asItem()));
			addDrop(MOSSY_BRICK_SLAB, drops(MOSSY_BRICK_SLAB.asItem()));
			addDrop(MOSSY_BRICK_STAIRS, drops(MOSSY_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_BRICK_WALL, drops(MOSSY_BRICK_WALL.asItem()));
			addDrop(CHISELED_TERRACOTTA, drops(CHISELED_TERRACOTTA.asItem()));
			addDrop(POLISHED_TERRACOTTA, drops(POLISHED_TERRACOTTA.asItem()));
			addDrop(POLISHED_TERRACOTTA_SLAB, drops(POLISHED_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_TERRACOTTA_STAIRS, drops(POLISHED_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_TERRACOTTA_WALL, drops(POLISHED_TERRACOTTA_WALL.asItem()));
			addDrop(TERRACOTTA_TILES, drops(TERRACOTTA_TILES.asItem()));
			addDrop(TERRACOTTA_TILE_SLAB, drops(TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(TERRACOTTA_TILE_STAIRS, drops(TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(TERRACOTTA_TILE_WALL, drops(TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_TERRACOTTA_TILES, drops(CRACKED_TERRACOTTA_TILES.asItem()));
			addDrop(TERRACOTTA_PILLAR, drops(TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_TERRACOTTA_PILLAR, drops(CHISELED_TERRACOTTA_PILLAR.asItem()));
			addDrop(RED_TERRACOTTA_SLAB, drops(RED_TERRACOTTA_SLAB.asItem()));
			addDrop(RED_TERRACOTTA_STAIRS, drops(RED_TERRACOTTA_STAIRS.asItem()));
			addDrop(RED_TERRACOTTA_WALL, drops(RED_TERRACOTTA_WALL.asItem()));
			addDrop(RED_TERRACOTTA_BRICKS, drops(RED_TERRACOTTA_BRICKS.asItem()));
			addDrop(RED_TERRACOTTA_BRICK_SLAB, drops(RED_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(RED_TERRACOTTA_BRICK_STAIRS, drops(RED_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(RED_TERRACOTTA_BRICK_WALL, drops(RED_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CRACKED_RED_TERRACOTTA_BRICKS, drops(CRACKED_RED_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_RED_TERRACOTTA_BRICKS, drops(MOSSY_RED_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_RED_TERRACOTTA_BRICK_SLAB, drops(MOSSY_RED_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MOSSY_RED_TERRACOTTA_BRICK_STAIRS, drops(MOSSY_RED_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_RED_TERRACOTTA_BRICK_WALL, drops(MOSSY_RED_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CHISELED_RED_TERRACOTTA, drops(CHISELED_RED_TERRACOTTA.asItem()));
			addDrop(POLISHED_RED_TERRACOTTA, drops(POLISHED_RED_TERRACOTTA.asItem()));
			addDrop(POLISHED_RED_TERRACOTTA_SLAB, drops(POLISHED_RED_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_RED_TERRACOTTA_STAIRS, drops(POLISHED_RED_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_RED_TERRACOTTA_WALL, drops(POLISHED_RED_TERRACOTTA_WALL.asItem()));
			addDrop(RED_TERRACOTTA_TILES, drops(RED_TERRACOTTA_TILES.asItem()));
			addDrop(RED_TERRACOTTA_TILE_SLAB, drops(RED_TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(RED_TERRACOTTA_TILE_STAIRS, drops(RED_TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(RED_TERRACOTTA_TILE_WALL, drops(RED_TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_RED_TERRACOTTA_TILES, drops(CRACKED_RED_TERRACOTTA_TILES.asItem()));
			addDrop(RED_TERRACOTTA_PILLAR, drops(RED_TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_RED_TERRACOTTA_PILLAR, drops(CHISELED_RED_TERRACOTTA_PILLAR.asItem()));
			addDrop(ORANGE_TERRACOTTA_SLAB, drops(ORANGE_TERRACOTTA_SLAB.asItem()));
			addDrop(ORANGE_TERRACOTTA_STAIRS, drops(ORANGE_TERRACOTTA_STAIRS.asItem()));
			addDrop(ORANGE_TERRACOTTA_WALL, drops(ORANGE_TERRACOTTA_WALL.asItem()));
			addDrop(ORANGE_TERRACOTTA_BRICKS, drops(ORANGE_TERRACOTTA_BRICKS.asItem()));
			addDrop(ORANGE_TERRACOTTA_BRICK_SLAB, drops(ORANGE_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(ORANGE_TERRACOTTA_BRICK_STAIRS, drops(ORANGE_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(ORANGE_TERRACOTTA_BRICK_WALL, drops(ORANGE_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CRACKED_ORANGE_TERRACOTTA_BRICKS, drops(CRACKED_ORANGE_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_ORANGE_TERRACOTTA_BRICKS, drops(MOSSY_ORANGE_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_ORANGE_TERRACOTTA_BRICK_SLAB, drops(MOSSY_ORANGE_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MOSSY_ORANGE_TERRACOTTA_BRICK_STAIRS, drops(MOSSY_ORANGE_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_ORANGE_TERRACOTTA_BRICK_WALL, drops(MOSSY_ORANGE_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CHISELED_ORANGE_TERRACOTTA, drops(CHISELED_ORANGE_TERRACOTTA.asItem()));
			addDrop(POLISHED_ORANGE_TERRACOTTA, drops(POLISHED_ORANGE_TERRACOTTA.asItem()));
			addDrop(POLISHED_ORANGE_TERRACOTTA_SLAB, drops(POLISHED_ORANGE_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_ORANGE_TERRACOTTA_STAIRS, drops(POLISHED_ORANGE_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_ORANGE_TERRACOTTA_WALL, drops(POLISHED_ORANGE_TERRACOTTA_WALL.asItem()));
			addDrop(ORANGE_TERRACOTTA_TILES, drops(ORANGE_TERRACOTTA_TILES.asItem()));
			addDrop(ORANGE_TERRACOTTA_TILE_SLAB, drops(ORANGE_TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(ORANGE_TERRACOTTA_TILE_STAIRS, drops(ORANGE_TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(ORANGE_TERRACOTTA_TILE_WALL, drops(ORANGE_TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_ORANGE_TERRACOTTA_TILES, drops(CRACKED_ORANGE_TERRACOTTA_TILES.asItem()));
			addDrop(ORANGE_TERRACOTTA_PILLAR, drops(ORANGE_TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_ORANGE_TERRACOTTA_PILLAR, drops(CHISELED_ORANGE_TERRACOTTA_PILLAR.asItem()));
			addDrop(YELLOW_TERRACOTTA_SLAB, drops(YELLOW_TERRACOTTA_SLAB.asItem()));
			addDrop(YELLOW_TERRACOTTA_STAIRS, drops(YELLOW_TERRACOTTA_STAIRS.asItem()));
			addDrop(YELLOW_TERRACOTTA_WALL, drops(YELLOW_TERRACOTTA_WALL.asItem()));
			addDrop(YELLOW_TERRACOTTA_BRICKS, drops(YELLOW_TERRACOTTA_BRICKS.asItem()));
			addDrop(YELLOW_TERRACOTTA_BRICK_SLAB, drops(YELLOW_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(YELLOW_TERRACOTTA_BRICK_STAIRS, drops(YELLOW_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(YELLOW_TERRACOTTA_BRICK_WALL, drops(YELLOW_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CRACKED_YELLOW_TERRACOTTA_BRICKS, drops(CRACKED_YELLOW_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_YELLOW_TERRACOTTA_BRICKS, drops(MOSSY_YELLOW_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_YELLOW_TERRACOTTA_BRICK_SLAB, drops(MOSSY_YELLOW_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MOSSY_YELLOW_TERRACOTTA_BRICK_STAIRS, drops(MOSSY_YELLOW_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_YELLOW_TERRACOTTA_BRICK_WALL, drops(MOSSY_YELLOW_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CHISELED_YELLOW_TERRACOTTA, drops(CHISELED_YELLOW_TERRACOTTA.asItem()));
			addDrop(POLISHED_YELLOW_TERRACOTTA, drops(POLISHED_YELLOW_TERRACOTTA.asItem()));
			addDrop(POLISHED_YELLOW_TERRACOTTA_SLAB, drops(POLISHED_YELLOW_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_YELLOW_TERRACOTTA_STAIRS, drops(POLISHED_YELLOW_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_YELLOW_TERRACOTTA_WALL, drops(POLISHED_YELLOW_TERRACOTTA_WALL.asItem()));
			addDrop(YELLOW_TERRACOTTA_TILES, drops(YELLOW_TERRACOTTA_TILES.asItem()));
			addDrop(YELLOW_TERRACOTTA_TILE_SLAB, drops(YELLOW_TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(YELLOW_TERRACOTTA_TILE_STAIRS, drops(YELLOW_TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(YELLOW_TERRACOTTA_TILE_WALL, drops(YELLOW_TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_YELLOW_TERRACOTTA_TILES, drops(CRACKED_YELLOW_TERRACOTTA_TILES.asItem()));
			addDrop(YELLOW_TERRACOTTA_PILLAR, drops(YELLOW_TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_YELLOW_TERRACOTTA_PILLAR, drops(CHISELED_YELLOW_TERRACOTTA_PILLAR.asItem()));
			addDrop(LIME_TERRACOTTA_SLAB, drops(LIME_TERRACOTTA_SLAB.asItem()));
			addDrop(LIME_TERRACOTTA_STAIRS, drops(LIME_TERRACOTTA_STAIRS.asItem()));
			addDrop(LIME_TERRACOTTA_WALL, drops(LIME_TERRACOTTA_WALL.asItem()));
			addDrop(LIME_TERRACOTTA_BRICKS, drops(LIME_TERRACOTTA_BRICKS.asItem()));
			addDrop(LIME_TERRACOTTA_BRICK_SLAB, drops(LIME_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(LIME_TERRACOTTA_BRICK_STAIRS, drops(LIME_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(LIME_TERRACOTTA_BRICK_WALL, drops(LIME_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CRACKED_LIME_TERRACOTTA_BRICKS, drops(CRACKED_LIME_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_LIME_TERRACOTTA_BRICKS, drops(MOSSY_LIME_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_LIME_TERRACOTTA_BRICK_SLAB, drops(MOSSY_LIME_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MOSSY_LIME_TERRACOTTA_BRICK_STAIRS, drops(MOSSY_LIME_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_LIME_TERRACOTTA_BRICK_WALL, drops(MOSSY_LIME_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CHISELED_LIME_TERRACOTTA, drops(CHISELED_LIME_TERRACOTTA.asItem()));
			addDrop(POLISHED_LIME_TERRACOTTA, drops(POLISHED_LIME_TERRACOTTA.asItem()));
			addDrop(POLISHED_LIME_TERRACOTTA_SLAB, drops(POLISHED_LIME_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_LIME_TERRACOTTA_STAIRS, drops(POLISHED_LIME_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_LIME_TERRACOTTA_WALL, drops(POLISHED_LIME_TERRACOTTA_WALL.asItem()));
			addDrop(LIME_TERRACOTTA_TILES, drops(LIME_TERRACOTTA_TILES.asItem()));
			addDrop(LIME_TERRACOTTA_TILE_SLAB, drops(LIME_TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(LIME_TERRACOTTA_TILE_STAIRS, drops(LIME_TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(LIME_TERRACOTTA_TILE_WALL, drops(LIME_TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_LIME_TERRACOTTA_TILES, drops(CRACKED_LIME_TERRACOTTA_TILES.asItem()));
			addDrop(LIME_TERRACOTTA_PILLAR, drops(LIME_TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_LIME_TERRACOTTA_PILLAR, drops(CHISELED_LIME_TERRACOTTA_PILLAR.asItem()));
			addDrop(GREEN_TERRACOTTA_SLAB, drops(GREEN_TERRACOTTA_SLAB.asItem()));
			addDrop(GREEN_TERRACOTTA_STAIRS, drops(GREEN_TERRACOTTA_STAIRS.asItem()));
			addDrop(GREEN_TERRACOTTA_WALL, drops(GREEN_TERRACOTTA_WALL.asItem()));
			addDrop(GREEN_TERRACOTTA_BRICKS, drops(GREEN_TERRACOTTA_BRICKS.asItem()));
			addDrop(GREEN_TERRACOTTA_BRICK_SLAB, drops(GREEN_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(GREEN_TERRACOTTA_BRICK_STAIRS, drops(GREEN_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(GREEN_TERRACOTTA_BRICK_WALL, drops(GREEN_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CRACKED_GREEN_TERRACOTTA_BRICKS, drops(CRACKED_GREEN_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_GREEN_TERRACOTTA_BRICKS, drops(MOSSY_GREEN_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_GREEN_TERRACOTTA_BRICK_SLAB, drops(MOSSY_GREEN_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MOSSY_GREEN_TERRACOTTA_BRICK_STAIRS, drops(MOSSY_GREEN_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_GREEN_TERRACOTTA_BRICK_WALL, drops(MOSSY_GREEN_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CHISELED_GREEN_TERRACOTTA, drops(CHISELED_GREEN_TERRACOTTA.asItem()));
			addDrop(POLISHED_GREEN_TERRACOTTA, drops(POLISHED_GREEN_TERRACOTTA.asItem()));
			addDrop(POLISHED_GREEN_TERRACOTTA_SLAB, drops(POLISHED_GREEN_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_GREEN_TERRACOTTA_STAIRS, drops(POLISHED_GREEN_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_GREEN_TERRACOTTA_WALL, drops(POLISHED_GREEN_TERRACOTTA_WALL.asItem()));
			addDrop(GREEN_TERRACOTTA_TILES, drops(GREEN_TERRACOTTA_TILES.asItem()));
			addDrop(GREEN_TERRACOTTA_TILE_SLAB, drops(GREEN_TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(GREEN_TERRACOTTA_TILE_STAIRS, drops(GREEN_TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(GREEN_TERRACOTTA_TILE_WALL, drops(GREEN_TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_GREEN_TERRACOTTA_TILES, drops(CRACKED_GREEN_TERRACOTTA_TILES.asItem()));
			addDrop(GREEN_TERRACOTTA_PILLAR, drops(GREEN_TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_GREEN_TERRACOTTA_PILLAR, drops(CHISELED_GREEN_TERRACOTTA_PILLAR.asItem()));
			addDrop(CYAN_TERRACOTTA_SLAB, drops(CYAN_TERRACOTTA_SLAB.asItem()));
			addDrop(CYAN_TERRACOTTA_STAIRS, drops(CYAN_TERRACOTTA_STAIRS.asItem()));
			addDrop(CYAN_TERRACOTTA_WALL, drops(CYAN_TERRACOTTA_WALL.asItem()));
			addDrop(CYAN_TERRACOTTA_BRICKS, drops(CYAN_TERRACOTTA_BRICKS.asItem()));
			addDrop(CYAN_TERRACOTTA_BRICK_SLAB, drops(CYAN_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(CYAN_TERRACOTTA_BRICK_STAIRS, drops(CYAN_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(CYAN_TERRACOTTA_BRICK_WALL, drops(CYAN_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CRACKED_CYAN_TERRACOTTA_BRICKS, drops(CRACKED_CYAN_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_CYAN_TERRACOTTA_BRICKS, drops(MOSSY_CYAN_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_CYAN_TERRACOTTA_BRICK_SLAB, drops(MOSSY_CYAN_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MOSSY_CYAN_TERRACOTTA_BRICK_STAIRS, drops(MOSSY_CYAN_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_CYAN_TERRACOTTA_BRICK_WALL, drops(MOSSY_CYAN_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CHISELED_CYAN_TERRACOTTA, drops(CHISELED_CYAN_TERRACOTTA.asItem()));
			addDrop(POLISHED_CYAN_TERRACOTTA, drops(POLISHED_CYAN_TERRACOTTA.asItem()));
			addDrop(POLISHED_CYAN_TERRACOTTA_SLAB, drops(POLISHED_CYAN_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_CYAN_TERRACOTTA_STAIRS, drops(POLISHED_CYAN_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_CYAN_TERRACOTTA_WALL, drops(POLISHED_CYAN_TERRACOTTA_WALL.asItem()));
			addDrop(CYAN_TERRACOTTA_TILES, drops(CYAN_TERRACOTTA_TILES.asItem()));
			addDrop(CYAN_TERRACOTTA_TILE_SLAB, drops(CYAN_TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(CYAN_TERRACOTTA_TILE_STAIRS, drops(CYAN_TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(CYAN_TERRACOTTA_TILE_WALL, drops(CYAN_TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_CYAN_TERRACOTTA_TILES, drops(CRACKED_CYAN_TERRACOTTA_TILES.asItem()));
			addDrop(CYAN_TERRACOTTA_PILLAR, drops(CYAN_TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_CYAN_TERRACOTTA_PILLAR, drops(CHISELED_CYAN_TERRACOTTA_PILLAR.asItem()));
			addDrop(LIGHT_BLUE_TERRACOTTA_SLAB, drops(LIGHT_BLUE_TERRACOTTA_SLAB.asItem()));
			addDrop(LIGHT_BLUE_TERRACOTTA_STAIRS, drops(LIGHT_BLUE_TERRACOTTA_STAIRS.asItem()));
			addDrop(LIGHT_BLUE_TERRACOTTA_WALL, drops(LIGHT_BLUE_TERRACOTTA_WALL.asItem()));
			addDrop(LIGHT_BLUE_TERRACOTTA_BRICKS, drops(LIGHT_BLUE_TERRACOTTA_BRICKS.asItem()));
			addDrop(LIGHT_BLUE_TERRACOTTA_BRICK_SLAB, drops(LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS, drops(LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(LIGHT_BLUE_TERRACOTTA_BRICK_WALL, drops(LIGHT_BLUE_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CRACKED_LIGHT_BLUE_TERRACOTTA_BRICKS, drops(CRACKED_LIGHT_BLUE_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_LIGHT_BLUE_TERRACOTTA_BRICKS, drops(MOSSY_LIGHT_BLUE_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_LIGHT_BLUE_TERRACOTTA_BRICK_SLAB, drops(MOSSY_LIGHT_BLUE_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MOSSY_LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS, drops(MOSSY_LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_LIGHT_BLUE_TERRACOTTA_BRICK_WALL, drops(MOSSY_LIGHT_BLUE_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CHISELED_LIGHT_BLUE_TERRACOTTA, drops(CHISELED_LIGHT_BLUE_TERRACOTTA.asItem()));
			addDrop(POLISHED_LIGHT_BLUE_TERRACOTTA, drops(POLISHED_LIGHT_BLUE_TERRACOTTA.asItem()));
			addDrop(POLISHED_LIGHT_BLUE_TERRACOTTA_SLAB, drops(POLISHED_LIGHT_BLUE_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_LIGHT_BLUE_TERRACOTTA_STAIRS, drops(POLISHED_LIGHT_BLUE_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_LIGHT_BLUE_TERRACOTTA_WALL, drops(POLISHED_LIGHT_BLUE_TERRACOTTA_WALL.asItem()));
			addDrop(LIGHT_BLUE_TERRACOTTA_TILES, drops(LIGHT_BLUE_TERRACOTTA_TILES.asItem()));
			addDrop(LIGHT_BLUE_TERRACOTTA_TILE_SLAB, drops(LIGHT_BLUE_TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(LIGHT_BLUE_TERRACOTTA_TILE_STAIRS, drops(LIGHT_BLUE_TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(LIGHT_BLUE_TERRACOTTA_TILE_WALL, drops(LIGHT_BLUE_TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_LIGHT_BLUE_TERRACOTTA_TILES, drops(CRACKED_LIGHT_BLUE_TERRACOTTA_TILES.asItem()));
			addDrop(LIGHT_BLUE_TERRACOTTA_PILLAR, drops(LIGHT_BLUE_TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_LIGHT_BLUE_TERRACOTTA_PILLAR, drops(CHISELED_LIGHT_BLUE_TERRACOTTA_PILLAR.asItem()));
			addDrop(BLUE_TERRACOTTA_SLAB, drops(BLUE_TERRACOTTA_SLAB.asItem()));
			addDrop(BLUE_TERRACOTTA_STAIRS, drops(BLUE_TERRACOTTA_STAIRS.asItem()));
			addDrop(BLUE_TERRACOTTA_WALL, drops(BLUE_TERRACOTTA_WALL.asItem()));
			addDrop(BLUE_TERRACOTTA_BRICKS, drops(BLUE_TERRACOTTA_BRICKS.asItem()));
			addDrop(BLUE_TERRACOTTA_BRICK_SLAB, drops(BLUE_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(BLUE_TERRACOTTA_BRICK_STAIRS, drops(BLUE_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(BLUE_TERRACOTTA_BRICK_WALL, drops(BLUE_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CRACKED_BLUE_TERRACOTTA_BRICKS, drops(CRACKED_BLUE_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_BLUE_TERRACOTTA_BRICKS, drops(MOSSY_BLUE_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_BLUE_TERRACOTTA_BRICK_SLAB, drops(MOSSY_BLUE_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MOSSY_BLUE_TERRACOTTA_BRICK_STAIRS, drops(MOSSY_BLUE_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_BLUE_TERRACOTTA_BRICK_WALL, drops(MOSSY_BLUE_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CHISELED_BLUE_TERRACOTTA, drops(CHISELED_BLUE_TERRACOTTA.asItem()));
			addDrop(POLISHED_BLUE_TERRACOTTA, drops(POLISHED_BLUE_TERRACOTTA.asItem()));
			addDrop(POLISHED_BLUE_TERRACOTTA_SLAB, drops(POLISHED_BLUE_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_BLUE_TERRACOTTA_STAIRS, drops(POLISHED_BLUE_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_BLUE_TERRACOTTA_WALL, drops(POLISHED_BLUE_TERRACOTTA_WALL.asItem()));
			addDrop(BLUE_TERRACOTTA_TILES, drops(BLUE_TERRACOTTA_TILES.asItem()));
			addDrop(BLUE_TERRACOTTA_TILE_SLAB, drops(BLUE_TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(BLUE_TERRACOTTA_TILE_STAIRS, drops(BLUE_TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(BLUE_TERRACOTTA_TILE_WALL, drops(BLUE_TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_BLUE_TERRACOTTA_TILES, drops(CRACKED_BLUE_TERRACOTTA_TILES.asItem()));
			addDrop(BLUE_TERRACOTTA_PILLAR, drops(BLUE_TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_BLUE_TERRACOTTA_PILLAR, drops(CHISELED_BLUE_TERRACOTTA_PILLAR.asItem()));
			addDrop(PURPLE_TERRACOTTA_SLAB, drops(PURPLE_TERRACOTTA_SLAB.asItem()));
			addDrop(PURPLE_TERRACOTTA_STAIRS, drops(PURPLE_TERRACOTTA_STAIRS.asItem()));
			addDrop(PURPLE_TERRACOTTA_WALL, drops(PURPLE_TERRACOTTA_WALL.asItem()));
			addDrop(PURPLE_TERRACOTTA_BRICKS, drops(PURPLE_TERRACOTTA_BRICKS.asItem()));
			addDrop(PURPLE_TERRACOTTA_BRICK_SLAB, drops(PURPLE_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(PURPLE_TERRACOTTA_BRICK_STAIRS, drops(PURPLE_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(PURPLE_TERRACOTTA_BRICK_WALL, drops(PURPLE_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CRACKED_PURPLE_TERRACOTTA_BRICKS, drops(CRACKED_PURPLE_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_PURPLE_TERRACOTTA_BRICKS, drops(MOSSY_PURPLE_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_PURPLE_TERRACOTTA_BRICK_SLAB, drops(MOSSY_PURPLE_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MOSSY_PURPLE_TERRACOTTA_BRICK_STAIRS, drops(MOSSY_PURPLE_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_PURPLE_TERRACOTTA_BRICK_WALL, drops(MOSSY_PURPLE_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CHISELED_PURPLE_TERRACOTTA, drops(CHISELED_PURPLE_TERRACOTTA.asItem()));
			addDrop(POLISHED_PURPLE_TERRACOTTA, drops(POLISHED_PURPLE_TERRACOTTA.asItem()));
			addDrop(POLISHED_PURPLE_TERRACOTTA_SLAB, drops(POLISHED_PURPLE_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_PURPLE_TERRACOTTA_STAIRS, drops(POLISHED_PURPLE_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_PURPLE_TERRACOTTA_WALL, drops(POLISHED_PURPLE_TERRACOTTA_WALL.asItem()));
			addDrop(PURPLE_TERRACOTTA_TILES, drops(PURPLE_TERRACOTTA_TILES.asItem()));
			addDrop(PURPLE_TERRACOTTA_TILE_SLAB, drops(PURPLE_TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(PURPLE_TERRACOTTA_TILE_STAIRS, drops(PURPLE_TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(PURPLE_TERRACOTTA_TILE_WALL, drops(PURPLE_TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_PURPLE_TERRACOTTA_TILES, drops(CRACKED_PURPLE_TERRACOTTA_TILES.asItem()));
			addDrop(PURPLE_TERRACOTTA_PILLAR, drops(PURPLE_TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_PURPLE_TERRACOTTA_PILLAR, drops(CHISELED_PURPLE_TERRACOTTA_PILLAR.asItem()));
			addDrop(MAGENTA_TERRACOTTA_SLAB, drops(MAGENTA_TERRACOTTA_SLAB.asItem()));
			addDrop(MAGENTA_TERRACOTTA_STAIRS, drops(MAGENTA_TERRACOTTA_STAIRS.asItem()));
			addDrop(MAGENTA_TERRACOTTA_WALL, drops(MAGENTA_TERRACOTTA_WALL.asItem()));
			addDrop(MAGENTA_TERRACOTTA_BRICKS, drops(MAGENTA_TERRACOTTA_BRICKS.asItem()));
			addDrop(MAGENTA_TERRACOTTA_BRICK_SLAB, drops(MAGENTA_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MAGENTA_TERRACOTTA_BRICK_STAIRS, drops(MAGENTA_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MAGENTA_TERRACOTTA_BRICK_WALL, drops(MAGENTA_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CRACKED_MAGENTA_TERRACOTTA_BRICKS, drops(CRACKED_MAGENTA_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_MAGENTA_TERRACOTTA_BRICKS, drops(MOSSY_MAGENTA_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_MAGENTA_TERRACOTTA_BRICK_SLAB, drops(MOSSY_MAGENTA_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MOSSY_MAGENTA_TERRACOTTA_BRICK_STAIRS, drops(MOSSY_MAGENTA_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_MAGENTA_TERRACOTTA_BRICK_WALL, drops(MOSSY_MAGENTA_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CHISELED_MAGENTA_TERRACOTTA, drops(CHISELED_MAGENTA_TERRACOTTA.asItem()));
			addDrop(POLISHED_MAGENTA_TERRACOTTA, drops(POLISHED_MAGENTA_TERRACOTTA.asItem()));
			addDrop(POLISHED_MAGENTA_TERRACOTTA_SLAB, drops(POLISHED_MAGENTA_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_MAGENTA_TERRACOTTA_STAIRS, drops(POLISHED_MAGENTA_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_MAGENTA_TERRACOTTA_WALL, drops(POLISHED_MAGENTA_TERRACOTTA_WALL.asItem()));
			addDrop(MAGENTA_TERRACOTTA_TILES, drops(MAGENTA_TERRACOTTA_TILES.asItem()));
			addDrop(MAGENTA_TERRACOTTA_TILE_SLAB, drops(MAGENTA_TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(MAGENTA_TERRACOTTA_TILE_STAIRS, drops(MAGENTA_TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(MAGENTA_TERRACOTTA_TILE_WALL, drops(MAGENTA_TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_MAGENTA_TERRACOTTA_TILES, drops(CRACKED_MAGENTA_TERRACOTTA_TILES.asItem()));
			addDrop(MAGENTA_TERRACOTTA_PILLAR, drops(MAGENTA_TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_MAGENTA_TERRACOTTA_PILLAR, drops(CHISELED_MAGENTA_TERRACOTTA_PILLAR.asItem()));
			addDrop(PINK_TERRACOTTA_SLAB, drops(PINK_TERRACOTTA_SLAB.asItem()));
			addDrop(PINK_TERRACOTTA_STAIRS, drops(PINK_TERRACOTTA_STAIRS.asItem()));
			addDrop(PINK_TERRACOTTA_WALL, drops(PINK_TERRACOTTA_WALL.asItem()));
			addDrop(PINK_TERRACOTTA_BRICKS, drops(PINK_TERRACOTTA_BRICKS.asItem()));
			addDrop(PINK_TERRACOTTA_BRICK_SLAB, drops(PINK_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(PINK_TERRACOTTA_BRICK_STAIRS, drops(PINK_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(PINK_TERRACOTTA_BRICK_WALL, drops(PINK_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CRACKED_PINK_TERRACOTTA_BRICKS, drops(CRACKED_PINK_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_PINK_TERRACOTTA_BRICKS, drops(MOSSY_PINK_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_PINK_TERRACOTTA_BRICK_SLAB, drops(MOSSY_PINK_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MOSSY_PINK_TERRACOTTA_BRICK_STAIRS, drops(MOSSY_PINK_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_PINK_TERRACOTTA_BRICK_WALL, drops(MOSSY_PINK_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CHISELED_PINK_TERRACOTTA, drops(CHISELED_PINK_TERRACOTTA.asItem()));
			addDrop(POLISHED_PINK_TERRACOTTA, drops(POLISHED_PINK_TERRACOTTA.asItem()));
			addDrop(POLISHED_PINK_TERRACOTTA_SLAB, drops(POLISHED_PINK_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_PINK_TERRACOTTA_STAIRS, drops(POLISHED_PINK_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_PINK_TERRACOTTA_WALL, drops(POLISHED_PINK_TERRACOTTA_WALL.asItem()));
			addDrop(PINK_TERRACOTTA_TILES, drops(PINK_TERRACOTTA_TILES.asItem()));
			addDrop(PINK_TERRACOTTA_TILE_SLAB, drops(PINK_TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(PINK_TERRACOTTA_TILE_STAIRS, drops(PINK_TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(PINK_TERRACOTTA_TILE_WALL, drops(PINK_TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_PINK_TERRACOTTA_TILES, drops(CRACKED_PINK_TERRACOTTA_TILES.asItem()));
			addDrop(PINK_TERRACOTTA_PILLAR, drops(PINK_TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_PINK_TERRACOTTA_PILLAR, drops(CHISELED_PINK_TERRACOTTA_PILLAR.asItem()));
			addDrop(BROWN_TERRACOTTA_SLAB, drops(BROWN_TERRACOTTA_SLAB.asItem()));
			addDrop(BROWN_TERRACOTTA_STAIRS, drops(BROWN_TERRACOTTA_STAIRS.asItem()));
			addDrop(BROWN_TERRACOTTA_WALL, drops(BROWN_TERRACOTTA_WALL.asItem()));
			addDrop(BROWN_TERRACOTTA_BRICKS, drops(BROWN_TERRACOTTA_BRICKS.asItem()));
			addDrop(BROWN_TERRACOTTA_BRICK_SLAB, drops(BROWN_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(BROWN_TERRACOTTA_BRICK_STAIRS, drops(BROWN_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(BROWN_TERRACOTTA_BRICK_WALL, drops(BROWN_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CRACKED_BROWN_TERRACOTTA_BRICKS, drops(CRACKED_BROWN_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_BROWN_TERRACOTTA_BRICKS, drops(MOSSY_BROWN_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_BROWN_TERRACOTTA_BRICK_SLAB, drops(MOSSY_BROWN_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MOSSY_BROWN_TERRACOTTA_BRICK_STAIRS, drops(MOSSY_BROWN_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_BROWN_TERRACOTTA_BRICK_WALL, drops(MOSSY_BROWN_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CHISELED_BROWN_TERRACOTTA, drops(CHISELED_BROWN_TERRACOTTA.asItem()));
			addDrop(POLISHED_BROWN_TERRACOTTA, drops(POLISHED_BROWN_TERRACOTTA.asItem()));
			addDrop(POLISHED_BROWN_TERRACOTTA_SLAB, drops(POLISHED_BROWN_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_BROWN_TERRACOTTA_STAIRS, drops(POLISHED_BROWN_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_BROWN_TERRACOTTA_WALL, drops(POLISHED_BROWN_TERRACOTTA_WALL.asItem()));
			addDrop(BROWN_TERRACOTTA_TILES, drops(BROWN_TERRACOTTA_TILES.asItem()));
			addDrop(BROWN_TERRACOTTA_TILE_SLAB, drops(BROWN_TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(BROWN_TERRACOTTA_TILE_STAIRS, drops(BROWN_TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(BROWN_TERRACOTTA_TILE_WALL, drops(BROWN_TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_BROWN_TERRACOTTA_TILES, drops(CRACKED_BROWN_TERRACOTTA_TILES.asItem()));
			addDrop(BROWN_TERRACOTTA_PILLAR, drops(BROWN_TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_BROWN_TERRACOTTA_PILLAR, drops(CHISELED_BROWN_TERRACOTTA_PILLAR.asItem()));
			addDrop(WHITE_TERRACOTTA_SLAB, drops(WHITE_TERRACOTTA_SLAB.asItem()));
			addDrop(WHITE_TERRACOTTA_STAIRS, drops(WHITE_TERRACOTTA_STAIRS.asItem()));
			addDrop(WHITE_TERRACOTTA_WALL, drops(WHITE_TERRACOTTA_WALL.asItem()));
			addDrop(WHITE_TERRACOTTA_BRICKS, drops(WHITE_TERRACOTTA_BRICKS.asItem()));
			addDrop(WHITE_TERRACOTTA_BRICK_SLAB, drops(WHITE_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(WHITE_TERRACOTTA_BRICK_STAIRS, drops(WHITE_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(WHITE_TERRACOTTA_BRICK_WALL, drops(WHITE_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CRACKED_WHITE_TERRACOTTA_BRICKS, drops(CRACKED_WHITE_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_WHITE_TERRACOTTA_BRICKS, drops(MOSSY_WHITE_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_WHITE_TERRACOTTA_BRICK_SLAB, drops(MOSSY_WHITE_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MOSSY_WHITE_TERRACOTTA_BRICK_STAIRS, drops(MOSSY_WHITE_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_WHITE_TERRACOTTA_BRICK_WALL, drops(MOSSY_WHITE_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CHISELED_WHITE_TERRACOTTA, drops(CHISELED_WHITE_TERRACOTTA.asItem()));
			addDrop(POLISHED_WHITE_TERRACOTTA, drops(POLISHED_WHITE_TERRACOTTA.asItem()));
			addDrop(POLISHED_WHITE_TERRACOTTA_SLAB, drops(POLISHED_WHITE_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_WHITE_TERRACOTTA_STAIRS, drops(POLISHED_WHITE_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_WHITE_TERRACOTTA_WALL, drops(POLISHED_WHITE_TERRACOTTA_WALL.asItem()));
			addDrop(WHITE_TERRACOTTA_TILES, drops(WHITE_TERRACOTTA_TILES.asItem()));
			addDrop(WHITE_TERRACOTTA_TILE_SLAB, drops(WHITE_TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(WHITE_TERRACOTTA_TILE_STAIRS, drops(WHITE_TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(WHITE_TERRACOTTA_TILE_WALL, drops(WHITE_TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_WHITE_TERRACOTTA_TILES, drops(CRACKED_WHITE_TERRACOTTA_TILES.asItem()));
			addDrop(WHITE_TERRACOTTA_PILLAR, drops(WHITE_TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_WHITE_TERRACOTTA_PILLAR, drops(CHISELED_WHITE_TERRACOTTA_PILLAR.asItem()));
			addDrop(LIGHT_GRAY_TERRACOTTA_SLAB, drops(LIGHT_GRAY_TERRACOTTA_SLAB.asItem()));
			addDrop(LIGHT_GRAY_TERRACOTTA_STAIRS, drops(LIGHT_GRAY_TERRACOTTA_STAIRS.asItem()));
			addDrop(LIGHT_GRAY_TERRACOTTA_WALL, drops(LIGHT_GRAY_TERRACOTTA_WALL.asItem()));
			addDrop(LIGHT_GRAY_TERRACOTTA_BRICKS, drops(LIGHT_GRAY_TERRACOTTA_BRICKS.asItem()));
			addDrop(LIGHT_GRAY_TERRACOTTA_BRICK_SLAB, drops(LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS, drops(LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(LIGHT_GRAY_TERRACOTTA_BRICK_WALL, drops(LIGHT_GRAY_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CRACKED_LIGHT_GRAY_TERRACOTTA_BRICKS, drops(CRACKED_LIGHT_GRAY_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_LIGHT_GRAY_TERRACOTTA_BRICKS, drops(MOSSY_LIGHT_GRAY_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_LIGHT_GRAY_TERRACOTTA_BRICK_SLAB, drops(MOSSY_LIGHT_GRAY_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MOSSY_LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS, drops(MOSSY_LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_LIGHT_GRAY_TERRACOTTA_BRICK_WALL, drops(MOSSY_LIGHT_GRAY_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CHISELED_LIGHT_GRAY_TERRACOTTA, drops(CHISELED_LIGHT_GRAY_TERRACOTTA.asItem()));
			addDrop(POLISHED_LIGHT_GRAY_TERRACOTTA, drops(POLISHED_LIGHT_GRAY_TERRACOTTA.asItem()));
			addDrop(POLISHED_LIGHT_GRAY_TERRACOTTA_SLAB, drops(POLISHED_LIGHT_GRAY_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_LIGHT_GRAY_TERRACOTTA_STAIRS, drops(POLISHED_LIGHT_GRAY_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_LIGHT_GRAY_TERRACOTTA_WALL, drops(POLISHED_LIGHT_GRAY_TERRACOTTA_WALL.asItem()));
			addDrop(LIGHT_GRAY_TERRACOTTA_TILES, drops(LIGHT_GRAY_TERRACOTTA_TILES.asItem()));
			addDrop(LIGHT_GRAY_TERRACOTTA_TILE_SLAB, drops(LIGHT_GRAY_TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(LIGHT_GRAY_TERRACOTTA_TILE_STAIRS, drops(LIGHT_GRAY_TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(LIGHT_GRAY_TERRACOTTA_TILE_WALL, drops(LIGHT_GRAY_TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_LIGHT_GRAY_TERRACOTTA_TILES, drops(CRACKED_LIGHT_GRAY_TERRACOTTA_TILES.asItem()));
			addDrop(LIGHT_GRAY_TERRACOTTA_PILLAR, drops(LIGHT_GRAY_TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_LIGHT_GRAY_TERRACOTTA_PILLAR, drops(CHISELED_LIGHT_GRAY_TERRACOTTA_PILLAR.asItem()));
			addDrop(GRAY_TERRACOTTA_SLAB, drops(GRAY_TERRACOTTA_SLAB.asItem()));
			addDrop(GRAY_TERRACOTTA_STAIRS, drops(GRAY_TERRACOTTA_STAIRS.asItem()));
			addDrop(GRAY_TERRACOTTA_WALL, drops(GRAY_TERRACOTTA_WALL.asItem()));
			addDrop(GRAY_TERRACOTTA_BRICKS, drops(GRAY_TERRACOTTA_BRICKS.asItem()));
			addDrop(GRAY_TERRACOTTA_BRICK_SLAB, drops(GRAY_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(GRAY_TERRACOTTA_BRICK_STAIRS, drops(GRAY_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(GRAY_TERRACOTTA_BRICK_WALL, drops(GRAY_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CRACKED_GRAY_TERRACOTTA_BRICKS, drops(CRACKED_GRAY_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_GRAY_TERRACOTTA_BRICKS, drops(MOSSY_GRAY_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_GRAY_TERRACOTTA_BRICK_SLAB, drops(MOSSY_GRAY_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MOSSY_GRAY_TERRACOTTA_BRICK_STAIRS, drops(MOSSY_GRAY_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_GRAY_TERRACOTTA_BRICK_WALL, drops(MOSSY_GRAY_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CHISELED_GRAY_TERRACOTTA, drops(CHISELED_GRAY_TERRACOTTA.asItem()));
			addDrop(POLISHED_GRAY_TERRACOTTA, drops(POLISHED_GRAY_TERRACOTTA.asItem()));
			addDrop(POLISHED_GRAY_TERRACOTTA_SLAB, drops(POLISHED_GRAY_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_GRAY_TERRACOTTA_STAIRS, drops(POLISHED_GRAY_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_GRAY_TERRACOTTA_WALL, drops(POLISHED_GRAY_TERRACOTTA_WALL.asItem()));
			addDrop(GRAY_TERRACOTTA_TILES, drops(GRAY_TERRACOTTA_TILES.asItem()));
			addDrop(GRAY_TERRACOTTA_TILE_SLAB, drops(GRAY_TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(GRAY_TERRACOTTA_TILE_STAIRS, drops(GRAY_TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(GRAY_TERRACOTTA_TILE_WALL, drops(GRAY_TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_GRAY_TERRACOTTA_TILES, drops(CRACKED_GRAY_TERRACOTTA_TILES.asItem()));
			addDrop(GRAY_TERRACOTTA_PILLAR, drops(GRAY_TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_GRAY_TERRACOTTA_PILLAR, drops(CHISELED_GRAY_TERRACOTTA_PILLAR.asItem()));
			addDrop(BLACK_TERRACOTTA_SLAB, drops(BLACK_TERRACOTTA_SLAB.asItem()));
			addDrop(BLACK_TERRACOTTA_STAIRS, drops(BLACK_TERRACOTTA_STAIRS.asItem()));
			addDrop(BLACK_TERRACOTTA_WALL, drops(BLACK_TERRACOTTA_WALL.asItem()));
			addDrop(BLACK_TERRACOTTA_BRICKS, drops(BLACK_TERRACOTTA_BRICKS.asItem()));
			addDrop(BLACK_TERRACOTTA_BRICK_SLAB, drops(BLACK_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(BLACK_TERRACOTTA_BRICK_STAIRS, drops(BLACK_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(BLACK_TERRACOTTA_BRICK_WALL, drops(BLACK_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CRACKED_BLACK_TERRACOTTA_BRICKS, drops(CRACKED_BLACK_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_BLACK_TERRACOTTA_BRICKS, drops(MOSSY_BLACK_TERRACOTTA_BRICKS.asItem()));
			addDrop(MOSSY_BLACK_TERRACOTTA_BRICK_SLAB, drops(MOSSY_BLACK_TERRACOTTA_BRICK_SLAB.asItem()));
			addDrop(MOSSY_BLACK_TERRACOTTA_BRICK_STAIRS, drops(MOSSY_BLACK_TERRACOTTA_BRICK_STAIRS.asItem()));
			addDrop(MOSSY_BLACK_TERRACOTTA_BRICK_WALL, drops(MOSSY_BLACK_TERRACOTTA_BRICK_WALL.asItem()));
			addDrop(CHISELED_BLACK_TERRACOTTA, drops(CHISELED_BLACK_TERRACOTTA.asItem()));
			addDrop(POLISHED_BLACK_TERRACOTTA, drops(POLISHED_BLACK_TERRACOTTA.asItem()));
			addDrop(POLISHED_BLACK_TERRACOTTA_SLAB, drops(POLISHED_BLACK_TERRACOTTA_SLAB.asItem()));
			addDrop(POLISHED_BLACK_TERRACOTTA_STAIRS, drops(POLISHED_BLACK_TERRACOTTA_STAIRS.asItem()));
			addDrop(POLISHED_BLACK_TERRACOTTA_WALL, drops(POLISHED_BLACK_TERRACOTTA_WALL.asItem()));
			addDrop(BLACK_TERRACOTTA_TILES, drops(BLACK_TERRACOTTA_TILES.asItem()));
			addDrop(BLACK_TERRACOTTA_TILE_SLAB, drops(BLACK_TERRACOTTA_TILE_SLAB.asItem()));
			addDrop(BLACK_TERRACOTTA_TILE_STAIRS, drops(BLACK_TERRACOTTA_TILE_STAIRS.asItem()));
			addDrop(BLACK_TERRACOTTA_TILE_WALL, drops(BLACK_TERRACOTTA_TILE_WALL.asItem()));
			addDrop(CRACKED_BLACK_TERRACOTTA_TILES, drops(CRACKED_BLACK_TERRACOTTA_TILES.asItem()));
			addDrop(BLACK_TERRACOTTA_PILLAR, drops(BLACK_TERRACOTTA_PILLAR.asItem()));
			addDrop(CHISELED_BLACK_TERRACOTTA_PILLAR, drops(CHISELED_BLACK_TERRACOTTA_PILLAR.asItem()));
		}
	}

	private static class ModelGenerator extends FabricModelProvider {
		private ModelGenerator(FabricDataOutput generator) {
			super(generator);
		}

		private void generateSlab(BlockStateModelGenerator blockStateModelGenerator, Block slabBlock, Block baseBlock, Identifier baseBlockID) {
			TextureMap map = TextureMap.all(baseBlock);
			Identifier identifier = Models.SLAB.upload(slabBlock, map, blockStateModelGenerator.modelCollector);//pool.ensureModel(Models.SLAB, block);
			Identifier identifier2 = Models.SLAB_TOP.upload(slabBlock, map, blockStateModelGenerator.modelCollector);//pool.ensureModel(Models.SLAB_TOP, block);
			blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createSlabBlockState(slabBlock, identifier, identifier2, baseBlockID));
			//blockStateModelGenerator.registerItemModel(slabBlock);
			blockStateModelGenerator.registerParentedItemModel(slabBlock.asItem(), ModelIds.getBlockModelId(slabBlock));
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

			registerPaneDoor(blockStateModelGenerator, SLIDING_GLASS_PANE, "sliding_glass_pane");
			registerPaneDoor(blockStateModelGenerator, RED_SLIDING_GLASS_PANE, "red_sliding_glass_pane");
			registerPaneDoor(blockStateModelGenerator, ORANGE_SLIDING_GLASS_PANE, "orange_sliding_glass_pane");
			registerPaneDoor(blockStateModelGenerator, YELLOW_SLIDING_GLASS_PANE, "yellow_sliding_glass_pane");
			registerPaneDoor(blockStateModelGenerator, LIME_SLIDING_GLASS_PANE, "lime_sliding_glass_pane");
			registerPaneDoor(blockStateModelGenerator, GREEN_SLIDING_GLASS_PANE, "green_sliding_glass_pane");
			registerPaneDoor(blockStateModelGenerator, CYAN_SLIDING_GLASS_PANE, "cyan_sliding_glass_pane");
			registerPaneDoor(blockStateModelGenerator, LIGHT_BLUE_SLIDING_GLASS_PANE, "light_blue_sliding_glass_pane");
			registerPaneDoor(blockStateModelGenerator, BLUE_SLIDING_GLASS_PANE, "blue_sliding_glass_pane");
			registerPaneDoor(blockStateModelGenerator, PURPLE_SLIDING_GLASS_PANE, "purple_sliding_glass_pane");
			registerPaneDoor(blockStateModelGenerator, MAGENTA_SLIDING_GLASS_PANE, "magenta_sliding_glass_pane");
			registerPaneDoor(blockStateModelGenerator, PINK_SLIDING_GLASS_PANE, "pink_sliding_glass_pane");
			registerPaneDoor(blockStateModelGenerator, BROWN_SLIDING_GLASS_PANE, "brown_sliding_glass_pane");
			registerPaneDoor(blockStateModelGenerator, WHITE_SLIDING_GLASS_PANE, "white_sliding_glass_pane");
			registerPaneDoor(blockStateModelGenerator, LIGHT_GRAY_SLIDING_GLASS_PANE, "light_gray_sliding_glass_pane");
			registerPaneDoor(blockStateModelGenerator, GRAY_SLIDING_GLASS_PANE, "gray_sliding_glass_pane");
			registerPaneDoor(blockStateModelGenerator, BLACK_SLIDING_GLASS_PANE, "black_sliding_glass_pane");

			blockStateModelGenerator.registerParentedItemModel(SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/sliding_glass_pane"));
			blockStateModelGenerator.registerParentedItemModel(RED_SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/red_sliding_glass_pane"));
			blockStateModelGenerator.registerParentedItemModel(ORANGE_SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/orange_sliding_glass_pane"));
			blockStateModelGenerator.registerParentedItemModel(YELLOW_SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/yellow_sliding_glass_pane"));
			blockStateModelGenerator.registerParentedItemModel(LIME_SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/lime_sliding_glass_pane"));
			blockStateModelGenerator.registerParentedItemModel(GREEN_SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/green_sliding_glass_pane"));
			blockStateModelGenerator.registerParentedItemModel(CYAN_SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/cyan_sliding_glass_pane"));
			blockStateModelGenerator.registerParentedItemModel(LIGHT_BLUE_SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/light_blue_sliding_glass_pane"));
			blockStateModelGenerator.registerParentedItemModel(BLUE_SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/blue_sliding_glass_pane"));
			blockStateModelGenerator.registerParentedItemModel(PURPLE_SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/purple_sliding_glass_pane"));
			blockStateModelGenerator.registerParentedItemModel(MAGENTA_SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/magenta_sliding_glass_pane"));
			blockStateModelGenerator.registerParentedItemModel(PINK_SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/pink_sliding_glass_pane"));
			blockStateModelGenerator.registerParentedItemModel(BROWN_SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/brown_sliding_glass_pane"));
			blockStateModelGenerator.registerParentedItemModel(WHITE_SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/white_sliding_glass_pane"));
			blockStateModelGenerator.registerParentedItemModel(LIGHT_GRAY_SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/light_gray_sliding_glass_pane"));
			blockStateModelGenerator.registerParentedItemModel(GRAY_SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/gray_sliding_glass_pane"));
			blockStateModelGenerator.registerParentedItemModel(BLACK_SLIDING_GLASS_PANE.asItem(), Identifier.of("pucks_parity_mod:block/black_sliding_glass_pane"));

			PucksParityModBlockFamilies.getFamilies()
					.filter(BlockFamily::shouldGenerateModels)
					.forEach(family -> blockStateModelGenerator.registerCubeAllModelTexturePool(family.getBaseBlock()).family(family));

			TexturedModel texturedModel = TexturedModel.SIDE_TOP_BOTTOM_WALL.get(MOSSY_SANDSTONE);
			blockStateModelGenerator.new BlockTexturePool(texturedModel.getTextures().put(TextureKey.WALL, Identifier.of("pucks_parity_mod", "block/mossy_sandstone_bottom")))
					.base(MOSSY_SANDSTONE, texturedModel.getModel())
					.wall(MOSSY_SANDSTONE_WALL)
					.stairs(MOSSY_SANDSTONE_STAIRS);
			generateSlab(blockStateModelGenerator, MOSSY_SANDSTONE_SLAB, MOSSY_SANDSTONE, Identifier.of("pucks_parity_mod", "mossy_sandstone"));

			TexturedModel texturedModel2 = TexturedModel.SIDE_TOP_BOTTOM_WALL.get(MOSSY_RED_SANDSTONE);
			blockStateModelGenerator.new BlockTexturePool(texturedModel2.getTextures().put(TextureKey.WALL, Identifier.of("pucks_parity_mod", "block/mossy_red_sandstone_bottom")))
					.base(MOSSY_RED_SANDSTONE, texturedModel2.getModel())
					.wall(MOSSY_RED_SANDSTONE_WALL)
					.stairs(MOSSY_RED_SANDSTONE_STAIRS);
			generateSlab(blockStateModelGenerator, MOSSY_RED_SANDSTONE_SLAB, MOSSY_RED_SANDSTONE, Identifier.of("pucks_parity_mod", "mossy_red_sandstone"));

			TexturedModel texturedModel3 = TexturedModel.CUBE_COLUMN.get(PURPUR_BRICKS);
			blockStateModelGenerator.new BlockTexturePool(texturedModel3.getTextures().put(TextureKey.WALL, Identifier.of("pucks_parity_mod", "block/purpur_bricks_side")))
					.base(PURPUR_BRICKS, texturedModel3.getModel())
					.wall(PURPUR_BRICK_WALL)
					.stairs(PURPUR_BRICK_STAIRS);
			generateSlab(blockStateModelGenerator, PURPUR_BRICK_SLAB, PURPUR_BRICKS, Identifier.of("pucks_parity_mod", "purpur_bricks"));

			TexturedModel texturedModel4 = TexturedModel.CUBE_COLUMN.get(CRACKED_PURPUR_BRICKS);
			blockStateModelGenerator.new BlockTexturePool(texturedModel4.getTextures()).base(CRACKED_PURPUR_BRICKS, texturedModel3.getModel());

			TexturedModel texturedModel5 = TexturedModel.CUBE_COLUMN.get(MOLDY_PURPUR_BRICKS);
			blockStateModelGenerator.new BlockTexturePool(texturedModel5.getTextures().put(TextureKey.WALL, Identifier.of("pucks_parity_mod", "block/moldy_purpur_bricks_side")))
					.base(MOLDY_PURPUR_BRICKS, texturedModel5.getModel())
					.wall(MOLDY_PURPUR_BRICK_WALL)
					.stairs(MOLDY_PURPUR_BRICK_STAIRS);
			generateSlab(blockStateModelGenerator, MOLDY_PURPUR_BRICK_SLAB, MOLDY_PURPUR_BRICKS, Identifier.of("pucks_parity_mod", "moldy_purpur_bricks"));

			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.STONE)).wall(STONE_WALL);
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.SMOOTH_STONE)).stairs(POLISHED_SMOOTH_STONE_STAIRS).wall(POLISHED_SMOOTH_STONE_WALL);
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.DEEPSLATE)).stairs(DEEPSLATE_STAIRS).wall(DEEPSLATE_WALL);
			generateSlab(blockStateModelGenerator, DEEPSLATE_SLAB, Blocks.DEEPSLATE, Identifier.of("minecraft", "deepslate"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.POLISHED_ANDESITE)).wall(POLISHED_ANDESITE_WALL);
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.POLISHED_DIORITE)).wall(POLISHED_DIORITE_WALL);
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.POLISHED_GRANITE)).wall(POLISHED_GRANITE_WALL);
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.END_STONE)).stairs(END_STONE_STAIRS).wall(END_STONE_WALL);
			generateSlab(blockStateModelGenerator, END_STONE_SLAB, Blocks.END_STONE, Identifier.of("minecraft", "end_stone"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Identifier.of("minecraft:block/purpur_block"))).wall(PURPUR_TILE_WALL);
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Identifier.of("minecraft:block/sandstone_top"))).wall(SMOOTH_SANDSTONE_WALL);
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.CUT_SANDSTONE)).stairs(CUT_SANDSTONE_STAIRS).wall(CUT_SANDSTONE_WALL);
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Identifier.of("minecraft:block/red_sandstone_top"))).wall(SMOOTH_RED_SANDSTONE_WALL);
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.CUT_RED_SANDSTONE)).stairs(CUT_RED_SANDSTONE_STAIRS).wall(CUT_RED_SANDSTONE_WALL);
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.PRISMARINE_BRICKS)).wall(PRISMARINE_BRICK_WALL);
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.DARK_PRISMARINE)).wall(DARK_PRISMARINE_TILE_WALL);
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Identifier.of("minecraft:block/quartz_block_bottom"))).wall(QUARTZ_WALL);
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Identifier.of("minecraft:block/quartz_block_top"))).wall(POLISHED_QUARTZ_WALL);
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.QUARTZ_BRICKS)).stairs(QUARTZ_BRICK_STAIRS).wall(QUARTZ_BRICK_WALL);
			generateSlab(blockStateModelGenerator, QUARTZ_BRICK_SLAB, Blocks.QUARTZ_BRICKS, Identifier.of("minecraft", "quartz_bricks"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.NETHERRACK)).stairs(NETHERRACK_STAIRS).wall(NETHERRACK_WALL);
			generateSlab(blockStateModelGenerator, NETHERRACK_SLAB, Blocks.NETHERRACK, Identifier.of("minecraft", "netherrack"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.NETHER_BRICKS)).wall(NETHER_BRICK_WALL);
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.SMOOTH_BASALT)).stairs(SMOOTH_BASALT_STAIRS).wall(SMOOTH_BASALT_WALL);
			generateSlab(blockStateModelGenerator, SMOOTH_BASALT_SLAB, Blocks.SMOOTH_BASALT, Identifier.of("minecraft", "smooth_basalt"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.CALCITE)).stairs(CALCITE_STAIRS).wall(CALCITE_WALL);
			generateSlab(blockStateModelGenerator, CALCITE_SLAB, Blocks.CALCITE, Identifier.of("minecraft", "calcite"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.DRIPSTONE_BLOCK)).stairs(DRIPSTONE_STAIRS).wall(DRIPSTONE_WALL);
			generateSlab(blockStateModelGenerator, DRIPSTONE_SLAB, Blocks.DRIPSTONE_BLOCK, Identifier.of("minecraft", "dripstone_block"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.PACKED_MUD)).stairs(PACKED_MUD_STAIRS).wall(PACKED_MUD_WALL);
			generateSlab(blockStateModelGenerator, PACKED_MUD_SLAB, Blocks.PACKED_MUD, Identifier.of("minecraft", "packed_mud"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.TERRACOTTA)).stairs(TERRACOTTA_STAIRS).wall(TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, TERRACOTTA_SLAB, Blocks.TERRACOTTA, Identifier.of("minecraft", "terracotta"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.RED_TERRACOTTA)).stairs(RED_TERRACOTTA_STAIRS).wall(RED_TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, RED_TERRACOTTA_SLAB, Blocks.RED_TERRACOTTA, Identifier.of("minecraft", "red_terracotta"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.ORANGE_TERRACOTTA)).stairs(ORANGE_TERRACOTTA_STAIRS).wall(ORANGE_TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, ORANGE_TERRACOTTA_SLAB, Blocks.ORANGE_TERRACOTTA, Identifier.of("minecraft", "orange_terracotta"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.YELLOW_TERRACOTTA)).stairs(YELLOW_TERRACOTTA_STAIRS).wall(YELLOW_TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, YELLOW_TERRACOTTA_SLAB, Blocks.YELLOW_TERRACOTTA, Identifier.of("minecraft", "yellow_terracotta"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.LIME_TERRACOTTA)).stairs(LIME_TERRACOTTA_STAIRS).wall(LIME_TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, LIME_TERRACOTTA_SLAB, Blocks.LIME_TERRACOTTA, Identifier.of("minecraft", "lime_terracotta"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.GREEN_TERRACOTTA)).stairs(GREEN_TERRACOTTA_STAIRS).wall(GREEN_TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, GREEN_TERRACOTTA_SLAB, Blocks.GREEN_TERRACOTTA, Identifier.of("minecraft", "green_terracotta"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.CYAN_TERRACOTTA)).stairs(CYAN_TERRACOTTA_STAIRS).wall(CYAN_TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, CYAN_TERRACOTTA_SLAB, Blocks.CYAN_TERRACOTTA, Identifier.of("minecraft", "cyan_terracotta"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.LIGHT_BLUE_TERRACOTTA)).stairs(LIGHT_BLUE_TERRACOTTA_STAIRS).wall(LIGHT_BLUE_TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, LIGHT_BLUE_TERRACOTTA_SLAB, Blocks.LIGHT_BLUE_TERRACOTTA, Identifier.of("minecraft", "light_blue_terracotta"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.BLUE_TERRACOTTA)).stairs(BLUE_TERRACOTTA_STAIRS).wall(BLUE_TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, BLUE_TERRACOTTA_SLAB, Blocks.BLUE_TERRACOTTA, Identifier.of("minecraft", "blue_terracotta"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.PURPLE_TERRACOTTA)).stairs(PURPLE_TERRACOTTA_STAIRS).wall(PURPLE_TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, PURPLE_TERRACOTTA_SLAB, Blocks.PURPLE_TERRACOTTA, Identifier.of("minecraft", "purple_terracotta"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.MAGENTA_TERRACOTTA)).stairs(MAGENTA_TERRACOTTA_STAIRS).wall(MAGENTA_TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, MAGENTA_TERRACOTTA_SLAB, Blocks.MAGENTA_TERRACOTTA, Identifier.of("minecraft", "magenta_terracotta"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.PINK_TERRACOTTA)).stairs(PINK_TERRACOTTA_STAIRS).wall(PINK_TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, PINK_TERRACOTTA_SLAB, Blocks.PINK_TERRACOTTA, Identifier.of("minecraft", "pink_terracotta"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.BROWN_TERRACOTTA)).stairs(BROWN_TERRACOTTA_STAIRS).wall(BROWN_TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, BROWN_TERRACOTTA_SLAB, Blocks.BROWN_TERRACOTTA, Identifier.of("minecraft", "brown_terracotta"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.WHITE_TERRACOTTA)).stairs(WHITE_TERRACOTTA_STAIRS).wall(WHITE_TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, WHITE_TERRACOTTA_SLAB, Blocks.WHITE_TERRACOTTA, Identifier.of("minecraft", "white_terracotta"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.LIGHT_GRAY_TERRACOTTA)).stairs(LIGHT_GRAY_TERRACOTTA_STAIRS).wall(LIGHT_GRAY_TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, LIGHT_GRAY_TERRACOTTA_SLAB, Blocks.LIGHT_GRAY_TERRACOTTA, Identifier.of("minecraft", "light_gray_terracotta"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.GRAY_TERRACOTTA)).stairs(GRAY_TERRACOTTA_STAIRS).wall(GRAY_TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, GRAY_TERRACOTTA_SLAB, Blocks.GRAY_TERRACOTTA, Identifier.of("minecraft", "gray_terracotta"));
			blockStateModelGenerator.new BlockTexturePool(TextureMap.all(Blocks.BLACK_TERRACOTTA)).stairs(BLACK_TERRACOTTA_STAIRS).wall(BLACK_TERRACOTTA_WALL);
			generateSlab(blockStateModelGenerator, BLACK_TERRACOTTA_SLAB, Blocks.BLACK_TERRACOTTA, Identifier.of("minecraft", "black_terracotta"));

			blockStateModelGenerator.registerTrapdoor(GOLD_TRAPDOOR);
			blockStateModelGenerator.registerDoor(GOLD_DOOR);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_GOLD);
			blockStateModelGenerator.registerSimpleCubeAll(GOLD_GRATE);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_IRON);
			blockStateModelGenerator.registerSimpleCubeAll(IRON_GRATE);

			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_SMOOTH_STONE_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_TUFF_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_GRANITE_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_ANDESITE_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_DIORITE_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_END_STONE_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_SANDSTONE_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_RED_SANDSTONE_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_PRISMARINE_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_DARK_PRISMARINE_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_QUARTZ_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_RED_NETHER_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_BASALT_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_CALCITE_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_DRIPSTONE_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_MUD_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_RED_TERRACOTTA_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_ORANGE_TERRACOTTA_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_YELLOW_TERRACOTTA_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_LIME_TERRACOTTA_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_GREEN_TERRACOTTA_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_CYAN_TERRACOTTA_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_LIGHT_BLUE_TERRACOTTA_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_BLUE_TERRACOTTA_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_PURPLE_TERRACOTTA_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_MAGENTA_TERRACOTTA_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_PINK_TERRACOTTA_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_BROWN_TERRACOTTA_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_WHITE_TERRACOTTA_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_LIGHT_GRAY_TERRACOTTA_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_GRAY_TERRACOTTA_BRICKS);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_BLACK_TERRACOTTA_BRICKS);

			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_STONE_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_SMOOTH_STONE_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_TUFF_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_BLACKSTONE_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_GRANITE_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_ANDESITE_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_DIORITE_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_END_STONE_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_PURPUR_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_SANDSTONE_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_RED_SANDSTONE_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_PRISMARINE_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_DARK_PRISMARINE_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_QUARTZ_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_NETHER_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_RED_NETHER_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_BASALT_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_CALCITE_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_DRIPSTONE_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_MUD_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_TERRACOTTA_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_RED_TERRACOTTA_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_ORANGE_TERRACOTTA_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_YELLOW_TERRACOTTA_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_LIME_TERRACOTTA_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_GREEN_TERRACOTTA_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_CYAN_TERRACOTTA_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_LIGHT_BLUE_TERRACOTTA_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_BLUE_TERRACOTTA_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_PURPLE_TERRACOTTA_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_MAGENTA_TERRACOTTA_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_PINK_TERRACOTTA_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_BROWN_TERRACOTTA_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_WHITE_TERRACOTTA_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_LIGHT_GRAY_TERRACOTTA_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_GRAY_TERRACOTTA_TILES);
			blockStateModelGenerator.registerSimpleCubeAll(CRACKED_BLACK_TERRACOTTA_TILES);

			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_SMOOTH_STONE);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_END_STONE);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_PURPUR);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_PRISMARINE);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_DARK_PRISMARINE);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_RED_HARDENED_NETHERRACK);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_BASALT);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_CALCITE);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_DRIPSTONE);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_PACKED_MUD);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_TERRACOTTA);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_RED_TERRACOTTA);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_ORANGE_TERRACOTTA);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_YELLOW_TERRACOTTA);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_LIME_TERRACOTTA);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_GREEN_TERRACOTTA);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_CYAN_TERRACOTTA);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_LIGHT_BLUE_TERRACOTTA);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_BLUE_TERRACOTTA);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_PURPLE_TERRACOTTA);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_MAGENTA_TERRACOTTA);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_PINK_TERRACOTTA);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_BROWN_TERRACOTTA);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_WHITE_TERRACOTTA);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_LIGHT_GRAY_TERRACOTTA);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_GRAY_TERRACOTTA);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_BLACK_TERRACOTTA);

			blockStateModelGenerator.registerAxisRotated(STONE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_STONE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(SMOOTH_STONE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_SMOOTH_STONE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(TUFF_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(DEEPSLATE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_DEEPSLATE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(GRANITE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_GRANITE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(ANDESITE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_ANDESITE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(DIORITE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_DIORITE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(BLACKSTONE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_BLACKSTONE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(END_STONE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_END_STONE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_PURPUR_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(SANDSTONE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(RED_SANDSTONE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(PRISMARINE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_PRISMARINE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(DARK_PRISMARINE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_DARK_PRISMARINE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_QUARTZ_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(NETHER_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_NETHER_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(RED_NETHER_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_RED_NETHER_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_BASALT_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CALCITE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_CALCITE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(DRIPSTONE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_DRIPSTONE_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(PACKED_MUD_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_MUD_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(RED_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_RED_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(ORANGE_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_ORANGE_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(YELLOW_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_YELLOW_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(LIME_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_LIME_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(GREEN_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_GREEN_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CYAN_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_CYAN_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(LIGHT_BLUE_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_LIGHT_BLUE_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(BLUE_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_BLUE_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(PURPLE_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_PURPLE_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(MAGENTA_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_MAGENTA_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(PINK_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_PINK_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(BROWN_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_BROWN_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(WHITE_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_WHITE_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(LIGHT_GRAY_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_LIGHT_GRAY_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(GRAY_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_GRAY_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(BLACK_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);
			blockStateModelGenerator.registerAxisRotated(CHISELED_BLACK_TERRACOTTA_PILLAR, TexturedModel.CUBE_COLUMN);

			blockStateModelGenerator.registerParentedItemModel(POLISHED_STONE.asItem(), Identifier.of("pucks_parity_mod:block/polished_stone"));
			blockStateModelGenerator.registerParentedItemModel(STONE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/stone_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_STONE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_stone_tiles"));
			blockStateModelGenerator.registerParentedItemModel(STONE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/stone_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_STONE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_stone_pillar"));
			blockStateModelGenerator.registerParentedItemModel(COBBLED_TUFF.asItem(), Identifier.of("pucks_parity_mod:block/cobbled_tuff"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_COBBLED_TUFF.asItem(), Identifier.of("pucks_parity_mod:block/mossy_cobbled_tuff"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_TUFF_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_tuff_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_TUFF_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_tuff_bricks"));
			blockStateModelGenerator.registerParentedItemModel(TUFF_TILES.asItem(), Identifier.of("pucks_parity_mod:block/tuff_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_TUFF_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_tuff_tiles"));
			blockStateModelGenerator.registerParentedItemModel(TUFF_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/tuff_pillar"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_COBBLED_DEEPSLATE.asItem(), Identifier.of("pucks_parity_mod:block/mossy_cobbled_deepslate"));
			blockStateModelGenerator.registerParentedItemModel(SCULKY_COBBLED_DEEPSLATE.asItem(), Identifier.of("pucks_parity_mod:block/sculky_cobbled_deepslate"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_DEEPSLATE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_deepslate_bricks"));
			blockStateModelGenerator.registerParentedItemModel(SCULKY_DEEPSLATE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/sculky_deepslate_bricks"));
			blockStateModelGenerator.registerParentedItemModel(DEEPSLATE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/deepslate_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_DEEPSLATE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_deepslate_pillar"));
			blockStateModelGenerator.registerParentedItemModel(COBBLED_GRANITE.asItem(), Identifier.of("pucks_parity_mod:block/cobbled_granite"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_COBBLED_GRANITE.asItem(), Identifier.of("pucks_parity_mod:block/mossy_cobbled_granite"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_GRANITE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_granite_bricks"));
			blockStateModelGenerator.registerParentedItemModel(GRANITE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/granite_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_GRANITE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_granite_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_GRANITE.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_granite"));
			blockStateModelGenerator.registerParentedItemModel(GRANITE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/granite_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_GRANITE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_granite_tiles"));
			blockStateModelGenerator.registerParentedItemModel(GRANITE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/granite_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_GRANITE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_granite_pillar"));
			blockStateModelGenerator.registerParentedItemModel(COBBLED_ANDESITE.asItem(), Identifier.of("pucks_parity_mod:block/cobbled_andesite"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_COBBLED_ANDESITE.asItem(), Identifier.of("pucks_parity_mod:block/mossy_cobbled_andesite"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_ANDESITE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_andesite_bricks"));
			blockStateModelGenerator.registerParentedItemModel(ANDESITE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/andesite_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_ANDESITE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_andesite_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_ANDESITE.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_andesite"));
			blockStateModelGenerator.registerParentedItemModel(ANDESITE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/andesite_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_ANDESITE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_andesite_tiles"));
			blockStateModelGenerator.registerParentedItemModel(ANDESITE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/andesite_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_ANDESITE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_andesite_pillar"));
			blockStateModelGenerator.registerParentedItemModel(COBBLED_DIORITE.asItem(), Identifier.of("pucks_parity_mod:block/cobbled_diorite"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_COBBLED_DIORITE.asItem(), Identifier.of("pucks_parity_mod:block/mossy_cobbled_diorite"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_DIORITE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_diorite_bricks"));
			blockStateModelGenerator.registerParentedItemModel(DIORITE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/diorite_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_DIORITE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_diorite_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_DIORITE.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_diorite"));
			blockStateModelGenerator.registerParentedItemModel(DIORITE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/diorite_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_DIORITE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_diorite_tiles"));
			blockStateModelGenerator.registerParentedItemModel(DIORITE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/diorite_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_DIORITE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_diorite_pillar"));
			blockStateModelGenerator.registerParentedItemModel(COBBLED_BLACKSTONE.asItem(), Identifier.of("pucks_parity_mod:block/cobbled_blackstone"));
			blockStateModelGenerator.registerParentedItemModel(CRIMSON_COBBLED_BLACKSTONE.asItem(), Identifier.of("pucks_parity_mod:block/crimson_cobbled_blackstone"));
			blockStateModelGenerator.registerParentedItemModel(CRIMSON_BLACKSTONE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/crimson_blackstone_bricks"));
			blockStateModelGenerator.registerParentedItemModel(WARPED_COBBLED_BLACKSTONE.asItem(), Identifier.of("pucks_parity_mod:block/warped_cobbled_blackstone"));
			blockStateModelGenerator.registerParentedItemModel(WARPED_BLACKSTONE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/warped_blackstone_bricks"));
			blockStateModelGenerator.registerParentedItemModel(BLACKSTONE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/blackstone_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_BLACKSTONE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_blackstone_tiles"));
			blockStateModelGenerator.registerParentedItemModel(BLACKSTONE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/blackstone_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_BLACKSTONE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_blackstone_pillar"));
			blockStateModelGenerator.registerParentedItemModel(COBBLED_END_STONE.asItem(), Identifier.of("pucks_parity_mod:block/cobbled_end_stone"));
			blockStateModelGenerator.registerParentedItemModel(MOLDY_COBBLED_END_STONE.asItem(), Identifier.of("pucks_parity_mod:block/moldy_cobbled_end_stone"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_END_STONE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_end_stone_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOLDY_END_STONE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/moldy_end_stone_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_END_STONE.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_end_stone"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_END_STONE.asItem(), Identifier.of("pucks_parity_mod:block/polished_end_stone"));
			blockStateModelGenerator.registerParentedItemModel(END_STONE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/end_stone_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_END_STONE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_end_stone_tiles"));
			blockStateModelGenerator.registerParentedItemModel(END_STONE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/end_stone_pillar"));
			blockStateModelGenerator.registerParentedItemModel(PURPUR.asItem(), Identifier.of("pucks_parity_mod:block/purpur"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_PURPUR_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_purpur_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_END_STONE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_end_stone_pillar"));
			blockStateModelGenerator.registerParentedItemModel(PURPUR_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/purpur_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOLDY_PURPUR_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/moldy_purpur_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_PURPUR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_purpur"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_PURPUR.asItem(), Identifier.of("pucks_parity_mod:block/polished_purpur"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_PURPUR_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_purpur_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_PURPUR_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_purpur_pillar"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_SANDSTONE.asItem(), Identifier.of("pucks_parity_mod:block/mossy_sandstone"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_SANDSTONE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_sandstone_bricks"));
			blockStateModelGenerator.registerParentedItemModel(SANDSTONE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/sandstone_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_SANDSTONE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_sandstone_bricks"));
			blockStateModelGenerator.registerParentedItemModel(SANDSTONE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/sandstone_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_SANDSTONE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_sandstone_tiles"));
			blockStateModelGenerator.registerParentedItemModel(SANDSTONE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/sandstone_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_SANDSTONE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_sandstone_pillar"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_RED_SANDSTONE.asItem(), Identifier.of("pucks_parity_mod:block/mossy_red_sandstone"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_RED_SANDSTONE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_red_sandstone_bricks"));
			blockStateModelGenerator.registerParentedItemModel(RED_SANDSTONE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/red_sandstone_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_RED_SANDSTONE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_red_sandstone_bricks"));
			blockStateModelGenerator.registerParentedItemModel(RED_SANDSTONE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/red_sandstone_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_RED_SANDSTONE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_red_sandstone_tiles"));
			blockStateModelGenerator.registerParentedItemModel(RED_SANDSTONE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/red_sandstone_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_RED_SANDSTONE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_red_sandstone_pillar"));
			blockStateModelGenerator.registerParentedItemModel(BARNACLED_PRISMARINE.asItem(), Identifier.of("pucks_parity_mod:block/barnacled_prismarine"));
			blockStateModelGenerator.registerParentedItemModel(SMOOTH_PRISMARINE.asItem(), Identifier.of("pucks_parity_mod:block/smooth_prismarine"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_PRISMARINE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_prismarine_bricks"));
			blockStateModelGenerator.registerParentedItemModel(BARNACLED_PRISMARINE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/barnacled_prismarine_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_PRISMARINE.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_prismarine"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_PRISMARINE.asItem(), Identifier.of("pucks_parity_mod:block/polished_prismarine"));
			blockStateModelGenerator.registerParentedItemModel(PRISMARINE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/prismarine_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_PRISMARINE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_prismarine_tiles"));
			blockStateModelGenerator.registerParentedItemModel(PRISMARINE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/prismarine_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_PRISMARINE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_prismarine_pillar"));
			blockStateModelGenerator.registerParentedItemModel(DARK_PRISMARINE.asItem(), Identifier.of("pucks_parity_mod:block/dark_prismarine"));
			blockStateModelGenerator.registerParentedItemModel(BARNACLED_DARK_PRISMARINE.asItem(), Identifier.of("pucks_parity_mod:block/barnacled_dark_prismarine"));
			blockStateModelGenerator.registerParentedItemModel(SMOOTH_DARK_PRISMARINE.asItem(), Identifier.of("pucks_parity_mod:block/smooth_dark_prismarine"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_DARK_PRISMARINE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_dark_prismarine_bricks"));
			blockStateModelGenerator.registerParentedItemModel(DARK_PRISMARINE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/dark_prismarine_bricks"));
			blockStateModelGenerator.registerParentedItemModel(BARNACLED_DARK_PRISMARINE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/barnacled_dark_prismarine_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_DARK_PRISMARINE.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_dark_prismarine"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_DARK_PRISMARINE.asItem(), Identifier.of("pucks_parity_mod:block/polished_dark_prismarine"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_DARK_PRISMARINE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_dark_prismarine_tiles"));
			blockStateModelGenerator.registerParentedItemModel(DARK_PRISMARINE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/dark_prismarine_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_DARK_PRISMARINE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_dark_prismarine_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CRIMSON_NETHERRACK.asItem(), Identifier.of("pucks_parity_mod:block/crimson_netherrack"));
			blockStateModelGenerator.registerParentedItemModel(WARPED_NETHERRACK.asItem(), Identifier.of("pucks_parity_mod:block/warped_netherrack"));
			blockStateModelGenerator.registerParentedItemModel(HARDENED_NETHERRACK.asItem(), Identifier.of("pucks_parity_mod:block/hardened_netherrack"));
			blockStateModelGenerator.registerParentedItemModel(CRIMSON_NETHER_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/crimson_nether_bricks"));
			blockStateModelGenerator.registerParentedItemModel(WARPED_NETHER_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/warped_nether_bricks"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_HARDENED_NETHERRACK.asItem(), Identifier.of("pucks_parity_mod:block/polished_hardened_netherrack"));
			blockStateModelGenerator.registerParentedItemModel(NETHER_TILES.asItem(), Identifier.of("pucks_parity_mod:block/nether_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_NETHER_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_nether_tiles"));
			blockStateModelGenerator.registerParentedItemModel(NETHER_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/nether_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_NETHER_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_nether_pillar"));
			blockStateModelGenerator.registerParentedItemModel(COBBLED_BASALT.asItem(), Identifier.of("pucks_parity_mod:block/cobbled_basalt"));
			blockStateModelGenerator.registerParentedItemModel(CRIMSON_COBBLED_BASALT.asItem(), Identifier.of("pucks_parity_mod:block/crimson_cobbled_basalt"));
			blockStateModelGenerator.registerParentedItemModel(WARPED_COBBLED_BASALT.asItem(), Identifier.of("pucks_parity_mod:block/warped_cobbled_basalt"));
			blockStateModelGenerator.registerParentedItemModel(BASALT_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/basalt_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_BASALT_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_basalt_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRIMSON_BASALT_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/crimson_basalt_bricks"));
			blockStateModelGenerator.registerParentedItemModel(WARPED_BASALT_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/warped_basalt_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_BASALT.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_basalt"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_BASALT.asItem(), Identifier.of("pucks_parity_mod:block/polished_basalt"));
			blockStateModelGenerator.registerParentedItemModel(BASALT_TILES.asItem(), Identifier.of("pucks_parity_mod:block/basalt_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_BASALT_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_basalt_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_BASALT_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_basalt_pillar"));
			blockStateModelGenerator.registerParentedItemModel(COBBLED_CALCITE.asItem(), Identifier.of("pucks_parity_mod:block/cobbled_calcite"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_COBBLED_CALCITE.asItem(), Identifier.of("pucks_parity_mod:block/mossy_cobbled_calcite"));
			blockStateModelGenerator.registerParentedItemModel(CALCITE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/calcite_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_CALCITE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_calcite_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_CALCITE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_calcite_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_CALCITE.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_calcite"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_CALCITE.asItem(), Identifier.of("pucks_parity_mod:block/polished_calcite"));
			blockStateModelGenerator.registerParentedItemModel(CALCITE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/calcite_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_CALCITE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_calcite_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CALCITE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/calcite_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_CALCITE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_calcite_pillar"));
			blockStateModelGenerator.registerParentedItemModel(COBBLED_DRIPSTONE.asItem(), Identifier.of("pucks_parity_mod:block/cobbled_dripstone"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_COBBLED_DRIPSTONE.asItem(), Identifier.of("pucks_parity_mod:block/mossy_cobbled_dripstone"));
			blockStateModelGenerator.registerParentedItemModel(DRIPSTONE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/dripstone_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_DRIPSTONE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_dripstone_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_DRIPSTONE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_dripstone_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_DRIPSTONE.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_dripstone"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_DRIPSTONE.asItem(), Identifier.of("pucks_parity_mod:block/polished_dripstone"));
			blockStateModelGenerator.registerParentedItemModel(DRIPSTONE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/dripstone_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_DRIPSTONE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_dripstone_tiles"));
			blockStateModelGenerator.registerParentedItemModel(DRIPSTONE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/dripstone_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_DRIPSTONE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_dripstone_pillar"));
			blockStateModelGenerator.registerParentedItemModel(SMOOTH_STONE.asItem(), Identifier.of("pucks_parity_mod:block/smooth_stone"));
			blockStateModelGenerator.registerParentedItemModel(SMOOTH_STONE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/smooth_stone_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_SMOOTH_STONE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_smooth_stone_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_SMOOTH_STONE_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_smooth_stone_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_SMOOTH_STONE.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_smooth_stone"));
			blockStateModelGenerator.registerParentedItemModel(SMOOTH_STONE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/smooth_stone_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_SMOOTH_STONE_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_smooth_stone_tiles"));
			blockStateModelGenerator.registerParentedItemModel(SMOOTH_STONE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/smooth_stone_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_SMOOTH_STONE_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_smooth_stone_pillar"));
			blockStateModelGenerator.registerParentedItemModel(RED_HARDENED_NETHERRACK.asItem(), Identifier.of("pucks_parity_mod:block/red_hardened_netherrack"));
			blockStateModelGenerator.registerParentedItemModel(CRIMSON_RED_NETHER_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/crimson_red_nether_bricks"));
			blockStateModelGenerator.registerParentedItemModel(WARPED_RED_NETHER_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/warped_red_nether_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_RED_NETHER_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_red_nether_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_RED_HARDENED_NETHERRACK.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_red_hardened_netherrack"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_RED_HARDENED_NETHERRACK.asItem(), Identifier.of("pucks_parity_mod:block/polished_red_hardened_netherrack"));
			blockStateModelGenerator.registerParentedItemModel(RED_NETHER_TILES.asItem(), Identifier.of("pucks_parity_mod:block/red_nether_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_RED_NETHER_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_red_nether_tiles"));
			blockStateModelGenerator.registerParentedItemModel(RED_NETHER_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/red_nether_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_RED_NETHER_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_red_nether_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_QUARTZ_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_quartz_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRIMSON_QUARTZ_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/crimson_quartz_bricks"));
			blockStateModelGenerator.registerParentedItemModel(WARPED_QUARTZ_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/warped_quartz_bricks"));
			blockStateModelGenerator.registerParentedItemModel(QUARTZ_TILES.asItem(), Identifier.of("pucks_parity_mod:block/quartz_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_QUARTZ_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_quartz_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_QUARTZ_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_quartz_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_MUD_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_mud_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_MUD_BRICKS.asItem(), ModelIds.getBlockModelId(MOSSY_MUD_BRICKS));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_PACKED_MUD.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_packed_mud"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_PACKED_MUD.asItem(), Identifier.of("pucks_parity_mod:block/polished_packed_mud"));
			blockStateModelGenerator.registerParentedItemModel(MUD_TILES.asItem(), Identifier.of("pucks_parity_mod:block/mud_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_MUD_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_mud_tiles"));
			blockStateModelGenerator.registerParentedItemModel(PACKED_MUD_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/packed_mud_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_MUD_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_mud_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(RED_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/red_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_RED_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_red_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_RED_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_red_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_RED_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_red_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_RED_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_red_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(RED_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/red_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_RED_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_red_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(RED_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/red_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_RED_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_red_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(ORANGE_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/orange_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_ORANGE_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_orange_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_ORANGE_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_orange_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_ORANGE_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_orange_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_ORANGE_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_orange_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(ORANGE_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/orange_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_ORANGE_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_orange_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(ORANGE_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/orange_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_ORANGE_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_orange_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(YELLOW_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/yellow_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_YELLOW_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_yellow_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_YELLOW_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_yellow_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_YELLOW_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_yellow_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_YELLOW_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_yellow_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(YELLOW_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/yellow_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_YELLOW_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_yellow_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(YELLOW_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/yellow_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_YELLOW_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_yellow_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(LIME_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/lime_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_LIME_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_lime_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_LIME_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_lime_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_LIME_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_lime_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_LIME_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_lime_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(LIME_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/lime_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_LIME_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_lime_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(LIME_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/lime_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_LIME_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_lime_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(GREEN_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/green_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_GREEN_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_green_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_GREEN_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_green_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_GREEN_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_green_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_GREEN_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_green_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(GREEN_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/green_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_GREEN_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_green_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(GREEN_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/green_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_GREEN_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_green_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CYAN_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cyan_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_CYAN_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_cyan_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_CYAN_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_cyan_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_CYAN_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_cyan_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_CYAN_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_cyan_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(CYAN_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cyan_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_CYAN_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_cyan_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CYAN_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/cyan_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_CYAN_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_cyan_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(LIGHT_BLUE_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/light_blue_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_LIGHT_BLUE_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_light_blue_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_LIGHT_BLUE_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_light_blue_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_LIGHT_BLUE_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_light_blue_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_LIGHT_BLUE_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_light_blue_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(LIGHT_BLUE_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/light_blue_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_LIGHT_BLUE_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_light_blue_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(LIGHT_BLUE_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/light_blue_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_LIGHT_BLUE_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_light_blue_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(BLUE_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/blue_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_BLUE_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_blue_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_BLUE_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_blue_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_BLUE_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_blue_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_BLUE_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_blue_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(BLUE_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/blue_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_BLUE_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_blue_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(BLUE_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/blue_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_BLUE_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_blue_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(PURPLE_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/purple_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_PURPLE_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_purple_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_PURPLE_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_purple_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_PURPLE_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_purple_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_PURPLE_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_purple_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(PURPLE_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/purple_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_PURPLE_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_purple_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(PURPLE_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/purple_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_PURPLE_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_purple_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(MAGENTA_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/magenta_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_MAGENTA_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_magenta_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_MAGENTA_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_magenta_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_MAGENTA_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_magenta_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_MAGENTA_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_magenta_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(MAGENTA_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/magenta_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_MAGENTA_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_magenta_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(MAGENTA_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/magenta_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_MAGENTA_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_magenta_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(PINK_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/pink_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_PINK_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_pink_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_PINK_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_pink_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_PINK_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_pink_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_PINK_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_pink_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(PINK_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/pink_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_PINK_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_pink_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(PINK_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/pink_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_PINK_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_pink_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(BROWN_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/brown_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_BROWN_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_brown_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_BROWN_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_brown_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_BROWN_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_brown_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_BROWN_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_brown_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(BROWN_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/brown_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_BROWN_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_brown_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(BROWN_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/brown_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_BROWN_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_brown_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(WHITE_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/white_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_WHITE_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_white_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_WHITE_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_white_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_WHITE_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_white_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_WHITE_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_white_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(WHITE_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/white_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_WHITE_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_white_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(WHITE_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/white_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_WHITE_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_white_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(LIGHT_GRAY_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/light_gray_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_LIGHT_GRAY_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_light_gray_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_LIGHT_GRAY_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_light_gray_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_LIGHT_GRAY_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_light_gray_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_LIGHT_GRAY_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_light_gray_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(LIGHT_GRAY_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/light_gray_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_LIGHT_GRAY_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_light_gray_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(LIGHT_GRAY_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/light_gray_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_LIGHT_GRAY_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_light_gray_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(GRAY_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/gray_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_GRAY_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_gray_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_GRAY_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_gray_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_GRAY_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_gray_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_GRAY_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_gray_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(GRAY_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/gray_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_GRAY_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_gray_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(GRAY_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/gray_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_GRAY_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_gray_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(BLACK_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/black_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_BLACK_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/cracked_black_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(MOSSY_BLACK_TERRACOTTA_BRICKS.asItem(), Identifier.of("pucks_parity_mod:block/mossy_black_terracotta_bricks"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_BLACK_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_black_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(POLISHED_BLACK_TERRACOTTA.asItem(), Identifier.of("pucks_parity_mod:block/polished_black_terracotta"));
			blockStateModelGenerator.registerParentedItemModel(BLACK_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/black_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(CRACKED_BLACK_TERRACOTTA_TILES.asItem(), Identifier.of("pucks_parity_mod:block/cracked_black_terracotta_tiles"));
			blockStateModelGenerator.registerParentedItemModel(BLACK_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/black_terracotta_pillar"));
			blockStateModelGenerator.registerParentedItemModel(CHISELED_BLACK_TERRACOTTA_PILLAR.asItem(), Identifier.of("pucks_parity_mod:block/chiseled_black_terracotta_pillar"));
		}

		@Override
		public void generateItemModels(ItemModelGenerator itemModelGenerator) {
			itemModelGenerator.register(COPPER_BUCKET, Models.GENERATED);
			itemModelGenerator.register(COPPER_LAVA_BUCKET, Models.GENERATED);
			itemModelGenerator.register(COPPER_MILK_BUCKET, Models.GENERATED);
			itemModelGenerator.register(COPPER_WATER_BUCKET, Models.GENERATED);
			itemModelGenerator.register(COPPER_POWDER_SNOW_BUCKET, Models.GENERATED);
			itemModelGenerator.register(COPPER_NUGGET, Models.GENERATED);
			itemModelGenerator.register(COPPER_SHEARS, Models.GENERATED);
			itemModelGenerator.register(COPPER_HORSE_ARMOR, Models.GENERATED);
			itemModelGenerator.register(COPPER_FIRE_STARTER, Models.GENERATED);

			itemModelGenerator.register(GOLD_BUCKET, Models.GENERATED);
			itemModelGenerator.register(GOLD_LAVA_BUCKET_1, Models.GENERATED);
			itemModelGenerator.register(GOLD_LAVA_BUCKET_2, Models.GENERATED);
			itemModelGenerator.register(GOLD_LAVA_BUCKET_3, Models.GENERATED);
			itemModelGenerator.register(GOLD_WATER_BUCKET_1, Models.GENERATED);
			itemModelGenerator.register(GOLD_WATER_BUCKET_2, Models.GENERATED);
			itemModelGenerator.register(GOLD_WATER_BUCKET_3, Models.GENERATED);
			itemModelGenerator.register(GOLD_MILK_BUCKET_1, Models.GENERATED);
			itemModelGenerator.register(GOLD_MILK_BUCKET_2, Models.GENERATED);
			itemModelGenerator.register(GOLD_MILK_BUCKET_3, Models.GENERATED);
			itemModelGenerator.register(GOLD_POWDER_SNOW_BUCKET_1, Models.GENERATED);
			itemModelGenerator.register(GOLD_POWDER_SNOW_BUCKET_2, Models.GENERATED);
			itemModelGenerator.register(GOLD_POWDER_SNOW_BUCKET_3, Models.GENERATED);
			itemModelGenerator.register(GOLD_SHEARS, Models.GENERATED);
			itemModelGenerator.register(GOLD_BRUSH, Models.GENERATED);
			itemModelGenerator.register(GOLD_FIRE_STARTER, Models.GENERATED);

			itemModelGenerator.register(IRON_BRUSH, Models.GENERATED);

			itemModelGenerator.register(COPPER_CHAIN.asItem(), Models.GENERATED);
			itemModelGenerator.register(EXPOSED_COPPER_CHAIN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WEATHERED_COPPER_CHAIN.asItem(), Models.GENERATED);
			itemModelGenerator.register(OXIDIZED_COPPER_CHAIN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_COPPER_CHAIN.asItem(), COPPER_CHAIN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_EXPOSED_COPPER_CHAIN.asItem(), EXPOSED_COPPER_CHAIN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_WEATHERED_COPPER_CHAIN.asItem(), WEATHERED_COPPER_CHAIN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_OXIDIZED_COPPER_CHAIN.asItem(), OXIDIZED_COPPER_CHAIN.asItem(), Models.GENERATED);

			itemModelGenerator.register(COPPER_BARS.asItem(), Models.GENERATED);
			itemModelGenerator.register(EXPOSED_COPPER_BARS.asItem(), Models.GENERATED);
			itemModelGenerator.register(WEATHERED_COPPER_BARS.asItem(), Models.GENERATED);
			itemModelGenerator.register(OXIDIZED_COPPER_BARS.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_COPPER_BARS.asItem(), COPPER_BARS.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_EXPOSED_COPPER_BARS.asItem(), EXPOSED_COPPER_BARS.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_WEATHERED_COPPER_BARS.asItem(), WEATHERED_COPPER_BARS.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_OXIDIZED_COPPER_BARS.asItem(), OXIDIZED_COPPER_BARS.asItem(), Models.GENERATED);

			itemModelGenerator.register(COPPER_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(EXPOSED_COPPER_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WEATHERED_COPPER_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(OXIDIZED_COPPER_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_COPPER_LANTERN.asItem(), COPPER_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_EXPOSED_COPPER_LANTERN.asItem(), EXPOSED_COPPER_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_WEATHERED_COPPER_LANTERN.asItem(), WEATHERED_COPPER_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_OXIDIZED_COPPER_LANTERN.asItem(), OXIDIZED_COPPER_LANTERN.asItem(), Models.GENERATED);

			itemModelGenerator.register(COPPER_SOUL_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(EXPOSED_COPPER_SOUL_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WEATHERED_COPPER_SOUL_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(OXIDIZED_COPPER_SOUL_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_COPPER_SOUL_LANTERN.asItem(), COPPER_SOUL_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_EXPOSED_COPPER_SOUL_LANTERN.asItem(), EXPOSED_COPPER_SOUL_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_WEATHERED_COPPER_SOUL_LANTERN.asItem(), WEATHERED_COPPER_SOUL_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_OXIDIZED_COPPER_SOUL_LANTERN.asItem(), OXIDIZED_COPPER_SOUL_LANTERN.asItem(), Models.GENERATED);

			itemModelGenerator.register(COPPER_REDSTONE_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(EXPOSED_COPPER_REDSTONE_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WEATHERED_COPPER_REDSTONE_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(OXIDIZED_COPPER_REDSTONE_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_COPPER_REDSTONE_LANTERN.asItem(), COPPER_REDSTONE_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_EXPOSED_COPPER_REDSTONE_LANTERN.asItem(), EXPOSED_COPPER_REDSTONE_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_WEATHERED_COPPER_REDSTONE_LANTERN.asItem(), WEATHERED_COPPER_REDSTONE_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_OXIDIZED_COPPER_REDSTONE_LANTERN.asItem(), OXIDIZED_COPPER_REDSTONE_LANTERN.asItem(), Models.GENERATED);

			itemModelGenerator.register(COPPER_GATE.asItem(), Models.GENERATED);
			itemModelGenerator.register(EXPOSED_COPPER_GATE.asItem(), Models.GENERATED);
			itemModelGenerator.register(WEATHERED_COPPER_GATE.asItem(), Models.GENERATED);
			itemModelGenerator.register(OXIDIZED_COPPER_GATE.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_COPPER_GATE.asItem(), COPPER_GATE.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_EXPOSED_COPPER_GATE.asItem(), EXPOSED_COPPER_GATE.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_WEATHERED_COPPER_GATE.asItem(), WEATHERED_COPPER_GATE.asItem(), Models.GENERATED);
			itemModelGenerator.register(WAXED_OXIDIZED_COPPER_GATE.asItem(), OXIDIZED_COPPER_GATE.asItem(), Models.GENERATED);

			itemModelGenerator.register(GOLD_CHAIN.asItem(), Models.GENERATED);
			itemModelGenerator.register(GOLD_BARS.asItem(), Models.GENERATED);
			itemModelGenerator.register(GOLD_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(GOLD_SOUL_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(GOLD_REDSTONE_LANTERN.asItem(), Models.GENERATED);
			itemModelGenerator.register(GOLD_GATE.asItem(), Models.GENERATED);

			itemModelGenerator.register(IRON_GATE.asItem(), Models.GENERATED);
			itemModelGenerator.register(IRON_REDSTONE_LANTERN.asItem(), Models.GENERATED);
		}

		private void registerPaneDoor(BlockStateModelGenerator blockStateModelGenerator, Block block, String texture) {
			Identifier normal = ModelIds.getBlockModelId(block);
			Identifier open = ModelIds.getBlockSubModelId(block, "_open");
			Identifier open_flipped = ModelIds.getBlockSubModelId(block, "_open_flipped");
			blockStateModelGenerator.blockStateCollector
					.accept(
							VariantsBlockStateSupplier.create(block)
									.coordinate(BlockStateVariantMap.create(Properties.HORIZONTAL_FACING, Properties.DOOR_HINGE, Properties.OPEN)
											.register(Direction.NORTH, DoorHinge.LEFT, true,
													BlockStateVariant.create().put(VariantSettings.MODEL, open_flipped).put(VariantSettings.Y, VariantSettings.Rotation.R0))
											.register(Direction.NORTH, DoorHinge.RIGHT, true,
													BlockStateVariant.create().put(VariantSettings.MODEL, open).put(VariantSettings.Y, VariantSettings.Rotation.R180))
											.register(Direction.NORTH, DoorHinge.LEFT, false,
													BlockStateVariant.create().put(VariantSettings.MODEL, normal).put(VariantSettings.Y, VariantSettings.Rotation.R0))
											.register(Direction.NORTH, DoorHinge.RIGHT, false,
													BlockStateVariant.create().put(VariantSettings.MODEL, normal).put(VariantSettings.Y, VariantSettings.Rotation.R180))
											.register(Direction.SOUTH, DoorHinge.LEFT, true,
													BlockStateVariant.create().put(VariantSettings.MODEL, open_flipped).put(VariantSettings.Y, VariantSettings.Rotation.R180))
											.register(Direction.SOUTH, DoorHinge.RIGHT, true,
													BlockStateVariant.create().put(VariantSettings.MODEL, open).put(VariantSettings.Y, VariantSettings.Rotation.R0))
											.register(Direction.SOUTH, DoorHinge.LEFT, false,
													BlockStateVariant.create().put(VariantSettings.MODEL, normal).put(VariantSettings.Y, VariantSettings.Rotation.R180))
											.register(Direction.SOUTH, DoorHinge.RIGHT, false,
													BlockStateVariant.create().put(VariantSettings.MODEL, normal).put(VariantSettings.Y, VariantSettings.Rotation.R0))
											.register(Direction.EAST, DoorHinge.LEFT, true,
													BlockStateVariant.create().put(VariantSettings.MODEL, open_flipped).put(VariantSettings.Y, VariantSettings.Rotation.R90))
											.register(Direction.EAST, DoorHinge.RIGHT, true,
													BlockStateVariant.create().put(VariantSettings.MODEL, open).put(VariantSettings.Y, VariantSettings.Rotation.R270))
											.register(Direction.EAST, DoorHinge.LEFT, false,
													BlockStateVariant.create().put(VariantSettings.MODEL, normal).put(VariantSettings.Y, VariantSettings.Rotation.R90))
											.register(Direction.EAST, DoorHinge.RIGHT, false,
													BlockStateVariant.create().put(VariantSettings.MODEL, normal).put(VariantSettings.Y, VariantSettings.Rotation.R270))
											.register(Direction.WEST, DoorHinge.LEFT, true,
													BlockStateVariant.create().put(VariantSettings.MODEL, open_flipped).put(VariantSettings.Y, VariantSettings.Rotation.R270))
											.register(Direction.WEST, DoorHinge.RIGHT, true,
													BlockStateVariant.create().put(VariantSettings.MODEL, open).put(VariantSettings.Y, VariantSettings.Rotation.R90))
											.register(Direction.WEST, DoorHinge.LEFT, false,
													BlockStateVariant.create().put(VariantSettings.MODEL, normal).put(VariantSettings.Y, VariantSettings.Rotation.R270))
											.register(Direction.WEST, DoorHinge.RIGHT, false,
													BlockStateVariant.create().put(VariantSettings.MODEL, normal).put(VariantSettings.Y, VariantSettings.Rotation.R90))
									));
			TextureMap textureMap = new TextureMap()
					.put(TextureKey.PARTICLE, Identifier.of("pucks_parity_mod", "block/" + texture))
					.put(TextureKey.TEXTURE, Identifier.of("pucks_parity_mod", "block/" + texture))
					.put(TextureKey.END, Identifier.of("pucks_parity_mod", "block/" + texture + "_end"));

			new Model(Optional.of(Identifier.of("pucks_parity_mod", "block/sliding_pane_base")), Optional.of(texture), TextureKey.PARTICLE, TextureKey.TEXTURE, TextureKey.END)
					.upload(normal, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of("pucks_parity_mod", "block/sliding_pane_open_base")), Optional.of(texture), TextureKey.PARTICLE, TextureKey.TEXTURE, TextureKey.END)
					.upload(open, textureMap, blockStateModelGenerator.modelCollector);
			new Model(Optional.of(Identifier.of("pucks_parity_mod", "block/sliding_pane_open_flipped_base")), Optional.of(texture), TextureKey.PARTICLE, TextureKey.TEXTURE, TextureKey.END)
					.upload(open_flipped, textureMap, blockStateModelGenerator.modelCollector);
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


}
