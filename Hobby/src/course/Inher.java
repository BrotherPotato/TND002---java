package course;

public class Inher extends DiceRoller{

		// this class inherits methods and values from the parent
	
	// this is the overriding method
	@Override
	void speak() {
		System.out.println("Another word");
	}
	
	
	String thing;
	
	Inher(String name, int age, String thing){
		// passes name and age to the constructor of the super class/ parent class
		super(name, age);
		//this.name = name;
		//this.age = age;
		this.thing = thing;
		
	}
	
	public String toString() {
		return super.toString() + this.thing;
	}

	@Override
	void go() {
		// TODO Auto-generated method stub
		System.out.println("GOOOOOOO");
	}
}
