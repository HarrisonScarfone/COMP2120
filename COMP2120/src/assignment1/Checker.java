package assignment1;

public class Checker extends CharMapping {
	
	public String str;
	private int midIdx;
	/**
	 * No parameter constructor that builds a hashmap to enable the character matching
	 */
	public Checker() {
		makeMap();
	}
	/**
	 * Check to see if the string is a palindrome
	 * @return Boolean based on if the string is a palindrome
	 */
	public boolean palindromeChecker() {
		midIdx = str.length() / 2;
		for(int i=0; i<midIdx; i++) {
			if(str.charAt(i) != str.charAt(str.length()-1-i)) { 
				return false;
			}
		}
		return true;
	}
	public boolean isMapped(char c) {
		try {
			reverseMap.get(c);
			return true;
		}catch(Exception e) {	
			//no char value in hashmap so str cannot be a mirrored string return false on catch
			return false;
		}				
	}
	/**
	 * Function to check if the string is a mirror
	 * @return Boolean based on if the string is a mirror or not
	 */
	public boolean mirrorChecker(){	
		midIdx = str.length() / 2;
		for(int i=0; i<midIdx; i++) {
			try {
				if(isMapped(str.charAt(i)) && (reverseMap.get(str.charAt(i)) != (str.charAt(str.length()-1-i)))){ 
					return false;
				}
			}catch(Exception e) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Function that returns the classification of a string
	 * @return The classification of a string as a string
	 */
	public String getClassification() {
		if(palindromeChecker() == true) {
			if(mirrorChecker() == true) {
				return str + " is a mirrored palindrome.";
			}
			return str + " is a regular palindrome.";
		}else if(mirrorChecker() == true){
			return str + " is a mirrored string.";			
		}else {
			return str + " is not a palindrome.";
		}	
	}
	
}
