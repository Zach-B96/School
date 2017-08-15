public class StrimkoConstraints{

    private int[][] grid;


    public StrimkoConstraints(){

    }

    public boolean checkConstraints(int[][] theGrid){
	grid=theGrid;
	int[] row= new int[7];
	int[] col=new int[7];

	for(int i=0;i<7;i++){
	    for(int j=0; j<7; j++){
		row[j]=grid[i][j];
		col[j]=grid[j][i];
	    }
	    if(!checkArray(row))
		return false;
	    if(!checkArray(col))
		return false;
	    for(int k=0; k<7;k++){
		row[k]=0;
		col[k]=0;
	    }
	}
	if(!checkStreams())
	    return false;

	return true;
    }

    private boolean checkArray(int[] list){
	if(list[0]==list[1] || list[0]==list[2] || list[0]==list[3] || list[0]==list[4] || list[0]==list[5] || list[0]==list[6]){
	    if(list[0]!=0)
		return false;
	}
	if(list[1]==list[2] || list[1]==list[3] || list[1]==list[4] || list[1]==list[5] || list[1]==list[6]){
	    if(list[1]!=0)
		return false;
	}
	if(list[2]==list[3] || list[2]==list[4] || list[2]==list[5] || list[2]==list[6]){
	    if(list[2]!=0)
		return false;
	}
	if(list[3]==list[4] || list[3]==list[5] || list[3]==list[6]){
	    if(list[3]!=0)
		return false;
	}
	if(list[4]==list[5] || list[4]==list[6]){
	    if(list[4]!=0)
		return false;
	}
	if(list[5]==list[6]){
	    if(list[5]!=0)
		return false;
	}
	return true;
    }

    private boolean checkStreams(){
	int[]stream=new int[7];

	stream[0]=grid[0][2];
	stream[1]=grid[0][1];
	stream[2]=grid[0][0];
	stream[3]=grid[1][0];
	stream[4]=grid[2][0];
	stream[5]=grid[3][1];
	stream[6]=grid[3][2];
	if(!checkArray(stream))
	    return false;
	for(int i=0;i<6;i++){
	    stream[i]=0;
	}

	stream[0]=grid[2][1];
	stream[1]=grid[1][1];
	stream[2]=grid[1][2];
	stream[3]=grid[0][3];
	stream[4]=grid[0][4];
	stream[5]=grid[0][5];
	stream[6]=grid[0][6];
	if(!checkArray(stream))
	    return false;
	for(int i=0;i<6;i++){
	    stream[i]=0;
	}

	stream[0]=grid[2][3];
	stream[1]=grid[2][2];
	stream[2]=grid[1][3];
	stream[3]=grid[1][4];
	stream[4]=grid[1][5];
	stream[5]=grid[1][6];
	stream[6]=grid[2][5];
	if(!checkArray(stream))
	    return false;
	for(int i=0;i<6;i++){
	    stream[i]=0;
	}

	stream[0]=grid[3][0];
	stream[1]=grid[4][0];
	stream[2]=grid[5][0];
	stream[3]=grid[5][1];
	stream[4]=grid[4][2];
	stream[5]=grid[3][3];
	stream[6]=grid[2][4];
	if(!checkArray(stream))
	    return false;
	for(int i=0;i<6;i++){
	    stream[i]=0;
	}

	stream[0]=grid[4][1];
	stream[1]=grid[5][2];
	stream[2]=grid[4][3];
	stream[3]=grid[3][4];
	stream[4]=grid[4][5];
	stream[5]=grid[4][6];
	stream[6]=grid[3][6];
	if(!checkArray(stream))
	    return false;
	for(int i=0;i<6;i++){
	    stream[i]=0;
	}

	stream[0]=grid[2][6];
	stream[1]=grid[3][5];
	stream[2]=grid[4][4];
	stream[3]=grid[5][3];
	stream[4]=grid[5][5];
	stream[5]=grid[6][6];
	stream[6]=grid[5][6];
	if(!checkArray(stream))
	    return false;
	for(int i=0;i<6;i++){
	    stream[i]=0;
	}

	stream[0]=grid[6][0];
	stream[1]=grid[6][1];
	stream[2]=grid[6][2];
	stream[3]=grid[6][3];
	stream[4]=grid[6][4];
	stream[5]=grid[6][5];
	stream[6]=grid[5][4];
	if(!checkArray(stream))
	    return false;

	return true;
	  
    }
}
