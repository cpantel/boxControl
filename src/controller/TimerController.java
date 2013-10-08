package controller;

import model.ControlModel;
import model.StateModel;
import processing.core.PApplet;
import view.AnalogSensorView;

public class TimerController {

	private AnalogSensorView view;
	int startTime;
	private StateModel stateModel;
	private ControlModel controlModel;

	public TimerController(StateModel stateModel, ControlModel controlModel, AnalogSensorView view, PApplet pa) {
		this.view = view;
		this.stateModel = stateModel;
		this.controlModel = controlModel;
		startTime = pa.millis();
		view.setSpos(view.getX());
	}

	public void update() {
		if (stateModel.isRunning()) {
			view.setSpos((float) (view.getSpos() + 0.025) );
		} else if (stateModel.isStopped()) {
			controlModel.reset();
		} else {
			
		}
	}

}
