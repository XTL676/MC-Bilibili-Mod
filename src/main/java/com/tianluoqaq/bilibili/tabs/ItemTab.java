package com.tianluoqaq.bilibili.tabs;

import com.tianluoqaq.bilibili.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

//�ڴ���ģʽ��E����Ʒ�������Ʒ��Item Tab��(��Ʒ��)��ǩҳ
public class ItemTab extends CreativeTabs
{

	// ���췽��
	public ItemTab()
	{

		super("item_tab");
		this.setBackgroundImageName("bgi.png");//��ǩҳ����ͼƬ�����Զ����ļ���ǰ����ӡ�tab_��,���ļ���Ӧ������Ϊ��tab_����.png����
	}

	@Override
	// ��ǩҳ������ʾ��ͼ��
	public ItemStack getTabIconItem()
	{

		return new ItemStack(ModItems.bibox);

	}

}