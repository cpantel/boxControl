package component;
import model.StateModel;
import processing.core.PApplet;
import view.LabelView;
import view.StateView;
import controller.StateController;


public class StateComponent extends AbstractComponent {
	protected StateController stateController;
	protected StateView stateView;
	public StateModel stateModel; //TODO overriding ControlModel
	public StateComponent(PApplet pa, float x, float y, int w, int h) {
		stateModel=new StateModel();
		stateView = new StateView(stateModel, pa, x + w + 25, y  ,h ,h);
		stateController = new StateController(pa, stateModel, stateView);
	
	}

	public void update() {
		try {
			stateController.update();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//stateModel.setActive( stateModel.isInverted() );
	}

	public void display() {
		stateView.display();
	}
}
