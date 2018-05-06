package code;

import java.awt.Color;
import java.awt.Graphics;

public class Sprite extends Rect{


	Animation [] animation;
	
	boolean selected = false;
	
	boolean moving = false;
	
	static final int  LEFT 	= 0;
	static final int  RIGHT = 1;
	static final int  UP 	= 2;
	static final int  DOWN 	= 3;
	
	
	int pose = LEFT;
	
	public Sprite(int x, int y,String file,String [] action,int count,int duration){
		super(x,y,90,130);
		
		
		animation = new Animation[action.length];
		
		
		for(int i = 0; i < action.length; i++){
			animation[i] = new Animation(file + action[i]+"_",count,duration);
		}
	}
	
	
	
	
	
	public void moveUpBy(int dy){
		
		y -= dy;
		moving = true;
		pose = UP;
	}
	
	public void moveDownBy(int dy){
		
		y += dy;
		moving = true;
		pose = DOWN;
	}
	public void moveLeftBy(int dx){
		x -= dx;
		moving = true;
		pose = RIGHT;
	}
	public void moveRightBy(int dx){
		x += dx;
		moving = true;
		pose = LEFT;
	}
	
	/*public void rotateLeft(String[]action) {
		for(int i = 0; i < action.length; i++){
			animation[i] = new Animation("g_" + action[i]+"_",3,2);
		}
	}
	*/
	
	
	public void draw(Graphics g){
		
		if(moving)
		g.drawImage(animation[pose].nextImage(),(int)x,(int)y,90,130, null);
		//g.drawImage(animation[pose].nextImage(),x,y, null);
		
		
		else
			g.drawImage(animation[pose].stillImage(),(int)x,(int)y,90,130,null);
		//g.drawImage(animation[pose].stillImage(),x,y,null);
			moving = false;
			
			g.setColor(Color.BLACK);
			if(selected)
				super.draw(g);
				g.drawLine((int)x+8, (int)y,(int)x+(int)w-8, (int)y);
				g.setColor(Color.BLACK);
				
		
		
	}
}
