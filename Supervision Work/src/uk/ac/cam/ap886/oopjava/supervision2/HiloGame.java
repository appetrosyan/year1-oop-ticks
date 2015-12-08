package uk.ac.cam.ap886.oopjava.supervision2;

import java.io.IOException;

public class HiloGame {

	public static void main(String [] args) throws IOException{
		Game currentGame= new Game(args.length > 0?Integer.parseInt(args[0]):0);
		System.out.println("Welcome to the guessing game. Your current difficulty setting is: " + currentGame.getDifficulty());
		System.out.println("You have to guess a random Number in the range from  0 to "+ currentGame.getRange());
		System.out.println("\n\n---------------------------------\n\n");
		int userInput= 0;
		while (!(currentGame.isOver() || userInput=='q')){
			System.out.println("---------------------------------\n\n");
			System.out.println("You have "+currentGame.getGuesses()+" guesses\n\nGuess!!!");
			userInput=System.in.read(); 
			System.in.read();//Dummy to read the carriage return character
			if(userInput!=10){
			System.out.println("Your Guess was " + (userInput-48));
			System.out.println(currentGame.guess(userInput-48));
			}
			
		}
		if(currentGame.isLost()==false){
			System.out.println("\n\n---------------------------------\n\n");
			System.out.println("You have won. Congrats");
		}
		
	}

}
