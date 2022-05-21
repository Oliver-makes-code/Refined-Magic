package olivermakesco.de.refmagic.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.surfacebuilder.SurfaceRules;
import net.minecraft.world.gen.surfacebuilder.VanillaSurfaceRules;
import olivermakesco.de.refmagic.registry.RefinedMagicBlocks;
import olivermakesco.de.refmagic.world.BiomeInit;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(VanillaSurfaceRules.class)
public class VanillaSurfaceRulesMixin {

    /**
     * @author zOnlyKroks
     */
    @Overwrite()
    public static SurfaceRules.MaterialRule getEndRules() {
        SurfaceRules.MaterialRule surfaceRule = SurfaceRules.block(RefinedMagicBlocks.enlium.getDefaultState());

        return SurfaceRules.sequence(
                SurfaceRules.condition(
                        SurfaceRules.biome(BiomeInit.MUSHROOM_ISLES),
                        SurfaceRules.condition(
                                SurfaceRules.ON_FLOOR,
                                surfaceRule
                        )
                ),
                SurfaceRules.block(Blocks.END_STONE.getDefaultState())
        );
    }
}
