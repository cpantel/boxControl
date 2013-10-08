package main;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;

import component.DriverComponent;


import processing.core.PApplet;
import web.WebServer;
import cc.arduino.AbstractMC;
import cc.arduino.Arduino;
import cc.arduino.ArduinoMC;
import cc.arduino.MockMC;

public class theBox extends PApplet{

	private static final long serialVersionUID = 4627945337236372513L;
	WebServer webServer;
    DriverComponent driver;
    
	public static void main(String args[]) {
		PApplet.main(new String[] {"--present", "theBox"});
	}
	
	public void setup() {
		AbstractMC micro = new ArduinoMC(this, Arduino.list()[0], 57600);
		//AbstractMC micro = new MockMC(8,8);
		driver = new DriverComponent(width, this, micro);
		size(640, 420);
		noStroke();		
        webServer = new WebServer(sketchPath("")+"../resources/pftf", driver.getDefcon());
	}

	public void draw() {
		//background(255);
		try {
			driver.draw();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//stroke(0);
	}
}
