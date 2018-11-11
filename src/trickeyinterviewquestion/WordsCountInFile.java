package trickeyinterviewquestion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordsCountInFile {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("src/Palindrome.java");
		
		/*
		 * Iterator<Entry<String, Long>> iterator = Files.lines(path) .flatMap(line ->
		 * Arrays.stream(line.trim().split(" "))) .map(word ->
		 * word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()).filter(word ->
		 * word.length() > 0) .map(word -> new SimpleEntry<>(word,
		 * 1)).collect(groupingBy(SimpleEntry::getKey, counting())).entrySet()
		 * .iterator(); Files.lines(path).flatMap(line ->
		 * Arrays.stream(line.trim().split(" "))) .map(word ->
		 * word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()).filter(word ->
		 * word.length() > 0) .map(word -> new SimpleEntry<>(word,
		 * 1)).collect(groupingBy(SimpleEntry::getKey, counting())) .forEach((k, v) ->
		 * System.out.println(k + " -> " + v));
		 */
		System.out.println("**************************************************");
		
		Stream<String> abc =Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" "))).filter(word -> word.length() > 0);

		Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" "))).filter(word -> word.length() > 0)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				.forEach((k, v) -> System.out.println(k + " -> " + v));

	}

}
