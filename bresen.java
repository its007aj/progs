//Drawing a straight line using Bresenhem Line drawing algorithm
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import java.applet.*;
import java.util.*;

public class bresen extends Applet {
    BufferedImage image = new BufferedImage(1200, 800, BufferedImage.TYPE_INT_ARGB);
    WritableRaster raster = image.getRaster();
    int array[] = {0, 0, 0, 255};
        public void init() {
        setSize(1200, 800);
    }
    public void paint(Graphics g)
    {
        int dx, dy, p, x, y,x0=100,y0=100,x1=500,y1=500;  
        dx=x1-x0;  
        dy=y1-y0;  
        x=x0;  
        y=y0;  
        p=2*dy-dx; 
        g.drawString(x0+","+y0, 100,100);
        g.drawString(x1+","+y1,500,500);
        System.out.println(x+","+y);
        while(x<x1)  
        {  
            if(p>0)  
            {  
                raster.setPixel(x,y,array);  
                y=y+1; 
                x= x+1;
                p=p+2*dy-2*dx; 
                System.out.println(x+","+y);
            }  
            else  
            {  
                raster.setPixel(x,y,array);  
                p=p+2*dy;
                x=x+1;
                System.out.println(x+","+y);
            } 
        }
         g.drawImage(image, 0, 0, this);
    } 

}


// <applet code="bresen" width="1200" height="800"></applet>