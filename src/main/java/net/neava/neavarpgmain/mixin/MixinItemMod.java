package net.neava.neavarpgmain.mixin;

import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin({ItemStack.class})
public class MixinItemMod {
    public MixinItemMod(){

    }

//    @Inject(
//            method = {"Lnet/minecraft/world/item/ItemStack;getAttributeModifiers(Lnet/minecraft/world/entity/EquipmentSlot;)Lcom/google/common/collect/Multimap;"},
//            at = {@At("RETURN")},
//            cancellable = true
//    )



}
