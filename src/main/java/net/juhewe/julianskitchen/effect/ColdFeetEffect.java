package net.juhewe.julianskitchen.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.item.enchantment.effects.EnchantmentEntityEffect;
import net.minecraft.world.item.enchantment.effects.ReplaceDisk;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;

import java.util.Optional;

public class ColdFeetEffect extends MobEffect {

    public ColdFeetEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {
        Vec3 entityPos = entity.position();
        Vec3i standingOn = new Vec3i((int)entityPos.x, (int)entityPos.y -1 , (int)entityPos.z);

        if(entity.onGround() || level.getBlockState(new BlockPos(standingOn)).getBlock().equals(Blocks.WATER)){
            EnchantmentEntityEffect enchantmentEffect =
                    new ReplaceDisk(
                    new LevelBasedValue.Clamped(LevelBasedValue.perLevel(3.0F, 1.0F), 0.0F, 16.0F),
                    LevelBasedValue.constant(1.0F),
                    new Vec3i(0, -1, 0),
                    Optional.of(
                            BlockPredicate.allOf(
                                    BlockPredicate.matchesTag(new Vec3i(0, 1, 0), BlockTags.AIR),
                                    BlockPredicate.matchesBlocks(Blocks.WATER),
                                    BlockPredicate.matchesFluids(Fluids.WATER),
                                    BlockPredicate.unobstructed()
                            )
                    ),
                    BlockStateProvider.simple(Blocks.FROSTED_ICE),
                    Optional.of(GameEvent.BLOCK_PLACE)
            );
            enchantmentEffect.apply(level, (amplifier * 3) + 1, null, entity, entity.position());

        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
