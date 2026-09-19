package net.jacob375.the_advanced_food.custom.items;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class GOLDEN_POTATO extends Item {
    public GOLDEN_POTATO(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
        ItemStack retval = super.finishUsingItem(itemstack, world, entity);
        entity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1));
        entity.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 2400, 1));
        entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 1200, 0));
        entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1200, 0));
        entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 300, 0));
        entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 1200, 0));

        return retval;
    }
}
