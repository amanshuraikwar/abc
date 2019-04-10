package abc.algo;

import abc.util.Comparator;
import java.util.Arrays;

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

    // Time complexity: All = O(N*Log(N))
    // Space complexity: O(N)
    // In place: yes
    // Stable: yes 
    class MergeSort<T> extends SortImpl<T> {

        public MergeSort(Comparator<T> comparator) {
            super(comparator);
        }

        public T[] sort(T[] items) {
            sort(items, 0, items.length - 1);
            return items;
        }

        private void sort(T[] items, int l, int r) {

            if (l < r) {

                int m = (l + r) / 2;

                sort(items, l, m);
                sort(items, m + 1, r);
                merge(items, l, m, r);
            }
        }

        private void merge(T[] items, int l, int m, int r) {

            T[] newItems = (T[])new Object[r - l + 1];
            
            int i = l;
            int j = m + 1;
            int k = 0;

            while (i <= m || j <= r) {
                
                if (i > m) {
                    newItems[k] = items[j];
                    k++; j++;
                } else if (j > r) {
                    newItems[k] = items[i];
                    k++; i++;
                } else if (comparator.compare(items[j], items[i]) >= 0) {
                    newItems[k] = items[i];
                    k++; i++;
                } else {
                    newItems[k] = items[j];
                    k++; j++;
                }
            }

            i = l;
            k = 0;
            
            while (i <= r) {
                items[i] = newItems[k];
                i++;
                k++;
            }
        }
    }
}