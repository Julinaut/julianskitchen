package net.juhewe.julianskitchen.effect;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import org.jspecify.annotations.Nullable;

public class PrecipitationEffect extends InstantStatusEffect {

    public PrecipitationEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        return true;
    }

    public void applyInstantEffect(ServerWorld world, @Nullable Entity effectEntity, @Nullable Entity attacker, LivingEntity target, int amplifier, double proximity) {
        world.setWeather(-1, -1, true, amplifier > 0);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
