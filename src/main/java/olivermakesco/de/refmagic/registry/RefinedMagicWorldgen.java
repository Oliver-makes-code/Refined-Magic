package olivermakesco.de.refmagic.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.util.Holder;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.InSquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import olivermakesco.de.refmagic.Mod;

public class RefinedMagicWorldgen {
    static RuleTest END_STONE_RULE_TEST = new BlockMatchRuleTest(Blocks.END_STONE);
    static RuleTest BLACKSTONE_RULE_TEST = new BlockMatchRuleTest(Blocks.BLACKSTONE);
    static RuleTest BASALT_RULE_TEST = new BlockMatchRuleTest(Blocks.BASALT);
    static RuleTest GRANITE_RULE_TEST = new BlockMatchRuleTest(Blocks.GRANITE);

    public static final Holder<ConfiguredFeature<OreFeatureConfig,?>> kyriteOreConfiguredFeature = ConfiguredFeatureUtil.register(Mod.id("kyrite_ore").toString(), Feature.ORE,
            new OreFeatureConfig(
                    END_STONE_RULE_TEST,
                    RefinedMagicBlocks.kyriteOre.getDefaultState(),
                    8
            )
    );
    public static final Holder<PlacedFeature> kyriteOrePlacedFeature = PlacedFeatureUtil.register(Mod.id("kyrite_ore").toString(),kyriteOreConfiguredFeature,
            CountPlacementModifier.create(15),
            InSquarePlacementModifier.getInstance(),
            HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(256))
    );

    public static final Holder<ConfiguredFeature<OreFeatureConfig,?>> opalOreConfiguredFeature = ConfiguredFeatureUtil.register(Mod.id("opal_ore").toString(), Feature.ORE,
            new OreFeatureConfig(
                    END_STONE_RULE_TEST,
                    RefinedMagicBlocks.opalOre.getDefaultState(),
                    8
            )
    );
    public static final Holder<PlacedFeature> opalOrePlacedFeature = PlacedFeatureUtil.register(Mod.id("opal_ore").toString(),opalOreConfiguredFeature,
            CountPlacementModifier.create(15),
            InSquarePlacementModifier.getInstance(),
            HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(128))
    );

    public static final Holder<ConfiguredFeature<OreFeatureConfig,?>> roseOreConfiguredFeature = ConfiguredFeatureUtil.register(Mod.id("rose_ore").toString(), Feature.ORE,
            new OreFeatureConfig(
                    END_STONE_RULE_TEST,
                    RefinedMagicBlocks.roseQuartzOre.getDefaultState(),
                    8
            )
    );
    public static final Holder<PlacedFeature> roseOrePlacedFeature = PlacedFeatureUtil.register(Mod.id("rose_ore").toString(),roseOreConfiguredFeature,
            CountPlacementModifier.create(15),
            InSquarePlacementModifier.getInstance(),
            HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(128))
    );



    public static final Holder<ConfiguredFeature<OreFeatureConfig,?>> bismuthOreConfiguredFeature = ConfiguredFeatureUtil.register(Mod.id("bismuth_ore").toString(), Feature.ORE,
            new OreFeatureConfig(
                    BASALT_RULE_TEST,
                    RefinedMagicBlocks.bismuthOre.getDefaultState(),
                    8
            )
    );
    public static final Holder<PlacedFeature> bismuthOrePlacedFeature = PlacedFeatureUtil.register(Mod.id("bismuth_ore").toString(),bismuthOreConfiguredFeature,
            CountPlacementModifier.create(20),
            InSquarePlacementModifier.getInstance(),
            HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(128))
    );

    public static final Holder<ConfiguredFeature<OreFeatureConfig,?>> citrineOreConfiguredFeature = ConfiguredFeatureUtil.register(Mod.id("citrine_ore").toString(), Feature.ORE,
            new OreFeatureConfig(
                    BLACKSTONE_RULE_TEST,
                    RefinedMagicBlocks.citrineOre.getDefaultState(),
                    8
            )
    );
    public static final Holder<PlacedFeature> citrineOrePlacedFeature = PlacedFeatureUtil.register(Mod.id("citrine_ore").toString(),citrineOreConfiguredFeature,
            CountPlacementModifier.create(20),
            InSquarePlacementModifier.getInstance(),
            HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(128))
    );

    public static final Holder<ConfiguredFeature<OreFeatureConfig,?>> topazOreConfiguredFeature = ConfiguredFeatureUtil.register(Mod.id("topaz_ore").toString(), Feature.ORE,
            new OreFeatureConfig(
                    GRANITE_RULE_TEST,
                    RefinedMagicBlocks.topazOre.getDefaultState(),
                    16
            )
    );
    public static final Holder<PlacedFeature> topazOrePlacedFeature = PlacedFeatureUtil.register(Mod.id("topaz_ore").toString(),topazOreConfiguredFeature,
            CountPlacementModifier.create(50),
            InSquarePlacementModifier.getInstance(),
            HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(128))
    );

    public static void register() {
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(
                        Registry.PLACED_FEATURE_KEY,
                        Mod.id("kyrite_ore")
                )
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(
                        Registry.PLACED_FEATURE_KEY,
                        Mod.id("opal_ore")
                )
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(
                        Registry.PLACED_FEATURE_KEY,
                        Mod.id("rose_ore")
                )
        );

        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(
                        Registry.PLACED_FEATURE_KEY,
                        Mod.id("bismuth_ore")
                )
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(
                        Registry.PLACED_FEATURE_KEY,
                        Mod.id("citrine_ore")
                )
        );

        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(
                        Registry.PLACED_FEATURE_KEY,
                        Mod.id("topaz_ore")
                )
        );
    }
}
