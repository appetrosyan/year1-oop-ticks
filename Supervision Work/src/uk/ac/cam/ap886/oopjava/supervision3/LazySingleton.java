package uk.ac.cam.ap886.oopjava.supervision3;

public class LazySingleton {
	private static LazySingleton instance;
	private LazySingleton(){}
	
	public static LazySingleton getInstance(){
		if (instance == null){
			instance = new LazySingleton();
		}
			return instance;		
	}
}
