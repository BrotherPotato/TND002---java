package course;

import java.util.Random;
// can't instantiate diceroller
public abstract class DiceRoller {
	
	Random rand;
	int number;
	
	String name = "";
	int age;
	
	DiceRoller(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	DiceRoller() {
		rand = new Random();
		number = 0;
		roll();
	}
	void roll() {
		rand = new Random();
		number = rand.nextInt(6)+1;
		System.out.println(number);
	}
	
	void speak() {
		System.out.println("Words");
	}
	public String toString() {
		return this.name + "\n" + this.age + "\n";
	}
	abstract void go();
	
}
