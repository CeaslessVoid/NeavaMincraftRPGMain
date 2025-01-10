
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.neava.neavarpgmain.init;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.neava.neavarpgmain.NeavaRPGMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NeavaBaseAttributes {

	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, NeavaRPGMod.MODID);

	public static void register(IEventBus modEventBus) {
		ATTRIBUTES.register(modEventBus);
	}

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, FORTITUDE.get());
		event.add(EntityType.PLAYER, STRENGTH.get());
		event.add(EntityType.PLAYER, INTELLIGENCE.get());
		event.add(EntityType.PLAYER, DEXTERITY.get());
		event.add(EntityType.PLAYER, ATTACK.get());
	}

	// Base stats
	public static final RegistryObject<Attribute> FORTITUDE = ATTRIBUTES.register(
			"fortitude",
			() -> new RangedAttribute("fortitudedesc", 0.0, 0.0, 1024.0).setSyncable(true)
	);

	public static final RegistryObject<Attribute> STRENGTH = ATTRIBUTES.register(
			"strength",
			() -> new RangedAttribute("strengthdesc", 0.0, 0.0, 1024.0).setSyncable(true)
	);

	public static final RegistryObject<Attribute> INTELLIGENCE = ATTRIBUTES.register(
			"intelligence",
			() -> new RangedAttribute("intelligencedesc", 0.0, 0.0, 1024.0).setSyncable(true)
	);

	public static final RegistryObject<Attribute> DEXTERITY = ATTRIBUTES.register(
			"dexterity",
			() -> new RangedAttribute("dexteritydesc", 0.0, 0.0, 1024.0).setSyncable(true)
	);


	// Modded Stats (Totals)
	public static final RegistryObject<Attribute> ATTACK = ATTRIBUTES.register(
			"attack",
			() -> new RangedAttribute("attackdesc", 0.0, 0.0, 1024.0).setSyncable(true)
	);
}
