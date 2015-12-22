package uk.ac.cam.ap886.oopjava.supervisionProjects.CyberPet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CommandLineInterface implements UserInterface {

	private BufferedReader c = new BufferedReader(new InputStreamReader(System.in));
	private Game game;
	
	//--------------------------------------------------------------------------
	
	public CommandLineInterface (Game newGame){
		game = newGame;
	}

	@Override
	public String getPlayerName() {
		System.out.format("%n-------------------%nPlease Type in Your Name %n -> ");
		try {
			return 	c.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Pet[] getPlayerPets() {
		Pet[] pets = new Pet[Game.SUPPORTED_PETS];
		String petType=new String();
		String petName=new String();
		for(int i=0;i<Game.SUPPORTED_PETS;i++){
			System.out.print("Please Choose type of pet_"+i+" -> "); //Would look better in Latex
			try {
				petType = c.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.print("How would you like to name your pet -> ");
			try {
				petName = c.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			pets[i] = parseToPet(petType, petName);
			
			//DEBUG
			System.out.println("Created "+ pets[i]);
		}
		return pets;
	}

	private Pet parseToPet(String petType,String petName) {
		switch (petType.toLowerCase().trim()){

		case "kung fu":
		case "kungfu":
		case "ninja":
		case "panda":
			return new KungFuPanda(petName,game);
		case "fish":
		case "fishie":
		case "fisher":
		case "aquarium":
			return new Fish(petName,game);
		case "dog":
		case "doge":
		case "doggie":
		default:
			return new Dog(petName,game);
		}
	}

	private Meal parseToMeal(String mealName){
		switch (mealName.toLowerCase()){
		case "snickers":
		case "mars":
		case "bounty":
		case "treat":
		case "chocolate":
			return new ChocolateBar();
		case "carrot":
		case "veg":
		case "vegetable":
			return new Carrot();
		case "cracker":
		case "food":
		case "default":
		default:
			return new Cracker();
		}
	}

	@Override
	public Action actionPrompt() {
		System.out.format("Please Specify what you want to do:%n"
				+ "[Action Keyword] [Pet Number]%n%n");
		String[] input;
		try {
			input = c.readLine().split(" ");
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		int petIndex = 0;//Defaults to 0;
		while(input.length<2){
			System.out.println("Invalid input. Should be [Action Keyword] [Pet Number]");
			try {
				input = c.readLine().split(" ");
			} catch (IOException e) {
				e.printStackTrace();
				return null;
			}
		}
		try{
			petIndex = Integer.parseInt(input[1]);
			if(petIndex<0){
				throw new NumberFormatException();
			}
		}catch(NumberFormatException error){
			return new Action(input[1],input[0]);
		}

		//Action String Recognition should be in the Act Method


		return new Action(petIndex, input[0]) ;
	}

	@Override
	public boolean continuePrompt() {
		System.out.println("Would you like to quit?");
		String input=new String();
		try {
			input = c.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		switch (input.toLowerCase()){
		case "yes":
		case "oui":
		case "yup":
		case "y":
		case "yeah I'd like to quit, please":
			return false;
		default:
			return true;
		}
	}

	@Override
	public Meal feedPrompt(){
		//In future would allow to select what to feed. now feeds 
		//the last thing on the list.
		System.out.println("What would you like to feed?");
		try {
			return parseToMeal(c.readLine());
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}


	}
	

}
