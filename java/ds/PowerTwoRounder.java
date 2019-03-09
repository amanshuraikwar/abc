package ds;

import java.lang.Math;

public interface PowerTwoRounder {

    public int round(int number);

    class SimplePowerTwoRounder implements PowerTwoRounder {
        
        @Override
        public int round(int number) {
            
            if (number < 0) {
                return -1;
            }

            // if the number itself is a power of 2 return the same
            BitsCounter bitsCounter = new BitsCounter.SimpleBitsCounter();
            if (bitsCounter.countSetBits(number) == 1) {
                return number;
            }

            int power = 0;
            
            while((number|0) != 0) {
                power++;
                number = number>>>1;
            }

            return (int) Math.pow(2, power);
        }
    }
}