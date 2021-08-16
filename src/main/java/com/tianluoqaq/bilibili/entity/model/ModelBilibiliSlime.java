package com.tianluoqaq.bilibili.entity.model;

import com.tianluoqaq.bilibili.entity.EntityBilibiliSlime;
import com.tianluoqaq.bilibili.util.Reference;

import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

//BilibiliSlimeģ����(��Geckolib���д���)
public class ModelBilibiliSlime extends AnimatedGeoModel<EntityBilibiliSlime>
{
	@Override
	public ResourceLocation getModelLocation(EntityBilibiliSlime object)
	{
		//����ģ��json�ļ�λ��
		return new ResourceLocation(Reference.MOD_ID, "geo/modelbilibilislime.geo.json");
	}

	@Override
	public ResourceLocation getTextureLocation(EntityBilibiliSlime object)
	{
		//����ģ����ͼpng�ļ�λ��
		return new ResourceLocation(Reference.MOD_ID, "textures/entity/bilibili_slime.png");
	}

	@Override
	public ResourceLocation getAnimationFileLocation(EntityBilibiliSlime object)
	{
		//����ģ�Ͷ���json�ļ�λ��
		return new ResourceLocation(Reference.MOD_ID, "animations/modelbilibilislime.animation.json");
	}
}