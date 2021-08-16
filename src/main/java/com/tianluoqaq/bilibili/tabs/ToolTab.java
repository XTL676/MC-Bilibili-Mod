package com.tianluoqaq.bilibili.tabs;

import com.tianluoqaq.bilibili.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

//�ڴ���ģʽ��E����Ʒ�������Ʒ��Tool Tab��(������)��ǩҳ
public class ToolTab extends CreativeTabs
{
	// ���췽��
	public ToolTab()
	{
		super("tool_tab");//��ǩ����
		this.setBackgroundImageName("bgi.png");//��ǩҳ����ͼƬ�����Զ����ļ���ǰ����ӡ�tab_��,���ļ���Ӧ������Ϊ��tab_����.png����
	}

	@Override
	// ��ǩҳ������ʾ��ͼ��
	public ItemStack getTabIconItem()
	{
		return new ItemStack(ModItems.BILIBILI_SWORD);
	}
}
