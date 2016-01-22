package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

public interface UserInterface {

	public String playerName();
	
	public void status() throws IllegalStageException;
	
	public boolean continuePrompt();
	
	public char guessPrompt();
	
	public void wrongGuessMessage();
	
	public void rightGuessMessage();
	
	public void repeatedGuessMessage();
	
	public void winPrompt();
	
	public void losePrompt();

	public void greet(Player player);
}
