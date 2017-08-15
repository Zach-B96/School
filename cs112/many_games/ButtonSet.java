import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonSet  implements ActionListener{

    private Button b;
    private HitoriButton b1;
    private StrimkoButton b2;
    private String game;
    private boolean set=false;
    private int buttonValue=0;

    public ButtonSet(Button button,String s){
	b=button;
	game=s;
    }

    public ButtonSet(HitoriButton button,String s){
	b1=button;
	game=s;
    }

    public ButtonSet(StrimkoButton button,String s){
	b2=button;
	game=s;
    }



    public void actionPerformed(ActionEvent e){
		String action = e.getActionCommand();
		if(game.equals("Kakurasu")){
		    if(!set){
			b.setHere();
			set=true;
		    }
		    else if(set){
			b.unsetHere();
			set=false;
			}
		}
		if(game.equals("Hitori")){
		    if(!set){
			b1.setHere();
			set=true;
		    }
		    else if(set){
			b1.unsetHere();
			set=false;
		    }
		}
		if(game.equals("Strimko")){
		    if(buttonValue==0){
			b2.set1();
			buttonValue+=1;
		    }
		    else if(buttonValue==1){
			b2.set2();
			buttonValue+=1;
		    }
		    else if(buttonValue==2){
			b2.set3();
			buttonValue+=1;
		    }
		    else if(buttonValue==3){
			b2.set4();
			buttonValue+=1;
		    }
		    else if(buttonValue==4){
			b2.set5();
			buttonValue+=1;
		    }
		    else if(buttonValue==5){
			b2.set6();
			buttonValue+=1;
		    }
		    else if(buttonValue==6){
			b2.set7();
			buttonValue+=1;
		    }
		    else if(buttonValue==7){
			b2.set1();
			buttonValue=1;
		    }
		}
    }
}