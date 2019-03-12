package abc.algo;

public interface AbsoluteInteger {

	public int abs(int number);

	public class TwosCompliment implements AbsoluteInteger {

		@Override
		public int abs(int number) {
			
			if (number > 0) {
				return number;
			}

			return ~(number - 1);
		}
	}

	public class TwosComplimentLess implements AbsoluteInteger {

		@Override
		public int abs(int number) {
			
			// for 32 bit int

			// this will result in -1 (111...1) if number is negative
			// else in 0 (000...0) if number is positive
			int bit31 = number >> 31;

			// number ^ bit31 is essentially ~number if bit31 is -1 (111...1)
			// else number ^ bit31 is number if bit31 is 0 (000...0)

			// as 2sC(2sC(num)) = num
			
			// bit31 is -1 if number is negative so -(-1) is adding to the compliment of the number
			// giving poositive form of the same number
			
			// bit31 is 0 if number is positive
			// thus subtracting 0 from the number which leaves the number unchanged

			return (number ^ bit31) - bit31;

		}
	}
}