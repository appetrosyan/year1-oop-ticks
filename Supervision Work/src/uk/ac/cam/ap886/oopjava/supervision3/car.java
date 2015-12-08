package uk.ac.cam.ap886.oopjava.supervision3;

public class car implements Comparable<car> {

	private String manufacturer;
	private int age;
	
	@Override
	public int compareTo(car pivot) {
		if(0 != this.manufacturer.compareTo(pivot.manufacturer))
				return this.manufacturer.compareTo(pivot.manufacturer);
		else 
				//Could do 
				//return this.age - pivot.age;
						
				//But this 
				return new Integer(this.age).compareTo(new Integer(pivot.age));
				//is safer, because if the Java Developers decide to 
				//change the specifications of compareTo, this will change too.
				
	}

}
