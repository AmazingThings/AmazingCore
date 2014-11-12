package com.amazingthings.core.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;

import com.amazingthings.core.AmazingCore;
import com.amazingthings.core.tileentity.TileEntityVessel;
import com.amazingthings.core.items.*;

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

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
    public boolean hasTileEntity()
    {
        return true;
    }

	@Override
	public boolean renderAsNormalBlock() {
		return false;

	}

	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int i, float f, float f1, float f2) {

		TileEntityVessel tile = (TileEntityVessel)w.getTileEntity(x, y, z);
		ItemStack item = p.getCurrentEquippedItem();
		
		if(tile == null || p.isSneaking() || item == null){
			return false;
		}
		
		if(item == new ItemStack(Items.arrow)) {
			p.addChatMessage(new ChatComponentText(tile.fuelTime+""));
			p.addChatMessage(new ChatComponentText(tile.burnTime+""));
			p.addChatMessage(new ChatComponentText(tile.amount+""));
			p.addChatMessage(new ChatComponentText(tile.Smelting+""));
			System.out.println("worked");
			return false;
			
		}
		
		if(TileEntityFurnace.isItemFuel(item)){
			tile.fuelTime += TileEntityFurnace.getItemBurnTime(item);
			item.stackSize--;
			return true;
		}

		if(tile.Smelting == null){
			if(item != new ItemStack(Items.arrow)) {
			tile.Smelting = item.getItem();
			tile.amount++;
			item.stackSize--;
			}
		}else if(tile.Smelting == item.getItem()){
			
			tile.amount++;
			item.stackSize--;
		}else{
			return false;
		}

		return true;
	}
}
