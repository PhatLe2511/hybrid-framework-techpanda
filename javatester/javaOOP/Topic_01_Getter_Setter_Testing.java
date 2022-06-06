package javaOOP;

public class Topic_01_Getter_Setter_Testing {

	public static void main(String[] args) {
		Topic_01_Getter_Setter topic = new Topic_01_Getter_Setter();
		
		topic.setStudentName("Phat");
		System.out.println(topic.getStudentName());
		topic.setStudentAge(7);
		System.out.println(topic.getStudentAge());
		topic.setStudentGrade(12);
		System.out.println(topic.getStudentGrade());
		topic.setStudentPoint(9.5);
		System.out.println(topic.getStudentPoint());
	}

}
