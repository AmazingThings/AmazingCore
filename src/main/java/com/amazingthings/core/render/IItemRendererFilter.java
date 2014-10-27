package com.amazingthings.core.render;

import org.lwjgl.opengl.GL11;

import com.amazingthings.core.AmazingCore;
import com.amazingthings.core.ResourceType;
import com.amazingthings.core.Resources;
import com.amazingthings.core.blocks.Filter;
import com.amazingthings.core.model.ModelFilter;
import com.amazingthings.core.model.ModelVessel;
import com.amazingthings.core.proxy.ClientProxy;
import com.amazingthings.core.tileentity.TileEntityFilter;
import com.amazingthings.core.tileentity.TileEntityVessel;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.common.util.ForgeDirection;

public class IItemRendererFilter implements ISimpleBlockRenderingHandler{

	@Override
	 public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
	 GL11.glPushMatrix();
	 GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
	 
	 if(block == AmazingCore.filter){
		 TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityFilter(), 0.0D, 0.0D, 0.0D, 0.0F);
	 }else if(block == AmazingCore.vessel){
		 TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityVessel(), 0.0D, 0.0D, 0.0D, 0.0F);
	 }
	 GL11.glPopMatrix();
	 }

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z,
			Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override
	public int getRenderId() {
		return -1;
	}
}
