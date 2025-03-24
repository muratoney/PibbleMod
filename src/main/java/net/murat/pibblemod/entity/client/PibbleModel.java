package net.murat.pibblemod.entity.client;

import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.murat.pibblemod.PibbleMod;
import net.murat.pibblemod.entity.custom.PibbleEntity;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;


public class PibbleModel extends GeoModel<PibbleEntity> {
    @Override
    public Identifier getModelResource(PibbleEntity pibbleEntity) {
        return Identifier.of(PibbleMod.MOD_ID, "geo/pibble.geo.json");
    }

    @Override
    public Identifier getTextureResource(PibbleEntity pibbleEntity) {
        return Identifier.of(PibbleMod.MOD_ID, "textures/entity/pibble.png");
    }

    @Override
    public Identifier getAnimationResource(PibbleEntity pibbleEntity) {
        return Identifier.of(PibbleMod.MOD_ID, "animations/pibble.animation.json");
    }

    @Override
    public void setCustomAnimations(PibbleEntity animatable, long instanceId, AnimationState<PibbleEntity> animationState) {
        GeoBone head = getAnimationProcessor().getBone("head");

        if (head != null){
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotY(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);

        }
    }
}
