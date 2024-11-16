package sirstotes.pucks_parity_mod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.*;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.UnaryOperator;

import static sirstotes.pucks_parity_mod.PucksParityModBlocks.*;
import static sirstotes.pucks_parity_mod.PucksParityModItems.*;

public class PucksParityModDataGenerator implements DataGeneratorEntrypoint {
	private static class RecipeGenerator extends FabricRecipeProvider {
		private RecipeGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
			super(output, registriesFuture);
		}

		@Override
		public void generate(RecipeExporter exporter) {
			offerReversibleCompactingRecipesWithCompactingRecipeGroup(
					exporter, RecipeCategory.MISC, COPPER_NUGGET, RecipeCategory.MISC, Items.COPPER_INGOT, "copper_ingot_from_nuggets", "copper_ingot"
			);
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
			createDoorRecipe(PucksParityModBlocks.GOLD_DOOR, Ingredient.ofItems(Items.GOLD_INGOT))
					.criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
					.offerTo(exporter);
			createTrapdoorRecipe(PucksParityModBlocks.GOLD_TRAPDOOR, Ingredient.ofItems(Items.GOLD_INGOT))
					.criterion(hasItem(Items.GOLD_INGOT), conditionsFromItem(Items.GOLD_INGOT))
					.offerTo(exporter);
			offerGrateRecipe(exporter, PucksParityModBlocks.GOLD_GRATE, Blocks.GOLD_BLOCK);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PucksParityModBlocks.CUT_GOLD_SLAB, PucksParityModBlocks.CUT_GOLD, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PucksParityModBlocks.CUT_GOLD_STAIRS, PucksParityModBlocks.CUT_GOLD);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PucksParityModBlocks.CUT_GOLD, Blocks.GOLD_BLOCK, 4);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PucksParityModBlocks.CUT_GOLD_STAIRS, Blocks.GOLD_BLOCK, 4);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PucksParityModBlocks.CUT_GOLD_SLAB, Blocks.GOLD_BLOCK, 8);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PucksParityModBlocks.CHISELED_GOLD, Blocks.GOLD_BLOCK, 4);
			offerBulbRecipe(exporter, PucksParityModBlocks.GOLD_BULB, Blocks.GOLD_BLOCK);
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
					.input('X', CUT_GOLD)
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
			offerGrateRecipe(exporter, PucksParityModBlocks.IRON_GRATE, Blocks.IRON_BLOCK);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PucksParityModBlocks.CUT_IRON_SLAB, PucksParityModBlocks.CUT_IRON, 2);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PucksParityModBlocks.CUT_IRON_STAIRS, PucksParityModBlocks.CUT_IRON);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PucksParityModBlocks.CUT_IRON, Blocks.IRON_BLOCK, 4);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PucksParityModBlocks.CUT_IRON_STAIRS, Blocks.IRON_BLOCK, 4);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PucksParityModBlocks.CUT_IRON_SLAB, Blocks.IRON_BLOCK, 8);
			offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, PucksParityModBlocks.CHISELED_IRON, Blocks.IRON_BLOCK, 4);
			offerBulbRecipe(exporter, PucksParityModBlocks.IRON_BULB, Blocks.IRON_BLOCK);
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
					.input('X', CUT_IRON)
					.pattern("X")
					.pattern("X")
					.criterion("has_cut_gold_block", conditionsFromItem(CUT_IRON))
					.offerTo(exporter);
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

			addDrop(IRON_BULB, drops(IRON_BULB.asItem()));
			addDrop(CUT_IRON, drops(CUT_IRON.asItem()));
			addDrop(CHISELED_IRON, drops(CHISELED_IRON.asItem()));
			addDrop(IRON_GRATE, drops(IRON_GRATE.asItem()));
			addDrop(IRON_GATE, drops(IRON_GATE.asItem()));
			addDrop(IRON_REDSTONE_LANTERN, drops(IRON_REDSTONE_LANTERN.asItem()));
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

			PucksParityModBlockFamilies.getFamilies()
					.filter(BlockFamily::shouldGenerateModels)
					.forEach(family -> blockStateModelGenerator.registerCubeAllModelTexturePool(family.getBaseBlock()).family(family));

			blockStateModelGenerator.registerTrapdoor(GOLD_TRAPDOOR);
			blockStateModelGenerator.registerDoor(GOLD_DOOR);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_GOLD);
			blockStateModelGenerator.registerSimpleCubeAll(GOLD_GRATE);
			blockStateModelGenerator.registerSimpleCubeAll(CHISELED_IRON);
			blockStateModelGenerator.registerSimpleCubeAll(IRON_GRATE);
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
		pack.addProvider(RecipeGenerator::new);
	}

}
