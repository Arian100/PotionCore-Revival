package net.kai_nulled.potioncore.effects;

import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;

public class DispelEffect extends MobEffect {

    public DispelEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }

    @Override
    public void applyInstantenousEffect(@NotNull ServerLevel level, @Nullable Entity pSource, @Nullable Entity pIndirectSource, LivingEntity pLivingEntity, int pAmplifier, double pHealth) {
        Collection<MobEffectInstance> effects = pLivingEntity.getActiveEffects();
        ArrayList<Holder<MobEffect>> toRemove = new ArrayList<>();

        for (MobEffectInstance eff : effects) {
            if (eff.getEffect().value().isBeneficial()) {
                toRemove.add(eff.getEffect());
            }
        }

        for (Holder<MobEffect> effectHolder : toRemove) {
            pLivingEntity.removeEffect(effectHolder);
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pTickCount, int pAmplifier) {
        return false;
    }
}