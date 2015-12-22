package uk.ac.cam.ap886.oopjava.supervisionProjects.CyberPet;

import java.util.Iterator;


public class Game {

	public static final int  SUPPORTED_PETS=3;
	private Player p;	//Could make an array in the future
	private UserInterface ui;

	public UserInterface getUi() {
		return ui;
	}

	public void setUi(UserInterface ui) {
		this.ui = ui;
	}

	public Game(){
		ui = new CommandLineInterface(this);
		Pet[] pets=(Pet[])ui.getPlayerPets();
		p = new Player(ui.getPlayerName(),pets,this);
	}

	public Player getPlayer(){
		return p;
	}

	public int getSupportedPets() {
		return SUPPORTED_PETS;
	}

	public static void main(String[] args){
		Game g = new Game();		
		//calls the constructor and creates a player. Plus SOme additional Maintenance
		//The class is structured in such a way taht you could create an array of games
		//and run all of them on different threads, all witgh their own player. 
		//IF you want to there could be multiple players in a single game, in that case 
		//there's no intersection between Different players' pets.
		do{
			try{
				g.getPlayer().act(g.getUi().actionPrompt());
			}catch(ArrayIndexOutOfBoundsException error){
				System.out.println("AN error occurred. retrying.");
				continue;
			}
			Iterator<Pet> it = g.getPlayer().getPets().values().iterator();
			while(it.hasNext()){
				Pet p = (Pet)it;
				p.update();
			}
			

		}while(g.getUi().continuePrompt());

	}

}
