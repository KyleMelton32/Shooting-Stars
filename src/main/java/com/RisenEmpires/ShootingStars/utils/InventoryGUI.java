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
					ItemStack item = new ItemStack (Material.NETHER_STAR);
					ItemMeta itemMeta = item.getItemMeta();
					List<String> itemLore = Arrays.asList(ChatColor.UNDERLINE + "" + ChatColor.ITALIC + "Shooting Stars Spawn",
							ChatColor.RESET + "Spawns a star in 3 minutes at your location");
					
					itemMeta.setDisplayName(ChatColor.GREEN + "Spawn");

					itemMeta.setLore(itemLore);
					item.setItemMeta(itemMeta);
					
					inventory.setItem(5, item);
				}
				if ((player.hasPermission("shootingstars.reload") || player.hasPermission("shootingstars.*") || player.isOp())) {
					ItemStack item = new ItemStack (Material.PUMPKIN_PIE);
					ItemMeta itemMeta = item.getItemMeta();
					List<String> itemLore = Arrays.asList(ChatColor.UNDERLINE + "" + ChatColor.ITALIC + "Shooting Stars Spawn",
							ChatColor.RESET + "Spawns a star in 3 minutes at your location");
					
					itemMeta.setDisplayName(ChatColor.GREEN + "Reload");

					itemMeta.setLore(itemLore);
					item.setItemMeta(itemMeta);
					
					inventory.setItem(5, item);
				}
				if ((player.hasPermission("shootingstars.version") || player.hasPermission("shootingstars.*") || player.isOp())) {
					ItemStack item = new ItemStack (Material.LADDER);
					ItemMeta itemMeta = item.getItemMeta();
					List<String> itemLore = Arrays.asList(ChatColor.UNDERLINE + "" + ChatColor.ITALIC + "Shooting Stars Spawn",
							ChatColor.RESET + "Spawns a star in 3 minutes at your location");
					
					itemMeta.setDisplayName(ChatColor.GREEN + "Version");

					itemMeta.setLore(itemLore);
					item.setItemMeta(itemMeta);
					
					inventory.setItem(5, item);
				}
				if ((player.hasPermission("shootingstars.update")) || (player.hasPermission("shootingstars.*"))) {
					ItemStack item = new ItemStack (Material.HOPPER);
					ItemMeta itemMeta = item.getItemMeta();
					List<String> itemLore = Arrays.asList(ChatColor.UNDERLINE + "" + ChatColor.ITALIC + "Shooting Stars Update",
							ChatColor.RESET + "Checks for updates and installs them");
					
					itemMeta.setDisplayName(ChatColor.GREEN + "Update");

					itemMeta.setLore(itemLore);
					item.setItemMeta(itemMeta);
					
					inventory.setItem(5, item);
				}
				
				player.openInventory(inventory);
				break;
			default:
				break;
		}
	}
}
