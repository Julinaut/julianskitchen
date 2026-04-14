package net.juhewe.julianskitchen.effect;

import net.juhewe.julianskitchen.JuliansKitchen;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;

public class ModEffects {

    public static final Holder<MobEffect> IMMUNE = registerStatusEffect("immune", new ImmuneEffect(MobEffectCategory.BENEFICIAL, 0x5EC800));
    public static final Holder<MobEffect> COLD_FEET = registerStatusEffect("cold_feet", new ColdFeetEffect(MobEffectCategory.BENEFICIAL, 0x92B9FE));
    public static final Holder<MobEffect> MENDING_TOUCH = registerStatusEffect("mending_touch", new MendingTouchEffect(MobEffectCategory.BENEFICIAL, 0xFAB326));
    public static final Holder<MobEffect> SOFT_LANDING = registerStatusEffect("soft_landing", new SoftLandingEffect(MobEffectCategory.BENEFICIAL, 0xFDFDFD));
    public static final Holder<MobEffect> SATURATION = registerStatusEffect("saturation", new SaturationEffect(MobEffectCategory.BENEFICIAL, 0xF82423));
    public static final Holder<MobEffect> FIREWALK = registerStatusEffect("firewalk", new FirewalkEffect(MobEffectCategory.HARMFUL, 0xDEE600));
    public static final Holder<MobEffect> SANDTRAP = registerStatusEffect("sandtrap", new SandtrapEffect(MobEffectCategory.HARMFUL, 0xDACFA2));
    public static final Holder<MobEffect> PRECIPITATION = registerStatusEffect("precipitation", new PrecipitationEffect(MobEffectCategory.NEUTRAL, 0x9483BA));
    public static final Holder<MobEffect> CLEAR_SKY = registerStatusEffect("clear_sky", new ClearSkyEffect(MobEffectCategory.NEUTRAL, 0xFFED8C));
    public static final Holder<MobEffect> FERTILIZE = registerStatusEffect("fertilize", new FertilizeEffect(MobEffectCategory.BENEFICIAL, 0x00C94D));

    private static Holder<MobEffect> registerStatusEffect(String name, MobEffect statusEffect){
        return Registry.registerForHolder(BuiltInRegistries.MOB_EFFECT, Identifier.fromNamespaceAndPath(JuliansKitchen.MOD_ID, name), statusEffect);

    }

    public static void registerEffects(){
        JuliansKitchen.LOGGER.info("Registering Mod Effect(s) for JuliansKitchen");
    }
}
