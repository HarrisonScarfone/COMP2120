package Lab4;

public class Employee {
	
	public static int lastId = 0;
	
	private int id;
	private String name;
	private double hours;
	private double hourlyRate;
	private Date dateOfHire;
	
	public Employee() {
		this("No Record", 0, 0, new Date());
	}
	
	public Employee(String name, double hours, double hourlyRate, Date dateOfHire) {
		//this(name, hours, hourlyRate);
		id = ++lastId;
		this.name = name;
		this.hours = hours;
		this.hourlyRate = hourlyRate;
		this.dateOfHire = dateOfHire;
	}
	
	public String toString() {
		return String.format("ID: %d\nName: %s\nHours: %d\nHourly Rate: %d\nDate of Hire: %s\n", 
				id, name, hours, hourlyRate, dateOfHire.toString());
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getHours() {
		return hours;
	}
	
	public void setHours(double hours) {
		this.hours = hours;
	}
	
	public double getHourlyRate() {
		return hourlyRate;
	}
	
	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
	
	public String getDateOfHire() {
		return dateOfHire.toString();
	}
	
	public void setDateOfHire(int day, int month, int year) {
		try {
			dateOfHire = new Date(day, month, year);
		}catch(Exception e) {
			e.getMessage();
		}
	}	
	
	public double calculatePay() {
		return hours*hourlyRate;
	}
	
	public boolean isValidName(String name) {
		if (name.isEmpty()){
			return false;
		}
		return true;
	}
}
