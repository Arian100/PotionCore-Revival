package net.kai_nulled.potioncore.procedures;

import net.kai_nulled.potioncore.Config;
import net.kai_nulled.potioncore.PotionCore;
import net.kai_nulled.potioncore.attributes.ModAttributes;
import net.kai_nulled.potioncore.effects.ModEffects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.ClientInput;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Input;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.MovementInputUpdateEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;
import net.neoforged.neoforge.event.entity.living.LivingEvent;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.event.tick.EntityTickEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@SuppressWarnings("deprecation")
@EventBusSubscriber(modid = PotionCore.MODID)
public class ModEventHandler {

    @SubscribeEvent
    public static void pMovementEvent(MovementInputUpdateEvent event) {
        ClientInput input = event.getInput();
        Minecraft mc = Minecraft.getInstance();

        if (event.getEntity().hasEffect(ModEffects.PERPLEXITY)) {
            input.moveVector = new Vec2(-input.moveVector.x, -input.moveVector.y);

            Input kp = input.keyPresses;
            input.keyPresses = new Input(
                    kp.backward(),                  // forward  → was backward
                    kp.forward(),                   // backward → was forward
                    kp.right(),                     // left     → was right
                    kp.left(),                      // right    → was left
                    mc.options.keyShift.isDown(),   // jump fires when sneak key held
                    mc.options.keyJump.isDown(),    // shift fires when jump key held
                    kp.sprint()
            );
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void eHurt(LivingDamageEvent.Pre event) {
        DamageSource damageSource = event.getSource();
        float amount = event.getOriginalDamage();
        LivingEntity entity = event.getEntity();
        Entity sourceEntity = damageSource.getEntity();

        float projectileDamageBonus = amount;
        float magicDamageBonus = amount;

        if (sourceEntity instanceof LivingEntity lse) {
            projectileDamageBonus = (float) (amount * lse.getAttributeValue(ModAttributes.PROJECTILE_DAMAGE));
            magicDamageBonus = (float) (amount * lse.getAttributeValue(ModAttributes.MAGIC_DAMAGE));
        }

        if (damageSource.is(DamageTypes.ARROW)) {
            event.setNewDamage(projectileDamageBonus);
        }

        if (damageSource.is(DamageTypes.MAGIC) || damageSource.is(DamageTypes.INDIRECT_MAGIC)) {
            event.setNewDamage((float) (magicDamageBonus - entity.getAttributeValue(ModAttributes.MAGIC_SHIELD)));
        }

        if (entity.hasEffect(ModEffects.RECOIL) && sourceEntity != entity && sourceEntity != null) {
            MobEffectInstance recoilEffect = entity.getEffect(ModEffects.RECOIL);
            if (recoilEffect != null) {
                sourceEntity.hurt(damageSource, (float) (amount * (0.2 * (recoilEffect.getAmplifier() + 1))));
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void eHurtLast(LivingDamageEvent.Pre event) {
        float amount = event.getNewDamage();
        LivingEntity entity = event.getEntity();

        event.getContainer().setNewDamage((float) (amount - amount * entity.getAttributeValue(ModAttributes.DAMAGE_RESISTANCE)));

        if (entity.hasEffect(ModEffects.REVIVAL) && amount >= entity.getHealth()) {
            MobEffectInstance revivalEffect = entity.getEffect(ModEffects.REVIVAL);
            if (revivalEffect != null) {
                event.setNewDamage(0);
                entity.setHealth(2f * (revivalEffect.getAmplifier() + 1));
                entity.removeEffect(ModEffects.REVIVAL);
            }
        }
    }

    @SubscribeEvent
    public static void eJump(LivingEvent.LivingJumpEvent event) {
        LivingEntity entity = event.getEntity();
        entity.addDeltaMovement(new Vec3(0, entity.getAttributeValue(ModAttributes.JUMP_HEIGHT) / 2, 0));
    }

    @SubscribeEvent
    public static void eDig(PlayerEvent.BreakSpeed event) {
        event.setNewSpeed((float) (event.getOriginalSpeed() * event.getEntity().getAttributeValue(ModAttributes.DIG_SPEED)));
    }

    @SubscribeEvent
    public static void eTick(EntityTickEvent.Post event) {
        if (event.getEntity() instanceof LivingEntity entity) {
            if (Config.potionSicknessReq > 0) {
                int count = 0;
                for (MobEffectInstance instance : entity.getActiveEffects()) {
                    if (instance.getEffect().value().isBeneficial()) {
                        count++;
                    }
                }
                if (count >= Config.potionSicknessReq && entity.hasEffect(ModEffects.POTION_SICKNESS)) {
                    entity.addEffect(new MobEffectInstance(ModEffects.POTION_SICKNESS, 3600, 0));
                }
            }
        }
    }

    @SubscribeEvent
    public static void onEffectExpired(MobEffectEvent.Expired event) {
        if (event.getEffectInstance() != null && event.getEffectInstance().getEffect() == ModEffects.FLIGHT) {
            if (event.getEntity() instanceof Player player && !(player.isCreative() || player.isSpectator())) {
                player.getAbilities().flying = false;
                player.getAbilities().mayfly = false;
                player.onUpdateAbilities();
            }
        }
    }

    @SubscribeEvent
    public static void onEffectRemoved(MobEffectEvent.Remove event) {
        if (event.getEffect() == ModEffects.FLIGHT) {
            if (event.getEntity() instanceof Player player && !(player.isCreative() || player.isSpectator())) {
                player.getAbilities().flying = false;
                player.getAbilities().mayfly = false;
                player.onUpdateAbilities();
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        if (!player.isCreative() && !player.isSpectator()) {
            if (player.getAbilities().mayfly && !player.hasEffect(ModEffects.FLIGHT)) {
                player.getAbilities().flying = false;
                player.getAbilities().mayfly = false;
                player.onUpdateAbilities();
            }
        }
    }
}