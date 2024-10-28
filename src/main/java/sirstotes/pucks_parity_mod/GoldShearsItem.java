package sirstotes.pucks_parity_mod;

import net.minecraft.block.Blocks;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ShearsItem;
import net.minecraft.registry.tag.BlockTags;

import java.util.List;

public class GoldShearsItem extends ShearsItem {
    public GoldShearsItem(Item.Settings settings) {
        super(settings);
    }

    public static ToolComponent createToolComponent() {
        return new ToolComponent(
                List.of(
                        ToolComponent.Rule.ofAlwaysDropping(List.of(Blocks.COBWEB), 20.0F),
                        ToolComponent.Rule.of(BlockTags.LEAVES, 20.0F),
                        ToolComponent.Rule.of(BlockTags.WOOL, 10.0F),
                        ToolComponent.Rule.of(List.of(Blocks.VINE, Blocks.GLOW_LICHEN), 5.0F)
                ),
                1.5F,
                1
        );
    }
}
