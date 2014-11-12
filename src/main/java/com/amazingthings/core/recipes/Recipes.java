package com.amazingthings.core.recipes;

import com.amazingthings.core.blocks.ATBlocks;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void registerRecipes(){
		GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(ATBlocks.vessel)), new Object[]{
			" x ", "x x", "xxx", 'x', Items.brick
		});
	}
	
	public static void registerCustomMachineRecipes(){
		
	}

}
