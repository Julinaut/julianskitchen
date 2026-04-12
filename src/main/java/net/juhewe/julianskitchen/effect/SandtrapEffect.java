package net.juhewe.julianskitchen.effect;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.enchantment.effect.entity.ReplaceBlockEnchantmentEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.InstantStatusEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class SandtrapEffect extends StatusEffect {

    private static final Random random = Random.create();

    public SandtrapEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {


        applySand(0, 1, world, entity, 100);
        applySand(0, 2, world, entity, 50);

        if(amplifier >= 1) {
            applySand(1, 1, world, entity, 100);
            applySand(1, 1, world, entity,50 + amplifier * 20);
        }
        if(amplifier >= 2) {
            applySand(2, 1, world, entity, 100);
            applySand(1, 3, world, entity,50 + amplifier * 10);
        }


        entity.setVelocity(0,-1,0);
        entity.velocityDirty = true;

        return true;
    }

    private int getRandomOffset(int range){
        return (random.nextInt(100) < 50 ? 1 : -1) * random.nextInt(range);
    }

    private void applySand(int heightOffset, float r, ServerWorld world, LivingEntity entity, int chance){

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
            tryPlaceSand(totalOffset, BlockPredicate.alwaysTrue(), world, entity);
        }

        tryPlaceSand(totalOffset,
                BlockPredicate.anyOf(
                        BlockPredicate.allOf(
                                BlockPredicate.matchingBlockTag(new Vec3i(0, -1, 0), BlockTags.SAND),
                                BlockPredicate.anyOf(
                                        BlockPredicate.replaceable(new Vec3i(1, -1, 0)),
                                        BlockPredicate.replaceable(new Vec3i(-1, -1, 0)),
                                        BlockPredicate.replaceable(new Vec3i(0, -1, 1)),
                                        BlockPredicate.replaceable(new Vec3i(0, -1, -1))
                                )
                        ),
                        BlockPredicate.anyOf(
                                BlockPredicate.matchingBlockTag(new Vec3i(1, 1, 0), BlockTags.SAND),
                                BlockPredicate.matchingBlockTag(new Vec3i(-1, 1, 0), BlockTags.SAND),
                                BlockPredicate.matchingBlockTag(new Vec3i(0, 1, 1), BlockTags.SAND),
                                BlockPredicate.matchingBlockTag(new Vec3i(0, 1, -1), BlockTags.SAND)
                        )
                )
                , world, entity);

    }

    private void tryPlaceSand(Vec3i offset, BlockPredicate additionalPredicate, ServerWorld world, LivingEntity entity){

        BlockPredicate blockPredicate = BlockPredicate.allOf(
                additionalPredicate,
                BlockPredicate.replaceable(),
                BlockPredicate.anyOf(
                        BlockPredicate.not(
                                BlockPredicate.matchingBlockTag(new Vec3i(0, -1, 0), BlockTags.AIR)
                        ),
                        BlockPredicate.not(
                                BlockPredicate.matchingBlockTag(new Vec3i(0, -2, 0), BlockTags.AIR)
                        ),
                        BlockPredicate.not(
                                BlockPredicate.matchingBlockTag(new Vec3i(0, -3, 0), BlockTags.AIR)
                        )
                )
        );

        EnchantmentEntityEffect enchantmentEffect = new ReplaceBlockEnchantmentEffect(
                offset,
                Optional.of(blockPredicate),
                BlockStateProvider.of(Blocks.SAND),
                Optional.of(GameEvent.BLOCK_PLACE)
        );
        enchantmentEffect.apply(world, 1, null, entity, entity.getEntityPos());

    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
