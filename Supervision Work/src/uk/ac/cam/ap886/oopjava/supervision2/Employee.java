package uk.ac.cam.ap886.oopjava.supervision2;

public abstract class Employee {
	int salary;
	int age;
	public Employee() {
		salary 	= 20000;
		age 	= 26;
	}
	public Employee(int mSalary, int mAge){
		age= mAge;
		salary = mSalary;
	}
	protected void work(){
		System.out.println("I'm busy");
	}
}
