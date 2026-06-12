package net.kai_nulled.potioncore.effects;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SpawnTeleportEffect extends MobEffect {
    public SpawnTeleportEffect(MobEffectCategory category, int color) {
        super(category, color);
    }
    @Override
    public boolean isInstantenous() {
        return true;
    }

    @Override
    public void applyInstantenousEffect(@NotNull ServerLevel level, @Nullable Entity pSource, @Nullable Entity pIndirectSource, @NotNull LivingEntity pLivingEntity, int pAmplifier, double pHealth) {
        if (pLivingEntity instanceof ServerPlayer p) {
            if (p.getRespawnConfig().dimension().equals(p.level().dimension()) && p.getRespawnConfig().pos() != null) {
                p.teleportTo(
                        p.getRespawnConfig().pos().getX() + 0.5,
                        p.getRespawnConfig().pos().getY(),
                        p.getRespawnConfig().pos().getZ() + 0.5
                );
            } else {
                var levelData = p.level().getLevelData();
                p.teleportTo(
                        levelData.getSpawnPos().getX() + 0.5,
                        levelData.getSpawnPos().getY(),
                        levelData.getSpawnPos().getZ() + 0.5
                );
            }
        }
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }
}
