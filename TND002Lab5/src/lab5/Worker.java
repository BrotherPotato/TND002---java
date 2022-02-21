package lab5;

/**
 * @author Max 
 * @version 1.0
 * THIS SUB CLASS DOES THE WORKER THINGS
 */
/** THIS DEFINES THE CLASS*/
public class Worker extends Employee {

	/** This constructor is called with the details of the worker and it passes these on to the constructor of the superclass. 
	 * @param firstName is firstname
	 * @param secondName last name
	 * @param employeeNumber employee number
	 * @param salary is the salary
	 */
	public Worker(String firstName, String secondName, int employeeNumber, double salary) {
		super(firstName, secondName, employeeNumber, salary);
	}
	
	/** This instance method compares two employees.
	 *  a value -1, 0, 1 depending on if the salary of this employee is higher, equal or lower than that of arg. 
	 *  @param employee to compare to
	 *  @return -1, 0 or 1 
	 *  */
	public int compareTo(Employee employee) {
		if(sortCriterion == Employee.BYNAME) {
			return Integer.signum(this.getName().compareTo(employee.getName()));
		}
		
		if(this.getSalary() > employee.getSalary()) {
			return -1;
		} else if(this.getSalary() == employee.getSalary()) {
			return 0;
		} else {
			return 1;
		}
	}
	
	/** This instance method computes the taxes the worker has to pay. The taxes are 25 per cent of the salary. 
	 * @return returns the taxes (25% of the salary)
	 * */
	public double computeTaxes() {
		return this.getSalary() * 0.25;
	}

}
