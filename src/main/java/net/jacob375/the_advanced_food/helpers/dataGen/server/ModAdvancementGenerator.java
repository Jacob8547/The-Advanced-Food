package net.jacob375.the_advanced_food.helpers.dataGen.server;

import net.jacob375.the_advanced_food.TheAdvancedFood;
import net.jacob375.the_advanced_food.helpers.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.triggers.ConsumeItemTrigger;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.advancements.triggers.PlayerTrigger;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModAdvancementGenerator extends AdvancementSubProvider {

        public ModAdvancementGenerator(BootstrapContext<Advancement> output) {
                super(output);
        }

        private static Identifier id(String name) {
                return Identifier.fromNamespaceAndPath(TheAdvancedFood.MOD_ID, name);
        }

        @Override
        public void generate() {
                Identifier root = id("the_advanced_food");
                Advancement.Builder.advancement().rootDisplay(
                                ModItems.BACON.get(),
                                Component.literal("The Advanced Food"),
                                Component.literal("Welcome to The Advanced Food!"),
                                id("screens/advancement_background"),
                                AdvancementType.TASK, true, true, true)
                                .addCriterion("the_advanced_food", PlayerTrigger.TriggerInstance.tick())
                                .save(this.output, root);

                Identifier acquireCorn = obtain("acquire_corn", root, ModItems.CORN,
                                "Corn Acquired", "Find corn on your adventure!", AdvancementType.GOAL, false);
                obtain("popcorn_crafted", acquireCorn, ModItems.POPCORN,
                                "The Buttery Stuff", "Make some popcorn!", AdvancementType.TASK, false);
                consume("burnt_corn_consumed", acquireCorn, ModItems.BURNT_CORN,
                                "Tastes like Rubber", "Consume burnt corn!", AdvancementType.TASK, false);
                obtain("chicken_nugget", root, ModItems.CHICKEN_NUGGET,
                                "Dino Nuggy?", "Find a chicken nugget!", AdvancementType.CHALLENGE, true);
                obtain("pizza_crafted", root, ModItems.PIZZA,
                                "Pizza Pizza Daddy-O", "Make a pizza!", AdvancementType.GOAL, false);
                Identifier hammer = obtain("hammer_crafted", root, ModItems.HAMMER,
                                "Digging Tool?", "Craft a normal-looking hammer!", AdvancementType.TASK, false);
                consume("flour_consumed", hammer, ModItems.FLOUR,
                                "Cough Cough", "Forget that flour is dry!", AdvancementType.GOAL, false);
                consume("cooking_oil_consumed", hammer, ModItems.COOKING_OIL,
                                "This Tastes Bad", "Drink cooking oil!", AdvancementType.TASK, false);
                consume("taco_consumed", hammer, ModItems.TACO,
                                "Supreme?", "Eat a taco!", AdvancementType.GOAL, false);
                consume("lettuce_consumed", root, ModItems.LETTUCE,
                                "Lettuce Feast!", "Consume some lettuce!", AdvancementType.TASK, false);
        }

        private Identifier obtain(String name, Identifier parent, DeferredItem<Item> item,
                        String title, String description, AdvancementType type, boolean hidden) {
                Identifier id = id(name);
                Advancement.Builder.advancement()
                                .parent(parent)
                                .display(item.get(), Component.literal(title), Component.literal(description), type,
                                                true, true, hidden)
                                .addCriterion(name, InventoryChangeTrigger.TriggerInstance.hasItems(item.get()))
                                .save(this.output, id);
                return id;
        }

        private Identifier consume(String name, Identifier parent, DeferredItem<Item> item,
                        String title, String description, AdvancementType type, boolean hidden) {
                Identifier id = id(name);
                Advancement.Builder.advancement()
                                .parent(parent)
                                .display(item.get(), Component.literal(title), Component.literal(description), type,
                                                true, true, hidden)
                                .addCriterion(name, ConsumeItemTrigger.TriggerInstance.usedItem(
                                                this.output.lookup(Registries.ITEM), item.get()))
                                .save(this.output, id);
                return id;
        }
}