package com.relt.toten.blocks;

import com.relt.toten.init.InitBlocks;
import com.relt.toten.init.InitItems;
import com.relt.toten.main.Main;
import com.relt.toten.utils.interfaces.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.Random;

public class DremidiyOre extends Block implements IHasModel {

	public DremidiyOre(String name, Material material) {
		super(material);
		
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(Main.BLOCK_TAB);
		setHardness(2F);
		setResistance(2F);
		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 3);
		
		
		
		InitBlocks.BLOCKS.add(this);
		InitItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
		
	}

	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
		
	}
}

