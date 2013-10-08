package model;

import java.util.ArrayList;

import component.AbstractComponent;

public class Logic {
	ArrayList<AbstractComponent> hs;
	int level;
	StateModel state;
	public static final int MAX = 40;
	public static final int INTERVAL = 10;
	public Logic(StateModel state) {
		this.hs = new ArrayList<AbstractComponent>();
		this.state = state;
		level = MAX;
	}

	public int getLevel() {
		    level = MAX;
			for (int i=0; i< hs.size(); ++i) {
				if ( hs.get(i).controlModel.isActive() ) {
					level -= hs.get(i).controlModel.getPenalty();
				}
			}
			
			if (level > MAX) {
				level = MAX;
			} else if (level <= 0) {
				level = 0;
				if (state.isRunning()) {
					state.ring();
				}
			}
		return level;
	}

	public void add(AbstractComponent component) {
		hs.add(component);
		
	}

}
