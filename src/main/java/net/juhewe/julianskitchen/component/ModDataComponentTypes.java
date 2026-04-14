package net.juhewe.julianskitchen.component;

import net.juhewe.julianskitchen.JuliansKitchen;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import java.util.function.UnaryOperator;

public class ModDataComponentTypes {

    public static final DataComponentType<PotionBundleContentsComponent> POTION_BUNDLE_CONTENTS =
            register("potion_bundle_contents",
                    builder -> builder.persistent(PotionBundleContentsComponent.CODEC)
                            .networkSynchronized(PotionBundleContentsComponent.STREAM_CODEC)
            );

    private static <T> DataComponentType<T> register(
            String name,
            UnaryOperator<DataComponentType.Builder<T>> builderOperator
    ) {
        return Registry.register(
                BuiltInRegistries.DATA_COMPONENT_TYPE,
                Identifier.fromNamespaceAndPath(JuliansKitchen.MOD_ID, name),
                builderOperator.apply(DataComponentType.builder()).build()
        );
    }
    public static void registerDataComponentTypes(){ JuliansKitchen.LOGGER.info("Registering Data Component Types for JuliansKitchen"); }
}