package lesson1ab;
public class Lesson1b {

	public static void main(String[] args) {
		
		Human first = new Human("Mark");
		Human second = new Human("Hanna", 28);
	    Human third = new Human("Alice", 22, 52.0);
	    Human fourth = new Human("Connor", 24, 75.0);
	    
	    Human.setOutputFormat(Human.SHORT);
	    
	    System.out.println(first);
	    System.out.println(second);
	    System.out.println(third);
	    System.out.println(fourth);
	    
	    Human.setOutputFormat(Human.FULL);
	    
	    System.out.println(first);
	    System.out.println(second);
	    System.out.println(third);
	    System.out.println(fourth);
	    
	    System.out.println(third.comparison(fourth));
	}

}
