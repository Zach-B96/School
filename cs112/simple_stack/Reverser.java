import java.util.Scanner;

public class Reverser {
    //Zachary Bessette



    public static void main(String[] args) {
	Scanner keyboard = new Scanner(System.in);
	Reverser use;
	use = new Reverser();
	System.out.print("Please enter a string: ");
	String t=keyboard.next();
	String reverse=use.reverse(t);
	System.out.println("The reverse of the string you entered is: "+reverse);

    }



    private String reverse(String t){

	CS112Stack s = new CS112Stack();
	s.initialize(5);

	for(int i=0; i<t.length(); i++){
	    s.push(t.charAt(i));
	}
	String reverse="";
	for(int j=0; j<t.length();j++){
	    reverse=reverse+s.pop();
	}
	return reverse;
    }
}
