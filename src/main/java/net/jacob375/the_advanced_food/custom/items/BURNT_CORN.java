package net.jacob375.the_advanced_food.custom.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BURNT_CORN extends Item {
    public BURNT_CORN(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level world, LivingEntity entity) {
        ItemStack retval = super.finishUsingItem(itemStack, world, entity);

        entity.addEffect(new MobEffectInstance(MobEffects.POISON, 60));
        return retval;
    }
}
