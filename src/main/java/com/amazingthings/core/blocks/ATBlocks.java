package com.amazingthings.core.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.amazingthings.core.AmazingCore;
import com.amazingthings.core.itemblocks.ItemBlockModel;

import cpw.mods.fml.common.registry.GameRegistry;

public class ATBlocks {

	public static Block oreCopper;
	public static Block oreTin;
	public static Block oreLead;
	public static Block oreBauxite;
	public static Block oreIlmenite;
	public static Block oreSilver;
	public static Block ULTRAHYPERAMAZING;

	public static Block vessel;
	public static Block filter;
	
	public static void registerBlocks(){
		oreCopper = new OreCopper(Material.rock).setCreativeTab(AmazingCore.tabCore).setHardness(1.8f);
		oreTin = new OreTin(Material.rock).setCreativeTab(AmazingCore.tabCore).setHardness(1.5f);
		oreLead = new OreLead(Material.rock).setCreativeTab(AmazingCore.tabCore).setHardness(2.5f);
		oreBauxite = new OreBauxite(Material.rock).setCreativeTab(AmazingCore.tabCore).setHardness(1.3f);
		oreIlmenite = new OreIlmenite(Material.rock).setCreativeTab(AmazingCore.tabCore).setHardness(3.0f);
		oreSilver = new OreSilver(Material.rock).setCreativeTab(AmazingCore.tabCore).setHardness(2.5f);		

		ULTRAHYPERAMAZING = new UHA(Material.cake).setCreativeTab(AmazingCore.tabCore).setHardmess(1.0f);
		
		oreCopper.setHarvestLevel("pickaxe", 1);
		oreTin.setHarvestLevel("pickaxe", 1);
		oreLead.setHarvestLevel("pickaxe", 2);
		oreBauxite.setHarvestLevel("pickaxe", 2);
		oreIlmenite.setHarvestLevel("pickaxe", 3);
		oreSilver.setHarvestLevel("pickaxe", 3);

		vessel = new Vessel(Material.clay).setCreativeTab(AmazingCore.tabCore).setHardness(3.0f);
		filter = new Filter().setCreativeTab(AmazingCore.tabCore).setHardness(3.0F);
		
		GameRegistry.registerBlock(oreCopper, "oreCopper");
		GameRegistry.registerBlock(oreTin, "oreTin");
		GameRegistry.registerBlock(oreLead, "oreLead");
		GameRegistry.registerBlock(oreBauxite, "oreBauxite");
		GameRegistry.registerBlock(oreIlmenite, "oreIlmenite");
		GameRegistry.registerBlock(oreSilver, "oreSilver");
	}
	
	public static void registerModelBlocks(){
		GameRegistry.registerBlock(vessel, ItemBlockModel.class, "vessel");
		GameRegistry.registerBlock(filter, ItemBlockModel.class, "filter");
	}
	
}
