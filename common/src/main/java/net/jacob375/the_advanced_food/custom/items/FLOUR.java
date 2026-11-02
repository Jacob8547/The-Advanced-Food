package net.jacob375.the_advanced_food.custom.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class FLOUR extends Item {
    public FLOUR(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level world, LivingEntity entity) {
        ItemStack retval = super.finishUsingItem(itemStack, world, entity);

        entity.addEffect(new MobEffectInstance(MobEffects.HUNGER, 120));
        return retval;
    }
}
