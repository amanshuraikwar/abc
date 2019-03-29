package abc.ds;

import java.util.List;
import java.util.ArrayList;

import abc.util.Comparator;

public interface Heap<T> {

    T peek();
    T pop();
    boolean push(T val);

    abstract class HeapImpl<T> implements Heap<T> {

        List<T> items;

        public HeapImpl() {
            items = new ArrayList<>();
        }

        public T peek() {
            return items.size() > 0 ? items.get(0) : null;
        }

        public T pop() {
            
            if (items.isEmpty()) {
                return null;
            }

            T poppedValue = items.get(0);

            swap(1, items.size());
            items.remove(items.size() - 1);

            if (items.isEmpty() || isLeaf(1)) {
                return poppedValue;
            }

            int curIndex = 1;

            while (!isLeaf(curIndex)) {
                
                // System.out.println("POP:" + toString() + " Cur index: " + curIndex);

                int worstChild = getWorstChildIndex(curIndex);
                
                if (worstChild == -1) {
                    break;
                }

                swap(curIndex, worstChild);

                curIndex = worstChild;
            }

            return poppedValue;
        }

        public int getWorstChildIndex(int index) {
            
            if (isLeaf(index)) {
                return -1;
            }

            if (hasSingleChild(index)) {
                
                int leftChild = leftChild(index);
                
                if (heapProperty(index, leftChild)) {
                    return -1;
                } else {
                    return leftChild;
                }

            } else {
                
                int leftChild = leftChild(index);
                int rightChild = rightChild(index);

                boolean left = heapProperty(index, leftChild);
                boolean right = heapProperty(index, rightChild);

                // System.out.println("POP:LEFT="+left+"RIGHT="+right);

                if (!left && !right) {

                    if (heapProperty(leftChild, rightChild)) {

                        // System.out.println("POP:LEFT");

                        return leftChild;
                    } else {

                        // System.out.println("POP:RIGHT");

                        return rightChild;
                    }

                } else if (!left) {
                    return leftChild;
                } else if (!right) {
                    return rightChild;
                } else {
                    return -1;
                }
            }
        }

        // Time = O(log(N))
        // Space = O(1)
        public boolean push(T val) {
            
            items.add(val);
            int curIndex = items.size();
            
            while(curIndex > 1) {
                
                int parentIndex = parent(curIndex);

                if (heapProperty(parentIndex, curIndex)) {
                    break;
                }

                swap(parentIndex, curIndex);
                curIndex = parentIndex;
            }

            return true;
        }

        private void swap(int index1, int index2) {
            T temp = items.get(index1 - 1);
            items.set(index1 - 1, items.get(index2 - 1));
            items.set(index2 - 1, temp);
        }

        private boolean heapProperty(int parent, int child) {
            return heapPropertyAct(items.get(parent - 1), items.get(child - 1));
        }

        protected abstract boolean heapPropertyAct(T parent, T child);

        private int parent(int index) {
            return index/2;
        }

        private int leftChild(int index) {
            return ((2*index) <= items.size()) ? (2*index) : -1;
        }

        private int rightChild(int index) {
            return ((2*index + 1) <= items.size()) ? (2*index + 1) : -1;
        }

        private boolean isLeaf(int index) {
            return (2*index) > items.size();
        }

        private boolean hasSingleChild(int index) {
            return (2*index + 1) > items.size();
        }

        @Override
        public String toString() {
            return items.toString();
        }
    }

    class MaxHeap<T> extends HeapImpl<T> {

        private Comparator<T> comparator;

        public MaxHeap(Comparator<T> comparator) {
            super();
            this.comparator = comparator;
        }

        @Override
        protected boolean heapPropertyAct(T parent, T child) {
            return comparator.compare(parent, child) >= 0;
        }
    }

    // untested - left for the reader - if there is any
    class MinHeap<T> extends HeapImpl<T> {

        private Comparator<T> comparator;

        public MinHeap(Comparator<T> comparator) {
            super();
            this.comparator = comparator;
        }

        @Override
        protected boolean heapPropertyAct(T parent, T child) {
            return comparator.compare(parent, child) <= 0;
        }
    }
}