package com.canismajor88.world;

import com.canismajor88.init.FeatureInit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

public class WorldGenCM {

    private static boolean biomeChecker(Biome biome,List<Biome> blackListedBiomes){
     for(int i=0;i<blackListedBiomes.size();i++)
     {
         if(biome== blackListedBiomes.get(i)){
             return false;
         }
     }
    return true;
    }


    private static void setupStructureGen(){
        List<Biome> blackListedBiomes =new ArrayList<Biome>();
        blackListedBiomes.add(Biomes.OCEAN);
        blackListedBiomes.add(Biomes.COLD_OCEAN);
        blackListedBiomes.add(Biomes.DEEP_COLD_OCEAN);
        blackListedBiomes.add(Biomes.DEEP_FROZEN_OCEAN);
        blackListedBiomes.add(Biomes.DEEP_LUKEWARM_OCEAN);
        blackListedBiomes.add(Biomes.END_BARRENS);
        blackListedBiomes.add(Biomes.END_HIGHLANDS);
        blackListedBiomes.add(Biomes.END_MIDLANDS);
        blackListedBiomes.add(Biomes.SMALL_END_ISLANDS);
        blackListedBiomes.add(Biomes.THE_END);
        blackListedBiomes.add(Biomes.FROZEN_OCEAN);
        blackListedBiomes.add(Biomes.NETHER);
        blackListedBiomes.add(Biomes.WARM_OCEAN);

        for (Biome biome : ForgeRegistries.BIOMES){
                if(biomeChecker(biome,blackListedBiomes)){
                    biome.addStructure(FeatureInit.WARP_STONE_METEOR.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
                    biome.addFeature(GenerationStage.Decoration.SURFACE_STRUCTURES, FeatureInit.WARP_STONE_METEOR.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG)
                            .withPlacement(Placement.NOPE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG)));
                }

        }


    }
    public static void generate(){
        setupStructureGen();
    }
}
