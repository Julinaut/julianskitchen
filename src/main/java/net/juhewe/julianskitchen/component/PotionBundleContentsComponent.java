package net.juhewe.julianskitchen.component;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public final class PotionBundleContentsComponent implements TooltipComponent {

    public static final PotionBundleContentsComponent DEFAULT =
            new PotionBundleContentsComponent(List.of());

    public static final Codec<PotionBundleContentsComponent> CODEC;
    public static final StreamCodec<RegistryFriendlyByteBuf, PotionBundleContentsComponent> STREAM_CODEC;

    final List<ItemStackTemplate> stacks;

    public PotionBundleContentsComponent(List<ItemStackTemplate> stacks) {
        this.stacks = stacks;
    }

    public ItemStack get(int index) {
        return this.stacks.get(index).create();
    }

    public Stream<ItemStack> stream() {
        return this.stacks.stream().map(ItemStackTemplate::create);
    }

    public Iterable<ItemStackTemplate> iterate() {
        return this.stacks;
    }

    public Iterable<ItemStack> iterateCopy() {
        return Lists.transform(this.stacks, itemStackTemplate -> itemStackTemplate != null ? itemStackTemplate.create() : null);
    }

    public Stream<ItemStack> itemCopyStream() {
        return this.stacks.stream().map(ItemStackTemplate::create);
    }

    public int size() {
        return this.stacks.size();
    }

    public boolean isEmpty() {
        return this.stacks.isEmpty();
    }

    public int getContentAmount() {
        int acc = 0;
        for (ItemStackTemplate template : stacks) {
            acc += Builder.getStackContentAmount(template.create());
        }
        return acc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PotionBundleContentsComponent other)) return false;

        if (this.stacks.size() != other.stacks.size()) return false;

        for (int i = 0; i < this.stacks.size(); i++) {
            if (!ItemStack.isSameItemSameComponents(
                    this.stacks.get(i).create(),
                    other.stacks.get(i).create()
            )) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 1;
        for (ItemStackTemplate t : stacks) {
            hash = 31 * hash + ItemStack.hashItemAndComponents(t.create());
        }
        return hash;
    }

    @Override
    public String toString() {
        return "PotionBundleContents" + stacks;
    }

    static {
        CODEC = ItemStackTemplate.CODEC.listOf()
                .xmap(PotionBundleContentsComponent::new, c -> c.stacks);

        STREAM_CODEC = ItemStackTemplate.STREAM_CODEC
                .apply(ByteBufCodecs.list())
                .map(PotionBundleContentsComponent::new, c -> c.stacks);
    }

    public static boolean canBeBagged(ItemStack stack) {
        return stack.is(Items.POTION)
                || stack.is(Items.SPLASH_POTION)
                || stack.is(Items.LINGERING_POTION)
                || stack.is(Items.GLASS_BOTTLE)
                || stack.is(Items.HONEY_BOTTLE)
                || stack.is(Items.DRAGON_BREATH)
                || stack.is(Items.OMINOUS_BOTTLE)
                || stack.is(Items.EXPERIENCE_BOTTLE);
    }

    public static class Builder {
        private final List<ItemStack> stacks;

        public Builder(PotionBundleContentsComponent base) {
            this.stacks = new ArrayList<>();
            for (ItemStackTemplate t : base.stacks) {
                this.stacks.add(t.create());
            }
        }

        public Builder clear() {
            stacks.clear();
            return this;
        }

        public int getContentAmount() {
            int acc = 0;
            for (ItemStack stack : stacks) {
                acc += getStackContentAmount(stack);
            }
            return acc;
        }

        public static int getStackContentAmount(ItemStack stack) {
            if (
                    stack.is(Items.POTION) ||
                            stack.is(Items.SPLASH_POTION) ||
                            stack.is(Items.LINGERING_POTION)
            ) {
                return 1;
            }
            return stack.getCount();
        }


        public int add(ItemStack stack, int capacity) {
            if (!canBeBagged(stack)) return 0;

            int insert = Math.min(
                    stack.getCount(),
                    Math.max(capacity - getContentAmount(), 0)
            );

            if (insert <= 0) return 0;

            stacks.addFirst(stack.split(insert));
            return insert;
        }

        public int add(Slot slot, Player player, int capacity) {
            ItemStack slotStack = slot.getItem();

            if (!canBeBagged(slotStack)) return 0;

            int insert = Math.min(
                    slotStack.getCount(),
                    Math.max(capacity - getContentAmount(), 0)
            );

            return add(slot.safeTake(slotStack.getCount(), insert, player), capacity);
        }

        @Nullable
        public ItemStack removeFirst() {
            if (stacks.isEmpty()) return null;
            return stacks.removeFirst().copy();
        }

        public PotionBundleContentsComponent build() {
            List<ItemStackTemplate> out = new ArrayList<>();
            for (ItemStack stack : stacks) {
                out.add(ItemStackTemplate.fromNonEmptyStack(stack));
            }
            return new PotionBundleContentsComponent(List.copyOf(out));
        }
    }
}