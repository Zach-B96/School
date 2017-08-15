import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

class SudokuChecker {
    /* Class to check the correctness of a solution 
     * to a Sudoku puzzle. 
     *
     * Zachary Bessette, 11/13/2015
     */

    
    public static void main(String[] args) {

	/* 
	 *  The filename containing Sudoku solutions is entered on the command line when the program is run.
	 *  For example, if we want to read in the Sudoku solutions in a file called sudoku_1.txt, the
	 *  program should be run with:
	 *
	 *               java SudokuChecker sudoku_1.txt
	 *
	 *  The 'filename' variable will get assigned the String value the User enters on the command line.
	*/
	String filename;
	if (args.length < 1) {
	    System.out.println("Error: no filename indicated.");
	    System.out.println("Usage: 'java SudokuChecker <filename>'");
	    System.exit(1);
	}
	filename = args[0];

	// Create a Scanner object from the file whose name is stored in the 'filename'
	// variable
	Scanner infile = openFile(filename);


	// Read in each of the 2-D arrays (grids) of integers from the file, one at a time.
	// For each 2-D array, call checkRows(), checkCols(), and checkAllSubGrids()
	// to determine whether the array violates any of the rules describing a valid
	// Sudoku solution.
	// Print each grid followed by a message indicating that the grid is valid or a
	// message or multiple messages indicating that the grid is not valid because of
	// a row, column, and/or subgrid.

	//  ---------- TO DO -----------------
	
	boolean rowValid = true;//boolean to hold whether the rows are valid
	boolean colValid = true;//boolean to hold whether the columns are valid
	boolean subGridValid = true;//boolean to hold whether the subgrids are valid
	boolean correct = true;//boolean to hold whether the whole sudoku puzzle is valid
	int [][] sudoku = new int [9][9];//matrix of the sudoku puzzle, changed each time through the loop

	while(infile.hasNextInt()){//runs while there is another interger (i.e. another sudoku puzzle)
	    sudoku = readInMatrix(infile);//makes the matrix into the one passed in from the file
	    rowValid = checkRows(sudoku);//checks if rows are valid
	    subGridValid = checkAllSubGrids(sudoku);//checks if sub grids are valid
	    colValid = checkCols(sudoku);//checks if columns are valid
	    printMatrix(sudoku);//prints the matrix
	    if(rowValid == false){//runs if the rows are not valid
		System.out.println("Grid is invalid because of a row.");
		correct=false;
	    }
	    if(colValid == false){//runs if the columns are not valid
		System.out.println("Grid is invalid because of a column.");
		correct=false;
	    }
	    if(subGridValid == false){//runs if the sub grids are not valid
		System.out.println("Grid is invalid because of a subgrid.");
		correct=false;
	    }
	    if(correct)//runs if the whole puzzle is valid
		System.out.println("Grid is Valid!");
	    correct = true;//changes correct back to true for each subsequent time through the loop

	}

	// make the file ready to be read again
	infile.close();

    } // main

    // Prints a matrix to the screen, 1 row per line, columns separated by tabs
    private static void printMatrix(int[][] a) {
	System.out.println();
	for(int row = 0; row<a.length; row++){
	    for(int col = 0; col<a[0].length; col++){
		System.out.print(a[row][col]+" ");//prints the numbers in the matrix 1 by 1 with a space in between
	    }//for col
	    System.out.println();//gets to a new line for the next row of the sudoku puzzle
	}//for row
    } // printMatrix


    // This method reads in the next 9x9 matrix of integers in the file indicated by the
    // Scanner parameter.
    public static int[][] readInMatrix(Scanner in) {
	int [][] a = new int[9][9];//matrix that will be filled by the scanner
	for(int row = 0; row<9; row++){
	    for(int col = 0; col<9; col++){
		a[row][col]=in.nextInt();//fills the matrix with the intergers found in the scanner
	    }
	}
	return a;
    } // readInMatrix
   

    // This method returns true if each of the 9 3x3 subgrids contains all the integers 1-9, false
    // otherwise.  It checks each subgrid individually by calling the method checkSubGrid();
    public static boolean checkAllSubGrids(int[][] a) {
	for (int row = 0; row < a.length; row += 3) {
	    for (int col = 0; col < a[0].length; col += 3) {
		if (!checkSubGrid(a,col,col+2,row,row+2))
		    return false;
	    }
	}
	return true;
    } // checkAllSubGrids

    // This method returns true if the 3x3 subgrid of a spanning between rows top and bottom and
    // columns left and right contains all the integers 1-9, false otherwise.  The parameter a is a 9x9
    // matrix.
    public static boolean checkSubGrid(int[][] a, int left, int right, int top, int bottom) {
	int [] singleArray = new int [9];//creates an array to hold the values of the subgrid
	int [] test = new int [9];//creats an array to test if the same value shows up more than once
	boolean valid = true;//boolean to hold whether the subgrids are valid
	int holdervalue = 0;//a holder value to increment the independently of the loop

	for(int row=left; row<=right; row++){
	    for(int col=top; col<=bottom; col++){
		singleArray [holdervalue] = a[row][col];// creates an array from the sub grid
		holdervalue++;
	    }
	}
	for(int k=0; k<9; k++){
	    test [singleArray[k]-1] =  singleArray[k];//stores values given the value of the array
	}
	for(int j=0; j<9; j++){
	    if(test[j]==0)//if any of the values were not filled, one must have shown up twice
		valid=false;
	}
	return valid;
    } // checkSubGrid
    
    // This method returns true if every row contains all the integers 1-9, false otherwise
    public static boolean checkRows(int[][] a) {
	boolean valid = true;
	int [] test = new int [9];//creats an array to test if the same value shows up more than once

	for(int row=0; row<a.length; row++){
	    for(int col=0; col<a[0].length; col++){
		test [a[row][col]-1] = a[row][col];//fills the array with the values from the row
	    }
	    for(int i=0; i<9; i++){
		if(test[i]==0)//if any value was not filled, it never showed up and another showed up more than once
		    valid=false;
	    }
	    for(int j=0; j<9; j++){
		test[j] = 0;//make every point in the array 0 once again to check the next row
	    }
	}

	return valid;
    } // checkRows


    // This method returns true if every column contains all the integers 1-9, false otherwise
    public static boolean checkCols(int[][] a) {
	boolean valid = true;
	int [] test = new int [9];

	for(int col=0; col<a[0].length; col++){
	    for(int row=0; row<a.length; row++){
	    	test [a[row][col]-1] = a[row][col];//fills the array with the values from the column
	    }
	    for(int i=0; i<9; i++){
		if(test[i]==0)//if any of the values were not filled then another showed up twice (i.e. not valid)
		    valid=false;
	    }
	    for(int j=0; j<9; j++){
		test[j] = 0;//make every value in the array 0 to get ready to check the next column
	    }
	}

	return valid;
    } // checkCols

    // This method returns a Scanner object that can be used to read the contents
    // from the file indicated by the filename parameter.  If the file cannot be found,
    // the method catches the FileNotFoundException, prints an error message, and exits.
    public static Scanner openFile(String filename) {
	try{
	    Scanner file = new Scanner(new java.io.FileReader(filename));//opens the rile
	    return file;
	}//end try
	catch (java.io.FileNotFoundException e){//catches an error of the file not being found
	    System.out.println("File not found.");
	    System.exit(1);
	    return null;
	}//end catch
    } // openFile

} // class
