package com.tianluoqaq.bilibili;

import com.tianluoqaq.bilibili.init.ModRecipes;
import com.tianluoqaq.bilibili.proxy.CommonProxy;
import com.tianluoqaq.bilibili.tabs.BlockTab;
import com.tianluoqaq.bilibili.tabs.ItemTab;
import com.tianluoqaq.bilibili.tabs.ToolTab;
import com.tianluoqaq.bilibili.util.Reference;
import com.tianluoqaq.bilibili.util.handlers.RegisteryHandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import software.bernie.geckolib3.GeckoLib;

//ģ������ں���
@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main
{

	//ʾ��
	@Instance
	public static Main instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
	public static CommonProxy proxy;

	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		RegisteryHandler.preInitRegistries();
	}

	@EventHandler
	public static void Init(FMLInitializationEvent event)
	{
		//Geckolib��ʼ��
		GeckoLib.initialize();
		
		//ģ���ڵ���¯�����䷽��ʼ��
		ModRecipes.init();
	}

	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{

	}

	// �½�����ģʽ��E����Ʒ���ı�ǩҳ
	public static final CreativeTabs BLOCK_TAB = new BlockTab();//����
	public static final CreativeTabs ITEM_TAB = new ItemTab();//��Ʒ
	public static final CreativeTabs TOOL_TAB = new ToolTab();//����

}
