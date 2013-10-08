package controller;

import model.Logic;

public class DefconController {
	int level;

	public DefconController() {
		level = Logic.INTERVAL;
	}
	
	public void setLevel(int level) {
		this.level=level;
	}

	public int getLevel() {
		return level;
	}
}
