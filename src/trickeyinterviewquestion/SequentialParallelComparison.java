package trickeyinterviewquestion;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * First of all let’s have a look what happens behind the scene. The parallel
 * stream uses the Fork/Join Framework for processing. This means that the
 * stream-source is getting forked (splitted) and hands over to the
 * fork/join-pool workers for execution.
 * 
 * @author nitin
 *
 */

public class SequentialParallelComparison {

	public static void main(String[] args) {
		int[]  arrayint= {1 ,3 ,4, 5,6,87,8,5,32,23,34};
		Arrays.stream(arrayint).sequential().forEach(s ->{
			System.out.println(s+"  value    "+ Thread.currentThread().getName());
		});
		
		Arrays.stream(arrayint).parallel().forEach(s ->{
			System.out.println (s+" value "+ Thread.currentThread().getName());
		});
		
		
		String[] strings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		Stream<String> ddddd = Arrays.stream(strings);

		System.out.println("-------\nRunning sequential\n-------");
		Arrays.stream(strings).sequential().forEach(s -> {
			System.out.println(LocalTime.now() + "  " + s + "   " + Thread.currentThread().getName());
		});
		System.out.println("-------\nRunning parallel\n-------");
		Arrays.stream(strings).parallel().forEach(s -> {
			System.out.println(LocalTime.now() + "  " + s + "   " + Thread.currentThread().getName());
		});
	}

	public static void main3435(String[] args) {
		String[] strings = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

		System.out.println("-------\nRunning sequential\n-------");
		run(Arrays.stream(strings).sequential());
		System.out.println("-------\nRunning parallel\n-------");
		run(Arrays.stream(strings).parallel());
	}

	public static void run(Stream<String> stream) {

		stream.forEach(s -> {
			System.out.println(LocalTime.now() + " - value: " + s + " - thread: " + Thread.currentThread().getName());
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}
}