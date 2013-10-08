package component;

import view.LabelView;
import model.ControlModel;

public abstract class AbstractComponent {
	public ControlModel controlModel;
	public LabelView labelView;
	abstract public void update();
	abstract public void display();

}
