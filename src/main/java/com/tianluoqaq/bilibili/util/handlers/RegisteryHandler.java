package com.tianluoqaq.bilibili.util.handlers;

import com.tianluoqaq.bilibili.entity.EntityInit;
import com.tianluoqaq.bilibili.init.ModBlocks;
import com.tianluoqaq.bilibili.init.ModItems;
import com.tianluoqaq.bilibili.util.IHasModel;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//ע����
@EventBusSubscriber
public class RegisteryHandler
{

	@SubscribeEvent
	// ע����Ʒ
	public static void onItemRegistry(RegistryEvent.Register<Item> event)
	{

		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));

	}

	@SubscribeEvent
	// ע�᷽��
	public static void onBlockRegistry(RegistryEvent.Register<Block> event)
	{

		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));

	}

	@SubscribeEvent
	// ע��ģ��
	public static void onModelRegistry(ModelRegistryEvent event)
	{

		// ע����Ʒģ��
		for (Item item : ModItems.ITEMS)
		{
			if (item instanceof IHasModel)
			{
				((IHasModel) item).registerModels();
			}
		}

		// ע�᷽��ģ��
		for (Block block : ModBlocks.BLOCKS)
		{
			if (block instanceof IHasModel)
			{
				((IHasModel) block).registerModels();
			}
		}

	}
	
	public static void preInitRegistries()
	{
		EntityInit.registerEntities();//���÷�����ע��ʵ��
		RenderHandler.RegisterEntityRenders();//���÷�����ע����Ⱦ��bilibili_slime��ʵ��
	}
	
	public static void postInitRegistries()
	{
		
	}

}
