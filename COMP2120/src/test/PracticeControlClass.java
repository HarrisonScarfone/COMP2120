package test;

public class PracticeControlClass {
	
	private int age;
	
	public PracticeControlClass() {
		this(20);
	}
	
	public PracticeControlClass(int age) {
		this.age = age;
	}
	
	public PracticeControlClass(PracticeControlClass c) {
		this.age = c.age;
	}
}
