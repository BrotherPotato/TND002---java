package complete5;
import java.util.*;
import java.io.*;

public class Payroll
{
    private ArrayList<Employee> vec;

    public Payroll()
    {
        vec = new ArrayList<Employee>();
    }

    public String load() {
    	int before = vec.size();
    	try {
    		BufferedReader theReader = new BufferedReader(new InputStreamReader(System.in));
    		System.out.print("File name : "); 
    		String arg = theReader.readLine(); 
    		theReader.close(); 
    		
    		theReader = new BufferedReader(new FileReader(arg));
    		String input; 
    		String[] subdivided;
    		while((input = theReader.readLine())!=null) {
    			subdivided = input.split(" +");
    			if (subdivided.length == 4 && subdivided[0].equals("Boss")) vec.add(new Boss(subdivided[1], subdivided[2], Double.valueOf(subdivided[3])));
    			else if (subdivided.length == 5 && subdivided[0].equals("Clerk")) vec.add(new Clerk(subdivided[1], subdivided[2], Double.valueOf(subdivided[3]),Double.valueOf(subdivided[3])));
    			else if (subdivided.length == 5 && subdivided[0].equals("Worker")) vec.add(new Worker(subdivided[1], subdivided[2], Double.valueOf(subdivided[3]),Integer.valueOf(subdivided[4])));
    		}
    		
    		theReader.close();
    		return String.format("File loaded! %3d workers stored", vec.size()-before);
    	}
    	catch(IOException ioerr) {return "IO error";}
    	catch(NumberFormatException numberError) {return "Wrong input";}
    }
    
    
    public void insert(Employee emp)
    {
        vec.add(emp);
    }

    public void sort()
    {
        Collections.sort(vec);  
    }

    public void print()
    {
        for (int i = 0; i < vec.size(); i++)
        {
            System.out.format("%s : %8.2f\n", vec.get(i), vec.get(i).earnings());
        }
        System.out.println();
    }
}
