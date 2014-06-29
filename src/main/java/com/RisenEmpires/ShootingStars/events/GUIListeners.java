package com.RisenEmpires.ShootingStars.events;

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
			case DIAMOND_CHESTPLATE:
				player.performCommand("");
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
