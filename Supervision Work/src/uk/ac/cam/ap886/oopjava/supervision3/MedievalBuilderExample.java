package uk.ac.cam.ap886.oopjava.supervision3;

public class MedievalBuilderExample {
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

	public MedievalBuilderExample(MedievalBuilder capsule){
		//Should always find something to initialise with
		age = capsule.getAge();
		name = capsule.getName()==null?"Anonymous":capsule.getName();
		Surname = capsule.getSurname()==null?"Unfamiliate":capsule.getSurname();
		
		
		//Don't really have to be initialised
		dukeOf = 		capsule.getDukeOf();
		viscountOf = 	capsule.getViscountOf();
		lordName = 		capsule.getLordName();
		lordOf = 		capsule.getLordOf();
		gender = 		capsule.isGender();
		knownFor = 		capsule.getKnownFor();
	}
	
	public void prettyPrint(){
		System.out.println(name + " " + Surname + " aged "+age+".");
		
		if(!(dukeOf==null)){
		System.out.print("Is duke of "+dukeOf+". ");
		}
		if(! (viscountOf==null)){
			System.out.print("Viscount de "+viscountOf+". ");
		}
		if(!(lordName ==null)){
			System.out.print("Is known as " + lordName);
			if(!(lordOf==null))
				System.out.print(" lord of " + lordOf+". ");
			else
				System.out.print(". ");
		}
		if(!(knownFor==null)){
			System.out.print("Known for "+(gender?"His ":"her ")+"Deeds in the area of "+knownFor);
		}

	}
	
	public static void main(String[] args){
 
		MedievalBuilder b = new MedievalBuilder();
		b.setAge(50);
		b.setName("Elias");
		b.setSurname("Thompson");
		

		b.setLordName(" Rayleigh");
		b.setLordOf("Staffordshire");
		b.setKnownFor("Physics");
		b.setGender(true);
		
		MedievalBuilderExample rayleigh = new MedievalBuilderExample(b);
		rayleigh.prettyPrint();
		
	}
}
