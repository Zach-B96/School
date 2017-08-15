import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;


public class ButtonMenu implements ActionListener {

	private JButton myButton;
	JPopupMenu  menu;
	
    public ButtonMenu(JButton clicker, TheGame g1, Frame runner, int x,String game) {

	
	myButton = clicker;
	
	menu = new JPopupMenu("Menu");
	
	
	SpotHandler spot = new SpotHandler(g1,runner,x,game);
	ButtonSet but= new ButtonSet((Button)clicker,game);
	
	JMenuItem set = new JMenuItem("Set");
	menu.add(set);
	set.addActionListener(spot);
	set.addActionListener(but);
	
	JMenuItem unset = new JMenuItem("Unset");
	menu.add(unset);
	unset.addActionListener(spot);
	unset.addActionListener(but);
	
	JMenuItem nvm = new JMenuItem("Never Mind");
	menu.add(nvm);
	unset.addActionListener(but);
    }


    public ButtonMenu(HitoriButton clicker, TheGame g1, Frame runner, int x,String game) {
	
	
	myButton = clicker;
	
	menu = new JPopupMenu("Menu");
	

	SpotHandler spot = new SpotHandler(g1,runner,x,game);
	ButtonSet but= new ButtonSet(clicker,game);
	
	JMenuItem set = new JMenuItem("Set");
	menu.add(set);
	set.addActionListener(spot);
	set.addActionListener(but);

	JMenuItem unset = new JMenuItem("Unset");
	menu.add(unset);
	unset.addActionListener(spot);
	unset.addActionListener(but);

	JMenuItem nvm = new JMenuItem("Never Mind");
	menu.add(nvm);
	unset.addActionListener(but);  
    }
    
	public void actionPerformed(ActionEvent e) {
		
	    menu.show(myButton,myButton.getWidth()/2,myButton.getHeight()/2);
	}
}
