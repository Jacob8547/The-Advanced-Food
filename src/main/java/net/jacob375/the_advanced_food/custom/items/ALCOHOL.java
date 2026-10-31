package net.jacob375.the_advanced_food.custom.items;

import net.minecraft.world.item.Items;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ALCOHOL extends Item {
    public ALCOHOL(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity user) {
        super.finishUsingItem(stack, level, user);

        return stack.isEmpty() ? new ItemStack(Items.GLASS_BOTTLE) : stack;
    }
}
