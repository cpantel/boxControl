package view;

import model.ControlModel;
import processing.core.PApplet;

public class DigitalSensorView extends AbstractView {
	private ControlModel control;
	private boolean over;
	private int value;

	public DigitalSensorView(ControlModel controlModel, PApplet pa, float x,
			float y, int w, int h) {
		super(pa, x, y, w, h);
		this.control = controlModel;
	}

	public void setOn(int digitalRead) {
		value = digitalRead;
	}
	
	public boolean isOn(){
		return value ==0;
	}
	
	public boolean isOver() {
		return over;
	}

	public void setOver(boolean over) {
		this.over = over;
	}	
	@Override
	public	void display() {
		if (control.isActive()) {
			pa.fill(255,0,0);
		} else {
			pa.fill(0,255,0);
		}
		pa.rect(getX(),getY(),getW(),getH());
		pa.fill(0,0,0);
		pa.text(control.getPenalty(), x,y + 12);
		 
	}


}
