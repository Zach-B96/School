import java.awt.*;

import javax.swing.JPanel;

//
// JPanels are useful as components to draw on
//

public class DisplayPanel extends JPanel {
	
    private Color col;
    private Color col2;

	public DisplayPanel() {
		// set size, otherwise Java will assume 0 x 0 and component may disappear
		setPreferredSize(new Dimension(300,300));
	    col2 = makeRandomColor();

	}


	public void randomSet() {
	    
	    col = makeRandomColor();
	    
	}
/*
 * This method is called whenever java wants to draw the panel
 * 
 */
	public void paintComponent(Graphics g) {


		g.setColor(col);
		
		g.drawString("Your First GUI Program",50,50);
		
		g.setColor(col2);

		g.fillOval(10,10,60,20);

		g.drawLine(50,55,200,55);

		g.fill3DRect(70,90,20,5,true);

		g.fillArc(50,100,60,35,180,180);

		g.drawRoundRect(50,80,20,20,8,8);
		g.drawRoundRect(90,80,20,20,8,8);

		int[] xPoints = new int[3];
		int[] yPoints = new int[3];
		
		xPoints[0] = 75;
		yPoints[0] = 110;
		xPoints[1] = 80;
		yPoints[1] = 100;
		xPoints[2] = 85;
		yPoints[2] = 110;

		g.fillPolygon(xPoints, yPoints, xPoints.length);

		g.drawOval(40,65,80,80);
	}

// Math.random() returns a number between 0 and 1
	
	private Color makeRandomColor() {
		int red = (int) (Math.random()*255);
		int green = (int) (Math.random()*255);
		int blue = (int) (Math.random()*255);

		Color col = new Color(red,green,blue);
		return col;
	}

}