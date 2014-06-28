package com.RisenEmpires.ShootingStars.files;

public enum Files {
	CONFIG("plugins/Shooting Stars/config.yml");
	
	private final String _path;

	private Files(final String path) {
		_path = path;
	}

	public String getPath() {
		return _path;
	}
}
