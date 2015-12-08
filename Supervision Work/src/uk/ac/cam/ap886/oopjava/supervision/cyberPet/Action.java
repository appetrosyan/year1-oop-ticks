package uk.ac.cam.ap886.oopjava.supervision.cyberPet;

public class Action {
	/*
	 * Not a true class, more of a strucutre. contains PET_INDEX;  ACTION_TYPE
	 * */
	
	public final int 	PET_INDEX;
	public final String ACTION_TYPE;
	public final String PET_NAME;
	public Action(int newIndex, String newType){
		PET_INDEX = newIndex;
		ACTION_TYPE= newType;
		PET_NAME = null;
	}

	public Action(String newPetName,String newType){
		PET_INDEX = -1;
		ACTION_TYPE= newType;
		PET_NAME = newPetName;
	}
	//DONE
}
