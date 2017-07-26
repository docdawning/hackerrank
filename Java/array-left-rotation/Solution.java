//Refs: https://www.hackerrank.com/challenges/array-left-rotation

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveIt();
    }
    
    private void solveIt() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int leftShifts = in.nextInt();
        in.nextLine(); //gets us on to the next line
        
        int[] array = new int[n];
        
        for (int i=0;i<n;i++) {
            array[(i+n-leftShifts)%n] = in.nextInt();
        }
        
        for (int i=0;i<n;i++) {
            System.out.print(array[i]+" ");
        }
    }
}
