package olivermakesco.de.refmagic.block;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.tag.TagKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.registry.RefinedMagicRegistry;
import olivermakesco.de.refmagic.registry.RefinedMagicWorldgen;

import java.util.Random;

public class EnliumBlock extends Block implements Fertilizable {
    public static TagKey<Block> enliumGrowable = TagKey.of(Registry.BLOCK_KEY, Mod.id("enlium_growable"));

    public EnliumBlock(Settings settings) {
        super(settings);
    }

    public static boolean solid(WorldView world, BlockPos pos) {
        return world.getBlockState(pos.up()).isSolidBlock(world,pos.up());
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (solid(world, pos))
            world.setBlockState(pos, Blocks.END_STONE.getDefaultState());
    }

    @Override
    public boolean hasRandomTicks(BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        RefinedMagicWorldgen.enliumPatch.value().generate(world, world.getChunkManager().getChunkGenerator(), random, pos);
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return world.getBlockState(pos.up()).isAir();
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }
}
