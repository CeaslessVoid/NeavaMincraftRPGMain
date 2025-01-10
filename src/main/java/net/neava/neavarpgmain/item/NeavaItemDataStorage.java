package net.neava.neavarpgmain.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class NeavaItemDataStorage
{
    public static class ItemNBTKeys {
        public static final String TYPE = "Type";
        public static final String RARITY = "Rarity";
        public static final String LEVEL = "Level";
        public static final String TAGS = "Tags";
        public static final String ATTACK = "Attack";
    }

    public static void setType(ItemStack stack, String type) {
        stack.getOrCreateTag().putString(ItemNBTKeys.TYPE, type);
    }

    public static void setRarity(ItemStack stack, String rarity) {
        stack.getOrCreateTag().putString(ItemNBTKeys.RARITY, rarity);
    }

    public static void setLevel(ItemStack stack, int level) {
        stack.getOrCreateTag().putInt(ItemNBTKeys.LEVEL, level);
    }

    public static void setTags(ItemStack stack, List<String> tags) {
        stack.getOrCreateTag().putString(ItemNBTKeys.TAGS, String.join(",", tags));
    }

    public static String getType(ItemStack stack) {
        return stack.getOrCreateTag().getString(ItemNBTKeys.TYPE);
    }

    public static String getRarity(ItemStack stack) {
        return stack.getOrCreateTag().getString(ItemNBTKeys.RARITY);
    }

    public static int getLevel(ItemStack stack) {
        return stack.getOrCreateTag().getInt(ItemNBTKeys.LEVEL);
    }

    public static List<String> getTags(ItemStack stack) {
        String tagString = stack.getOrCreateTag().getString(ItemNBTKeys.TAGS);
        return List.of(tagString.split(","));
    }

    public static boolean hasType(ItemStack stack) {
        return stack.getOrCreateTag().contains(ItemNBTKeys.TYPE);
    }

    public static boolean hasRarity(ItemStack stack) {
        return stack.getOrCreateTag().contains(ItemNBTKeys.RARITY);
    }

    public static boolean hasLevel(ItemStack stack) {
        return stack.getOrCreateTag().contains(ItemNBTKeys.LEVEL);
    }

    public static boolean hasTags(ItemStack stack) {
        return stack.getOrCreateTag().contains(ItemNBTKeys.TAGS);
    }

    public static void setAttack(ItemStack stack, int attack) {
        stack.getOrCreateTag().putInt(ItemNBTKeys.ATTACK, attack);
    }

    public static int getAttack(ItemStack stack) {
        return stack.getOrCreateTag().getInt(ItemNBTKeys.ATTACK);
    }

    public static boolean hasAttack(ItemStack stack) {
        return stack.getOrCreateTag().contains(ItemNBTKeys.ATTACK);
    }

    public static int calculateAttack(ItemStack stack) {
        int level = NeavaItemDataStorage.getLevel(stack);

        ItemRarity rarity = ItemRarity.fromString(NeavaItemDataStorage.getRarity(stack));

        double modifier = (rarity != null) ? rarity.getModifier() : 1.0;

        int baseAttack = 5 + level + (int) (Math.random() * (level + 1));

        return Math.round((float) (baseAttack * modifier));
    }

}


