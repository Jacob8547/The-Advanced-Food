package net.jacob375.the_advanced_food.custom.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class CIDER extends Item {
    public CIDER(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        ItemStack retval = new ItemStack(Items.GLASS_BOTTLE);
        super.finishUsingItem(itemStack, level, livingEntity);

        if (itemStack.isEmpty()) {
            return retval;
        } else
            return itemStack;
    }
}
