package net.juhewe.julianskitchen.effect;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

import java.util.Random;

public class FertilizeEffect extends MobEffect {

    private static final Random random = new Random();

    public FertilizeEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(ServerLevel level, LivingEntity entity, int amplifier) {

        Vec3 ePos = entity.position();
        Vec3i bPos = entity.blockPosition();
        if(random.nextInt(100) <= (amplifier + 1) * 10 && entity.onGround()){
            useOnBlock(level, new BlockPos(bPos.getX(), (int)(ePos.y() - 0.5d), bPos.getZ()));
        }
        if(random.nextInt(100) <= (amplifier + 1) * 10 && entity.onGround()){
            useOnBlock(level, new BlockPos(bPos.getX(), (int)(ePos.y() + 0.5d), bPos.getZ()));
        }

        return true;
    }


    public void useOnBlock(ServerLevel level, BlockPos blockPos) {
        Direction blockSide = Direction.UP;
        BlockPos blockPos2 = blockPos.offset(blockSide.getUnitVec3i());
        if (useOnFertilizable(level, blockPos)) {
            createParticles(level, blockPos, 2);
        } else {
            BlockState blockState = level.getBlockState(blockPos);
            boolean bl = blockState.isFaceSturdy(level, blockPos, blockSide);
            if (bl && useOnGround(level, blockPos2, blockSide)) {
                createParticles(level, blockPos, 2);
            }
        }
    }

    public static boolean useOnFertilizable(ServerLevel level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        if (state.getBlock() instanceof BonemealableBlock block) {
            if (block.isValidBonemealTarget(level, pos, state)) {
                if (block.isBonemealSuccess(level, level.getRandom(), pos, state)) {
                    block.performBonemeal(level, level.getRandom(), pos, state);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean useOnGround(ServerLevel level, BlockPos pos, @Nullable Direction facing) {
        if (!level.getBlockState(pos).is(Blocks.WATER) || !level.getFluidState(pos).isSourceOfType(Fluids.WATER)) return false;

        RandomSource random = level.getRandom();

        for (int j = 0; j < 128; j++) {
            BlockPos testPos = pos;
            BlockState stateToGrow = Blocks.SEAGRASS.defaultBlockState();

            for (int i = 0; i < j / 16; i++) {
                testPos = testPos.offset(random.nextInt(3) - 1,
                        (random.nextInt(3) - 1) * random.nextInt(3) / 2,
                        random.nextInt(3) - 1);

                if (level.getBlockState(testPos).isCollisionShapeFullBlock(level, testPos)) continue;
            }

            if (stateToGrow.canSurvive(level, testPos)) {
                BlockState current = level.getBlockState(testPos);

                if (current.is(Blocks.WATER) && level.getFluidState(testPos).isSourceOfType(Fluids.WATER)) {
                    level.setBlock(testPos, stateToGrow, 3);
                } else if (current.getBlock() instanceof BonemealableBlock plant
                        && plant.isValidBonemealTarget(level, testPos, current)
                        && random.nextInt(10) == 0) {
                    plant.performBonemeal(level, random, testPos, current);
                }
            }
        }

        return true;
    }
    public static void createParticles(ServerLevel level, BlockPos pos, int count) {
        BlockState state = level.getBlockState(pos);

        if (state.getBlock() instanceof BonemealableBlock bonemealable) {
            BlockPos particlePos = bonemealable.getParticlePos(pos);

            switch (bonemealable.getType()) {
                case NEIGHBOR_SPREADER ->
                        ParticleUtils.spawnParticles(level, particlePos, count * 3, 3.0D, 1.0D, false, ParticleTypes.HAPPY_VILLAGER);

                case GROWER ->
                        ParticleUtils.spawnParticleInBlock(level, particlePos, count, ParticleTypes.HAPPY_VILLAGER);
            }
        } else if (state.is(Blocks.WATER)) {
            ParticleUtils.spawnParticles(level, pos, count * 3, 3.0D, 1.0D, false, ParticleTypes.HAPPY_VILLAGER);
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        return true;
    }
}
