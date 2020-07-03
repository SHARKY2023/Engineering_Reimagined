package com.SHARKY2023.EngineeringReimagined.resources;

public enum ItemResources implements INamedResource {
    COPPER("copper"),
    TIN("tin"),
    BRONZE("bronze",Type.ALLOY),
    SILVER("silver"),
    LEAD("lead"),
    ELECTRUM("electrum",Type.ALLOY),
    STEEL("steel",Type.ALLOY),
    PLATINUM("platinum"),
    URANIUM("uranium"),
    BRASS("brass",Type.ALLOY),
    ZINC("zinc"),
    NICKEL("nickel"),
    INVAR("invar",Type.ALLOY),
    ALUMINIUM("aluminum"),
    COAL("coal",Type.VANILLA),
    CHARCOAL("charcoal",Type.SPECIAL),
    DIAMOND("diamond", Type.VANILLA),
    EMERALD("emerald", Type.VANILLA),
    LAPIS("lapis_lazuri", Type.VANILLA),
    IRON("iron", Type.VANILLA),
    GOLD("gold", Type.VANILLA);

    private final Type type;
    private final String registrySuffix;

    ItemResources(String registrySuffix) {
        this.registrySuffix = registrySuffix;
        this.type = Type.PURE;
    }

    ItemResources(String registrySuffix, Type t) {
        this.type = t;
        this.registrySuffix = registrySuffix;
    }

    @Override
    public String getRegistrySuffix() {
        return registrySuffix;
    }


    public boolean isVanillaMetal() {
        return type == Type.VANILLA;
    }
    public boolean isAlloy()
    {
        return type==Type.ALLOY;
    }

    public boolean isSpecial()
    {
        return type==Type.SPECIAL;
    }

    public boolean shouldAddOre()
    {
        return !isVanillaMetal()&&!isAlloy()&&!isSpecial();
    }

    public String tagName()
    {
        return registrySuffix;
    }


    private enum Type
    {
        VANILLA,
        PURE,
        ALLOY,
        SPECIAL
    }
}