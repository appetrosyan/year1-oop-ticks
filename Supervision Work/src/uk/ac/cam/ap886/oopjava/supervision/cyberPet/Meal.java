package uk.ac.cam.ap886.oopjava.supervision.cyberPet;

public abstract class Meal  {
	private int VALUE; 	//Intrinsically immutable therefore constant
	
	protected Meal(int newValue){
		VALUE = newValue;	//Shouldn't be able to create uncreative meals
							//Don't have default appearance, name therefore 
	}
	//------------------------
	public int getNutrientValue(){
		return VALUE;
	}
	//DONE
}
