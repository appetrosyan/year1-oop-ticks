package uk.ac.cam.ap886.oopjava.supervisionProjects.Hangman;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleScore implements Score {
	
	private int gamesWon;
	private int gamesLost;
	private Date firstRegistered;
	private DateFormat dateFormat;
	
	public SimpleScore(){
		dateFormat = new SimpleDateFormat("DD/MM/yyyy::HH:mm:ss"); 
		gamesWon = 0;
		gamesLost=0;
		firstRegistered=new Date();//Assigns the Current date 
	}
	
	public SimpleScore(String formatLine) throws ParseException{
		dateFormat = new SimpleDateFormat("DD/MM/yyyy::HH:mm:ss"); 
		String[] parts = new String[3];
		parts= formatLine.split(" ");
		gamesWon = Integer.parseInt(parts[0]);
		gamesLost = Integer.parseInt(parts[1]);
		firstRegistered = dateFormat.parse(parts[2]); 
	}

	@Override
	public int getGamesWon() {
		return gamesWon;
	}

	@Override
	public int getGamesLost() {
		
		return gamesLost;
	}

	private float computeRating(){
		return gamesWon *0.001f -0.0001f*gamesLost;
	}
	
	@Override
	public float getRating() {
		return computeRating();
	}

	@Override
	public int getGamesPlayed() {
		return gamesWon + gamesLost;
	}

	
	public Date getFirstRegistered() {
		return firstRegistered;
	}
	
	@Override
	public String toString(){
		return gamesWon+" "+gamesLost+" "
	+dateFormat.format(firstRegistered);
	}

	@Override
	public void win() {
	gamesWon++;	
	}

	@Override
	public void lose() {
	gamesLost++;	
	}

	@Override
	public void resetFirstRegistered() {
		firstRegistered = new Date();
		
	}

}
