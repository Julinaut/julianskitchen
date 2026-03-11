package net.juhewe.julianskitchen.item;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import com.google.common.collect.Lists;
import net.juhewe.julianskitchen.ModGamerules;
import net.juhewe.julianskitchen.component.ModDataComponentTypes;
import net.juhewe.julianskitchen.component.PotionBundleContentsComponent;
import net.juhewe.julianskitchen.sound.ModSounds;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.BundleContentsComponent;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.*;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.text.MutableText;
import net.minecraft.util.*;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.apache.commons.lang3.math.Fraction;
import net.minecraft.text.Text;

public class PotionBundleItem extends Item {

    private static final int FULL_ITEM_BAR_COLOR = ColorHelper.fromFloats(1.0F, 0.4F, 0.33F, 0.33F);
    private static final int ITEM_BAR_COLOR = ColorHelper.fromFloats(1.0F, 0.9F, 0.9F, 1.0F);

    public PotionBundleItem(Item.Settings settings) {
        super(settings);
    }

    public boolean onStackClicked(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player) {
        PotionBundleContentsComponent bundleContentsComponent = (PotionBundleContentsComponent)stack.get(ModDataComponentTypes.POTION_BUNDLE_CONTENTS);
        if (bundleContentsComponent == null) {
            return false;
        } else {
            ItemStack itemStack = slot.getStack();
            PotionBundleContentsComponent.Builder builder = new PotionBundleContentsComponent.Builder(bundleContentsComponent);
            if (clickType == ClickType.LEFT && !itemStack.isEmpty() &&
                    (
                            itemStack.itemMatches(Items.POTION.getRegistryEntry())
                            || itemStack.itemMatches(Items.SPLASH_POTION.getRegistryEntry())
                            ||itemStack.itemMatches(Items.LINGERING_POTION.getRegistryEntry())
                                    ||itemStack.itemMatches(Items.GLASS_BOTTLE.getRegistryEntry())
                            )

            ) {
                if (builder.add(slot, player, ModGamerules.getPotionBundleCapacity()) > 0) {
                    playInsertSound(player);
                } else {
                    playInsertFailSound(player);
                }

                stack.set(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, builder.build());
                this.onContentChanged(player);
                return true;
            } else if (clickType == ClickType.RIGHT && itemStack.isEmpty()) {
                ItemStack itemStack2 = builder.removeFirst();
                if (itemStack2 != null) {
                    ItemStack itemStack3 = slot.insertStack(itemStack2);
                    if (itemStack3.getCount() > 0) {
                        builder.add(itemStack3, ModGamerules.getPotionBundleCapacity());
                    } else {
                        playRemoveOneSound(player);
                    }
                }

                stack.set(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, builder.build());
                this.onContentChanged(player);
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean onClicked(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference) {
        if (clickType == ClickType.LEFT && otherStack.isEmpty()) {
            return false;
        } else {
            PotionBundleContentsComponent bundleContentsComponent = (PotionBundleContentsComponent)stack.get(ModDataComponentTypes.POTION_BUNDLE_CONTENTS);
            if (bundleContentsComponent == null) {
                return false;
            } else {
                PotionBundleContentsComponent.Builder builder = new PotionBundleContentsComponent.Builder(bundleContentsComponent);

                if (clickType == ClickType.LEFT && !otherStack.isEmpty() &&
                        (
                                otherStack.itemMatches(Items.POTION.getRegistryEntry())
                                        || otherStack.itemMatches(Items.SPLASH_POTION.getRegistryEntry())
                                        ||otherStack.itemMatches(Items.LINGERING_POTION.getRegistryEntry())
                                        ||otherStack.itemMatches(Items.GLASS_BOTTLE.getRegistryEntry())
                        )
                ) {
                    if (slot.canTakePartial(player) && builder.add(otherStack, ModGamerules.getPotionBundleCapacity()) > 0) {
                        playInsertSound(player);
                    } else {
                        playInsertFailSound(player);
                    }

                    stack.set(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, builder.build());
                    this.onContentChanged(player);
                    return true;
                } else if (clickType == ClickType.RIGHT && otherStack.isEmpty()) {
                    if (slot.canTakePartial(player)) {
                        ItemStack itemStack = builder.removeFirst();
                        if (itemStack != null) {
                            playRemoveOneSound(player);
                            cursorStackReference.set(itemStack);
                        }
                    }

                    stack.set(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, builder.build());
                    this.onContentChanged(player);
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        user.setCurrentHand(hand);
        return ActionResult.SUCCESS;
    }

    private void dropContentsOnUse(World world, PlayerEntity player, ItemStack stack) {
        if (this.dropFirstBundledStack(stack, player)) {
            playDropContentsSound(world, player);
            player.incrementStat(Stats.USED.getOrCreateStat(this));
        }
    }

    public boolean isItemBarVisible(ItemStack stack) {
        PotionBundleContentsComponent bundleContentsComponent = (PotionBundleContentsComponent)stack.getOrDefault(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT);
        return Fraction.getFraction(bundleContentsComponent.getContentAmount(), ModGamerules.getPotionBundleCapacity()).compareTo(Fraction.ZERO) > 0;
    }

    public int getItemBarStep(ItemStack stack) {
        PotionBundleContentsComponent bundleContentsComponent = (PotionBundleContentsComponent)stack.getOrDefault(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT);
        return Math.max(Math.min(MathHelper.multiplyFraction(Fraction.getFraction(bundleContentsComponent.getContentAmount(), ModGamerules.getPotionBundleCapacity()), 13), 13), 0);
    }

    public int getItemBarColor(ItemStack stack) {
        PotionBundleContentsComponent bundleContentsComponent = (PotionBundleContentsComponent)stack.getOrDefault(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, BundleContentsComponent.DEFAULT);
        return Fraction.getFraction(bundleContentsComponent.getContentAmount(), ModGamerules.getPotionBundleCapacity()).compareTo(Fraction.ONE) >= 0 ? FULL_ITEM_BAR_COLOR : ITEM_BAR_COLOR;
    }

    private boolean dropFirstBundledStack(ItemStack stack, PlayerEntity player) {
        PotionBundleContentsComponent bundleContentsComponent = (PotionBundleContentsComponent)stack.get(ModDataComponentTypes.POTION_BUNDLE_CONTENTS);
        if (bundleContentsComponent != null && !bundleContentsComponent.isEmpty()) {
            Optional<ItemStack> optional = popFirstBundledStack(stack, player, bundleContentsComponent);
            if (optional.isPresent()) {
                player.dropItem((ItemStack)optional.get(), true);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static Optional<ItemStack> popFirstBundledStack(ItemStack stack, PlayerEntity player, PotionBundleContentsComponent contents) {
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

    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if (user instanceof PlayerEntity playerEntity) {
            int i = this.getMaxUseTime(stack, user);
            boolean bl = remainingUseTicks == i;
            if (bl || remainingUseTicks < i - 10) {
                this.dropContentsOnUse(world, playerEntity, stack);
            }
        }

    }

    public int getMaxUseTime(ItemStack stack, LivingEntity user) {
        return 200;
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {

        int showItems = ModGamerules.getPotionBundleVisibleCount();

        PotionBundleContentsComponent content = (PotionBundleContentsComponent)stack.get(ModDataComponentTypes.POTION_BUNDLE_CONTENTS);

        List<ItemStack> contentStacks = content.stream().toList();

        if(content.isEmpty()) {
            textConsumer.accept(Text.translatable("julianskitchen.potion_bundle_tooltip_empty").formatted(Formatting.GRAY));
        }
        else {
            int itemIndex = 0;

            for (ItemStack contentStack : contentStacks) {
                if(itemIndex < showItems){

                    if (itemIndex > 0) {
                        textConsumer.accept(Text.translatable("julianskitchen.potion_bundle_tooltip_separator").formatted(Formatting.DARK_GRAY));
                    }


                    PotionContentsComponent potionContent = (PotionContentsComponent)contentStack.get(DataComponentTypes.POTION_CONTENTS);
                    boolean isGlassBottle = contentStack.itemMatches(Items.GLASS_BOTTLE.getRegistryEntry());
                    if(potionContent != null || isGlassBottle){

                        if(contentStack.itemMatches(Items.POTION.getRegistryEntry())){
                            textConsumer.accept(Text.translatable("item.minecraft.potion").formatted(Formatting.GRAY));
                            buildPotionEffectTooltip(potionContent.getEffects(), textConsumer, (Float)contentStack.getOrDefault(DataComponentTypes.POTION_DURATION_SCALE, 1.0F), context.getUpdateTickRate());
                        }
                        else if(contentStack.itemMatches(Items.SPLASH_POTION.getRegistryEntry())){
                            textConsumer.accept(Text.translatable("item.minecraft.splash_potion").formatted(Formatting.GRAY));
                            buildPotionEffectTooltip(potionContent.getEffects(), textConsumer, (Float)contentStack.getOrDefault(DataComponentTypes.POTION_DURATION_SCALE, 1.0F), context.getUpdateTickRate());
                        }
                        else if(contentStack.itemMatches(Items.LINGERING_POTION.getRegistryEntry())){
                            textConsumer.accept(Text.translatable("item.minecraft.lingering_potion").formatted(Formatting.GRAY));
                            buildPotionEffectTooltip(potionContent.getEffects(), textConsumer, (Float)contentStack.getOrDefault(DataComponentTypes.POTION_DURATION_SCALE, 1.0F), context.getUpdateTickRate());
                        }
                        else if(isGlassBottle){
                            textConsumer.accept(Text.translatable("item.minecraft.glass_bottle").append(Text.of(" x" + contentStack.getCount())).formatted(Formatting.GRAY));
                        }
                    }
                }
                else if(itemIndex == showItems)
                {
                    textConsumer.accept(Text.of("... +" + (contentStacks.size() - showItems)));
                }
                itemIndex++;
            }
        }
        super.appendTooltip(stack, context, displayComponent, textConsumer, type);
    }

    public static void buildPotionEffectTooltip(Iterable<StatusEffectInstance> effects, Consumer<Text> textConsumer, float durationMultiplier, float tickRate) {
        List<com.mojang.datafixers.util.Pair<RegistryEntry<EntityAttribute>, EntityAttributeModifier>> list = Lists.newArrayList();
        boolean noEffects = true;

        for(StatusEffectInstance statusEffectInstance : effects) {
            noEffects = false;
            RegistryEntry<StatusEffect> registryEntry = statusEffectInstance.getEffectType();
            int i = statusEffectInstance.getAmplifier();
            ((StatusEffect)registryEntry.value()).forEachAttributeModifier(i, (attribute, modifier) -> list.add(new com.mojang.datafixers.util.Pair(attribute, modifier)));
            MutableText mutableText = PotionContentsComponent.getEffectText(registryEntry, i);
            if (!statusEffectInstance.isDurationBelow(20)) {
                mutableText = Text.translatable("potion.withDuration", new Object[]{mutableText, StatusEffectUtil.getDurationText(statusEffectInstance, durationMultiplier, tickRate)});
            }

            textConsumer.accept(mutableText.formatted(((StatusEffect)registryEntry.value()).getCategory().getFormatting()));
        }

        if (noEffects) {
            textConsumer.accept(Text.translatable("effect.none").formatted(Formatting.GRAY));
        }
    }

    public void onItemEntityDestroyed(ItemEntity entity) {
        PotionBundleContentsComponent bundleContentsComponent = (PotionBundleContentsComponent)entity.getStack().get(ModDataComponentTypes.POTION_BUNDLE_CONTENTS);
        if (bundleContentsComponent != null) {
            entity.getStack().set(ModDataComponentTypes.POTION_BUNDLE_CONTENTS, PotionBundleContentsComponent.DEFAULT);
            ItemUsage.spawnItemContents(entity, bundleContentsComponent.iterateCopy());
        }
    }

    private static void playRemoveOneSound(Entity entity) {
        entity.playSound(ModSounds.POTION_BUNDLE_REMOVE, 0.8F, 0.8F + entity.getEntityWorld().getRandom().nextFloat() * 0.4F);
    }

    private static void playInsertSound(Entity entity) {
        entity.playSound(ModSounds.POTION_BUNDLE_INSERT, 0.8F, 0.8F + entity.getEntityWorld().getRandom().nextFloat() * 0.4F);
    }

    private static void playInsertFailSound(Entity entity) {
        entity.playSound(ModSounds.POTION_BUNDLE_INSERT_FAIL, 0.8F, 0.8F + entity.getEntityWorld().getRandom().nextFloat() * 0.4F);
    }

    private static void playDropContentsSound(World world, Entity entity) {
        world.playSound((Entity)null, entity.getBlockPos(), ModSounds.POTION_BUNDLE_DROP_CONTENTS, SoundCategory.PLAYERS, 0.8F, 0.8F + entity.getEntityWorld().getRandom().nextFloat() * 0.4F);
    }

    private void onContentChanged(PlayerEntity user) {
        ScreenHandler screenHandler = user.currentScreenHandler;
        if (screenHandler != null) {
            screenHandler.onContentChanged(user.getInventory());
        }
    }
}
