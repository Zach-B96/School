import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton{//implements ActionListener

    private Color c;


    public Button(){
	c=Color.white;
    }


    /*public Button(String s){
	c=Color.white;
	this.setText(s);
	}*/

    public void paintComponent(Graphics g){
	super.paintComponent(g);
	if(c.equals(Color.cyan)){
		g.setColor(c);
		g.fill3DRect(0,0,0,0,false);
	}
	else if(c.equals(Color.white)){
	}
	else{
		g.setColor(c);
		//g.fill3DRect(40,30,20,20,false);
		g.fill3DRect(0,0,200,200,false);
	}
    }

    /* public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	if(action.equals("Set"))
	   beenHere();
	if(action.equals("Unset"))
	    return;
	    }*/

    public void setHere(){
	c=Color.cyan;
	ImageIcon x = new ImageIcon("X.gif");
	this.setIcon(x);
	//this.setEnabled(false);
	//this.setEnabled(true);
	}

    public void unsetHere(){
	c=Color.lightGray;
	ImageIcon x = new ImageIcon();
	this.setIcon(x);
	//this.setEnabled(false);
	//this.setEnabled(true);
    }
}
