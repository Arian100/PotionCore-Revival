package net.kai_nulled.potioncore.attributes;

import net.kai_nulled.potioncore.PotionCore;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(modid = PotionCore.MODID)
public class ModAttributes {

    public static final DeferredRegister<Attribute> ATTRIBUTES
            = DeferredRegister.create(Registries.ATTRIBUTE, PotionCore.MODID);

    public static final DeferredHolder<Attribute, Attribute> JUMP_HEIGHT = ATTRIBUTES.register("jump_height",
            () -> new RangedAttribute("creativetab.potioncore.jump_height", 0, -2048, 2048));

    public static final DeferredHolder<Attribute, Attribute> DIG_SPEED = ATTRIBUTES.register("dig_speed",
            () -> new RangedAttribute("creativetab.potioncore.dig_speed", 1, -2048, 2048));

    public static final DeferredHolder<Attribute, Attribute> PROJECTILE_DAMAGE = ATTRIBUTES.register("projectile_damage",
            () -> new RangedAttribute("creativetab.potioncore.projectile_damage", 1, 0, Integer.MAX_VALUE));

    public static final DeferredHolder<Attribute, Attribute> MAGIC_DAMAGE = ATTRIBUTES.register("magic_damage",
            () -> new RangedAttribute("creativetab.potioncore.magic_damage", 1, -2048, Integer.MAX_VALUE));

    public static final DeferredHolder<Attribute, Attribute> DAMAGE_RESISTANCE = ATTRIBUTES.register("damage_resistance",
            () -> new RangedAttribute("creativetab.potioncore.damage_resistance", 0, Integer.MIN_VALUE, 1));

    public static final DeferredHolder<Attribute, Attribute> MAGIC_SHIELD = ATTRIBUTES.register("magic_shield",
            () -> new RangedAttribute("creativetab.potioncore.magic_shield", 0, -2048, 2048));

    @SubscribeEvent
    public static void addAttributeToMobs(EntityAttributeModificationEvent event) {
        event.add(EntityType.PLAYER, ModAttributes.DIG_SPEED);

        for (EntityType<? extends LivingEntity> entityType : event.getTypes()) {
            event.add(entityType, ModAttributes.DAMAGE_RESISTANCE);
            event.add(entityType, ModAttributes.MAGIC_DAMAGE);
            event.add(entityType, ModAttributes.MAGIC_SHIELD);
            event.add(entityType, ModAttributes.PROJECTILE_DAMAGE);
            event.add(entityType, ModAttributes.JUMP_HEIGHT);
        }
    }
}