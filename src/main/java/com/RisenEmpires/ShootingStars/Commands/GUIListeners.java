package com.RisenEmpires.ShootingStars.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class GUIListeners implements Listener{
	
	
	
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		if (!ChatColor.stripColor(event.getInventory().getName()).equalsIgnoreCase("Shooting Star Commands")) {
			return;
		}
		Player player = (Player) event.getWhoClicked();
		event.setCancelled(true);
		
		if((event.getCurrentItem() == null) || (event.getCurrentItem().getType() == Material.AIR) || (!event.getCurrentItem().hasItemMeta())) {
			return;
		}
		
		switch (event.getCurrentItem().getType()) {
			case NETHER_STAR:
				player.performCommand("stars spawn");
				player.closeInventory();
				break;
			case PUMPKIN_PIE:
				player.performCommand("stars reload");
				player.closeInventory();
				break;
			case LADDER:
				player.performCommand("stars version");
				player.closeInventory();
				break;
			case HOPPER:
				player.performCommand("stars update");
				player.closeInventory();
				break;
			default:
				break;
				
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Action a = event.getAction();
		ItemStack item = event.getItem();
		
		if((a == Action.PHYSICAL) || (item == null) || (item.getType() == Material.AIR)) {
			return;
		}
		if (item.getType() == Material.FIREWORK_CHARGE) {
			
		}
	}
}
