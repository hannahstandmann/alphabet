package org.smbaiwsy.azbuka;

import java.util.Comparator;

public class AlphabetPersonComparator implements Comparator<Person> {
	@Override
	public int compare(Person p1, Person p2) {
		AlphabetComparator ac = new AlphabetComparator();
		int surnames = ac.compare(p1.getSurname(), p2.getSurname());
		if (surnames == 0){
			return ac.compare(p1.getName(), p2.getName());
		}
		return surnames;
	}

}
