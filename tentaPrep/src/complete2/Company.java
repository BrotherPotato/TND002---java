package complete2;
import java.util.*;
public class Company {
	private ArrayList<Employee> theList; 
	public Company() {
		theList = new ArrayList<Employee>();
	}
	
	public void addEmployee(Employee arg) {
		theList.add(arg);
	}
	
	public ArrayList<Employee> availableWorkers() {
		ArrayList<Employee> freeWorkers = new ArrayList<Employee>();
		for (int j = 0; j < theList.size(); j++) {
			if (theList.get(j).getProfession().equals("Worker") && theList.get(j).getAllocation() == null) {
				freeWorkers.add(theList.get(j));
			}
		}
		return freeWorkers;
	}
			
	public double getTaxes() {
		double taxes = 0; double bonus; Employee dummy;
		for (int j=0; j < theList.size();j++) {
			taxes = taxes + (theList.get(j).getSalary() * 0.25);
			if ((dummy = theList.get(j)).getProfession().equals("Director")) {
				bonus = 0.0;
				for (int k=0; k < theList.size(); k++) {
					if (dummy == theList.get(k).getAllocation()) bonus = bonus + 0.2*theList.get(k).getSalary(); 
				}
				taxes = taxes + 0.25*bonus;
			}
		}
		return taxes;
	}
	
	public Employee getDirector(String arg) {
		Employee dummy = null;
		for (int j=0 ; j < theList.size(); j++) {
			if (theList.get(j).getName().equals(arg) && theList.get(j).getProfession().equals("Director")) {
				dummy = theList.get(j);
			}
		}
		return dummy;
	}
	
	public String toString() {
		String result = "Company information : \n";
		result = result + "Number of employees : " + theList.size() + "\n";
		result = result + "Total taxes paid : " + getTaxes() + "\n";		
		return result;
	}
}
