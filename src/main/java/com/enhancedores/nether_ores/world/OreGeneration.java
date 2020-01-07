package com.enhancedores.nether_ores.world;

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

        nether_block_map.put(BlockList.nether_iron, new Pair<>(20, 9));
        nether_block_map.put(BlockList.nether_coal, new Pair<>(15, 17));
        nether_block_map.put(BlockList.nether_diamond, new Pair<>(3, 8));
        nether_block_map.put(BlockList.nether_emerald, new Pair<>(2, 1));
        nether_block_map.put(BlockList.nether_gold, new Pair<>(10, 9));
        nether_block_map.put(BlockList.nether_lapis, new Pair<>(1, 7));
        nether_block_map.put(BlockList.nether_redstone, new Pair<>(8, 8));

        for(Map.Entry<Block, Pair<Integer, Integer>> entry : nether_block_map.entrySet()){

            Block nether_block = entry.getKey();
            int count_per_chunk = entry.getValue().getKey();
            int count_per_vein = entry.getValue().getValue();

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
