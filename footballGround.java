//Drawing a football Ground in Java using in-built functions
import java.applet.*;
import java.awt.Color;
import java.awt.Graphics;

public class footballGround extends Applet {
	public void paint(Graphics g) {
	/*	g.drawLine(330, 330, 200, 330);
		g.drawLine(330, 230, 330, 330);
		g.drawLine(200, 330, 200, 230);
		g.drawLine(200, 230, 330, 230);
	*/	
		//g.drawRect(100, 200, 400, 300);
		g.setColor(Color.green);
		g.fillRect(50, 50, 1100, 500);
		g.setColor(Color.black);
		g.drawString("Football Game", 550, 75);
		g.setColor(Color.blue);
		g.fillRect(100,100,1000,400);
		g.setColor(Color.black);
		g.drawRect(100, 200, 150, 200);
		g.drawRect(950, 200, 150, 200);
		g.setColor(Color.white);
		g.fillRect(100, 230, 50, 140);
		g.setColor(Color.white);
		g.fillRect(1050, 230, 50, 140);
		g.setColor(Color.black);
		g.drawLine(600, 100, 600, 500);
		g.drawOval(570, 270, 60, 60);
		g.fillOval(180, 300, 10, 10);
		g.fillOval(1010, 300, 10, 10);
		g.drawArc(225, 280, 50, 50, 270, 180);
		g.drawArc(925, 280, 50, 50, 90, 180);
		
	}
}