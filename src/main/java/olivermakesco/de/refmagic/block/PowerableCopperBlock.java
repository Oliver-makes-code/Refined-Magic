package olivermakesco.de.refmagic.block;

import com.kneelawk.graphlib.GraphLib;
import com.kneelawk.graphlib.graph.BlockNode;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.node.Powerable;
import olivermakesco.de.refmagic.node.PowerableBlockNode;
import olivermakesco.de.refmagic.node.PowerableDiscoverer;
import org.apache.logging.log4j.core.jmx.Server;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public class PowerableCopperBlock extends Block implements Powerable {
    public PowerableCopperBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(Mod.copperPoweredProperty, false).with(Mod.copperPowerSource, false));
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        super.onBroken(world, pos, state);
        if (!(world instanceof ServerWorld serverWorld)) return;
        GraphLib.getController(serverWorld).onChanged(pos);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        super.onPlaced(world, pos, state, placer, itemStack);
        if (!(world instanceof ServerWorld serverWorld)) return;
        GraphLib.getController(serverWorld).onChanged(pos);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(Mod.copperPoweredProperty);
        builder.add(Mod.copperPowerSource);
    }

    @Override
    public void turnOn(World world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, state.with(Mod.copperPoweredProperty, true));
    }

    @Override
    public void turnOff(World world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, state.with(Mod.copperPoweredProperty, false));
    }

    @Override
    public void toggle(World world, BlockPos pos, BlockState state) {
        world.setBlockState(pos, state.with(Mod.copperPoweredProperty, !isPowered(world,pos,state)));
    }

    @Override
    public boolean isPowered(World world, BlockPos pos, BlockState state) {
        return state.get(Mod.copperPoweredProperty);
    }

    @Override
    public Collection<BlockNode> createBlockNodes() {
        return List.of(PowerableDiscoverer.blockNode);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!(world instanceof ServerWorld serverWorld)) return state;
        boolean powered = serverWorld.isReceivingRedstonePower(pos);
        if (powered && !state.get(Mod.copperPowerSource)) {
            state = state.with(Mod.copperPowerSource, true);
            PowerableBlockNode.deferUpdate(pos);
        } else if (!powered && state.get(Mod.copperPowerSource)) {
            state = state.with(Mod.copperPowerSource, false);
            PowerableBlockNode.deferUpdate(pos);
        }
        return state;
    }
}
