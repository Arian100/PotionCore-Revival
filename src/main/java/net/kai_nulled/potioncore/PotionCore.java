package net.kai_nulled.potioncore;

import com.mojang.logging.LogUtils;
import net.kai_nulled.potioncore.attributes.ModAttributes;
import net.kai_nulled.potioncore.effects.ModEffects;
import net.kai_nulled.potioncore.potions.ModPotions;
import net.kai_nulled.potioncore.utils.ModCreativeTab;
import net.minecraft.core.Holder;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import org.slf4j.Logger;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

@SuppressWarnings("SameParameterValue")
@Mod(PotionCore.MODID)
public class PotionCore {
    public static final String MODID = "potioncore";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final Holder<Potion> WITHER =
            register("wither", new Potion("wither", new MobEffectInstance(MobEffects.WITHER, 3600)));

    public PotionCore(IEventBus modEventBus, ModContainer modContainer) {
        LOGGER.info("Loading Potion Core...");

        ModEffects.register(modEventBus);
        ModPotions.register(modEventBus);
        ModCreativeTab.register(modEventBus);

        NeoForge.EVENT_BUS.addListener(this::onRegisterBrewingRecipes);

        ModAttributes.ATTRIBUTES.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private static Holder<Potion> register(String name, Potion potion) {
        MappedRegistry<Potion> potRegistry = (MappedRegistry<Potion>) BuiltInRegistries.POTION;
        potRegistry.frozen = false;
        var result = Registry.registerForHolder(BuiltInRegistries.POTION, ResourceLocation.withDefaultNamespace(name), potion);
        potRegistry.freeze();
        return result;
    }

    private void onRegisterBrewingRecipes(RegisterBrewingRecipesEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        if(Config.recipes[0]) makeRecipe(builder, Potions.AWKWARD, Items.CHARCOAL, ModPotions.ANTIDOTE);
        if(Config.recipes[1]) makeRecipe(builder, ModPotions.ANTIDOTE, Items.REDSTONE, ModPotions.LONG_ANTIDOTE);

        if(Config.recipes[2]) makeRecipe(builder, Potions.AWKWARD, Items.HONEYCOMB, ModPotions.PURITY);
        if(Config.recipes[3]) makeRecipe(builder, ModPotions.PURITY, Items.REDSTONE, ModPotions.LONG_PURITY);

        if(Config.recipes[4]) makeRecipe(builder, Potions.SLOW_FALLING, Items.FIREWORK_ROCKET, ModPotions.FLIGHT);
        if(Config.recipes[5]) makeRecipe(builder, ModPotions.FLIGHT, Items.REDSTONE, ModPotions.LONG_FLIGHT);

        if(Config.recipes[6]) makeRecipe(builder, ModPotions.NAUSEA, Items.RED_MUSHROOM, ModPotions.PERPLEXITY);
        if(Config.recipes[7]) makeRecipe(builder, ModPotions.PERPLEXITY, Items.REDSTONE, ModPotions.LONG_PERPLEXITY);

        if(Config.recipes[8]) makeRecipe(builder, Potions.AWKWARD, Items.GOLDEN_PICKAXE, ModPotions.HASTE);
        if(Config.recipes[9]) makeRecipe(builder, ModPotions.HASTE, Items.REDSTONE, ModPotions.LONG_HASTE);
        if(Config.recipes[10]) makeRecipe(builder, ModPotions.HASTE, Items.GLOWSTONE_DUST, ModPotions.STRONG_HASTE);

        if(Config.recipes[11]) makeRecipe(builder, Potions.AWKWARD, Items.OBSIDIAN, ModPotions.FATIGUE);
        if(Config.recipes[12]) makeRecipe(builder, ModPotions.FATIGUE, Items.REDSTONE, ModPotions.LONG_FATIGUE);
        if(Config.recipes[13]) makeRecipe(builder, ModPotions.FATIGUE, Items.GLOWSTONE_DUST, ModPotions.STRONG_FATIGUE);

        if(Config.recipes[14]) makeRecipe(builder, Potions.AWKWARD, Items.BOW, ModPotions.ARCHERY);
        if(Config.recipes[15]) makeRecipe(builder, ModPotions.ARCHERY, Items.REDSTONE, ModPotions.LONG_ARCHERY);
        if(Config.recipes[16]) makeRecipe(builder, ModPotions.ARCHERY, Items.GLOWSTONE_DUST, ModPotions.STRONG_ARCHERY);

        if(Config.recipes[17]) makeRecipe(builder, ModPotions.ARCHERY, Items.CLAY_BALL, ModPotions.KLUTZ);
        if(Config.recipes[18]) makeRecipe(builder, ModPotions.KLUTZ, Items.REDSTONE, ModPotions.LONG_KLUTZ);
        if(Config.recipes[19]) makeRecipe(builder, ModPotions.KLUTZ, Items.GLOWSTONE_DUST, ModPotions.STRONG_KLUTZ);

        if(Config.recipes[20]) makeRecipe(builder, Potions.AWKWARD, Items.LAPIS_LAZULI, ModPotions.MAGIC_FOCUS);
        if(Config.recipes[21]) makeRecipe(builder, ModPotions.MAGIC_FOCUS, Items.REDSTONE, ModPotions.LONG_MAGIC_FOCUS);
        if(Config.recipes[22]) makeRecipe(builder, ModPotions.MAGIC_FOCUS, Items.GLOWSTONE_DUST, ModPotions.STRONG_MAGIC_FOCUS);

        if(Config.recipes[23]) makeRecipe(builder, Potions.AWKWARD, Items.MUD, ModPotions.MAGIC_INHIBITION);
        if(Config.recipes[24]) makeRecipe(builder, ModPotions.MAGIC_INHIBITION, Items.REDSTONE, ModPotions.LONG_MAGIC_INHIBITION);
        if(Config.recipes[25]) makeRecipe(builder, ModPotions.MAGIC_INHIBITION, Items.GLOWSTONE_DUST, ModPotions.STRONG_MAGIC_INHIBITION);

        if(Config.recipes[26]) makeRecipe(builder, Potions.AWKWARD, Items.DIAMOND_PICKAXE, ModPotions.REACH);
        if(Config.recipes[27]) makeRecipe(builder, ModPotions.REACH, Items.REDSTONE, ModPotions.LONG_REACH);
        if(Config.recipes[28]) makeRecipe(builder, ModPotions.REACH, Items.GLOWSTONE_DUST, ModPotions.STRONG_REACH);

        if(Config.recipes[29]) makeRecipe(builder, Potions.AWKWARD, Items.POINTED_DRIPSTONE, ModPotions.RECOIL);
        if(Config.recipes[30]) makeRecipe(builder, ModPotions.RECOIL, Items.REDSTONE, ModPotions.LONG_RECOIL);
        if(Config.recipes[31]) makeRecipe(builder, ModPotions.RECOIL, Items.GLOWSTONE_DUST, ModPotions.STRONG_RECOIL);

        if(Config.recipes[32]) makeRecipe(builder, Potions.AWKWARD, Items.EXPERIENCE_BOTTLE, ModPotions.REPAIR);
        if(Config.recipes[33]) makeRecipe(builder, ModPotions.REPAIR, Items.REDSTONE, ModPotions.LONG_REPAIR);
        if(Config.recipes[34]) makeRecipe(builder, ModPotions.REPAIR, Items.GLOWSTONE_DUST, ModPotions.STRONG_REPAIR);

        if(Config.recipes[35]) makeRecipe(builder, ModPotions.REPAIR, Items.WITHER_ROSE, ModPotions.RUST);
        if(Config.recipes[36]) makeRecipe(builder, ModPotions.RUST, Items.REDSTONE, ModPotions.LONG_RUST);
        if(Config.recipes[37]) makeRecipe(builder, ModPotions.RUST, Items.GLOWSTONE_DUST, ModPotions.STRONG_RUST);

        if(Config.recipes[38]) makeRecipe(builder, Potions.AWKWARD, Items.SHIELD, ModPotions.SOLID_CORE);
        if(Config.recipes[39]) makeRecipe(builder, ModPotions.SOLID_CORE, Items.REDSTONE, ModPotions.LONG_SOLID_CORE);
        if(Config.recipes[40]) makeRecipe(builder, ModPotions.SOLID_CORE, Items.GLOWSTONE_DUST, ModPotions.STRONG_SOLID_CORE);

        if(Config.recipes[41]) makeRecipe(builder, ModPotions.NAUSEA, Items.MINECART, ModPotions.SPIN);
        if(Config.recipes[42]) makeRecipe(builder, ModPotions.SPIN, Items.REDSTONE, ModPotions.LONG_SPIN);
        if(Config.recipes[43]) makeRecipe(builder, ModPotions.SPIN, Items.GLOWSTONE_DUST, ModPotions.STRONG_SPIN);

        if(Config.recipes[44]) makeRecipe(builder, Potions.AWKWARD, Items.CALCITE, ModPotions.STEP_UP);
        if(Config.recipes[45]) makeRecipe(builder, ModPotions.STEP_UP, Items.REDSTONE, ModPotions.LONG_STEP_UP);
        if(Config.recipes[46]) makeRecipe(builder, ModPotions.STEP_UP, Items.GLOWSTONE_DUST, ModPotions.STRONG_STEP_UP);

        if(Config.recipes[47]) makeRecipe(builder, Potions.AWKWARD, Items.ROTTEN_FLESH, ModPotions.VULNERABLE);
        if(Config.recipes[48]) makeRecipe(builder, ModPotions.VULNERABLE, Items.REDSTONE, ModPotions.LONG_VULNERABLE);
        if(Config.recipes[49]) makeRecipe(builder, ModPotions.VULNERABLE, Items.GLOWSTONE_DUST, ModPotions.STRONG_VULNERABLE);

        if(Config.recipes[50]) makeRecipe(builder, Potions.AWKWARD, Items.RED_MUSHROOM, ModPotions.NAUSEA);
        if(Config.recipes[51]) makeRecipe(builder, ModPotions.NAUSEA, Items.REDSTONE, ModPotions.LONG_NAUSEA);

        if(Config.recipes[52]) makeRecipe(builder, Potions.AWKWARD, Items.DROPPER, ModPotions.CHANCE);
        if(Config.recipes[53]) makeRecipe(builder, ModPotions.CHANCE, Items.GLOWSTONE_DUST, ModPotions.STRONG_CHANCE);

        if(Config.recipes[54]) makeRecipe(builder, ModPotions.CHANCE, Items.EMERALD, ModPotions.BLESS);
        if(Config.recipes[55]) makeRecipe(builder, ModPotions.BLESS, Items.GLOWSTONE_DUST, ModPotions.STRONG_BLESS);

        if(Config.recipes[56]) makeRecipe(builder, ModPotions.CHANCE, Items.WITHER_ROSE, ModPotions.CURSE);
        if(Config.recipes[57]) makeRecipe(builder, ModPotions.CURSE, Items.GLOWSTONE_DUST, ModPotions.STRONG_CURSE);

        if(Config.recipes[58]) makeRecipe(builder, ModPotions.ANTIDOTE, Items.GLISTERING_MELON_SLICE, ModPotions.CURE);
        if(Config.recipes[59]) makeRecipe(builder, WITHER, Items.WITHER_ROSE, ModPotions.DISPEL);

        if(Config.recipes[60]) makeRecipe(builder, Potions.AWKWARD, Items.WITHER_ROSE, WITHER);
        if(Config.recipes[61]) makeRecipe(builder, WITHER, Items.REDSTONE, ModPotions.LONG_WITHER);
        if(Config.recipes[62]) makeRecipe(builder, WITHER, Items.GLOWSTONE_DUST, ModPotions.STRONG_WITHER);

        if(Config.recipes[63]) makeRecipe(builder, Potions.AWKWARD, Items.WHEAT, ModPotions.LOVE);
        if(Config.recipes[64]) makeRecipe(builder, ModPotions.LOVE, Items.REDSTONE, ModPotions.LONG_LOVE);
        if(Config.recipes[65]) makeRecipe(builder, ModPotions.LOVE, Items.GLOWSTONE_DUST, ModPotions.STRONG_LOVE);

        if(Config.recipes[66]) makeRecipe(builder, Potions.AWKWARD, Items.IRON_INGOT, ModPotions.IRON_SKIN);
        if(Config.recipes[67]) makeRecipe(builder, ModPotions.IRON_SKIN, Items.REDSTONE, ModPotions.LONG_IRON_SKIN);
        if(Config.recipes[68]) makeRecipe(builder, ModPotions.IRON_SKIN, Items.GLOWSTONE_DUST, ModPotions.STRONG_IRON_SKIN);

        if(Config.recipes[69]) makeRecipe(builder, Potions.AWKWARD, Items.DIAMOND, ModPotions.DIAMOND_SKIN);
        if(Config.recipes[70]) makeRecipe(builder, ModPotions.DIAMOND_SKIN, Items.REDSTONE, ModPotions.LONG_DIAMOND_SKIN);
        if(Config.recipes[71]) makeRecipe(builder, ModPotions.DIAMOND_SKIN, Items.GLOWSTONE_DUST, ModPotions.STRONG_DIAMOND_SKIN);

        if(Config.recipes[72]) makeRecipe(builder, ModPotions.IRON_SKIN, Items.WITHER_ROSE, ModPotions.BROKEN_ARMOR);
        if(Config.recipes[73]) makeRecipe(builder, ModPotions.BROKEN_ARMOR, Items.REDSTONE, ModPotions.LONG_BROKEN_ARMOR);
        if(Config.recipes[74]) makeRecipe(builder, ModPotions.BROKEN_ARMOR, Items.GLOWSTONE_DUST, ModPotions.STRONG_BROKEN_ARMOR);

        if(Config.recipes[75]) makeRecipe(builder, Potions.AWKWARD, Items.LADDER, ModPotions.CLIMB);
        if(Config.recipes[76]) makeRecipe(builder, ModPotions.CLIMB, Items.REDSTONE, ModPotions.LONG_CLIMB);

        if(Config.recipes[77]) makeRecipe(builder, Potions.AWKWARD, Items.ENCHANTED_BOOK, ModPotions.MAGIC_SHIELD);
        if(Config.recipes[78]) makeRecipe(builder, ModPotions.MAGIC_SHIELD, Items.REDSTONE, ModPotions.LONG_MAGIC_SHIELD);
        if(Config.recipes[79]) makeRecipe(builder, ModPotions.MAGIC_SHIELD, Items.GLOWSTONE_DUST, ModPotions.STRONG_MAGIC_SHIELD);

        if(Config.recipes[80]) makeRecipe(builder, Potions.AWKWARD, Items.WITHER_ROSE, ModPotions.BROKEN_MAGIC_SHIELD);
        if(Config.recipes[81]) makeRecipe(builder, ModPotions.BROKEN_MAGIC_SHIELD, Items.REDSTONE, ModPotions.LONG_BROKEN_MAGIC_SHIELD);
        if(Config.recipes[82]) makeRecipe(builder, ModPotions.BROKEN_MAGIC_SHIELD, Items.GLOWSTONE_DUST, ModPotions.STRONG_BROKEN_MAGIC_SHIELD);

        if(Config.recipes[83]) makeRecipe(builder, Potions.THICK, Items.SALMON, ModPotions.DROWN);
        if(Config.recipes[84]) makeRecipe(builder, ModPotions.DROWN, Items.REDSTONE, ModPotions.LONG_DROWN);
        if(Config.recipes[85]) makeRecipe(builder, ModPotions.DROWN, Items.GLOWSTONE_DUST, ModPotions.STRONG_DROWN);

        if(Config.recipes[86]) makeRecipe(builder, Potions.HEALING, Items.TOTEM_OF_UNDYING, ModPotions.REVIVAL);
        if(Config.recipes[87]) makeRecipe(builder, ModPotions.REVIVAL, Items.REDSTONE, ModPotions.LONG_REVIVAL);
        if(Config.recipes[88]) makeRecipe(builder, ModPotions.REVIVAL, Items.GLOWSTONE_DUST, ModPotions.STRONG_REVIVAL);

        if(Config.recipes[89]) makeRecipe(builder, Potions.AWKWARD, Items.ANVIL, ModPotions.WEIGHT);
        if(Config.recipes[90]) makeRecipe(builder, ModPotions.WEIGHT, Items.REDSTONE, ModPotions.LONG_WEIGHT);
        if(Config.recipes[91]) makeRecipe(builder, ModPotions.WEIGHT, Items.GLOWSTONE_DUST, ModPotions.STRONG_WEIGHT);

        if(Config.recipes[92]) makeRecipe(builder, Potions.AWKWARD, Items.LIGHTNING_ROD, ModPotions.LIGHTNING);
        if(Config.recipes[93]) makeRecipe(builder, Potions.THICK, Items.NETHERITE_INGOT, ModPotions.INVERT);

        if(Config.recipes[94]) makeRecipe(builder, Potions.AWKWARD, Items.FLINT_AND_STEEL, ModPotions.FIRE);
        if(Config.recipes[95]) makeRecipe(builder, ModPotions.FIRE, Items.REDSTONE, ModPotions.LONG_FIRE);

        if(Config.recipes[96]) makeRecipe(builder, Potions.AWKWARD, Items.REDSTONE, ModPotions.EXTEND);
        if(Config.recipes[97]) makeRecipe(builder, ModPotions.EXTEND, Items.REDSTONE, ModPotions.LONG_EXTEND);

        if(Config.recipes[98]) makeRecipe(builder, Potions.LEAPING, Items.PISTON, ModPotions.LAUNCH);
        if(Config.recipes[99]) makeRecipe(builder, ModPotions.LAUNCH, Items.GLOWSTONE_DUST, ModPotions.STRONG_LAUNCH);

        if(Config.recipes[100]) makeRecipe(builder, Potions.AWKWARD, Items.TNT, ModPotions.EXPLOSION);
        if(Config.recipes[101]) makeRecipe(builder, ModPotions.EXPLOSION, Items.TNT, ModPotions.STRONG_EXPLOSION);

        if(Config.recipes[102]) makeRecipe(builder, ModPotions.EXPLOSION, Items.IRON_BLOCK, ModPotions.BURST);
        if(Config.recipes[103]) makeRecipe(builder, ModPotions.BURST, Items.GLOWSTONE_DUST, ModPotions.STRONG_BURST);

        if(Config.recipes[104]) makeRecipe(builder, Potions.AWKWARD, Items.CHORUS_FRUIT, ModPotions.RANDOM_TELEPORT);
        if(Config.recipes[105]) makeRecipe(builder, ModPotions.RANDOM_TELEPORT, Items.GLOWSTONE_DUST, ModPotions.STRONG_RANDOM_TELEPORT);
        if(Config.recipes[106]) makeRecipe(builder, ModPotions.RANDOM_TELEPORT, Items.GRASS_BLOCK, ModPotions.SURFACE_TELEPORT);
        if(Config.recipes[107]) makeRecipe(builder, ModPotions.RANDOM_TELEPORT, Items.WHITE_BED, ModPotions.SPAWN_TELEPORT);
    }

    private void makeRecipe(PotionBrewing.Builder builder, Holder<Potion> inputPotion, Item ingredient, Holder<Potion> resultPotion) {
        ItemStack inputStack = new ItemStack(Items.POTION);
        ItemStack resultStack = new ItemStack(Items.POTION);

        inputStack.set(DataComponents.POTION_CONTENTS, new PotionContents(inputPotion));
        resultStack.set(DataComponents.POTION_CONTENTS, new PotionContents(resultPotion));

        builder.addMix(inputPotion, Ingredient.of(ingredient).getValues().get(0).value(), resultPotion);
    }

    private static final Collection<AbstractMap.SimpleEntry<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

    public static void queueServerWork(int tick, Runnable action) {
        LOGGER.debug("Added work to the servers queue");
        if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
            workQueue.add(new AbstractMap.SimpleEntry<>(action, tick));
    }

    @SubscribeEvent
    public void tick(ServerTickEvent.Post event) {
        List<AbstractMap.SimpleEntry<Runnable, Integer>> actions = new ArrayList<>();
        workQueue.forEach(work -> {
            work.setValue(work.getValue() - 1);
            if (work.getValue() == 0)
                actions.add(work);
        });
        actions.forEach(e -> e.getKey().run());
        workQueue.removeAll(actions);
    }
}
