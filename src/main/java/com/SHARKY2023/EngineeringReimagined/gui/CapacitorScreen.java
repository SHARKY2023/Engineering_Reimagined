package com.SHARKY2023.EngineeringReimagined.gui;

import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.blocks.capacitor.CapacitorContainer;

import com.SHARKY2023.EngineeringReimagined.blocks.capacitor.CapacitorTile;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class CapacitorScreen extends ContainerScreen<CapacitorContainer> {

        private static final ResourceLocation GUI = new ResourceLocation(EngineeringReimagined.MOD_ID, "textures/gui/solar_panel.png");
        private final CapacitorTile tile;

        public CapacitorScreen(CapacitorContainer container, PlayerInventory inv, ITextComponent name) {
            super(container, inv, name);
            this.tile = container.tile;
        }

        @Override
        public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
            this.renderBackground(matrixStack);
            super.render(matrixStack, mouseX, mouseY, partialTicks);
            this.renderTooltip(matrixStack, mouseX, mouseY);
        }

        @Override
        protected void renderLabels(MatrixStack matrixStack, int mouseX, int mouseY) {
            drawString(matrixStack, Minecraft.getInstance().font, "Energy: " + menu.getEnergy(), 10, 10, 0xffffff);
        }

    @Override
    protected void renderBg(MatrixStack mStack, float partialTicks, int mouseX, int mouseY)
    {
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bind(GUI);
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
        Long currentEnergy = new Long(menu.getEnergy());
        int maxEnergy = 2000000;

        long result = currentEnergy * 100 / maxEnergy;

        return (int) result;
    }
}

