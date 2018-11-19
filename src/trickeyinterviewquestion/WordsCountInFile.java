package trickeyinterviewquestion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
*/

public class WordsCountInFile {

	public static void main(String[] args) throws IOException {
		Path path = Paths.get("src/trickeyinterviewquestion/Palindrome.java");
		Stream<String> page = Files.lines(path);
		Stream<String> seperateWords = page.flatMap(line -> Arrays.stream(line.trim().split(" ")));
		Stream<String> words = seperateWords.map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim());
		Stream<String> ss = words.filter(w -> w.length() > 0);
		Map<String, Long> ssss = ss.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Set<Map.Entry<String, Long>> dsds = ssss.entrySet();
		for (Entry<String, Long> entry : dsds) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		/*
		 * Path path = Paths.get("src/trickeyinterviewquestion/Palindrome.java");
		 * 
		 * Path path=Paths.
		 * 
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
		 * 
		 * System.out.println("**************************************************");
		 * 
		 * Stream<String> abc = Files.lines(path).flatMap(line ->
		 * Arrays.stream(line.trim().split(" "))) .filter(word -> word.length() > 0);
		 * 
		 * Files.lines(path).flatMap(line ->
		 * Arrays.stream(line.trim().split(" "))).filter(word -> word.length() > 0)
		 * .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
		 * .forEach((k, v) -> System.out.println(k + " -> " + v));
		 */

	}

}
