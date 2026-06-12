package net.kai_nulled.potioncore.effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

public class ClimbEffect extends MobEffect {

    public ClimbEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(@NotNull ServerLevel level, @NotNull LivingEntity entity, int pAmplifier) {
        if (entity.horizontalCollision) {
            if (entity.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D) {
                entity.setDeltaMovement(new Vec3(entity.getDeltaMovement().x, 0.25, entity.getDeltaMovement().z));
            }
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pTickCount, int pAmplifier) {
        return true;
    }
}