package tenta;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		String name, profession, input;
		String[] employeeInfo;
		double salary;
		int wantedIndex = 0;
		Employee newEmployee;
		Employee currentDirector, worker;
		Company theCompany = new Company();
	
		do {
			System.out.println("Input a firstname, a profession and a salary for a employee, divide these values with spaces");
			input = inputReader.readLine();
			input = input.trim();
			employeeInfo = input.split(" +");
			if(employeeInfo.length == 3 && (employeeInfo[1].equals("Worker") || (employeeInfo[1].equals("Director")))) {
				try {
					salary = Integer.parseInt(employeeInfo[2]);
					newEmployee = new Employee(employeeInfo[0], employeeInfo[1], salary);
					theCompany.addEmployee(newEmployee);
				} catch (NumberFormatException ignore) {
					System.out.println("Invalid salary");
				}
			} else if(!input.equals("end")){
				System.out.println("Invalid input, try again");
			}
			
		} while(!input.equals("end"));
		
		do{
			System.out.println("Input a director name:");
			name = inputReader.readLine();
			name = name.trim();
			if((currentDirector = theCompany.getDirector(name)) != null) {			
				for (int i = 0; i < theCompany.availableWorkers().size(); i++) {
					worker = theCompany.availableWorkers().get(i);
					System.out.println(worker.getName() + " : " + i);
				}
				
				try {
					do {
						System.out.println("Enter a worker number to add to the director");
						wantedIndex = Integer.parseInt(inputReader.readLine());
					} while(wantedIndex < 0 || wantedIndex >= theCompany.availableWorkers().size());
					worker = theCompany.availableWorkers().get(wantedIndex);
					worker.setAllocation(currentDirector);
					System.out.println(worker.toString());
					
				} catch (NumberFormatException ignore) {
					System.out.println("Invalid number");
				}
			} else if(theCompany.availableWorkers().size() != 0){
				System.out.println("Director not found, try again");
			}
		} while(theCompany.availableWorkers().size() != 0);
		
		System.out.println(theCompany.toString());
		inputReader.close();
	}
}
