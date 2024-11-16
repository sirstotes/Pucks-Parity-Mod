package sirstotes.pucks_parity_mod;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;

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

        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_LANTERN, EXPOSED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_LANTERN, WEATHERED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_LANTERN, OXIDIZED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_LANTERN, WAXED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_LANTERN, WAXED_EXPOSED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_LANTERN, WAXED_WEATHERED_COPPER_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_LANTERN, WAXED_OXIDIZED_COPPER_LANTERN);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_SOUL_LANTERN, EXPOSED_COPPER_SOUL_LANTERN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_SOUL_LANTERN, WEATHERED_COPPER_SOUL_LANTERN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_SOUL_LANTERN, OXIDIZED_COPPER_SOUL_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_SOUL_LANTERN, WAXED_COPPER_SOUL_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_SOUL_LANTERN, WAXED_EXPOSED_COPPER_SOUL_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_SOUL_LANTERN, WAXED_WEATHERED_COPPER_SOUL_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_SOUL_LANTERN, WAXED_OXIDIZED_COPPER_SOUL_LANTERN);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_REDSTONE_LANTERN, EXPOSED_COPPER_REDSTONE_LANTERN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_REDSTONE_LANTERN, WEATHERED_COPPER_REDSTONE_LANTERN);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_REDSTONE_LANTERN, OXIDIZED_COPPER_REDSTONE_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_REDSTONE_LANTERN, WAXED_COPPER_REDSTONE_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_REDSTONE_LANTERN, WAXED_EXPOSED_COPPER_REDSTONE_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_REDSTONE_LANTERN, WAXED_WEATHERED_COPPER_REDSTONE_LANTERN);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_REDSTONE_LANTERN, WAXED_OXIDIZED_COPPER_REDSTONE_LANTERN);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(PLAYER_PRESSURE_PLATE, EXPOSED_PLAYER_PRESSURE_PLATE);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_PLAYER_PRESSURE_PLATE, WEATHERED_PLAYER_PRESSURE_PLATE);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_PLAYER_PRESSURE_PLATE, OXIDIZED_PLAYER_PRESSURE_PLATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(PLAYER_PRESSURE_PLATE, WAXED_PLAYER_PRESSURE_PLATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_PLAYER_PRESSURE_PLATE, WAXED_EXPOSED_PLAYER_PRESSURE_PLATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_PLAYER_PRESSURE_PLATE, WAXED_WEATHERED_PLAYER_PRESSURE_PLATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_PLAYER_PRESSURE_PLATE, WAXED_OXIDIZED_PLAYER_PRESSURE_PLATE);

        OxidizableBlocksRegistry.registerOxidizableBlockPair(COPPER_GATE, EXPOSED_COPPER_GATE);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_COPPER_GATE, WEATHERED_COPPER_GATE);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_COPPER_GATE, OXIDIZED_COPPER_GATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(COPPER_GATE, WAXED_COPPER_GATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_COPPER_GATE, WAXED_EXPOSED_COPPER_GATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_COPPER_GATE, WAXED_WEATHERED_COPPER_GATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_COPPER_GATE, WAXED_OXIDIZED_COPPER_GATE);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((itemGroup) -> {
            itemGroup.addAfter(Items.IRON_BLOCK, new ItemStack[] {new ItemStack(CHISELED_IRON),
                    new ItemStack(IRON_GRATE),
                    new ItemStack(CUT_IRON),
                    new ItemStack(CUT_IRON_STAIRS),
                    new ItemStack(CUT_IRON_SLAB)});
            itemGroup.addAfter(Items.IRON_BARS, IRON_GATE);
            itemGroup.addAfter(Items.IRON_TRAPDOOR, IRON_BULB);
            itemGroup.addAfter(Items.GOLD_BLOCK, new ItemStack[] {new ItemStack(CHISELED_GOLD),
                    new ItemStack(GOLD_GRATE),
                    new ItemStack(CUT_GOLD),
                    new ItemStack(CUT_GOLD_STAIRS),
                    new ItemStack(CUT_GOLD_SLAB),
                    new ItemStack(GOLD_BARS),
                    new ItemStack(GOLD_GATE),
                    new ItemStack(GOLD_DOOR),
                    new ItemStack(GOLD_TRAPDOOR)});
            itemGroup.addAfter(Items.HEAVY_WEIGHTED_PRESSURE_PLATE, GOLD_CHAIN);
            itemGroup.addAfter(Items.CUT_COPPER_SLAB, new ItemStack[] {new ItemStack(COPPER_BARS), new ItemStack(COPPER_GATE)});
            itemGroup.addAfter(Items.COPPER_BULB, new ItemStack[] {new ItemStack(PLAYER_PRESSURE_PLATE), new ItemStack(COPPER_CHAIN)});
            itemGroup.addAfter(Items.EXPOSED_CUT_COPPER_SLAB, new ItemStack[] {new ItemStack(EXPOSED_COPPER_BARS), new ItemStack(EXPOSED_COPPER_GATE)});
            itemGroup.addAfter(Items.EXPOSED_COPPER_BULB, new ItemStack[] {new ItemStack(EXPOSED_PLAYER_PRESSURE_PLATE), new ItemStack(EXPOSED_COPPER_CHAIN)});
            itemGroup.addAfter(Items.WEATHERED_CUT_COPPER_SLAB, new ItemStack[] {new ItemStack(WEATHERED_COPPER_BARS), new ItemStack(WEATHERED_COPPER_GATE)});
            itemGroup.addAfter(Items.WEATHERED_COPPER_BULB, new ItemStack[] {new ItemStack(WEATHERED_PLAYER_PRESSURE_PLATE), new ItemStack(WEATHERED_COPPER_CHAIN)});
            itemGroup.addAfter(Items.OXIDIZED_CUT_COPPER_SLAB, new ItemStack[] {new ItemStack(OXIDIZED_COPPER_BARS), new ItemStack(OXIDIZED_COPPER_GATE)});
            itemGroup.addAfter(Items.OXIDIZED_COPPER_BULB, new ItemStack[] {new ItemStack(OXIDIZED_PLAYER_PRESSURE_PLATE), new ItemStack(OXIDIZED_COPPER_CHAIN)});
            itemGroup.addAfter(Items.WAXED_CUT_COPPER_SLAB, new ItemStack[] {new ItemStack(WAXED_COPPER_BARS), new ItemStack(WAXED_COPPER_GATE)});
            itemGroup.addAfter(Items.WAXED_COPPER_BULB, new ItemStack[] {new ItemStack(WAXED_PLAYER_PRESSURE_PLATE), new ItemStack(WAXED_COPPER_CHAIN)});
            itemGroup.addAfter(Items.WAXED_EXPOSED_CUT_COPPER_SLAB, new ItemStack[] {new ItemStack(WAXED_EXPOSED_COPPER_BARS), new ItemStack(WAXED_EXPOSED_COPPER_GATE)});
            itemGroup.addAfter(Items.WAXED_EXPOSED_COPPER_BULB, new ItemStack[] {new ItemStack(WAXED_EXPOSED_PLAYER_PRESSURE_PLATE), new ItemStack(WAXED_EXPOSED_COPPER_CHAIN)});
            itemGroup.addAfter(Items.WAXED_WEATHERED_CUT_COPPER_SLAB, new ItemStack[] {new ItemStack(WAXED_WEATHERED_COPPER_BARS), new ItemStack(WAXED_WEATHERED_COPPER_GATE)});
            itemGroup.addAfter(Items.WAXED_WEATHERED_COPPER_BULB, new ItemStack[] {new ItemStack(WAXED_WEATHERED_PLAYER_PRESSURE_PLATE), new ItemStack(WAXED_WEATHERED_COPPER_CHAIN)});
            itemGroup.addAfter(Items.WAXED_OXIDIZED_CUT_COPPER_SLAB, new ItemStack[] {new ItemStack(WAXED_OXIDIZED_COPPER_BARS), new ItemStack(WAXED_OXIDIZED_COPPER_GATE)});
            itemGroup.addAfter(Items.WAXED_OXIDIZED_COPPER_BULB, new ItemStack[] {new ItemStack(WAXED_OXIDIZED_PLAYER_PRESSURE_PLATE), new ItemStack(WAXED_OXIDIZED_COPPER_CHAIN)});
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register((itemGroup) -> {
            itemGroup.addAfter(Items.SOUL_LANTERN, new ItemStack[] {new ItemStack(IRON_REDSTONE_LANTERN),
                    new ItemStack(GOLD_LANTERN),
                    new ItemStack(GOLD_SOUL_LANTERN),
                    new ItemStack(GOLD_REDSTONE_LANTERN),
                    new ItemStack(COPPER_LANTERN), new ItemStack(COPPER_SOUL_LANTERN), new ItemStack(COPPER_REDSTONE_LANTERN),
                    new ItemStack(EXPOSED_COPPER_LANTERN), new ItemStack(EXPOSED_COPPER_SOUL_LANTERN), new ItemStack(EXPOSED_COPPER_REDSTONE_LANTERN),
                    new ItemStack(WEATHERED_COPPER_LANTERN), new ItemStack(WEATHERED_COPPER_SOUL_LANTERN), new ItemStack(WEATHERED_COPPER_REDSTONE_LANTERN),
                    new ItemStack(OXIDIZED_COPPER_LANTERN), new ItemStack(OXIDIZED_COPPER_SOUL_LANTERN), new ItemStack(OXIDIZED_COPPER_REDSTONE_LANTERN),
                    new ItemStack(WAXED_COPPER_LANTERN), new ItemStack(WAXED_COPPER_SOUL_LANTERN), new ItemStack(WAXED_COPPER_REDSTONE_LANTERN),
                    new ItemStack(WAXED_EXPOSED_COPPER_LANTERN), new ItemStack(WAXED_EXPOSED_COPPER_SOUL_LANTERN), new ItemStack(WAXED_EXPOSED_COPPER_REDSTONE_LANTERN),
                    new ItemStack(WAXED_WEATHERED_COPPER_LANTERN), new ItemStack(WAXED_WEATHERED_COPPER_SOUL_LANTERN), new ItemStack(WAXED_WEATHERED_COPPER_REDSTONE_LANTERN),
                    new ItemStack(WAXED_OXIDIZED_COPPER_LANTERN), new ItemStack(WAXED_OXIDIZED_COPPER_SOUL_LANTERN), new ItemStack(WAXED_OXIDIZED_COPPER_REDSTONE_LANTERN)});
            itemGroup.addAfter(Items.CHAIN, new ItemStack[] {new ItemStack(GOLD_CHAIN),
                    new ItemStack(COPPER_CHAIN),
                    new ItemStack(EXPOSED_COPPER_CHAIN),
                    new ItemStack(WEATHERED_COPPER_CHAIN),
                    new ItemStack(OXIDIZED_COPPER_CHAIN),
                    new ItemStack(WAXED_COPPER_CHAIN),
                    new ItemStack(WAXED_EXPOSED_COPPER_CHAIN),
                    new ItemStack(WAXED_WEATHERED_COPPER_CHAIN),
                    new ItemStack(WAXED_OXIDIZED_COPPER_CHAIN)});
            itemGroup.addAfter(Items.REDSTONE_LAMP, new ItemStack[] {new ItemStack(IRON_BULB), new ItemStack(GOLD_BULB)});
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register((itemGroup) -> {
            itemGroup.addAfter(Items.LIGHT_WEIGHTED_PRESSURE_PLATE, new ItemStack[] {
                    new ItemStack (WAXED_PLAYER_PRESSURE_PLATE),
                    new ItemStack (WAXED_EXPOSED_PLAYER_PRESSURE_PLATE),
                    new ItemStack (WAXED_WEATHERED_PLAYER_PRESSURE_PLATE),
                    new ItemStack (WAXED_OXIDIZED_PLAYER_PRESSURE_PLATE)
            });
            itemGroup.addAfter(Items.IRON_DOOR, GOLD_DOOR);
            itemGroup.addAfter(Items.OAK_FENCE_GATE, new ItemStack[] {new ItemStack(WAXED_COPPER_GATE), new ItemStack(IRON_GATE), new ItemStack(GOLD_GATE)});
            itemGroup.addAfter(Items.IRON_TRAPDOOR, GOLD_TRAPDOOR);
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

    public static final Block COPPER_LANTERN = register("copper_lantern", new OxidizableLanternBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WAXED_COPPER_LANTERN = register("waxed_copper_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block EXPOSED_COPPER_LANTERN = register("exposed_copper_lantern", new OxidizableLanternBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WAXED_EXPOSED_COPPER_LANTERN = register("waxed_exposed_copper_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WEATHERED_COPPER_LANTERN = register("weathered_copper_lantern", new OxidizableLanternBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WAXED_WEATHERED_COPPER_LANTERN = register("waxed_weathered_copper_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block OXIDIZED_COPPER_LANTERN = register("oxidized_copper_lantern", new OxidizableLanternBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WAXED_OXIDIZED_COPPER_LANTERN = register("waxed_oxidized_copper_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);

    public static final Block COPPER_SOUL_LANTERN = register("copper_soul_lantern", new OxidizableLanternBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WAXED_COPPER_SOUL_LANTERN = register("waxed_copper_soul_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block EXPOSED_COPPER_SOUL_LANTERN = register("exposed_copper_soul_lantern", new OxidizableLanternBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WAXED_EXPOSED_COPPER_SOUL_LANTERN = register("waxed_exposed_copper_soul_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WEATHERED_COPPER_SOUL_LANTERN = register("weathered_copper_soul_lantern", new OxidizableLanternBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WAXED_WEATHERED_COPPER_SOUL_LANTERN = register("waxed_weathered_copper_soul_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block OXIDIZED_COPPER_SOUL_LANTERN = register("oxidized_copper_soul_lantern", new OxidizableLanternBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WAXED_OXIDIZED_COPPER_SOUL_LANTERN = register("waxed_oxidized_copper_soul_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);

    public static final Block COPPER_REDSTONE_LANTERN = register("copper_redstone_lantern", new OxidizableLanternBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WAXED_COPPER_REDSTONE_LANTERN = register("waxed_copper_redstone_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block EXPOSED_COPPER_REDSTONE_LANTERN = register("exposed_copper_redstone_lantern", new OxidizableLanternBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WAXED_EXPOSED_COPPER_REDSTONE_LANTERN = register("waxed_exposed_copper_redstone_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WEATHERED_COPPER_REDSTONE_LANTERN = register("weathered_copper_redstone_lantern", new OxidizableLanternBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WAXED_WEATHERED_COPPER_REDSTONE_LANTERN = register("waxed_weathered_copper_redstone_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block OXIDIZED_COPPER_REDSTONE_LANTERN = register("oxidized_copper_redstone_lantern", new OxidizableLanternBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WAXED_OXIDIZED_COPPER_REDSTONE_LANTERN = register("waxed_oxidized_copper_redstone_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);

    public static final Block PLAYER_PRESSURE_PLATE = register(
            "player_pressure_plate",
            new OxidizablePlayerOnlyPressurePlateBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).solid().requiresTool().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY),
                    BlockSetType.COPPER,
                    0,
                    Oxidizable.OxidationLevel.UNAFFECTED
            ),
            true
    );
    public static final Block WAXED_PLAYER_PRESSURE_PLATE = register(
            "waxed_player_pressure_plate",
            new PlayerOnlyPressurePlateBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).solid().requiresTool().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY),
                    BlockSetType.COPPER,
                    0
            ),
            true
    );
    public static final Block EXPOSED_PLAYER_PRESSURE_PLATE = register(
            "exposed_player_pressure_plate",
            new OxidizablePlayerOnlyPressurePlateBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).solid().requiresTool().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY),
                    BlockSetType.COPPER,
                    10,
                    Oxidizable.OxidationLevel.EXPOSED
            ),
            true
    );
    public static final Block WAXED_EXPOSED_PLAYER_PRESSURE_PLATE = register(
            "waxed_exposed_player_pressure_plate",
            new PlayerOnlyPressurePlateBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).solid().requiresTool().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY),
                    BlockSetType.COPPER,
                    10
            ),
            true
    );
    public static final Block WEATHERED_PLAYER_PRESSURE_PLATE = register(
            "weathered_player_pressure_plate",
            new OxidizablePlayerOnlyPressurePlateBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).solid().requiresTool().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY),
                    BlockSetType.COPPER,
                    20,
                    Oxidizable.OxidationLevel.WEATHERED
            ),
            true
    );
    public static final Block WAXED_WEATHERED_PLAYER_PRESSURE_PLATE = register(
            "waxed_weathered_player_pressure_plate",
            new PlayerOnlyPressurePlateBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).solid().requiresTool().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY),
                    BlockSetType.COPPER,
                    20
            ),
            true
    );
    public static final Block OXIDIZED_PLAYER_PRESSURE_PLATE = register(
            "oxidized_player_pressure_plate",
            new OxidizablePlayerOnlyPressurePlateBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).solid().requiresTool().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY),
                    BlockSetType.COPPER,
                    50,
                    Oxidizable.OxidationLevel.OXIDIZED
            ),
            true
    );
    public static final Block WAXED_OXIDIZED_PLAYER_PRESSURE_PLATE = register(
            "waxed_oxidized_player_pressure_plate",
            new PlayerOnlyPressurePlateBlock(
                    AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).solid().requiresTool().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY),
                    BlockSetType.COPPER,
                    50
            ),
            true
    );
    public static final Block COPPER_GATE = register("copper_gate", new OxidizableSlidingPaneDoorBlock(BlockSetType.COPPER, Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.copy(Blocks.COPPER_DOOR)), true);
    public static final Block WAXED_COPPER_GATE = register("waxed_copper_gate", new SlidingPaneDoorBlock(BlockSetType.COPPER, AbstractBlock.Settings.copy(Blocks.COPPER_DOOR)), true);
    public static final Block EXPOSED_COPPER_GATE = register("exposed_copper_gate", new OxidizableSlidingPaneDoorBlock(BlockSetType.COPPER, Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.copy(Blocks.COPPER_DOOR)), true);
    public static final Block WAXED_EXPOSED_COPPER_GATE = register("waxed_exposed_copper_gate", new SlidingPaneDoorBlock(BlockSetType.COPPER, AbstractBlock.Settings.copy(Blocks.COPPER_DOOR)), true);
    public static final Block WEATHERED_COPPER_GATE = register("weathered_copper_gate", new OxidizableSlidingPaneDoorBlock(BlockSetType.COPPER, Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.copy(Blocks.COPPER_DOOR)), true);
    public static final Block WAXED_WEATHERED_COPPER_GATE = register("waxed_weathered_copper_gate", new SlidingPaneDoorBlock(BlockSetType.COPPER, AbstractBlock.Settings.copy(Blocks.COPPER_DOOR)), true);
    public static final Block OXIDIZED_COPPER_GATE = register("oxidized_copper_gate", new OxidizableSlidingPaneDoorBlock(BlockSetType.COPPER, Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.copy(Blocks.COPPER_DOOR)), true);
    public static final Block WAXED_OXIDIZED_COPPER_GATE = register("waxed_oxidized_copper_gate", new SlidingPaneDoorBlock(BlockSetType.COPPER, AbstractBlock.Settings.copy(Blocks.COPPER_DOOR)), true);

    public static final Block GOLD_CHAIN = register("gold_chain", new ChainBlock(AbstractBlock.Settings.create().solid().requiresTool().strength(4.0F, 6.0F).sounds(BlockSoundGroup.CHAIN).nonOpaque()), true);
    public static final Block GOLD_BARS = register("gold_bars", new PaneBlock(AbstractBlock.Settings.create().requiresTool().strength(4.0F, 6.0F).sounds(BlockSoundGroup.METAL).nonOpaque()), true);
    public static final Block GOLD_TRAPDOOR = register("gold_trapdoor", new GoldTrapdoorBlock(BlockSetType.GOLD, AbstractBlock.Settings.create().mapColor(MapColor.GOLD).requiresTool().strength(4.0F).allowsSpawning(Blocks::never)), true);
    public static final Block GOLD_DOOR = register("gold_door", new GoldDoorBlock(BlockSetType.GOLD, AbstractBlock.Settings.create().mapColor(MapColor.GOLD).requiresTool().strength(4.0F).pistonBehavior(PistonBehavior.DESTROY)), true);
    public static final Block CHISELED_GOLD = register("chiseled_gold", new Block(AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK)), true);
    public static final Block CUT_GOLD = register("cut_gold", new Block(AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK)), true);
    public static final Block CUT_GOLD_SLAB = register("cut_gold_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK)), true);
    public static final Block CUT_GOLD_STAIRS = register("cut_gold_stairs", new StairsBlock(CUT_GOLD.getDefaultState(), AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK)), true);
    public static final Block GOLD_GRATE = register("gold_grate", new GrateBlock(AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK).nonOpaque()), true);
    public static final Block GOLD_LANTERN = register("gold_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block GOLD_SOUL_LANTERN = register("gold_soul_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block GOLD_REDSTONE_LANTERN = register("gold_redstone_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block GOLD_BULB = register("gold_bulb", new BulbBlock(AbstractBlock.Settings.create()
        .mapColor(Blocks.GOLD_BLOCK.getDefaultMapColor())
        .strength(3.0F, 6.0F)
        .sounds(BlockSoundGroup.COPPER_BULB)
        .requiresTool()
        .solidBlock(Blocks::never)
        .luminance(Blocks.createLightLevelFromLitBlockState(15))), true);
    public static final Block GOLD_GATE = register("gold_gate", new GoldSlidingPaneDoorBlock(BlockSetType.GOLD, AbstractBlock.Settings.copy(GOLD_DOOR)), true);

    public static final Block CHISELED_IRON = register("chiseled_iron", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)), true);
    public static final Block CUT_IRON = register("cut_iron", new Block(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)), true);
    public static final Block CUT_IRON_SLAB = register("cut_iron_slab", new SlabBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)), true);
    public static final Block CUT_IRON_STAIRS = register("cut_iron_stairs", new StairsBlock(CUT_IRON.getDefaultState(), AbstractBlock.Settings.copy(Blocks.IRON_BLOCK)), true);
    public static final Block IRON_GRATE = register("iron_grate", new GrateBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK).nonOpaque()), true);
    public static final Block IRON_BULB = register("iron_bulb", new DirectionalBulbBlock(AbstractBlock.Settings.create()
            .mapColor(Blocks.IRON_BLOCK.getDefaultMapColor())
            .strength(3.0F, 6.0F)
            .sounds(BlockSoundGroup.COPPER_BULB)
            .requiresTool()
            .solidBlock(Blocks::never)
            .luminance(Blocks.createLightLevelFromLitBlockState(15))), true);
    public static final Block IRON_GATE = register("iron_gate", new SlidingPaneDoorBlock(BlockSetType.IRON, AbstractBlock.Settings.copy(Blocks.IRON_DOOR)), true);
    public static final Block IRON_REDSTONE_LANTERN = register("iron_redstone_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
}
