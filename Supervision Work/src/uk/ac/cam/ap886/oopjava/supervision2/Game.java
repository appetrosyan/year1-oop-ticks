package uk.ac.cam.ap886.oopjava.supervision2;
import java.util.Random;
public class Game {
	int number;
	int difficulty;
	int numAttempts = 3;
	boolean over = false;
	boolean lost = false;
	
	public Game (int mDifficulty){
		difficulty = mDifficulty < 0?0:mDifficulty;
		Random randomGenerator = new Random();	
		difficulty = difficulty <5?difficulty:4;
		number = randomGenerator.nextInt(5+difficulty);
		numAttempts = 2+difficulty;
	}
	public Game (int mDifficulty, int nAttempts){
		mDifficulty = mDifficulty < 0?-mDifficulty:mDifficulty;
		Random randomGenerator = new Random();
		number = randomGenerator.nextInt(5+difficulty);
		numAttempts = nAttempts;
	}
	public String guess(int mGuess){
		if(over){
			return "Game Over. You have" + (lost?" lost":" won!!!");
		}
		else{
			if(mGuess == number){
				over = true;
				return "Correct";
			}
			else{
				if(numAttempts < 1){
					over = true;
					lost = true;
					return "Game Over. You've lost";
				}
				else{
					numAttempts --;
					return mGuess>number?"Go Lower":"Go Higher";
				}
				
			}
		}
		
	}
	public String getRange(){
		return Integer.toString((1<<(difficulty+3)));
	}
	public boolean isOver(){
		return over;
	}
	public boolean isLost(){
		return lost;
	}
	public int getGuesses(){
		return numAttempts;
	}
	public int getDifficulty(){
		return difficulty;
	}
  
}
 
