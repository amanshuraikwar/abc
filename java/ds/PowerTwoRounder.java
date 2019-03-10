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

    // we are essentially taking the leftmost set bit 
    // and propagating that bit (1) to all the left bits
    class ShiftPowerTwoRounder implements PowerTwoRounder {

        @Override
        public int round(int number) {

            if (number < 0) {
                return -1;
            }

            if (number == 0) {
                return 1;
            }

            // subtract 1 to handle edge case of number being already a power of two
            number -= 1;
            number |= number >>> 1;
            number |= number >>> 2;
            number |= number >>> 4;
            number |= number >>> 8;
            number |= number >>> 16;
            number += 1;

            return number;

        }
    }
}