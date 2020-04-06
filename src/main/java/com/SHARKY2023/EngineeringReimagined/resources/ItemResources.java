package com.SHARKY2023.EngineeringReimagined.resources;

public enum ItemResources implements INamedResource{
    COPPER("copper"),
    TIN("tin"),
    BRONZE("bronze"),
    SILVER("silver"),
    LEAD("lead"),
    ELECTRUM("electrum"),
    STEEL("steel"),
    PLATINUM("platinum"),
    URANIUM("uranium"),
    BRASS("brass"),
    ZINC("zinc"),
    NICKEL("nickel"),
    INVAR("invar"),
    ALUMINIUM("aluminum"),
    COAL("coal"),
    CHARCOAL("charcoal"),
    DIAMOND("diamond"),
    EMERALD("emerald"),
    LAPIS("lapis_lazuri"),
    IRON("iron"),
    GOLD("gold");



    private final String registrySuffix;

    ItemResources(String registrySuffix) {
        this.registrySuffix = registrySuffix;
    }
    @Override
    public String getRegistrySuffix() {
        return registrySuffix;
    }
}
