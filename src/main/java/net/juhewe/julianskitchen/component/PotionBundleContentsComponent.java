package net.juhewe.julianskitchen.component;

import com.google.common.collect.Lists;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipData;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.screen.slot.Slot;
import org.jspecify.annotations.Nullable;

public final class PotionBundleContentsComponent implements TooltipData {
    public static final PotionBundleContentsComponent DEFAULT = new PotionBundleContentsComponent(List.of());
    public static final Codec<PotionBundleContentsComponent> CODEC;
    public static final PacketCodec<RegistryByteBuf, PotionBundleContentsComponent> PACKET_CODEC;
    final List<ItemStack> stacks;

    public ItemStack get(int index) { return (ItemStack)this.stacks.get(index); }
    public Stream<ItemStack> stream() { return this.stacks.stream().map(ItemStack::copy); }
    public Iterable<ItemStack> iterate() { return this.stacks; }
    public Iterable<ItemStack> iterateCopy() { return Lists.transform(this.stacks, ItemStack::copy); }
    public int size() { return this.stacks.size(); }
    public boolean isEmpty() { return this.stacks.isEmpty(); }

    PotionBundleContentsComponent(List<ItemStack> stacks) {
        this.stacks = stacks;
    }

    public int getContentAmount(){
        int acc = 0;
        for(ItemStack stack : stacks){
            acc += PotionBundleContentsComponent.Builder.getStackContentAmount(stack);
        }
        return acc;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof PotionBundleContentsComponent)) {
            return false;
        } else {
            PotionBundleContentsComponent bundleContentsComponent = (PotionBundleContentsComponent)o;
            return ItemStack.stacksEqual(this.stacks, bundleContentsComponent.stacks);
        }
    }

    public int hashCode() {
        return ItemStack.listHashCode(this.stacks);
    }

    public String toString() {
        return "BundleContents" + String.valueOf(this.stacks);
    }

    static {
        CODEC = ItemStack.CODEC.listOf()
                .flatXmap(
                        list -> DataResult.success(new PotionBundleContentsComponent(list)),  // deserialize
                        component -> DataResult.success(component.stacks)                      // serialize
                );
        PACKET_CODEC = ItemStack.PACKET_CODEC.collect(PacketCodecs.toList()).xmap(PotionBundleContentsComponent::new, (component) -> component.stacks);
    }

    public static class Builder {
        private final List<ItemStack> stacks;

        public Builder(PotionBundleContentsComponent base) {
            this.stacks = new ArrayList(base.stacks);
        }

        public Builder clear() {
            this.stacks.clear();
            return this;
        }

        public int getContentAmount(){
            int acc = 0;
            for(ItemStack stack : stacks){
                acc += getStackContentAmount(stack);
            }
            return acc;
        }

        public static int getStackContentAmount(ItemStack stack){
            if(
                    stack.itemMatches(Items.POTION.getRegistryEntry())
                            || stack.itemMatches(Items.SPLASH_POTION.getRegistryEntry())
                            ||stack.itemMatches(Items.LINGERING_POTION.getRegistryEntry())
            ){
                return 1;
            }
            else{
                return stack.getCount();
            }
        }

        private boolean canBeBagged(ItemStack itemStack){
            return (
                    itemStack.itemMatches(Items.POTION.getRegistryEntry())
                            || itemStack.itemMatches(Items.SPLASH_POTION.getRegistryEntry())
                            ||itemStack.itemMatches(Items.LINGERING_POTION.getRegistryEntry())
                            ||itemStack.itemMatches(Items.GLASS_BOTTLE.getRegistryEntry())
                            ||itemStack.itemMatches(Items.HONEY_BOTTLE.getRegistryEntry())
            );
        }

        public int add(ItemStack itemStack, int bundleCapacity) {

            if (!canBeBagged(itemStack)) {
                return 0;
            }
            int itemsToInsert = Math.min(
                    itemStack.getCount(),                        // items available in the stack
                    Math.max(bundleCapacity - getContentAmount(), 0) // capacity left in bundle
            );
            if (itemsToInsert == 0) {
                return 0;
            }
            this.stacks.add(0, itemStack.split(itemsToInsert));
            return itemsToInsert;
        }

        public int add(Slot slot, PlayerEntity player, int bundleCapacity) {

            ItemStack slotStack = slot.getStack();

            if (!canBeBagged(slotStack)) {
                return 0;
            }

            int itemsToInsert = Math.min(
                    slotStack.getCount(),                        // items available in the stack
                    Math.max(bundleCapacity - getContentAmount(), 0) // capacity left in bundle
            );


            return this.add(
                    slot.takeStackRange(slotStack.getCount(), itemsToInsert, player),
                    bundleCapacity
            );
        }

        public @Nullable ItemStack removeFirst() {
            if (this.stacks.isEmpty()) {
                return null;
            } else {
                ItemStack itemStack = ((ItemStack)this.stacks.removeFirst()).copy();
                return itemStack;
            }
        }

        public PotionBundleContentsComponent build() {
            return new PotionBundleContentsComponent(List.copyOf(this.stacks));
        }
    }
}
