package com.SHARKY2023.EngineeringReimagined.resources;

public enum BlockResourceInfo implements INamedResource {
    COPPER("copper", 5.0f, 10.0f, 1),
    TIN("tin", 5.0f, 10.0f, 1),
    BRONZE("bronze", 5.0f, 15.0f, 1),
    SILVER("silver", 5.0f, 15.0f, 1),
    LEAD("lead", 7.5f, 15.0f, 1),
    ELECTRUM("electrum", 7.5f, 15.0f, 1),
    STEEL("steel", 10.0f, 15.0f, 1),
    PLATINUM("platinum", 10.0f, 15f, 1),
    URANIUM("uranium", 10.0f, 15.0f, 1),
    BRASS("brass", 5.0f, 10.0f, 1),
    ZINC("zinc", 5.0f, 10.0f, 1),
    NICKEL("nickel", 7.5f, 15.0f, 1),
    INVAR("invar", 10.0f, 15.0f, 1),
    ALUMINIUM("aluminum", 5.0f, 10.0f, 1),
    CHARCOAL("charcoal", 5.0F, 10.0F, 0, 0);


    private final String registrySuffix;
    private final float resistance;
    private final float hardness;
    private final int lightValue;
    private final int harvestLevel;

    BlockResourceInfo(String registrySuffix, float hardness, float resistance, int harvestLevel) {
        this(registrySuffix, hardness, resistance, harvestLevel, 0);
    }

    BlockResourceInfo(String registrySuffix, float hardness, float resistance, int harvestLevel, int lightValue) {
        this.registrySuffix = registrySuffix;
        this.hardness = hardness;
        this.resistance = resistance;
        this.harvestLevel = harvestLevel;
        this.lightValue = lightValue;
    }


    @Override
    public String getRegistrySuffix() {
        return registrySuffix;
    }

    public float getHardness() {
        return hardness;
    }

    public float getResistance() {
        return resistance;
    }

    public int getLightValue() {
        return lightValue;
    }

    public int getHarvestLevel() {
        return harvestLevel;
    }
}






