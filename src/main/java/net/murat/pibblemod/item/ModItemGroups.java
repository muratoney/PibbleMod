package net.murat.pibblemod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.murat.pibblemod.PibbleMod;

public class ModItemGroups {

    public static final ItemGroup PIBBLE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PibbleMod.MOD_ID, "pibble_mod_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.PIBBLE_SPAWN_EGG))
                    .displayName(Text.translatable("itemgroup.pibblemod.pibble_mod_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.PIBBLE_SPAWN_EGG);
                    }).build());

    public static void registerItemGroups() {
        PibbleMod.LOGGER.info("Registering Item Groups for " + PibbleMod.MOD_ID);
    }
}

