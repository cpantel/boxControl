package view;

import model.ControlModel;
import processing.core.PApplet;

public class InverterView extends AbstractView{

	private ControlModel control;

	public InverterView(ControlModel control, PApplet pa, float x, float y, int w, int h) {
		super(pa, x, y, w, h);
		this.control = control;
	}


	@Override
	public	void display() {
		if (control.isInverted()) {
			pa.fill(255,0,0);
		} else {
			pa.fill(0,255,0);
		}
		pa.rect(getX(),getY(),getW(),getH());
		pa.fill(0,0,0); 
	}

}
