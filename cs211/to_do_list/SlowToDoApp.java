public class SlowToDoApp
{
    public static void main(String[] args)
    {
	ToDoList toDo;
	if (args.length > 0 && args[0].equals("1"))
	    {
		toDo = new ToDoList1AL();
	    }
	else
	    {
		toDo = new ToDoList2AL();
	    }

	for (int i = 0; i < 1000000; i++)
	    {
		toDo.add(new Task(1, "Eat " + i + " peas"));
	    }

	while (toDo.isIncomplete())
	    {
		toDo.completeNext();
	    }
    }
}
