package net.jacob375.the_advanced_food.helpers.dataGen;

import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jacob375.the_advanced_food.helpers.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;

public class ModRecipeProvider extends FabricRecipeProvider {
	public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected RecipeProvider createRecipeProvider(Provider registries, BootstrapContext<Recipe<?>> recipes,
			BootstrapContext<Advancement> advancements) {
		return new RecipeProvider(recipes, advancements) {
			@Override
			public void buildRecipes() {
				// HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);

				shapeless(RecipeCategory.FOOD, ModItems.ALCOHOL)
						.requires(ModItems.CIDER)
						.requires(Items.SUGAR)
						.requires(Items.WHEAT)
						.unlockedBy(getHasName(ModItems.CIDER), has(ModItems.CIDER))
						.save(output);

				shapeless(RecipeCategory.FOOD, ModItems.CHEESE)
						.requires(ModItems.CREAM)
						.requires(Items.MILK_BUCKET)
						.unlockedBy(getHasName(ModItems.CREAM), has(ModItems.CREAM))
						.save(output);

				shapeless(RecipeCategory.FOOD, ModItems.CIDER)
						.requires(ModItems.HAMMER)
						.requires(Items.APPLE)
						.requires(Items.GLASS_BOTTLE)
						.unlockedBy(getHasName(ModItems.HAMMER), has(ModItems.HAMMER))
						.save(output);

				shapeless(RecipeCategory.FOOD, ModItems.DONUT)
						.requires(ModItems.CREAM)
						.requires(Items.BREAD)
						.requires(Items.COCOA_BEANS)
						.unlockedBy(getHasName(ModItems.CREAM), has(ModItems.CREAM))
						.save(output);

				shapeless(RecipeCategory.FOOD, ModItems.FLOUR)
						.requires(ModItems.HAMMER)
						.requires(Items.WHEAT)
						.unlockedBy(getHasName(ModItems.HAMMER), has(ModItems.HAMMER))
						.save(output);

				shapeless(RecipeCategory.FOOD, ModItems.LETTUCE)
						.requires(ItemTags.LEAVES)
						.requires(Items.POTION)
						.unlockedBy(getHasName(Items.POTION), has(Items.POTION))
						.save(output);

				shapeless(RecipeCategory.FOOD, ModItems.PIZZA)
						.requires(ModItems.CHEESE)
						.requires(Items.COOKED_PORKCHOP)
						.requires(Items.BREAD)
						.requires(ModItems.TOMATO)
						.unlockedBy(getHasName(ModItems.CHEESE), has(ModItems.CHEESE))
						.save(output);

				shapeless(RecipeCategory.FOOD, ModItems.CHICKEN_NUGGET)
						.requires(ModItems.COOKING_OIL)
						.requires(Items.CHICKEN)
						.requires(ModItems.FLOUR)
						.unlockedBy(getHasName(Items.CHICKEN), has(Items.CHICKEN))
						.save(output, "chicken_nugget_from_raw");

				shapeless(RecipeCategory.FOOD, ModItems.CHICKEN_NUGGET)
						.requires(ModItems.COOKING_OIL)
						.requires(Items.COOKED_CHICKEN)
						.requires(ModItems.FLOUR)
						.unlockedBy(getHasName(Items.CHICKEN), has(Items.CHICKEN))
						.save(output, "chicken_nugget_from_cooked");

				shapeless(RecipeCategory.FOOD, ModItems.COOKING_OIL)
						.requires(ModItems.HAMMER)
						.requires(ModItems.PEANUT)
						.unlockedBy(getHasName(ModItems.PEANUT), has(ModItems.PEANUT))
						.save(output);

				shapeless(RecipeCategory.FOOD, ModItems.CORN_SEEDS, 2)
						.requires(ModItems.CORN)
						.unlockedBy(getHasName(ModItems.CORN), has(ModItems.CORN))
						.save(output);

				shapeless(RecipeCategory.FOOD, ModItems.CREAM)
						.requires(Items.MILK_BUCKET)
						.requires(Items.MILK_BUCKET)
						.unlockedBy(getHasName(Items.MILK_BUCKET), has(Items.MILK_BUCKET))
						.save(output);

				shapeless(RecipeCategory.FOOD, ModItems.SUSHI)
						.requires(Items.DRIED_KELP)
						.requires(Items.DRIED_KELP)
						.requires(Items.COD)
						.unlockedBy(getHasName(Items.DRIED_KELP), has(Items.DRIED_KELP))
						.save(output);

				shapeless(RecipeCategory.FOOD, ModItems.TACO)
						.requires(ModItems.LETTUCE)
						.requires(ModItems.CHEESE)
						.requires(Items.COOKED_BEEF)
						.requires(ModItems.TACO_SHELL)
						.unlockedBy(getHasName(ModItems.TACO_SHELL), has(ModItems.TACO_SHELL))
						.save(output);

				shapeless(RecipeCategory.FOOD, ModItems.TACO_SHELL, 3)
						.requires(ModItems.COOKING_OIL)
						.requires(ModItems.FLOUR)
						.requires(ModItems.CORN)
						.unlockedBy(getHasName(ModItems.CORN), has(ModItems.CORN))
						.save(output);

				shapeless(RecipeCategory.FOOD, ModItems.FRENCH_FRIES)
						.requires(Items.POTATO)
						.requires(ModItems.COOKING_OIL)
						.unlockedBy(getHasName(Items.POTATO), has(Items.POTATO))
						.save(output);

				shaped(RecipeCategory.FOOD, ModItems.EMPTY_POPCORN_BUCKET)
						.pattern("A A")
						.pattern("A A")
						.pattern("AAA")
						.define('A', Items.PAPER)
						.unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
						.save(output);

				shaped(RecipeCategory.FOOD, ModItems.GOLDEN_POTATO)
						.pattern("000")
						.pattern("040")
						.pattern("000")
						.define('0', Items.GOLD_INGOT)
						.define('4', Items.POTATO)
						.unlockedBy(getHasName(Items.POTATO), has(Items.POTATO))
						.save(output);

				shaped(RecipeCategory.FOOD, ModItems.HAMMER)
						.pattern("000")
						.pattern(" 10")
						.pattern(" 1 ")
						.define('0', Items.COBBLESTONE)
						.define('1', Items.STICK)
						.unlockedBy(getHasName(Items.COBBLESTONE), has(Items.COBBLESTONE))
						.save(output);

				shaped(RecipeCategory.FOOD, ModItems.PANCAKE, 6)
						.pattern("MMM")
						.pattern("SES")
						.pattern("FFF")
						.define('M', Items.MILK_BUCKET)
						.define('S', Items.SUGAR)
						.define('E', ItemTags.EGGS)
						.define('F', ModItems.FLOUR)
						.unlockedBy(getHasName(Items.SUGAR), has(Items.SUGAR))
						.save(output);

				shaped(RecipeCategory.FOOD, ModItems.POPCORN)
						.pattern("0")
						.pattern("1")
						.define('0', ModItems.POPPED_CORN)
						.define('1', ModItems.EMPTY_POPCORN_BUCKET)
						.unlockedBy(getHasName(ModItems.POPPED_CORN), has(ModItems.POPPED_CORN))
						.save(output);

				SimpleCookingRecipeBuilder
						.smelting(Ingredient.of(Items.COOKED_PORKCHOP), RecipeCategory.FOOD, CookingBookCategory.FOOD,
								ModItems.BACON, 1.0F, 200)
						.unlockedBy(getHasName(Items.COOKED_PORKCHOP), has(Items.COOKED_PORKCHOP))
						.save(output, "bacon_from_smelting");

				SimpleCookingRecipeBuilder
						.smoking(Ingredient.of(Items.COOKED_PORKCHOP), RecipeCategory.FOOD, ModItems.BACON, 1.0F, 200)
						.unlockedBy(getHasName(Items.COOKED_PORKCHOP), has(Items.COOKED_PORKCHOP))
						.save(output, "bacon_from_smoking");

				SimpleCookingRecipeBuilder
						.campfireCooking(Ingredient.of(Items.COOKED_PORKCHOP), RecipeCategory.FOOD, ModItems.BACON,
								1.0F, 600)
						.unlockedBy(getHasName(Items.COOKED_PORKCHOP), has(Items.COOKED_PORKCHOP))
						.save(output, "bacon_from_campfire_cooking");

				SimpleCookingRecipeBuilder
						.smelting(Ingredient.of(ModItems.POPPED_CORN), RecipeCategory.FOOD, CookingBookCategory.FOOD,
								ModItems.BURNT_CORN, 1.0F, 200)
						.unlockedBy(getHasName(ModItems.POPPED_CORN), has(ModItems.POPPED_CORN))
						.save(output, "burnt_corn_from_smelting");

				SimpleCookingRecipeBuilder
						.smoking(Ingredient.of(ModItems.POPPED_CORN), RecipeCategory.FOOD, ModItems.BURNT_CORN, 1.0F,
								200)
						.unlockedBy(getHasName(ModItems.POPPED_CORN), has(ModItems.POPPED_CORN))
						.save(output, "burnt_corn_from_smoking");

				SimpleCookingRecipeBuilder
						.campfireCooking(Ingredient.of(ModItems.POPPED_CORN), RecipeCategory.FOOD, ModItems.BURNT_CORN,
								1.0F, 600)
						.unlockedBy(getHasName(ModItems.POPPED_CORN), has(ModItems.POPPED_CORN))
						.save(output, "burnt_corn_from_campfire_cooking");

				SimpleCookingRecipeBuilder
						.smelting(Ingredient.of(ModItems.CORN), RecipeCategory.FOOD, CookingBookCategory.FOOD,
								ModItems.POPPED_CORN, 1.0F, 200)
						.unlockedBy(getHasName(ModItems.CORN), has(ModItems.CORN))
						.save(output, "popped_corn_from_smelting");

				SimpleCookingRecipeBuilder
						.smoking(Ingredient.of(ModItems.CORN), RecipeCategory.FOOD, ModItems.POPPED_CORN, 1.0F,
								200)
						.unlockedBy(getHasName(ModItems.CORN), has(ModItems.CORN))
						.save(output, "popped_corn_from_smoking");

				SimpleCookingRecipeBuilder
						.campfireCooking(Ingredient.of(ModItems.CORN), RecipeCategory.FOOD, ModItems.POPPED_CORN,
								1.0F, 600)
						.unlockedBy(getHasName(ModItems.CORN), has(ModItems.CORN))
						.save(output, "popped_corn_from_campfire_cooking");
			}
		};
	}
}
