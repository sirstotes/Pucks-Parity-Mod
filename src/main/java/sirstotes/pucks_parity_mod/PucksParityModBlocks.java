package sirstotes.pucks_parity_mod;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ChainBlock;
import net.minecraft.block.Oxidizable;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
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
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register((itemGroup) -> {
            itemGroup.add(COPPER_CHAIN.asItem());
            itemGroup.add(EXPOSED_COPPER_CHAIN.asItem());
            itemGroup.add(WEATHERED_COPPER_CHAIN.asItem());
            itemGroup.add(OXIDIZED_COPPER_CHAIN.asItem());
        });
    }

    public static final Block COPPER_CHAIN = register("copper_chain", new CopperChainBlock(Oxidizable.OxidationLevel.UNAFFECTED, AbstractBlock.Settings.create().solid().requiresTool().strength(4.0F, 6.0F).sounds(BlockSoundGroup.CHAIN).nonOpaque()), true);
    public static final Block EXPOSED_COPPER_CHAIN = register("exposed_copper_chain", new CopperChainBlock(Oxidizable.OxidationLevel.EXPOSED, AbstractBlock.Settings.create().solid().requiresTool().strength(4.0F, 6.0F).sounds(BlockSoundGroup.CHAIN).nonOpaque()), true);
    public static final Block WEATHERED_COPPER_CHAIN = register("weathered_copper_chain", new CopperChainBlock(Oxidizable.OxidationLevel.WEATHERED, AbstractBlock.Settings.create().solid().requiresTool().strength(4.0F, 6.0F).sounds(BlockSoundGroup.CHAIN).nonOpaque()), true);
    public static final Block OXIDIZED_COPPER_CHAIN = register("oxidized_copper_chain", new CopperChainBlock(Oxidizable.OxidationLevel.OXIDIZED, AbstractBlock.Settings.create().solid().requiresTool().strength(4.0F, 6.0F).sounds(BlockSoundGroup.CHAIN).nonOpaque()), true);

}
