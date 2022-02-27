package lab6;

public class Person {

	private String givenName;
	private String surname;
	private int phoneNumber;
	
	Person(String givenName, String surname, int phoneNumber){
		this.givenName = givenName;
		this.surname = surname;
		this.phoneNumber = phoneNumber;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public String getFullName() {
		//System.out.println(this.givenName + " " + this.surname);
		return this.givenName + " " + this.surname;
	}
	
	public int getPhoneNumber() {
		return this.phoneNumber;
	}
	
}
