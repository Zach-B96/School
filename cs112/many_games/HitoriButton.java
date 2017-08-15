import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class HitoriButton extends JButton{//implements ActionListener

    private Color c;
    private String number;

    public HitoriButton(String s){
	c=Color.cyan;
	number=s;
	this.setText(s);
    }

    public void paintComponent(Graphics g){
	super.paintComponent(g);

		g.setColor(c);
		g.fill3DRect(0,0,160,150,false);
		g.setColor(Color.black);
		g.drawString(number,75,60);
    }


    public void setHere(){
	c=Color.gray;
	//ImageIcon x = new ImageIcon("X.gif");
	//ImageIcon x = new ImageIcon("gray.png");
	//this.setIcon(x);
	//this.setEnabled(false);
	}

    public void unsetHere(){
	c=Color.white;
	//ImageIcon x = new ImageIcon("Circle.jpg");
	//ImageIcon x = new ImageIcon("white.jpg");
	//this.setIcon(x);
	//this.setEnabled(false);
    }
}
