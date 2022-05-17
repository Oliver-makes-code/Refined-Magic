package olivermakesco.de.refmagic.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MushroomPlantBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class EnchantedFungusBlock extends MushroomPlantBlock {
    public EnchantedFungusBlock() {
        super(QuiltBlockSettings.copyOf(Blocks.CRIMSON_FUNGUS), () -> TreeConfiguredFeatures.CRIMSON_FUNGUS_PLANTED);
    }
}
