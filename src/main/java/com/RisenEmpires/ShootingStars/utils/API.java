package com.RisenEmpires.ShootingStars.utils;

import com.RisenEmpires.ShootingStars.ShootingStars;
import com.RisenEmpires.ShootingStars.events.GUIListeners;
import com.RisenEmpires.ShootingStars.files.FileHandler;

public class API {
	private static ShootingStars _stars;
	private static FileHandler fileHandler;
	private static InventoryGUI inventoryGUI;
	
	public API(ShootingStars shootingStars) {
		_stars = shootingStars;
		fileHandler = new FileHandler(_stars);
		new InventoryGUI();
		new GUIListeners();
	}
	
	public static FileHandler getFileHandler() {
		return fileHandler;
	}
	
	public static InventoryGUI getInventoryGUI() {
		return inventoryGUI;
	}
}
