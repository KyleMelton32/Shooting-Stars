package com.RisenEmpires.ShootingStars.Commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

import com.RisenEmpires.ShootingStars.utils.API;
import com.RisenEmpires.ShootingStars.utils.TerrainManager;

public class Commands implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
		if (commandLabel.equalsIgnoreCase("stars")) {
			if (sender instanceof Player){
				Player player = (Player) sender;
				if (args.length == 0){
					if (player.hasPermission("shootingstars.reload") ||
							player.hasPermission("shootingstars.*") ||
							player.hasPermission("shootingstars.spawn") ||
							player.hasPermission("shootingstars.version") ||
							player.hasPermission("shootingstars.update") ||
							player.isOp()) {
						API.getInventoryGUI().openGUI(player, "Commands");
					} else {
						player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
					}
				}
				
				if (args[0].equalsIgnoreCase("spawn")) {
					if ((player.hasPermission("shootingstars.spawn")) || (player.isOp()) || (player.hasPermission("shootingstars.*"))) {
						Location location = player.getLocation();
						TerrainManager tm = new TerrainManager(null, player);
						File saveFile = new File( "/plugins/Shooting Stars", "star");
						player.sendMessage(ChatColor.AQUA + "[Shooting Stars] " + ChatColor.GREEN + "A star has crashed at your location!");
						try {
							tm.loadSchematic(saveFile, location);
			             } catch (Exception e) {
			            	 e.printStackTrace();
			             }
					}
				}
				
				if (args[0].equalsIgnoreCase("reload")) {
					if ((player.hasPermission("shootingstars.reload")) || (player.isOp()) || (player.hasPermission("shootingstars.*"))) {
						API.getFileHandler().loadFiles();
						player.sendMessage(ChatColor.AQUA + "[Shooting Stars] " + ChatColor.GREEN + "Shooting Stars config file reloaded.");
						Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[Shooting Stars]" + ChatColor.GREEN + player + "has reloaded the config files");
					} else {
						player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
					}
				}
				
				if (args[0].equalsIgnoreCase("version")) {
					if((player.hasPermission("shootingstars.version")) || (player.isOp()) || (player.hasPermission("shootingstars.*"))){
						PluginDescriptionFile pdf = Bukkit.getPluginManager().getPlugin("Shooting Stars").getDescription();
						player.sendMessage(ChatColor.AQUA + "[Shooting Stars] " + ChatColor.GREEN + pdf.getName() + " Version " + pdf.getVersion() + " is currently Enabled!");
					} else {
						player.sendMessage(ChatColor.RED + "You do not have permission to use this command");
					}
				}
				if (args[0].equalsIgnoreCase("update")) {
					
				}
			} else {
				
			}
		}
		return true;
	}
}
