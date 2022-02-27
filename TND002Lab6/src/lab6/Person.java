package lab6;

public class Person {

	private String givenName;
	private String surname;
	private int phoneNumber;
	
	Person(String givenName, String surname, int phoneNumber){
		givenName = this.givenName;
		surname = this.surname;
		phoneNumber = this.phoneNumber;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public String getFullName() {
		return this.givenName + " " + this.surname;
	}
	
	public int getPhoneNumber() {
		return this.phoneNumber;
	}
	
}
