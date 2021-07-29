package com.SHARKY2023.EngineeringReimagined.gui;

import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.SolarPanelContainer;

import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.SolarPanelTile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;

public class SolarPanelScreen extends AbstractContainerScreen<SolarPanelContainer> {

    private static final ResourceLocation TEXTURES = new ResourceLocation(EngineeringReimagined.MOD_ID, "textures/gui/solar_panel.png");
    private final SolarPanelTile tile;

    public SolarPanelScreen(SolarPanelContainer container, Inventory inv, Component name)
    {
        super(container, inv, name);
        this.tile = container.tile;
    }

    @Override
    public void render(PoseStack mStack, int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground(mStack);
        super.render(mStack,mouseX, mouseY, partialTicks);
        this.renderTooltip(mStack, mouseX, mouseY);
        if(mouseX > leftPos + 7 && mouseX < leftPos + 29 && mouseY > topPos + 3 && mouseY < topPos + 70)
            this.renderTooltip(mStack, new TextComponent("Energy: " + getPercent() + "%"), mouseX, mouseY);
    }

    @Override
    protected void renderLabels(PoseStack mStack, int mouseX, int mouseY)
    {
        String energy = "Stored energy: " + getEnergyFormatted(tile.energyClient);
        this.font.draw(mStack, energy, (imageWidth / 2 - font.width(energy) / 2) + 14, 20, 4210752);

        String maxEnergy = "Max capacity: " + getEnergyFormatted(tile.maxEnergy);
        this.font.draw(mStack, maxEnergy, (imageWidth / 2 - font.width(maxEnergy) / 2) + 14, 30, 4210752);

        String generation = "Generation: " + tile.energyProductionClient + " FE/t";
        this.font.draw(mStack, generation, (imageWidth / 2 - font.width(generation) / 2) + 14, 40, 4210752);
    }

    @Override
    protected void renderBg(PoseStack mStack, float partialTicks, int mouseX, int mouseY)
    {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bind(TEXTURES);
        this.blit(mStack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);

        // Energy
        int y = this.getEnergyScaled(60);
        this.blit(mStack ,this.leftPos + 12, this.topPos + 5 + y, 180, 0, 16, 60 - y);

    }

    private String getEnergyFormatted(int energy)
    {
        if(energy >= 1000000)
            return (energy / 1000) + " kFE";
        else
            return energy + " FE";
    }

    private int getEnergyScaled(int pixels)
    {
        return pixels - (pixels * getPercent() / 100);
    }

    private int getPercent()
    {
        Long currentEnergy = new Long(tile.energyClient);
        int maxEnergy = tile.maxEnergy;

        long result = currentEnergy * 100 / maxEnergy;

        return (int) result;
    }
}