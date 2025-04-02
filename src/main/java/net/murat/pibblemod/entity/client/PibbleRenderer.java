package net.murat.pibblemod.entity.client;

import com.google.common.collect.Maps;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.murat.pibblemod.PibbleMod;
import net.murat.pibblemod.entity.custom.PibbleEntity;
import net.murat.pibblemod.entity.custom.PibbleVariant;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class PibbleRenderer extends GeoEntityRenderer<PibbleEntity> {
    private static final Map<PibbleVariant, Identifier> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(PibbleVariant.class), map -> {
                map.put(PibbleVariant.DEFAULT,
                        Identifier.of(PibbleMod.MOD_ID, "textures/entity/pibble.png"));
                map.put(PibbleVariant.WASHINGTON,
                        Identifier.of(PibbleMod.MOD_ID, "textures/entity/washington.png"));
            });


    public PibbleRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new PibbleModel());
    }

    @Override
    public Identifier getTextureLocation(PibbleEntity animatable) {
        return LOCATION_BY_VARIANT.get(animatable.getVariants());
    }

    @Override
    public void render(PibbleEntity entity, float entityYaw, float partialTick, MatrixStack poseStack, VertexConsumerProvider bufferSource, int packedLight) {
        if(entity.isBaby()){
            poseStack.scale(.5f, .5f, .5f);
        }
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
