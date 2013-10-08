package cc.arduino;

public class MockMC extends AbstractMC {
	private float[] analogChannels;
	private int[] digitalChannels;
	private int[] analogDirection;
	private int[] digitalDirection;

    
	public MockMC(int analog, int digital) {
		analogChannels= new float[analog];
		analogDirection = new int[analog];
		
		digitalChannels= new int[analog];
		digitalDirection = new int[analog];
		
		for (int i=0; i< analogChannels.length; ++i) {
			analogChannels[i]=500;
			analogDirection[i]=5;
		}
		for (int i=0; i< digitalChannels.length; ++i) {
			digitalChannels[i]=100;
			digitalDirection[i]=1;
		}
		
	}
	
	@Override
	public float analogRead(int pin) {
		analogChannels[pin] += analogDirection[pin];
		if (analogChannels[pin]> 1500 || analogChannels[pin]<0) analogDirection[pin] *= -1;
		return analogChannels[pin];
	}

	@Override
	public int digitalRead(int pin) {
		digitalChannels[pin] += pin * digitalDirection[pin];
		if (digitalDirection[pin] > 500 
				||  (digitalDirection[pin] <= 100)) {
			digitalDirection[pin] *= -1;
		}		
		return digitalDirection[pin] == 1 ? 1: 0;
	}
}
