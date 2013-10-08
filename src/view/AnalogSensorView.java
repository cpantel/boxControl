package view;

import model.ControlModel;
import processing.core.PApplet;

public class AnalogSensorView extends AbstractView {

	protected ControlModel control;
	protected float spos;
	protected boolean over;           // is the mouse over the slider?
	protected boolean locked;
	
	public AnalogSensorView(ControlModel control,  PApplet pa, float x, float y, int w, int h) {
		super(pa, x, y, w, h);
		this.control = control;
	}

	@Override
	public	void display() {
		pa.noStroke();

		pa.fill(0,0,0);
		pa.text(spos,0,getY() + 12);
		pa.fill(204);
		pa.rect(getX(), getY(), getW(), getH());
		if (over || locked) {
			pa.fill (0,0,0);
		} else {
			if (control.isActive()) {
				pa.fill(255, 0, 0);
			} else {
				pa.fill(0,255,0);
			}
		}

		pa.rect(spos, getY(), getH(), getH());
	}

	public float getSpos() {
		return spos;
	}

	public void setSpos(float spos) {
		this.spos = spos;
	}

	public boolean isOver() {
		return over;
	}

	public void setOver(boolean over) {
		this.over = over;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

}
