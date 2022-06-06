package javaOOP;

public class StudentManagement {
	private int studentCode;
	private String studentName;
	private float theoryPoint;
	private float practicePoint;


	public StudentManagement(int studentCode, String studentName, float theoryPoint, float practicePoint) {
		
	}

	public StudentManagement() {
	
	}

	public int getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(int studentCode) {
		this.studentCode = studentCode;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public float getTheoryPoint() {
		return theoryPoint;
	}

	public void setTheoryPoint(float theoryPoint) {
		this.theoryPoint = theoryPoint;
	}

	public float getPracticePoint() {
		return practicePoint * 2;
	}

	public void setPracticePoint(float practicePoint) {
		this.practicePoint = practicePoint;
	}
	
	public float averagePoint() {
		return (practicePoint + theoryPoint * 2) / 3;
	}
	
	public void studentOutput() {
		System.out.printf("%6d %-18s %10.2f %12.2f %12.2f \n",studentCode, studentName, theoryPoint, practicePoint, averagePoint());
	}
	
}
