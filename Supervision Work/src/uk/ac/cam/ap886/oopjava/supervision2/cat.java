package uk.ac.cam.ap886.oopjava.supervision2;

public class cat extends animal implements pet {

	public cat() {
		super (0,4,"Garfield");
	}

	public cat(int mLegs, int mAge, String mName) {
		super(mLegs, mAge, mName);
		
	}

	@Override
	public void pet() {
		//Scratch the eyes of the owner out
		//Cats generally don't like being pet
		//Or they do. Suggest Import java.util.random

	}

	@Override
	public void bond() {
		System.out.println("Sleep all day behave like a jerk"); 

	}

	@Override
	protected void live() {
		//breather();
		//heartBeat(50);
		//etc.
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

}