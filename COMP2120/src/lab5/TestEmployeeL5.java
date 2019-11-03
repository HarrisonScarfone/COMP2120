package lab5;

import java.util.ArrayList;
import java.util.Random;

public class TestEmployeeL5 extends NamesL5{
	
	private final static ArrayList<HourlyWorkerL5> hourlyWorkers = new ArrayList<HourlyWorkerL5>();
	private final static Random random = new Random();
	/**
	 * Driver function for Lab 4.
	 * @param args Command line arguments for program.
	 */
	public static void main(String[] args) {
		for(int i=0; i<30; i++) {
			HourlyWorkerL5 newWorker = new HourlyWorkerL5(
					names[random.nextInt(names.length)],
					random.nextInt(47) + 18,
					random.nextInt(1500) + 1500,
					random.nextInt(100),
					random.nextDouble()*100 + 15.0
					);
			hourlyWorkers.add(newWorker);
		}
		
		for(HourlyWorkerL5 hw: hourlyWorkers) {
			System.out.println("|||||||||||||||||||||||||||||||||||||||");
			hw.payWorker();
			System.out.println("===========================");
			hw.payWorker();
			System.out.println("===========================");
			System.out.println(hw);
			System.out.println("===========================");
			System.out.println("|||||||||||||||||||||||||||||||||||||||");
		}
	}
}
