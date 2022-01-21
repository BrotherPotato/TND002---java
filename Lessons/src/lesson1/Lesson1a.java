package lesson1;

public class Lesson1a {

	public static void main(String[] args) {
		Human h1 = new Human("Max", 20, 75.0);
		Human h2 = new Human("Jeff", 200, 175.0);
		
		System.out.println(h1.comparison(h2));
	}

}
