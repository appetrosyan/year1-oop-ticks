package uk.ac.cam.ap886.oopjava.supervision.cyberPet;

import java.util.HashMap;

public class Player {
	private String name;
	private Game game;
	private String[] petNames;
	private HashMap<String,Pet> pets=new HashMap<String,Pet>();	
	//At this point support only three pets.
	
	//--------------------------------------------------
	public Player (String newName, Pet[] newPets, Game newGame){
		//Want to avoid passing the reference. 
		game = newGame;
		petNames = new String[Game.SUPPORTED_PETS];
		setName(newName);
		try{
		for(int i=0;i<newPets.length;i++){
			petNames[i]=new String(newPets[i].NAME);
			pets.put(newPets[i].NAME, newPets[i]);
		}
		}catch (IndexOutOfBoundsException error){
			System.out.println("Internal error::");
		}
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void act (Action predicate){
		UserInterface ui = game.getUi();
		String petName = predicate.PET_NAME==null?petNames[predicate.PET_INDEX]:predicate.PET_NAME;
		if(!pets.containsKey(petName )){
			throw new IndexOutOfBoundsException();
		}
		else{
		switch (predicate.ACTION_TYPE.toLowerCase().trim()){
		case "play":
			pets.get(petName).play();
			break;
		case "feed":
			pets.get(petName).feed(ui.feedPrompt());
			break;
		case "sleep":
		case "let be":
			pets.get(petName).sleep();
			break;
		case "status":
		case "check":
			pets.get(petName).respond();
			break;
		default:
				System.out.println("Unrecognised action. Defaulting to update");
		}
		}
		
	}
	
	public HashMap<String,Pet> getPets() {
		return pets;
	}


	//Done
}
