package com.tianluoqaq.bilibili.items.food;

import com.tianluoqaq.bilibili.Main;
import com.tianluoqaq.bilibili.init.ModItems;
import com.tianluoqaq.bilibili.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

//ģ����ʳ�����
public class FoodBase extends ItemFood implements IHasModel
{

	/**
	 * @param name			ʳ������
	 * @param amount		�ܲ���ı�ʳ��(1 = 1������)
	 * @param saturation	�ܲ���ı��Ͷ�
	 * @param isWolfFood	�Ƿ���ι����(ѱ����ʵ��)��
	 * @param tab			����ģʽ��ǩ
	 */
	public FoodBase(String name, int amount, float saturation, boolean isWolfFood, CreativeTabs tab)
	{
		super(amount, saturation, isWolfFood);
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
