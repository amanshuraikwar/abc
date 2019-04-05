package abc.algo;

import abc.util.Comparator;

public interface Sort<T> {

    T[] sort(T[] items);

    // Time complexity: Best = O(N) 
    //                  Avg = O(N^2)
    //                  Worst = O(N^2)
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
                
                boolean valSwapped = false;

                for (int j = 0, k = 1; j < i; j++, k++) {
                    
                    int comparedVal = comparator.compare(items[k], items[j]);

                    if (comparedVal < 0) {
                        T temp = items[k];
                        items[k] = items[j];
                        items[j] = temp;

                        valSwapped = true;
                    }
                }

                if (!valSwapped) {
                    break;
                }
            }

            return items;
        }
    }

    // Time complexity: Best = O(N)
    //                  Worst = O(N^2)
    // Space complexity: O(1)
    // In place: yes
    // Stable: yes 
    // Online: yes
    // Extra: Binary insertion sort is a modified version of insertion sort.
    //        Where the appropriate element for swapping is search using binary search.
    //        Decreasing the search time from O(i) to O(log(i)).
    //        Although the worst case running time is still O(n).
    //        Because of the swaps taken to insert element at the searched position.
    class InsertionSort<T> extends SortImpl<T> {

        public InsertionSort(Comparator<T> comparator)  {
            super(comparator);
        }

        public T[] sort(T[] items) {

            for (int i = 1; i < items.length; i++) {

                for (int j = i; j > 0; j--) {

                    int comparedVal = comparator.compare(items[j], items[j-1]);

                    if (comparedVal < 0) {
                        T temp = items[j];
                        items[j] = items[j-1];
                        items[j-1] = temp;
                    } else {
                        break;
                    }
                }
            }

            return items;
        }
    }
}