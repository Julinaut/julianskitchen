package net.juhewe.julianskitchen.effect;

import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.enchantment.effect.entity.ReplaceDiskEnchantmentEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.Optional;

public class FirewalkEffect extends StatusEffect {

    public FirewalkEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        applyFire(new Vec3i(0, 0, 0), amplifier, world, entity);
        if(amplifier >= 2){
            applyFire(new Vec3i(0, 1, 0), amplifier, world, entity);
        }
        return true;
    }

    private void applyFire(Vec3i offset, int amplifier, ServerWorld world, LivingEntity entity){

        EnchantmentEntityEffect enchantmentEffect = new ReplaceDiskEnchantmentEffect(
                new EnchantmentLevelBasedValue.Clamped(EnchantmentLevelBasedValue.linear(1.0F, 1.0F), 0.0F, 16.0F),
                EnchantmentLevelBasedValue.constant(1.0F),
                offset,
                Optional.of(
                        BlockPredicate.allOf(
                                BlockPredicate.IS_AIR,
                                BlockPredicate.unobstructed()
                        )
                ),
                BlockStateProvider.of(Blocks.FIRE),
                Optional.of(GameEvent.BLOCK_PLACE)
        );
        enchantmentEffect.apply(world, (amplifier) + 1, null, entity, entity.getEntityPos());

    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
