package net.kai_nulled.potioncore.effects;

import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InvertEffect extends MobEffect {

    public InvertEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean isInstantenous() {
        return true;
    }

    private static void invertPotion(LivingEntity entity, Holder<MobEffect> mb1, Holder<MobEffect> mb2) {
        if (entity == null) return;

        MobEffectInstance eff = entity.getEffect(mb1);
        MobEffectInstance eff1 = entity.getEffect(mb2);

        if (eff != null && eff1 != null) {
            int dur1 = eff.getDuration();
            int dur2 = eff1.getDuration();
            int amp1 = eff.getAmplifier();
            int amp2 = eff1.getAmplifier();

            entity.removeEffect(mb1);
            entity.removeEffect(mb2);

            if (!entity.level().isClientSide()) entity.addEffect(new MobEffectInstance(mb1, dur2, amp2));
            if (!entity.level().isClientSide()) entity.addEffect(new MobEffectInstance(mb2, dur1, amp1));
        } else {
            if (eff != null) {
                int dur1 = eff.getDuration();
                int amp1 = eff.getAmplifier();
                entity.removeEffect(mb1);
                if (!entity.level().isClientSide()) entity.addEffect(new MobEffectInstance(mb2, dur1, amp1));
            } else if (eff1 != null) {
                int dur2 = eff1.getDuration();
                int amp2 = eff1.getAmplifier();
                entity.removeEffect(mb2);
                if (!entity.level().isClientSide()) entity.addEffect(new MobEffectInstance(mb1, dur2, amp2));
            }
        }
    }

    @Override
    public void applyInstantenousEffect(@NotNull ServerLevel level, @Nullable Entity pSource, @Nullable Entity pIndirectSource, @NotNull LivingEntity entity, int pAmplifier, double pHealth) {
        invertPotion(entity, MobEffects.POISON, ModEffects.ANTIDOTE);
        invertPotion(entity, MobEffects.WITHER, ModEffects.PURITY);
        invertPotion(entity, MobEffects.JUMP_BOOST, ModEffects.WEIGHT);
        invertPotion(entity, MobEffects.RESISTANCE, ModEffects.VULNERABLE);
        invertPotion(entity, MobEffects.WATER_BREATHING, ModEffects.DROWN);
        invertPotion(entity, MobEffects.FIRE_RESISTANCE, ModEffects.FIRE);
        invertPotion(entity, ModEffects.KLUTZ, ModEffects.TRUE_SHOT);
        invertPotion(entity, ModEffects.MAGIC_FOCUS, ModEffects.MAGIC_INHIBITION);
        invertPotion(entity, ModEffects.BROKEN_ARMOR, ModEffects.IRON_SKIN);
        invertPotion(entity, ModEffects.BROKEN_MAGIC_SHIELD, ModEffects.MAGIC_SHIELD);
        invertPotion(entity, ModEffects.CURE, ModEffects.DISPEL);
        invertPotion(entity, ModEffects.BLESS, ModEffects.CURSE);
        invertPotion(entity, ModEffects.REPAIR, ModEffects.RUST);
        invertPotion(entity, MobEffects.SATURATION, MobEffects.HUNGER);
        invertPotion(entity, MobEffects.UNLUCK, MobEffects.LUCK);
        invertPotion(entity, MobEffects.HASTE, MobEffects.MINING_FATIGUE);
        invertPotion(entity, MobEffects.BAD_OMEN, MobEffects.HERO_OF_THE_VILLAGE);
        invertPotion(entity, MobEffects.SPEED, MobEffects.SLOWNESS);
        invertPotion(entity, MobEffects.NIGHT_VISION, MobEffects.DARKNESS);
        invertPotion(entity, MobEffects.GLOWING, MobEffects.INVISIBILITY);
        invertPotion(entity, MobEffects.STRENGTH, MobEffects.WEAKNESS);
        invertPotion(entity, MobEffects.SLOW_FALLING, MobEffects.LEVITATION);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pTickCount, int pAmplifier) {
        return false;
    }
}