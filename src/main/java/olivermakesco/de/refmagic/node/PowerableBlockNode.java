package olivermakesco.de.refmagic.node;

import com.kneelawk.graphlib.GraphLib;
import com.kneelawk.graphlib.graph.BlockNodeWrapper;
import com.kneelawk.graphlib.graph.NodeView;
import com.kneelawk.graphlib.graph.struct.Node;
import com.kneelawk.graphlib.wire.FullWireBlockNode;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.NbtElement;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import olivermakesco.de.refmagic.Mod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.quiltmc.qsl.lifecycle.api.event.ServerWorldTickEvents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PowerableBlockNode implements FullWireBlockNode {
    @Override
    public @NotNull Identifier getTypeId() {
        return Mod.id("powerable_copper");
    }

    @Override
    public @Nullable NbtElement toTag() {
        return null;
    }

    @Override
    public @NotNull Collection<Node<BlockNodeWrapper<?>>> findConnections(@NotNull ServerWorld world, @NotNull NodeView nodeView, @NotNull BlockPos pos) {
        var list = new ArrayList<Node<BlockNodeWrapper<?>>>();
        for (Direction dir : Direction.Type.HORIZONTAL) {
            var newpos = pos.offset(dir);
            nodeView.getNodesAt(newpos).forEach(list::add);
        }
        return list;
    }

    @Override
    public boolean canConnect(@NotNull ServerWorld world, @NotNull NodeView nodeView, @NotNull BlockPos pos, @NotNull Node<BlockNodeWrapper<?>> other) {
        return world.getBlockState(pos).getBlock() instanceof Powerable;
    }

    @Override
    public void onChanged(@NotNull ServerWorld world, @NotNull BlockPos pos) {
        GraphLib.getController(world).updateConnections(pos);
        var blockCollection = getConnectedBlockNodes(world, pos);
        var powered = false;
        for (BlockPos blockPos : blockCollection) {
            var state = world.getBlockState(blockPos);
            if (!(state.getBlock() instanceof Powerable)) continue;
            if (state.get(Mod.copperPowerSource)) {
                powered = true;
                break;
            }
        }
        for (BlockPos blockPos : blockCollection) {
            var state = world.getBlockState(blockPos);
            if (!(state.getBlock() instanceof Powerable)) continue;
            world.setBlockState(blockPos, state.with(Mod.copperPoweredProperty, powered));
        }
    }

    public static Collection<BlockPos> getConnectedBlockNodes(ServerWorld world, BlockPos pos) {
        var nodes = GraphLib.getController(world).getNodesAt(pos);
        var out = new ArrayList<BlockPos>();
        nodes.forEach((node) -> {
            out.add(node.data().pos());
        });
        return out;
    }

    public static void register() {
        GraphLib.registerDiscoverer(new PowerableDiscoverer());
        Registry.register(GraphLib.BLOCK_NODE_DECODER, Mod.id("powerable_copper"), new PowerableDiscoverer.Decoder());
    }
}
