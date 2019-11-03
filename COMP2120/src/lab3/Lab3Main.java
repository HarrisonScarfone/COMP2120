package lab3;

public class Lab3Main {
	
	
	/**	
	 * The main driver method for lab3.
	 * @param args Runtime arguments.
	 */
	public static void main(String[] args) {
		Weather weather1 = new Weather();
		System.out.println(weather1);
		Weather weather2 = new Weather(13, 17);
		System.out.println(weather2);
		weather2.set_tempF(0);
		weather2.set_windSpeed(40);
		System.out.println(weather2);
	}
}


/*Without the no argument constructor the program throws
  an error saying that the no argument constructor is 
  undefined
*/

/*The no argument constructor is provided by default when
 the class parameters are given default values in the class */
 