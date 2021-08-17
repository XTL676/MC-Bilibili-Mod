package com.tianluoqaq.bilibili.entity;

import com.tianluoqaq.bilibili.util.handlers.LootTableHandler;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.nbt.NBTTagCompound;
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

//BilibiliSlime_Smallʵ���࣬�̳���Slime��
public class EntityBilibiliSlime_Small extends EntitySlime implements IAnimatable
{
	private AnimationFactory factory = new AnimationFactory(this);

	// ���췽��
	public EntityBilibiliSlime_Small(World worldIn)
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

	// ����ս��Ʒ�����Դλ��(�Զ���ս��Ʒ����)
	@Override
	protected ResourceLocation getLootTable()
	{
		return LootTableHandler.BILIBILI_SLIME;
	}

	// ���ô�СΪСʷ��ķһ���Ĵ�С
	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
	{
		super.readEntityFromNBT(compound);
		this.setSlimeSize(1, true);
	}

	// ��������Сʷ��ķ�Ķ���
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
	{
		// ѭ������antshake(ҡ������)����
		event.getController()
				.setAnimation(new AnimationBuilder().addAnimation("animation.ModelBilibiliSlime_Small.antshake", true));

		/**
		*	�����ϣ���������������ŵ�ǰ����,����ϣ����ֹͣ,�뷵��:
		*	PlayState.CONTINUE	�������ŵ�ǰ����
		*	PlayState.STOP		ֹͣ���ŵ�ǰ����
		*/
		return PlayState.CONTINUE;
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
		*	EntityBilibiliSlime_Small animatable	Ҫ���Ƶ�ʵ����
		*	String name						����������������
		*	float transitionLengthTicks		��������ʱ��(֡)
		*	IAnimationPredicate<EntityBilibiliSlime_Small> animationPredicate	�ӿ�(һ���this::predicate��)
		*/
		data.addAnimationController(
				new AnimationController<EntityBilibiliSlime_Small>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory()
	{
		return this.factory;
	}
}
