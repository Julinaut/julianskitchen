package net.juhewe.julianskitchen.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class SoftLandingEffect extends StatusEffect {

    public SoftLandingEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {

        if(!entity.isOnGround()){
            entity.fallDistance = 0D;
        }

        //if (entity.getVelocity().getY() > (double)-0.1F && entity.fallDistance > (double)0.1F) {
        //    entity.fallDistance = (double)0.1F;
        //}

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
