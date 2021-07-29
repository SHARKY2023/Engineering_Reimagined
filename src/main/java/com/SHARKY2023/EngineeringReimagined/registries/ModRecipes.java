package com.SHARKY2023.EngineeringReimagined.registries;

import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.crafting.recipe.CrushingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.fml.RegistryObject;

import RegistryObject;

public final class ModRecipes {
    public static final class Types{
        public  static final RecipeType<CrushingRecipe> CRUSHING = RecipeType.register(EngineeringReimagined.MOD_ID + "crushing");


    }

    public static class Serializers {
        public static final RegistryObject<RecipeSerializer<?>> CRUSHING = Registration.RECIPE_SERIALIZERS.register("crushing", CrushingRecipe.Serializer::new);

        }
    }




