package com.SHARKY2023.EngineeringReimagined.crafting.recipe;

import com.SHARKY2023.EngineeringReimagined.registries.ModRecipes;
import com.google.gson.JsonObject;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.GsonHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;


import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SingleItemRecipe;

public class CrushingRecipe extends SingleItemRecipe  {

    public CrushingRecipe(ResourceLocation recipeId, Ingredient ingredient, ItemStack result) {
            super(ModRecipes.Types.CRUSHING, ModRecipes.Serializers.CRUSHING.get(), recipeId, "", ingredient, result);
    }

    @Override
    public boolean matches(Container inv, Level world) {
        return this.ingredient.test(inv.getItem(0));
    }

    public static class Serializer extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<CrushingRecipe>{

        @Override
        public CrushingRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            Ingredient ingredient = Ingredient.fromJson(json.get("ingredient"));
            ResourceLocation itemId = new ResourceLocation((GsonHelper.getAsString(json,"result")));
            int count = GsonHelper.getAsInt(json,"count");

            ItemStack result = new ItemStack(ForgeRegistries.ITEMS.getValue(itemId),count);
            return new CrushingRecipe(recipeId, ingredient, result);

        }

        @Nullable
        @Override
        public CrushingRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
             Ingredient ingredient = Ingredient.fromNetwork(buffer);
             ItemStack result = buffer.readItem();
             return new CrushingRecipe(recipeId, ingredient,result);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, CrushingRecipe recipe) {
            recipe.ingredient.toNetwork(buffer);
            buffer.writeItem(recipe.result);
        }
    }


}


