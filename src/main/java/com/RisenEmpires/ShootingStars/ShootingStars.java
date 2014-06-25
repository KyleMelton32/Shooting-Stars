package com.RisenEmpires.ShootingStars;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import com.RisenEmpires.ShootingStars.utils.API;

public class ShootingStars extends JavaPlugin{
	
	public final Logger log = Logger.getLogger("Minecraft");
	
	@Override
	public void onEnable() {
		new API(this);
/*		try {
		    Metrics metrics = new Metrics(this);
		    metrics.start();
		} catch (IOException e) {
	    	// Failed to submit the stats :-(
		}*/
	}
	
	@Override
	public void onDisable() {
		
	}
}
