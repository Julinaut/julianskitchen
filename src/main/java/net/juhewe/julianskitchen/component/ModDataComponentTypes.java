package net.juhewe.julianskitchen.component;

import net.juhewe.julianskitchen.JuliansKitchen;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final ComponentType<PotionBundleContentsComponent> POTION_BUNDLE_CONTENTS =
            register("potion_bundle_contents", builder -> builder.codec(PotionBundleContentsComponent.CODEC));

    private static <T>ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderOperator){
        return Registry.register(Registries.DATA_COMPONENT_TYPE, Identifier.of(JuliansKitchen.MOD_ID, name),
                builderOperator.apply(ComponentType.builder()).build());
    }

    public static void registerDataComponentTypes(){
        JuliansKitchen.LOGGER.info("Registering Data Component Types for JuliansKitchen");
    }
}
