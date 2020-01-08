package com.enhancedores.nether_ores.world;

import com.enhancedores.nether_ores.config.OregenConfig;
import com.enhancedores.nether_ores.lists.BlockList;
import javafx.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.HashMap;
import java.util.Map;

public class OreGeneration {

    public static void setupNetherOreGeneration(){

        final int bottomOffset = 0;
        final int topOffset = 0;
        final int maximum = 255;

        HashMap<Block, Pair<Integer, Integer>> nether_block_map = new HashMap<>();

        nether_block_map.put(BlockList.nether_iron, new Pair<>(OregenConfig.iron_per_chunk.get(), OregenConfig.iron_per_vein.get()));
        nether_block_map.put(BlockList.nether_coal, new Pair<>(OregenConfig.coal_per_chunk.get(), OregenConfig.coal_per_vein.get()));
        nether_block_map.put(BlockList.nether_diamond, new Pair<>(OregenConfig.diamond_per_chunk.get(), OregenConfig.diamond_per_vein.get()));
        nether_block_map.put(BlockList.nether_emerald, new Pair<>(OregenConfig.emerald_per_chunk.get(), OregenConfig.emerald_per_vein.get()));
        nether_block_map.put(BlockList.nether_gold, new Pair<>(OregenConfig.gold_per_chunk.get(), OregenConfig.gold_per_vein.get()));
        nether_block_map.put(BlockList.nether_lapis, new Pair<>(OregenConfig.lapis_per_chunk.get(), OregenConfig.lapis_per_vein.get()));
        nether_block_map.put(BlockList.nether_redstone, new Pair<>(OregenConfig.redstone_per_chunk.get(), OregenConfig.redstone_per_vein.get()));

        for(Map.Entry<Block, Pair<Integer, Integer>> entry : nether_block_map.entrySet()){

            Block nether_block = entry.getKey();
            int count_per_chunk = entry.getValue().getKey();
            int count_per_vein = entry.getValue().getValue();

            // Don't ask.
            Biomes.NETHER.addFeature(
                GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.func_225566_b_(
                    new OreFeatureConfig(
                        OreFeatureConfig.FillerBlockType.NETHERRACK,
                        nether_block.getDefaultState(),
                        count_per_vein
                    )
                ).func_227228_a_(
                    Placement.COUNT_RANGE.func_227446_a_(
                        new CountRangeConfig(
                            count_per_chunk,
                            bottomOffset,
                            topOffset,
                            maximum
                        )
                    )
                )

            );

        }

    }

}
