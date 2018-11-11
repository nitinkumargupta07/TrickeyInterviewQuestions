package trickeyinterviewquestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class CharacterOccuranceCount {
	// https://howtodoinjava.com/java8/java8-boxed-intstream/
	// https://www.geeksforgeeks.org/intstream-boxed-java/
	public static void main(String[] args) {
		/*
		 * String inputString; Scanner in = new Scanner(System.in);
		 * 
		 * System.out.println("Input a string"); inputString = in.nextLine();
		 */
		String inputString = "sfdsfdsfsdfdsfsgetyter";
		String str = charsOccuranceCountStr1(inputString);

	}

	private static String charsOccuranceCountStr1(String inputString) {
		StringBuilder charCount = new StringBuilder();
		
		
		inputString.chars().mapToObj(c ->(char) c).collect(Collectors.groupingBy(Function.identity() ,Collectors.counting()));
		///inputString.chars().boxed().collect(Collectors.groupingBy(c ->Character.valueOf((char) c.intValue(), LinkedHashMap::new ,Collectors.counting())));
		

		Map<Character, Long> testss = inputString.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		Iterator<Entry<Character, Long>> qqstr = inputString.chars().boxed().collect(Collectors
				.groupingBy(c -> Character.valueOf((char) c.intValue()), LinkedHashMap::new, Collectors.counting()))
				.entrySet().iterator();
		while (qqstr.hasNext()) {
			Entry<Character, Long> sdsd = qqstr.next();
			charCount.append(sdsd.getKey()).append(sdsd.getValue().toString());
		}
		StringBuilder charCount1 = new StringBuilder();
		Set<Entry<Character, Long>> str = inputString.chars().boxed().collect(Collectors
				.groupingBy(c -> Character.valueOf((char) c.intValue()), LinkedHashMap::new, Collectors.counting()))
				.entrySet();
		for (Iterator iterator = str.iterator(); iterator.hasNext();) {
			Entry<Character, Long> entry = (Entry<Character, Long>) iterator.next();
			charCount1.append(entry.getKey()).append(entry.getValue().toString());
		}
		System.out.println(charCount.toString());
		return charCount.toString();

	}

	private static String charsOccuranceCountStr(String inputString) {

		Map<Character, Integer> frequencies = inputString.toLowerCase().chars().boxed()
				.collect(toMap(k -> Character.valueOf((char) k.intValue()), v -> 1, // 1 occurence
						Integer::sum, LinkedHashMap::new)); // counting

		inputString.toLowerCase().chars().boxed().collect(toMap(k -> Character.valueOf((char) k.intValue()), v -> 1, // 1
				Integer::sum, LinkedHashMap::new)).forEach((k, v) -> System.out.println(k + "" + v));

		System.out.println(frequencies);

		return null;
	}

}
