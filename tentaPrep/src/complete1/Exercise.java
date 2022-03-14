package complete1;
import java.io.*;
public class Exercise {

	public static void main(String[] args) {
		
		try {
			BufferedReader theReader = new BufferedReader(new InputStreamReader(System.in));
			String input;
			DataBase theDataBase = new DataBase();
			// Adding to dynamic array
			while (true) {
				System.out.print("Your input (type end to exit) : ");
				input = theReader.readLine().trim();
				if (input.equals("end")) break;
				try {Integer.valueOf(input);}
				catch(NumberFormatException inerr) {
					theDataBase.add(input); 
				}
			} 
			System.out.println(theDataBase);
			// Removing from dynamic array
			while (true) {
				System.out.print("Your input (type end to exit) : ");
				input = theReader.readLine().trim();
				if (input.equals("end")) break;
				try {Integer.valueOf(input);}
				catch(NumberFormatException inerr) {
					if (!theDataBase.delete(input)) break; 
				}
			} 
			theReader.close();
			System.out.println(theDataBase);
		}
		catch(IOException ioerr) {}
	}
}
