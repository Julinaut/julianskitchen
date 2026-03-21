package net.juhewe.julianskitchen.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.Random;

public class SaturationEffect extends StatusEffect {

    public SaturationEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    private static final Random random = Random.create();

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {

        if (entity.isPlayer()) {
            PlayerEntity player = (PlayerEntity) entity;
            HungerManager hunger = player.getHungerManager();

            if(random.nextInt((int)world.getTickManager().getTickRate()) <= amplifier){
                hunger.add(1, 1f);
            }
        }

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
