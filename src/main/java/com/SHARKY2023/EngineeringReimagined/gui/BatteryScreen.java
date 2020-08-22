package com.SHARKY2023.EngineeringReimagined.gui;

import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.blocks.battery.Container.BatteryContainer;

import com.SHARKY2023.EngineeringReimagined.blocks.battery.tile.BatteryTile;
import com.SHARKY2023.EngineeringReimagined.blocks.generator.solar.SolarPanelTile;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import java.util.Collections;

public class BatteryScreen extends ContainerScreen<BatteryContainer> {

    private static final ResourceLocation TEXTURES = new ResourceLocation(EngineeringReimagined.MOD_ID, "textures/gui/solar_panel.png");
    private final BatteryTile tile;

    public BatteryScreen(BatteryContainer container, PlayerInventory inv, ITextComponent name)
    {
        super(container, inv, name);
        this.tile = container.tile;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
        if(mouseX > guiLeft + 7 && mouseX < guiLeft + 29 && mouseY > guiTop + 10 && mouseY < guiTop + 77)
            this.renderTooltip(Collections.singletonList("Energy: " + getPercent() + "%"), mouseX, mouseY, font);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String energy = "Stored energy: " + getEnergyFormatted(tile.energyStored);
        this.font.drawString(energy, (xSize / 2 - font.getStringWidth(energy) / 2) + 14, 20, 4210752);

        String maxEnergy = "Max capacity: " + getEnergyFormatted(tile.maxEnergy);
        this.font.drawString(maxEnergy, (xSize / 2 - font.getStringWidth(maxEnergy) / 2) + 14, 30, 4210752);

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bindTexture(TEXTURES);
        this.blit(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        // Energy
        int y = this.getEnergyScaled(60);
        this.blit(this.guiLeft + 10, this.guiTop + 12 + y, 176, 0, 16, 60 - y);

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
        Long currentEnergy = (long) tile.energyStored;
        int maxEnergy = tile.maxEnergy;

        long result = currentEnergy * 100 / maxEnergy;

        return (int) result;
    }
}
