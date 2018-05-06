package code;
import java.applet.Applet;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;




@SuppressWarnings("serial")
public class Game extends Applet implements KeyListener, MouseListener,MouseMotionListener, Runnable {

	//screen size
	Image off_screen;
	Graphics off_g ;

	

	//String [] action = {"rt","lt","up","dn"};
	
	
	
	Image start_menu = Toolkit.getDefaultToolkit().getImage("Start_menu.png");
	
	ImageLayer road = new ImageLayer("/Users/Charlie/Desktop/road.jpg",400,0,1);
	//ImageLayer sidewalk = new ImageLayer("/Users/Charlie/Desktop/jungle.jpg",0,0,1);
	

	
	
	//at class scope
	Rect r = new Rect(350,300,700,300);
	Rect r2 = new Rect(50,50,50,50);
	

	
	Thread t; 
	
	boolean paused = false;
	boolean ltPressed = false;
	boolean rtPressed = false;
	boolean upPressed = false;
	boolean dwnPressed = false;
	boolean space_pressed = false;
	boolean start = false;
	
	
	boolean overlap = false;
	
	int mx;
	int my;
	
	
	
	public void init(){

		setSize(1366,768);
		
		off_screen = this.createImage(1366, 768);
		off_g = off_screen.getGraphics();
		
		
		requestFocus(); //makes the program request focus from the operating system
		addKeyListener(this);
		//"this" means this program
		//this program is a keyListener itself
		//this == I
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		t = new Thread(this);// "This" parameter. This line creates a thread
		t.start();
		
		
	}

	
	@SuppressWarnings("static-access")
	public void run() {
		
		//game loop
		//make the loop sleep
		//make it try to sleep
		//test.play(stream);
		
		while(!start){
			
			
			repaint();
				
			try{
				
				t.sleep(15);
				
			}catch(Exception x){}
		}
		
		
		while(start){//dont stop
			
			road.y += 10;
			
			if(space_pressed){
				
				paused = !paused;
			}
	
				
				
			if(upPressed){
			
			}
			
			
			if(dwnPressed){
				
		
			}
			
			
			if(ltPressed){
				
				
			}
		
			if(rtPressed){
				
			}
			
			
	
			
			repaint();
			
			
			
			try{
				
				t.sleep(15);
				
			}catch(Exception x){}
			
		}
		
		}
	
	
	public void update(Graphics g){

		off_g.clearRect(0, 0, 1366, 768);
		paint(off_g);
		g.drawImage(off_screen, 0, 0, null);
		
	}
	
	
	
	public void paint(Graphics g){
		//g.drawImage(jungle, 0, 100, 1366, 500, this);
		if(!start) {
			g.drawImage(start_menu, 0, 0, null);
			
			r.draw(g);
		
		}
		
		if(start) {
			
			
			
			
		r.draw(g);
		
		//tank.draw(g);
		//soldier.draw(g);
		
		road.draw(g);
		//tank2.draw(g);
		r2.draw(g);
		//g.drawImage(jungle,0,0,null);
		
		
		
		}
	
	}
	
	
	@Override
	public void mouseMoved(MouseEvent e){
	
	}
	
	@Override
	public void mouseDragged(MouseEvent e){
		
		//these are not the same as the ones in mousePressed because these are not at class scope
		int mx = e.getX();
		int my = e.getY();
		
		
		
						//this.mx  and this.my is outside of area
		int dx = mx - this.mx;
		int dy = my - this.my;
		
		r2.resizeBy(dx, dy);
		
		

		this.mx = mx;
		this.my = my;
		
		
		
	}
	
	@Override
	public void mousePressed(MouseEvent e){
		 mx = e.getX();
		 my = e.getY();
		 
		r2 = new Rect(mx,my,0,0);
		
		 
		 
		 if(r.contains(mx, my)) {
			 System.out.println("clicked in square");
			 this.start = true;
			 r2 = new Rect(mx,my,0,0);
		 }
		 
		 
		 
		 
		 
		
	}

	@Override
	public void mouseReleased(MouseEvent e){
		
		r = new Rect(-100,0,0,0);
		r2 = new Rect(-100,0,0,0);
	
		
		
	}

	public void mouseClicked(MouseEvent e){
	
		 
	}
	
	public void mouseEntered(MouseEvent e){
		
	}

	public void mouseExited(MouseEvent e){
	
	}

	
	
	
	
	

	@Override
	public void keyPressed(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == e.VK_A){
			ltPressed = true; 
			
		}
		if(code == e.VK_D){
			rtPressed = true; 
		}
		if(code == e.VK_W){
			upPressed = true; 
		}
		if(code == e.VK_S){
			dwnPressed = true; 
		}
		if(code == e.VK_SPACE) {
			space_pressed = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		if(code == e.VK_A){
			ltPressed = false; 
		}
		if(code == e.VK_D){
			rtPressed = false; 
		}
		if(code == e.VK_W){
			upPressed = false; 
		}
		if(code == e.VK_S){
			dwnPressed = false; 
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	

	
	
	
}
