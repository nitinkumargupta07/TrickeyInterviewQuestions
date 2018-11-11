package multithreading;

/**
 * Solution: Sequencing in multi-threading can be achieved by different means
 * but you can simply use join() method of thread class to start a thread when
 * another one is finished its execution. To ensure three threads execute you
 * need to start the last one first e.g. T3 and then call join methods in
 * reverse order e.g. T3 calls T2.join, and T2 calls T1.join, this ways T1 will
 * finish first and T3 will finish last.
 * 
 * @author nitin
 *
 */
public class HowToEnsureThreadsSequence {

	public static void main(String[] args) {

		final Thread T1 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Starting 1");
				System.out.println("Ending 1");
			}

		});

		final Thread T2 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Starting 2");
				
					try {
						T1.join();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				System.out.println("Ending 2");
			}

		});

		Thread T3 = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Starting 3");
				try {
					T2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println("Ending 3");
			}

		});

		// Starting's are random
		T3.start();
		T2.start();
		T1.start();

		// Endings are always 1,2,3
	}

}
