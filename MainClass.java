/*Assignment 9: Susan Pinchiaroli
 * 
 * In this program, I increased the speed of target every time it hit an edge in the method edgecheck();
 * In here, every time entity was an instance of target and it hit the edge, I increased the targets speed by 1.003. 
 * I changed the color of each row in the setup method. In the target class, I had a method called color()
 * that would take in the row and for each row, assign it the same color. Then, for changing length of base,
 * I created a mouseClicked() method that checked if the mouse was on the left or right side of base
 * by seeing where it was in relation to xPosition. Lastly, I created a monster entity that simply moves from side to side
 * and prints out the score. This score is accumulated each time a missile hits a target. If its going down, meaning its dy is 
 * positive, then add three points. After hitting all targets, the monster prints out "finished". 
 * 
 * 
 * 
 */
  import java.util.ArrayList;
 

import processing.core.PApplet;

public class MainClass extends PApplet {
	public int nCols = 1200, nRows = 600;
	ArrayList<Entity> entities = new ArrayList<Entity>();
	Block b; Target t; Missle m; Barrier barr; Base base;
	monster mons;
	public void setup(){//just runs one time. 
	size(nCols,nRows);
	for (int row  =1; row<=5; row++ ) {//create target. you give it a row and column of the target. 
		
		for (int col  =1; col<=10; col++ ) {//creating targets
	         t= new Target(row,col);
	         t.color(row);
	         entities.add(t);
	         
	    }
		
		
		
		
	}
	for (int row  =1; row<=6; row++ ) {//creates a couple barriers. 
	    barr= new Barrier(row);  
	    entities.add(barr);
	}
	base = new Base();//creates base and missiles
	m = new Missle(base,nCols,nRows);
	entities.add(base);
	entities.add(m);
	mons=new monster();
	entities.add(mons);

	//when you create these add to enttities array list. Entitiy is interface so any class that 
	//implements, must be able to update itself and draw itself on the screen. 
	}// end setup. So many times a second it calls the draw. 
	
	
	public void draw(){ 
		 
		
		EdgeCheck();  // blocks change direction when hitting edge. 
		for (Entity myentity: entities) {// for an arraylist returns items in index order
		     {myentity.update() ;}//go through every entitiy and update yourself. Update means
		     //adding dx to your x. 
		}
		for (Entity myentity: entities) {
			if (myentity instanceof  Block  )  {//block is either a barrier or a target 
				
		    	b = (Block) myentity;
		    	
		    	
		    	
		    	
		        if (b.collide(m) ) {///if you collide
		        	if (b instanceof Target) {
		        		entities.remove(myentity);
		        	
		        	
		        		
		        		if(m.dy>0) {
		        			mons.addToScore(3);//if the missile is going down, add three to it. else, add 1 points to score
		        		}
		        		else {
		        		mons.addToScore(1);}//check if region ot barrier matches region of missile. 
		        		
		        	if (m.dy <0) {m.setOnBase();
		        	} else {m.dy=-m.dy; }
		        	
		        	
		        	break; }
		        	
		        	if (b instanceof Barrier) {m.dx = -m.dx; m.dy=-m.dy;}
		        	if (b instanceof Base) { m.setOnBase();}
		        }
		         
		        
		        
		        
		        
			}
		        
		       
		    }
		
			
			
		
		
		background(200);
		for (Entity myentity: entities) {
		    myentity.draw(this) ;
		    
		}
		
	}
	public void mouseClicked(){
		
		double centerX =base.x + base.w/2;
		double centerY = base.y + base.h/2;
		
		double diffX = mouseX-centerX;
		double diffY = mouseY-centerY;
		String[] a;
		String x = "hey, ";
		a = x.split(",");
		
	
		
		
		if(diffY <= base.h && diffY >= 0) {
			if(diffX <= 0) { //move left
				base.x-=5;
				base.w+=5;
				m.x-=5;
			}else { //move right
				base.x+=5;
				base.w-=5;
				m.x+=5;
			}
		}
	
		
		System.out.printf("rectangleCoords:(%.1f,%.1f)\tmouse:(%d,%d)\trectangleDims:(%d,%d)\n", centerX,centerY,mouseX,mouseY,base.w,base.h);
		System.out.printf("diff:(%.1f,%.1f)", diffX, diffY);
         
	
	
	}
		public void keyPressed(){ 
		if (keyCode == UP) {
			m.fired = true;}			 
		if (keyCode == RIGHT) {
			base.x+= 5;
			if (!m.fired) {m.x+=5;}}
		if (keyCode == LEFT) {
			base.x-= 5;
			if (!m.fired) {m.x-=5;}}
			}
					 
				
	public void EdgeCheck() {
		boolean edgeflag = false;
		for (Entity myentity: entities) {
		    if (myentity instanceof  Block  )  {
		    	b = (Block) myentity;
		        if ( b.x + b.w > nCols) {edgeflag = true;break;}
		        if ( b.x <0) {edgeflag = true;break;}
		    }	
	    }
		if (edgeflag) {
			for (Entity myentity: entities) {
			    if (myentity instanceof  Target )  {
			    	
			    	b = (Block) myentity;
			    	b.dx = -b.dx;  b.y +=5;
			    	b.dx*=1.0003;//increase speed of target. 
			    }	
		    }
		}
	}
}
