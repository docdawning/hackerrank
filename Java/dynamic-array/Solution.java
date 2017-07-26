//Refs: https://www.hackerrank.com/challenges/dynamic-array

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        try {
            Solution solution = new Solution();
            solution.doIt();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void doIt() throws Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int lastAnswer = 0;
        ArrayList<ArrayList<Integer>> seqList = new ArrayList<ArrayList<Integer>>();
        for (int i=0;i<n;i++) seqList.add(new ArrayList<Integer>());
        
        for (int i=0;i<q;i++) {
            in.nextLine(); //gets us past the line return
            int queryCode = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            
            int index = (x ^ lastAnswer) % n;
            
            if (queryCode == 1) {
                (seqList.get(index)).add(y);
            }
            
            if (queryCode == 2) {
                int size = (seqList.get(index)).size();
                lastAnswer = (seqList.get(index)).get(y % size);
                System.out.println(lastAnswer);
            }
            
            if (queryCode < 1 || queryCode > 2) {
                throw new Exception("Invalid Query Code given: "+queryCode);
            }
        }
    }

}
