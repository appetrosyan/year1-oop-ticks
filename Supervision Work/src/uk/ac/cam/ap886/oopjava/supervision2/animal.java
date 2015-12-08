package uk.ac.cam.ap886.oopjava.supervision2;
public abstract class animal{
	protected int age;
	protected int numberOfLegs;
	protected String name;
	public animal (){
		age = 0;
		numberOfLegs = 4;
		name = "Homeless vagrant";
	}
	public animal (int mLegs, int mAge, String mName){
		age = mAge;
		numberOfLegs = mLegs;
		name = mName;
	}
	public int getAge(){
		return age;
	}
	public int getLegs(){
		return numberOfLegs;
	}
	public String getName(){
		return name;
	}
	protected abstract void live();
		
	}
	