package com.SHARKY2023.EngineeringReimagined.network;


import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.network.packet.UpdateSolarPanel;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkDirection;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;

import java.util.Optional;

public class PacketHandler {

    private static final String PROTOCOL_VERSION = "1";
    // @formatter:off
    public static SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(EngineeringReimagined.MOD_ID, "net"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);
    // @formatter:on
    public static void init()
    {
        int id = 0;
        INSTANCE.registerMessage(id++, UpdateSolarPanel.class, UpdateSolarPanel::toBytes, UpdateSolarPanel::new, UpdateSolarPanel::handle, Optional.of(NetworkDirection.PLAY_TO_CLIENT));
    };
}