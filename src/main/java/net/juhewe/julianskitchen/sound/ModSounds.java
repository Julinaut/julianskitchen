package net.juhewe.julianskitchen.sound;

import net.juhewe.julianskitchen.JuliansKitchen;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

public class ModSounds {

    public static final SoundEvent POTION_BUNDLE_DROP_CONTENTS = registerSoundEvent("potion_bundle_drop_contents");
    public static final SoundEvent POTION_BUNDLE_INSERT = registerSoundEvent("potion_bundle_insert");
    public static final SoundEvent POTION_BUNDLE_INSERT_FAIL = registerSoundEvent("potion_bundle_insert_fail");
    public static final SoundEvent POTION_BUNDLE_REMOVE = registerSoundEvent("potion_bundle_remove");

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.fromNamespaceAndPath(JuliansKitchen.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createFixedRangeEvent(id, 1.0f));
    }

    public static void registerSounds(){
        JuliansKitchen.LOGGER.info("Registering Mod Sounds for JuliansKitchen.");
    }
}
