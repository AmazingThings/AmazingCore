package com.amazingthings.core.blocks;

import com.amazingthings.core.tileentity.TileEntityFilter;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Filter extends BlockContainer {

	float pixel = 1F/16F;
	
	public Filter() {
		super(Material.iron);
		this.setBlockBounds(pixel*1, 0f, pixel*1, pixel*15, pixel*9, pixel*15);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityFilter();
	}

	public int getRenderType() {
		return -1;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
    public boolean hasTileEntity()
    {
        return true;
    }

	public boolean renderAsNormalBlock() {
		return false;
	}

}
