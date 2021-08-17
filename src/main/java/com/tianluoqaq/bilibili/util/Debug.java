package com.tianluoqaq.bilibili.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

//���Թ�����
public class Debug
{
	/**
	 * ���������Ϣ��
	 * 
	 * @param world	�������������Object���ڵ�����
	 * @param message	Ҫ�������Ϣ
	 */
	public static final void sendDebugMessage(World world, String message)
	{
		EntityPlayer p = world.getPlayerEntityByName(Minecraft.getMinecraft().player.getName());
		if (p != null) {
			p.sendMessage(new TextComponentString(message));
		}
	}
}
