//Drawing a 2D circle using Mid Point Circle Algorithm
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.applet.*;
import java.util.*;

public class mid_point_circle extends Applet {
	BufferedImage image = new BufferedImage(1200, 800, BufferedImage.TYPE_INT_ARGB);
    WritableRaster raster = image.getRaster();
    int array[] = {250, 0, 0, 250};
    public void init() {
        setSize(1200, 800);
    }
    void circlePlotPoints(int xc, int yc, int x, int y) {
    	raster.setPixel(xc+x, yc+y, array);
    	raster.setPixel(xc-x, yc+y, array);
    	raster.setPixel(xc+x, yc-y, array);
    	raster.setPixel(xc-x, yc-y, array);
    	raster.setPixel(xc+y, yc+x, array);
    	raster.setPixel(xc-y, yc+x, array);
    	raster.setPixel(xc+y, yc-x, array);
    	raster.setPixel(xc-y, yc-x, array);
    }
    void dda(int xcen, int ycen) {
    	double dx, dy, x, y;
        int i,k;
        double xc=0, yc=0;
        int x2[] = {125,275,240,300};
        int y2[] = {266,266,108,200};
        for(i=0; i<4; i++) {
        	dx= xcen-x2[i];
        	dy= ycen-y2[i];
        	double m= dy/dx;
        	if(dx<0)
        		dx= (-1)*dx;
        	if(dy<0)
        		dy= -dy;
        	if(m<=1 && m>=0) {
        		xc= 1;
        		yc= m;
        	}
        	else if(m>=1){
        		xc= 1/m;
        		yc= 1;
        	}
        	else if(m>-1 && m<0) {
        		yc= 1;
        		xc= 1/m;
        	}
        	else if(m<=-1) {
        		xc= 1;
        		yc= m;
        	}
        	if(dx>dy && m<0) {
        		dx= dy;
        	}
        	x= xcen;
        	y= ycen;
        	raster.setPixel((int) Math.round(x), (int) Math.round(y), array);
        	for(k=1; k<=dx; k++) {
        		x+= xc;
        		y+= yc;
        		raster.setPixel((int) Math.round(x), (int) Math.round(y), array);
        	}
        }
    }
    public void paint(Graphics g) {
    	int xCenter= 200;
    	int yCenter= 200;
    	int radius= 100;
    	int x=0;
    	int y= radius;
    	int p= 1-radius;
    	circlePlotPoints(xCenter,yCenter,x,y);
    	while(x<y) {
    		x++;
    		if(p<0) {
    			p+= 2*x+1;
    		}
    		else {
    			y--;
    			p+= 2*(x-y)+1;
    		}
    		System.out.println(x+","+y);
    		circlePlotPoints(xCenter,yCenter,x,y);
    	}
    	g.drawImage(image, 0, 0, this);
    	dda(xCenter,yCenter);
    	g.drawString("Sports", 185, 50);
    	g.drawString("Cricket", 50, 150);
    	g.drawString("55%", 145, 160);
    	g.drawString("Kabaddi", 290, 125);
    	g.drawString("15%", 245, 155);
    	g.drawString("Hockey", 200, 320);
    	g.drawString("20%", 200, 276);
    	g.drawString("Football", 310, 230);
    	g.drawString("10%", 250, 230);
    }
}
