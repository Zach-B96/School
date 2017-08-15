import java.util.Scanner;

public class Parentheses {
    //Zachary Bessette

    public static void main(String[] args) {
	
	Scanner keyboard = new Scanner(System.in);
	Parentheses use;
	use = new Parentheses();
	System.out.print("Please enter a string with parentheses: ");
	String t=keyboard.next();
	if(use.balanced(t))
	    System.out.println("The string you entered has matching parentheses");
	else
	    System.out.println("Your parentheses do not match.");


    }


    private boolean balanced(String t) {

	CS112Stack s = new CS112Stack();
	s.initialize(5);

	for(int i=0; i<t.length(); i++){
	    if(t.charAt(i)=='(' ||  t.charAt(i) == '{' || t.charAt(i) == '[')
		s.push(t.charAt(i));
	    if(t.charAt(i)==')' ||  t.charAt(i) == '}' || t.charAt(i) == ']'){
		if(s.empty())
		    return false;
		else{
		    char pop = s.pop();
			if(t.charAt(i)==')'){
			    if(pop=='{' || pop=='[')
				return false;
			}
			else if(t.charAt(i)=='}'){
			    if(pop=='(' || pop=='[')
				return false;
			}
			else if(t.charAt(i)==']'){
			    if(pop=='(' || pop=='{')
				return false;	
			}
		}//else
	    }//if
	}//for
	if(s.empty())
	    return true;
	else
	    return false;
    }//balanced
}
