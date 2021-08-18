package com.tianluoqaq.bilibili.entity;

import com.tianluoqaq.bilibili.Main;
import com.tianluoqaq.bilibili.util.Reference;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit
{
	// ����ע��ʵ�巽��,ע��ʵ��
	public static void registerEntities()
	{
		// TODO ��Ȼ����ʵ��
		// ��������ʷ��ķϵ��,��Ȼ������:ѩɽ,ƽԭ,ɭ��,Ģ��������
		registerEntity("bilibili_slime", EntityBilibiliSlime.class, Reference.ENTITY_BILIBILI_SLIME, 50, 2272740, 0,
				100, 4, 4, EnumCreatureType.MONSTER, Biomes.ICE_MOUNTAINS, Biomes.PLAINS, Biomes.FOREST,
				Biomes.MUSHROOM_ISLAND_SHORE);

		registerEntity("bilibili_slime_small", EntityBilibiliSlime_Small.class, Reference.ENTITY_BILIBILI_SLIME_SMALL,
				55, 2272740, 0, 100, 4, 4, EnumCreatureType.MONSTER, Biomes.ICE_MOUNTAINS, Biomes.PLAINS, Biomes.FOREST,
				Biomes.MUSHROOM_ISLAND_SHORE);

		registerEntity("bilibili_slime_big", EntityBilibiliSlime_Big.class, Reference.ENTITY_BILIBILI_SLIME_BIG, 53,
				2272740, 0, 100, 4, 4, EnumCreatureType.MONSTER, Biomes.ICE_MOUNTAINS, Biomes.PLAINS, Biomes.FOREST,
				Biomes.MUSHROOM_ISLAND_SHORE);
	}

	/**
	 * ע��ʵ�巽��
	 * 
	 * @param name				ʵ������
	 * @param entity			ʵ�����͡�xxxxx.class��
	 * @param id				ʵ��ID��Reference.xxxxx��
	 * @param range				ʵ����Է�����ҵ����ķ�Χ
	 * 							��ʵ��ˢ�ֵ��ĵ�ɫ��ʮ��������ɫ�Ĵ����ֱ�ʾ��
	 * @param primaryColor		ʹ����վhttps://www.mathsisfun.com/hexadecimal-decimal-colors.html,
	 * 							����#xxxxxx�����롰Color Mixer���ġ�Hexadecimal���У��ٽ�����ġ�Decimal�������ָ���������
	 * @param secondaryColor	��ʵ��ˢ�ֵ��Ĵ�Ҫ��ɫ���൱�ڵ�����İߵ����ɫ��
	 * @param weightedProb		��Ȩ����
	 * @param minSpawnCount		��С��������
	 * @param maxSpawnCount		�����������
	 * @param spawnType			��������,��
	 * EnumCreatureType.MONSTER ������	EnumCreatureType.CREATURE ������
	 * EnumCreatureType.AMBIENT ����������	EnumCreatureType.WATER_CREATURE	ˮ��������
	 * 
	 * @param biomes			����Ⱥϵ��Biomes.xx,Biomes.xx,...,Biomes.xx��,
	 * 							�����������ȺϵID.txt����
	 */
	public static void registerEntity(String name, Class<? extends EntityLiving> entity, int id, int range,
			int primaryColor, int secondaryColor, int weightedProb, int minSpawnCount, int maxSpawnCount,
			EnumCreatureType spawnType, Biome... biomes)
	{
		/**
		 * registerModEntity(
		 * new ResourceLocation(Reference.MOD_ID + ":" + name��ʵ��������Դλ�ã���ʽΪ:ģ��ID����:ʵ�����ơ�),
		 * ʵ���ࡾClass<? extends Entity>��, ʵ������, ʵ��ID, 
		 * �����ڵ�ģ�顾��������,Main.instance��, ʵ�巢��������ķ�Χ, ���ٸ��µ�Ƶ��, �Ƿ����ٶ���Ϣ��, 
		 * ��ʵ��ˢ�ֵ��ĵ�ɫ, ��ʵ��ˢ�ֵ��Ĵ�Ҫ��ɫ);
		*/
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id,
				Main.instance, range, 1, true, primaryColor, secondaryColor);

		EntityRegistry.addSpawn(entity, weightedProb, minSpawnCount, maxSpawnCount, spawnType, biomes);
	}
}
