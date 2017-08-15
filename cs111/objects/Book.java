class Book {

    // This class represents a book object.
    // Zachary Bessette, 10/23/2015

    /* Instance variables */
    private String title;
    private String author;
    private int publicationYear;
    private boolean onLoan; // Whether you've loaned the book to someone
    private String loanedTo; // Name of who you've loaned it to
    private int loanCount;

    /* Constructor */
    /* Initializes title, author, publicationYear, onLoan, and loanCount */
    public Book(String t, String a, int y) {
	title = t;
	author = a;
	publicationYear = y;
	onLoan = false;
	loanCount = 0;
    }//Book

    /* Public methods */

    //returns the title, author, and punlication year of a book
    public String toString() {
	String s = title + ", by " + author + " (" + publicationYear + ")";
	return s;
    }//toString
    
    //returns the title of the book
    public String getTitle() {
	return title;
    }//getTitle

    //resets the Title of the book
    public void setTitle(String t) {
	title = t;
    }//setTitle

    //returns the author of the book
    public String getAuthor() {
	return author;
    }//getAuthor

    //resets the author of a book
    public void setAuthor(String a) {
	author = a;
    }//setAuthor

    //returns the year the book was published
    public int getPubYear() {
	return publicationYear;
    }//getPubYear

    //resets the publication year of a book
    public void setPubYear(int y) {
	publicationYear = y;
    }//setPubYear
    
    /* If the book has already been loaned out, returns false.
       If not, loans the book to name and returns true. In order
       to loan the book, we need to update 3 instance variables:
       onLoan, loanedTo, and loanCount. */
    public boolean loan(String name) {
	if(onLoan == true)
	    return false;
	else{
	    onLoan = true;
	    loanedTo = name;
	    loanCount++;
	    return true;
	}	
    } // loan

    /* If the book is on loan, returns true.  If not, returns false. 
       Once we receive a book, we update onLoan and loanedTo. */
    public boolean receive() {
	if(onLoan == true){
	    onLoan = false;
	    loanedTo = "";
	    return true;
	}
	else
	    return false;
    } // receive

    //gets whether or not the book is on loan
    public boolean isLoaned() {
	return onLoan;
    }//isLoaned

    //returns the number of times the book has been loaned
    public int timesLoaned() {
	return loanCount;
    }//timesLoaned

    //returns who a book is loaned to
    public String loanedTo() {
	if(onLoan == false)
	    return "nobody";
	else
	    return loanedTo;
    }//loanedTo

} // class
