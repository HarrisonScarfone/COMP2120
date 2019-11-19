package lab9;

public class Person {
	
	private String lastName;
	private String firstName;
	private String birthMonth;
	private String birthDay;
	private String birthYear;
	
	public Person(String lastName, String firstName, String birthMonth, String birthDay, String birthYear) {
		this.lastName = lastName;
		this.firstName = firstName;
		setBirthMonth(birthMonth);
		setBirthDay(birthDay);
		setBirthYear(birthYear);
	}
	
	public String toString() {
		return "" + lastName + "," + firstName + "," + birthMonth + "/" + birthDay + "/" + birthYear;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getBirthMonth() {
		return birthMonth;
	}
	
	public void setBirthMonth(String birthMonth) {
		try {
			int bm = Integer.parseInt(birthMonth);
			if(bm < 12 && bm > 0) {
				this.birthMonth = birthMonth;
			}
		}catch(Exception e) {
			this.birthMonth = "1";
		}
	}
	
	public String getBirthDay() {
		return birthDay;
	}
	
	public void setBirthDay(String birthDay) {
		try {
			int bd = Integer.parseInt(birthDay);
			if(bd < 31 && bd > 0) {
				this.birthDay = birthDay;
			}
		}catch(Exception e) {
			this.birthDay = "1";
		}
	}
	
	public String getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(String birthYear) {
		try {
			int by = Integer.parseInt(birthMonth);
			if(by < 12 && by > 0) {
				this.birthYear = birthYear;
			}
		}catch(Exception e) {
			this.birthYear = "1900";
		}
	}
}
