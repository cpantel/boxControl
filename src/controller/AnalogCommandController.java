package controller;
import model.ControlModel;
import processing.core.PApplet;
import view.AnalogSensorView;


public class AnalogCommandController extends AbstractSliderController {


	private ControlModel controlModel;
	public AnalogCommandController (ControlModel controlModel, AnalogSensorView view, PApplet pa) {
        super(view, pa);
		this.controlModel = controlModel;
	}

	public void update() {
		view.setOver(overEvent());

		view.setLocked(pa.mousePressed && view.isOver());
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
		if (view.isLocked()) {
			newspos = PApplet.constrain(pa.mouseX-view.getH()/2, sposMin, sposMax);
		}
		if (PApplet.abs(newspos - view.getSpos()) > 1) {
			view.setSpos(view.getSpos() + (newspos-view.getSpos())/1);
		}
	}

	boolean overEvent() {
		return (pa.mouseX > view.getX() && pa.mouseX < view.getX()+view.getW()
			&& pa.mouseY > view.getY() && pa.mouseY < view.getY()+view.getH());
	}
}
