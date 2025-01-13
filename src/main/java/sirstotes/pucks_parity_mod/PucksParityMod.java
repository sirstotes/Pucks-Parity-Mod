package sirstotes.pucks_parity_mod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
//? if >1.19.2 {
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
//?} else {
/*import net.minecraft.tag.BiomeTags;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryKey;
*///?}
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PucksParityMod implements ModInitializer {
	public static final String MOD_ID = "pucks_parity_mod";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final RegistryKey<PlacedFeature> SMOOTH_PRISMARINE_ORE_PLACED_KEY = RegistryKey.of(/*? if >1.19.2 {*/RegistryKeys.PLACED_FEATURE/*?} else {*//*BuiltinRegistries.PLACED_FEATURE.getKey()*//*?}*/, Identifier.of(MOD_ID,"ore_smooth_prismarine"));
	public static final RegistryKey<PlacedFeature> SMOOTH_DARK_PRISMARINE_ORE_PLACED_KEY = RegistryKey.of(/*? if >1.19.2 {*/RegistryKeys.PLACED_FEATURE/*?} else {*//*BuiltinRegistries.PLACED_FEATURE.getKey()*//*?}*/, Identifier.of(MOD_ID,"ore_smooth_dark_prismarine"));

	@Override
	public void onInitialize() {
		PucksParityModBlocks.initialize();

		BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OCEAN), GenerationStep.Feature.UNDERGROUND_ORES, SMOOTH_PRISMARINE_ORE_PLACED_KEY);
		BiomeModifications.addFeature(BiomeSelectors.tag(BiomeTags.IS_OCEAN), GenerationStep.Feature.UNDERGROUND_ORES, SMOOTH_DARK_PRISMARINE_ORE_PLACED_KEY);
	}
}