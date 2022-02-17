package lab5;

import java.util.Locale;

public abstract class Employee implements Comparable<Employee> {
	public String firstName;
	private String secondName;
	private int employeeNumber;
	private double salary;
	public static int sortCriterion = 0;
	// Sorts the list of employees by the surname.
	public static final int BYNAME = 0; 
	// Sorts the list of employees by the salary.
	public static final int BYSALARY = 1;
	// Sorts the list of employees by the paid taxes.
	public static final int BYTAXES = 2;
	
	// The constructor for an employee.
	public Employee(String firstName, String secondName, int employeeNumber, double salary) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.employeeNumber = employeeNumber;
		this.salary = salary;
	}
	// This instance method returns the surname of the employee.
	public String getName() {
		return this.secondName;
	}
	// This instance method returns the employee's number.
	public int getNumber() {
		return this.employeeNumber;
	}
	// This instance method returns the salary of the employee.
	public double getSalary() {
		return this.salary;
	}
	
	// This class method allows you to change the criterion by which the employees are sorted.
	public static void changeCriterion(int orderBy) {
		sortCriterion = orderBy;
	}
	// This instance method returns the taxes paid by the employee and it is implemented in the subclasses
	public abstract double computeTaxes();
	
	// The information about the employee is returned in the form first name (12 characters), second name (12 characters) and employee number (8 characters).
	// If you sort by paid taxes you also attach the value of the paid taxes.
	public String toString() {
		if(sortCriterion == Employee.BYSALARY) {
			return String.format(Locale.US, "%-12s %-12s %-8d %-12.6f\n", this.firstName, this.getName(), this.getNumber(), this.getSalary());
		} else if(sortCriterion == Employee.BYTAXES) {
			return String.format(Locale.US, "%-12s %-12s %-8d %-12.6f\n", this.firstName, this.getName(), this.getNumber(), this.computeTaxes());
		}
		
		return String.format(Locale.US, "%-12s %-12s %-8d\n", this.firstName, this.getName(), this.getNumber());
	}
}
