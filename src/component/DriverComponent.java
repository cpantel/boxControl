package component;
import java.util.ArrayList;

import model.Logic;
import model.StateModel;
import processing.core.PApplet;
import view.DefconView;
import cc.arduino.AbstractMC;
import controller.DefconController;

public class DriverComponent {
	ArrayList<AbstractComponent> ac;
	ArrayList<AbstractComponent> dc;

	TimerComponent timer;
	DefconController defcon;
	DefconView defconView;
	Logic logic;
	PApplet pa;
	StateComponent state;
	
	public DriverComponent(int w, PApplet pa, AbstractMC micro) {
		this.pa = pa;
        state = new StateComponent(pa, 250, 360, 48, 48);
		logic = new Logic(state.stateModel);
		
		timer = new TimerComponent(state.stateModel, pa, 60, 20, w * 2,16);
		timer.labelView.setName("tiempo");
		timer.controlModel.setName("tiempo");
		timer.controlModel.setPenalty(50);
		
		logic.add(timer);
		
		//TODO: make DefconComponent
		defcon = new DefconController();
		defconView = new DefconView(defcon,pa,320,75,50,50);
		
		initAnalog(w, pa, micro,5);
		initDigital(32, pa, micro,2);

		
		
	}

	private void initAnalog(int w, PApplet pa, AbstractMC micro, int penalty) {
		ac = new ArrayList<AbstractComponent>();
		for (int i=0; i< 8; ++i) {
			ac.add(new AnalogComponent(pa, micro, i, 60, 48 + (i*40), w/2, 16));
		}
		
		ac.get(0).controlModel.setName("laser1");
		ac.get(1).controlModel.setName("laser2");
		ac.get(2).controlModel.setName("laser3");
		ac.get(3).controlModel.setName("laser4");
		ac.get(4).controlModel.setName("piso");
		ac.get(5).controlModel.setName("puerta oeste");
		ac.get(6).controlModel.setName("puerta este");
		ac.get(7).controlModel.setName("movimiento");
		
		for (int i=0; i< ac.size(); ++i) {
			ac.get(i).labelView.setName(ac.get(i).controlModel.getName());
			ac.get(i).controlModel.setPenalty(penalty);
			logic.add(ac.get(i));
		}
	}

	private void initDigital(int w, PApplet pa, AbstractMC micro, int penalty) {
		dc = new ArrayList<AbstractComponent>();
//		for (int i=0; i< 12; ++i) {
//			dc.add(new DigitalComponent(pa, micro, i, 400, 80 + (i*32), w/2, 16));
//		}
		int i=2;
		dc.add(new DigitalComponent(pa, micro, i, 400, 80 + (i*32), w/2, 16));
		i=3;
		dc.add(new DigitalComponent(pa, micro, i, 400, 80 + (i*32), w/2, 16));
		i=4;
		dc.add(new DigitalComponent(pa, micro, i, 400, 80 + (i*32), w/2, 16));
		i=6;
		dc.add(new DigitalComponent(pa, micro, i, 400, 80 + (i*32), w/2, 16));
		i=7;
		dc.add(new DigitalComponent(pa, micro, i, 400, 80 + (i*32), w/2, 16));


		dc.get(0).controlModel.setName("laser3");
		dc.get(1).controlModel.setName("laser4");
		dc.get(2).controlModel.setName("piso");

		dc.get(3).controlModel.setName("puerta este");
		dc.get(4).controlModel.setName("puerta oeste");

		
		for ( i=0; i< dc.size(); ++i) {
			dc.get(i).labelView.setName(dc.get(i).controlModel.getName());
			dc.get(i).controlModel.setPenalty(penalty);
			logic.add(dc.get(i));
		}
	}
	public void draw() {
		for (int i=0; i< ac.size(); ++i) {
			ac.get(i).update();
		}  
		for (int i=0; i< dc.size(); ++i) {
			dc.get(i).update();
		}  
    	state.update();

        if (timer.tick(125)) {
        	pa.background(255);
        	timer.update();
			defcon.setLevel(logic.getLevel());
	
	        timer.display();
			for (int i=0; i< ac.size(); ++i) {
				ac.get(i).display();
			}
			for (int i=0; i< dc.size(); ++i) {
				dc.get(i).display();
			}
			defconView.display();
			state.display();
    		pa.stroke(0);
        }
	}
	public StateModel getDefcon() {
		return state.stateModel;
	}
}
