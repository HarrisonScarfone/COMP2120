package assignment2;

import java.util.Comparator;

public class GiftSort implements Comparator<GiftCard> {

	@Override
	public int compare(GiftCard o1, GiftCard o2) {
		return o1.getLabel().compareTo(o2.getLabel());
	}

}
