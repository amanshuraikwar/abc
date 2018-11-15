package ds;

import static ds.UTest.*;

public class Driver {
	
	private static int testCaseCount = 0;

	public static void main(String[] args) {
		
		driveVector();
	}

	private static void driveVector() {

		try {
			
			Vector<Integer> vector = new Vector();
			int testCaseCount = 0;

			vector.add(1);
			vector.add(2);

			assertEquals("java.lang.Integer [2] { 1, 2 }", vector.toString());
			assertEquals("2", vector.size()+"");
			assertEquals("2", vector.limit()+"");

			vector.add(3);
			
			assertEquals("4", vector.limit()+"");

			vector.add(5);

			assertEquals("java.lang.Integer [4] { 1, 2, 3, 5 }", vector.toString());
			assertEquals("4", vector.size()+"");
			assertEquals("4", vector.limit()+"");
			
			vector.add(3, 4);

			assertEquals("java.lang.Integer [5] { 1, 2, 3, 4, 5 }", vector.toString());
			assertEquals("5", vector.size()+"");
			assertEquals("8", vector.limit()+"");

			vector.add(5, 6);

			assertEquals("java.lang.Integer [6] { 1, 2, 3, 4, 5, 6 }", vector.toString());
			assertEquals("6", vector.size()+"");

			assertEquals("1", vector.get(0)+"");
			assertEquals("2", vector.get(1)+"");
			assertEquals("3", vector.get(2)+"");
			assertEquals("4", vector.get(3)+"");
			assertEquals("5", vector.get(4)+"");

			vector.add(0, 0);
			assertEquals("java.lang.Integer [7] { 0, 1, 2, 3, 4, 5, 6 }", vector.toString());
			assertEquals("8", vector.limit()+"");

			vector.delete(0);
			assertEquals("java.lang.Integer [6] { 1, 2, 3, 4, 5, 6 }", vector.toString());
			assertEquals("8", vector.limit()+"");

			vector.delete(5);
			assertEquals("java.lang.Integer [5] { 1, 2, 3, 4, 5 }", vector.toString());
			assertEquals("8", vector.limit()+"");

			vector.delete(3);
			assertEquals("java.lang.Integer [4] { 1, 2, 3, 5 }", vector.toString());
			assertEquals("4", vector.limit()+"");

			vector.delete(0);
			assertEquals("4", vector.limit()+"");
			vector.delete(0);
			assertEquals("2", vector.limit()+"");
			vector.delete(0);
			assertEquals("2", vector.limit()+"");
			vector.delete(0);
			assertEquals("2", vector.limit()+"");

			vector.add(1);
			vector.set(0, 45);
			assertEquals("45", vector.get(0)+"");

			vector.delete(0);

			assertEquals("java.lang.Integer [0] { }", vector.toString());

			vector.add(1);
			vector.add(2);
			vector.prepend(0);

			assertEquals("java.lang.Integer [3] { 0, 1, 2 }", vector.toString());
			assertEquals("3", vector.size() + "");
			assertEquals("4", vector.limit() + "");

			vector.prepend(-1);
			vector.prepend(-2);
			vector.prepend(-3);

			assertEquals("java.lang.Integer [6] { -3, -2, -1, 0, 1, 2 }", vector.toString());
			assertEquals("6", vector.size() + "");
			assertEquals("8", vector.limit() + "");

			vector.pop();

			assertEquals("java.lang.Integer [5] { -3, -2, -1, 0, 1 }", vector.toString());

			vector.pop();

			assertEquals("4", vector.size() + "");
			assertEquals("4", vector.limit() + "");

			vector.pop();
			vector.pop();
			vector.pop();

			assertEquals("java.lang.Integer [1] { -3 }", vector.toString());

			vector.pop();
			
			assertEquals("java.lang.Integer [0] { }", vector.toString());
			assertEquals("0", vector.size() + "");
			assertEquals("2", vector.limit() + "");

			vector.add(1);
			vector.add(2);
			vector.add(3);
			vector.add(4);
			vector.add(5);

			assertEquals(2, vector.find(3));
			assertEquals(4, vector.find(5));
			assertEquals(0, vector.find(1));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}