import processing.core.PApplet;


public class Missle implements Entity{
    public Base base;
    int x,y,dx,dy,w,h;
    boolean fired = false;
    int nRows,nCols;
	public Missle(Base inbase, int inCols,int inRows ) {
		base= inbase;w=20;h=30;
		nRows=inRows; nCols=inCols;
		setOnBase();
	}
	public void update() {
		if (fired) {x = x+dx;  y = y+dy;}
		if (y-h/2 <0) {dy=-dy;}
		if (y+h/2 >nCols) {setOnBase();}
	}

	@Override
	public void draw(PApplet p) {
		p.fill(10,10,50);
		p.ellipse(x,y,w,h);
		
	}
	public void setOnBase() {
		x= base.x + base.w/2 ; 
		y= base.y-15;
		dx = 0; dy=-5; 
		fired=false;
	}
	

}
