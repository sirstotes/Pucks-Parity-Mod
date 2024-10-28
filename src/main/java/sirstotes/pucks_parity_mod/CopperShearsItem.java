package sirstotes.pucks_parity_mod;

import java.util.List;

import net.minecraft.block.Blocks;
import net.minecraft.component.type.ToolComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ShearsItem;
import net.minecraft.registry.tag.BlockTags;

public class CopperShearsItem extends ShearsItem {
	public CopperShearsItem(Item.Settings settings) {
		super(settings);
	}

	public static ToolComponent createToolComponent() {
		return new ToolComponent(
			List.of(
				ToolComponent.Rule.ofAlwaysDropping(List.of(Blocks.COBWEB), 10.0F),
				ToolComponent.Rule.of(BlockTags.LEAVES, 10.0F),
				ToolComponent.Rule.of(BlockTags.WOOL, 2.0F),
				ToolComponent.Rule.of(List.of(Blocks.VINE, Blocks.GLOW_LICHEN), 1.0F)
			),
			0.75F,
			1
		);
	}
}
