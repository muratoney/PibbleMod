package net.murat.pibblemod.item;


import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.murat.pibblemod.PibbleMod;
import net.murat.pibblemod.entity.ModEntities;

public class ModItems {
    public static final Item PIBBLE_SPAWN_EGG = registerItem("pibble_spawn_egg",
            new SpawnEggItem(ModEntities.PIBBLE, 0xc0a088, 0x463e37, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PibbleMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PibbleMod.LOGGER.info("Registering Mod Items for " + PibbleMod.MOD_ID);
    }
}
