package net.juhewe.julianskitchen.effect;

import net.juhewe.julianskitchen.JuliansKitchen;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> IMMUNE = registerStatusEffect("immune", new ImmuneEffect(StatusEffectCategory.BENEFICIAL, 0x5EC800));
    public static final RegistryEntry<StatusEffect> COLD_FEET = registerStatusEffect("cold_feet", new ColdFeetEffect(StatusEffectCategory.BENEFICIAL, 0x92B9FE));
    public static final RegistryEntry<StatusEffect> MENDING_TOUCH = registerStatusEffect("mending_touch", new MendingTouchEffect(StatusEffectCategory.BENEFICIAL, 0xFAB326));
    public static final RegistryEntry<StatusEffect> SOFT_LANDING = registerStatusEffect("soft_landing", new SoftLandingEffect(StatusEffectCategory.BENEFICIAL, 0xFDFDFD));
    public static final RegistryEntry<StatusEffect> SATURATION = registerStatusEffect("saturation", new SaturationEffect(StatusEffectCategory.BENEFICIAL, 0xF82423));
    public static final RegistryEntry<StatusEffect> FIREWALK = registerStatusEffect("firewalk", new FirewalkEffect(StatusEffectCategory.HARMFUL, 0xDEE600));
    public static final RegistryEntry<StatusEffect> SANDTRAP = registerStatusEffect("sandtrap", new SandtrapEffect(StatusEffectCategory.HARMFUL, 0xDACFA2));
    public static final RegistryEntry<StatusEffect> PRECIPITATION = registerStatusEffect("precipitation", new PrecipitationEffect(StatusEffectCategory.NEUTRAL, 0x9483BA));
    public static final RegistryEntry<StatusEffect> CLEAR_SKY = registerStatusEffect("clear_sky", new ClearSkyEffect(StatusEffectCategory.NEUTRAL, 0xFFED8C));
    public static final RegistryEntry<StatusEffect> FERTILIZE = registerStatusEffect("fertilize", new FertilizeEffect(StatusEffectCategory.BENEFICIAL, 0x00C94D));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(JuliansKitchen.MOD_ID, name), statusEffect);
    }

    public static void registerEffects(){
        JuliansKitchen.LOGGER.info("Registering Mod Effect(s) for JuliansKitchen");
    }
}
