package net.kai_nulled.potioncore.effects;

import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LoveEffect extends MobEffect {

    public LoveEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyEffectTick(@NotNull ServerLevel level, @NotNull LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity instanceof Animal animal) {
            if (animal.canFallInLove()) {
                Player nearestPlayer = level.getNearestPlayer(animal.getX(), animal.getY(), animal.getZ(), 10.0, true);
                animal.setInLove(nearestPlayer);
                animal.setInLoveTime(1000);
            }
        } else if (pLivingEntity instanceof Player p) {
            AABB searchBox = new AABB(p.getX() - 8, p.getY() - 8, p.getZ() - 8, p.getX() + 8, p.getY() + 8, p.getZ() + 8);

            List<Player> nears = level.getNearbyPlayers(TargetingConditions.DEFAULT, p, searchBox);
            Player nearestP = p;
            double distMax = 0;

            for (Player near : nears) {
                if (near != null && near != p) {
                    double temp = distMax;
                    distMax = Mth.absMax(distMax, p.distanceToSqr(near));
                    if (distMax != temp) {
                        nearestP = near;
                    }
                }
            }

            if (nearestP != p) {
                p.lookAt(EntityAnchorArgument.Anchor.EYES, nearestP.position().add(0, 1, 0));

                if (pAmplifier > 0) {
                    float yaw = p.getYHeadRot();
                    float pSpeed = p.getSpeed() * (-1.0F);

                    float radYaw = yaw * ((float) Math.PI / 180F);
                    double rx = Mth.cos(radYaw) * pSpeed;
                    double ry = 0;
                    double rz = -Mth.sin(radYaw) * pSpeed;

                    p.addDeltaMovement(new Vec3(rx, ry, rz));

                    p.hurtMarked = true;
                }
            }
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pTickCount, int pAmplifier) {
        return true;
    }
}