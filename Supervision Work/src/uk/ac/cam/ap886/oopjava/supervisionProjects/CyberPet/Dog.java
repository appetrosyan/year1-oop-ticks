package uk.ac.cam.ap886.oopjava.supervisionProjects.CyberPet;

public class Dog extends Pet {

	public Dog(String newName,Game newGame){
		super(newName,newGame);
	}

	@Override
	public void play() {
		if(fatigue<=70){
			System.out.println("My FLuffy Friend "+ this.NAME+" Wants to play?");
			try{
				Thread.sleep(2000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}finally{		
				System.out.println("												");
				System.out.println("                             _					");
				System.out.println("                          ,:'/   _..._			");
				System.out.println("                         // ( `~~-.._.'			");
				System.out.println("                         \\| /    6\\___          ");
				System.out.println("                         |     6      4         ");
				System.out.println("                        |            /          ");
				System.out.println("                         \\_       .--'          ");
				System.out.println("                         (_'---'`)              ");
				System.out.println("                         / `'---`()             ");
				System.out.println("                       ,'        |              ");
				System.out.println("       ,            .'`          |              ");
				System.out.println("       )\\       _.-'             ;              ");
				System.out.println("      / |    .'`   _            /               ");
				System.out.println("    /` /   .'       '.        , |               ");
				System.out.println("   /  /   /           \\   ;   | |               ");
				System.out.println("   |  \\  |            |  .|   | |               ");
				System.out.println("    \\  `~|           /.-' |   | |               ");
				System.out.println("     '-..-\\       _.;.._  |   |.;-.             ");
				System.out.println("           \\    <`.._  )) |  .;-. ))            ");
				System.out.println("           (__.  `  ))-'  \\_    ))'             ");
				System.out.println("               `'--@`  jgs  `~~~               ");
				System.out.println("                                                ");
				System.out.println("                                                ");
				System.out.println("                                                ");
				System.out.println("                                                ");
				System.out.println("                                                ");
				System.out.println("                                                ");
			}
			this.fatigue+=23;
			//Dogs are generally eager pets;
		}
		else{
			System.out.println("I'm too tired to play... Woof!");
		}
	}                                                                       
                                                                            
	@Override                                                               
	public void sleep() {
		System.out.print("Even The Eager souls of Dogs sometimes get tired");
		System.out.print(".");
		this.fatigue= 0;		
		try{
			Thread.sleep(500);
			System.out.print(".");
			this.satiation+=10;//So that a dog doesn't die in its sleep
			Thread.sleep(500);
			System.out.println(".");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Override
	public String toString(){
		return "Dog, named " +NAME; 
	}
}
