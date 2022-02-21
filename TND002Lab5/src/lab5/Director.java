package lab5;

/**
 * @author Max 
 * @version 1.0
 * THIS SUB CLASS DOES THE DIRECTOR THINGS
 */

import java.util.ArrayList;
/** THIS DEFINES THE CLASS*/
public class Director extends Employee {

	/** THIS IS THE LIST OF WORKERS UNDER EACH DIRECTOR */
	private ArrayList<Employee> workerList = new ArrayList<Employee>();
	
	/** This constructor is called with the details of the worker and it passes these on to the constructor of the superclass. 
	 * @param firstName is firstname
	 * @param secondName last name
	 * @param employeeNumber employee number
	 * @param salary is the salary
	 */
	public Director(String firstName, String secondName, int employeeNumber, double salary) {
		super(firstName, secondName, employeeNumber, salary);
	}
	/** This instance method adds a worker to the list of subordinates of the director. 
	 * @param worker - this is a worker
	 * */
	public void addEmployee(Worker worker) {
		workerList.add(worker);
	}
	
	
	/** This instance method computes the bonus of the director. 
	 * The bonus equals the 10 per cent of the cumulative salary of all his/her subordinates.
	 * @return returns the bonus depending on the workers under the director
	 */
	public double computeBonus() {
		double bonus = 0;
		for (Employee employee : workerList) {
			bonus = bonus + employee.getSalary() * 0.1;
		}
		return bonus;
	}
	/** This instance method computes the taxes the director has to pay. The taxes are 25 per cent of the sum of the salary and the bonus. 
	 * @return returns the taxes for the director
	 * */
	public double computeTaxes() {
		double taxes = (this.getSalary() + this.computeBonus()) * 0.25;
		return taxes;
	}
	
	/** This instance method compares two employees. 
	 * @param employee - another employee to compare to
	 * @return returns -1, 0, 1 depending on the current criterion 
	 * */
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
}
