package com.tianluoqaq.bilibili.util.handlers;

import com.tianluoqaq.bilibili.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

//ս��Ʒ����
public class LootTableHandler
{
	//����ս��Ʒ��������Դλ��(loot_tables/xxxx.json),һ���������ע����
	//ע��:��Ҫ��json�ļ�����ϡ�"name":"�����������",����һ������,ʵ���������������Ʒ
	public static final ResourceLocation BILIBILI_SLIME = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "bilibili_slime"));
}
