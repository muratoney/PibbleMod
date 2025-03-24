package net.murat.pibblemod.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.murat.pibblemod.PibbleMod;
import net.murat.pibblemod.entity.custom.PibbleEntity;


public class ModEntities {
    public static final EntityType<PibbleEntity> PIBBLE = Registry.register(
            Registries.ENTITY_TYPE, "pibblemod:pibble",
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, PibbleEntity::new)
                    .dimensions(EntityDimensions.fixed(.8f, .8f)).build());
}
