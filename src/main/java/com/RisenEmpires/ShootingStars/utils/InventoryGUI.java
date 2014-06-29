package com.RisenEmpires.ShootingStars.utils;

import java.util.Arrays;
import java.util.List;

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
				
				if ((player.hasPermission("shootingstars.spawn") || player.hasPermission("shootingstars.*") || player.isOp())) {
					ItemStack spawn = new ItemStack (Material.NETHER_STAR);
					ItemMeta spawnMeta = spawn.getItemMeta();
					List<String> spawnLore = Arrays.asList(ChatColor.UNDERLINE + "" + ChatColor.ITALIC + "Shooting Stars Spawn",
							ChatColor.RESET + "Spawns a star in 3 minutes at your location");
					
					spawnMeta.setDisplayName(ChatColor.GREEN + "Spawn");

					spawnMeta.setLore(spawnLore);
					spawn.setItemMeta(spawnMeta);
					
					inventory.setItem(5, spawn);
				}
				
				player.openInventory(inventory);
				break;
			default:
				break;
		}
	}
}
