package course;

public class Swi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String day = "d";
		
		switch(day) {
		case "Monday": System.out.println("Monday");
			break;
		case "Tuesday": System.out.println("Tuesday");
			break;
		case "Wednesday": System.out.println("Wednesday");
			break;
		case "Thursday": System.out.println("Thursday");
			break;
		case "Friday": System.out.println("Friday");
			break;
		case "Saturday": System.out.println("Saturday");
			break;
		case "Sunday": System.out.println("Sunday");
			break;	
		default: System.out.println(day+" is not a day");
		}
		// % [flags] [precision] [width] [conversion-character]
		//System.out.printf("This is a format string %d", 123);
		
		boolean myBoolean = true;
		char myChar = '@';
		String myString = "ring";
		int myInt = 50;
		double myDouble = 100000.00;
		// [conversion-characters]
		System.out.printf("%b        ", myBoolean);
		System.out.printf("%c        ", myChar);
		System.out.printf("%s        ", myString);
		System.out.printf("%d        ", myInt);
		System.out.printf("%f        ", myDouble);
		System.out.println();
		// [width]
		System.out.printf("%10b", myBoolean);
		System.out.printf("%-10c", myChar);
		System.out.printf("%10s", myString);
		System.out.printf("%10d", myInt);
		System.out.printf("%10f", myDouble);
		System.out.println();
		// [precision]
		System.out.printf("%.2f", myDouble);
		System.out.println();
		// [flags]
		// - left-justify
		// + output a plus (+) or minus(-) sign for a numeric value
		// 0 numeric values are zero-padded
		// , comma grouping separator if numbers > 1000
		//System.out.printf("Hello ther isd asidhnas %-20f", myDouble);
		//System.out.printf("Hello ther isd asidhnas %+f", myDouble);
		//System.out.printf("Hello ther isd asidhnas %020f", myDouble);
		System.out.printf("Hello ther isd asidhnas %,f", myDouble);
		
		
		
	}

	
	
}
