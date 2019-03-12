package abc.ds;

public interface Stack<T> {

	void push(T value);
	T pop();
	T peek();
	int size();
	boolean empty();

	class LinkedStack<T> implements Stack<T> {

		Node<T> top;
		int size = 0;

		public void push(T value) {

			Node<T> newNode = new Node<>(value);

			if (top == null) {
				top = newNode;
			} else {
				newNode.next = top;
				top = newNode;
			}

			size++;

		}

		public T pop() {

			if (top == null) {
				return null;
			}

			T value = top.value;
			top = top.next;

			size--;

			return value;

		}

		public T peek() {

			if (top == null) {
				return null;
			}

			return top.value;

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