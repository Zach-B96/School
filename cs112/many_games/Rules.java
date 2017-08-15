import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Rules implements ActionListener{

    private String game;
    private static String newline= System.getProperty("line.separator");

    private String message1="1.Squares are either marked or unmarked." + newline+"2.The clues are on the right and across the bottom and are the totals for the respctive rows and columns."+newline+"3.The numbers across the top and on the left are the values for each of the squares."+newline+"4.Marking a square will add that square's value to both the row's total and the column's total.";

    private String message2="1.Shade some squares so that no unshaded digit is repeated in a row or column."+newline+"2.No shaded square can touch any other shaded square horizonatlly or vertically (but they may touch diagonally)."+newline+"3.You must be able to 'travel' from any unshaded square to any other unshaded square simply by moving left/right/up/down from unshaded square to unshaded square.";

    private String message3="1.The spots are filled in with numbers from 1 to 7."+newline+"2.All of the numbers in each row must be unique."+newline+"3.All of the numbers in each column must be unique"+newline+"4.All of the numbers in each stream must be unique."+newline+"5.Streams are represented by color. Buttons of the same color belong in the same string."+newline+"6.Buttons surrounded in gray are set values for the game and cannot be changed.";

    public Rules(String game1){
	game=game1;
    }

    public void actionPerformed(ActionEvent e){

	if(game.equals("Kakurasu")){
	    JFrame rules = new JFrame("Rules");
	    JOptionPane optionPane = new JOptionPane();
	    optionPane.showMessageDialog(rules, message1);
	}
	if(game.equals("Hitori")){
	    JFrame rules = new JFrame("Rules");
	    JOptionPane optionPane = new JOptionPane();
	    optionPane.showMessageDialog(rules, message2);
	}
	if(game.equals("Strimko")){
	    JFrame rules = new JFrame("Rules");
	    JOptionPane optionPane = new JOptionPane();
	    optionPane.showMessageDialog(rules, message3);
	}
    }
}
