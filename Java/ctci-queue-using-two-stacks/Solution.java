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
    }
    
    public class MyQueue<T> {
	boolean inputMode; //if in inputMode, then elements are in inputStack
        Stack<T> inputStack;
        Stack<T> outputStack;
        
        public MyQueue() {
	    inputMode = true;
            inputStack = new Stack<T>();
            outputStack = new Stack<T>();
        }
        
        public void enqueue(int value) {
	    if (!inputMode) switchModes();
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
	    if (inputMode) switchModes();

	    Object nextOut = null;
	    if (outputStack.head != null) nextOut = outputStack.head.value;	

	    if (dequeueRequested) outputStack.pop();

	    return nextOut;
        }
      
        private void switchModes() {
		if (inputMode) {
			//swap elements in to outputStack
			Node someNode = inputStack.pop();
			while (someNode != null) { 
				outputStack.push(someNode);
				someNode = inputStack.pop();
			}
			inputMode = false;
		} else {
			//swap elements in to inputStack
			Node someNode = outputStack.pop();
			while (someNode != null) {
				inputStack.push(someNode);
				someNode = outputStack.pop();
			}
			inputMode = true;
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
