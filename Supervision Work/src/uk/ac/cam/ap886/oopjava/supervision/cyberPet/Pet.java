package uk.ac.cam.ap886.oopjava.supervision.cyberPet;

public abstract class Pet implements CyberPet{
	
	protected Game game;
	protected final String NAME;
	protected int fatigue = 30;
	protected int satiation = 100;
	
	//-----------------------------------------
	

	
	public Pet (String newName,Game newGame){
		NAME = newName;
		game = newGame;
	}
	
	@Override
	public void feed(Meal m) {
		if(satiation >100){
			System.out.println("The Poor "+ this+" seems to be full");
		}else if(satiation>60){
			System.out.println(this + " happily eats the "+ m.toString().toLowerCase());
		}else if(satiation>0){
			System.out.println(NAME + " seems to be extremely hungry.");
		}else{
			System.out.println("It's no use feeding a dead pet.");
		}
		
	}
	
	@Override
	public abstract void play();

	@Override
	public void respond(){
		String tired =fatigue>50? " tired and sleepy":" Ready to play";
		String conjunctor;
		String hungry;
		if(satiation >100){
			hungry = " overfed";
			conjunctor = fatigue>50?" as well as":" but";
		}else if(satiation>60){
			hungry = " well nourished";
			conjunctor = fatigue>50?" though":" and";
		}else if(satiation>0){
			hungry = " hungry";	 
			conjunctor = fatigue>50?" as well":" and definitely not";
		}else{
			System.out.println("A dead pet cannot speak.");
			return;
		}
		System.out.println("Hi, "+game.getPlayer().getName()+"! I'm currently"+hungry+conjunctor+tired);
	}
	
	@Override
	public abstract void sleep();
	
	public void update(){
		satiation-=3;
		fatigue+=4;		
	}
		
	//DONE
		
	}
	


