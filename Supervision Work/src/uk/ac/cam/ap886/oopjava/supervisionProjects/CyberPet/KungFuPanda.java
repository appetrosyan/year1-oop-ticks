package uk.ac.cam.ap886.oopjava.supervisionProjects.CyberPet;

public class KungFuPanda extends Pet {

	public KungFuPanda(String newName,Game newGame){
		super(newName,newGame);
	}

	@Override
	public void play() {
		if(fatigue<=20){
			System.out.println("You sure are fun to watch, "+ this.NAME+".");
			try{
				Thread.sleep(2000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}finally{		
				
				System.out.println("░░░░░░░░██░▀▀▀▀▄██▄░░░░░░░░░░░░░ "); 
				System.out.println("██▄░░░░░█░░░░░░▀▀▀▄░░░░░░░░░░░░░ "); 
				System.out.println("░█▀▄▄░░█▀▄░░▄░░░░░█░░░░░░░░▄▄▄██ "); 
				System.out.println("░█▄▄▄▀█▀█▀░▀██░░░█▄█▄░░░▄█████▀▀ "); 
				System.out.println("▀█▄████▄░▄▄░░░░▄▄████████████▀░░ ");
				System.out.println("░▀██████▄▄▄▄▄██████████████▄█░░░ "); 
				System.out.println("░░░▀█████████████████████▀▀░░░░░ "); 
				System.out.println("░░░░░▀▀██████████████▀▀░░░░░░░░░ ");
				System.out.println("░░░░░░░█▀▀▀▀▀░░▀░░░▀█░░░░░░░░░░░ ");
				System.out.println("░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░ ");
				System.out.println("░░░░░█░░░░░░░░░░░░░░░█░░░░░░░░░░ ");
				System.out.println("░░░░░█░░░░░░░░░░░░░░░█░░░░░░░░░░ ");
				System.out.println("░░░▄████▄▄░░░░░░░░░░██░░░░░░░░░░ ");
				System.out.println("░░▄████████░░░░░░░▄███░░░░░░░░░░ ");  
				System.out.println("░░█████████▄▄▄▄███████░░░░░░░░░░ "); 
		        System.out.println("░░███████░░░░░░████████░░░░░░░░░ "); 
		        System.out.println("░░▀▀█████░░░░░░░▀▀████▀░░░░░░░░░ "); 
		        //Kung fu Panda, sorry, no Ninja warrior on the net
			}                         
			this.fatigue+=80;         
		}   //A KungFuPanda really has to wear itself out                      　　　　　
		else{                                                  
			System.out.format("What. No no more bamboo mommy! %n"
					+ "I don't want to go to school%n");  
		}                                                      
		                                                       
		                                                       

	}

	@Override
	public void sleep() {
		System.out.print("Pandas need more sleep");
		System.out.print(".");
		this.fatigue= 0;		
		try{
			Thread.sleep(500);
			System.out.print(".");
			//this.satiation+=10; 
			//A fish on the other hand can very well die in its sleep
			Thread.sleep(500);
			System.out.print(".");
			for(int i=0;i<4;i++){
				Thread.sleep(500);System.out.print(".");
			}			
			System.out.println();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public String toString(){
		return "Master "+NAME;
	}

}
