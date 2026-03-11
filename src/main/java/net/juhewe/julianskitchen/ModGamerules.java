package net.juhewe.julianskitchen;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Identifier;
import net.minecraft.world.rule.GameRule;
import net.minecraft.world.rule.GameRuleCategory;

public class ModGamerules {
    private static final int defaultPotionBundleCapacity = 6;
    private static final int defaultPotionBundleVisibleCount = 1;

    public  static final GameRule<Integer> POTION_BUNDLE_CAPACITY = GameRuleBuilder
            .forInteger(defaultPotionBundleCapacity)
            .category(GameRuleCategory.MISC)
            .range(1, 64)
            .buildAndRegister(Identifier.of(JuliansKitchen.MOD_ID,"potion_bundle_capacity"))
            ;
    public  static final GameRule<Integer> POTION_BUNDLE_VISIBLE_COUNT = GameRuleBuilder
            .forInteger(defaultPotionBundleVisibleCount)
            .category(GameRuleCategory.MISC)
            .range(0, 64)
            .buildAndRegister(Identifier.of(JuliansKitchen.MOD_ID,"potion_bundle_visible_count"))
            ;

    public static int getPotionBundleCapacity(){
        if(ModServerTickListener.currentServerWorld == null){
            return defaultPotionBundleCapacity;
        }
        ServerWorld serverWorld = ModServerTickListener.currentServerWorld;
        int gameRuleValue = serverWorld.getGameRules().getValue(POTION_BUNDLE_CAPACITY);
        return Math.min(Math.max(1, gameRuleValue), 64);
    }
    public static int getPotionBundleVisibleCount(){
        if(ModServerTickListener.currentServerWorld == null){
            return defaultPotionBundleVisibleCount;
        }
        ServerWorld serverWorld = ModServerTickListener.currentServerWorld;
        int gameRuleValue = serverWorld.getGameRules().getValue(POTION_BUNDLE_VISIBLE_COUNT);
        return Math.min(Math.max(0, gameRuleValue), getPotionBundleCapacity());
    }

    public static void registerModGameRules(){
        JuliansKitchen.LOGGER.info("Registering Mod Game Rules for JuliansKitchen");
    }
}
