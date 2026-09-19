package net.jacob375.the_advanced_food.custom.items;

import net.jacob375.the_advanced_food.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class POPCORN extends Item {
    public POPCORN(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        ItemStack retval = new ItemStack(ModItems.EMPTY_POPCORN_BUCKET);
        super.finishUsingItem(itemStack, level, livingEntity);

        if (itemStack.isEmpty()) {
            return retval;
        } else
            return itemStack;
    }
}
