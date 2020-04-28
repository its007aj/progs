//Drawing a 2D ellipse using Mid Point Ellipse Algorithm
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.applet.*;
import java.util.*;

public class midpointEllipse extends Applet{
	BufferedImage image = new BufferedImage(1200, 800, BufferedImage.TYPE_INT_ARGB);
    WritableRaster raster = image.getRaster();
    int array[] = {250, 0, 0, 250};
    public void init() {
        setSize(1200, 800);
    }
    
    void plotPoints(int xCenter, int yCenter, int rx, int ry) {
    	raster.setPixel(xCenter+rx, yCenter+ry, array);
    	raster.setPixel(xCenter-rx, yCenter+ry, array);
    	raster.setPixel(xCenter-rx, yCenter-ry, array);
    	raster.setPixel(xCenter+rx, yCenter-ry, array);
    }
    
    public void paint(Graphics g){
    	int xCenter= 500;
    	int yCenter= 500;
    	int rx= 100;
    	int ry= 150;
    	plotPoints(xCenter, yCenter, rx, 0);
    	plotPoints(xCenter, yCenter, 0, ry);
    	int x= rx;
    	int y= 0;
    	int p2= ((ry*ry)/4) - (rx*ry*ry) + (rx*rx);
    	System.out.println("Region2:");
    	while(ry*ry*x >= rx*rx*y) {
    		if(p2<0) {
    			p2+= rx*rx*(2*y+3);
    		}
    		else {
    			p2+= rx*rx*(2*y+3) - 2*ry*ry*(x-1);
    			x--;
    		}
    		y++;
    		System.out.println(x+","+y);
    		plotPoints(xCenter,yCenter, x,y);
    	}
    	System.out.println();
    	System.out.println("Region1:");
    	int p1= ry*ry*(x-1)*(x-1) + rx*rx*(y+1/2)*(y+1/2) - rx*rx*ry*ry;
    	while(x>0){
    		if(p1<0) {
    			p1+= 2*rx*rx*(y+1) - ry*ry*(2*x-3);
    			y++;
    		}
    		else {
    			p1-= ry*ry*(2*x-3);
    		}
    		x--;
    		System.out.println(x+","+y);
    		plotPoints(xCenter,yCenter, x,y);
    	}
    	
    	g.drawString("(500,500)", 500, 500);
    	g.drawString("(600,500)", 600, 500);
    	g.drawString("(400,500)", 370, 500);
    	g.drawString("(500,650)", 500, 660);
    	g.drawString("(500,350)", 500, 350);
    	g.fillOval(500, 500, 5, 5);
    	g.fillOval(600, 500, 5, 5);
    	g.fillOval(400, 500, 5, 5);
    	g.fillOval(500, 650, 5, 5);
    	g.fillOval(500, 350, 5, 5);
    	g.drawImage(image, 0, 0, this);
    }
}
