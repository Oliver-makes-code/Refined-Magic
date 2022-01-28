package olivermakesco.de.refinedmagic.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import olivermakesco.de.refinedmagic.block.entity.GlassTankBlockEntity;
import org.jetbrains.annotations.Nullable;

public class GlassTankBlock extends Block implements BlockEntityProvider {
    public static final VoxelShape shape = getVoxelShape();

    public GlassTankBlock() {
        super(Settings.copy(Blocks.END_STONE).mapColor(MapColor.PALE_YELLOW).nonOpaque().allowsSpawning((a, b, c, d) -> false).solidBlock((a, b, c) -> false).suffocates((a, b, c) -> false).blockVision((a, b, c) -> false));
    }



    public static VoxelShape getVoxelShape() {
        var bottom = Block.createCuboidShape(1,0,1,15,2,15);
        var top = Block.createCuboidShape(3,2,3,13,14,13);
        return VoxelShapes.union(bottom,top);
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return shape;
    }
    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
    }


    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
    @Override
    public boolean hasSidedTransparency(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new GlassTankBlockEntity(pos,state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return (BlockEntityTicker<T>) new GlassTankBlockEntity.Ticker();
    }
}
