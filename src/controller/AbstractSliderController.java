package controller;

import processing.core.PApplet;
import view.AnalogSensorView;

public abstract class AbstractSliderController {
	float newspos;    // x position of slider
	float sposMin, sposMax; // max and min values of slider

	float ratio;
	PApplet pa;
	AnalogSensorView view;
	protected int millis;
	protected int delta;
	public AbstractSliderController ( AnalogSensorView view, PApplet pa) {
  		this.view = view;
		this.pa = pa;

		view.setY(20 + view.getY());
		int widthtoheight = view.getW() - view.getH();
		ratio = (float ) view.getW() / (float)widthtoheight;
		view.setY(view.getY()-view.getH()/2);
		view.setSpos(view.getX() + view.getW()- view.getH());
		newspos = view.getSpos();
		sposMin = view.getX();
		sposMax = view.getX() + view.getW() - view.getH();
		delta = 750;
		millis = pa.millis();
	}
}
