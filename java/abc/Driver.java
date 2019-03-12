package abc;

import static abc.util.UTest.*;
import abc.ds.*;
import abc.algo.*;

public class Driver {
	
	private static int testCaseCount = 0;

	public static void main(String[] args) {
		
		driveQueue();
		driveStack();
		driveLinkedList();
		driveVector();
		driveCircularBuffer();
		driveRollingHash();
		driveKarpRabin();
		driveBitwise();
		driveByte();
		driveBitsCounter();
		drivePowerTwoRounder();
		driveSwap();
		driveAbsolute();
		driveTreeTraversals();
		driveBfs();
		driveDfs();
		driveBinarySearch();
	}

	private static void driveBinarySearch() {

		setTestContext("BinarySearch");

		Integer[] sortedInput = new Integer[]{-67, -34, -12, 0, 1, 56, 87, 198, 235};
		BinarySearch.Comparator<Integer> comparator = new BinarySearch.Comparator<Integer>() {
			@Override
			public int compare(Integer expectedBig, Integer expectedSmall) {
				return expectedBig - expectedSmall;
			}
		};

		assertEquals(1, comparator.compare(-1, -2));
		assertEquals(4, comparator.compare(34, 30));
		assertEquals(0, comparator.compare(0, 0));
		assertEquals(-4, comparator.compare(-34, -30));
		assertEquals(-4, comparator.compare(30, 34));

		BinarySearch bs = new BinarySearch.IterativeBinarySearch();
		assertEquals(4, bs.search(1, sortedInput, comparator));
		assertEquals(1, bs.search(-34, sortedInput, comparator));
		assertEquals(0, bs.search(-67, sortedInput, comparator));
		assertEquals(2, bs.search(-12, sortedInput, comparator));
		assertEquals(3, bs.search(0, sortedInput, comparator));
		assertEquals(5, bs.search(56, sortedInput, comparator));
		assertEquals(6, bs.search(87, sortedInput, comparator));
		assertEquals(7, bs.search(198, sortedInput, comparator));
		assertEquals(8, bs.search(235, sortedInput, comparator));

		bs = new BinarySearch.RecursiveBinarySearch();
		assertEquals(4, bs.search(1, sortedInput, comparator));
		assertEquals(1, bs.search(-34, sortedInput, comparator));
		assertEquals(0, bs.search(-67, sortedInput, comparator));
		assertEquals(2, bs.search(-12, sortedInput, comparator));
		assertEquals(3, bs.search(0, sortedInput, comparator));
		assertEquals(5, bs.search(56, sortedInput, comparator));
		assertEquals(6, bs.search(87, sortedInput, comparator));
		assertEquals(7, bs.search(198, sortedInput, comparator));
		assertEquals(8, bs.search(235, sortedInput, comparator));
	}

	private static void driveDfs() {

		setTestContext("Dfs");

		Tree.Node<Integer> root = new Tree.Node<>(1);
		Tree.Node<Integer> child1 = new Tree.Node<>(2);
		Tree.Node<Integer> child2 = new Tree.Node<>(3);

		root.addChild(child1);
		root.addChild(child2);

		child1.addChild(new Tree.Node<>(4));

		child2 = new Tree.Node<>(5);

		child1.addChild(child2);

		child2.addChild(new Tree.Node<>(6));

		// graph:
		//      1
		//     / \
		//    2  3
		//   / \   
		//  4  5
		//    /
		//   6

		Tree.Searcher searcher = new Tree.SimpleSearcher();
		assertEquals(1, searcher.dfs(root, 1).getVal());
		assertEquals(2, searcher.dfs(root, 2).getVal());
		assertEquals(3, searcher.dfs(root, 3).getVal());
		assertEquals(4, searcher.dfs(root, 4).getVal());
		assertEquals(5, searcher.dfs(root, 5).getVal());
		assertEquals(6, searcher.dfs(root, 6).getVal());
		assertEquals("null", searcher.dfs(root, 0) + "");

		searcher = new Tree.RecursiveSearcher();
		assertEquals(1, searcher.dfs(root, 1).getVal());
		assertEquals(2, searcher.dfs(root, 2).getVal());
		assertEquals(3, searcher.dfs(root, 3).getVal());
		assertEquals(4, searcher.dfs(root, 4).getVal());
		assertEquals(5, searcher.dfs(root, 5).getVal());
		assertEquals(6, searcher.dfs(root, 6).getVal());
		assertEquals("null", searcher.dfs(root, 0) + "");
	}

	private static void driveBfs() {

		setTestContext("Bfs");

		Tree.Node<Integer> root = new Tree.Node<>(1);
		Tree.Node<Integer> child1 = new Tree.Node<>(2);
		Tree.Node<Integer> child2 = new Tree.Node<>(3);

		root.addChild(child1);
		root.addChild(child2);

		child1.addChild(new Tree.Node<>(4));

		child2 = new Tree.Node<>(5);

		child1.addChild(child2);

		child2.addChild(new Tree.Node<>(6));

		// graph:
		//      1
		//     / \
		//    2  3
		//   / \   
		//  4  5
		//    /
		//   6

		Tree.Searcher searcher = new Tree.SimpleSearcher();
		assertEquals(1, searcher.bfs(root, 1).getVal());
		assertEquals(2, searcher.bfs(root, 2).getVal());
		assertEquals(3, searcher.bfs(root, 3).getVal());
		assertEquals(4, searcher.bfs(root, 4).getVal());
		assertEquals(5, searcher.bfs(root, 5).getVal());
		assertEquals(6, searcher.bfs(root, 6).getVal());
		assertEquals("null", searcher.bfs(root, 0) + "");
	}

	private static void driveTreeTraversals() {

		setTestContext("TreeTraversals");

		Tree.Node<Integer> root = new Tree.Node<>(1);
		Tree.Node<Integer> child1 = new Tree.Node<>(2);
		Tree.Node<Integer> child2 = new Tree.Node<>(3);

		root.addChild(child1);
		root.addChild(child2);

		child1.addChild(new Tree.Node<>(4));

		child2 = new Tree.Node<>(5);

		child1.addChild(child2);

		child2.addChild(new Tree.Node<>(6));

		// graph:
		//      1
		//     / \
		//    2  3
		//   / \   
		//  4  5
		//    /
		//   6

		Tree.Traversaler traversaler = new Tree.RecursiveTraversaler();
		assertEquals("[4, 2, 6, 5, 1, 3]", traversaler.inOrder(root).toString());
		assertEquals("[1, 2, 4, 5, 6, 3]", traversaler.preOrder(root).toString());
		assertEquals("[4, 6, 5, 2, 3, 1]", traversaler.postOrder(root).toString());
		assertEquals("[1, 2, 3, 4, 5, 6]", traversaler.levelOrder(root).toString());
	}

	private static void driveAbsolute() {

		setTestContext("Absolute");

		AbsoluteInteger absoluteInteger = new AbsoluteInteger.TwosCompliment();
		
		assertEquals(235534, absoluteInteger.abs(235534));
		assertEquals(235534, absoluteInteger.abs(-235534));

		absoluteInteger = new AbsoluteInteger.TwosComplimentLess();

		assertEquals(235534, absoluteInteger.abs(235534));
		assertEquals(235534, absoluteInteger.abs(-235534));
	}

	private static void driveSwap() {

		setTestContext("Swap");

		int a = 1;
		int b = 2;

		// simple using temp
		int temp = a;
		a = b;
		b = temp;

		assertEquals(2, a);
		assertEquals(1, b);

		a = 1;
		b = 2;

		// using arithematic operations
		// no extra variable
		a = a + b;
		b = a - b;
		a = a - b;

		assertEquals(2, a);
		assertEquals(1, b);

		a = 1;
		b = 2;

		// using bitwise operations
		// no extra variable

		// (a xor b) xor a = b
		// Proof: 
		// 		 (0 xor 0) xor 0 = 0
		// 		 (1 xor 0) xor 1 = 0
		//		 (0 xor 1) xor 0 = 1
		// 		 (1 xor 1) xor 1 = 1

		// b xor (a xor b) = a
		// Proof: 
		// 		 0 xor (0 xor 0) = 0
		// 		 1 xor (0 xor 1) = 0
		//		 0 xor (1 xor 0) = 1
		// 		 1 xor (1 xor 1) = 1

		a ^= b;
		b ^= a;
		a ^= b;

		assertEquals(2, a);
		assertEquals(1, b);
	}

	private static void drivePowerTwoRounder() {
		
		setTestContext("PowerTwoRounder");

		PowerTwoRounder powerTwoRounder = new PowerTwoRounder.SimplePowerTwoRounder();
		
		assertEquals(-1, powerTwoRounder.round(-1));
		assertEquals(1, powerTwoRounder.round(0));
		assertEquals(1, powerTwoRounder.round(1));
		assertEquals(2, powerTwoRounder.round(2));
		assertEquals(4, powerTwoRounder.round(3));
		assertEquals(4, powerTwoRounder.round(4));
		assertEquals(1024, powerTwoRounder.round(1020));
		assertEquals(1024, powerTwoRounder.round(1024));
		assertEquals(1048576, powerTwoRounder.round(1048576));
		assertEquals(1073741824, powerTwoRounder.round(1073741824));
		// -1>>>1 = 011...1 = max signed int = 2147483647, 2147483647/2 = 1073741823.5
		assertEquals(1073741824, powerTwoRounder.round((-1>>>1)/2));


		powerTwoRounder = new PowerTwoRounder.ShiftPowerTwoRounder();
		
		assertEquals(-1, powerTwoRounder.round(-1));
		assertEquals(1, powerTwoRounder.round(0));
		assertEquals(1, powerTwoRounder.round(1));
		assertEquals(2, powerTwoRounder.round(2));
		assertEquals(4, powerTwoRounder.round(3));
		assertEquals(4, powerTwoRounder.round(4));
		assertEquals(1024, powerTwoRounder.round(1020));
		assertEquals(1024, powerTwoRounder.round(1024));
		assertEquals(1048576, powerTwoRounder.round(1048576));
		assertEquals(1073741824, powerTwoRounder.round(1073741824));
		// -1>>>1 = 011...1 = max signed int = 2147483647, 2147483647/2 = 1073741823.5
		assertEquals(1073741824, powerTwoRounder.round((-1>>>1)/2));
	}

	private static void driveBitsCounter() {
		
		setTestContext("BitsCounter");

		BitsCounter bitsCounter = new BitsCounter.SimpleBitsCounter();

		assertEquals(0, bitsCounter.countSetBits(0));
		assertEquals(1, bitsCounter.countSetBits(1));
		assertEquals(1, bitsCounter.countSetBits(2));
		assertEquals(2, bitsCounter.countSetBits(3));
		
		// as of 2's compliment -1 = 111...1
		assertEquals(32, bitsCounter.countSetBits(-1));
		// as of 2's compliment -1 = 111...1, -1>>>1 = 011...1
		assertEquals(31, bitsCounter.countSetBits(-1>>>1));

		assertEquals(32, bitsCounter.countUnsetBits(0));
		assertEquals(31, bitsCounter.countUnsetBits(1));
		assertEquals(31, bitsCounter.countUnsetBits(2));
		assertEquals(30, bitsCounter.countUnsetBits(3));
		
		// as of 2's compliment -1 = 111...1
		assertEquals(0, bitsCounter.countUnsetBits(-1));
		// as of 2's compliment -1 = 111...1, -1>>>1 = 011...1
		assertEquals(1, bitsCounter.countUnsetBits(-1>>>1));

	}

	private static void driveByte() {
		
		setTestContext("Byte");
		
		// <+/->0bXXX...
		// use +0bXXX... for a positive value
		// use -0bXXX... for a negative value
		// this is used for giving binary for a number
		// for example 0b1 = 1, 0b11 = 3, 0b10 = 2 and so on...
		
		// b1 is -0b0000001 = 11111111 = -1
		byte b1 = -0b0000001;
		assertEquals((byte) -1, b1);

		// ~b1 is 00000000 = 0b0000000 = 0
		byte b2 = (byte) ~b1;
		assertEquals(0b0000000, b2);
		
		// proof that java stores the negative numbers as 2's compliment
		// b3 is 01001110 = 78
		// b4 is (~b3 (1's compliment) = 10110001) + (0b1 = 00000001) = (10110010 = -78)
		byte b3 = 0b1001110;
		assertEquals(78, b3);
		byte b4 = (byte) ((byte) ~b3 + (byte) 0b1);
		assertEquals(-78, b4);
		// or by using simple integers
		assertEquals(-78, ~78 + 1);

		// representing max -ve byte using -0bXXX... notation
		byte b5 = -0b10000000;
		byte b6 = 0b1111111; // this is 127
		// b6 is 127 = 01111111, ~b6 = 10000000 = -128 (as of 2's compliment)
		// this proves b5 = -128
		assertEquals(~b6, b5);
	}

	private static  void driveBitwise() {
		
		setTestContext("Bitwise");
		
		// and
		assertEquals(0, 2&1);
		
		// or
		assertEquals(3, 2|1);
		
		// xor
		// if same bits --> 0
		assertEquals(0, 2^2);
		// if different bits --> 1
		assertEquals(3, 2^1);

		// compliment
		// this replaces 1s with 0s and vise versa
		// so, for 1 = 00000...001 --> ~1 = 111111...110 which is -2 as of 2's compliment
		assertEquals(-2, ~1);
		// for 0 = 00000...000 --> ~0 = 111111...111 which is -1 as of 2's compliment
		assertEquals(-1, ~0);

		// left shift
		// shifts bit left leaving zero at original bits 
		assertEquals(4, 2<<1);
		assertEquals(8, 2<<2);
		// multiply the number by 2^x where x is number of shifted bits
		assertEquals(20, 5<<2);

		// right shift
		assertEquals(2, 5>>1);
		// divide the number by 2^x where x is number of shifted bits
		assertEquals(5, 20>>2);

		// zero fill right shift
		// todo
		assertEquals(2, 5>>>1);
		// divide the number by 2^x where x is number of shifted bits
		assertEquals(5, 20>>>2);
		
		// special cases
		// just shift the right-most bit (which is 1) to right so every bit is now 0
		assertEquals(0, 1>>1);
		// >> operator shifts the bits right and replaces with the left-most bit
		// so for -1, the left-most bit is 1 and as of 2's compiment, every other bit is also 1
		// thus -1>>1 will not change anything in the bits
		assertEquals(-1, -1>>30);

		// negative numbers
		// for -2 as of 2's compliment, all the bits will be 1 except the right-most bit
		// shifting one right will just eliminate the zero from right-most bit
		assertEquals(-1, -2>>1);
		// for -1 all the bits are one and >>> will shift right by one bit and will replace the first bit with zero
		// converting that number to a positive according to 2's compliment
		// so -1>>>1 will be 01111111...(depending on system)
		// this will be max positive signed int (32 bit on the system that it's written)
		assertEquals(2147483647, -1>>>1);

		// integer roll through
		// adding 1 to the max positive signed integer gives max negative signed integer
		// because: -1 = 1111111...11 and -1>>>1 = 0111111...11 and (-1>>>1) + 1 = 1000000...00 and MAX_NEGATIVE = 100000...00
		assertEquals(-2147483648, (-1>>>1) + 1);
	}

	private static void driveKarpRabin() {

		setTestContext("KarpRabin");

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

		setTestContext("RollingHash");

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

		setTestContext("CircularBuffer");

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

		setTestContext("Queue");

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

		setTestContext("Stack");

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

		setTestContext("LinkedList");

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

		setTestContext("Vector");

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