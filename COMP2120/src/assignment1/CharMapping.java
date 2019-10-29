package assignment1;

import java.util.HashMap;

abstract class CharMapping {
	
	HashMap<Character, Character> reverseMap = new HashMap<Character, Character>();
	
	public void makeMap(){		
		reverseMap.put('A', 'A');
		reverseMap.put('E', '3');
		reverseMap.put('H', 'H');
		reverseMap.put('I', 'I');
		reverseMap.put('J', 'L');
		reverseMap.put('L', 'J');
		reverseMap.put('M', 'M');
		reverseMap.put('O', 'O');
		reverseMap.put('S', '2');
		reverseMap.put('T', 'T');
		reverseMap.put('U', 'U');
		reverseMap.put('V', 'V');
		reverseMap.put('W', 'W');
		reverseMap.put('X', 'X');
		reverseMap.put('Y', 'Y');
		reverseMap.put('Z', '5');
		reverseMap.put('1', '1');
		reverseMap.put('2', 'S');
		reverseMap.put('3', 'E');
		reverseMap.put('5', 'Z');
		reverseMap.put('8', '8');
	}
}
