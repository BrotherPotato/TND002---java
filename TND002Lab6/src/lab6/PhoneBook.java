package lab6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PhoneBook {

	private ArrayList<Person> listOfNumbers;
	
	public PhoneBook() {
		listOfNumbers = new ArrayList<Person>();
	}
	
	public String load(String fileName) {

		try {
			File newFile = new File(fileName);
			BufferedReader freader = new BufferedReader(new FileReader(newFile));
			String eachLine;
			String[] personData;
			int phoneNumber;
			while ((eachLine = freader.readLine()) != null) {
				personData = eachLine.split(" +");
				//System.out.println(personData[0]);
				phoneNumber = Integer.parseInt(personData[2]);
				//System.out.println(phoneNumber);
				Person newPerson = new Person(personData[0], personData[1], phoneNumber);
				
				//System.out.println(newPerson.getFullName());
				//System.out.println(newPerson.getPhoneNumber());
				listOfNumbers.add(newPerson);
			}
			freader.close();
			return "Phone book loaded";
		} catch (IOException ignore) {
			return "Try again";
		}
	}
	
	public ArrayList<Person> search(String searchArg){
		ArrayList<Person> listOfPeople = new ArrayList<Person>();
		
		for (Person person : listOfNumbers) {
			try {
				if(searchArg.equals(person.getSurname()) || Integer.parseInt(searchArg) == person.getPhoneNumber()) {
					listOfPeople.add(person);
				}
			} catch (NumberFormatException ignore) {
				
			}
		}
		
		return listOfPeople;
	}
	
	public String deletePerson(String fullName, int phoneNumber) {
		// change to forloop / get index of
//		for (Person person : listOfNumbers) {
//			if(person.getFullName().equals(fullName) && person.getPhoneNumber() == phoneNumber) {
//				listOfNumbers.remove(person);
//				return "Person deleted";
//			}
//		}
		for (int i = 0; i < listOfNumbers.size(); i++) {
			if(listOfNumbers.get(i).getFullName().equals(fullName) && listOfNumbers.get(i).getPhoneNumber() == phoneNumber) {
				listOfNumbers.remove(i);
				return "Person deleted";
			}
		}
		
		
		return "The person/number does not exist";
	}
	
	public boolean addPerson(String fullName, int phoneNumber) {
		String[] splitName = fullName.split(" ");
		//System.out.println(splitName.length);
		//System.out.println(phoneNumber);
		boolean phoneNumberFound = false;
		for (Person person : listOfNumbers) {
			if(person.getPhoneNumber() == phoneNumber) {
				phoneNumberFound = true;
			}
		}
		if(splitName.length != 2 || phoneNumberFound) {
			return false;
		}
		
		Person newPerson = new Person(splitName[0], splitName[1], phoneNumber);
		listOfNumbers.add(newPerson);
		return true;
	}
	
	public String save(String externalFile) {
		File file = new File(externalFile);
		String outputLine;
		try {
			BufferedWriter fwriter = new BufferedWriter(new FileWriter(file));
			
			//System.out.println(listOfNumbers.get(0).getPhoneNumber());
			for (Person person : listOfNumbers) {
				outputLine = String.format("%-20s %-5d", person.getFullName(), person.getPhoneNumber());
				
				fwriter.write(outputLine);
				fwriter.newLine();
			}
			fwriter.close();
			return "Saved " + listOfNumbers.size() + " people to the file";
		} catch (IOException ignore) {
			return "Could not save to the file";
		}
	}
	
}
