package trickeyinterviewquestion;


public class Java7MultipleExceptions {

	public static void main(String[] args) {
		try {
			rethrow("abc");
		} catch (FirstException | SecondException |NullPointerException | ThirdException  e) {
			// below assignment will throw compile time exception since e is final
			// e = new Exception();
			System.out.println(e.getMessage());
		}
	}

	static void rethrow(String s) throws FirstException, SecondException, ThirdException {
		try {
			if (s.equals("First"))
				throw new FirstException("First");
			else if (s.equals("Second"))
				throw new SecondException("Second");
			else if (s.equals("third"))
				throw new ThirdException("Third");
			else
				throw new NullPointerException("Null");
		} catch (Exception e) {
			// below assignment disables the improved rethrow exception type checking
			// feature of Java 7
			// e=new ThirdException();
			throw e;
		}
	}

	static class FirstException extends Exception {

		public FirstException(String msg) {
			super(msg);
		}
	}

	static class SecondException extends Exception {

		public SecondException(String msg) {
			super(msg);
		}
	}

	static class ThirdException extends Exception {

		public ThirdException(String msg) {
			super(msg);
		}
	}

}