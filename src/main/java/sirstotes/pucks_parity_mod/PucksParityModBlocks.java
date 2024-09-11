package sirstotes.pucks_parity_mod;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class PucksParityModBlocks {
    public static Block register(String name, Block block, boolean shouldRegisterItem) {
        Identifier id = Identifier.of(PucksParityMod.MOD_ID, name);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }
    public static void initialize() {
        Registry.register(Registries.BLOCK_TYPE, Identifier.of(PucksParityMod.MOD_ID, "weathering_copper_chain"), OxidizableChainBlock.CODEC);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_CHAIN, EXPOSED_COPPER_CHAIN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_CHAIN, WEATHERED_COPPER_CHAIN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_CHAIN, OXIDIZED_COPPER_CHAIN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_CHAIN, WAXED_COPPER_CHAIN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_CHAIN, WAXED_EXPOSED_COPPER_CHAIN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_CHAIN, WAXED_WEATHERED_COPPER_CHAIN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_CHAIN, WAXED_OXIDIZED_COPPER_CHAIN);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_BARS, EXPOSED_COPPER_BARS);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_BARS, WEATHERED_COPPER_BARS);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_BARS, OXIDIZED_COPPER_BARS);
        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_BARS, WAXED_COPPER_BARS);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_BARS, WAXED_EXPOSED_COPPER_BARS);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_BARS, WAXED_WEATHERED_COPPER_BARS);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_BARS, WAXED_OXIDIZED_COPPER_BARS);


        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((itemGroup) -> {
            itemGroup.add(COPPER_CHAIN.asItem());
            itemGroup.add(EXPOSED_COPPER_CHAIN.asItem());
            itemGroup.add(WEATHERED_COPPER_CHAIN.asItem());
            itemGroup.add(OXIDIZED_COPPER_CHAIN.asItem());
            itemGroup.add(WAXED_COPPER_CHAIN.asItem());
            itemGroup.add(WAXED_EXPOSED_COPPER_CHAIN.asItem());
            itemGroup.add(WAXED_WEATHERED_COPPER_CHAIN.asItem());
            itemGroup.add(WAXED_OXIDIZED_COPPER_CHAIN.asItem());
            itemGroup.add(COPPER_BARS.asItem());
            itemGroup.add(EXPOSED_COPPER_BARS.asItem());
            itemGroup.add(WEATHERED_COPPER_BARS.asItem());
            itemGroup.add(OXIDIZED_COPPER_BARS.asItem());
            itemGroup.add(WAXED_COPPER_BARS.asItem());
            itemGroup.add(WAXED_EXPOSED_COPPER_BARS.asItem());
            itemGroup.add(WAXED_WEATHERED_COPPER_BARS.asItem());
            itemGroup.add(WAXED_OXIDIZED_COPPER_BARS.asItem());
        });
    }

    public static final Block COPPER_CHAIN = register("copper_chain", new OxidizableChainBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().solid().requiresTool().strength(4.0F, 6.0F).sounds(BlockSoundGroup.CHAIN).nonOpaque()), true);
    public static final Block WAXED_COPPER_CHAIN = register("waxed_copper_chain", new ChainBlock(AbstractBlock.Settings.copy(COPPER_CHAIN)), true);
    public static final Block EXPOSED_COPPER_CHAIN = register("exposed_copper_chain", new OxidizableChainBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().solid().requiresTool().strength(4.0F, 5.0F).sounds(BlockSoundGroup.CHAIN).nonOpaque()), true);
    public static final Block WAXED_EXPOSED_COPPER_CHAIN = register("waxed_exposed_copper_chain", new ChainBlock(AbstractBlock.Settings.copy(COPPER_CHAIN)), true);
    public static final Block WEATHERED_COPPER_CHAIN = register("weathered_copper_chain", new OxidizableChainBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().solid().requiresTool().strength(4.0F, 4.0F).sounds(BlockSoundGroup.CHAIN).nonOpaque()), true);
    public static final Block WAXED_WEATHERED_COPPER_CHAIN = register("waxed_weathered_copper_chain", new ChainBlock(AbstractBlock.Settings.copy(COPPER_CHAIN)), true);
    public static final Block OXIDIZED_COPPER_CHAIN = register("oxidized_copper_chain", new OxidizableChainBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().solid().requiresTool().strength(4.0F, 3.0F).sounds(BlockSoundGroup.CHAIN).nonOpaque()), true);
    public static final Block WAXED_OXIDIZED_COPPER_CHAIN = register("waxed_oxidized_copper_chain", new ChainBlock(AbstractBlock.Settings.copy(COPPER_CHAIN)), true);

    public static final Block COPPER_BARS = register("copper_bars", new OxidizablePaneBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().requiresTool().strength(4.0F, 6.0F).sounds(BlockSoundGroup.METAL).nonOpaque()), true);
    public static final Block WAXED_COPPER_BARS = register("waxed_copper_bars", new PaneBlock(AbstractBlock.Settings.copy(COPPER_BARS)), true);
    public static final Block EXPOSED_COPPER_BARS = register("exposed_copper_bars", new OxidizablePaneBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().requiresTool().strength(4.0F, 5.0F).sounds(BlockSoundGroup.METAL).nonOpaque()), true);
    public static final Block WAXED_EXPOSED_COPPER_BARS = register("waxed_exposed_copper_bars", new PaneBlock(AbstractBlock.Settings.copy(EXPOSED_COPPER_BARS)), true);
    public static final Block WEATHERED_COPPER_BARS = register("weathered_copper_bars", new OxidizablePaneBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().requiresTool().strength(4.0F, 4.0F).sounds(BlockSoundGroup.METAL).nonOpaque()), true);
    public static final Block WAXED_WEATHERED_COPPER_BARS = register("waxed_weathered_copper_bars", new PaneBlock(AbstractBlock.Settings.copy(WEATHERED_COPPER_BARS)), true);
    public static final Block OXIDIZED_COPPER_BARS = register("oxidized_copper_bars", new OxidizablePaneBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().requiresTool().strength(4.0F, 3.0F).sounds(BlockSoundGroup.METAL).nonOpaque()), true);
    public static final Block WAXED_OXIDIZED_COPPER_BARS = register("waxed_oxidized_copper_bars", new PaneBlock(AbstractBlock.Settings.copy(OXIDIZED_COPPER_BARS)), true);
    //public static final MapCodec<? extends Block> COPPER_CHAIN_TYPE = Registry.register(Registries.BLOCK_TYPE, Identifier.of(PucksParityMod.MOD_ID, "weathering_copper_chain"), OxidizableChainBlock.CODEC);
}
