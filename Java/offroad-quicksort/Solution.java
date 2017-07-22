//Refs: https://www.hackerrank.com/challenges/ctci-balanced-brackets

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
	int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

	array = quicksort(array);

	for (int i = 0; i < n; i++) {
        	System.out.println(array[i]+" ");
	}
    }

    private int[] quicksort(int[] array) {
	return quicksort(array, 0, array.length-1);
    }

    private int[] quicksort(int[] array, int left, int right) {
	int pivot = (right-left)/2;
	if (left >= right) return array;


    }
}
