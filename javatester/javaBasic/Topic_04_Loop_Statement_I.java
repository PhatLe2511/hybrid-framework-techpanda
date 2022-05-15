package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_04_Loop_Statement_I {
	
	Scanner scanner = new Scanner(System.in);
	
	public void TC_01() {
		int n = scanner.nextInt();
		 for(int i = 1 ; i <= n; i++) {
			 System.out.println(i);
		 }
	}
	
	public void TC_02() {
		System.out.println("Nhap so a: ");
		int a = scanner.nextInt();scanner.nextLine();
		System.out.println("Nhap so b: ");
		int b = scanner.nextInt();
		
		for(int i = a ; i <= b; i++) {
			System.out.println(i);
		}
	}
	
	public void TC_03() {
		int a = scanner.nextInt();
		for(int i = 1; i <= a ; i++) {
			if(i % 2 == 0) {
				System.out.println(i);
			}
		}
	}
	
	@Test
	public void TC_04() {
		System.out.println("Nhap so a: ");
		int a = scanner.nextInt();scanner.nextLine();
		System.out.println("Nhap so b: ");
		int b = scanner.nextInt();
		
		for (int i = a;i <= b; i++) {
			i += b;
		}
	}
}

