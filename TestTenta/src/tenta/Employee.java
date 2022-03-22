package tenta;

public class Employee {

	private String theName;
	private String profession;
	private double salary;
	private Employee allocatedDirector;
	
	public Employee(String theName, String profession, double salary){
		this.theName = theName;
		this.profession = profession;
		this.salary = salary;
		allocatedDirector = null;
	}
	
	public String getProfession() {
		return this.profession;
	}
	
	public Employee getAllocation() {
		return allocatedDirector;
	}
	
	public void setAllocation(Employee director) {
		if(this.profession.equals("Worker")) {
			this.allocatedDirector = director;
		}
	}
	
	public String getName() {
		return this.theName;
	}
	
	public double getSalary() {
		return this.salary;
	}	
	
	public String toString() {
		return "Employee’s details : " + this.theName + " : " + this.profession + " : " + this.salary;
	}
}
