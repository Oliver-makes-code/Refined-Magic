package olivermakesco.de.potiontweaks.registry;

import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Holder;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.InSquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import olivermakesco.de.potiontweaks.Mod;

public class Worldgen {
    static RuleTest END_STONE_RULE_TEST = new BlockMatchRuleTest(net.minecraft.block.Blocks.END_STONE);

    private static final Holder<ConfiguredFeature<OreFeatureConfig,?>> kyriteOreConfiguredFeature = ConfiguredFeatureUtil.register(Mod.id("witherite_ore").toString(), Feature.ORE,
            new OreFeatureConfig(
                    END_STONE_RULE_TEST,
                    Blocks.kyriteOre.getDefaultState(),
                    4
            )
    );
    public static Holder<PlacedFeature> kyriteOrePlacedFeature = PlacedFeatureUtil.register(Mod.id("witherite_ore").toString(),kyriteOreConfiguredFeature,
            CountPlacementModifier.create(2),
            InSquarePlacementModifier.getInstance(),
            HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(256))
    );

    public static void register() {
        
    }
}
