package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_01_Data_Type_Excercise {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("a = ");
		int a = scanner.nextInt();
		System.out.println("b = ");
		int b = scanner.nextInt();

		System.out.println("a + b = " + (a+b));
		System.out.println("a - b = " + (a-b));
		System.out.println("a * b = " + (a*b));
		System.out.println("a / b = " + (a/b));
		
	}
	
	@Test
	public void TC_01_Dien_Tich() {
		double length = 7.5;
		double width = 3.8;
		
		System.out.println("Area = " + (length * width));
	}
	
	@Test
	public void TC_02_Name() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("name = ");
		String name = scanner.nextLine();
		System.out.println("Hello " + name);
	}
}
