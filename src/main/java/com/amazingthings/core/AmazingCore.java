package com.amazingthings.core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.amazingthings.core.blocks.*;
import com.amazingthings.core.itemblocks.*;
import com.amazingthings.core.items.*;
import com.amazingthings.core.proxy.CommonProxy;
import com.amazingthings.core.worldgen.*;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import static com.amazingthings.core.blocks.Blocks.*;
import static com.amazingthings.core.items.Items.*;

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

	public static CreativeTabs tabCore = new CreativeTabs("tabCore") {

		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(vessel);
		}

	};

	@Instance(value = modid)
	public static AmazingCore instance;

	@SidedProxy(clientSide="com.amazingthings.core.proxy.ClientProxy", serverSide="com.amazingthings.core.proxy.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
							   //MAY BE REPLACED WITH:
		Blocks.registerBlocks();      //Blocks.registerBlocks();
		Items.registerItems();       //Items.registerItems();
		Blocks.registerModelBlocks(); //Blocks.registerModelBlocks
		Recipes.registerRecipes();
		Recipes.registerCustomMachineRecipes();
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.registerRenderThings();
		GameRegistry.registerWorldGenerator(new WorldGenOres(), 0);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {

	}
}
