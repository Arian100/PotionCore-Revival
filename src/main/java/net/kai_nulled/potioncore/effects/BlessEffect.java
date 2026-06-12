package net.kai_nulled.potioncore.effects;

import net.kai_nulled.potioncore.procedures.ModGlobalVars;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class BlessEffect extends MobEffect {

    public BlessEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }

    @Override
    public void applyInstantenousEffect(@NotNull ServerLevel level, @Nullable Entity pSource, @Nullable Entity pIndirectSource, @NotNull LivingEntity pLivingEntity, int pAmplifier, double pHealth) {
        if (!ModGlobalVars.gpotionList.isEmpty()) {
            int rnd = Mth.nextInt(RandomSource.create(), 0, ModGlobalVars.gpotionList.size() - 1);
            MobEffect randomEffect = ModGlobalVars.gpotionList.get(rnd);

            pLivingEntity.addEffect(new MobEffectInstance(
                    BuiltInRegistries.MOB_EFFECT.wrapAsHolder(randomEffect),
                    3600 * (pAmplifier + 1),
                    pAmplifier
            ));
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pTickCount, int pAmplifier) {
        return false;
    }
}