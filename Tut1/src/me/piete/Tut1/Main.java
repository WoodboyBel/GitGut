package me.piete.Tut1;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin
{
	
	@Override
	public void onEnable()
	{
		this.getLogger().info("plugin Has Started");
	}
	
	@Override
	public void onDisable()
	{
		Bukkit.getLogger().log(Level.INFO,"[TestPlugin] Has Stopped");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(cmd.getName().equalsIgnoreCase("hello"))
		{
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cHello "+sender.getName()));
			return true;
		}
		
		return false;
	}
	
}
