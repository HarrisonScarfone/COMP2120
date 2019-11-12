package assignment2;

import java.util.Comparator;

public class ShoeSort implements Comparator<Shoe>{

	@Override
	public int compare(Shoe o1, Shoe o2) {
		return (int) (o1.getSize() - o2.getSize());
	}
}
