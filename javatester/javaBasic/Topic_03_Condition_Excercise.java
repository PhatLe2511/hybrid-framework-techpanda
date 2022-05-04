package javaBasic;

import java.util.Scanner;
import org.testng.annotations.Test;

public class Topic_03_Condition_Excercise {
	Scanner scanner = new Scanner(System.in);
	
	public void TC_01_Odd_Even_Number() {
		int number = scanner.nextInt();
		
		if(number % 2 == 0) {
			System.out.println(number + " là số chẵn");
		}else {
			System.out.println(number + " là số lẻ");
		}		
	}
	
	
	public void TC_02_Two_Int_Number() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		if (a > b) {
			System.out.println(a + " lớn hơn " + b);
		}else if(a <= b) {
			System.out.println(a + " nhỏ hơn hoặc bằng " + b);
		}
	}
	
	
	public void TC_03_Username_Comparision() {
		String userNameA = scanner.nextLine();
		String userNameB = scanner.nextLine();
		
		if(userNameA.equals(userNameB)) {
			System.out.println(userNameA + " cùng tên " + userNameB);
		}else {
			System.out.println(userNameA + " khác tên " + userNameB);
		}
	}
	
	public void TC_04_Three_Int_Numbers() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		if (a > b && a > c) {
			System.out.println(a);
		} else if (b > c) {
			System.out.println(b);
		} else {
			System.out.println(c);
		}
	}
	
	public void TC_05_Boundary() {
		int a = scanner.nextInt();
		
		if(a >= 10 && a <= 100) {
			System.out.println(a + " nằm trong [10,100]");
		} else {
			System.out.println(a + " không nằm trong [10,100]");
		}
	}
	
	public void TC_06_Student_Point() {
		float studentPoint = scanner.nextFloat();
		
		if (0 < studentPoint && studentPoint <= 5) {
			System.out.println(studentPoint + " là điểm D");
		} else if (5 < studentPoint && studentPoint <= 7.5) {
			System.out.println(studentPoint + " là điểm C");
		} else if (7.5 < studentPoint && studentPoint <= 8.5) {
			System.out.println(studentPoint + " là điểm B");
		} else if (8.5 < studentPoint && studentPoint <= 10) {
			System.out.println(studentPoint + " là điểm A");
		} else {
			System.out.println("Vui lòng nhập lại");
		}
	}
	
	public void TC_07_Month_Of_Year() {
		int month = scanner.nextInt();
		
		if(month == 1 || month == 3 || month == 5 || month == 7 ||month == 8 || month ==  10 ||month == 12) { 
			System.out.println("Tháng này có 31 ngày");
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			System.out.println("Tháng này có 30 ngày");
		} else if (month == 2) {
			System.out.println("Tháng này có 28 hoặc 29 ngày");
		}
	}
}
