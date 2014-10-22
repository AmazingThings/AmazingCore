package com.amazingthings.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OreSilver extends Block{

	public OreSilver(Material m) {
		super(m.rock);
		this.setBlockName("oreSilver");
		this.setBlockTextureName("oreSilver");
	}

}
