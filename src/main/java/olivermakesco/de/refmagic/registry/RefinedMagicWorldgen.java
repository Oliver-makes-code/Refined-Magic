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
    static RuleTest STONE_RULE_TEST = new BlockMatchRuleTest(Blocks.STONE);
    static RuleTest DEEPSLATE_RULE_TEST = new BlockMatchRuleTest(Blocks.DEEPSLATE);
    static RuleTest NETHERRACK_RULE_TEST = new BlockMatchRuleTest(Blocks.NETHERRACK);
    static RuleTest BLACKSTONE_RULE_TEST = new BlockMatchRuleTest(Blocks.BLACKSTONE);
    static RuleTest BASALT_RULE_TEST = new BlockMatchRuleTest(Blocks.BASALT);
    static RuleTest GRANITE_RULE_TEST = new BlockMatchRuleTest(Blocks.GRANITE);

    public static final Holder<ConfiguredFeature<OreFeatureConfig,?>> kyriteOreEndConfiguredFeature = ConfiguredFeatureUtil.register(Mod.id("kyrite_ore_end").toString(), Feature.ORE,
            new OreFeatureConfig(
                    END_STONE_RULE_TEST,
                    RefinedMagicBlocks.kyriteOreEnd.getDefaultState(),
                    8
            )
    );
    public static final Holder<ConfiguredFeature<OreFeatureConfig,?>> kyriteOreOverworldConfiguredFeature = ConfiguredFeatureUtil.register(Mod.id("kyrite_ore_overworld").toString(), Feature.ORE,
            new OreFeatureConfig(
                    STONE_RULE_TEST,
                    RefinedMagicBlocks.kyriteOreOverworld.getDefaultState(),
                    8
            )
    );
    public static final Holder<ConfiguredFeature<OreFeatureConfig,?>> kyriteOreNetherConfiguredFeature = ConfiguredFeatureUtil.register(Mod.id("kyrite_ore_nether").toString(), Feature.ORE,
            new OreFeatureConfig(
                    NETHERRACK_RULE_TEST,
                    RefinedMagicBlocks.kyriteOreNether.getDefaultState(),
                    8
            )
    );
    public static final Holder<PlacedFeature> kyriteOreEndPlacedFeature = PlacedFeatureUtil.register(Mod.id("kyrite_ore_end").toString(),kyriteOreEndConfiguredFeature,
            CountPlacementModifier.create(15),
            InSquarePlacementModifier.getInstance(),
            HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(256))
    );
    public static final Holder<PlacedFeature> kyriteOreOverworldPlacedFeature = PlacedFeatureUtil.register(Mod.id("kyrite_ore_overworld").toString(),kyriteOreOverworldConfiguredFeature,
            CountPlacementModifier.create(15),
            InSquarePlacementModifier.getInstance(),
            HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(256))
    );
    public static final Holder<PlacedFeature> kyriteOreNetherPlacedFeature = PlacedFeatureUtil.register(Mod.id("kyrite_ore_nether").toString(),kyriteOreNetherConfiguredFeature,
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



    public static final Holder<ConfiguredFeature<OreFeatureConfig,?>> bismuthOreNetherConfiguredFeature = ConfiguredFeatureUtil.register(Mod.id("bismuth_ore_nether").toString(), Feature.ORE,
            new OreFeatureConfig(
                    BASALT_RULE_TEST,
                    RefinedMagicBlocks.bismuthOreNether.getDefaultState(),
                    8
            )
    );
    public static final Holder<ConfiguredFeature<OreFeatureConfig,?>> bismuthOreOverworldConfiguredFeature = ConfiguredFeatureUtil.register(Mod.id("bismuth_ore_overworld").toString(), Feature.ORE,
            new OreFeatureConfig(
                    DEEPSLATE_RULE_TEST,
                    RefinedMagicBlocks.bismuthOreOverworld.getDefaultState(),
                    8
            )
    );
    public static final Holder<PlacedFeature> bismuthOreNetherPlacedFeature = PlacedFeatureUtil.register(Mod.id("bismuth_ore_nether").toString(),bismuthOreNetherConfiguredFeature,
            CountPlacementModifier.create(20),
            InSquarePlacementModifier.getInstance(),
            HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(128))
    );
    public static final Holder<PlacedFeature> bismuthOreOverworldPlacedFeature = PlacedFeatureUtil.register(Mod.id("bismuth_ore_overworld").toString(),bismuthOreOverworldConfiguredFeature,
            CountPlacementModifier.create(20),
            InSquarePlacementModifier.getInstance(),
            HeightRangePlacementModifier.createUniform(YOffset.fixed(-64), YOffset.fixed(0))
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
                BiomeSelectors.foundInTheNether(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(
                        Registry.PLACED_FEATURE_KEY,
                        Mod.id("kyrite_ore_nether")
                )
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(
                        Registry.PLACED_FEATURE_KEY,
                        Mod.id("kyrite_ore_overworld")
                )
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInTheEnd(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(
                        Registry.PLACED_FEATURE_KEY,
                        Mod.id("kyrite_ore_end")
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
                        Mod.id("bismuth_ore_nether")
                )
        );
        BiomeModifications.addFeature(
                BiomeSelectors.foundInOverworld(),
                GenerationStep.Feature.UNDERGROUND_ORES,
                RegistryKey.of(
                        Registry.PLACED_FEATURE_KEY,
                        Mod.id("bismuth_ore_overworld")
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
