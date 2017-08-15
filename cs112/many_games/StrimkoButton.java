import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StrimkoButton extends JButton{//implements ActionListener

    private Color c;
    private String number;
    private int value;
    private boolean set;

    public StrimkoButton(String color){
	if(color.equals("blue"))
	   c=Color.blue;
	else if(color.equals("green"))
	   c=Color.green;
	else if(color.equals("cyan"))
	   c=Color.cyan;
	else if(color.equals("magenta"))
	   c=Color.magenta;
	else if(color.equals("pink"))
	   c=Color.pink;
	else if(color.equals("red"))
	   c=Color.red;
	else if(color.equals("orange"))
	   c=Color.orange;
	set=false;
	value = 0;
	number="0";
    }

    public StrimkoButton(int x, String color){
	set=true;
	if(color.equals("blue"))
	   c=Color.blue;
	else if(color.equals("green"))
	   c=Color.green;
	else if(color.equals("cyan"))
	   c=Color.cyan;
	else if(color.equals("magenta"))
	   c=Color.magenta;
	else if(color.equals("pink"))
	   c=Color.pink;
	else if(color.equals("red"))
	   c=Color.red;
	else if(color.equals("orange"))
	   c=Color.orange;
	value=x;
	number=Integer.toString(x);
	this.setEnabled(false);
    }


    public void paintComponent(Graphics g){

	if(set){
	    super.paintComponent(g);
	    g.setColor(Color.gray);
	    g.fillOval(25,18,60,60);
	    g.setColor(c);
	    g.fillOval(30,22,50,50);
	    g.setColor(Color.black);
	    g.drawString(number,50,50); 
	    this.setBorderPainted(false);
	    this.setContentAreaFilled(false);
	    this.setOpaque(false);
	}
        else{
	    super.paintComponent(g);
	    g.setColor(c);
	    g.fillOval(30,22,50,50);
	    g.setColor(Color.black);
	    g.drawString(number,50,50); 
	    this.setBorderPainted(false);
	    this.setContentAreaFilled(false);
	    this.setOpaque(false);
	} 
  }


    public void set1(){
	value=1;
	number=Integer.toString(value);
    }

    public void set2(){
	value=2;
	number=Integer.toString(value);
    }

    public void set3(){
	value=3;
	number=Integer.toString(value);
    }

    public void set4(){
	value=4;
	number=Integer.toString(value);
    }

    public void set5(){
	value=5;
	number=Integer.toString(value);
    }

    public void set6(){
	value=6;
	number=Integer.toString(value);
    }

    public void set7(){
	value=7;
	number=Integer.toString(value);
    }
}
