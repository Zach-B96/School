import java.awt.*;
import javax.swing.*;

public class StrimkoFrame extends Frame {

        private JLabel message;
        private JButton[] buttons;
        private int buttonCount;
        private Container contentPane;

        public void init3() {

                contentPane=getContentPane();
		contentPane = this.getContentPane();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane.setLayout(new GridLayout(8,7));

		int[] possible = {1,2,3,4,5,6,7};

		int[][] constraints=getCon();

		TheGame game1 = new TheGame("Strimko",possible,7,constraints);

		buttonCount=49;

		buttons=new JButton[buttonCount];


	        for(int i=0;i<buttonCount; i++) {

		    if(i==0){
			StrimkoButton jb = new StrimkoButton(5,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==5){
			StrimkoButton jb = new StrimkoButton(1,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==6){
			StrimkoButton jb = new StrimkoButton(7,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==9){
			StrimkoButton jb = new StrimkoButton(3,getColor(i));		       
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==11){
			StrimkoButton jb = new StrimkoButton(4,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==17){
			StrimkoButton jb = new StrimkoButton(3,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==21){
			StrimkoButton jb = new StrimkoButton(4,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==23){
			StrimkoButton jb = new StrimkoButton(1,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==24){
			StrimkoButton jb = new StrimkoButton(5,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==25){
			StrimkoButton jb = new StrimkoButton(7,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==27){
			StrimkoButton jb = new StrimkoButton(6,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==33){
			StrimkoButton jb = new StrimkoButton(5,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==37){
			StrimkoButton jb = new StrimkoButton(2,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==38){
			StrimkoButton jb = new StrimkoButton(1,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==39){
			StrimkoButton jb = new StrimkoButton(5,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==40){
			StrimkoButton jb = new StrimkoButton(7,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==44){
			StrimkoButton jb = new StrimkoButton(6,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else if(i==47){
			StrimkoButton jb = new StrimkoButton(4,getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		    else{
			StrimkoButton jb = new StrimkoButton(getColor(i));
			contentPane.add(jb);
			SpotHandler spot = new SpotHandler(game1,this,i,"Strimko");
			ButtonSet but= new ButtonSet(jb,"Strimko");
			jb.addActionListener(spot);
			jb.addActionListener(but);
			buttons[i]=jb;
		    }
		}
		buttonMaker(game1);

	}



        public void setDoneMessage(String ender){
	    message.setText(ender);

	    for(JButton b : buttons){
		//	b.setEnabled(false);
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
		Solver solver = new Solver(game1, this, "Strimko", buttons);
		buttonPanel2.add(solve);//add action listener
		solve.addActionListener(solver);


		JButton rules= new JButton("Rules");
		Rules r = new Rules("Strimko");
		buttonPanel4.add(rules);
		rules.addActionListener(r);

		contentPane.add(buttonPanel1);
		contentPane.add(buttonPanel2);
		contentPane.add(buttonPanel4);

	}

        private int[][] getCon(){
	    int[][] zach =new int[7][7];
	    for(int i=0;i<7;i++){
		for(int j=0;j<7;j++){
		zach[i][j]=0;
		}
	    }
	    zach[0][0]=5;
	    zach[0][5]=1;
	    zach[0][6]=7;
	    zach[1][2]=3;
	    zach[1][4]=4;
	    zach[2][3]=3;
	    zach[3][0]=4;
	    zach[3][2]=1;
	    zach[3][3]=5;
	    zach[3][4]=7;
	    zach[3][6]=6;
	    zach[4][5]=5;
	    zach[5][2]=2;
	    zach[5][3]=1;
	    zach[5][4]=5;
	    zach[5][5]=7;
	    zach[6][2]=6;
	    zach[6][5]=4;

	    return zach;
	}

        private String getColor(int x){
	    if(x==0 || x==1 || x==2 || x==7 || x==14 || x==22 || x==23)
		return "red";
	    if(x==3 || x==4 || x==5 || x==6 || x==8 || x==9 || x==15)
		return "blue";
	    if(x==21 || x==28 || x==35 || x==36 || x==30 || x==24 || x==18)
		return "magenta";
	    if(x==29 || x==31 || x==33 || x==34 || x==25 || x==27 || x==37)
		return "cyan";
	    if(x==10 || x==11 || x==12 || x==13 || x==16 || x==17 || x==19)
		return "pink";
	    if(x==20 || x==26 || x==32 || x==38 || x==40 || x==41 || x==48)
		return "green";
	    if(x==42 || x==43 || x==44 || x==45 || x==46 || x==47 || x==39)
		return "orange";
	    return "";
	}

}//Class
