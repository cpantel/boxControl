package cc.arduino;
import processing.core.PApplet;


//import processing.serial.*;


public class ArduinoMC extends AbstractMC {
    private Arduino arduino;
    
	public ArduinoMC(PApplet theBox, String string, int i) {
		arduino = new Arduino(theBox, string, i);
	}

	@Override
	public float analogRead(int pin) {
		return arduino.analogRead(pin);
	}
	
	public int digitalRead(int pin) {
		return arduino.digitalRead(pin);
	}

}
