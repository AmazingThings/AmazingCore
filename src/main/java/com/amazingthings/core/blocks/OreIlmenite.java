package com.amazingthings.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OreIlmenite extends Block{

	public OreIlmenite(Material m) {
		super(m.rock);
		this.setBlockName("oreIlmenite");
		this.setBlockTextureName("atcore:oreIlmenite");
	}

}
