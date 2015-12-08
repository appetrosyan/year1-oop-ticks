package uk.ac.cam.ap886.oopjava.supervision2;

public class puppy extends animal implements pet {
	
	public puppy() {
		super(0,4,"Sparky"); //Creates a four legged animal named Sparky
	}

	public puppy(int mLegs, int mAge, String mName) {
		super(mLegs, mAge, mName);	//Could be a homeless cripple. 
	}

	@Override
	public void pet() {
		//Allow the human to pet you. 
		//Dogs generally enjoy this, as opposed to cats. 
	}

	@Override
	public void bond() {
		System.out.println("Make puppy eyes etc. etc.");

	}

	@Override
	protected void live() {
		//breathe();
		//heartBeat (80);
		//etc. 

	}

}
