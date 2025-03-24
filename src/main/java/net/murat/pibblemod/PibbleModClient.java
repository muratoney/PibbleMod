package net.murat.pibblemod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.murat.pibblemod.entity.ModEntities;
import net.murat.pibblemod.entity.client.PibbleRenderer;
import net.murat.pibblemod.entity.custom.PibbleEntity;

public class PibbleModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.PIBBLE, PibbleRenderer::new);

        FabricDefaultAttributeRegistry.register(ModEntities.PIBBLE, PibbleEntity.setAttributes());
    }
}