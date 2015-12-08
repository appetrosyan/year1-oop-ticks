package uk.ac.cam.ap886.oopjava.supervision3;

public class StateGreetActual {
	public static void main(String[] args){
		StateContext sc = new StateContext();
		
		for(int i=0;i<5;i++){
			sc.greet("Stephen");
		}
	}
}
