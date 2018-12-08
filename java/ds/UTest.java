package ds;

import static ds.L.*;

public class UTest {
	
	private static int testCaseCount = 0;

	public static void assertEquals(int expected, int actual) {
		assertEquals(expected + "", actual + "");
	}

	public static void assertEquals(float expected, float actual) {
		assertEquals(expected + "", actual + "");
	}

	public static void assertEquals(double expected, double actual) {
		assertEquals(expected + "", actual + "");
	}

	public static void assertEquals(boolean expected, boolean actual) {
		assertEquals(expected + "", actual + "");
	}

	public static void assertEquals(String expected, String actual) {
		
		boolean pass = expected.equals(actual);

		if (pass) {
			// tick char
			print(" " + ((char)0x2713) +" ");
			println("[" + (++testCaseCount) + "] Passed!");
		} else {
			// cross char
			print(" " + ((char)0x2A09) +" ");
			println("[" + (++testCaseCount) + "] Failed!");
		}
		
		if (!pass) {
			// replacing every char in '"[" + (testCaseCount) + "]"' with a space to give correct leading space
			println((" " + ((char)0x2A09) +" "+"[" + (testCaseCount) + "]").replaceAll("(\\s|\\S)", " ") + " Expected: " + expected + ", Actual: " + actual);
		}
	}
}