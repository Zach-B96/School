import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BadSpotHandler implements ActionListener {

	private TheGame g;
	private Lab7Frame frame;
	
	public BadSpotHandler(TheGame game1,Lab7Frame fr) {
		g = game1;
		frame = fr;
	}

	public void actionPerformed(ActionEvent e) {
	    if(!g.clear()){
		g.spot();
		g.setClear();
		if (g.getDoneMessage() != null)
			frame.setDoneMessage(g.getDoneMessage());
		// ask for the Lab7Frame to be repainted
		frame.repaint();
	    }
	    else{
		g.badSpot();
		if (g.getDoneMessage() != null)
			frame.setDoneMessage(g.getDoneMessage());
		frame.repaint();
	    }
	}
}
