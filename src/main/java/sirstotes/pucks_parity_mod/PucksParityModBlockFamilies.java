package sirstotes.pucks_parity_mod;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.Registries;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class PucksParityModBlockFamilies {
    private static final Map<Block, BlockFamily> BASE_BLOCKS_TO_FAMILIES = Maps.<Block, BlockFamily>newHashMap();
    public static final BlockFamily CUT_IRON = register(PucksParityModBlocks.CUT_IRON)
            .slab(PucksParityModBlocks.CUT_IRON_SLAB)
            .stairs(PucksParityModBlocks.CUT_IRON_STAIRS)
            .build();
    public static final BlockFamily CUT_GOLD = register(PucksParityModBlocks.CUT_GOLD)
            .slab(PucksParityModBlocks.CUT_GOLD_SLAB)
            .stairs(PucksParityModBlocks.CUT_GOLD_STAIRS)
            .build();

    public static BlockFamily.Builder register(Block baseBlock) {
        BlockFamily.Builder builder = new BlockFamily.Builder(baseBlock);
        BlockFamily blockFamily = (BlockFamily)BASE_BLOCKS_TO_FAMILIES.put(baseBlock, builder.build());
        if (blockFamily != null) {
            throw new IllegalStateException("Duplicate family definition for " + Registries.BLOCK.getId(baseBlock));
        } else {
            return builder;
        }
    }

    public static Stream<BlockFamily> getFamilies() {
        return BASE_BLOCKS_TO_FAMILIES.values().stream();
    }
}
