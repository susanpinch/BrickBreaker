import processing.core.PApplet;

public class monster extends PApplet implements Entity{
	private int xPos=400;
	private int yPos=250;
	private int xinc=1;

	private int ncols = 800;
    private int nrows = 500;
   public double rr = Math.random()*1000%256;
	public double rb=Math.random()*1000%256;
	public double rg=Math.random()*1000%256;
	public int points=0;
	public int r = 255;
	public int g=255;
	public int b = 255;
	public int score=0;
	public int c=0;

	
	public void setup() {
		size(ncols,nrows);
	}

	@Override
	public void draw(PApplet p) {
		//when done it appears and says, 'youre done, you earned a score of:'
		// TODO Auto-generated method stub
		
		
		 
		 if(xPos>=50+400) {
			 xinc=-xinc;
		 }
		 if(xPos<=400-50) {
			 xinc=Math.abs(xinc);
		 }
		xPos+=xinc;
		
		
		
		
		
		
		p.fill((float)rr,(float)rg,(float)rb);
		p.rect(xPos,yPos,50,50);
		p.fill(255,0,0);
		p.ellipse(xPos+12,yPos,20,20);
		p.fill(r,g,b);
		p.ellipse(xPos+12,yPos,12,12);
		p.fill(255,0,0);	
		p.ellipse(xPos+37,yPos,20,20);
		p.fill(r,g,b);
		p.ellipse(xPos+37,yPos,12,12);
		p.fill(255,255,255);
		p.rect(xPos+12,yPos+30,20,2);
		p.fill(255,56,7);
		if(c>=50) {
			p.fill(0,56,7);

			p.text("finished", xPos+50,258);
		}
		else {
		p.text(returnScore(), xPos+50,258);}
		

		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	public void addToScore(int i) {
		this.score+=i;
		this.c++;
	}
	public String returnScore() {
		return Integer.toString(score);

	}
	

	
}