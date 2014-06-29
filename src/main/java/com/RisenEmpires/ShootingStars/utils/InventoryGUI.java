package com.RisenEmpires.ShootingStars.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class InventoryGUI implements Listener {
	
	public void openGUI(Player player, String GUI) {
		switch (GUI) {
			case "Commands":
				Inventory inventory = Bukkit.createInventory(null, 9, ChatColor.AQUA + "Shooting Star Commands");
				
				ItemStack spawn = new ItemStack (Material.DIAMOND_CHESTPLATE);
				ItemMeta spawnMeta = spawn.getItemMeta();
				
				spawnMeta.setDisplayName(ChatColor.GREEN + "Spawn");
				spawn.setItemMeta(spawnMeta);
				
				inventory.setItem(5, spawn);
				
				player.openInventory(inventory);
				break;
			default:
				break;
		}
	}
}
