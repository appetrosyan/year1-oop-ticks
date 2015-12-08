package uk.ac.cam.ap886.oopjava.tick4;

@SuppressWarnings("serial")//Not going to serialise
public class CommandLineException extends Exception {
	public CommandLineException (String message){
		super(message);
	}
}
