package javaOOP.overriding;

public class Testing {

	public static void main(String[] args) {
		Student student = new Student();
		student.eat();
		student.sleep();
		student.work();
		
		Employee employee = new Employee();
		employee.eat();
		employee.work();
		employee.sleep();
		
		Kids kids = new Kids();
		kids.eat();
		kids.work();
		employee.sleep();
		

	}

}
