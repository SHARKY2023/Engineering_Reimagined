package com.SHARKY2023.EngineeringReimagined.network.packet;

import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.SolarPanelTile;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class UpdateSolarPanel {

    private BlockPos pos;
    private int currentEnergy;
    private int currentProduction;

    public UpdateSolarPanel(FriendlyByteBuf buf)
    {
        pos = buf.readBlockPos();
        currentEnergy = buf.readInt();
        currentProduction = buf.readInt();
    }

    public UpdateSolarPanel(BlockPos pos, int currentEnergy, int currentProduction)
    {
        this.pos = pos;
        this.currentEnergy = currentEnergy;
        this.currentProduction = currentProduction;
    }

    public void toBytes(FriendlyByteBuf buf)
    {
        buf.writeBlockPos(pos);
        buf.writeInt(currentEnergy);
        buf.writeInt(currentProduction);
    }

    public void handle(Supplier<NetworkEvent.Context> ctx)
    {
        ctx.get().enqueueWork(() -> {
            Level world = EngineeringReimagined.proxy.getClientWorld();
            if(world.isLoaded(pos))
            {
                BlockEntity te = world.getBlockEntity(pos);
                if(te instanceof SolarPanelTile)
                {
                    SolarPanelTile solar = (SolarPanelTile) te;
                    solar.energyClient = currentEnergy;
                    solar.energyProductionClient = currentProduction;
                }
            }
        });
        ctx.get().setPacketHandled(true);
    }
}
