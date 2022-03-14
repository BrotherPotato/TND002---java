package complete3;

import java.io.*;
import java.util.*;

public class Dictionary 
{
    private ArrayList<Zoophobia> dataBase;

    public Dictionary()
    {
        dataBase = new ArrayList<Zoophobia>();
    }

    public void load(File myFile) 
    {
        String line, phobia, animal;
        String[] strArray;
        try {
        BufferedReader infile = new BufferedReader(new FileReader(myFile));
        while ((line = infile.readLine()) != null)
        {
            strArray = line.split(" +");
            phobia = strArray[0];
            animal = strArray[1];
            dataBase.add(new Zoophobia(phobia, animal));
        }

        infile.close();}
        catch(IOException ierr){}
    }

    public void sort()
    {
        Collections.sort(dataBase);
    }

    public void insert(Zoophobia zp)
    {
    	String theAnimal = zp.getAnimal();
    	String thePhobia = zp.getPhobia();
    	boolean exists = false;
        for (int j=0; j < dataBase.size(); j++) {
        	if (thePhobia.equals(dataBase.get(j).getPhobia())) {
        		if (!theAnimal.equals(dataBase.get(j).getAnimal())) {
        			dataBase.get(j).setAnimal(theAnimal);
        		}
        		exists = true;
        	}
        }
        if (!exists) dataBase.add(zp);
    }

    public void delete(String phobia)
    {
        for (int i = 0; i < dataBase.size(); i++)
        {
            if (phobia.equals(dataBase.get(i).getPhobia()))
            {
                dataBase.remove(i);
            }
        }
    }

    public String lookup(String phobia)
    {
        for (int i = 0; i < dataBase.size(); i++)
        {
            if (phobia.equals(dataBase.get(i).getPhobia()))
            {
                return dataBase.get(i).getAnimal();
            }
        }

        return null;
    }

    public void save(File arg) 
    {
    	try {
        BufferedWriter outfile = new BufferedWriter(new FileWriter(arg));        
        outfile.write(toString());
        outfile.close();}
    	catch(IOException ierr){}
    }
    
    public String toString() {
    	String result = new String();
    	for (int j=0; j < dataBase.size();j++) {
    		result = result + dataBase.get(j) + "\r\n";
    	}
    	return result;
    }
}
