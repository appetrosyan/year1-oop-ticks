package uk.ac.cam.ap886.oopjava.supervision2;

public class EmployeeNinja extends Employee implements Ninja {
	protected int health;
	protected int damage;
	public EmployeeNinja() {
		super (40000, 22); //Ninja Recruits are usually higher paid and 
							//younger. 
	}

	public EmployeeNinja(int mSalary, int mAge) {
		super(mSalary, mAge);
		health = 100;
	}
	public EmployeeNinja(int mSalary, int mAge, int mHealth) {
		super(mSalary, mAge);
		health = mHealth;
	}
	@Override
	public void ThrowShuriken() {
		//Throw the SHuriken bending hand inwards. 
		//Or specify any other technique 
		//Deal Damage damage. 
		System.out.println("Jaguar claws away");
	}

	@Override
	public int getHealth() {
		
		return health;
	}

	@Override
	public void receiveDamage(int damage) {
		health -= damage;
	}
	public static void main(String [] args){
		EmployeeNinja shippuden = new EmployeeNinja(50000,18,2000);
		shippuden.work();			//EMployee method
		shippuden.ThrowShuriken();	//Ninja method
	}
}