package com.RisenEmpires.ShootingStars;

import java.io.IOException;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.mcstats.Metrics;

import com.RisenEmpires.ShootingStars.utils.API;

public class ShootingStars extends JavaPlugin{
	
	public final Logger log = Logger.getLogger("Minecraft");
	
	@Override
	public void onEnable() {
		new API(this);
		if (Bukkit.getPluginManager().getPlugin("WorldEdit") == null) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[Shooting Stars]" + ChatColor.RED + "Unable to find WorldEdit: Disabling Shooting Stars.");
			Bukkit.getPluginManager().disablePlugin(this);
		}
		
		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
	    	// Failed to submit the stats :-(
		}
	}
	
	@Override
	public void onDisable() {
		
	}
}
