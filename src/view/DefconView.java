package view;

import model.Logic;
import controller.DefconController;
import processing.core.PApplet;

public class DefconView extends AbstractView {

	int[] r = new int[5];
	int[] g = new int[5];
	int[] b = new int[5];

	DefconController defcon;
	
	public DefconView(DefconController defcon, PApplet pa,  float x, float y, int w, int h) {
		super(pa,x,y,w,h);
		this.defcon = defcon;

		r[0]=1;	g[0]=1;	b[0]=1;
		r[1]=1;	g[1]=0;	b[1]=0;
		r[2]=1;	g[2]=1;	b[2]=0;
		r[3]=0;	g[3]=1;	b[3]=0;
		r[4]=0;	g[4]=0;	b[4]=1;
        
	}
	public void display() {

		pa.fill(0,0,0);
		for ( int i=0; i<5; ++i) {
			pa.rect(getX(),getY() + i * getW() ,getW(),getH());
		}
		int l = defcon.getLevel();

		for ( int i=0; i<5; ++i) {
		    
			int m = (i==(l+ Logic.INTERVAL - 1)/Logic.INTERVAL)? 255: 112;
			pa.fill(r[i]*m,g[i]*m,b[i]*m);
			pa.rect(getX()+1,(getY() + i * getW()) +1 ,getW() - 2 ,getH() -1);
		}

	}

}
