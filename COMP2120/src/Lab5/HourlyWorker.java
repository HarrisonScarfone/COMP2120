package Lab5;

public class HourlyWorker extends Employee{
	
	private int num_hours;
	private double hourly_rate;
	
	public HourlyWorker() {
		super();
		this.num_hours = 0;
		this.hourly_rate = 0.0;
	}
	
	public HourlyWorker(String name, int age, int year_hired, int num_hours, double hourly_rate) {
		super(name, age, year_hired);
		this.num_hours = num_hours;
		this.hourly_rate = hourly_rate;
	}
	
	public String toString() {
		return "" + getName() +  "," + getId() + "," + getAge() + "," + get_year_hired() + "," + num_hours + "," + hourly_rate;
	}
	
	public int getNumHours() {
		return num_hours;
	}
	
	public void setNumHours(int newNumHours) {
		if(validate(newNumHours)) {
			num_hours = newNumHours;
		}
	}
	
	public double getHourlyRate() {
		return hourly_rate;
	}
	
	public void setHourlyRate(double newHourlyRate) {
		if(validate(newHourlyRate)) {
			hourly_rate = newHourlyRate;
		}			
	}
	
	public double getTotalPay() {
		return (double)num_hours * hourly_rate;
	}
	
	public void payWorker() {
		System.out.printf("%s is an employee who gets paid $%.2f this week.\n", getName(), getTotalPay());
	}
	
	private boolean validate(int check) {
		return check > 0;
	}
	
	private boolean validate(double check) {
		return check > 0;
	}

}
