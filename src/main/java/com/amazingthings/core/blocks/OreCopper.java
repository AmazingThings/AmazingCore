package com.amazingthings.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OreCopper extends Block{

	public OreCopper(Material m) {
		super(m.rock);
		this.setBlockName("oreCopper");
		this.setBlockTextureName("atcore:oreCopper");
	}

}
