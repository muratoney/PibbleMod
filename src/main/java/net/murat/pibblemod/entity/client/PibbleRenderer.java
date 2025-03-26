package net.murat.pibblemod.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.murat.pibblemod.PibbleMod;
import net.murat.pibblemod.entity.custom.PibbleEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PibbleRenderer extends GeoEntityRenderer<PibbleEntity> {
    public PibbleRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new PibbleModel());
    }

    @Override
    public Identifier getTextureLocation(PibbleEntity animatable) {
        return Identifier.of(PibbleMod.MOD_ID, "textures/entity/pibble.png");
    }

    @Override
    public void render(PibbleEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()){
            poseStack.scale(1f, 1f, 1f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
