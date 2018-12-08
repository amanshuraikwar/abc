package ds;

import static ds.L.*;

public class LinkedList<DataType> {

	private Node<DataType> first;
	private Node<DataType> last;

	private int size = 0;



	public int size() {
		return size;
	}

	public boolean empty() {
		return size == 0;
	}

	public DataType valueAt(int index) throws Exception {
		
		if (index >= size || index < 0) {
			throw new Exception("Index out of bounds.");
		}

		Node<DataType> curNode = traverseFromFrontTo(index);

		return curNode.item;
	}

	public void pushFront(DataType value) {

		Node<DataType> newNode = new Node<>();
		newNode.item = value;
		newNode.next = first;
		first = newNode;

		if (size == 0) {	
			last = first;
		}

		size++;
	}

	public DataType popFront() {

		if (size == 0) {
			return null;
		}

		DataType value = first.item;

		first = first.next;
		size--;

		if (size == 0) {
			last = null;
		}

		return value;
	}

	public void pushBack(DataType value) {

		Node<DataType> newNode = new Node<>();
		newNode.item = value;

		if (size == 0) {
			first = newNode;
		} else {
			last.next = newNode;
		}

		size++;
		last = newNode;
	}

	public DataType popBack() {

		if (size == 0) {
			return null;
		}

		DataType val = null;
		val = last.item;

		if (size == 1) {
			first = null;
			last = null;
		} else {
			Node<DataType> newLastNode = traverseFromFrontTo(size - 2);
			newLastNode.next = null;
			last = newLastNode;
		}

		size--;

		return val;
	}

	public DataType front() {

		if (size == 0) {
			return null;
		}

		return first.item;
	}

	public DataType back() {

		if (size == 0) {
			return null;
		}

		return last.item;
	}

	public boolean insert(int index, DataType value) {

		if (index > size || index < 0) {
			return false;
		}

		Node<DataType> newNode = new Node<>();
		newNode.item = value;

		if (index == 0) {
			newNode.next = first;
			first = newNode;
		} else {
			Node<DataType> displacedNode = traverseFromFrontTo(index - 1);
			newNode.next = displacedNode.next;
			displacedNode.next = newNode;
		}

		if (index == size) {
			last = newNode;
		}

		size++;

		return true;
	}

	public DataType erase(int index) {

		if (index >= size || index < 0) {
			return null;
		}

		DataType value = null;

		if (index == 0) {

			value = first.item;
			first = first.next;

		} else {
			
			Node<DataType> displacedNode = traverseFromFrontTo(index - 1);

			value = displacedNode.next.item;

			displacedNode.next = displacedNode.next.next;

			if (index == size - 1) {
				last = displacedNode;
			}

		}

		size--;

		return value;
	}

	public DataType valueNFromEnd(int n) {
		
		int index = size - n - 1;
		
		if (index < 0 || index >= size) {
			return null;
		}

		return traverseFromFrontTo(index).item;
	}

	public void reverse() {

		Node<DataType> curNode = first;
		Node<DataType> previousNode = null;

		while(curNode != null) {
			Node<DataType> nextNode = curNode.next;
			curNode.next = previousNode;
			previousNode = curNode;
			curNode = nextNode;
		}

		curNode = first;
		first = last;
		last = curNode;
	}

	public int removeValue(DataType value) {

		Node<DataType> curNode = first;
		
		int index = 0;
		
		while(curNode != null) {

			if ((curNode.item+"").equals(value+"")) {
				erase(index);
				return index;
			}

			index++;

			curNode = curNode.next;
		}

		return -1;
	}

	@Override
	public String toString() {

		// there will always be a zero'th item in the itemList
		StringBuilder sb = new StringBuilder("LinkedList" + " [" + size + "] { ");
		
		Node<DataType> curNode = first;

		while (curNode != null) {
			
			sb.append(curNode.item);

			if (curNode.next != null) {
				sb.append(",");
			}

			sb.append(" ");

			curNode = curNode.next;
		}

		sb.append("}");
		return sb.toString();
	}

	private Node<DataType> traverseFromFrontTo(int index) {
		
		Node<DataType> curNode = first;

		for (int i = 0; i < index; i++) {
			curNode = curNode.next;
		}

		return curNode;
	}

	private class Node<DataType> {
		private DataType item;
		private Node<DataType> next;
		public String toString() {
			return "{" + item + ":" + next + "}";
		}
	}
}