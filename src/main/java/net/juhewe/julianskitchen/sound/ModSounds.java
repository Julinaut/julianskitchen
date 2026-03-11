package net.juhewe.julianskitchen.sound;

import net.juhewe.julianskitchen.JuliansKitchen;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent POTION_BUNDLE_DROP_CONTENTS = registerSoundEvent("potion_bundle_drop_contents");
    public static final SoundEvent POTION_BUNDLE_INSERT = registerSoundEvent("potion_bundle_insert");
    public static final SoundEvent POTION_BUNDLE_INSERT_FAIL = registerSoundEvent("potion_bundle_insert_fail");
    public static final SoundEvent POTION_BUNDLE_REMOVE = registerSoundEvent("potion_bundle_remove");

    private static SoundEvent registerSoundEvent(String name){
        Identifier id = Identifier.of(JuliansKitchen.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        JuliansKitchen.LOGGER.info("Registering Mod Sounds for JuliansKitchen.");
    }
}
