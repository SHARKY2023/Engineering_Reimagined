package com.SHARKY2023.EngineeringReimagined.blocks.generator.sterling;
import com.SHARKY2023.EngineeringReimagined.EngineeringReimagined;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;

public class SterlingScreen extends ContainerScreen<SterlingContainer> {

    private static final ResourceLocation TEXTURES = new ResourceLocation(EngineeringReimagined.MOD_ID, "textures/gui/sterling_gui.png");
    private final SterlingTile tile;

    public SterlingScreen(SterlingContainer container, PlayerInventory inv, ITextComponent name) {
        super(container, inv, name);
        this.tile = container.tile;
    }

    @Override
    public void render(MatrixStack mStack, int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground(mStack);
        super.render(mStack, mouseX, mouseY, partialTicks);
        this.renderTooltip(mStack, mouseX, mouseY);
        if(mouseX > leftPos + 7 && mouseX < leftPos + 29 && mouseY > topPos + 10 && mouseY < topPos + 77)
            this.renderTooltip(mStack, new StringTextComponent("Energy: " + /*getPercent() + */  "%"), mouseX, mouseY);
    }

    @Override
    protected void renderLabels(MatrixStack mStack,int mouseX, int mouseY) {

        drawString(mStack,Minecraft.getInstance().font, "Energy: " + menu.getEnergy(), 10, 10, 0xffffff);
    }

    protected void renderBg(MatrixStack mStack, float partialTicks, int mouseX, int mouseY) {
        this.minecraft.getTextureManager().bind(TEXTURES);
        this.blit(mStack, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }


    }