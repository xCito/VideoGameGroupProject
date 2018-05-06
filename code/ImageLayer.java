package code;

import java.awt.*;


public class ImageLayer  {
	
	//List list = new List();
	
	Image image;
	
	int x;
	int y;
	int z;
	
	public ImageLayer(String file, int x,int y,int z) {
		image = Toolkit.getDefaultToolkit().getImage(file);
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void moveLeftBy(int dx) {
		x-=dx;
	}
	
	public void moveRightBy(int dx) {
		x+=dx;
	}
	
	public void moveUpBy(int dy) {
		y+=dy;
	}
	public void moveDownBy(int dy) {
		y-=dy;
	}
	
	
	
	
	
	public void draw(Graphics g) {
		//int count = 0;
		for(int i = 0;i<10;i++) {
			g.drawImage(image,x,y+(i*250),250,250,null);
			//g.drawImage(image,x,y+350,250,250,null);
		}
	}

}
