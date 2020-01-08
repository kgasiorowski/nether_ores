package com.enhancedores.nether_ores.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.enhancedores.nether_ores.NetherOres;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

import java.io.File;

@Mod.EventBusSubscriber
public class Config {

    private static final ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec config;

    static
    {

        OregenConfig.init(builder);
        config = builder.build();

    }

    public static void loadConfig(ForgeConfigSpec config, String path){

        NetherOres.LOGGER.info("Creating configuration for nether ores: " + path);
        final CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        NetherOres.LOGGER.info("Build configuration for nether ores");
        file.load();
        config.setConfig(file);
        NetherOres.LOGGER.info("Loaded configuration for nether ores");

    }

}
