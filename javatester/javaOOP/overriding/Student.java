package javaOOP.overriding;

public class Student extends Schedule{
	
	@Override
	public void eat() {
		System.out.println("eat at 0.5 hours");
	}
	
	@Override
	public void work() {
		System.out.println("learn at 6 hours");
	}
	
	@Override
	public void sleep() {
		System.out.println("sleep at 8 hours");
	}
}
