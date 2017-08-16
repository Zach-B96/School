import java.util.Scanner;

/**
 * A simple to-do list app (imagine that we have a nice touch screen
 * interface for this).  Reads tasks from standard input in the form
 *
 * 3 comment this class
 *
 * and then commands: c for complete, d for delay, p for postpone
 *
 * @author Jim Glenn
 * @version 0.1 2017-01-26
 */

public class ToDoApp
{
    public static void main(String[] args)
    {
	// prepare to read standard input
	Scanner in = new Scanner(System.in);

	// make ourselves an empty to-do list
	ToDoList toDo;
	if (args.length > 0 && args[0].equals("1"))
	    {
		toDo = new ToDoList1AL();
	    }
	else
	    {
		toDo = new ToDoList2AL();
	    }

	// read tasks from standard input
	System.out.println("Enter tasks (time description); x to end");
	while (in.hasNextInt())
	    {
		// read time and then description separated by whitespace
		int time = in.nextInt();
		String description = in.nextLine().trim();

		// add new task to this list
		toDo.add(new Task(time, description));
	    }
	in.next();

	// print the list; I hope it is not too daunting
	System.out.println(toDo);

	// display next task
	if (toDo.isIncomplete())
	    {
		System.out.println("Next: " + toDo.getNext());
		System.out.println("Total Time: " + toDo.totalTimeRemaining());
	    }

	// read commands until we give up or complete all our tasks
	while (toDo.isIncomplete() && in.hasNext())
	    {
		// read and perform command
		String command = in.next();
		if (command.equals("c"))
		    {
			toDo.completeNext();
		    }
		else if (command.equals("d"))
		    {
			toDo.delayNext();
		    }
		else if (command.equals("p"))
		    {
			toDo.postponeNext();
		    }

		// display next task if there still is one
		if (toDo.isIncomplete())
		    {
			System.out.println("Next: " + toDo.getNext());
			System.out.println("Total Time: " + toDo.totalTimeRemaining());
		    }
	    }

	// show our final to-do list
	System.out.println(toDo);
    }
}
