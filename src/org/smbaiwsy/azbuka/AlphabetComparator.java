package org.smbaiwsy.azbuka;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlphabetComparator implements Comparator<String> {
	public static String ALPHABET_LIST = "ABVGDĐEŽZIJKLLJMNNJOPRSTĆUFHCČDŽŠ -"; 
	Pattern ALPHABET_LETTERS = Pattern.compile("(LJ|NJ|DŽ|A|B|V|G|D|Đ|E|Ž|Z|I|J|K|L|M|N|O|P|R|S|T|Ć|U|F|H|C|Č|Š|\\s|-)");
	private List<String> findLetters(String word){
		 Matcher m = ALPHABET_LETTERS.matcher(word.toUpperCase());
		 List<String> letters = new ArrayList<>();
		 while (m.find()) {
			letters.add(m.group(1));
		 }
		 return letters;
	} 
	@Override
	public int compare(String s1, String s2) {
		if (s1.equals(s2)) return 0;
		if (s1.contains(s2)) return 1;
		if (s2.contains(s1)) return -1;
		List<String> first = findLetters(s1);
		List<String> second = findLetters(s2);
	    int length = Math.min(first.size(), second.size());
	    int result;
		for (int i = 0; i<length;i++){
			int p1 = ALPHABET_LIST.indexOf(first.get(i));
			int p2 = ALPHABET_LIST.indexOf(second.get(i));
			result = p1-p2;
			if (result != 0) return result;
		}
		result = first.size() - second.size();
		if (result == 0) return result;
		return result;
	}
}
