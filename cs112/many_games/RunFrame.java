import java.awt.*;
import javax.swing.*;

public class RunFrame extends Frame {

        private JLabel message;
        private JButton[] buttons;
        private int buttonCount;
        private Container contentPane;

        public void init1() {

                contentPane=getContentPane();
		contentPane = this.getContentPane();

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane.setLayout(new GridLayout(8,7));

		//TheGame game1 = new TheGame("Kakurasu",15,10,11,2,3,1,10,8,4,6);
		int[] possible = {1,2};
		TheGame game1 = new TheGame("Kakurasu",possible,5);

		buttonCount=25;

		buttons=new JButton[buttonCount];

		topBoundary();

	        for(int i=0;i<buttonCount; i++) {
		    if(i%5==0 && i!=0)
			boundaryMaker(i);
		    JButton jb = new Button();
		    contentPane.add(jb);

		    //ButtonMenu sp = new ButtonMenu(jb,game1,this,i,"Kakurasu");
		    //SpotHandler sp = new SpotHandler(game1,this,i);
		    SpotHandler spot = new SpotHandler(game1,this,i,"Kakurasu");
		    ButtonSet but= new ButtonSet((Button)jb,"Kakurasu");
		    jb.addActionListener(spot);
		    jb.addActionListener(but);
		    //jb.addActionListener(sp);

		    buttons[i]=jb;

		}
		bottomBoundary();

		buttonMaker(game1);

	}



        public void setDoneMessage(String ender){
	    message.setText(ender);

	    for(JButton b : buttons){
		//	b.setEnabled(false);
	    }

	}





        public void topBoundary(){
		contentPane.add(new JLabel(" "));
		JLabel boundary;
		for(int i=1;i<6;i++){
		    boundary = new JLabel(Integer.toString(i));
		    boundary.setHorizontalAlignment(JLabel.CENTER);
		    contentPane.add(boundary);
		}
		contentPane.add(new JLabel(" "));
		boundary = new JLabel("1");
		boundary.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(boundary);
	}


        public void bottomBoundary(){
	    JLabel boundary;
	    boundary=new JLabel("3");
	    boundary.setHorizontalAlignment(JLabel.CENTER);
	    contentPane.add(boundary);
	    boundary=new JLabel(" ");
	    boundary.setHorizontalAlignment(JLabel.CENTER);
	    contentPane.add(boundary);	
	    boundary=new JLabel("1");
	    boundary.setHorizontalAlignment(JLabel.CENTER);
	    contentPane.add(boundary);
	    boundary=new JLabel("10");
	    boundary.setHorizontalAlignment(JLabel.CENTER);
	    contentPane.add(boundary);
	    boundary=new JLabel("8");
	    boundary.setHorizontalAlignment(JLabel.CENTER);
	    contentPane.add(boundary);
	    boundary=new JLabel("4");
	    boundary.setHorizontalAlignment(JLabel.CENTER);
	    contentPane.add(boundary);
	    boundary=new JLabel("6");
	    boundary.setHorizontalAlignment(JLabel.CENTER);
	    contentPane.add(boundary);
	    boundary=new JLabel(" ");
	    boundary.setHorizontalAlignment(JLabel.CENTER);
	    contentPane.add(boundary);
	}

        public void boundaryMaker(int i){
	    int x= (i/5)+1;
	    JLabel boundary;
	    if(x==2){
		boundary=new JLabel("15");
		boundary.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(boundary);
	    }
	    else if(x==3){
		boundary=new JLabel("10");
		boundary.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(boundary);
	    }
	    else if(x==4){
		boundary=new JLabel("11");
		boundary.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(boundary);
	    }
	    else if(x==5){
		boundary=new JLabel("2");
		boundary.setHorizontalAlignment(JLabel.CENTER);
		contentPane.add(boundary);
	    }
	    boundary = new JLabel(Integer.toString(x));
	    boundary.setHorizontalAlignment(JLabel.CENTER);
	    contentPane.add(boundary);


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
		Solver solver = new Solver(game1, this, "Kakurasu", buttons);
		buttonPanel2.add(solve);//add action listener
		solve.addActionListener(solver);


		JButton rules= new JButton("Rules");
		Rules r = new Rules("Kakurasu");
		buttonPanel4.add(rules);
		rules.addActionListener(r);

		contentPane.add(buttonPanel1);
		contentPane.add(buttonPanel2);
		contentPane.add(buttonPanel4);
	}
}//Class
