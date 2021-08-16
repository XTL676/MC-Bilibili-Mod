package com.tianluoqaq.bilibili.entity.render;

import com.tianluoqaq.bilibili.entity.EntityBilibiliSlime;
import com.tianluoqaq.bilibili.entity.model.ModelBilibiliSlime;
import net.minecraft.client.renderer.entity.RenderManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

//BilibiliSlime��Ⱦ��
public class RenderBilibiliSlime extends GeoEntityRenderer<EntityBilibiliSlime>
{

	public RenderBilibiliSlime(RenderManager manager)
	{
		super(manager, new ModelBilibiliSlime());
		this.shadowSize = 0.5f;// ��Ӱ�����ʵ������ı�����0.5fΪ0.5����
	}

}
