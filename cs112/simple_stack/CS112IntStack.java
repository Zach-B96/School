import java.util.Scanner;

public class CS112IntStack {

    private int count;
    private int[] theStack;
    private boolean debugging = false;

    public void initialize(int i) {
	count = 0;
	theStack = new int[i];
    }

    public void initialize() {
	initialize(100);
    }

    public void push(int c) {
	if (count == theStack.length)
	    doubleIt();
	theStack[count] = c;
	count++;
    }

    /*
    public void operator(String s){
	char c = s.charAt(0);
	if(c=='+'){
	    int i=pop();
	    int j=pop();
	    int sum=i+j;
	    push(sum);
	}
	else if(c=='-'){
	    int k=pop();
	    int l=pop();
	    int subtraction=l-k;
	    push(subtraction);
	}
	else if(c=='*'){
	    int m=pop();
	    int n=pop();
	    int mult=m*n;
	    push(mult);
	}
	else if(c=='/'){
	    int o=pop();
	    int p=pop();
	    int divide=p/(o);
	    push(divide);
	}
    }
    public int value(Scanner keyboard){
	while(keyboard.hasNext()){
	    if(keyboard.next()=="=")
		return pop();
	    if(keyboard.hasNextInt())
		push(keyboard.nextInt());
	    else
		operator(keyboard.next());
	}
	return pop();
    }
    */

    public int pop() {
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
	
	int[] n = new int[theStack.length*2];
	for (int i=0; i<theStack.length;i++)
	    n[i] = theStack[i];
	theStack = n;
    }

    public boolean empty() {
	return count == 0;
    }
}
