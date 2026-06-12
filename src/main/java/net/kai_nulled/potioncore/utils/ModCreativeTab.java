package net.kai_nulled.potioncore.utils;

import net.kai_nulled.potioncore.PotionCore;
import net.kai_nulled.potioncore.potions.ModPotions;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModCreativeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB
            = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PotionCore.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> POTION_CORE = CREATIVE_MODE_TAB.register("potioncore",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(Items.POTION))
                    .title(Component.translatable("creativetab.potioncore"))
                    .displayItems((pParameters, pOutput) -> {
                        for (DeferredHolder<Potion, ? extends Potion> potion : ModPotions.POTIONS.getEntries()) {

                            ItemStack potionStack = new ItemStack(Items.POTION);
                            potionStack.set(DataComponents.POTION_CONTENTS, new PotionContents(potion));
                            pOutput.accept(potionStack);

                            ItemStack splashStack = new ItemStack(Items.SPLASH_POTION);
                            splashStack.set(DataComponents.POTION_CONTENTS, new PotionContents(potion));
                            pOutput.accept(splashStack);

                            ItemStack lingeringStack = new ItemStack(Items.LINGERING_POTION);
                            lingeringStack.set(DataComponents.POTION_CONTENTS, new PotionContents(potion));
                            pOutput.accept(lingeringStack);

                            ItemStack arrowStack = new ItemStack(Items.TIPPED_ARROW);
                            arrowStack.set(DataComponents.POTION_CONTENTS, new PotionContents(potion));
                            pOutput.accept(arrowStack);
                        }
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}