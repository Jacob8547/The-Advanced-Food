package net.jacob375.the_advanced_food.custom.items;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;

public class HAMMER extends HAMMER_BASE {
    public HAMMER(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStackTemplate getCraftingRemainder(ItemStack stack) {
        return ItemStackTemplate.fromNonEmptyStack(calculateDamagedRemainder(stack));
    }
}