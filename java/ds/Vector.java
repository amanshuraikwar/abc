package ds;

import java.lang.reflect.ParameterizedType;

public class Vector<DataType> {
	
	private static final int EXPAND_FACTOR = 2;
	private static final int SHRINK_FACTOR = 2;

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

	public void add(int atIndex, DataType val) throws Exception {

		if (atIndex > size || atIndex < 0) {
			throw new Exception("Array Index Out of Bounds.");
		}

		if (size == limit) {
			expandByFactor(EXPAND_FACTOR);
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

		limit = limit * byFactor;
	}

	private void shrinkByFactor(int byFactor) {
		
		DataType[] newItemList = (DataType[]) new Object[limit / byFactor];

		for (int i = 0; i < size; i++) {
			newItemList[i] = itemList[i];
		}

		itemList = newItemList;

		limit = limit / byFactor;
	}

	private void shiftRightBy(int fromIndex, int by) throws Exception {

		if (fromIndex > size || fromIndex < 0 || (size + by) > limit) {
			throw new Exception("Array Index Out of Bounds.");
		}

		for (int i = size - 1; i >= fromIndex; i--) {
			itemList[i + by] = itemList[i];
		}
	}

	public void delete(int atIndex) throws Exception {

		if (atIndex < 0 || atIndex >= size) {
			throw new Exception("Array Index Out of Bounds.");
		}

		if (atIndex != (size - 1)) {
			shiftLeftBy(atIndex + 1, 1);
		}

		size--;

		if (size >= 2) {
			if ((limit / size) >= SHRINK_FACTOR) {
				shrinkByFactor(SHRINK_FACTOR);
			}	
		}
	}

	private void shiftLeftBy(int fromIndex, int by) throws Exception {

		if (fromIndex >= size || fromIndex < 0 || (fromIndex - by) < 0) {
			throw new Exception("Array Index Out of Bounds.");
		}

		for (int i = fromIndex; i < size; i++) {
			itemList[i - by] = itemList[i];
		}
	}

	public DataType get(int index) throws Exception {

		if (index < 0 || index >= size) {
			throw new Exception("Array Index Out of Bounds.");
		}

		return itemList[index];
	}

	public void set(int atIndex, DataType val) throws Exception {

		if (atIndex < 0 || atIndex >= size) {
			throw new Exception("Array Index Out of Bounds.");
		}

		itemList[atIndex] = val;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void prepend(DataType val) throws Exception {
		
		if (size == limit) {
			expandByFactor(EXPAND_FACTOR);
		}

		shiftRightBy(0, 1);

		size++;
		
		itemList[0] = val;
	}

	public DataType pop() throws Exception {
		
		if (size == 0) {
			throw new Exception("Array Index Out of Bounds.");
		}

		DataType lastVal = itemList[size - 1];

		size--;

		if (size >= 2) {
			
			if (limit / size >= SHRINK_FACTOR) {
				shrinkByFactor(SHRINK_FACTOR);
			}
		}

		return lastVal;
	}

	public int find(DataType val) {

		for (int i = 0; i < size ; i++) {
			
			if (itemList[i] == val) {
				return i;
			}
		}

		return -1;
	}

	int limit() {
		return limit;
	}

	@Override
	public String toString() {

		// there will always be a zero'th item in the itemList
		StringBuilder sb = new StringBuilder(itemList[0].getClass().getName() + " [" + size + "] { ");
		
		for (int i = 0; i < size; i++) {
			
			sb.append(itemList[i]);

			if (i != (size - 1)) {
				sb.append(",");
			}

			sb.append(" ");
		}
		sb.append("}");
		return sb.toString();
	}
}