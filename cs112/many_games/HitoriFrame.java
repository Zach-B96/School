import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.awt.*;
import javax.swing.*;

public class HitoriFrame extends Frame {

        private JLabel message;
        private JButton[] buttons;
        private int buttonCount;
        private Container contentPane;

        public void init2() {
                contentPane=getContentPane();
		contentPane = this.getContentPane();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane.setLayout(new GridLayout(6,5));

		int[] possible = {1,2};

		int[]grid=readFromFile("HitoriGrid.txt");

		int[][]colDub=getCol(grid);
		int[][]rowDub=getRow(grid);
		int[][]grids=makeMatrix(grid);

		TheGame game1=new TheGame("Hitori",possible, rowDub, colDub,5);

		buttonCount=grid.length;

		buttons=new JButton[buttonCount];


	        for(int i=0;i<buttonCount; i++) {

		    HitoriButton jb = new HitoriButton(Integer.toString(grid[i]));
		    contentPane.add(jb);

		    //ButtonMenu sp = new ButtonMenu(jb,game1,this,i,"Hitori");
		    SpotHandler spot = new SpotHandler(game1,this,i,"Hitori");
		    ButtonSet but= new ButtonSet(jb,"Hitori");
		    jb.addActionListener(spot);
		    jb.addActionListener(but);

		    buttons[i]=jb;

		}

		buttonMaker(game1);


	}



        public void setDoneMessage(String ender){
	    message.setText(ender);
	    for(JButton b : buttons){
		//b.setEnabled(false);
	    }

	}


        public void buttonMaker(TheGame game1){
	message= new JLabel("Good Luck!");
		contentPane.add(message);

		JPanel buttonPanel1 = new JPanel();
		JPanel buttonPanel2 = new JPanel();
		JPanel buttonPanel4 = new JPanel();

		JButton starter = new JButton("Back to Menu");
		StartListener st=new StartListener(this);
		buttonPanel1.add(starter);
		starter.addActionListener(st);

		JButton solve = new JButton("Solve");
		Solver solver = new Solver(game1, this,"Hitori",buttons);
		buttonPanel2.add(solve);//add action listener
		solve.addActionListener(solver);


		JButton rules= new JButton("Rules");
		Rules r = new Rules("Hitori");
		buttonPanel4.add(rules);
		rules.addActionListener(r);

		contentPane.add(buttonPanel1);
		contentPane.add(buttonPanel2);
		contentPane.add(buttonPanel4);

	}


    public static int[] readFromFile(String fname) {
	try{
	    Scanner in = new Scanner(new File(fname));
	    
	    int[] pattern = new int[25];
	    int i=0;
	    while (in.hasNextInt()) {

		pattern[i] = in.nextInt();
		i+=1;
	    }

	    in.close();

	    return pattern;
	}
	catch (FileNotFoundException ex) {
	    return null;
	}
    } // trackFromFile


    private int[][] getRow(int[] g){
	int[][]matrix=makeMatrix(g);
	int[][]row=new int[5][5];
	for(int i=0; i<5;i++){
	    for(int j=0; j<5; j++){
		int c=matrix[i][j];
		if(c==matrix[i][(j+1)%5] || c==matrix[i][(j+2)%5] || c==matrix[i][(j+3)%5] ||c==matrix[i][(j+4)%5])
		    row[i][j]=1;
		else
		    row[i][j]=0;
	    }
	}
	return row;

    }

    private int[][] getCol(int[] g){
	int[][]matrix=makeMatrix(g);
	int[][]col=new int[5][5];
	for(int i=0; i<5;i++){
	    for(int j=0; j<5; j++){
		int c=matrix[j][i];
		if(c==matrix[(j+1)%5][i] || c==matrix[(j+2)%5][i] || c==matrix[(j+3)%5][i] ||c==matrix[(j+4)%5][i])
		    col[j][i]=1;
		else
		    col[j][i]=0;
	    }
	}
	return col;

    }

    private int[][] makeMatrix(int[] g){
	int[][]matrix=new int[5][5];
	matrix[0][0]=g[0];
	int j=0;
	for(int i=1; i<g.length;i++){
	    if(i%5==0)
		j=j+1;
	    if(i<5)
		matrix[j][i]=g[i];
	    else if(i<10)
		matrix[j][i-5]=g[i];
	    else if(i<15)
		matrix[j][i-10]=g[i];
	    else if(i<20)
		matrix[j][i-15]=g[i];
	    else
		matrix[j][i-20]=g[i];
	}
	return matrix;
    }
}//Class
