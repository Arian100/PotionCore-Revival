package net.kai_nulled.potioncore.effects;

import net.kai_nulled.potioncore.procedures.ModGlobalVars;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class PotionSickness extends MobEffect {
    public PotionSickness(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(@NotNull ServerLevel level, LivingEntity pLivingEntity, int pAmplifier) {
        // Nutzen der eingebauten Random-Quelle der Entity statt jedes Mal eine neue zu erstellen
        var random = pLivingEntity.getRandom();

        if (!ModGlobalVars.bpotionList.isEmpty()) {
            int rnd = Mth.nextInt(random, 0, ModGlobalVars.bpotionList.size() - 1);
            int duration = Mth.nextInt(random, 360, 3600);

            pLivingEntity.addEffect(new MobEffectInstance(Holder.direct(ModGlobalVars.bpotionList.get(rnd)), duration, pAmplifier));
        }

        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return pDuration % 360 == 0;
    }
}