package com.tianluoqaq.bilibili.tabs;

import com.tianluoqaq.bilibili.init.ModBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

//�ڴ���ģʽ��E����Ʒ����ķ��顰Block Tab��(������)��ǩҳ
public class BlockTab extends CreativeTabs
{

	// ���췽��
	public BlockTab()
	{

		super("block_tab");
		this.setBackgroundImageName("bgi.png");//��ǩҳ����ͼƬ�����Զ����ļ���ǰ����ӡ�tab_��,���ļ���Ӧ������Ϊ��tab_����.png����
	}

	@Override
	// ��ǩҳ������ʾ��ͼ��
	public ItemStack getTabIconItem()
	{

		return new ItemStack(Item.getItemFromBlock(ModBlocks.BILIBILI_BLOCK));

	}

}
