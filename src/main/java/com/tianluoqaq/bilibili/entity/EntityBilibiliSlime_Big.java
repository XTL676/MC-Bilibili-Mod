package com.tianluoqaq.bilibili.entity;

import com.tianluoqaq.bilibili.util.handlers.LootTableHandler;

import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

//BilibiliSlime_Bigʵ���࣬�̳���Slime��
public class EntityBilibiliSlime_Big extends EntitySlime implements IAnimatable
{
	private AnimationFactory factory = new AnimationFactory(this);

	// ���췽��
	public EntityBilibiliSlime_Big(World worldIn)
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

	// �޸���������ʷ��ķ��ɱ������ѳ���������ʷ��ķ�������Ƿ��ѳ�ԭ��ʷ��ķ
	@Override
	protected EntityBilibiliSlime createInstance()
	{
		return new EntityBilibiliSlime(this.world);
	}

	// ���÷������ﵰ���ɵ������СΪ��ʷ��ķһ���Ĵ�С
	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
	{
		super.readEntityFromNBT(compound);
		this.setSlimeSize(4, true);
	}

	// ������Ȼ���ɵ������СΪ��ʷ��ķһ���Ĵ�С
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata)
	{
		IEntityLivingData IELD = super.onInitialSpawn(difficulty, livingdata);
		this.setSlimeSize(4, true);
		return IELD;
	}

	// ����������ʷ��ķ�Ķ���
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
	{
		// ѭ������idle(�ȴ�)����
		event.getController()
				.setAnimation(new AnimationBuilder().addAnimation("animation.ModelBilibiliSlime_Big.idle", true));

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
		*	EntityBilibiliSlime animatable	Ҫ���Ƶ�ʵ����
		*	String name						����������������
		*	float transitionLengthTicks		��������ʱ��(֡)
		*	IAnimationPredicate<EntityBilibiliSlime_Big> animationPredicate	�ӿ�(һ���this::predicate��)
		*/
		data.addAnimationController(
				new AnimationController<EntityBilibiliSlime_Big>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory()
	{
		return this.factory;
	}
}
