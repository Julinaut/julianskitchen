package net.juhewe.julianskitchen.effect;


import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

import java.util.Random;

public class SaturationEffect extends MobEffect {

    public SaturationEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    private static final Random random = new Random();

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {

        if (entity instanceof Player player) {
            if(random.nextInt((int)level.tickRateManager().tickrate()) <= amplifier){
                player.getFoodData().eat(1, 1.0F);
            }
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
