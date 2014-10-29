package com.amazingthings.core.worldgen;

import java.util.Random;

import com.amazingthings.core.AmazingCore;
import com.amazingthings.core.blocks.Blocks;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGenOres implements IWorldGenerator{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case -1:
		    generateNether(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 0:
		    generateSurface(world, random, chunkX * 16, chunkZ * 16);
		    break;
		case 1:
		    generateEnd(world, random, chunkX * 16, chunkZ * 16);
		    break;
		}
	}

	private void generateNether(World world, Random random, int cX, int cZ) {
	}

	private void generateSurface(World world, Random rand, int cX, int cZ) {
		for(int k = 0; k < 10; k++) {
			int x = cX + rand.nextInt(16);
			int y = rand.nextInt(64);
			int z = cZ + rand.nextInt(16);
			
        	(new WorldGenMinable(Blocks.oreBauxite, 13)).generate(world, rand, x, y, z);

		}
	}

	private void generateEnd(World world, Random random, int cX, int cZ) {
	}

}
