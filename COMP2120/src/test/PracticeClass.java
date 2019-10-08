package test;

public class PracticeClass {
	
	//parameters
	private int num;
	private String name;
	
	public PracticeClass() {
		this(1, "bob");
	}
	
	public PracticeClass(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	public String toString() {
		return "This is what happens when you just print object";
	}
	
	//methods
	public int getNum() {
		return num;
	}
	
	public void setNum(int newNum) {
		num = newNum;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;		
	}

}
