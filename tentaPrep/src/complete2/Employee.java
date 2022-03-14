package complete2;
import java.util.*;
public class Employee {	
	private String theName, profession;
	private double salary;
	private Employee allocatedDirector = null;
	
	public Employee(String arg1, String arg2, double arg3) {
		profession = arg1; theName = arg2; salary = arg3; 
	}
	
	public String getProfession() {
		return profession;
	}
		
	public Employee getAllocation() {
		return allocatedDirector;
	}
	
	public void setAllocation(Employee arg) {
		if (!profession.equals("Director") && arg.getProfession().equals("Director")) allocatedDirector = arg;
	}
	
	public String getName() {
		return theName;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public String toString() {
		return "Employee's details : " + theName + ", " + profession + ", " + salary + "\n";
	}
}
