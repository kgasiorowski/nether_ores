package com.enhancedores.nether_ores;

import com.enhancedores.nether_ores.config.Config;
import com.enhancedores.nether_ores.lists.BlockList;
import com.enhancedores.nether_ores.lists.ItemList;
import com.enhancedores.nether_ores.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("nether_ores")
public class NetherOres {

    public static final String MOD_ID = "nether_ores";
    public static final Logger LOGGER = LogManager.getLogger();

    public NetherOres() {
        // Register ourselves for server and other game events we are interested in
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, Config.config);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        Config.loadConfig(Config.config, FMLPaths.CONFIGDIR.get().resolve("nether_ores.toml").toString());

        MinecraftForge.EVENT_BUS.register(this);

    }

    private void setup(final FMLCommonSetupEvent event){

        OreGeneration.setupNetherOreGeneration();
        LOGGER.info("Setup method registered");

    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {

        @SubscribeEvent
        public static void registerItems(final RegistryEvent.Register<Item> event) {

            ItemList.nether_iron = new BlockItem(BlockList.nether_iron, new Item.Properties()
                    .group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.nether_iron.getRegistryName());
            ItemList.nether_coal = new BlockItem(BlockList.nether_coal, new Item.Properties()
                    .group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.nether_coal.getRegistryName());
            ItemList.nether_gold = new BlockItem(BlockList.nether_gold, new Item.Properties()
                    .group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.nether_gold.getRegistryName());
            ItemList.nether_diamond = new BlockItem(BlockList.nether_diamond, new Item.Properties()
                    .group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.nether_diamond.getRegistryName());
            ItemList.nether_redstone = new BlockItem(BlockList.nether_redstone, new Item.Properties()
                    .group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.nether_redstone.getRegistryName());
            ItemList.nether_emerald = new BlockItem(BlockList.nether_emerald, new Item.Properties()
                    .group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.nether_emerald.getRegistryName());
            ItemList.nether_lapis = new BlockItem(BlockList.nether_lapis, new Item.Properties()
                    .group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.nether_lapis.getRegistryName());

            event.getRegistry().registerAll(
                    ItemList.nether_iron,
                    ItemList.nether_coal,
                    ItemList.nether_gold,
                    ItemList.nether_diamond,
                    ItemList.nether_redstone,
                    ItemList.nether_emerald,
                    ItemList.nether_lapis
            );

            LOGGER.info("Nether ores items registered");

        }

        @SubscribeEvent
        public static void registerBlocks(final RegistryEvent.Register<Block> event) {

            BlockList.nether_iron = new Block(Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(3f)
                    ).setRegistryName(new ResourceLocation(MOD_ID, "nether_iron"));
            BlockList.nether_coal = new Block(Block.Properties.create(Material.ROCK)
                    .harvestLevel(0)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(3f)
                    ).setRegistryName(new ResourceLocation(MOD_ID, "nether_coal"));
            BlockList.nether_diamond = new Block(Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(3f)
                    ).setRegistryName(new ResourceLocation(MOD_ID, "nether_diamond"));
            BlockList.nether_gold = new Block(Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(3f)
                    ).setRegistryName(new ResourceLocation(MOD_ID, "nether_gold"));
            BlockList.nether_redstone = new Block(Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(3f)
                    ).setRegistryName(new ResourceLocation(MOD_ID, "nether_redstone"));
            BlockList.nether_emerald = new Block(Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(3f)
                    ).setRegistryName(new ResourceLocation(MOD_ID, "nether_emerald"));
            BlockList.nether_lapis = new Block(Block.Properties.create(Material.ROCK)
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
                    .hardnessAndResistance(3f)
                    ).setRegistryName(new ResourceLocation(MOD_ID, "nether_lapis"));

            event.getRegistry().registerAll(
                    BlockList.nether_iron,
                    BlockList.nether_coal,
                    BlockList.nether_diamond,
                    BlockList.nether_gold,
                    BlockList.nether_redstone,
                    BlockList.nether_emerald,
                    BlockList.nether_lapis
            );

            LOGGER.info("Nether ores blocks registered");

        }

    }

}
