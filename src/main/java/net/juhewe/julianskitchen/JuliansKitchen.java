package net.juhewe.julianskitchen;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.juhewe.julianskitchen.component.ModDataComponentTypes;
import net.juhewe.julianskitchen.effect.ModEffects;
import net.juhewe.julianskitchen.item.ModItems;
import net.juhewe.julianskitchen.potion.ModPotions;
import net.juhewe.julianskitchen.sound.ModSounds;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.entry.RegistryEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JuliansKitchen implements ModInitializer {
	public static final String MOD_ID = "julianskitchen";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModGamerules.registerModGameRules();
		ModServerTickListener.registerModServerTickListener();
		ModSounds.registerSounds();
		ModEffects.registerEffects();
		ModPotions.registerPotions();
		ModDataComponentTypes.registerDataComponentTypes();
		ModItems.registerModItems();

		registerPotionRecipe(Potions.AWKWARD, Items.FERMENTED_SPIDER_EYE, ModPotions.FERTILIZE_POTION_A);
		registerPotionRecipe(ModPotions.FERTILIZE_POTION_A, Items.REDSTONE, ModPotions.FERTILIZE_POTION_B);
		registerPotionRecipe(ModPotions.FERTILIZE_POTION_B, Items.REDSTONE, ModPotions.FERTILIZE_POTION_C);

		registerPotionRecipe(Potions.AWKWARD, Items.POISONOUS_POTATO, ModPotions.VACCINATION_POTION_A);
		registerPotionRecipe(ModPotions.VACCINATION_POTION_A, Items.REDSTONE, ModPotions.VACCINATION_POTION_B);
		registerPotionRecipe(ModPotions.VACCINATION_POTION_B, Items.REDSTONE, ModPotions.VACCINATION_POTION_C);

		registerPotionRecipe(Potions.AWKWARD, Items.WHITE_WOOL, ModPotions.SOFT_LANDING_POTION_A);
		registerPotionRecipe(Potions.AWKWARD, Items.ORANGE_WOOL, ModPotions.SOFT_LANDING_POTION_A);
		registerPotionRecipe(Potions.AWKWARD, Items.MAGENTA_WOOL, ModPotions.SOFT_LANDING_POTION_A);
		registerPotionRecipe(Potions.AWKWARD, Items.LIGHT_BLUE_WOOL, ModPotions.SOFT_LANDING_POTION_A);
		registerPotionRecipe(Potions.AWKWARD, Items.YELLOW_WOOL, ModPotions.SOFT_LANDING_POTION_A);
		registerPotionRecipe(Potions.AWKWARD, Items.LIME_WOOL, ModPotions.SOFT_LANDING_POTION_A);
		registerPotionRecipe(Potions.AWKWARD, Items.PINK_WOOL, ModPotions.SOFT_LANDING_POTION_A);
		registerPotionRecipe(Potions.AWKWARD, Items.GRAY_WOOL, ModPotions.SOFT_LANDING_POTION_A);
		registerPotionRecipe(Potions.AWKWARD, Items.LIGHT_GRAY_WOOL, ModPotions.SOFT_LANDING_POTION_A);
		registerPotionRecipe(Potions.AWKWARD, Items.CYAN_WOOL, ModPotions.SOFT_LANDING_POTION_A);
		registerPotionRecipe(Potions.AWKWARD, Items.PURPLE_WOOL, ModPotions.SOFT_LANDING_POTION_A);
		registerPotionRecipe(Potions.AWKWARD, Items.BLUE_WOOL, ModPotions.SOFT_LANDING_POTION_A);
		registerPotionRecipe(Potions.AWKWARD, Items.BROWN_WOOL, ModPotions.SOFT_LANDING_POTION_A);
		registerPotionRecipe(Potions.AWKWARD, Items.GREEN_WOOL, ModPotions.SOFT_LANDING_POTION_A);
		registerPotionRecipe(Potions.AWKWARD, Items.RED_WOOL, ModPotions.SOFT_LANDING_POTION_A);
		registerPotionRecipe(Potions.AWKWARD, Items.LIGHT_BLUE_WOOL, ModPotions.SOFT_LANDING_POTION_A);
		registerPotionRecipe(ModPotions.SOFT_LANDING_POTION_A, Items.REDSTONE, ModPotions.SOFT_LANDING_POTION_B);
		registerPotionRecipe(ModPotions.SOFT_LANDING_POTION_B, Items.REDSTONE, ModPotions.SOFT_LANDING_POTION_C);

		registerPotionRecipe(Potions.AWKWARD, Items.POWDER_SNOW_BUCKET, ModPotions.COLD_FEET_POTION_AA);
		registerPotionRecipe(ModPotions.COLD_FEET_POTION_AA, Items.REDSTONE, ModPotions.COLD_FEET_POTION_BA);
		registerPotionRecipe(ModPotions.COLD_FEET_POTION_AB, Items.REDSTONE, ModPotions.COLD_FEET_POTION_BB);
		registerPotionRecipe(ModPotions.COLD_FEET_POTION_AC, Items.REDSTONE, ModPotions.COLD_FEET_POTION_BC);
		registerPotionRecipe(ModPotions.COLD_FEET_POTION_BA, Items.REDSTONE, ModPotions.COLD_FEET_POTION_CA);
		registerPotionRecipe(ModPotions.COLD_FEET_POTION_BB, Items.REDSTONE, ModPotions.COLD_FEET_POTION_CB);
		registerPotionRecipe(ModPotions.COLD_FEET_POTION_BC, Items.REDSTONE, ModPotions.COLD_FEET_POTION_CC);
		registerPotionRecipe(ModPotions.COLD_FEET_POTION_AA, Items.GLOWSTONE_DUST, ModPotions.COLD_FEET_POTION_AB);
		registerPotionRecipe(ModPotions.COLD_FEET_POTION_BA, Items.GLOWSTONE_DUST, ModPotions.COLD_FEET_POTION_BB);
		registerPotionRecipe(ModPotions.COLD_FEET_POTION_CA, Items.GLOWSTONE_DUST, ModPotions.COLD_FEET_POTION_CB);
		registerPotionRecipe(ModPotions.COLD_FEET_POTION_AB, Items.GLOWSTONE_DUST, ModPotions.COLD_FEET_POTION_AC);
		registerPotionRecipe(ModPotions.COLD_FEET_POTION_BB, Items.GLOWSTONE_DUST, ModPotions.COLD_FEET_POTION_BC);
		registerPotionRecipe(ModPotions.COLD_FEET_POTION_CB, Items.GLOWSTONE_DUST, ModPotions.COLD_FEET_POTION_CC);

		registerPotionRecipe(Potions.AWKWARD, Items.RESIN_CLUMP, ModPotions.MENDING_TOUCH_POTION_AA);
		registerPotionRecipe(ModPotions.MENDING_TOUCH_POTION_AA, Items.REDSTONE, ModPotions.MENDING_TOUCH_POTION_BA);
		registerPotionRecipe(ModPotions.MENDING_TOUCH_POTION_AB, Items.REDSTONE, ModPotions.MENDING_TOUCH_POTION_BB);
		registerPotionRecipe(ModPotions.MENDING_TOUCH_POTION_AC, Items.REDSTONE, ModPotions.MENDING_TOUCH_POTION_BC);
		registerPotionRecipe(ModPotions.MENDING_TOUCH_POTION_BA, Items.REDSTONE, ModPotions.MENDING_TOUCH_POTION_CA);
		registerPotionRecipe(ModPotions.MENDING_TOUCH_POTION_BB, Items.REDSTONE, ModPotions.MENDING_TOUCH_POTION_CB);
		registerPotionRecipe(ModPotions.MENDING_TOUCH_POTION_BC, Items.REDSTONE, ModPotions.MENDING_TOUCH_POTION_CC);
		registerPotionRecipe(ModPotions.MENDING_TOUCH_POTION_AA, Items.GLOWSTONE_DUST, ModPotions.MENDING_TOUCH_POTION_AB);
		registerPotionRecipe(ModPotions.MENDING_TOUCH_POTION_BA, Items.GLOWSTONE_DUST, ModPotions.MENDING_TOUCH_POTION_BB);
		registerPotionRecipe(ModPotions.MENDING_TOUCH_POTION_CA, Items.GLOWSTONE_DUST, ModPotions.MENDING_TOUCH_POTION_CB);
		registerPotionRecipe(ModPotions.MENDING_TOUCH_POTION_AB, Items.GLOWSTONE_DUST, ModPotions.MENDING_TOUCH_POTION_AC);
		registerPotionRecipe(ModPotions.MENDING_TOUCH_POTION_BB, Items.GLOWSTONE_DUST, ModPotions.MENDING_TOUCH_POTION_BC);
		registerPotionRecipe(ModPotions.MENDING_TOUCH_POTION_CB, Items.GLOWSTONE_DUST, ModPotions.MENDING_TOUCH_POTION_CC);

		registerPotionRecipe(Potions.AWKWARD, Items.SWEET_BERRIES, ModPotions.HASTE_POTION_AA);
		registerPotionRecipe(ModPotions.HASTE_POTION_AA, Items.REDSTONE, ModPotions.HASTE_POTION_BA);
		registerPotionRecipe(ModPotions.HASTE_POTION_AB, Items.REDSTONE, ModPotions.HASTE_POTION_BB);
		registerPotionRecipe(ModPotions.HASTE_POTION_AC, Items.REDSTONE, ModPotions.HASTE_POTION_BC);
		registerPotionRecipe(ModPotions.HASTE_POTION_BA, Items.REDSTONE, ModPotions.HASTE_POTION_CA);
		registerPotionRecipe(ModPotions.HASTE_POTION_BB, Items.REDSTONE, ModPotions.HASTE_POTION_CB);
		registerPotionRecipe(ModPotions.HASTE_POTION_BC, Items.REDSTONE, ModPotions.HASTE_POTION_CC);
		registerPotionRecipe(ModPotions.HASTE_POTION_AA, Items.GLOWSTONE_DUST, ModPotions.HASTE_POTION_AB);
		registerPotionRecipe(ModPotions.HASTE_POTION_BA, Items.GLOWSTONE_DUST, ModPotions.HASTE_POTION_BB);
		registerPotionRecipe(ModPotions.HASTE_POTION_CA, Items.GLOWSTONE_DUST, ModPotions.HASTE_POTION_CB);
		registerPotionRecipe(ModPotions.HASTE_POTION_AB, Items.GLOWSTONE_DUST, ModPotions.HASTE_POTION_AC);
		registerPotionRecipe(ModPotions.HASTE_POTION_BB, Items.GLOWSTONE_DUST, ModPotions.HASTE_POTION_BC);
		registerPotionRecipe(ModPotions.HASTE_POTION_CB, Items.GLOWSTONE_DUST, ModPotions.HASTE_POTION_CC);

		registerPotionRecipe(Potions.AWKWARD, Items.APPLE, ModPotions.RESISTANCE_POTION_AA);
		registerPotionRecipe(ModPotions.RESISTANCE_POTION_AA, Items.REDSTONE, ModPotions.RESISTANCE_POTION_BA);
		registerPotionRecipe(ModPotions.RESISTANCE_POTION_AB, Items.REDSTONE, ModPotions.RESISTANCE_POTION_BB);
		registerPotionRecipe(ModPotions.RESISTANCE_POTION_AC, Items.REDSTONE, ModPotions.RESISTANCE_POTION_BC);
		registerPotionRecipe(ModPotions.RESISTANCE_POTION_BA, Items.REDSTONE, ModPotions.RESISTANCE_POTION_CA);
		registerPotionRecipe(ModPotions.RESISTANCE_POTION_BB, Items.REDSTONE, ModPotions.RESISTANCE_POTION_CB);
		registerPotionRecipe(ModPotions.RESISTANCE_POTION_BC, Items.REDSTONE, ModPotions.RESISTANCE_POTION_CC);
		registerPotionRecipe(ModPotions.RESISTANCE_POTION_AA, Items.GLOWSTONE_DUST, ModPotions.RESISTANCE_POTION_AB);
		registerPotionRecipe(ModPotions.RESISTANCE_POTION_BA, Items.GLOWSTONE_DUST, ModPotions.RESISTANCE_POTION_BB);
		registerPotionRecipe(ModPotions.RESISTANCE_POTION_CA, Items.GLOWSTONE_DUST, ModPotions.RESISTANCE_POTION_CB);
		registerPotionRecipe(ModPotions.RESISTANCE_POTION_AB, Items.GLOWSTONE_DUST, ModPotions.RESISTANCE_POTION_AC);
		registerPotionRecipe(ModPotions.RESISTANCE_POTION_BB, Items.GLOWSTONE_DUST, ModPotions.RESISTANCE_POTION_BC);
		registerPotionRecipe(ModPotions.RESISTANCE_POTION_CB, Items.GLOWSTONE_DUST, ModPotions.RESISTANCE_POTION_CC);

		registerPotionRecipe(Potions.AWKWARD, Items.HONEY_BOTTLE, ModPotions.HEALTH_BOOST_POTION_AA);
		registerPotionRecipe(ModPotions.HEALTH_BOOST_POTION_AA, Items.REDSTONE, ModPotions.HEALTH_BOOST_POTION_BA);
		registerPotionRecipe(ModPotions.HEALTH_BOOST_POTION_AB, Items.REDSTONE, ModPotions.HEALTH_BOOST_POTION_BB);
		registerPotionRecipe(ModPotions.HEALTH_BOOST_POTION_AC, Items.REDSTONE, ModPotions.HEALTH_BOOST_POTION_BC);
		registerPotionRecipe(ModPotions.HEALTH_BOOST_POTION_BA, Items.REDSTONE, ModPotions.HEALTH_BOOST_POTION_CA);
		registerPotionRecipe(ModPotions.HEALTH_BOOST_POTION_BB, Items.REDSTONE, ModPotions.HEALTH_BOOST_POTION_CB);
		registerPotionRecipe(ModPotions.HEALTH_BOOST_POTION_BC, Items.REDSTONE, ModPotions.HEALTH_BOOST_POTION_CC);
		registerPotionRecipe(ModPotions.HEALTH_BOOST_POTION_AA, Items.GLOWSTONE_DUST, ModPotions.HEALTH_BOOST_POTION_AB);
		registerPotionRecipe(ModPotions.HEALTH_BOOST_POTION_BA, Items.GLOWSTONE_DUST, ModPotions.HEALTH_BOOST_POTION_BB);
		registerPotionRecipe(ModPotions.HEALTH_BOOST_POTION_CA, Items.GLOWSTONE_DUST, ModPotions.HEALTH_BOOST_POTION_CB);
		registerPotionRecipe(ModPotions.HEALTH_BOOST_POTION_AB, Items.GLOWSTONE_DUST, ModPotions.HEALTH_BOOST_POTION_AC);
		registerPotionRecipe(ModPotions.HEALTH_BOOST_POTION_BB, Items.GLOWSTONE_DUST, ModPotions.HEALTH_BOOST_POTION_BC);
		registerPotionRecipe(ModPotions.HEALTH_BOOST_POTION_CB, Items.GLOWSTONE_DUST, ModPotions.HEALTH_BOOST_POTION_CC);

		registerPotionRecipe(Potions.AWKWARD, Items.BROWN_MUSHROOM, ModPotions.SATURATION_POTION_AA);
		registerPotionRecipe(Potions.AWKWARD, Items.RED_MUSHROOM, ModPotions.SATURATION_POTION_AA);
		registerPotionRecipe(Potions.AWKWARD, Items.WARPED_FUNGUS, ModPotions.SATURATION_POTION_AA);
		registerPotionRecipe(Potions.AWKWARD, Items.CRIMSON_FUNGUS, ModPotions.SATURATION_POTION_AA);
		registerPotionRecipe(ModPotions.SATURATION_POTION_AA, Items.REDSTONE, ModPotions.SATURATION_POTION_BA);
		registerPotionRecipe(ModPotions.SATURATION_POTION_AB, Items.REDSTONE, ModPotions.SATURATION_POTION_BB);
		registerPotionRecipe(ModPotions.SATURATION_POTION_AC, Items.REDSTONE, ModPotions.SATURATION_POTION_BC);
		registerPotionRecipe(ModPotions.SATURATION_POTION_BA, Items.REDSTONE, ModPotions.SATURATION_POTION_CA);
		registerPotionRecipe(ModPotions.SATURATION_POTION_BB, Items.REDSTONE, ModPotions.SATURATION_POTION_CB);
		registerPotionRecipe(ModPotions.SATURATION_POTION_BC, Items.REDSTONE, ModPotions.SATURATION_POTION_CC);
		registerPotionRecipe(ModPotions.SATURATION_POTION_AA, Items.GLOWSTONE_DUST, ModPotions.SATURATION_POTION_AB);
		registerPotionRecipe(ModPotions.SATURATION_POTION_BA, Items.GLOWSTONE_DUST, ModPotions.SATURATION_POTION_BB);
		registerPotionRecipe(ModPotions.SATURATION_POTION_CA, Items.GLOWSTONE_DUST, ModPotions.SATURATION_POTION_CB);
		registerPotionRecipe(ModPotions.SATURATION_POTION_AB, Items.GLOWSTONE_DUST, ModPotions.SATURATION_POTION_AC);
		registerPotionRecipe(ModPotions.SATURATION_POTION_BB, Items.GLOWSTONE_DUST, ModPotions.SATURATION_POTION_BC);
		registerPotionRecipe(ModPotions.SATURATION_POTION_CB, Items.GLOWSTONE_DUST, ModPotions.SATURATION_POTION_CC);

		registerPotionRecipe(Potions.AWKWARD, Items.GLOW_BERRIES, ModPotions.GLOWING_POTION_A);
		registerPotionRecipe(ModPotions.GLOWING_POTION_A, Items.REDSTONE, ModPotions.GLOWING_POTION_B);
		registerPotionRecipe(ModPotions.GLOWING_POTION_B, Items.REDSTONE, ModPotions.GLOWING_POTION_C);

		registerPotionRecipe(Potions.AWKWARD, Items.ENDER_EYE, ModPotions.LEVITATION_POTION_AA);
		registerPotionRecipe(ModPotions.LEVITATION_POTION_AA, Items.REDSTONE, ModPotions.LEVITATION_POTION_BA);
		registerPotionRecipe(ModPotions.LEVITATION_POTION_AB, Items.REDSTONE, ModPotions.LEVITATION_POTION_BB);
		registerPotionRecipe(ModPotions.LEVITATION_POTION_AC, Items.REDSTONE, ModPotions.LEVITATION_POTION_BC);
		registerPotionRecipe(ModPotions.LEVITATION_POTION_BA, Items.REDSTONE, ModPotions.LEVITATION_POTION_CA);
		registerPotionRecipe(ModPotions.LEVITATION_POTION_BB, Items.REDSTONE, ModPotions.LEVITATION_POTION_CB);
		registerPotionRecipe(ModPotions.LEVITATION_POTION_BC, Items.REDSTONE, ModPotions.LEVITATION_POTION_CC);
		registerPotionRecipe(ModPotions.LEVITATION_POTION_AA, Items.GLOWSTONE_DUST, ModPotions.LEVITATION_POTION_AB);
		registerPotionRecipe(ModPotions.LEVITATION_POTION_BA, Items.GLOWSTONE_DUST, ModPotions.LEVITATION_POTION_BB);
		registerPotionRecipe(ModPotions.LEVITATION_POTION_CA, Items.GLOWSTONE_DUST, ModPotions.LEVITATION_POTION_CB);
		registerPotionRecipe(ModPotions.LEVITATION_POTION_AB, Items.GLOWSTONE_DUST, ModPotions.LEVITATION_POTION_AC);
		registerPotionRecipe(ModPotions.LEVITATION_POTION_BB, Items.GLOWSTONE_DUST, ModPotions.LEVITATION_POTION_BC);
		registerPotionRecipe(ModPotions.LEVITATION_POTION_CB, Items.GLOWSTONE_DUST, ModPotions.LEVITATION_POTION_CC);

		registerPotionRecipe(Potions.AWKWARD, Items.ENDER_PEARL, ModPotions.LUCK_POTION_AA);
		registerPotionRecipe(ModPotions.LUCK_POTION_AA, Items.REDSTONE, ModPotions.LUCK_POTION_BA);
		registerPotionRecipe(ModPotions.LUCK_POTION_AB, Items.REDSTONE, ModPotions.LUCK_POTION_BB);
		registerPotionRecipe(ModPotions.LUCK_POTION_AC, Items.REDSTONE, ModPotions.LUCK_POTION_BC);
		registerPotionRecipe(ModPotions.LUCK_POTION_BA, Items.REDSTONE, ModPotions.LUCK_POTION_CA);
		registerPotionRecipe(ModPotions.LUCK_POTION_BB, Items.REDSTONE, ModPotions.LUCK_POTION_CB);
		registerPotionRecipe(ModPotions.LUCK_POTION_BC, Items.REDSTONE, ModPotions.LUCK_POTION_CC);
		registerPotionRecipe(ModPotions.LUCK_POTION_AA, Items.GLOWSTONE_DUST, ModPotions.LUCK_POTION_AB);
		registerPotionRecipe(ModPotions.LUCK_POTION_BA, Items.GLOWSTONE_DUST, ModPotions.LUCK_POTION_BB);
		registerPotionRecipe(ModPotions.LUCK_POTION_CA, Items.GLOWSTONE_DUST, ModPotions.LUCK_POTION_CB);
		registerPotionRecipe(ModPotions.LUCK_POTION_AB, Items.GLOWSTONE_DUST, ModPotions.LUCK_POTION_AC);
		registerPotionRecipe(ModPotions.LUCK_POTION_BB, Items.GLOWSTONE_DUST, ModPotions.LUCK_POTION_BC);
		registerPotionRecipe(ModPotions.LUCK_POTION_CB, Items.GLOWSTONE_DUST, ModPotions.LUCK_POTION_CC);

		// VANILLA EXTENSIONS

		registerPotionRecipe(ModPotions.WEAKNESS_POTION_AB, Items.REDSTONE, ModPotions.WEAKNESS_POTION_BB);
		registerPotionRecipe(ModPotions.WEAKNESS_POTION_AC, Items.REDSTONE, ModPotions.WEAKNESS_POTION_BC);
		registerPotionRecipe(Potions.LONG_WEAKNESS, Items.REDSTONE, ModPotions.WEAKNESS_POTION_CA);
		registerPotionRecipe(ModPotions.WEAKNESS_POTION_BB, Items.REDSTONE, ModPotions.WEAKNESS_POTION_CB);
		registerPotionRecipe(ModPotions.WEAKNESS_POTION_BC, Items.REDSTONE, ModPotions.WEAKNESS_POTION_CC);
		registerPotionRecipe(Potions.WEAKNESS, Items.GLOWSTONE_DUST, ModPotions.WEAKNESS_POTION_AB);
		registerPotionRecipe(Potions.LONG_WEAKNESS, Items.GLOWSTONE_DUST, ModPotions.WEAKNESS_POTION_BB);
		registerPotionRecipe(ModPotions.WEAKNESS_POTION_CA, Items.GLOWSTONE_DUST, ModPotions.WEAKNESS_POTION_CB);
		registerPotionRecipe(ModPotions.WEAKNESS_POTION_AB, Items.GLOWSTONE_DUST, ModPotions.WEAKNESS_POTION_AC);
		registerPotionRecipe(ModPotions.WEAKNESS_POTION_BB, Items.GLOWSTONE_DUST, ModPotions.WEAKNESS_POTION_BC);
		registerPotionRecipe(ModPotions.WEAKNESS_POTION_CB, Items.GLOWSTONE_DUST, ModPotions.WEAKNESS_POTION_CC);

		registerPotionRecipe(Potions.STRONG_SWIFTNESS, Items.REDSTONE, ModPotions.SPEED_POTION_BB);
		registerPotionRecipe(ModPotions.SPEED_POTION_AC, Items.REDSTONE, ModPotions.SPEED_POTION_BC);
		registerPotionRecipe(Potions.LONG_SWIFTNESS, Items.REDSTONE, ModPotions.SPEED_POTION_CA);
		registerPotionRecipe(ModPotions.SPEED_POTION_BB, Items.REDSTONE, ModPotions.SPEED_POTION_CB);
		registerPotionRecipe(ModPotions.SPEED_POTION_BC, Items.REDSTONE, ModPotions.SPEED_POTION_CC);
		registerPotionRecipe(Potions.LONG_SWIFTNESS, Items.GLOWSTONE_DUST, ModPotions.SPEED_POTION_BB);
		registerPotionRecipe(ModPotions.SPEED_POTION_CA, Items.GLOWSTONE_DUST, ModPotions.SPEED_POTION_CB);
		registerPotionRecipe(Potions.STRONG_SWIFTNESS, Items.GLOWSTONE_DUST, ModPotions.SPEED_POTION_AC);
		registerPotionRecipe(ModPotions.SPEED_POTION_BB, Items.GLOWSTONE_DUST, ModPotions.SPEED_POTION_BC);
		registerPotionRecipe(ModPotions.SPEED_POTION_CB, Items.GLOWSTONE_DUST, ModPotions.SPEED_POTION_CC);

		registerPotionRecipe(Potions.STRONG_SLOWNESS, Items.REDSTONE, ModPotions.SLOWNESS_POTION_BB);
		registerPotionRecipe(ModPotions.SLOWNESS_POTION_AC, Items.REDSTONE, ModPotions.SLOWNESS_POTION_BC);
		registerPotionRecipe(Potions.LONG_SLOWNESS, Items.REDSTONE, ModPotions.SLOWNESS_POTION_CA);
		registerPotionRecipe(ModPotions.SLOWNESS_POTION_BB, Items.REDSTONE, ModPotions.SLOWNESS_POTION_CB);
		registerPotionRecipe(ModPotions.SLOWNESS_POTION_BC, Items.REDSTONE, ModPotions.SLOWNESS_POTION_CC);
		registerPotionRecipe(Potions.LONG_SLOWNESS, Items.GLOWSTONE_DUST, ModPotions.SLOWNESS_POTION_BB);
		registerPotionRecipe(ModPotions.SLOWNESS_POTION_CA, Items.GLOWSTONE_DUST, ModPotions.SLOWNESS_POTION_CB);
		registerPotionRecipe(Potions.STRONG_SLOWNESS, Items.GLOWSTONE_DUST, ModPotions.SLOWNESS_POTION_AC);
		registerPotionRecipe(ModPotions.SLOWNESS_POTION_BB, Items.GLOWSTONE_DUST, ModPotions.SLOWNESS_POTION_BC);
		registerPotionRecipe(ModPotions.SLOWNESS_POTION_CB, Items.GLOWSTONE_DUST, ModPotions.SLOWNESS_POTION_CC);

		registerPotionRecipe(Potions.STRONG_LEAPING, Items.REDSTONE, ModPotions.LEAPING_POTION_BB);
		registerPotionRecipe(ModPotions.LEAPING_POTION_AC, Items.REDSTONE, ModPotions.LEAPING_POTION_BC);
		registerPotionRecipe(Potions.LONG_LEAPING, Items.REDSTONE, ModPotions.LEAPING_POTION_CA);
		registerPotionRecipe(ModPotions.LEAPING_POTION_BB, Items.REDSTONE, ModPotions.LEAPING_POTION_CB);
		registerPotionRecipe(ModPotions.LEAPING_POTION_BC, Items.REDSTONE, ModPotions.LEAPING_POTION_CC);
		registerPotionRecipe(Potions.LONG_LEAPING, Items.GLOWSTONE_DUST, ModPotions.LEAPING_POTION_BB);
		registerPotionRecipe(ModPotions.LEAPING_POTION_CA, Items.GLOWSTONE_DUST, ModPotions.LEAPING_POTION_CB);
		registerPotionRecipe(Potions.STRONG_LEAPING, Items.GLOWSTONE_DUST, ModPotions.LEAPING_POTION_AC);
		registerPotionRecipe(ModPotions.LEAPING_POTION_BB, Items.GLOWSTONE_DUST, ModPotions.LEAPING_POTION_BC);
		registerPotionRecipe(ModPotions.LEAPING_POTION_CB, Items.GLOWSTONE_DUST, ModPotions.LEAPING_POTION_CC);

		registerPotionRecipe(Potions.STRONG_STRENGTH, Items.REDSTONE, ModPotions.STRENGTH_POTION_BB);
		registerPotionRecipe(ModPotions.STRENGTH_POTION_AC, Items.REDSTONE, ModPotions.STRENGTH_POTION_BC);
		registerPotionRecipe(Potions.LONG_STRENGTH, Items.REDSTONE, ModPotions.STRENGTH_POTION_CA);
		registerPotionRecipe(ModPotions.STRENGTH_POTION_BB, Items.REDSTONE, ModPotions.STRENGTH_POTION_CB);
		registerPotionRecipe(ModPotions.STRENGTH_POTION_BC, Items.REDSTONE, ModPotions.STRENGTH_POTION_CC);
		registerPotionRecipe(Potions.LONG_STRENGTH, Items.GLOWSTONE_DUST, ModPotions.STRENGTH_POTION_BB);
		registerPotionRecipe(ModPotions.STRENGTH_POTION_CA, Items.GLOWSTONE_DUST, ModPotions.STRENGTH_POTION_CB);
		registerPotionRecipe(Potions.STRONG_STRENGTH, Items.GLOWSTONE_DUST, ModPotions.STRENGTH_POTION_AC);
		registerPotionRecipe(ModPotions.STRENGTH_POTION_BB, Items.GLOWSTONE_DUST, ModPotions.STRENGTH_POTION_BC);
		registerPotionRecipe(ModPotions.STRENGTH_POTION_CB, Items.GLOWSTONE_DUST, ModPotions.STRENGTH_POTION_CC);

		registerPotionRecipe(Potions.STRONG_HEALING, Items.GLOWSTONE_DUST, ModPotions.HEALING_POTION_C);
		registerPotionRecipe(Potions.STRONG_HARMING, Items.GLOWSTONE_DUST, ModPotions.HARMING_POTION_C);

		registerPotionRecipe(Potions.STRONG_POISON, Items.REDSTONE, ModPotions.POISON_POTION_BB);
		registerPotionRecipe(ModPotions.POISON_POTION_AC, Items.REDSTONE, ModPotions.POISON_POTION_BC);
		registerPotionRecipe(Potions.LONG_POISON, Items.REDSTONE, ModPotions.POISON_POTION_CA);
		registerPotionRecipe(ModPotions.POISON_POTION_BB, Items.REDSTONE, ModPotions.POISON_POTION_CB);
		registerPotionRecipe(ModPotions.POISON_POTION_BC, Items.REDSTONE, ModPotions.POISON_POTION_CC);
		registerPotionRecipe(Potions.LONG_POISON, Items.GLOWSTONE_DUST, ModPotions.POISON_POTION_BB);
		registerPotionRecipe(ModPotions.POISON_POTION_CA, Items.GLOWSTONE_DUST, ModPotions.POISON_POTION_CB);
		registerPotionRecipe(Potions.STRONG_POISON, Items.GLOWSTONE_DUST, ModPotions.POISON_POTION_AC);
		registerPotionRecipe(ModPotions.POISON_POTION_BB, Items.GLOWSTONE_DUST, ModPotions.POISON_POTION_BC);
		registerPotionRecipe(ModPotions.POISON_POTION_CB, Items.GLOWSTONE_DUST, ModPotions.POISON_POTION_CC);

		registerPotionRecipe(Potions.STRONG_REGENERATION, Items.REDSTONE, ModPotions.REGENERATION_POTION_BB);
		registerPotionRecipe(ModPotions.REGENERATION_POTION_AC, Items.REDSTONE, ModPotions.REGENERATION_POTION_BC);
		registerPotionRecipe(Potions.LONG_REGENERATION, Items.REDSTONE, ModPotions.REGENERATION_POTION_CA);
		registerPotionRecipe(ModPotions.REGENERATION_POTION_BB, Items.REDSTONE, ModPotions.REGENERATION_POTION_CB);
		registerPotionRecipe(ModPotions.REGENERATION_POTION_BC, Items.REDSTONE, ModPotions.REGENERATION_POTION_CC);
		registerPotionRecipe(Potions.LONG_REGENERATION, Items.GLOWSTONE_DUST, ModPotions.REGENERATION_POTION_BB);
		registerPotionRecipe(ModPotions.REGENERATION_POTION_CA, Items.GLOWSTONE_DUST, ModPotions.REGENERATION_POTION_CB);
		registerPotionRecipe(Potions.STRONG_REGENERATION, Items.GLOWSTONE_DUST, ModPotions.REGENERATION_POTION_AC);
		registerPotionRecipe(ModPotions.REGENERATION_POTION_BB, Items.GLOWSTONE_DUST, ModPotions.REGENERATION_POTION_BC);
		registerPotionRecipe(ModPotions.REGENERATION_POTION_CB, Items.GLOWSTONE_DUST, ModPotions.REGENERATION_POTION_CC);

		registerPotionRecipe(Potions.LONG_FIRE_RESISTANCE, Items.REDSTONE, ModPotions.FIRE_RESISTANCE_POTION_C);
		registerPotionRecipe(Potions.LONG_WATER_BREATHING, Items.REDSTONE, ModPotions.WATER_BREATHING_POTION_C);
		registerPotionRecipe(Potions.LONG_NIGHT_VISION, Items.REDSTONE, ModPotions.NIGHT_VISION_POTION_C);
		registerPotionRecipe(Potions.LONG_INVISIBILITY, Items.REDSTONE, ModPotions.INVISIBILITY_POTION_C);
		registerPotionRecipe(Potions.LONG_SLOW_FALLING, Items.REDSTONE, ModPotions.SLOW_FALLING_POTION_C);

	}


	private static void registerPotionRecipe(RegistryEntry<Potion> input, Item ingredient, RegistryEntry<Potion> output){
		FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
			builder.registerPotionRecipe(input, ingredient, output);
		});
	}


}