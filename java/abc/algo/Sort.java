package abc.algo;

import abc.util.Comparator;

public interface Sort<T> {

    T[] sort(T[] items);

    // Time complexity: Best = O(N); Avg = O(N^2); Worst = O(N^2)
    // Space complexity: O(1)
    // In place: yes
    // Stable: yes
    abstract class SortImpl<T> implements Sort<T> {

        protected Comparator<T> comparator;

        public SortImpl(Comparator<T> comparator) {
            this.comparator = comparator;
        }
    }

    class BubbleSort<T> extends SortImpl<T> {

        public BubbleSort(Comparator<T> comparator) {
            super(comparator);
        }

        public T[] sort(T[] items) {

            for (int i = items.length - 1; i > 0; i--) {
                
                for (int j = 0, k = 1; j < i; j++, k++) {
                    
                    int comparedVal = comparator.compare(items[k], items[j]);

                    if (comparedVal < 0) {
                        T temp = items[k];
                        items[k] = items[j];
                        items[j] = temp;
                    }
                }
            }

            return items;
        }
    }
}