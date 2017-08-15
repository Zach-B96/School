public class HitoriConstraints{

    private int[][] grid;
    private int[][]row;
    private int[][]col;
    //private int[][]constraints;

    public HitoriConstraints(){

    }

    public boolean checkConstraints(int[][] theGrid, int[][]rowDoubles, int[][]colDoubles){

	grid=theGrid;
	row=rowDoubles;
	col=colDoubles;
	//constraints=con;
	if(!checkRowDubs())
	    return false;
	if(!checkColDubs())
	    return false;
	if(!checkAroundSet())
	    return false;
	if(!checkPath())
	    return false;
	return true;
	
    }


    private boolean checkRowDubs(){
	int howMany=0;
	for(int i=0; i<5; i++){
	    for(int j=0;j<5;j++){
		if(row[i][j]==1 && grid[i][j]==1)
		    howMany=howMany+1;
	    }
	    if(howMany==2)
		return false;
	    howMany=0;
	}
	return true;
    }

    private boolean checkColDubs(){
	int howMany=0;
	for(int i=0; i<5; i++){
	    for(int j=0;j<5;j++){
		if(col[j][i]==1 && grid[j][i]==1)
		    howMany=howMany+1;
	    }
	    if(howMany==2)
		return false;
	    howMany=0;
	}
	return true;
    }

    private boolean checkAroundSet(){
	for(int i=0;i<4;i++){
	    for(int j=0; j<4; j++){
		if(grid[i][j]==2 && grid[i][j+1]==2)
		    return false;
		if(grid[i][j]==2 && grid[i+1][j]==2)
		    return false;
	    }
	}
	return true;
    }

    private boolean checkPath(){
	if(grid[0][0]==1 && grid[0][1]==2 && grid[1][0]==2)
	    return false;
	else if(grid[0][4]==1 && grid[0][3]==2 && grid[1][4]==2)
	    return false;
	else if(grid[4][0]==1 && grid[4][1]==2 && grid[3][0]==2)
	    return false;
	else if(grid[4][4]==1 && grid[4][3]==2 && grid[3][4]==2)
	    return false;
	int i=1;
	while(i<4){
	    if(grid[0][i]==1){
		if(grid[1][i]==2 && grid[0][i-1]==2 && grid[0][i+1]==2)
		    return false;
	    }
	    if(grid[i][0]==1){
		if(grid[i][1]==2 && grid[i-1][0]==2 &&grid[i+1][0]==2)
		    return false;
	    }
	    if(grid[4][i]==1){
		if(grid[3][i]==2 && grid[4][i-1]==2 && grid[4][i+1]==2)
		    return false;
	    }
	    if(grid[i][4]==1){
		if(grid[i][3]==2 && grid[i-1][4]==2 &&grid[i+1][4]==2)
		    return false;
	    }
	    i=i+1;
	}
	for(int k = 1; k<4;k++){
	    for(int j=1;j<4;j++){
		if(grid[k][j]==1){
		    if(grid[k+1][j]==2 && grid[k-1][j]==2 && grid[k][j+1]==2 && grid[k][j-1]==2)
			return false;
		}
	    }
	}
	return true;
    }
}
