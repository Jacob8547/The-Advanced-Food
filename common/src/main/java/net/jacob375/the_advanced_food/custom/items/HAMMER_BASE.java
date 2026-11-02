package net.jacob375.the_advanced_food.custom.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class HAMMER_BASE extends Item {
    public HAMMER_BASE(Properties properties) {
        super(properties);
    }

    // Helper method shared by both platforms to calculate the damaged remainder
    protected ItemStack calculateDamagedRemainder(ItemStack stack) {
        int newDamage = stack.getDamageValue() + 1;
        if (newDamage >= stack.getMaxDamage()) {
            return ItemStack.EMPTY;
        }
        ItemStack remainder = stack.copy();
        remainder.setDamageValue(newDamage);
        return remainder;
    }
}