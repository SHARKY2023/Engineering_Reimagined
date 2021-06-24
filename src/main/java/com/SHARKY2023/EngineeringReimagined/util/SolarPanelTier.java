package com.SHARKY2023.EngineeringReimagined.util;

public enum SolarPanelTier {

    Basic, Advanced, Ultimate;

    public String getSolarPanelName()
    {
        return "solar_panel_" + getCorrectName(this.ordinal());
    }

    private String getCorrectName(int index)
    {
        switch (index) {
            case 0:
                return "basic";
            case 1:
                return "advanced";
            case 2:
                return "ultimate";
            default:
                throw new RuntimeException("Solar panel tier not yet implemented!");
        }}
}
