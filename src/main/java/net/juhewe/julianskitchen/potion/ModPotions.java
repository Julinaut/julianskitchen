package net.juhewe.julianskitchen.potion;

import net.juhewe.julianskitchen.JuliansKitchen;
import net.juhewe.julianskitchen.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;

public class ModPotions {

    //Potions

    public static final Holder.Reference<Potion> FIREWALK_POTION_AA = registerPotion("firewalk_potion_aa", new MobEffectInstance(ModEffects.FIREWALK, 20*10, 0));
    public static final Holder.Reference<Potion> FIREWALK_POTION_AB = registerPotion("firewalk_potion_ab", new MobEffectInstance(ModEffects.FIREWALK, 20*10, 1));
    public static final Holder.Reference<Potion> FIREWALK_POTION_AC = registerPotion("firewalk_potion_ac", new MobEffectInstance(ModEffects.FIREWALK, 20*10, 2), new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20*15, 0));
    public static final Holder.Reference<Potion> FIREWALK_POTION_BA = registerPotion("firewalk_potion_ba", new MobEffectInstance(ModEffects.FIREWALK, 20*20, 0));
    public static final Holder.Reference<Potion> FIREWALK_POTION_BB = registerPotion("firewalk_potion_bb", new MobEffectInstance(ModEffects.FIREWALK, 20*20, 1));
    public static final Holder.Reference<Potion> FIREWALK_POTION_BC = registerPotion("firewalk_potion_bc", new MobEffectInstance(ModEffects.FIREWALK, 20*20, 2), new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20*25, 0));
    public static final Holder.Reference<Potion> FIREWALK_POTION_CA = registerPotion("firewalk_potion_ca", new MobEffectInstance(ModEffects.FIREWALK, 20*30, 0));
    public static final Holder.Reference<Potion> FIREWALK_POTION_CB = registerPotion("firewalk_potion_cb", new MobEffectInstance(ModEffects.FIREWALK, 20*30, 1));
    public static final Holder.Reference<Potion> FIREWALK_POTION_CC = registerPotion("firewalk_potion_cc", new MobEffectInstance(ModEffects.FIREWALK, 20*60, 2), new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20*70, 0));

    public static final Holder.Reference<Potion> SANDTRAP_POTION_A = registerPotion("sandtrap_potion_a", new MobEffectInstance(ModEffects.SANDTRAP, 20+4, 0));
    public static final Holder.Reference<Potion> SANDTRAP_POTION_B = registerPotion("sandtrap_potion_b", new MobEffectInstance(ModEffects.SANDTRAP, 20+5, 1));
    public static final Holder.Reference<Potion> SANDTRAP_POTION_C = registerPotion("sandtrap_potion_c", new MobEffectInstance(ModEffects.SANDTRAP, 20+6, 2));

    public static final Holder.Reference<Potion> MONSOON_POTION_A = registerPotion("monsoon_potion_a", new MobEffectInstance(ModEffects.PRECIPITATION, 1, 0));
    public static final Holder.Reference<Potion> MONSOON_POTION_B = registerPotion("monsoon_potion_b", new MobEffectInstance(ModEffects.PRECIPITATION, 1, 1));
    public static final Holder.Reference<Potion> CLEAR_SKY_POTION = registerPotion("clear_sky_potion", new MobEffectInstance(ModEffects.CLEAR_SKY, 1, 0));

    public static final Holder.Reference<Potion> FERTILIZE_POTION_A = registerPotion("fertilize_potion_a", new MobEffectInstance(ModEffects.FERTILIZE, 20*20, 0));
    public static final Holder.Reference<Potion> FERTILIZE_POTION_B = registerPotion("fertilize_potion_b", new MobEffectInstance(ModEffects.FERTILIZE, 20*40, 1));
    public static final Holder.Reference<Potion> FERTILIZE_POTION_C = registerPotion("fertilize_potion_c", new MobEffectInstance(ModEffects.FERTILIZE, 20*60, 2));

    public static final Holder.Reference<Potion> VACCINATION_POTION_A = registerPotion("vaccination_potion_a", new MobEffectInstance(ModEffects.IMMUNE, 20*60*3, 0));
    public static final Holder.Reference<Potion> VACCINATION_POTION_B = registerPotion("vaccination_potion_b", new MobEffectInstance(ModEffects.IMMUNE, 20*60*6, 0));
    public static final Holder.Reference<Potion> VACCINATION_POTION_C = registerPotion("vaccination_potion_c", new MobEffectInstance(ModEffects.IMMUNE, 20*60*9, 0));

    public static final Holder.Reference<Potion> SOFT_LANDING_POTION_A = registerPotion("soft_landing_potion_a", new MobEffectInstance(ModEffects.SOFT_LANDING, 20*60*1, 0));
    public static final Holder.Reference<Potion> SOFT_LANDING_POTION_B = registerPotion("soft_landing_potion_b", new MobEffectInstance(ModEffects.SOFT_LANDING, 20*60*2, 0));
    public static final Holder.Reference<Potion> SOFT_LANDING_POTION_C = registerPotion("soft_landing_potion_c", new MobEffectInstance(ModEffects.SOFT_LANDING, 20*60*5, 0));

    public static final Holder.Reference<Potion> COLD_FEET_POTION_AA = registerPotion("cold_feet_potion_aa", new MobEffectInstance(ModEffects.COLD_FEET, 20*60*2, 0));
    public static final Holder.Reference<Potion> COLD_FEET_POTION_AB = registerPotion("cold_feet_potion_ab", new MobEffectInstance(ModEffects.COLD_FEET, 20*60*2, 1));
    public static final Holder.Reference<Potion> COLD_FEET_POTION_AC = registerPotion("cold_feet_potion_ac", new MobEffectInstance(ModEffects.COLD_FEET, 20*60*4, 2));
    public static final Holder.Reference<Potion> COLD_FEET_POTION_BA = registerPotion("cold_feet_potion_ba", new MobEffectInstance(ModEffects.COLD_FEET, 20*60*4, 0));
    public static final Holder.Reference<Potion> COLD_FEET_POTION_BB = registerPotion("cold_feet_potion_bb", new MobEffectInstance(ModEffects.COLD_FEET, 20*60*4, 1));
    public static final Holder.Reference<Potion> COLD_FEET_POTION_BC = registerPotion("cold_feet_potion_bc", new MobEffectInstance(ModEffects.COLD_FEET, 20*60*6, 2));
    public static final Holder.Reference<Potion> COLD_FEET_POTION_CA = registerPotion("cold_feet_potion_ca", new MobEffectInstance(ModEffects.COLD_FEET, 20*60*6, 0));
    public static final Holder.Reference<Potion> COLD_FEET_POTION_CB = registerPotion("cold_feet_potion_cb", new MobEffectInstance(ModEffects.COLD_FEET, 20*60*6, 1));
    public static final Holder.Reference<Potion> COLD_FEET_POTION_CC = registerPotion("cold_feet_potion_cc", new MobEffectInstance(ModEffects.COLD_FEET, 20*60*10, 2));

    public static final Holder.Reference<Potion> MENDING_TOUCH_POTION_AA = registerPotion("mending_touch_potion_aa", new MobEffectInstance(ModEffects.MENDING_TOUCH, 20*10, 0));
    public static final Holder.Reference<Potion> MENDING_TOUCH_POTION_AB = registerPotion("mending_touch_potion_ab", new MobEffectInstance(ModEffects.MENDING_TOUCH, 20*10, 1));
    public static final Holder.Reference<Potion> MENDING_TOUCH_POTION_AC = registerPotion("mending_touch_potion_ac", new MobEffectInstance(ModEffects.MENDING_TOUCH, 20*10, 2));
    public static final Holder.Reference<Potion> MENDING_TOUCH_POTION_BA = registerPotion("mending_touch_potion_ba", new MobEffectInstance(ModEffects.MENDING_TOUCH, 20*20, 0));
    public static final Holder.Reference<Potion> MENDING_TOUCH_POTION_BB = registerPotion("mending_touch_potion_bb", new MobEffectInstance(ModEffects.MENDING_TOUCH, 20*20, 1));
    public static final Holder.Reference<Potion> MENDING_TOUCH_POTION_BC = registerPotion("mending_touch_potion_bc", new MobEffectInstance(ModEffects.MENDING_TOUCH, 20*20, 2));
    public static final Holder.Reference<Potion> MENDING_TOUCH_POTION_CA = registerPotion("mending_touch_potion_ca", new MobEffectInstance(ModEffects.MENDING_TOUCH, 20*30, 0));
    public static final Holder.Reference<Potion> MENDING_TOUCH_POTION_CB = registerPotion("mending_touch_potion_cb", new MobEffectInstance(ModEffects.MENDING_TOUCH, 20*30, 1));
    public static final Holder.Reference<Potion> MENDING_TOUCH_POTION_CC = registerPotion("mending_touch_potion_cc", new MobEffectInstance(ModEffects.MENDING_TOUCH, 20*30, 2));

    //Vanilla Effects

    public static final Holder.Reference<Potion> HASTE_POTION_AA = registerPotion("haste_potion_aa", new MobEffectInstance(MobEffects.HASTE, 20*60*1, 0));
    public static final Holder.Reference<Potion> HASTE_POTION_AB = registerPotion("haste_potion_ab", new MobEffectInstance(MobEffects.HASTE, 20*60*1, 1));
    public static final Holder.Reference<Potion> HASTE_POTION_AC = registerPotion("haste_potion_ac", new MobEffectInstance(MobEffects.HASTE, 20*60*1, 2));
    public static final Holder.Reference<Potion> HASTE_POTION_BA = registerPotion("haste_potion_ba", new MobEffectInstance(MobEffects.HASTE, 20*60*2, 0));
    public static final Holder.Reference<Potion> HASTE_POTION_BB = registerPotion("haste_potion_bb", new MobEffectInstance(MobEffects.HASTE, 20*60*2, 1));
    public static final Holder.Reference<Potion> HASTE_POTION_BC = registerPotion("haste_potion_bc", new MobEffectInstance(MobEffects.HASTE, 20*60*2, 2));
    public static final Holder.Reference<Potion> HASTE_POTION_CA = registerPotion("haste_potion_ca", new MobEffectInstance(MobEffects.HASTE, 20*60*3, 0));
    public static final Holder.Reference<Potion> HASTE_POTION_CB = registerPotion("haste_potion_cb", new MobEffectInstance(MobEffects.HASTE, 20*60*3, 1));
    public static final Holder.Reference<Potion> HASTE_POTION_CC = registerPotion("haste_potion_cc", new MobEffectInstance(MobEffects.HASTE, 20*60*5, 2));

    public static final Holder.Reference<Potion> RESISTANCE_POTION_AA = registerPotion("resistance_potion_aa", new MobEffectInstance(MobEffects.RESISTANCE, 20*60*2, 0));
    public static final Holder.Reference<Potion> RESISTANCE_POTION_AB = registerPotion("resistance_potion_ab", new MobEffectInstance(MobEffects.RESISTANCE, 20*60*2, 1));
    public static final Holder.Reference<Potion> RESISTANCE_POTION_AC = registerPotion("resistance_potion_ac", new MobEffectInstance(MobEffects.RESISTANCE, 20*60*2, 2));
    public static final Holder.Reference<Potion> RESISTANCE_POTION_BA = registerPotion("resistance_potion_ba", new MobEffectInstance(MobEffects.RESISTANCE, 20*60*4, 0));
    public static final Holder.Reference<Potion> RESISTANCE_POTION_BB = registerPotion("resistance_potion_bb", new MobEffectInstance(MobEffects.RESISTANCE, 20*60*4, 1));
    public static final Holder.Reference<Potion> RESISTANCE_POTION_BC = registerPotion("resistance_potion_bc", new MobEffectInstance(MobEffects.RESISTANCE, 20*60*4, 2));
    public static final Holder.Reference<Potion> RESISTANCE_POTION_CA = registerPotion("resistance_potion_ca", new MobEffectInstance(MobEffects.RESISTANCE, 20*60*6, 0));
    public static final Holder.Reference<Potion> RESISTANCE_POTION_CB = registerPotion("resistance_potion_cb", new MobEffectInstance(MobEffects.RESISTANCE, 20*60*6, 1));
    public static final Holder.Reference<Potion> RESISTANCE_POTION_CC = registerPotion("resistance_potion_cc", new MobEffectInstance(MobEffects.RESISTANCE, 20*60*10, 2));

    public static final Holder.Reference<Potion> HEALTH_BOOST_POTION_AA = registerPotion("health_boost_potion_aa", new MobEffectInstance(MobEffects.HEALTH_BOOST, 20*60*2, 0));
    public static final Holder.Reference<Potion> HEALTH_BOOST_POTION_AB = registerPotion("health_boost_potion_ab", new MobEffectInstance(MobEffects.HEALTH_BOOST, 20*60*2, 1));
    public static final Holder.Reference<Potion> HEALTH_BOOST_POTION_AC = registerPotion("health_boost_potion_ac", new MobEffectInstance(MobEffects.HEALTH_BOOST, 20*60*2, 2));
    public static final Holder.Reference<Potion> HEALTH_BOOST_POTION_BA = registerPotion("health_boost_potion_ba", new MobEffectInstance(MobEffects.HEALTH_BOOST, 20*60*4, 0));
    public static final Holder.Reference<Potion> HEALTH_BOOST_POTION_BB = registerPotion("health_boost_potion_bb", new MobEffectInstance(MobEffects.HEALTH_BOOST, 20*60*4, 1));
    public static final Holder.Reference<Potion> HEALTH_BOOST_POTION_BC = registerPotion("health_boost_potion_bc", new MobEffectInstance(MobEffects.HEALTH_BOOST, 20*60*4, 2));
    public static final Holder.Reference<Potion> HEALTH_BOOST_POTION_CA = registerPotion("health_boost_potion_ca", new MobEffectInstance(MobEffects.HEALTH_BOOST, 20*60*6, 0));
    public static final Holder.Reference<Potion> HEALTH_BOOST_POTION_CB = registerPotion("health_boost_potion_cb", new MobEffectInstance(MobEffects.HEALTH_BOOST, 20*60*6, 1));
    public static final Holder.Reference<Potion> HEALTH_BOOST_POTION_CC = registerPotion("health_boost_potion_cc", new MobEffectInstance(MobEffects.HEALTH_BOOST, 20*60*10, 2));

    public static final Holder.Reference<Potion> SATURATION_POTION_AA = registerPotion("saturation_potion_aa", new MobEffectInstance(ModEffects.SATURATION, 20*60*2, 0));
    public static final Holder.Reference<Potion> SATURATION_POTION_AB = registerPotion("saturation_potion_ab", new MobEffectInstance(ModEffects.SATURATION, 20*60*2, 1));
    public static final Holder.Reference<Potion> SATURATION_POTION_AC = registerPotion("saturation_potion_ac", new MobEffectInstance(ModEffects.SATURATION, 20*60*2, 2));
    public static final Holder.Reference<Potion> SATURATION_POTION_BA = registerPotion("saturation_potion_ba", new MobEffectInstance(ModEffects.SATURATION, 20*60*4, 0));
    public static final Holder.Reference<Potion> SATURATION_POTION_BB = registerPotion("saturation_potion_bb", new MobEffectInstance(ModEffects.SATURATION, 20*60*4, 1));
    public static final Holder.Reference<Potion> SATURATION_POTION_BC = registerPotion("saturation_potion_bc", new MobEffectInstance(ModEffects.SATURATION, 20*60*4, 2));
    public static final Holder.Reference<Potion> SATURATION_POTION_CA = registerPotion("saturation_potion_ca", new MobEffectInstance(ModEffects.SATURATION, 20*60*6, 0));
    public static final Holder.Reference<Potion> SATURATION_POTION_CB = registerPotion("saturation_potion_cb", new MobEffectInstance(ModEffects.SATURATION, 20*60*6, 1));
    public static final Holder.Reference<Potion> SATURATION_POTION_CC = registerPotion("saturation_potion_cc", new MobEffectInstance(ModEffects.SATURATION, 20*60*10, 2));

    public static final Holder.Reference<Potion> GLOWING_POTION_A = registerPotion("glowing_potion_a", new MobEffectInstance(MobEffects.GLOWING, 20*60*1, 0));
    public static final Holder.Reference<Potion> GLOWING_POTION_B = registerPotion("glowing_potion_b", new MobEffectInstance(MobEffects.GLOWING, 20*60*2, 0));
    public static final Holder.Reference<Potion> GLOWING_POTION_C = registerPotion("glowing_potion_c", new MobEffectInstance(MobEffects.GLOWING, 20*60*3, 0));

    public static final Holder.Reference<Potion> LEVITATION_POTION_AA = registerPotion("levitation_potion_aa", new MobEffectInstance(MobEffects.LEVITATION, 20*30, 0));
    public static final Holder.Reference<Potion> LEVITATION_POTION_AB = registerPotion("levitation_potion_ab", new MobEffectInstance(MobEffects.LEVITATION, 20*30, 1));
    public static final Holder.Reference<Potion> LEVITATION_POTION_AC = registerPotion("levitation_potion_ac", new MobEffectInstance(MobEffects.LEVITATION, 20*30, 2));
    public static final Holder.Reference<Potion> LEVITATION_POTION_BA = registerPotion("levitation_potion_ba", new MobEffectInstance(MobEffects.LEVITATION, 20*60, 0));
    public static final Holder.Reference<Potion> LEVITATION_POTION_BB = registerPotion("levitation_potion_bb", new MobEffectInstance(MobEffects.LEVITATION, 20*60, 1));
    public static final Holder.Reference<Potion> LEVITATION_POTION_BC = registerPotion("levitation_potion_bc", new MobEffectInstance(MobEffects.LEVITATION, 20*60, 2));
    public static final Holder.Reference<Potion> LEVITATION_POTION_CA = registerPotion("levitation_potion_ca", new MobEffectInstance(MobEffects.LEVITATION, 20*90, 0));
    public static final Holder.Reference<Potion> LEVITATION_POTION_CB = registerPotion("levitation_potion_cb", new MobEffectInstance(MobEffects.LEVITATION, 20*90, 1));
    public static final Holder.Reference<Potion> LEVITATION_POTION_CC = registerPotion("levitation_potion_cc", new MobEffectInstance(MobEffects.LEVITATION, 20*100, 2));

    public static final Holder.Reference<Potion> LUCK_POTION_AA = registerPotion("luck_potion_aa", new MobEffectInstance(MobEffects.LUCK, 20*60*2, 0));
    public static final Holder.Reference<Potion> LUCK_POTION_AB = registerPotion("luck_potion_ab", new MobEffectInstance(MobEffects.LUCK, 20*60*2, 1));
    public static final Holder.Reference<Potion> LUCK_POTION_AC = registerPotion("luck_potion_ac", new MobEffectInstance(MobEffects.LUCK, 20*60*2, 2));
    public static final Holder.Reference<Potion> LUCK_POTION_BA = registerPotion("luck_potion_ba", new MobEffectInstance(MobEffects.LUCK, 20*60*4, 0));
    public static final Holder.Reference<Potion> LUCK_POTION_BB = registerPotion("luck_potion_bb", new MobEffectInstance(MobEffects.LUCK, 20*60*4, 1));
    public static final Holder.Reference<Potion> LUCK_POTION_BC = registerPotion("luck_potion_bc", new MobEffectInstance(MobEffects.LUCK, 20*60*4, 2));
    public static final Holder.Reference<Potion> LUCK_POTION_CA = registerPotion("luck_potion_ca", new MobEffectInstance(MobEffects.LUCK, 20*60*5, 0));
    public static final Holder.Reference<Potion> LUCK_POTION_CB = registerPotion("luck_potion_cb", new MobEffectInstance(MobEffects.LUCK, 20*60*5, 1));
    public static final Holder.Reference<Potion> LUCK_POTION_CC = registerPotion("luck_potion_cc", new MobEffectInstance(MobEffects.LUCK, 20*60*6, 2));

    //Vanilla Extensions

    public static final Holder.Reference<Potion> WEAKNESS_POTION_CA = registerPotion("weakness_potion_ca", new MobEffectInstance(MobEffects.WEAKNESS, 20*60*8, 0));
    public static final Holder.Reference<Potion> WEAKNESS_POTION_AB = registerPotion("weakness_potion_ab", new MobEffectInstance(MobEffects.WEAKNESS, 20*90, 1));
    public static final Holder.Reference<Potion> WEAKNESS_POTION_BB = registerPotion("weakness_potion_bb", new MobEffectInstance(MobEffects.WEAKNESS, 20*60*4, 1));
    public static final Holder.Reference<Potion> WEAKNESS_POTION_CB = registerPotion("weakness_potion_cb", new MobEffectInstance(MobEffects.WEAKNESS, 20*60*8, 1));
    public static final Holder.Reference<Potion> WEAKNESS_POTION_AC = registerPotion("weakness_potion_ac", new MobEffectInstance(MobEffects.WEAKNESS, 20*60*2, 2));
    public static final Holder.Reference<Potion> WEAKNESS_POTION_BC = registerPotion("weakness_potion_bc", new MobEffectInstance(MobEffects.WEAKNESS, 20*60*6, 2));
    public static final Holder.Reference<Potion> WEAKNESS_POTION_CC = registerPotion("weakness_potion_cc", new MobEffectInstance(MobEffects.WEAKNESS, 20*60*10, 3));

    public static final Holder.Reference<Potion> SPEED_POTION_CA = registerPotion("speed_potion_ca", new MobEffectInstance(MobEffects.SPEED, 20*60*10, 0));
    public static final Holder.Reference<Potion> SPEED_POTION_BB = registerPotion("speed_potion_bb", new MobEffectInstance(MobEffects.SPEED, 20*60*4, 1));
    public static final Holder.Reference<Potion> SPEED_POTION_CB = registerPotion("speed_potion_cb", new MobEffectInstance(MobEffects.SPEED, 20*60*8, 1));
    public static final Holder.Reference<Potion> SPEED_POTION_AC = registerPotion("speed_potion_ac", new MobEffectInstance(MobEffects.SPEED, 20*60*2, 2));
    public static final Holder.Reference<Potion> SPEED_POTION_BC = registerPotion("speed_potion_bc", new MobEffectInstance(MobEffects.SPEED, 20*60*6, 2));
    public static final Holder.Reference<Potion> SPEED_POTION_CC = registerPotion("speed_potion_cc", new MobEffectInstance(MobEffects.SPEED, 20*60*10, 3));

    public static final Holder.Reference<Potion> SLOWNESS_POTION_CA = registerPotion("slowness_potion_ca", new MobEffectInstance(MobEffects.SLOWNESS, 20*60*8, 0));
    public static final Holder.Reference<Potion> SLOWNESS_POTION_BB = registerPotion("slowness_potion_bb", new MobEffectInstance(MobEffects.SLOWNESS, 20*90, 3));
    public static final Holder.Reference<Potion> SLOWNESS_POTION_CB = registerPotion("slowness_potion_cb", new MobEffectInstance(MobEffects.SLOWNESS, 20*60*4, 3));
    public static final Holder.Reference<Potion> SLOWNESS_POTION_AC = registerPotion("slowness_potion_ac", new MobEffectInstance(MobEffects.SLOWNESS, 20*60*2, 5));
    public static final Holder.Reference<Potion> SLOWNESS_POTION_BC = registerPotion("slowness_potion_bc", new MobEffectInstance(MobEffects.SLOWNESS, 20*60*4, 5));
    public static final Holder.Reference<Potion> SLOWNESS_POTION_CC = registerPotion("slowness_potion_cc", new MobEffectInstance(MobEffects.SLOWNESS, 20*60*8, 5));

    public static final Holder.Reference<Potion> LEAPING_POTION_CA = registerPotion("leaping_potion_ca", new MobEffectInstance(MobEffects.JUMP_BOOST, 20*60*10, 0));
    public static final Holder.Reference<Potion> LEAPING_POTION_BB = registerPotion("leaping_potion_bb", new MobEffectInstance(MobEffects.JUMP_BOOST, 20*60*4, 1));
    public static final Holder.Reference<Potion> LEAPING_POTION_CB = registerPotion("leaping_potion_cb", new MobEffectInstance(MobEffects.JUMP_BOOST, 20*60*8, 1));
    public static final Holder.Reference<Potion> LEAPING_POTION_AC = registerPotion("leaping_potion_ac", new MobEffectInstance(MobEffects.JUMP_BOOST, 20*60*2, 2));
    public static final Holder.Reference<Potion> LEAPING_POTION_BC = registerPotion("leaping_potion_bc", new MobEffectInstance(MobEffects.JUMP_BOOST, 20*60*6, 2));
    public static final Holder.Reference<Potion> LEAPING_POTION_CC = registerPotion("leaping_potion_cc", new MobEffectInstance(MobEffects.JUMP_BOOST, 20*60*10, 3));

    public static final Holder.Reference<Potion> STRENGTH_POTION_CA = registerPotion("strength_potion_ca", new MobEffectInstance(MobEffects.STRENGTH, 20*60*10, 0));
    public static final Holder.Reference<Potion> STRENGTH_POTION_BB = registerPotion("strength_potion_bb", new MobEffectInstance(MobEffects.STRENGTH, 20*60*4, 1));
    public static final Holder.Reference<Potion> STRENGTH_POTION_CB = registerPotion("strength_potion_cb", new MobEffectInstance(MobEffects.STRENGTH, 20*60*8, 1));
    public static final Holder.Reference<Potion> STRENGTH_POTION_AC = registerPotion("strength_potion_ac", new MobEffectInstance(MobEffects.STRENGTH, 20*60*2, 2));
    public static final Holder.Reference<Potion> STRENGTH_POTION_BC = registerPotion("strength_potion_bc", new MobEffectInstance(MobEffects.STRENGTH, 20*60*6, 2));
    public static final Holder.Reference<Potion> STRENGTH_POTION_CC = registerPotion("strength_potion_cc", new MobEffectInstance(MobEffects.STRENGTH, 20*60*10, 3));

    public static final Holder.Reference<Potion> HEALING_POTION_C = registerPotion("healing_potion_c", new MobEffectInstance(MobEffects.INSTANT_HEALTH, 1, 3));
    public static final Holder.Reference<Potion> HARMING_POTION_C = registerPotion("harming_potion_c", new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 1, 3));

    public static final Holder.Reference<Potion> POISON_POTION_AC = registerPotion("poison_potion_ac", new MobEffectInstance(MobEffects.POISON, 20*15, 2));
    public static final Holder.Reference<Potion> POISON_POTION_BB = registerPotion("poison_potion_bb", new MobEffectInstance(MobEffects.POISON, 20*60*1, 1));
    public static final Holder.Reference<Potion> POISON_POTION_BC = registerPotion("poison_potion_bc", new MobEffectInstance(MobEffects.POISON, 20*30, 2));
    public static final Holder.Reference<Potion> POISON_POTION_CA = registerPotion("poison_potion_ca", new MobEffectInstance(MobEffects.POISON, 20*60*2, 0));
    public static final Holder.Reference<Potion> POISON_POTION_CB = registerPotion("poison_potion_cb", new MobEffectInstance(MobEffects.POISON, 20*90, 1));
    public static final Holder.Reference<Potion> POISON_POTION_CC = registerPotion("poison_potion_cc", new MobEffectInstance(MobEffects.POISON, 20*60*3, 3));

    public static final Holder.Reference<Potion> REGENERATION_POTION_AC = registerPotion("regeneration_potion_ac", new MobEffectInstance(MobEffects.REGENERATION, 20*15, 2));
    public static final Holder.Reference<Potion> REGENERATION_POTION_BB = registerPotion("regeneration_potion_bb", new MobEffectInstance(MobEffects.REGENERATION, 20*60*1, 1));
    public static final Holder.Reference<Potion> REGENERATION_POTION_BC = registerPotion("regeneration_potion_bc", new MobEffectInstance(MobEffects.REGENERATION, 20*30, 2));
    public static final Holder.Reference<Potion> REGENERATION_POTION_CA = registerPotion("regeneration_potion_ca", new MobEffectInstance(MobEffects.REGENERATION, 20*60*2, 0));
    public static final Holder.Reference<Potion> REGENERATION_POTION_CB = registerPotion("regeneration_potion_cb", new MobEffectInstance(MobEffects.REGENERATION, 20*90, 1) );
    public static final Holder.Reference<Potion> REGENERATION_POTION_CC = registerPotion("regeneration_potion_cc", new MobEffectInstance(MobEffects.REGENERATION, 20*60*3, 3) );

    public static final Holder.Reference<Potion> FIRE_RESISTANCE_POTION_C = registerPotion("fire_resistance_potion_c", new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20*60*10, 0) );
    public static final Holder.Reference<Potion> WATER_BREATHING_POTION_C = registerPotion("water_breathing_potion_c", new MobEffectInstance(MobEffects.WATER_BREATHING, 20*60*10, 0) );
    public static final Holder.Reference<Potion> NIGHT_VISION_POTION_C = registerPotion("night_vision_potion_c", new MobEffectInstance(MobEffects.NIGHT_VISION, 20*60*10, 0) );
    public static final Holder.Reference<Potion> INVISIBILITY_POTION_C = registerPotion("invisibility_potion_c", new MobEffectInstance(MobEffects.INVISIBILITY, 20*60*10, 0) );
    public static final Holder.Reference<Potion> SLOW_FALLING_POTION_C = registerPotion("slow_falling_potion_c", new MobEffectInstance(MobEffects.SLOW_FALLING, 20*60*8, 0) );

    //Functions

    private static Holder.Reference<Potion> registerPotion(String itemName, MobEffectInstance... effects) {
        return Registry.registerForHolder(
                BuiltInRegistries.POTION,
                Identifier.fromNamespaceAndPath(JuliansKitchen.MOD_ID, itemName),
                new Potion(itemName,effects));
    }


    public static void registerPotions(){
        JuliansKitchen.LOGGER.info("Registering Mod Potions for JuliansKitchen");
    }
}
