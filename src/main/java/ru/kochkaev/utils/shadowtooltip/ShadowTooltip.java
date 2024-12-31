package ru.kochkaev.utils.shadowtooltip;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShadowTooltip implements ModInitializer {

    public static final Logger LOGGER = LogManager.getLogger("shadowtooltips");
    public static boolean isCarpetShadowInit = FabricLoader.getInstance().isModLoaded("carpet-shadow");
    public static boolean isClient = false;
    public static boolean isModWorks = false;
    @Override
    public void onInitialize() {
        if (!isCarpetShadowInit)
            ShadowTooltip.LOGGER.warn("You have the Carpet Shadow mod installed, Shadow Tooltips was disabled!");
//        if (!isClient)
//            LOGGER.warn("Shadow Tooltips is client-side mod only! It was disabled.");
    }
}
