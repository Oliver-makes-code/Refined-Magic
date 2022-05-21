package olivermakesco.de.refmagic.world;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;
import olivermakesco.de.refmagic.registry.RefinedMagicBlocks;

public class GiantMushroomFeature extends Feature<DefaultFeatureConfig> {

    public GiantMushroomFeature() {
        super(DefaultFeatureConfig.CODEC);
    }

    @Override
    public boolean place(FeatureContext<DefaultFeatureConfig> context) {
        BlockPos pos = context.getOrigin();
        ServerWorld world = context.getWorld().toServerWorld();

        world.setBlockState(pos, RefinedMagicBlocks.enchantedStem.getDefaultState());

        return true;
    }
}
