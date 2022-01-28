package lesson2;
import java.io.*; 
import java.util.Random; 
import java.util.ArrayList;
public class Lesson2 {

	public static void main(String[] args) throws IOException {	
		BufferedReader freader, creader;
		BufferedWriter fwriter;
		File file;
		
		// Task 1
		
		file = new File("Test.txt");
		//file.createNewFile();
		
		if (file.createNewFile() && file.exists() && file.canRead() && file.canWrite()) {
			System.out.println(file.getAbsolutePath());
			file.deleteOnExit();			
		}
				
		// Task 2
		
		fwriter = new BufferedWriter(new FileWriter(file));
		Random myRandom = new Random();
		
		
		int maxloop = myRandom.nextInt(10000);
		fwriter.write("Loop variable: " + maxloop + " "); fwriter.newLine();
		for (int i=0; i < maxloop; i++) {
			fwriter.write(String.valueOf(myRandom.nextInt(1000)+ " "));				
		}
		
		fwriter.flush(); // Test what happens if you don't flush.
		
		// Task 3
		
		creader = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<String> strArr = new ArrayList<String>();
		String rs;
		
		do {
			rs = creader.readLine();
			strArr.add(rs); 			
		}while(!rs.equals("end"));
		
		strArr.remove(strArr.size()-1);
		
		for (int j=0; j < strArr.size(); j++) {
			fwriter.write(strArr.get(j));
			fwriter.newLine();
		}
		
		fwriter.flush();
		
		// Task 4
		ArrayList<Integer> intArr = new ArrayList<Integer>();
		
		String[] splitted;
		
		freader = new BufferedReader(new FileReader(file));
		
		rs = freader.readLine();
		splitted = rs.split(" +");
		System.out.println(splitted[2]);
		
		while ((rs = freader.readLine())!=null) {
			splitted = rs.split(" +");
			for (int i=0; i < splitted.length; i++) {
				try {
					intArr.add(Integer.valueOf(splitted[i]));
				}
				catch(NumberFormatException ierr) {
					strArr.add(splitted[i]);
				}
			}
		}
		
		System.out.println(intArr.size());
		System.out.println(strArr.size());
		
		freader.close();
		
		freader = new BufferedReader(new FileReader(file));
		
		// Task 5
		
		long length = file.length();
		
		while (file.length() == length) {}
		
		System.out.println("The file size has changed");
		
		freader.close(); creader.close(); fwriter.close(); 
		file.delete(); 
		
	}
	
}
