package com.amazingthings.core.proxy;

import com.amazingthings.core.render.RenderVessel;
import com.amazingthings.core.tileentity.TileEntityVessel;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	public void registerRenderThings() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVessel.class, new RenderVessel());
	}
}
