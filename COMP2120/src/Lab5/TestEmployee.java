package Lab5;

import java.util.ArrayList;
import java.util.Random;

public class TestEmployee extends Names{
	
	public static ArrayList<HourlyWorker> hourlyWorkers = new ArrayList<HourlyWorker>();
	private final static Random random = new Random();
	/**
	 * Driver function for Lab 4.
	 * @param args Command line arguments for program.
	 */
	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			HourlyWorker newWorker = new HourlyWorker(
					names[random.nextInt(10)],
					random.nextInt(47) + 18,
					random.nextInt(1500) + 1500,
					random.nextInt(100),
					random.nextDouble()*100 + 15.0
					);
			hourlyWorkers.add(newWorker);
		}
		
		for(HourlyWorker hw: hourlyWorkers) {
			hw.payWorker();
		}
	}
}
