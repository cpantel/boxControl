package view;

import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

import model.StateModel;
import processing.core.PApplet;
import web.WebServer;

public class StateView extends AbstractView{

	private StateModel state;
	private URL url;
	private AudioClip audioClip;

	public StateView(StateModel state, PApplet pa, float x, float y, int w, int h) {
		super(pa, x, y, w, h);
		this.state = state;
		try {
			url = new URL("file://" + pa.sketchPath("")+"../resources/top.wav");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		audioClip = pa.getAudioClip(url);
	}


	@Override
	public	void display() {
		if (state.isRunning() ) {
			pa.fill(0,255,0);
		} else if (state.isStopped()) {
			pa.fill(127,127,127);
		} else {
			audioClip.play();
			pa.fill(255,0,0);
		}
		pa.rect(getX(),getY(),getW(),getH());
		pa.fill(0,0,0); 
	}

}
