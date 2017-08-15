import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class DiamondButton extends JButton implements ActionListener {
	
	private Color c = Color.BLUE;
	
	public DiamondButton(Color c) {
		this.c = c;
		this.addActionListener(this);
	}
	
	/*  
	 * The method paintComponent(Graphics g) is called when
	 * java needs to draw the component
	 */
	public void paintComponent(Graphics g) {
	    super.paintComponent(g);

	        int[] xPoints = new int[10];
		int[] yPoints = new int[10];
		
		xPoints[0] = 50;
		yPoints[0] = 60;
		xPoints[1] = 88;
		yPoints[1] = 52;
		xPoints[2] = 100;
		yPoints[2] = 20;
		xPoints[3] = 112;
		yPoints[3] = 52;
		xPoints[4] = 150;
		yPoints[4] = 60;
		xPoints[5] = 118;
		yPoints[5] = 70;
		xPoints[6] = 125;
		yPoints[6] = 100;
		xPoints[7] = 100;
		yPoints[7] = 82;
		xPoints[8] = 75;
		yPoints[8] = 100;
		xPoints[9] = 82;
		yPoints[9] = 70;
		g.setColor(c);
		//g.fillPolygon(xPoints, yPoints, xPoints.length);
		g.fill3DRect(20,30,20,20,false);
	}

	public void beenHere() {
		c = Color.gray;
		ImageIcon x = new ImageIcon("X.gif");
		// setIcon adds an image to a button
		this.setIcon(x);
		this.setEnabled(false);		
	}
	
	public void actionPerformed(ActionEvent e) {
		beenHere();
	}	
}
