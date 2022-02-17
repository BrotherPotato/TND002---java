package lab5;

import java.util.ArrayList;

public class Company {

	public ArrayList<Employee> employeeList;
	
	// The constructor takes no argument
	public Company() {
		this.employeeList = new ArrayList<Employee>();
	}
	
	
	// This instance method adds a director to the dynamic array of employees.
	public void addEmployee(Director director) {
		employeeList.add(director);
	}
	// This instance method adds a worker to the dynamic array of employees and attaches it to one director.
	public void addEmployee(Worker worker, Director director) {
		employeeList.add(worker);
		director.addEmployee(worker);
	}
	// This instance method writes out a header followed by the sorted list of employees.
	public String toString() {
		return "";
	}

}
