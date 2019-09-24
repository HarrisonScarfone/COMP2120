package Lab1;
/**
 * Lab 1 Assignment.  Accomplishes 3 tasks as described 
 * in the lab handout and this javadoc.
 * @author Harrison Scarfone 104900846
 *
 */

public class Lab1Main {

	public static void main(String[] args) {
		System.out.println(calc(5, 7));
		System.out.print("\n");
		System.out.println(wordCap("hElLoWORLd"));
		System.out.println(wordCap("H"));
		System.out.println(wordCap(""));
		System.out.println(findKeyWord("This is a test", "TeSt", false));
		System.out.println(findKeyWord("This is a test", "TeSt", true));
		System.out.println(findKeyWord("This is a test", "test", false));
		System.out.println(findKeyWord("", "test", false));
		System.out.println(findKeyWord("This is a test", "", false));
		System.out.println(findKeyWord("This is a test", "This is a longer test", false));
	}
	
	/**
	 * Takes in an x and y value and outputs a value based on a given
	 * equation for the lab.
	 * @param x The x value for the equation.
	 * @param y The y value for the equation.
	 * @return The value calculated as per description.
	 */
	public static double calc (int x, int y) {
		try {
			return Math.pow((Math.PI*(Math.pow(y, 2))), 0.5) / (2*x);
		}catch(Exception e){
			System.out.println("Unable to calculate");
		}
		return 0;
	}
	
	/**
	 * Takes in a string and capitalizes the first letter and makes lower 
	 * case the remainder of the string.
	 * @param str The string value to be modified.
	 * @return The modified string.
	 */
	private static String wordCap(String str) {
		if(str.isEmpty()) {
			return "";
		}else if(str.length()==1) {
			return str.toUpperCase();
		}else {
			return (str.substring(0,1)).toUpperCase() + (str.substring(1,str.length()).toLowerCase());
		}
	}
	
	/**
	 * Looks for a keyword kw inside of a String str.
	 * @param str The string to be searched.
	 * @param kw The keyword to look for.
	 * @param caseSensitive If the search should be case sensitive.
	 * @return Boolean true if kw is found in str.
	 */
	private static boolean findKeyWord(String str, String kw, boolean caseSensitive) {
		
		if(str.isEmpty() || kw.isEmpty()) {
			System.out.println("One of your input lines was blank. Returning false.");
			return false;
		}
		
		if(str.length() < kw.length()) {
			System.out.println("KW longer than str. Returning false.");
			return false;
		}
		
		if(!caseSensitive) {
			if(str.contains(kw)) {			
				return true;
			}
		}else {
			String str1 = str.toLowerCase();
			String kw1 = str.toLowerCase();
			if(str1.contains(kw1)) {
				return true;
			}
		}	
		return false;
	}	
}
