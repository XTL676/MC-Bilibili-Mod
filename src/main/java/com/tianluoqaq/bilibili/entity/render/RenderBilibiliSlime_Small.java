package com.tianluoqaq.bilibili.entity.render;

import com.tianluoqaq.bilibili.entity.EntityBilibiliSlime_Small;
import com.tianluoqaq.bilibili.entity.model.ModelBilibiliSlime_Small;

import net.minecraft.client.renderer.entity.RenderManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

//��������Сʷ��ķ��Ⱦ��
public class RenderBilibiliSlime_Small extends GeoEntityRenderer<EntityBilibiliSlime_Small>
{
	public RenderBilibiliSlime_Small(RenderManager manager)
	{
		super(manager, new ModelBilibiliSlime_Small());
		this.shadowSize = 0.4f;// ��Ӱ�����ʵ������ı�����0.4fΪ0.4����
	}

}
