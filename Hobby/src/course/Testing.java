package course;

public class Testing {

	public static void main(String[] args) {
		Inher obj = new Inher("asda", 120, "asdasdasd");
		//DiceRoller is abstract
		//DiceRoller obj2 = new DiceRoller();
		obj.roll();
		//obj2.speak();
		obj.speak();
		
		
		//System.out.println(obj.name);
		//System.out.println(obj.age);
		//System.out.println(obj.thing);
		
		System.out.println(obj.toString());
		obj.go();
	}

}
