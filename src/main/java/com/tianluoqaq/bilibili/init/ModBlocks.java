package com.tianluoqaq.bilibili.init;

import java.util.ArrayList;
import java.util.List;

import com.tianluoqaq.bilibili.Main;
import com.tianluoqaq.bilibili.blocks.BlockBase;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

//ģ���ڵ����з��鶨��ĵط�
public class ModBlocks
{

	public static final List<Block> BLOCKS = new ArrayList<Block>();

	// ���������飬����Ϊ��������
	public static final Block BILIBILI_BLOCK = new BlockBase("bilibili_block", Material.GRASS, Main.BLOCK_TAB);
}
