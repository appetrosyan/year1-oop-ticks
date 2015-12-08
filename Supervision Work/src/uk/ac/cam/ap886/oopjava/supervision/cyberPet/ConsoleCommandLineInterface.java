package uk.ac.cam.ap886.oopjava.supervision.cyberPet;

import java.io.Console;


public class ConsoleCommandLineInterface implements UserInterface {

	private Console c =System.console();
	
	private Game game;

	//--------------------------------------------------------------------------

	public ConsoleCommandLineInterface (Game newGame){
		game = newGame;
	}
	public ConsoleCommandLineInterface(){
		try{
			c = System.console();
			if(c==null){
				throw new NullPointerException("This is silly"); 
			}//Returns Null in every instance
		}catch (NullPointerException e){
			System.out.println(e.getMessage());
		}
	}


	@Override
	public String getPlayerName() {
		System.out.println("Please Type in the User Name ");
		return 	c.readLine();
	}

	@Override
	public Pet[] getPlayerPets() {
		Pet[] pets = new Pet[Game.SUPPORTED_PETS];
		String petType;
		String petName;
		for(int i=0;i<Game.SUPPORTED_PETS;i++){
			System.out.println("Please Choose type of pet_"+i); //Would look better in Latex
			petType = c.readLine();
			System.out.println("How would you like to name your pet");
			petName = c.readLine();
			pets[i] = parseToPet(petType, petName);
		}
		return pets;
	}

	private Pet parseToPet(String petType,String petName) {
		switch (petType.toLowerCase()){

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
		String[] input = c.readLine().split(" ");
		int petIndex = 0;//Defaults to 0;
		while(input.length<2){
			System.out.println("Invalid input. Should be [Action Keyword] [Pet Number]");
			input = c.readLine().split(" ");
		}
		try{
			petIndex = Integer.parseInt(input[1]);
			if(petIndex<0){
				throw new NumberFormatException();
			}
		}catch(NumberFormatException error){
			System.out.print("Invalid Input.");
			System.out.println("Second argument should be a "
					+ "positive integer "+input[1]+" given." );
		}

		//Action String Recognition should be in the Act Method


		return new Action(petIndex, input[0]) ;
	}

	@Override
	public boolean continuePrompt() {
		System.out.println("Would you like to quit?");
		String input = c.readLine();
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
		return parseToMeal(c.readLine());


	}
	public static void main(String[] args){
		ConsoleCommandLineInterface ui = new ConsoleCommandLineInterface();
		System.out.println(ui.c.readLine());
	}

}
