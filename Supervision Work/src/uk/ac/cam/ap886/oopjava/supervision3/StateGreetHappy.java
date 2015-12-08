package uk.ac.cam.ap886.oopjava.supervision3;

public class StateGreetHappy implements StateGreet {

	
	
	@Override
	public void greet(StateContext context) {
		System.out.println("Hello, how are you doing? ");
		context.setState(new StateGreetSad());
	}

}
