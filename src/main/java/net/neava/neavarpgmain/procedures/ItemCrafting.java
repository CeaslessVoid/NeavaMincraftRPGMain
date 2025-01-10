package net.neava.neavarpgmain.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ItemCrafting {
    @SubscribeEvent
    public static void onItemCrafted(PlayerEvent.ItemCraftedEvent event) {
        execute(event, event.getCrafting());
    }

    public static void execute(ItemStack itemstack) {
        execute(null, itemstack);
    }

    private static void execute(@Nullable Event event, ItemStack itemstack) {
        itemstack.getOrCreateTag().putDouble("Level", 3);
        itemstack.getOrCreateTag().putString("Type", "Weapon");
        itemstack.getOrCreateTag().putString("Rarity", "Rare");
        itemstack.getOrCreateTag().putDouble("Attack", 2);
    }
}
