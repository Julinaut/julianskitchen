package net.juhewe.julianskitchen.item;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.juhewe.julianskitchen.JuliansKitchen;
import net.juhewe.julianskitchen.component.ModDataComponentTypes;
import net.juhewe.julianskitchen.component.PotionBundleContentsComponent;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final Item POTION_BUNDLE = registerPotionBundleItem("potion_bundle");

    public static final Item WHITE_POTION_BUNDLE = registerPotionBundleItem("white_potion_bundle");
    public static final Item ORANGE_POTION_BUNDLE = registerPotionBundleItem("orange_potion_bundle");
    public static final Item MAGENTA_POTION_BUNDLE = registerPotionBundleItem("magenta_potion_bundle");
    public static final Item LIGHT_BLUE_POTION_BUNDLE = registerPotionBundleItem("light_blue_potion_bundle");
    public static final Item YELLOW_POTION_BUNDLE = registerPotionBundleItem("yellow_potion_bundle");
    public static final Item LIME_POTION_BUNDLE = registerPotionBundleItem("lime_potion_bundle");
    public static final Item PINK_POTION_BUNDLE = registerPotionBundleItem("pink_potion_bundle");
    public static final Item GRAY_POTION_BUNDLE = registerPotionBundleItem("gray_potion_bundle");
    public static final Item LIGHT_GRAY_POTION_BUNDLE = registerPotionBundleItem("light_gray_potion_bundle");
    public static final Item CYAN_POTION_BUNDLE = registerPotionBundleItem("cyan_potion_bundle");
    public static final Item PURPLE_POTION_BUNDLE = registerPotionBundleItem("purple_potion_bundle");
    public static final Item BLUE_POTION_BUNDLE = registerPotionBundleItem("blue_potion_bundle");
    public static final Item BROWN_POTION_BUNDLE = registerPotionBundleItem("brown_potion_bundle");
    public static final Item GREEN_POTION_BUNDLE = registerPotionBundleItem("green_potion_bundle");
    public static final Item RED_POTION_BUNDLE = registerPotionBundleItem("red_potion_bundle");
    public static final Item BLACK_POTION_BUNDLE = registerPotionBundleItem("black_potion_bundle");



    private static Item registerPotionBundleItem(String itemName){

        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(JuliansKitchen.MOD_ID, itemName));

        Item item = new PotionBundleItem(
                new Item.Properties()
                        .setId(itemKey)
                        .stacksTo(1)
                        .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT)
        );

        return Registry.register(BuiltInRegistries.ITEM, Identifier.fromNamespaceAndPath(JuliansKitchen.MOD_ID, itemName), item);
    }



    public static void registerModItems(){
        JuliansKitchen.LOGGER.info("Registering Mod Items for JuliansKitchen");

        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register((entries -> {
            entries.accept(POTION_BUNDLE);
            entries.accept(WHITE_POTION_BUNDLE);
            entries.accept(ORANGE_POTION_BUNDLE);
            entries.accept(MAGENTA_POTION_BUNDLE);
            entries.accept(LIGHT_BLUE_POTION_BUNDLE);
            entries.accept(YELLOW_POTION_BUNDLE);
            entries.accept(LIME_POTION_BUNDLE);
            entries.accept(PINK_POTION_BUNDLE);
            entries.accept(GRAY_POTION_BUNDLE);
            entries.accept(LIGHT_GRAY_POTION_BUNDLE);
            entries.accept(CYAN_POTION_BUNDLE);
            entries.accept(PURPLE_POTION_BUNDLE);
            entries.accept(BLUE_POTION_BUNDLE);
            entries.accept(BROWN_POTION_BUNDLE);
            entries.accept(GREEN_POTION_BUNDLE);
            entries.accept(RED_POTION_BUNDLE);
            entries.accept(BLACK_POTION_BUNDLE);
        }));
    }
}
