package net.juhewe.julianskitchen.effect;

import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.particle.ParticleUtil;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.biome.Biome;
import org.jspecify.annotations.Nullable;

public class FertilizeEffect extends StatusEffect {

    private static final Random random = Random.create();

    public FertilizeEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {

        Vec3d ePos = entity.getEntityPos();
        Vec3i bPos = entity.getBlockPos();

        if(random.nextInt(100) <= (amplifier + 1) * 10 && entity.isOnGround()){
            useOnBlock(world, new BlockPos(bPos.getX(), (int)(ePos.getY() - 0.5d), bPos.getZ()));
        }
        if(random.nextInt(100) <= (amplifier + 1) * 10 && entity.isOnGround()){
            useOnBlock(world, new BlockPos(bPos.getX(), (int)(ePos.getY() + 0.5d), bPos.getZ()));
        }
        return true;
    }


    public void useOnBlock(World world, BlockPos blockPos) {

        Direction blockSide = Direction.UP;
        BlockPos blockPos2 = blockPos.offset(blockSide);


        if (useOnFertilizable(world, blockPos)) {

            createParticles(world, blockPos, 2);
        } else {
            BlockState blockState = world.getBlockState(blockPos);
            boolean bl = blockState.isSideSolidFullSquare(world, blockPos, blockSide);
            if (bl && useOnGround(world, blockPos2, blockSide)) {

                createParticles(world, blockPos, 2);

            }
        }
    }

    public static boolean useOnFertilizable(World world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        Block block = blockState.getBlock();
        if (block instanceof Fertilizable fertilizable) {
            if (fertilizable.isFertilizable(world, pos, blockState)) {
                if (world instanceof ServerWorld) {
                    if (fertilizable.canGrow(world, world.random, pos, blockState)) {
                        fertilizable.grow((ServerWorld)world, world.random, pos, blockState);
                    }
                }

                return true;
            }
        }

        return false;
    }

    public static boolean useOnGround(World world, BlockPos blockPos, @Nullable Direction facing) {
        if (world.getBlockState(blockPos).isOf(Blocks.WATER) && world.getFluidState(blockPos).getLevel() == 8) {
            if (!(world instanceof ServerWorld)) {
                return true;
            } else {
                Random random = world.getRandom();

                label80:
                for(int i = 0; i < 128; ++i) {
                    BlockPos blockPos2 = blockPos;
                    BlockState blockState = Blocks.SEAGRASS.getDefaultState();

                    for(int j = 0; j < i / 16; ++j) {
                        blockPos2 = blockPos2.add(random.nextInt(3) - 1, (random.nextInt(3) - 1) * random.nextInt(3) / 2, random.nextInt(3) - 1);
                        if (world.getBlockState(blockPos2).isFullCube(world, blockPos2)) {
                            continue label80;
                        }
                    }

                    RegistryEntry<Biome> registryEntry = world.getBiome(blockPos2);
                    if (registryEntry.isIn(BiomeTags.PRODUCES_CORALS_FROM_BONEMEAL)) {
                        if (i == 0 && facing != null && facing.getAxis().isHorizontal()) {
                            blockState = (BlockState) Registries.BLOCK.getRandomEntry(BlockTags.WALL_CORALS, world.random).map((blockEntry) -> ((Block)blockEntry.value()).getDefaultState()).orElse(blockState);
                            if (blockState.contains(DeadCoralWallFanBlock.FACING)) {
                                blockState = (BlockState)blockState.with(DeadCoralWallFanBlock.FACING, facing);
                            }
                        } else if (random.nextInt(4) == 0) {
                            blockState = (BlockState)Registries.BLOCK.getRandomEntry(BlockTags.UNDERWATER_BONEMEALS, world.random).map((blockEntry) -> ((Block)blockEntry.value()).getDefaultState()).orElse(blockState);
                        }
                    }

                    if (blockState.isIn(BlockTags.WALL_CORALS, (state) -> state.contains(DeadCoralWallFanBlock.FACING))) {
                        for(int k = 0; !blockState.canPlaceAt(world, blockPos2) && k < 4; ++k) {
                            blockState = (BlockState)blockState.with(DeadCoralWallFanBlock.FACING, Direction.Type.HORIZONTAL.random(random));
                        }
                    }

                    if (blockState.canPlaceAt(world, blockPos2)) {
                        BlockState blockState2 = world.getBlockState(blockPos2);
                        if (blockState2.isOf(Blocks.WATER) && world.getFluidState(blockPos2).getLevel() == 8) {
                            world.setBlockState(blockPos2, blockState, 3);
                        } else if (blockState2.isOf(Blocks.SEAGRASS) && ((Fertilizable)Blocks.SEAGRASS).isFertilizable(world, blockPos2, blockState2) && random.nextInt(10) == 0) {
                            ((Fertilizable)Blocks.SEAGRASS).grow((ServerWorld)world, random, blockPos2, blockState2);
                        }
                    }
                }

                return true;
            }
        } else {
            return false;
        }
    }

    public static void createParticles(WorldAccess world, BlockPos pos, int count) {
        ParticleUtil.spawnParticlesAround(world, pos, count * 3, (double)3.0F, (double)1.0F, false, ParticleTypes.HAPPY_VILLAGER);

    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
