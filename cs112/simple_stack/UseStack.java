public class UseStack {

    public static void main(String[] args) {

	UseStack use;
	use = new UseStack();
	use.go();

    }

    public void go() {

	CS112Stack s = new CS112Stack();
	s.initialize(5);

	for (char i='a'; i<='z';i++)
	    {
		s.push(i);
	    }

	while (!s.empty())
	    {
		System.out.print(s.pop());
	    }

	System.out.println();
    }
}
