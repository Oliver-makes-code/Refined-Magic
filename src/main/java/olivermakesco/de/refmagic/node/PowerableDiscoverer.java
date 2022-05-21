package olivermakesco.de.refmagic.node;

import com.kneelawk.graphlib.graph.BlockNode;
import com.kneelawk.graphlib.graph.BlockNodeDecoder;
import com.kneelawk.graphlib.graph.BlockNodeDiscoverer;
import net.minecraft.nbt.NbtElement;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;

public class PowerableDiscoverer implements BlockNodeDiscoverer {
    public static final PowerableBlockNode blockNode = new PowerableBlockNode();

    @Override
    public @NotNull Collection<BlockNode> getNodesInBlock(@NotNull ServerWorld world, @NotNull BlockPos pos) {
        return ((Powerable)world.getBlockState(pos).getBlock()).createBlockNodes();
    }

    public static class Decoder implements BlockNodeDecoder {

        @Override
        public @Nullable BlockNode createBlockNodeFromTag(@Nullable NbtElement tag) {
            return blockNode;
        }
    }
}
