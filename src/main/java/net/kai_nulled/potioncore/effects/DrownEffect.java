package net.kai_nulled.potioncore.effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class DrownEffect extends MobEffect {

    public DrownEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(@NotNull ServerLevel level, LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity.isUnderWater()) {
            if (pLivingEntity.getAirSupply() < pLivingEntity.getMaxAirSupply() * 2) {
                pLivingEntity.setAirSupply(Mth.clamp(
                        pLivingEntity.getAirSupply() + 2 * (pAmplifier + 1),
                        0,
                        pLivingEntity.getMaxAirSupply() * 2 - pLivingEntity.getAirSupply()
                ));
            }
        } else {
            pLivingEntity.setAirSupply(pLivingEntity.getAirSupply() - 5 * (pAmplifier + 1));
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pTickCount, int pAmplifier) {
        return true;
    }
}