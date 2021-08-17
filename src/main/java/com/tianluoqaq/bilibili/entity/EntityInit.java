package com.tianluoqaq.bilibili.entity;

import com.tianluoqaq.bilibili.Main;
import com.tianluoqaq.bilibili.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit
{
	// ����ע��ʵ�巽��,ע��ʵ��
	public static void registerEntities()
	{
		registerEntity("bilibili_slime", EntityBilibiliSlime.class, Reference.ENTITY_BILIBILI_SLIME, 50, 2272740, 0);
		registerEntity("bilibili_slime_small", EntityBilibiliSlime_Small.class, Reference.ENTITY_BILIBILI_SLIME_SMALL,
				80, 2272740, 0);
		registerEntity("bilibili_slime_big", EntityBilibiliSlime_Big.class, Reference.ENTITY_BILIBILI_SLIME_BIG,
				65, 2272740, 0);
	}

	// ע��ʵ�巽��
	public static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int primaryColor,
			int secondaryColor)
	{
		/**
		 * registerModEntity(
		 * new ResourceLocation(Reference.MOD_ID + ":" + name��ʵ��������Դλ�ã���ʽΪ:ģ��ID����:ʵ�����ơ�),
		 * ʵ���ࡾClass<? extends Entity>��, ʵ������, ʵ��ID, 
		 * �����ڵ�ģ�顾��������,Main.instance��, ʵ�巢��������ķ�Χ, ���ٸ��µ�Ƶ��, �Ƿ����ٶ���Ϣ��, 
		 * ��ʵ��ˢ�ֵ��ĵ�ɫ��ʮ��������ɫ�Ĵ����ֱ�ʾ��ʹ����վhttps://www.mathsisfun.com/hexadecimal-decimal-colors.html��
		 * ����#xxxxxx�����롰Color Mixer���ġ�Hexadecimal���У��ٽ�����ġ�Decimal�������ָ���������, ��ʵ��ˢ�ֵ��Ĵ�Ҫ��ɫ);
		*/
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id,
				Main.instance, range, 1, true, primaryColor, secondaryColor);
	}
}
