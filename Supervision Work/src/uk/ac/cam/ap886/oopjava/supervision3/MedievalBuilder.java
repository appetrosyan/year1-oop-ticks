package uk.ac.cam.ap886.oopjava.supervision3;

public class MedievalBuilder{
	//Person - specific
	int age=0;
	String name=null;
	String Surname=null;

	//Optional parameters
	String dukeOf=null;
	String viscountOf=null;
	String lordName=null;
	String lordOf=null;
	boolean gender=false;
	String knownFor=null;


	public MedievalBuilder(){}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getDukeOf() {
		return dukeOf;
	}

	public void setDukeOf(String dukeOf) {
		this.dukeOf = dukeOf;
	}

	public String getViscountOf() {
		return viscountOf;
	}

	public void setViscountOf(String viscountOf) {
		this.viscountOf = viscountOf;
	}

	public String getLordName() {
		return lordName;
	}

	public void setLordName(String lordName) {
		this.lordName = lordName;
	}

	public String getLordOf() {
		return lordOf;
	}

	public void setLordOf(String lordOf) {
		this.lordOf = lordOf;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getKnownFor() {
		return knownFor;
	}

	public void setKnownFor(String knownFor) {
		this.knownFor = knownFor;
	}



}