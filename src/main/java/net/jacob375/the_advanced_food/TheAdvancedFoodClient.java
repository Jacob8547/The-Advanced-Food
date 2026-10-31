package net.jacob375.the_advanced_food;

import net.jacob375.the_advanced_food.config.ModConfigScreen;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = TheAdvancedFood.MOD_ID, dist = Dist.CLIENT)
public class TheAdvancedFoodClient {

    public TheAdvancedFoodClient(ModContainer container) {
        boolean cloth = ModList.get().isLoaded("cloth_config");
        TheAdvancedFood.LOGGER.info("Client entry running, cloth_config loaded: {}", cloth);

        if (cloth) {
            container.registerExtensionPoint(IConfigScreenFactory.class,
                    (modContainer, parent) -> ModConfigScreen.create(parent));
        }
    }
}