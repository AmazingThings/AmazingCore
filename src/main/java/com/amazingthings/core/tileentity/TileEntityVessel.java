package com.amazingthings.core.tileentity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import com.amazingthings.core.recipes.VesselRecipes;

public class TileEntityVessel extends TileEntity {

	public int amount;
	public int burnTime;
	public int fuelTime;
	public int degreesCelcius;
	public Item Smelting;

	public TileEntityVessel() {

	}

	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);

		NBTTagList nbttaglist = tag.getTagList("Item", 1);
		
		NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(1);
        int j = nbttagcompound1.getByte("Slot") & 255;
        
        if(j == 1){
        	Smelting = ItemStack.loadItemStackFromNBT(nbttagcompound1).getItem();
        }
		nbttaglist = tag.getTagList("Item", 1);
        
		amount = tag.getInteger("amount");
		burnTime = tag.getInteger("burnTime");
		fuelTime = tag.getInteger("fuelTime");
		degreesCelcius = tag.getInteger("degreesCelcius");
		this.markDirty();
		//TODO: NEEDS FIX
	}

	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);

		NBTTagList nbttaglist = new NBTTagList();
		
		if (this.Smelting != null)
        {
            NBTTagCompound nbttagcompound1 = new NBTTagCompound();
            nbttagcompound1.setByte("Slot", (byte)1);
            new ItemStack(Smelting).writeToNBT(nbttagcompound1);
            nbttaglist.appendTag(nbttagcompound1);
        }
		
		tag.setTag("Item", nbttaglist);
		
		tag.setInteger("amount", amount);
		tag.setInteger("burnTime", burnTime);
		tag.setInteger("fuelTime", fuelTime);
		tag.setInteger("degreesCelcius", degreesCelcius);
		//TODO: NEEDS FIX
	}

	public void updateEntity() {
		boolean isBurning = fuelTime > 0;
		boolean sendUpdate = false;
		degreesCelcius = getRequiredDegrees(); //TODO: Remove this and replace with when using fuel degreesCelcius++; at random?

		if(fuelTime > 0) {
			fuelTime--;
			sendUpdate = true;
		}
		if(!worldObj.isRemote) {
			if(fuelTime == 0 && this.canSmelt()) {
				if(fuelTime > 0) {
					sendUpdate = true;
					
				}
			}
		}
		if(degreesCelcius >= getRequiredDegrees() && canSmelt()) {
			burnTime++;

			if(burnTime == 200) {
				burnTime = 0;
				smeltItems(getSmeltingResult().getItem(), getSmeltingResult().stackSize);
				
			}
			if(sendUpdate) {
				this.markDirty();
			}
		} 
		//if(!canSmelt() && amount > 0)smeltItem(Smelting);
		
	}

	private void smeltItem(Item output) {
		boolean jobDone = false;
		
		IInventory invUp = (IInventory)worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
		IInventory invDown = (IInventory)worldObj.getTileEntity(xCoord, yCoord-1, zCoord);
		IInventory invFront = (IInventory)worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
		IInventory invBack = (IInventory)worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
		IInventory invRigth = (IInventory)worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
		IInventory invLeft = (IInventory)worldObj.getTileEntity(xCoord-1, yCoord, zCoord);

		IInventory inv = null;

		for(int i = 0; i < 1; i++){
			if(invUp != null){
				inv = invUp;
				break;
			}
			if(invDown != null){
				inv = invDown;
				break;
			}
			if(invFront != null){
				inv = invFront;
				break;
			}
			if(invBack != null){
				inv = invBack;
				break;
			}
			if(invRigth != null){
				inv = invRigth;
				break;
			}
			if(invLeft != null){
				inv = invLeft;
				break;
			}
		}
		
		if(inv == null){
			
			EntityItem item = new EntityItem(worldObj, xCoord, yCoord + 0.5F, zCoord, new ItemStack(output));
			item.lifespan = 1200;
			item.delayBeforeCanPickup = 10;
			
			float f3 = 0.05f;
			item.motionX = (float) worldObj.rand.nextGaussian() * f3;
			item.motionY = (float) worldObj.rand.nextGaussian() * f3 + 1.0f;
			item.motionZ = (float) worldObj.rand.nextGaussian() * f3;
	
		
			worldObj.spawnEntityInWorld(item);
			
			jobDone = true;
			
		}else{
			for(int i = 0; i < inv.getSizeInventory(); i++){
				if(inv.isItemValidForSlot(i, new ItemStack(output))){
					if(inv.getStackInSlot(i) == null || inv.getStackInSlot(i).getItem() == output && inv.getStackInSlot(i).stackSize + 1 <= inv.getInventoryStackLimit()){
						inv.setInventorySlotContents(i, new ItemStack(output, inv.getStackInSlot(i) != null ? inv.getStackInSlot(i).stackSize + 1 : 1));
						jobDone=true;
						break;
					}
				}
			}
		}
		
		if(!jobDone){
			EntityItem item = new EntityItem(worldObj, xCoord, yCoord + 0.5F, zCoord, new ItemStack(output));
			item.lifespan = 1200;
			item.delayBeforeCanPickup = 10;
			
			float f3 = 0.05f;
			item.motionX = (float) worldObj.rand.nextGaussian() * f3;
			item.motionY = (float) worldObj.rand.nextGaussian() * f3 + 1.0f;
			item.motionZ = (float) worldObj.rand.nextGaussian() * f3;
	
		
			worldObj.spawnEntityInWorld(item);
			amount--;
			if(amount == 0){
				Smelting = null;
			}
		}else{
			amount--;
			if(amount == 0){
				Smelting = null;
			}
		}

	}
	
	private void smeltItems(Item output, int amount) {
		boolean jobDone = false;
		
		IInventory invUp = (IInventory)worldObj.getTileEntity(xCoord, yCoord+1, zCoord);
		IInventory invDown = (IInventory)worldObj.getTileEntity(xCoord, yCoord-1, zCoord);
		IInventory invFront = (IInventory)worldObj.getTileEntity(xCoord, yCoord, zCoord+1);
		IInventory invBack = (IInventory)worldObj.getTileEntity(xCoord, yCoord, zCoord-1);
		IInventory invRigth = (IInventory)worldObj.getTileEntity(xCoord+1, yCoord, zCoord);
		IInventory invLeft = (IInventory)worldObj.getTileEntity(xCoord-1, yCoord, zCoord);

		IInventory inv = null;

		for(int i = 0; i < 1; i++){
			if(invUp != null){
				inv = invUp;
				break;
			}
			if(invDown != null){
				inv = invDown;
				break;
			}
			if(invFront != null){
				inv = invFront;
				break;
			}
			if(invBack != null){
				inv = invBack;
				break;
			}
			if(invRigth != null){
				inv = invRigth;
				break;
			}
			if(invLeft != null){
				inv = invLeft;
				break;
			}
		}
		
		if(inv == null){
			EntityItem item = new EntityItem(worldObj, xCoord, yCoord + 0.5F, zCoord, new ItemStack(output));
			item.lifespan = 1200;
			item.delayBeforeCanPickup = 10;
			
			float f3 = 0.05f;
			item.motionX = (float) worldObj.rand.nextGaussian() * f3;
			item.motionY = (float) worldObj.rand.nextGaussian() * f3 + 1.0f;
			item.motionZ = (float) worldObj.rand.nextGaussian() * f3;
	
		
			worldObj.spawnEntityInWorld(item);
			jobDone = true;
		}else{
			for(int i = 0; i < inv.getSizeInventory(); i++){
				if(inv.isItemValidForSlot(i, new ItemStack(output))){
					if(inv.getStackInSlot(i) == null || inv.getStackInSlot(i).getItem() == output && inv.getStackInSlot(i).stackSize + amount <= inv.getInventoryStackLimit()){
						inv.setInventorySlotContents(i, new ItemStack(output, inv.getStackInSlot(i) != null ? inv.getStackInSlot(i).stackSize + amount : amount));
						jobDone=true;
						break;
					}
				}
			}
		}
		
		if(!jobDone){
			EntityItem item = new EntityItem(worldObj, xCoord, yCoord + 0.5F, zCoord, new ItemStack(output));
			item.lifespan = 1200;
			item.delayBeforeCanPickup = 10;
			
			float f3 = 0.05f;
			item.motionX = (float) worldObj.rand.nextGaussian() * f3;
			item.motionY = (float) worldObj.rand.nextGaussian() * f3 + 1.0f;
			item.motionZ = (float) worldObj.rand.nextGaussian() * f3;
	
		
			worldObj.spawnEntityInWorld(item);
			this.amount--;
			if(this.amount == 0){
				Smelting = null;
			}
		}else{
			this.amount--;
			if(this.amount == 0){
				Smelting = null;
			}
		}
	}

	public boolean canSmelt() {
		if(amount > 0 ) {
			if(VesselRecipes.smelting().getSmeltingResult(new ItemStack(Smelting)) != null)return true;
		}
		return false;
	}
	
	public ItemStack getSmeltingResult(){
		return VesselRecipes.smelting().getSmeltingResult(new ItemStack(Smelting));
	}
	public int getRequiredDegrees(){
		return VesselRecipes.smelting().getDegreesNeeded(new ItemStack(Smelting));
	}
	
	public int getCurrentDegrees() {
		return this.degreesCelcius;
	}
	
	public void addDegrees(int amount) {
		this.degreesCelcius = this.degreesCelcius + amount;
	}
	
	public void setDegrees(int amount) {
		this.degreesCelcius = amount;
	}
}
