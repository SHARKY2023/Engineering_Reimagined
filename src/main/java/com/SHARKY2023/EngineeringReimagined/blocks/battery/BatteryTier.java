package com.SHARKY2023.EngineeringReimagined.blocks.battery;

public enum BatteryTier {

    Basic, Advanced, Ultimate;

    public String getBatteryName()
    {
        return "battery_" + getCorrectName(this.ordinal());
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
                throw new RuntimeException("Battery tier not yet implemented!");
        }}
    }
