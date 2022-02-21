package lab5;

/**
 * @author Max 
 * @version 1.0
 * THIS CLASS DOES THE EMPLOYEE THINGS
 */

import java.util.Locale;
/** THIS DEFINES THE CLASS*/
public abstract class Employee extends Object implements Comparable<Employee> {
	/** THE FIRST NAME OF A EMPLOYEE */
	protected String firstName;
	/** THE SECOUND NAME OF A EMPLOYEE */
	protected String secondName;
	/** THE EMPLOYEE NUMBER OF A EMPLOYEE */
	protected int employeeNumber;
	/** THE SALARY OF A EMPLOYEE */
	protected double salary;
	/** THE FIRST NAME OF A EMPLOYEE */
	protected static int sortCriterion = 0;
	/** Sorts the list of employees by the surname. */
	public static final int BYNAME = 0; 
	/** Sorts the list of employees by the salary. */
	public static final int BYSALARY = 1;
	/** Sorts the list of employees by the paid taxes. */
	public static final int BYTAXES = 2;
	
	/** Constructor for an Employee 
	 * @param firstName is firstname
	 * @param secondName last name
	 * @param employeeNumber employee number
	 * @param salary is the salary
	 */
	public Employee(String firstName, String secondName, int employeeNumber, double salary) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.employeeNumber = employeeNumber;
		this.salary = salary;
	}
	/** This instance method returns the surname of the employee. 
	 * @return returns the surname of an employee
	 * */
	public String getName() {
		return this.secondName;
	}
	/** This instance method returns the employee's number. 
	 * @return returns the employee number 
	 * */
	public int getNumber() {
		return this.employeeNumber;
	}
	/** This instance method returns the salary of the employee. 
	 * @return returns an employees salary
	 * */
	public double getSalary() {
		return this.salary;
	}
	
	/** This class method allows you to change the criterion by which the employees are sorted. 
	 * @param orderBy the criterion to change the set criterion to
	 * */
	public static void changeCriterion(int orderBy) {
		sortCriterion = orderBy;
	}
	/** This instance method returns the taxes paid by the employee and it is implemented in the subclasses 
	 * @return returns the taxes
	 * */
	public abstract double computeTaxes();
	
	/** The information about the employee is returned in the form first name (12 characters), second name (12 characters) and employee number (8 characters).
	 * If you sort by paid taxes you also attach the value of the paid taxes.
	 *  This function returns information about the employee, the information depends on the current sort criterion, 
	 * first name (12 characters), second name (12 characters) and employee number (8 characters)
	 * @return returns the information about a employee depending on the sortCriterion
	 * */
	public String toString() {
		if(sortCriterion == Employee.BYSALARY) {
			return String.format(Locale.US, "%-12s %-12s %-8d %-12.6f\n", this.firstName, this.getName(), this.getNumber(), this.getSalary());
		} else if(sortCriterion == Employee.BYTAXES) {
			return String.format(Locale.US, "%-12s %-12s %-8d %-12.6f\n", this.firstName, this.getName(), this.getNumber(), this.computeTaxes());
		} else {
			return String.format(Locale.US, "%-12s %-12s %-8d\n", this.firstName, this.getName(), this.getNumber());
		}
	}
}
