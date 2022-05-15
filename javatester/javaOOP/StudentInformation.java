package javaOOP;

import java.util.Scanner;

public class StudentInformation extends StudentManagement{

	public StudentInformation(int studentCode, String studentName, float theoryPoint, float practicePoint) {
		super(studentCode, studentName, theoryPoint, practicePoint);
	}

	public static void main(String[] args) {
		StudentManagement student1 = new StudentManagement();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap ma sinh vien 1: ");
		student1.setStudentCode(scanner.nextInt());scanner.nextLine();
		System.out.println("Nhap ho va ten sinh vien 1: ");
		student1.setStudentName(scanner.nextLine());
		System.out.println("Nhap diem ly thuyet sinh vien 1: ");
		student1.setTheoryPoint(scanner.nextFloat());
		System.out.println("Nhap diem thuc hanh sinh vien 1: ");
		student1.setPracticePoint(scanner.nextFloat());
		System.out.printf("%6s %10s %20s %10s %10s \n","Mã sinh viên","Họ tên","Điểm lý thuyết","Điểm thực hành","Điểm trung bình");
		student1.studentOutput();
	}

}
