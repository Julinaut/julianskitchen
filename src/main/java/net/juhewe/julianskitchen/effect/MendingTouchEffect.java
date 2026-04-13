package net.juhewe.julianskitchen.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;

public class MendingTouchEffect extends StatusEffect {

    public MendingTouchEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        int amount = amplifier + 1;
        ItemStack itemStack = entity.getActiveOrMainHandStack();
        int j = Math.min(amount, itemStack.getDamage());
        itemStack.setDamage(itemStack.getDamage() - j);

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
