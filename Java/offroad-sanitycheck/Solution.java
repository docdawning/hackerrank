import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	static class JInt {
		public int value;

		public JInt(int value) {
			this.value = value;
		}
	}

	public static void main(String[] args) {
		JInt myInt = new JInt(4);

		System.out.println("Initially: "+myInt.value);

		incrementInteger(myInt);

		System.out.println("Finally: "+myInt.value);
	}

	private static void incrementInteger(JInt someInt) {
		someInt.value = someInt.value + 1;
	}
}
