package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

import java.util.Date;;

public interface Score {
	
	public int getGamesWon();
	public int getGamesLost();
	public float getRating();
	public int getGamesPlayed();
	public Date getFirstRegistered();
	public void resetFirstRegistered();
	public void win();
	public void lose();
	

}
