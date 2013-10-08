package component;
import model.ControlModel;
import controller.AnalogCommandController;
import controller.AnalogSensorController;
import controller.InverterController;
import cc.arduino.AbstractMC;
import processing.core.PApplet;
import view.AnalogCommandView;
import view.AnalogSensorView;
import view.InverterView;
import view.LabelView;


public class AnalogComponent extends AbstractComponent {
	protected InverterController inverterController;
	protected InverterView inverterView;
	public AnalogSensorController analogSensorController;
	public AnalogCommandController analogCommandController;
	public AnalogSensorView analogSensorView;
	public AnalogCommandView analogCommandView;
	public AnalogComponent(PApplet pa, AbstractMC micro, int pin, float x, float y, int w, int h) {
		controlModel=new ControlModel();
		labelView = new LabelView(pa,  x + w + 30, y +12 ,h ,h);
		inverterView = new InverterView(controlModel, pa, x + w + 30, y +26 ,h ,h);
		inverterController = new InverterController(pa, controlModel, inverterView);
		analogSensorView = new AnalogSensorView(controlModel, pa, x, y, w, h);
		analogSensorController = new AnalogSensorController(analogSensorView,pa);
		analogSensorController.set(micro,pin);
		analogCommandView = new AnalogCommandView(controlModel, pa, x, y +16, w, h);
		analogCommandController = new AnalogCommandController(controlModel, analogCommandView, pa);
	}

	public void update() {
		analogCommandController.update();
		analogSensorController.update();
		inverterController.update();
		controlModel.setActive( controlModel.isInverted() ^ analogSensorView.getSpos() >= analogCommandView.getSpos());
	}

	public void display() {
		analogSensorView.display();
		analogCommandView.display();
		labelView.display();
		inverterView.display();
	}
}
