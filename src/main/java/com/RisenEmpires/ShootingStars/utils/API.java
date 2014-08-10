package com.RisenEmpires.ShootingStars.utils;

import com.RisenEmpires.ShootingStars.ShootingStars;
import com.RisenEmpires.ShootingStars.Commands.Commands;
import com.RisenEmpires.ShootingStars.Commands.GUIListeners;
import com.RisenEmpires.ShootingStars.files.FileHandler;

public class API {
	private static ShootingStars _stars;
	private static FileHandler fileHandler;
	private static InventoryGUI inventoryGUI;
	private static TerrainManager terrainManager;
	private Commands commands;
	
	public API(ShootingStars shootingStars) {
		_stars = shootingStars;
		fileHandler = new FileHandler(_stars);
		new InventoryGUI();
		new GUIListeners();
		
		commands = new Commands(_stars);
		_stars.getCommand("stars").setExecutor(commands);
	}
	
	public static FileHandler getFileHandler() {
		return fileHandler;
	}
	
	public static InventoryGUI getInventoryGUI() {
		return inventoryGUI;
	}
	
	public static TerrainManager getTerrainManager() {
		return terrainManager;
	}
}
