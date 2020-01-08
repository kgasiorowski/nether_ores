package com.enhancedores.nether_ores.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class OregenConfig {

    public static ForgeConfigSpec.IntValue iron_per_chunk;
    public static ForgeConfigSpec.IntValue iron_per_vein;

    public static ForgeConfigSpec.IntValue coal_per_chunk;
    public static ForgeConfigSpec.IntValue coal_per_vein;

    public static ForgeConfigSpec.IntValue gold_per_chunk;
    public static ForgeConfigSpec.IntValue gold_per_vein;

    public static ForgeConfigSpec.IntValue diamond_per_chunk;
    public static ForgeConfigSpec.IntValue diamond_per_vein;

    public static ForgeConfigSpec.IntValue emerald_per_chunk;
    public static ForgeConfigSpec.IntValue emerald_per_vein;

    public static ForgeConfigSpec.IntValue lapis_per_chunk;
    public static ForgeConfigSpec.IntValue lapis_per_vein;

    public static ForgeConfigSpec.IntValue redstone_per_chunk;
    public static ForgeConfigSpec.IntValue redstone_per_vein;

    public static void init(ForgeConfigSpec.Builder server){

        server.comment("Nether ore generation Config");

        iron_per_chunk = server
                .comment("Number of iron veins per chunk")
                .defineInRange("nether_ores.iron_per_chunk", 20, 0, 1000);

        iron_per_vein = server
                .comment("Number of iron ores per vein")
                .defineInRange("nether_ores.iron_per_vein", 9, 0, 1000);

        coal_per_chunk = server
                .comment("Number or coal veins per chunk")
                .defineInRange("nether_ores.coal_per_chunk", 15, 0, 1000);

        coal_per_vein = server
                .comment("Number of coal ores per vein")
                .defineInRange("nether_ores.coal_per_vein", 17, 0, 1000);

        gold_per_chunk = server
                .comment("Number of gold veins per chunk")
                .defineInRange("nether_ores.gold_per_chunk", 10, 0, 1000);

        gold_per_vein = server
                .comment("Number of gold ores per vein")
                .defineInRange("nether_ores.gold_per_vein", 9, 0, 1000);

        diamond_per_chunk = server
                .comment("Number of diamond veins per chunk")
                .defineInRange("nether_ores.diamond_per_chunk", 3, 0, 1000);

        diamond_per_vein = server
                .comment("Number of diamond ores per vein")
                .defineInRange("nether_ores.diamond_per_vein", 8, 0, 1000);

        emerald_per_chunk = server
                .comment("Number of emerald veins per chunk")
                .defineInRange("nether_ores.emerald_per_chunk", 2, 0,1000);

        emerald_per_vein = server
                .comment("Number of emerald ores per vein")
                .defineInRange("nether_ores.emerald_per_vein", 1, 0, 1000);

        redstone_per_chunk = server
                .comment("Number of redstone veins per chunk")
                .defineInRange("nether_ores.redstone_per_chunk", 8, 0, 1000);

        redstone_per_vein = server
                .comment("Number of redstone ores per vein")
                .defineInRange("nether_ores.redstone_per_vein", 8, 0, 1000);

        lapis_per_chunk = server
                .comment("Number of lapis veins per chunk")
                .defineInRange("nether_ores.lapis_per_chunk", 1, 0, 1000);

        lapis_per_vein = server
                .comment("Number of lapis ores per vein")
                .defineInRange("nether_ores.lapis_per_vein", 8, 0, 1000);

    }

}
