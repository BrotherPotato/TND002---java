package lesson1;

public class Human {
	
	private String name;
	private int age;
	private double weight;
	
	private static boolean outputFormat = false;
	
	private boolean complete = false;
	
	public static final boolean FULL = true;
	public static final boolean SHORT = false;
	
	
	public Human(String name) {
		 this.name = name;
	}
	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public Human(String name, int age, double weight) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.complete = true;
	}
	public static String setOutputFormat (boolean bArg) {
		outputFormat = bArg;
		if(outputFormat) {
			return "Full format";
		} else {
			return "Short format";
		}
	}
	public void setName(String name) {
		this.name = name;
	}
	public String comparison(Human h) {
		//int v1 = this.name.compareTo(h.name);
		int v1 = this.name.compareTo(h.getName());
		int v2 = this.compareTo(h.age);
		int v3 = this.compareTo(h.age);
		
		return String.format("(%2d, %2d, %2d)", v1, v2, v3);
	}
	// set compareTo to private
	public int compareTo(int age) {
		if(this.age == age) {
			return 0;
		} else if(this.age > age) {
			return 1;
		} else {
			return -1;
		}
	}
	public int compareTo(double weight) {
		if(this.weight == weight) {
			return 0;
		} else if(this.weight > weight) {
			return 1;
		} else {
			return -1;
		}
	}
	public String getName() {
		return this.name;
	}
	public String toString() {
		if(outputFormat && complete) {
			return String.format("Name:%7s, age:%3d, weight:%5.1f", this.name, this.age, this.weight);
		} else {
			return "Name. " + this.name;
		}
	}
	
	
	/*
	private String name;
	private int age;
	private double weight; 
	public static final boolean FULL = true;
	public static final boolean SHORT = false;
	
	private static boolean outputFormat = false;
	private boolean complete = false;
	
	
	public Human(String n) {
		setName(n); 
	}
	
	public Human(String n, int a) {
		setName(n); age = a;
	}
	
	public Human(String n, int a, double d) {
		setName(n); age = a; weight = d; complete = true;
	}
	
	public static String setOutputFormat (boolean b) {
		outputFormat=b;
		if (b) return "Full format";
		else return "Short format";
	}
		
	public void setName(String n) {
		name = n;
	}
	
	public String comparison(Human h) {
		int ncmp = name.compareTo(h.getName());
		int acmp = compareTo(h.age); 
		int wcmp = compareTo(h.weight);
		
		return String.format("(%2d,%2d,%2d)", ncmp, acmp, wcmp);
	}
	
	public int compareTo(int i) {
		if (age == i) return 0;
		else if (age < i) return -1;
		else return 1;
	}
	
	public int compareTo(double d) {
		if (weight == d) return 0;
		else if (weight < d) return -1;
		else return 1;
	}
	
	public String getName() {
		return name;
	}
	
	
	public String toString() {
		if (outputFormat && complete) {
			return String.format("Name:%7s, age:%3d, weight:%5.1f", name, age, weight);			
		}
		else {
			return "Name: " + name;
		}
	}
	*/
}
