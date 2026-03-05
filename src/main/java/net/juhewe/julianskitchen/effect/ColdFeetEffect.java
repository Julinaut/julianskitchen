package net.juhewe.julianskitchen.effect;

import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.enchantment.effect.entity.ReplaceDiskEnchantmentEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.Optional;

public class ColdFeetEffect extends StatusEffect {

    public ColdFeetEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
        Vec3d entityPos = entity.getEntityPos();
        Vec3i standingOn = new Vec3i((int)entityPos.x, (int)entityPos.y -1 , (int)entityPos.z);

        if(entity.isOnGround() || world.getBlockState(new BlockPos(standingOn)).getBlock().equals(Blocks.WATER)){
            EnchantmentEntityEffect enchantmentEffect = new ReplaceDiskEnchantmentEffect(
                    new EnchantmentLevelBasedValue.Clamped(EnchantmentLevelBasedValue.linear(3.0F, 1.0F), 0.0F, 16.0F),
                    EnchantmentLevelBasedValue.constant(1.0F),
                    new Vec3i(0, -1, 0),
                    Optional.of(
                            BlockPredicate.allOf(
                                    BlockPredicate.matchingBlockTag(new Vec3i(0, 1, 0), BlockTags.AIR),
                                    BlockPredicate.matchingBlocks(Blocks.WATER),
                                    BlockPredicate.matchingFluids(Fluids.WATER),
                                    BlockPredicate.unobstructed()
                            )
                    ),
                    BlockStateProvider.of(Blocks.FROSTED_ICE),
                    Optional.of(GameEvent.BLOCK_PLACE)
            );
            enchantmentEffect.apply(world, (amplifier * 3) + 1, null, entity, entity.getEntityPos());

        }
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
