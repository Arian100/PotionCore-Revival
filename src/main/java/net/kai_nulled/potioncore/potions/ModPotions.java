package net.kai_nulled.potioncore.potions;

import net.kai_nulled.potioncore.PotionCore;
import net.kai_nulled.potioncore.effects.ModEffects;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(Registries.POTION, PotionCore.MODID);

    public static final DeferredHolder<Potion, Potion> ANTIDOTE = POTIONS.register("antidote",
            () -> new Potion("antidote", new MobEffectInstance(ModEffects.ANTIDOTE, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> LONG_ANTIDOTE = POTIONS.register("long_antidote",
            () -> new Potion("antidote", new MobEffectInstance(ModEffects.ANTIDOTE, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> PURITY = POTIONS.register("purity",
            () -> new Potion("purity", new MobEffectInstance(ModEffects.PURITY, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> LONG_PURITY = POTIONS.register("long_purity",
            () -> new Potion("purity", new MobEffectInstance(ModEffects.PURITY, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> FLIGHT = POTIONS.register("flight",
            () -> new Potion("flight", new MobEffectInstance(ModEffects.FLIGHT, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> LONG_FLIGHT = POTIONS.register("long_flight",
            () -> new Potion("flight", new MobEffectInstance(ModEffects.FLIGHT, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> PERPLEXITY = POTIONS.register("perplexity",
            () -> new Potion("perplexity", new MobEffectInstance(ModEffects.PERPLEXITY, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> LONG_PERPLEXITY = POTIONS.register("long_perplexity",
            () -> new Potion("perplexity", new MobEffectInstance(ModEffects.PERPLEXITY, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> DISORGANIZATION = POTIONS.register("disorganization",
            () -> new Potion("disorganization", new MobEffectInstance(ModEffects.DISORGANIZATION, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> LONG_DISORGANIZATION = POTIONS.register("long_disorganization",
            () -> new Potion("disorganization", new MobEffectInstance(ModEffects.DISORGANIZATION, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> SPAWN_TELEPORT = POTIONS.register("spawn_teleport",
            () -> new Potion("spawn_teleport", new MobEffectInstance(ModEffects.SPAWN_TELEPORT, 1, 0)));

    public static final DeferredHolder<Potion, Potion> SURFACE_TELEPORT = POTIONS.register("surface_teleport",
            () -> new Potion("surface_teleport", new MobEffectInstance(ModEffects.SURFACE_TELEPORT, 1, 0)));

    public static final DeferredHolder<Potion, Potion> RANDOM_TELEPORT = POTIONS.register("random_teleport",
            () -> new Potion("random_teleport", new MobEffectInstance(ModEffects.RANDOM_TELEPORT, 1, 0)));

    public static final DeferredHolder<Potion, Potion> STRONG_RANDOM_TELEPORT = POTIONS.register("strong_random_teleport",
            () -> new Potion("random_teleport", new MobEffectInstance(ModEffects.RANDOM_TELEPORT, 1, 1)));

    public static final DeferredHolder<Potion, Potion> CURE = POTIONS.register("cure",
            () -> new Potion("cure", new MobEffectInstance(ModEffects.CURE, 1, 0)));

    public static final DeferredHolder<Potion, Potion> DISPEL = POTIONS.register("dispel",
            () -> new Potion("dispel", new MobEffectInstance(ModEffects.DISPEL, 1, 0)));

    public static final DeferredHolder<Potion, Potion> INVERT = POTIONS.register("invert",
            () -> new Potion("invert", new MobEffectInstance(ModEffects.INVERSION, 1, 0)));

    public static final DeferredHolder<Potion, Potion> LIGHTNING = POTIONS.register("lightning",
            () -> new Potion("lightning", new MobEffectInstance(ModEffects.LIGHTNING, 1, 0)));

    public static final DeferredHolder<Potion, Potion> LAUNCH = POTIONS.register("launch",
            () -> new Potion("launch", new MobEffectInstance(ModEffects.LAUNCH, 1, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_LAUNCH = POTIONS.register("strong_launch",
            () -> new Potion("launch", new MobEffectInstance(ModEffects.LAUNCH, 1, 1)));

    public static final DeferredHolder<Potion, Potion> CHANCE = POTIONS.register("chance",
            () -> new Potion("chance", new MobEffectInstance(ModEffects.CHANCE, 1, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_CHANCE = POTIONS.register("strong_chance",
            () -> new Potion("chance", new MobEffectInstance(ModEffects.CHANCE, 1, 1)));

    public static final DeferredHolder<Potion, Potion> BLESS = POTIONS.register("bless",
            () -> new Potion("bless", new MobEffectInstance(ModEffects.BLESS, 1, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_BLESS = POTIONS.register("strong_bless",
            () -> new Potion("bless", new MobEffectInstance(ModEffects.BLESS, 1, 1)));

    public static final DeferredHolder<Potion, Potion> CURSE = POTIONS.register("curse",
            () -> new Potion("curse", new MobEffectInstance(ModEffects.CURSE, 1, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_CURSE = POTIONS.register("strong_curse",
            () -> new Potion("curse", new MobEffectInstance(ModEffects.CURSE, 1, 1)));

    public static final DeferredHolder<Potion, Potion> BURST = POTIONS.register("burst",
            () -> new Potion("burst", new MobEffectInstance(ModEffects.BURST, 1, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_BURST = POTIONS.register("strong_burst",
            () -> new Potion("burst", new MobEffectInstance(ModEffects.BURST, 1, 1)));

    public static final DeferredHolder<Potion, Potion> EXPLOSION = POTIONS.register("explosion",
            () -> new Potion("explosion", new MobEffectInstance(ModEffects.EXPLODE, 1, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_EXPLOSION = POTIONS.register("strong_explosion",
            () -> new Potion("explosion", new MobEffectInstance(ModEffects.EXPLODE, 1, 1)));

    public static final DeferredHolder<Potion, Potion> LOVE = POTIONS.register("love",
            () -> new Potion("love", new MobEffectInstance(ModEffects.LOVE, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_LOVE = POTIONS.register("strong_love",
            () -> new Potion("love", new MobEffectInstance(ModEffects.LOVE, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_LOVE = POTIONS.register("long_love",
            () -> new Potion("love", new MobEffectInstance(ModEffects.LOVE, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> FIRE = POTIONS.register("fire",
            () -> new Potion("fire", new MobEffectInstance(ModEffects.FIRE, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> LONG_FIRE = POTIONS.register("long_fire",
            () -> new Potion("fire", new MobEffectInstance(ModEffects.FIRE, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> IRON_SKIN = POTIONS.register("iron_skin",
            () -> new Potion("iron_skin", new MobEffectInstance(ModEffects.IRON_SKIN, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_IRON_SKIN = POTIONS.register("strong_iron_skin",
            () -> new Potion("iron_skin", new MobEffectInstance(ModEffects.IRON_SKIN, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_IRON_SKIN = POTIONS.register("long_iron_skin",
            () -> new Potion("iron_skin", new MobEffectInstance(ModEffects.IRON_SKIN, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> DIAMOND_SKIN = POTIONS.register("diamond_skin",
            () -> new Potion("diamond_skin", new MobEffectInstance(ModEffects.DIAMOND_SKIN, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_DIAMOND_SKIN = POTIONS.register("strong_diamond_skin",
            () -> new Potion("diamond_skin", new MobEffectInstance(ModEffects.DIAMOND_SKIN, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_DIAMOND_SKIN = POTIONS.register("long_diamond_skin",
            () -> new Potion("diamond_skin", new MobEffectInstance(ModEffects.DIAMOND_SKIN, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> MAGIC_SHIELD = POTIONS.register("magic_shield",
            () -> new Potion("magic_shield", new MobEffectInstance(ModEffects.MAGIC_SHIELD, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_MAGIC_SHIELD = POTIONS.register("strong_magic_shield",
            () -> new Potion("magic_shield", new MobEffectInstance(ModEffects.MAGIC_SHIELD, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_MAGIC_SHIELD = POTIONS.register("long_magic_shield",
            () -> new Potion("magic_shield", new MobEffectInstance(ModEffects.MAGIC_SHIELD, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> BROKEN_ARMOR = POTIONS.register("broken_armor",
            () -> new Potion("broken_armor", new MobEffectInstance(ModEffects.BROKEN_ARMOR, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_BROKEN_ARMOR = POTIONS.register("strong_broken_armor",
            () -> new Potion("broken_armor", new MobEffectInstance(ModEffects.BROKEN_ARMOR, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_BROKEN_ARMOR = POTIONS.register("long_broken_armor",
            () -> new Potion("broken_armor", new MobEffectInstance(ModEffects.BROKEN_ARMOR, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> BROKEN_MAGIC_SHIELD = POTIONS.register("broken_magic_shield",
            () -> new Potion("broken_magic_shield", new MobEffectInstance(ModEffects.BROKEN_MAGIC_SHIELD, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_BROKEN_MAGIC_SHIELD = POTIONS.register("strong_broken_magic_shield",
            () -> new Potion("broken_magic_shield", new MobEffectInstance(ModEffects.BROKEN_MAGIC_SHIELD, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_BROKEN_MAGIC_SHIELD = POTIONS.register("long_broken_magic_shield",
            () -> new Potion("broken_magic_shield", new MobEffectInstance(ModEffects.BROKEN_MAGIC_SHIELD, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> CLIMB = POTIONS.register("climb",
            () -> new Potion("climb", new MobEffectInstance(ModEffects.CLIMB, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> LONG_CLIMB = POTIONS.register("long_climb",
            () -> new Potion("climb", new MobEffectInstance(ModEffects.CLIMB, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> WEIGHT = POTIONS.register("weight",
            () -> new Potion("weight", new MobEffectInstance(ModEffects.WEIGHT, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> LONG_WEIGHT = POTIONS.register("long_weight",
            () -> new Potion("weight", new MobEffectInstance(ModEffects.WEIGHT, 9800, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_WEIGHT = POTIONS.register("strong_weight",
            () -> new Potion("weight", new MobEffectInstance(ModEffects.WEIGHT, 9800, 1)));

    public static final DeferredHolder<Potion, Potion> EXTEND = POTIONS.register("extend",
            () -> new Potion("extend", new MobEffectInstance(ModEffects.EXTEND, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> LONG_EXTEND = POTIONS.register("long_extend",
            () -> new Potion("extend", new MobEffectInstance(ModEffects.EXTEND, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> DROWN = POTIONS.register("drown",
            () -> new Potion("drown", new MobEffectInstance(ModEffects.DROWN, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_DROWN = POTIONS.register("strong_drown",
            () -> new Potion("drown", new MobEffectInstance(ModEffects.DROWN, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_DROWN = POTIONS.register("long_drown",
            () -> new Potion("drown", new MobEffectInstance(ModEffects.DROWN, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> ARCHERY = POTIONS.register("archery",
            () -> new Potion("archery", new MobEffectInstance(ModEffects.TRUE_SHOT, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_ARCHERY = POTIONS.register("strong_archery",
            () -> new Potion("archery", new MobEffectInstance(ModEffects.TRUE_SHOT, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_ARCHERY = POTIONS.register("long_archery",
            () -> new Potion("archery", new MobEffectInstance(ModEffects.TRUE_SHOT, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> KLUTZ = POTIONS.register("klutz",
            () -> new Potion("klutz", new MobEffectInstance(ModEffects.KLUTZ, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_KLUTZ = POTIONS.register("strong_klutz",
            () -> new Potion("klutz", new MobEffectInstance(ModEffects.KLUTZ, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_KLUTZ = POTIONS.register("long_klutz",
            () -> new Potion("klutz", new MobEffectInstance(ModEffects.KLUTZ, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> MAGIC_FOCUS = POTIONS.register("magic_focus",
            () -> new Potion("magic_focus", new MobEffectInstance(ModEffects.MAGIC_FOCUS, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_MAGIC_FOCUS = POTIONS.register("strong_magic_focus",
            () -> new Potion("magic_focus", new MobEffectInstance(ModEffects.MAGIC_FOCUS, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_MAGIC_FOCUS = POTIONS.register("long_magic_focus",
            () -> new Potion("magic_focus", new MobEffectInstance(ModEffects.MAGIC_FOCUS, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> MAGIC_INHIBITION = POTIONS.register("magic_inhibition",
            () -> new Potion("magic_inhibition", new MobEffectInstance(ModEffects.MAGIC_INHIBITION, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_MAGIC_INHIBITION = POTIONS.register("strong_magic_inhibition",
            () -> new Potion("magic_inhibition", new MobEffectInstance(ModEffects.MAGIC_INHIBITION, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_MAGIC_INHIBITION = POTIONS.register("long_magic_inhibition",
            () -> new Potion("magic_inhibition", new MobEffectInstance(ModEffects.MAGIC_INHIBITION, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> REACH = POTIONS.register("reach",
            () -> new Potion("reach", new MobEffectInstance(ModEffects.REACH, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_REACH = POTIONS.register("strong_reach",
            () -> new Potion("reach", new MobEffectInstance(ModEffects.REACH, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_REACH = POTIONS.register("long_reach",
            () -> new Potion("reach", new MobEffectInstance(ModEffects.REACH, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> RECOIL = POTIONS.register("recoil",
            () -> new Potion("recoil", new MobEffectInstance(ModEffects.RECOIL, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_RECOIL = POTIONS.register("strong_recoil",
            () -> new Potion("recoil", new MobEffectInstance(ModEffects.RECOIL, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_RECOIL = POTIONS.register("long_recoil",
            () -> new Potion("recoil", new MobEffectInstance(ModEffects.RECOIL, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> REVIVAL = POTIONS.register("revival",
            () -> new Potion("revival", new MobEffectInstance(ModEffects.REVIVAL, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_REVIVAL = POTIONS.register("strong_revival",
            () -> new Potion("revival", new MobEffectInstance(ModEffects.REVIVAL, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_REVIVAL = POTIONS.register("long_revival",
            () -> new Potion("revival", new MobEffectInstance(ModEffects.REVIVAL, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> REPAIR = POTIONS.register("repair",
            () -> new Potion("repair", new MobEffectInstance(ModEffects.REPAIR, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_REPAIR = POTIONS.register("strong_repair",
            () -> new Potion("repair", new MobEffectInstance(ModEffects.REPAIR, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_REPAIR = POTIONS.register("long_repair",
            () -> new Potion("repair", new MobEffectInstance(ModEffects.REPAIR, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> RUST = POTIONS.register("rust",
            () -> new Potion("rust", new MobEffectInstance(ModEffects.RUST, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_RUST = POTIONS.register("strong_rust",
            () -> new Potion("rust", new MobEffectInstance(ModEffects.RUST, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_RUST = POTIONS.register("long_rust",
            () -> new Potion("rust", new MobEffectInstance(ModEffects.RUST, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> SOLID_CORE = POTIONS.register("solid_core",
            () -> new Potion("solid_core", new MobEffectInstance(ModEffects.SOLID_CORE, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_SOLID_CORE = POTIONS.register("strong_solid_core",
            () -> new Potion("solid_core", new MobEffectInstance(ModEffects.SOLID_CORE, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_SOLID_CORE = POTIONS.register("long_solid_core",
            () -> new Potion("solid_core", new MobEffectInstance(ModEffects.SOLID_CORE, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> SPIN = POTIONS.register("spin",
            () -> new Potion("spin", new MobEffectInstance(ModEffects.SPIN, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_SPIN = POTIONS.register("strong_spin",
            () -> new Potion("spin", new MobEffectInstance(ModEffects.SPIN, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_SPIN = POTIONS.register("long_spin",
            () -> new Potion("spin", new MobEffectInstance(ModEffects.SPIN, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> STEP_UP = POTIONS.register("step_up",
            () -> new Potion("step_up", new MobEffectInstance(ModEffects.STEP_UP, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_STEP_UP = POTIONS.register("strong_step_up",
            () -> new Potion("step_up", new MobEffectInstance(ModEffects.STEP_UP, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_STEP_UP = POTIONS.register("long_step_up",
            () -> new Potion("step_up", new MobEffectInstance(ModEffects.STEP_UP, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> VULNERABLE = POTIONS.register("vulnerable",
            () -> new Potion("vulnerable", new MobEffectInstance(ModEffects.VULNERABLE, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_VULNERABLE = POTIONS.register("strong_vulnerable",
            () -> new Potion("vulnerable", new MobEffectInstance(ModEffects.VULNERABLE, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_VULNERABLE = POTIONS.register("long_vulnerable",
            () -> new Potion("vulnerable", new MobEffectInstance(ModEffects.VULNERABLE, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> HASTE = POTIONS.register("haste",
            () -> new Potion("haste", new MobEffectInstance(MobEffects.HASTE, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_HASTE = POTIONS.register("strong_haste",
            () -> new Potion("haste", new MobEffectInstance(MobEffects.HASTE, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_HASTE = POTIONS.register("long_haste",
            () -> new Potion("haste", new MobEffectInstance(MobEffects.HASTE, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> FATIGUE = POTIONS.register("fatigue",
            () -> new Potion("fatigue", new MobEffectInstance(MobEffects.MINING_FATIGUE, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_FATIGUE = POTIONS.register("strong_fatigue",
            () -> new Potion("fatigue", new MobEffectInstance(MobEffects.MINING_FATIGUE, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_FATIGUE = POTIONS.register("long_fatigue",
            () -> new Potion("fatigue", new MobEffectInstance(MobEffects.MINING_FATIGUE, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> NAUSEA = POTIONS.register("nausea",
            () -> new Potion("nausea", new MobEffectInstance(MobEffects.NAUSEA, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> LONG_NAUSEA = POTIONS.register("long_nausea",
            () -> new Potion("nausea", new MobEffectInstance(MobEffects.NAUSEA, 9800, 0)));

    public static final DeferredHolder<Potion, Potion> WITHER = POTIONS.register("wither",
            () -> new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 3600, 0)));
    public static final DeferredHolder<Potion, Potion> STRONG_WITHER = POTIONS.register("strong_wither",
            () -> new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 4800, 1)));
    public static final DeferredHolder<Potion, Potion> LONG_WITHER = POTIONS.register("long_wither",
            () -> new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 9800, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}