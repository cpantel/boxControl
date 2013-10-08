package controller;
import cc.arduino.AbstractMC;
import processing.core.PApplet;
import view.AnalogSensorView;


public class AnalogSensorController extends AbstractSliderController {
	int pin;
	AbstractMC dataSource;

	public AnalogSensorController(AnalogSensorView view, PApplet pa) {
		super(view, pa);
	}

	public void set(AbstractMC micro, int pin) {
		this.pin = pin;
		this.dataSource = micro;
	}

	public void update() {
		float wi = view.getW() - view.getX() ;
		float r = wi/900;
		view.setSpos(view.getX() + dataSource.analogRead(pin) * r ) ;
	}
}
