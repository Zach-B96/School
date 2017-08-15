public class TheGame {

	// Notice that the Game does not know about the GUI interface to the game
	
	private int howManyPushed = 0;
	private int limit;
	private String doneMessage = null;
	private int howMany = 11;
        private int[] badButtons = {1,3,5,7,9};
        private boolean clear = true;



        public TheGame(int i) {
		limit = i;

	}

	public void badSpot() {
		doneMessage = "You Lose - Good!";
	}
	
	public void spot() {
		howManyPushed++;
		if (howManyPushed == limit)
			doneMessage = "Curses, you win";
	}

	public boolean isButtonBad(int c) {
		for (int a : badButtons)
			if (c==a) return true;
		return false;
	}
	
	public String getDoneMessage() {
		return doneMessage;
	}

	public int howManyButtons() {
		return howMany;
	}

        public int getTimesPushed(){
	    return howManyPushed;
	}

        public boolean clear(){
	    return clear;
	}

        public void setClear(){
	    if(clear)
		clear=false;
	    else
		clear=true;
	}

}

/*
The game was altered by making it to where you first must click an even number, then an odd, then an even, and so on until the 7 clicks (I decided it was a nice number) is achieved. Instead of creating an action listener for each button, which was my first instinct, I instead decided to utilize good spot and bad spot as odd and even. I then added a boolean to the game to signify which was okay to click at the time. Switching the boolean on every click makes it to where the user must alternate in order to achieve victory. 
 */
