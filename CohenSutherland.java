//Implementing Cohen Sutherland Line clipping algorithm
import java.applet.*;
import java.awt.*;
import java.awt.image.*;
import java.lang.*;
public class CohenSutherland extends Applet{
	public void paint(Graphics g) {
		int x[]= {400,800,800,400}; //window x
		int y[]= {100,100,400,400}; //window y
		int xmin= 400, ymin= 100;
		int xmax= 800, ymax= 400;
		g.drawPolygon(x,y,4);
		for(int i=0; i<x.length; i++) {
			g.drawString(x[i]+","+y[i], x[i], y[i]);
		}
		int l1[]= {350,350}; //x1,y1
		int l2[]= {750,60}; //x2,y2
		//g.drawLine(l1[0], l1[1], l2[0], l2[1]);
		int p1, p2, and;
		p1= getCode(l1[0],l1[1], xmin, ymin, xmax, ymax);
		System.out.println("Region code 1:"+p1);
		p2= getCode(l2[0],l2[1], xmin, ymin, xmax, ymax);
		System.out.println("Region code 2:"+p2);
		if(p1==0 && p2==0) {
			System.out.println("Interior");
			g.drawLine(l1[0], l1[1], l2[0], l2[1]);
			g.drawString(l1[0]+","+l1[1], l1[0], l1[1]);
			g.drawString(l2[0]+","+l2[1], l2[0], l2[1]);
		}
		else if(p1!=0 && p2!=0) {
			if((p1&p2)!=0)
				System.out.println("Exterior");
			else {
				intersection(l1,l2,xmin,ymin,xmax,ymax,p1,p2,g);
			}
		}
		else if((p1!=0 && p2==0) || (p1==0 && p2!=0))
			intersection(l1,l2,xmin,ymin,xmax,ymax,p1,p2,g);
	}
	public int getCode(int x,int y, int xmin, int ymin, int xmax, int ymax) {
		int top= 8;
		int bottom= 4;
		int left= 1;
		int right= 2;
		int p= 0;
		if(x<=xmin) 
			p= p|left;
		if(x>=xmax)
			p= p|right;
		if(y<=ymin)
			p= p|bottom;
		if(y>=ymax)
			p= p|top;
		return p;
	}
	public void intersection(int line1[], int line2[], int xmin, int ymin, int xmax, int ymax, int p1, int p2, Graphics g) {
		double m= (line2[1]-line1[1])/(double)(line2[0]-line1[0]);
		System.out.println(m);
		int x1=0, x2=0, y1=0, y2=0;
		
		if(p1==8) { //top
			y1= ymax;
			x1= (int)(line1[0]+(ymax-line1[1])/m);
		}
		else if(p1==4) { //bottom
			y1= ymin;
			x1= (int)(line1[0]+(ymin-line1[1])/m);
		}
		else if(p1==2) { //right
			x1= xmax;
			y1= (int)(line1[1]+m*(xmax-line1[0]));
		}
		else if(p1==1) { //left
			x1= xmin;
			y1= (int)(line1[1]+m*(xmin-line1[0]));
		}
		if(p2==8) { //top
			y2= ymax;
			x1= (int)(line1[0]+(ymax-line1[1])/m);
		}
		else if(p2==4) { //bottom
			y2= ymin;
			x2= (int)(line1[0]+(ymin-line1[1])/m);
		}
		else if(p2==2) { //right
			x2= xmax;
			y2= (int)(line1[1]+m*(xmax-line1[0]));
		}
		else if(p2==1) { //left
			x2= xmin;
			y2= (int)(line1[1]+m*(xmin-line1[0]));
		}
		if(p1!=0 && p2==0) {
			g.drawLine(x1,y1,line2[0],line2[1]);
			g.drawString(x1+","+y1, x1, y1);
			g.drawString(line2[0]+","+line2[1], line2[0], line2[1]);
		}
		else if(p1==0 && p2!=0) {
			g.drawLine(x2,y2,line1[0],line1[1]);
			g.drawString(line1[0]+","+line1[1], line1[0], line1[1]);
			g.drawString(x2+","+y2, x2, y2);
		}
		else if(p1!=0 && p2!=0) {
			g.drawLine(x1,y1,x2,y2);
			g.drawString(x1+","+y1, x1, y1);
			g.drawString(x2+","+y2, x2, y2);
		}
	}
}
