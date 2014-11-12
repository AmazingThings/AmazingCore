package com.amazingthings.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class UHA extends Block{

	protected UHA(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setBlockTextureName("tnt");
	}
	
	@Override
	public boolean onBlockActivated(World w, int x, int y, int z, EntityPlayer p, int i, float f, float f1, float f2) {
		Explosion e;
		w.spawnEntityInWorld(w,new Explosion(w, p, x, x, x, f2), x, y, z);
		return true;
		
	}

}
