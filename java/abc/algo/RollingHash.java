package abc.algo;

import java.lang.Math;

public interface RollingHash {

	long hash();
	void append(char c);
	boolean skip(char c);

	class DivisionRollingHash implements RollingHash {

		private static final int BASE = 128;

		private long encodedString = 0;
		private int length = 0;

		private long m;

		public DivisionRollingHash(long m) {
			this.m = m;
		}

		@Override
		public long hash() {
			return encodedString % m;
		}

		@Override
		public void append(char c) {
			encodedString = encodedString * BASE + ((int) c);
			length++;
		}

		private long convertToDecimal(long baseNumber) {
			return ((long) Math.pow(BASE, length)) * baseNumber;
		}

		@Override
		public boolean skip(char c) {
			
			if (length == 0) {
				return false;
			}

			encodedString = encodedString - ((int) c) * ((long) Math.pow(BASE, length - 1));
			length--;

			return true;
		}
	}
}