package com.amazingthings.core.recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.amazingthings.core.blocks.ATBlocks;
import com.amazingthings.core.items.ATItems;

public class VesselRecipes {
    private static final VesselRecipes smeltingBase = new VesselRecipes();
    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map degreesList = new HashMap();
    private static final String __OBFID = "CL_00000085";

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static VesselRecipes smelting()
    {
        return smeltingBase;
    }

    private VesselRecipes()
    {
    	//add?toList(input, itemstackOutput, degrees heat)
        addBlocktoList(ATBlocks.oreBauxite, new ItemStack(ATItems.ingotAluminium), 175);
    }

    public void addBlocktoList(Block inputBlock, ItemStack outputstack, int degrees)
    {
        this.addItemtoList(Item.getItemFromBlock(inputBlock), outputstack, degrees);
    }

    public void addItemtoList(Item inputItem, ItemStack outputstack, int degrees)
    {
        this.addItemStacktoList(new ItemStack(inputItem, 1, 32767), outputstack, degrees);
    }

    public void addItemStacktoList(ItemStack inputstack, ItemStack outputstack, int degrees)
    {
        this.smeltingList.put(inputstack, outputstack);
        this.degreesList.put(inputstack, Integer.valueOf(degrees));
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack stack)
    {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.checkIsTheSame(stack, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }
    
    public int getDegreesNeeded(ItemStack stack){
    	Iterator iterator = this.degreesList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return -1;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.checkIsTheSame(stack, (ItemStack)entry.getKey()));

        return ((Integer)entry.getValue()).intValue();
    }

    private boolean checkIsTheSame(ItemStack checking, ItemStack entry)
    {
        return entry.getItem() == checking.getItem() && (entry.getItemDamage() == 32767 || entry.getItemDamage() == checking.getItemDamage());
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }
    
    public Map getDegreesList(){
    	return this.degreesList;
    }
	
}
