package net.jacob375.the_advanced_food;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModContainer;

@Mod(TheAdvancedFood.MODID)
public class TheAdvancedFood {
    public static final String MODID = "theadvancedfood";
    public static final Logger LOGGER = LogUtils.getLogger();

    public TheAdvancedFood(IEventBus modEventBus, ModContainer modContainer) {
    }
}
