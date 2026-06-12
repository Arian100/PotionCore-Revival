package net.kai_nulled.potioncore.effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LaunchEffect extends MobEffect {

    public LaunchEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }

    @Override
    public void applyInstantenousEffect(@NotNull ServerLevel level, @Nullable Entity pSource, @Nullable Entity pIndirectSource, LivingEntity pLivingEntity, int pAmplifier, double pHealth) {
        pLivingEntity.addDeltaMovement(new Vec3(0, (pAmplifier + 1) * 1.5, 0));

        pLivingEntity.hurtMarked = true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pTickCount, int pAmplifier) {
        return false;
    }
}