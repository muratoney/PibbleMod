package net.murat.pibblemod;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.murat.pibblemod.entity.ModEntities;
import net.murat.pibblemod.entity.custom.PibbleEntity;
import net.murat.pibblemod.item.ModItemGroups;
import net.murat.pibblemod.item.ModItems;
import net.murat.pibblemod.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PibbleMod implements ModInitializer {
	public static final String MOD_ID = "pibblemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FabricDefaultAttributeRegistry.register(ModEntities.PIBBLE, PibbleEntity.setAttributes());
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModWorldGeneration.generateModWorldGen();
	}
}