package com.tianluoqaq.bilibili.items;

import com.tianluoqaq.bilibili.Main;
import com.tianluoqaq.bilibili.init.ModItems;
import com.tianluoqaq.bilibili.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

//����ģ������Ʒ�ĸ���
public class ItemBase extends Item implements IHasModel
{

	public ItemBase(String name, CreativeTabs tab)
	{

		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);

		ModItems.ITEMS.add(this);

	}

	@Override
	public void registerModels()
	{
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}

}
