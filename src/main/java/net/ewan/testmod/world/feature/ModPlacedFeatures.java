package net.ewan.testmod.world.feature;

import net.ewan.testmod.testmod;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {

    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, testmod.MOD_ID);


    public static final RegistryObject<PlacedFeature> TIN_ORE_PLACED = PLACED_FEATURES.register("tin_ore",
            () -> new PlacedFeature(ModConfiguresFeatures.TIN_ORE.getHolder().get(),
                    commonOrePlacement(11,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-20), VerticalAnchor.absolute(60)))));

    public static final RegistryObject<PlacedFeature> ALUMINUM_ORE_PLACED = PLACED_FEATURES.register("aluminum_ore",
            () -> new PlacedFeature(ModConfiguresFeatures.ALUMINUM_ORE.getHolder().get(),
                    commonOrePlacement(12,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-80), VerticalAnchor.absolute(50)))));

    public static final RegistryObject<PlacedFeature> SILICON_ORE_PLACED = PLACED_FEATURES.register("silicon_ore",
            () -> new PlacedFeature(ModConfiguresFeatures.SILICON_ORE.getHolder().get(),
                    commonOrePlacement(15,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(80)))));



    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    public static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }





    public static void register(IEventBus eventBus) {
        PLACED_FEATURES.register(eventBus);
    }

}
