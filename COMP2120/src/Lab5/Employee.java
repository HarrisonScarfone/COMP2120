package Lab5;
import java.time.Year;

public class Employee extends Person{
	
	public static int counter = 0;
	
	protected int year_hired;
	protected int id;
	/**
	 * No parameter constructor.
	 */
	public Employee() {
		super();
		this.year_hired =  Year.now().getValue();
		this.id = ++counter;
	}
	/**
	 * 3 Parameter constructor for an Employee.
	 * @param name Name of the employee.
	 * @param age Age of the employee.
	 * @param year_hired Year the employee was hired.
	 */
	public Employee(String name, int age,  int year_hired) {
		super(name, age);
		this.year_hired = (year_hired < 3000 && year_hired > 1500) 
				? year_hired : Year.now().getValue();
		this.id = ++counter;
	}
	/**
	 * To string method for the employee class.
	 */
	public String toString() {
		return name + " was hired in " + year_hired + " and is " + age + " years old."
				+ " Id: " + id;
	}
	/**
	 * Getter for the year hired.
	 * @return The hiring year.
	 */
	public int get_year_hired() {
		return year_hired;
	}
	/**
	 * Setter for the year hired.
	 * @param new_year_hired The new year hired.
	 */
	public void set_year_hired(int new_year_hired) {
		year_hired = (new_year_hired < 3000 && new_year_hired > 1500) 
				? new_year_hired : Year.now().getValue();
	}
	/**
	 * Getter for the id.
	 * @return The employee id.
	 */
	public int getId() {
		return id;
	}
	
	protected void payWorker() {
		System.out.println("" + getName() + " is an employee who needs to be paid.");
	}
}
