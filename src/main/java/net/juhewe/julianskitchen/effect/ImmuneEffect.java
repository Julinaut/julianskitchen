package net.juhewe.julianskitchen.effect;

import net.minecraft.block.Blocks;
import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.*;
import net.minecraft.enchantment.effect.entity.ReplaceDiskEnchantmentEffect;
import net.minecraft.enchantment.effect.value.AddEnchantmentEffect;
import net.minecraft.enchantment.effect.value.MultiplyEnchantmentEffect;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.condition.AllOfLootCondition;
import net.minecraft.loot.condition.DamageSourcePropertiesLootCondition;
import net.minecraft.loot.condition.EntityPropertiesLootCondition;
import net.minecraft.loot.condition.InvertedLootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.predicate.TagPredicate;
import net.minecraft.predicate.entity.DamageSourcePredicate;
import net.minecraft.predicate.entity.EntityFlagsPredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.EntityTypePredicate;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stat;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.event.GameEvent;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImmuneEffect extends StatusEffect {

    public ImmuneEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {

        if(entity.hasStatusEffect(StatusEffects.DARKNESS       )){ entity.removeStatusEffect(StatusEffects.DARKNESS      ); }
        if(entity.hasStatusEffect(StatusEffects.BLINDNESS      )){ entity.removeStatusEffect(StatusEffects.BLINDNESS     ); }
        if(entity.hasStatusEffect(StatusEffects.HUNGER         )){ entity.removeStatusEffect(StatusEffects.HUNGER        ); }
        if(entity.hasStatusEffect(StatusEffects.INFESTED       )){ entity.removeStatusEffect(StatusEffects.INFESTED      ); }
        if(entity.hasStatusEffect(StatusEffects.INSTANT_DAMAGE )){ entity.removeStatusEffect(StatusEffects.INSTANT_DAMAGE); }
        if(entity.hasStatusEffect(StatusEffects.LEVITATION     )){ entity.removeStatusEffect(StatusEffects.LEVITATION    ); }
        if(entity.hasStatusEffect(StatusEffects.MINING_FATIGUE )){ entity.removeStatusEffect(StatusEffects.MINING_FATIGUE); }
        if(entity.hasStatusEffect(StatusEffects.NAUSEA         )){ entity.removeStatusEffect(StatusEffects.NAUSEA        ); }
        if(entity.hasStatusEffect(StatusEffects.OOZING         )){ entity.removeStatusEffect(StatusEffects.OOZING        ); }
        if(entity.hasStatusEffect(StatusEffects.POISON         )){ entity.removeStatusEffect(StatusEffects.POISON        ); }
        if(entity.hasStatusEffect(StatusEffects.SLOWNESS       )){ entity.removeStatusEffect(StatusEffects.SLOWNESS      ); }
        if(entity.hasStatusEffect(StatusEffects.UNLUCK         )){ entity.removeStatusEffect(StatusEffects.UNLUCK        ); }
        if(entity.hasStatusEffect(StatusEffects.WEAKNESS       )){ entity.removeStatusEffect(StatusEffects.WEAKNESS      ); }
        if(entity.hasStatusEffect(StatusEffects.WEAVING        )){ entity.removeStatusEffect(StatusEffects.WEAVING       ); }
        if(entity.hasStatusEffect(StatusEffects.WIND_CHARGED   )){ entity.removeStatusEffect(StatusEffects.WIND_CHARGED  ); }
        if(entity.hasStatusEffect(StatusEffects.WITHER         )){ entity.removeStatusEffect(StatusEffects.WITHER        ); }

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
