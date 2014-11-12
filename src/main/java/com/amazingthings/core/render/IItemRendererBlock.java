package com.amazingthings.core.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import com.amazingthings.core.blocks.ATBlocks;
import com.amazingthings.core.tileentity.TileEntityFilter;
import com.amazingthings.core.tileentity.TileEntityVessel;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class IItemRendererBlock implements ISimpleBlockRenderingHandler{

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		GL11.glPushMatrix();
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

		if(block == ATBlocks.filter){
			TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityFilter(), 0.0D, 0.0D, 0.0D, 0.0F);
		}else if(block == ATBlocks.vessel){
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
