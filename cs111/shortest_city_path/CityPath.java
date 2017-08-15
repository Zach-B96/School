import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

class CityPath{
    /* Finds the shortest round-trip route that visits all the cities. */
    /* Zachary Bessette
       Jonathan Heidenberg
       December 15, 2015*/


    public static void main(String[] args) {

	/* 
	 *  The filename containing a distance matrix is entered on the command line when the program is run.
	 *  For example, if we want to read in the distance matrix in a file called bays6.txt, the
	 *  program should be run with:
	 *
	 *               java CityPath bays6.txt
	 *
	 *  The 'filename' variable will get assigned the String value the User enters on the command line.
	*/
	String filename;
	if (args.length < 1) {
	    System.out.println("Error: no filename indicated.");
	    System.out.println("Usage: 'java CityPath <filename>'");
	    System.exit(1);
	}
	filename = args[0];

	Scanner infile = openFile(filename); // open the file for reading
	int n = getNumberOfLines(infile); // dimension of the distance matrix (total num of cities)
	infile = openFile(filename); // reopen the file
	int[][] distance = readInMatrix(infile,n); // distance matrix
	infile.close(); // make the file ready to be used again

	System.out.println();
	System.out.println(filename + " has a matrix with " + n + " cities.");
	printMatrix(distance);

	int [] path = new int [n];//create an array to store the shortest path

	for(int i = 0; i<path.length; i++){//fill path with all -1
	    path[i]=-1;

	}//for loop


	path=shortestCityPath(distance,path,0,n);//call the recursive method from the main method
	                                           

	int distanceTraveled =pathDistance(distance,path); //now that path represents the shortest path, calculate that distance
	System.out.println();
	System.out.println("Total distance: "+distanceTraveled);//print the distance of the shortest path
	System.out.println("The shortest path is: ");
	System.out.println();
	printPath(path);//print the indices of path in order

    } // main


    /* This method recursively finds the shortest round-trip route through all the cities 
     * represented in the distance matrix, d.  
       Parameters:
       int[][] d -- the distance matrix
       int[] path -- the partial path we've taken so far
       int numVisited -- the total number of cities we've visited so far in path
       int n -- the total number of cities we need to visit
       Returns the shortest path as an array.
     */
    private static int[] shortestCityPath(int[][] d, int[] path, int numVisited, int n) {


	int [] copy = new int [n];//creates a copy of the array 
	System.arraycopy(path,0,copy,0,n);


	int [] counter = new int [n];//counter array to avoid repeats
	for(int j=0; j<n; j++){
	    if (copy[j] != -1){
		counter[copy[j]]++;
	    }//if statement
	}//for loop


	int [] bestPath = new int [n];//holds the shortest path 


	int index=-1;//holds the index of the first unfilled spot
	for(int i=0; i<copy.length;i++){
	    if (copy[i]==-1){
		index= i;
		break;//ensures that index is the first empty value and not any subsequent ones
	    }//if statement
        }//for loop


	if (numVisited==n){
	    return path;
	}//base case

	else{

	    int shortestSoFar=Integer.MAX_VALUE;//minimum value of the distance
	    int [] savior = new int [n];//saves each iteration of the array, thus savior

	    for(int i=0;i<n;i++){
		copy[index] = i;//changes the values of copy

		if(counter[i]==0){

			copy[numVisited]=i;
			savior = shortestCityPath(d,copy,numVisited+1,n);//recursive call passing in the value numVisited+1 to make progress to base case

			int newDistance = pathDistance(d, savior);//distance of each iteration
			    if(newDistance<shortestSoFar){//if the distance in the test is less than the previous minimum distance
				shortestSoFar = newDistance;//chage the minimum distance to the new minimum
				System.arraycopy(savior,0,bestPath,0,n);//coppies the new shortest iteration into bestPath

			    }//if statement
			   
			
	       	}//if statement
	    }//for loop
	}//general case
	return bestPath;//return the shortest path thus far

    } // shortestCityPath


    // This method computes the total distance traveled on a roundtrip
    // route starting at path[0], traveling to path[1], path[2], ...,
    // path[path.length-1], and ending back at path[0].
    private static int pathDistance(int[][] d, int[] path) {
	int distance = 0;//create an integer to store the distance of that path
	for(int i = 0; i < path.length-1; i++){//runs through all indices in path
	    distance += d[path[i]][path[i+1]];// adds to distance the value of the distance from one index in path to the next
	}//for loop
	distance += d[path[path.length-1]][path[0]];//adds the distrance from the last city in path back to the first
	return distance;
    } // pathDistance

    // This method prints the cities in a path
    private static void printPath(int[] path) {
	for (int city : path)
	    System.out.print(city + "\t");
	System.out.println();
    } // printPath


    // This method returns the number of lines in the file the Scanner infile
    // represents
    private static int getNumberOfLines(Scanner infile) {
	int lineCount = 0;
	while (infile.hasNextLine()) {
	    infile.nextLine();
	    lineCount++;
	}
	infile.close();
	return lineCount;
    } // getNumberOfLines

    // Prints a matrix to the screen, 1 row per line, columns separated by tabs
    private static void printMatrix(int[][] a) {
	System.out.println();
	for(int row = 0; row<a.length; row++){
	    for(int col = 0; col<a[0].length; col++){
		System.out.print(a[row][col]+" ");//prints the numbers in the matrix 1 by 1 with a space in between
	    }//for col
	    System.out.println();//gets to a new line for the next row of the matrix
	}//for row
    } // printMatrix



    // This method reads in the distance matrix of integers in the file indicated by the
    // Scanner parameter.
    public static int[][] readInMatrix(Scanner in, int n) {
	int [][] a = new int[n][n];//n by n matrix that will be filled by the scanner
	for(int row = 0; row<n; row++){
	    for(int col = 0; col<n; col++){
		a[row][col]=in.nextInt();//fills the matrix with the intergers found in the scanner
	    }//for col
	}//for row
	return a;
    } // readInMatrix


    // This method returns a Scanner object that can be used to read the contents
    // from the file indicated by the filename parameter.  If the file cannot be found,
    // the method catches the FileNotFoundException, prints an error message, and exits.
    public static Scanner openFile(String filename) {
    	try{
	    Scanner file = new Scanner(new java.io.FileReader(filename));//opens the file
	    return file;
	}//end try
	catch (java.io.FileNotFoundException e){//catches an error of the file not being found
	    System.out.println("File not found.");
	    System.exit(1);
	    return null;
	}//end catch
    } // openFile

} // class
