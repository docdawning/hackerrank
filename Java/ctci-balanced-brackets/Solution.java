//Refs: https://www.hackerrank.com/challenges/ctci-balanced-brackets

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static class Stack {
        int size;
        Node top;
        
        public Stack() {
            size = 0;
            top = null;
        }
        
        public boolean isEmpty() {
            if (top == null) return true;
            return false;
        }
        
        public void push(Node node) {
            size++;
            node.next = top;
            top = node;
        }
        
        public Node pop() {
            size--;
            Node node = top;
	    if (top != null) top = top.next;
            return node;
        }
    }
    
    public static class Node {
        Node next;
        String value;
        
        public Node(String value) {
            this.value = value;
        }
    }
    
    public static boolean isOpeningBracket(String bracket) {
        if (bracket.equals("{") || bracket.equals("[") || bracket.equals("(")) return true;
        return false;
    }
    
    public static boolean isBalanced(String expression) {
        Stack stack = new Stack();
        for (int i=0;i<expression.length();i++) {
            String bracket = expression.substring(i, i+1);
            if (isOpeningBracket(bracket)) {
                Node node = new Node(bracket);
                stack.push(node);
            } else {
                //Then it's a closing bracket. If it doesn't pair with the top of the stack, fail
                Node top = stack.pop();
		if (top == null) return false;
                if (!((top.value.equals("[") && bracket.equals("]")) || (top.value.equals("{") && bracket.equals("}")) || (top.value.equals("(") && bracket.equals(")")))) return false;
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}

