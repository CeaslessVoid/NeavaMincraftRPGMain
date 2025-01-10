package net.neava.neavarpgmain.player;

import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.neava.neavarpgmain.NeavaRPGMod;
import net.neava.neavarpgmain.init.NeavaBaseAttributes;
import net.neava.neavarpgmain.item.NeavaItemDataStorage;

import java.util.ArrayList;
import java.util.Collection;

@Mod.EventBusSubscriber(modid = NeavaRPGMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerStatHandler {

//    public static void register() {
//        MinecraftForge.EVENT_BUS.register(new PlayerAttackHandler());
//    }

//    @SubscribeEvent
//    public void addModifiers(ItemAttributeModifierEvent event)
//    {
//        if (NeavaItemDataStorage.hasAttack(event.getItemStack()))
//        {
//            int attackStat = NeavaItemDataStorage.getAttack(event.getItemStack());
//
//            event.addModifier(Attributes.ATTACK_DAMAGE, new AttributeModifier("attackadd", attackStat, AttributeModifier.Operation.ADDITION));
//        }
//    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        NeavaRPGMod.queueServerWork(20, () ->
        {
            Player player = event.player;

            // Apply Stats
            if (event.phase == TickEvent.Phase.END)
            {
                ItemStack mainHandItem = player.getMainHandItem();

                // Read all our stats
                AttributeInstance modAttack = player.getAttribute(NeavaBaseAttributes.ATTACK.get());

                if (NeavaItemDataStorage.hasAttack(mainHandItem)) {
                    int customAttack = NeavaItemDataStorage.getAttack(mainHandItem);
                    modAttack.setBaseValue(customAttack);
                } else {
                    modAttack.setBaseValue(1);
                }



                // Health
                AttributeInstance maxHealth =  player.getAttribute(Attributes.MAX_HEALTH);
                double fortitude = player.getAttribute(NeavaBaseAttributes.FORTITUDE.get()).getValue();

                maxHealth.setBaseValue(20 + fortitude);


                //Attack
                AttributeInstance heldAttack =  player.getAttribute(Attributes.ATTACK_DAMAGE);

                Collection<AttributeModifier> modifiers = new ArrayList<>(heldAttack.getModifiers());
                for (AttributeModifier modifier : modifiers) {
                    heldAttack.removeModifier(modifier);
                }

                heldAttack.setBaseValue(modAttack.getValue());
            }
        });
    }
}

//player.sendSystemMessage(Component.literal("Hi"));