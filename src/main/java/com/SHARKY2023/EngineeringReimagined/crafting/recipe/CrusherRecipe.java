package com.SHARKY2023.EngineeringReimagined.crafting.recipe;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.*;
import java.util.Map;

public class CrusherRecipe extends IRecipe<IInventory> {
  private final ResourceLocation recipeId;
  private int processTime;
  private Ingredient ingredient;
  private final Map<ItemStack, Float> results = new LinkedHashMap<>();

  public CrusherRecipe(ResourceLocation recipeId) {
      this.recipeId = recipeId;
  }


  public int getProcessTime() {
      return processTime;
  }


    public Ingredient getIngredient() {
        return ingredient;
    }








    @Override
    public boolean matches(IInventory p_77569_1_, World p_77569_2_) {
        return false;
    }

    @Override
    public ItemStack assemble(IInventory p_77572_1_) {
        return null;
    }

    @Override
    public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
        return false;
    }


    @Override
    public ItemStack getResultItem() {
        return null;
    }

    @Override
    public ResourceLocation getId() {
        return recipeId;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return ModRecipes.Types.CRUSHER;
    }

    @Override
    public IRecipeType<?> getType() {
        return null;
    }
}
