package olivermakesco.de.refinedmagic.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class EvaporationTableBlock extends Block {
    public VoxelShape shape;

    public EvaporationTableBlock() {
        super(Settings.copy(Blocks.COBBLESTONE).nonOpaque().allowsSpawning((a,b,c,d) -> false).solidBlock((a,b,c) -> false));
        generateShape();
    }

    public void generateShape() {
        var bottom = createCuboidShape(2,0,2,14,8,14);
        var top = createCuboidShape(1,8,1,15,10,15);
        var rod = createCuboidShape(7,10,7,9,18,9);
        shape = VoxelShapes.union(bottom,top,rod);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
    }

    @Override
    public VoxelShape getCullingShape(BlockState state, BlockView world, BlockPos pos) {
        return shape;
    }

    @Override
    public VoxelShape getRaycastShape(BlockState state, BlockView world, BlockPos pos) {
        return shape;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
    }
}
