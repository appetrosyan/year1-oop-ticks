package uk.ac.cam.ap886.oopjava.supervision3;

public class EagerSingleton {
	private static final EagerSingleton INSTANCE = new EagerSingleton();
	
	private EagerSingleton (){
		//Can't do anything at this point, because there's only one field;
	}
	
	public static EagerSingleton getInstance(){
		return INSTANCE;
	}
}
