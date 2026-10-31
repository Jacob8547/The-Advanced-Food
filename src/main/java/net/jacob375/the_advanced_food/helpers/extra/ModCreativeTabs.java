package net.jacob375.the_advanced_food.helpers.extra;

import net.jacob375.the_advanced_food.TheAdvancedFood;
import net.jacob375.the_advanced_food.helpers.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TheAdvancedFood.MOD_ID);

    public static final ResourceKey<CreativeModeTab> CUSTOM_ITEM_GROUP_KEY = ResourceKey.create(
            Registries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, "the_advanced_food_tab"));

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CUSTOM_ITEM_GROUP =
            CREATIVE_TABS.register("the_advanced_food_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable("The Advanced Food Tab"))
                    .icon(() -> ModItems.PIZZA.toStack())
                    .build());

    public static void register(IEventBus modEventBus) {
        CREATIVE_TABS.register(modEventBus);
    }
}