package abc.algo;

public interface BinarySearch {

    public <T> int search(T val, T[] items, Comparator<T> comparator);

    interface Comparator<T> {
        public int compare(T expectedBig, T expectedSmall);
    }

    class IterativeBinarySearch implements BinarySearch {
        
        @Override
        public <T> int search(T val, T[] items, Comparator<T> comparator) {

            int left = 0;
            int right = items.length - 1;

            while (left <= right) {
                
                int curIndex = left + (right - left) / 2;
                int comparedOutput = comparator.compare(val, items[curIndex]);
                
                if (comparedOutput == 0) {
                    return curIndex;
                }

                if (comparedOutput < 0) {
                    right = curIndex - 1;
                }

                if (comparedOutput > 0) {
                    left = curIndex + 1;
                }

            }

            return -1;
        }
    }

    class RecursiveBinarySearch implements BinarySearch {

        @Override
        public <T> int search(T val, T[] items, Comparator<T> comparator) {
            return search(val, items, comparator, 0, items.length - 1);
        }

        private <T> int search(T val, T[] items, Comparator<T> comparator, int left, int right) {

            int curIndex = left + (right - left) / 2;
            int comparedValue = comparator.compare(val, items[curIndex]);

            if (left > right) {
                return -1;
            }

            if (comparedValue == 0) {
                return curIndex;
            }

            if (comparedValue < 0) {
                return search(val, items, comparator, left, curIndex - 1);
            }

            if (comparedValue > 0) {
                return search(val, items, comparator, curIndex + 1, right);
            }

            // this statement will never be reached
            // this is just here to satisfy the stupid greedy compiler
            return -1;
        }
    }
}