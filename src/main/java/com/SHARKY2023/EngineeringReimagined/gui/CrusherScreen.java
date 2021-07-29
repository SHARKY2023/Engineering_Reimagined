package com.SHARKY2023.EngineeringReimagined.gui;

import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.SHARKY2023.EngineeringReimagined.blocks.machine.crusher.CrusherContainer;
import com.SHARKY2023.EngineeringReimagined.blocks.machine.crusher.CrusherTile;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

public class CrusherScreen extends AbstractContainerScreen<CrusherContainer>{

    private static final ResourceLocation GUI = new ResourceLocation(EngineeringReimagined.MOD_ID, "textures/gui/solar_panel.png");

    private final CrusherTile tile;

        public CrusherScreen(CrusherContainer container, Inventory inv, Component name) {
            super(container, inv, name);
            this.tile = container.tile;
        }

        @Override
        public void render(PoseStack matrixStack, int mouseX, int mouseY, float partialTicks) {
            this.renderBackground(matrixStack);
            super.render(matrixStack, mouseX, mouseY, partialTicks);
            this.renderTooltip(matrixStack, mouseX, mouseY);
        }

        @Override
        protected void renderLabels(PoseStack mStack, int mouseX, int mouseY) {
            String energy = "Stored energy: " + getEnergyFormatted(menu.getEnergy());
            this.font.draw(mStack, energy, (imageWidth / 2 - font.width(energy) / 2) + 14, 20, 4210752);
            // drawString(mStack, Minecraft.getInstance().font, "Energy: " + getEnergyFormatted(menu.getEnergy()),14 , 20, 4210752);


            String maxEnergy = "Max capacity: " + getEnergyFormatted(20000000);
            this.font.draw(mStack, maxEnergy, (imageWidth / 2 - font.width(maxEnergy) / 2) + 14, 30, 4210752);

        }
        @Override
        protected void renderBg(PoseStack mStack, float partialTicks, int mouseX, int mouseY)
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
            int maxEnergy = 20000000;

            long result = currentEnergy * 100 / maxEnergy;

            return (int) result;
        }
}
