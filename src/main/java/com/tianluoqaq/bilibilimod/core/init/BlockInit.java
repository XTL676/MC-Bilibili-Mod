package com.tianluoqaq.bilibilimod.core.init;

import com.tianluoqaq.bilibilimod.core.util.Reference;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

//ģ���ڷ���ʵ�����Լ���ʼ�����ࡾ���巽����ࡿ
public class BlockInit
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
			Reference.MOD_ID);

	/******************************************Blocks(����)******************************************************************/

	/**
	 * ���巽��
	 * 
	 * ITEMS.register("�����ʶ��",
	 *	() -> new Block(AbstractBlock.Properties.of(Material.����Ĳ���)
	 *		.harvestLevel(����ļ�Ӳ�ȼ���0 = ���������ƻ�, 1 = ʯͷ, 2 = ��, 3 = ��ʯ��).sound(SoundType.���ƻ�ʱ����������)
	 *			.strength(����ļ�Ӳ�̶ȡ�https://minecraft.fandom.com/wiki/Breaking#Blocks_by_hardness��
	 *			, ������ھ�������https://minecraft.fandom.com/wiki/Explosion��)));
	 */
	// TODO ��͸������
	public static final RegistryObject<Block> LIGHT_BLUE_BILIBILI_GLASS = BLOCKS.register("light_blue_bilibili_glass",
			() -> new Block(AbstractBlock.Properties.of(Material.GLASS).sound(SoundType.GLASS).strength(0.3f, 0.3f)));

	// �����������ʯ
	public static final RegistryObject<Block> B_DIAMOND_ORE = BLOCKS.register("b_diamond_ore",
			() -> new Block(AbstractBlock.Properties.copy(Blocks.DIAMOND_ORE).strength(3f, 3f)));
}
