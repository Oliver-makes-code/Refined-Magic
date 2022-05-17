package olivermakesco.de.refmagic.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import olivermakesco.de.refmagic.registry.RefinedMagicBlocks;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class EnchantedStemBlock extends PillarBlock {
    public final boolean stripped;
    public EnchantedStemBlock(boolean stripped) {
        super(QuiltBlockSettings.copyOf(Blocks.CRIMSON_STEM));
        this.stripped = stripped;
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stripped) return super.onUse(state, world, pos, player, hand, hit);
        var stack = player.getStackInHand(hand);
        if (!(stack.getItem() instanceof AxeItem)) return super.onUse(state, world, pos, player, hand, hit);
        stack.damage(1, player, playerEntity -> {});
        world.setBlockState(pos, RefinedMagicBlocks.strippedEnchantedStem.getDefaultState());
        world.playSound(null, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1f, 1f);
        return ActionResult.SUCCESS;
    }
}
