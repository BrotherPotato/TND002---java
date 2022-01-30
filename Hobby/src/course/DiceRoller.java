package course;

import java.util.Random;

public class DiceRoller {
	
	Object random;
	int number;
	
	DiceRoller() {
		random = new Random();
		number = 0;
		//roll();
	}
	void roll() {
		random = new Random();
		number = random.nextInt(6)+1;
	}
}
