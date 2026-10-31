package net.jacob375.the_advanced_food.helpers.extra;

import com.mojang.serialization.MapCodec;
import java.util.function.Supplier;
import net.jacob375.the_advanced_food.TheAdvancedFood;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModLootModifiers {

    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS =
            DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, TheAdvancedFood.MOD_ID);

    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> ADD_ITEM_WITH_CHANCE =
            LOOT_MODIFIERS.register("add_item_with_chance", () -> AddItemWithChanceModifier.CODEC);

    public static void register(IEventBus modEventBus) {
        LOOT_MODIFIERS.register(modEventBus);
    }
}