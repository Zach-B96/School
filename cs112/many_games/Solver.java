import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Solver implements ActionListener{

    private TheGame game;
    private String name;
    private Frame frame;
    private int[][]theGrid;
    private int [] possibleValues;
    private JButton[] buttons;
    private int rows;
    private int columns;


    public Solver(TheGame game1,Frame run, String name1, JButton[]buttons1){
	game=game1;
	frame=run;
	name=name1;
	buttons=buttons1;
	theGrid=game.getGrid();
	possibleValues=game.getPossible();
    }



    public void actionPerformed(ActionEvent e){
	theGrid=game.getGrid();
	if(game.checks(theGrid)){
	    boolean b=label(0,0);
	}
	else{
	    if(name.equals("Strimko"))
		theGrid=game.getOriginal();
	    else{
		for(int i=0; i<theGrid[0].length;i++){
		    for(int j=0; j<theGrid[0].length; j++){
			theGrid[i][j]=0;
		    }
		}
	    }
	    boolean b=label(0,0);
	}

	game.setGrid(theGrid);
	int k=0;


	for(int l=0; l<theGrid.length;l++){
	    for(int m=0; m<theGrid.length; m++){

		if(name.equals("Kakurasu")){
		    if(theGrid[l][m]==1){
			((Button)buttons[k]).unsetHere();
		    }
		    else if(theGrid[l][m]==2){
			((Button)buttons[k]).setHere();
		    }
	       	}
		else if(name.equals("Hitori")){
		    if(theGrid[l][m]==1){
			((HitoriButton)buttons[k]).unsetHere();
		    }
		    else if(theGrid[l][m]==2){
			((HitoriButton)buttons[k]).setHere();
		    }
		}
		else if(name.equals("Strimko")){
		    if(theGrid[l][m]==1){
			((StrimkoButton)buttons[k]).set1();
		    }
		    else if(theGrid[l][m]==2){
			((StrimkoButton)buttons[k]).set2();
		    }
		    else if(theGrid[l][m]==3){
			((StrimkoButton)buttons[k]).set3();
		    }
		    else if(theGrid[l][m]==4){
			((StrimkoButton)buttons[k]).set4();
		    }
		    else if(theGrid[l][m]==5){
			((StrimkoButton)buttons[k]).set5();
		    }
		    else if(theGrid[l][m]==6){
			((StrimkoButton)buttons[k]).set6();
		    }
		    else if(theGrid[l][m]==7){
			((StrimkoButton)buttons[k]).set7();
		    }
		}
		k=k+1;
	    }
	}
	if(name.equals("Kakurasu"))
	    ((RunFrame)frame).setDoneMessage(game.getDoneMessage());
	if(name.equals("Hitori"))
	    ((HitoriFrame)frame).setDoneMessage(game.getDoneMessage());
	if(name.equals("Strimko"))
	    ((StrimkoFrame)frame).setDoneMessage(game.getDoneMessage());

	frame.repaint();
    }


    private boolean label(int row, int column){
	if(row==theGrid.length){
	     return game.checks(theGrid);
	}
	else{
	    if(theGrid[row][column]!=0){
		game.printGrid(theGrid);
		if(game.checks(theGrid)){
		    int newcolumn=column+1;
		    int newrow=row;
		    if(newcolumn==theGrid[newrow].length){
			newcolumn=0;
			newrow=newrow+1;
		    }
		    if(label(newrow,newcolumn))
			return true;
		}
		unset(row, column);
		label(0,0);
	    }
	    else{
		for(int i =0;i<possibleValues.length;i++){
		    theGrid[row][column]=possibleValues[i];
		    boolean check=game.checks(theGrid);
		    if(check){
			int newrow = row;
			int newcolumn=column+1;
			if(newcolumn==theGrid[newrow].length){
			    newcolumn=0;
			    newrow=newrow+1;
			}
			if(label(newrow,newcolumn))
			    return true;		
		    }
		    unset(row,column);
		
		}//for

		return false;
	    }

	}//else

      	return true;



    }//label


    public void unset(int row, int column){
	/*if(!b)
		theGrid[row][column]=0;
	    else{
		column=column-1;
		if(column==-1){
		    column=5;
		    row=row-1;
		    }*/
		theGrid[row][column]=0;   
    }
}
