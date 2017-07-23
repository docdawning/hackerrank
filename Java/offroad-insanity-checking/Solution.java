//Refs: https://www.youtube.com/watch?v=eRfvgSvf-mM 

// After quite a few years writing Java, I somehow have managed to write quite a lot of stuff that
// works great, but I never actually knew for the most part a method can alter values in a variable
// such that it need not be passed back. I guess it's better to "get it" late, than never at all. :)
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class StringWrapper {
	String value;
	
	public StringWrapper(String value) {
		this.value = value;
	}
    }

    public static void main(String[] args) {
	int[] array = {4, 5, 1, 5, 7, 8, 5, 64};
	
	printArray("Before: ", array);

	seriouslyWtf(array);

	printArray("After: ", array);

	int aLiteral = 5;
	System.out.println("aLiteral is: "+aLiteral);
	shouldWorkLikeIExpect(aLiteral);
	System.out.println("aLiteral is: "+aLiteral);

	StringWrapper wrapper = new StringWrapper("Original String");
	System.out.println("wrapper has: "+wrapper.value);
	alterWrapper(wrapper);
	System.out.println("wrapper has: "+wrapper.value);
    	alterWrapper2(wrapper);
 	System.out.println("wrapper has: "+wrapper.value);
    }

    private static void alterWrapper2(StringWrapper aWrapper) {
	//This isn't seen because 'aWrapper' is pointing to an object, and here we assign it a new object.
	aWrapper = new StringWrapper("I expect this not to be seen");
    }

    private static void alterWrapper(StringWrapper aWrapper) {
	aWrapper.value = "Not the original string at all, brah";
    }

    private static void shouldWorkLikeIExpect(int someLiteral) {
	someLiteral = 6;
    }

    private static void printArray(String message, int[] array) {
	System.out.print(message);
	for (int i=0;i<array.length;i++) {
		System.out.print(array[i]+" ");
	}
	System.out.println("");
    }

    private static void seriouslyWtf(int[] array) {
	for (int i=0;i<array.length;i++) {
		array[i]=-42;
	}
    }

}
