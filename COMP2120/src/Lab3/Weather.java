package Lab3;

public class Weather {
	
	private int tempF;
	private int windSpeed;
	private int windChill;
	private boolean severe;
	
	public Weather() {
		this(80, 0);
	}
	
	public Weather(int tempF, int windSpeed) {
		this.tempF = tempF;
		this.windSpeed = windSpeed;
		this.windChill = calculateWindchill(tempF, windSpeed);
		this.severe = isSevere(this.windChill);
	}
	
	public String toString() {
		if(severe) {
			return "The air temperature is F" + tempF + " and the wind speed is " + windSpeed + ". Considering the windchill,"
					+ " it feels like " + windChill + " F.";
		}else {
			return "The air temperature is F" + tempF + " and the wind speed is " + windSpeed + ". Wind chill"
					+ " is not a factor.";
		}		
	}
	
	public int calculateWindchill() {
		return (int) (35.74 + 0.6215*tempF - 35.75*Math.pow(windSpeed, 0.16) 
			+ 0.4275*tempF*Math.pow(windSpeed, 0.16));		
	}
	
	public int calculateWindchill(int tempF, int windSpeed) {
		return (int) (35.74 + 0.6215*tempF - 35.75*Math.pow(windSpeed, 0.16) 
			+ 0.4275*tempF*Math.pow(windSpeed, 0.16));		
	}
	
	public boolean isSevere() {
		if(windChill < -15) {		
			return true;
		}
		return false;
	}
	
	public boolean isSevere(int windChill) {
		if(windChill < -15) {		
			return true;
		}
		return false;
	}
	
	public void set_tempF(int tempF) {
		this.tempF = tempF;
	}
	
	public int get_tempF() {
		return tempF;
	}
	
	public void set_windSpeed(int windSpeed) {
		this.windSpeed = windSpeed;
		windChill = calculateWindchill();
		severe = isSevere();
	}
	
	public int get_windSpeed() {
		return windSpeed;
	}	
}
