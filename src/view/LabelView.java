package view;

import processing.core.PApplet;

public class LabelView extends AbstractView {
	private String name;
	
	public LabelView( PApplet pa, float x, float y, int w, int h) {
		super(pa,x,y,w,h);
	}

	public void display() {
		pa.fill(0);
		pa.text(getName(),getX(),getY() + 12);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
