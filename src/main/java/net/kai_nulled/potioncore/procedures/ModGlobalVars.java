package net.kai_nulled.potioncore.procedures;

import net.kai_nulled.potioncore.PotionCore;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.registries.RegisterEvent;

import java.util.ArrayList;
import java.util.List;

@EventBusSubscriber(modid = PotionCore.MODID)
public class ModGlobalVars {
    public static List<MobEffect> potionList = new ArrayList<>();
    public static List<MobEffect> gpotionList = new ArrayList<>();
    public static List<MobEffect> bpotionList = new ArrayList<>();

    @SubscribeEvent
    public static void onRegister(RegisterEvent event) {
        if (event.getRegistryKey().equals(BuiltInRegistries.MOB_EFFECT.key())) {
            for (MobEffect effect : BuiltInRegistries.MOB_EFFECT) {
                potionList.add(effect);

                if (effect.isBeneficial()) {
                    gpotionList.add(effect);
                } else if (effect.getCategory() == MobEffectCategory.HARMFUL) {
                    bpotionList.add(effect);
                }
            }
        }
    }
}