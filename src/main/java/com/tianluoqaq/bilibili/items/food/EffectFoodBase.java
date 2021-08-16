package com.tianluoqaq.bilibili.items.food;

import com.tianluoqaq.bilibili.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//ģ���ڳ��˻���ҩˮЧ����ʳ�����
public class EffectFoodBase extends FoodBase implements IHasModel
{

	private PotionEffect effect;// ҩˮЧ��

	/**
	 * @param name			ʳ������
	 * @param amount		�ܲ���ı�ʳ��(1 = 1������)
	 * @param saturation	�ܲ���ı��Ͷ�
	 * @param isWolfFood	�Ƿ���ι����(ѱ����ʵ��)��
	 * @param tab			����ģʽ��ǩ
	 * @param effect		ҩˮЧ��
	 */
	public EffectFoodBase(String name, int amount, float saturation, boolean isWolfFood, CreativeTabs tab,
			PotionEffect effect)
	{
		super(name, amount, saturation, isWolfFood, tab);

		setAlwaysEdible();// ʹ�ô˷���������ʳ������ұ�ʳ����������»��ǿ��Գ�

		this.effect = effect;
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
	{
		if (!worldIn.isRemote)
		{
			player.addPotionEffect(new PotionEffect(effect.getPotion(), effect.getDuration(), effect.getAmplifier(),
					effect.getIsAmbient(), effect.doesShowParticles()));
		}
	}
	
	//���ش�ʳ������ҩˮЧ����
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack)
	{
		return true;
	}

}
