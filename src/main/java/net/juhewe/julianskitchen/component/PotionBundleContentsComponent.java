package net.juhewe.julianskitchen.component;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipData;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.screen.slot.Slot;
import org.apache.commons.lang3.math.Fraction;
import org.jspecify.annotations.Nullable;

public final class PotionBundleContentsComponent implements TooltipData {
    public static final PotionBundleContentsComponent DEFAULT = new PotionBundleContentsComponent(List.of());
    public static final Codec<PotionBundleContentsComponent> CODEC;
    public static final PacketCodec<RegistryByteBuf, PotionBundleContentsComponent> PACKET_CODEC;
    private static final Fraction NESTED_BUNDLE_OCCUPANCY;
    final List<ItemStack> stacks;
    final Fraction occupancy;

    PotionBundleContentsComponent(List<ItemStack> stacks, Fraction occupancy) {
        this.stacks = stacks;
        this.occupancy = occupancy;
    }

    private static DataResult<PotionBundleContentsComponent> validateOccupancy(List<ItemStack> stacks) {
        try {
            Fraction fraction = calculateOccupancy(stacks);
            return DataResult.success(new PotionBundleContentsComponent(stacks, fraction));
        } catch (ArithmeticException var2) {
            return DataResult.error(() -> "Excessive total bundle weight");
        }
    }

    public PotionBundleContentsComponent(List<ItemStack> stacks) {
        this(stacks, calculateOccupancy(stacks));
    }

    private static Fraction calculateOccupancy(List<ItemStack> stacks) {
        Fraction fraction = Fraction.ZERO;

        for(ItemStack itemStack : stacks) {
            fraction = fraction.add(getOccupancy(itemStack).multiplyBy(Fraction.getFraction(itemStack.getCount(), 1)));
        }

        return fraction;
    }

    static Fraction getOccupancy(ItemStack stack) {
        PotionBundleContentsComponent bundleContentsComponent = (PotionBundleContentsComponent)stack.get(ModDataComponentTypes.POTION_BUNDLE_CONTENTS);
        if (bundleContentsComponent != null) {
            return NESTED_BUNDLE_OCCUPANCY.add(bundleContentsComponent.getOccupancy());
        } else {
            return Fraction.getFraction(1, stack.getMaxCount());
        }
    }

    public static boolean canBeBundled(ItemStack stack) {
        return !stack.isEmpty() && stack.getItem().canBeNested();
    }

    public ItemStack get(int index) {
        return (ItemStack)this.stacks.get(index);
    }

    public Stream<ItemStack> stream() {
        return this.stacks.stream().map(ItemStack::copy);
    }

    public Iterable<ItemStack> iterate() {
        return this.stacks;
    }

    public Iterable<ItemStack> iterateCopy() {
        return Lists.transform(this.stacks, ItemStack::copy);
    }

    public int size() {
        return this.stacks.size();
    }

    public Fraction getOccupancy() {
        return this.occupancy;
    }

    public boolean isEmpty() {
        return this.stacks.isEmpty();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof PotionBundleContentsComponent)) {
            return false;
        } else {
            PotionBundleContentsComponent bundleContentsComponent = (PotionBundleContentsComponent)o;
            return this.occupancy.equals(bundleContentsComponent.occupancy) && ItemStack.stacksEqual(this.stacks, bundleContentsComponent.stacks);
        }
    }

    public int hashCode() {
        return ItemStack.listHashCode(this.stacks);
    }

    public String toString() {
        return "BundleContents" + String.valueOf(this.stacks);
    }

    static {
        CODEC = ItemStack.CODEC.listOf().flatXmap(PotionBundleContentsComponent::validateOccupancy, (component) -> DataResult.success(component.stacks));
        PACKET_CODEC = ItemStack.PACKET_CODEC.collect(PacketCodecs.toList()).xmap(PotionBundleContentsComponent::new, (component) -> component.stacks);
        NESTED_BUNDLE_OCCUPANCY = Fraction.getFraction(1, 16);
    }

    public static class Builder {
        private final List<ItemStack> stacks;
        private Fraction occupancy;

        public Builder(PotionBundleContentsComponent base) {
            this.stacks = new ArrayList(base.stacks);
            this.occupancy = base.occupancy;
        }

        public Builder clear() {
            this.stacks.clear();
            this.occupancy = Fraction.ZERO;
            return this;
        }

        private int getInsertionIndex(ItemStack stack) {
            if (!stack.isStackable()) {
                return -1;
            } else {
                for(int i = 0; i < this.stacks.size(); ++i) {
                    if (ItemStack.areItemsAndComponentsEqual((ItemStack)this.stacks.get(i), stack)) {
                        return i;
                    }
                }

                return -1;
            }
        }

        private int getMaxAllowed(ItemStack stack, int maxItemsMultiplier) {
            Fraction fraction = Fraction.getFraction(maxItemsMultiplier, 1).subtract(this.occupancy);
            return Math.max(fraction.divideBy(PotionBundleContentsComponent.getOccupancy(stack)).intValue(), 0);
        }

        public int add(ItemStack stack, int maxItemsMultiplier) {
            if (!PotionBundleContentsComponent.canBeBundled(stack)) {
                return 0;
            } else {
                int i = Math.min(stack.getCount(), this.getMaxAllowed(stack, maxItemsMultiplier));
                if (i == 0) {
                    return 0;
                } else {
                    this.occupancy = this.occupancy.add(PotionBundleContentsComponent.getOccupancy(stack).multiplyBy(Fraction.getFraction(i, 1)));
                    int j = this.getInsertionIndex(stack);
                    if (j != -1) {
                        ItemStack itemStack = (ItemStack)this.stacks.remove(j);
                        ItemStack itemStack2 = itemStack.copyWithCount(itemStack.getCount() + i);
                        stack.decrement(i);
                        this.stacks.add(0, itemStack2);
                    } else {
                        this.stacks.add(0, stack.split(i));
                    }

                    return i;
                }
            }
        }

        public int add(Slot slot, PlayerEntity player, int maxItemsMultiplier) {
            ItemStack itemStack = slot.getStack();
            int i = this.getMaxAllowed(itemStack, maxItemsMultiplier);
            return PotionBundleContentsComponent.canBeBundled(itemStack) ? this.add(slot.takeStackRange(itemStack.getCount(), i, player), maxItemsMultiplier) : 0;
        }

        public @Nullable ItemStack removeFirst() {
            if (this.stacks.isEmpty()) {
                return null;
            } else {
                ItemStack itemStack = ((ItemStack)this.stacks.removeFirst()).copy();
                this.occupancy = this.occupancy.subtract(PotionBundleContentsComponent.getOccupancy(itemStack).multiplyBy(Fraction.getFraction(itemStack.getCount(), 1)));
                return itemStack;
            }
        }

        public Fraction getOccupancy() {
            return this.occupancy;
        }

        public PotionBundleContentsComponent build() {
            return new PotionBundleContentsComponent(List.copyOf(this.stacks), this.occupancy);
        }
    }
}
