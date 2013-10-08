package view;

import processing.core.PApplet;

public abstract class AbstractView {
	protected int w;
	protected int h;
	protected float x;
	protected float y;
	PApplet pa;
	public AbstractView(PApplet pa, float x, float y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.pa = pa;
	}
	
	abstract void display();

	public int getW() {
		return w;
	}

	public int getH() {
		return h;
	}

	public float getY() {
		return y;
	}

	public float getX() {
		return x;
	}

	public void setW(int w) {
		this.w = w;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}
	
}
