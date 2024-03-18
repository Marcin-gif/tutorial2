package net.martin.tutorialmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods  {
    public static final FoodProperties HABERFOOD = new FoodProperties.Builder().nutrition(4).fast()
            .saturationMod(0.2f).effect(()->new MobEffectInstance(MobEffects.MOVEMENT_SPEED,200),1.0f).build();
}
