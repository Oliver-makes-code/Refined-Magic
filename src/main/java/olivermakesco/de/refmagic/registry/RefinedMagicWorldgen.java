package olivermakesco.de.refmagic.registry;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.TheEndBiomes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Holder;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.VerticalSurfaceType;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountOnEveryLayerPlacementModifier;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.InSquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil;
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import olivermakesco.de.refmagic.Mod;
import olivermakesco.de.refmagic.worldgen.EnliumVegetation;

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

    public static final RegistryKey<Biome> mushroomIsles = RegistryKey.of(Registry.BIOME_KEY,Mod.id("mushroom_isles"));

    public static final Holder<ConfiguredFeature<HugeFungusFeatureConfig, ?>> enchantedFungusPlanted = ConfiguredFeatureUtil.register(
            Mod.id("enchanted_mushroom_planted").toString(),
            Feature.HUGE_FUNGUS,
            new HugeFungusFeatureConfig(
                    RefinedMagicBlocks.enlium.getDefaultState(),
                    RefinedMagicBlocks.enchantedStem.getDefaultState(),
                    RefinedMagicBlocks.enchantedWart.getDefaultState(),
                    RefinedMagicBlocks.enchantedShroomlight.getDefaultState(),
                    false
            )
    );

    public static final Holder<PlacedFeature> enchantedFungusPlaced = PlacedFeatureUtil.register(Mod.id("enchanted_fungus_placed").toString(), enchantedFungusPlanted, CountOnEveryLayerPlacementModifier.create(8), PlacedFeatureUtil.OCEAN_FLOOR_HEIGHTMAP);

    public static final Biome mushroomIslesBiome = createMushroomIsles();
    public static <FC extends FeatureConfig, F extends Feature<FC>> Holder<ConfiguredFeature<SimpleBlockFeatureConfig, ?>> register(String id, F feature, FC featureConfig) {
        return BuiltinRegistries.registerExact(BuiltinRegistries.CONFIGURED_FEATURE, id, new ConfiguredFeature(feature, featureConfig));
    }
    public static final EnliumVegetation enliumFeature = Registry.register(Registry.FEATURE, Mod.id("enlium_feature"), new EnliumVegetation(SimpleBlockFeatureConfig.CODEC));
    public static final Holder<ConfiguredFeature<SimpleBlockFeatureConfig, ?>> enliumVegetation = register(
            Mod.id("enlium_vegetation").toString(),
            enliumFeature,
            new SimpleBlockFeatureConfig(
                    new WeightedBlockStateProvider(
                            new DataPool.Builder<BlockState>()
                                    .add(Blocks.AIR.getDefaultState(), 50)
                                    .add(RefinedMagicBlocks.enliumGrowth.getDefaultState(), 10)
                                    .add(RefinedMagicBlocks.enchantedFungus.getDefaultState(), 5)
                                    .add(RefinedMagicBlocks.hoopvine.getDefaultState(), 5)
                                    .build()
                    )
            )
    );
    public static final Holder<ConfiguredFeature<VegetationPatchFeatureConfig, ?>> enliumPatch = ConfiguredFeatureUtil.register(
            Mod.id("enlium_patch").toString(),
            Feature.VEGETATION_PATCH,
            new VegetationPatchFeatureConfig(
                    TagKey.of(Registry.BLOCK_KEY, Mod.id("enlium_replaceable")),
                    BlockStateProvider.of(RefinedMagicBlocks.enlium),
                    PlacedFeatureUtil.placedInline(enliumVegetation),
                    VerticalSurfaceType.FLOOR,
                    ConstantIntProvider.create(1),
                    0.0F,
                    5,
                    0.8F,
                    UniformIntProvider.create(4, 7),
                    0.3F
            )
    );

    public static final Holder<ConfiguredFeature<VegetationPatchFeatureConfig, ?>> enliumBase = ConfiguredFeatureUtil.register(
            Mod.id("enlium_base").toString(),
            Feature.VEGETATION_PATCH,
            new VegetationPatchFeatureConfig(
                    TagKey.of(Registry.BLOCK_KEY, Mod.id("enlium_base")),
                    BlockStateProvider.of(RefinedMagicBlocks.enlium),
                    PlacedFeatureUtil.placedInline(enliumVegetation),
                    VerticalSurfaceType.FLOOR,
                    ConstantIntProvider.create(1),
                    0.0F,
                    5,
                    0.8F,
                    UniformIntProvider.create(4, 7),
                    0.3F
            )
    );

    public static final Holder<PlacedFeature> enliumPatchPlaced = PlacedFeatureUtil.register(Mod.id("enlium_patch_placed").toString(), enliumBase, CountOnEveryLayerPlacementModifier.create(8), PlacedFeatureUtil.OCEAN_FLOOR_HEIGHTMAP);


    private static Biome createBaseEndBiome(GenerationSettings.Builder builder) {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addEndMobs(spawnSettings);
        return new Biome.Builder()
                .precipitation(Biome.Precipitation.NONE)
                .category(Biome.Category.THEEND)
                .temperature(0.5F)
                .downfall(0.5F)
                .effects((new BiomeEffects.Builder())
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .fogColor(10518688).skyColor(0)
                        .moodSound(BiomeMoodSound.CAVE)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(builder.build())
                .build();
    }

    public static Biome createMushroomIsles() {
        GenerationSettings.Builder builder = new GenerationSettings.Builder()
                .feature(GenerationStep.Feature.SURFACE_STRUCTURES, EndPlacedFeatures.END_GATEWAY_RETURN);
        return createBaseEndBiome(builder);
    }

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
        Registry.register(BuiltinRegistries.BIOME, mushroomIsles.getValue(), mushroomIslesBiome);
        TheEndBiomes.addHighlandsBiome(mushroomIsles, 5.0);
        BiomeModifications.addFeature((a) -> true, GenerationStep.Feature.VEGETAL_DECORATION, RegistryKey.of(Registry.PLACED_FEATURE_KEY, Mod.id("enchanted_fungus_placed")));
        BiomeModifications.addFeature((a) -> true, GenerationStep.Feature.VEGETAL_DECORATION, RegistryKey.of(Registry.PLACED_FEATURE_KEY, Mod.id("enlium_patch_placed")));
    }
}
