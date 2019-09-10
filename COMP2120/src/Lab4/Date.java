package Lab4;

import java.time.LocalDate;

public class Date {

	private int day;
	private int month;
	private int year;
	
	public Date() {
		LocalDate localDate = java.time.LocalDate.now();
		String date = localDate.toString();
		this.year = Integer.parseInt(date.substring(0,4));
		this.month = Integer.parseInt(date.substring(5,7));
		this.day = Integer.parseInt(date.substring(8));		
	}
	
	public Date(int day, int month, int year) throws InvalidEntry {
		this.day = day;
		this.month = month;
		this.year = year;
		if(!isValidDay(day)){
			throw new InvalidEntry("The day is not valid.");
		}else if(!isValidMonth(month)) {
			throw new InvalidEntry("The month is not valid.");
		}else if(!isValidYear(year)) {
			throw new InvalidEntry("The year is not valid.");
		}
	}
	
	public String toString() {
		return "The date is (dd/mm/yyyy): " + day + "/" + month + "/" + year + "\n";
	}
	
	public void set_day(int day) {
		this.day = day;
	}
	
	public int get_day() {
		return day;
	}
	
	public void set_month(int month) {
		this.month = month;
	}
	
	public int get_month() {
		return month;
	}
	
	public void set_year(int year) {
		this.year = year;
	}
	
	public int get_year(int year) {
		return year;
	}
	
	public boolean isValidDay(int day){
		if(day > 31 || day < 1) {
			return false;
		}
		switch(month) {
		case 1: 
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return day < 32 && day > 0 ? true : false;
		case 2:
			if(year % 4 == 0) {
				return day < 30 && day > 0 ? true : false;
			}
			return day < 29 && day > 0 ? true : false;
		case 4:
		case 6:
		case 9:
		case 11:
			return day < 31 && day > 0 ? true: false;
		}
		return false;
	}
	
	public boolean isValidMonth(int month){
		if (month > 12 || month < 1) {
			return false;
		}
		switch(month) {
		case 1: 
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return day < 32 && day > 0 ? true : false;
		case 2:
			if(year % 4 == 0) {
				return day < 30 && day > 0 ? true : false;
			}
			return day < 29 && day > 0 ? true : false;
		case 4:
		case 6:
		case 9:
		case 11:
			return day < 31 && day > 0 ? true: false;
		}
		return false;
	}
	
	public boolean isValidYear(int year) {
		if (year < 0) {
			return false;
		}
		if (year%4 != 0) {
			if(month == 2) {
				return day > 28 ? false : true;
			}
		}
		return true;
	}
	
	public class InvalidEntry extends Exception{
		private static final long serialVersionUID = 1L;
		public InvalidEntry(String errorMessage) {
			super(errorMessage);
		}
	}	
}
