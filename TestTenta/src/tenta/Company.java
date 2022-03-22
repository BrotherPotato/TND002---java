package tenta;

import java.util.ArrayList;

public class Company {
	
	private ArrayList<Employee> theList;
	
	public Company() {
		theList = new ArrayList<Employee>();
	}
	
	public void addEmployee(Employee employee) {
		this.theList.add(employee);
	}
	
	public ArrayList<Employee> availableWorkers() {
		ArrayList<Employee> availableWorkerList = new ArrayList<Employee>();
		
		for (Employee employee : theList) {
			if(employee.getProfession().equals("Worker") && employee.getAllocation() == null) {
				availableWorkerList.add(employee);
			}
		}
		return availableWorkerList;
	}
	
	public double getTaxes() {
		double taxes = 0;
		double bonus;
		for (Employee employee : theList) {
			taxes += employee.getSalary() * 0.25;
			if(employee.getProfession().equals("Director")) {
				bonus = 0;
				for (Employee employee2 : theList) {
					if(!availableWorkers().contains(employee2) && employee2.getAllocation() != null) {
						if(employee2.getAllocation().equals(employee)) {
							bonus += employee2.getSalary() * 0.1;
						}
					}
				}
			taxes += bonus * 0.25;
			}
		}
		return taxes;
	}
	
	public Employee getDirector(String name) {
		for (Employee employee : theList) {
			if(employee.getName().equals(name) && employee.getProfession().equals("Director")) {
				return employee;
			}
		}
		return null;
	}
	
	public String toString() {
		String output = "Company information :" + "\n" +
						"Number of employees :" + theList.size() + "\n" +
						"Total taxes paid :" + getTaxes();
		return output;
	}
}
