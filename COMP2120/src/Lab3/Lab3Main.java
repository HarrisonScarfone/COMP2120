package Lab3;

public class Lab3Main {
	
	public static void main(String[] args) {
		
		Weather weather1 = new Weather();
		System.out.println(weather1);
		Weather weather2 = new Weather(75, 40);
		System.out.println(weather2);
		Weather weather3 = new Weather(12, 500);
		System.out.println(weather3);		
	}
}
