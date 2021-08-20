package com.tianluoqaq.bilibilimod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tianluoqaq.bilibilimod.core.init.BlockInit;
import com.tianluoqaq.bilibilimod.core.init.FeatureInit;
import com.tianluoqaq.bilibilimod.core.init.ItemInit;
import com.tianluoqaq.bilibilimod.core.itemgroup.BItemGroup;
import com.tianluoqaq.bilibilimod.core.util.Reference;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

//ģ����ں���,���Լ���ģ��,����������ģ��Ľ���
@Mod("bilibilimod")
@Mod.EventBusSubscriber(modid = Reference.MOD_ID, bus = Bus.MOD)
public class BilibiliMod
{
	public static final Logger LOGGER = LogManager.getLogger();

	public BilibiliMod()
	{
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

		ItemInit.ITEMS.register(bus);// ע�ᡰItemInit���������ж������Ʒ
		BlockInit.BLOCKS.register(bus);// ע�ᡰBlockInit���������ж���ķ���

		// ������ӿ�ʯ��addOres������
		MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, FeatureInit::addOres);
		MinecraftForge.EVENT_BUS.register(this);
	}

	// ע����Ʒ
	@SubscribeEvent
	public static void OnRegisterItem(final RegistryEvent.Register<Item> event)
	{
		// ע�᷽��
		BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block ->
		{
			// ע�᷽�鵽������������Ʒ����ǩҳ
			event.getRegistry().register(new BlockItem(block, new Item.Properties().tab(BItemGroup.BItemTab))
					.setRegistryName(block.getRegistryName()));
		});
	}
}
