import java.util.Scanner;

class MyLibrary {

    /* A book loan system to keep track of my books!
       Zachary Bessette, 10/23/2015   */

    public static Scanner keyboard = new Scanner(System.in);
    public static Scanner keyboard2 = new Scanner(System.in);
    /*I had to create a second scanner because the first alone would not
      allow me to enter multiple words as the title of a book and created 
      an InputMismatchException. Seperating the scanner for integers and
      the scanner for Strings solves this problem */
    
    public static void main(String[] args) {
	
	System.out.println("Welcome to my library");
	System.out.println();
	
	/* Initialize book objects */

	Book b1 = new Book("War and Peace", "Leo Tolstoy", 1869);
	Book b2 = new Book("A Tale of Two Cities", "Charles Dickens", 1859);
	Book b3 = new Book("Babbitt", "Sinclair Lewis", 1922);
	Book b4 = new Book("Fox in Socks", "Dr. Seuss", 1965);
	Book b5 = new Book("Java Programming", "Lyle A. McGeoch", 2012);

	Book [] b = {b1,b2,b3,b4,b5};

	printBooks(b1,b2,b3,b4,b5);

	
	int userInput = getUserInput();

	while (userInput != 0) {
	    if (userInput == 1) {

		printStatus(b);//makes clear what books can be lent
		System.out.println("Which book would you like to loan?" +
				   " Enter 1-5");
		int book = keyboard.nextInt();
		while (book < 1 || book > 5) {
		    System.out.println("Please enter a value between 1 - 5:");
		    book = keyboard.nextInt();
		}
		System.out.println("Who is going to be borrowing the book?");
		String name = keyboard.next();
		if (book == 1) {
		    if (!b1.loan(name))
			System.out.println(b1.getTitle() + " is already on loan");
		} else if (book == 2) {
		    if (!b2.loan(name))
			System.out.println(b2.getTitle() + " is already on loan");
		} else if (book == 3) {
		    if (!b3.loan(name))
			System.out.println(b3.getTitle() + " is already on loan");
		} else if (book == 4) {
		    if (!b4.loan(name))
			System.out.println(b4.getTitle() + " is already on loan");
		} else {
		    if (!b5.loan(name))
			System.out.println(b5.getTitle() + " is already on loan");
		}
		userInput = getUserInput();
	    }//loaning book to someone

	    else if(userInput == 2){

		printStatus(b);//makes clear the number for books
		System.out.println("Which book are you receiving?" +
				   " Enter 1 - 5.");
		int book = keyboard.nextInt();
		while (book < 1 || book > 5) {
		    System.out.println("Please enter a value between 1 - 5:");
		    book = keyboard.nextInt();
		}
		if (book == 1) {
		    if (!b1.receive())
			System.out.println(b1.getTitle() + " was not on loan");
		    else
			System.out.println("The book has been received.");
		} else if (book == 2) {
		    if (!b2.receive())
			System.out.println(b2.getTitle() + " was not on loan");
		    else
			System.out.println("The book has been received.");
		} else if (book == 3) {
		    if (!b3.receive())
			System.out.println(b3.getTitle() + " was not on loan");
		    else
			System.out.println("The book has been received.");
		} else if (book == 4) {
		    if (!b4.receive())
			System.out.println(b4.getTitle() + " was not on loan");
		    else
			System.out.println("The book has been received.");
		} else {
		    if (!b5.receive())
			System.out.println(b5.getTitle() + " was not on loan");
		    else
			System.out.println("The book has been received.");
		}
		userInput = getUserInput();
	    
	
	} //receive a book

	else if(userInput == 3){//allows user to correct information

	    printBooks(b1,b2,b3,b4,b5);
	    System.out.println("Which book would you like to adjust the information for?");
	    int book = keyboard.nextInt();//get the book the user wants to fix
		while (book < 1 || book > 5) {
		    System.out.println("Please enter a value between 1 - 5:");
		    book = keyboard.nextInt();
		}
		System.out.println();
		System.out.println("To adjust the title of the book, enter 1.");
		System.out.println("To adjust the author of the book, enter 2.");
		System.out.println("To ajust the publication year of the book, enter 3");
		//see what the user wants to fix
		int adjust = keyboard.nextInt();
		while(adjust < 1 || adjust > 3){
		    System.out.println("Please enter a value between 1 and 3.");
		    adjust = keyboard.nextInt();
		}
		System.out.println();

		if(adjust == 1){//adjusting author
		    if(book == 1){
			System.out.println("What would you like to change the title of '"+b1.getTitle()+"' to?");
			String newTitle = keyboard2.nextLine();//new title enter
			b1.setTitle(newTitle);//reset title
			System.out.println("The new title is '"+b1.getTitle()+"'.");
	       	    }
		    else if(book == 2){
			System.out.println("What would you like to change the title of '"+b2.getTitle()+"' to?");
			String newTitle = keyboard2.nextLine();//new title enter
			b2.setTitle(newTitle);//reset title
			System.out.println("The new title is '"+b2.getTitle()+"'.");
		    }
		    else  if(book == 3){
			System.out.println("What would you like to change the title of '"+b3.getTitle()+"' to?");
			String newTitle = keyboard2.nextLine();//new title enter
			b3.setTitle(newTitle);//reset title
			System.out.println("The new title is '"+b3.getTitle()+"'.");
		    }
		    else  if(book == 4){
			System.out.println("What would you like to change the title of '"+b4.getTitle()+"' to?");
			String newTitle = keyboard2.nextLine();//new title enter
			b4.setTitle(newTitle);//reset title
			System.out.println("The new title is '"+b4.getTitle()+"'.");
		    }
		    else{
			System.out.println("What would you like to change the title of '"+b5.getTitle()+"' to?");
			String newTitle = keyboard2.nextLine();//new title enter
			b5.setTitle(newTitle);//reset title
			System.out.println("The new title is '"+b5.getTitle()+"'.");
		    }
	    
		}//adjust title

		else if(adjust == 2){//allows user to adjust the author of a book
		    if(book == 1){
			System.out.println("Who would you like to change the author of '"+b1.getTitle()+"' to?");
			String newAuthor = keyboard2.nextLine();//new author
			b1.setAuthor(newAuthor);//reset author
			System.out.println("The new author is "+b1.getAuthor()+".");
	       	    }
		    else if(book == 2){
			System.out.println("Who would you like to change the author of '"+b2.getTitle()+"' to?");
			String newAuthor = keyboard2.nextLine();//new author
			b2.setAuthor(newAuthor);//reset author
			System.out.println("The new author is "+b2.getAuthor()+".");
		    }
		    else if(book == 3){
			System.out.println("Who would you like to change the author of '"+b3.getTitle()+"' to?");
			String newAuthor = keyboard2.nextLine();//new author
			b3.setAuthor(newAuthor);//reset author
			System.out.println("The new author is "+b3.getAuthor()+".");
		    }
		    else if(book == 4){
			System.out.println("Who would you like to change the author of '"+b4.getTitle()+"' to?");
			String newAuthor = keyboard2.nextLine();//new author
			b4.setAuthor(newAuthor);//reset author
			System.out.println("The new author is "+b4.getAuthor()+".");
		    }
		    else{
			System.out.println("Who would you like to change the author of '"+b5.getTitle()+"' to?");
			String newAuthor = keyboard2.nextLine();//new author
			b5.setAuthor(newAuthor);//reset author
			System.out.println("The new author is "+b5.getAuthor()+".");
		    }
		}//adjust author

		else{//allows the user to correct a book's publication year
		    if(book == 1){
			System.out.println("What would you like to change the publication year of '"+b1.getTitle()+"' to?");
			int newYear = keyboard.nextInt();//new publication year
			b1.setPubYear(newYear);//reset year
			System.out.println("The new publication year is "+b1.getPubYear()+".");
	       	    }
		    else if(book == 2){
			System.out.println("What would you like to change the publication year of '"+b2.getTitle()+"' to?");
			int newYear = keyboard.nextInt();//new publication year
			b2.setPubYear(newYear);//reset year
			System.out.println("The new publication year is "+b2.getPubYear()+".");
	       	    }
		    else if(book == 3){
			System.out.println("What would you like to change the publication year of '"+b3.getTitle()+"' to?");
			int newYear = keyboard.nextInt();//new publication year
			b3.setPubYear(newYear);//reset year
			System.out.println("The new publication year is "+b3.getPubYear()+".");
	       	    }
		    else if(book == 4){
			System.out.println("What would you like to change the publication year of '"+b4.getTitle()+"' to?");
			int newYear = keyboard.nextInt();//new publication year
			b4.setPubYear(newYear);//reset year
			System.out.println("The new publication year is "+b4.getPubYear()+".");
	       	    }
		    else{
			System.out.println("What would you like to change the publication year of '"+b5.getTitle()+"' to?");
			int newYear = keyboard.nextInt();//new publication year
			b5.setPubYear(newYear);//reset year
			System.out.println("The new publication year is "+b5.getPubYear()+".");
	       	    }
		}//adjust Publication year

		userInput = getUserInput();
	}//adjust info (total)

      
	else if(userInput == 4){//allows user to see how many times a book has 
	                        //been lent.

	    printBooks(b1,b2,b3,b4,b5);
	    System.out.println("For which book would you like to know the number of times it has been lent?");
	    int book = keyboard.nextInt();
		while (book < 1 || book > 5) {
		    System.out.println("Please enter a value between 1 - 5:");
		    book = keyboard.nextInt();
		}

		if(book == 1){
		    System.out.println("'"+b1.getTitle()+"' has been lent out "+b1.timesLoaned()+" times.");//prints times lent
		}
		else if(book == 2){
		    System.out.println("'"+b2.getTitle()+"' has been lent out "+b2.timesLoaned()+" times.");//prints times lent
		}
		else if(book == 3){
		    System.out.println("'"+b3.getTitle()+"' has been lent out "+b3.timesLoaned()+" times.");//prints times lent
		}
		else if(book == 4){
		    System.out.println("'"+b4.getTitle()+"' has been lent out "+b4.timesLoaned()+" times.");//prints times lent
		}
		else{
		    System.out.println("'"+b5.getTitle()+"' has been lent out "+b5.timesLoaned()+" times.");//prints times lent
		}
	    userInput = getUserInput();
	}//Number of times lent
	

	else{
	    System.out.println("Please enter a valid number");
	    userInput = getUserInput();
	}



	}
	System.out.println("Goodbye. Please come again!");//logoff message
	
    } // main


    //prints the names of the books and if they are loaned out
    public static void printStatus(Book [] b) {
	System.out.println();
	System.out.println("I have the following books: \n");
	System.out.println("Book 1: " + b[0]);
	if (b[0].isLoaned())
	    System.out.println("\t Is on loan to " + b[0].loanedTo());

	System.out.println("Book 2: " + b[1]);
	if (b[1].isLoaned())
	    System.out.println("\t Is on loan to " + b[1].loanedTo());

	System.out.println("Book 3: " + b[2]);
	if (b[2].isLoaned())
	    System.out.println("\t Is on loan to " + b[2].loanedTo());

	System.out.println("Book 4: " + b[3]);
	if (b[3].isLoaned())
	    System.out.println("\t Is on loan to " + b[3].loanedTo());

	System.out.println("Book 5: " + b[4]);
	if (b[4].isLoaned())
	    System.out.println("\t Is on loan to " + b[4].loanedTo());

	System.out.println();

    } // printStatus
    

    //prints the title, author, and publication year of the books
    public static void printBooks(Book b1,Book b2,Book b3,Book b4,Book b5) {
	System.out.println();
	System.out.println("I have the following books: \n");
	System.out.println("Book 1: " + b1);
	System.out.println("Book 2: " + b2);
	System.out.println("Book 3: " + b3);
	System.out.println("Book 4: " + b4);	  
	System.out.println("Book 5: " + b5);
	System.out.println();
    } // printBooks
    
    //asks user their desired action within the program
    public static int getUserInput() {
	int i;
	do {
	    System.out.println("What would you like to do?");
	    System.out.println();
	    System.out.println("To loan a book to someone, enter 1.");
	    System.out.println("To receive a book back from loan, enter 2.");
	    System.out.println("To adjust the author,title, or publication year of a book, enter 3");
	    System.out.println("To see how many times a book has been lent, enter 4");
	    System.out.println("To quit, enter 0.");
	    i = keyboard.nextInt();
	    System.out.println();
	} while (i < 0 || i > 4);
	return i;
    } // getUserInput
	

} // class
