package controller;

import model.ControlModel;
import cc.arduino.AbstractMC;
import processing.core.PApplet;
import view.DigitalSensorView;

public class DigitalSensorController {
	int pin;
	AbstractMC dataSource;
	private DigitalSensorView view;
	private PApplet pa;
	private ControlModel controlModel;
	int millis;
	int delta;	
	public DigitalSensorController(ControlModel controlModel, DigitalSensorView view,	PApplet pa) {
		this.view=view;
		this.pa = pa;
		this.controlModel = controlModel;
		delta = 750;
		millis = pa.millis();
	}
	public void set(AbstractMC micro, int pin) {
		this.pin = pin;
		this.dataSource = micro;
	}
	public void update() {
		view.setOn(dataSource.digitalRead(pin)) ;
		
		view.setOver(overEvent());

		if (view.isOver() && pa.keyPressed){
			int now = pa.millis();
			if (now > millis + delta) {
				char key = pa.key;
				if (key >= '0' && key <= '9') {
					controlModel.setPenalty(((controlModel.getPenalty() * 10) + (key - '0')) % 100);
				}
				millis = now;
			}			
		}
	}
	boolean overEvent() {
		return (pa.mouseX > view.getX() && pa.mouseX < view.getX()+view.getW()
			&& pa.mouseY > view.getY() && pa.mouseY < view.getY()+view.getH());
	}
}
