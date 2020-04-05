package com.SHARKY2023.EngineeringReimagined.proxy;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public interface IProxy {

    World getClientWorld();

    PlayerEntity getClientPlayer();


}
