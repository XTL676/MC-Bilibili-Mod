package com.tianluoqaq.bilibili.entity.render;

import com.tianluoqaq.bilibili.entity.EntityBilibiliSlime_Big;
import com.tianluoqaq.bilibili.entity.model.ModelBilibiliSlime_Big;

import net.minecraft.client.renderer.entity.RenderManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

//BilibiliSlime_Big��Ⱦ��
public class RenderBilibiliSlime_Big extends GeoEntityRenderer<EntityBilibiliSlime_Big>
{
	public RenderBilibiliSlime_Big(RenderManager manager)
	{
		super(manager, new ModelBilibiliSlime_Big());
		this.shadowSize = 0.6f;// ��Ӱ�����ʵ������ı�����0.6fΪ0.6����
	}
}
