import processing.core.PApplet;



public class Target extends Block {
	public float l=0;
	public float g=0;
	public float b=0;

	
	public void color(int re) {
		if(re==1) {
			l= 255;
			g=0;
			b=255;
			
			
		}
		else if(re==2) {
			l = 138;
			g= 43;
			b=226;
		}
		else if(re ==3) {
			l= 240;
			g= 255;
			b=255;
		}
		else if(re==4) {
			l = 244;
			g=231;
			b=222;
		}
		else {
			l=176;
			g=196;
			b=222;
		}


	}
	
	
    public Target(int inrow, int incol) {
    	
    	
    	row = inrow;  	col = incol; w=50; h=20;
    	
    	
    	x = (col-1)*(50+5); y = (row-1)*(20+3);
    	dx = 5; dy=0;
    }
	@Override
	public void update() {
		x = x+dx; 	
	}
	@Override
	public void draw(PApplet p) {
		p.fill(l,g,b);
		p.rect(x, y, w, h);
	}
	@Override
	public boolean collide(Missle m) {
	if (m.x- m.w/2 > this.x + this.w) {return false;}  //left
	if (m.x+ m.w/2 < this.x  ) {return false;}  //right
	if (m.y- m.h/2 > this.y + this.h) {return false;}  //bottom
	if (m.y+ m.w/2 < this.y  ) {return false;}  //top
	return true;
	}
}
