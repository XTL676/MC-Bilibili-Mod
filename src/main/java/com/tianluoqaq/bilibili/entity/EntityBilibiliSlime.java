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

//BilibiliSlime实体类，继承自Slime类
public class EntityBilibiliSlime extends EntitySlime implements IAnimatable
{
	private AnimationFactory factory = new AnimationFactory(this);

	// 构造方法
	public EntityBilibiliSlime(World worldIn)
	{
		super(worldIn);
		this.ignoreFrustumCheck = true;
		this.setSlimeSize(2, true);
	}

	// 修改哔哩哔哩史莱姆的弹跳粒子效果为蓝色水滴粒子
	@Override
	protected EnumParticleTypes getParticleType()
	{
		return EnumParticleTypes.WATER_DROP;
	}

	// 修改哔哩哔哩史莱姆被杀死后分裂出哔哩哔哩小史莱姆，而不是分裂出原版史莱姆
	@Override
	protected EntitySlime createInstance()
	{
		return new EntityBilibiliSlime_Small(this.world);
	}

	// 返回战利品表的资源位置(自定义战利品掉落)
	@Override
	protected ResourceLocation getLootTable()
	{
		return LootTableHandler.BILIBILI_SLIME;
	}

	// 设置放置生物蛋生成的生物大小为中等史莱姆一样的大小
	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
	{
		super.readEntityFromNBT(compound);
		this.setSlimeSize(2, true);
	}

	// 设置自然生成大小为中等史莱姆一样的大小
	@Override
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata)
	{
		IEntityLivingData IELD = super.onInitialSpawn(difficulty, livingdata);
		this.setSlimeSize(2, true);
		return IELD;
	}

	// 哔哩哔哩史莱姆动作
	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event)
	{
		if (this.onGround)// 当实体在地面上的时候,循环播放idle(等待)动作
		{
			event.getController()
					.setAnimation(new AnimationBuilder().addAnimation("animation.ModelBilibiliSlime.idle", true));

			/**
			*	如果您希望控制器继续播放当前动画,或者希望其停止,请返回:
			*	PlayState.CONTINUE	继续播放当前动画
			*	PlayState.STOP		停止播放当前动画
			*/
			return PlayState.CONTINUE;
		} else
		{ // 当实体处于其他状态时,循环播放antshake(摇动天线)动作
			event.getController()
					.setAnimation(new AnimationBuilder().addAnimation("animation.ModelBilibiliSlime.antshake", true));

			return PlayState.CONTINUE;
		}

	}

	// 注册所有控制器以及监听器
	@Override
	public void registerControllers(AnimationData data)
	{
		/**
		*	addAnimationController()	将动画控制器注册到动画数据对象
		*
		*	AnimationController()		动画控制器是壁虎控制动画的核心,每个控制器可以一次播放一个动画.要同时播放多个动画,只需创建并注册多个动画即可.
		*	通过AnimationController.getAnimationState()了解控制器处于什么状态,有这么几种状态:
		*	运行	表示控制器正在积极播放动画
		*	过渡	控制器正在从停止到运行或从一个动画过渡到另一个动画
		*	停止	控制器没有主动运行动画。要么完全静止，要么回到模型的原始状态。
		*	
		*	EntityBilibiliSlime animatable	要控制的实体类
		*	String name						动作控制器的名字
		*	float transitionLengthTicks		动作过渡时间(帧)
		*	IAnimationPredicate<EntityBilibiliSlime> animationPredicate	接口(一般填“this::predicate”)
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
