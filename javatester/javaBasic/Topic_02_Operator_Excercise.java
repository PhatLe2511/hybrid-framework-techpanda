package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_02_Operator_Excercise {
	
	@Test
	public void TC_01_Age_username() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Name = ");
		String name = scanner.nextLine();
		System.out.println("Age = ");
		int age = scanner.nextInt();
		System.out.println("After 15 years, age of " + name + " will be " + (age + 15));
	}
	
	
	
	//@Test
	public void TC_02_Name() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("name = ");
		String name = scanner.nextLine();
		System.out.println("Hello " + name);
	}
}
