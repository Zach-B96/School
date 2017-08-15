import java.util.Scanner;

public class PostFixEval {
    //Zachary Bessette

    private CS112IntStack t = new CS112IntStack();
    private boolean stop;

    public static void main(String[] args) {

	PostFixEval use;
	use = new PostFixEval();
	use.go();

    }

    public void go (){


	t.initialize(5);

	Scanner keyboard = new Scanner(System.in);
	System.out.println("Please enter an expression and I shall evaluate it.");
	stop=true;
	int answer=value(keyboard);

	System.out.println("The answer is: "+answer);

    }


    public void operator(String s){

	char c = s.charAt(0);

	if(c=='+'){
	    int i=t.pop();
	    int j=t.pop();
	    int sum=i+j;
	    t.push(sum);
	}

	else if(c=='-'){
	    int k=t.pop();
	    int l=t.pop();
	    int subtraction=l-k;
	    t.push(subtraction);
	}

	else if(c=='*'){
	    int m=t.pop();
	    int n=t.pop();
	    int mult=m*n;
	    t.push(mult);
	}

	else if(c=='/'){
	    int o=t.pop();
	    int p=t.pop();
	    int divide=p/(o);
	    t.push(divide);
	}
	else{
	    stop=false;
	}


    }

    public int value(Scanner keyboard){

	while(stop){
	    if(keyboard.hasNextInt())
		t.push(keyboard.nextInt());
	    else
		operator(keyboard.next());
	}
	return t.pop();
    }
}
