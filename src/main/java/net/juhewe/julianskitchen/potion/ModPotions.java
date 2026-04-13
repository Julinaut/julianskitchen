package net.juhewe.julianskitchen.potion;

import net.juhewe.julianskitchen.JuliansKitchen;
import net.juhewe.julianskitchen.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {

    //Potions

    public static final RegistryEntry<Potion> FIREWALK_POTION_AA = registerPotion("firewalk_potion_aa",
            new StatusEffectInstance(ModEffects.FIREWALK, 20*10, 0)
    );
    public static final RegistryEntry<Potion> FIREWALK_POTION_AB = registerPotion("firewalk_potion_ab",
            new StatusEffectInstance(ModEffects.FIREWALK, 20*10, 1)
    );
    public static final RegistryEntry<Potion> FIREWALK_POTION_AC = registerPotion("firewalk_potion_ac",
            new StatusEffectInstance(ModEffects.FIREWALK, 20*10, 2),
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*15, 0)
    );
    public static final RegistryEntry<Potion> FIREWALK_POTION_BA = registerPotion("firewalk_potion_ba",
            new StatusEffectInstance(ModEffects.FIREWALK, 20*20, 0)
    );
    public static final RegistryEntry<Potion> FIREWALK_POTION_BB = registerPotion("firewalk_potion_bb",
            new StatusEffectInstance(ModEffects.FIREWALK, 20*20, 1)
    );
    public static final RegistryEntry<Potion> FIREWALK_POTION_BC = registerPotion("firewalk_potion_bc",
            new StatusEffectInstance(ModEffects.FIREWALK, 20*20, 2),
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*25, 0)
    );
    public static final RegistryEntry<Potion> FIREWALK_POTION_CA = registerPotion("firewalk_potion_ca",
            new StatusEffectInstance(ModEffects.FIREWALK, 20*30, 0)
    );
    public static final RegistryEntry<Potion> FIREWALK_POTION_CB = registerPotion("firewalk_potion_cb",
            new StatusEffectInstance(ModEffects.FIREWALK, 20*30, 1)
    );
    public static final RegistryEntry<Potion> FIREWALK_POTION_CC = registerPotion("firewalk_potion_cc",
            new StatusEffectInstance(ModEffects.FIREWALK, 20*60, 2),
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*70, 0)
    );


    public static final RegistryEntry<Potion> SANDTRAP_POTION_A = registerPotion("sandtrap_potion_a",
            new StatusEffectInstance(ModEffects.SANDTRAP, 20+4, 0)
    );
    public static final RegistryEntry<Potion> SANDTRAP_POTION_B = registerPotion("sandtrap_potion_b",
            new StatusEffectInstance(ModEffects.SANDTRAP, 20+5, 1)
    );
    public static final RegistryEntry<Potion> SANDTRAP_POTION_C = registerPotion("sandtrap_potion_c",
            new StatusEffectInstance(ModEffects.SANDTRAP, 20+6, 2)
    );


    public static final RegistryEntry<Potion> MONSOON_POTION_A = registerPotion("monsoon_potion_a",
            new StatusEffectInstance(ModEffects.PRECIPITATION, 1, 0)
    );
    public static final RegistryEntry<Potion> MONSOON_POTION_B = registerPotion("monsoon_potion_b",
            new StatusEffectInstance(ModEffects.PRECIPITATION, 1, 1)
    );
    public static final RegistryEntry<Potion> CLEAR_SKY_POTION = registerPotion("clear_sky_potion",
            new StatusEffectInstance(ModEffects.CLEAR_SKY, 1, 0)
    );

    public static final RegistryEntry<Potion> FERTILIZE_POTION_A = registerPotion("fertilize_potion_a",
            new StatusEffectInstance(ModEffects.FERTILIZE, 20*20, 0)
    );
    public static final RegistryEntry<Potion> FERTILIZE_POTION_B = registerPotion("fertilize_potion_b",
            new StatusEffectInstance(ModEffects.FERTILIZE, 20*40, 1)
    );
    public static final RegistryEntry<Potion> FERTILIZE_POTION_C = registerPotion("fertilize_potion_c",
            new StatusEffectInstance(ModEffects.FERTILIZE, 20*60, 2)
    );

    public static final RegistryEntry<Potion> VACCINATION_POTION_A = registerPotion("vaccination_potion_a",
            new StatusEffectInstance(ModEffects.IMMUNE, 20*60*3, 0)
    );
    public static final RegistryEntry<Potion> VACCINATION_POTION_B = registerPotion("vaccination_potion_b",
            new StatusEffectInstance(ModEffects.IMMUNE, 20*60*6, 0)
    );
    public static final RegistryEntry<Potion> VACCINATION_POTION_C = registerPotion("vaccination_potion_c",
            new StatusEffectInstance(ModEffects.IMMUNE, 20*60*9, 0)
    );

    public static final RegistryEntry<Potion> SOFT_LANDING_POTION_A = registerPotion("soft_landing_potion_a",
            new StatusEffectInstance(ModEffects.SOFT_LANDING, 20*60*1, 0)
    );
    public static final RegistryEntry<Potion> SOFT_LANDING_POTION_B = registerPotion("soft_landing_potion_b",
            new StatusEffectInstance(ModEffects.SOFT_LANDING, 20*60*2, 0)
    );
    public static final RegistryEntry<Potion> SOFT_LANDING_POTION_C = registerPotion("soft_landing_potion_c",
            new StatusEffectInstance(ModEffects.SOFT_LANDING, 20*60*5, 0)
    );

    public static final RegistryEntry<Potion> COLD_FEET_POTION_AA = registerPotion("cold_feet_potion_aa",
            new StatusEffectInstance(ModEffects.COLD_FEET, 20*60*2, 0)
    );
    public static final RegistryEntry<Potion> COLD_FEET_POTION_AB = registerPotion("cold_feet_potion_ab",
            new StatusEffectInstance(ModEffects.COLD_FEET, 20*60*2, 1)
    );
    public static final RegistryEntry<Potion> COLD_FEET_POTION_AC = registerPotion("cold_feet_potion_ac",
            new StatusEffectInstance(ModEffects.COLD_FEET, 20*60*4, 2)
    );
    public static final RegistryEntry<Potion> COLD_FEET_POTION_BA = registerPotion("cold_feet_potion_ba",
            new StatusEffectInstance(ModEffects.COLD_FEET, 20*60*4, 0)
    );
    public static final RegistryEntry<Potion> COLD_FEET_POTION_BB = registerPotion("cold_feet_potion_bb",
            new StatusEffectInstance(ModEffects.COLD_FEET, 20*60*4, 1)
    );
    public static final RegistryEntry<Potion> COLD_FEET_POTION_BC = registerPotion("cold_feet_potion_bc",
            new StatusEffectInstance(ModEffects.COLD_FEET, 20*60*6, 2)
    );
    public static final RegistryEntry<Potion> COLD_FEET_POTION_CA = registerPotion("cold_feet_potion_ca",
            new StatusEffectInstance(ModEffects.COLD_FEET, 20*60*6, 0)
    );
    public static final RegistryEntry<Potion> COLD_FEET_POTION_CB = registerPotion("cold_feet_potion_cb",
            new StatusEffectInstance(ModEffects.COLD_FEET, 20*60*6, 1)
    );
    public static final RegistryEntry<Potion> COLD_FEET_POTION_CC = registerPotion("cold_feet_potion_cc",
            new StatusEffectInstance(ModEffects.COLD_FEET, 20*60*10, 2)
    );

    public static final RegistryEntry<Potion> MENDING_TOUCH_POTION_AA = registerPotion("mending_touch_potion_aa",
            new StatusEffectInstance(ModEffects.MENDING_TOUCH, 20*10, 0)
    );
    public static final RegistryEntry<Potion> MENDING_TOUCH_POTION_AB = registerPotion("mending_touch_potion_ab",
            new StatusEffectInstance(ModEffects.MENDING_TOUCH, 20*10, 1)
    );
    public static final RegistryEntry<Potion> MENDING_TOUCH_POTION_AC = registerPotion("mending_touch_potion_ac",
            new StatusEffectInstance(ModEffects.MENDING_TOUCH, 20*10, 2)
    );
    public static final RegistryEntry<Potion> MENDING_TOUCH_POTION_BA = registerPotion("mending_touch_potion_ba",
            new StatusEffectInstance(ModEffects.MENDING_TOUCH, 20*20, 0)
    );
    public static final RegistryEntry<Potion> MENDING_TOUCH_POTION_BB = registerPotion("mending_touch_potion_bb",
            new StatusEffectInstance(ModEffects.MENDING_TOUCH, 20*20, 1)
    );
    public static final RegistryEntry<Potion> MENDING_TOUCH_POTION_BC = registerPotion("mending_touch_potion_bc",
            new StatusEffectInstance(ModEffects.MENDING_TOUCH, 20*20, 2)
    );
    public static final RegistryEntry<Potion> MENDING_TOUCH_POTION_CA = registerPotion("mending_touch_potion_ca",
            new StatusEffectInstance(ModEffects.MENDING_TOUCH, 20*30, 0)
    );
    public static final RegistryEntry<Potion> MENDING_TOUCH_POTION_CB = registerPotion("mending_touch_potion_cb",
            new StatusEffectInstance(ModEffects.MENDING_TOUCH, 20*30, 1)
    );
    public static final RegistryEntry<Potion> MENDING_TOUCH_POTION_CC = registerPotion("mending_touch_potion_cc",
            new StatusEffectInstance(ModEffects.MENDING_TOUCH, 20*30, 2)
    );

    //Vanilla Effects

    public static final RegistryEntry<Potion> HASTE_POTION_AA = registerPotion("haste_potion_aa",
            new StatusEffectInstance(StatusEffects.HASTE, 20*60*1, 0)
    );
    public static final RegistryEntry<Potion> HASTE_POTION_AB = registerPotion("haste_potion_ab",
            new StatusEffectInstance(StatusEffects.HASTE, 20*60*1, 1)
    );
    public static final RegistryEntry<Potion> HASTE_POTION_AC = registerPotion("haste_potion_ac",
            new StatusEffectInstance(StatusEffects.HASTE, 20*60*1, 2)
    );
    public static final RegistryEntry<Potion> HASTE_POTION_BA = registerPotion("haste_potion_ba",
            new StatusEffectInstance(StatusEffects.HASTE, 20*60*2, 0)
    );
    public static final RegistryEntry<Potion> HASTE_POTION_BB = registerPotion("haste_potion_bb",
            new StatusEffectInstance(StatusEffects.HASTE, 20*60*2, 1)
    );
    public static final RegistryEntry<Potion> HASTE_POTION_BC = registerPotion("haste_potion_bc",
            new StatusEffectInstance(StatusEffects.HASTE, 20*60*2, 2)
    );
    public static final RegistryEntry<Potion> HASTE_POTION_CA = registerPotion("haste_potion_ca",
            new StatusEffectInstance(StatusEffects.HASTE, 20*60*3, 0)
    );
    public static final RegistryEntry<Potion> HASTE_POTION_CB = registerPotion("haste_potion_cb",
            new StatusEffectInstance(StatusEffects.HASTE, 20*60*3, 1)
    );
    public static final RegistryEntry<Potion> HASTE_POTION_CC = registerPotion("haste_potion_cc",
            new StatusEffectInstance(StatusEffects.HASTE, 20*60*5, 2)
    );

    public static final RegistryEntry<Potion> RESISTANCE_POTION_AA = registerPotion("resistance_potion_aa",
            new StatusEffectInstance(StatusEffects.RESISTANCE, 20*60*2, 0)
    );
    public static final RegistryEntry<Potion> RESISTANCE_POTION_AB = registerPotion("resistance_potion_ab",
            new StatusEffectInstance(StatusEffects.RESISTANCE, 20*60*2, 1)
    );
    public static final RegistryEntry<Potion> RESISTANCE_POTION_AC = registerPotion("resistance_potion_ac",
            new StatusEffectInstance(StatusEffects.RESISTANCE, 20*60*2, 2)
    );
    public static final RegistryEntry<Potion> RESISTANCE_POTION_BA = registerPotion("resistance_potion_ba",
            new StatusEffectInstance(StatusEffects.RESISTANCE, 20*60*4, 0)
    );
    public static final RegistryEntry<Potion> RESISTANCE_POTION_BB = registerPotion("resistance_potion_bb",
            new StatusEffectInstance(StatusEffects.RESISTANCE, 20*60*4, 1)
    );
    public static final RegistryEntry<Potion> RESISTANCE_POTION_BC = registerPotion("resistance_potion_bc",
            new StatusEffectInstance(StatusEffects.RESISTANCE, 20*60*4, 2)
    );
    public static final RegistryEntry<Potion> RESISTANCE_POTION_CA = registerPotion("resistance_potion_ca",
            new StatusEffectInstance(StatusEffects.RESISTANCE, 20*60*6, 0)
    );
    public static final RegistryEntry<Potion> RESISTANCE_POTION_CB = registerPotion("resistance_potion_cb",
            new StatusEffectInstance(StatusEffects.RESISTANCE, 20*60*6, 1)
    );
    public static final RegistryEntry<Potion> RESISTANCE_POTION_CC = registerPotion("resistance_potion_cc",
            new StatusEffectInstance(StatusEffects.RESISTANCE, 20*60*10, 2)
    );


    public static final RegistryEntry<Potion> HEALTH_BOOST_POTION_AA = registerPotion("health_boost_potion_aa",
            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20*60*2, 0)
    );
    public static final RegistryEntry<Potion> HEALTH_BOOST_POTION_AB = registerPotion("health_boost_potion_ab",
            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20*60*2, 1)
    );
    public static final RegistryEntry<Potion> HEALTH_BOOST_POTION_AC = registerPotion("health_boost_potion_ac",
            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20*60*2, 2)
    );
    public static final RegistryEntry<Potion> HEALTH_BOOST_POTION_BA = registerPotion("health_boost_potion_ba",
            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20*60*4, 0)
    );
    public static final RegistryEntry<Potion> HEALTH_BOOST_POTION_BB = registerPotion("health_boost_potion_bb",
            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20*60*4, 1)
    );
    public static final RegistryEntry<Potion> HEALTH_BOOST_POTION_BC = registerPotion("health_boost_potion_bc",
            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20*60*4, 2)
    );
    public static final RegistryEntry<Potion> HEALTH_BOOST_POTION_CA = registerPotion("health_boost_potion_ca",
            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20*60*6, 0)
    );
    public static final RegistryEntry<Potion> HEALTH_BOOST_POTION_CB = registerPotion("health_boost_potion_cb",
            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20*60*6, 1)
    );
    public static final RegistryEntry<Potion> HEALTH_BOOST_POTION_CC = registerPotion("health_boost_potion_cc",
            new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 20*60*10, 2)
    );



    public static final RegistryEntry<Potion> SATURATION_POTION_AA = registerPotion("saturation_potion_aa",
            new StatusEffectInstance(ModEffects.SATURATION, 20*60*2, 0)
    );
    public static final RegistryEntry<Potion> SATURATION_POTION_AB = registerPotion("saturation_potion_ab",
            new StatusEffectInstance(ModEffects.SATURATION, 20*60*2, 1)
    );
    public static final RegistryEntry<Potion> SATURATION_POTION_AC = registerPotion("saturation_potion_ac",
            new StatusEffectInstance(ModEffects.SATURATION, 20*60*2, 2)
    );
    public static final RegistryEntry<Potion> SATURATION_POTION_BA = registerPotion("saturation_potion_ba",
            new StatusEffectInstance(ModEffects.SATURATION, 20*60*4, 0)
    );
    public static final RegistryEntry<Potion> SATURATION_POTION_BB = registerPotion("saturation_potion_bb",
            new StatusEffectInstance(ModEffects.SATURATION, 20*60*4, 1)
    );
    public static final RegistryEntry<Potion> SATURATION_POTION_BC = registerPotion("saturation_potion_bc",
            new StatusEffectInstance(ModEffects.SATURATION, 20*60*4, 2)
    );
    public static final RegistryEntry<Potion> SATURATION_POTION_CA = registerPotion("saturation_potion_ca",
            new StatusEffectInstance(ModEffects.SATURATION, 20*60*6, 0)
    );
    public static final RegistryEntry<Potion> SATURATION_POTION_CB = registerPotion("saturation_potion_cb",
            new StatusEffectInstance(ModEffects.SATURATION, 20*60*6, 1)
    );
    public static final RegistryEntry<Potion> SATURATION_POTION_CC = registerPotion("saturation_potion_cc",
            new StatusEffectInstance(ModEffects.SATURATION, 20*60*10, 2)
    );





    public static final RegistryEntry<Potion> GLOWING_POTION_A = registerPotion("glowing_potion_a",
            new StatusEffectInstance(StatusEffects.GLOWING, 20*60*1, 0)
    );
    public static final RegistryEntry<Potion> GLOWING_POTION_B = registerPotion("glowing_potion_b",
            new StatusEffectInstance(StatusEffects.GLOWING, 20*60*2, 0)
    );
    public static final RegistryEntry<Potion> GLOWING_POTION_C = registerPotion("glowing_potion_c",
            new StatusEffectInstance(StatusEffects.GLOWING, 20*60*3, 0)
    );





    public static final RegistryEntry<Potion> LEVITATION_POTION_AA = registerPotion("levitation_potion_aa",
            new StatusEffectInstance(StatusEffects.LEVITATION, 20*30, 0)
    );
    public static final RegistryEntry<Potion> LEVITATION_POTION_AB = registerPotion("levitation_potion_ab",
            new StatusEffectInstance(StatusEffects.LEVITATION, 20*30, 1)
    );
    public static final RegistryEntry<Potion> LEVITATION_POTION_AC = registerPotion("levitation_potion_ac",
            new StatusEffectInstance(StatusEffects.LEVITATION, 20*30, 2)
    );
    public static final RegistryEntry<Potion> LEVITATION_POTION_BA = registerPotion("levitation_potion_ba",
            new StatusEffectInstance(StatusEffects.LEVITATION, 20*60, 0)
    );
    public static final RegistryEntry<Potion> LEVITATION_POTION_BB = registerPotion("levitation_potion_bb",
            new StatusEffectInstance(StatusEffects.LEVITATION, 20*60, 1)
    );
    public static final RegistryEntry<Potion> LEVITATION_POTION_BC = registerPotion("levitation_potion_bc",
            new StatusEffectInstance(StatusEffects.LEVITATION, 20*60, 2)
    );
    public static final RegistryEntry<Potion> LEVITATION_POTION_CA = registerPotion("levitation_potion_ca",
            new StatusEffectInstance(StatusEffects.LEVITATION, 20*90, 0)
    );
    public static final RegistryEntry<Potion> LEVITATION_POTION_CB = registerPotion("levitation_potion_cb",
            new StatusEffectInstance(StatusEffects.LEVITATION, 20*90, 1)
    );
    public static final RegistryEntry<Potion> LEVITATION_POTION_CC = registerPotion("levitation_potion_cc",
            new StatusEffectInstance(StatusEffects.LEVITATION, 20*100, 2)
    );



    public static final RegistryEntry<Potion> LUCK_POTION_AA = registerPotion("luck_potion_aa",
            new StatusEffectInstance(StatusEffects.LUCK, 20*60*2, 0)
    );
    public static final RegistryEntry<Potion> LUCK_POTION_AB = registerPotion("luck_potion_ab",
            new StatusEffectInstance(StatusEffects.LUCK, 20*60*2, 1)
    );
    public static final RegistryEntry<Potion> LUCK_POTION_AC = registerPotion("luck_potion_ac",
            new StatusEffectInstance(StatusEffects.LUCK, 20*60*2, 2)
    );
    public static final RegistryEntry<Potion> LUCK_POTION_BA = registerPotion("luck_potion_ba",
            new StatusEffectInstance(StatusEffects.LUCK, 20*60*4, 0)
    );
    public static final RegistryEntry<Potion> LUCK_POTION_BB = registerPotion("luck_potion_bb",
            new StatusEffectInstance(StatusEffects.LUCK, 20*60*4, 1)
    );
    public static final RegistryEntry<Potion> LUCK_POTION_BC = registerPotion("luck_potion_bc",
            new StatusEffectInstance(StatusEffects.LUCK, 20*60*4, 2)
    );
    public static final RegistryEntry<Potion> LUCK_POTION_CA = registerPotion("luck_potion_ca",
            new StatusEffectInstance(StatusEffects.LUCK, 20*60*5, 0)
    );
    public static final RegistryEntry<Potion> LUCK_POTION_CB = registerPotion("luck_potion_cb",
            new StatusEffectInstance(StatusEffects.LUCK, 20*60*5, 1)
    );
    public static final RegistryEntry<Potion> LUCK_POTION_CC = registerPotion("luck_potion_cc",
            new StatusEffectInstance(StatusEffects.LUCK, 20*60*6, 2)
    );

    //Vanilla Extensions

    public static final RegistryEntry<Potion> WEAKNESS_POTION_CA = registerPotion("weakness_potion_ca",
            new StatusEffectInstance(StatusEffects.WEAKNESS, 20*60*8, 0)
    );
    public static final RegistryEntry<Potion> WEAKNESS_POTION_AB = registerPotion("weakness_potion_ab",
            new StatusEffectInstance(StatusEffects.WEAKNESS, 20*90, 1)
    );
    public static final RegistryEntry<Potion> WEAKNESS_POTION_BB = registerPotion("weakness_potion_bb",
            new StatusEffectInstance(StatusEffects.WEAKNESS, 20*60*4, 1)
    );
    public static final RegistryEntry<Potion> WEAKNESS_POTION_CB = registerPotion("weakness_potion_cb",
            new StatusEffectInstance(StatusEffects.WEAKNESS, 20*60*8, 1)
    );
    public static final RegistryEntry<Potion> WEAKNESS_POTION_AC = registerPotion("weakness_potion_ac",
            new StatusEffectInstance(StatusEffects.WEAKNESS, 20*60*2, 2)
    );
    public static final RegistryEntry<Potion> WEAKNESS_POTION_BC = registerPotion("weakness_potion_bc",
            new StatusEffectInstance(StatusEffects.WEAKNESS, 20*60*6, 2)
    );
    public static final RegistryEntry<Potion> WEAKNESS_POTION_CC = registerPotion("weakness_potion_cc",
            new StatusEffectInstance(StatusEffects.WEAKNESS, 20*60*10, 3)
    );

    public static final RegistryEntry<Potion> SPEED_POTION_CA = registerPotion("speed_potion_ca",
            new StatusEffectInstance(StatusEffects.SPEED, 20*60*10, 0)
    );
    public static final RegistryEntry<Potion> SPEED_POTION_BB = registerPotion("speed_potion_bb",
            new StatusEffectInstance(StatusEffects.SPEED, 20*60*4, 1)
    );
    public static final RegistryEntry<Potion> SPEED_POTION_CB = registerPotion("speed_potion_cb",
            new StatusEffectInstance(StatusEffects.SPEED, 20*60*8, 1)
    );
    public static final RegistryEntry<Potion> SPEED_POTION_AC = registerPotion("speed_potion_ac",
            new StatusEffectInstance(StatusEffects.SPEED, 20*60*2, 2)
    );
    public static final RegistryEntry<Potion> SPEED_POTION_BC = registerPotion("speed_potion_bc",
            new StatusEffectInstance(StatusEffects.SPEED, 20*60*6, 2)
    );
    public static final RegistryEntry<Potion> SPEED_POTION_CC = registerPotion("speed_potion_cc",
            new StatusEffectInstance(StatusEffects.SPEED, 20*60*10, 3)
    );

    public static final RegistryEntry<Potion> SLOWNESS_POTION_CA = registerPotion("slowness_potion_ca",
            new StatusEffectInstance(StatusEffects.SLOWNESS, 20*60*8, 0)
    );
    public static final RegistryEntry<Potion> SLOWNESS_POTION_BB = registerPotion("slowness_potion_bb",
            new StatusEffectInstance(StatusEffects.SLOWNESS, 20*90, 3)
    );
    public static final RegistryEntry<Potion> SLOWNESS_POTION_CB = registerPotion("slowness_potion_cb",
            new StatusEffectInstance(StatusEffects.SLOWNESS, 20*60*4, 3)
    );
    public static final RegistryEntry<Potion> SLOWNESS_POTION_AC = registerPotion("slowness_potion_ac",
            new StatusEffectInstance(StatusEffects.SLOWNESS, 20*60*2, 5)
    );
    public static final RegistryEntry<Potion> SLOWNESS_POTION_BC = registerPotion("slowness_potion_bc",
            new StatusEffectInstance(StatusEffects.SLOWNESS, 20*60*4, 5)
    );
    public static final RegistryEntry<Potion> SLOWNESS_POTION_CC = registerPotion("slowness_potion_cc",
            new StatusEffectInstance(StatusEffects.SLOWNESS, 20*60*8, 5)
    );

    public static final RegistryEntry<Potion> LEAPING_POTION_CA = registerPotion("leaping_potion_ca",
            new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20*60*10, 0)
    );
    public static final RegistryEntry<Potion> LEAPING_POTION_BB = registerPotion("leaping_potion_bb",
            new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20*60*4, 1)
    );
    public static final RegistryEntry<Potion> LEAPING_POTION_CB = registerPotion("leaping_potion_cb",
            new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20*60*8, 1)
    );
    public static final RegistryEntry<Potion> LEAPING_POTION_AC = registerPotion("leaping_potion_ac",
            new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20*60*2, 2)
    );
    public static final RegistryEntry<Potion> LEAPING_POTION_BC = registerPotion("leaping_potion_bc",
            new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20*60*6, 2)
    );
    public static final RegistryEntry<Potion> LEAPING_POTION_CC = registerPotion("leaping_potion_cc",
            new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20*60*10, 3)
    );

    public static final RegistryEntry<Potion> STRENGTH_POTION_CA = registerPotion("strength_potion_ca",
            new StatusEffectInstance(StatusEffects.STRENGTH, 20*60*10, 0)
    );
    public static final RegistryEntry<Potion> STRENGTH_POTION_BB = registerPotion("strength_potion_bb",
            new StatusEffectInstance(StatusEffects.STRENGTH, 20*60*4, 1)
    );
    public static final RegistryEntry<Potion> STRENGTH_POTION_CB = registerPotion("strength_potion_cb",
            new StatusEffectInstance(StatusEffects.STRENGTH, 20*60*8, 1)
    );
    public static final RegistryEntry<Potion> STRENGTH_POTION_AC = registerPotion("strength_potion_ac",
            new StatusEffectInstance(StatusEffects.STRENGTH, 20*60*2, 2)
    );
    public static final RegistryEntry<Potion> STRENGTH_POTION_BC = registerPotion("strength_potion_bc",
            new StatusEffectInstance(StatusEffects.STRENGTH, 20*60*6, 2)
    );
    public static final RegistryEntry<Potion> STRENGTH_POTION_CC = registerPotion("strength_potion_cc",
            new StatusEffectInstance(StatusEffects.STRENGTH, 20*60*10, 3)
    );

    public static final RegistryEntry<Potion> HEALING_POTION_C = registerPotion("healing_potion_c",
            new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 3)
    );

    public static final RegistryEntry<Potion> HARMING_POTION_C = registerPotion("harming_potion_c",
            new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 3)
    );

    public static final RegistryEntry<Potion> POISON_POTION_AC = registerPotion("poison_potion_ac",
            new StatusEffectInstance(StatusEffects.POISON, 20*15, 2)
    );
    public static final RegistryEntry<Potion> POISON_POTION_BB = registerPotion("poison_potion_bb",
            new StatusEffectInstance(StatusEffects.POISON, 20*60*1, 1)
    );
    public static final RegistryEntry<Potion> POISON_POTION_BC = registerPotion("poison_potion_bc",
            new StatusEffectInstance(StatusEffects.POISON, 20*30, 2)
    );
    public static final RegistryEntry<Potion> POISON_POTION_CA = registerPotion("poison_potion_ca",
            new StatusEffectInstance(StatusEffects.POISON, 20*60*2, 0)
    );
    public static final RegistryEntry<Potion> POISON_POTION_CB = registerPotion("poison_potion_cb",
            new StatusEffectInstance(StatusEffects.POISON, 20*90, 1)
    );
    public static final RegistryEntry<Potion> POISON_POTION_CC = registerPotion("poison_potion_cc",
            new StatusEffectInstance(StatusEffects.POISON, 20*60*3, 3)
    );

    public static final RegistryEntry<Potion> REGENERATION_POTION_AC = registerPotion("regeneration_potion_ac",
            new StatusEffectInstance(StatusEffects.REGENERATION, 20*15, 2)
    );
    public static final RegistryEntry<Potion> REGENERATION_POTION_BB = registerPotion("regeneration_potion_bb",
            new StatusEffectInstance(StatusEffects.REGENERATION, 20*60*1, 1)
    );
    public static final RegistryEntry<Potion> REGENERATION_POTION_BC = registerPotion("regeneration_potion_bc",
            new StatusEffectInstance(StatusEffects.REGENERATION, 20*30, 2)
    );
    public static final RegistryEntry<Potion> REGENERATION_POTION_CA = registerPotion("regeneration_potion_ca",
            new StatusEffectInstance(StatusEffects.REGENERATION, 20*60*2, 0)
    );
    public static final RegistryEntry<Potion> REGENERATION_POTION_CB = registerPotion("regeneration_potion_cb",
            new StatusEffectInstance(StatusEffects.REGENERATION, 20*90, 1)
    );
    public static final RegistryEntry<Potion> REGENERATION_POTION_CC = registerPotion("regeneration_potion_cc",
            new StatusEffectInstance(StatusEffects.REGENERATION, 20*60*3, 3)
    );

    public static final RegistryEntry<Potion> FIRE_RESISTANCE_POTION_C = registerPotion("fire_resistance_potion_c",
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20*60*10, 0)
    );

    public static final RegistryEntry<Potion> WATER_BREATHING_POTION_C = registerPotion("water_breathing_potion_c",
            new StatusEffectInstance(StatusEffects.WATER_BREATHING, 20*60*10, 0)
    );

    public static final RegistryEntry<Potion> NIGHT_VISION_POTION_C = registerPotion("night_vision_potion_c",
            new StatusEffectInstance(StatusEffects.NIGHT_VISION, 20*60*10, 0)
    );

    public static final RegistryEntry<Potion> INVISIBILITY_POTION_C = registerPotion("invisibility_potion_c",
            new StatusEffectInstance(StatusEffects.INVISIBILITY, 20*60*10, 0)
    );

    public static final RegistryEntry<Potion> SLOW_FALLING_POTION_C = registerPotion("slow_falling_potion_c",
            new StatusEffectInstance(StatusEffects.SLOW_FALLING, 20*60*8, 0)
    );



    //Functions
    private static RegistryEntry<Potion> registerPotion(String itemName, StatusEffectInstance... effects) {

        Potion potion = new Potion(itemName, effects);
        return Registry.registerReference(Registries.POTION, Identifier.of(JuliansKitchen.MOD_ID, itemName), potion);
    }

    public static void registerPotions(){
        JuliansKitchen.LOGGER.info("Registering Mod Potions for JuliansKitchen");
    }
}
