package com.RisenEmpires.ShootingStars.files;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.RisenEmpires.ShootingStars.ShootingStars;

public class FileHandler {
	private final HashMap<Files, YamlConfiguration> _configurations;
	
	public FileHandler(ShootingStars stars) {
		_configurations = new HashMap<Files, YamlConfiguration>();
		loadFiles();
	}
	
	public void loadFiles() {
		for (Files file : Files.values()) {
			File confFile = new File(file.getPath());

			if (confFile.exists()) {
				if (_configurations.containsKey(file)) {
					_configurations.remove(file);
				}
				YamlConfiguration conf = YamlConfiguration.loadConfiguration(confFile);
				_configurations.put(file, conf);
			} else {
				File parentFile = confFile.getParentFile();

				if (!parentFile.exists()) {
					parentFile.mkdirs();
				}
				this.createFiles(file, confFile);
			}
		}
	}

	private void createFiles(Files files, File file) {
		switch (files) {
			case CONFIG:
				YamlConfiguration Config = YamlConfiguration.loadConfiguration(file);
				Config.set("Shooting Stars Configuration", true);
				try {
					Config.save(file);
				} catch (IOException e) {
				}
				_configurations.put(files, Config);
				break;
		default:
			break;
		}
	}

	public String getProperty(Files file, String path) {
		FileConfiguration conf = _configurations.get(file);

		if (conf != null) {
			String prop = conf.getString(path, "NULL");

			if (!prop.equalsIgnoreCase("NULL"))
				return prop;
			conf.set(path, null);
		}
		return null;
	}

	public List<String> getPropertyList(Files file, String path) {
		FileConfiguration conf = _configurations.get(file);

		if (conf != null) {
			List<String> prop = conf.getStringList(path);
			if (!prop.contains("NULL"))
				return prop;
			conf.set(path, null);
		}
		return null;
	}
	public String setProperty(Files file, String path, String value){
		FileConfiguration conf = _configurations.get(file);
		if (conf != null) {
			
		}
		return null;
	}
}
