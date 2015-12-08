package uk.ac.cam.ap886.oopjava.supervision.cyberPet;

public class Fish extends Pet {

	public Fish(String newName,Game newGame){
		super(newName,newGame);
	}

	@Override
	public void play() {
		if(fatigue<=70){
			System.out.println("You sure are fun to watch, "+ this.NAME+".");
			try{
				Thread.sleep(2000);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}finally{		
				System.out.println("     .--~~```                 ```~~--.		");
				System.out.println("            ':--..___             ___..--:'		");
				System.out.println("              \\      ```~~~~~~~```      /		");
				System.out.println("            .-`  ___.....-----.....___  '-.		");
				System.out.println("          .:-~~``     ~          ~    ``~~-:.         ");
				System.out.println("         /`-..___ ~        ~         ~___..-'\\       ");
				System.out.println("        /  ~    '`-----.........---\"\"`        \\       ");
				System.out.println("       ;                                       ;        ");
				System.out.println("      ; '::.   '          _,           _,       ;       ");
				System.out.println("      |   ':::    '     .' (    ~   .-'./    ~  |       ");
				System.out.println("      |~  .:'   .     _/..._'.    .'.-'/        |       ");
				System.out.println("      | .:'       .-'`      ` '-./.'_.'         |       ");
				System.out.println("      |  ':.     ( o)   ))      ;= <_           |        ");
				System.out.println("      ; '::.      '-.,\\\\__ __.-;`\'. '.  .      ;       ");
				System.out.println("       ;    ':         \\) |`\\ \\)  '.'-.\\       ;       ");
				System.out.println("        \\.:'.:':.         \\_/       '-._\\     /        ");
				System.out.println("         \\ ':.     ~                    `    /        ");
				System.out.println("          '. '::..  _ . - - -- .~ _      ~ .'        ");
				System.out.println("            '-._':'                 `'-_.-'        ");
				System.out.println("        jgs    (``''--..._____...--''``)        ");
				System.out.println("                `\"--...__     __...--\"`        ");
				System.out.println("                         `````      			");
				System.out.println("       											");
		
			}
			this.fatigue+=11;
			//Fish don't play you just observe them
		}
		else{
			System.out.println("Gzrp... I need some sleep!");
		}

	}

	@Override
	public void sleep() {
		System.out.print("Surprisingly fish sleep too");
		System.out.print(".");
		this.fatigue= 0;		
		try{
			Thread.sleep(500);
			System.out.print(".");
			//this.satiation+=10; 
			//A fish on the other hand can very well die in its sleep
			Thread.sleep(500);
			System.out.println(".");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public String toString(){
		return NAME + " the Fish";
	}
}
