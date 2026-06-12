package net.kai_nulled.potioncore.utils;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionContents;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;
import org.jetbrains.annotations.NotNull;

public class BetterBrewingRecipes implements IBrewingRecipe {
    private final Holder<Potion> input;
    private final Item ingredient;
    private final Holder<Potion> output;

    public BetterBrewingRecipes(Holder<Potion> input, Item ingredient, Holder<Potion> output) {
        this.input = input;
        this.ingredient = ingredient;
        this.output = output;
    }

    @Override
    public boolean isInput(ItemStack inputStack) {
        PotionContents contents = inputStack.get(DataComponents.POTION_CONTENTS);
        if (contents == null || contents.potion().isEmpty()) {
            return false;
        }
        return contents.potion().get().is(this.input.unwrapKey().orElseThrow());
    }

    @Override
    public boolean isIngredient(ItemStack ingredientStack) {
        return ingredientStack.is(this.ingredient);
    }

    @Override
    public @NotNull ItemStack getOutput(@NotNull ItemStack inputStack, @NotNull ItemStack ingredientStack) {
        if (!this.isInput(inputStack) || !this.isIngredient(ingredientStack)) {
            return ItemStack.EMPTY;
        }

        ItemStack outputStack = new ItemStack(inputStack.getItem());

        outputStack.set(DataComponents.POTION_CONTENTS, new PotionContents(this.output));

        return outputStack;
    }
}