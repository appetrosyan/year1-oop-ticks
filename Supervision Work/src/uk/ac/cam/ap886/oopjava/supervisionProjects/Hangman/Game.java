package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

import java.io.IOException;
import java.util.ArrayList;

public class Game {
	protected 	Vocabulary 	vocab;		
	protected 	Player 		player;		  	
	protected 	char[] 		etalon;			
	protected	ArrayList 	<Character> 	guessedLetters;
	protected	char[] 		openedWord;		
	protected	ArrayList	<Character>		wrongLetters;
	protected 	UserInterface ui;			
	protected 	static final int 	TOTAL_GUESSES=9;
	protected 	int 		currentGuesses;


	public Game(){
		try {
			vocab = new ArrayVocabulary ("words.txt");
		} catch (IOException e) {
			System.err.println("An error reading the vocab");
			e.printStackTrace();
		}
		ui = new GUIMainWindow(this);
		player = new SimplePlayer(ui.playerName());
		player.save();
		ui.greet(player);
		reset();
	}

	public void reset(){
		etalon = vocab.getRandomWord().toCharArray();
		openedWord= new char[etalon.length];
		for(int i=0;i<etalon.length;i++)
			openedWord[i]='_';
		currentGuesses = TOTAL_GUESSES;
		guessedLetters =new ArrayList<Character>();	
		wrongLetters =new ArrayList<Character>();
	}

	public String getOpenedWord(){
		return new String(openedWord);
	}

	public Player getPlayer(){
		return player;
	}

	public ArrayList <Character> getRightlyGuessedLetters(){
		return wrongLetters;
	}


	protected boolean playerHasWon(){
		return etalon.equals(openedWord);
	}

	public int getHangmanStage(){
		return TOTAL_GUESSES-currentGuesses;
	}
	
	public enum OUTCOME{
		DUPLICATE(-1), WRONG(0), RIGHT(1);
		
		private final int value;
		
		OUTCOME (final int newValue){
			value = newValue;
		}
	}

	public OUTCOME attempt(char letter){
		boolean found=false;
		if(letter ==0){
			return OUTCOME.DUPLICATE;
		}
		for(char l:guessedLetters){
			if (l==letter){
				return OUTCOME.DUPLICATE;
			}
		}
		guessedLetters.add(letter);
		for(int i=0; i<etalon.length;i++){
			if(letter == etalon[i]){
				found=true;
				openedWord[i]=letter;
			}
		}

		if(found){return OUTCOME.RIGHT;}
		else{
			currentGuesses--;
			wrongLetters.add(letter);
			return OUTCOME.WRONG;
		}
	}

	protected boolean gameOver(){
		return playerHasWon()||currentGuesses<=0;
	}

	public String getRightWord(){
		return new String(etalon);
	}

	public static void main(String[] args){
		Game current = new Game();
		while(current.ui.continuePrompt()){
			while(!current.gameOver()){
				try {
					current.ui.status();
				} catch (IllegalStageException e) {
					System.err.println("Internal Error "+e.getMessage());
					e.printStackTrace();
				}
				OUTCOME guessOutcome =current.attempt(
						current.ui.guessPrompt());
				if(guessOutcome.value==0){
					current.ui.wrongGuessMessage();
				}else if(guessOutcome.value>0){
					current.ui.rightGuessMessage();
				}else{
					current.ui.repeatedGuessMessage();
				}
			}if(current.playerHasWon()){
				current.ui.winPrompt();
				current.player.win();
				current.player.save();
			}else{
				current.ui.losePrompt();
				current.player.lose();
				current.player.save();
			}

		}
	}
}
