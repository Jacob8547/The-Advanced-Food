package net.jacob375.the_advanced_food.helpers.dataGen.server;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.jacob375.the_advanced_food.TheAdvancedFood;
import net.jacob375.the_advanced_food.helpers.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.triggers.ConsumeItemTrigger;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.advancements.triggers.PlayerTrigger;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

public class ModAdvancementProvider extends FabricAdvancementProvider {

    public ModAdvancementProvider(FabricPackOutput output, CompletableFuture<Provider> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(Provider registryLookup, Consumer<AdvancementHolder> consumer) {
        AdvancementHolder theAdvancedFood = Advancement.Builder.advancement().rootDisplay(
                ModItems.BACON,
                Component.literal("The Advanced Food"),
                Component.literal("Welcome to The Advanced Food!"),
                Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, "screens/advancement_background"),
                AdvancementType.TASK,
                true,
                true,
                true).addCriterion("the_advanced_food", PlayerTrigger.TriggerInstance.tick())
                .save(consumer, Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, "the_advanced_food"));

        AdvancementHolder acquireCorn = obtainHandler(consumer, theAdvancedFood, "acquire_corn", ModItems.CORN,
                "Corn Acquired", "Find corn on your adventure!", AdvancementType.GOAL, false);

        AdvancementHolder popcornCrafted = obtainHandler(consumer, acquireCorn, "popcorn_crafted", ModItems.POPCORN,
                "The Buttery Stuff", "Make some popcorn!", AdvancementType.TASK, false);

        AdvancementHolder burntCornConsumed = consumeHandler(consumer, acquireCorn, "burnt_corn_consumed",
                registryLookup, ModItems.BURNT_CORN, "Tastes like Rubber", "Consume burnt corn!", AdvancementType.TASK,
                false);

        AdvancementHolder chickenNugget = obtainHandler(consumer, theAdvancedFood, "chicken_nugget",
                ModItems.CHICKEN_NUGGET, "Dino Nuggy?", "Find a chicken nugget!", AdvancementType.CHALLENGE, true);

        AdvancementHolder pizzaCrafted = obtainHandler(consumer, theAdvancedFood, "pizza_crafted", ModItems.PIZZA,
                "Pizza Pizza Daddy-O", "Make a pizza!", AdvancementType.GOAL, false);

        AdvancementHolder hammerCrafted = obtainHandler(consumer, theAdvancedFood, "hammer_crafted", ModItems.HAMMER,
                "Digging Tool?", "Craft a normal-looking hammer!", AdvancementType.TASK, false);

        AdvancementHolder flourConsumed = consumeHandler(consumer, hammerCrafted, "flour_consumed", registryLookup,
                ModItems.FLOUR, "Cough Cough", "Forget that flour is dry!", AdvancementType.GOAL, false);

        AdvancementHolder cookingOilConsumed = consumeHandler(consumer, hammerCrafted, "cooking_oil_consumed",
                registryLookup, ModItems.COOKING_OIL, "This Tastes Bad", "Drink cooking oil!", AdvancementType.TASK,
                false);

        AdvancementHolder tacoConsumed = consumeHandler(consumer, hammerCrafted, "taco_consumed", registryLookup,
                ModItems.TACO, "Supreme?", "Eat a taco!", AdvancementType.GOAL, false);

        AdvancementHolder lettuceConsumed = consumeHandler(consumer, theAdvancedFood, "lettuce_consumed",
                registryLookup, ModItems.LETTUCE, "Lettuce Feast!", "Consume some lettuce!", AdvancementType.TASK,
                false);
    }

    private static AdvancementHolder obtainHandler(Consumer<AdvancementHolder> consumer, AdvancementHolder parent,
            String name, Item item, String title, String description,
            AdvancementType type, boolean hidden) {
        return Advancement.Builder.advancement()
                .parent(parent)
                .display(item, Component.literal(title), Component.literal(description), type, true, true, hidden)
                .addCriterion(name, InventoryChangeTrigger.TriggerInstance.hasItems(item))
                .save(consumer, Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, name));
    }

    private static AdvancementHolder consumeHandler(Consumer<AdvancementHolder> consumer, AdvancementHolder parent,
            String name, Provider registryLookup, Item item, String title, String description,
            AdvancementType type, boolean hidden) {
        HolderGetter<Item> items = registryLookup.lookupOrThrow(Registries.ITEM);

        return Advancement.Builder.advancement()
                .parent(parent)
                .display(item, Component.literal(title), Component.literal(description), type, true, true, hidden)
                .addCriterion(name, ConsumeItemTrigger.TriggerInstance.usedItem(items, item))
                .save(consumer, Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, name));
    }
}
