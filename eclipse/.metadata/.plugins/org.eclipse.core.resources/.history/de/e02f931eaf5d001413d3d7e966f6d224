package com.amazingthings.core.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import com.amazingthings.core.AmazingCore;
import com.amazingthings.core.render.IItemRendererFilter;
import com.amazingthings.core.render.RenderFilter;
import com.amazingthings.core.render.RenderVessel;
import com.amazingthings.core.tileentity.TileEntityFilter;
import com.amazingthings.core.tileentity.TileEntityVessel;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	public void registerRenderThings() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVessel.class, new RenderVessel());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityFilter.class, new RenderFilter());
		
		RenderingRegistry.registerBlockHandler(new IItemRendererFilter());
	}
}
