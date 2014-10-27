package com.amazingthings.core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.amazingthings.core.blocks.Filter;
import com.amazingthings.core.blocks.OreBauxite;
import com.amazingthings.core.blocks.OreCopper;
import com.amazingthings.core.blocks.OreIlmenite;
import com.amazingthings.core.blocks.OreLead;
import com.amazingthings.core.blocks.OreSilver;
import com.amazingthings.core.blocks.OreTin;
import com.amazingthings.core.blocks.Vessel;
import com.amazingthings.core.itemblocks.ItemBlockFilter;
import com.amazingthings.core.items.IngotCopper;
import com.amazingthings.core.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = AmazingCore.modid, version = AmazingCore.version, name = AmazingCore.name)
public class AmazingCore {

	/**
	 * @author kristav
	 * 
	 * @author MathMods
	 */
	

	public static final String version = "1.0.0";
	public static final String name = "AmazingCore";
	public static final String modid = "atcore";
	
	public static Block oreCopper;
	public static Block oreTin;
	public static Block oreLead;
	public static Block oreBauxite;
	public static Block oreIlmenite;
	public static Block oreSilver;
	
	public static Block vessel;
	public static Block filter;
	
	public static Item ingotCopper;
	public static Item ingotTin;
	public static Item ingotLead;
	public static Item ingotBauxite;
	public static Item ingotIlmenite;
	public static Item ingotTitanium;
	public static Item ingotAluminium;
	public static Item ingotSilver;
	
	public static Item redmud;

	public static CreativeTabs tabCore = new CreativeTabs("tabCore") {
		
		@Override
		public Item getTabIconItem() {
			return ingotCopper;
		}
		
	};
	
	@Instance(value = modid)
	public static AmazingCore instance;
	
	@SidedProxy(clientSide="com.amazingthings.core.proxy.ClientProxy", serverSide="com.amazingthings.core.proxy.CommonProxy")
    public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		oreCopper = new OreCopper(Material.rock).setCreativeTab(tabCore).setHardness(1.8f);
		oreTin = new OreTin(Material.rock).setCreativeTab(tabCore).setHardness(1.5f);
		oreLead = new OreLead(Material.rock).setCreativeTab(tabCore).setHardness(2.5f);
		oreBauxite = new OreBauxite(Material.rock).setCreativeTab(tabCore).setHardness(1.3f);
		oreIlmenite = new OreIlmenite(Material.rock).setCreativeTab(tabCore).setHardness(3.0f);
		oreSilver = new OreSilver(Material.rock).setCreativeTab(tabCore).setHardness(2.5f);		
		
		oreCopper.setHarvestLevel("pickaxe", 1);
		oreTin.setHarvestLevel("pickaxe", 1);
		oreLead.setHarvestLevel("pickaxe", 2);
		oreBauxite.setHarvestLevel("pickaxe", 2);
		oreIlmenite.setHarvestLevel("pickaxe", 3);
		oreSilver.setHarvestLevel("pickaxe", 3);
		
		vessel = new Vessel(Material.clay).setCreativeTab(tabCore).setHardness(3.0f);
		filter = new Filter().setCreativeTab(tabCore).setHardness(3.0F);
		
		//GameRegistry.registerBlock(vessel, "vessel");
		//GameRegistry.registerBlock(filter, "filter");
		// ^^^ DO NOT REGISTER MODELS LIKE THIS ^^^
		GameRegistry.registerBlock(vessel, ItemBlockFilter.class, "vessel");
		GameRegistry.registerBlock(filter, ItemBlockFilter.class, "filter");
		// ^^^ REGISTER MODELS LIKE THIS ^^^
		
		ingotCopper = new IngotCopper();
		
		GameRegistry.registerItem(ingotCopper, "ingotCopper");
		
		Recipes.registerRecipes();
		Recipes.registerCustomMachineRecipes();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.registerRenderThings();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
