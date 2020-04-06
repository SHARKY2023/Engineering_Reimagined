package com.SHARKY2023.EngineeringReimagined.resources;



public enum ResourceType {
    DUST("dust"),
    INGOT("ingot"),
    NUGGET("nugget");

    private final String registryPrefix;

    ResourceType(String prefix) {
        this.registryPrefix = prefix;
    }

    public String getRegistryPrefix() {
        return registryPrefix;
    }
}
