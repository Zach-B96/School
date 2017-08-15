import java.awt.event.*;

public class StartListener implements ActionListener{

    private Frame frame;

    public StartListener(Frame run){
	frame=run;
    }

    public void actionPerformed(ActionEvent e){
	frame.getContentPane().removeAll();
	frame.init();
	frame.validate();
	frame.repaint();
    }
}
