//Using the 4-way Boundary Fill algorithm to fill color in a 2D polygon
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.applet.*;
import java.util.*;
public class Fill extends Applet{
	BufferedImage image = new BufferedImage(1200, 800, BufferedImage.TYPE_INT_ARGB);
    WritableRaster raster = image.getRaster();
    int array[]= {0,0,0,255}; //color values for the boundary of the hut
    public void init() {
        setSize(1200, 800);
    }
	public void paint(Graphics g) {
		//using dda to draw the hut
		double dx, dy, x, y;
        int i,k;
        double xc, yc;
        int x1[] = {20,20,20,60,100,20,40,80,40};
        int y1[] = {40,40,40,20,40,80,60,60,60};
        int x2[] = {60,100,20,100,100,100,80,80,40};
        int y2[] = {20,40,80,40,80,80,60,80,80};
        for(i=0;i<x1.length;i++)
        {
        	dx = x2[i]-x1[i];
        	dy = y2[i]-y1[i];
        	if(dx==0)
        	{
        		dx=dy;
        	}
        	double m = dy / dx;
        	if (m <= 1) {
        		xc = 1;
        		yc = m;
        	} else {
        		xc = 1 / m;
        		yc = 1;
        	}
        	x = x1[i];
        	y = y1[i];
        	raster.setPixel((int) Math.round(x), (int) Math.round(y), array);
        	for (k = 1; k <= dx; k++) {
        		if(x1[i]==x2[i])
        		{
        			x=x1[i];
        			y+=yc;
        		}else{
        			x += xc;
        			y += yc;
			}
        		raster.setPixel((int) Math.round(x), (int) Math.round(y), array);
        	}
        }
		int fill_out[]= {255,0,0,255}; //color values for body of the hut
		int fill_gate[]= {175,0,175,255}; //color value for gate of the hut
		int fill_terrace[]= {0,255,0,255}; //color value for terrace of the hut
		int boundary[]= {0,0,0,255}; //color value of the boundary, i.e., black
		boundaryFill4(21,41,fill_out,boundary); //out
		boundaryFill4(41,61,fill_gate,boundary); //gate
		boundaryFill4(41,39,fill_terrace,boundary); //terrace
		g.drawImage(image, 0, 0, this);
	}
	void boundaryFill4(int x, int y, int f[], int b[]) {
		int current[]= new int[4];
		raster.getPixel(x, y, current); //getting the current color values in current[4]
		if(!Arrays.equals(current, b) && !Arrays.equals(current, f)) {
			raster.setPixel(x, y, f);
			boundaryFill4(x+1,y,f,b); //going 1pixel right
			boundaryFill4(x-1,y,f,b); //going 1pixel left
			boundaryFill4(x,y+1,f,b); //going 1pixel down
			boundaryFill4(x,y-1,f,b); //going 1pixel up
		}
	}
}
