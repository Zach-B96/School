public class CS112Stack {
    //Zachary Bessette

    private int count;
    private char[] theStack;
    private boolean debugging = false;

    public void initialize(int i) {
	count = 0;
	theStack = new char[i];
    }

    public void initialize() {
	initialize(100);
    }

    public void push(char c) {
	if (count == theStack.length)
	    doubleIt();
	theStack[count] = c;
	count++;
    }

    public char pop() {
	if (count == 0) {
	    System.out.println("You have tried to pop from an empty stack - "+
			       "program ending");
	    System.exit(1);
	}
	count--;
	return theStack[count];
    }

    private void doubleIt() {
	if (debugging)
	    System.out.println("expanding to "+theStack.length*2);
	
	char[] n = new char[theStack.length*2];
	for (int i=0; i<theStack.length;i++)
	    n[i] = theStack[i];
	theStack = n;
    }

    public boolean empty() {
	return count == 0;
    }

    /*  public String reverse(String s){
	for(int i=0; i<s.length(); i++){
	    push(s.charAt(i));
	}
	String reverse="";
	for(int j=0; j<s.length();j++){
	    reverse=reverse+pop();
	}
	return reverse;
	}*/

    /*    public boolean balanced(String s){
	for(int i=0; i<s.length(); i++){
	    if(s.charAt(i)=='(' ||  s.charAt(i) == '{' || s.charAt(i) == '[')
		push(s.charAt(i));
	    if(s.charAt(i)==')' ||  s.charAt(i) == '}' || s.charAt(i) == ']'){
		if(empty())
		    return false;
		else{
		    char pop = pop();
			if(s.charAt(i)==')'){
			    if(pop=='{' || pop=='[')
				return false;
			}
			else if(s.charAt(i)=='}'){
			    if(pop=='(' || pop=='[')
				return false;
			}
			else if(s.charAt(i)==']'){
			    if(pop=='(' || pop=='{')
				return false;	
			}
		}//else
	    }//if
	}//for
	if(empty())
	    return true;
	else
	    return false;
	    }//balanced*/

}//class
