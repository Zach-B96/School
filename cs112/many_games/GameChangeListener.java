import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameChangeListener implements ActionListener {

	Frame run;
	
	public GameChangeListener(Frame runner) {
		run = runner;	
	}
	
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Kakurasu")){
		    run.getContentPane().removeAll();
		    run.init1();
		    run.validate();
		    run.repaint();
		}
		if(action.equals("Hitori")){
		    run.getContentPane().removeAll();
		    run.init2();
		    run.validate();
		    run.repaint();
		}
		if (action.equals("Strimko")){
		    run.getContentPane().removeAll();
		    run.init3();
		    run.validate();
		    run.repaint();
		}

	}		
}