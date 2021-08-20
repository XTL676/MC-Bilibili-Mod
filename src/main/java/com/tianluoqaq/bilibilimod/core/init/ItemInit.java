package com.tianluoqaq.bilibilimod.core.init;

import com.tianluoqaq.bilibilimod.core.itemgroup.BItemGroup;
import com.tianluoqaq.bilibilimod.core.util.Reference;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//ģ������Ʒʵ�����Լ���ʼ�����ࡾ������Ʒ���ࡿ
public class ItemInit
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Reference.MOD_ID);

	/******************************************Items(��Ʒ)******************************************************************/

	/**
	 * ������Ʒ
	 * 
	 * ITEMS.register("��Ʒ��ʶ��",
			() -> new Item(new Item.Properties().tab(ItemGroup.����ģʽ����Ʒ���ڸ���Ʒ���ڵı�ǩҳ)));
	 */
	public static final RegistryObject<Item> BIBOX = ITEMS.register("bibox", // ����������Ƭ
			() -> new Item(new Item.Properties().tab(BItemGroup.BItemTab)));

	public static final RegistryObject<Item> B_DIAMOND = ITEMS.register("b_diamond", // ����������
			() -> new Item(new Item.Properties().tab(BItemGroup.BItemTab)));
}
