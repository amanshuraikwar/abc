package abc.ds;

public interface CircularBuffer<T> {

	boolean push(T value);
	T peek();
	T pop();
	boolean empty();
	int spaceLeft();
	boolean full();

	// if the buffer gets full, it restricts addition of new items
	class LinkedCircularBuffer<T> implements CircularBuffer<T> {

		private static final int DEFAULT_CAPACITY = 8;
		
		private int capacity;
		private Node<T> head;
		private Node<T> tail;

		public LinkedCircularBuffer() {
			this.capacity = DEFAULT_CAPACITY;
			init();
		}

		public LinkedCircularBuffer(int capacity) {
			this.capacity = capacity;
			init();
		}

		// O(N)
		private void init() {

			head = new Node<T>(null);
			tail = head;

			Node<T> curNode = head;

			for (int i = 1; i < capacity; i++) {
				Node<T> newNode = new Node<>(null);
				curNode.next = newNode;
				curNode = newNode;
			}

			curNode.next = head;

		}

		// O(1)
		public boolean push(T value) {

			if (tail.next == head) {
				return false;
			}

			if (tail.value != null) {
				tail = tail.next;
			}
	
			tail.value = value;
			
			return true;

		}

		// O(1)
		public T peek() {
			return head.value;
		}

		// O(1)
		public T pop() {

			if (head.value == null) {
				return null;
			}

			T value = head.value;

			if (head == tail) {
				head.value = null;
			} else {
				head = head.next;
			}

			return value;

		}

		// O(1)
		public boolean empty() {
			return head == tail && tail.value == null;
		}

		// O(N)
		public int spaceLeft() {

			if (tail.value == null) {
				return capacity;
			}

			Node<T> curNode = head;
			
			int i = capacity - 1;

			for(; curNode != tail; i--) {
				curNode = curNode.next;
			}

			return i;

		}

		// O(1)
		public boolean full() {
			return tail.next == head;
		}

		private static class Node<T> {

			private T value;
			private Node<T> next;

			private Node(T value) {
				this.value = value;
			} 
		}
	}
}