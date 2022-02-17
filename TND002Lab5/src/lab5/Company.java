package lab5;

import java.util.ArrayList;
import java.util.Collections;

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
	// It creates a title string that depends on the sorting criterion, it sorts the list of employees 
	// according to the criterion and concatenates the return values of the toString methods of all employees to one large string, which is then returned.
	public String toString() {

		String header = "List of Employees\n"
					  + "-----------------\n";
		
		header = header + String.format("%-12s %-12s %-8s ", "First name", "Surname", "Number");
		if(Employee.sortCriterion == Employee.BYSALARY) {
			header = header + String.format("%-12s", "Salary");
		} else if(Employee.sortCriterion == Employee.BYTAXES) {
			header = header + String.format("%-12s", "Taxes");
		}
		header = header + "\n\n";
		Collections.sort(employeeList);
		String body = "";
		for (Employee employee : employeeList) {
			body = body + employee.toString();
		}
		
		return header + body;
	}

}
