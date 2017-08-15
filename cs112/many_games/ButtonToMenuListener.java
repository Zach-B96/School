import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class ButtonToMenuListener implements ActionListener {

	private JButton myButton;
	JPopupMenu  menu;
	
	public ButtonToMenuListener(Frame runner, JButton clicker) {
		myButton = clicker;
		
		// create a popup menu
		menu = new JPopupMenu("Menu");
		GameChangeListener run = new GameChangeListener(runner);
		
        // create a menu item
		JMenuItem game1 = new JMenuItem("Kakurasu");
        // add the menu item to the menu
		menu.add(game1);
        // add a listener to the menu item
		game1.addActionListener(run);
        
		JMenuItem game2 = new JMenuItem("Hitori");
		menu.add(game2);
		game2.addActionListener(run);

		JMenuItem game3 = new JMenuItem("Strimko");
		menu.add(game3);
		game3.addActionListener(run);

		menu.add(new JMenuItem("Never Mind"));        
	}

	public void actionPerformed(ActionEvent e) {
		
		menu.show(myButton,myButton.getWidth()/2,myButton.getHeight()/2);
	}
}
