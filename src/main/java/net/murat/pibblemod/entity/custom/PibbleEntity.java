package net.murat.pibblemod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.murat.pibblemod.entity.ModEntities;
import net.murat.pibblemod.entity.client.PibbleModel;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;
import software.bernie.geckolib.model.GeoModel;

public class PibbleEntity extends WolfEntity implements GeoEntity {
    private AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public PibbleEntity(EntityType<? extends WolfEntity> entityType, World world) {
        super(entityType, world);
    }
    public static DefaultAttributeContainer.Builder setAttributes(){
        return WolfEntity.createWolfAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 10)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0f)
                .add(EntityAttributes.GENERIC_ATTACK_SPEED, .7f)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, .5f);
    }

    @Override
    protected void initGoals(){
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(3, new FollowOwnerGoal(this, 0.5f, 5.0F, 50.0F));
        this.goalSelector.add(4, new SitGoal(this));
        this.goalSelector.add(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, .3f, 1));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.targetSelector.add(2, new AttackWithOwnerGoal(this));
    }

    @Override
    public WolfEntity createChild(ServerWorld world, PassiveEntity entity){
        return ModEntities.PIBBLE.create(world);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<PibbleEntity> pibbleEntityAnimationState) {
        if (this.isInSittingPose()) {
            // Sitting animation
            pibbleEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.pibble.sit", Animation.LoopType.HOLD_ON_LAST_FRAME));
            this.setSitting(true);
            return PlayState.CONTINUE;
        }

        if (pibbleEntityAnimationState.isMoving()) {
            // Walking animation
            pibbleEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.pibble.walk", Animation.LoopType.LOOP));
            pibbleEntityAnimationState.getController().setAnimationSpeed(2);
            return PlayState.CONTINUE;
        }
        // Idle animation when not sitting and not moving
        pibbleEntityAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.pibble.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }



    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}



