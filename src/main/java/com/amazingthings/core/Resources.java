package com.amazingthings.core;

import net.minecraft.util.ResourceLocation;

public class Resources {
	
	public static ResourceLocation getResource(ResourceType renderType, String pictureName) {
		switch(renderType){
		case RENDER:
			return new ResourceLocation("atcore", "textures/model/" + pictureName + ".png");
		case BLOCK:
			return new ResourceLocation("atcore", "textures/blocks/" + pictureName + ".png");
		case ITEM:
			return new ResourceLocation("atcore", "textures/items/" + pictureName + ".png");
		}
		return null;
	}

}
