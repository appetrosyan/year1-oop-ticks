package uk.ac.cam.ap886.oopjava.supervision3;

public class StateContext {
	private StateGreet mState;
	
	public StateContext (){
		mState = new StateGreetHappy();
	}
	public void setState(StateGreet newState){
		mState = newState;
	}
	public void greet(String name){
		System.out.print("Hey, "+ name + ". ");
		mState.greet(this);
		System.out.format("%n%n%n");
		
	}
}
