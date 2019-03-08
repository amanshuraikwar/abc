package ds;

import static ds.L.*;

public class UTest {
	
	private static int testCaseCount = 0;

	private static String context = null;

	public static void assertEquals(int expected, int actual) {
		assertEquals(expected + "", actual + "");
	}

	public static void assertEquals(long expected, long actual) {
		assertEquals(expected + "", actual + "");
	}

	public static void assertEquals(byte expected, byte actual) {
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
		String contextPrint = context != null ? "[" + context + "]" : "";
		
		if (pass) {
			// tick char
			print(" " + ((char)0x2713) +" ");
			println(contextPrint + " [" + (++testCaseCount) + "] Passed!");
		} else {
			// cross char
			print(" " + ((char)0x2A09) +" ");
			println(contextPrint + " [" + (++testCaseCount) + "] Failed!");
		}
		
		if (!pass) {
			// replacing every char in '"[" + (testCaseCount) + "]"' with a space to give correct leading space
			println((" " + ((char)0x2A09) + " " + contextPrint + " [" + (testCaseCount) + "]").replaceAll("(\\s|\\S)", " ") + " Expected: " + expected + ", Actual: " + actual);
		}
	}

	public static void setTestContext(String context) {
		UTest.context = context;
	}
}