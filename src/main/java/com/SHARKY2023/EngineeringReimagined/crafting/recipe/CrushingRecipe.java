package com.SHARKY2023.EngineeringReimagined.crafting.recipe;

import com.SHARKY2023.EngineeringReimagined.registries.ModRecipes;
import com.google.gson.JsonObject;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.*;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nullable;


public class CrushingRecipe extends SingleItemRecipe  {

    public CrushingRecipe(ResourceLocation recipeId, Ingredient ingredient, ItemStack result) {
            super(ModRecipes.Types.CRUSHING, ModRecipes.Serializers.CRUSHING.get(), recipeId, "", ingredient, result);
    }

    @Override
    public boolean matches(IInventory inv, World world) {
        return this.ingredient.test(inv.getItem(0));
    }

    public static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<CrushingRecipe>{

        @Override
        public CrushingRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            Ingredient ingredient = Ingredient.fromJson(json.get("ingredient"));
            ResourceLocation itemId = new ResourceLocation((JSONUtils.getAsString(json,"result")));
            int count = JSONUtils.getAsInt(json,"count");

            ItemStack result = new ItemStack(ForgeRegistries.ITEMS.getValue(itemId),count);
            return new CrushingRecipe(recipeId, ingredient, result);

        }

        @Nullable
        @Override
        public CrushingRecipe fromNetwork(ResourceLocation recipeId, PacketBuffer buffer) {
             Ingredient ingredient = Ingredient.fromNetwork(buffer);
             ItemStack result = buffer.readItem();
             return new CrushingRecipe(recipeId, ingredient,result);
        }

        @Override
        public void toNetwork(PacketBuffer buffer, CrushingRecipe recipe) {
            recipe.ingredient.toNetwork(buffer);
            buffer.writeItem(recipe.result);
        }
    }


}


