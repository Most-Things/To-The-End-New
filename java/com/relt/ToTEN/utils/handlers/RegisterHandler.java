package com.relt.toten.utils.handlers;

import com.relt.toten.init.InitBlocks;
import com.relt.toten.init.InitItems;
import com.relt.toten.utils.FurnaceRecipes;
import com.relt.toten.utils.interfaces.IHasModel;
import com.relt.toten.world.generate.WorldGenOreGenerator;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@EventBusSubscriber
public class RegisterHandler {
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event){
		event.getRegistry().registerAll(InitItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event){
		event.getRegistry().registerAll(InitBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	public static void init(){
		GameRegistry.registerWorldGenerator(new WorldGenOreGenerator(), 0);
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event){
		for(Item item : InitItems.ITEMS){
			if(item instanceof IHasModel){
				((IHasModel)item).registerModels();
			}
		}
		for(Block block : InitBlocks.BLOCKS){
			if(block instanceof IHasModel){
				((IHasModel)block).registerModels();
			}
		}
	}

	public static void otherRegister(){
		FurnaceRecipes.registerRecipes();
	}

}
