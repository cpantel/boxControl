package controller;

import model.StateModel;
import processing.core.PApplet;
import view.AbstractView;


public class StateController{

	int millis;
	int delta;
	PApplet pa;
	private StateModel state;
	private AbstractView view;
	private boolean pressed;
	
	public StateController(PApplet pa, StateModel control, AbstractView view) {

		this.view = view;
		this.state=control;
		this.pa = pa;
		pressed = false;
		delta = 750;
		millis = pa.millis();
	}

	public void update() {

		if (pa.mousePressed && overEvent()) {
			pressed = true;
			int now = pa.millis();
			if (now > millis + delta) {
				state.change();
				millis = now;
			}
		}
	}
	boolean overEvent() {
		return (pa.mouseX > view.getX() && pa.mouseX < view.getX()+view.getW()
			&& pa.mouseY > view.getY() && pa.mouseY < view.getY()+view.getH());
	}
}
