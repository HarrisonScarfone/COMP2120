package lab9;

import java.util.Comparator;

public class DescendingPeopleSort implements Comparator<Person>{

	@Override
	public int compare(Person arg0, Person arg1) {
		if(arg0.getLastName().compareTo(arg1.getLastName())==0) {
			return arg0.getFirstName().compareTo(arg1.getFirstName());
		}else {
			return (-1) * arg0.getLastName().compareTo(arg1.getLastName());
		}
	}

}
