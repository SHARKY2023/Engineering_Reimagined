package com.SHARKY2023.EngineeringReimagined.registries;

import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.crafting.recipe.CrushingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraftforge.fml.RegistryObject;

public final class ModRecipes {
    public static final class Types{
        public  static final IRecipeType<CrushingRecipe> CRUSHING = IRecipeType.register(EngineeringReimagined.MOD_ID + "crushing");


    }

    public static class Serializers {
        public static final RegistryObject<IRecipeSerializer<?>> CRUSHING = Registration.RECIPE_SERIALIZERS.register("crushing", CrushingRecipe.Serializer::new);

        }
    }




