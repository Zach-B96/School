import java.awt.event.*;

public class SpotHandler implements ActionListener{

    private TheGame game;
    private Frame frame;
    private int spot;
    private String gameName;
    private boolean set=false;
    private int value=0;

    public SpotHandler(TheGame g, Frame run, int sp,String gamenm){
	game=g;
	frame=run;
	spot=sp;
	gameName=gamenm;
    }

    public void actionPerformed(ActionEvent e){
	/*String action = e.getActionCommand();
	if(action.equals("Set"))
	    game.spot(spot,2);
	else if(action.equals("Unset"))
	game.spot(spot,1);*/
	if(gameName.equals("Hitori") || gameName.equals("Kakurasu")){
	    if(!set){
		game.spot(spot,2);
		set=true;
	    }
	    else if(set){
		game.spot(spot,1);
		set=false;
	    }
	}

	if(gameName.equals("Strimko")){
	    if(value==0){
		game.spot(spot,1);
		value=1;
	    }
	    else if(value==1){
		game.spot(spot,2);
		value=2;
	    }
	    else if(value==2){
		game.spot(spot,3);
		value=3;
	    }
	    else if(value==3){
		game.spot(spot,4);
		value=4;
	    }
	    else if(value==4){
		game.spot(spot,5);
		value=5;
	    }	
	    else if(value==5){
		game.spot(spot,6);
		value=6;
	    }
	    else if(value==6){
		game.spot(spot,7);
		value=7;
	    }
	    else if(value==7){
		game.spot(spot,1);
		value=1;
	    }
	}

		
	if(gameName.equals("Kakurasu")){
	    if(game.getDoneMessage()!=null)
		((RunFrame)frame).setDoneMessage(game.getDoneMessage());
	}
	else if(gameName.equals("Hitori")){
	    if(game.getDoneMessage()!=null)
		((HitoriFrame)frame).setDoneMessage(game.getDoneMessage());
	}
	else if(gameName.equals("Strimko")){
	    if(game.getDoneMessage()!=null)
		((StrimkoFrame)frame).setDoneMessage(game.getDoneMessage());
	}
	   
	frame.repaint();
    }
}
