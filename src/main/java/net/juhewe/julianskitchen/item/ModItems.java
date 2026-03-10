package net.juhewe.julianskitchen.item;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.juhewe.julianskitchen.JuliansKitchen;
import net.juhewe.julianskitchen.component.ModDataComponentTypes;
import net.juhewe.julianskitchen.component.PotionBundleContentsComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item POTION_BUNDLE = registerItem(                      "potion_bundle", new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,"potion_bundle"))) .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));
    public static final Item WHITE_POTION_BUNDLE = registerItem(                      "white_potion_bundle",            new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,      "white_potion_bundle"         )))  .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));
    public static final Item ORANGE_POTION_BUNDLE = registerItem(                      "orange_potion_bundle",          new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,       "orange_potion_bundle"       )))  .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));
    public static final Item MAGENTA_POTION_BUNDLE = registerItem(                      "magenta_potion_bundle",        new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,        "magenta_potion_bundle"      )))  .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));
    public static final Item LIGHT_BLUE_POTION_BUNDLE = registerItem(                      "light_blue_potion_bundle",  new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,           "light_blue_potion_bundle")))  .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));
    public static final Item YELLOW_POTION_BUNDLE = registerItem(                      "yellow_potion_bundle",          new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,       "yellow_potion_bundle"        )))  .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));
    public static final Item LIME_POTION_BUNDLE = registerItem(                      "lime_potion_bundle",              new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,     "lime_potion_bundle"            )))  .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));
    public static final Item PINK_POTION_BUNDLE = registerItem(                      "pink_potion_bundle",              new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,     "pink_potion_bundle"            )))  .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));
    public static final Item GRAY_POTION_BUNDLE = registerItem(                      "gray_potion_bundle",              new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,     "gray_potion_bundle"            )))  .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));
    public static final Item LIGHT_GRAY_POTION_BUNDLE = registerItem(                      "light_gray_potion_bundle",  new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,           "light_gray_potion_bundle")))  .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));
    public static final Item CYAN_POTION_BUNDLE = registerItem(                      "cyan_potion_bundle",              new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,     "cyan_potion_bundle"            )))  .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));
    public static final Item PURPLE_POTION_BUNDLE = registerItem(                      "purple_potion_bundle",          new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,       "purple_potion_bundle"        )))  .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));
    public static final Item BLUE_POTION_BUNDLE = registerItem(                      "blue_potion_bundle",              new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,     "blue_potion_bundle"            )))  .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));
    public static final Item BROWN_POTION_BUNDLE = registerItem(                      "brown_potion_bundle",            new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,      "brown_potion_bundle"          )))  .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));
    public static final Item GREEN_POTION_BUNDLE = registerItem(                      "green_potion_bundle",            new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,      "green_potion_bundle"          )))  .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));
    public static final Item RED_POTION_BUNDLE = registerItem(                      "red_potion_bundle",                new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,    "red_potion_bundle"              )))  .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));
    public static final Item BLACK_POTION_BUNDLE = registerItem(                      "black_potion_bundle",            new PotionBundleItem(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(JuliansKitchen.MOD_ID,      "black_potion_bundle"          )))  .maxCount(1) .component(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT) ));


    private static Item registerItem(String itemName, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(JuliansKitchen.MOD_ID, itemName), item);
    }

    public static void registerModItems(){
        JuliansKitchen.LOGGER.info("Registering Mod Items for JuliansKitchen");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register((entries -> {
            entries.add(POTION_BUNDLE);
            entries.add(WHITE_POTION_BUNDLE);
            entries.add(ORANGE_POTION_BUNDLE);
            entries.add(MAGENTA_POTION_BUNDLE);
            entries.add(LIGHT_BLUE_POTION_BUNDLE);
            entries.add(YELLOW_POTION_BUNDLE);
            entries.add(LIME_POTION_BUNDLE);
            entries.add(PINK_POTION_BUNDLE);
            entries.add(GRAY_POTION_BUNDLE);
            entries.add(LIGHT_GRAY_POTION_BUNDLE);
            entries.add(CYAN_POTION_BUNDLE);
            entries.add(PURPLE_POTION_BUNDLE);
            entries.add(BLUE_POTION_BUNDLE);
            entries.add(BROWN_POTION_BUNDLE);
            entries.add(GREEN_POTION_BUNDLE);
            entries.add(RED_POTION_BUNDLE);
            entries.add(BLACK_POTION_BUNDLE);
        }));
    }
}
