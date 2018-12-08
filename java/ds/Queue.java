package ds;

public interface Queue<T> {

	void push(T value);
	T pop();
	T peek();
	int size();
	boolean empty();

	class LinkedQueue<T> implements Queue<T> {

		Node<T> head;
		Node<T> tail;
		int size = 0;

		public void push(T value) {

			Node<T> newNode = new Node<>(value);

			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = newNode;
			}

			size++;

		}

		public T pop() {

			if (head == null) {
				return null;
			}

			T value = head.value;

			head = head.next;

			if (head == null) {
				tail = null;
			}

			size--;

			return value;

		}

		public T peek() {

			if (head == null) {
				return null;
			}

			return head.value;

		}

		public int size() {
			return size;
		}

		public boolean empty() {
			return size == 0;
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