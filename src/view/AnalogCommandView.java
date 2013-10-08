package view;

import model.ControlModel;
import processing.core.PApplet;

public class AnalogCommandView extends AnalogSensorView {

	public AnalogCommandView(ControlModel control, PApplet pa, float x,
			float y, int w, int h) {
		super(control, pa, x, y, w, h);
	}
	public void display() {
		pa.noStroke();
		pa.text(spos,0,y + 12);
		pa.fill(204);
		pa.rect(x, y, w, h);

		if (over || locked) {
			pa.fill(0, 0, 0);
		} else {
			pa.fill(102, 102, 102);
		}
		pa.rect(spos, y, h, h);
		pa.fill(255);
		pa.text(control.getPenalty(), spos,y + 12);
	}
	
}
