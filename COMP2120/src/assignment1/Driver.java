package assignment1;

import java.io.File;
import java.util.Scanner;

/*class handles file io and instantiates checker
 * passes each line to checker and outputs the type determination
 */

public class Driver {

	public static void main(String[] args) {
		
		File f = new File("test.txt");
		Checker strChk = new Checker();
		
		try {
			Scanner scanner = new Scanner(f);			
			while(scanner.hasNextLine()) {
				strChk.str = scanner.next();
				System.out.println(strChk.getClassification());
			}		
			scanner.close();
		}catch(Exception e) {
			System.out.println("Blank line or path error");
		}
	}
	
}
