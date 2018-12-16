package ds;

import static ds.UTest.*;

public class Driver {
	
	private static int testCaseCount = 0;

	public static void main(String[] args) {
		
		// driveQueue();
		// driveStack();
		// driveLinkedList();
		// driveVector();
		// driveCircularBuffer();
		// driveRollingHash();

		driveKarpRabin();

	}

	private static void driveKarpRabin() {

		String searchStr = "t sub";
		String domainStr = "You can get substring  ";

		RollingHash rh1 = new RollingHash.DivisionRollingHash(541);
		RollingHash rh2 = new RollingHash.DivisionRollingHash(541);

		for(int i = 0; i < searchStr.length(); i++) {
			rh1.append(searchStr.charAt(i));
		}

		for(int i = 0; i < searchStr.length(); i++) {
			rh2.append(domainStr.charAt(i));
		}

		boolean equal = false;

		if (rh1.hash() == rh2.hash()) {
			equal = searchStr.equals(domainStr.substring(0, searchStr.length()));
		}

		assertEquals(false, equal);

		for(int i = searchStr.length(); i < domainStr.length(); i++) {

			rh2.skip(domainStr.charAt(i - searchStr.length()));
			rh2.append(domainStr.charAt(i));

			// L.println("Index: " + (i - searchStr.length() + 1) + " Hash 1: " + rh1.hash() + " hash 2: " + rh2.hash());

			if (rh1.hash() == rh2.hash()) {
				equal = searchStr.equals(domainStr.substring(i - searchStr.length() + 1, i + 1));
			}

			if (equal) {
				break;
			}
		}

		assertEquals(true, equal);

	}

	private static void driveRollingHash() {

		String s1 = "ABC";
		
		RollingHash rh1 = new RollingHash.DivisionRollingHash(541);
		
		for(int i = 0; i < s1.length(); i++) {
			rh1.append(s1.charAt(i));
		}

		// appending
		assertEquals(131, rh1.hash());

		// skipping to zero
		rh1.skip('A');

		assertEquals(400, rh1.hash());

		rh1.skip('B');

		assertEquals(67, rh1.hash());

		rh1.skip('C');

		assertEquals(0, rh1.hash());

		// checking for hash, skip vs append
		s1 = "ABCDEFGH";

		for(int i = 0; i < s1.length(); i++) {
			rh1.append(s1.charAt(i));
		}

		String s2 = "BCDEFGH";

		RollingHash rh2= new RollingHash.DivisionRollingHash(541);

		for(int i = 0; i < s2.length(); i++) {
			rh2.append(s2.charAt(i));
		}

		rh1.skip('A');

		assertEquals(true, rh1.hash() == rh2.hash());

	}

	private static void driveCircularBuffer() {

		CircularBuffer<Integer> cb = new CircularBuffer.LinkedCircularBuffer<>(5);
		
		assertEquals("null", cb.peek() + "");
		assertEquals("null", cb.pop() + "");
		assertEquals(true, cb.empty());
		assertEquals(5, cb.spaceLeft());
		assertEquals(false, cb.full());

		assertEquals(true, cb.push(1));
		assertEquals(1, cb.peek());
		assertEquals(false, cb.empty());
		assertEquals(4, cb.spaceLeft());
		assertEquals(false, cb.full());

		assertEquals(1, cb.pop());
		assertEquals("null", cb.pop() + "");
		
		assertEquals(true, cb.push(-1));
		assertEquals(true, cb.push(-2));
		
		assertEquals(-1, cb.peek());
		assertEquals(false, cb.empty());
		assertEquals(3, cb.spaceLeft());
		assertEquals(false, cb.full());

		assertEquals(-1, cb.pop());
		assertEquals(-2, cb.peek());
		assertEquals(false, cb.empty());
		assertEquals(4, cb.spaceLeft());
		assertEquals(false, cb.full());

		assertEquals(-2, cb.pop());
		assertEquals("null", cb.peek() + "");
		assertEquals("null", cb.pop() + "");
		assertEquals(true, cb.empty());
		assertEquals(5, cb.spaceLeft());
		assertEquals(false, cb.full());

		assertEquals(true, cb.push(-1));
		assertEquals(true, cb.push(-2));
		assertEquals(true, cb.push(-3));
		assertEquals(true, cb.push(-4));
		assertEquals(true, cb.push(-5));

		assertEquals(false, cb.empty());
		assertEquals(0, cb.spaceLeft());
		assertEquals(true, cb.full());

		assertEquals(false, cb.push(-6));
		assertEquals(false, cb.push(-7));

		assertEquals(false, cb.empty());
		assertEquals(0, cb.spaceLeft());
		assertEquals(true, cb.full());

		assertEquals(-1, cb.peek());
		
		assertEquals(-1, cb.pop());

		assertEquals(-2, cb.peek());
		assertEquals(false, cb.empty());
		assertEquals(1, cb.spaceLeft());
		assertEquals(false, cb.full());

		assertEquals(-2, cb.pop());

		assertEquals(-3, cb.peek());
		assertEquals(false, cb.empty());
		assertEquals(2, cb.spaceLeft());
		assertEquals(false, cb.full());

		assertEquals(-3, cb.pop());
		assertEquals(-4, cb.pop());

		assertEquals(-5, cb.peek());
		assertEquals(false, cb.empty());
		assertEquals(4, cb.spaceLeft());
		assertEquals(false, cb.full());

		assertEquals(-5, cb.pop());
		assertEquals("null", cb.peek() + "");
		assertEquals("null", cb.pop() + "");
		assertEquals(true, cb.empty());
		assertEquals(5, cb.spaceLeft());
		assertEquals(false, cb.full());
	}

	private static void driveQueue() {

		Queue<Integer> queue = new Queue.LinkedQueue<>();
		assertEquals(0, queue.size());
		assertEquals(true, queue.empty());
		assertEquals("null", queue.pop() + "");
		assertEquals("null", queue.peek() + "");

		queue.push(1);
		assertEquals(1, queue.size());
		assertEquals(false, queue.empty());
		assertEquals(1, queue.peek());

		assertEquals(1, queue.pop());
		assertEquals(0, queue.size());
		assertEquals(true, queue.empty());
		assertEquals("null", queue.pop() + "");
		assertEquals("null", queue.peek() + "");

		queue.push(1);
		queue.push(2);
		assertEquals(2, queue.size());
		assertEquals(false, queue.empty());
		assertEquals(1, queue.peek());
		assertEquals(1, queue.pop());

		assertEquals(2, queue.peek());
		assertEquals(1, queue.size());
		assertEquals(false, queue.empty());

		assertEquals(2, queue.pop());
		assertEquals(0, queue.size());
		assertEquals(true, queue.empty());
		assertEquals("null", queue.pop() + "");
		assertEquals("null", queue.peek() + "");

		queue.push(1);
		queue.push(2);
		queue.push(3);
		queue.push(4);
		queue.push(-5);
		assertEquals(5, queue.size());
		assertEquals(false, queue.empty());
		assertEquals(1, queue.peek());

		assertEquals(1, queue.pop());
		assertEquals(2, queue.peek());
		assertEquals(2, queue.pop());
		assertEquals(3, queue.peek());
		assertEquals(3, queue.pop());
		assertEquals(4, queue.peek());
		assertEquals(4, queue.pop());
		assertEquals(-5, queue.peek());
		assertEquals(-5, queue.pop());

		assertEquals(0, queue.size());
		assertEquals(true, queue.empty());
		assertEquals("null", queue.pop() + "");
		assertEquals("null", queue.peek() + "");

	}

	private static void driveStack() {

		Stack<Integer> stack = new Stack.LinkedStack<>();
		assertEquals(0, stack.size());
		assertEquals(true, stack.empty());
		assertEquals("null", stack.pop() + "");
		assertEquals("null", stack.peek() + "");

		stack.push(1);
		assertEquals(1, stack.size());
		assertEquals(false, stack.empty());
		assertEquals(1, stack.peek());

		assertEquals(1, stack.pop());
		assertEquals(0, stack.size());
		assertEquals(true, stack.empty());
		assertEquals("null", stack.pop() + "");
		assertEquals("null", stack.peek() + "");

		stack.push(1);
		stack.push(2);
		assertEquals(2, stack.size());
		assertEquals(false, stack.empty());
		assertEquals(2, stack.peek());
		assertEquals(2, stack.pop());

		assertEquals(1, stack.peek());
		assertEquals(1, stack.size());
		assertEquals(false, stack.empty());

		assertEquals(1, stack.pop());
		assertEquals(0, stack.size());
		assertEquals(true, stack.empty());
		assertEquals("null", stack.pop() + "");
		assertEquals("null", stack.peek() + "");

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(-5);
		assertEquals(5, stack.size());
		assertEquals(false, stack.empty());
		assertEquals(-5, stack.peek());

		assertEquals(-5, stack.pop());
		assertEquals(4, stack.peek());
		assertEquals(4, stack.pop());
		assertEquals(3, stack.peek());
		assertEquals(3, stack.pop());
		assertEquals(2, stack.peek());
		assertEquals(2, stack.pop());
		assertEquals(1, stack.peek());
		assertEquals(1, stack.pop());

		assertEquals(0, stack.size());
		assertEquals(true, stack.empty());
		assertEquals("null", stack.pop() + "");
		assertEquals("null", stack.peek() + "");

	}

	private static void driveLinkedList() {

		LinkedList<Integer> ll = new LinkedList();

		assertEquals("LinkedList [0] { }", ll.toString());
		assertEquals(0, ll.size());
		assertEquals(true, ll.empty());
		assertEquals(null + "", ll.front() + "");
		assertEquals(null + "", ll.back() + "");

		ll.pushFront(1);

		assertEquals("LinkedList [1] { 1 }", ll.toString());
		assertEquals(1, ll.size());
		assertEquals(false, ll.empty());
		assertEquals(1, ll.front());
		assertEquals(1, ll.back());

		ll.pushFront(2);

		assertEquals(2, ll.front());
		assertEquals(1, ll.back());

		ll.pushFront(3);
		ll.pushFront(4);

		assertEquals("LinkedList [4] { 4, 3, 2, 1 }", ll.toString());
		assertEquals(4, ll.size());
		assertEquals(4, ll.front());
		assertEquals(1, ll.back());

		assertEquals(4, ll.popFront());
		assertEquals("LinkedList [3] { 3, 2, 1 }", ll.toString());
		assertEquals(3, ll.size());
		assertEquals(3, ll.front());
		assertEquals(1, ll.back());

		assertEquals(3, ll.popFront());
		assertEquals(2, ll.popFront());

		assertEquals("LinkedList [1] { 1 }", ll.toString());
		assertEquals(1, ll.size());
		assertEquals(1, ll.front());
		assertEquals(1, ll.back());

		assertEquals(1, ll.popFront());

		assertEquals(0, ll.size());
		assertEquals(null + "", ll.front() + "");
		assertEquals(null + "", ll.back() + "");

		ll.pushFront(-2);
		ll.pushFront(-1);

		assertEquals("LinkedList [2] { -1, -2 }", ll.toString());
		assertEquals(2, ll.size());
		assertEquals(-1, ll.front());
		assertEquals(-2, ll.back());

		assertEquals(-1, ll.popFront());
		assertEquals(1, ll.size());
		assertEquals(-2, ll.front());
		assertEquals(-2, ll.back());

		assertEquals(-2, ll.popFront());

		ll.pushBack(-1);
		
		assertEquals("LinkedList [1] { -1 }", ll.toString());
		assertEquals(1, ll.size());
		assertEquals(-1, ll.front());
		assertEquals(-1, ll.back());

		ll.pushBack(-2);
		ll.pushBack(-3);

		assertEquals("LinkedList [3] { -1, -2, -3 }", ll.toString());
		assertEquals(3, ll.size());
		assertEquals(-1, ll.front());
		assertEquals(-3, ll.back());

		assertEquals(-3, ll.popBack());
		
		assertEquals("LinkedList [2] { -1, -2 }", ll.toString());
		assertEquals(2, ll.size());
		assertEquals(-1, ll.front());
		assertEquals(-2, ll.back());

		assertEquals(-2, ll.popBack());
		assertEquals("LinkedList [1] { -1 }", ll.toString());
		assertEquals(1, ll.size());
		assertEquals(-1, ll.front());
		assertEquals(-1, ll.back());


		assertEquals(-1, ll.popBack());
		assertEquals("LinkedList [0] { }", ll.toString());
		assertEquals(0, ll.size());
		assertEquals(null + "", ll.front() + "");
		assertEquals(null + "", ll.back() + "");

		assertEquals(true, ll.insert(0, 10));
		assertEquals("LinkedList [1] { 10 }", ll.toString());
		assertEquals(1, ll.size());
		assertEquals(10, ll.front());
		assertEquals(10, ll.back());

		assertEquals(true, ll.insert(0, 5));
		assertEquals(true, ll.insert(0, 1));
		assertEquals(true, ll.insert(1, 2));
		assertEquals(true, ll.insert(4, 20));

		assertEquals("LinkedList [5] { 1, 2, 5, 10, 20 }", ll.toString());
		assertEquals(5, ll.size());
		assertEquals(1, ll.front());
		assertEquals(20, ll.back());

		assertEquals(1, ll.erase(0));

		assertEquals("LinkedList [4] { 2, 5, 10, 20 }", ll.toString());
		assertEquals(4, ll.size());
		assertEquals(2, ll.front());
		assertEquals(20, ll.back());

		assertEquals(null + "", ll.erase(4) + "");

		assertEquals(20, ll.erase(3));

		assertEquals("LinkedList [3] { 2, 5, 10 }", ll.toString());
		assertEquals(3, ll.size());
		assertEquals(2, ll.front());
		assertEquals(10, ll.back());

		assertEquals(5, ll.erase(1));
		assertEquals("LinkedList [2] { 2, 10 }", ll.toString());
		assertEquals(2, ll.size());
		assertEquals(2, ll.front());
		assertEquals(10, ll.back());

		assertEquals(10, ll.erase(1));
		assertEquals(2, ll.erase(0));
		assertEquals("LinkedList [0] { }", ll.toString());
		assertEquals(0, ll.size());
		assertEquals(null + "", ll.front() + "");
		assertEquals(null + "", ll.back() + "");

		ll.pushBack(100);
		ll.pushBack(200);
		ll.pushBack(300);
		ll.pushBack(400);

		assertEquals("LinkedList [4] { 100, 200, 300, 400 }", ll.toString());

		assertEquals(400, ll.valueNFromEnd(0));
		assertEquals("null", ll.valueNFromEnd(-1) + "");

		assertEquals("null", ll.valueNFromEnd(100) + "");

		assertEquals(100, ll.valueNFromEnd(3));
		assertEquals(200, ll.valueNFromEnd(2));

		ll.reverse();

		assertEquals("LinkedList [4] { 400, 300, 200, 100 }", ll.toString());
		assertEquals(4, ll.size());
		assertEquals(400, ll.front());
		assertEquals(100, ll.back());

		assertEquals(0, ll.removeValue(400));

		assertEquals("LinkedList [3] { 300, 200, 100 }", ll.toString());

		ll.pushFront(100);

		assertEquals("LinkedList [4] { 100, 300, 200, 100 }", ll.toString());

		assertEquals(0, ll.removeValue(100));

		assertEquals("LinkedList [3] { 300, 200, 100 }", ll.toString());

		assertEquals(2, ll.removeValue(100));

		ll.pushFront(400);

		assertEquals("LinkedList [3] { 400, 300, 200 }", ll.toString());

		assertEquals(1, ll.removeValue(300));

		assertEquals(2, ll.size());
		assertEquals(400, ll.front());
		assertEquals(200, ll.back());

		assertEquals(0, ll.removeValue(400));

		assertEquals(1, ll.size());
		assertEquals(200, ll.front());
		assertEquals(200, ll.back());

		assertEquals(0, ll.removeValue(200));
		assertEquals(0, ll.size());
		assertEquals(null + "", ll.front() + "");
		assertEquals(null + "", ll.back() + "");

	}

	private static void driveVector() {

		try {
			
			Vector<Integer> vector = new Vector();

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