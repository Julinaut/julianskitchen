package net.juhewe.julianskitchen.effect;


import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.item.enchantment.effects.ReplaceBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;

import java.util.Optional;
import java.util.Random;

public class SandtrapEffect extends MobEffect {

    private static final Random random = new Random();

    public SandtrapEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        applySand(0, 1, level, entity, 100);
        applySand(0, 2, level, entity, 50);

        if(amplifier >= 1) {
            applySand(1, 1, level, entity, 100);
            applySand(1, 1, level, entity,50 + amplifier * 20);
        }
        if(amplifier >= 2) {
            applySand(2, 1, level, entity, 100);
            applySand(1, 3, level, entity,50 + amplifier * 10);
        }

        entity.setDeltaMovement(0,-1,0);

        return true;
    }

    private int getRandomOffset(int range){
        return (random.nextInt(100) < 50 ? 1 : -1) * random.nextInt(range);
    }

    private void applySand(int heightOffset, float r, ServerLevel level, LivingEntity entity, int chance){
        int xOffset = getRandomOffset((int)(r + 0.5F));
        int zOffset = getRandomOffset((int)(r + 0.5F));

        float d = xOffset * xOffset + zOffset * zOffset;
        float maxD = r * r;
        if(d > maxD){
            return;
        }

        Vec3i totalOffset = new Vec3i(xOffset, heightOffset, zOffset);

        if(heightOffset > 0 && xOffset > 0 && zOffset > 0){
            if(random.nextInt(100) > chance){
                return ;
            }
        }

        if(xOffset == 0 && zOffset == 0){
            tryPlaceSand(totalOffset, BlockPredicate.alwaysTrue(), level, entity);
        }

        tryPlaceSand(totalOffset,
                BlockPredicate.anyOf(
                        BlockPredicate.allOf(
                                BlockPredicate.matchesTag(new Vec3i(0, -1, 0), BlockTags.SAND),
                                BlockPredicate.anyOf(
                                        BlockPredicate.replaceable(new Vec3i(1, -1, 0)),
                                        BlockPredicate.replaceable(new Vec3i(-1, -1, 0)),
                                        BlockPredicate.replaceable(new Vec3i(0, -1, 1)),
                                        BlockPredicate.replaceable(new Vec3i(0, -1, -1))
                                )
                        ),
                        BlockPredicate.anyOf(
                                BlockPredicate.matchesTag(new Vec3i(1, 1, 0), BlockTags.SAND),
                                BlockPredicate.matchesTag(new Vec3i(-1, 1, 0), BlockTags.SAND),
                                BlockPredicate.matchesTag(new Vec3i(0, 1, 1), BlockTags.SAND),
                                BlockPredicate.matchesTag(new Vec3i(0, 1, -1), BlockTags.SAND)
                        )
                )
                , level, entity);
    }

    private void tryPlaceSand(Vec3i offset, BlockPredicate additionalPredicate, ServerLevel level, LivingEntity entity){
        BlockPredicate blockPredicate = BlockPredicate.allOf(
                additionalPredicate,
                BlockPredicate.replaceable(),
                BlockPredicate.anyOf(
                        BlockPredicate.not(
                                BlockPredicate.matchesTag(new Vec3i(0, -1, 0), BlockTags.AIR)
                        ),
                        BlockPredicate.not(
                                BlockPredicate.matchesTag(new Vec3i(0, -2, 0), BlockTags.AIR)
                        ),
                        BlockPredicate.not(
                                BlockPredicate.matchesTag(new Vec3i(0, -3, 0), BlockTags.AIR)
                        )
                )
        );

        EnchantmentEntityEffect enchantmentEffect = new ReplaceBlock(
                offset,
                Optional.of(blockPredicate),
                BlockStateProvider.simple(Blocks.SAND),
                Optional.of(GameEvent.BLOCK_PLACE)
        );
        enchantmentEffect.apply(level, 1, null, entity, entity.position());
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
