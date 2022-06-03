package olivermakesco.de.refmagic.worldgen;

import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Holder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.SimpleBlockFeature;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.feature.VegetationPatchFeatureConfig;
import net.minecraft.world.gen.feature.util.FeatureContext;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import olivermakesco.de.refmagic.block.HoopvineBlock;

public class EnliumVegetation extends SimpleBlockFeature {

    public EnliumVegetation(Codec<SimpleBlockFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeatureContext<SimpleBlockFeatureConfig> context) {
        SimpleBlockFeatureConfig simpleBlockFeatureConfig = context.getConfig();
        StructureWorldAccess structureWorldAccess = context.getWorld();
        BlockPos blockPos = context.getOrigin();
        BlockState blockState = simpleBlockFeatureConfig.toPlace().getBlockState(context.getRandom(), blockPos);
        if (blockState.canPlaceAt(structureWorldAccess, blockPos)) {
            if (blockState.getBlock() instanceof TallPlantBlock) {
                if (!structureWorldAccess.isAir(blockPos.up())) {
                    return false;
                }

                TallPlantBlock.placeAt(structureWorldAccess, blockState, blockPos, 2);
            } else if (blockState.getBlock() instanceof HoopvineBlock) {
                HoopvineBlock.grow(structureWorldAccess, blockPos, context.getRandom());
            } else {
                structureWorldAccess.setBlockState(blockPos, blockState, 2);
            }

            return true;
        } else {
            return false;
        }
    }
}
