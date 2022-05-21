package olivermakesco.de.refmagic.node;

import com.kneelawk.graphlib.graph.BlockNode;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Collection;

public interface Powerable {
    void turnOn(World world, BlockPos pos, BlockState state);
    void turnOff(World world, BlockPos pos, BlockState state);
    void toggle(World world, BlockPos pos, BlockState state);
    boolean isPowered(World world, BlockPos pos, BlockState state);
    Collection<BlockNode> createBlockNodes();
}
