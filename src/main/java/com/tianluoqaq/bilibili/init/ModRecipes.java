package com.tianluoqaq.bilibili.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

//ģ���ڵ���¯�����䷽
public class ModRecipes
{

	// ItemStack(Items.DYE��Ⱦ���ࡿ, ����, ����ֵ��F3+H �����ͣ����Ʒ�Ϸ�����ʾ�ġ�#xxxx/x���ġ�/����������֡�)
	public static final ItemStack LAPIS_LAZULI = new ItemStack(Items.DYE, 1, 4);// ���ʯ

	public static void init()
	{

		/**
		 * ������Ʒ/�����Ʒ ��ʽ:
		 * 
		 * ԭ�淽��(vanilla blocks):	Blocks.������
		 * ԭ����Ʒ(vanilla blocks):	Items.��Ʒ��
		 * ģ�鷽��(mod blocks):	ModBlocks.������
		 * ģ����Ʒ(mod items):	ModItems.��Ʒ��
		 * 
		 * addSmelting(������Ʒ,new ItemStack(���Ƴ�����Ʒ,����),�õ�����ĸ��ʡ�1.0fΪ100%�õ����飬0.857fΪ85.7%�õ����顿)
		*/

		//����������*1 -> ����������Ƭ*6
		GameRegistry.addSmelting(ModBlocks.BILIBILI_BLOCK, new ItemStack(ModItems.bibox, 6), 0.857f);
		//���ʯ*1 -> ����������Ƭ*2
		GameRegistry.addSmelting(LAPIS_LAZULI, new ItemStack(ModItems.bibox, 2), 0.2233f);
	}

}
