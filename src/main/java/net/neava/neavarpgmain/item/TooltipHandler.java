package net.neava.neavarpgmain.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.item.*;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = "neavarpgmain", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TooltipHandler
{
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        var stack = event.getItemStack();
        var toolTip = event.getToolTip();

//        if (stack.hasTag() && NeavaItemDataStorage.hasType(stack)) {
//            toolTip.clear();
//
//            var rarity = NeavaItemDataStorage.getRarity(stack);
//            var level = NeavaItemDataStorage.getLevel(stack);
//
//            if (!rarity.isEmpty() && level > 0) {
//                var itemRarity = ItemRarity.fromString(rarity);
//
//                MutableComponent nameComponent = Component.literal("Level " + level + " " + stack.getHoverName().getString())
//                        .setStyle(Style.EMPTY.withColor(itemRarity.getColor()));
//
//                toolTip.add(nameComponent);
//            }
//
//            toolTip.add(Component.literal(""));
//
//            if (NeavaItemDataStorage.hasAttack(stack))
//            {
//                int attack = NeavaItemDataStorage.getAttack(stack);
//
//                toolTip.add(Component.translatable("tooltip.neavarpgmain.weapondamage", attack));
//            }
//
//            toolTip.add(Component.literal(""));
//
//            Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(stack);
//            if (!enchantments.isEmpty()) {
//                for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
//                    Enchantment enchantment = entry.getKey();
//                    int enchantmentLevel = entry.getValue();
//
//                    toolTip.add(Component.translatable(enchantment.getDescriptionId())
//                            .append(" ")
//                            .append(Component.literal(Integer.toString(enchantmentLevel))
//                                    .setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY))));
//                }
//            }
//
//            toolTip.add(Component.literal(""));
//
//            ItemRarity rarityFromEnum = ItemRarity.fromString(rarity);
//
//            toolTip.add(Component.literal(rarityFromEnum.getName() + " " + NeavaItemDataStorage.getType(stack))
//                    .setStyle(Style.EMPTY.withColor(rarityFromEnum.getColor())));
//
//            int durabilityCurrent = stack.getMaxDamage() - stack.getDamageValue();
//            int durabilityMax = stack.getMaxDamage();
//            toolTip.add(Component.literal(durabilityCurrent + " / " + durabilityMax));
//
//        }
//        else if (stack.hasTag() && (isWeapon(stack) || isArmor(stack)))
//        {
//            toolTip.add(Component.translatable("tooltip.neavarpgmain.notneavarpgstat"));
//        }
    }

    private static boolean isWeapon(ItemStack stack) {
        Item item = stack.getItem();
        // Check if the item is a sword, axe, or any weapon-like item
        return item instanceof SwordItem || item instanceof AxeItem || item instanceof CrossbowItem || item instanceof BowItem || item.getDefaultInstance().is(Items.TRIDENT);
    }

    private static boolean isArmor(ItemStack stack) {
        Item item = stack.getItem();
        // Check if the item is any piece of armor
        return item instanceof ArmorItem;
    }
}
