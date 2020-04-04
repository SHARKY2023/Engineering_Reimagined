/*
Large Portions of this class are written by BluSunrize for Immersive Engineering
 */



package com.SHARKY2023.engineeringreimagined.blocks;

public enum EnumMetals {

    COPPER(0.3f),
    ALUMINUM(0.3F),
    LEAD(0.7F),
    SILVER(1.0F),
    NICKEL(1.0F),
    PLATINUM(1.0f),
    TIN(0.3F),
    ZINC(0.6f),
    URANIUM(1.0F),
    INVAR(Type.RE_ALLOY, Float.NaN),
    BRASS(Type.RE_ALLOY, Float.NaN),
    BRONZE(Type.RE_ALLOY, Float.NaN),
    ELECTRUM(Type.RE_ALLOY, Float.NaN),
    STEEL(Type.RE_ALLOY, Float.NaN),
    IRON(Type.VANILLA, 0.7F),
    GOLD(Type.VANILLA, 1);

    private final Type type;
    public final float smeltingXP;

    EnumMetals(Type t, float xp)
    {
        this.type = t;
        this.smeltingXP = xp;
    }

    EnumMetals(float xp)
    {
        smeltingXP = xp;
        this.type = Type.RE_PURE;
    }

    public boolean isVanillaMetal()
    {
        return type==Type.VANILLA;
    }

    public boolean isAlloy()
    {
        return type==Type.RE_ALLOY;
    }

    public boolean shouldAddOre()
    {
        return !isVanillaMetal()&&!isAlloy();
    }

    public String tagName()
    {
        return name().toLowerCase();
    }

    private enum Type
    {
        VANILLA,
        RE_PURE,
        RE_ALLOY
    }
}