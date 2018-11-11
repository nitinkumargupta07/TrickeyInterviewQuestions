package multithreading;

class State {
	private int state;

	public State() {
		this.state = 3;
	}

	public synchronized int getState() {
		return state;
	}

	public synchronized void setState(int state) {
		this.state = state;
	}

}

class T1 implements Runnable {

	State s;

	public T1(State s) {
		this.s = s;
	}

	@Override
	public void run() {
		int i = 1;

		while (i < 50) {
			// System.out.println("s in t1 "+ s.getState());

			while (s.getState() != 3) {

				synchronized (s) {
					try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

			synchronized (s) {
				// if(s.getState() ==3)

				if (s.getState() == 3)
					System.out.println("t1 " + i);
				s.setState(1);
				i = i + 3;
				s.notifyAll();

			}

		}

	}

}

class T2 implements Runnable {

	State s;

	public T2(State s) {
		this.s = s;
	}

	@Override
	public synchronized void run() {
		int i = 2;

		while (i < 50) {

			while (s.getState() != 1) {

				synchronized (s) {
					try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

			synchronized (s) {
				// if(s.getState() ==3)

				if (s.getState() == 1)
					System.out.println("t2 " + i);
				s.setState(2);
				i = i + 3;
				s.notifyAll();

			}

		}

	}

}

class T3 implements Runnable {

	State s;

	public T3(State s) {
		this.s = s;
	}

	@Override
	public synchronized void run() {
		int i = 3;

		while (i < 50) {

			while (s.getState() != 2) {
				synchronized (s) {
					try {
						s.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			}

			synchronized (s) {

				if (s.getState() == 2)
					System.out.println("t3 " + i);
				i = i + 3;
				s.setState(3);
				s.notifyAll();
			}

		}

	}
}

public class HowToEnsureThreadSequence1 {
	public static void main(String[] args) {

		State s = new State();
		Thread t1 = new Thread(new T1(s));
		Thread t2 = new Thread(new T2(s));
		Thread t3 = new Thread(new T3(s));

		t1.start();
		t2.start();
		t3.start();

	}
}
