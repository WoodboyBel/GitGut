package me.piete.Tut3;


import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

public class Main extends JavaPlugin
{
	
	@Override
	public void onEnable()
	{
		Bukkit.getLogger().log(Level.INFO,"[Tutorial 2] Has Started");
	}
	
	@Override
	public void onDisable()
	{
		Bukkit.getLogger().log(Level.INFO,"[Tutorial 2] Has Stopped");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(cmd.getName().equalsIgnoreCase("lobby"))
		{
			if(sender instanceof Player)
			{
				Player player = (Player) sender;
				
				if(player.hasPermission("tutorial.lobby"))
				{
					//hardcoded coords
					int x = 110;
					int y = 64;
					int z = -173;
					
					//getting the world
					// 0 is first world
					World world = Bukkit.getWorlds().get(0);
					
					Location loc = new Location(world,x,y,z);
					player.teleport(loc);
					
					//adding potion effects
					player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 10, 4));
					player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 10, 4));
					
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou arrived!"));
					
					return true;
				}
				else
				{
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&rAcces Denied!"));
					return true;
				}
				
				
				
				
				
			}else{
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&rConsole cannot run this command!"));
				return true;
			}
			
		}
		
		return false;
	}
	
}
