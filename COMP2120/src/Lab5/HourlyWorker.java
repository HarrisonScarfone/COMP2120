package Lab5;

public class HourlyWorker extends Employee{
	
	private int num_hours;
	private double hourly_rate;
	
	/**
	 * No argument constructor
	 */
	public HourlyWorker() {
		super();
		this.num_hours = 0;
		this.hourly_rate = 0.0;
	}
	/**
	 * Parameterized Constructor
	 * @param name Name of employee
	 * @param age Age of employee
	 * @param year_hired The year hired (1550-2999)
	 * @param num_hours The number of hours worked as an int
	 * @param hourly_rate The hourly rate of pay as a duble
	 */
	public HourlyWorker(String name, int age, int year_hired, int num_hours, double hourly_rate) {
		super(name, age, year_hired);
		this.num_hours = num_hours;
		this.hourly_rate = hourly_rate;
	}
	/**
	 * To string method for class
	 */
	public String toString() {
		return "" + getName() +  "," + getId() + "," + getAge() + "," + get_year_hired() + "," + num_hours + "," + hourly_rate;
	}
	/**
	 * Return the number of hours worked by employee
	 * @return Number of hours worked as an int
	 */
	public int getNumHours() {
		return num_hours;
	}
	/**
	 * Sets the new number of hours worker for an employee
	 * @param newNumHours The new hours amount as an int (>0)
	 */
	public void setNumHours(int newNumHours) {
		if(validate(newNumHours)) {
			num_hours = newNumHours;
		}
	}
	/**
	 * Get the hourly rate
	 * @return The hourly rate as an unformatted double
	 */
	public double getHourlyRate() {
		return hourly_rate;
	}
	/**
	 * Sets the new hourly rate
	 * @param newHourlyRate The new hourly rate as a double (>0)
	 */
	public void setHourlyRate(double newHourlyRate) {
		if(validate(newHourlyRate)) {
			hourly_rate = newHourlyRate;
		}			
	}
	/**
	 * Calculates the total pay of an employee
	 * @return The employees pay as a double
	 */
	public double getTotalPay() {
		return (double)num_hours * hourly_rate;
	}
	/**
	 * Function to display worker pay as requested in the lab
	 */
	public void payWorker() {
		System.out.printf("%s is an employee who gets paid $%.2f this week.\n", getName(), getTotalPay());
	}
	/**
	 * Validate number is >0
	 * @param check int number to be checked 
	 * @return Boolean is the number greater than 0
	 */
	private boolean validate(int check) {
		return check > 0;
	}
	/**
	 * Validate number is >0
	 * @param check The double to be verfied is greater than 0
	 * @return Boolean is check greater than 0
	 */
	private boolean validate(double check) {
		return check > 0;
	}

}
