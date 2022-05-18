package olivermakesco.de.refmagic.block;

import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import olivermakesco.de.refmagic.Mod;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class EnliumGrowthBlock extends PlantBlock {
    public static final VoxelShape shape = VoxelShapes.cuboid(1/16f,0,1/16f,15/16f,1/4f,15/16f);

    public EnliumGrowthBlock() {
        super(QuiltBlockSettings.copyOf(Blocks.GRASS).sounds(BlockSoundGroup.NETHER_SPROUTS));
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(EnliumBlock.enliumGrowable);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
    }
}
