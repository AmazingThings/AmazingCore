package com.amazingthings.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OreLead extends Block{

	public OreLead(Material m) {
		super(m.rock);
		this.setBlockName("oreLead");
		this.setBlockTextureName("oreLead");
	}

}
