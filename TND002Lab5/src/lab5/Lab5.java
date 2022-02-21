package lab5;

/**
 * @author Max 
 * @version 1.0
 * THIS IS THE MAIN CLASS WHICH DOES THINGS
 */

import javax.swing.*;
/** THIS IS THE MAIN CLASS*/
public class Lab5 extends Object {
	/** THIS IS THE MAIN METHOD
	 * @param args - THIS DOES NOT MATTER
	 * */
	public static void main(String[] args) {
		
		Company theCompany = new Company();
				
		/* Directors are created as objects with an own reference variable because they are added to 
                 * Workers. The entries in the constructor are the first name, surname, employee number and salary. */
		
		Director director1 = new Director("John", "Smith", 1, 700000.0);
		Director director2 = new Director("Elaine", "Garret", 2, 670000.0);
		
		// We add the directors to the company
		
		theCompany.addEmployee(director1);
		theCompany.addEmployee(director2);
		
		// We add workers to the company and assign them to a director. 
		
		theCompany.addEmployee(new Worker("Paul", "Johnson", 3, 400000.0), director1);
		theCompany.addEmployee(new Worker("Sarah", "Davidson", 4, 420000.0), director1);
		theCompany.addEmployee(new Worker("Doris","McClure", 5, 470000.0), director1);
		theCompany.addEmployee(new Worker("James", "Adams", 6, 340000.0), director1);
		theCompany.addEmployee(new Worker("Sam", "Cooper", 7, 460000.0), director2);
		theCompany.addEmployee(new Worker("Andrea","Lester", 8, 460000.0), director2);
		theCompany.addEmployee(new Worker("Olga", "Gibbs", 9, 420000.0), director2);
		
		//Here we change the sorting criterium using the class constants of Employee: 
		//BYNAME = 0, BYSALARY = 1, BYTAXES = 2.
		//This is the code for part B.
		Employee.changeCriterion(Employee.BYNAME);
		System.out.println(theCompany.toString());
		Employee.changeCriterion(Employee.BYSALARY);
		System.out.println(theCompany.toString());
		Employee.changeCriterion(Employee.BYTAXES);
		System.out.println(theCompany.toString());	
		
		//This is the code for part C.	
		
		JFrame jFrame = new JFrame();
		jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		int orderBy;
		
		String getMessage = JOptionPane.showInputDialog(jFrame, "Do you want to sort by Surname (0), Salary (1) or paid Taxes (2)?");
		try {
			orderBy = Integer.parseInt(getMessage);
		} catch (NumberFormatException ignore) {
			orderBy = -1;
		}
		while(orderBy != 0 && orderBy != 1 && orderBy != 2) {
			JOptionPane.showMessageDialog(jFrame, "Try again!");
			getMessage = JOptionPane.showInputDialog(jFrame, "Do you want to sort by Surname (0), Salary (1) or paid Taxes (2)?");
			try {
				orderBy = Integer.parseInt(getMessage);
			} catch (NumberFormatException ignore) {
				orderBy = -1;
			}
		}
		
		Employee.changeCriterion(orderBy);
		JOptionPane.showMessageDialog(jFrame, theCompany.toString());
	}
}
