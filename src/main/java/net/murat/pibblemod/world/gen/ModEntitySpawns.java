package net.murat.pibblemod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.murat.pibblemod.entity.ModEntities;

public class ModEntitySpawns {
    public static void addSpawns() {
        BiomeModifications.addSpawn(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.DARK_FOREST, BiomeKeys.FOREST, BiomeKeys.TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA),
                SpawnGroup.CREATURE, ModEntities.PIBBLE, 10, 1, 5);

        SpawnRestriction.register(ModEntities.PIBBLE, SpawnLocationTypes.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, AnimalEntity::isValidNaturalSpawn);
    }
}
