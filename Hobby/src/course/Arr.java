package course;

import java.util.ArrayList;

public class Arr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String[] cars = {"Camero", "Corvette", "Tesla"};
		
		cars[0] = "Mustang";
		System.out.println(cars[0]);
		
		String[] cars2 = new String[3];
		cars2[0] = "Car";
		cars2[1] = "";
		cars2[2] = "Rac";
		for (int i = 0; i < cars2.length; i++) {
			
		}
		
		String[][] carsCars = new String[3][3];
		// String[][] carsCars = {{"Camero", "Corvette", "Serverado"}, {"Mustang", "Ranger", "F-150"}, {"Ferrari", "Lambo", "Tesla"}};
		carsCars[0][0] = "Camero";
		carsCars[0][1] = "Corvette";
		carsCars[0][2] = "Serverado";
		carsCars[1][0] = "Mustang";
		carsCars[1][1] = "Ranger";
		carsCars[1][2] = "F-150";
		carsCars[2][0] = "Ferrari";
		carsCars[2][1] = "Lambo";
		carsCars[2][2] = "Tesla";
		
		for (int i = 0; i < carsCars.length; i++) {
			System.out.println();
			for (int j = 0; j < carsCars[i].length; j++) {
				System.out.println(carsCars[i][j] + " ");
			}
		}
		*/
		
		ArrayList<String> food = new ArrayList<String>();
		
		food.add("piz");
		food.add("ice");
		food.add("water");
		
		food.set(0, "susho");
		food.remove(2);
		
		
		for (int i = 0; i < food.size(); i++) {
			System.out.println(food.get(i));
		}
		food.clear();
		
		ArrayList<ArrayList<String>> groceryList = new ArrayList<ArrayList<String>>(); 
		
		ArrayList<String> bakeryList = new ArrayList<String>();
		bakeryList.add("pasta");
		bakeryList.add("bred");
		bakeryList.add("cookie");
		
		ArrayList<String> produceList = new ArrayList();
		produceList.add("tomater");
		produceList.add("eggplant");
		produceList.add("perppserss");
		
		ArrayList<String> drinksList = new ArrayList<String>();
		drinksList.add("water");
		drinksList.add("cofefe");
		
		groceryList.add(bakeryList);
		groceryList.add(produceList);
		groceryList.add(drinksList);
		
		System.out.println(groceryList.get(0).get(0));
		
		/*
		String[] animals = {"cat", "dog", "rat", "elephant"};
		
		for (String i : animals) {
			System.out.println(i);
		}
		*/
		
		ArrayList<String> animals = new ArrayList<String>();
		
		animals.add("rat");
		animals.add("dog");
		animals.add("cat");
		animals.add("elephant");
		
		for (String i : animals) {
			System.out.println(i);
		}
		hello("dog", 5);
	}
	
	static void hello(String name, int age) {
		System.out.println("Hello " + name + ", age " + age);
	}

}
