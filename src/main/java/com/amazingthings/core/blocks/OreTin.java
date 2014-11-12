package com.amazingthings.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OreTin extends Block{

	public OreTin(Material m) {
		super(m.rock);
		this.setBlockName("oreTin");
		this.setBlockTextureName("atcore:oreTin");
	}

}
