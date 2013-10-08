package component;
import model.ControlModel;
import processing.core.PApplet;
import view.DigitalSensorView;
import view.InverterView;
import view.LabelView;
import cc.arduino.AbstractMC;
import controller.DigitalSensorController;
import controller.InverterController;


public class DigitalComponent extends AbstractComponent {
	protected InverterController inverterController;
	protected InverterView inverterView;
	public DigitalSensorController digitalSensorController;
	public DigitalSensorView digitalSensorView;
	public DigitalComponent(PApplet pa, AbstractMC micro, int pin, float x, float y, int w, int h) {
		controlModel=new ControlModel();
		labelView = new LabelView(pa,  x + w + 45, y  ,h ,h);
		inverterView = new InverterView(controlModel, pa, x + w + 25, y  ,h ,h);
		inverterController = new InverterController(pa, controlModel, inverterView);
		digitalSensorView = new DigitalSensorView(controlModel, pa, x, y, w, h);
		digitalSensorController = new DigitalSensorController(controlModel,digitalSensorView,pa);
		digitalSensorController.set(micro,pin);
		
	}

	public void update() {
		digitalSensorController.update();
		inverterController.update();
		controlModel.setActive( controlModel.isInverted() ^ digitalSensorView.isOn());
	}

	public void display() {
		digitalSensorView.display();
		labelView.display();
		inverterView.display();
	}
}
