package com.amazingthings.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OreBauxite extends Block{

	public OreBauxite(Material m) {
		super(m.rock);
		this.setBlockName("oreBauxite");
		this.setBlockTextureName("atcore:oreBauxite");
	}

}
