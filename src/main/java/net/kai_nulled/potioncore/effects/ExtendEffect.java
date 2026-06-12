package net.kai_nulled.potioncore.effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ExtendEffect extends MobEffect {

    public ExtendEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(@NotNull ServerLevel level, LivingEntity pLivingEntity, int pAmplifier) {
        var activeEffects = pLivingEntity.getActiveEffects();

        if (!activeEffects.isEmpty()) {
            List<MobEffectInstance> effectsList = new ArrayList<>(activeEffects);
            RandomSource random = pLivingEntity.getRandom();

            int rnd = random.nextInt(effectsList.size());
            MobEffectInstance selectedInstance = effectsList.get(rnd);

            if (selectedInstance.getEffect() == ModEffects.EXTEND) {
                if (effectsList.size() > 1) {
                    rnd = (rnd + 1) % effectsList.size();
                    selectedInstance = effectsList.get(rnd);
                }
            }

            if (selectedInstance.getEffect() != ModEffects.EXTEND) {
                pLivingEntity.addEffect(new MobEffectInstance(
                        selectedInstance.getEffect(),
                        selectedInstance.getDuration() * 2,
                        selectedInstance.getAmplifier(),
                        selectedInstance.isAmbient(),
                        selectedInstance.isVisible(),
                        selectedInstance.showIcon()
                ));
            }

            pLivingEntity.removeEffect(ModEffects.EXTEND);
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pTickCount, int pAmplifier) {
        return true;
    }
}