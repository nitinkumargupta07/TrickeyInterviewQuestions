package trickeyinterviewquestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MapVsFlatMap {
	/**
	 * In Java 8, Stream can hold different data types, for examples:
	 * ******************Using Map**********************************
	 * *******************USINg flatMap*******************
	 * 
	 * Stream<String[]> -> flatMap -> Stream<String>
	 * 
	 * Stream<Set<String>> -> flatMap -> Stream<String>
	 * 
	 * Stream<List<String>> -> flatMap -> Stream<String>
	 * 
	 * Stream<List<Object>> -> flatMap -> Stream<Object>
	 * 
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		List<Integer> listOfIntegers = Stream.of("1", "2", "3", "4").map(a -> Integer.valueOf(a))
				.collect(Collectors.toList());

		List<Integer> evens = Arrays.asList(2, 4, 6, 8);
		List<Integer> odds = Arrays.asList(3, 5, 7);
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11);
		

		IntStream  dddd=IntStream.range(1, 5).map(i -> i * i);  
		Stream<Integer> stream = IntStream.range(1, 5).boxed();  
		List<Integer> numbers = Stream.of(evens, odds, primes).flatMap(list -> list.stream())
				.collect(Collectors.toList());

		System.out.println("flattend list: " + numbers);

		String[][] data = new String[][] { { "a", "b" }, { "c", "d" }, { "e", "f" }, { "sd" },
				{ "sdsds", "wewe", "we" } };
		// Stream<String[]>
		Stream<String[]> temp = Arrays.stream(data);
		// Stream<String>, GOOD!
		Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));

	}

	public static void main12(String[] args) {
		Student obj1 = new Student();
		obj1.setName("mkyong");
		obj1.addBook("Java 8 in Action");
		obj1.addBook("Spring Boot in Action");
		obj1.addBook("Effective Java (2nd Edition)");

		Student obj2 = new Student();
		obj2.setName("zilap");
		obj2.addBook("Learning Python, 5th Edition");
		obj2.addBook("Effective Java (2nd Edition)");

		List<Student> list = new ArrayList<>();
		list.add(obj1);
		list.add(obj2);

		List<String> collect = list.stream().map(x -> x.getBook()) // Stream<Set<String>>
				.flatMap(x -> x.stream()) // Stream<String>
				.distinct().collect(Collectors.toList());
		System.out.println(collect);

	}

}

class Student {

	private String name;

	public String getName() {
		return name;
	}

	public Student() {
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getBook() {
		return book;
	}

	public void setBook(Set<String> book) {
		this.book = book;
	}

	private Set<String> book;

	public void addBook(String book) {
		if (this.book == null) {
			this.book = new HashSet<>();
		}
		this.book.add(book);
	}
}
