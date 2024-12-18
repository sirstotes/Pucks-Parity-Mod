package sirstotes.pucks_parity_mod.mixin;
//?if >1.20.1 {
/*import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.DungeonFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import sirstotes.pucks_parity_mod.PucksParityModBlocks;

@Mixin(DungeonFeature.class)
public class DungeonFeatureMixin extends Feature<DefaultFeatureConfig> {
    public DungeonFeatureMixin(Codec<DefaultFeatureConfig> configCodec) {
        super(configCodec);
    }

    @ModifyExpressionValue(method = "generate", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getDefaultState()Lnet/minecraft/block/BlockState;", ordinal = 0))
    public BlockState replaceMossy(BlockState original, FeatureContext<DefaultFeatureConfig> context) {
        if(context.getOrigin().getY() < 0) {
            return switch (context.hashCode() % 3) {
                case 0 -> PucksParityModBlocks.MOSSY_COBBLED_DRIPSTONE.getDefaultState();
                case 1 -> PucksParityModBlocks.MOSSY_COBBLED_TUFF.getDefaultState();
                default -> PucksParityModBlocks.MOSSY_COBBLED_DEEPSLATE.getDefaultState();
            };
        }
        return switch (context.hashCode() % 5) {
            case 0 -> PucksParityModBlocks.MOSSY_COBBLED_ANDESITE.getDefaultState();
            case 1 -> PucksParityModBlocks.MOSSY_COBBLED_DIORITE.getDefaultState();
            case 2 -> PucksParityModBlocks.MOSSY_COBBLED_GRANITE.getDefaultState();
            case 3 -> PucksParityModBlocks.MOSSY_COBBLED_DRIPSTONE.getDefaultState();
            default -> original;
        };
    }

    @ModifyExpressionValue(method = "generate", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getDefaultState()Lnet/minecraft/block/BlockState;", ordinal = 1))
    public BlockState replaceNormal(BlockState original, FeatureContext<DefaultFeatureConfig> context) {
        if(context.getOrigin().getY() < 0) {
            return switch (context.hashCode() % 3) {
                case 0 -> PucksParityModBlocks.COBBLED_DRIPSTONE.getDefaultState();
                case 1 -> PucksParityModBlocks.COBBLED_TUFF.getDefaultState();
                default -> Blocks.COBBLED_DEEPSLATE.getDefaultState();
            };
        }
        return switch (context.hashCode() % 5) {
            case 0 -> PucksParityModBlocks.COBBLED_ANDESITE.getDefaultState();
            case 1 -> PucksParityModBlocks.COBBLED_DIORITE.getDefaultState();
            case 2 -> PucksParityModBlocks.COBBLED_GRANITE.getDefaultState();
            case 3 -> PucksParityModBlocks.COBBLED_CALCITE.getDefaultState();
            default -> original;
        };
    }

    @Shadow
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        return false;
    }
}
*///?}