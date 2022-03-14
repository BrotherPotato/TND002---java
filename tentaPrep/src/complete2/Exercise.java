package complete2;
import java.util.ArrayList;
import java.io.*;
public class Exercise {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String profession;
		String name; 
		int salary; 
		Company theCompany = new Company();
		Employee dummy; 
		ArrayList<Employee> availableWorkers; 
		int response;
		
		System.out.println("Adding employees to the company.");
		do {
			System.out.print("Profession (Worker, Director, end) : "); 
			profession = reader.readLine();
			if (profession.equals("Worker") || profession.equals("Director")) {
				System.out.print("Name : "); 
				name = reader.readLine();
				System.out.print("Salary : "); 
				salary = Integer.valueOf(reader.readLine());
				theCompany.addEmployee(new Employee(profession, name, salary));				
			}
		}while(!profession.equals("end"));
		
		System.out.println();
		System.out.println("Connecting workers and directors."); 
		
		while ((availableWorkers = theCompany.availableWorkers()).size() > 0) {
			System.out.print("Name of Director : "); 
			name = reader.readLine();
			if ((dummy = theCompany.getDirector(name))!=null) {
				System.out.println("Free workers");
				for (int j=0; j < availableWorkers.size(); j++) {
					System.out.println(availableWorkers.get(j).getName() + " " + j);
				}
				System.out.println("Selection : "); 
				response = Integer.valueOf(reader.readLine()); 
				availableWorkers.get(response).setAllocation(dummy);
				System.out.println("The following employee has been allocated to the director : ");
				System.out.println(availableWorkers.get(response));
			}
		}		
		reader.close();
		System.out.println();
		System.out.println(theCompany);
	}

}
