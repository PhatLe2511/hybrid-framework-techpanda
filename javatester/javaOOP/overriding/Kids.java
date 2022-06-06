package javaOOP.overriding;

public class Kids extends Schedule{
	@Override
	public void eat() {
		System.out.println("eat at 1 hour");
	}
	
	@Override
	public void work() {
		System.out.println("Not work");
	}
	
	@Override
	public void sleep() {
		System.out.println("sleep at 15 hours");
	}
}
