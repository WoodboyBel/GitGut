package me.piete.JoinMessage;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public void onEnable()
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		getConfig().addDefault("JoinMessage", "%speler% is nu online! HUIJ");
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	@EventHandler
	public void onJoin(PlayerJoinEvent e)
	{
		Player p = e.getPlayer();
		String message = getConfig().getString("JoinMessage").replaceAll("%speler%", p.getName());
		e.setJoinMessage(message);
	}
	public void onDisable()
	{
		
	}

}
