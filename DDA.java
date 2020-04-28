//Drawing a 2D bar chart using DDA algorithm 
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.applet.*;
import java.util.*;

public class DDA extends Applet {

    BufferedImage image = new BufferedImage(1200, 700, BufferedImage.TYPE_INT_ARGB);
    WritableRaster raster = image.getRaster();
    int array[] = {5000, 0,0 , 5000};

    public void init() {
        setSize(800, 800);
    }

    public void paint(Graphics g) {
        double dx, dy, x, y;
        int i,k;
        double xc, yc;
        int x1[] = {100, 100,200,200,300,400,400,500};
        int y1[] = {50, 600,450, 450,450,300,300,300};
        int x2[] ={100, 1000,200, 300,300,400,500,500};
        int y2[] = {600, 600,600,450,600,600,300,600};
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
		}
	    else
	    {
	    	x += xc;
            y += yc;
        }
        raster.setPixel((int) Math.round(x), (int) Math.round(y), array);
        }
        }
        g.drawString("Y", 98, 50);
        g.drawString("X", 1000, 605);
        g.drawString("300", 80, 300);
        g.drawString("450", 80, 450);
        g.drawString("(100,600)", 80, 600);
        g.drawString("200", 200, 620);
        g.drawString("marks",250,650);
        g.drawString("300", 300, 620);
        g.drawString("400", 400, 620);
        g.drawString("percent",450,620);
        g.drawString("500", 500, 620);
        g.drawImage(image, 0, 0, this);
    }
}