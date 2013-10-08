package controller;

import model.ControlModel;
import processing.core.PApplet;
import view.AbstractView;


public class InverterController{

	int millis;
	int delta;
	PApplet pa;
	private ControlModel control;
	private AbstractView view;
	
	public InverterController(PApplet pa, ControlModel control, AbstractView view) {

		this.view = view;
		this.control=control;
		this.pa = pa;
		
		delta = 750;
		millis = pa.millis();
	}

	public void update() {

		if (pa.mousePressed && overEvent()) {
			int now = pa.millis();
			if (now > millis + delta) {
				control.setInverted();
				millis = now;
			}
		}
	}
	boolean overEvent() {
		return (pa.mouseX > view.getX() && pa.mouseX < view.getX()+view.getW()
			&& pa.mouseY > view.getY() && pa.mouseY < view.getY()+view.getH());
	}
}
