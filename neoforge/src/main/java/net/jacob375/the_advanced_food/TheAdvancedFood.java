package net.jacob375.the_advanced_food;

import java.util.function.Supplier;

import net.jacob375.the_advanced_food.helpers.ModBlocksCommon;
import net.jacob375.the_advanced_food.neoforge.config.ModConfigScreen;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.neoforged.fml.ModContainer;

@Mod(Constants.MOD_ID)
public class TheAdvancedFood {
        public static final DeferredRegister.Blocks BLOCKS = DeferredRegister
                        .createBlocks(TheAdvancedFoodCommon.MOD_ID);
        public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TheAdvancedFoodCommon.MOD_ID);
        public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
                        .create(Registries.CREATIVE_MODE_TAB, TheAdvancedFoodCommon.MOD_ID);

        public static final DeferredHolder<Block, Block> PEANUT_BLOCK = BLOCKS.register("peanut_block",
                        () -> ModBlocksCommon.PEANUT_BLOCK);
        public static final DeferredHolder<Item, Item> PEANUT_BLOCK_ITEM = ITEMS.register("peanut_block",
                        () -> new BlockItem(ModBlocksCommon.PEANUT_BLOCK,
                                        new Item.Properties().useBlockDescriptionPrefix()));
        public static final Supplier<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("the_advanced_food_tab",
                        () -> TheAdvancedFoodCommon.CUSTOM_ITEM_GROUP);

        public TheAdvancedFood(IEventBus eventBus, ModContainer container) {
                TheAdvancedFoodCommon.commonInit();
                CREATIVE_MODE_TABS.register(eventBus);

                container.registerExtensionPoint(IConfigScreenFactory.class,
                                (IConfigScreenFactory) (modContainer, parent) -> ModConfigScreen.create(parent));
        }
}