package lab3;

public class Weather {
	
	private int tempF;
	private int windSpeed;
	private int windChill;
	private boolean severe;
	
	/**
	 * No argument constructor
	 */
	public Weather() {
		this(80, 0);
	}
	
	/**
	 * Parameterized constructor.
	 * @param tempF The temperature in Farenheit
	 * @param windSpeed The wind speed in miles per hour
	 */
	public Weather(int tempF, int windSpeed) {
		this.tempF = tempF;
		this.windSpeed = windSpeed;
		this.windChill = calculateWindchill(tempF, windSpeed);
		this.severe = isSevere(this.windChill);
	}
	
	/**
	 * To string method for the class.
	 */
	public String toString() {
		if(severe) {
			return "Current temperature is " + tempF + "'F. Feels like " + windChill + "'F and the wind speed is " + windSpeed 
					+ ". The windchill is severe.";
		}else {
			return "Current temperature is " + tempF + "'F. Feels like " + windChill + "'F and the wind speed is " + windSpeed + 
					". The windchill is not severe.";
		}		
	}
	
	/**
	 * Calculates the windchill based on class parameters. Used to set windchill in constructor.
	 * Cast to in as per lab requirements.
	 * @param tempF Temperature in farenehiet.
	 * @param windSpeed The windspeed in miles per hour.
	 * @return The windchill.
	 */
	public int calculateWindchill(int tempF, int windSpeed) {
		return (int) (35.74 + 0.6215*tempF - 35.75*Math.pow(windSpeed, 0.16) 
			+ 0.4275*tempF*Math.pow(windSpeed, 0.16));		
	}
	/**
	 * Using class parameters, determines if the windchill is severe. Is severe after windchill
	 * is less that -15.
	 * @return boolean classifing as severe or not severe.
	 */
	public boolean isSevere() {
		if(windChill < -15) {		
			return true;
		}
		return false;
	}
	
	/**
	 * Helper method. Updates the windchill and severity after setting a new
	 * temperature or windspeed.
	 */
	public void update() {
		windChill = calculateWindchill(tempF, windSpeed);
		severe = isSevere(windChill);
	}
	
	/**
	 * Determines if the windchill is to be classified as severe.
	 * @param windChill The windchill as an integer.
	 * @return Boolean determining if the windchill is severe or not.
	 */
	public boolean isSevere(int windChill) {
		if(windChill < -15) {		
			return true;
		}
		return false;
	}
	/**
	 * Setter for the temperature.
	 * @param tempF The temperature in farenheit.
	 */
	public void set_tempF(int tempF) {
		this.tempF = tempF;
		update();
	}
	/**
	 * Getter for the temperature.
	 * @return The temperature in farenehit.
	 */
	public int get_tempF() {
		return tempF;
	}
	/**
	 * Setter for the windspeed.
	 * @param windSpeed The new windspeed in miles per hour.
	 */
	public void set_windSpeed(int windSpeed) {
		this.windSpeed = windSpeed;
		update();
	}
	/**
	 * Getter for the wind speed.
	 * @return The windspeed in miles per hour.
	 */
	public int get_windSpeed() {
		return windSpeed;
	}	
}
