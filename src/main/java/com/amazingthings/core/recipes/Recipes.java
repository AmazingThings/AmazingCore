package com.amazingthings.core.recipes;

import com.amazingthings.core.blocks.Blocks;
import com.amazingthings.core.items.Items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {
	
	public static void registerRecipes(){
		GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(Blocks.vessel)), new Object[]{
			" x ", "x x", "xxx", 'x', Items.ingotCopper
		});
	}
	
	public static void registerCustomMachineRecipes(){
		
	}

}