package ru.kochkaev.utils.shadowtooltip.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import ru.kochkaev.utils.shadowtooltip.ShadowNBTData;
import ru.kochkaev.utils.shadowtooltip.ShadowTooltip;

public class ShadowTooltipClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ShadowTooltip.isClient = true;
        var isModWorks = !ShadowTooltip.isCarpetShadowInit;
        if (isModWorks) {
            new ShadowNBTData();
            ShadowTooltip.LOGGER.info("Enjoy with ShadowTooltips!");
        }
        ShadowTooltip.isModWorks = isModWorks;
    }
}
