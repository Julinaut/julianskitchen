package net.juhewe.julianskitchen.effect;

import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.item.enchantment.effects.ReplaceDisk;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.Optional;

public class FirewalkEffect extends MobEffect {

    public FirewalkEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        applyFire(new Vec3i(0, 0, 0), amplifier, level, entity);
        if(amplifier >= 2){
            applyFire(new Vec3i(0, 1, 0), amplifier, level, entity);
        }

        return true;
    }

    private void applyFire(Vec3i offset, int amplifier, ServerLevel level, LivingEntity entity){
        EnchantmentEntityEffect enchantmentEffect = new ReplaceDisk(
                new LevelBasedValue.Clamped(LevelBasedValue.perLevel(1.0F, 1.0F), 0.0F, 16.0F),
                LevelBasedValue.constant(1.0F),
                offset,
                Optional.of(
                        BlockPredicate.allOf(
                                BlockPredicate.matchesTag(BlockTags.AIR),
                                BlockPredicate.unobstructed()
                        )
                ),
                BlockStateProvider.simple(Blocks.FIRE),
                Optional.of(GameEvent.BLOCK_PLACE)
        );
        enchantmentEffect.apply(level, (amplifier) + 1, null, entity, entity.position());

        if(amplifier >= 2){
            EnchantmentEntityEffect enchantmentEffect2 = new ReplaceDisk(
                    LevelBasedValue.constant(2.0F),
                    LevelBasedValue.constant(1.0F),
                    offset,
                    Optional.of(
                            BlockPredicate.allOf(
                                    BlockPredicate.matchesBlocks(Blocks.FIRE)
                            )
                    ),
                    BlockStateProvider.simple(Blocks.AIR),
                    Optional.of(GameEvent.BLOCK_PLACE)
            );
            enchantmentEffect2.apply(level, 1, null, entity, entity.position());
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
