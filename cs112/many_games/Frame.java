//import javax.swing.BoxLayout;
import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {

    private Container contentPane;

    public void init(){

	contentPane=getContentPane();
	contentPane = this.getContentPane();
	//contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
	contentPane.setLayout(new GridLayout(8,1));
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	JButton changer = new JButton("Play Game");
	ButtonToMenuListener fl = new ButtonToMenuListener(this,changer);
	contentPane.add(new JLabel("Hi, Welcome to my game!"));
	contentPane.add(new JLabel("If you would like to play, just click the button."));
	contentPane.add(new JLabel("The rest will take care of itself."));
	contentPane.add(changer);


	changer.addActionListener(fl);
    }

    public void init1(){
	RunFrame frame = new RunFrame();
	frame.init1();
	frame.pack();
	frame.setVisible(true);
	frame.setSize(new Dimension(800,800));
    }

    public void init2(){
	HitoriFrame frame1 = new HitoriFrame();
	frame1.init2();
	frame1.pack();
	frame1.setVisible(true);
	frame1.setSize(new Dimension(800,800));

    }

    public void init3(){
	StrimkoFrame frame2 = new StrimkoFrame();
	frame2.init3();
	frame2.pack();
	frame2.setVisible(true);
	frame2.setSize(new Dimension(800,800));

    }
}