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

        OxidizableBlocksRegistry.registerOxidizableBlockPair(PLAYER_PRESSURE_PLATE, EXPOSED_PLAYER_PRESSURE_PLATE);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(EXPOSED_PLAYER_PRESSURE_PLATE, WEATHERED_PLAYER_PRESSURE_PLATE);
        OxidizableBlocksRegistry.registerOxidizableBlockPair(WEATHERED_PLAYER_PRESSURE_PLATE, OXIDIZED_PLAYER_PRESSURE_PLATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(PLAYER_PRESSURE_PLATE, WAXED_PLAYER_PRESSURE_PLATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(EXPOSED_PLAYER_PRESSURE_PLATE, WAXED_EXPOSED_PLAYER_PRESSURE_PLATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(WEATHERED_PLAYER_PRESSURE_PLATE, WAXED_WEATHERED_PLAYER_PRESSURE_PLATE);
        OxidizableBlocksRegistry.registerWaxableBlockPair(OXIDIZED_PLAYER_PRESSURE_PLATE, WAXED_OXIDIZED_PLAYER_PRESSURE_PLATE);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((itemGroup) -> {
            itemGroup.add(GOLD_CHAIN.asItem());
            itemGroup.add(GOLD_DOOR.asItem());
            itemGroup.add(GOLD_TRAPDOOR.asItem());
            itemGroup.add(COPPER_CHAIN.asItem());
            itemGroup.add(EXPOSED_COPPER_CHAIN.asItem());
            itemGroup.add(WEATHERED_COPPER_CHAIN.asItem());
            itemGroup.add(OXIDIZED_COPPER_CHAIN.asItem());
            itemGroup.add(WAXED_COPPER_CHAIN.asItem());
            itemGroup.add(WAXED_EXPOSED_COPPER_CHAIN.asItem());
            itemGroup.add(WAXED_WEATHERED_COPPER_CHAIN.asItem());
            itemGroup.add(WAXED_OXIDIZED_COPPER_CHAIN.asItem());
            itemGroup.add(GOLD_BARS.asItem());
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
    public static final Block COPPER_LANTERN = register("copper_lantern", new OxidizableLanternBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WAXED_COPPER_LANTERN = register("waxed_copper_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block EXPOSED_COPPER_LANTERN = register("exposed_copper_lantern", new OxidizableLanternBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WAXED_EXPOSED_COPPER_LANTERN = register("waxed_exposed_copper_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WEATHERED_COPPER_LANTERN = register("weathered_copper_lantern", new OxidizableLanternBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WAXED_WEATHERED_COPPER_LANTERN = register("waxed_weathered_copper_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block OXIDIZED_COPPER_LANTERN = register("oxidized_copper_lantern", new OxidizableLanternBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.copy(Blocks.LANTERN)), true);
    public static final Block WAXED_OXIDIZED_COPPER_LANTERN = register("waxed_oxidized_copper_lantern", new LanternBlock(AbstractBlock.Settings.copy(Blocks.LANTERN)), true);

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
    public static final Block GOLD_BULB = register("gold_bulb", new BulbBlock(AbstractBlock.Settings.create()
        .mapColor(Blocks.GOLD_BLOCK.getDefaultMapColor())
        .strength(3.0F, 6.0F)
        .sounds(BlockSoundGroup.COPPER_BULB)
        .requiresTool()
        .solidBlock(Blocks::never)
        .luminance(Blocks.createLightLevelFromLitBlockState(15))), true);
    public static final Block GOLD_GATE = register("gold_gate", new SlidingPaneDoorBlock(BlockSetType.GOLD, AbstractBlock.Settings.create()), true);

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
}
