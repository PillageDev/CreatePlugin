package dev.crafty.types;

import org.bukkit.inventory.ItemStack;

public class CreateRecipe {
    private ItemStack[] ingredients;
    private ItemStack result;

    public CreateRecipe(ItemStack[] ingredients, ItemStack result) {
        this.ingredients = ingredients;
        this.result = result;
    }

    public ItemStack[] getIngredients() {
        return ingredients;
    }

    public ItemStack getResult() {
        return result;
    }

    public void setIngredients(ItemStack[] ingredients) {
        this.ingredients = ingredients;
    }

    public void setResult(ItemStack result) {
        this.result = result;
    }

    public boolean equals(CreateRecipe recipe) {
        if (recipe == null) {
            return false;
        }
        if (this.ingredients.length != recipe.getIngredients().length) {
            return false;
        }
        for (int i = 0; i < this.ingredients.length; i++) {
            if (!this.ingredients[i].equals(recipe.getIngredients()[i])) {
                return false;
            }
        }
        return this.result.equals(recipe.getResult());
    }

    public String toString() {
        String recipeString = "";
        for (ItemStack ingredient : this.ingredients) {
            recipeString += ingredient.toString() + " ";
        }
        recipeString += this.result.toString();
        return recipeString;
    }
}
