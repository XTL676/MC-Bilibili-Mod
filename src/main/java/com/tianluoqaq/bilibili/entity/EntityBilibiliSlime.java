package com.tianluoqaq.bilibili.entity;

import com.tianluoqaq.bilibili.util.handlers.LootTableHandler;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

//BilibiliSlimeʵ���࣬�̳���Slime��
public class EntityBilibiliSlime extends EntitySlime implements IAnimatable
{
	private AnimationFactory factory = new AnimationFactory(this);

	// ���췽��
	public EntityBilibiliSlime(World worldIn)
	{
		super(worldIn);
		this.ignoreFrustumCheck = true;
	}

	// �޸���������ʷ��ķ�ĵ�������Ч��Ϊ��ɫˮ������
	@Override
	protected EnumParticleTypes getParticleType()
	{
		return EnumParticleTypes.WATER_DROP;
	}

	// �޸���������ʷ��ķ��ɱ������ѳ���������ʷ��ķ�������Ƿ��ѳ�ԭ��ʷ��ķ
	@Override
	protected EntityBilibiliSlime createInstance()
	{
		return new EntityBilibiliSlime(this.world);
	}

	//����ս��Ʒ�����Դλ��(�Զ���ս��Ʒ����)
	@Override
	protected ResourceLocation getLootTable()
	{
		return LootTableHandler.BILIBILI_SLIME;
	}
	
	// TODO ��������ʷ��ķ����
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
	{
		if (!this.isSmallSlime() && this.onGround)// ������С��������ʷ��ķ��ʵ���ڵ����ϵ�ʱ��,ѭ������idle(�ȴ�)����
		{
			event.getController()
					.setAnimation(new AnimationBuilder().addAnimation("animation.ModelBilibiliSlime.idle", true));

			/**
			*	�����ϣ���������������ŵ�ǰ����,����ϣ����ֹͣ,�뷵��:
			*	PlayState.CONTINUE	�������ŵ�ǰ����
			*	PlayState.STOP		ֹͣ���ŵ�ǰ����
			*/
			return PlayState.CONTINUE;
		} else
		{// ��ʵ�崦������״̬ʱ,ѭ������antshake(ҡ������)����
			event.getController()
					.setAnimation(new AnimationBuilder().addAnimation("animation.ModelBilibiliSlime.antshake", true));

			return PlayState.CONTINUE;
		}

	}

	// ע�����п������Լ�������
	@Override
	public void registerControllers(AnimationData data)
	{
		/**
		*	addAnimationController()	������������ע�ᵽ�������ݶ���
		*
		*	AnimationController()		�����������Ǳڻ����ƶ����ĺ���,ÿ������������һ�β���һ������.Ҫͬʱ���Ŷ������,ֻ�贴����ע������������.
		*	ͨ��AnimationController.getAnimationState()�˽����������ʲô״̬,����ô����״̬:
		*	����	��ʾ���������ڻ������Ŷ���
		*	����	���������ڴ�ֹͣ�����л��һ���������ɵ���һ������
		*	ֹͣ	������û���������ж�����Ҫô��ȫ��ֹ��Ҫô�ص�ģ�͵�ԭʼ״̬��
		*	
		*	EntityBilibiliSlime animatable	Ҫ���Ƶ�ʵ����
		*	String name						����������������
		*	float transitionLengthTicks		��������ʱ��(֡)
		*	IAnimationPredicate<EntityBilibiliSlime> animationPredicate	�ӿ�(һ���this::predicate��)
		*/
		data.addAnimationController(
				new AnimationController<EntityBilibiliSlime>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory()
	{
		return this.factory;
	}

}
