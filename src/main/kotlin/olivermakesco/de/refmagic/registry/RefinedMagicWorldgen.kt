package olivermakesco.de.refmagic.registry

import net.fabricmc.fabric.api.biome.v1.BiomeModifications
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors
import net.fabricmc.fabric.api.biome.v1.TheEndBiomes
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.sound.BiomeMoodSound
import net.minecraft.structure.rule.BlockMatchRuleTest
import net.minecraft.structure.rule.RuleTest
import net.minecraft.tag.TagKey
import net.minecraft.util.Holder
import net.minecraft.util.collection.DataPool
import net.minecraft.util.math.VerticalSurfaceType
import net.minecraft.util.math.intprovider.ConstantIntProvider
import net.minecraft.util.math.intprovider.UniformIntProvider
import net.minecraft.util.registry.BuiltinRegistries
import net.minecraft.util.registry.Registry
import net.minecraft.util.registry.RegistryKey
import net.minecraft.world.biome.Biome
import net.minecraft.world.biome.BiomeEffects
import net.minecraft.world.biome.GenerationSettings
import net.minecraft.world.biome.SpawnSettings
import net.minecraft.world.gen.GenerationStep
import net.minecraft.world.gen.YOffset
import net.minecraft.world.gen.decorator.CountOnEveryLayerPlacementModifier
import net.minecraft.world.gen.decorator.CountPlacementModifier
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier
import net.minecraft.world.gen.decorator.InSquarePlacementModifier
import net.minecraft.world.gen.feature.*
import net.minecraft.world.gen.feature.util.ConfiguredFeatureUtil
import net.minecraft.world.gen.feature.util.PlacedFeatureUtil
import net.minecraft.world.gen.stateprovider.BlockStateProvider
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider
import olivermakesco.de.refmagic.Mod
import olivermakesco.de.refmagic.worldgen.EnliumVegetation

object RefinedMagicWorldgen {
    var END_STONE_RULE_TEST: RuleTest = BlockMatchRuleTest(Blocks.END_STONE)
    var STONE_RULE_TEST: RuleTest = BlockMatchRuleTest(Blocks.STONE)
    var DEEPSLATE_RULE_TEST: RuleTest = BlockMatchRuleTest(Blocks.DEEPSLATE)
    var NETHERRACK_RULE_TEST: RuleTest = BlockMatchRuleTest(Blocks.NETHERRACK)
    var BLACKSTONE_RULE_TEST: RuleTest = BlockMatchRuleTest(Blocks.BLACKSTONE)
    var BASALT_RULE_TEST: RuleTest = BlockMatchRuleTest(Blocks.BASALT)
    var GRANITE_RULE_TEST: RuleTest = BlockMatchRuleTest(Blocks.GRANITE)
    val kyriteOreEndConfiguredFeature = ConfiguredFeatureUtil.register(
        Mod.id("kyrite_ore_end").toString(), Feature.ORE,
        OreFeatureConfig(
            END_STONE_RULE_TEST,
            RefinedMagicBlocks.kyriteOreEnd.defaultState,
            8
        )
    )
    val kyriteOreOverworldConfiguredFeature = ConfiguredFeatureUtil.register(
        Mod.id("kyrite_ore_overworld").toString(), Feature.ORE,
        OreFeatureConfig(
            STONE_RULE_TEST,
            RefinedMagicBlocks.kyriteOreOverworld.defaultState,
            8
        )
    )
    val kyriteOreNetherConfiguredFeature = ConfiguredFeatureUtil.register(
        Mod.id("kyrite_ore_nether").toString(), Feature.ORE,
        OreFeatureConfig(
            NETHERRACK_RULE_TEST,
            RefinedMagicBlocks.kyriteOreNether.defaultState,
            8
        )
    )
    val kyriteOreEndPlacedFeature = PlacedFeatureUtil.register(
        Mod.id("kyrite_ore_end").toString(), kyriteOreEndConfiguredFeature,
        CountPlacementModifier.create(15),
        InSquarePlacementModifier.getInstance(),
        HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(256))
    )
    val kyriteOreOverworldPlacedFeature = PlacedFeatureUtil.register(
        Mod.id("kyrite_ore_overworld").toString(), kyriteOreOverworldConfiguredFeature,
        CountPlacementModifier.create(15),
        InSquarePlacementModifier.getInstance(),
        HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(256))
    )
    val kyriteOreNetherPlacedFeature = PlacedFeatureUtil.register(
        Mod.id("kyrite_ore_nether").toString(), kyriteOreNetherConfiguredFeature,
        CountPlacementModifier.create(15),
        InSquarePlacementModifier.getInstance(),
        HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(256))
    )
    val opalOreConfiguredFeature = ConfiguredFeatureUtil.register(
        Mod.id("opal_ore").toString(), Feature.ORE,
        OreFeatureConfig(
            END_STONE_RULE_TEST,
            RefinedMagicBlocks.opalOre.defaultState,
            8
        )
    )
    val opalOrePlacedFeature = PlacedFeatureUtil.register(
        Mod.id("opal_ore").toString(), opalOreConfiguredFeature,
        CountPlacementModifier.create(15),
        InSquarePlacementModifier.getInstance(),
        HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(128))
    )
    val roseOreConfiguredFeature = ConfiguredFeatureUtil.register(
        Mod.id("rose_ore").toString(), Feature.ORE,
        OreFeatureConfig(
            END_STONE_RULE_TEST,
            RefinedMagicBlocks.roseQuartzOre.defaultState,
            8
        )
    )
    val roseOrePlacedFeature = PlacedFeatureUtil.register(
        Mod.id("rose_ore").toString(), roseOreConfiguredFeature,
        CountPlacementModifier.create(15),
        InSquarePlacementModifier.getInstance(),
        HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(128))
    )
    val bismuthOreNetherConfiguredFeature = ConfiguredFeatureUtil.register(
        Mod.id("bismuth_ore_nether").toString(), Feature.ORE,
        OreFeatureConfig(
            BASALT_RULE_TEST,
            RefinedMagicBlocks.bismuthOreNether.defaultState,
            8
        )
    )
    val bismuthOreOverworldConfiguredFeature = ConfiguredFeatureUtil.register(
        Mod.id("bismuth_ore_overworld").toString(), Feature.ORE,
        OreFeatureConfig(
            DEEPSLATE_RULE_TEST,
            RefinedMagicBlocks.bismuthOreOverworld.defaultState,
            8
        )
    )
    val bismuthOreNetherPlacedFeature = PlacedFeatureUtil.register(
        Mod.id("bismuth_ore_nether").toString(), bismuthOreNetherConfiguredFeature,
        CountPlacementModifier.create(20),
        InSquarePlacementModifier.getInstance(),
        HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(128))
    )
    val bismuthOreOverworldPlacedFeature = PlacedFeatureUtil.register(
        Mod.id("bismuth_ore_overworld").toString(), bismuthOreOverworldConfiguredFeature,
        CountPlacementModifier.create(20),
        InSquarePlacementModifier.getInstance(),
        HeightRangePlacementModifier.createUniform(YOffset.fixed(-64), YOffset.fixed(0))
    )
    val citrineOreConfiguredFeature = ConfiguredFeatureUtil.register(
        Mod.id("citrine_ore").toString(), Feature.ORE,
        OreFeatureConfig(
            BLACKSTONE_RULE_TEST,
            RefinedMagicBlocks.citrineOre.defaultState,
            8
        )
    )
    val citrineOrePlacedFeature = PlacedFeatureUtil.register(
        Mod.id("citrine_ore").toString(), citrineOreConfiguredFeature,
        CountPlacementModifier.create(20),
        InSquarePlacementModifier.getInstance(),
        HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(128))
    )
    val topazOreConfiguredFeature = ConfiguredFeatureUtil.register(
        Mod.id("topaz_ore").toString(), Feature.ORE,
        OreFeatureConfig(
            GRANITE_RULE_TEST,
            RefinedMagicBlocks.topazOre.defaultState,
            16
        )
    )
    val topazOrePlacedFeature = PlacedFeatureUtil.register(
        Mod.id("topaz_ore").toString(), topazOreConfiguredFeature,
        CountPlacementModifier.create(50),
        InSquarePlacementModifier.getInstance(),
        HeightRangePlacementModifier.createUniform(YOffset.fixed(1), YOffset.fixed(128))
    )
    @JvmField
    val mushroomIsles = RegistryKey.of(Registry.BIOME_KEY, Mod.id("mushroom_isles"))
    val enchantedFungusPlanted = ConfiguredFeatureUtil.register(
        Mod.id("enchanted_mushroom_planted").toString(),
        Feature.HUGE_FUNGUS,
        HugeFungusFeatureConfig(
            RefinedMagicBlocks.enlium.defaultState,
            RefinedMagicBlocks.enchantedStem.defaultState,
            RefinedMagicBlocks.enchantedWart.defaultState,
            RefinedMagicBlocks.enchantedShroomlight.defaultState,
            false
        )
    )
    val enchantedFungusPlaced = PlacedFeatureUtil.register(
        Mod.id("enchanted_fungus_placed").toString(),
        enchantedFungusPlanted,
        CountOnEveryLayerPlacementModifier.create(8),
        PlacedFeatureUtil.OCEAN_FLOOR_HEIGHTMAP
    )
    val mushroomIslesBiome = createMushroomIsles()
    fun <FC : FeatureConfig?, F : Feature<FC>?> register(
        id: String?,
        feature: F,
        featureConfig: FC
    ): Holder<ConfiguredFeature<FC, F>> {
        return BuiltinRegistries.registerExact(
            BuiltinRegistries.CONFIGURED_FEATURE,
            id,
            ConfiguredFeature(feature, featureConfig)
        )
    }

    val enliumFeature =
        Registry.register(Registry.FEATURE, Mod.id("enlium_feature"), EnliumVegetation(SimpleBlockFeatureConfig.CODEC))
    val enliumVegetation = register(
        Mod.id("enlium_vegetation").toString(),
        enliumFeature,
        SimpleBlockFeatureConfig(
            WeightedBlockStateProvider(
                DataPool.Builder<BlockState>()
                    .add(Blocks.AIR.defaultState, 50)
                    .add(RefinedMagicBlocks.enliumGrowth.defaultState, 10)
                    .add(RefinedMagicBlocks.enchantedFungus.defaultState, 5)
                    .add(RefinedMagicBlocks.hoopvine.defaultState, 5)
                    .build()
            )
        )
    )
    val enliumPatch = ConfiguredFeatureUtil.register(
        Mod.id("enlium_patch").toString(),
        Feature.VEGETATION_PATCH,
        VegetationPatchFeatureConfig(
            TagKey.of(Registry.BLOCK_KEY, Mod.id("enlium_replaceable")),
            BlockStateProvider.of(RefinedMagicBlocks.enlium),
            PlacedFeatureUtil.placedInline(enliumVegetation),
            VerticalSurfaceType.FLOOR,
            ConstantIntProvider.create(1),
            0.0f,
            5,
            0.8f,
            UniformIntProvider.create(4, 7),
            0.3f
        )
    )
    val enliumBase = ConfiguredFeatureUtil.register(
        Mod.id("enlium_base").toString(),
        Feature.VEGETATION_PATCH,
        VegetationPatchFeatureConfig(
            TagKey.of(Registry.BLOCK_KEY, Mod.id("enlium_base")),
            BlockStateProvider.of(RefinedMagicBlocks.enlium),
            PlacedFeatureUtil.placedInline(enliumVegetation),
            VerticalSurfaceType.FLOOR,
            ConstantIntProvider.create(1),
            0.0f,
            5,
            0.8f,
            UniformIntProvider.create(4, 7),
            0.3f
        )
    )
    val enliumPatchPlaced = PlacedFeatureUtil.register(
        Mod.id("enlium_patch_placed").toString(),
        enliumBase,
        CountOnEveryLayerPlacementModifier.create(8),
        PlacedFeatureUtil.OCEAN_FLOOR_HEIGHTMAP
    )

    private fun createBaseEndBiome(builder: GenerationSettings.Builder): Biome {
        val spawnSettings = SpawnSettings.Builder()
        DefaultBiomeFeatures.addEndMobs(spawnSettings)
        return Biome.Builder()
            .precipitation(Biome.Precipitation.NONE)
            .category(Biome.Category.THEEND)
            .temperature(0.5f)
            .downfall(0.5f)
            .effects(
                BiomeEffects.Builder()
                    .waterColor(4159204)
                    .waterFogColor(329011)
                    .fogColor(10518688).skyColor(0)
                    .moodSound(BiomeMoodSound.CAVE)
                    .build()
            )
            .spawnSettings(spawnSettings.build())
            .generationSettings(builder.build())
            .build()
    }

    fun createMushroomIsles(): Biome {
        val builder = GenerationSettings.Builder()
            .feature(GenerationStep.Feature.SURFACE_STRUCTURES, EndPlacedFeatures.END_GATEWAY_RETURN)
        return createBaseEndBiome(builder)
    }

    fun register() {
        BiomeModifications.addFeature(
            BiomeSelectors.foundInTheNether(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(
                Registry.PLACED_FEATURE_KEY,
                Mod.id("kyrite_ore_nether")
            )
        )
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(
                Registry.PLACED_FEATURE_KEY,
                Mod.id("kyrite_ore_overworld")
            )
        )
        BiomeModifications.addFeature(
            BiomeSelectors.foundInTheEnd(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(
                Registry.PLACED_FEATURE_KEY,
                Mod.id("kyrite_ore_end")
            )
        )
        BiomeModifications.addFeature(
            BiomeSelectors.foundInTheEnd(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(
                Registry.PLACED_FEATURE_KEY,
                Mod.id("opal_ore")
            )
        )
        BiomeModifications.addFeature(
            BiomeSelectors.foundInTheEnd(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(
                Registry.PLACED_FEATURE_KEY,
                Mod.id("rose_ore")
            )
        )
        BiomeModifications.addFeature(
            BiomeSelectors.foundInTheNether(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(
                Registry.PLACED_FEATURE_KEY,
                Mod.id("bismuth_ore_nether")
            )
        )
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(
                Registry.PLACED_FEATURE_KEY,
                Mod.id("bismuth_ore_overworld")
            )
        )
        BiomeModifications.addFeature(
            BiomeSelectors.foundInTheNether(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(
                Registry.PLACED_FEATURE_KEY,
                Mod.id("citrine_ore")
            )
        )
        BiomeModifications.addFeature(
            BiomeSelectors.foundInOverworld(),
            GenerationStep.Feature.UNDERGROUND_ORES,
            RegistryKey.of(
                Registry.PLACED_FEATURE_KEY,
                Mod.id("topaz_ore")
            )
        )
        Registry.register(BuiltinRegistries.BIOME, mushroomIsles.value, mushroomIslesBiome)
        TheEndBiomes.addHighlandsBiome(mushroomIsles, 5.0)
        BiomeModifications.addFeature(
            { a: BiomeSelectionContext? -> true }, GenerationStep.Feature.VEGETAL_DECORATION, RegistryKey.of(
                Registry.PLACED_FEATURE_KEY, Mod.id("enchanted_fungus_placed")
            )
        )
        BiomeModifications.addFeature(
            { a: BiomeSelectionContext? -> true }, GenerationStep.Feature.VEGETAL_DECORATION, RegistryKey.of(
                Registry.PLACED_FEATURE_KEY, Mod.id("enlium_patch_placed")
            )
        )
    }
}