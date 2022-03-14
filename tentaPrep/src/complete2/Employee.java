package complete2;
import java.util.*;
public class Employee {	
	private String theName;
	private String profession;
	private double salary;
	private Employee allocatedDirector = null;
	
	public Employee(String profession, String theName, double salary) {
		this.profession = profession; 
		this.theName = theName; 
		this.salary = salary; 
	}
	
	public String getProfession() {
		return profession;
	}
		
	public Employee getAllocation() {
		return allocatedDirector;
	}
	
	public void setAllocation(Employee arg) {
		if (!profession.equals("Director") && arg.getProfession().equals("Director")) {
			allocatedDirector = arg;
		}
	}
	
	public String getName() {
		return theName;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public String toString() {
		return "Employee's details : " + this.theName + ", " + this.profession + ", " + this.salary + "\n";
	}
}
