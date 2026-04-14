package net.juhewe.julianskitchen.item;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.juhewe.julianskitchen.ModGamerules;
import net.juhewe.julianskitchen.component.ModDataComponentTypes;
import net.juhewe.julianskitchen.component.PotionBundleContentsComponent;
import net.juhewe.julianskitchen.sound.ModSounds;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.FormattedText;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import org.apache.commons.lang3.math.Fraction;
import org.jspecify.annotations.NonNull;

public class PotionBundleItem extends Item {

    private static final int FULL_ITEM_BAR_COLOR = ARGB.colorFromFloat(1.0F, 0.4F, 0.33F, 0.33F);
    private static final int ITEM_BAR_COLOR = ARGB.colorFromFloat(1.0F, 0.9F, 0.9F, 1.0F);

    public PotionBundleItem(Item.Properties settings) {
        super(settings);
    }

    public boolean overrideStackedOnOther(final ItemStack self, final Slot slot, final ClickAction clickAction, final Player player) {
        PotionBundleContentsComponent initialContents = (PotionBundleContentsComponent)self.get(ModDataComponentTypes.POTION_BUNDLE_CONTENTS);
        if (initialContents == null) {
            return false;
        } else {
            ItemStack other = slot.getItem();
            //BundleContents.Mutable contents = new BundleContents.Mutable(initialContents);
            PotionBundleContentsComponent.Builder contents = new PotionBundleContentsComponent.Builder(initialContents);

            if (clickAction == ClickAction.PRIMARY && !other.isEmpty() &&
                    (
                            other.is(Items.POTION)
                                    || other.is(Items.SPLASH_POTION)
                                    ||other.is(Items.LINGERING_POTION)
                                    ||other.is(Items.GLASS_BOTTLE)
                                    ||other.is(Items.HONEY_BOTTLE)
                                    || other.is(Items.DRAGON_BREATH)
                                    || other.is(Items.OMINOUS_BOTTLE)
                                    || other.is(Items.EXPERIENCE_BOTTLE)
                    )) {
                if (slot.allowModification(player) && contents.add(other, ModGamerules.getPotionBundleCapacity()) > 0) {
                    playInsertSound(player);
                } else {
                    playInsertFailSound(player);
                }
                self.set(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, contents.build());
                this.onContentChanged(player);
                return true;
            } else if (clickAction == ClickAction.SECONDARY && other.isEmpty()) {
                if (slot.allowModification(player)) {
                    ItemStack itemStack = contents.removeFirst();
                    if (itemStack != null) {
                        playRemoveOneSound(player);
                        slot.set(itemStack);
                    }
                }

                self.set(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, contents.build());
                this.onContentChanged(player);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean overrideOtherStackedOnMe(final ItemStack self, final ItemStack other, final Slot slot, final ClickAction clickAction, final Player player, final SlotAccess carriedItem) {
        if (clickAction == ClickAction.PRIMARY && other.isEmpty()) {
            return false;
        } else {
            PotionBundleContentsComponent initialContents = (PotionBundleContentsComponent)self.get(ModDataComponentTypes.POTION_BUNDLE_CONTENTS);
            if (initialContents == null) {
                return false;
            } else {
                PotionBundleContentsComponent.Builder contents = new PotionBundleContentsComponent.Builder(initialContents);
                if (clickAction == ClickAction.PRIMARY && !other.isEmpty() &&
                        (
                                other.is(Items.POTION)
                                        || other.is(Items.SPLASH_POTION)
                                        ||other.is(Items.LINGERING_POTION)
                                        ||other.is(Items.GLASS_BOTTLE)
                                        ||other.is(Items.HONEY_BOTTLE)
                                        || other.is(Items.DRAGON_BREATH)
                                        || other.is(Items.OMINOUS_BOTTLE)
                                        || other.is(Items.EXPERIENCE_BOTTLE)
                        )) {

                    if (slot.allowModification(player) && contents.add(other, ModGamerules.getPotionBundleCapacity()) > 0) {
                        playInsertSound(player);
                    } else {
                        playInsertFailSound(player);
                    }
                    self.set(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, contents.build());
                    this.onContentChanged(player);
                    return true;
                } else if (clickAction == ClickAction.SECONDARY && other.isEmpty()) {

                    if (slot.allowModification(player)) {
                        ItemStack itemStack = contents.removeFirst();
                        if (itemStack != null) {
                            playRemoveOneSound(player);
                            carriedItem.set(itemStack);
                        }
                    }

                    self.set(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, contents.build());
                    this.onContentChanged(player);
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public boolean isBarVisible(final ItemStack stack) {
        PotionBundleContentsComponent bundleContentsComponent = (PotionBundleContentsComponent)stack.getOrDefault(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT);
        return Fraction.getFraction(bundleContentsComponent.getContentAmount(), ModGamerules.getPotionBundleCapacity()).compareTo(Fraction.ZERO) > 0;
    }

    public int getBarWidth(final ItemStack stack) {
        PotionBundleContentsComponent bundleContentsComponent = (PotionBundleContentsComponent)stack.getOrDefault(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT);
        return Math.max(Math.min(Mth.mulAndTruncate(Fraction.getFraction(bundleContentsComponent.getContentAmount(), ModGamerules.getPotionBundleCapacity()), 13), 13), 0);
    }

    public int getBarColor(final ItemStack stack) {
        PotionBundleContentsComponent bundleContentsComponent = (PotionBundleContentsComponent)stack.getOrDefault(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT);
        return Fraction.getFraction(bundleContentsComponent.getContentAmount(), ModGamerules.getPotionBundleCapacity()).compareTo(Fraction.ONE) >= 0 ? FULL_ITEM_BAR_COLOR : ITEM_BAR_COLOR;
    }

    private static Optional<ItemStack> popFirstBundledStack(ItemStack stack, Player player, PotionBundleContentsComponent contents) {
        PotionBundleContentsComponent.Builder builder = new PotionBundleContentsComponent.Builder(contents);
        ItemStack itemStack = builder.removeFirst();
        if (itemStack != null) {
            playRemoveOneSound(player);
            stack.set(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, builder.build());
            return Optional.of(itemStack);
        } else {
            return Optional.empty();
        }
    }

    public void onUseTick(final Level world, final LivingEntity user, final ItemStack stack, final int remainingUseTicks) {
        if (user instanceof Player playerEntity) {
            int i = this.getUseDuration(stack, user);
            boolean bl = remainingUseTicks == i;
            if (bl || remainingUseTicks < i - 10) {
                this.dropContentsOnUse(world, playerEntity, stack);
            }
        }
    }

    private void dropContentsOnUse(Level world, Player player, ItemStack stack) {
        if (this.dropFirstBundledStack(stack, player)) {
            playDropContentsSound(world, player);
            player.awardStat(Stats.ITEM_USED.get(this));
        }
    }

    private boolean dropFirstBundledStack(ItemStack stack, Player player) {
        PotionBundleContentsComponent bundleContentsComponent = (PotionBundleContentsComponent)stack.get(ModDataComponentTypes.POTION_BUNDLE_CONTENTS);
        if (bundleContentsComponent != null && !bundleContentsComponent.isEmpty()) {
            Optional<ItemStack> optional = popFirstBundledStack(stack, player, bundleContentsComponent);
            if (optional.isPresent()) {
                player.drop((ItemStack)optional.get(), true);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public int getUseDuration(final ItemStack itemStack, final LivingEntity entity) {
        return 200;
    }

    public @NonNull ItemUseAnimation getUseAnimation(final @NonNull ItemStack itemStack) {
        return ItemUseAnimation.BUNDLE;
    }

    public void appendHoverText(final ItemStack stack, final TooltipContext context, final TooltipDisplay displayComponent, final Consumer<Component> textConsumer, final TooltipFlag type) {
        int showItems = ModGamerules.getPotionBundleVisibleCount();

        PotionBundleContentsComponent content = (PotionBundleContentsComponent)stack.get(ModDataComponentTypes.POTION_BUNDLE_CONTENTS);

        List<ItemStack> contentStacks = content.stream().toList();

        if(content.isEmpty()) {
            textConsumer.accept(Component.translatable("julianskitchen.potion_bundle_tooltip_empty").withStyle(ChatFormatting.GRAY));
        }
        else {
            int itemIndex = 0;

            for (ItemStack contentStack : contentStacks) {
                if(itemIndex < showItems){

                    if (itemIndex > 0) {
                        textConsumer.accept(Component.translatable("julianskitchen.potion_bundle_tooltip_separator").withStyle(ChatFormatting.DARK_GRAY));
                    }


                    PotionContents potionContent = (PotionContents)contentStack.get(DataComponents.POTION_CONTENTS);
                    boolean isGlassBottle = contentStack.is(Items.GLASS_BOTTLE);
                    boolean isHoneyBottle = contentStack.is(Items.HONEY_BOTTLE);
                    boolean isDragonsBreath = contentStack.is(Items.DRAGON_BREATH);
                    boolean isOminousBottle = contentStack.is(Items.OMINOUS_BOTTLE);
                    boolean isExperienceBottle = contentStack.is(Items.EXPERIENCE_BOTTLE);
                    if(potionContent != null || PotionBundleContentsComponent.canBeBagged(contentStack)){

                        if(contentStack.is(Items.POTION)){
                            textConsumer.accept(Component.translatable("item.minecraft.potion").withStyle(ChatFormatting.GRAY));
                            buildPotionEffectTooltip(potionContent.getAllEffects(), textConsumer, (Float)contentStack.getOrDefault(DataComponents.POTION_DURATION_SCALE, 1.0F), context.tickRate());
                        }
                        else if(contentStack.is(Items.SPLASH_POTION)){
                            textConsumer.accept(Component.translatable("item.minecraft.splash_potion").withStyle(ChatFormatting.GRAY));
                            buildPotionEffectTooltip(potionContent.getAllEffects(), textConsumer, (Float)contentStack.getOrDefault(DataComponents.POTION_DURATION_SCALE, 1.0F), context.tickRate());
                        }
                        else if(contentStack.is(Items.LINGERING_POTION)){
                            textConsumer.accept(Component.translatable("item.minecraft.lingering_potion").withStyle(ChatFormatting.GRAY));
                            buildPotionEffectTooltip(potionContent.getAllEffects(), textConsumer, (Float)contentStack.getOrDefault(DataComponents.POTION_DURATION_SCALE, 1.0F), context.tickRate());
                        }
                        else if(isGlassBottle){
                            textConsumer.accept(Component.translatable("item.minecraft.glass_bottle").append(Component.literal(" x" + contentStack.getCount())).withStyle(ChatFormatting.GRAY));
                        }
                        else if(isHoneyBottle){
                            textConsumer.accept(Component.translatable("item.minecraft.honey_bottle").append(Component.literal(" x" + contentStack.getCount())).withStyle(ChatFormatting.GRAY));
                        }
                        else if(isDragonsBreath){
                            textConsumer.accept(Component.translatable("item.minecraft.dragon_breath").append(Component.literal(" x" + contentStack.getCount())).withStyle(ChatFormatting.GRAY));
                        }
                        else if(isOminousBottle){
                            textConsumer.accept(Component.translatable("item.minecraft.ominous_bottle").append(Component.literal(" x" + contentStack.getCount())).withStyle(ChatFormatting.GRAY));
                        }
                        else if(isExperienceBottle){
                            textConsumer.accept(Component.translatable("item.minecraft.experience_bottle").append(Component.literal(" x" + contentStack.getCount())).withStyle(ChatFormatting.GRAY));
                        }
                    }
                }
                else if(itemIndex == showItems)
                {
                    textConsumer.accept(Component.literal("... +" + (contentStacks.size() - showItems)));
                }
                itemIndex++;
            }
        }
    }

    public static void buildPotionEffectTooltip(Iterable<MobEffectInstance> effects, Consumer<Component> textConsumer, float durationMultiplier, float tickRate) {
        List<Pair<Holder<Attribute>, AttributeModifier>> list = Lists.newArrayList();
        boolean noEffects = true;

        for(MobEffectInstance MobEffectInstance : effects) {
            noEffects = false;
            Holder<MobEffect> registryEntry = MobEffectInstance.getEffect();
            int i = MobEffectInstance.getAmplifier();
            ((MobEffect)registryEntry.value()).createModifiers(i, (attribute, modifier) -> list.add(new Pair(attribute, modifier)));
            MutableComponent mutableText = PotionContents.getPotionDescription(registryEntry, i);
            if (!MobEffectInstance.endsWithin(20)) {
                mutableText = Component.translatable("potion.withDuration", new Object[]{mutableText, MobEffectUtil.formatDuration(MobEffectInstance, durationMultiplier, tickRate)});
            }

            textConsumer.accept(mutableText.withStyle(((MobEffect)registryEntry.value()).getCategory().getTooltipFormatting()));
        }

        if (noEffects) {
            textConsumer.accept(Component.translatable("effect.none").withStyle(ChatFormatting.GRAY));
        }
    }


    public void onDestroyed(final ItemEntity entity) {
        PotionBundleContentsComponent bundleContentsComponent = (PotionBundleContentsComponent)entity.getItem().get(ModDataComponentTypes.POTION_BUNDLE_CONTENTS);
        if (bundleContentsComponent != null) {
            entity.getItem().set(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT);
            ItemUtils.onContainerDestroyed(entity, bundleContentsComponent.itemCopyStream());
        }
    }

    private static void playRemoveOneSound(Entity entity) {
        entity.playSound(ModSounds.POTION_BUNDLE_REMOVE, 0.8F, 0.8F + entity.level().getRandom().nextFloat() * 0.4F);
    }

    private static void playInsertSound(Entity entity) {
        entity.playSound(ModSounds.POTION_BUNDLE_INSERT, 0.8F, 0.8F + entity.level().getRandom().nextFloat() * 0.4F);
    }

    private static void playInsertFailSound(Entity entity) {
        entity.playSound(ModSounds.POTION_BUNDLE_INSERT_FAIL, 0.8F, 0.8F + entity.level().getRandom().nextFloat() * 0.4F);
    }

    private static void playDropContentsSound(Level world, Entity entity) {
        world.playSound((Entity)null, entity.blockPosition(), ModSounds.POTION_BUNDLE_DROP_CONTENTS, SoundSource.PLAYERS, 0.8F, 0.8F + entity.level().getRandom().nextFloat() * 0.4F);
    }

    private void onContentChanged(Player player) {
        AbstractContainerMenu containerMenu = player.containerMenu;
        if (containerMenu != null) {
            containerMenu.slotsChanged(player.getInventory());
        }

    }

}
