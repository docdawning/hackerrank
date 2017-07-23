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

	quicksort(array);

	for (int i = 0; i < n; i++) {
        	System.out.println(array[i]+" ");
	}
    }

    private static void quicksort(int[] array) {
	quicksort(array, 0, array.length-1);
    }

    private static void quicksort(int[] array, int left, int right) {
	int pivot = (right+left)/2;
	int pivotValue = array[pivot];

	if (left >= right) return;

	int i = left;
	int j = right;

	while (i<=j) {
		while (array[i]<pivotValue) {
			i++;
		}
		while (array[j]>pivotValue) {
			j--;
		}

		if (i <= j) {
			int temp = array[j];
			array[j] = array[i];
			array[i] = temp;
			i++;
			j--;
		}
	}

	quicksort(array, left, j);
	quicksort(array, i, right);
    }
}
