package lab5;

public class Worker extends Employee {

	// This constructor is called with the details of the worker and it passes these on to the constructor of the superclass.
	public Worker(String firstName, String secondName, int employeeNumber, double salary) {
		super(firstName, secondName, employeeNumber, salary);
	}
	
	// This instance method compares two employees.
	// a value -1, 0, 1 depending on if the salary of this employee is higher, equal or lower than that of arg.
	public int compareTo(Employee employee) {
		if(this.getSalary() > employee.getSalary()) {
			return -1;
		} else if(this.getSalary() == employee.getSalary()) {
			return 0;
		} else {
			return 1;
		}
	}
	
	// This instance method computes the taxes the worker has to pay. The taxes are 25 per cent of the salary.
	public double computeTaxes() {
		return this.getSalary() * 0.25;
	}

}
