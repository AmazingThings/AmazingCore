package com.amazingthings.core.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;

import com.amazingthings.core.AmazingCore;
import com.amazingthings.core.tileentity.TileEntityVessel;

import cpw.mods.fml.common.registry.GameRegistry;

public class Vessel extends BlockContainer{

	public static TileEntityVessel tile;

	float pixel = 1f/16f;
	
	public Vessel(Material m) {
		super(m);
		this.setBlockBounds(pixel*1, 0f, pixel*1, pixel*15, pixel*15, pixel*15);
		this.setBlockName("vessel");
		this.setBlockTextureName("atcore:vessel");
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return tile = new TileEntityVessel();
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

	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int i, float f, float f1, float f2) {

		TileEntityVessel tile = (TileEntityVessel)w.getTileEntity(x, y, z);
		ItemStack item = p.getCurrentEquippedItem();

		if(tile == null || p.isSneaking() || item == null){
			return false;
		}
		
		if(GameRegistry.getFuelValue(item) > 0){
			tile.fuelTime += GameRegistry.getFuelValue(item);
			item.stackSize--;
			return true;
		}

		if(tile.Smelting == null){
			tile.Smelting = item.getItem();
			tile.amount++;
			item.stackSize--;
		}else if(tile.Smelting == item.getItem()){
			tile.amount++;
			item.stackSize--;
		}else{
			return false;
		}

		return true;

	}
}
