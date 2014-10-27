package com.amazingthings.core.worldgen;

import java.util.Random;

import com.amazingthings.core.AmazingCore;

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

	private void generateNether(World world, Random random, int i, int j) {
	}

	private void generateSurface(World world, Random random, int i, int j) {
		
		int x = random.nextInt(16) + i;
		int z = random.nextInt(16) + j;
		int y = 40 + random.nextInt(256-40);
		
		(new WorldGenMinable(AmazingCore.oreBauxite, 13)).generate(world, random, x, y, z);
	}

	private void generateEnd(World world, Random random, int i, int j) {
	}

}
