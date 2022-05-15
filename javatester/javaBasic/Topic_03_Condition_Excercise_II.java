package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_03_Condition_Excercise_II {
	
	Scanner scanner = new Scanner(System.in);
	
	public void TC_01_Number_In_English() {
		int number = scanner.nextInt();
		switch(number) {
		case 1:
			System.out.println("Number One");
			break;
		case 2:
			System.out.println("Number Two");
			break;
		case 3:
			System.out.println("Number Three");
			break;
		case 4:
			System.out.println("Number Four");
			break;
		case 5:
			System.out.println("Number Five");
			break;
		case 6:
			System.out.println("Number Six");
			break;
		case 7:
			System.out.println("Number Seven");
			break;
		case 8:
			System.out.println("Number Eight");
			break;
		case 9:
			System.out.println("Number Nine");
			break;
		case 10:
			System.out.println("Number Ten");
			break;
		default:
			System.out.println("Invalid number, please try again!");
			break;
		}
	}
	
	public void TC_02_Month_In_Year() {
		int month = scanner.nextInt();
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("Tháng này có 31 ngày");
			break;
		case 2:
			System.out.println("Tháng này có 28 hoặc 29 ngày");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("Tháng này có 30 ngày");
			break;
		}
	}
}
