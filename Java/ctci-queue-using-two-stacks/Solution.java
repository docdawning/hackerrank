//Refs: https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Node<T> {
        T value;
        Node next;
        
        public Node(T value) {
            this.value = value;
        }
    }
    
    public class Stack<T> {
        Node head;
        
        public Stack() {
            head = null;
        }
        
        public Node pop() {
            Node popped = head;
	    if (head != null) head = head.next;
	    return popped;
        }
         
        public void push(Node aNode) {
	    log("Pushing node with value: "+aNode.value);
	    aNode.next = head;
	    head = aNode;
        }

	public boolean isEmpty() {
	    if (head == null) return true;
	    return false;
	}
    }
    
    public class MyQueue<T> {
        Stack<T> inputStack;
        Stack<T> outputStack;
        
        public MyQueue() {
            inputStack = new Stack<T>();
            outputStack = new Stack<T>();
        }
        
        public void enqueue(int value) {
            Node<Integer> aNewNode = new Node<Integer>(new Integer(value));
            inputStack.push(aNewNode);
        }
        
        public Object dequeue() {
            return peek(true);
        }
        
        public Object peek() {
            return peek(false);
        }
        
        public Object peek(boolean dequeueRequested) {
		if (inputStack.isEmpty() && outputStack.isEmpty()) return null;

		if (outputStack.isEmpty()) loadOutputStack();

		Node someNode = outputStack.head;

		if (dequeueRequested) outputStack.pop();

		if (someNode == null) return null;
		return someNode.value;
        }
      
	//assumes outputStack IS empty
	private void loadOutputStack() {
		Node someNode = inputStack.pop();
		while (someNode != null) {
			outputStack.push(someNode);
			someNode = inputStack.pop();
		}
	}

    }

    public static final boolean DEBUGGING = false; 

    public static void main(String[] args) {
	Solution sol = new Solution();
	sol.execute();
    }

    public void execute() {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    public static void log(String message) {
	    if (DEBUGGING) System.out.println(message);
    }
}
