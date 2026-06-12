package net.kai_nulled.potioncore.effects;

import net.minecraft.core.NonNullList;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;

public class DisorganizationEffect extends MobEffect {

    public DisorganizationEffect(MobEffectCategory category, int color) {
        super(category, color);
    }

    public ItemStack getItemStack(int sltid, Entity entity) {
        IItemHandler capability = entity.getCapability(Capabilities.ItemHandler.ENTITY, null);
        if (capability != null) {
            return capability.getStackInSlot(sltid).copy();
        }
        return ItemStack.EMPTY;
    }

    public void setItemStack(int sltid, ItemStack slt, Entity entity) {
        ItemStack setStack = slt.copy();
        setStack.setCount(slt.getCount());

        IItemHandler capability = entity.getCapability(Capabilities.ItemHandler.ENTITY, null);
        if (capability instanceof IItemHandlerModifiable modHandler) {
            modHandler.setStackInSlot(sltid, setStack);
        }
    }

    @Override
    public boolean applyEffectTick(@NotNull ServerLevel level, @NotNull LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity instanceof Player player) {
            Inventory pInv = player.getInventory();
            if (!pInv.isEmpty()) {
                NonNullList<ItemStack> inv = NonNullList.withSize(36, ItemStack.EMPTY);
                for (int i = 0; i < 36; i++) {
                    inv.set(i, pInv.getItem(i).copy());
                }

                Collections.shuffle(inv);

                for (int i = 0; i < 36; i++) {
                    pInv.setItem(i, inv.get(i));
                }
            }
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return pDuration % 50 == 0;
    }
}