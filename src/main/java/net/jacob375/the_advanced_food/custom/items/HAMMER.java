package net.jacob375.the_advanced_food.custom.items;

import org.jspecify.annotations.Nullable;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;

public class HAMMER extends Item {
    public HAMMER(Properties properties) {
        super(properties);
    }

    @Override
    public @Nullable ItemStackTemplate getCraftingRemainder(ItemStack stack) {
        int newDamage = stack.getDamageValue() + 1;
        if (newDamage >= stack.getMaxDamage()) {
            return null;
        }
        ItemStack remainder = stack.copy();
        remainder.setDamageValue(newDamage);
        return ItemStackTemplate.fromNonEmptyStack(remainder);
    }
}
