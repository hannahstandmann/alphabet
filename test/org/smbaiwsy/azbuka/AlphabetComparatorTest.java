package org.smbaiwsy.azbuka;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AlphabetComparatorTest {

	@Test
	public void testAlphabetComparator() {
		AlphabetComparator ac = new AlphabetComparator();
		String[] names =new String[]{"Ljiljana", "Ljubiša","Cveta","Ana","Ana-Marija","Ana Maria","Anastasija","Lidija","Vladimir","Njegoš","Đorđe","Žarko","Hristina","Njegovan"};
		String[] expected =new String[]{"Ana", "Anastasija", "Ana Maria", "Ana-Marija", "Vladimir", "Đorđe", "Žarko", "Lidija", "Ljiljana", "Ljubiša", "Njegovan", "Njegoš", "Hristina", "Cveta"};
		Arrays.sort(names,ac);
		assertArrayEquals(names,expected);
	}
	@Test
	public void testAlphabetPersonComparator(){
		List<Person> people = Arrays.asList(new Person[]{new Person("1","Petrović","Ljiljana"), new Person("2", "Marković", "Ana"), new Person("3","Stojković", "Predrag"),new Person("4","Stojanović","Stojan"), new Person("5","Petrović","Žarko"),new Person("6","Habjanović Đurović", "Marija"),new Person("7","Jovanović", "Jovan"),new Person("8","Cvetković", "Ljubica")});
		people.sort(new AlphabetPersonComparator());
		String[] result = people.stream().map(p->p.getId()).toArray(String[]::new);
		assertArrayEquals(result, new String[]{"7","2","5","1","4","3","6","8"});
	}

}
