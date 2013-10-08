package model;

public class StateModel {
	//TODO use enum
	public static final int INACTIVE = 0;
	public static final int ACTIVE = 1;
	public static final int ALARM = 2;
    private int state;
	public StateModel() {
		state=INACTIVE;
	}
    public void stop() {
    	state=INACTIVE;
    }
    public void start() {
    	if ( isStopped()) {
    		state=ACTIVE;
    	}
    	
    }
    public void ring() {
    	if (isRunning()) {
    		state=ALARM;
    	}	
    }
    
	public boolean isRunning() {
		return state == ACTIVE;
	}
	public boolean isStopped() {
		return state == INACTIVE;
	}
	public void change() {
		if (isStopped()) {
			start();
		} else {
			stop();
		}
	}
}
