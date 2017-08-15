public class TheGame{

    private String game;
    private String doneMessage=null;
 
    private int howManyPressed=0;
    private int size;

    private int[][] theGrid;
    private int[][] strimkoOriginal;

    private int[][] hitoriRowDoubles;
    private int[][] hitoriColDoubles;
    //private int[][] hitoriConstraints;

    private int[] possible;



    public TheGame(String game1,int[] possibility, int size1){
	game=game1;
	possible=possibility;
	size=size1;
	theGrid=new int[size][size];
    }

    public TheGame(String game1,int[] possibility, int size1, int[][] grid1){
	game=game1;
	possible=possibility;
	size=size1;
	theGrid=grid1;
	strimkoOriginal=grid1;
    }

    public TheGame(String game1,int[] possibility, int[][]row, int[][]col, int size1){
	game=game1;
	possible=possibility;
	hitoriRowDoubles=row;
	hitoriColDoubles=col;
	size=size1;
	theGrid=new int[size][size];
	//hitoriConstraints=constraints;

    }

    public void spot(int spot, int value){
	//howManyPressed+=1;
	update(spot,value);
	//printGrid(theGrid);
	boolean b=checks(theGrid);
	if(b)
	    doneMessage="Keep going!";
	if(!b)
	    doneMessage="Oops! No....";
	//if(howManyPressed==25 && checks(theGrid))
	if(noZeroes() && b)
	    doneMessage="You Win!";
    }



    public String getDoneMessage(){
	return doneMessage;
    }

    private void update(int x,int value){
	theGrid[x/size][x-(size*(x/size))]=value;
    }

    public int[][] getGrid(){
	return theGrid;
    }

    public int[] getPossible(){
	return possible;
    }

    public int[][] getOriginal(){
	return strimkoOriginal;
    }

    public void setGrid(int row, int column, int value){
	theGrid[row][column]=value;
    }

    public void setGrid(int[][]answer){
	for(int i=0; i<answer[0].length; i++){
	    for(int j=0; j<answer[0].length; j++){
		theGrid[i][j]=answer[i][j];
	    }
	}	
	doneMessage="Quitter...";
	//add a new action listiner to solver that sets buttons and message
    }

    public boolean checks(int[][] newGrid){

	if(game.equals("Kakurasu")){
	    KakurasuConstraints c=new KakurasuConstraints();
	    if(c.checkConstraints(newGrid)){
		return true;
	    }
	    else{
		return false;
	    }
	}
	else if(game.equals("Hitori")){
	    HitoriConstraints c=new HitoriConstraints();
	    if(c.checkConstraints(newGrid,hitoriRowDoubles,hitoriColDoubles)){
		return true;
	    }
	    else{
		return false;
	    }
	}
	else if(game.equals("Strimko")){
	    StrimkoConstraints c=new StrimkoConstraints();
	    if(c.checkConstraints(newGrid))
		return true;
	    else
		return false;
	}

	return true;

    }

 
    public void printGrid(int[][] newGrid){
	System.out.println();
	for(int i=0;i<newGrid[0].length;i++){
	    for(int j=0;j<newGrid[0].length;j++){
		System.out.print(newGrid[i][j]);
		System.out.print("  ");
	    }
	    System.out.println();
	}
    }


    public boolean noZeroes(){
	for(int i=0; i<theGrid[0].length; i++){
	    for(int j=0;j<theGrid[0].length;j++){
		if(theGrid[i][j]==0)
		    return false;
	    }
	}
	return true;
    }
}
