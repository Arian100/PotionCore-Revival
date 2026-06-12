package net.kai_nulled.potioncore.effects;

import net.kai_nulled.potioncore.PotionCore;
import net.kai_nulled.potioncore.attributes.ModAttributes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    private static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(Registries.MOB_EFFECT, PotionCore.MODID);

    private static ResourceLocation loc(String name) {
        return ResourceLocation.fromNamespaceAndPath(PotionCore.MODID, "effect." + name);
    }

    public static final DeferredHolder<MobEffect, MobEffect> ANTIDOTE = MOB_EFFECTS.register("antidote",
            () -> new AntidoteEffect(MobEffectCategory.BENEFICIAL, 52377));

    public static final DeferredHolder<MobEffect, MobEffect> PURITY = MOB_EFFECTS.register("purity",
            () -> new PurityEffect(MobEffectCategory.BENEFICIAL, 16777215));

    public static final DeferredHolder<MobEffect, MobEffect> TRUE_SHOT = MOB_EFFECTS.register("true_shot",
            () -> new TrueShotEffect(MobEffectCategory.BENEFICIAL, 10048768).addAttributeModifier(
                    ModAttributes.PROJECTILE_DAMAGE, loc("true_shot"), 0.2, AttributeModifier.Operation.ADD_VALUE));

    public static final DeferredHolder<MobEffect, MobEffect> KLUTZ = MOB_EFFECTS.register("klutz",
            () -> new KlutzEffect(MobEffectCategory.HARMFUL, 10066227).addAttributeModifier(
                    ModAttributes.PROJECTILE_DAMAGE, loc("klutz"), -0.2, AttributeModifier.Operation.ADD_VALUE));

    public static final DeferredHolder<MobEffect, MobEffect> MAGIC_FOCUS = MOB_EFFECTS.register("magic_focus",
            () -> new MagicFocusEffect(MobEffectCategory.BENEFICIAL, 15114239).addAttributeModifier(
                    ModAttributes.MAGIC_DAMAGE, loc("magic_focus"), 0.2, AttributeModifier.Operation.ADD_VALUE));

    public static final DeferredHolder<MobEffect, MobEffect> MAGIC_INHIBITION = MOB_EFFECTS.register("magic_inhibition",
            () -> new MagicInhibitionEffect(MobEffectCategory.HARMFUL, 10845875).addAttributeModifier(
                    ModAttributes.MAGIC_DAMAGE, loc("magic_inhibition"), -0.2, AttributeModifier.Operation.ADD_VALUE));

    public static final DeferredHolder<MobEffect, MobEffect> RECOIL = MOB_EFFECTS.register("recoil",
            () -> new RecoilEffect(MobEffectCategory.BENEFICIAL, 34850));

    public static final DeferredHolder<MobEffect, MobEffect> BURST = MOB_EFFECTS.register("burst",
            () -> new BurstEffect(MobEffectCategory.BENEFICIAL, 6710886));

    public static final DeferredHolder<MobEffect, MobEffect> EXPLODE = MOB_EFFECTS.register("explode",
            () -> new ExplodeEffect(MobEffectCategory.HARMFUL, 3355443));

    public static final DeferredHolder<MobEffect, MobEffect> FIRE = MOB_EFFECTS.register("fire",
            () -> new FireEffect(MobEffectCategory.HARMFUL, 16733440));

    public static final DeferredHolder<MobEffect, MobEffect> LIGHTNING = MOB_EFFECTS.register("lightning",
            () -> new LightningEffect(MobEffectCategory.HARMFUL, 16776960));

    public static final DeferredHolder<MobEffect, MobEffect> LAUNCH = MOB_EFFECTS.register("launch",
            () -> new LaunchEffect(MobEffectCategory.NEUTRAL, 65280));

    public static final DeferredHolder<MobEffect, MobEffect> VULNERABLE = MOB_EFFECTS.register("vulnerable",
            () -> new VulnerableEffect(MobEffectCategory.HARMFUL, 5601024).addAttributeModifier(
                    ModAttributes.DAMAGE_RESISTANCE, loc("vulnerable"), -0.2, AttributeModifier.Operation.ADD_VALUE));

    public static final DeferredHolder<MobEffect, MobEffect> BROKEN_ARMOR = MOB_EFFECTS.register("broken_armor",
            () -> new BrokenArmorEffect(MobEffectCategory.HARMFUL, 10583930).addAttributeModifier(
                    Attributes.ARMOR, loc("broken_armor"), -1.0, AttributeModifier.Operation.ADD_VALUE));

    public static final DeferredHolder<MobEffect, MobEffect> BROKEN_MAGIC_SHIELD = MOB_EFFECTS.register("broken_magic_shield",
            () -> new BrokenMagicShieldEffect(MobEffectCategory.HARMFUL, 11012960).addAttributeModifier(
                    ModAttributes.MAGIC_SHIELD, loc("broken_magic_shield"), -1.0, AttributeModifier.Operation.ADD_VALUE));

    public static final DeferredHolder<MobEffect, MobEffect> IRON_SKIN = MOB_EFFECTS.register("iron_skin",
            () -> new IronSkinEffect(MobEffectCategory.BENEFICIAL, 13092807).addAttributeModifier(
                    Attributes.ARMOR, loc("iron_skin"), 1.0, AttributeModifier.Operation.ADD_VALUE));

    public static final DeferredHolder<MobEffect, MobEffect> DIAMOND_SKIN = MOB_EFFECTS.register("diamond_skin",
            () -> new DiamondSkinEffect(MobEffectCategory.BENEFICIAL, 2873584).addAttributeModifier(
                    Attributes.ARMOR_TOUGHNESS, loc("diamond_skin"), 1.0, AttributeModifier.Operation.ADD_VALUE));

    public static final DeferredHolder<MobEffect, MobEffect> SOLID_CORE = MOB_EFFECTS.register("solid_core",
            () -> new SolidCoreEffect(MobEffectCategory.BENEFICIAL, 2236962).addAttributeModifier(
                    Attributes.KNOCKBACK_RESISTANCE, loc("solid_core"), 0.2, AttributeModifier.Operation.ADD_VALUE));

    public static final DeferredHolder<MobEffect, MobEffect> MAGIC_SHIELD = MOB_EFFECTS.register("magic_shield",
            () -> new MagicShieldEffect(MobEffectCategory.BENEFICIAL, 16729770).addAttributeModifier(
                    ModAttributes.MAGIC_SHIELD, loc("magic_shield"), 1.0, AttributeModifier.Operation.ADD_VALUE));

    public static final DeferredHolder<MobEffect, MobEffect> REVIVAL = MOB_EFFECTS.register("revival",
            () -> new RevivalEffect(MobEffectCategory.BENEFICIAL, 16711680));

    public static final DeferredHolder<MobEffect, MobEffect> STEP_UP = MOB_EFFECTS.register("step_up",
            () -> new StepUpEffect(MobEffectCategory.BENEFICIAL, 3394611).addAttributeModifier(
                    Attributes.STEP_HEIGHT, loc("step_up"), 1.0, AttributeModifier.Operation.ADD_VALUE));

    public static final DeferredHolder<MobEffect, MobEffect> REACH = MOB_EFFECTS.register("reach",
            () -> new ReachEffect(MobEffectCategory.BENEFICIAL, 13120100)
                    .addAttributeModifier(Attributes.ENTITY_INTERACTION_RANGE, loc("reach_entity"), 1.0, AttributeModifier.Operation.ADD_VALUE)
                    .addAttributeModifier(Attributes.BLOCK_INTERACTION_RANGE, loc("reach_block"), 1.0, AttributeModifier.Operation.ADD_VALUE));

    public static final DeferredHolder<MobEffect, MobEffect> CLIMB = MOB_EFFECTS.register("climb",
            () -> new ClimbEffect(MobEffectCategory.BENEFICIAL, 13391104));

    public static final DeferredHolder<MobEffect, MobEffect> RUST = MOB_EFFECTS.register("rust",
            () -> new RustEffect(MobEffectCategory.HARMFUL, 7811840));

    public static final DeferredHolder<MobEffect, MobEffect> REPAIR = MOB_EFFECTS.register("repair",
            () -> new RepairEffect(MobEffectCategory.BENEFICIAL, 7829367));

    public static final DeferredHolder<MobEffect, MobEffect> FLIGHT = MOB_EFFECTS.register("flight",
            () -> new FlightEffect(MobEffectCategory.BENEFICIAL, 5609983));

    public static final DeferredHolder<MobEffect, MobEffect> RANDOM_TELEPORT = MOB_EFFECTS.register("random_teleport",
            () -> new RandomTeleportEffect(MobEffectCategory.NEUTRAL, 52377));

    public static final DeferredHolder<MobEffect, MobEffect> SURFACE_TELEPORT = MOB_EFFECTS.register("surface_teleport",
            () -> new SurfaceTeleportEffect(MobEffectCategory.NEUTRAL, 65433));

    public static final DeferredHolder<MobEffect, MobEffect> SPAWN_TELEPORT = MOB_EFFECTS.register("spawn_teleport",
            () -> new SpawnTeleportEffect(MobEffectCategory.NEUTRAL, 10049023));

    public static final DeferredHolder<MobEffect, MobEffect> LOVE = MOB_EFFECTS.register("love",
            () -> new LoveEffect(MobEffectCategory.NEUTRAL, 16724787));

    public static final DeferredHolder<MobEffect, MobEffect> DROWN = MOB_EFFECTS.register("drown",
            () -> new DrownEffect(MobEffectCategory.NEUTRAL, 65535));

    public static final DeferredHolder<MobEffect, MobEffect> WEIGHT = MOB_EFFECTS.register("weight",
            () -> new WeightEffect(MobEffectCategory.HARMFUL, 5592405).addAttributeModifier(
                    ModAttributes.JUMP_HEIGHT, loc("weight"), -0.15, AttributeModifier.Operation.ADD_VALUE));

    public static final DeferredHolder<MobEffect, MobEffect> DISORGANIZATION = MOB_EFFECTS.register("disorganization",
            () -> new DisorganizationEffect(MobEffectCategory.HARMFUL, 10027263));

    public static final DeferredHolder<MobEffect, MobEffect> PERPLEXITY = MOB_EFFECTS.register("perplexity",
            () -> new PerplexityEffect(MobEffectCategory.NEUTRAL, 10027263));

    public static final DeferredHolder<MobEffect, MobEffect> EXTEND = MOB_EFFECTS.register("extend",
            () -> new ExtendEffect(MobEffectCategory.NEUTRAL, 10027161));

    public static final DeferredHolder<MobEffect, MobEffect> CHANCE = MOB_EFFECTS.register("chance",
            () -> new ChanceEffect(MobEffectCategory.NEUTRAL, 255));

    public static final DeferredHolder<MobEffect, MobEffect> BLESS = MOB_EFFECTS.register("bless",
            () -> new BlessEffect(MobEffectCategory.BENEFICIAL, 6737151));

    public static final DeferredHolder<MobEffect, MobEffect> CURSE = MOB_EFFECTS.register("curse",
            () -> new CurseEffect(MobEffectCategory.HARMFUL, 0));

    public static final DeferredHolder<MobEffect, MobEffect> CURE = MOB_EFFECTS.register("cure",
            () -> new CureEffect(MobEffectCategory.BENEFICIAL, 16733695));

    public static final DeferredHolder<MobEffect, MobEffect> DISPEL = MOB_EFFECTS.register("dispel",
            () -> new DispelEffect(MobEffectCategory.HARMFUL, 10027161));

    public static final DeferredHolder<MobEffect, MobEffect> INVERSION = MOB_EFFECTS.register("invert",
            () -> new InvertEffect(MobEffectCategory.BENEFICIAL, 10092441));

    public static final DeferredHolder<MobEffect, MobEffect> SPIN = MOB_EFFECTS.register("spin",
            () -> new SpinEffect(MobEffectCategory.HARMFUL, 10079232));

    public static final DeferredHolder<MobEffect, MobEffect> POTION_SICKNESS = MOB_EFFECTS.register("potion_sickness",
            () -> new PotionSickness(MobEffectCategory.HARMFUL, 16711935));

    public static void register(IEventBus bus) {
        MOB_EFFECTS.register(bus);
    }
}