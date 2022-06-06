package javaOOP.overriding;

public class Employee extends Schedule{
	
	@Override
	public void eat() {
		System.out.println("eat at 0.5 hours");
	}
	
	@Override
	public void work() {
		System.out.println("work at 8 hours");
	}
	
	@Override
	public void sleep() {
		System.out.println("sleep at 7 hours");
	}
}
