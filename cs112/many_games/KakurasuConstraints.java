public class KakurasuConstraints{

    private int[][] grid;

    private int row1=15;
    private int row2=10;
    private int row3=11;
    private int row4=2;
    private int row5=3;
    private int col1=1;
    private int col2=10;
    private int col3=8;
    private int col4=4;
    private int col5=6;

    public KakurasuConstraints(){

    }

    public boolean checkConstraints(int[][] theGrid){
	grid=theGrid;
	int rowSum=0;
	int colSum=0;
	//int howManyRow=0;
	//int howManyCol=0;
	for(int i = 0; i<5; i++){
	    for(int j = 0; j<5;j++){
		if(grid[i][j]==2)
		    rowSum+=j+1;
		if(grid[j][i]==2)
		    colSum+=j+1;
		/*	if(grid[i][j]!=0)
		    howManyRow=howManyRow+1;
		if(grid[j][i]!=0)
		howManyCol=howManyCol+1;*/
	    }
	    if(rowSum>getSum(0,i))
		return false;
	    if(colSum>getSum(1,i))
		return false;
	    if(rowFull(grid[i]) && rowSum!=getSum(0,i)){
		return false;
	    }
	    /* if(rowSum!=getSum(0,i) && howManyRow==5)
		return false;
	    if(colSum!=getSum(1,i) && howManyCol==5)
	    return false;*/
	    rowSum=0;
	    colSum=0;
	    // howManyRow=0;
	    //howManyCol=0;
	}

	return true;
    }


    private int getSum(int indicator, int value){
	if(indicator==0 && value==0)
	    return row1;
	if(indicator==0 && value==1)
	    return row2;
	if(indicator==0 && value==2)
	    return row3;
	if(indicator==0 && value==3)
	    return row4;
	if(indicator==0 && value==4)
	    return row5;
	if(indicator==1 && value==0)
	    return col1;
	if(indicator==1 && value==1)
	    return col2;
	if(indicator==1 && value==2)
	    return col3;
	if(indicator==1 && value==3)
	    return col4;
	if(indicator==1 && value==4)
	    return col5;
	else 
	    return 100;

    }

    private boolean rowFull(int[]blah){
	int hm=0;
	for(int i=0;i<5;i++){
	    if(blah[i]==0)
		hm++;
	}
	if(hm==0)
	    return true;
	else 
	    return false;
    }
}
