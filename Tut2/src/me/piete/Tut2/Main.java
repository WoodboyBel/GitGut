package me.piete.Tut2;


import java.util.ArrayList;
import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

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
		if(cmd.getName().equalsIgnoreCase("hello"))
		{
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cHello "+sender.getName()));
			return true;
		}
		if(cmd.getName().equalsIgnoreCase("please"))
		{
			if(sender instanceof Player)
			{
				Player player = (Player) sender;
				player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cHere you go "+player.getName()));
				
				Material axe = Material.DIAMOND_AXE;
				ItemStack item = new ItemStack(axe, 1);
				item.addEnchantment(Enchantment.DURABILITY, 5);
				ItemMeta meta = item.getItemMeta();
				meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cShitty Axe"));
				java.util.List<String>lore = new ArrayList<String>();
				lore.add(ChatColor.translateAlternateColorCodes('&', "&bWhy Am I Here"));
				lore.add(ChatColor.translateAlternateColorCodes('&', "&bDROP ME!!"));
				meta.setLore(lore);
				item.setItemMeta(meta);
				
				player.getInventory().addItem(item);
				
				Material wool = Material.WOOL;
				ItemStack woolItem = new ItemStack(wool,32,(byte)4);
				
				player.getInventory().addItem(woolItem);
				
				return true;
			}else{
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&rConsole cannot run this command!"));
				return true;
			}
			
		}
		
		return false;
	}
	
}
