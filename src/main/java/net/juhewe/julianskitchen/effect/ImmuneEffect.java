package net.juhewe.julianskitchen.effect;


import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

public class ImmuneEffect extends MobEffect {

    public ImmuneEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        if(entity.hasEffect(MobEffects.DARKNESS)){ entity.removeEffect(MobEffects.DARKNESS); }
        if(entity.hasEffect(MobEffects.BLINDNESS)){ entity.removeEffect(MobEffects.BLINDNESS); }
        if(entity.hasEffect(MobEffects.HUNGER)){ entity.removeEffect(MobEffects.HUNGER); }
        if(entity.hasEffect(MobEffects.INFESTED)){ entity.removeEffect(MobEffects.INFESTED); }
        if(entity.hasEffect(MobEffects.INSTANT_DAMAGE)){ entity.removeEffect(MobEffects.INSTANT_DAMAGE); }
        if(entity.hasEffect(MobEffects.LEVITATION)){ entity.removeEffect(MobEffects.LEVITATION); }
        if(entity.hasEffect(MobEffects.MINING_FATIGUE)){ entity.removeEffect(MobEffects.MINING_FATIGUE); }
        if(entity.hasEffect(MobEffects.NAUSEA)){ entity.removeEffect(MobEffects.NAUSEA); }
        if(entity.hasEffect(MobEffects.OOZING)){ entity.removeEffect(MobEffects.OOZING); }
        if(entity.hasEffect(MobEffects.POISON)){ entity.removeEffect(MobEffects.POISON); }
        if(entity.hasEffect(MobEffects.SLOWNESS)){ entity.removeEffect(MobEffects.SLOWNESS); }
        if(entity.hasEffect(MobEffects.UNLUCK)){ entity.removeEffect(MobEffects.UNLUCK); }
        if(entity.hasEffect(MobEffects.WEAKNESS)){ entity.removeEffect(MobEffects.WEAKNESS); }
        if(entity.hasEffect(MobEffects.WEAVING)){ entity.removeEffect(MobEffects.WEAVING); }
        if(entity.hasEffect(MobEffects.WIND_CHARGED)){ entity.removeEffect(MobEffects.WIND_CHARGED); }
        if(entity.hasEffect(MobEffects.WITHER)){ entity.removeEffect(MobEffects.WITHER); }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
