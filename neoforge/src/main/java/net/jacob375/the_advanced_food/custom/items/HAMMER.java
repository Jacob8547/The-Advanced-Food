package net.jacob375.the_advanced_food.custom.items;

import org.jspecify.annotations.Nullable;

import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;

public class HAMMER extends BaseHammerItem {
    public HAMMER(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable ItemStackTemplate getCraftingRemainder(ItemInstance instance) {
        if (instance instanceof ItemStack stack) {
            return ItemStackTemplate.fromNonEmptyStack(calculateDamagedRemainder(stack));
        } else {
            return ItemStackTemplate.fromStack(ItemStack.EMPTY);
        }
    }
}