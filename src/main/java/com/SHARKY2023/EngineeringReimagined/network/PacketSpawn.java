package com.SHARKY2023.EngineeringReimagined.network;

import net.minecraft.world.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;
//import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;


public class PacketSpawn {

    private final ResourceLocation id;
  //  private final DimensionType type;
    private final BlockPos pos;

    public PacketSpawn(FriendlyByteBuf buf) {
        id = buf.readResourceLocation();
       // type = DimensionType.getById(buf.readInt());
        pos = buf.readBlockPos();
    }

    public PacketSpawn(ResourceLocation id/*DimensionType type */, BlockPos pos) {
        this.id = id;
       // this.type = type;
        this.pos = pos;
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeResourceLocation(id);
    //    buf.writeInt(type.getId());
        buf.writeBlockPos(pos);
    }

    public boolean handle(Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
          //  ServerWorld spawnWorld = ctx.get().getSender().level.getServer().getLevel(type);
            EntityType<?> entityType = ForgeRegistries.ENTITIES.getValue(id);
            if (entityType == null) {
                throw new IllegalStateException("This cannot happen! Unknown id '" + id.toString() + "'!");
            }
          //  entityType.spawn(spawnWorld, null, null, pos, SpawnReason.SPAWN_EGG, true, true);
        });
        return true;
    }

}

