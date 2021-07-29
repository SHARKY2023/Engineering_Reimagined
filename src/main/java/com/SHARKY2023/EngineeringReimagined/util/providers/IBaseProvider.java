package com.SHARKY2023.EngineeringReimagined.util.providers;



import net.minecraft.resources.ResourceLocation;

public interface IBaseProvider {

    ResourceLocation getRegistryName();

    default String getName() {
        return getRegistryName().getPath();
    }
}
