package sirstotes.pucks_parity_mod;

import com.google.common.collect.Maps;
import net.minecraft.block.Block;
//import net.minecraft.block.Blocks;
import net.minecraft.block.Blocks;
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

    public static final BlockFamily POLISHED_STONE = register(PucksParityModBlocks.POLISHED_STONE)
            .slab(PucksParityModBlocks.POLISHED_STONE_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_STONE_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_STONE_WALL)
            .build();
    public static final BlockFamily STONE_TILES = register(PucksParityModBlocks.STONE_TILES)
            .slab(PucksParityModBlocks.STONE_TILE_SLAB)
            .stairs(PucksParityModBlocks.STONE_TILE_STAIRS)
            .wall(PucksParityModBlocks.STONE_TILE_WALL)
            .build();
    public static final BlockFamily COBBLED_TUFF = register(PucksParityModBlocks.COBBLED_TUFF)
            .slab(PucksParityModBlocks.COBBLED_TUFF_SLAB)
            .stairs(PucksParityModBlocks.COBBLED_TUFF_STAIRS)
            .wall(PucksParityModBlocks.COBBLED_TUFF_WALL)
            .build();
    public static final BlockFamily MOSSY_COBBLED_TUFF = register(PucksParityModBlocks.MOSSY_COBBLED_TUFF)
            .slab(PucksParityModBlocks.MOSSY_COBBLED_TUFF_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_COBBLED_TUFF_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_COBBLED_TUFF_WALL)
            .build();
    public static final BlockFamily MOSSY_TUFF_BRICKS = register(PucksParityModBlocks.MOSSY_TUFF_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_TUFF_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_TUFF_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_TUFF_BRICK_WALL)
            .build();
    public static final BlockFamily TUFF_TILES = register(PucksParityModBlocks.TUFF_TILES)
            .slab(PucksParityModBlocks.TUFF_TILE_SLAB)
            .stairs(PucksParityModBlocks.TUFF_TILE_STAIRS)
            .wall(PucksParityModBlocks.TUFF_TILE_WALL)
            .build();
    public static final BlockFamily MOSSY_COBBLED_DEEPSLATE = register(PucksParityModBlocks.MOSSY_COBBLED_DEEPSLATE)
            .slab(PucksParityModBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_COBBLED_DEEPSLATE_WALL)
            .build();
    public static final BlockFamily SCULKY_COBBLED_DEEPSLATE = register(PucksParityModBlocks.SCULKY_COBBLED_DEEPSLATE)
            .slab(PucksParityModBlocks.SCULKY_COBBLED_DEEPSLATE_SLAB)
            .stairs(PucksParityModBlocks.SCULKY_COBBLED_DEEPSLATE_STAIRS)
            .wall(PucksParityModBlocks.SCULKY_COBBLED_DEEPSLATE_WALL)
            .build();
    public static final BlockFamily MOSSY_DEEPSLATE_BRICKS = register(PucksParityModBlocks.MOSSY_DEEPSLATE_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_DEEPSLATE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_DEEPSLATE_BRICK_WALL)
            .build();
    public static final BlockFamily SCULKY_DEEPSLATE_BRICKS = register(PucksParityModBlocks.SCULKY_DEEPSLATE_BRICKS)
            .slab(PucksParityModBlocks.SCULKY_DEEPSLATE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.SCULKY_DEEPSLATE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.SCULKY_DEEPSLATE_BRICK_WALL)
            .build();
    public static final BlockFamily COBBLED_GRANITE = register(PucksParityModBlocks.COBBLED_GRANITE)
            .slab(PucksParityModBlocks.COBBLED_GRANITE_SLAB)
            .stairs(PucksParityModBlocks.COBBLED_GRANITE_STAIRS)
            .wall(PucksParityModBlocks.COBBLED_GRANITE_WALL)
            .build();
    public static final BlockFamily MOSSY_COBBLED_GRANITE = register(PucksParityModBlocks.MOSSY_COBBLED_GRANITE)
            .slab(PucksParityModBlocks.MOSSY_COBBLED_GRANITE_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_COBBLED_GRANITE_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_COBBLED_GRANITE_WALL)
            .build();
    public static final BlockFamily GRANITE_BRICKS = register(PucksParityModBlocks.GRANITE_BRICKS)
            .slab(PucksParityModBlocks.GRANITE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.GRANITE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.GRANITE_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_GRANITE_BRICKS = register(PucksParityModBlocks.MOSSY_GRANITE_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_GRANITE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_GRANITE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_GRANITE_BRICK_WALL)
            .build();
    public static final BlockFamily GRANITE_TILES = register(PucksParityModBlocks.GRANITE_TILES)
            .slab(PucksParityModBlocks.GRANITE_TILE_SLAB)
            .stairs(PucksParityModBlocks.GRANITE_TILE_STAIRS)
            .wall(PucksParityModBlocks.GRANITE_TILE_WALL)
            .build();
    public static final BlockFamily COBBLED_ANDESITE = register(PucksParityModBlocks.COBBLED_ANDESITE)
            .slab(PucksParityModBlocks.COBBLED_ANDESITE_SLAB)
            .stairs(PucksParityModBlocks.COBBLED_ANDESITE_STAIRS)
            .wall(PucksParityModBlocks.COBBLED_ANDESITE_WALL)
            .build();
    public static final BlockFamily MOSSY_COBBLED_ANDESITE = register(PucksParityModBlocks.MOSSY_COBBLED_ANDESITE)
            .slab(PucksParityModBlocks.MOSSY_COBBLED_ANDESITE_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_COBBLED_ANDESITE_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_COBBLED_ANDESITE_WALL)
            .build();
    public static final BlockFamily ANDESITE_BRICKS = register(PucksParityModBlocks.ANDESITE_BRICKS)
            .slab(PucksParityModBlocks.ANDESITE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.ANDESITE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.ANDESITE_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_ANDESITE_BRICKS = register(PucksParityModBlocks.MOSSY_ANDESITE_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_ANDESITE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_ANDESITE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_ANDESITE_BRICK_WALL)
            .build();
    public static final BlockFamily ANDESITE_TILES = register(PucksParityModBlocks.ANDESITE_TILES)
            .slab(PucksParityModBlocks.ANDESITE_TILE_SLAB)
            .stairs(PucksParityModBlocks.ANDESITE_TILE_STAIRS)
            .wall(PucksParityModBlocks.ANDESITE_TILE_WALL)
            .build();
    public static final BlockFamily COBBLED_DIORITE = register(PucksParityModBlocks.COBBLED_DIORITE)
            .slab(PucksParityModBlocks.COBBLED_DIORITE_SLAB)
            .stairs(PucksParityModBlocks.COBBLED_DIORITE_STAIRS)
            .wall(PucksParityModBlocks.COBBLED_DIORITE_WALL)
            .build();
    public static final BlockFamily MOSSY_COBBLED_DIORITE = register(PucksParityModBlocks.MOSSY_COBBLED_DIORITE)
            .slab(PucksParityModBlocks.MOSSY_COBBLED_DIORITE_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_COBBLED_DIORITE_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_COBBLED_DIORITE_WALL)
            .build();
    public static final BlockFamily DIORITE_BRICKS = register(PucksParityModBlocks.DIORITE_BRICKS)
            .slab(PucksParityModBlocks.DIORITE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.DIORITE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.DIORITE_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_DIORITE_BRICKS = register(PucksParityModBlocks.MOSSY_DIORITE_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_DIORITE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_DIORITE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_DIORITE_BRICK_WALL)
            .build();
    public static final BlockFamily DIORITE_TILES = register(PucksParityModBlocks.DIORITE_TILES)
            .slab(PucksParityModBlocks.DIORITE_TILE_SLAB)
            .stairs(PucksParityModBlocks.DIORITE_TILE_STAIRS)
            .wall(PucksParityModBlocks.DIORITE_TILE_WALL)
            .build();
    public static final BlockFamily COBBLED_BLACKSTONE = register(PucksParityModBlocks.COBBLED_BLACKSTONE)
            .slab(PucksParityModBlocks.COBBLED_BLACKSTONE_SLAB)
            .stairs(PucksParityModBlocks.COBBLED_BLACKSTONE_STAIRS)
            .wall(PucksParityModBlocks.COBBLED_BLACKSTONE_WALL)
            .build();
    public static final BlockFamily CRIMSON_COBBLED_BLACKSTONE = register(PucksParityModBlocks.CRIMSON_COBBLED_BLACKSTONE)
            .slab(PucksParityModBlocks.CRIMSON_COBBLED_BLACKSTONE_SLAB)
            .stairs(PucksParityModBlocks.CRIMSON_COBBLED_BLACKSTONE_STAIRS)
            .wall(PucksParityModBlocks.CRIMSON_COBBLED_BLACKSTONE_WALL)
            .build();
    public static final BlockFamily CRIMSON_BLACKSTONE_BRICKS = register(PucksParityModBlocks.CRIMSON_BLACKSTONE_BRICKS)
            .slab(PucksParityModBlocks.CRIMSON_BLACKSTONE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.CRIMSON_BLACKSTONE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.CRIMSON_BLACKSTONE_BRICK_WALL)
            .build();
    public static final BlockFamily WARPED_COBBLED_BLACKSTONE = register(PucksParityModBlocks.WARPED_COBBLED_BLACKSTONE)
            .slab(PucksParityModBlocks.WARPED_COBBLED_BLACKSTONE_SLAB)
            .stairs(PucksParityModBlocks.WARPED_COBBLED_BLACKSTONE_STAIRS)
            .wall(PucksParityModBlocks.WARPED_COBBLED_BLACKSTONE_WALL)
            .build();
    public static final BlockFamily WARPED_BLACKSTONE_BRICKS = register(PucksParityModBlocks.WARPED_BLACKSTONE_BRICKS)
            .slab(PucksParityModBlocks.WARPED_BLACKSTONE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.WARPED_BLACKSTONE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.WARPED_BLACKSTONE_BRICK_WALL)
            .build();
    public static final BlockFamily BLACKSTONE_TILES = register(PucksParityModBlocks.BLACKSTONE_TILES)
            .slab(PucksParityModBlocks.BLACKSTONE_TILE_SLAB)
            .stairs(PucksParityModBlocks.BLACKSTONE_TILE_STAIRS)
            .wall(PucksParityModBlocks.BLACKSTONE_TILE_WALL)
            .build();
    public static final BlockFamily COBBLED_END_STONE = register(PucksParityModBlocks.COBBLED_END_STONE)
            .slab(PucksParityModBlocks.COBBLED_END_STONE_SLAB)
            .stairs(PucksParityModBlocks.COBBLED_END_STONE_STAIRS)
            .wall(PucksParityModBlocks.COBBLED_END_STONE_WALL)
            .build();
    public static final BlockFamily MOLDY_COBBLED_END_STONE = register(PucksParityModBlocks.MOLDY_COBBLED_END_STONE)
            .slab(PucksParityModBlocks.MOLDY_COBBLED_END_STONE_SLAB)
            .stairs(PucksParityModBlocks.MOLDY_COBBLED_END_STONE_STAIRS)
            .wall(PucksParityModBlocks.MOLDY_COBBLED_END_STONE_WALL)
            .build();
//    public static final BlockFamily END_STONE = register(Blocks.END_STONE)
//            .slab(PucksParityModBlocks.END_STONE_SLAB)
//            .stairs(PucksParityModBlocks.END_STONE_STAIRS)
//            .wall(PucksParityModBlocks.END_STONE_WALL)
//            .build();
    public static final BlockFamily MOLDY_END_STONE_BRICKS = register(PucksParityModBlocks.MOLDY_END_STONE_BRICKS)
            .slab(PucksParityModBlocks.MOLDY_END_STONE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOLDY_END_STONE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOLDY_END_STONE_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_END_STONE = register(PucksParityModBlocks.POLISHED_END_STONE)
            .slab(PucksParityModBlocks.POLISHED_END_STONE_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_END_STONE_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_END_STONE_WALL)
            .build();
    public static final BlockFamily END_STONE_TILES = register(PucksParityModBlocks.END_STONE_TILES)
            .slab(PucksParityModBlocks.END_STONE_TILE_SLAB)
            .stairs(PucksParityModBlocks.END_STONE_TILE_STAIRS)
            .wall(PucksParityModBlocks.END_STONE_TILE_WALL)
            .build();
    public static final BlockFamily PURPUR = register(PucksParityModBlocks.PURPUR)
        .slab(PucksParityModBlocks.PURPUR_SLAB)
        .stairs(PucksParityModBlocks.PURPUR_STAIRS)
        .wall(PucksParityModBlocks.PURPUR_WALL)
        .build();
//    public static final BlockFamily PURPUR_BRICKS = register(PucksParityModBlocks.PURPUR_BRICKS)
//            .slab(PucksParityModBlocks.PURPUR_BRICK_SLAB)
//            .stairs(PucksParityModBlocks.PURPUR_BRICK_STAIRS)
//            .wall(PucksParityModBlocks.PURPUR_BRICK_WALL)
//            .build();
//    public static final BlockFamily MOLDY_PURPUR_BRICKS = register(PucksParityModBlocks.MOLDY_PURPUR_BRICKS)
//            .slab(PucksParityModBlocks.MOLDY_PURPUR_BRICK_SLAB)
//            .stairs(PucksParityModBlocks.MOLDY_PURPUR_BRICK_STAIRS)
//            .wall(PucksParityModBlocks.MOLDY_PURPUR_BRICK_WALL)
//            .build();
    public static final BlockFamily POLISHED_PURPUR = register(PucksParityModBlocks.POLISHED_PURPUR)
            .slab(PucksParityModBlocks.POLISHED_PURPUR_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_PURPUR_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_PURPUR_WALL)
            .build();
//    public static final BlockFamily MOSSY_COBBLED_SANDSTONE = register(PucksParityModBlocks.MOSSY_SANDSTONE)
//            .slab(PucksParityModBlocks.MOSSY_SANDSTONE_SLAB)
//            .stairs(PucksParityModBlocks.MOSSY_SANDSTONE_STAIRS)
//            .wall(PucksParityModBlocks.MOSSY_SANDSTONE_WALL)
//            .build();
//    public static final BlockFamily SMOOTH_SANDSTONE = register(Blocks.SMOOTH_SANDSTONE)
//            .wall(PucksParityModBlocks.SMOOTH_SANDSTONE_WALL)
//            .build();
    public static final BlockFamily SANDSTONE_BRICKS = register(PucksParityModBlocks.SANDSTONE_BRICKS)
            .slab(PucksParityModBlocks.SANDSTONE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.SANDSTONE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.SANDSTONE_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_SANDSTONE_BRICKS = register(PucksParityModBlocks.MOSSY_SANDSTONE_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_SANDSTONE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_SANDSTONE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_SANDSTONE_BRICK_WALL)
            .build();
    public static final BlockFamily SANDSTONE_TILES = register(PucksParityModBlocks.SANDSTONE_TILES)
            .slab(PucksParityModBlocks.SANDSTONE_TILE_SLAB)
            .stairs(PucksParityModBlocks.SANDSTONE_TILE_STAIRS)
            .wall(PucksParityModBlocks.SANDSTONE_TILE_WALL)
            .build();
//    public static final BlockFamily MOSSY_COBBLED_RED_SANDSTONE = register(PucksParityModBlocks.MOSSY_RED_SANDSTONE)
//            .slab(PucksParityModBlocks.MOSSY_RED_SANDSTONE_SLAB)
//            .stairs(PucksParityModBlocks.MOSSY_RED_SANDSTONE_STAIRS)
//            .wall(PucksParityModBlocks.MOSSY_RED_SANDSTONE_WALL)
//            .build();
//    public static final BlockFamily SMOOTH_RED_SANDSTONE = register(Blocks.SMOOTH_RED_SANDSTONE)
//            .wall(PucksParityModBlocks.SMOOTH_RED_SANDSTONE_WALL)
//            .build();
    public static final BlockFamily RED_SANDSTONE_BRICKS = register(PucksParityModBlocks.RED_SANDSTONE_BRICKS)
            .slab(PucksParityModBlocks.RED_SANDSTONE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.RED_SANDSTONE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.RED_SANDSTONE_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_RED_SANDSTONE_BRICKS = register(PucksParityModBlocks.MOSSY_RED_SANDSTONE_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_RED_SANDSTONE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_RED_SANDSTONE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_RED_SANDSTONE_BRICK_WALL)
            .build();
    public static final BlockFamily RED_SANDSTONE_TILES = register(PucksParityModBlocks.RED_SANDSTONE_TILES)
            .slab(PucksParityModBlocks.RED_SANDSTONE_TILE_SLAB)
            .stairs(PucksParityModBlocks.RED_SANDSTONE_TILE_STAIRS)
            .wall(PucksParityModBlocks.RED_SANDSTONE_TILE_WALL)
            .build();
    public static final BlockFamily BARNACLED_COBBLED_PRISMARINE = register(PucksParityModBlocks.BARNACLED_PRISMARINE)
            .slab(PucksParityModBlocks.BARNACLED_PRISMARINE_SLAB)
            .stairs(PucksParityModBlocks.BARNACLED_PRISMARINE_STAIRS)
            .wall(PucksParityModBlocks.BARNACLED_PRISMARINE_WALL)
            .build();
    public static final BlockFamily SMOOTH_PRISMARINE = register(PucksParityModBlocks.SMOOTH_PRISMARINE)
            .slab(PucksParityModBlocks.SMOOTH_PRISMARINE_SLAB)
            .stairs(PucksParityModBlocks.SMOOTH_PRISMARINE_STAIRS)
            .wall(PucksParityModBlocks.SMOOTH_PRISMARINE_WALL)
            .build();
//    public static final BlockFamily PRISMARINE_BRICKS = register(Blocks.PRISMARINE_BRICKS)
//            .wall(PucksParityModBlocks.PRISMARINE_BRICK_WALL)
//            .build();
    public static final BlockFamily BARNACLED_PRISMARINE_BRICKS = register(PucksParityModBlocks.BARNACLED_PRISMARINE_BRICKS)
            .slab(PucksParityModBlocks.BARNACLED_PRISMARINE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.BARNACLED_PRISMARINE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.BARNACLED_PRISMARINE_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_PRISMARINE = register(PucksParityModBlocks.POLISHED_PRISMARINE)
            .slab(PucksParityModBlocks.POLISHED_PRISMARINE_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_PRISMARINE_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_PRISMARINE_WALL)
            .build();
    public static final BlockFamily PRISMARINE_TILES = register(PucksParityModBlocks.PRISMARINE_TILES)
            .slab(PucksParityModBlocks.PRISMARINE_TILE_SLAB)
            .stairs(PucksParityModBlocks.PRISMARINE_TILE_STAIRS)
            .wall(PucksParityModBlocks.PRISMARINE_TILE_WALL)
            .build();
    public static final BlockFamily DARK_PRISMARINE = register(PucksParityModBlocks.DARK_PRISMARINE)
            .slab(PucksParityModBlocks.DARK_PRISMARINE_SLAB)
            .stairs(PucksParityModBlocks.DARK_PRISMARINE_STAIRS)
            .wall(PucksParityModBlocks.DARK_PRISMARINE_WALL)
            .build();
    public static final BlockFamily BARNACLED_DARK_PRISMARINE = register(PucksParityModBlocks.BARNACLED_DARK_PRISMARINE)
            .slab(PucksParityModBlocks.BARNACLED_DARK_PRISMARINE_SLAB)
            .stairs(PucksParityModBlocks.BARNACLED_DARK_PRISMARINE_STAIRS)
            .wall(PucksParityModBlocks.BARNACLED_DARK_PRISMARINE_WALL)
            .build();
    public static final BlockFamily SMOOTH_DARK_PRISMARINE = register(PucksParityModBlocks.SMOOTH_DARK_PRISMARINE)
            .slab(PucksParityModBlocks.SMOOTH_DARK_PRISMARINE_SLAB)
            .stairs(PucksParityModBlocks.SMOOTH_DARK_PRISMARINE_STAIRS)
            .wall(PucksParityModBlocks.SMOOTH_DARK_PRISMARINE_WALL)
            .build();
    public static final BlockFamily DARK_PRISMARINE_BRICKS = register(PucksParityModBlocks.DARK_PRISMARINE_BRICKS)
            .slab(PucksParityModBlocks.DARK_PRISMARINE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.DARK_PRISMARINE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.DARK_PRISMARINE_BRICK_WALL)
            .build();
    public static final BlockFamily BARNACLED_DARK_PRISMARINE_BRICKS = register(PucksParityModBlocks.BARNACLED_DARK_PRISMARINE_BRICKS)
            .slab(PucksParityModBlocks.BARNACLED_DARK_PRISMARINE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.BARNACLED_DARK_PRISMARINE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.BARNACLED_DARK_PRISMARINE_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_DARK_PRISMARINE = register(PucksParityModBlocks.POLISHED_DARK_PRISMARINE)
            .slab(PucksParityModBlocks.POLISHED_DARK_PRISMARINE_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_DARK_PRISMARINE_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_DARK_PRISMARINE_WALL)
            .build();
//    public static final BlockFamily DARK_PRISMARINE_TILES = register(Blocks.DARK_PRISMARINE)
//            .wall(PucksParityModBlocks.DARK_PRISMARINE_TILE_WALL)
//            .build();
//    public static final BlockFamily NETHERRACK = register(Blocks.NETHERRACK)
//            .slab(PucksParityModBlocks.NETHERRACK_SLAB)
//            .stairs(PucksParityModBlocks.NETHERRACK_STAIRS)
//            .wall(PucksParityModBlocks.NETHERRACK_WALL)
//            .build();
    public static final BlockFamily CRIMSON_NETHERRACK = register(PucksParityModBlocks.CRIMSON_NETHERRACK)
            .slab(PucksParityModBlocks.CRIMSON_NETHERRACK_SLAB)
            .stairs(PucksParityModBlocks.CRIMSON_NETHERRACK_STAIRS)
            .wall(PucksParityModBlocks.CRIMSON_NETHERRACK_WALL)
            .build();
    public static final BlockFamily WARPED_NETHERRACK = register(PucksParityModBlocks.WARPED_NETHERRACK)
            .slab(PucksParityModBlocks.WARPED_NETHERRACK_SLAB)
            .stairs(PucksParityModBlocks.WARPED_NETHERRACK_STAIRS)
            .wall(PucksParityModBlocks.WARPED_NETHERRACK_WALL)
            .build();
    public static final BlockFamily HARDENED_NETHERRACK = register(PucksParityModBlocks.HARDENED_NETHERRACK)
            .slab(PucksParityModBlocks.HARDENED_NETHERRACK_SLAB)
            .stairs(PucksParityModBlocks.HARDENED_NETHERRACK_STAIRS)
            .wall(PucksParityModBlocks.HARDENED_NETHERRACK_WALL)
            .build();
//    public static final BlockFamily NETHER_BRICKS = register(Blocks.NETHER_BRICKS)
//            .wall(PucksParityModBlocks.NETHER_BRICK_WALL)
//            .build();
    public static final BlockFamily CRIMSON_NETHER_BRICKS = register(PucksParityModBlocks.CRIMSON_NETHER_BRICKS)
            .slab(PucksParityModBlocks.CRIMSON_NETHER_BRICK_SLAB)
            .stairs(PucksParityModBlocks.CRIMSON_NETHER_BRICK_STAIRS)
            .wall(PucksParityModBlocks.CRIMSON_NETHER_BRICK_WALL)
            .build();
    public static final BlockFamily WARPED_NETHER_BRICKS = register(PucksParityModBlocks.WARPED_NETHER_BRICKS)
            .slab(PucksParityModBlocks.WARPED_NETHER_BRICK_SLAB)
            .stairs(PucksParityModBlocks.WARPED_NETHER_BRICK_STAIRS)
            .wall(PucksParityModBlocks.WARPED_NETHER_BRICK_WALL)
            .build();
    public static final BlockFamily WARPED_RED_NETHER_BRICKS = register(PucksParityModBlocks.WARPED_RED_NETHER_BRICKS)
            .slab(PucksParityModBlocks.WARPED_RED_NETHER_BRICK_SLAB)
            .stairs(PucksParityModBlocks.WARPED_RED_NETHER_BRICK_STAIRS)
            .wall(PucksParityModBlocks.WARPED_RED_NETHER_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_HARDENED_NETHERRACK = register(PucksParityModBlocks.POLISHED_HARDENED_NETHERRACK)
            .slab(PucksParityModBlocks.POLISHED_HARDENED_NETHERRACK_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_HARDENED_NETHERRACK_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_HARDENED_NETHERRACK_WALL)
            .build();
    public static final BlockFamily NETHER_TILES = register(PucksParityModBlocks.NETHER_TILES)
            .slab(PucksParityModBlocks.NETHER_TILE_SLAB)
            .stairs(PucksParityModBlocks.NETHER_TILE_STAIRS)
            .wall(PucksParityModBlocks.NETHER_TILE_WALL)
            .build();
    public static final BlockFamily COBBLED_BASALT = register(PucksParityModBlocks.COBBLED_BASALT)
            .slab(PucksParityModBlocks.COBBLED_BASALT_SLAB)
            .stairs(PucksParityModBlocks.COBBLED_BASALT_STAIRS)
            .wall(PucksParityModBlocks.COBBLED_BASALT_WALL)
            .build();
    public static final BlockFamily CRIMSON_COBBLED_BASALT = register(PucksParityModBlocks.CRIMSON_COBBLED_BASALT)
            .slab(PucksParityModBlocks.CRIMSON_COBBLED_BASALT_SLAB)
            .stairs(PucksParityModBlocks.CRIMSON_COBBLED_BASALT_STAIRS)
            .wall(PucksParityModBlocks.CRIMSON_COBBLED_BASALT_WALL)
            .build();
    public static final BlockFamily WARPED_COBBLED_BASALT = register(PucksParityModBlocks.WARPED_COBBLED_BASALT)
            .slab(PucksParityModBlocks.WARPED_COBBLED_BASALT_SLAB)
            .stairs(PucksParityModBlocks.WARPED_COBBLED_BASALT_STAIRS)
            .wall(PucksParityModBlocks.WARPED_COBBLED_BASALT_WALL)
            .build();
//    public static final BlockFamily SMOOTH_BASALT = register(Blocks.SMOOTH_BASALT)
//            .slab(PucksParityModBlocks.SMOOTH_BASALT_SLAB)
//            .stairs(PucksParityModBlocks.SMOOTH_BASALT_STAIRS)
//            .wall(PucksParityModBlocks.SMOOTH_BASALT_WALL)
//            .build();
    public static final BlockFamily POLISHED_SMOOTH_BASALT = register(PucksParityModBlocks.POLISHED_BASALT)
            .slab(PucksParityModBlocks.POLISHED_BASALT_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_BASALT_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_BASALT_WALL)
            .build();
    public static final BlockFamily BASALT_BRICKS = register(PucksParityModBlocks.BASALT_BRICKS)
            .slab(PucksParityModBlocks.BASALT_BRICK_SLAB)
            .stairs(PucksParityModBlocks.BASALT_BRICK_STAIRS)
            .wall(PucksParityModBlocks.BASALT_BRICK_WALL)
            .build();
    public static final BlockFamily CRIMSON_BASALT_BRICKS = register(PucksParityModBlocks.CRIMSON_BASALT_BRICKS)
            .slab(PucksParityModBlocks.CRIMSON_BASALT_BRICK_SLAB)
            .stairs(PucksParityModBlocks.CRIMSON_BASALT_BRICK_STAIRS)
            .wall(PucksParityModBlocks.CRIMSON_BASALT_BRICK_WALL)
            .build();
    public static final BlockFamily WARPED_BASALT_BRICKS = register(PucksParityModBlocks.WARPED_BASALT_BRICKS)
            .slab(PucksParityModBlocks.WARPED_BASALT_BRICK_SLAB)
            .stairs(PucksParityModBlocks.WARPED_BASALT_BRICK_STAIRS)
            .wall(PucksParityModBlocks.WARPED_BASALT_BRICK_WALL)
            .build();
    public static final BlockFamily BASALT_TILES = register(PucksParityModBlocks.BASALT_TILES)
            .slab(PucksParityModBlocks.BASALT_TILE_SLAB)
            .stairs(PucksParityModBlocks.BASALT_TILE_STAIRS)
            .wall(PucksParityModBlocks.BASALT_TILE_WALL)
            .build();
    public static final BlockFamily COBBLED_CALCITE = register(PucksParityModBlocks.COBBLED_CALCITE)
            .slab(PucksParityModBlocks.COBBLED_CALCITE_SLAB)
            .stairs(PucksParityModBlocks.COBBLED_CALCITE_STAIRS)
            .wall(PucksParityModBlocks.COBBLED_CALCITE_WALL)
            .build();
    public static final BlockFamily MOSSY_COBBLED_CALCITE = register(PucksParityModBlocks.MOSSY_COBBLED_CALCITE)
            .slab(PucksParityModBlocks.MOSSY_COBBLED_CALCITE_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_COBBLED_CALCITE_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_COBBLED_CALCITE_WALL)
            .build();
//    public static final BlockFamily CALCITE = register(Blocks.CALCITE)
//            .slab(PucksParityModBlocks.CALCITE_SLAB)
//            .stairs(PucksParityModBlocks.CALCITE_STAIRS)
//            .wall(PucksParityModBlocks.CALCITE_WALL)
//            .build();
public static final BlockFamily POLISHED_CALCITE = register(PucksParityModBlocks.POLISHED_CALCITE)
        .slab(PucksParityModBlocks.POLISHED_CALCITE_SLAB)
        .stairs(PucksParityModBlocks.POLISHED_CALCITE_STAIRS)
        .wall(PucksParityModBlocks.POLISHED_CALCITE_WALL)
        .build();
    public static final BlockFamily CALCITE_BRICKS = register(PucksParityModBlocks.CALCITE_BRICKS)
            .slab(PucksParityModBlocks.CALCITE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.CALCITE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.CALCITE_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_CALCITE_BRICKS = register(PucksParityModBlocks.MOSSY_CALCITE_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_CALCITE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_CALCITE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_CALCITE_BRICK_WALL)
            .build();
    public static final BlockFamily CALCITE_TILES = register(PucksParityModBlocks.CALCITE_TILES)
            .slab(PucksParityModBlocks.CALCITE_TILE_SLAB)
            .stairs(PucksParityModBlocks.CALCITE_TILE_STAIRS)
            .wall(PucksParityModBlocks.CALCITE_TILE_WALL)
            .build();
    public static final BlockFamily COBBLED_DRIPSTONE = register(PucksParityModBlocks.COBBLED_DRIPSTONE)
            .slab(PucksParityModBlocks.COBBLED_DRIPSTONE_SLAB)
            .stairs(PucksParityModBlocks.COBBLED_DRIPSTONE_STAIRS)
            .wall(PucksParityModBlocks.COBBLED_DRIPSTONE_WALL)
            .build();
    public static final BlockFamily MOSSY_COBBLED_DRIPSTONE = register(PucksParityModBlocks.MOSSY_COBBLED_DRIPSTONE)
            .slab(PucksParityModBlocks.MOSSY_COBBLED_DRIPSTONE_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_COBBLED_DRIPSTONE_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_COBBLED_DRIPSTONE_WALL)
            .build();
//    public static final BlockFamily DRIPSTONE = register(Blocks.DRIPSTONE_BLOCK)
//            .slab(PucksParityModBlocks.DRIPSTONE_SLAB)
//            .stairs(PucksParityModBlocks.DRIPSTONE_STAIRS)
//            .wall(PucksParityModBlocks.DRIPSTONE_WALL)
//            .build();
    public static final BlockFamily DRIPSTONE_BRICKS = register(PucksParityModBlocks.DRIPSTONE_BRICKS)
            .slab(PucksParityModBlocks.DRIPSTONE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.DRIPSTONE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.DRIPSTONE_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_DRIPSTONE_BRICKS = register(PucksParityModBlocks.MOSSY_DRIPSTONE_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_DRIPSTONE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_DRIPSTONE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_DRIPSTONE_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_DRIPSTONE = register(PucksParityModBlocks.POLISHED_DRIPSTONE)
            .slab(PucksParityModBlocks.POLISHED_DRIPSTONE_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_DRIPSTONE_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_DRIPSTONE_WALL)
            .build();
    public static final BlockFamily DRIPSTONE_TILES = register(PucksParityModBlocks.DRIPSTONE_TILES)
            .slab(PucksParityModBlocks.DRIPSTONE_TILE_SLAB)
            .stairs(PucksParityModBlocks.DRIPSTONE_TILE_STAIRS)
            .wall(PucksParityModBlocks.DRIPSTONE_TILE_WALL)
            .build();

    public static final BlockFamily SMOOTH_STONE = register(PucksParityModBlocks.SMOOTH_STONE)
            .slab(PucksParityModBlocks.SMOOTH_STONE_SLAB)
            .stairs(PucksParityModBlocks.SMOOTH_STONE_STAIRS)
            .wall(PucksParityModBlocks.SMOOTH_STONE_WALL)
            .build();
    public static final BlockFamily SMOOTH_STONE_BRICKS = register(PucksParityModBlocks.SMOOTH_STONE_BRICKS)
            .slab(PucksParityModBlocks.SMOOTH_STONE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.SMOOTH_STONE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.SMOOTH_STONE_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_SMOOTH_STONE_BRICKS = register(PucksParityModBlocks.MOSSY_SMOOTH_STONE_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_SMOOTH_STONE_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_SMOOTH_STONE_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_SMOOTH_STONE_BRICK_WALL)
            .build();
//    public static final BlockFamily POLISHED_SMOOTH_STONE = register(Blocks.SMOOTH_STONE)
//            .slab(PucksParityModBlocks.POLISHED_SMOOTH_STONE_SLAB)
//            .stairs(PucksParityModBlocks.POLISHED_SMOOTH_STONE_STAIRS)
//            .wall(PucksParityModBlocks.POLISHED_SMOOTH_STONE_WALL)
//            .build();
    public static final BlockFamily SMOOTH_STONE_TILES = register(PucksParityModBlocks.SMOOTH_STONE_TILES)
            .slab(PucksParityModBlocks.SMOOTH_STONE_TILE_SLAB)
            .stairs(PucksParityModBlocks.SMOOTH_STONE_TILE_STAIRS)
            .wall(PucksParityModBlocks.SMOOTH_STONE_TILE_WALL)
            .build();
    
    public static final BlockFamily RED_HARDENED_NETHERRACK = register(PucksParityModBlocks.RED_HARDENED_NETHERRACK)
            .slab(PucksParityModBlocks.RED_HARDENED_NETHERRACK_SLAB)
            .stairs(PucksParityModBlocks.RED_HARDENED_NETHERRACK_STAIRS)
            .wall(PucksParityModBlocks.RED_HARDENED_NETHERRACK_WALL)
            .build();
    //    public static final BlockFamily NETHER_BRICKS = register(Blocks.NETHER_BRICKS)
//            .wall(PucksParityModBlocks.NETHER_BRICK_WALL)
//            .build();
    public static final BlockFamily CRIMSON_RED_NETHER_BRICKS = register(PucksParityModBlocks.CRIMSON_RED_NETHER_BRICKS)
            .slab(PucksParityModBlocks.CRIMSON_RED_NETHER_BRICK_SLAB)
            .stairs(PucksParityModBlocks.CRIMSON_RED_NETHER_BRICK_STAIRS)
            .wall(PucksParityModBlocks.CRIMSON_RED_NETHER_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_RED_HARDENED_NETHERRACK = register(PucksParityModBlocks.POLISHED_RED_HARDENED_NETHERRACK)
            .slab(PucksParityModBlocks.POLISHED_RED_HARDENED_NETHERRACK_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_RED_HARDENED_NETHERRACK_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_RED_HARDENED_NETHERRACK_WALL)
            .build();
    public static final BlockFamily RED_NETHER_TILES = register(PucksParityModBlocks.RED_NETHER_TILES)
            .slab(PucksParityModBlocks.RED_NETHER_TILE_SLAB)
            .stairs(PucksParityModBlocks.RED_NETHER_TILE_STAIRS)
            .wall(PucksParityModBlocks.RED_NETHER_TILE_WALL)
            .build();
//    public static final BlockFamily PACKED_MUD = register(Blocks.PACKED_MUD)
//            .slab(PucksParityModBlocks.PACKED_MUD_SLAB)
//            .stairs(PucksParityModBlocks.PACKED_MUD_STAIRS)
//            .wall(PucksParityModBlocks.PACKED_MUD_WALL)
//            .build();
    public static final BlockFamily MOSSY_MUD_BRICKS = register(PucksParityModBlocks.MOSSY_MUD_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_MUD_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_MUD_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_MUD_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_PACKED_MUD = register(PucksParityModBlocks.POLISHED_PACKED_MUD)
            .slab(PucksParityModBlocks.POLISHED_PACKED_MUD_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_PACKED_MUD_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_PACKED_MUD_WALL)
            .build();
    public static final BlockFamily MUD_TILES = register(PucksParityModBlocks.MUD_TILES)
            .slab(PucksParityModBlocks.MUD_TILE_SLAB)
            .stairs(PucksParityModBlocks.MUD_TILE_STAIRS)
            .wall(PucksParityModBlocks.MUD_TILE_WALL)
            .build();
    //?if >1.21.3 {
    /*public static final BlockFamily RESIN = register(PucksParityModBlocks.RESIN)
            .slab(PucksParityModBlocks.RESIN_SLAB)
            .stairs(PucksParityModBlocks.RESIN_STAIRS)
            .wall(PucksParityModBlocks.RESIN_WALL)
            .build();
    public static final BlockFamily MOSSY_RESIN_BRICKS = register(PucksParityModBlocks.MOSSY_RESIN_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_RESIN_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_RESIN_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_RESIN_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_RESIN = register(PucksParityModBlocks.POLISHED_RESIN)
            .slab(PucksParityModBlocks.POLISHED_RESIN_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_RESIN_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_RESIN_WALL)
            .build();
    public static final BlockFamily RESIN_TILES = register(PucksParityModBlocks.RESIN_TILES)
            .slab(PucksParityModBlocks.RESIN_TILE_SLAB)
            .stairs(PucksParityModBlocks.RESIN_TILE_STAIRS)
            .wall(PucksParityModBlocks.RESIN_TILE_WALL)
            .build();
    *///?}
    public static final BlockFamily CRIMSON_QUARTZ_BRICKS = register(PucksParityModBlocks.CRIMSON_QUARTZ_BRICKS)
            .slab(PucksParityModBlocks.CRIMSON_QUARTZ_BRICK_SLAB)
            .stairs(PucksParityModBlocks.CRIMSON_QUARTZ_BRICK_STAIRS)
            .wall(PucksParityModBlocks.CRIMSON_QUARTZ_BRICK_WALL)
            .build();
    public static final BlockFamily WARPED_QUARTZ_BRICKS = register(PucksParityModBlocks.WARPED_QUARTZ_BRICKS)
            .slab(PucksParityModBlocks.WARPED_QUARTZ_BRICK_SLAB)
            .stairs(PucksParityModBlocks.WARPED_QUARTZ_BRICK_STAIRS)
            .wall(PucksParityModBlocks.WARPED_QUARTZ_BRICK_WALL)
            .build();
    public static final BlockFamily QUARTZ_TILES = register(PucksParityModBlocks.QUARTZ_TILES)
            .slab(PucksParityModBlocks.QUARTZ_TILE_SLAB)
            .stairs(PucksParityModBlocks.QUARTZ_TILE_STAIRS)
            .wall(PucksParityModBlocks.QUARTZ_TILE_WALL)
            .build();

//    public static final BlockFamily TERRACOTTA = register(Blocks.TERRACOTTA)
//            .slab(PucksParityModBlocks.TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily MOSSY_BRICKS = register(PucksParityModBlocks.MOSSY_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_TERRACOTTA = register(PucksParityModBlocks.POLISHED_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily TERRACOTTA_TILES = register(PucksParityModBlocks.TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.TERRACOTTA_TILE_WALL)
            .build();
//    public static final BlockFamily RED_TERRACOTTA = register(Blocks.RED_TERRACOTTA)
//            .slab(PucksParityModBlocks.RED_TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.RED_TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.RED_TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily RED_TERRACOTTA_BRICKS = register(PucksParityModBlocks.RED_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.RED_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.RED_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.RED_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_RED_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MOSSY_RED_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_RED_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_RED_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_RED_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_RED_TERRACOTTA = register(PucksParityModBlocks.POLISHED_RED_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_RED_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_RED_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_RED_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily RED_TERRACOTTA_TILES = register(PucksParityModBlocks.RED_TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.RED_TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.RED_TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.RED_TERRACOTTA_TILE_WALL)
            .build();
//    public static final BlockFamily ORANGE_TERRACOTTA = register(Blocks.ORANGE_TERRACOTTA)
//            .slab(PucksParityModBlocks.ORANGE_TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.ORANGE_TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.ORANGE_TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily ORANGE_TERRACOTTA_BRICKS = register(PucksParityModBlocks.ORANGE_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.ORANGE_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.ORANGE_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.ORANGE_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_ORANGE_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MOSSY_ORANGE_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_ORANGE_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_ORANGE_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_ORANGE_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_ORANGE_TERRACOTTA = register(PucksParityModBlocks.POLISHED_ORANGE_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_ORANGE_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_ORANGE_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_ORANGE_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily ORANGE_TERRACOTTA_TILES = register(PucksParityModBlocks.ORANGE_TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.ORANGE_TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.ORANGE_TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.ORANGE_TERRACOTTA_TILE_WALL)
            .build();
//    public static final BlockFamily YELLOW_TERRACOTTA = register(Blocks.YELLOW_TERRACOTTA)
//            .slab(PucksParityModBlocks.YELLOW_TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.YELLOW_TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.YELLOW_TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily YELLOW_TERRACOTTA_BRICKS = register(PucksParityModBlocks.YELLOW_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.YELLOW_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.YELLOW_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.YELLOW_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_YELLOW_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MOSSY_YELLOW_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_YELLOW_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_YELLOW_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_YELLOW_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_YELLOW_TERRACOTTA = register(PucksParityModBlocks.POLISHED_YELLOW_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_YELLOW_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_YELLOW_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_YELLOW_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily YELLOW_TERRACOTTA_TILES = register(PucksParityModBlocks.YELLOW_TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.YELLOW_TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.YELLOW_TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.YELLOW_TERRACOTTA_TILE_WALL)
            .build();
//    public static final BlockFamily LIME_TERRACOTTA = register(Blocks.LIME_TERRACOTTA)
//            .slab(PucksParityModBlocks.LIME_TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.LIME_TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.LIME_TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily LIME_TERRACOTTA_BRICKS = register(PucksParityModBlocks.LIME_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.LIME_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.LIME_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.LIME_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_LIME_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MOSSY_LIME_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_LIME_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_LIME_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_LIME_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_LIME_TERRACOTTA = register(PucksParityModBlocks.POLISHED_LIME_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_LIME_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_LIME_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_LIME_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily LIME_TERRACOTTA_TILES = register(PucksParityModBlocks.LIME_TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.LIME_TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.LIME_TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.LIME_TERRACOTTA_TILE_WALL)
            .build();
//    public static final BlockFamily GREEN_TERRACOTTA = register(Blocks.GREEN_TERRACOTTA)
//            .slab(PucksParityModBlocks.GREEN_TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.GREEN_TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.GREEN_TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily GREEN_TERRACOTTA_BRICKS = register(PucksParityModBlocks.GREEN_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.GREEN_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.GREEN_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.GREEN_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_GREEN_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MOSSY_GREEN_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_GREEN_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_GREEN_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_GREEN_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_GREEN_TERRACOTTA = register(PucksParityModBlocks.POLISHED_GREEN_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_GREEN_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_GREEN_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_GREEN_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily GREEN_TERRACOTTA_TILES = register(PucksParityModBlocks.GREEN_TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.GREEN_TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.GREEN_TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.GREEN_TERRACOTTA_TILE_WALL)
            .build();
//    public static final BlockFamily CYAN_TERRACOTTA = register(Blocks.CYAN_TERRACOTTA)
//            .slab(PucksParityModBlocks.CYAN_TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.CYAN_TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.CYAN_TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily CYAN_TERRACOTTA_BRICKS = register(PucksParityModBlocks.CYAN_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.CYAN_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.CYAN_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.CYAN_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_CYAN_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MOSSY_CYAN_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_CYAN_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_CYAN_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_CYAN_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_CYAN_TERRACOTTA = register(PucksParityModBlocks.POLISHED_CYAN_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_CYAN_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_CYAN_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_CYAN_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily CYAN_TERRACOTTA_TILES = register(PucksParityModBlocks.CYAN_TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.CYAN_TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.CYAN_TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.CYAN_TERRACOTTA_TILE_WALL)
            .build();
//    public static final BlockFamily LIGHT_BLUE_TERRACOTTA = register(Blocks.LIGHT_BLUE_TERRACOTTA)
//            .slab(PucksParityModBlocks.LIGHT_BLUE_TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.LIGHT_BLUE_TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.LIGHT_BLUE_TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily LIGHT_BLUE_TERRACOTTA_BRICKS = register(PucksParityModBlocks.LIGHT_BLUE_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.LIGHT_BLUE_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_LIGHT_BLUE_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MOSSY_LIGHT_BLUE_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_LIGHT_BLUE_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_LIGHT_BLUE_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_LIGHT_BLUE_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_LIGHT_BLUE_TERRACOTTA = register(PucksParityModBlocks.POLISHED_LIGHT_BLUE_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_LIGHT_BLUE_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_LIGHT_BLUE_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_LIGHT_BLUE_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily LIGHT_BLUE_TERRACOTTA_TILES = register(PucksParityModBlocks.LIGHT_BLUE_TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.LIGHT_BLUE_TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.LIGHT_BLUE_TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.LIGHT_BLUE_TERRACOTTA_TILE_WALL)
            .build();
//    public static final BlockFamily BLUE_TERRACOTTA = register(Blocks.BLUE_TERRACOTTA)
//            .slab(PucksParityModBlocks.BLUE_TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.BLUE_TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.BLUE_TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily BLUE_TERRACOTTA_BRICKS = register(PucksParityModBlocks.BLUE_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.BLUE_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.BLUE_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.BLUE_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_BLUE_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MOSSY_BLUE_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_BLUE_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_BLUE_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_BLUE_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_BLUE_TERRACOTTA = register(PucksParityModBlocks.POLISHED_BLUE_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_BLUE_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_BLUE_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_BLUE_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily BLUE_TERRACOTTA_TILES = register(PucksParityModBlocks.BLUE_TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.BLUE_TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.BLUE_TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.BLUE_TERRACOTTA_TILE_WALL)
            .build();
//    public static final BlockFamily PURPLE_TERRACOTTA = register(Blocks.PURPLE_TERRACOTTA)
//            .slab(PucksParityModBlocks.PURPLE_TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.PURPLE_TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.PURPLE_TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily PURPLE_TERRACOTTA_BRICKS = register(PucksParityModBlocks.PURPLE_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.PURPLE_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.PURPLE_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.PURPLE_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_PURPLE_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MOSSY_PURPLE_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_PURPLE_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_PURPLE_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_PURPLE_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_PURPLE_TERRACOTTA = register(PucksParityModBlocks.POLISHED_PURPLE_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_PURPLE_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_PURPLE_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_PURPLE_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily PURPLE_TERRACOTTA_TILES = register(PucksParityModBlocks.PURPLE_TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.PURPLE_TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.PURPLE_TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.PURPLE_TERRACOTTA_TILE_WALL)
            .build();
//    public static final BlockFamily MAGENTA_TERRACOTTA = register(Blocks.MAGENTA_TERRACOTTA)
//            .slab(PucksParityModBlocks.MAGENTA_TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.MAGENTA_TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.MAGENTA_TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily MAGENTA_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MAGENTA_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MAGENTA_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MAGENTA_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MAGENTA_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_MAGENTA_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MOSSY_MAGENTA_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_MAGENTA_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_MAGENTA_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_MAGENTA_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_MAGENTA_TERRACOTTA = register(PucksParityModBlocks.POLISHED_MAGENTA_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_MAGENTA_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_MAGENTA_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_MAGENTA_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily MAGENTA_TERRACOTTA_TILES = register(PucksParityModBlocks.MAGENTA_TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.MAGENTA_TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.MAGENTA_TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.MAGENTA_TERRACOTTA_TILE_WALL)
            .build();
//    public static final BlockFamily PINK_TERRACOTTA = register(Blocks.PINK_TERRACOTTA)
//            .slab(PucksParityModBlocks.PINK_TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.PINK_TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.PINK_TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily PINK_TERRACOTTA_BRICKS = register(PucksParityModBlocks.PINK_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.PINK_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.PINK_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.PINK_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_PINK_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MOSSY_PINK_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_PINK_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_PINK_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_PINK_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_PINK_TERRACOTTA = register(PucksParityModBlocks.POLISHED_PINK_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_PINK_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_PINK_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_PINK_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily PINK_TERRACOTTA_TILES = register(PucksParityModBlocks.PINK_TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.PINK_TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.PINK_TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.PINK_TERRACOTTA_TILE_WALL)
            .build();
//    public static final BlockFamily BROWN_TERRACOTTA = register(Blocks.BROWN_TERRACOTTA)
//            .slab(PucksParityModBlocks.BROWN_TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.BROWN_TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.BROWN_TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily BROWN_TERRACOTTA_BRICKS = register(PucksParityModBlocks.BROWN_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.BROWN_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.BROWN_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.BROWN_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_BROWN_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MOSSY_BROWN_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_BROWN_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_BROWN_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_BROWN_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_BROWN_TERRACOTTA = register(PucksParityModBlocks.POLISHED_BROWN_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_BROWN_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_BROWN_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_BROWN_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily BROWN_TERRACOTTA_TILES = register(PucksParityModBlocks.BROWN_TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.BROWN_TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.BROWN_TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.BROWN_TERRACOTTA_TILE_WALL)
            .build();
//    public static final BlockFamily WHITE_TERRACOTTA = register(Blocks.WHITE_TERRACOTTA)
//            .slab(PucksParityModBlocks.WHITE_TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.WHITE_TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.WHITE_TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily WHITE_TERRACOTTA_BRICKS = register(PucksParityModBlocks.WHITE_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.WHITE_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.WHITE_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.WHITE_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_WHITE_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MOSSY_WHITE_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_WHITE_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_WHITE_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_WHITE_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_WHITE_TERRACOTTA = register(PucksParityModBlocks.POLISHED_WHITE_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_WHITE_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_WHITE_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_WHITE_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily WHITE_TERRACOTTA_TILES = register(PucksParityModBlocks.WHITE_TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.WHITE_TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.WHITE_TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.WHITE_TERRACOTTA_TILE_WALL)
            .build();
//    public static final BlockFamily LIGHT_GRAY_TERRACOTTA = register(Blocks.LIGHT_GRAY_TERRACOTTA)
//            .slab(PucksParityModBlocks.LIGHT_GRAY_TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.LIGHT_GRAY_TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.LIGHT_GRAY_TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily LIGHT_GRAY_TERRACOTTA_BRICKS = register(PucksParityModBlocks.LIGHT_GRAY_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.LIGHT_GRAY_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_LIGHT_GRAY_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MOSSY_LIGHT_GRAY_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_LIGHT_GRAY_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_LIGHT_GRAY_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_LIGHT_GRAY_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_LIGHT_GRAY_TERRACOTTA = register(PucksParityModBlocks.POLISHED_LIGHT_GRAY_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_LIGHT_GRAY_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_LIGHT_GRAY_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_LIGHT_GRAY_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily LIGHT_GRAY_TERRACOTTA_TILES = register(PucksParityModBlocks.LIGHT_GRAY_TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.LIGHT_GRAY_TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.LIGHT_GRAY_TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.LIGHT_GRAY_TERRACOTTA_TILE_WALL)
            .build();
//    public static final BlockFamily GRAY_TERRACOTTA = register(Blocks.GRAY_TERRACOTTA)
//            .slab(PucksParityModBlocks.GRAY_TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.GRAY_TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.GRAY_TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily GRAY_TERRACOTTA_BRICKS = register(PucksParityModBlocks.GRAY_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.GRAY_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.GRAY_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.GRAY_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_GRAY_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MOSSY_GRAY_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_GRAY_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_GRAY_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_GRAY_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_GRAY_TERRACOTTA = register(PucksParityModBlocks.POLISHED_GRAY_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_GRAY_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_GRAY_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_GRAY_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily GRAY_TERRACOTTA_TILES = register(PucksParityModBlocks.GRAY_TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.GRAY_TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.GRAY_TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.GRAY_TERRACOTTA_TILE_WALL)
            .build();
//    public static final BlockFamily BLACK_TERRACOTTA = register(Blocks.BLACK_TERRACOTTA)
//            .slab(PucksParityModBlocks.BLACK_TERRACOTTA_SLAB)
//            .stairs(PucksParityModBlocks.BLACK_TERRACOTTA_STAIRS)
//            .wall(PucksParityModBlocks.BLACK_TERRACOTTA_WALL)
//            .build();
    public static final BlockFamily BLACK_TERRACOTTA_BRICKS = register(PucksParityModBlocks.BLACK_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.BLACK_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.BLACK_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.BLACK_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily MOSSY_BLACK_TERRACOTTA_BRICKS = register(PucksParityModBlocks.MOSSY_BLACK_TERRACOTTA_BRICKS)
            .slab(PucksParityModBlocks.MOSSY_BLACK_TERRACOTTA_BRICK_SLAB)
            .stairs(PucksParityModBlocks.MOSSY_BLACK_TERRACOTTA_BRICK_STAIRS)
            .wall(PucksParityModBlocks.MOSSY_BLACK_TERRACOTTA_BRICK_WALL)
            .build();
    public static final BlockFamily POLISHED_BLACK_TERRACOTTA = register(PucksParityModBlocks.POLISHED_BLACK_TERRACOTTA)
            .slab(PucksParityModBlocks.POLISHED_BLACK_TERRACOTTA_SLAB)
            .stairs(PucksParityModBlocks.POLISHED_BLACK_TERRACOTTA_STAIRS)
            .wall(PucksParityModBlocks.POLISHED_BLACK_TERRACOTTA_WALL)
            .build();
    public static final BlockFamily BLACK_TERRACOTTA_TILES = register(PucksParityModBlocks.BLACK_TERRACOTTA_TILES)
            .slab(PucksParityModBlocks.BLACK_TERRACOTTA_TILE_SLAB)
            .stairs(PucksParityModBlocks.BLACK_TERRACOTTA_TILE_STAIRS)
            .wall(PucksParityModBlocks.BLACK_TERRACOTTA_TILE_WALL)
            .build();

}
