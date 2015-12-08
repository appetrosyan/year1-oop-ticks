package uk.ac.cam.ap886.oopjava.supervision.cyberPet;

public interface UserInterface {
	public String 	getPlayerName();
	public CyberPet[] 	getPlayerPets();
	public Action 	actionPrompt();
	public boolean 	continuePrompt();
	public Meal 	feedPrompt();
	//Done
}
