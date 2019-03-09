package ds;

public interface BitsCounter {

    public int countSetBits(int number);
    public int countUnsetBits(int number);

    class SimpleBitsCounter implements BitsCounter {

        @Override
        public int countSetBits(int number) {
            int count = 0;
            while((number|0) != 0) {
                count += number&1;
                number = number>>>1;
            }
            return count;
        }

        @Override
        public int countUnsetBits(int number) {
            return countSetBits(~number);
        }
    }
}