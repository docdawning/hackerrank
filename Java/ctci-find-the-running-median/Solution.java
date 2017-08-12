//Refs: https://www.hackerrank.com/challenges/ctci-find-the-running-median

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.Integer;
import java.util.ArrayList;

public class Solution {
	ArrayList<Integer> minHeap;
	ArrayList<Integer> maxHeap;

	public static void main(String[] args) {
		Solution solution = new Solution(System.in);
		solution.begin();
	}

	private int getParentIndex(int index) { return ((index-2)/2); }
	private int getLeftChildIndex(int index) { return ((index*2)+1); }
	private int getRightChildIndex(int index) { return ((index*2)+2); }

	private void begin() {
		minHeap = new ArrayList<Integer>();
		maxHeap = new ArrayList<Integer>();

	        Scanner in = new Scanner(System.in);
        	int n = in.nextInt();
	        int[] a = new int[n];
        	for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = in.nextInt();
        	}
	}
    }
}

