package net.juhewe.julianskitchen.effect;

import net.minecraft.enchantment.effect.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;

public class ImmuneEffect extends StatusEffect {

    public ImmuneEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        if(entity.hasStatusEffect(StatusEffects.DARKNESS)){ entity.removeStatusEffect(StatusEffects.DARKNESS); }
        if(entity.hasStatusEffect(StatusEffects.BLINDNESS)){ entity.removeStatusEffect(StatusEffects.BLINDNESS); }
        if(entity.hasStatusEffect(StatusEffects.HUNGER)){ entity.removeStatusEffect(StatusEffects.HUNGER); }
        if(entity.hasStatusEffect(StatusEffects.INFESTED)){ entity.removeStatusEffect(StatusEffects.INFESTED); }
        if(entity.hasStatusEffect(StatusEffects.INSTANT_DAMAGE)){ entity.removeStatusEffect(StatusEffects.INSTANT_DAMAGE); }
        if(entity.hasStatusEffect(StatusEffects.LEVITATION)){ entity.removeStatusEffect(StatusEffects.LEVITATION); }
        if(entity.hasStatusEffect(StatusEffects.MINING_FATIGUE)){ entity.removeStatusEffect(StatusEffects.MINING_FATIGUE); }
        if(entity.hasStatusEffect(StatusEffects.NAUSEA)){ entity.removeStatusEffect(StatusEffects.NAUSEA); }
        if(entity.hasStatusEffect(StatusEffects.OOZING)){ entity.removeStatusEffect(StatusEffects.OOZING); }
        if(entity.hasStatusEffect(StatusEffects.POISON)){ entity.removeStatusEffect(StatusEffects.POISON); }
        if(entity.hasStatusEffect(StatusEffects.SLOWNESS)){ entity.removeStatusEffect(StatusEffects.SLOWNESS); }
        if(entity.hasStatusEffect(StatusEffects.UNLUCK)){ entity.removeStatusEffect(StatusEffects.UNLUCK); }
        if(entity.hasStatusEffect(StatusEffects.WEAKNESS)){ entity.removeStatusEffect(StatusEffects.WEAKNESS); }
        if(entity.hasStatusEffect(StatusEffects.WEAVING)){ entity.removeStatusEffect(StatusEffects.WEAVING); }
        if(entity.hasStatusEffect(StatusEffects.WIND_CHARGED)){ entity.removeStatusEffect(StatusEffects.WIND_CHARGED); }
        if(entity.hasStatusEffect(StatusEffects.WITHER)){ entity.removeStatusEffect(StatusEffects.WITHER); }

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
