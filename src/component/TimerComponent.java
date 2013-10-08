package component;

import model.ControlModel;
import model.StateModel;
import processing.core.PApplet;
import view.AnalogCommandView;
import view.AnalogSensorView;
import view.InverterView;
import view.LabelView;
import controller.AnalogCommandController;
import controller.InverterController;
import controller.TimerController;

public class TimerComponent extends AbstractComponent {
    int nextExecuteTime;
    
	protected InverterController inverterController;
	protected InverterView inverterView;
	public AnalogCommandController analogCommandController;
	public AnalogSensorView analogSensorView;
	public AnalogCommandView analogCommandView;
	public TimerController timerController;

	private PApplet pa;

	public TimerComponent(StateModel stateModel, PApplet pa, float x, float y, int w, int h) {
		controlModel=new ControlModel();
		labelView = new LabelView(pa,  x + w + 30, y -8 ,h ,h);
		inverterView = new InverterView(controlModel, pa, x + w + 30, y + 12 ,h ,h);
		inverterController = new InverterController(pa, controlModel, inverterView);
		analogSensorView = new AnalogSensorView(controlModel, pa, x, y, w, h);
		timerController = new TimerController(stateModel, controlModel, analogSensorView,pa);
		analogCommandView = new AnalogCommandView(controlModel, pa, x, y +2, w, h);
		analogCommandController = new AnalogCommandController(controlModel, analogCommandView, pa);
		this.pa=pa;
   	}

	public boolean tick(int ms) {
		if (pa.millis() > nextExecuteTime ) {
			nextExecuteTime = pa.millis() + ms;
			return true;
		}
		return false;
	}

	public void update() {
		timerController.update();
		analogCommandController.update();
		inverterController.update();
		controlModel.setActive(controlModel.isInverted() ^ analogSensorView.getSpos() >= analogCommandView.getSpos());
	}

	public void display() {
		analogSensorView.display();
		analogCommandView.display();
		labelView.display();
		inverterView.display();
	}
}
