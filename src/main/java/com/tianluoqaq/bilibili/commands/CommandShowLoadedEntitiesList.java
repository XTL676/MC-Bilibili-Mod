package com.tianluoqaq.bilibili.commands;

import java.util.List;

import com.google.common.collect.Lists;
import com.tianluoqaq.bilibili.util.Debug;
import com.tianluoqaq.bilibili.util.Reference;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

//�鿴��ǰ������ص���������
public class CommandShowLoadedEntitiesList extends CommandBase
{
	// ��������������ַ���
	private final List<String> aliases = Lists.newArrayList(Reference.MOD_ID, "entitiesshow");

	// �����ȫ��
	@Override
	public String getName()
	{
		return "entitiesshow";
	}

	// ����ĸ�ʽ
	@Override
	public String getUsage(ICommandSender sender)
	{
		return "entitiesshow";
	}

	@Override
	public List<String> getAliases()
	{
		return aliases;
	}

	// �Ƿ�������Ȩ�����д�����
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender)
	{
		return true;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
	{
		if (sender instanceof EntityPlayer)
		{
			Debug.sendDebugMessage(((EntityPlayer) sender).world,
					((EntityPlayer) sender).world.getLoadedEntityList() + "");
		}
	}

}
