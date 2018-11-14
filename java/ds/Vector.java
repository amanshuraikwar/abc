package ds;

import java.lang.reflect.ParameterizedType;

public class Vector<DataType> {
	
	private DataType[] itemList;

	private int size, limit;

	public Vector() {
		itemList = (DataType[]) new Object[2];
		size = 0;
		limit = 2;
	}

	public void add(DataType val) {
		
		if (size == limit) {
			expandByFactor(2);
		}

		itemList[size] = val;
		size++;
	}

	public void add(DataType val, int atIndex) throws Exception {

		if (atIndex > size || atIndex < 0) {
			throw new Exception("Array Index Out of Bounds.");
		}

		if (size == limit) {
			expandByFactor(2);
		}

		if (atIndex < size) {
			shiftRightBy(atIndex, 1);
		}

		itemList[atIndex] = val;
		size++;
	}

	private void expandByFactor(int byFactor) {
		
		DataType[] newItemList = (DataType[]) new Object[limit * byFactor];

		for (int i = 0; i < size; i++) {
			newItemList[i] = itemList[i];
		}

		itemList = newItemList;
	}

	private void shiftRightBy(int fromIndex, int by) throws Exception {

		if (fromIndex > (size - 1) || fromIndex < 0 || (size + by) > limit) {
			throw new Exception("Array Index Out of Bounds.");
		}

		for (int i = size - 1; i >= fromIndex; i--) {
			itemList[i + by] = itemList[i];
		}
	}

	public void delete(int atIndex) throws Exception {

		if (atIndex < 0 || atIndex > (size - 1)) {
			throw new Exception("Array Index Out of Bounds.");
		}

		if (atIndex != (size - 1)) {
			shiftLeftBy(atIndex + 1, 1);
		}

		size--;
	}

	private void shiftLeftBy(int fromIndex, int by) throws Exception {

		if (fromIndex > (size - 1) || fromIndex < 0 || (fromIndex - by) < 0) {
			throw new Exception("Array Index Out of Bounds.");
		}

		for (int i = fromIndex; i < size; i++) {
			itemList[i - by] = itemList[i];
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(itemList[0].getClass().getName() + " [" + size + "] {");
		for (int i = 0; i < size; i++) {
			
			sb.append(" " + itemList[i]);

			if (i != (size - 1)) {
				sb.append(",");
			}

			sb.append(" ");
		}
		sb.append("}");
		return sb.toString();
	}
}