package javaOOP;

public class Topic_01_Getter_Setter {
	private String studentName;
	private int studentAge;
	private int studentGrade;
	private double studentPoint;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		if (studentName == null || studentName.isEmpty() || studentName.startsWith("w")) {
			throw new IllegalArgumentException("This name is invalid!");
		} else {
			this.studentName = studentName;
		}
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		if (studentAge == 0 || studentAge > 18 || studentAge < 0) {
			throw new IllegalArgumentException("This age is invalid!");
		}else {
			this.studentAge = studentAge;	
		}
	}
	
	public int getStudentGrade() {
		return studentGrade;
	}
	
	public void setStudentGrade(int studentGrade) {
		if(studentGrade < 0 || studentGrade > 12 || studentGrade == 0) {
			throw new IllegalArgumentException("This grade is invalid!");
		}else {
			this.studentGrade = studentGrade;
		}	
	}
	
	public double getStudentPoint() {
		return studentPoint;
	}
	
	public void setStudentPoint(double studentPoint) {
		if (studentPoint < 0 || studentPoint > 10) {
			throw new IllegalArgumentException("This point is invalid!");
		} else {
			this.studentPoint = studentPoint;
		}
	}
	
}
