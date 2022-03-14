package complete3;

import java.io.*;
public class Exercise {	
    public static void main(String[] args) throws IOException 
    {
        Dictionary theDictionary = new Dictionary();

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        File theFile; String input, phobia, animal; int loop;
        System.out.println("File to open : ");
        do {
        	input = consoleReader.readLine();
        	theFile = new File(input); 
        	theFile.createNewFile();
        }while(!theFile.exists());
        
        theDictionary.load(theFile);

        System.out.println();
        System.out.println("Content after loading from file");
        System.out.println(theDictionary);

        System.out.println("Insert how many phobias? : ");
        loop = Integer.valueOf(consoleReader.readLine());
        System.out.println("Inserting " + loop + " new phobias.");
        for (int j=0; j<loop; j++) {
        	phobia = consoleReader.readLine();
        	animal = consoleReader.readLine();   
        	theDictionary.insert(new Zoophobia(phobia, animal));
        }
        
        System.out.println("Content after the update");
        System.out.println(theDictionary);
        System.out.println();
        
        System.out.println("Delete phobia (stop with end) : ");
        while (!(input = consoleReader.readLine()).equals("end")) {
        	if (input!=null) {
        		System.out.println("Deleted phobia : " + input + " and animal : " + theDictionary.lookup(input));
        		theDictionary.delete(input);
        	}
        }
        
        theDictionary.sort();
        System.out.println();
        System.out.println("Sorted content of the dictionary");
        System.out.println(theDictionary);
       
        System.out.println("Save to file : ");
        input = consoleReader.readLine();
        theFile = new File(input);        	
        theDictionary.save(theFile);

        System.out.println("\n** File new.txt saved\n");
        
        consoleReader.close();
     }
 }
    

